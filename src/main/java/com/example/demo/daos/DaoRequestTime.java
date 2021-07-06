package com.example.demo.daos;

import com.example.demo.entities.CakeLimit;
import com.example.demo.entities.RequestTime;
import com.example.demo.exceptions.LimitPassedException;
import com.example.demo.exceptions.WasNotFoundException;
import com.example.demo.models.Response;
import com.example.demo.models.ResponsePagination;
import com.example.demo.repos.RepoCakeLimits;
import com.example.demo.repos.RepoRequestTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DaoRequestTime {

    public String toSqlNaming(String val){
        String pattern="[A-Z]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(val);
        if(m.find()){
            String secHalf=val.substring(m.start());
            secHalf=secHalf.substring(0, 1).toLowerCase() + secHalf.substring(1);
            val=val.substring(0,m.start())+'_'+toSqlNaming(secHalf);
        }
        return val;
    }

    @Autowired
    RepoRequestTime repoRequestTime;

    @Autowired
    RepoCakeLimits repoCakeLimits;

    public Response insert(RequestTime requestTime){
        Optional<CakeLimit> optionalCakeLimit=repoCakeLimits.findByDate(requestTime.getOrderDate());
        if(!optionalCakeLimit.isPresent()){
            CakeLimit cakeLimit=new CakeLimit();
            cakeLimit.setDate(requestTime.getOrderDate());
            repoCakeLimits.save(
                    cakeLimit
            );
        }
        Optional<CakeLimit> optionalCakeLimit1=repoCakeLimits.findByDate(requestTime.getOrderDate());
        if(optionalCakeLimit1.isPresent()){
            CakeLimit cakeLimit=optionalCakeLimit1.get();
            final LocalTime time1 = LocalTime.parse("10:00:00");
            final LocalTime time2 = LocalTime.parse("11:00:00");
            final LocalTime time3 = LocalTime.parse("12:00:00");
            final LocalTime time4 = LocalTime.parse("13:00:00");
            final LocalTime time5 = LocalTime.parse("14:00:00");
            final LocalTime time6 = LocalTime.parse("15:00:00");
            final LocalTime time7 = LocalTime.parse("16:00:00");
            final LocalTime time8 = LocalTime.parse("17:00:00");
            final LocalTime time9 = LocalTime.parse("18:00:00");
            final LocalTime time10 = LocalTime.parse("19:00:00");
            LocalTime orderTime=requestTime.getOrderTime();
            if(orderTime==time1){
                if(cakeLimit.getFirstBatchLimit()+1>cakeLimit.getFirstBatchLimit()){
                    throw new LimitPassedException("Limit for the first batch has been passed");
                }
                cakeLimit.setFirstBatchDone(cakeLimit.getFirstBatchDone()+1);
            }else if(orderTime==time2){
                if(cakeLimit.getSecBatchDone()+1>cakeLimit.getSecBatchLimit()){
                    throw new LimitPassedException("Limit for the second batch has been passed");
                }
                cakeLimit.setSecBatchDone(cakeLimit.getSecBatchDone()+1);
            }else if(orderTime==time3){
                if(cakeLimit.getThirdBatchDone()+1>cakeLimit.getThirdBatchLimit()){
                    throw new LimitPassedException("Limit for the third batch has been passed");
                }
                cakeLimit.setThirdBatchDone(cakeLimit.getThirdBatchDone()+1);
            }else if(orderTime==time4){
                if(cakeLimit.getFourthBatchDone()+1>cakeLimit.getFourthBatchLimit()){
                    throw new LimitPassedException("Limit for the fourth batch has been passed");
                }
                cakeLimit.setFourthBatchDone(cakeLimit.getFourthBatchDone()+1);
            }else if(orderTime==time5){
                if(cakeLimit.getFifthBatchDone()+1>cakeLimit.getFifthBatchLimit()){
                    throw new LimitPassedException("Limit for the fifth batch has been passed");
                }
                cakeLimit.setFifthBatchDone(cakeLimit.getFifthBatchDone()+1);
            }else if(orderTime==time6){
                if(cakeLimit.getSixthBatchDone()+1>cakeLimit.getSixthBatchLimit()){
                    throw new LimitPassedException("Limit for the sixth batch has been passed");
                }
                cakeLimit.setSixthBatchDone(cakeLimit.getSixthBatchDone()+1);
            }else if(orderTime==time7){
                if(cakeLimit.getSeventhBatchDone()+1>cakeLimit.getSeventhBatchLimit()){
                    throw new LimitPassedException("Limit for the seventh batch has been passed");
                }
                cakeLimit.setSeventhBatchDone(cakeLimit.getSeventhBatchDone()+1);
            }else if(orderTime==time8){
                if(cakeLimit.getEighthBatchDone()+1>cakeLimit.getEighthBatchLimit()){
                    throw new LimitPassedException("Limit for the eighth batch has been passed");
                }
                cakeLimit.setEighthBatchDone(cakeLimit.getEighthBatchDone()+1);
            }else if (orderTime==time9){
                if(cakeLimit.getNinthBatchDone()+1>cakeLimit.getNinthBatchLimit()){
                    throw new LimitPassedException("Limit for the ninth batch has been passed");
                }
                cakeLimit.setNinthBatchDone(cakeLimit.getNinthBatchDone()+1);
            }else if(orderTime==time10){
                if(cakeLimit.getTenthBatchDone()+1>cakeLimit.getTenthBatchLimit()){
                    throw new LimitPassedException("Limit for the tenth batch has been passed");
                }
                cakeLimit.setTenthBatchDone(cakeLimit.getTenthBatchDone()+1);
            }
            repoCakeLimits.save(cakeLimit);
            return new Response().setResponse(
                    repoRequestTime.save(requestTime
                        .setIdCakeLimit(cakeLimit.getId())
                    )
            );
        }
        throw new RuntimeException("An error occurred");
    }


    public void timeChecker(List<RequestTime> list){
        LocalDate currentDate=java.time.LocalDate.now();
        LocalTime currentTime=java.time.LocalTime.now();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getOrderTime().isBefore(currentTime)
                    && (list.get(i).getOrderDate().isBefore(currentDate) || list.get(i).getOrderDate().isEqual(currentDate))){
                repoRequestTime.save(
                        list.get(i).setItsTime(true)
                );
            }
        }
    }

    public Response selectAll(){
        List<RequestTime> requestTimeList=repoRequestTime.selectAll();
        timeChecker(requestTimeList);
        Collections.reverse(requestTimeList);
        return new Response().setResponse(requestTimeList);
    }

    public Response selectBy(String query, Integer limit, Integer ascending, Integer page, String orderBy) {
        Sort sort;
        orderBy = orderBy == null? "id" : toSqlNaming(orderBy);
        if (ascending == 0) sort = Sort.by(orderBy).descending();
        else sort = Sort.by(orderBy).ascending();
        Pageable pageable = PageRequest.of(page != null ? (page-1) : 0, limit != null ? limit : 20, sort);
        Page<RequestTime> pages = repoRequestTime.findAllByQuery(query, pageable);
        if (pages != null && pages.getTotalElements() > 0) {
            return new Response().setResponse(new ResponsePagination()
                    .setDataList(pages.getContent()).setTotal(pages.getTotalElements()));
        } else {
            throw new WasNotFoundException("Nothing was found with these parameters");
        }

    }
}

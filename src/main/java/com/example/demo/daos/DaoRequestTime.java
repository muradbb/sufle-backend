package com.example.demo.daos;

import com.example.demo.entities.CakeLimit;
import com.example.demo.entities.RequestTime;
import com.example.demo.exceptions.LimitPassedException;
import com.example.demo.exceptions.NotFoundException;
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

    public String toSqlNaming(String val) {
        String pattern = "[A-Z]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(val);
        if (m.find()) {
            String secHalf = val.substring(m.start());
            secHalf = secHalf.substring(0, 1).toLowerCase() + secHalf.substring(1);
            val = val.substring(0, m.start()) + '_' + toSqlNaming(secHalf);
        }
        return val;
    }

    @Autowired
    RepoRequestTime repoRequestTime;

    @Autowired
    RepoCakeLimits repoCakeLimits;

    public Response insert(RequestTime requestTime) {
        Optional<CakeLimit> optionalCakeLimit = repoCakeLimits.findByDateAndType(requestTime.getOrderDate(), requestTime.getType());
        if (!optionalCakeLimit.isPresent()) {
            CakeLimit cakeLimit = cakeLimitInitializer(requestTime);
            cakeLimit = typeDelegator(requestTime, cakeLimit);
            repoCakeLimits.save(
                    cakeLimit
            );
            requestTime.setIdCakeLimit(cakeLimit.getId());
            return new Response().setResponse(repoRequestTime.save(requestTime));
        }
        CakeLimit cakeLimit = typeDelegator(requestTime, optionalCakeLimit.get());
        repoCakeLimits.save(cakeLimit);
        return new Response().setResponse(
                repoRequestTime.save(requestTime
                        .setIdCakeLimit(cakeLimit.getId())
                )
        );
    }

    public CakeLimit typeDelegator(RequestTime requestTime, CakeLimit cakeLimit) {

        String type = requestTime.getType();
        if (type.equals("tort")) {
            return addTort(cakeLimit, requestTime);
        } else if (type.equals("mtort")) {
            return addMTort(cakeLimit, requestTime);
        } else if (type.equals("atort")) {
            return addAtort(cakeLimit, requestTime);
        } else if (type.equals("qogal")) {
            return addQogal(cakeLimit, requestTime);
        } else if (type.equals("sekerbura")) {
            return addSekerbura(cakeLimit, requestTime);
        }else if(type.equals("paxlava")){
            return addPaxlava(cakeLimit,requestTime);
        }
        throw new NotFoundException("No entity with this type was found");
    }

    public CakeLimit cakeLimitInitializer(RequestTime requestTime) {
        String type = requestTime.getType();
        CakeLimit cakeLimit = new CakeLimit();
        cakeLimit.setDate(requestTime.getOrderDate());
        cakeLimit.setType(requestTime.getType());
        if (type.equals("tort")) {
            cakeLimit.setFirstBatchLimit(5);
            cakeLimit.setSecBatchLimit(5);
            cakeLimit.setThirdBatchLimit(5);
            cakeLimit.setFourthBatchLimit(5);
            cakeLimit.setFifthBatchLimit(5);
            cakeLimit.setSixthBatchLimit(5);
            cakeLimit.setSeventhBatchLimit(10);
            cakeLimit.setEighthBatchLimit(10);
            cakeLimit.setNinthBatchLimit(10);
            cakeLimit.setTenthBatchLimit(10);
        } else if (type.equals("mtort")) {
            cakeLimit.setFirstBatchLimit(2);
            cakeLimit.setSecBatchLimit(2);
            cakeLimit.setThirdBatchLimit(3);
        } else if (type.equals("atort")) {
            cakeLimit.setFirstBatchLimit(8);
            cakeLimit.setSecBatchLimit(4);
        } else if (type.equals("qogal")) {
            cakeLimit.setFirstBatchLimit(1600);
            cakeLimit.setSecBatchLimit(1000);
        } else if (type.equals("sekerbura")) {
            cakeLimit.setFirstBatchLimit(1000);
        } else if (type.equals("paxlava")) {
            cakeLimit.setFirstBatchLimit(50);
        } else {
            throw new WasNotFoundException("The type of baked good you requested does not exist");
        }
        return cakeLimit;
    }

    public CakeLimit addTort(CakeLimit cakeLimit, RequestTime requestTime) {
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
        LocalTime orderTime = requestTime.getOrderTime();
        if (orderTime == time1) {
            if (cakeLimit.getFirstBatchLimit() + requestTime.getAmount() > cakeLimit.getFirstBatchLimit()) {
                throw new LimitPassedException("Limit for the first batch has been passed");
            }
            cakeLimit.setFirstBatchDone(cakeLimit.getFirstBatchDone() + requestTime.getAmount());
        } else if (orderTime == time2) {
            if (cakeLimit.getSecBatchDone() + requestTime.getAmount() > cakeLimit.getSecBatchLimit()) {
                throw new LimitPassedException("Limit for the second batch has been passed");
            }
            cakeLimit.setSecBatchDone(cakeLimit.getSecBatchDone() + requestTime.getAmount());
        } else if (orderTime == time3) {
            if (cakeLimit.getThirdBatchDone() + requestTime.getAmount() > cakeLimit.getThirdBatchLimit()) {
                throw new LimitPassedException("Limit for the third batch has been passed");
            }
            cakeLimit.setThirdBatchDone(cakeLimit.getThirdBatchDone() + requestTime.getAmount());
        } else if (orderTime == time4) {
            if (cakeLimit.getFourthBatchDone() + requestTime.getAmount() > cakeLimit.getFourthBatchLimit()) {
                throw new LimitPassedException("Limit for the fourth batch has been passed");
            }
            cakeLimit.setFourthBatchDone(cakeLimit.getFourthBatchDone() + requestTime.getAmount());
        } else if (orderTime == time5) {
            if (cakeLimit.getFifthBatchDone() + requestTime.getAmount() > cakeLimit.getFifthBatchLimit()) {
                throw new LimitPassedException("Limit for the fifth batch has been passed");
            }
            cakeLimit.setFifthBatchDone(cakeLimit.getFifthBatchDone() + requestTime.getAmount());
        } else if (orderTime == time6) {
            if (cakeLimit.getSixthBatchDone() + requestTime.getAmount() > cakeLimit.getSixthBatchLimit()) {
                throw new LimitPassedException("Limit for the sixth batch has been passed");
            }
            cakeLimit.setSixthBatchDone(cakeLimit.getSixthBatchDone() + requestTime.getAmount());
        } else if (orderTime == time7) {
            if (cakeLimit.getSeventhBatchDone() + requestTime.getAmount() > cakeLimit.getSeventhBatchLimit()) {
                throw new LimitPassedException("Limit for the seventh batch has been passed");
            }
            cakeLimit.setSeventhBatchDone(cakeLimit.getSeventhBatchDone() + requestTime.getAmount());
        } else if (orderTime == time8) {
            if (cakeLimit.getEighthBatchDone() + requestTime.getAmount() > cakeLimit.getEighthBatchLimit()) {
                throw new LimitPassedException("Limit for the eighth batch has been passed");
            }
            cakeLimit.setEighthBatchDone(cakeLimit.getEighthBatchDone() + requestTime.getAmount());
        } else if (orderTime == time9) {
            if (cakeLimit.getNinthBatchDone() + requestTime.getAmount() > cakeLimit.getNinthBatchLimit()) {
                throw new LimitPassedException("Limit for the ninth batch has been passed");
            }
            cakeLimit.setNinthBatchDone(cakeLimit.getNinthBatchDone() + requestTime.getAmount());
        } else if (orderTime == time10) {
            if (cakeLimit.getTenthBatchDone() + requestTime.getAmount() > cakeLimit.getTenthBatchLimit()) {
                throw new LimitPassedException("Limit for the tenth batch has been passed");
            }
            cakeLimit.setTenthBatchDone(cakeLimit.getTenthBatchDone() + requestTime.getAmount());
        }
        return cakeLimit;
    }

    public CakeLimit addMTort(CakeLimit cakeLimit, RequestTime requestTime) {
        LocalTime orderTime = requestTime.getOrderTime();
        double amount = requestTime.getAmount();
        final LocalTime time1 = LocalTime.parse("10:00:00");
        final LocalTime time2 = LocalTime.parse("15:00:00");
        final LocalTime time3 = LocalTime.parse("18:00:00");
        if (orderTime == time1) {
            if (cakeLimit.getFirstBatchDone() + amount > cakeLimit.getFirstBatchLimit()) {
                throw new LimitPassedException("Limit for the mtort has been passed for the 09:00-13:00 period");
            } else {
                cakeLimit.setFirstBatchDone(cakeLimit.getFirstBatchDone() + amount);
            }
        } else if (orderTime == time2) {
            if (cakeLimit.getSecBatchDone() + amount > cakeLimit.getSecBatchLimit()) {
                throw new LimitPassedException("Limit for the mtort has been passed for the 13:00-17:00 period");
            } else {
                cakeLimit.setSecBatchDone(cakeLimit.getSecBatchDone() + amount);
            }
        } else if (orderTime == time3) {
            if (cakeLimit.getThirdBatchDone() + amount > cakeLimit.getThirdBatchLimit()) {
                throw new LimitPassedException("Limit for the mtort has been passed for the 17:00-21:00 period");
            } else {
                cakeLimit.setThirdBatchDone(cakeLimit.getThirdBatchDone() + amount);
            }
        }
        return cakeLimit;
    }

    public CakeLimit addAtort(CakeLimit cakeLimit, RequestTime requestTime) {
        LocalTime orderTime = requestTime.getOrderTime();
        double amount = requestTime.getAmount();
        final LocalTime time1 = LocalTime.parse("14:00:00");
        final LocalTime time2 = LocalTime.parse("17:00:00");
        if (orderTime == time1) {
            if (cakeLimit.getFirstBatchDone() + amount > cakeLimit.getFirstBatchLimit()) {
                throw new LimitPassedException("Limit for the atort has been passed for the 12:00-16:00 period");
            } else {
                cakeLimit.setFirstBatchDone(cakeLimit.getFirstBatchDone() + amount);
            }
        } else if (orderTime == time2) {
            if (cakeLimit.getSecBatchDone() + amount > cakeLimit.getSecBatchLimit()) {
                throw new LimitPassedException("Limit for the atort has been passed for the 16:00-21:00 period");
            } else {
                cakeLimit.setSecBatchDone(cakeLimit.getSecBatchDone() + amount);
            }
        }
        return cakeLimit;
    }

    public CakeLimit addQogal(CakeLimit cakeLimit, RequestTime requestTime) {
        LocalTime orderTime = requestTime.getOrderTime();
        double amount = requestTime.getAmount();
        final LocalTime time1 = LocalTime.parse("11:00:00");
        final LocalTime time2 = LocalTime.parse("15:00:00");
        if (orderTime == time1) {
            if (cakeLimit.getFirstBatchDone() + amount > cakeLimit.getFirstBatchLimit()) {
                throw new LimitPassedException("Limit for the atort has been passed for the 12:00-16:00 period");
            } else {
                cakeLimit.setFirstBatchDone(cakeLimit.getFirstBatchDone() + amount);
            }
        } else if (orderTime == time2) {
            if (cakeLimit.getSecBatchDone() + amount > cakeLimit.getSecBatchLimit()) {
                throw new LimitPassedException("Limit for the atort has been passed for the 16:00-21:00 period");
            } else {
                cakeLimit.setSecBatchDone(cakeLimit.getSecBatchDone() + amount);
            }
        }
        return cakeLimit;
    }

    public CakeLimit addSekerbura(CakeLimit cakeLimit, RequestTime requestTime) {
        double amount = requestTime.getAmount();
        if (cakeLimit.getFirstBatchDone() + amount > cakeLimit.getFirstBatchLimit()) {
            throw new LimitPassedException("Limit for sekerbura for today has been passed");
        }
        cakeLimit.setFirstBatchDone(cakeLimit.getFirstBatchDone() + amount);
        return cakeLimit;
    }

    public CakeLimit addPaxlava(CakeLimit cakeLimit,RequestTime requestTime){
        double amount = requestTime.getAmount();
        if (cakeLimit.getFirstBatchDone() + amount > cakeLimit.getFirstBatchLimit()) {
            throw new LimitPassedException("Limit for paxlava for today has been passed");
        }
        cakeLimit.setFirstBatchDone(cakeLimit.getFirstBatchDone() + amount);
        return cakeLimit;
    }


    public void timeChecker(List<RequestTime> list) {
        LocalDate currentDate = java.time.LocalDate.now();
        LocalTime currentTime = java.time.LocalTime.now();
        try {
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).isItsTime() && list.get(i).getOrderTime().isBefore(currentTime)
                        && (list.get(i).getOrderDate().isBefore(currentDate) || list.get(i).getOrderDate().isEqual(currentDate))) {
                    repoRequestTime.save(
                            list.get(i).setItsTime(true)
                    );
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Response selectAll() {
        List<RequestTime> requestTimeList = repoRequestTime.selectAll();
        timeChecker(requestTimeList);
        Collections.reverse(requestTimeList);
        return new Response().setResponse(requestTimeList);
    }

    public Response selectByType(String type) {
        if (!repoRequestTime.findAllByType(type).isPresent()) {
            throw new NotFoundException("No entity with this type was found");
        }
        return new Response().setResponse(repoRequestTime.findAllByType(type));
    }

    public Response selectBy(String query, Integer limit, Integer ascending, Integer page, String orderBy) {
        Sort sort;
        orderBy = orderBy == null ? "id" : toSqlNaming(orderBy);
        if (ascending == 0) sort = Sort.by(orderBy).descending();
        else sort = Sort.by(orderBy).ascending();
        Pageable pageable = PageRequest.of(page != null ? (page - 1) : 0, limit != null ? limit : 20, sort);
        Page<RequestTime> pages = repoRequestTime.findAllByQuery(query, pageable);
        if (pages != null && pages.getTotalElements() > 0) {
            return new Response().setResponse(new ResponsePagination()
                    .setDataList(pages.getContent()).setTotal(pages.getTotalElements()));
        } else {
            throw new WasNotFoundException("Nothing was found with these parameters");
        }

    }
}

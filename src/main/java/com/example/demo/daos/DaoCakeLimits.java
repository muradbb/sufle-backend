package com.example.demo.daos;

import com.example.demo.entities.CakeLimit;
import com.example.demo.exceptions.AlreadyExistsException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.WasNotFoundException;
import com.example.demo.models.Response;
import com.example.demo.repos.RepoCakeLimits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class DaoCakeLimits {

    @Autowired
    RepoCakeLimits repoCakeLimits;

    public Response insert(CakeLimit cakeLimit){
        Optional<CakeLimit> optionalCakeLimit=repoCakeLimits.findByDate(cakeLimit.getDate());
        if(!optionalCakeLimit.isPresent()){
            return new Response().setResponse(
                    repoCakeLimits.save(
                            cakeLimit
                    )
            );
        }
        throw new AlreadyExistsException("A cake limit with this date has already been created with the id:"+optionalCakeLimit.get().getId());
    }

    public boolean[] avalCheck(long id){
        Optional<CakeLimit> optionalCakeLimit=repoCakeLimits.findById(id);
        if(optionalCakeLimit.isPresent()){
            if(optionalCakeLimit.get().getType().equals("tort")){
                boolean[] avals=new boolean[9];
                CakeLimit cakeLimit= optionalCakeLimit.get();
                if(cakeLimit.getSecBatchLimit()==cakeLimit.getSecBatchDone()){
                    avals[0]=true;
                }
                if(cakeLimit.getThirdBatchLimit()==cakeLimit.getThirdBatchDone()){
                    avals[1]=true;
                }
                if(cakeLimit.getFourthBatchLimit()==cakeLimit.getFourthBatchDone()){
                    avals[2]=true;
                }
                if(cakeLimit.getFifthBatchLimit()==cakeLimit.getFifthBatchDone()){
                    avals[3]=true;
                }
                if(cakeLimit.getSixthBatchLimit()==cakeLimit.getSixthBatchDone()){
                    avals[4]=true;
                }
                if(cakeLimit.getSeventhBatchLimit()==cakeLimit.getSeventhBatchDone()){
                    avals[5]=true;
                }
                if(cakeLimit.getEighthBatchLimit()==cakeLimit.getEighthBatchDone()){
                    avals[6]=true;
                }
                if(cakeLimit.getNinthBatchLimit()==cakeLimit.getNinthBatchDone()){
                    avals[7]=true;
                }
                if(cakeLimit.getTenthBatchLimit()==cakeLimit.getTenthBatchDone()){
                    avals[8]=true;
                }
                return avals;
            }else{
                boolean[] avals=new boolean[10];
                CakeLimit cakeLimit= optionalCakeLimit.get();
                if(cakeLimit.getFirstBatchLimit()==cakeLimit.getFirstBatchDone()){
                    avals[0]=true;
                }
                if(cakeLimit.getSecBatchLimit()==cakeLimit.getSecBatchDone()){
                    avals[1]=true;
                }
                if(cakeLimit.getThirdBatchLimit()==cakeLimit.getThirdBatchDone()){
                    avals[2]=true;
                }
                if(cakeLimit.getFourthBatchLimit()==cakeLimit.getFourthBatchDone()){
                    avals[3]=true;
                }
                if(cakeLimit.getFifthBatchLimit()==cakeLimit.getFifthBatchDone()){
                    avals[4]=true;
                }
                if(cakeLimit.getSixthBatchLimit()==cakeLimit.getSixthBatchDone()){
                    avals[5]=true;
                }
                if(cakeLimit.getSeventhBatchLimit()==cakeLimit.getSeventhBatchDone()){
                    avals[6]=true;
                }
                if(cakeLimit.getEighthBatchLimit()==cakeLimit.getEighthBatchDone()){
                    avals[7]=true;
                }
                if(cakeLimit.getNinthBatchLimit()==cakeLimit.getNinthBatchDone()){
                    avals[8]=true;
                }
                if(cakeLimit.getTenthBatchLimit()==cakeLimit.getTenthBatchDone()){
                    avals[9]=true;
                }
                return avals;
            }
        }
        throw new NotFoundException("No cake limit was found with this id");
    }

    public Response selectById(long id){
        Optional<CakeLimit> optionalCakeLimit=repoCakeLimits.findById(id);
        if (optionalCakeLimit.isPresent()){
            CakeLimit cakeLimit= optionalCakeLimit.get();
            cakeLimit.setAvailability(avalCheck(id));
            return new Response().setResponse(cakeLimit);
        }
        throw new NotFoundException("No cake limit was found with this id");
    }

    public Response selectByDate(LocalDate date){
        Optional<CakeLimit> optionalCakeLimit=repoCakeLimits.findByDate(date);
        if (optionalCakeLimit.isPresent()){
            Optional<CakeLimit> cakeLimitOptional=repoCakeLimits.findById(optionalCakeLimit.get().getId());
            if(cakeLimitOptional.isPresent()){
                return selectById(cakeLimitOptional.get().getId());
            }
        }
        throw new WasNotFoundException("No item was found for this date");
    }

    public Response selectByDateAndType(LocalDate date,String type){
        Optional<CakeLimit> optionalCakeLimit=repoCakeLimits.findByDateAndType(date,type);
        //System.out.println(optionalCakeLimit.isPresent());
        if(optionalCakeLimit.isPresent()){
            CakeLimit cakeLimit=optionalCakeLimit.get();
            cakeLimit.setAvailability(avalCheck(cakeLimit.getId()));
            return new Response().setResponse(cakeLimit);
        }
        throw new WasNotFoundException("No item was found for this date and type");
    }



}

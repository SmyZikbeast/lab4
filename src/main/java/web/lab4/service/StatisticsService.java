package web.lab4.service;

import org.springframework.stereotype.Service;
import web.lab4.bean.ResultsBean;
import web.lab4.model.Submission;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class StatisticsService {
    ResultsBean resultsBean;

    public StatisticsService(ResultsBean resultsBean) {
        this.resultsBean = resultsBean;
    }

    public void clear(){
        resultsBean.clear();
        resultsBean.setHits(0);
        resultsBean.setLastClear(LocalDateTime.now());
    }

    public ArrayList<Submission> getList(){
        int fromIndex = Math.max(0, getAmount() - 10);
        ArrayList<Submission> slice = new ArrayList<>(resultsBean.getList().subList(fromIndex, getAmount()));
        Collections.reverse(slice);
        return slice;
    }

    public int getHits(){
        return resultsBean.getHits();
    }

    public int getAmount(){
        return resultsBean.getAmount();
    }

    public int getMisses(){
        return getAmount() - getHits();
    }

    public float getHitPercent(){
        return (float)getHits()/getAmount();
    }

    public LocalDateTime getLastClear(){
        return resultsBean.getLastClear();
    }
}

package web.lab4.service;

import org.springframework.stereotype.Service;
import web.lab4.bean.ResultsBean;
import web.lab4.model.Point;
import web.lab4.model.Submission;

import java.time.LocalDateTime;

@Service
public class PointService {
    ResultsBean resultsBean;

    public PointService(ResultsBean resultsBean) {
        this.resultsBean = resultsBean;
    }

    public void process(Point point){
        Submission submission = new Submission(resultsBean.getAmount() + 1, point, isHit(point), LocalDateTime.now());
        resultsBean.add(submission);
        if(submission.isHit()){
            resultsBean.setHits(resultsBean.getHits() + 1);
        }
    }

    public boolean isHit(Point point){
        float x = point.getX();
        float y = point.getY();
        float r = point.getR();
        if (x <= 0 && y >=0 && y <= x + r){
            return true;
        }
        if (x <= 0 && y <= 0 && x >= -r && y >= - r / 2){
            return true;
        }
        if (x >= 0 && y <= 0 && Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)){
            return true;
        }
        return false;
    }
}

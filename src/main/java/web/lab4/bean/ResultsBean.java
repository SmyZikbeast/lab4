package web.lab4.bean;

import org.springframework.stereotype.Component;
import web.lab4.model.Submission;

import java.time.LocalDateTime;
import java.util.ArrayList;


@Component
public class ResultsBean {
    static int hits = 0;
    private ArrayList<Submission> list = new ArrayList<>();
    private LocalDateTime lastClear = LocalDateTime.now();

    public void clear(){
        list = new ArrayList<>();
    }

    public ArrayList<Submission> getList() {
        return new ArrayList<>(list);
    }

    public void setList(ArrayList<Submission> list) {
        this.list = list;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public LocalDateTime getLastClear() {
        return lastClear;
    }

    public void setLastClear(LocalDateTime lastClear) {
        this.lastClear = lastClear;
    }

    public void add(Submission submission){
        list.add(submission);
    }

    public int getAmount() {
        return list.size();
    }
}

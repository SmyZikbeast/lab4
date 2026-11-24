package web.lab4.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Submission {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    int id;
    Point point;
    boolean hit;
    String submitTime;

    public Submission(int id, Point point, boolean hit, LocalDateTime submitTime) {
        this.id = id;
        this.point = point;
        this.hit = hit;
        this.submitTime = submitTime.format(formatter);
    }

    public int getId() {
        return id;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isHit() {
        return hit;
    }

    public String getSubmitTime() {
        return submitTime;
    }
}

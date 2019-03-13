package com.example.courseratingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Rating implements Parcelable {

    private String comment;
    private int feedback;
    private int exQuality;
    private int relevans;
    private int tPerfomance;
    private int tPreparation;
    private int jobOpp;


    public Rating(Parcel in) {
        comment = in.readString();
        feedback = in.readInt();
        exQuality = in.readInt();
        relevans = in.readInt();
        tPerfomance = in.readInt();
        tPreparation = in.readInt();
        jobOpp = in.readInt();
    }

    public Rating() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(comment);
        dest.writeInt(feedback);
        dest.writeInt(exQuality);
        dest.writeInt(relevans);
        dest.writeInt(tPerfomance);
        dest.writeInt(tPreparation);
        dest.writeInt(jobOpp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Rating> CREATOR = new Creator<Rating>() {
        @Override
        public Rating createFromParcel(Parcel in) {
            return new Rating(in);
        }

        @Override
        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public int getExQuality() {
        return exQuality;
    }

    public void setExQuality(int exQuality) {
        this.exQuality = exQuality;
    }

    public int getRelevans() {
        return relevans;
    }

    public void setRelevans(int relevans) {
        this.relevans = relevans;
    }

    public int gettPerfomance() {
        return tPerfomance;
    }

    public void settPerfomance(int tPerfomance) {
        this.tPerfomance = tPerfomance;
    }

    public int gettPreparation() {
        return tPreparation;
    }

    public void settPreparation(int tPreparation) {
        this.tPreparation = tPreparation;
    }

    public int getJobOpp() {
        return jobOpp;
    }

    public void setJobOpp(int jobOpp) {
        this.jobOpp = jobOpp;
    }
}

package com.example.month_3_lesson_2;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class MusicItem implements Parcelable{
    private String musicName;
    private int musicImage;
    private String musicAuthor;

    public MusicItem(String musicName, int musicImage , String musicAuthor) {
        this.musicName = musicName;
        this.musicImage = musicImage;
        this.musicAuthor = musicAuthor;
    }

    public String getMusicName() {
        return musicName;
    }

    public int getMusicImage() {
        return musicImage;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }





    protected MusicItem (Parcel in){
        musicImage = in.readInt();
        musicName = in.readString();
        musicAuthor = in.readString();
    }

    public  static final Creator<MusicItem> CREATOR = new Creator<MusicItem>() {
        @Override
        public MusicItem createFromParcel(Parcel parcel) {
            return new MusicItem(parcel);
        }

        @Override
        public MusicItem[] newArray(int size) {
            return new MusicItem[0];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
    parcel.writeInt(musicImage);
    parcel.writeString(musicName);
    parcel.writeString(musicAuthor);
    }
}

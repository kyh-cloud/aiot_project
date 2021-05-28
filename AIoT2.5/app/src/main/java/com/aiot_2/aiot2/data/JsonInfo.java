package com.aiot_2.aiot2.data;

/*
"id":1,
"date":"2017-11-22",
"user_rating":4.1,
"audience_rating":8.36,
"reviewer_rating":4.33,
"reservation_rate":61.69,
"reservation_grade":1,
"grade":15,
"thumb":"http://movie2.phinf.naver.net/20171107_251/1510033896133nWqxG_JPEG/movie_image.jpg?type=m99_141_2",
"image":"http://movie.phinf.naver.net/20171107_251/1510033896133nWqxG_JPEG/movie_image.jpg",
"photos":"http://movie.phinf.naver.net/20171010_164/1507615090097Sml1w_JPEG/movie_image.jpg?type=m665_443_2,http://movie.phinf.naver.net/20171010_127/1507615090528Dgk7z_JPEG/movie_image.jpg?"
 */

public class JsonInfo {

    public int id;
    public String title;
    public String title_eng;
    public String date;
    public float user_rating;
    public float audience_rating;
    public float reviewer_rating;
    public float reservation_rate;
    public int reservation_grade;
    public int grade;
    public String thumb;
    public String image;
    public String photos;

    public String name;
    public String height;
    public String weight;

    public String hour;
    public String min;
    public String sec;

}

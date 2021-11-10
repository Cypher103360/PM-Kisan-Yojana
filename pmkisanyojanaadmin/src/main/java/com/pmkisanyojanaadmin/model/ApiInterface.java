package com.pmkisanyojanaadmin.model;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    @POST("fetch_kisan_yojana_api.php")
    Call<YojanaModelList> getAllYojana();

    @POST("fetch_news_api.php")
    Call<NewsModelList> getAllNews();

    @FormUrlEncoded
    @POST("upload_kisan_yojna_api.php")
    Call<MessageModel> uploadYojana(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("upload_news_api.php")
    Call<MessageModel> uploadNews(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("upload_yojna_preview_data.php")
    Call<MessageModel> upladYojanaPreivewData(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("upload_news_preview_data.php")
    Call<MessageModel> uploadNewsPreviewData(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("fetch_yojana_preview_data.php")
    Call<YojanaPreviewModelList> getYojanaPreview(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("fetch_news_preview_data.php")
    Call<NewsPreviewModelList> getNewsPreview(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("update_news_api.php")
    Call<MessageModel> updateNews(@FieldMap Map<String, String> map);

}

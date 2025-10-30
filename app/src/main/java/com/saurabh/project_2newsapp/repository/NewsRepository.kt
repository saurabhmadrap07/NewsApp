package com.saurabh.project_2newsapp.repository

import com.saurabh.project_2newsapp.api.RetrofitInstance
import com.saurabh.project_2newsapp.db.ArticleDatabase
import com.saurabh.project_2newsapp.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews("India", pageNumber, "publishedAt")

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouritesNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}

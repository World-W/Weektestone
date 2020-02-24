package com.example.wangshijie_20200224.base;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

/**
 * 王世杰
 * 20200224
 */
public class Bean {

//    根据响应数据封装Bean类，并把响应数据转换成Bean对象
    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private List<BannerBean> banner;
        private List<NewsistBean> newsist;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<NewsistBean> getNewsist() {
            return newsist;
        }

        public void setNewsist(List<NewsistBean> newsist) {
            this.newsist = newsist;
        }

        public static class BannerBean extends SimpleBannerInfo {

            private String imageurl;

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }

            @Override
            public Object getXBannerUrl() {
                return null;
            }
        }

        public static class NewsistBean {
            private String title;
            private String content;
            private String author;
            private String time;
            private String image;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}

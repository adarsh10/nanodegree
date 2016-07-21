package com.adarsh.myappportfolio;

import java.util.List;

public interface AsyncResponse {

    void onTaskCompleted( List<Movie> results );

}

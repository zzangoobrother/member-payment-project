package com.example.memberpaymentproject.acceptance;

import com.example.memberpaymentproject.infrastructure.persistence.SearchSorting;
import com.example.memberpaymentproject.interfaces.presentation.request.CreateMemberRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class MemberSteps {

    public static ExtractableResponse<Response> 회원_등록(CreateMemberRequest request) {
        Map<String, String> params = new HashMap<>();
        params.put("name", request.name());

        return RestAssured.given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/api/v1/members")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 회원_목록_조회(SearchSorting searchSorting, int page) {
       return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/api/v1/members?searchSorting=" + searchSorting + "&page=" + page)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 회원_프로필_업데이트(Long memberId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .put("/api/v1/members/" + memberId + "/inquiry")
                .then().log().all()
                .extract();
    }
}

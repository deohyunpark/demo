package com.example.demo.controller;

import com.example.demo.controller.response.Response;
import com.example.demo.exception.ErrorCode;
import com.example.demo.service.OpenApiManager;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@ApiOperation(value = "공공데이터포털 API")
public class ApiController {
    private final OpenApiManager openApiManager;

    @Operation(summary = "인천광역시 미추홀구 의료기관 조회 API" , description =  "공공데이터 포털 API 를 이용하여 인천광역시 미추홀구에 있는 의료기관을 조회.",
            responses = { @ApiResponse(responseCode = "200", description = "목록조회성공"),
                    @ApiResponse(responseCode = "500", description = "서버 내부 에러",content = @Content(schema = @Schema(implementation = ErrorCode.class)))})
    @ApiImplicitParam(name = "pageNum", value = "조회하려는 페이지 숫자", dataType = "String", paramType = "path",required = true, dataTypeClass = String.class, example = "0")
    @GetMapping(value = "/open-api/{pageNum}")
    public Response<?> api(@PathVariable("pageNum") String pageNum) throws IOException {
        String jsonObject = openApiManager.openApi(pageNum);

        return Response.success(jsonObject);

    }


        }

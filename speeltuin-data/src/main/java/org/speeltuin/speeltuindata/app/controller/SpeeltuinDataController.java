package org.speeltuin.speeltuindata.app.controller;

import io.swagger.annotations.*;
import org.speeltuin.speeltuindata.app.config.SwaggerConfig;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"data"})
@Validated
@RequestMapping("mydata")
public interface SpeeltuinDataController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConfig.HTTP_200),
            @ApiResponse(code = 401, message = SwaggerConfig.HTTP_401),
            @ApiResponse(code = 404, message = SwaggerConfig.HTTP_404),
            @ApiResponse(code = 500, message = SwaggerConfig.HTTP_500)
    })
    List<Person> getData(
            @ApiParam(value = "", example = "") @RequestParam(required = false) String owner,
            @ApiParam(value = "", example = "") @RequestParam(required = false) String name,
            InputSortingAndPagingParams inputSortingAndPagingParams
    );

    @ApiOperation(value = "")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = SwaggerConfig.HTTP_204),
            @ApiResponse(code = 400, message = SwaggerConfig.HTTP_400),
            @ApiResponse(code = 401, message = SwaggerConfig.HTTP_401),
            @ApiResponse(code = 403, message = SwaggerConfig.HTTP_403),
            @ApiResponse(code = 404, message = SwaggerConfig.HTTP_404),
            @ApiResponse(code = 500, message = SwaggerConfig.HTTP_500)
    })
    @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    @PostMapping(value = "postdata",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    void postData(
            @ApiParam(value = "", required = true, example = "") @PathVariable String id,
            @ApiParam(value = "", required = true) @RequestBody RequestBody body);



}

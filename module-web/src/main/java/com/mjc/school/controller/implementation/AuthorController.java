package com.mjc.school.controller.implementation;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotation.CommandBody;
import com.mjc.school.controller.annotation.CommandHandler;
import com.mjc.school.controller.annotation.CommandParam;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.implementation.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController implements BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> {
    private final BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> authorService;

    @Autowired
    public AuthorController(AuthorServiceImpl authorServiceImpl) {
        this.authorService = authorServiceImpl;
    }

    @CommandHandler("GetAllAuthors")
    @Override
    public List<AuthorDtoResponse> readAll() {
        return authorService.readAll();
    }

    @CommandHandler("ReadAuthorById")
    @Override
    public AuthorDtoResponse readById(@CommandParam("authorId") Long id) {
        return authorService.readById(id);
    }

    @CommandHandler("CreateAuthor")
    @Override
    public AuthorDtoResponse create(@CommandBody AuthorDtoRequest createRequest) {
        return authorService.create(createRequest);
    }

    @CommandHandler("UpdateAuthor")
    @Override
    public AuthorDtoResponse update(@CommandBody AuthorDtoRequest updateRequest) {
        return authorService.update(updateRequest);
    }

    @CommandHandler("DeleteAuthor")
    @Override
    public boolean deleteById(@CommandParam("authorId") Long id) {
        return authorService.deleteById(id);
    }
}

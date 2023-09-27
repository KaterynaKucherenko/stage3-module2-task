package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.aspects.OnDelete;
import com.mjc.school.repository.datasourse.AuthorDataSource;
import com.mjc.school.repository.model.AuthorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("authorRepository")
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {
    private AuthorDataSource authorDataSource;

    @Autowired
    public AuthorRepository(AuthorDataSource authorDataSource) {
        this.authorDataSource = authorDataSource;
    }

    @Override
    public List<AuthorModel> readAll() {
        return authorDataSource.getAuthorModelList();
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        return Optional.ofNullable(this.authorDataSource.getAuthorId(id));
    }

    @Override
    public AuthorModel create(AuthorModel authorModel) {
        authorModel.setId(this.authorDataSource.getLastAuthorId());
        authorDataSource.getAuthorModelList().add(authorModel);
        return authorModel;
    }

    @Override
    public AuthorModel update(AuthorModel authorModel) {
        if (this.authorDataSource.getAuthorId(authorModel.getId()) == null) {
            return null;
        }
        AuthorModel authorForUpdate = this.authorDataSource.getAuthorId(authorModel.getId());
        authorForUpdate.setName(authorModel.getName());
        int tmp = authorDataSource.getAuthorModelList().indexOf(this.authorDataSource.getAuthorId(authorModel.getId()));
        authorDataSource.getAuthorModelList().remove(authorDataSource.getAuthorId(authorModel.getId()));
        authorDataSource.getAuthorModelList().add(tmp, authorForUpdate);
        return authorForUpdate;
    }

    @Override
    @OnDelete
    public boolean deleteById(Long id) {
        return authorDataSource.getAuthorModelList().remove(this.authorDataSource.getAuthorId(id));
    }

    @Override
    public boolean existById(Long id) {
        return this.authorDataSource.getAuthorId(id) != null;
    }
}

package zone.god.blogprojectbe.service;

import org.springframework.stereotype.Service;
import zone.god.blogprojectbe.model.Blog;

import java.util.List;

@Service
public interface BlogService {
    List<Blog> findAll();
    Blog findById(long id);
    void save(Blog blog);

    void delete(long id);
}

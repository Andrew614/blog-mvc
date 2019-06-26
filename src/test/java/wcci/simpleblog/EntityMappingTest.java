package wcci.simpleblog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityMappingTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private BlogTagRepository blogTagRepo;
	
	@Test
	public void shouldSaveAndLoadAuthor() {
		Author author = new Author("Andrew", "Zhang");
		entityManager.persist(author);
		entityManager.flush();
		Author foundAuthor = authorRepo.findById(author.getId()).get();
		assertThat(foundAuthor.getFirstName(), is("Andrew"));
	}
	
	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = new Category("category");
		entityManager.persist(category);
		entityManager.flush();
		Category foundCategory = categoryRepo.findById(category.getId()).get();
		assertThat(foundCategory.getName(), is("category"));	
	}
	
	@Test
	public void shouldSaveAndLoadBlogTags() {
		BlogTag blogTag = new BlogTag("food");
		entityManager.persist(blogTag);
		entityManager.flush();
		BlogTag foundBlogTag = blogTagRepo.findById(blogTag.getId()).get();
		assertThat(foundBlogTag.getName(), is("food"));
	}
	
	@Test
	public void shouldSaveAndLoadPost() {
		Author author = new Author("Andrew", "Zhang");
		entityManager.persist(author);
		Category category = new Category("category");
		entityManager.persist(category);
		BlogTag blogTag = new BlogTag("fruits");
		entityManager.persist(blogTag);
		Post post = new Post("title", author, category, "content", blogTag);
		entityManager.persist(post);
		entityManager.flush();
		Post foundPost = postRepo.findById(post.getId()).get();
		assertThat(foundPost.getTitle(), is("title"));
	}
}
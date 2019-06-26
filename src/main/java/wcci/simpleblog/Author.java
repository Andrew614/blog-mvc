package wcci.simpleblog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	private String firstName;
	private String lastName;

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "author")
	private List<Post> posts;

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Post> getPosts() {
		return posts;
	}

}
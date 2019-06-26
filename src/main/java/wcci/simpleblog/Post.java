package wcci.simpleblog;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	private String title;
	private String content;

	@ManyToOne
	private Author author;

	@ManyToOne
	private Category category;

	@ManyToMany
	private List<BlogTag> blogTags;

	@Id
	@GeneratedValue
	private Long id;
	
	protected Post() {}

	public Post(String title, Author author, Category category, String content, BlogTag... blogTags) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.content = content;
		this.blogTags = new ArrayList<BlogTag>();
		for (BlogTag blogTag : blogTags) {
			this.blogTags.add(blogTag);
		}
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public Category getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}

	public List<BlogTag> getBlogTag() {
		return blogTags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

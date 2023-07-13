package br.com.erudio.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.model.Book;

public class MockBook {

	public Book mockEntity() {
		return mockEntity(0);
	}

	public BookVO mockVO() {
		return mockVO(0);
	}

	public List<Book> mockEntityList() {
		List<Book> books = new ArrayList<Book>();
		for (int i = 0; i < 14; i++) {
			books.add(mockEntity(i));
		}
		return books;
	}

	public List<BookVO> mockVOList() {
		List<BookVO> books = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			books.add(mockVO(i));
		}
		return books;
	}

	public Book mockEntity(Integer number) {
		Book book = new Book();
		book.setAuthor("Author Test" + number);
		book.setTitle("Title Test" + number);
		book.setPrice(200D);
		book.setId(number.longValue());
		book.setLaunchDate(new Date(1688403896161L));
		return book;
	}

	public BookVO mockVO(Integer number) {
		BookVO book = new BookVO();
		book.setAuthor("Author Test" + number);
		book.setTitle("Title Test" + number);
		book.setPrice(200D);
		book.setKey(number.longValue());
		book.setLaunchDate(new Date(1688403896161L));
		return book;
	}
}

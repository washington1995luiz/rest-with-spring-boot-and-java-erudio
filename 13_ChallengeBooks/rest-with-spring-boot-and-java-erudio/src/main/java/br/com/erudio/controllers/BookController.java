package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.services.BookServices;
import br.com.erudio.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Books", description = "Endpoints to managing books")
public class BookController {
	
	@Autowired
	BookServices service;
	
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Find all Books", description = "Find all Books",
			tags = {"Books"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {
									@Content(
											mediaType = MediaType.APPLICATION_JSON,
											array  = @ArraySchema(schema = @Schema(implementation = BookVO.class))
											),
									@Content(
											mediaType = MediaType.APPLICATION_XML,
											array  = @ArraySchema(schema = @Schema(implementation = BookVO.class))
											),
									@Content(
											mediaType = MediaType.APPLICATION_YML,
											array  = @ArraySchema(schema = @Schema(implementation = BookVO.class))
											)
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			})
	public List<BookVO> findAll(){
		return service.findAll();
		}
	@GetMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Find all Books", description = "Find all Books",
			tags = {"Books"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {
									@Content(
											mediaType = MediaType.APPLICATION_JSON,
											array  = @ArraySchema(schema = @Schema(implementation = BookVO.class))
											),
									@Content(
											mediaType = MediaType.APPLICATION_XML,
											array  = @ArraySchema(schema = @Schema(implementation = BookVO.class))
											),
									@Content(
											mediaType = MediaType.APPLICATION_YML,
											array  = @ArraySchema(schema = @Schema(implementation = BookVO.class))
											)
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			})
	public List<BookVO> findAllWithSlash(){
		return service.findAll();
		}
	@GetMapping(value = "/{id}",
            	produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})

	@Operation(summary = "Find a Book", description = "Find a Book",
			tags = {"Books"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
						content = {
							@Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = BookVO.class)),
							@Content(mediaType = MediaType.APPLICATION_XML,schema = @Schema(implementation = BookVO.class)),
							@Content(mediaType = MediaType.APPLICATION_YML,schema = @Schema(implementation = BookVO.class)),
											
					}),
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			})
	public BookVO findById(@PathVariable(value = "id") Long id){
		return service.findById(id);
		}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Create a new book", description = "Create a new book", tags = {"Books"},
				responses = {
						@ApiResponse(description = "Success", responseCode = "200",
							content = { 
								@Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = BookVO.class)),
								@Content(mediaType = MediaType.APPLICATION_XML,schema = @Schema(implementation = BookVO.class)),
								@Content(mediaType = MediaType.APPLICATION_YML,schema = @Schema(implementation = BookVO.class)),
								}
						),
						
						@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
						@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
						@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
						@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
				})
	public BookVO create(@RequestBody BookVO book) {
		return service.create(book);
	}
	
	@PutMapping(produces = {
            		MediaType.APPLICATION_JSON, 
            		MediaType.APPLICATION_XML, 
            		MediaType.APPLICATION_YML
            		})
	@Operation(summary = "Update a book", description = "Update a book", tags = {"Books"},
				responses = {
						@ApiResponse(description = "Success", responseCode = "200",
							content = { 
								@Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = BookVO.class)), 
								@Content(mediaType = MediaType.APPLICATION_XML, schema = @Schema(implementation = BookVO.class)), 
								@Content(mediaType = MediaType.APPLICATION_YML, schema = @Schema(implementation = BookVO.class)), 
									}),
						@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
						@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
						@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
						@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
						@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
				}
			)
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete one book", description = "Delete one book", tags = {"Books"},
				responses = {
						@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
						@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
						@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
						@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
						@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
				}
			)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

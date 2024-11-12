<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<table border="1" width=100%>

		<tr>
			
			<td>
			
				<c:if test="${book.cover_image.substring(0,5) != 'https' }">
					<c:url value="/image?fname=${book.cover_image}" var="imgUrl"></c:url>
					
				</c:if> 
				<c:if test="${book.cover_image.substring(0,5) == 'https' }">
					<c:url value="${book.cover_image}" var="imgUrl"></c:url>
				</c:if> 
					<img height="150" width="200" src="${imgUrl}" />
			
			</td>
			<td>Tiêu đề: ${book.title}<br />
                Mã isbn: ${book.isbn}<br />
                Tác giả: ${book.author} <br />
                Publisher: ${book.publisher} <br />
                Publisher_date: ${book.publish_date} <br />
                Quantity: ${book.quantity} <br />
                Reviews (${book.num_rv}) 
							
			</td>
		</tr>
		
		<tr>
			<td>
				Reviews
			</td>
			<td></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<c:forEach var="item" items="${list}">            
                	${item} <br />
         		</c:forEach>
            </td>       
    	
    	</tr>

</table>
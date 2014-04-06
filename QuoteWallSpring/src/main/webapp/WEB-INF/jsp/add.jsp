<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<div class="panel panel-default">
	<div class="panel-body">
		<form:form commandName="addQuoteForm" method="post" cssClass="form-horizontal well">
			<fieldset>
				<legend>Add quote</legend>
				
				<div class="form-group">
					<form:label path="author" cssClass="col-sm-2 control-label">Author:</form:label>
					<form:input path="author" cssClass="form-control" />
				</div>
	
				<div class="form-group">
					<form:label path="text" class="col-sm-2 control-label">Text:</form:label>
					<form:textarea path="text" cssClass="form-control" rows="10" cols="30" />
				</div>
				
				<div class="form-group">
					<label class="col-md-8 control-label" for="singlebutton"></label>
					<input type="submit" value="Add" class="btn btn-primary" name="add"/>
				</div>

			</fieldset>
		</form:form>
	</div>
</div>
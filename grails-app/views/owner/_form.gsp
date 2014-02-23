<%@ page import="inventory.Owner" %>



<div class="fieldcontain ${hasErrors(bean: ownerInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="owner.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="128" required="" value="${ownerInstance?.name}"/>

</div>


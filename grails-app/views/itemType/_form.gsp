<%@ page import="inventory.ItemType" %>



<div class="fieldcontain ${hasErrors(bean: itemTypeInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="itemType.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="type" maxlength="64" required="" value="${itemTypeInstance?.type}"/>

</div>


<%@ page import="inventory.Member" %>



<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="member.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="128" required="" value="${memberInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'telephone', 'error')} required">
	<label for="telephone">
		<g:message code="member.telephone.label" default="Telephone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telephone" maxlength="32" pattern="${memberInstance.constraints.telephone.matches}" required="" value="${memberInstance?.telephone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="member.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="email" cols="40" rows="5" maxlength="254" required="" value="${memberInstance?.email}"/>

</div>


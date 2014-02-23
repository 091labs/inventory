<%@ page import="inventory.Item" %>



<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="item.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="name" cols="40" rows="5" maxlength="254" required="" value="${itemInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="item.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1024" required="" value="${itemInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="item.status.label" default="Status" />
		
	</label>
	<g:select name="status" from="${itemInstance.constraints.status.inList}" value="${itemInstance?.status}" valueMessagePrefix="item.status" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'picture', 'error')} ">
	<label for="picture">
		<g:message code="item.picture.label" default="Picture" />
		
	</label>
	<g:textField name="picture" value="${itemInstance?.picture}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="item.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${inventory.Owner.list()}" optionKey="id" required="" value="${itemInstance?.owner?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'serial', 'error')} ">
	<label for="serial">
		<g:message code="item.serial.label" default="Serial" />
		
	</label>
	<g:textField name="serial" value="${itemInstance?.serial}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="item.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="type" name="type.id" from="${inventory.ItemType.list()}" optionKey="id" required="" value="${itemInstance?.type?.id}" class="many-to-one"/>

</div>


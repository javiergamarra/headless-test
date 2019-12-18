package com.liferay.headless.test.internal.graphql.mutation.v1_0;

import com.liferay.headless.test.dto.v1_0.Entity;
import com.liferay.headless.test.resource.v1_0.EntityResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setEntityResourceComponentServiceObjects(
		ComponentServiceObjects<EntityResource>
			entityResourceComponentServiceObjects) {

		_entityResourceComponentServiceObjects =
			entityResourceComponentServiceObjects;
	}

	@GraphQLField
	public Entity createEntity(@GraphQLName("entity") Entity entity)
		throws Exception {

		return _applyComponentServiceObjects(
			_entityResourceComponentServiceObjects,
			this::_populateResourceContext,
			entityResource -> entityResource.postEntity(entity));
	}

	@GraphQLField
	public boolean deleteEntity(@GraphQLName("entityId") Integer entityId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_entityResourceComponentServiceObjects,
			this::_populateResourceContext,
			entityResource -> entityResource.deleteEntity(entityId));

		return true;
	}

	@GraphQLField
	public Entity updateEntity(
			@GraphQLName("entityId") Integer entityId,
			@GraphQLName("entity") Entity entity)
		throws Exception {

		return _applyComponentServiceObjects(
			_entityResourceComponentServiceObjects,
			this::_populateResourceContext,
			entityResource -> entityResource.putEntity(entityId, entity));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(EntityResource entityResource)
		throws Exception {

		entityResource.setContextAcceptLanguage(_acceptLanguage);
		entityResource.setContextCompany(_company);
		entityResource.setContextHttpServletRequest(_httpServletRequest);
		entityResource.setContextHttpServletResponse(_httpServletResponse);
		entityResource.setContextUriInfo(_uriInfo);
		entityResource.setContextUser(_user);
	}

	private static ComponentServiceObjects<EntityResource>
		_entityResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private Company _company;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;
	private User _user;

}
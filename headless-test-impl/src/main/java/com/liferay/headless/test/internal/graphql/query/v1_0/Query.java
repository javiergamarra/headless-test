package com.liferay.headless.test.internal.graphql.query.v1_0;

import com.liferay.headless.test.dto.v1_0.Entity;
import com.liferay.headless.test.resource.v1_0.EntityResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.function.BiFunction;

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
public class Query {

	public static void setEntityResourceComponentServiceObjects(
		ComponentServiceObjects<EntityResource>
			entityResourceComponentServiceObjects) {

		_entityResourceComponentServiceObjects =
			entityResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {entities(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public EntityPage entities(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_entityResourceComponentServiceObjects,
			this::_populateResourceContext,
			entityResource -> new EntityPage(
				entityResource.getEntitiesPage(
					search,
					_filterBiFunction.apply(entityResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(entityResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {entity(entityId: ___){id, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Entity entity(@GraphQLName("entityId") Integer entityId)
		throws Exception {

		return _applyComponentServiceObjects(
			_entityResourceComponentServiceObjects,
			this::_populateResourceContext,
			entityResource -> entityResource.getEntity(entityId));
	}

	@GraphQLName("EntityPage")
	public class EntityPage {

		public EntityPage(Page entityPage) {
			items = entityPage.getItems();
			lastPage = entityPage.getLastPage();
			page = entityPage.getPage();
			pageSize = entityPage.getPageSize();
			totalCount = entityPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<Entity> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private Company _company;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;
	private User _user;

}
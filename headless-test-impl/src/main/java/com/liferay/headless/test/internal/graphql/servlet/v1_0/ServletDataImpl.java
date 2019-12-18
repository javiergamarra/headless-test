package com.liferay.headless.test.internal.graphql.servlet.v1_0;

import com.liferay.headless.test.internal.graphql.mutation.v1_0.Mutation;
import com.liferay.headless.test.internal.graphql.query.v1_0.Query;
import com.liferay.headless.test.resource.v1_0.EntityResource;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Javier Gamarra
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setEntityResourceComponentServiceObjects(
			_entityResourceComponentServiceObjects);

		Query.setEntityResourceComponentServiceObjects(
			_entityResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	/**
	 * @deprecated
	 */
	@Override
	@Deprecated
	public String getPath() {
		return "/headless-test-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<EntityResource>
		_entityResourceComponentServiceObjects;

}
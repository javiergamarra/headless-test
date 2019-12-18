package com.liferay.headless.test.internal.resource.v1_0;

import com.liferay.headless.test.dto.v1_0.Entity;
import com.liferay.headless.test.resource.v1_0.EntityResource;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.SearchUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Javier Gamarra
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/entity.properties",
	scope = ServiceScope.PROTOTYPE, service = EntityResource.class
)
public class EntityResourceImpl extends BaseEntityResourceImpl implements
	EntityModelResource {

	Map<Integer, Entity> entities = new HashMap<>();

	@Override
	public Entity getEntity(Integer entityId) throws Exception {
		return entities.get(entityId);
	}

	@Override
	public Page<Entity> getEntitiesPage(
		String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		return SearchUtil.search(
			booleanQuery -> {
				// does nothing, we just need the UnsafeConsumer<BooleanQuery, Exception> method
			},
			filter, Entity.class, search, pagination,
			queryConfig -> queryConfig.setSelectedFieldNames(
				Field.ENTRY_CLASS_PK),
			searchContext -> searchContext.setCompanyId(contextCompany.getCompanyId()),
			document -> new Entity(), //FILL with your implementation
			sorts);
	}

	@Override
	public void deleteEntity(Integer entityId) throws Exception {
		entities.remove(entityId);
	}

	@Override
	public Entity postEntity(Entity entity) throws Exception {
		entities.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public Entity putEntity(Integer entityId, Entity entity) throws Exception {
		entities.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return _entityEntityModel;
	}

	private EntityEntityModel _entityEntityModel = new EntityEntityModel();
}
package com.rpm.best.repo;

import java.util.List;

import com.rpm.best.model.DynamicQuery;

/**
 * @author MohanRamu
 *
 * @param <T>
 */
public interface CustomQuery<T> {

	List<T> getByDynamicQuery(DynamicQuery dynamicQuery);
}

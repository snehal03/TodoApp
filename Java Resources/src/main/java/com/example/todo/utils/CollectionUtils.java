package com.example.todo.utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author invdeshmuk
 *
 */
public class CollectionUtils {
	/**
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty() || collection.size() == 0;
	}

	/**
	 * Casts List Elements With Requested Class
	 * 
	 * @param clazz
	 * @param c
	 * @return
	 */
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		if (c.size() != 0) {
			for (Object o : c)
				r.add(clazz.cast(o));
		}
		return r;
	}
}

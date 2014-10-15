package com.wordpress.infow.usermng.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wordpress.infow.usermng.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {

	}

	public UserDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<User> list() {

		@SuppressWarnings("unchecked")
		List<User> listUser = this.sessionFactory
		.getCurrentSession()
		.createCriteria(User.class)
		.setResultTransformer(
						CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public void saveOrUpdate(User user) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void delete(int id) {

		User userToDelete = new User();
		userToDelete.setId(id);
		this.sessionFactory.getCurrentSession().delete(userToDelete);
	}

	@Override
	@Transactional
	public User get(int id) {

		String hql = "from User where id=" + id;
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> listUser = query.list();

		if ((listUser != null) && !listUser.isEmpty()) {
			return listUser.get(0);
		}

		return null;
	}
}
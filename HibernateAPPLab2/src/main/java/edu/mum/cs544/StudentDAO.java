package edu.mum.cs544;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDAO {

	private Collection<Student> studentlist = new ArrayList<Student>();

	public Student load(long studentid) {
		EntityManager em = EntityManagerHelper.getCurrent();
		EntityGraph<Student> studentEntityGraph = em.createEntityGraph(Student.class);
		studentEntityGraph.addAttributeNodes("courselist");

		TypedQuery<Student>query = em.createQuery("from Student s where s.studentid= :s_id",Student.class);
		query.setParameter("s_id",studentid);
		query.setHint("javax.persistence.fetchgraph",studentEntityGraph);
		return query.getSingleResult();
	}
}

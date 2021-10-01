package edu.supavenir.ormtest;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import edu.supavenir.ormtest.models.Organization;
import edu.supavenir.ormtest.repositories.OrgaRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestOrgaRepository {
	
	@Autowired
	private OrgaRepository orgaRepository;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	void testSearch() {
		
		String search = UUID.randomUUID().toString();
		
		Organization o1 = new Organization();
		o1.setName(search);
		
		Organization o2 = new Organization();
		o2.setName("o2");
		o2.setDomain(search.toUpperCase());
		
		Organization o3 = new Organization();
		o3.setName("o2");
		o3.setAliases(search.toLowerCase());
		
		orgaRepository.save(o1);
		orgaRepository.save(o2);
		orgaRepository.save(o3);
		orgaRepository.flush();
		
		List<Organization> orgasSearch = orgaRepository.search(search);
		assertEquals(orgasSearch.size(), 3);
		orgaRepository.delete(o1);
		orgaRepository.delete(o2);
		orgaRepository.delete(o3);
		orgaRepository.flush();
	}
}

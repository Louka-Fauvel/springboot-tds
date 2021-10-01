package edu.supavenir.ormtest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.supavenir.ormtest.models.Organization;

@Repository
public interface OrgaRepository extends JpaRepository<Organization, Integer> {
	
	public Optional<Organization> findByName(String name); // peut retourner 1 objet ou rien
	
	public Integer deleteByName(String name);
	
	public List<Organization> findByNameContainingOrDomainContainingOrAliasesContainingIgnoreCase(String name, String domain, String aliases);
	
	@Query("select o from Organization o where lower(o.name) like lower(concat('%', :search, '%')) or lower(o.domain) like lower(concat('%', :search, '%')) or lower(o.aliases) like lower(concat('%', :search, '%'))")
	public List<Organization> search(@Param("search") String search);
}

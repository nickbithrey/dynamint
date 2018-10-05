package org.innovation.dynamint.channel.file;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ftpChannel", path = "ftpChannel")
public interface FtpRepository extends PagingAndSortingRepository<FtpChannel, Long> {

}

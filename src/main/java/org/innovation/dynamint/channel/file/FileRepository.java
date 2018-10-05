package org.innovation.dynamint.channel.file;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "fileChannel", path = "fileChannel")
public interface FileRepository extends PagingAndSortingRepository<FileChannel, Long> {

}

package org.innovation.dynamint.channel;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "channel", path = "channel")
public interface ChannelRepository extends PagingAndSortingRepository<BaseChannel, Long> {

}

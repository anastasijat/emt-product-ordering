package mk.ukim.finki.emt.productordering.sharedkernel.domain.base;


import mk.ukim.finki.emt.productordering.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();
}

package mk.ukim.finki.emt.productordering.productcatalog.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.productordering.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.ukim.finki.emt.productordering.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeLeftEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    public GradeLeftEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClassName().equals("mk.ukim.finki.emt.productordering.ordermanagement.domain.event.GradeLeft");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, GradeLeftEvent.class));
    }
}

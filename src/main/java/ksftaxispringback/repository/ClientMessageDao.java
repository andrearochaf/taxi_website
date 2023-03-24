package ksftaxispringback.repository;

import ksftaxispringback.entity.ClientMessage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientMessageDao extends JpaRepository<ClientMessage, Long> {

}

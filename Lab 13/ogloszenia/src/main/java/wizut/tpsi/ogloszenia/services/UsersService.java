package wizut.tpsi.ogloszenia.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wizut.tpsi.ogloszenia.jpa.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class UsersService {

    @PersistenceContext
    private EntityManager em;

    public User getUserByLogin(String login){
        return em.find(User.class, login);
    }

}

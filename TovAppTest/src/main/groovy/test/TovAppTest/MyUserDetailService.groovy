package test.TovAppTest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import test.TovAppTest.entities.User
import test.TovAppTest.rep.UserRepository

import java.util.logging.Logger


@Service
class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    UserDetails loadUserByUsername(String name){
        Logger logger = Logger.getLogger(TovAppTestApplication.class.getName())
        User user = repo.findByName(name)
        if (user==null) throw new UsernameNotFoundException(name)
        return new UserPrincipal(user)
    }
}

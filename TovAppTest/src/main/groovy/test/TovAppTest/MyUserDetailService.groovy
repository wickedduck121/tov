package test.TovAppTest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import test.TovAppTest.rep.UserRepository


@Service
class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    UserDetails loadUserByUsername(String name){

        /*repo
                .findByName(name)
                .map { new User(it.name, it.pass, []) }
                .orElseThrow { throw new UsernameNotFoundException() }*/
        def user = repo.findByName(name)
        User user1 = new User(user.name,user.pass, [])
        user1

    }
}

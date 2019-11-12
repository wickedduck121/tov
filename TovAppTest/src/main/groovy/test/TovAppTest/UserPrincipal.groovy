package test.TovAppTest

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import test.TovAppTest.entities.User

class UserPrincipal implements UserDetails {
    private User user;

    UserPrincipal(User user_local){
        user=user_local;
    }

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
        auths.add(new SimpleGrantedAuthority("USER"));
        return auths;
    }

    @Override
    String getPassword() {

        user.pass
    }

    @Override
    String getUsername() {
        user.name
    }

    @Override
    boolean isAccountNonExpired() {
        return false
    }

    @Override
    boolean isAccountNonLocked() {
        return false
    }

    @Override
    boolean isCredentialsNonExpired() {
        return false
    }

    @Override
    boolean isEnabled() {
        return true
    }
}

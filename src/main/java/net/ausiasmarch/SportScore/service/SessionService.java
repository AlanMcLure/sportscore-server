package net.ausiasmarch.SportScore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;
import net.ausiasmarch.SportScore.bean.JugadorBean;
import net.ausiasmarch.SportScore.entity.JugadorEntity;
import net.ausiasmarch.SportScore.exception.ResourceNotFoundException;
import net.ausiasmarch.SportScore.exception.UnauthorizedException;
import net.ausiasmarch.SportScore.helper.JWTHelper;
import net.ausiasmarch.SportScore.repository.JugadorRepository;

@Service
public class SessionService {
    
    @Autowired
    JugadorRepository oJugadorRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    public String login(JugadorBean oJugadorBean) {
        oJugadorRepository.findByUsernameAndPassword(oJugadorBean.getUsername(), oJugadorBean.getPassword())
                .orElseThrow(() -> new ResourceNotFoundException("User o password incorrectos"));
        return JWTHelper.generateJWT(oJugadorBean.getUsername());
    }

    public String getSessionUsername() {        
        if (oHttpServletRequest.getAttribute("username") instanceof String) {
            return oHttpServletRequest.getAttribute("username").toString();
        } else {
            return null;
        }
    }

    public JugadorEntity getSessionUser() {
        if (this.getSessionUsername() != null) {
            return oJugadorRepository.findByUsername(this.getSessionUsername()).orElse(null);    
        } else {
            return null;
        }
    }

    public Boolean isSessionActive() {
        if (this.getSessionUsername() != null) {
            return oJugadorRepository.findByUsername(this.getSessionUsername()).isPresent();
        } else {
            return false;
        }
    }

    public Boolean isAdmin() {
        if (this.getSessionUsername() != null) {
            JugadorEntity oUserEntityInSession = oJugadorRepository.findByUsername(this.getSessionUsername())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));
            return Boolean.FALSE.equals(oUserEntityInSession.getRole());
        } else {
            return false;
        }
    }

    public Boolean isUser() {
        if (this.getSessionUsername() != null) {
            JugadorEntity oUserEntityInSession = oJugadorRepository.findByUsername(this.getSessionUsername())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));
            return Boolean.TRUE.equals(oUserEntityInSession.getRole());
        } else {
            return false;
        }
    }

    public void onlyAdmins() {
        if (!this.isAdmin()) {
            throw new UnauthorizedException("Sólo los administradores pueden hacer esto");
        }
    }

    public void onlyUsers() {
        if (!this.isUser()) {
            throw new UnauthorizedException("Sólo los jugadores pueden hacer esto");
        }
    }

    public void onlyAdminsOrUsers() {
        if (!this.isSessionActive()) {
            throw new UnauthorizedException("Sólo los administradores o jugadores pueden hacer esto");
        }
    }

    public void onlyJugadoresWithIisOwnData(Long jugadorId) {
        if (!this.isUser()) {
            throw new UnauthorizedException("Sólo los jugadores pueden hacer esto");
        }
        if (!this.getSessionUser().getId().equals(jugadorId)) {
            throw new UnauthorizedException("Sólo los jugadores pueden hacer esto");
        }
    }

    public void onlyAdminsOrJugadoresWithIisOwnData(Long jugadorId) {
        if (this.isSessionActive()) {
            if (!this.isAdmin()) {
                if (!this.isUser()) {
                    throw new UnauthorizedException("Sólo los administradores pueden hacer esto");
                } else {
                    if (!this.getSessionUser().getId().equals(jugadorId)) {
                        throw new UnauthorizedException("Only admins or users with its own data can do this");
                    }
                }
            }
        } else {
            throw new UnauthorizedException("Sólo los administradores o jugadores pueden hacer esto");
        }
    }
}

# Activité Pratique N°4 :  Sécurité des Systèmes Distribués
## Partie 1 : Configuration de l'environnment et test
### 1.1 Configuration de l'environnment
On télécharge keycloak depuis le site officiel : https://www.keycloak.org/downloads.html (version 19.0.2)
On décompresse l'archive téléchargée et on lance le serveur keycloak avec la commande suivante :
```bash
bin\kc.bat start-dev
```
On accède à l'interface d'administration de keycloak via l'url : http://localhost:8080/auth/admin/
![img.png](images/img.png)
On crée un nouveau realm "wallet-realm" 

![img_1.png](images/img_1.png)

On crée un nouveau client "wallet-client"

![img_2.png](images/img_2.png)

On ajoute les configurations d'accès suivantes 
![img_3.png](images/img_3.png)

On crée un nouveau user "user1" avec le mot de passe "user1"

![img_4.png](images/img_4.png)

![img_5.png](images/img_5.png)


On crée un nouveau user avec "ayabug89" 
![img_6.png](images/img_6.png)

Puis on change de rôle vers Users et ADMIN
![img_7.png](images/img_7.png)


### 1.2 Test avec Postman 
Sur postman on test la réponse du endpoint suivant:
http://localhost:8080/realms/wallet-realm/protocol/openid-connect/token

![img_10.png](images/img_10.png)

On ajoute les propriétés suivantes :

![img_11.png](images/img_11.png)

On obtient le résultat suivant :
![img_12.png](images/img_12.png)

````json
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJxZXlRMzhPemF6RGFGMXBkcWNTNW5PalpZY0ZYMjFoaXkwRkg3VDRvOEZzIn0.eyJleHAiOjE3MDEwODE4NDQsImlhdCI6MTcwMTA4MTU0NCwianRpIjoiNzMxMTYwOTMtOWM4Yy00NjRmLWE1YjMtMGM3NzAyNjg4NWY1IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy93YWxsZXQtcmVhbG0iLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiOGJkODIzYTQtYTUxZS00ZWFlLTlmZWMtMzZlMzYwNjA2Y2FmIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoid2FsbGV0LWNsaWVudCIsInNlc3Npb25fc3RhdGUiOiJkNzc3MDVjYS1kZjU4LTQ0YzktOWFkYS0xN2U0NDhlOWNlZGMiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiZGVmYXVsdC1yb2xlcy13YWxsZXQtcmVhbG0iLCJ1bWFfYXV0aG9yaXphdGlvbiIsIlVTRVIiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJkNzc3MDVjYS1kZjU4LTQ0YzktOWFkYS0xN2U0NDhlOWNlZGMiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJVc2VyIDEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ1c2VyMSIsImdpdmVuX25hbWUiOiJVc2VyIiwiZmFtaWx5X25hbWUiOiIxIiwiZW1haWwiOiJ1c2VyMUB1c2VyLmNvbSJ9.jHOpmhGChbUTnvGvsnj3ZUBjNfgO-pZiIBq8pnU2oXQ7OJAlL2VVJfcqomSTeWrIeZT6UOJot9e7fI69hUg4dS-MqLDX4wHjc12R7DOJjVAFJZXFqec-0ggahlNrrHrmb6d3wMWkkyaE53UgjtpPDiZ5FU8bmgZHNShRsOSL6bGD9FcLrBRWNSNJsZxiXrSltUocXDf56ooeN_EUoNC09_uNLH1UbkiYJ0eeXapN186WFVrWasjnfPxyAGbMjefa76et-Sy7PyyvNFCHz-3OaNBEmd_DMOqdouSeKKvKOuOBHNv1qh-_Jdy4iVQfb_3MmkHx_ckfjgPfpCYzqwhAKQ",
    "expires_in": 300,
    "refresh_expires_in": 1800,
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjMWVmMzNhZi0zZDVhLTRlMzctODFkZS00NTUzY2RkYTFhYjQifQ.eyJleHAiOjE3MDEwODMzNDQsImlhdCI6MTcwMTA4MTU0NCwianRpIjoiYjg2Y2UxMDYtNWUyYS00MDU1LWI1ZTUtMjcyMWY5ZjZiYmNlIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy93YWxsZXQtcmVhbG0iLCJhdWQiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvcmVhbG1zL3dhbGxldC1yZWFsbSIsInN1YiI6IjhiZDgyM2E0LWE1MWUtNGVhZS05ZmVjLTM2ZTM2MDYwNmNhZiIsInR5cCI6IlJlZnJlc2giLCJhenAiOiJ3YWxsZXQtY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImQ3NzcwNWNhLWRmNTgtNDRjOS05YWRhLTE3ZTQ0OGU5Y2VkYyIsInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6ImQ3NzcwNWNhLWRmNTgtNDRjOS05YWRhLTE3ZTQ0OGU5Y2VkYyJ9.CeV1uTvhk5UcrFpjZna6JfYlVJlrIMTyLxje2iDxPEw",
    "token_type": "Bearer",
    "not-before-policy": 0,
    "session_state": "d77705ca-df58-44c9-9ada-17e448e9cedc",
    "scope": "email profile"
}
````
Si on convertit le token JWT on obtient les information suivants:
![img_13.png](images/img_13.png)

Sur keycloak on cherch la public key du wallet-realm
![img_14.png](images/img_14.png)
````
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyYmUi53Q/GioeNwKexrfWuCZYbMbPGtpBGSe3dDUoV5cagfwDONhPqHe+t114j2Cs8ssa0H0rWVaP/0GFiyZ3jgsx3okafVEW7kG8mOQlz6NsR2V5UajzJkr1Wu6mw9fpx04iwaMTGRfTaZkLFyBaQJTYKnnKh198tU2QHJ3GCP1noLDzq/CBWYPcMtKxXDGWyEkuChifBI4ZOIU/aKEazaRU1lz81XdMUzQLJlsJTbHdrO34kACj7ysTo/1coeRqLIWM8LQtjQHOiqyYbfhK7V7uAaV1v5fM2q5cusiEXq0Kn4JeaWMk8s7zoqFde7hi9w8GELwJnqh3NMM+L1BDwIDAQAB
-----END PUBLIC KEY-----
````

Et on essaie d'envoyer une requête vers le endpoint avec le token obtenu:

![img_15.png](images/img_15.png)

### 1.3 Authentification
On active client authentication pour Wallet-client
![img_16.png](images/img_16.png)

Le client secret suivant est généré 
![img_17.png](images/img_17.png)

On test sur postman avec le client secret
![img_18.png](images/img_18.png)

## Partie  2 : Sécuriser avec Keycloak les applications Wallet App

On exécute les services Ebank et Wallet 
![img_19.png](images/img_19.png)

### 2.1 Sécuriser le service Ebank
Puis on consulte http://localhost:8084/currencyDeposits,si tout marche bien on reçoit les données sous format JSON
![img_20.png](images/img_20.png)

Dans ebank, on ajoute les dépendances suivantes :
````
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.keycloak</groupId>
			<artifactId>keycloak-spring-boot-starter</artifactId>
			<version>19.0.2</version>
		</dependency>
````
Puis dans le fichier application.properties on ajoute les configurations suivantes :
````
keycloak.realm=wallet-realm 
keycloak.resource=wallet-client
keycloak.bearer-only=true 
keycloak.auth-server-url=http://Localhost:8080
keycloak.ssl-required=none
````

On modifie dans Wallet-realm :
![img_21.png](images/img_21.png)

On crée un package security dans ebank et on ajoute la classe suivante :
- [KeycloakAdapterConfig.java](ebank-service/src/main/java/org/sid/ebankservice/security/KeycloakAdapterConfig.java)
- [SecurityConfig.java](ebank-service/src/main/java/org/sid/ebankservice/security/SecurityConfig.java)

Sur postman on envoie une nouvelle requete pour reçevoir le token JWT
![img_22.png](images/img_22.png)

````
eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJxZXlRMzhPemF6RGFGMXBkcWNTNW5PalpZY0ZYMjFoaXkwRkg3VDRvOEZzIn0.eyJleHAiOjE3MDExOTUyNzgsImlhdCI6MTcwMTE5NDk3OCwianRpIjoiOTBlMWE0YTMtMmJlZS00MzBkLWI2ODUtMDE3OTk5YjE4NjE3IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy93YWxsZXQtcmVhbG0iLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiZTVjMDgyNTAtNjcwYi00ZjhmLTgxMjktZWYxYTM5ODI4NzQxIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoid2FsbGV0LWNsaWVudCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJkZWZhdWx0LXJvbGVzLXdhbGxldC1yZWFsbSIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwiY2xpZW50SG9zdCI6IjEyNy4wLjAuMSIsImNsaWVudElkIjoid2FsbGV0LWNsaWVudCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LXdhbGxldC1jbGllbnQiLCJjbGllbnRBZGRyZXNzIjoiMTI3LjAuMC4xIn0.PSasKajlMOCQp5qUBoV_4H_Z3hmUANbz_G5k10oPU1Ayk_hCXrLkFpreZZXt6reT0BYB5FMmbN5ttdpSJBQkNkkCIO8IFdxvW62xj5A91wj5gcdZu54eDX5G_ozzEihdIQ8ygB4AXsdOmO04dEM8HG8IWsY99C8UcrECnSODnLO7DlB8tbYn5BM7EdYiXK5B_fm9bUn64dkMAVx48sOUP_CjKUUn-ytD-uIvgffmX8YXPfXxi6Dw8ssGhcMaZfuh-TCyvBc9l70Zk-AQBRq-rJlg9X7t2-_7P4thMaD9qZMpJqm2BdrXRev118CLhqjRLT0Bdzhjjveb9QAMwuYXBQ
````

On peut désormais accéder à http://localhost:8084/currencyDeposits avec le token JWT

````http request
GET http://localhost:8084/currencyDeposits
Accept: application/json
Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJxZXlRMzhPemF6RGFGMXBkcWNTNW5PalpZY0ZYMjFoaXkwRkg3VDRvOEZzIn0.eyJleHAiOjE3MDExOTUyNzgsImlhdCI6MTcwMTE5NDk3OCwianRpIjoiOTBlMWE0YTMtMmJlZS00MzBkLWI2ODUtMDE3OTk5YjE4NjE3IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy93YWxsZXQtcmVhbG0iLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiZTVjMDgyNTAtNjcwYi00ZjhmLTgxMjktZWYxYTM5ODI4NzQxIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoid2FsbGV0LWNsaWVudCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJkZWZhdWx0LXJvbGVzLXdhbGxldC1yZWFsbSIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwiY2xpZW50SG9zdCI6IjEyNy4wLjAuMSIsImNsaWVudElkIjoid2FsbGV0LWNsaWVudCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LXdhbGxldC1jbGllbnQiLCJjbGllbnRBZGRyZXNzIjoiMTI3LjAuMC4xIn0.PSasKajlMOCQp5qUBoV_4H_Z3hmUANbz_G5k10oPU1Ayk_hCXrLkFpreZZXt6reT0BYB5FMmbN5ttdpSJBQkNkkCIO8IFdxvW62xj5A91wj5gcdZu54eDX5G_ozzEihdIQ8ygB4AXsdOmO04dEM8HG8IWsY99C8UcrECnSODnLO7DlB8tbYn5BM7EdYiXK5B_fm9bUn64dkMAVx48sOUP_CjKUUn-ytD-uIvgffmX8YXPfXxi6Dw8ssGhcMaZfuh-TCyvBc9l70Zk-AQBRq-rJlg9X7t2-_7P4thMaD9qZMpJqm2BdrXRev118CLhqjRLT0Bdzhjjveb9QAMwuYXBQ

````

![img_23.png](images/img_23.png)

### 2.2 Sécuriser le service Wallet

On lance le service wallet et l'application angular wallet-app

![img_24.png](images/img_24.png)

![img_25.png](images/img_25.png)

On ajoute ajoute les dépendances suivantes dans wallet-app :
```bash
npm install keycloak-angular keycloak-js --force
```

On ajoute guards puis crée [security.guard.ts](wallet-front-angular/src/app/guards/security.guard.ts) :
```typescript
export function kcFactory(keycloakService: KeycloakService) {
  return () => keycloakService.init({
    config: {
      url: 'http://localhost:8080',
      realm: 'wallet',
      clientId: 'wallet-client'
    },
    initOptions: {
      onLoad: 'login-required',
      checkLoginIframe: true
    },
  });
}
...
providers: [
    {provide: APP_INITIALIZER,
      useFactory: kcFactory,
      deps: [KeycloakService],
      multi: true
    }
  ],
```


Dans [app.component.ts](wallet-front-angular/src/app/app.component.ts) on ajoute les configurations suivantes :
```typescript
import { Injectable } from '@angular/core';
import {
    ActivatedRouteSnapshot,
    Router,
    RouterStateSnapshot
} from '@angular/router';
import { KeycloakAuthGuard, KeycloakService } from 'keycloak-angular';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard extends KeycloakAuthGuard {
    constructor(
        protected override readonly router: Router,
        protected readonly keycloak: KeycloakService
    ) {
        super(router, keycloak);
    }

    public async isAccessAllowed(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ) {
        // Force the user to log in if currently unauthenticated.
        if (!this.authenticated) {
            await this.keycloak.login({
                redirectUri: window.location.origin
            });
        }

        // Get the roles required from the route.
        const requiredRoles = route.data['roles'];

        // Allow the user to proceed if no additional roles are required to access the route.
        if (!Array.isArray(requiredRoles) || requiredRoles.length === 0) {
            return true;
        }

        // Allow the user to proceed if all the required roles are present.
        return requiredRoles.every((role) => this.roles.includes(role));
    }
}

```

Dan Service on ajoute [security.service.ts](wallet-front-angular/src/app/services/security.service.ts) :
```typescript
import {Injectable} from "@angular/core";
import {KeycloakProfile} from "keycloak-js";
import {KeycloakEventType, KeycloakService} from "keycloak-angular";

@Injectable({providedIn : "root"})
export class SecurityService {

  public profile? : KeycloakProfile;
  constructor (public kcService: KeycloakService) {

    this.init();

  }

  init(){

    this.kcService.keycloakEvents$.subscribe({

      next: (e) => {

        if (e.type == KeycloakEventType.OnAuthSuccess) {
          this.kcService.loadUserProfile().then(profile=>{
            this.profile=profile;

          });

        }

      }

    });

  }

  public hasRoleln(roles:string[]):boolean{
    let userRoles = this.kcService.getUserRoles();

    for(let role of roles){

      if (userRoles.includes(role)) return true;
    } return false;

  }

}
```

Dans Navbar on ajoute la condition suivante :
```html
 <a class="nav-link" *ngIf="securityService.profile;else loginTemplate">
             <a>{{securityService.profile.firstName}}</a>
            </a>
```

Puis on configure async login dans [navbar.component.ts](wallet-front-angular/src/app/navbar/navbar.component.ts) :
```typescript
onLogout() {
    this.securityService.kcService.logout(
        window.location.origin
    )

}
async login(){
    this.securityService.kcService.login(
{redirectUri: window.location.origin}
    )
    }
```

Notre application désormais nécessite une authentification pour accéder aux services

![img_26.png](images/img_26.png)

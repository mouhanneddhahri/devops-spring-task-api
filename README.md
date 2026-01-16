# devops-spring-task-api
#  DevOps Spring Task API

![Build Status](https://github.com/mouhanneddhahri/devops-spring-task-api/actions/workflows/ci-cd.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)
![Kubernetes](https://img.shields.io/badge/Kubernetes-Ready-blue)

##  Overview (Vue d'ensemble)
Ce projet est une API REST backend développée avec **Spring Boot**.
Il sert de démonstration complète d'un **cycle DevOps moderne** incluant l'intégration continue, le déploiement continu, la conteneurisation, l'orchestration et la sécurité.

###  Objectifs réalisés
- **Code :** API REST Java 17 (< 150 lignes).
- **CI/CD :** Pipeline GitHub Actions complet (Build, Test, Docker Push, DAST Scan).
- **Sécurité :** Analyse statique (CodeQL) et dynamique (OWASP ZAP).
- **Conteneurisation :** Image Docker optimisée multi-stage.
- **Orchestration :** Déploiement Kubernetes (Minikube) avec Haute Disponibilité (3 Répliques).
- **Observabilité :** Logs, Métriques Prometheus et Health Checks.

---

##  Prérequis

Pour lancer ce projet localement, vous avez besoin de :
- Java 17
- Maven
- Docker Desktop
- Minikube & Kubectl

---

##  Guide de Démarrage (Local)

 1. Cloner le projet
```bash
git clone https://github.com/mouhanneddhahri/devops-spring-task-api.git
cd devops-spring-task-api
2. Lancer avec Maven (Sans Docker)
code
Bash
mvn spring-boot:run
L'application sera accessible sur : http://localhost:8080/api/hello
 Utilisation avec Docker
L'image est disponible publiquement sur Docker Hub : mouhanneddhahri/task-api
1. Récupérer et lancer l'image
code
Bash
docker pull mouhanneddhahri/task-api:latest
docker run -p 8080:8080 mouhanneddhahri/task-api:latest
2. Vérifier
Accédez à : http://localhost:8080/api/hello
 Déploiement Kubernetes (Minikube)
Le projet utilise une stratégie de déploiement RollingUpdate avec 3 répliques pour assurer la haute disponibilité.
1. Démarrer Minikube
code
Bash
minikube start
2. Déployer l'application (Deployment + Service)
code
Bash
kubectl apply -f k8s/app.yaml
3. Vérifier les Pods
code
Bash
kubectl get pods
Résultat attendu : 3 pods en statut "Running".
4. Accéder à l'application
code
Bash
minikube service task-api --url
Utilisez l'URL fournie par Minikube pour tester les endpoints.
. API Endpoints & Observabilité
Voici les URLs à tester (remplacez LOCALHOST:PORT par l'URL de Minikube ou localhost:8080) :
Méthode	Endpoint	Description
GET	/api/hello	Retourne "Hello DevOps!" (Preuve de fonctionnement)
GET	/actuator/health	Statut de santé de l'application (UP)
GET	/actuator/prometheus	Métriques techniques pour le monitoring
GET	/actuator/metrics	Liste des métriques disponibles (Tracing basique)
. Sécurité (Security Scans)
Ce projet intègre des scans de sécurité automatisés dans le pipeline GitHub Actions :
SAST (Static Application Security Testing) : Analyse du code source via CodeQL pour détecter les vulnérabilités avant compilation.
DAST (Dynamic Application Security Testing) : Scan de l'application en cours d'exécution via OWASP ZAP pour détecter les failles web.
Consultez l'onglet Actions ou Security du dépôt pour voir les rapports.
. Architecture CI/CD
Le pipeline .github/workflows/ci-cd.yml effectue les étapes suivantes à chaque push :
Build & Test : Compilation Java et Tests Unitaires.
Security SAST : Analyse CodeQL.
Docker Build & Push : Création de l'image et envoi sur Docker Hub.
Security DAST : Lancement du conteneur et scan OWASP ZAP.


 Auteur : Mouhanned Dhahri

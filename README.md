# Spring Config Client Demo Project

## Config Client with automatic refresh using KubernetesClient

### Prerequisites:
- Java 21 or higher
- Docker
- Kubernetes

Running the service:
- source local/docker/db_credentials.env
- docker compose -f local/docker/docker-compose.yaml up -d
- ./mvnw clean install -Pdocker
- envsubst < k8s/chart/values.yaml | helm install reports ./k8s/chart --namespace demo -f -
- kubectl port-forward -n demo service/reports-svc 8010:8080
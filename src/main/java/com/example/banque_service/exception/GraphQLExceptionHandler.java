package com.example.banque_service.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

/**
 * Gestionnaire d'exceptions global pour GraphQL
 * Intercepte et formate les exceptions levées lors de l'exécution des requêtes GraphQL
 */
@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

    /**
     * Convertit une exception Java en erreur GraphQL
     * @param ex l'exception levée
     * @param env l'environnement d'exécution de la requête GraphQL
     * @return une erreur GraphQL formatée
     */
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return new GraphQLError() {
            /**
             * Retourne le message d'erreur
             * @return le message de l'exception
             */
            @Override
            public String getMessage() {
                return ex.getMessage();
            }

            /**
             * Retourne les emplacements dans la requête GraphQL où l'erreur s'est produite
             * @return null (non implémenté)
             */
            @Override
            public List<SourceLocation> getLocations() {
                return null;
            }

            /**
             * Retourne la classification du type d'erreur
             * @return null (non implémenté)
             */
            @Override
            public ErrorClassification getErrorType() {
                return null;
            }
        };
    }
}
package classes;

/**
 * Enumération représentant l'état d'une demande d'avis.
 * Le statut évolue selon les réponses reçues.
 */

public enum StatutDemande {
    EN_ATTENTE,
    EN_COURS,
    TRAITEE,
    ANNULEE
}
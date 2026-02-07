package com.app.hangerhub.auth.tenant;

public enum TenantStatus {
    ACTIVE,         // Currently accepting orders
    INACTIVE,       // Temporarily shut down (e.g., vacation)
    PENDING_SETUP,  // Account created, but menu/details not complete
    SUSPENDED,      // Account disabled by admin (e.g., violation)
    DELETED;        // Soft-deleted/archived
}

const configuredApiUrl = import.meta.env.VITE_API_URL || "http://localhost:8081";
const apiOrigin = configuredApiUrl.replace(/\/+$/, "").replace(/\/api$/, "");

export const apiBaseUrl = `${apiOrigin}/api/`;

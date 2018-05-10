package model;

public enum JobStatus {
    ABERTA("Aberta"), FECHADA("Fechada");

    private final String jobStatus;

    JobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobStatus() {
        return jobStatus;
    }
}

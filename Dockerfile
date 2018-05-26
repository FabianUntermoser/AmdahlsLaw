FROM airhacks/glassfish
COPY ./target/AmdahlsLaw.war ${DEPLOYMENT_DIR}

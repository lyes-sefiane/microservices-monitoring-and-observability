FROM grafana/grafana
LABEL maintainer="Lyes Sefiane"
ADD provisioning /etc/grafana/provisioning
ADD grafana.ini /etc/grafana
USER root
RUN apk upgrade --update-cache --available && \
    apk add openssl=1.1.1q-r0 && \
    rm -rf /var/cache/apk/*
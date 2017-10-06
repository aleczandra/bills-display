FROM cogniteev/oracle-java:java8

RUN mkdir /billprocesser
ADD bills-processer-0.0.1-SNAPSHOT.jar /billprocesser
ADD application.yml /billprocesser
ADD entrypoint.sh /billprocesser
RUN chmod +x /billprocesser/entrypoint.sh

WORKDIR /billprocesser
VOLUME /billprocesser

EXPOSE 8080
ENTRYPOINT ["/billprocesser/entrypoint.sh"]


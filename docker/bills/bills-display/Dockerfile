FROM tomcat:8.0-jre8


RUN mkdir /billdisplay
ADD bills-display-0.0.1-SNAPSHOT.jar /billdisplay
ADD entrypoint.sh /billdisplay
RUN chmod +x /billdisplay/entrypoint.sh

WORKDIR /billdisplay
VOLUME /billdisplay

EXPOSE 8080
ENTRYPOINT ["/billdisplay/entrypoint.sh"]





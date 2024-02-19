FROM alpine:3.18.3
RUN apk add --no-cache openjdk17
RUN apk add --no-cache tzdata
COPY build/libs/library1-1.0..jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/library1-1.0..jar"]

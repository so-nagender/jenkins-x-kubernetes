FROM node:12.18.1-alpine3.11

RUN apk update && apk upgrade && \
    echo @edge http://nl.alpinelinux.org/alpine/edge/community >> /etc/apk/repositories && \
    echo @edge http://nl.alpinelinux.org/alpine/edge/main >> /etc/apk/repositories && \
    echo @edge http://nl.alpinelinux.org/alpine/v3.9/community >> /etc/apk/repositories && \
    apk add --no-cache \
      chromium@edge \
      nss@edge \
      freetype@edge \
      harfbuzz@edge \
      ttf-freefont@edge \
      jq curl
RUN apk add --no-cache git
RUN apk --no-cache add --virtual builds-deps build-base python
RUN apk --no-cache add openjdk8
RUN mkdir -p /usr/src/oh
WORKDIR /usr/src/oh
COPY ./ /usr/src/oh

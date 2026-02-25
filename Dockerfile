FROM ubuntu:latest
LABEL authors="noahstewart"

ENTRYPOINT ["top", "-b"]
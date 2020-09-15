#!/usr/bin/env bash
cd $(dirname $0)
curl -F "file=@./atalhos_eclipse.pdf" http://localhost:8080/upload
FROM node

WORKDIR /usr/src/app

COPY ["package.json", "package-lock.json", "./"]


RUN npm install angular
RUN npm install
RUN npm install -g http-server

COPY . .

CMD http-server -p 4200

EXPOSE 4200/tcp

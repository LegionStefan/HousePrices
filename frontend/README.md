## Setting up the project

Setup a postgres database, see the file `src/main/resources/initialize-schema.sql` for more information.

First, start the backend:

```bash
./gradlew bootRun
```

Next up, start the frontend:

```bash
cd frontend;npm run dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

- The frontend runs on Next.js
- The backend runs on Springboot

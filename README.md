# six-pits

Sample online game / Tech showcase

You can read about the game [here](docs/about-the-game.md)

You can learn about the adopted tech stack [here](docs/about-the-tech-stack.md)

For detailed info about service project, jump [here](six-pits-service/README.md)

Detailed info on web project, [here](six-pits-web/README.md)

## How to run and test this solution

Open two terminals, one inside _service_ and another inside _web_ module.

On service module:

```bash
gradle bootRun
```

On web module:

```bash
npm install
npm run dev
```

To run tests on service module:

```bash
gradle test jacocoTestReport
```

And then go to the `build/reports` folder to see the results for test and coverage.

To run tests on web module:

```bash
npm run test
```

Test results and coverage will appear on console output

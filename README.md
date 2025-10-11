# healthcare-edi-model

HealthCare EDI Model is a library for creating and reading EDIFACT files from the German health care system for
rehabilitation sports (Sonstige Leistungserbringer).

## Introduction

HealthCare EDI Model is a library for creating and reading EDIFACT files from the German health care system for
rehabilitation sports (Sonstige Leistungserbringer).

## Prerequisites

Java JDK 8

## Maven

```
<dependency>
    <groupId>io.github.weissmuster</groupId>
    <artifactId>healthcare-edi-model</artifactId>
    <version>${project.version}</version>
</dependency>
```

or

## Setup

```
git clone https://github.com/weissmuster/healthcare-edi-model.git
cd healthcare-edi-model
mvn install
```

## Usage

TBD

## Features

- Easy integration

## Contributing

Contributions from the community are welcomed! Please create an issue or a pull request if you've found a bug or wish to
suggest a new feature.

## License

This project is licensed under the Apache License, Version 2.0. See
the [LICENSE](https://www.apache.org/licenses/LICENSE-2.0.txt) file for more details.

# healthcare-edi-model

HealthCare EDI Model is a library for creating and reading EDIFACT files from the German health care system for
rehabilitation sports (Sonstige Leistungserbringer).

## Introduction

HealthCare EDI Model is a library for creating and reading EDIFACT files from the German health care system for
rehabilitation sports (Sonstige Leistungserbringer).

## Prerequisites

Java JDK 8

## Maven

```
<dependency>
    <groupId>io.github.weissmuster</groupId>
    <artifactId>healthcare-edi-model</artifactId>
    <version>${project.version}</version>
</dependency>
```

or

## Setup

```
git clone https://github.com/weissmuster/healthcare-edi-model.git
cd healthcare-edi-model
mvn install
```

## Usage

TBD

## Features

- Easy integration

## Releasing to Maven Central (Sonatype Central Portal)

This project is configured to publish releases via the Sonatype Central Portal and to deploy SNAPSHOTs to OSSRH (s01).

- SNAPSHOTs: `mvn -DskipTests deploy`
  - Goes to: https://s01.oss.sonatype.org/content/repositories/snapshots
- Releases (non-SNAPSHOT version): `mvn -DskipTests deploy`
  - Uses the Central Publishing Maven Plugin to upload to https://central.sonatype.com

Requirements in ~/.m2/settings.xml:

```
<settings>
  <servers>
    <!-- Central Portal credentials: create a token in central.sonatype.com with Publish permission -->
    <server>
      <id>central</id>
      <username>YourCentralTokenName</username>
      <password>YourCentralTokenValue</password>
    </server>

    <!-- OSSRH snapshot credentials (if needed for snapshots) -->
    <server>
      <id>ossrh</id>
      <username>your-ossrh-username</username>
      <password>your-ossrh-password</password>
    </server>
  </servers>
</settings>
```

Notes:
- The Central token must be created in the Central Portal (https://central.sonatype.com) and must have Publish scope for the namespace `io.github.weissmuster`.
- In this POM the Central plugin uses server id `central` by default. You can override it at build time if your settings use a different id:
  - `mvn -Dcentral.publishing.serverId=yourServerId -DskipTests deploy`

Troubleshooting 401 "Invalid token":
- Ensure the token was created in the Central Portal (not legacy OSSRH) and is active (not revoked/expired).
- Check that your `~/.m2/settings.xml` server id matches the one used by the build (default `central`, or override via `-Dcentral.publishing.serverId=...`).
- Verify the token has Publish permission for the exact namespace of this project (`io.github.weissmuster`).
- Recreate a token if in doubt and update `settings.xml` accordingly.
- Run Maven with `-X -e` for more diagnostics.

## Contributing

Contributions from the community are welcomed! Please create an issue or a pull request if you've found a bug or wish to
suggest a new feature.

## License

This project is licensed under the Apache License, Version 2.0. See
the [LICENSE](https://www.apache.org/licenses/LICENSE-2.0.txt) file for more details.

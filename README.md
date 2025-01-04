# NaleumFramework [1.20~1.21]

**NaleumFramework**는 마인크래프트 서버를 위한 강력하고 확장 가능한 플러그인 프레임워크입니다. 이 프레임워크는 효율적이고 사용자 친화적인 API를 제공하여 개발자들이 쉽고 빠르게 플러그인을 개발할 수 있도록 돕습니다.

## 📋 주요 기능

- **이벤트 관리**: 간편한 이벤트 등록 및 처리.
- **명령어 시스템**: 유연한 명령어 작성 및 자동 완성 지원.
- **데이터 관리**: SQL 형식의 설정 및 데이터 파일 관리.
- **모듈화**: 플러그인 기능의 모듈화 및 확장성.
- **성능 최적화**: 고성능과 안정성을 보장하는 구조.

---

## 🚀 설치 방법

1. [Release 페이지](https://github.com/사용자명/NaleumFramework/releases)에서 최신 버전을 다운로드하세요.
2. 다운로드한 `NaleumFramework.jar` 파일을 서버의 `plugins` 폴더에 넣으세요.
3. 서버를 시작한 뒤, `logs/latest.log` 파일에서 프레임워크가 정상적으로 로드되었는지 확인하세요.

---

## 🛠️ 사용 방법

## 1. Plugin Setting

`plugins/NaleumFramework/config.yml` 파일에서 프레임워크의 기본 설정을 수정할 수 있습니다.

```yaml
database:
  type: mysql
  host: localhost
  port: 3306
  user: root
  password: root
  DB: NaleumFramework
```

## 2. Developer API
repository
```xml
<repository>
    <id>jitpack-repo</id>
    <url>https://jitpack.io</url>
</repository>
```
dependency
```xml
<dependency>
    <groupId>com.github.DevNyanHa</groupId>
    <artifactId>NaleumFramework</artifactId>
    <version>version</version>
    <scope>provided</scope>
</dependency>
```

---

## 📚 문서 및 가이드

- [API 문서](https://github.com/사용자명/NaleumFramework/wiki) 추가예정
- [예제 플러그인](https://github.com/사용자명/NaleumFramework/examples) 추가예정
- [질문 및 도움](https://github.com/사용자명/NaleumFramework/issues) 추가예정

---

## 📜 라이선스

이 프로젝트는 [MIT 라이선스](LICENSE)에 따라 배포됩니다.

---

# 전체 커밋 요약
git log <last tag> HEAD --pretty=format:%s

# 새로운 기능만
git log <last release> HEAD --grep feature

# overview

AndroidとFirebaseでチャットを作る

# Step1

- ProjectSetup
  - packname:challecara.handson
- gitを有効化
  - Menu>Enable Version Controller Integration
    - gitを選択
- gitignoreの設定
    - https://gist.github.com/Suwashimizu/190f43224c8e75ab8e76aa8d7cc4b711
    - .gitginoreを上書き
- ここでFirstCommit
- gmailが必要
- エミュレーターの設定
- 一度Build&Run

# Step2

- mBaaSとは何か
  - mobile backend as a Service
  - モバイルのバックエンドに必要なサービスを提供してくれるよ
  - ユーザー認証やデーターの保存ができるよ

- gradleに追加
  - https://gist.github.com/Suwashimizu/190f43224c8e75ab8e76aa8d7cc4b711
- string.xmlに追加
- databindingを有効化
- FirebaseのSetup
  - https://firebase.google.com/?hl=ja
  - プロジェクトを追加する
    - challecara2018
    - アナリティクスは日本
    - プロジェクトを作成
  - Dashboard
    - Androidアプリを追加
    - パッケージ名を入力
    - 設定ファイルをプロジェクトへ追加
    - 画面は閉じずにアプリを実行して疎通の確認

# Step3

- Authを試して見る
  - FirebaseDashboard
    - email認証のみ行う
    - ログイン方法をメール/パスワードありで有効
- FirebaseUIを試す
- Logoutをつける
  - AndroidResource > Menu > todo.xmlを追加
- MainActivity
  - startActivityForResult以降を参照
  - onActivityResultで結果を受け取る
- userObjを取得する
  - `val currentUser = FirebaseAuth.getInstance().currentUser`

# Step4

- ここから難易度UP
- TodoListFragment追加
- DBのruleを変えよう
  - https://gist.github.com/Suwashimizu/190f43224c8e75ab8e76aa8d7cc4b711#file-firebaserule
- RealtimeDatabase
- ListViewとArrayAdapter

import java.util.*


android {

    // 省略
    
    // APK作成と署名の設定
    signingConfigs {
        // 環境変数から取りに行く
        create("release_signing_config") {
            // 存在しない場合はとりあえずスルーする
            if (System.getenv("ENV_SIGN_KEYSTORE_BASE64") != null) {
                // GitHubActionsの環境変数に入れておいた署名ファイルがBase64でエンコードされているので戻す
                System.getenv("ENV_SIGN_KEYSTORE_BASE64").let { base64 ->
                    val decoder = Base64.getDecoder()
                    // ルートフォルダに作成する
                    File("keystore.jks").also { file ->
                        file.createNewFile()
                        file.writeBytes(decoder.decode(base64))
                    }
                }
                // どうやら appフォルダ の中を見に行ってるみたいなのでプロジェクトのルートフォルダを指定する
                storeFile = File(rootProject.projectDir, "keystore.jks")
                keyAlias = System.getenv("ENV_SIGN_KEY_ALIAS")
                keyPassword = System.getenv("ENV_SIGN_KEY_PASSWORD")
                storePassword = System.getenv("ENV_SIGN_STORE_PASSWORD")
            }
        }
    }

    buildTypes {
        release {
            // 署名の設定を適用する
            signingConfig = signingConfigs.getByName("release_signing_config")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

}

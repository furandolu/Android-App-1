import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class AboutActivity : AppCompatActivity() {
imageView.setImageResource(R.mipmap.ic_about)
textView.text = "Reimu Browser"
textView.text = "バージョン 1.0"
textView.text = "Created by Hakurei Reimu"
val clickableSpan = object : URLSpan("https://github.com/furandolu/Android-App-1") {
	override fun updateDrawState(ds: TextPaint) {
		super.updateDrawState(ds)
		ds.isUnderlineText = false
	}
}
binding.text.text = SpannableString("Github").apply {
	setSpan(clickableSpan, 3, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
}
binding.text.movementMethod = LinkMovementMethod.getInstance()

}

package com.iruen.www.kakao.domain;

public class KakaoMessage {

	private ApnsMessage apns;
	private GcmMessage gcm;

	public ApnsMessage getApns() {
		return apns;
	}

	public void setApns(ApnsMessage apns) {
		this.apns = apns;
	}

	public GcmMessage getGcm() {
		return gcm;
	}

	public void setGcm(GcmMessage gcm) {
		this.gcm = gcm;
	}

	public static class ApnsMessage {
		private int badge;
		private String sound;
		private boolean push_alert;
		private String message;
		private CustomField custom_field;

		public int getBadge() {
			return badge;
		}

		public void setBadge(int badge) {
			this.badge = badge;
		}

		public String getSound() {
			return sound;
		}

		public void setSound(String sound) {
			this.sound = sound;
		}

		public boolean isPush_alert() {
			return push_alert;
		}

		public void setPush_alert(boolean push_alert) {
			this.push_alert = push_alert;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public CustomField getCustom_field() {
			return custom_field;
		}

		public void setCustom_field(CustomField custom_field) {
			this.custom_field = custom_field;
		}

	}

	public static class GcmMessage {
		private String collapse;
		private boolean delay_while_idle;
		private CustomField custom_field;

		public String getCollapse() {
			return collapse;
		}

		public void setCollapse(String collapse) {
			this.collapse = collapse;
		}

		public boolean isDelay_while_idle() {
			return delay_while_idle;
		}

		public void setDelay_while_idle(boolean delay_while_idle) {
			this.delay_while_idle = delay_while_idle;
		}

		public CustomField getCustom_field() {
			return custom_field;
		}

		public void setCustom_field(CustomField custom_field) {
			this.custom_field = custom_field;
		}
	}

	public static class CustomField {
		private int article_id;
		private int comment_id;
		private String comment_preview;

		public int getArticle_id() {
			return article_id;
		}

		public void setArticle_id(int article_id) {
			this.article_id = article_id;
		}

		public int getComment_id() {
			return comment_id;
		}

		public void setComment_id(int comment_id) {
			this.comment_id = comment_id;
		}

		public String getComment_preview() {
			return comment_preview;
		}

		public void setComment_preview(String comment_preview) {
			this.comment_preview = comment_preview;
		}
	}

	public static KakaoMessage getDummyMessage() {
		KakaoMessage message = new KakaoMessage();
		ApnsMessage aMessage = new ApnsMessage();
		GcmMessage gMessage = new GcmMessage();
		CustomField cf = new CustomField();

		cf.setArticle_id(1);
		cf.setComment_id(1);
		cf.setComment_preview("Test Message Build created by gson!");

		aMessage.setBadge(1);
		aMessage.setCustom_field(cf);
		aMessage.setMessage("Apns Test Message created by gson!");
		aMessage.setPush_alert(true);
		aMessage.setSound("sound_file");

		gMessage.setCollapse("articleId123");
		gMessage.setCustom_field(cf);
		gMessage.setDelay_while_idle(false);

		message.setApns(aMessage);
		message.setGcm(gMessage);
		
		return message;
	}
}

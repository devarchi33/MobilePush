/**
 * kakao login 
 */
// 사용할 앱의 Javascript 키를 설정해 주세요.
Kakao.init('db831e72d4093199ddd7954e27a2f91b');

var kakaoLoginBtnCreator = Kakao.Auth.createLoginButton;

function logout() {
	Kakao.Auth.logout();
	location.reload();
};

// 카카오 로그인 버튼을 생성합니다.
kakaoLoginBtnCreator({
	container : '#kakao-login-btn-skyfly33-template',
	lang : 'kr',
	size : 'large',
	success : function(authObj) {
		// 로그인 성공시, API를 호출합니다.
		console.log("access_token : " + authObj.access_token);
		console.log("refresh_token : " + authObj.refresh_token);
		console.log("authObj : " + authObj);
		Kakao.API
				.request({
					url : '/v1/user/me',
					success : function(res) {
						// alert(JSON.stringify(res));
						var arr = res;
						console.log(arr);
						console.log(arr.id);
						console.log(arr.properties);
						var arr2 = arr.properties;
						console.log(arr2.nickname);
						console.log(arr2.thumbnail_image);

						var access_token = Kakao.Auth.getAccessToken();
						var refresh_token = Kakao.Auth.getRefreshToken();

//						document.pushInfo.AccessToken.value = access_token;
//						document.pushInfo.AdminKey.value = "69bc3ed693c46ce0e216be14a763152a";
						document.pushInfo.push_token.value = "APA91bEnfXAr1oJhErVcpd7vsBo-_3DDzcYmvuCGLNTTfxLtxIkLJe8DwvURrAfIRLBDeXbBg5yf6GKyLcMPksxLGxhZl3XffZmTPRVbBjG9yOh94ZQ4Y2JzYlBmVlt2IrCDNEyGGMQ7";
						document.pushInfo.device_id.value = "3134d877-ea92-3e4e-a403-f85950062cfb";
						document.pushInfo.uuid.value = arr.id;

						var i;
						var out = "<div class='row well'><div class='col-md-6'>";

						out += " <a href=''#'>" + "<img src= '"
								+ arr2.thumbnail_image + "' /></a>"
								+ "<p><strong>ID : </strong>" + arr.id + "</p>"
								+ "<p><strong>Nickname : </strong>"
								+ arr2.nickname + "</p>"
								+ "<p><strong>Access_Token : </strong>"
								+ access_token + "</p>"
								+ "<p><strong>Refresh_Token : </strong>"
								+ refresh_token + "</p>"
						out += "</div></div>"

						document.getElementById("id01").innerHTML = out;

						document.getElementById("id01").style.display = "block";

						/* window.onload = setTimeout("location.href='http://localhost:8080/redis_pub_sub/form.html'",3000); */
					},
					fail : function(error) {
						alert(JSON.stringify(error))
					},
					always : function(authObj, error) {
						//alert("test");
					},
				// persistAccessToken: false
				// persistRefreshToken: 'true'
				});
	},
	fail : function(err) {
		alert(JSON.stringify(err))
	}
});
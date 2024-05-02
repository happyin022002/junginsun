
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0310.jsp
	 *@FileTitle : Indonesian Customs EDI
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.29
	 *@LastModifier : 민동진
	 *@LastVersion : 1.0
	 * 2009.09.29 민동진
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.event.EsmBkg0310Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0310Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	
	// 템플릿 외 추가 된 부분 - S
	String strOfc_cd = "";
	// 템플릿 외 추가 된 부분 - E
	
	Logger log = Logger
			.getLogger("com.hanjin.apps.esm.bkg.customsdeclaration.customstransmission.indonesia");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		// 템플릿 외 추가 된 부분 - S
		strOfc_cd = account.getOfc_cd();
		// 테믈릿 외 추가 된 부분 - E

		event = (EsmBkg0310Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Indonesian Customs EDI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="bound_cd" value="I">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd %>">
	
	 <!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--top menu (S)--> <!--top menu (E)--></td>
	</tr>








	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">


				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="200" valign="top"><!--  biz_1  (S) -->
						<table class="search" border="0" style="width: 200;">
							<tr class="h23">
								<td width="33">VVD</td>
								<td width=""><input type="text"
									style="width: 100; ime-mode: disabled" value=""
									class="input1" dataformat="engupnum" maxlength="9" name="vvd" ></td>
								<td width="20"></td>
							</tr>
							<tr class="h23">
								<td colspan="2" width="">
								<table class="line_bluedot">
									<tr>
										<td colspan="4"></td>
									</tr>
								</table>
								</td>
								<td width="20"></td>
							</tr>
							<tr class="h23">
								<td width="33">POL</td>
								<td width=""><input type="text"
									style="width: 100; ime-mode: disabled" value=""
									class="input1" dataformat="engupnum" maxlength="5"
									name="pol_code"></td>
								<td width="20"></td>
							</tr>
							<tr class="h23">
								<td width="30">POD</td>
								<td width=""><input type="text"
									style="width: 100; ime-mode: disabled" value=""
									class="input1" dataformat="engupnum" maxlength="5"
									name="pod_code"></td>
								<td width="20"></td>
							</tr>
						</table>
						</td>
						<td width="">
						<table class="search_sm2" border="0" style="width: 300;">
							<tr class="h23">
								<td width=""><input type="radio" value="01I" class="trans"
									name="mf_tp_cd" checked="checked">&nbsp;&nbsp;01I&nbsp;:
								List of Discharged Goods</td>
							</tr>
							<tr class="h23">
								<td width=""><input type="radio" value="02I" class="trans"
									name="mf_tp_cd">&nbsp;&nbsp;02I &nbsp;: List of
								Transshipment Goods</td>
							</tr>
							<tr class="h23">
								<td width=""><input type="radio" value="03I" class="trans"
									name="mf_tp_cd">&nbsp;&nbsp;03I &nbsp;: List of Goods
								Retain on Board</td>
							</tr>
							<tr class="h23">
								<td width=""><input type="radio" value="08X" class="trans"
									name="mf_tp_cd">&nbsp;&nbsp;08X &nbsp;: Empty Container
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
			<!--  biz_1  (S) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td>
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	

				<!-- Grid BG Box  (S) --></td>
			</tr>
		</table>
		<!--biz page (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel">Excel Down</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_edi">EDI File Download</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->
		<table style="visibility:hidden;" >
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table id="mainTable" style="visibility:hidden;">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --> <!--  Button_Sub (S) --> <!-- Button_Sub (E) --></td>
			</tr>
		</table>
		</td>
	</tr>
</table>


<!-- Copyright (S) --> <!-- Copyright (E) --> <!-- 개발자 작업  끝 --></form>
</body>
</html>
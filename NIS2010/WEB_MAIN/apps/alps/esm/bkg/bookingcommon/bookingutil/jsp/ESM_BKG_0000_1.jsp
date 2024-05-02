<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_PRC_TEST.js
*@FileTitle : PROCEDURE TEST
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.24 김기종
* 1.0 Creation
* 2011.11.08 전성진 [] booking re-activate 기능 추가
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
	import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event.EsmBookingUtilEvent"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBookingUtilEvent event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBookingUtilEvent) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request
		//		.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();	
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<inputtype="hidden" name="pagerows"> 
<!-- 개발자 작업	-->
<table width="747" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp; BKG DB OBJ TEST</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0">
			<!-- : ( Grid ) (S) -->
				<table width="92%" class="search"  id="mainTable"> 
                     <tr>
                         <td width="250">
                         <script language="javascript">ComSheetObject('sheet1');</script>
                         </td>
                     </tr>
                </table>
		</table>

		<!--TAB Export (S) -->
		<div id="tabLayer" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg">
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>
						
						<td width="350">BKG_BDR_LOG_PKG.BDR_LOG_MAIN_PRC<br>
								(in_vsl_cd IN VARCHAR2<br>
	                            ,in_skd_voy_no IN VARCHAR2<br>
	                            ,in_skd_dir_cd IN VARCHAR2<br>
	                            ,in_user_id IN VARCHAR2<br>
	                            ,o_result   OUT VARCHAR2<br>
	                            ,o_err_msg  OUT VARCHAR2)</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<td class="btn2_left"></td>
								<td>
									<input type="text" style="width: 50; text-align: center;" class="input1" maxlength="4" name="vsl_cd" value="YUBT" required caption="vsl_cd" style="ime-mode:disabled">
									<input type="text" style="width: 40; text-align: center;" class="input1" maxlength="4" name="skd_voy_no" value="0011" required caption="skd_voy_no" style="ime-mode:disabled">
									<input type="text" style="width: 20; text-align: center;" class="input1" maxlength="1" name="skd_dir_cd" value="W" required caption="skd_dir_cd" style="ime-mode:disabled">
									
								&nbsp;<input type=button name="btn_Retrieve" id="btn_retrieve" value="실행" ></input>
								</td>
						</table>
						</td>
					</tr>
					<TR>
						
					</TR>
				</table>
				</td>
			</tr>
		</table>
		</div>
		<!--TAB Export (E) --> <!-- : ( Search Options ) (E) --></td>
	</tr>
</table>

<table width="747" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<!--TAB Export (S) -->
		<div id="tabLayer" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg">
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>
						
						<td width="350">BKG Re-activate</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<td class="btn2_left"></td>
								<td>
									<input type="text" style="width: 150; text-align: left" class="input1" maxlength="13" name="bkg_no" value="" required caption="Booking No." style="ime-mode:disabled">									
								&nbsp;<input type=button name="btn_activate" id="btn_activate" value="실행" ></input>
								</td>
						</table>
						</td>
					</tr>
					<TR>
						
					</TR>
				</table>
				</td>
			</tr>
		</table>
		</div>
		<!--TAB Export (E) --> <!-- : ( Search Options ) (E) --></td>
	</tr>
</table>

<!-- 2015/03/03 양동훈 수정 -->
<table width="747" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<!--TAB Export (S) -->
		<div id="tabLayer" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg">
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
						<tr>
						
						<td width="350">No Rate Status</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<td class="btn2_left"></td>
								<td>
									<input type="text" style="width: 150; text-align: left" class="input1" maxlength="13" name="bkg_no_norate" value="" required caption="Booking No." style="ime-mode:disabled">									
								&nbsp;<input type=button name="btn_noratefirm" id="btn_noratefirm" value="Firm" ></input>
								</td>
						</table>
						</td>
					</tr>
					<TR>
						
					</TR>
				</table>
				</td>
			</tr>
		</table>
		</div>
		<!--TAB Export (E) --> <!-- : ( Search Options ) (E) --></td>
	</tr>
</table>
<br/>
<!-- 2015/03/03 양동훈 수정 끝  -->



<!-- 2015/03/05 양동훈 수정 -->
<table width="747" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp; Container DB OBJ TEST</td>
			</tr>
		</table>
		<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
						<tr>
						
						<td width="150">BKG_NO</td>
						<td >
						<table width="100%" border="0" cellpadding="3" cellspacing="3">
								<td class="btn2_left"></td>
								<td>
									<input type="text" style="width: 150; text-align: left" class="input1" maxlength="13" name="bkgNo" value="" required caption="Booking No." style="ime-mode:disabled">									
								</td>
						</table>
						<td width="150">CNTR_NO</td>
						<td >
						<table width="100%" border="0" cellpadding="3" cellspacing="3">
								<td class="btn2_left"></td>
								<td>
									<input type="text" style="width: 150; text-align: left" class="input1" maxlength="13" name="cntrNo" value="" required caption="Container No." style="ime-mode:disabled">									
								</td>
						</table>
						</td>
					</tr>
					<TR>
						
					</TR>
</table>
		<!-- : ( Title ) (E) --> <!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0">
			<!-- : ( Grid ) (S) -->
				<table width="92%" class="search"  id="mainTable"> 
                     <tr>
                         <td width="250">
                         <script language="javascript">ComSheetObject('sheet2');</script>
                         </td>
                     </tr>
                </table>
                <table class="button" border="0" style="padding:5px 0px 10px 0px; border-collapse:collapse; border-spacing:0px; padding:0px; width:100%;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left">
									<td class="btn1" name="btnRetrieve">Retrieve</td>
									<td class="btn1_right">
								</tr>
							</table>
						</td>
						<td class="btn1_line"></td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left">
									<td class="btn1" name="btnSave">Save</td>
									<td class="btn1_right">
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
		</table>
		<!--TAB Export (E) --> <!-- : ( Search Options ) (E) --></td>
	</tr>
</table>
<!-- 
<table class="button" border="0" style="padding:5px 0px 10px 0px; border-collapse:collapse; border-spacing:0px; padding:0px; width:100%;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left">
									<td class="btn1" name="btnRetrieve">Retrieve</td>
									<td class="btn1_right">
								</tr>
							</table>
						</td>
						<td class="btn1_line"></td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left">
									<td class="btn1" name="btnSave">Save</td>
									<td class="btn1_right">
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
<!-- 2015/03/05 수정 끝 -->


<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>



<!-- 개발자 작업  끝 --></form>
</body>
</html>
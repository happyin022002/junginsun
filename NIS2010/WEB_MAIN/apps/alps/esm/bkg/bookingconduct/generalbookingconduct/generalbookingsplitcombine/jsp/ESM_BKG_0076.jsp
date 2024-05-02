<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0076.jsp
*@FileTitle : Booking Combine
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.25 전용진
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0076Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0076Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSplitCombine");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0076Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Combine</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="mst_bkg_no">
<input type="hidden" name="ca_rsn_cd"       value=""  style="width:30;"><!-- CA ReasonCd : 초기화 -->
<input type="hidden" name="ca_remark"       value=""  style="width:30;"><!-- CA Remark   : 초기화  -->
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->	

		<!-- : ( Search Options ) (S) -->
 			<!--biz page-1 (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="275">
						<table class="search_sm2" border="0" style="width:245;"> 
							<tr class="h23">
								<td><input type="radio" name="search_gbn" value="B" onClick="javascript:changeSearchGbn()" class="trans"> By BKG No.&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="search_gbn" value="R" onClick="javascript:changeSearchGbn()" class="trans" checked> By VVD & Route</td>
							</tr>
						</table>
					</td>
					<td width="65">First VVD</td>
					<td width="105"><input type="text" name="vvd" style="width:80;" maxlength="9" dataformat="engup" class="input1" value=""></td>
					<td width="25">POL</td>
					<td width="105"><input type="text" name="pol_cd" style="width:50;" maxlength="5" dataformat="engup" class="input1" value="">&nbsp;<input type="text" name="pol_nod_cd" style="width:25;" maxlength="2" dataformat="engup" class="input" value=""></td> 
					<td width="25">POD</td>
					<td width="105"><input type="text" name="pod_cd" style="width:50;" maxlength="5" dataformat="engup" class="input1" value="">&nbsp;<input type="text" name="pod_nod_cd" style="width:25;" maxlength="2" dataformat="engup" class="input" value=""></td>
					<td width="25">DEL</td>
					<td width="105"><input type="text" name="del_cd" style="width:50;" maxlength="5" dataformat="engup" class="input" value="">&nbsp;<input type="text" name="del_nod_cd" style="width:25;" maxlength="2" dataformat="engup" class="input" value=""></td>
					<td width="60">Hitchment</td>
					<td width=""><input type="checkbox" name="hitchment_yn" value="Y" class="trans" onClick="javscript:changeHitchGbn()"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:784;"> 
				<tr class="h23">
					<td width="45">Shipper</td>
					<td width=""><input type="text" name="cust_cnt_cd" style="width:25;" dataformat="engup" maxlength="2" class="input" value="">&nbsp;<input type="text" name="cust_seq" style="width:55;" dataformat="int" maxlength="6" class="input" value="">&nbsp;<input type="text" name="cust_nm" style="width:200;" dataformat="eng" maxlength="50" class="input" value=""></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- : ( Grid ) (E) -->	
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_rowdelete">Row&nbsp;Delete</td>
								<td class="btn2_right"></td>
								</tr>
							</table></td>
						</table>
					</td></tr>
				</table>
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	</td></tr>
</table> 
<table width="100% " class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_combine">Combine</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_container">Container</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cancel">BKG Cancel</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
	</tr>
</table>
    <!--Button (E) -->
</form>
</body>
</html>
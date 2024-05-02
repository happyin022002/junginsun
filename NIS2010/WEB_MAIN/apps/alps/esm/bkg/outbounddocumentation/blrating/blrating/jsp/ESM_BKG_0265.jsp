<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0265.jsp
*@FileTitle : Freight & Charge_Freight & Charge Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0265Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0265Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BlRating.BlRating");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0265Event)request.getAttribute("Event");
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
<title>Freight & Charge_Freight & Charge Remark</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="readOnly" value='<%=JSPUtil.getParameter(request, "readOnly")%>'>
<input type="hidden" name="ca_flg" value='<%=JSPUtil.getParameter(request, "ca_flg")%>'>
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  Charge Remark</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table border="0" style="width:100%;" class="search">
				<tr class="h23">
					<td width="80">Booking No.</td>
					<td width=""><input type="text" name='bkg_no' value='<%=JSPUtil.getParameter(request, "bkg_no")%>' class="" style="width:110;" readonly ></td>
				</tr>
				</table>

				<table class="search" border="0">
				<tr><td class="height_5"></td></tr>
				<tr><td class="title_h"></td>
					<td class="title_s">Internal Charge Remark for Audit</td></tr>
				</table>


				<table border="0" style="width:100%;" class="search">
				<tr class="h23">
					<td width="">
				
					
					<textarea rows="6" style="font-family:Courier New;width:100%; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img7" wrap="physical" dataformat="etc"  wrap="hard"  name="inter_rmk" tabindex=64></textarea>
					
					
					</td>
				</tr>
				</table>
				<table class="search" border="0">
				<tr><td class="height_5"></td></tr>
				<tr><td class="title_h"></td>
					<td class="title_s">External Charge Remark</td></tr>
				</table>


				<table border="0" style="width:100%;" class="search">
				<tr class="h23">
					<td width="">
					
			
					<textarea rows="6" style="font-family:Courier New;:width:100%; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img7" wrap="physical" dataformat="etc"  wrap="hard"  name="diff_rmk" tabindex=64></textarea>
					
					
					</td>
					</tr>
				</table>
				
				
				<table class="search" border="0">
					<tr><td class="height_5"></td></tr>
					<tr><td class="title_h"></td>
						<td class="title_s">Remark for Doc Center</td></tr>
				</table>


				<table border="0" style="width:100%;" class="search">
				<tr class="h23">
					<td width="">
					<textarea rows="6" style="font-family:Courier New;:width:100%; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img7" wrap="physical" dataformat="etc"  wrap="hard"  name="doc_inter_rmk" tabindex=64></textarea>
					</td>
					</tr>
				</table>


				<!--  biz_1   (E) -->


		</td></tr></table>
		<!--biz page (E)-->

</td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_clause">Pre Set Clause</td>
					<td class="btn1_right"></td>
				</tr></table></td>

			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->

	</td></tr>
</table>

<!-- : ( Button : pop ) (E) -->
<div id="Layer1" style="display:none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
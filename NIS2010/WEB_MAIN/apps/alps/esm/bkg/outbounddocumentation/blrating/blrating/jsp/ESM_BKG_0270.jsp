<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0270.jsp
*@FileTitle : Freight & Charge_S/C Note
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0270Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0270Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0270Event)request.getAttribute("Event");
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
<title>Freight & Charge_S/C Note</title>
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
<input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'>
<input type="hidden" name="sc_no" value='<%=JSPUtil.getParameter(request, "sc_no")%>'>
<input type="hidden" name="application_date" value='<%=JSPUtil.getParameter(request, "application_date")%>'>
<input type="hidden" name="svc_scp_cd" value='<%=JSPUtil.getParameter(request, "svc_scp_cd")%>'>
<input type="hidden" name="note_rt_seq" value='<%=JSPUtil.getParameter(request,"note_rt_seq") %>'>
<input type="hidden" name="prop_no" value='<%=JSPUtil.getParameter(request,"prop_no")%>'>
<input type="hidden" name="amdt_seq" value='<%=JSPUtil.getParameter(request,"amdt_seq") %>'>
<input type="hidden" name="gen_spcl_rt_tp_cd" value='<%=JSPUtil.getParameter(request,"gen_spcl_rt_tp_cd")%>'>
<input type="hidden" name="cmdt_hdr_seq" value='<%=JSPUtil.getParameter(request,"cmdt_hdr_seq")%>'>
<input type="hidden" name="rout_seq" value='<%=JSPUtil.getParameter(request,"rout_seq")%>'>




<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; S/C Note</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">


				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">OFT Note</td></tr>
				</table>

				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
						<!-- <div id="DIV_sheet1" style="display:none;"> -->
							<script language="javascript">ComSheetObject('sheet1');</script>
						<!-- </div> -->
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->



				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>


				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Surcharge Note</td></tr>
				</table>

				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
						<!--<div id="DIV_sheet2" style="display:none;"> -->
							<script language="javascript">ComSheetObject('sheet2');</script>
						<!--</div>-->
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<!-- : Arbitrary Note 삭제 
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Arbitrary  Note</td></tr>
				</table>
				<div id="DIV_sheet3" style="display:none;">
				<table width="100%" class="grid2">
					<tr>
						<td class="tr2_head" width="60">Note</td>
						<td class="input2"><textarea style="width:100%; height:40;" class="textarea2" name ='arbitrary_note' readonly></textarea></td>
					</tr>
				</table>
				</div>
 					-->
		    <!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
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


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
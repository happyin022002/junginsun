<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_360.jsp
*@FileTitle : Marks And Description by NVO H/BL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.07.22 김영출
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0360Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0360Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");

	String bkgNo = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0360Event)request.getAttribute("Event");
		bkgNo = event.getBkgNo();
		
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
<title>Marks &amp; Description of NVOCC House B/L</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

 
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Marks & Description of NVOCC House B/L</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
	
	<!--biz page (S)-->
	<table width="100%" class="search"> 
		<tr><td class="bg">
		
			<!--  biz_1  (S) -->
			<table width="700" border="0" class="search"> 
			<tr class="h23">
				<td width="140">Booking No.</td>
				<td width="550"><input type="text" name="bkg_no" value="<%=bkgNo%>" class="input" style="ime-mode:disabled;width:120px;" dataformat="engupnum">
				<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
				</td>
			</tr> 
			</table>
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table width="700" border="0" class="search"> 
				<tr class="h23">
				<td width="140">Customs Description</td>
				<td width="550"><input type="text" name="cntr_mf_gds_desc" class="input" style="ime-mode:disabled;width:100%;" dataformat="engupnumspc"></td>
				</tr> 
			</table>
			
			<table><tr><td height="5"></td></tr></table>
			
			<table width="700" border="0" cellspacing="2" class="search"> 
				<tr class="h23">
				<td width="137" valign="top">
					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- : ( Grid ) (E) -->
				</td>
				<td width="190" valign="top">
					<table width="98%" height="100%" border="0" class="search"> 
						<tr><td height="18" style="border:1px solid #A3A4C7;" class="tr_head2">Marks & Numbers</td></tr>
						<tr><td align="center" valign="top"><textarea name="bl_mk_desc"  style="height:80;width:190; ime-mode:disabled;font-family:Courier New;font-size:14px;text-indent:0px;overflow X:hidden;height:182px;" dataformat="engupnumspc"></textarea></td></tr>		
					</table>
				</td>
				<td width="3"></td>
				<td width="370" wvalign="top">
					<table width="98%" height="100%" border="0" class="search"> 
						<tr><td height="18" style="border:1px solid #A3A4C7;" class="tr_head2">Description of Goods</td></tr>
						<tr><td align="center" valign="top"><textarea name="bl_gds_desc" style="height:80;width:370; ime-mode:disabled;font-family:Courier New;font-size:14px;text-indent:0px;overflow X:hidden;height:182px" dataformat="engupnumspc"></textarea></td></tr>		
					</table>
				</td>
				</tr>
		</table>

		</td></tr></table>
		<!--  biz_1   (E) -->

	</td></tr></table>
	<!--biz page (E)--> 

	<!-- : ( Button : pop ) (S) -->
	<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
	
			<!--Button (S) -->	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
			<tr><td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve">Retrieve</td>
						<td class="btn1_right">
					</tr></table></td>	
					<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_selectall">Select All</td>
						<td class="btn1_right">
					</tr></table></td-->	
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_copy">Copy to M.B/L</td>
						<td class="btn1_right">
					</tr></table></td>	
				<td class="btn1_line"></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right">
					</tr></table></td>
				</tr>
			</table></td></tr>
			</table>
			<!--Button (E) -->
		
		</td></tr>
	</table>
	<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
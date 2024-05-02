<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2077.jsp
*@FileTitle : Inventory by Lessor & Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.10 조재성
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2077Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm2077Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm2077Event)request.getAttribute("Event");
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
<title>Inventory by Lessor & Agreement</title>
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="eq_knd_cd">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="ofc_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:979;"> 
				        <tr class="h23">
					<td width="100">Creation Office</td>
                    <td width="" colspan="3"><input type="text" style="width:140;ime-mode:disabled" dataformat="engup" name="crnt_ofc_cd"   class="input" value="" >&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="ComOpenPopupWithTargetOffice"></td>
					</tr> 
					<tr class="h23">
					<td width="100">Lessor</td>
					<td width="220"><input type="text" name="vndr_seq" dataformat="eng" style="width:140;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="80">Lease Term</td>
					<td width=""><script language="javascript">ComComboObject('agmt_lstm_cd', 1, 155, 0, 0, 1, true);</script>&nbsp;<!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					</tr> 
				</table>
				
		
		<!-- Tab BG Box  (S) -->
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
	
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				

			<!-- Grid (E) -->

	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
		</td>
				</tr>
			</table>
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp; Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</tr>
		</table>
    <!--Button (E) -->
		</td></tr>
</table>
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
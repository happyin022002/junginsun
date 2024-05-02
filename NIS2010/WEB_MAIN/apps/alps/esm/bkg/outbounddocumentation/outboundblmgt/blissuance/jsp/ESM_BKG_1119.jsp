<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1119.jsp
*@FileTitle : Korea B/L Application List
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.01
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.12.01 김종호
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1119Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssRqstVO"%>

<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%@ page import="java.util.HashMap"%>

<%
	EsmBkg1119Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
//	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
	//String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");

	String sXml = null;
//	BlIssRqstVO blissRqst = null;
	
	/*-----------------------------------------------------*/
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();	   
	   
		event = (EsmBkg1119Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		if (eventResponse != null) {
			eventResponse.getRsVoList();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Issue Request(WEB)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var userOfc_cd = "<%=strOfc_cd%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onload="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="bkgNoList">
<input type="hidden" name="seqList">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=System.getProperty("user.home")+System.getProperty("file.separator")%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr><td valign="top">
	
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="84">Request Date</td>
					<td width="230">
					  <input type="text" style="width: 80"  class="input1" name="rqst_from_dt" caption="Request DT" dataformat="ymd" tabindex="1">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width: 80"  class="input1" name="rqst_to_dt" caption="Request DT" dataformat="ymd" tabindex="2">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
					</td>
					<td width="160">접수지&nbsp;<input type="text" style="width: 100;" style="ime-mode:disabled" dataformat="engupnum" maxlength="5" class="input" name="rqst_rct_loc_cd" value="" tabindex="3"></td>
					<td width="130">POL&nbsp;<input type="text" style="width: 90;" style="ime-mode:disabled" dataformat="engupnum" maxlength="5" class="input" name="pol_cd" value="" tabindex="4"></td>
					<td width="60">B/L Type&nbsp;</td>
                    <td><script language="javascript">ComComboObject('rqst_bl_tp_cd',1, 90, '');</script>
					</td>
					<td>Handling Status&nbsp;</td>
					<td><script language="javascript">ComComboObject('bl_iss_sts_cd',1, 90, '');</script>
					</td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="84">B/L No</td>
					<td width="230"><input type="text" style="width: 161;" style="ime-mode:disabled" caption="Request No." dataformat="engupnum" maxlength="12" class="input" name="bl_no" value="" tabindex="11"></td>
					<td width="290">Vessel Name&nbsp;<input type="text" style="width: 200;" style="ime-mode:disabled" maxlength="9" dataformat="engupnum" class="input" name="vvd" value="" tabindex="12"></td>
					<td width="60">Delete</td>
					<td><select name="delt_flg" style="width:90;">
						<option value="N" selected>N</option>
						<option value="Y">Y</option>
						</select>
					</td>  
					<td>Handling Office&nbsp;</td>
					<td><input type="text" style="width: 90;" style="ime-mode:disabled" class="input" dataformat="engup" maxlength="6" name="ofc_cd" value="" tabindex="12"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width: 979;"> 
				<tr class="h23">
					<td width="84">신청업체</td>
					<td width=""><input type="text" style="width: 450;" class="input" name="rqst_co_nm" value="" tabindex="44"></td>
					<td>Request Type&nbsp;</td>
					<td><script language="javascript">ComComboObject('bl_iss_rqst_cd',1, 90, '');</script></td>
					<td width="250">&nbsp;</td>
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid (E) -->
			
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print" id="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_exceldown">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_detail" id="btn_detail">발급 신청 명세</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

	</td></tr>
</table>
</form>
</body>
</html>


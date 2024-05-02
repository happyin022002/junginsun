<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_9464.jsp
*@FileTitle : B/L Certificate Request
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2015.04.13 조정민
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9464Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlCertiRqstVO"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%@ page import="java.util.HashMap"%>

<%
	EsmBkg9464Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
//	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
	//String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strUserHomerFileSeparator = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");

	String sXml = null;
//	BlIssRqstVO blissRqst = null;
	
	/*-----------------------------------------------------*/
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id(); 
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();	
		
		String strTemp1 = System.getProperty("user.home");
	    if (strTemp1 != null) {
	    } else {
	    	strTemp1 = "";
	    }
	  	
	    String strTemp2 = System.getProperty("file.separator");
	    if (strTemp2 != null) {
	    } else {
	    	strTemp2 = "";
	    }
	    strUserHomerFileSeparator = strTemp1 + strTemp2;
	   
		event = (EsmBkg9464Event)request.getAttribute("Event");
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
<title>B/L Certificate Request</title>
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
<input type="hidden" name="blNoList">
<input type="hidden" name="seqList">
<input type="hidden" name="divFlg">
<input type="hidden" name="ui_id" value="ESM_BKG_9464">
<input type="hidden" name="selectRow">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=strUserHomerFileSeparator%>">
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
					<td width="90">Request Date</td>
					<td width="230">
					  <input type="text" style="width: 80"  class="input1" name="rqst_from_dt" caption="Request DT" dataformat="ymd" tabindex="1">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width: 80"  class="input1" name="rqst_to_dt" caption="Request DT" dataformat="ymd" tabindex="2">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
					</td>
					<td width="70">Sales Code</td>
					<td width="120"><input type="text" style="width: 100;" style="ime-mode:disabled" dataformat="engupnum" maxlength="5" class="input" name="ob_srep_cd" value="" tabindex="1"></td>
					<td width="60">POL</td>
					<td width="80"><input type="text" style="width: 60;" style="ime-mode:disabled" dataformat="engupnum" maxlength="5" class="input" name="pol_cd" value="" tabindex="2"></td>
					<td width="110">Handling Status</td>
					<td><script language="javascript">ComComboObject('bl_certi_sts_cd',1, 90, '');</script>
					</td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="90">B/L No.</td>
					<td width="130"><input type="text" name="bl_no" style="width:105;" maxlength="13" dataformat="engupnum" class="input" value=""></td> 
					<td width="80">Vessel Name</td>
					<td width="210"><input type="text" style="width: 190;" style="ime-mode:disabled" dataformat="engupnum" class="input" name="vsl_eng_nm" value="" tabindex="3"></td>
					<td width="60">신청업체</td>
					<td width="290"><input type="text" style="width: 280;" class="input" name="co_nm" value="" tabindex="4"></td>
					<td>&nbsp;</td>
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
					<td class="btn1" name="btn_detail" id="btn_detail">Certificate 확인</td>
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


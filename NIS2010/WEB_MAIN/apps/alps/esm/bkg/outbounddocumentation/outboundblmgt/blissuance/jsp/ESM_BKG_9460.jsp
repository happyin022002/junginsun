<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_9460.jsp
*@FileTitle : 3rd Party Billing & Issue Request
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.24
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2014.09.24 조정민
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9460Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssRqstVO"%>

<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%@ page import="java.util.HashMap"%>

<%
	EsmBkg9460Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
//	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
	//String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String ui_id		    = "";
	String bkg_no		    = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");

	String sXml = null;
//	BlIssRqstVO blissRqst = null;
	
	/*-----------------------------------------------------*/
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();	   
	   
		event = (EsmBkg9460Event)request.getAttribute("Event");
        ui_id = JSPUtil.getParameter(request,"ui_id"); 
        bkg_no = JSPUtil.getParameter(request,"bkg_no"); 
        
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
	String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>
<html>
<head>
<title>3rd Party Billing & Issue Request</title>
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



<% if (popMode.equals("Y")) { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="ui_id" value="<%=ui_id%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;3rd Party Billing & Issue Request</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>

<body  onload="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="ui_id" value="<%=ui_id%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr><td valign="top">
	
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	<!--Page Title, Historical (E)-->


<% } %>	
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
					<td width="30">VVD</td>
					<td width="105"><input type="text" style="width: 90;" style="ime-mode:disabled" maxlength="9" dataformat="engupnum" class="input" name="vvd" value="" tabindex="12"></td>
					<td width="70">B/L Type</td>
                    <td width="105"><script language="javascript">ComComboObject('rqst_bl_tp_cd',1, 90, '');</script>
					</td>
					<td width="110">Handling Status</td>
					<td width="100"><script language="javascript">ComComboObject('n3pty_bl_sts_cd',1, 90, '');</script>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Set Search&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name="btn_SRCH_SET" align="absmiddle">&nbsp;<input type="checkbox" value="Y" name="set_slct_flg" class="trans" tabindex="6"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="90">Booking No.</td>
					<td width="125"><input type="text" style="width: 104;" style="ime-mode:disabled" caption="Request No." dataformat="engupnum" maxlength="12" class="input" name="bkg_no" value="<%=bkg_no%>" tabindex="11"></td>
					<td width="105">POL&nbsp;<input type="text" style="width: 60;" style="ime-mode:disabled" dataformat="engupnum" maxlength="5" class="input" name="pol_cd" value="" tabindex="4"></td>
					<td width="30">POD</td>
					<td width="104"><input type="text" style="width: 60;" style="ime-mode:disabled" dataformat="engupnum" maxlength="5" class="input" name="pod_cd" value="" tabindex="4"></td>
					<td width="70">POL Office</td>
					<td width="105"><input type="text" style="width: 60;" style="ime-mode:disabled" class="input" dataformat="engup" maxlength="5" name="pol_ofc_cd" value="" tabindex="12"></td>
					<td width="110">3rd Party Office</td>
					<td width="70"><input type="text" style="width: 60;" style="ime-mode:disabled" dataformat="engupnum" maxlength="5" class="input" name="n3pty_ofc_cd" value="" tabindex="3"></td>
					<td>B/L Issue Office&nbsp;&nbsp;<input type="text" style="width: 60;" style="ime-mode:disabled" dataformat="engupnum" maxlength="5" class="input" name="bl_iss_ofc_cd" value="" tabindex="3"></td>
				</tr>
				</table>	
				<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="90">Shipper Code</td>
					<td width="125"><input type="text" style="width: 104;" style="ime-mode:disabled" maxlength="9" dataformat="engupnum" class="input" name="shpr_cd" value="" tabindex="13"></td>
					<td width="50">S/C No.</td>
					<td width="100"><input type="text" name="sc_no" style="width:85;" class="input" value="" maxlength=10 style="ime-mode:disabled"  dataformat="engupnum" tabindex=38></td>
					<td width="50">RFA No.</td>
					<td><input type="text" name="rfa_no" style="width:85;" class="input" value="" maxlength=11 style="ime-mode:disabled"  dataformat="engupnum" tabindex=38></td>
					
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 0;"> 
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Credit">Credit Confirmation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Excel">Down Excel</td>
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
<% if (popMode.equals("Y")) { %>

      <table class="height_5"><tr><td></td></tr></table>
      <!-- : ( Button : pop ) (S) -->
      <table width="100%" class="sbutton">
        <tr>
          <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
              <tr>
                <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_close">Close</td>
                            <td class="btn1_right"></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!-- : ( Button : pop ) (E) -->

<% } %>

</form>
</body>
</html>


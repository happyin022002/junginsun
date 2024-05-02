<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_9464.jsp
*@FileTitle : Web OB/L Paper Management
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9467Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg9467Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg9467Event)request.getAttribute("Event");
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
<title>Web OB/L Paper Management</title>
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

<body  onload="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_chk_cd" value="">
<input type="hidden" name="roc_div" value="0">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>	
	<!--Page Title, Historical (E)-->
      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="40">Year</td>
                <td width="75"><script language="javascript">ComComboObject('dtrb_yr', 1, 60, 1, 1)</script></td>
				<td width="60">Duration</td>
				<td width="230">
					<input type="text" style="width: 80"  class="input" name="cre_from_dt" caption="Duration" dataformat="ymd" tabindex="1">&nbsp;~&nbsp;<input type="text" style="width: 80"  class="input" name="cre_to_dt" caption="Duration" dataformat="ymd" tabindex="2">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
				</td>
                <td width="40">RHQ</td>
                <td width="85"><input type="text" name="rhq_cd" style="width:60;" maxlength="5" dataformat="engupnum" value="" class="input"></td>
                <td width="45">Office</td>
                <td width="85"><input type="text" name="ofc_cd" style="width:60;" maxlength="6" dataformat="engupnum" value="" class="input"></td>
				<td width="70">Customer</td>
				<td width="26"><input type="text" name="cust_cnt_cd" style="width:25;" maxlength="2" dataformat="engup" value="" class="input"></td>
				<td width="51"><input type="text" name="cust_seq" style="width:50;" maxlength="6" dataformat="int" value="" class="input"></td>
				<td width="91"><input type="text" name="cust_nm" style="width:90;" maxlength="50" dataformat="etc" value="" class="input">
				</td>
				<td>&nbsp;</td>
              </tr>
            </table>
       </table>

	          
        <!-- Tab (S) -->
        <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" >
            <tr>
            	<td width="100%">
                    <script language="javascript">ComTabObject('tab1')</script>
                </td>
            </tr>
        </table>
        <!-- Tab (E) -->
			<table class="search" border="0" id="mainTable">
				<tr>
					<td class="bg">
						
						    <!--TAB Unmatch (S) -->
					    <div id="tabLayer" style="display:inline">
							<table width="100%" id="mainTable">
								<tr>
									<td><script language="javascript">ComSheetObject('sheet1');</script></td>
								</tr>
							</table>
					      <!--biz page (E)-->
					    </div>
					    <!--TAB Unmatch (E) -->
					
					    <!--TAB Match (S) -->
					    <div id="tabLayer" style="display:none">

					      <!-- Grid BG Box  (S) -->
							<table width="100%" id="mainTable">
								<tr>
									<td><script language="javascript">ComSheetObject('sheet2');</script></td>
								</tr>
							</table>
					      <!-- Grid BG Box  (S) -->
					    </div>    
					    <!--TAB Match (E) -->
						
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_add">Row Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_delete">Row Delete</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
							
								</tr></table>
						</td></tr>
						</table>
			    	<!-- Button_Sub (E) -->	
					</td>
				</tr>
			</table>
      <!-- Tab BG Box(E) -->
      <!--biz page (E)-->
      <!-- Grid  (S) -->

      
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
        <tr>
          <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                 <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downExcel">Down&nbsp;Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                  <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_history">History</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!--Button (E) --></td>
  </tr>
</table>
</form>
</body>
</html>


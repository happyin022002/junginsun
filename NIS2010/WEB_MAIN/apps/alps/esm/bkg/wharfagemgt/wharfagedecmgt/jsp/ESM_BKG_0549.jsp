<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0549.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0549Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0549Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0549Event)request.getAttribute("Event");
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
<title>Korea Wharfage - Data Interface</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">

<!-- 개발자 작업	-->
<%
	String vvd  = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String whfPolCd = (request.getParameter("whf_pol_cd") == null)? "":request.getParameter("whf_pol_cd");
	String whfBndCd = (request.getParameter("whf_bnd_cd") == null)? "":request.getParameter("whf_bnd_cd");
	String mrnNo = (request.getParameter("mrn_no") == null)? "":request.getParameter("mrn_no");
%>

<input type="hidden" name="mrn_no" value="<%=mrnNo %>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Wharfage Vessel Information - Data Interface</td>
				</tr>
			</table>
	
	
	
		<!--biz page (S)-->
		<table width="100%" class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:466;"> 
				<tr class="h23">
					<td width="23">VVD</td>
					<td width="140"><input type="text" style="width:80;ime-mode:disabled" class="input1" name="vvd" id= "vvd" value="<%=vvd %>" dataformat="ennum" maxlength="9"></td>
					<td width="30">Port</td>
					<td width="120"><input type="text" style="width:50;" class="input1" name="whf_pol_cd" id="whf_pol_cd" value="<%=whfPolCd %>" dataformat="ennup" maxlength="5"></td> 
					<td width="52">Bound</td>
					<td width=""><select style="width:87;" class="input1" id="whf_bnd_cd" name="whf_bnd_cd">
						<option value="OO" <%= ("OO".equals(whfBndCd) ? "selected=\"selected\"":"") %>>Outbound</option>
						<option value="II" <%= ("II".equals(whfBndCd) ? "selected=\"selected\"":"") %>>Inbound</option>
						</select></td> </tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				<table width="100%" class="search" border="0"> 
				<tr class="h23">
					<td width="33">Total</td>
					<td width="190"><input type="text" style="width:80;text-align:right" class="input2" name="total" readonly="readonly" ></td>
					<td width="30">OK</td>
					<td width="170"><input type="text" style="width:80;text-align:right" class="input2" name="ok" readonly="readonly" ></td> 
					<td width="25">Fail</td>
					<td width=""><input type="text" style="width:80;text-align:right" class="input2" name="fail" readonly="readonly" ></td> </tr>
				</table>
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
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
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
			</tr>
			</table></td>
			<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
			</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
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
<!-- : ( Button : pop ) (E) -->
<!--biz page (E)-->
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0069.jsp
*@FileTitle : CSR Inquiry – CSR Details POP UP 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.10 함대성
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0069Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0069Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String csrNo = StringUtil.xssFilter(request.getParameter("csrNo"));	
	if(csrNo == null){
		csrNo = "";
	}
	
	String gubun = StringUtil.xssFilter(request.getParameter("gubun"));	//slp_iss_dt, eff_dt
	if(gubun == null){
		gubun = "";
	}
	
	String fr_dt = StringUtil.xssFilter(request.getParameter("fr_dt"));
	if(fr_dt == null){
		fr_dt = "";
	}
	
	String to_dt = StringUtil.xssFilter(request.getParameter("to_dt"));
	if(to_dt == null){
		to_dt = "";
	}
	
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0069Event)request.getAttribute("Event");
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
<title>CSR Inquiry – CSR Details POP UP 화면</title>
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
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CSR Inquiry - CSR Details </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:797;"> 
				<tr class="h23">
					<td width="440">
					<table class="search_sm" border="0" style="width:410;">
							<tr class="h23">
								<td width="">&nbsp;<input type="radio" name="gubun" value="slp_iss_dt" class="trans" <%= gubun.equals("slp_iss_dt") ? "checked" : "" %> >&nbsp;&nbsp;품의일&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="gubun" value="eff_dt" class="trans" <%= gubun.equals("eff_dt") ? "checked" : "" %>>&nbsp;&nbsp;EFF, DT&nbsp;&nbsp;&nbsp;<input type="text" style="width:80" value="<%=fr_dt %>" name="fr_dt" class="input1" readOnly>&nbsp;<!-- img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"-->&nbsp;~&nbsp;<input type="text" style="width:80" value="<%=to_dt %>" name="to_dt" class="input1" readOnly>&nbsp;<!--img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"--></td>
							</tr>
							</table></td>
					<td width="44">Team</td>
					<td width="100">
						<input type="text" style="width:60" class="input" name="slp_ofc_cd_sel" value="" readOnly>
						<!-- select style="width:60;" class="input">&nbsp;
						<option value="0" selected>ALL</option>
						<option value="1">SELADG</option>
						<option value="2">SINRSG</option>
						<option value="2">HAMURG</option>
						<option value="2">NYCRAG</option>
						</select -->
					</td>
					<td width="55">CSR NO.</td>
					<td width=""><input type="text" style="width:170" class="input" name="csr_no" value="<%=csrNo %>" readOnly></td>
				</tr> 
				</table>
			
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
				
			<table class="height_10"><tr><td></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
				<!-- : ( Grid ) (S) -->
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
				<!-- : ( Grid ) (E) -->	
			<!-- Grid  (S) -->
			
			<!-- Grid (E) -->

			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table class="height_5"><tr><td></td></tr></table>
    <!--Button (E) -->
	</td></tr>
</table>


	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
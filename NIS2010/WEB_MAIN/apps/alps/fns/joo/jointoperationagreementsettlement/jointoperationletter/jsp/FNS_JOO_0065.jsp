<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0065.jsp
*@FileTitle : MCS & Invoice Letter Fax/E-mail Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.07 장강철
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0065Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0065Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationLetter");
	String yyyyMM = JSPUtil.getKST("yyyy-MM-dd");	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (FnsJoo0065Event)request.getAttribute("Event");
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
<title>MCS & Invoice Letter Fax/E-mail Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
 
    var strOfc_cd = "<%=strOfc_cd%>";
    var yyyyMMfr  = "<%=yyyyMM%>";
    var yyyyMMto  = "<%=yyyyMM%>";
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id %>">

 

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
 
 	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!--Page Title, Historical (E)-->
		
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="45">Office</td>
				<td width="130"><input type="text" style="width:80" name='ofc_cd' required readonly  maxlength=10  style="ime-mode:disabled"  class="input2"  >
				<!-- <select style="width:80;" name="ofc_cd" class="input">
						<option value="">All</option>				
						<option value="SELADG" selected>SELADG</option>
						<option value="SINRSS">SINRSS</option>
						<option value="SINWSG">HAMTG(없음)</option>
						</select>--></td>
					<td width="55">User ID</td>
					<td width="130"><input type="text" style="width:80" name='cre_usr_id'  maxlength=10  style="ime-mode:disabled"  class="input" value="<%=strUsr_id %>"></td>
					<td width="45">Period</td>
					<td width=""><input type="text" style="width:80" class="input" name='ltr_iss_dt_fr' value="<%=yyyyMM %>"  style="ime-mode:disabled" dataformat='ymd' maxlength='8' required cofield="ltr_iss_dt_to">&nbsp;~&nbsp;<input type="text" style="width:80" class="input"  name='ltr_iss_dt_to'   style="ime-mode:disabled" required dataformat='ymd' maxlength='8'  cofield="ltr_iss_dt_fr"  value="<%=yyyyMM %>">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name='btns_calendar'  id='btns_calendar'  width="19" height="19" border="0" align="absmiddle"></td>
					</tr> 
				</table>

				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
		
 
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable" style='display:none' >
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="140">Success E-mail Count</td>
				<td width="120"><input type="text" style="width:80;text-align=right" name='cnt_eml_snd_no' readonly class="input1" value=""></td>
				<td width="120">Success Fax Count</td>
				<td width="120"><input type="text" style="width:80;text-align=right" name='cnt_jo_cntc_fax_no_ctnt' readonly class="input1" value=""></td>
				<td width="80">Total Count</td> 
				<td width=""><input type="text" style="width:80;text-align=right" name='tot_cnt' class="input1" readonly value=""></td>
				</tr>
			</table>
				<!--  biz_1   (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
			
		</td></tr>
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
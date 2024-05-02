<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0075.jsp
*@FileTitle : Bank detail & Signature
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.29 장강철
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0075Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0075Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (FnsJoo0075Event)request.getAttribute("Event");
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
<title>Bank detail & Signature</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="strOfc_cd" value ="<%=strOfc_cd %>">
<input type="hidden" name="str_usr_id" value ="<%=strUsr_id %>">

<input type="hidden" name="jo_ltr_tp_cd"     value ="B">
<input type="hidden" name="ofc_addr"         value ="X">
<input type="hidden" name="jo_ltr_tmplt_seq" value ="">
	
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!--Page Title, Historical (E)-->	
 	<table class="search"> 
       	<tr><td class="bg">
			<table width="100%" class="search">
			<tr class="h23">
				<td width="50">&nbsp;Office</td>
				<!-- <td width="130"><input type="text" style="width:60" class="input2" readonly name="ofc_cd" value ="<%=strOfc_cd %>" ></td>-->
                <td width="130"><script language="javascript">ComComboObject('ofc_cd', 1, 80, 0, 1);</script></td>				
			
				<td width="120">Creation User NM</td>
				<td width="130"><script language="javascript">ComComboObject('usr_id', 2, 100, 0, 1);</script></td>
				<td width="40">Seq.</td>
				<td width=""><script language="javascript">ComComboObject('jo_tmplt_no',1,40,0, 1);</script></td>
			</tr>
			</table>
			
			<table class="height_10"><tr><td></td></tr></table>
			
			<table width="100%" class="grid2">
			<tr>
				<td width="70" class="tr2_head">Signature</td>
				<td width=""><textarea style="width:100%;height:80;" name='sig_stmt_ctnt' class="textarea1_1"  ></textarea></td>
			</tr>
			</table>
			
			<table class="height_10"><tr><td></td></tr></table>
			
			<table width="100%" class="grid2">
			<tr>
				<td width="70" class="tr2_head">Bank<br>Details</td>
				<td width=""><textarea style="width:100%;height:80;"  name='bank_stmt_ctnt'  class="textarea1_1"  ></textarea></td>
			</tr>
			</table>
		</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table>
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>	
         <td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id='btn_Retrieve'>Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_copy">Copy</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_1" name="btn_delete" id="btn_delete">Delete</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23"><td style="padding-left:2">
					<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 		
				</td></tr> 
			</table>	
	</td></tr>
</table>
<table  ><tr height=260><td></td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
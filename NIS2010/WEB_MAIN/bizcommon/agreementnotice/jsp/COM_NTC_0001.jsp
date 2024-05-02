<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_NTC_0001.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.28
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2014.01.28 서미진
* 1.0 Creation
=========================================================
* History
=========================================================*/
%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.agreementnotice.event.ComNtc0001Event"%>
<%@ page import="com.hanjin.bizcommon.agreementnotice.util.AgreementNoticeUtil"%>
<%
	ComNtc0001Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.bizcommon.BizCommonSC.AgreementNoticeBC"); 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (ComNtc0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	int usr_max_knt = 0;
	String str_usr_max_knt = new AgreementNoticeUtil().searchUsrMaxKnt(); //여기서 UTIL로 user max knt값을 받아온다.
	usr_max_knt = str_usr_max_knt!=null&&!str_usr_max_knt.trim().equals("")?Integer.parseInt(JSPUtil.getNull(str_usr_max_knt)):0;

%>
<html>
<head>
<title>Agreement Notice User Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var usr_max_knt = "<%=usr_max_knt%>";
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
<input type="hidden" name="usr_max_knt" value="<%=usr_max_knt%>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_down_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<!--biz page (S)-->
<table class="search"> 
    <tr><td class="bg">

	<!--  biz_1  (S) -->
	<table class="Search" border="0" style="width:979;"> 
	<tr class="h23">
		<td width="70">System</td>
		<td width="250"><script language="javascript">ComComboObject('sys_cd', 1, 230, 0, 1, 2);</script></td>
		<td width="90">Office Level</td>
		<td width=""><script language="javascript">ComComboObject('ofc_tp_cd', 1, 80, 1, 0);</script></td>			
	</tr>
	</table>
	<!--  biz_1  (E) -->	     
	 
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
					  	
	<!-- Grid  (S) -->
	<table width="979"  id="mainTable">
		<tr><td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
		</td></tr>
	</table>
	<!-- Grid (E) -->

	<!--  Button_Sub (S) -->
	<table width="979" class="button">
      	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>										
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_rowadd">Row Add</td>
			<td class="btn2_right"></td>
			</tr></table></td>	
			
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_rowdelete">Row Delete</td>
			<td class="btn2_right"></td>
			</tr></table></td>																				
		</tr>
		</table>
	</td></tr>
  	</table>
  	<!-- Button_Sub (E) -->

	</td></tr>
</table>
<!--biz page (E)-->	
    <table class="height_8"><tr><td></td></tr></table>    	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
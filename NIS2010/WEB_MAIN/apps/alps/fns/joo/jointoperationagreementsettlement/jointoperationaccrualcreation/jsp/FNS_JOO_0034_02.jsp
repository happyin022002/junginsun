<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0034_02.jsp
*@FileTitle : Estimate Code Check - VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.06 장강철
* 1.0 Creation
* -------------------------------------------------------
* 2012.04.02 조병연[CHM-201217059-01]
* Title : [ALPS JOO] Estimate VVD Code Check - Current Estimate Cost 0 조회 기능 추가
* 내용 :
* Estimate Cost가 0인 경우의 조회 조건이 추가, 해당 쿼리를 생성. 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo003402Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo003402Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationAccrualCreation");
	String yyyyMM = JSPUtil.getKST("yyyy-MM");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo003402Event)request.getAttribute("Event");
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
<title>Estimate Code Check - VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var yyyyMM = "<%=yyyyMM%>";
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
<!-- 개발자 작업	-->

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
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="110">Estimated Period</td>
					<td width="160"><input type="text" style="width:60" required fullfill  caption="Estimated Period"  style="ime-mode:disabled" dataformat='ym' maxlength='6' value="<%=yyyyMM %>" name='exe_yrmon' class="input1"  >&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20"  name='btns_back' border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" name='btns_next' height="20" border="0" align="absmiddle"></td>
                    <td width="30">VVD</td>
                    <td width="380" class="noinput1">&nbsp;<input type="radio"  value="curr" name='yrmon_type'  class="trans" checked>&nbsp;&nbsp;Current&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="curr_estm" name='yrmon_type' class="trans"  >&nbsp;&nbsp;Current Estimate Cost '0'&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="prev" name='yrmon_type' class="trans"  >&nbsp;&nbsp;Previous</td>
                    <td width=""></td>
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
			<table width="100%" class="search"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet');</script>
					</td>
				</tr>
			</table> 
			
			<!-- Grid (E) -->
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
					<td class="btn1" name="btn_retrive">Retrieve</td>
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
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
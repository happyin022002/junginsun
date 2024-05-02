<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0080.jsp
*@FileTitle : Combined Data Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.15 박희동
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0080Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0080Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");

	String yyyyMM = JSPUtil.getKST("yyyy-MM");
	String ofcList = "";
	String ofcCd  = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0080Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		ofcList = eventResponse.getETCData("ofc_list");
		ofcCd   = eventResponse.getETCData("ofc_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Combined Data Inquery</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gOfcCd = "<%=ofcCd%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=ofcList%>");
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
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
		<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="100">&nbsp;Account Date</td>
				<td width="320"><input type="text" style="width:70" class="input1" value="<%=yyyyMM%>" name="fr_dt" dataformat='ym' maxlength="6" >&nbsp;<img class="cursor" name="btn_fr_back" src="img/btns_back.gif" width="18" height="19" border="0" align="absmiddle">&nbsp;<img class="cursor" name="btn_fr_next" src="img/btns_next.gif" width="18" height="19" border="0" align="absmiddle">
				~&nbsp;<input type="text" style="width:70" class="input1" value="<%=yyyyMM%>" name="to_dt" dataformat='ym' maxlength="6" >&nbsp;<img class="cursor" name="btn_to_back" src="img/btns_back.gif" width="18" height="19" border="0" align="absmiddle">&nbsp;<img class="cursor"  name="btn_to_next" src="img/btns_next.gif" width="18" height="19" border="0" align="absmiddle"></td>
				<td width="40">Office</td>
				<td width=""><script language="javascript">ComComboObject('slp_ofc_cd',2,80,0,1);</script></td>
					
				</tr>
			</table>
			<table class="height_2"><tr><td colspan="8"></td></tr></table>	
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
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve" auth="C">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new" auth="R">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td class="btn1_line"></td>
			<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel" id="btn_downexcel" auth="R">Down Excel</td>
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
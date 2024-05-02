<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0049.jsp
*@FileTitle : Settlement Status for Basic Allocation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.10 장강철
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0049Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0049Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String yyyyMM = JSPUtil.getKST("yyyy-MM");
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.CarrierSettlementProcess");
	String offList = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0049Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		offList    = eventResponse.getETCData("office");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Settlement Status for Basic Allocation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var gOffList    = "<%=offList%>";
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
				<td width="40">Trade</td>
				<td width="130"><script language="javascript">ComComboObject('trd_cd',1,80,0,1);</script></td>
				<td width="35">Lane</td>
				<td width="140"><script language="javascript">ComComboObject('rlane_cd',1,80,0,0);</script></td>
				<td width="50">Period</td>
				<td width="300"><input type="text" style="width:60" class="input"  dataformat='ym'  maxlength='6' value="<%=yyyyMM %>" caption='Period From Month'   fullfill name='acct_yrmon_fr'  cofield="acct_yrmon_to">&nbsp;<img class="cursor" src="img/btns_back.gif" name='btn_acct_yrmon_fr_back' width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif"  name='btn_acct_yrmon_fr_next' width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:60" class="input"     fullfill maxlength='6'  caption='Period To Month'  value="<%=yyyyMM %>" dataformat='ym' name='acct_yrmon_to'  cofield="acct_yrmon_fr">&nbsp;<img class="cursor" src="img/btns_back.gif"  name='btn_acct_yrmon_to_back'  width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif"  name='btn_acct_yrmon_to_next' width="19" height="20" border="0" align="absmiddle"></td>
				<td width="45">Office</td>
				<td width=""><script language="javascript">ComComboObject('ofc_cd', 1, 80, 1, 0,0 );</script></td>
<!-- 2010.03.25 화면 수정 박효숙 차장
				<td width="">
					<table class="search_sm" border="0" style="width:100%;">
					<tr class="h23">
						<td width="65">Rev./Exp.</td>
						<td width="" class="noinput1">&nbsp;<input type="radio"  value="R" name='reopt'  class="trans" checked>&nbsp;&nbsp;Revenue&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="E" name='reopt' class="trans"  >&nbsp;&nbsp;Expense</td>								
					</tr>
					</table>
			    </td>
-->							
				</tr> 
				</table>
				
				<!--  biz_1   (E) -->
				
			</td>
		</tr>
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
			<!-- Grid (E) -->
			
			</td>
		</tr>
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
<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0033.jsp
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.20 김종옥
* 1.0 Creation
=========================================================
* History
* 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopOpf0033Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rso              = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChangeOfDestinationMgt.ChangeOfDestinationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf0033Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		rso = eventResponse.getETCData("rso");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>COD Approve Main Screen</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=rso%>');
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
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="80">RSO</td>
				<td width="120">
					<script language="javascript">ComComboObject('rso', 2, 75, 1, 1);</script>
				</td>
				
				<td width="70">VVD</td>
				<td width="180">
					<input name="vsl_cd" required fullfill type="text" style="width:40;" class="input" value="" caption="Vessel Code" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input name="skd_voy_no" required fullfill type="text" style="width:40;" class="input" value="" caption="Schedule Voyage Number" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input name="skd_dir_cd" required fullfill type="text" style="width:20;" class="input" value="" caption="Schedule Direction Code" maxlength="1" dataformat="engup" style="ime-mode:disabled">&nbsp;<img name="btn_VVDpop" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
				</td>
				<td width="50">BKG No.</td>
				<td width="130">
					<input name="bkg_no" type="text" style="width:100;" class="input" value="" caption="Booking Number" maxlength="13" dataformat="engup" style="ime-mode:disabled">
				</td> 
				<!-- <td width="96">COD Condition</td>
				<td width="">
					<script language="javascript">ComComboObject('cod', 1, 100, 1);</script>
				</td>  -->
				<td width="80">Result</td>
				<td width="">
					<script language="javascript">ComComboObject('cod_sts_cd', 2, 200, 1);</script>
				</td>
			</tr>
			<tr class="h23">
				<td width="80">Lane</td>
				<td width="120"><input type="text" name="slan_cd" caption="Lane Code" style="width:55;ime-mode:disabled;" class="input" maxlength="3" dataformat="engup" fullfill>&nbsp;<img src="img/btns_search.gif" name="btn_slan_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="70">Reason</td>
				<td width="180">
					<script language="javascript">ComComboObject('cod_rqst_rsn_cd', 2, 100, 1);</script>
				</td>
				<td title="Requested date" width="60">&nbsp;Period</td>
				<td title="Requested date" width="210"><input type="text" name="fr_dt" style="width:80; text-align:center;" class="input" dataformat="ymd" maxlength="8" caption="the from date">&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:80; text-align:center;" class="input" dataformat="ymd" maxlength="8" caption="the to date">&nbsp;<img src="img/btns_calendar.gif" id="btns_period" name="btns_period" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>					
				
			</tr>
			</table>	
		</td></tr>
	</table>		
			
   <table class="height_8"><tr><td></td></tr></table>	
	<!-- Tab (S) -->
	<!-- Tab (E) -->
	<table class="search"> 
    <tr><td class="bg" style="height:454" valign="top">
		<!-- biz_1  (S) -->
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) --> 
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->
	
	<!-- TAB [ Gang Structure ] (E) -->
	<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
	</div>
	<!-- TAB [ Gang Structure ] (E) -->		
	
	<!--Button (S) -->
		<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Detail">Detail</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_History">History</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>			
				</tr>
				</table>
			</td></tr>
			</table>
			<!-- Button (E) -->
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
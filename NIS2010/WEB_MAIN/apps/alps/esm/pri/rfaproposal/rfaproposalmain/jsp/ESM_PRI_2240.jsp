<%
/*=========================================================
*Copyright(c) 2016 CyberLogitecs
*@FileName : ESM_PRI_2240.jsp
*@FileTitle : Master RFA Proposal & Amendment [Amend]
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2040Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%

	String rfaNo  = StringUtil.xssFilter(request.getParameter("sRfaNo"));
	String amdtSeq = StringUtil.xssFilter(request.getParameter("sAmdtSeq"));
	String propNo = StringUtil.xssFilter(request.getParameter("sPropNo"));
	String sDurDt = StringUtil.xssFilter(request.getParameter("sSdurDt"));
	String eDurDt = StringUtil.xssFilter(request.getParameter("sEdurDt"));
	String effDt = StringUtil.xssFilter(request.getParameter("sEffDt"));
	String nowEffDt = StringUtil.xssFilter(request.getParameter("nowEffDt")); // 현재 Amd 의 EFF Date

	String nwDur= "";
	EsmPri2040Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri2040Event)request.getAttribute("Event");
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
<title>Amendment Request</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sDurDt" value="<%=sDurDt%>">
<input type="hidden" name="eDurDt" value="<%=eDurDt%>">
<input type="hidden" name="new_dur" value="<%=nwDur%>">
<input type="hidden" name="rfa_ctrt_tp_cd" value="M">
<input type="hidden" name="prop_no" value="<%=propNo %>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq %>">
<input type="hidden" name="eff_dt">

<input type="hidden" name="pos_eff_dt" value="<%=effDt %>">
<input type="hidden" name="pos_exp_dt" value="<%=eDurDt %>">

<input type="hidden" id = "new_ctrt_eff_dt" name="ctrt_eff_dt" value="<%=sDurDt %>">

<input type="hidden" name ="now_eff_dt" value="<%= nowEffDt%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Proposal Creation [Amend]</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search" border="0"> 
       		<tr><td class="bg">
				
				<table border="0" style="width:100%;" > 
				<tr class="h23">
						<td width="75">RFA No.</td>
						<td width="170"><input type="text" style="width:158;text-align:center;" class="input2" name="rfa_no" value="<%=rfaNo %>" readonly="readonly"></td>
						<td width="70">AMD No.</td>
						<td width=""><input type="text" style="width:40;text-align:center;" class="input2" name="next_amdt_seq" value="<%=Integer.parseInt(amdtSeq)+1 %>" readonly="readonly"></td>			
				</tr>
				<tr class="h23">
						<td>Duration</td>
						<td>
							<input type="text" style="width:70;text-align:center;" class="input2" name="sdur_dt" value="<%=sDurDt %>" maxlength="10" dataformat="ymd" readonly=true>&nbsp;~&nbsp;<input type="text" style="width:70;text-align:center;" class="input1" name="exp_dt" value="<%=eDurDt %>" maxlength="10" dataformat="ymd"  id="new_ctrt_exp_dt">
						</td>
						<td>
							<table><tr><td><img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1" id="btn_cal"></td></tr></table>
						</td>
						<td></td>
				</tr>
				</table>
				
				<!-- Grid  (S) -->
				<table width="440"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
		</table></td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
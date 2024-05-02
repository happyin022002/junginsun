<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2040.jsp
*@FileTitle : RFA Proposal Creation[Amend]
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 이은섭
*@LastVersion : 1.1
* 2009.05.13 변영주
* 1.0 Creation
* 1.1 Modify - 구주 Hinterland 프로젝트로 인한 변경
=========================================================
* History
* 2013.12.20 서미진 [선처리 CSR] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
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
<input type="hidden" name="rfa_ctrt_tp_cd" value="<%=JSPUtil.getParameter(request, "sRfaCtrtTpCd") %>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
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
						<td width="90">RFA No.</td>
						<td width="140"><input type="text" style="width:106;text-align:center;" class="input2" name="rfa_no" value="<%=rfaNo %>"></td>
						<td width="60">AMD No.</td>
						<td width="78"><input type="text" style="width:40;text-align:center;" class="input2" name="amdt_seq" value="<%=amdtSeq%>"></td>			
						<td width="90">Proposal No.</td>
						<td width=""><input type="text" style="width:100;text-align:center;" class="input2" name="prop_no" value="<%=propNo %>"></td>
				</tr>
						
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				
				<table border="0" style="width:100%;" > 
				<tr class="h23">
						<td width="90">Duration</td>
						<td width="280">
							<input type="text" style="width:80;text-align:center;" class="input2" name="sdur_dt" value="<%=sDurDt %>" maxlength="10" dataformat="ymd" readonly=true>&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input2" name="edur_dt" value="<%=eDurDt %>" maxlength="10" dataformat="ymd" readonly=true></td>
						
						<td width="90" ><span id="new_du">New Duration</span></td>
						<td width="" id="new_ctrt_dt">
							<input type="text" id = "new_ctrt_eff_dt" style="width:80;text-align:center;" class="input2" name="ctrt_eff_dt" value="<%=sDurDt %>" maxlength="10" dataformat="ymd" readonly=true>&nbsp;<span id="new_dt">~</span>&nbsp;
							<input type="text" id = "new_ctrt_exp_dt" style="width:80;text-align:center;" class="input1" name="exp_dt"  value="<%=eDurDt %>" maxlength="10" dataformat="ymd"  tabindex=1>&nbsp;</td>
							<td>
							<table><tr><td><img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1" id="btn_cal"></td></tr></table></td>
				</tr>
				<tr class="h23">
						<td width="">Possible EFF</td>
						<td width=""><input type="text" style="width:80;text-align:center;" class="input2" name="pos_eff_dt" value="<%=effDt %>" maxlength="10" dataformat="ymd" readonly=true>&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input2" name="pos_exp_dt" value="<%=eDurDt %>" maxlength="10" dataformat="ymd" readonly=true></td>
						
						<td width="">AMD EFF</td>
						<td width=""><input type="text" style="width:80;text-align:center;" class="input1" name="eff_dt" value="" maxlength="10" dataformat="ymd" tabindex=2>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
				</tr>		
				</table>
				
			
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
				<!-- Grid  (S) -->
				<table width="640"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
	
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
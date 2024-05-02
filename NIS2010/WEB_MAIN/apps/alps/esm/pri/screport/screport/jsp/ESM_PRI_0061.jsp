<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0061.jsp
*@FileTitle : S/C Retrieval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.30 변영주
* 1.0 Creation
=========================================================
* 2011.04.20 김민아 [CHM-201110238-01] SC Inquiry -> SC List Inquiry 에서 Print 기능 추가 요청 - Radio Button 추가하여 expire 된 Scope 은 출력이 되지 않는 기능 추가
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0061Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmPri0061Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_srep      = "";
	String strProp_no 		= "";
	String strAmdt_seq 		= "";
	String sSpScrnEvntPgmCd = ""; //ADD
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_srep = account.getSrep_cd();
		strProp_no 	= StringUtil.xssFilter(request.getParameter("prop_no"));
		strAmdt_seq 	= StringUtil.xssFilter(request.getParameter("amdt_seq"));
		sSpScrnEvntPgmCd	  = StringUtil.xssFilter(request.getParameter("sp_scrn_evnt_pgm_cd"));	//ADD
		event = (EsmPri0061Event)request.getAttribute("Event");
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
<title>S/C Retrieval</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<input type="hidden" name="prop_no" value="<%=strProp_no%>">
<input type="hidden" name="amdt_seq" value="<%=strAmdt_seq %>">
<input type="hidden" name="hd_scp_tp_cd" value="A">
<input type="hidden" name="pagerows">
<!-- [CHM-201537788] SC 다운로드 보안 강화_2차 개발 start -->
<input type="hidden" name="prnt_scrn_evnt_seq" value="">
<input type="hidden" name="sp_prn_evnt_tp_cd" value="" >
<input type="hidden" name="sp_scrn_evnt_pgm_cd" value="<%=sSpScrnEvntPgmCd%>">
<!-- [CHM-201537788] SC 다운로드 보안 강화_2차 개발 end -->
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Print </td></tr>
        </table>
        <!-- : ( Title ) (E) -->

	<!--Page Title, Historical (E)-->
	<!-- Hidden sheet for Transaction (S) -->
	<script language="javascript">ComSheetObject('sheet1');</script>
	<!-- Hidden sheet for Transaction (E) -->		
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="55">S/C No.</td>
					<td width="130"><input type="text" style="width:110;" name="sc_no" readonly=true class="input2"></td>
					<td width="60">AMD No.</td>
					<td width="70"><input type="text" style="width:40;" name="amd_seq" readonly=true class="input2"></td> 
					<td width="120">S/C Effective Date</td>
					<td width="200"><input type="text" caption="Duration" name="ctrt_eff_dt" dataformat="ymd" style="width:80;" readonly=true class="input2" >&nbsp;~&nbsp;
												  <input type="text" caption="Duration" name="ctrt_exp_dt" dataformat="ymd" style="width:80;" readonly=true class="input2" ></td>
					<td width="100">Contract Office</td>
					<td width="70"><input type="text" style="width:45;" name="prop_ofc_cd"  readonly=true class="input2"></td>
					<td width="100">Customer Type</td>
					<td width=""><input type="text" style="width:25;" name="prc_ctrt_cust_tp_cd" readonly=true class="input2"></td>
					<tr class="h23">
					<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_search">Search</td>
						<td class="btn1_right">
					</tr></table></td>
					<td colspan="9"><table border="0" style="width:500;" class="search_sm1">
						<tr class="h23">
							<td class="stm" width="">
								<input type="radio" class="trans" name="scp_tp_cd" value="A" onClick="scp_tp_cd_OnChange(this);" checked>&nbsp;
								All contents including expired data&nbsp;
								<input type="radio" class="trans" name="scp_tp_cd" value="E" onClick="scp_tp_cd_OnChange(this);">&nbsp;
								Effective contents only(New Function)
						</tr>
					</table></td>
					</tr>
				
				</table>
				<!--  biz_1   (E) -->
			</td>
		</tr>
	</table>
	
	<table class="height_8"><tr><td></td></tr></table>
		
		
	<table class="search"> 
       	<tr><td class="bg">		
				<!-- Grid  (S) -->
					<table width="100%" height="550" class="grid"> 
						<tr class="tr_head">
							<td width="100%"><script language="javascript">comRdObject('report1');</script></td>
						</tr>		
					</table> 
				<!-- Grid (E) -->
				</td></tr>
			</table>
	
	<!--biz page (E)-->
</td></tr>
</table>
<table class="height_5"><tr><td></td></tr></table>
    	<!--Button (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_saveas">Save As</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
			</table>
		</td></tr>
		</table>
		
    <!--Button (E) -->
</td></tr>
</table>
<SCRIPT LANGUAGE=JavaScript FOR=report1 EVENT="ReportFinished();">
	ReportFinished();
</SCRIPT>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
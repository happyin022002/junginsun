<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0079.jsp
*@FileTitle : S_C Print View
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.08.10 변영주
* 1.0 Creation
=========================================================
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
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0079Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmPri0079Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_srep      = "";	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String sParam			= "";
	
	String sSpScrnEvntPgmCd = ""; 
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_srep = account.getSrep_cd();		
		sParam	  = StringUtil.xssFilter(request.getParameter("sParam"));	
		sSpScrnEvntPgmCd	  = StringUtil.xssFilter(request.getParameter("sp_scrn_evnt_pgm_cd"));	
		event = (EsmPri0079Event)request.getAttribute("Event");
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
<title>S/C Print View</title>
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
<input type="hidden" name="sParam" value="<%=sParam%>">
<!-- [CHM-201537788] SC 다운로드 보안 강화_2차 개발 start -->
<input type="hidden" name="prnt_scrn_evnt_seq" value="">
<input type="hidden" name="sp_prn_evnt_tp_cd" value="" >
<input type="hidden" name="sp_scrn_evnt_pgm_cd" value="<%=sSpScrnEvntPgmCd%>">
<!-- [CHM-201537788] SC 다운로드 보안 강화_2차 개발 end -->
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Print </td></tr>
        </table>
        <!-- : ( Title ) (E) -->


	<!-- Hidden sheet for Transaction (S) -->
	<script language="javascript">ComSheetObject('sheet1');</script>
	<!-- Hidden sheet for Transaction (E) -->		

		<!--biz page (S)-->
		<table class="search" id="mainTable">
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="30">Seq.</td>
					<td width="50"><input type="text" style="width:30;" readonly=true name="sc_seq" class="input2"></td>
					<td width="50">S/C No.</td>
					<td width="135"><input type="text" style="width:90;" readonly=true name="sc_no" class="input2"></td>
					<td width="55">AMD No.</td>
					<td width="60"><input type="text" style="width:40;" readonly=true name="amdt_seq" class="input2"></td>
					<td width="80">Proposal No.</td>
					<td width="110"><input type="text" style="width:80;" readonly=true name="prop_no" class="input2"></td>
					<td width="55">Duration</td>
					<td width="200"><input type="text" style="width:80;" readonly=true name="ctrt_eff_dt" class="input2">&nbsp;~&nbsp;<input type="text" style="width:80;" readonly=true name="ctrt_exp_dt" class="input2"></td>
					<td width="65">Filed Date</td>
					<td width=""><input type="text" style="width:75;" readonly=true name="prop_file_dt" class="input2"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="90">Request Office</td>
					<td width="70"><input type="text" style="width:50;" readonly=true name="prop_ofc_cd" class="input2"></td>
					<td width="65">Sales Rep.</td>
					<td width="155"><script language="javascript">ComComboObject('prop_srep_cd', 1, 63, 0, 1, 0, false);</script>
								&nbsp;<input type="text" style="width:70;" name="prop_srep_nm" readonly=true class="input2"></td>
					<td width="100">Approval Office</td>
					<td width="90"><input type="text" style="width:60;" readonly=true name="apro_ofc_cd" class="input2"></td>
					<td width="55">Auth by</td>
					<td width="178"><input type="text" style="width:80;" readonly=true name="apro_usr_nm" class="input2"></td>
					<td width="87">Creation Date</td>
					<td width=""><input type="text" style="width:75;" readonly=true name="prop_cre_dt" class="input2"></td>
				</tr>
				</table>

				<table class="search" width="462" border="0" >
				<tr>
				<td>
					<table class="search_sm2" border="0" style="width:362;">
					<tr class="h23">
						<td width="100">Print Option</td>
						<td width="" class="stm"><input type="checkbox" name="blpl_flg" class="trans" >&nbsp;Boiler Plate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="sign_flg" class="trans" checked>&nbsp;Signature Page</td>
					</tr>
					</table>	
				</td>
				<td>
					<table>
					<tr class="h23">
					<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_search">Search</td>
						<td class="btn1_right">
					</tr></table></td>
					</tr>						
					
					</table>
				</td>
				</tr>
				</table>

				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td></td></tr></table>



			<!--  biz_1  (S) -->
			<table width="100%" height="485" class="grid">
				<tr class="h23">
					<td><script language="javascript">comRdObject('report1');</script></td>
				</tr>
			</table>
			<!--  biz_1   (E) -->
			<table class="height_5"><tr><td></td></tr></table>

			<table border="0" style="width:100%;" class="search">
				<tr class="h23">
					<td width="350"></td>
					<td width="90"><img src="img/btns_back_1.gif" width="18" height="19" alt="" border="0" name="btns_back1" class="cursor">&nbsp;<img src="img/btns_back.gif" width="18" height="19" alt="" border="0" name="btns_back2" class="cursor">&nbsp;<img src="img/btns_next.gif" width="18" height="19" alt="" border="0" name="btns_next1" class="cursor">&nbsp;<img src="img/btns_next_1.gif" width="18" height="19" alt="" border="0" name="btns_next2" class="cursor"></td>
					<td><script language="javascript">ComComboObject('sc_no_list', 1, 120, 1, 1, 0, false);</script></td>
				</tr>
			</table>
			</td></tr>
		</table>
		<!--biz page (E)-->

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
    	<!--Button (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
		</table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
<SCRIPT LANGUAGE=JavaScript FOR=report1 EVENT="ReportFinished();">
	ReportFinished();
</SCRIPT>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
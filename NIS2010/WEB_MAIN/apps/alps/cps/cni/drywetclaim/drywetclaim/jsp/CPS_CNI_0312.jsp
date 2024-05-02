<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0312.jsp
 *@FileTitle : [CPS_CNI_0312] Transfer
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0312Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0312Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0;

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
	String schFromDate = "";
	String schToDate = "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.drywetclaim.DryWetClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	SignOnUserAccount account = null;

    try
    {

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0312Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		schFromDate = eventResponse.getETCData("schFromDate");
		schToDate = eventResponse.getETCData("schToDate");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }

    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
%>


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>

<html>
<head>
<title>Incident-Inquiry</title>
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
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
</head>

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="page_no" value="1">

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">

<!--RD 를 위한변수-->
<input type="hidden" name="sch_date_div_chk" value="">
<input type="hidden" name="sch_trns_auth_cd_chk" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
<td valign="top">

    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->

		<!--biz page (S)-->

<table class="search" id="mainTable">
    <tr><td class="bg">
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="47" title="Handling Office">&nbsp;&nbsp;HOFC</td>
				<td width="170"><input type="text" name="sch_ofc_cd" style="width:100;text-align:center" value="<%=userOffice%>" class="input" caption="HOFC" ></td>
				<td width="55">Handler</td>
				<td width="140"><input type="text" name="sch_usr_id" style="width:100;text-align:center" value="<%=userId%>" class="input"  caption="Handler" ></td>
				<td>
				<table class="search_sm2" border="0" style="width:;">
					<tr class="h23">
					<td><input type="radio" name="sch_date_div" value="T" class="trans" checked>&nbsp;Transferred&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_date_div" value="P" class="trans">&nbsp;Processed</td>
					<td><input type="text" name="sch_date_from" style="width:80;text-align:center" value="<%=schFromDate%>" dataformat="ymd" maxlength="8" class="input1" required caption="From Date">&nbsp;<img src="img/btns_calendar.gif" name="btns_date_cal1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;<input type="text" name="sch_date_to" style="width:80;text-align:center" value="<%=schToDate%>" dataformat="ymd" maxlength="8" class="input1" required caption="To Date">&nbsp;<img src="img/btns_calendar.gif" name="btns_date_cal2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
				</table>
				</td>
			</tr>
			</table>
			<table class="search_sm2" border="0" style="width:400;">
					<tr class="h23">
					<td>Status</td>
					<td class="stm"><input type="radio" name="sch_trns_auth_cd" value="W" class="trans" checked>&nbsp;Waiting&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_trns_auth_cd" value="A" class="trans">&nbsp;Accepted&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_trns_auth_cd" value="R" class="trans">&nbsp;Rejected&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_trns_auth_cd" value="" class="trans">&nbsp;All </td>
				</tr>
				</table>
		<table class="height_5"><tr><td></td></tr></table>

						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
						<!-- Grid  (E) -->




		<!--biz page (E)-->

			</td></tr>
		</table>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Down_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->



    <!--biz page (E)-->

</td>
</tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

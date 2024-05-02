<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0031.jsp
 *@FileTitle : [CPS_CNI_0031] Incident-Inquiry
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0031Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryCondVO"%>
<%
	CpsCni0031Event event = null;
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
	String userCgoClmNo = "";//session claimNo 변수
	String reqCgoClmInciNo = "";
	String schFromStrGmt = "";
	String schToStrGmt = "";//조회조건의 to날짜(GMT)

    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);

	IncidentInquiryCondVO condVO= null;
	SignOnUserAccount account = null;

    try
    {

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0031Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		reqCgoClmInciNo  = JSPUtil.getParameter(request, "cgo_clm_inci_no","");

		schFromStrGmt = eventResponse.getETCData("schToStr").substring(0,4) + "-01" + "-01";
		schToStrGmt = eventResponse.getETCData("schToStr");

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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="clss_clm_misc_cd"/>
<input type="hidden" name="sXml" value="<%=xml%>">

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="usr_area" value="<%=area%>">
<!-- 조회조건  -->
<input type="hidden" name="schFromStrGmt" value="<%=schFromStrGmt%>">
<input type="hidden" name="schToStrGmt" value="<%=schToStrGmt%>">

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
			<td width="195">
				<table class="search_sm2" border="0" style="width:190;">
					<tr class="h23">
					<td><input type="radio" name="sch_cond" value="INCI_NO" class="trans" checked>&nbsp;&nbsp;Incident No.&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_cond" value="VVD" class="trans">&nbsp;&nbsp;VVD</td>
					<input type="hidden" name="sch_cond_chk" value=""><!--RD 를 위한변수-->
				</tr>
				</table>

			</td>

				<td width="126"><input type="text" name="sch_str" style="width:120;" value="<%=reqCgoClmInciNo%>" class="input"></td>
				<td width="240"><table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Claim_Search">Claim Find</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="35">Area</td><!-- combo1 -->
				<td width="120"><script language="javascript">ComComboObject("combo1", 2, 67, 1);</script><input type="hidden" name="sch_area" value=""></td>
				<td width="44" title="Register Office Code">RGOFC</td>
				<td width="80"><input type="text" name="sch_ofc_cd" style="width:57;text-align:center" value="" class="input"></td>
				<td width="55">Register</td>
				<td width=""><input type="text" name="sch_cre_usr_id" style="width:84;text-align:center" value="" class="input"></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23">

				<td width="35" title="Place Of Incident">&nbsp;&nbsp;POI</td><!-- combo2 -->
				<td width="100"><script language="javascript">ComComboObject("combo2", 2, 67, 1);</script><input type="hidden" name="sch_plc_tp_cd" value=""></td>
				<td width="60">Location</td>
				<td width="360"><input type="text" name="sch_loc_cd" style="width:60;text-align:center" value="" class="input">&nbsp;<img src="img/btns_search.gif" name="btns_location" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="152">
				<table class="search_sm2" border="0" style="width:150;">
					<tr class="h23">
					<td><input type="radio" name="sch_duration" value="DOI" class="trans" checked title="Date Of Incident">&nbsp;&nbsp;DOI&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_duration" value="DORG" class="trans" title="Date of Register">&nbsp;&nbsp;DORG</td>
					<input type="hidden" name="sch_duration_chk" value=""><!--RD 를 위한변수-->
				</tr>
				</table>
			</td>
			<td width=""><input type="text" name="sch_from_str" style="width:80;text-align:center" value="" dataformat="ymd" maxlength="8" required class="input1">&nbsp;<img src="img/btns_calendar.gif" name="btns_date_cal1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;<input type="text" name="sch_to_str" style="width:80;text-align:center" value="" dataformat="ymd" maxlength="8" required class="input1">&nbsp;<img src="img/btns_calendar.gif" name="btns_date_cal2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr>
			</table>
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Outline of Incident</td></tr>
				</table>
			<table border="0" style="width:100%;" class="grid2">
				<tr>
				<td width=""><textarea name="inci_dev_desc" style="width:100%" rows="10" class="textarea"></textarea></td>
				</tr>
				</table>


			</td>
			</tr>
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

<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0030.jsp
 *@FileTitle : [CPS_CNI_0030] Incident-Creation
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0030Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0030Event event = null;
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

    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	
	SignOnUserAccount account = null;

    try
    {

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0030Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		reqCgoClmInciNo  = JSPUtil.getParameter(request, "cgo_clm_inci_no","");


    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
    //roles = "CNI03";
    //area =  "E";
    //ofcCd = "SELHO";
    //userId = "2001702";    
%>


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>

<html>
<head>
<title>Incident-Creation</title>
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
<input type="hidden" name="pagerows">
<input type="hidden" name="clss_clm_misc_cd"/>
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="cgo_clm_inci_no_old" value=""/><!--file upload 위한 old값.-->

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
				<td width="87">Incident No.</td>
				<td width="150"><input type="text" name="cgo_clm_inci_no" style="width:110;text-align:center;ime-mode:disabled" value="<%=reqCgoClmInciNo%>" caption="Incident No" maxlength="13" onKeyPress="ComKeyOnlyAlphabet('uppernum')" class="input1"></td>
				<td width="35">Area</td>
				<td width="99"><input type="text" name="clm_area_cd" style="width:30;text-align:center" value="" class="input2" readonly></td>
				<td width="40" title="Register Office">RGOFC</td>
				<td width="130"><input type="text" name="cre_ofc_cd" style="width:80;text-align:center" value="" class="input2" readonly></td>
				<td width="57">Register</td>
				<td width="130"><input type="text" name="cre_usr_id" style="width:80;text-align:center" value="" class="input2" readonly></td>
				<td width="35" title="Date of Register">DORG</td>
				<td width="110"><input type="text" name="cre_dt" dataformat="ymd" style="width:80;text-align:center" value="" class="input2" readonly></td>
				<td width="30" title="Date Of Updated">DOU</td>
				<td width=""><input type="text" name="upd_dt" dataformat="ymd" style="width:80;text-align:center" value="" class="input2" readonly></td>
			</tr>
			<tr class="h23">
				<td width="87" title="Place of Incident">POI</td>
				<td width="150" style="padding-left:2"><script language="javascript">ComComboObject("combo1", 2, 110, 1);</script><input type="hidden" name="inci_plc_tp_cd" value=""></td>
				<td width="35" title="Date of Incident">DOI</td>
				<td width="119"><input type="text" name="inci_occr_dt" style="width:77;text-align:center; ime-mode:disabled" required caption="DOI" dataformat="ymd" maxlength="8" value="" class="input1">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_date_cal" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="40" title="Vessel Voyage Direction">VVD</td>
				<td width="110"><input type="text" name="inci_ref_vvd_no" style="width:80;text-align:center" value="" maxlength="20" class="input">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_vvd" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="57">Location</td>
				<td width="" colspan="5"><input type="text" name="inci_loc_cd" style="width:80;text-align:center" value="" class="input" caption="Location" maxlength="5">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_location" width="19" height="20" border="0" align="absmiddle"></td>
				</tr></table>

			<table class="line_bluedot"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23"><td>
			<table class="search" border="0" style="width:826;">
			<tr class="h23">
				<td width="83">Subject</td>
				<td width=""><input type="text" name="inci_subj_nm" style="width:398;" value="" required maxlength="100" class="input1" caption="Subject"></td>
			</tr>
			</table>
			</td>
			<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn1_File_Upload">File Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
			</tr>
			</table>

			<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Outline of Incident</td></tr>
				</table>
			<table border="0" style="width:100%;" class="grid2">
				<tr>
				<td width="" class="input1"><textarea style="width:100%" name="inci_dev_desc"  rows="26"  required class="textarea1"  caption="Outline of Incident" ></textarea></td>
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
					<td class="btn1" name="btn1_Save">Save</td>
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
<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
</body>
</html>

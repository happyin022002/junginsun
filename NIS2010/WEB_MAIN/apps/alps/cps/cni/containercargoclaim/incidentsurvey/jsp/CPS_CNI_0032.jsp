<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0032.jsp
 *@FileTitle : [CPS_CNI_0032] Incident-Claim Inquiry
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0032Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0032Event event = null;
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
	String schToStrGmt = "";//조회조건의 to날짜(GMT)

    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	SignOnUserAccount account = null;

    try
    {

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0032Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		reqCgoClmInciNo  = JSPUtil.getParameter(request, "cgo_clm_inci_no","");

		schToStrGmt = eventResponse.getETCData("schToStr").substring(0,4);

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }

    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    
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

        <% if ("Y".equals(popupYn)) {%>
<body class="popup_bg"  onLoad="setupPage();">

        <table width="100%" class="popup" cellpadding="10" border="0">
        <tr><td class="top"></td></tr>
       <% } else { %>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
        <% } %>
<tr>
<td valign="top">

    <!--Page Title, Historical (S)-->
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="page_no" value="1">

<!-- 개발자 작업 -->
<!-- POPUP 용도로 사용시 -->
<input type="hidden" name="popupYn" value="<%=popupYn%>">
<!-- GMT 설정 -->
<input type="hidden" name="schToStrGmt" value="<%=schToStrGmt%>">
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="usr_area" value="<%=area%>">

    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <% if ("Y".equals(popupYn)) { %>
        <tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">  Incident-Claim Inquiry</td></tr>
        <% } else { %>
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        <% } %>

    </table>
    <!--Page Title, Historical (E)-->

		<!--biz page (S)-->

<table class="search" id="mainTable">
       		<tr><td class="bg">
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
				<td width="80">Incident No.</td>
				<td width="114"><input type="text" name="cgo_clm_inci_no" style="width:90;ime-mode:disabled" value="<%=reqCgoClmInciNo%>" class="input1" maxlength="13"></td>
				<td width="35">Area</td>
				<td width="50"><input type="text" name="clm_area_cd2" style="width:21;text-align:center" value="" class="input2" readonly></td>
				<td width="61" title="Register Office Code">RGOFC</td>
				<td width="90"><input type="text" name="cre_ofc_cd" style="width:50;text-align:center" value="" class="input2" readonly></td>
				<td width="50">Register</td>
				<td width="110"><input type="text" name="cre_usr_id" style="width:80;text-align:center" value="" class="input2" readonly></td>
				<td width="40" title="Date Of Registration">DORG</td>
				<td width="110"><input type="text" name="cre_dt"  style="width:80;text-align:center" value="" class="input2" readonly></td>
				<td width="30" title="Date Of Updated">DOU</td>
				<td width=""><input type="text" name="upd_dt2"  style="width:80;text-align:center" value="" class="input2" readonly></td>
			</tr></table>
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
				<td width="80" title="Place Of Incident">POI</td>
				<td width="60"><input type="text" name="inci_plc_tp_cd" style="width:40;text-align:center" value="" class="input2" readonly></td>
				<td width="30" title="Vessel Voyage Direction">VVD</td>
				<td width="110"><input type="text" name="inci_ref_vvd_no" style="width:80;text-align:center" value="" class="input2" readonly></td>
				<td width="60">Location</td>
				<td width="90"><input type="text" name="inci_loc_cd" style="width:50;text-align:center" value="" class="input2" readonly></td>
				<td width="50" title="Date Of Incident">DOI</td>
				<td width=""><input type="text" name="inci_occr_dt" style="width:80;text-align:center" value="" class="input2" readonly></td>
			</tr>
			<tr class="h23">
				<td width="">Subject</td>
				<td width="" colspan="7"><input type="text" name="inci_subj_nm" style="width:480;" value="" class="input2"></td>
			</tr>
			</table>

			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
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
<!-- : ( Search Options ) (E) -->

</td></tr>
		</table>

<% if ("Y".equals(popupYn)) {%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
<% } %>

			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><% if ("Y".equals(popupYn)) {%><td class="btn3_bg"><% }else{ %><td class="btn1_bg"><%}%>
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
                 <% if ("Y".equals(popupYn)) {%>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_close">Close</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <% } %>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<% if ("Y".equals(popupYn)) {%>
</tr>
</table>
<% } %>

    <!--biz page (E)-->

</td>
</tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

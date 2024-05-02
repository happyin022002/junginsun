<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0002.jsp
 *@FileTitle : [CPS_CNI_0002] Find
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0002Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0002Event event = null;
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

    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	SignOnUserAccount account = null;

    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0002Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }

	/*현재년도*/
	String currYear = "CC"+DateTime.getYear();
	
	// 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();
%>



<%@page import="com.hanjin.framework.component.util.StringUtil"%><html>
<html>
<head>
<title>Find</title>
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
		<td width="660">
			<table class="search_sm2" border="0" style="width:650;">
			<tr class="h23">
				<td width=""><input type="radio" name="sch_cond" value="CLM_NO" class="trans" checked>&nbsp;Claim No.&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_cond" value="BL_NO" class="trans">&nbsp;B/L&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_cond" value="CNTR_NO" class="trans">&nbsp;CNTR&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_cond" value="VVD" class="trans">&nbsp;VVD&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_cond" value="INCI_NO" class="trans">&nbsp;INC No.&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_cond" value="VOC_NO" class="trans">&nbsp;VOC No.&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_cond" value="INSURER_REF" class="trans">&nbsp;Insurer Ref.&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_cond" value="IMS_NO" class="trans">&nbsp;IMS No.</td>
			</tr>
			</table>
				<td width=""><input type="text" style="width:170;ime-mode:disabled" name="sch_str"  value="<%=currYear%>" maxlength="30" onKeyPress="ComKeyOnlyAlphabet('uppernum')" required caption="Data" class="input1">&nbsp;<script language="javascript">ComComboObject("combo1", 2, 67, 1);</script><input type="hidden" name="misc_cd" value="">&nbsp;<select style="width:70;" name="vt">
						<option value="" ></option>
						<option value="G" selected>GEN</option>
						<option value="I">INC</option>
						<option value="O">OTH</option>
						</select></td>
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
					<td class="btn1" name="btn1_Main">Main</td>
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

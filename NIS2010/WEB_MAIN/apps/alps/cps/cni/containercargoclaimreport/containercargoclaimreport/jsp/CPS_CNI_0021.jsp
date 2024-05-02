<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_cni_0021.jsp
     *@FileTitle : [CPS_CNI_0021] Occurrence Analysis
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.12.09
     *@LastModifier : 박제성
     *@LastVersion : 1.0
     * 2009.12.09 박제성
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
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.event.CpsCni0021Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%
	
	CpsCni0021Event event = null;    
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
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaimreport.ContainerCargoClaimReportSC");
    SignOnUserAccount account = null;
    String xml = HttpUtil.makeXML(request,response);
    
    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0021Event) request.getAttribute("Event");
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
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 

    
%>
<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<html>
<head>
<title>Occurrence Analysis</title>
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

<body onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="page_no" value="1">

<!-- 개발자 작업 -->

<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<!-- 조회조건  -->
<input type="hidden" name="report_by" value="0">
<input type="hidden" name="schFromStrGmt"  >
<input type="hidden" name="schToStrGmt"  >
<!--RD 를 위한변수-->
<input type="hidden" name="rd_title" value="">
<input type="hidden" name="rd_title_nm" value="">
<input type="hidden" name="rd_report_by" value="">


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
				<td width="74">Report by</td>
				
				<td width="240">
					<script language="javascript">ComComboObject("combo1", 1, 220, 1);</script>
				</td>
				<td width="45">Period</td>
				<td width="340">&nbsp;<script language="javascript">ComComboObject("period", 2, 80, 1);</script>&nbsp;
				<input type="text" value="" name="from_period" class="input1" style="width:75;ime-mode:disabled;text-align:center" required maxlength="8" dataformat="ymd" fullfill caption="Period(From Date)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_from_period" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;
				<input type="text" value="" name="to_period" style="width:75;ime-mode:disabled;text-align:center"  class="input1" required maxlength="8" dataformat="ymd" fullfill caption="Period(To Date)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_to_period" width="19" height="20" border="0" align="absmiddle"></td>
			    <td>
					<table class="search_sm2" border="0" style="width:230;"> 
					<tr class="h23">
					<td><input name="rdbtn" type="radio" value="0" class="trans" checked>&nbsp;POL - POD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="rdbtn" type="radio" value="1" class="trans">&nbsp;POR - DEL</td>
					</tr>
					</table> 
				</td>
				</tr>
			</table> 
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<div id="tbl1" style="display:;"><script language="javascript">ComSheetObject('sheet1');</script></div>
						<div id="tbl2" style="display: none;"><script language="javascript">ComSheetObject('sheet2');</script></div>
					</td>
				</tr>
			</table>
	<!-- Grid  (E) -->

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
					<td class="btn1_2" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_2" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_2" name="btn1_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_2" name="btn1_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
</td>
</tr>
</table>
 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
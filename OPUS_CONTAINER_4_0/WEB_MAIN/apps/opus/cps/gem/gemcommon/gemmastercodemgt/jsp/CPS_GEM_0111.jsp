<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0111.jsp
     *@FileTitle : [CPS_GEM-0111] Foreign Exchange Rate Maintenance
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="java.util.Date"%>
<%@page import="com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0111Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0111Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.GEMCommon.GEMMasterCodeMgt");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (CpsGem0111Event) request.getAttribute("Event");
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
%>




<html>
<head>
<title>Foreign Exchange Rate Maintenance</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(month){  
        loadPage(month);
    }
</script>
</head>
<body class="popup_bg" onLoad="setupPage('<%=DateTime.getFormatDate(new Date(),"yyyy-MM")%>');">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Monthly Accounting Rate
				Interface</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="50">Month</td>
						<td><input type="text" style="width: 70;" class="input1" maxlength="6"  name="acct_xch_rt_yrmon" fulfill required  dataformat="ym" caption="Month" value="">&nbsp;<img class="cursor"
							src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>

						
					</tr>
				</table>
				<!--  biz_1   (E) --></td>
			</tr>
		</table>
		<!--biz page (E)-->

<table>
	<tr>
	<td height="10"><script language="javascript">ComSheetObject('sheet1');</script></td>
	</tr>
</table>
		</td>
	</tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0"
			style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn1_Confirm">Confirm</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn1_Reset">Reset</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn1_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

					</tr>
				</table>
				<!--Button (E) -->
				
				</td>
			</tr>
		</table>

		<!-- : ( Button : pop ) (E) --></td>
	</tr>
</table>
 
</form>
</body>

</html>
<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0018.jsp
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.24 장창수
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsTot0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String yyyyMM =DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM");
	String stlClzFlg		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TonnageTaxOutput.TonnageTaxStandardProfitConclusion");
	//String recentDt = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsTot0018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		stlClzFlg = eventResponse.getETCData("stlClzFlg" );

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TOT</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage("<%=stlClzFlg%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="stl_yr">
<input type="hidden" name="back_end_job_key">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id %>">
<input type="hidden" name="feeder_yn">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Month</td>
					<td width="150"><input type="text" style="width:60;" class="input1" name="stl_yrmon" maxlength="6" size="7" value="<%=yyyyMM%>" dataformat="ym">&nbsp;<img class="cursor" src="img/btns_back.gif" name = "btns_back" width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif" name = "btns_next" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="50">Status</td>
					<td width=""><input type="text" style="width:100;" class="input" name="status" readonly ></td>
					
					</tr>
				</table>
				
			</td>
		</tr>
		</table>		
				<table class="height_8"><tr><td colspan="8"></td></tr></table>
				
		<table class="search"> 
       	<tr><td class="bg">		
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="150">Total Vessel / Amount</td>
					<td width=""><input type="text" style="width:100;text-align:right" class="input" name="vsl_cnt" dataformat="int" disabled >&nbsp;<input type="text" style="width:200;text-align:right" class="input" name="vsl_total" dataformat="float" disabled ></td>
					</tr>
				</table>
			<!--  Grid_button (S) -->
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_YearClose">Year Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Status" >Status</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ERPIF">ERP I/F</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0024.jsp
*@FileTitle : Off Hire Plan Input &amp; Update by H/Q
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 오봉현
*@LastVersion : 1.0
* 2009.06.02 오봉현
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.containerleasemgt.leaseplan");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (EesLse0024Event)request.getAttribute("Event");
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
<title>Off Hire Plan Input &amp; Update by H/Q</title>
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
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="de_mon">
<input type="hidden" name="offh_loc_tp_cd" value="H">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">

				<!--  biz  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						
						<td width="280">
							<table border="0" style="width:250;" class="search_sm2"> 
								<tr class="h23">
									<td width="65">Plan Type</td>
									<td class="stm" align="center">
										<input type="radio" name="offh_pln_tp_cd" value="B" class="trans" checked>&nbsp;Basic&nbsp;&nbsp;
										<input type="radio" name="offh_pln_tp_cd" value="O" class="trans" >&nbsp;Operation
									</td>
								</tr>
							</table>
						</td>
						<td width="60">Plan Year</td>
						<td width="100">
							<input type="text" name="pln_yr" caption="Plan Year" style="width:50;text-align:center;" class="input1" value="" dataformat="int" maxlength="4" required fullfill>&nbsp;
						</td>
						<td width="30">Ver</td>
						<td width="">
							<input type="text" name="offh_ver_seq" caption="Version" style="width:35;text-align:center;" class="input" dataformat="int" maxlength="3">&nbsp;
						</td>
					</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="60">&nbsp;TP/SZ</td>
						<td width="220">
							<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 190, 0);</script>
							<!--<input type="checkbox" name="chk_cntr_tpsz_cd" class="trans">-->
						</td>
						<td width="61">Term</td>
						<td width="100" style="padding-left:1;"><script language="javascript">ComComboObject('lstm_cd', 1, 50, 0);</script></td>
						<td width="30">RCC</td>
						<td width="360">
							<script language="javascript">ComComboObject('offh_rgn_loc_cd', 1, 200, 0);</script>
							<!--<input type="checkbox" name="chk_offh_rgn_loc_cd" class="trans">-->
						</td>
						<td width="50">User ID</td>
						<td width="">
							<input type="text" name="" caption="Office" style="width:80;text-align:center;" class="input2" value="<%= strUsr_id %>" readonly>
						</td>
					</tr>
				</table>
				<!--  biz (E) -->

		</td></tr></table>	

		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" valign="top">

			<!-- Grid  (S) -->
			<table width="100%" id="sheetTable">
				<tr>
					<td>
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btns_LoadExcel">Load&nbsp;Excel</td>
							<td class="btn2_right"></td></tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btns_DownExcel">Down&nbsp;Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table>
						</td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       	<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
			    	<td>
				    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Save">Save</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Ver">Version&nbsp;Up</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

	</td></tr>
		</table>
	
</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
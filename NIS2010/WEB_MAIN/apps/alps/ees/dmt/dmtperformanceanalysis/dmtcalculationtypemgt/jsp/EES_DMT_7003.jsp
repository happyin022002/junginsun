<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_7003.jsp
*@FileTitle : Calculation Type Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.13 황효근
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt7003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.DMTCalculationTypeMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt7003Event)request.getAttribute("Event");
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
<title>Calculation Type Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>

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
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="retry">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Minimize" id="btn_Minimize">Minimize</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       			
				<div id="sch_cond_div" style='display:block;'>
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;Country</td>
					<td width="90" style="padding-left:2"><script language="javascript">ComComboObject('combo1', 2, 60, 0);</script></td>
					<td width="105"><span id="Region">Region</span></td>
					<td width="130"><script language="javascript">ComComboObject('combo2', 2, 60, 0, 0, 0, true);</script></td>
					<td width="60">Location</td>
					<td width=""><input type="text" style="width:50;" class="input" name="location" value="" maxlength="5" dataformat="engup" 
										OnKeyUp="checkLocation()"></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;Bound</td>
					<td width="90"><select name="io_bnd_cd" style="width:60;" class="input">&nbsp;
						<option value="" selected>All</option>
						<option value="I">Inbound</option>
						<option value="O">Outbound</option>
						</select></td>
					<td width="105">Calculation Type</td>
					<td width=""><select name="dmdt_calc_tp_cd" style="width:100;" class="input">&nbsp;
						<option value="" selected>All</option>
						<option value="C">Combined</option>
						<option value="D">Dual</option>
						</select></td>
					</tr> 
				</table>
				<table class="search_sm2" border="0" style="width:400;"> 
				<tr class="h23">
					
					<td width="50">Validity</td>
					<td width="100" class="stm"><input type="checkbox" name="val_curr" value="Y" class="trans" checked>Current</td>
					<td width="100" class="stm"><input type="checkbox" name="val_tobe" value="Y" class="trans" checked>To-be</td>
					<td class="stm"><input type="checkbox" name="val_exp" value="Y" class="trans">Expired</td>
					</tr> 
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				</div>
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			
			
			<table class="height_5"><tr><td colspan="8"></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23"><td class="sm">* Coverage :Booking DEL (Inbound) & Booking POR(Outbound)&nbsp;<br>
* Effective Date:  POD ETA(Inbound) & OP Movement(Outbound)<br><br></td></tr>
			</table>
			<table class="grid2" border="0" style="width:979;"> 
				<tr>
					<td class="tr2_head" width="130">Exception Remark(s)</td>
					<td style="padding:5px 5px 5px 5px;">POD: CNHKG, DEL: CN -> Dual<br>
&nbsp;POD: US, DEL: MX -> Dual</td>
				</tr>
			</table>
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<table class="height_8"><tr><td></td></tr></table>
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
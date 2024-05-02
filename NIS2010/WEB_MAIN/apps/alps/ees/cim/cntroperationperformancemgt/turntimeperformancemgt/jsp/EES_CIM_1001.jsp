<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1001.jsp
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.24 박광석
* 1.0 Creation
=========================================================*/%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1001Event"%>
<%@ page import="org.apache.log4j.Logger" %> 

<%
 	EesCim1001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg = "";						//에러메세지
 	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
 	
 	String successFlag = "";
 	String codeList  = "";
 	String pageRows  = "100";

 	String strUsr_id		= "";
 	String strUsr_nm		= "";
 	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.TurnTimePerformanceMgt");
	String xml = "";
 	
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();
 	   
 	   
 		event = (EesCim1001Event)request.getAttribute("Event");
 		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

 		if (serverException != null) {
 			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
 		}
 		
 		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
 		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);
 		
 	}catch(Exception e) {
 		out.println(e.toString());
 	}
 %>
<html>
<head>
<title>Turn Time by Port</title>
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
<form name="form" >
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="from">
<input type="hidden" name="to">

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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" ID="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
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
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="55">Period</td>
					<td width="117"><select style="width:125;" class="input1" name="period" >
						<option value="M" selected>Month(YYYY-MM)</option>
						<option value="W" > Week(YYYY-WW)</option>
						</select></td>
					<td width="205"><input type="text" style="width:54" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6"><!-- &nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarfm">-->&nbsp;~
					<input type="text" style="width:54" class="input1" value="" name="tos" required dataformat="ym" caption="TO" maxlength="6"><!-- &nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto">--></td>
					<td width="85">Location </td>
					<td width="170"><select style="width:70;" class="input1" name="inquiryLevel">
						<option value="A" selected></option>
						<option value="R" >RCC</option>
						<option value="C" >Country</option>
						<option value="P" >POL</option>
						</select>&nbsp;<input type="text"  disabled style="width:55;" class="input"  name="location" value="" dataformat="engup" style="ime-mode:disabled" maxLength ="5">&nbsp;<img class="cursor" name="btn_loc_cd"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="60">Port Com</td>
					<td width="95"><select style="width:75;" class="input" name="portcom">
						<option value="A" selected></option>
						<option value="S" >Same</option>
						<option value="D" >Different</option>
						</select></td>
					<td width="83">Flow Pattern</td>	
					<td width=""><select style="width:80;" class="input" name="flowpattern">
						<option value="5" selected>Excl MIMO</option>
						<option value="A">ALL</option>
						<option value="1" >FI -> FO</option>
						<option value="2" >FI -> MO</option>
						<option value="3" >MI -> FO</option>
						<option value="4" >MI -> MO</option>
						</select></td>
					</tr> 
				</table> 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="387">
					<table border="0" style="width:98%;" class="search_sm2"> 
					<tr class="h23">
					<td width="45">TP/SZ</td>
					<td width="" class="stm" style="font-size:12;">
						<input type="radio" class="trans" name="tpsz" checked value="A">All&nbsp;&nbsp;
						<input type="radio" class="trans" name="tpsz" value="D">DRY&nbsp;&nbsp;
						<input type="radio" class="trans" name="tpsz" value="S">SPCL&nbsp;&nbsp;
						<input type="radio" class="trans" name="tpsz" value="R">Reefer&nbsp;
						<select style="width:90;" class="input" name="rdtype" disabled>
						<option value="I" selected>Include R/D</option>
						<option value="E">Exclude R/D</option>
						<option value="O" >Only R/D</option>
						</select></td>
						</tr> 
						</table></td>
					<td width="85">T/S CNTR</td>
					<td width="170"><select style="width:70;" class="input" name="tscntr">
						<option value="E" selected>Exclude</option>
						<option value="I" >Include</option>
						<option value="O" >Only</option>
						</select></td>
					<td width="60">S.O.C </td>
					<td width="95"><select style="width:75;" class="input"  name="soc">
						<option value="E" selected>Exclude</option>
						<option value="I" >Include</option>
						<option value="O" >Only</option>
						</select></td>
					<td width="83">Company</td>
					<td width=""><input type="text" style="width:30;text-align:center;" class="input" value="SML" readOnly></td>
				
				</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       			<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td></tr>
				</table>
		<!-- Tab ) (E) -->

		<!-- Tab Summary  (S) -->
		<div id="tabLayer" style="display:inline">

			<!-- Tab BG Box  (S) -->
			<table class="search"> 
			<tr><td class="bg">
																		
				<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table> 				
				<!-- Grid (E) -->

				<!--  Grid_button (S) -->
				</td></tr>
			</table>
		<!-- Tab BG Box  (S) -->

		</div>

		<!-- Tab Summary  (E) -->


		<!-- Tab Detail  (S) -->
		<div id="tabLayer" style="display:none">
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table> 			
			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
				
		</div>

		<!-- Tab Detail  (E) -->

		
	<!--biz page (E)-->

	</td></tr>
</table>



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
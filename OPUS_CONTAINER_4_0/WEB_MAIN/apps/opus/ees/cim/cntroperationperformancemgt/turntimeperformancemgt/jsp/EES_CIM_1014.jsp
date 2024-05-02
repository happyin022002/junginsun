<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1014.jsp
*@FileTitle : Turn Around Time
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.TurnTimePerformanceMgt");
	String xml = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCim1014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Turn Around Time</title>
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
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="from">
<input type="hidden" name="to">
<!-- developer job	-->
<input type="hidden" name="inquiryLevel" value="O">
<input type="hidden" name="location">

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
					<td class="btn1" name="btn_Retrieve"  ID="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="65">Period</td>
					<td width="127"><select style="width:125;" class="input1" name="period" >
						<option value="M" selected>Month(YYYY-MM)</option>
						<option value="W" > Week(YYYY-WW)</option>
						</select></td>
					<td width="180"><input type="text" style="width:55" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6"><!-- &nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarfm">-->&nbsp;~
					<input type="text" style="width:55" class="input1" value="" name="tos" required dataformat="ym" caption="TO" maxlength="6"><!-- &nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto">--></td>
					<td width="40">Trade</td>
					<td width="90">
					<script language="javascript" >ComComboObject('trade', 2, 50, 0,0,0,true);</script>
					</td>
					<td width="45">Bound</td>
					<td width="90"><select style="width:40;" name="bound">
						<option value="" selected></option>
						<option value="E">E</option>
						<option value="W">W</option>
						<option value="N">N</option>
						<option value="S">S</option>
						</select></td>
					<td width="35">Lane</td>
					<td width="145">
					<script language="javascript" >ComComboObject('lane', 2, 50, 0,0,0,true);</script>
					</td>
					<td width="120"></td>
				</table>				

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="65">TP/SZ </td>
					<td width="305" style="padding-left:2">
					<script language="javascript" >ComComboObject('tpsz', 1, 123,1);</script>
					<!--  &nbsp;<input type="checkbox"  class="trans" name="chk_cntr_tpsz_cd"  border="0">-->					
					</td>		
					<td id = "se"  style="display:none;">
						<table class="search_sm2" border="0" style="width:92%;"> 
							<tr class="h23">
								
								<td width="300"><input type="radio" value="O" class="trans" name="locdivision"  Checked>OP Loc.&nbsp;<input type="text" style="width:46" class="input" value="" name="oploc" dataformat="engup" style="ime-mode:disabled"   maxlength="5">&nbsp;<img class="cursor" name="btn_loc_cd1"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;&nbsp;&nbsp;ID Loc.&nbsp;<input type="text" style="width:46" class="input" value="" name="idloc" dataformat="engup" style="ime-mode:disabled"  maxlength="5">&nbsp;<img class="cursor" name="btn_loc_cd2"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width=""><input type="radio" value="P" class="trans" name="locdivision">POL&nbsp;<input type="text" style="width:46" class="input" value="" name="pol" dataformat="engup" style="ime-mode:disabled"   maxlength="5">&nbsp;<img class="cursor" name="btn_loc_cd3"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;&nbsp;&nbsp;POD&nbsp;<input type="text" style="width:46" class="input" value="" name="pod" dataformat="engup" style="ime-mode:disabled"   maxlength="5">&nbsp;<img class="cursor" name="btn_loc_cd4"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></td>
				
							</tr>
						</table>
					</td>
					<td id = "se2" >
						<table border="0" style="width:95%;"> 
							<tr class="h23">
								
								<td width="280">&nbsp;</td>
								<td width="">&nbsp;</td>
				
							</tr>
						</table>
					</td>
					</tr>
				</table>			
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="65">T/S CNTR</td>
					<td width="130" style="padding-left:0"><select style="width:90;" name="tscntr">
						<option value="E" >Exclude</option>
						<option value="I" selected>Include</option>
						<option value="O">Only</option>
						</select></td>
					<td width="35">S.O.C</td>
					<td width="200">
						<select style="width:90;" name="soc">
						<option value="E" selected>Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only</option>
						</select></td>
					<td width="75">&nbsp;</td>
					<td width="">&nbsp;</td>
				</tr>
				</table>		
				<!--  biz_1   (E) -->
			
		</td></tr></table>

		
		<table class="height_8"><tr><td></td></tr></table>	
		
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
		
		
		
		
<!--TAB Trade-Lane (S) -->
<div id="tabLayer" style="display:inline">
			
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>			

			<!-- Grid (E) -->	
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!--TAB Trade-Lane (E) -->




<!--TAB TYSZ-Trade (S) -->
<div id="tabLayer" style="display:none">
			
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>			

			<!-- Grid (E) -->	
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!--TAB TYSZ-Trade (E) -->




<!--TAB OPLOC-MTLOC (S) -->
<div id="tabLayer" style="display:none">
			
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>			

			<!-- Grid (E) -->	
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!--TAB OPLOC-MTLOC (E) -->
	
	</td></tr>
		</table>
	



<!-- end of developer job -->
</form>
</body>
</html>
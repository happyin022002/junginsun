<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0506.jsp
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.26 김종옥
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.event.VopVsk0504Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0504Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.PortInformationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0504Event)request.getAttribute("Event");
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
<title>Port Information Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<input type="hidden" name="trsp_mod_cd">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">

	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<!-- table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;CBF>>CBF for Own Booking (Creation)</td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Port Information Creation</td></tr>
		</table -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
		
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">Port</td>					
					<td width="120"><input type="text" name="loc_cd" style="width:60;text-align:center;" class="input1" value="" dataformat="uppernum" style="ime-mode:disabled" maxlength="5" caption="Vessel Code">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_loc_cd" border="0" align="absmiddle" class="cursor"></td>
					<td width="35">RHQ</td>
					<td width="110">
						<!-- script language="javascript">ComComboObject('rhq', 1, 80, 1);</script -->
						<div id="comboRhq" style="display:none;"><script language="javascript">ComComboObject('rhq', 1, 80, 1);</script></div>
						<div id="inputRhq" style="display:inline;"><input type="text" style="width:80;text-align:center;" class="input2" value="" name="in_rhq" readOnly></div>
					</td>
					<td width="35">Year</td>
					<td width="365">
					    <input type="hidden" name="nowYear" style="width:50;text-align:center;" class="input2" value="<%=DateTime.getYear()%>">
					    <input type="hidden" name="nowDateTime" style="width:50;text-align:center;" class="input2" value="<%=DateTime.getShortDateString()%><%=DateTime.getShortTimeString()%>">                                   
					    <!-- script language="javascript">ComComboObject('cel_year', 1, 80, 1);</script -->
					    <input type="text" name="cel_year" style="width:60;text-align:center;" class="input" value="<%=DateTime.getYear()%>" dataformat="ymd" maxlength="4" caption="Year">&nbsp;<img src="img/btns_calendar.gif" name="btn_Calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="90">Updated Date</td>   
					<td width="116"><input type="text" name="upd_dt" style="width:115;text-align:center;" class="input2" readOnly></td>
					<td width="" align="right"><input type="text" name="upd_usr_id" style="width:70;" class="input2" readOnly></td>					
					</tr>
				</table>	
			
				<!-- biz_1  (E) -->		
				
				
		</td></tr>
			</table>		
			
   <table class="height_8"><tr><td></td></tr></table>	
    
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
			


<!--TAB Maneuvering (S) -->
<div id="tabLayer" style="display:inline">
				
	<table class="search"> 
    <tr><td class="bg" style="height:438" valign="top">
		
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
					
			<table class="height_8"><tr><td></td></tr></table>
			<table border="0" style="width:100%; background-color:white;" class="grid2"> 
			<tr class="tr_head2"></tr>
			<tr>
				<td width="15%" class="tr2_head" rowspan="2"> Remark(s)	</td>
				<td width="%" rowspan="2"> <textarea name="mnvr_rmk" style="width:100%;height:60" readOnly></textarea></td>
 				</tr>
			</table> 
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->

</div>
<!--TAB Maneuvering (E) -->



<!--TAB Treminal (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
    <tr><td class="bg" style="height:438" valign="top">
	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t2downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->

</div>
<!--TAB Treminal (E) -->



<!--TAB Distance (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
    <tr><td class="bg" style="height:438" valign="top">
	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
					
			
			
			
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->

</div>
<!--TAB Distance (E) --> 



<!--TAB Doc (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
    <tr><td class="bg" style="height:438" valign="top">
	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
					
			
			
			
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->

</div>
<!--TAB Doc (E) --> 



<!--TAB Canal (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
    <tr><td class="bg" style="height:438" valign="top">
	
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t5sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t5downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

	<br>
		
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%" align="right" valign="bottom">Unit(%)</td>
					</tr>				
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t5sheet2');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	

			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->

</div>
<!--TAB Canal (E) --> 



<!--TAB Trucking (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
    <tr><td class="bg" style="height:438" valign="top">
	
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t6sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t6downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		<table class="height_8"><tr><td></td></tr></table>
			<table border="0" style="width:100%; background-color:white;" class="grid2"> 
			<tr class="tr_head2"></tr>
				<tr>
				<td width="15%" class="tr2_head" rowspan="2"> Remark(s)	</td>
				<td width="%" rowspan="2"> <textarea name="trsp_rmk_td" style="width:100%;height:60" readOnly></textarea></td>
 				</tr>
			</table> 			
			
			
			
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->

</div>
<!--TAB Trucking (E) --> 



<!--TAB Railroad (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
    <tr><td class="bg" style="height:438" valign="top">
	
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t7sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t7downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
					
			<table class="height_8"><tr><td></td></tr></table>
			<table border="0" style="width:100%; background-color:white;" class="grid2"> 
			<tr class="tr_head2"></tr>
				<tr>
				<td width="15%" class="tr2_head" rowspan="2"> Remark(s)	</td>
				<td width="%" rowspan="2"> <textarea name="trsp_rmk_rd" style="width:100%;height:60" readOnly></textarea></td>
 				</tr>
			</table> 	
			
			
			
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->

</div>
<!--TAB Railroad (E) -->
	
	
<!-- TAB [ Gang Structure ] (E) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:438" valign="top">
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t10sheet1');</script>
							<!-- script language="javascript">ComSheetObject('t5sheet3');</script -->
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!-- TAB [ Gang Structure ] (E) -->		
	
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
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
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- Copyright (S) -->
<!-- table class="copy">
<tr><td class="familysite">&nbsp;
		<select name="sitelink" id="sitelink" class="select_family" onChange="javascript:go_sitelink(this);">
       	<option selected>&nbsp;&nbsp;  -- Family Site --  &nbsp;&nbsp;</option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
   		</select>
	</td>
	<td class="copy"><img src="img/img_bottom_logo.gif" width="460" height="16" alt="" border="0"></td></tr>
</table -->
<!-- Copyright(E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
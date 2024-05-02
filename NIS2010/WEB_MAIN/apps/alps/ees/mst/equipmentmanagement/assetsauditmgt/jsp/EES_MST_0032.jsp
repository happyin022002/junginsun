<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0032.jsp
*@FileTitle : Analyze different Data in NIS & ERP-FA - Master/FA Only
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.31 이호선
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event.EesMst0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EesMst0032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.AssetsAuditMgt");
	String cntr_no = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EesMst0032Event)request.getAttribute("Event");
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
<title>::</title>
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
<input type="hidden" name="ver_no_h" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:750;"> 
				<tr class="h23">
					<td width="70">Month</td>
					<td width="140"><input type="text" style="width:60" class="input1" dataformat="ym" maxlength="7" style="ime-mode:disabled" value="" name="yr_mon">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" onClick="popCalendar('calendarPopup2')"></td>
					<td width="50">Version</td>
					<td width="120"><script language="javascript">ComComboObject('ver_no', 1, 40, 1);</script></td>					
					<td><table class="search_sm2" border="0" style="width:320;"> 
						<tr class="h23">
							<td width="70" align="center">EQ Type</td>
							<td width="" class="stm"><input type="radio" value="U" class="trans" checked name="eq_type">Container&nbsp;&nbsp;&nbsp;<input type="radio" value="Z" class="trans" name="eq_type">Chassis&nbsp;&nbsp;&nbsp;<input type="radio" value="G" class="trans" name="eq_type">M.G.Set</td>
						</tr> 
						</table>
					</td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Master</td>
					<td width="200"><input type="text" style="width:127;" dataformat="int" class="input2" value="" name="mst_qty" readOnly style="text-align:right"></td> 
					<td width="80">FA</td>
					<td width="200"><input type="text" style="width:127;" dataformat="int" class="input2" value="" name="fa_qty" readOnly style="text-align:right"></td>
					<td width="70">Job Date</td>
					<td><input type="text" style="width:127;" class="input2" value="" name="cre_dt" readOnly style="text-align:center"></td> 
				</tr>
				<tr class="h23">
					<td>Difference</td>
					<td><input type="text" style="width:127;" dataformat="int" class="input2" value="" name="diff_qty" readOnly style="text-align:right"></td>
					<td>Master Only</td>
					<td><input type="text" style="width:127;" dataformat="int" class="input2" value="" name="mst_ony_qty" readOnly style="text-align:right"></td>
					<td>FA Only</td>
					<td><input type="text" style="width:127;" dataformat="int" class="input2" value="" name="fa_ony_qty" readOnly style="text-align:right"></td> 
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="69">Remark</td>
					<td><textarea style="width:677; height:70;" name="diff_rmk_m" maxlength="200" style="ime-mode:disabled"></textarea></td> 
				</tr>
				</table>
				<!--  biz_1   (E) -->

			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<!-- 1 (E) -->
				
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) -->



<!--TAB Master Only (S) -->
<div id="tabLayer" style="display:inline">		
		<!-- 2-1 (S) -->
		<table class="search">
       	<tr><td class="bg">
		
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1downexcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		<!-- 2-1 (E) -->
</div>
<!--TAB Master Only (E) --> 			
		
<!--TAB FA Only (S) -->
<div id="tabLayer" style="display:none">
		<!-- 2-2 (S) -->
		<table class="search">
       	<tr><td class="bg">
		
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2downexcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		<!-- 2-2 (E) -->
</div>
<!--TAB FA Only (E) --> 

<!--TAB FA Only (S) -->
<div id="tabLayer" style="display:none">
		<!-- 2-2 (S) -->
		<table class="search">
       	<tr><td class="bg">
		
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3downexcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		<!-- 2-2 (E) -->
</div>
<!--TAB FA Only (E) --> 			
		
		
	<!--biz page (E)-->

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
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

</form>
</body>
</html>

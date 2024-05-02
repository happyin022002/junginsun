<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_1007.jsp
*@FileTitle : Holiday by Country Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1007Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTMasterDataMgt.HolidayMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt1007Event)request.getAttribute("Event");
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
<title>Holiday by Country Creation</title>
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
<input type="hidden" name="hol_yr">
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
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Country</td>
					<td width="70">&nbsp;<script language="javascript">ComComboObject('cboCountry', 2, 60 , 0, 1)</script></td>
					<td width="40"><span id="Region">Region</span></td>
					<td width="70">&nbsp;<script language="javascript">ComComboObject('cboRegion', 2, 60 , 0, 0, 0, true)</script></td>
					<td width="45">Location</td>
					<td width="">&nbsp;<input type="text" name="location" style="width:60;" class="input" value="" dataformat="engup" maxlength="5" OnKeyUp="checkLocation()"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Year</td>
					<td width="120">&nbsp;<select name="year" style="width:60;" class="input"></select></td>
					<td width="">
						<table class="search_sm2" border="2" style="width:280;">
							<tr class="h23">
								<td><input name="wknd_tp_cd" type="radio" value="" class="trans" checked disabled> SAT/SUN&nbsp;&nbsp;&nbsp;<input name="wknd_tp_cd" type="radio" value="TF" class="trans" disabled> THU/FRI&nbsp;&nbsp;&nbsp;<input name="wknd_tp_cd" type="radio" value="FS" class="trans" disabled> FRI/SAT</td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				
				
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!-- biz_2  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="130" valign="top">
					
					<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>					
					<!--grid (E)-->
					
					
					</td>
					<td width="19">&nbsp;&nbsp;</td>
					<td width="130" valign="top">
					
					<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
					<!--grid (E)-->
					
					
					</td>
					<td width="20">&nbsp;&nbsp;</td>
					<td width="680">
					
					<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>					
					<!--grid (E)-->
					<!--sub_button (S)-->
					<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2_1" name="no_btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2_1" name="no_btn_RowCopy">Row Copy</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2_1" name="no_btn_Delete">Delete</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2_1" name="no_btn_LoadExcel">Load Excel</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
					</tr></table>
					</td></tr>
					</table>
					<!--sub_button (E)-->
					
					
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="150">Update Date/OFC/Name</td>
					<td width="">&nbsp;<input type="text" name="upd_dt" style="width:80;" value="">&nbsp;<input type="text" name="upd_ofc_cd" style="width:60;" value="">&nbsp;<input type="text" name="upd_usr_nm" style="width:400;" value="">
					</td>
				</tr>
				</table>
				
			<!-- biz_2 (E) -->
					
					
					</td></tr>
			</table>
			
					
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
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
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_1" name="no_btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_1" name="no_btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
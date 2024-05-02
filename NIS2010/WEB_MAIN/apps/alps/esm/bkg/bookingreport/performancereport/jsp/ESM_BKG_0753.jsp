<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0753.jsp
*@FileTitle : bookingReport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.01 강동윤
* 1.0 Creation
* 2011.09.02 변종건 [CHM-201111165-01] [BKG] BL Data Input Cross-check 기능 추가 보완-Sailing Date 및  Multi-VVD Base 검색 조건 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0753Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0753Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");
	
	String strMaxKnt = JSPUtil.getNull(request.getParameter("max_knt"));
	if( strMaxKnt == null || strMaxKnt.equals("") ){
		strMaxKnt = "50";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0753Event)request.getAttribute("Event");
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
<title>bookingReport</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		document.form.vps_port_cd.focus();
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="vsl_cd" value=""> 
<input type="hidden" name="skd_voy_no" value=""> 
<input type="hidden" name="skd_dir_cd" value="">
<input type="hidden" name="vps_eta_dt" value="">
<input type="hidden" name="num_max_knt" value="<%=strMaxKnt%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;VVD Selection Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:100%;"> 
     		<tr>
     			<td width="100%">
					<script language="javascript">ComTabObject('tab1');</script>
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) -->
						
		<!--biz page (S)-->
		<div id="tabLayer" style="display:inline">
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<table class="search" border="0" style="width:880;"> 
					<tr class="h23">
						<td width="30">Port</td>
						<td width="60"><input type="text" name="vps_port_cd" style="width:50;" class="input1" value="" maxLength="5" onKeyUp="javascript:upper(this);"></td>
						<td width="320">
							<table class="search_sm" border="0" style="width:310;"> 
								<tr class="h23">
									<td width="100"><input type="radio" name="check_op" value="0" class="trans" checked>ETD&nbsp;&nbsp;<input type="radio" name="check_op" value="1" class="trans">ETA</td>
									<td width=""><input type="text" name="vps_etb_dt" style="width:75;" class="input" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;~&nbsp;<input type="text" name="vps_etd_dt" style="width:75;" class="input" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar"></td>
								</tr>
							</table>
						</td>
						<td width="30">Lane</td>
						<td width="50"><input type="text" name="slan_cd" style="width:35;" class="input" value="" maxLength="3" onKeyUp="javascript:upper(this);"></td>
						<td width="25">Dir.</td>
						<td width="35"><input type="text" name="dir_cd" style="width:20;" class="input" value="" maxLength="1" onKeyUp="javascript:upper(this);"></td>
						<td width="25">VVD</td>
						<td width="95"><input type="text" name="vvd" style="width:80;" class="input" value="" maxLength="9" onKeyUp="javascript:upper(this);"></td>
						<td width="75">Vessel Name</td>
						<td width=""><input type="text" name="vsl_eng_nm" style="width:120;" class="input" value="" maxLength="50" onKeyUp="javascript:upper(this);"></td>
					</tr>
				</table>
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
				
			
			
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="500" valign="top">
						
					<!--grid (S)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>					
					<!--Grid (E)-->
					</td>
					<td width="80" align="center">
					<img src="img/btns_add.gif" width="26" height="26" alt="" border="0" class="cursor" name="btn_add"><br><br>
					<img src="img/btns_del.gif" width="26" height="26" alt="" border="0" class="cursor" name="btn_del"><br><br>
					</td>
					<td width="300" valign="top">
					<!--grid (S)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>						
					<!--Grid (E)-->
					</td>
				</tr>
			</table>
				
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_new">New</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_rowAdd">Row&nbsp;Add</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_loadexcel">Load Excel</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td style="height:19; width:15; background-image: url(/hanjin/img/btn_2_left_up.gif);"></td>
									<td class="btn2"  name="btns_up">Up</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td style="height:19; width:15; background-image: url(/hanjin/img/btn_2_left_down.gif);"></td>
									<td class="btn2" name="btns_down">Down</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
				
				
			
		</td></tr></table>
		</div>
		<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
       				<table class="search" border="0" style="width:880;">
       					<tr class="h23">
       						<td width="880" colspan="3">
	       						<table class="search_sm" border="0" width="880"> 
									<tr class="h23">
										<td width="" align="center">Multi-VVD Input Template</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr class="h23">
							<td width="30" align="center">ID</td>
							<td width="100"><input type="text" name="user_id" style="width:90;" class="input" value="<%=strUsr_id%>" readonly></td>
							<td width="750">(Type with comma(,) between VVDs)</td>
						</tr>
					</table>
	       			<table class="search" border="0" width="100%"> 
						<tr class="h23">
							<td width="100%" valign="top">
								
							<!--grid (S)-->
								<table width="100%"  id="mainTable"> 
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('sheet3');</script>
										</td>
									</tr>
								</table>					
							<!--Grid (E)-->
							
							</td>
						</tr>
					</table>
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
				       	<tr>
				       		<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_temp_add">Row&nbsp;Add</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_temp_del">Delete</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_temp_save">Save</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
	    	<!-- Button_Sub (E) -->
       			</td>
       		</tr>
       	</table>
		</div>
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
			<td class="btn1_line"></td>		
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
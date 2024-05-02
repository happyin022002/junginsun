<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0900.jsp
*@FileTitle : B/L Rider
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.16 이진서
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0900Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0900Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoRider");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0900Event)request.getAttribute("Event");
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
<title>B/L Rider</title>
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
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
	                <!-- SEARCH OPT (S)-->		
					<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="40">&nbsp;&nbsp;VVD</td>
							<td width="200" class="sm"><input type="text" style="width:80;" class="input1"  name="vvd_cd" value=""  maxlength='9'  required fullfill  dataformat='engupnum' style="ime-mode:disabled">&nbsp;
							Trunk <input type="checkbox" class="trans" name="trunk_flag" value="Y"></td>
							<td></td>
							<td width="50">Lane</td>
							<td width="100"><input type="text" style="width:80;" class="input" name="lane_cd" value=""  maxlength='3'  dataformat='engupnum' style="ime-mode:disabled"></td>
							<td width="20">Dir</td>
							<td width="" colspan="5"><script language="javascript">ComComboObject('dir_cd', 1, 57, '');</script>&nbsp;<!-- <img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td>
						</tr> 
						<tr class="h23">
							<td>&nbsp;&nbsp;POL</td>
							<td class="sm" width="180" colspan="2">
								<table cellspacing='0' cellpadding='0' border='0'>
								<tr>
									<td><input type="text" style="width:50" value="" name="pol_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input">&nbsp<input type="text" style="width:25" value="" class="input" name="pol_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
									<td>&nbsp;(</td>
									<td><input type="checkbox" class="trans" name="pol_local" value="Y"> </td>
									<td>Local&nbsp;</td>
									<td><input type="checkbox" class="trans" name="pol_ts" value="Y"></td>
									<td>T/S)</td>
								</tr>
								</table>
							</td>
							<td>POD</td>
							<td class="sm" width="200" colspan="2">
								<table cellspacing='0' cellpadding='0' border='0'>
								<tr>
									<td><input type="text" style="width:50" value="" name="pod_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input">&nbsp;<input type="text" style="width:25" value="" class="input" name="pod_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
									<td>&nbsp;(</td>
									<td><input type="checkbox" class="trans" name="pod_local" value="Y"> </td>
									<td>Local&nbsp;</td>
									<td><input type="checkbox" class="trans" name="pod_ts" value="Y"></td>
									<td>T/S)</td>
								</tr>
								</table>
									
							</td>
	
							<td></td>						
							<td width="50">POR</td>
							<td width="80"><input type="text" style="width:50;" class="input" name="por_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" value=""></td>
							<td width="50">DEL</td>
							<td class="sm" width="" >
								<table cellspacing='0' cellpadding='0' border='0'>
								<tr><td>
								<input type="text" style="width:50;" class="input" name="del_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" value="">
								</td></tr>
								</table>
							</td>
						</tr> 
						<!--tr class="h23">
							<td>&nbsp;&nbsp;POR</td>
							<td><input type="text" style="width:50;" class="input" name="por_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" value=""></td>
							<td></td>
							<td>DEL</td>
							<td class="sm" width="200" colspan="2">
								<table cellspacing='0' cellpadding='0' border='0'>
								<tr><td>
								<input type="text" style="width:50;" class="input" name="del_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" value="">
								</td></tr>
								</table>
							</td>
					     </tr--> 
					     
										<table class="search" border="0" style="width:100%;">
										<tr class="h23" align="char">
											<td width="95">1st VVD ETD</td>
											<td width=""><input type="text" style="width: 80"
												value="" class="input1" name="board_from_dt" maxlength='10'
												dataformat="ymd"> &nbsp;~&nbsp; <input type="text"
												style="width: 80" value="" class="input1" name="board_to_dt"
												maxlength='10' dataformat="ymd"> <img class="cursor"
												src="img/btns_calendar.gif" width="19" height="20"
												border="0" align="absmiddle" name="btn_board_date"> <!-- <input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"> -->
											</td>
										    <td width="95">Booking Date</td>
											<td width="" >
											  <input type="text" style="width:80" value="" class="input1"  name="bkg_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="bkg_to_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_bkg_date">
						
											</td>	
											<td width="95">Last VVD ETA</td>
											<td width="" >
											  <input type="text" style="width:80" value="" class="input1"  name="eta_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="eta_to_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_eta_date">
											</td>
										</tr>
									</table>						
										
										<!--table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">Booking Date</td>
											<td width="" >
											  <input type="text" style="width:80" value="" class="input1"  name="bkg_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="bkg_to_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_bkg_date">
						
											</td>
											</tr>
										</table>				
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">Last VVD ETA</td>
											<td width="" >
											  <input type="text" style="width:80" value="" class="input1"  name="eta_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="eta_to_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_eta_date">
											</td>
											</tr>
										</table-->				
										  						
						<TABLE>
							<tr class="h23">
									<td width="95">BKG Office</td>
									<td width="110" class="sm"><input type="text" style="width:50" value="" class="input" name="b_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled">&nbsp;&nbsp;Sub<input type="checkbox" class="trans" name="b_ofc_cd_sub" value="N" onClick="javascript:changeOfcCdSubManual(this)"></td>
									<td width="90">L/Office</td>
									<td width="195" class="sm"><input type="text" style="width:80;" class="input"  maxlength='6' dataformat='engup'  name="l_ofc_cd" value="">&nbsp;&nbsp;Sub <input type="checkbox" class="trans" name="l_ofc_cd_sub" value="Y"></td>
									<td>C/Office</td>
									<td class="sm" colspan="3"><input type="text" style="width:80;" class="input" maxlength='6' dataformat='engup' style="ime-mode:disabled" name="c_ofc_cd" value="">&nbsp;&nbsp;</td>
							</tr>
						</TABLE>
						<table border="0" style="width:100%;" class="search_sm"> 
							<tr class="h23"><td>
												<table class="search" border="0" style="width:100%;">										
													<tr class="h23">
													<td width="115" rowspan="2">Warning - Customer Filtering</td>
													<td  class="sm" width="180"><input type="checkbox" class="trans" name="warn_cust_b" value="B">Blacklisted&nbsp;</td>
													<td  class="sm" width="200"><input type="checkbox" class="trans" name="warn_cust_y" value="Y">Yellow(Previous Mis-declaration)&nbsp;</td>
													<td  class="sm">&nbsp;</td>
													<td  class="sm">&nbsp;</td>
													</tr>
													<tr>
													<td  class="sm"><input type="checkbox" class="trans" name="warn_cust_c" value="C">Charcoal/Calcium Hypochloride&nbsp;</td>
													<td  class="sm"><input type="checkbox" class="trans" name="warn_cust_s" value="S">Sales Approval&nbsp;</td>
													<td  class="sm"><input type="checkbox" class="trans" name="warn_cust_i" value="I">Iran Saction&nbsp;</td>
													<td  class="sm">&nbsp;</td>
													</tr>
												</table>
								</td></tr>
						</table>	
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table border="0" style="width:100%;" class="search_sm"> 
							<tr class="h23"><td>
												<table class="search" border="0" style="width:100%;">										
													<tr class="h23">
													<td width="115" rowspan="2">Warning - Cargo Filtering</td>	
													<td  class="sm"><input type="checkbox" class="trans" name="warn_cargo_p" value="P">Prohibited&nbsp;</td>
													<td  class="sm"></td>
													<td  class="sm"></td>
													</tr>
													<tr>
													<td  class="sm"><input type="checkbox" class="trans" name="warn_cargo_m" value="M">Mis-declared Dangerous&nbsp;</td>
													<td  class="sm"></td>
													<td  class="sm"></td>
													</tr>
												</table>
								</td></tr>
						</table>	
					</table>
	                <!-- SEARCH OPT (E)-->		
					
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
			
			<!-- Grid_2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid_2 (E) -->		
			
			</td></tr>
		</table>
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>	
<!-- 개발자 작업  끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>
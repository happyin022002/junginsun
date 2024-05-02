<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0596.jsp
*@FileTitle : Manual BDR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.21 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0596Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0596Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingMasterMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0596Event)request.getAttribute("Event");
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
<title>Manual BDR</title>
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

<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="vps_port_cd">

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
					<td width="320">
					<table class="search_sm2" border="0" style="width:280;"> 
						<tr class="h23">
						<td width="60">Option</td>
						<td width="" class="stm">
						<input type="radio" name="rdo_trunk_feeder" value="T" class="trans" checked>&nbsp;&nbsp;Trunk Base&nbsp;&nbsp;&nbsp;
						<input type="radio" name="rdo_trunk_feeder" value="S" class="trans">&nbsp;&nbsp;Feeder Base</td>
						</tr>
				</table>
					</td>
					<td width="30">VVD</td>
					<td width="120"><input type="text" name="vvd_cd" style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="uppernum" caption="VVD" maxlength="9" fullfill></td>
					<td width="30">POL</td>
					<td width="100">
						<script language="javascript">ComComboObject('pol_cd', 3, 64, 0,0,0,true);</script>
					</td>
					<td width="30">POD</td>
					<td width="100">
						<script language="javascript">ComComboObject('pod_cd', 1, 64, 0,0,0,true);</script>
					</td>
					<td width="55">BKG No.</td>
					<td width="125">
						<input type="text" style="width:100;" name="bkg_no" value="" class="input" style="ime-mode:disabled" dataformat="uppernum" caption="Booking No." maxlength="13"  fullfill>
					</td>
					<td width="30">BDR</td>
					<td width=""><select name="bdr_flg" style="width:67;">
						<option value="" selected>All</option>
						<option value="N" >No</option>
						<option value="Y">Yes</option>
						</select></td>
				</tr>
				</table>
				
				
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="70">VVD BDR</td>
					<td width="80"><input type="text" name="vvd_bdr" style="width:40;text-align:center" class="input2" value="" readonly></td>
					<td width="90">Total Booking</td>
					<td width="80"><input type="text" name="tot_booking_cnt" style="width:40;text-align:right" class="input2" value="" readonly></td>
					<td width="90">BDR Booking</td>
					<td width=""><input type="text" name="btr_booking_cnt" style="width:40;text-align:right" class="input2" value="" readonly></td>
					</tr>
				</table>
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
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_CheckAll">Check All</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_UncheckAll">Uncheck All</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				</td></tr>
			</table>
	<!-- Grid BG Box  (S) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
	
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BKGBDR">BKG BDR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_VVDBDR">VVD BDR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_C_BKGBDR">BKG BDR Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_C_VVDBDR">VVD BDR Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (E)-->
	
	</td></tr>
		</table>
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
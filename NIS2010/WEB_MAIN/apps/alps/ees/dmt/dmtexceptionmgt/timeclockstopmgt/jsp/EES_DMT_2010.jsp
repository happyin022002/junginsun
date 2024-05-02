<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_dmt_2010.jsp
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
* 2010.11.25 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.event.EesDmt2010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	//EES_DMT_2011 화면에서 팝업으로 호출시에 사용하는 파라미터 
	String  clk_stop_no     = request.getParameter("parm") == null ? "" : (String)request.getParameter("parm");
	String  popup     		= request.getParameter("parm2") == null ? "" : (String)request.getParameter("parm2");

	EesDmt2010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strRhq_ofc_cd 	= "";
	
	String todate = DateTime.getDateString().replace(".","-");
	//out.println("[todate]"+todate);
	//Logger log = Logger.getLogger("com.hanjin.apps.DMTExceptionMgt.TimeClockStopMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 		=	account.getUsr_id();
		strUsr_nm 		= account.getUsr_nm().trim();
		strOfc_cd 		= account.getOfc_cd().trim();
		strRhq_ofc_cd 	= account.getRhq_ofc_cd();
		
	   
	   
		event = (EesDmt2010Event)request.getAttribute("Event");
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
<title>Time Clock Stop Creation</title>
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
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="clk_stop_ofc_cd">
<input type="hidden" name="clk_stop_yd_cd">
<input type="hidden" name="all_yd_flg">
<input type="hidden" name="popup" value="<%=popup %>">
<input type="hidden" name="s_usr_nm" value="<%=strUsr_nm %>">
<input type="hidden" name="s_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="s_cre_dt" value="<%=todate %>">
<input type="hidden" name="rhq_ofc_cd" value="<%=strRhq_ofc_cd %>">
<input type="hidden" name="button_mode">
<input type="hidden" name="auth_yn">
<input type="hidden" name="intg_cd_id" >
<input type="hidden" name="dmdt_bkg_term_ctnt">

<input type="hidden" name="backendjob_key"> <!-- BackEndJob -->
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>

	<!--Page Title, Historical (E)-->
	
	
	<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="95">Clock Stop No. </td>
						<td width="250"><input type="text" style="width:120;text-align:left" class="input" name="clk_stop_no"  value="<%=clk_stop_no %>"></td>
						<td width="65">Status</td>
						<td width=""><input type="text" style="width:80;text-align:left" class="input2" name="cxl_flg" readonly></td>
					</tr>
				
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="77">Tariff Type</td>
						<td width="" style="padding-left:2;">
						<script language="javascript">ComComboObject('combo1', 2, 70 , 0, 1)</script>&nbsp;<input type="text" name="dmdt_trf_nm" style="width:560;text-align:left" class="input2" readonly></td>
					</tr>
					<tr class="h23">
						<td width="">Office</td>
						<td width="" style="padding-left:2;">
						<script language="javascript">ComComboObject('combo2', 2, 70 , 0, 1)</script>&nbsp;<input type="text" name="clk_stop_ofc_nm" style="width:560;text-align:left" class="input2" readonly></td>
					</tr>
					<!-- 2010.11.19. Yard 추가 -->
					<tr class="h23">
						<td width="">Yard</td>
						<td width="" style="padding-left:2;">
						<script language="javascript">ComComboObject('combo3', 2, 70 , 0, 1)</script>&nbsp;<input type="text" name="clk_stop_yd_nm" style="width:560;text-align:left" class="input2" readonly></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="77">Stop Period</td>
						<td width="265">

						<input type="text" style="width:80;" class="input1" name="clk_stop_fm_dt" maxlength="8" dataformat="ymd"  caption="From Date">&nbsp;~
						<input type="text" style="width:80;" class="input1" name="clk_stop_to_dt" maxlength="8" dataformat="ymd"  caption="To Date" >
						<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" >
								
						</td>
						<td width="65">Stop Days</td>
						<td width=""><input type="text" name="stop_days"style="width:40;" class="input2" readonly></td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 	
					<tr class="h23">
						<td width="130">Applicable BKG Term</td>
						<td width="" style="padding-left:2;">
						<script language="javascript">ComComboObject('combo4', 2, 100 , 1, 0)</script></td>
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="77">Date</td>
						<td width="90"><input type="text" name="upd_dt" value="" style="width:75;" class="input2" readonly></td>
						<td width="40">Office</td>
						<td width="140"><input type="text" name="upd_ofc_cd" value="<%=strOfc_cd %>" style="width:60;" class="input2" readonly></td>
						<td width="65">Name</td>
						<td width=""><input type="text" name="upd_usr_id" value="<%=strUsr_nm %>" style="width:300;" class="input2" readonly></td>
					</tr>
				</table>

				<table class="height_2"><tr><td></td></tr></table>
	
				<table class="grid2" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="65" class="tr2_head" >Remark(s)</td>
						<td class="noinput1"><textarea name="clk_stop_rmk" style="width:100%;height:90;ime-mode:disabled;" onKeyPress="DmtComKeyOnlyAlphabet('upperall')" class="textarea1"></textarea></td>
					</tr>
				</table>
				

				
				<!--  biz_1  (E) -->
				
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- hidden 처리 (S)-->

<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- hidden 처리 (E)-->
</form>
</body>
</html>
<!-- 개발자 작업  끝 -->
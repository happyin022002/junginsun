<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0323.jsp
*@FileTitle : H/Bar Inquiry by BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : KIM HYUN JOO
*@LastVersion : 1.0
* 2015.03.17 KIM HYUN JOO
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
<%@ page import="com.hanjin.apps.alps.esd.eas.expnaud.mnraud.event.EsdEas0323Event"%>

<%
	EsdEas0323Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";
	
	// SignOnUserAccount Info
	String usr_id 					= "";
	String strUsr_nm				= "";
	String ofc_cd					= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		ofc_cd      		= account.getOfc_cd();      


		event = (EsdEas0323Event)request.getAttribute("Event");
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
<title>Drop-Off Charge Inquiry</title>
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
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="code_key">
<input type="hidden" name="usr_id" 		value="<%=usr_id%>" >
<input type="hidden" name="ofc_cd" 		value="<%=ofc_cd%>" >
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

			
		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_new" >New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
		 
		<!--biz page (S)-->
 		<table class="search" > 
       	<tr><td class="bg">		
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="10"></td>				
					<td width="100">Flag Duration</td>
					<td width="230" >
						<input type="text" name="s_fm_dt" dataformat="ymd" maxlength="8" size="10" style="width:70;" class="input1">&nbsp;<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						~
						<input type="text" name="s_to_dt" dataformat="ymd" maxlength="8" size="10" style="width:70;" class="input1">&nbsp;<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					
					<td width="20"></td>
					<td width="140">Install Country Code</td>
					<td width="180">
						<input type="text" style="width:50;ime-mode:disabled;" name="s_cnt_cd" maxlength=10 dataformat ="uppernum" class="input1">
					</td>
					
					<td width="30"></td>
					<td width="100">Register Office</td>
					<td width="168">
						<input type="text" style="width:50;ime-mode:disabled;" name="s_reg_ofc_cd" maxlength=10 dataformat ="uppernum" class="input">
					</td>
					
					<td width="11"></td>
				</tr>
			</table>
			<table ><tr><td></td></tr></table>
			<table class="search" border="0" style="width: 979;">		
 				<tr class="h23">
 					<td width="10"></td>
 					<td width="100">POR/POL</td>
					<td width="230">
						<input type="text" style="width:50;" class="input" value="" name="s_loc_cd" dataformat="uppernum" maxlength="5">
						<input type="text" style="width:30;" class="input" value="" name="s_yd_cd" dataformat="uppernum" maxlength="2">
						<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_porl_cd">
					</td>
					
 					<td width="20"></td>
					<td width="141">CNTR No.</td>
					<td class="stm" style="padding-left:2" width="179">
						<input type="text" name="s_cntr_no" maxlength="" size="10"  style="width:150;" class="input" dataformat="uppernum">
						<img src="img/btns_multisearch.gif"	name="btn_cntr_no" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">
					</td>
					
 					<td width="30"></td>
	                <td width="102">Work Order</td>
					<td width="166">
						<script language="javascript">ComComboObject('s_wo_flg',1,80,1,0,0);</script>
					</td>
					<td width="11"></td>
				</tr>
			</table>
		</td></tr>
		</table>

	<table class="height_5"><tr><td></td></tr></table>
	<!-- Grid BG Box  (S) -->
	<table class="search" id="mainTable">
	 	<tr><td class="bg" valign="top">
		<!-- Grid  (S) -->
 		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 
		</td></tr>
	</table> 
	<!-- Button_Sub (E) -->		
<!-- 개발자 작업  끝 -->
			</td>
		</tr>
	</table>
</form>
</body>
</html>
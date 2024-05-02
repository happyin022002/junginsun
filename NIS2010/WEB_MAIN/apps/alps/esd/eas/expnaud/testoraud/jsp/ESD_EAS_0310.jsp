<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0310.jsp
*@FileTitle : Rehandling Expense - TOR vs. TPB
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : KIM HYUN JOO
*@LastVersion : 1.0
* 2015.02.25 KIM HYUN JOO
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
<%@ page import="com.hanjin.apps.alps.esd.eas.expnaud.testoraud.event.EsdEas0310Event"%>

<%
	EsdEas0310Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsdEas0310Event)request.getAttribute("Event");
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
	<%= JSPUtil.getIBCodeCombo("s_bnd_cd", "", "CD00591", 0, "")%>
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
<!-- 					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_save" >Save</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td> -->
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_eacif" >EAC I/F</td>
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
<!-- 					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td> -->
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
					<td width="110">RHQ</td>
					<td width="170">
						<script language="javascript">ComComboObject('s_rhq_ofc_cd',1,80,0,1,0);</script>
					</td>
					
					<td width="30"></td>
					<td width="98">Port/Yard</td>
<!-- 					<td width="170" >
						<script language="javascript">ComComboObject('s_ofc_cd',1,85,0,1,0);</script>
					</td> -->
					
					<td width="172">
						<input name="s_port_cd" type="text" dataformat="uppernum" style="width:50" value="" size="5" maxlength="5" >&nbsp;
						<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
						<script language="javascript">ComComboObject('s_trmnl_cd',2, 60, 1);</script>
					</td>
					
					<td width="30"></td>				
					<td width="90">Duration</td>
					<td width="230" >
						<input type="text" name="s_fm_dt" dataformat="ymd" maxlength="8" size="10" style="width:70;" class="input1">&nbsp;<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						&nbsp;~&nbsp;
						<input type="text" name="s_to_dt" dataformat="ymd" maxlength="8" size="10" style="width:70;" class="input1">&nbsp;<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="39"></td>
				</tr>
			</table>
			<table ><tr><td></td></tr></table>
			
								
							    
							    
			<table class="search" border="0" style="width: 979;">		
 				<tr class="h23">
 					
 					<td width="10"></td>
					<td width="107">BKG Number</td>
					<td class="stm" style="padding-left:2" width="173">
						<input type="text" name="s_bkg_no" maxlength="" size="10"  style="width:100;" class="input" dataformat="uppernum">&nbsp;
						<img src="img/btns_multisearch.gif"	name="btn_bkg_no" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('m_cntr_no')">
					</td>

 					<td width="30"></td>
					<td width="97">CNTR Number</td>
					<td class="stm" style="padding-left:2" width="173">
						<input type="text" name="s_cntr_no" maxlength="" size="10"  style="width:100;" class="input" dataformat="uppernum">&nbsp;
						<img src="img/btns_multisearch.gif" name="btn_cntr_no" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('m_cntr_no')">
					</td>

 					<td width="30"></td>
					<td width="89">VVD</td>
					<td class="stm" style="padding-left:2" width="173">
						<input type="text" name="s_vvd" maxlength="" size="10"  style="width:100;" class="input" dataformat="uppernum">&nbsp;
						<img src="img/btns_multisearch.gif" name="btn_vvd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('m_cntr_no')">
					</td>
					<td width="99"></td>
				</tr>
			</table>
			<table ><tr><td></td></tr></table>
			<table class="search" border="0" style="width: 979;">		
 				<tr class="h23">
 					<td width="10"></td>
	                <td width="110">Restow Reason</td>
					<td width="170">
						<script language="javascript">ComComboObject('s_shift_rsn',1,80,1,0,0);</script>
					</td>
					<td width="30"></td>
					<td width="100">TPB Issue</td>
					<td width="170">
						<script language="javascript">ComComboObject('s_tpb_flg',1,70,1,0,0);</script>
					</td>
					<td width="30"></td>
					<td width="92">EAC I/F</td>
					<td width="168">
						<script language="javascript">ComComboObject('s_eac_if',1,70,1,0,0);</script>
					</td>
					<td width="99"></td>
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
	
	<!-- Grid BG Box  (S) -->
	<script language="javascript">ComSheetObject('t6sheet1');</script>
	<!-- Button_Sub (E) -->		
<!-- 개발자 작업  끝 -->
			</td>
		</tr>
	</table>
</form>
</body>
</html>

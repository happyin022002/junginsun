<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0206.jsp
*@FileTitle : EAC Inquiry Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0206Event"%>

<%
	EsdEas0206Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsdEas0206Event)request.getAttribute("Event");
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
<title>EAC Inquiry Confirm</title>
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
<input type="hidden" name="ofclevel">
<input type="hidden" name="s_apro_sts_cd">
<input type="hidden" name="eac_sts_cd">
<input type="hidden" name="usr_id" 		value="<%=usr_id%>" >
<input type="hidden" name="ofc_cd" 		value="<%=ofc_cd%>" >
<input type="hidden" name="hq_ofc_use_flg" value="Y">
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
							<td class="btn1" name="btn_confirm" >Confirm</td>
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
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="85">RHQ</td>
					<td width="100" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_rhq_ofc_cd',1,100,0,0,0);</script>
					</td>
					
	                <td width="10"></td>
					<td width="80">Audit Office</td>
					<td width="100" style="padding-left:0;">
						<script language="javascript">ComComboObject('s_ofc_cd',1,100,0,0,0,0);</script>
					</td>
					
	                <td width="10"></td>
	                
					<td width="80">Audit Month</td>
					<td width="100" style="padding-left:0;">
						<input type="text" name="s_eac_yrmon" dataformat="ym" maxlength="7" size="10" style="width:68;text-align:center;" class="input1">&nbsp;<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					
					<td width="414"></td>
				</tr>
			</table>
							
			<table class=""><tr><td></td></tr></table>
					
			<table class="search" border="0"  style="width: 979;" >
			<tr class="h23">
				<td width="86">Expense Type</td>
				<td width="100" style="padding-left:1;">
					<script language="javascript">ComComboObject('s_eac_expn_tp_cd',1,100,0,0,0);</script>
				</td>
				
				<td width="10"></td>				
				<td width="80">EAC Type</td>
				<td width="100" style="padding-left:1;">
					<script language="javascript">ComComboObject('s_eac_tp_cd',1,100,1,0,0);</script>
				</td>
				<td width="169" style="padding-left:2;">
					<script language="javascript">ComComboObject('s_eac_bil_tp_cd',1,170,1,0,0);</script>
				</td>
				
			    <td width="10"></td>	
				<td width="92">Amount(US$)</td>
				<td width="121">
					<input name="s_inv_aud_usd_amt" dataformat="float" type="text" style="width:86; text-align:right;" class="input"> Over
				</td>				
			    <td width="10"></td>	
				<td width="101">EAC Duplication</td>
				<td width="50">
					<script language="javascript">ComComboObject('s_eac_dup',1,50,1,0,0);</script>
				</td>				
				<td width="50"></td>
			</tr>
			</table>
										
			<table class=""><tr><td></td></tr></table>
			
			<table class="search" border="0"  style="width: 979;" >
			<tr class="h23">
				<td width="84">S/P Code</td>
				<td width="96">
					<input name="s_vndr_seq" dataformat="int" type="text" style="width:70; text-align:left;" class="input">
					<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vndr_seq">
				</td>
				<td width="134" align="left">
					<input name="s_vndr_nm" type="text" style="width:130; text-align:left;" class="input2" readonly="readonly">
				</td>
				

				<td width="73"></td>
				<td width="70">Keyword</td>
				<td width="91">
					<input name="s_keyword" type="text" style="width:91; text-align:left;" class="input">
				</td>				
				<td width="11"></td>
				<td width="70">Status</td>
				<td width="109">
					<script language="javascript">ComComboObject('s_eac_sts_cd',1,109,1,0,0);</script>
				</td>				
			    <td width="42"></td>	
				<td width="100">TPB Duplication</td>
				<td width="50">
					<script language="javascript">ComComboObject('s_tpb_dup',1,50,1,0,0);</script>
				</td>							
				<td width="49"></td>
			</tr>
			</table>
										
			</td>
		</tr>
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
		<!-- Grid (E) -->
		
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table> 		
		</td></tr>
	</table>
<!-- Grid BG Box  (E) -->

<!-- 개발자 작업  끝 -->
			</td>
		</tr>
	</table>
</form>
</body>
</html>
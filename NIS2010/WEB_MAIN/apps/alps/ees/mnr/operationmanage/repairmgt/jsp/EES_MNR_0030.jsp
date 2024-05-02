<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESS_MNR_0030.jsp
*@FileTitle : W/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009.08.03 WanGyu Kim
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0030Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0030Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EesMnr0030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title><span id="title"></span></title>
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
<input type="hidden" name="cost_ofc_cd" value="<%= strOfc_cd%>">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="selected_vndr_seq">
<input type="hidden" name="mnr_wo_tp_cd" value="EST">
<input type="hidden" name="sel_type" value="M">
<input type="hidden" name="pagerows">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrive">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td id="btn_wo"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name=btn_Creation>W/O Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="bnt_doc"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DocSend">W/O Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	
		<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
			
				<!--  biz  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="105">Status</td>
					<td width="" style="padding-left:0"><script language="javascript">ComComboObject('status', 1, 120, 1, 1);</script></td>
					<td width="60">EQ Type</td>
					<td width="260" style="padding-left:2"><script language="javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 1);</script></td>					
					<td width="90">Approval Date</td>
					<td width=""><input type="text" name="apro_dt_fr" style="width:75" class="input1" caption="from date" requred dataformat="ymd" maxlength="8" cofield="apro_dt_to">
					   &nbsp;~&nbsp;<input type="text" name="apro_dt_to" style="width:75" class="input1" caption="to date" requred dataformat="ymd" maxlength="8" cofield=apro_dt_fr>&nbsp;<img name="apro_dt_cal" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr> 
				<tr class="h23">
					<td width="">Service Provider</td> 
					<td width=""><script language="javascript">ComComboObject('comboVndrSeq', 8, 170, 1, 0,0,false,1);</script></td>
					<td width="">W/O No.</td>	
					<td width=""><input type="text" name="wo_no" style="width:120;" class="input" dataformat="engup" maxlength="200">&nbsp;<img name="wo_no_popup" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">EQ No.</td>
					<td width=""><input type="text" name="rqst_eq_no" style="width:90" class="input" dataformat="engup" maxlength="20"></td>
				</tr> 
				</table>				
							
				<!--  biz   (E) -->

		</td></tr></table>	
		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				
			<!-- grid box -->
			<table class="search">
			<tr><td colspan="2">	
			
				<!-- Title -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Repair Work Order List</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<!-- Title -->
				
				</td></tr>
				
			<tr><td valign="top" width="230">	


					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheetMaster');</script>
							</td>
						</tr>
					</table> 
	
				</td>
				
				<td valign="top" style="padding-left:10px;">	
					
					<!-- Grid  (S) -->
					
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheetDetail');</script>
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
							<td class="btn2" name="btn_Detail">Detail(s)</td>
							<td class="btn2_right"></td> 
							</tr> 
							</table></td>    
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_DownExcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>	
				</tr></table>
			</td></tr>
			</table>
			    	<!-- Button_Sub (E) -->

				
				</td></tr>
			</table>
			
			
		</td></tr>
		</table>			
		<!--biz page (E)-->

	
	

	</td></tr>
		</table>

</form>
</body>
</html>

<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0017.jsp
*@FileTitle : M&R Agreement Attachment_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2014.12.15 Chang Young Kim
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnr0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>

<%
	EesMnr0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	String strAgmtOfcCtyCd	= "";
	String strAgmtSeq		= "";
	String strAgmtVerNo		= "";
	String strFileAtchFlg	= "";
	String strActnFlg		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.test.test");
	
	String csrGwUrl = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		strAgmtOfcCtyCd = JSPUtil.getParameter(request, "agmt_ofc_cty_cd");
		strAgmtSeq = JSPUtil.getParameter(request, "agmt_seq");
		strAgmtVerNo = JSPUtil.getParameter(request, "agmt_ver_no");
		strFileAtchFlg = JSPUtil.getParameter(request, "file_atch_flg");
		strActnFlg = JSPUtil.getParameter(request, "actn_flg");

		event = (EesMnr0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
  
<html>
<head>
<title>M&R Agreement Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<!--MNR 공용 사용  -->       
<script language="javascript">   
	function setupPage(){    
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<body class="popup_bg"  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">

<input type="hidden" name ="agmt_ofc_cty_cd" value="<%=strAgmtOfcCtyCd%>">
<input type="hidden" name ="agmt_seq" value="<%=strAgmtSeq%>">
<input type="hidden" name ="agmt_ver_no" value="<%=strAgmtVerNo%>">
<input type="hidden" name ="file_atch_flg" value="<%=strFileAtchFlg%>">
<input type="hidden" name ="actn_flg" value="<%=strActnFlg%>">

<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   M&R Agreement Attachment_Pop Up</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<!-- <table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				 biz_1  (S)
				<table class="search" border="0" style="width:879;"> 
				<tr class="h23">
					<td width="90">EQ Type</td>
					<td width="140"><script language="javascript">ComComboObject('combo1',1, 100 , 1,1)</script> </td>
					<td width="">Agreement Office</td>
					<td width="130"><script language="javascript">ComComboObject('combo2',1, 100 , 1,1)</script></td>
					<td width="120">Agreement Period</td>
					<td width="" colspan="3">
						<input type="text" style="width:80;" class="input1" name="agmt_fm_dt" dataformat="ymd" maxlength="8"  cofield="agmt_to_dt">&nbsp;~
						<input type="text" style="width:80;" class="input1" name="agmt_to_dt" dataformat="ymd" maxlength="8"  cofield="agmt_fm_dt">&nbsp;
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cre_dt_cal"></td>
				</tr>
					</table>				
				 biz_1   (E)
			
		</td></tr></table> -->
		
		<!-- <table class="height_8"><tr><td></td></tr></table>	 -->
		
		<table class="search" id="mainTable"> 
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
			<div id="div_grp_row" style="display:none">
			<table width="100%" class="button">
			<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btns_add">Row&nbsp;Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btns_del">Row&nbsp;Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					</tr></table>
			</td></tr>
			</table>
			</div>
			<!--  Button_Sub (S) -->
			
			</td></tr>
		</table>
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
			<tr>
				<td>
					<div id="div_grp_new" style="display:none">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
					</tr></table>
					</div>
				</td>
			
				<td id="div_new_line" class="btn1_line" style="display:none"></td>
			
				<td>
					<div id="div_grp_save" style="display:none">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>
					</tr></table>
					</div>
				</td>
				
				<td id="div_save_line" class="btn1_line" style="display:none"></td>
					
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>	
			</tr>
		</table>
		<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
		
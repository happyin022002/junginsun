<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0204.jsp
*@FileTitle : Personnel Config
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
<%@ page import="com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0204Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdEas0204Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";

	// SignOnUserAccount Info
	String usr_id 					= "";
	String strUsr_nm				= "";
	String ofc_cd					= "";
	
	String main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
	String eac_usr_id	 = StringUtil.xssFilter(request.getParameter("EAC_USR_ID"))!=null&&!StringUtil.xssFilter(request.getParameter("EAC_USR_ID")).equals("")?StringUtil.xssFilter(request.getParameter("EAC_USR_ID")):""; 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		ofc_cd      		= account.getOfc_cd();    

		event = (EsdEas0204Event)request.getAttribute("Event");
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
<title>Personnel Config</title>
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
<input type="hidden" name="usr_id" value = "<%=usr_id%>">
<input type="hidden" name="usr_nm" value = "<%=strUsr_nm%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<%if(!main_page.equals("yes")){ %>


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
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
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
							</table>
						</td>

						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_del">Delete</td>
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
				
<%} else { %>


<table width="679" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Personnel Config</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} %>

		<!--biz page (S)-->
		<table class="search"> 
	       	<tr><td class="bg">		
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 679;">
					<tr class="h23">
					    <td width="1"></td>
						<td width="144">Global ID</td>
						<td width="140">
							<input type="text" style="width: 119; text-align:left;" class="input2" name="eac_usr_id" value="<%=eac_usr_id%>"  readonly="readonly"> 
						</td>						
						<td width="40">Name</td>
						<td width="239">
							<input type="text" style="width: 236; text-align:left;" class="input1" name="eac_usr_nm" > 
						</td>
						<td width="115"></td>
	                </tr>					
				</table>		
				<table class="search" border="0" style="width: 679;">		
					<tr class="h23">			
						<td width="144">Audit Scope</td>
						<td width="419">
							<textarea name="expn_aud_scp_desc" rows="4" cols="79" ></textarea> 
						</td>
		                <td width="115"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 679;">		
					<tr class="h23">	
					    <td width="1"></td>
						<td width="144">E-mail</td>
						<td width="341">
							<input type="text"  style="width: 340; text-align:left;" class="input" name="usr_eml"> 
						</td>
		                <td width="193"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 679;">
					<tr class="h23">
					    <td width="1"></td>
						<td width="144">TEL</td>
						<td width="140">
							<input type="text"  style="width: 119; text-align:left;" class="input" name="phn_no"> 
						</td>
						<td width="40">FAX</td>
						<td width="161">
							<input type="text"  style="width: 160; text-align:left;" class="input" name="fax_no"> 
						</td>
						<td width="193"></td>
	                </tr>
				</table>

				<table class="search" border="0" style="width: 679;">		
					<tr class="h23">
					    <td width="1"></td>
						<td width="144">Subject</td>
						<td width="341">
							<input type="text"  style="width: 340; text-align:left;" class="input" name="eml_subj_ctnt"> 
						</td>
		                <td width="193"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 679;">		
					<tr class="h23">			
						<td width="144">Carbon Copy</br> (Internal Reference)</td>
						<td width="419">
							<textarea name="ntc_cc_rcv_eml" rows="3" cols="79" ></textarea> 
						</td>
		                <td width="115"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 679;">		
					<tr class="h23">			
						<td width="144">Body of a Letter</td>
						<td width="419">
							<textarea name="eml_ctnt" rows="4" cols="79" ></textarea> 
						</td>
		                <td width="115"></td>
					</tr>
				</table>
								
	          </td>
			</tr>
		</table>
        <!--biz page (S)-->
<!-- Grid  (S) -->														
<table width="100%" id="mainTable"> 
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</td>
</tr>
</table> 
<!-- Grid (E) -->

<%if(main_page.equals("yes")){ %>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0"
					cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table> 
<%} %>

		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
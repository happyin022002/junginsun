<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0203.jsp
*@FileTitle : Office Config
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
<%@ page import="com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0203Event"%>

<%
	EsdEas0203Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

		event = (EsdEas0203Event)request.getAttribute("Event");
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
<title>Office Config</title>
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
<!-- 						<td> -->
<!-- 							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> -->
<!-- 							<tr> -->
<!-- 								<td class="btn1_left"></td> -->
<!-- 								<td class="btn1" name="btn_new" >New</td> -->
<!-- 								<td class="btn1_right"></td> -->
<!-- 							</tr> -->
<!-- 							</table> -->
<!-- 						</td> -->
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
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
		<table class="search"> 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="101">Office Code</td>
					<td width="250">
						<input type="text" style="width: 100; text-align:center;" class="input2" name="eac_ofc_cd" value="<%=ofc_cd%>" readonly="readonly"> 
					</td>					
					<td width="150">Office Name(External)</td>
					<td width="210">
						<input type="text"  style="width: 202; text-align:left;" class="input1" name="ofc_eng_nm"> 
					</td>					
					<td width="268"></td>
                </tr>					
			</table>		

			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="101">Address</td>
					<td width="610">
						<input type="text"  style="width: 602; text-align:left;" class="input" name="ofc_addr"> 
					</td>
					<td width="268"></td>
                </tr>					
			</table>		

			<table class="search" border="0" style="width: 979;">		
				<tr class="h23">											
					<td width="101">State</td>
					<td width="250">
						<input type="text"  style="width: 200; text-align:left;" class="input" name="ste_nm"> 
					</td>
					
					<td width="150">Zip Code</td>
					<td width="210">
						<input type="text" style="width: 202; text-align:left;" class="input" name="ofc_zip_cd"> 
					</td>
					
					<td width="268"></td>
				</tr>
			</table>

			<table class="search" border="0" style="width: 979;">		
				<tr class="h23">						
					<td width="101">TEL</td>
					<td width="250">
						<input type="text"  style="width: 200; text-align:left;" class="input" name="ofc_phn_no" maxlength="20" > 
					</td>
					
					<td width="150">FAX</td>
					<td width="210">
						<input type="text"  style="width: 202; text-align:left;" class="input" name="ofc_fax_no"> 
					</td>
					
					<td width="268"></td>
				</tr>
			</table>

			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="101">E-mail</td>
					<td width="250">
						<input type="text"  style="width: 200; text-align:left;" class="input" name="ofc_eml"> 
					</td>
					
					<td width="150">Web-address</td>
					<td width="210">
						<input type="text" dataformat="engup" style="width: 202; text-align:left;" class="input" name="eac_ofc_url"> 
					</td>
					
					<td width="268"></td>
				</tr>
			</table>

			<table class="search" border="0" style="width: 979;">		
				<tr class="h23">						
					
					<td width="100">Report Footnote</td>
					<td width="610">
						<textarea name="ftr_ctnt" rows="4" cols="116" ></textarea> 
					</td>
					<td width="269"></td>
				</tr>
			</table>
          </td>
		</tr>
	</table>
<!-- Grid  (S) -->														
<table width="100%" id="mainTable"> 
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</td>
</tr>
</table> 
		</td>
	</tr>
</table>
<!-- Grid (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
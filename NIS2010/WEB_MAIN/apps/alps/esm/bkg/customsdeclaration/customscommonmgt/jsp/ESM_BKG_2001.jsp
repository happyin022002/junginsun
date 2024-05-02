<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BKG_2001.jsp
*@FileTitle : Customs Common Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg2001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg2001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg2001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Customs Common Code</title>
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
<input type="hidden" name="chk_cnt_cd">
<input type="hidden" name="chk_cstms_div_id">
<input type="hidden" name="chk_cnt">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<!-- 	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> -->
<!-- 	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> -->
 <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Customs Hard Coding Setup</td></tr>
</table>
<!--Page Title, Historical (E)-->

			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
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
				<tr>
					<td class="bg">
						<table class="search" border="0" style="width: 100%;">
							<tr class="h23">
								<td width="20">Country</td>
								<td width="100">
									<input type="text" style="width:30; ime-mode:disabled" name="frm_cnt_cd" class="input1" dataformat="engup" maxlength="2" caption="Country Code">
								</td>
								<td width="65">Division ID</td>
								<td width="200">
									<input type="text" style="width:150; ime-mode:disabled" name="frm_cstms_div_id" class="input" dataformat="engup" maxlength="20">
								</td>
								<td width="60">Description</td>
								<td width="200">
									<input type="text" style="width:500; ime-mode:abled" name="frm_cstms_cd_desc" class="input" dataformat="default" maxlength="4000">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- Grid BG Box  (S) -->
	     	<table width="100%" class="search" id="mainTable">
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
				<table width="100%" class="button"> 
	       		<tr>
					<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_RowAdd1">Row&nbsp;Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_RowDel1">Row&nbsp;Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_exceldown1">Down Excel</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_excelup1">Load Excel</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    	<!-- Button_Sub (E) -->	
				
				</td></tr>
			</table>
			<!-- Grid BG Box  (S) -->

	     	<table width="100%" class="search" id="mainTable">
	       	<tr><td class="bg">
				
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>			
				<!-- Grid (E) -->
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
	       		<tr>
					<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_RowAdd2">Row&nbsp;Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_RowDel2">Row&nbsp;Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_exceldown2">Down Excel</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_excelup2">Load Excel</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    	<!-- Button_Sub (E) -->	
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
   
	</td></tr>
		</table>


</form>
</body>
</html>
<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0010.jsp
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.16 
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0702Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0702Event  event = null;					
	Exception serverException   = null;			
	int rowCount	 = 0;						//DB ResultSet 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strErrMsg = "";						
	Logger log = Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.LaneInformationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0702Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Lane Information Creation</title>
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
<input type="hidden" name="vskd_flet_grp_cd">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Lane Group Setting</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table border="0" style="width:340;" class="search_sm2" id="searchHelp"> 
					<tr class="h23">
						<td width="160">Target LRS Lane Select</td>
						<td class="stm">
							<input type="radio" class="trans" name="vsl_svc_tp_cd" value="" checked> All 
							<input type="radio" class="trans" name="vsl_svc_tp_cd" value="1"> Trunk 
							<input type="radio" class="trans" name="vsl_svc_tp_cd" value="2"> Off-line 
						</td>
					</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="search" border="0" style="width:584;" id="sheetBasic">
				<tr><td valign="top" style="padding-top:21;">
						
					<!-- : Grid - 1 (S) -->
				<table width="320"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>					
					<!-- : Grid - 1 (E) -->
				
				</td> 
				
				<td width="44" valign="middle" align="center" style="padding-left:10"style="padding-right:10"><img src="img/btns_add.gif" width="26" height="26" alt="" border="0" name="btn_add"><br><br><img src="img/btns_del.gif" width="26" height="26" alt="" border="0" name="btn_del"></td> 
				
				
				<td valign="top">
				<table class="search" border="0" id="sheetHelp1">
				<TR class="h23">
					<TD>
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s" style="background-color:#F3F2F8;">Main Lane (Include UA Lane)</td></tr>
						</table>
					
					
					
							<!-- : Grid - 2 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="320">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>					
					
					</TD>
				</TR>
				</TABLE>
					<!-- : Grid - 2 (E) -->	
				
				
			
				<table class="search" border="0" id="sheetHelp2">
				<TR>
					<TD>
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">CKY Lane</td></tr>
						</table>
						
							<!-- : Grid - 3 (S) -->
						<table width="320"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>					
					</TD>
				</TR>
				</TABLE>
					<!-- : Grid - 3 (E) -->	
				
				
				<table class="search" border="0" id="sheetHelp3">
				<TR>
					<TD>
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Intra Asia Lane</td></tr>
						</table>
						
							<!-- : Grid - 4 (S) -->
						<table width="320"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet4');</script>
								</td>
							</tr>
						</table>					
					<!-- : Grid - 4 (E) -->	
					</TD>
				</TR>
				</TABLE>
					
				
				<table class="search" border="0" id="sheetHelp4">
				<TR>
					<TD>
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Other Lane</td></tr>
						</table>
						
							<!-- : Grid - 5 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="320">
									<script language="javascript">ComSheetObject('sheet5');</script>
								</td>
							</tr>
						</table>					
							<!-- : Grid - 5 (E) -->	
				
					</TD>
				</TR>
				</TABLE>
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<!--Button (S) -->
		
		</td></tr>
		</table>
    <!--Button (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
					<td class="btn1_line"></td>
					</tr></table></td>
					
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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

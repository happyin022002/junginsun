<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7006.jsp
 *@FileTitle : IHC(Barge/Rail/Truck) tariff copying to other trade
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.10.11
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2012.10.11 서미진
 * 1.0 Creation
 =========================================================*/
%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event.EsmPri7006Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri7006Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.pri.tariff");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();

		event = (EsmPri7006Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>IHC(Barge/Rail/Truck) tariff copying to other trade</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="org_dest_tp_cd" value="<%= JSPUtil.getParameter(request, "org_dest_tp_cd") %>" required="required">
<input type="hidden" name="rhq_cd" value="<%= JSPUtil.getParameter(request, "rhq_cd") %>" required="required">
<input type="hidden" name="cntCd" value="<%= JSPUtil.getParameter(request, "cnt_cd") %>" required="required">
<input type="hidden" name="cd" value="<%= JSPUtil.getParameter(request, "rhq_cd") %>" required="required">
<input type="hidden" name="etc1" value="<%= JSPUtil.getParameter(request, "org_dest_tp_cd") %>">
<input type="hidden" name="etc2" value="<%= JSPUtil.getParameter(request, "cnt_cd") %>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;IHC(Barge/Rail/Truck) tariff copying to other trade</td>
			</tr>
		</table>
	<!-- : ( Title ) (E) -->
	
	<!--biz page (S)-->
	<table class="search">
		<tr>
			<td class="bg">
			<!-- : ( Grid 1) (S) -->
			<table class="search_sm2" border="0" style="width:80;">        	
			<tr class="h23">  
				<td width="" align="center">Original</td>																	
			</tr>                                                                                                                                                                                                                                                                                                                                                                                          
			</table>
			
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- : ( Grid 1) (E) --> 
			
			<!-- : ( Grid 2) (S) -->
			<table class="search_sm2" border="0" style="width:120;">        	
			<tr class="h23">  
				<td width="" align="center">Copying to</td>																	
			</tr>                                                                                                                                                                                                                                                                                                                                                                                          
			</table>
			
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			
			<!--  Button_Sub (S) -->
				<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>														
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete_row">Delete</td>
						<td class="btn2_right"></td>
						</tr></table></td>	
						
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add_row">Row Add</td>
						<td class="btn2_right"></td>
						</tr></table></td>																				
					</tr>
					</table>
				</td></tr>
			  	</table>
			  	<!-- Button_Sub (E) -->		
		  	
			<!-- : ( Grid 2) (E) --> 
			</td>
		</tr>
	</table>
		</td>
	</tr>
</table>

	<!-- Button_Sub (E) -->
	<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
				    	<tr>
				    	    <td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_save">Save</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
				    	    
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_close">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td></tr>
			</table>
		</td></tr>
	</table>
	<!-- Button_Sub (E) -->		
<div id="flagLayer1" style="display:none">		
<table width="100%" id="mainTable">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet4');</script>
		</td>
	</tr>
</table>	
</div>	
</form>
</body>
</html>
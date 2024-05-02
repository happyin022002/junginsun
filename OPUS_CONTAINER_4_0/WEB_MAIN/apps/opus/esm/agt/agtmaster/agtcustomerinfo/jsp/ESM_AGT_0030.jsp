<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_030.jsp
*@FileTitle : FAC Shipper Relationship Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.event.EsmAgt0030Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
EsmAgt0030Event  event = null;                                 //PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;                             //error from server
String strErrMsg = "";                                                  //error message
int rowCount     = 0;                                                   //count of DB resultSET list
//String pageRows  = "100";
String userId 		= "";
String strUsr_nm	= "";
try {
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    userId=account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
	event = (EsmAgt0030Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    if (serverException != null) {
    	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	} else {
    	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} // end else
} catch (Exception e) {
	out.println(e.toString());
}
%>

<html>
<head>
<title>FAC Shipper 관계 관리 화면</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cust_cd">
<input type="hidden" name="sheetId">
<input type="hidden" name="row">
<input type="hidden" name="colNm1">
<input type="hidden" name="colNm2">
</form>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			<!-- TABLE '#D' : ( Button : Main ) (S) -->
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
            	<tr>
            		<td class="btn1_bg">
                    	<table border="0" cellpadding="0" cellspacing="0">
                        	<tr>
                            	<td>
                            		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    	<tr>
                                    		<td class="btn1_left"></td>
                                            <td class="btn1" name="btn_retrieve">Retrieve</td>
                                            <td class="btn1_right"></td>
                                    	</tr>
									</table>
										</td>
                                        	<td class="btn1_line"></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                            <tr><td class="btn1_left"></td>
                                            <td class="btn1" name="btn_save">Save</td>
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
            <!-- TABLE '#D' : ( Button : Main ) (E) -->
			<!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search">
				<tr>
					<td class="bg">
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="5%">Office</td>
								<td>
									<input type="text" name="fac_ofc_cd" class="input1" style="width:100;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="6">
									<a href="javascript:openWindowOffice(document.form);" class="purple"><img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
            <!-- TABLE '#D' : ( Search Options : BKG Information ) (E) -->
			<table class="height_10"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search">
            	<tr>
            		<td class="bg">
                		<table class="height_5"><tr><td></td></tr></table>
                		<!-- : ( grid ) (S) -->
                        <table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
                        </table>
                        <!-- : ( grid ) (E) -->
                        <!-- : ( Button : Sub ) (S) -->
                        <table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
                                	<table border="0" cellpadding="0" cellspacing="0">
                                		<tr>
                                        	<td>
                                        		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                            		<tr>
                                            			<td class="btn2_left"></td>
                                            			<td class="btn2" name="btn2_Row_Add">Row Add</td>
                                            			<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
                                			<td>
                                				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    				<tr>
                                    					<td class="btn2_left"></td>
                                            			<td class="btn2" name="btn2_Row_Copy">Row Copy</td>
                                            			<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
            			<!-- : ( Button : Sub ) (E) -->
					</td>
				</tr>
			</table>
<!-- TABLE '#D' : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
</form>
</body>
</html>
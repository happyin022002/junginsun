<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_9251_02.js
*@FileTitle : RFA Auth Hardcoding Management (Retro) - User Level
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.02
*@LastModifier : Min-Gyung Lee
*@LastVersion : 1.0
=========================================================                                                                                                                                                                                                                                                                                                                                                                                                               
* History                                                                                                                                                                                                                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                                                                                                                                       
=========================================================*/                                                                                                                                                                                                                                                                                                                                                                                                             
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri925102Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri925102Event  event = null;					
	Exception serverException   = null;			
	String strErrMsg = "";						
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.PRIMasterData.AuthorizationAssignment");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri925102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			log.debug(serverException);
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA Auth Hardcoding Management (Retro) - User Level</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	
    function setupPage(){
        var errMessage  = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">
<form name="form">
<input  type="hidden" name="f_cmd">
<input  type="hidden" name="prc_ctrt_tp_cd" value = "R">
<input  type="hidden" name="prc_usr_auth_tp_cd" value = "R">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <table class="height_10"><tr><td></td></tr></table>
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search" border="0">
        <tr>
          <td class="bg">
            <!-- : ( SHEET ) (S) -->
            <table width="100%" id="mainTable" border="0">
              <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
            </table>
            <!-- : ( SHEET ) (E) -->
                  			<!--  Button_Sub (S) -->
			
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowadd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>				
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      

	    	
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->


		<!-- Grid (E) -->
		<table width="100%" class="button">
			<tr>
				<td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0"
									cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
										<td class="btn1_right"></td>
									</tr>
								</table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0"
									cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_save">Save</td>
										<td class="btn1_right"></td>
									</tr>
								</table></td>

						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!--  biz_2   (E) -->

	</form>
</body>
</html>
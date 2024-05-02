<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0112.jsp
*@FileTitle : VVD Status
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* =======================================================
* History : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0112Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmCoa0112Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//Variable for sheet1
	String f_cost_yr = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yr"));
	String f_cost_fm_mon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_fm_mon"));
	
	Logger log = Logger.getLogger("com.clt.apps.WeeklyPFMC.WeeklyCM");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


	}catch(Exception e) {
		log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>VVD Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setRetrieveAction();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cost_yr"     value="<%=f_cost_yr%>">
<input type="hidden" name="f_cost_fm_mon" value="<%=f_cost_fm_mon%>">

<!-- OUTER - POPUP (S)tart -->
<table class="popup" cellpadding="10" border="0" style="width:800;">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">


			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp; VVD Status ( <%=f_cost_yr%>.<%=f_cost_fm_mon%> ) </td></tr>
			</table>
			<!-- : ( Title ) (E) -->
			
		      <!--Button_L (S) -->
		      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		        <tr>
		          <td class="btn1_bg">
		            <table border="0" cellpadding="0" cellspacing="0">
		              <tr>
		                <!-- Repeat Pattern -->
		                <td>
		                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		                    <tr>
		                      <td class="btn1_left"></td>
		                      <td class="btn1" id="btn_monthvvdif" name="btn_monthvvdif">Month VVD I/F</td>
		                      <td class="btn1_right"></td>
		                    </tr>
		                  </table>
		                </td>		
		                <!-- Repeat Pattern -->
		              </tr>
		            </table>
		
		          </td>
		        </tr>
		      </table>
		      <!--Button_L (E) -->


			<!-- : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">


						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td>
								<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->

						<table border="0">
						<tr><td class="sm"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;&nbsp;<b>STATUS Reference</b><br></td></tr>
						<tr><td class="sm" style="padding:1,10;">IF Only : on the side of I/F System only.<br></td></tr>
						<tr><td class="sm" style="padding:1,10;">BOTH : both I/F System and COA System.<br></td></tr>
						<tr><td class="sm" style="padding:1,10;">COA Only : on the side of COA System only.<br></td></tr>
						</table>


					</td>
				</tr>
			</table>
			<!-- : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Save" id="btn_Save">Save</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
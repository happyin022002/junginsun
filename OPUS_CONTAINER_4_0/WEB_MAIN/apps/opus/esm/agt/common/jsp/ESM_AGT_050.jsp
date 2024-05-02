<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_050.jsp
*@FileTitle : Container type Retrieve and multiple Optional(Pop-up)
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
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.ESM_AGT_050Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.ESM_AGT_050EventResponse"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils" %>
<%
	String fac_spcl_cntr_tp_ctnt = "";

	ESM_AGT_050Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	ESM_AGT_050EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//error from server
	DBRowSet rowSet = null;						//DB ResultSet

	String strErrMsg = "";							//error message
	int rowCount	 = 0;							//count of DB resultSET list

	try {
   
		event = (ESM_AGT_050Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ESM_AGT_050EventResponse)request.getAttribute("EventResponse");
			
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();

				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
			
			//Parameters from ESM_AGT_008
			fac_spcl_cntr_tp_ctnt = JSPUtil.getParameter(request, "fac_spcl_cntr_tp_ctnt");

			
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Container type를 Retrieve 및 다중 Optional(Pop-up)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="fac_spcl_cntr_tp_ctnt" value=<%=fac_spcl_cntr_tp_ctnt%>> 


<!-- OUTER - POPUP (S)tart -->
<table width="320" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="300" border="0">
		<tr><td class="title"><img src="/opuscntr/img/ico_t1.gif" width="20" height="12">CNTR Type List</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
		<table class="search">
		<tr><td class="bg_a">

			<table class="search" border="0" style="width:290;">
				<tr class="h23">
					<td width="280" valign="top">
						<table class="search" border="0" style="width:280;">
						<tr class="h23">
							<td>CNTR Type</td>
						</tr>
						</table>

						<!-- : ( Speed ) (S) -->
						<table width="100%" id="mainTable">
							  <tr><td>
							 <script language="javascript">comSheetObject('sheet1');</script>
							  </td></tr>
						</table>
					</td>
				</tr>
			</table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table class="sbutton">
		<tr><td class="p_bt"><img class="cursor" src="/opuscntr/img/button/btn_ok.gif" width="66" height="20" border="0" name="btn_ok"></td>
		<td class="p_bt"><img class="cursor" src="/opuscntr/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>
<%@include file="../../common/include/common.jsp"%>
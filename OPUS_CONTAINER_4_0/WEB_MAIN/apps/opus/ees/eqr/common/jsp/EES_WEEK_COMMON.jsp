<%--/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_WEEK_COMMON.jsp
*@FileTitle : GET WEEK 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-06
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesCommonEvent"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO"%>
<%

	EesCommonEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//error from server
	String strErrMsg = "";							//error message
	
	String scnr_id = "";
	
	
	
	
	try {
	   	//SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	//userId=account.getUsr_id();
		//userAuth=account.getAuth(); 
		
		event = (EesCommonEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				EesCommonVO eesCommonVO = (EesCommonVO)eventResponse.getCustomData("RetVO");
				scnr_id = eesCommonVO.getScnrId();

				
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<!--
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		parent.document.form.scnr_id.value = "<%=scnr_id%>";
		//var opener     = window.dialogArguments; // creating parent object
		//opener.document.form.scnr_id.value = "<%=scnr_id%>";
		//self.close();
	}
//-->
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
</body>
</html>



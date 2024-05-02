<%--/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CURR_WEEK.jsp
*@FileTitle : GET WEEK 
*Open Issues :
*Change history :
*@LastModifyDate :
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
<%

	EesCommonEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//error from server
	//DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//error message
	//int rowCount	 = 0;							//count of DB resultSET list
	//String successFlag = "";
	
	//String result = "";
	String fr_yyyy = "";
	String fr_week = "";
	String to_yyyy = "";
	String to_week = "";
	String[] info = null;
	
	
	
	
	try {
		event = (EesCommonEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				EesCommonVO eesCommonVO = (EesCommonVO)eventResponse.getCustomData("RetVO");
				info = eesCommonVO.getWeekinfo();
				fr_yyyy = JSPUtil.getNull(info[0]);
				fr_week = JSPUtil.getNull(info[1]);
				to_yyyy = JSPUtil.getNull(info[2]);
				to_week = JSPUtil.getNull(info[3]);
				
			
				
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
		//var opener     = window.dialogArguments; // creating parent object
		
		parent.document.form.fr_yyyy.value = "<%=fr_yyyy%>";
		parent.document.form.fr_week.value = "<%=fr_week%>";
		parent.document.form.to_yyyy.value = "<%=to_yyyy%>";
		parent.document.form.to_week.value = "<%=to_week%>";
		
		parent.setCurrWeek();
		  
		
		//opener.document.form.fr_yyyy.value = "<%=fr_yyyy%>";
		//opener.document.form.fr_week.value = "<%=fr_week%>";
		//opener.document.form.to_yyyy.value = "<%=to_yyyy%>";
		//opener.document.form.to_week.value = "<%=to_week%>";
		//opener.setCurrWeek();
		
		//self.close();
		
		
	}
-->
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
</body>
</html>



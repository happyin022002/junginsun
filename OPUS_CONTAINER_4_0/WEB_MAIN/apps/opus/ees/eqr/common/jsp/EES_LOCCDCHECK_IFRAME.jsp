<%--=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LOCCDCHECK_IFRAME.jsp
*@FileTitle :  IFRAME
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================--%>
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
	
	String row 		= "";
	String colname  = "";
	String result   = "";
	String loccd 	= "";
	
	try {
	
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (EesCommonEvent)request.getAttribute("Event");			
			EesCommonConditionVO condiVO = event.getEesCommonConditionVO();
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			EesCommonVO eesCommonVO = (EesCommonVO)eventResponse.getCustomData("RetVO");
			row    = condiVO.getLoccodeRow();
			colname= condiVO.getLoccodeColname();
			loccd  = condiVO.getLocCd();
			
			if(eventResponse != null) {				
				result = eesCommonVO.getLoccdResult();								
			}

			//System.out.println("------------------result : " +result);
			if(result.equals("0")) {
				loccd = "";				
			}	
			
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

		parent.checkEccCode("<%=row%>", "<%=colname%>", "<%=loccd%>");

	}
//-->
</script>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	ype="hidden" name="f_cmd"> 


</form>

</body>
</html>

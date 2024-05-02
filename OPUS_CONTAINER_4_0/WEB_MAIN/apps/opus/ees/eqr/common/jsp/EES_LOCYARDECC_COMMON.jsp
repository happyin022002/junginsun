<%--=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LOCYARDECC_COMMON.jsp
*@FileTitle : retrieving fo rLOC YARD COMBO BOX
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
	EesCommonEvent  event = null;				//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException 				= null;	//error from server
	String strErrMsg 						= "";	//error message
	String row 								= "";
	String search_ecc                       = "";  // search ecc
	String yard_col                         = ""; // yard column
	String ecc_col                          = ""; // ecc column
	String[] locYard 					    = new String[2]; // locYard[0] : yard code, locYard[1] : ecc code
	locYard[0] = "";
	locYard[1] = "";
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		event = (EesCommonEvent)request.getAttribute("Event");
		eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		if(event != null){
			EesCommonConditionVO condiVO = event.getEesCommonConditionVO();
			row      = condiVO.getLocyardRow();
			search_ecc=condiVO.getLocyardEcc();
			yard_col = condiVO.getLocyardColname();
			ecc_col  = condiVO.getLocyardColname1();
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			
			
			
			if (eventResponse != null) {
				
				EesCommonVO eesCommonVO = (EesCommonVO)eventResponse.getCustomData("RetVO");
				
				locYard  = eesCommonVO.getLocyardeccResult();
								
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
				
		parent.checkYardCode_iframe("<%=row%>", "<%= search_ecc %>", "<%=yard_col%>", "<%=ecc_col%>", "<%=locYard[0]%>", "<%=locYard[1]%>");

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

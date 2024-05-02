<%--/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CHECK_PERIOD.jsp
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
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesCommonEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//error from server
	String strErrMsg = "";							//error message
	
	String[] info = null;
	String   info1 = null;
	String yrwk_d = "";
	String fm_yrwk_e= "";
	String to_yrwk_e= "";
	String at_yrwk_e= "";
	String scnr_id= "";
	
	String fm_yr = "";
	String fm_wk = "";
	String to_yr = "";
	String to_wk = "";
	String checkMaxWk = "";
	String checkMaxWkFm = "";
	String checkMaxWkTo = "";
	String checkMaxWkAt = "";
	
	String gubun = request.getParameter("gubun");
	
	try {
	   	
		event = (EesCommonEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				EesCommonVO eesCommonVO = (EesCommonVO)eventResponse.getCustomData("RetVO");
				//Rresent Week   
				info = eesCommonVO.getResultset();
				//From Week별 Scnr_id
				info1 = eesCommonVO.getResultset5();
				
				yrwk_d = JSPUtil.getNull(info[0]);//default
				fm_yrwk_e = JSPUtil.getNull(info[1]);//max 구성.
				to_yrwk_e = JSPUtil.getNull(info[2]);//max 구성.
				at_yrwk_e = JSPUtil.getNull(info[3]);//max 구성.
				scnr_id = JSPUtil.getNull(info1);
				
				if(yrwk_d != null){
					if(yrwk_d.indexOf(",") != -1){
						fm_yr = yrwk_d.substring(0,yrwk_d.indexOf(",")).substring(0,4);
						fm_wk = yrwk_d.substring(0,yrwk_d.indexOf(",")).substring(4,6);
					}
					if(yrwk_d.lastIndexOf(",") != -1){
						to_yr = yrwk_d.substring(yrwk_d.lastIndexOf(",")+1, yrwk_d.length()).substring(0,4);
						to_wk = yrwk_d.substring(yrwk_d.lastIndexOf(",")+1, yrwk_d.length()).substring(4,6);
					}
				}
				
				//checkMaxWk
				if(fm_yrwk_e != null){
					if(fm_yrwk_e.lastIndexOf(",") != -1){
						checkMaxWk = fm_yrwk_e.substring(fm_yrwk_e.lastIndexOf(",")+1, fm_yrwk_e.length());
					}
				}
				/////////////////////////////////////
				if(gubun.equals("FMTOAT")){
					if(fm_yrwk_e != null){
						if(fm_yrwk_e.lastIndexOf(",") != -1){
							checkMaxWkFm = fm_yrwk_e.substring(fm_yrwk_e.lastIndexOf(",")+1, fm_yrwk_e.length());
						}
					}
					if(fm_yrwk_e != null){
						if(fm_yrwk_e.lastIndexOf(",") != -1){
							checkMaxWkTo = to_yrwk_e.substring(to_yrwk_e.lastIndexOf(",")+1, to_yrwk_e.length());
						}
					}
					if(fm_yrwk_e != null){
						if(fm_yrwk_e.lastIndexOf(",") != -1){
							checkMaxWkAt = at_yrwk_e.substring(at_yrwk_e.lastIndexOf(",")+1, at_yrwk_e.length());
						}
					}				
				}
				/////////////////////////////////////

			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String stryrwk_d = "";
	String strfm_yrwk_e = "";
	if(yrwk_d != null){
		stryrwk_d = yrwk_d;
	}
	
	if(fm_yrwk_e != null){
		strfm_yrwk_e = fm_yrwk_e;
	}
%>
<html>
<!--
<head>
-->
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<!--
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if


		if(parent.document.form.scnr_id != null){
			parent.document.form.scnr_id.value = "<%=scnr_id%>";
		}
		
		parent.setCheckWeek("<%=gubun%>");
	}
//-->
</script>
<!--
</head>
-->

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">


<input type="hidden" name="fm_yr" value="<%= fm_yr%>">
<input type="hidden" name="fm_wk" value="<%= fm_wk%>">
<input type="hidden" name="to_yr" value="<%= to_yr%>">
<input type="hidden" name="to_wk" value="<%= to_wk%>">

<input type="hidden" name="checkMaxWk" value="<%= checkMaxWk%>">

<input type="hidden" name="yrwk_d" value="<%= stryrwk_d%>">
<input type="hidden" name="yrwk_e" value="<%= strfm_yrwk_e%>">


<input type="hidden" name="checkMaxWkFm" value="<%= checkMaxWkFm%>">
<input type="hidden" name="checkMaxWkTo" value="<%= checkMaxWkTo%>">
<input type="hidden" name="checkMaxWkAt" value="<%= checkMaxWkAt%>">

<input type="hidden" name="fm_yrwk_e" value="<%=strfm_yrwk_e%>">
<input type="hidden" name="to_yrwk_e" value="<%= to_yrwk_e%>">
<input type="hidden" name="at_yrwk_e" value="<%= at_yrwk_e%>">


</form>


</body>
</html>

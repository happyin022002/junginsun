<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0775.jsp
*@FileTitle : Booking Status Report Result Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.10 김경섭
* 1.0 Creation
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.StatusReport");

	String rfn = JSPUtil.getParameter(request,"rfn","");
	String rp = JSPUtil.getParameter(request,"rp","");
	String rv = JSPUtil.getParameter(request,"rv","");
	String mrd = JSPUtil.getParameter(request,"mrd","");
	String title = JSPUtil.getParameter(request,"rd_title","");
	String rpost = JSPUtil.getParameter(request,"rpost","");
	String print_type = JSPUtil.getParameter(request,"print_type","");
	
    String cookiesJSessionId="";
    Cookie[] cookies = request.getCookies();
      if (cookies != null) {
          for (int loop = 0; loop < cookies.length; loop++) {
                 if (cookies[loop].getName().equals("JSESSIONID")) {
                         cookiesJSessionId=cookies[loop].getValue();
                  }
          }
   }
      
%>
<html>
<head>
<title><%=title %></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>

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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rfn" value="<%=rfn%>">
<input type="hidden" name="rpost" value="<%=rpost%>">
<input type="hidden" name="rp" value="<%=rp%>">
<input type="hidden" name="rv" value="<%=rv%>">
<input type="hidden" name="mrd" value="<%=mrd%>">
<input type="hidden" name="print_type" value="<%=print_type%>">
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
<!-- 개발자 작업	-->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span><%=title %></span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	
	<div class="wrap_result">
		<div class="opus_design_RD"> 
			<script language="javascript">rdViewerObject();</script>
		</div>
	</div>
</div>
</form>
<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESM_AGT_008FR.jsp
*@FileTitle : CM에 제공하기 위한 Unit Cost Insert 및 Retrieve 화면 iFrame
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-08
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-02-08 Hwang GyeongNam
* 1.0 최초 Insert
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil" %>
<%
	String ff_cnt_cd	= "";
	String newRow		= "";

	EsmAgt0008Event event = null;
	Exception serverException = null;				//error from server
	String strErrMsg = "";							//error message
	
	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if(serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			event = (EsmAgt0008Event)request.getAttribute("Event");
			GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			
			if (eventResponse != null) {
//				ff_cnt_cd = JSPUtil.getNull((String)eventResponse.getResult());
				ff_cnt_cd = JSPUtil.getNull(eventResponse.getETCData(ff_cnt_cd));
			}
			
			if(eventResponse != null) {
				newRow = JSPUtil.getNull(eventResponse.getETCData("newRow"));
			}
		}
	}catch(Exception e){
		out.println(e.toString());
	}
%>
<script language="javascript">
	parent.document.form.ff_cnt_cd.value = "<%=ff_cnt_cd%>";
	parent.document.form.newRow.value = "<%=newRow%>";
	parent.addRowData();
</script>
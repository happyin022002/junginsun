<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_009FR.jsp
*@FileTitle : CM에 제공하기 위한 Unit Cost 생성 및 조회 화면 iFrame
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-10
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-10 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.event.ESM_AGT_009Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.event.ESM_AGT_009EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>

<%
	String element		= "";
	String updateDate	= "";
	ESM_AGT_009Event event = null;
	ESM_AGT_009EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB Result)
	Exception serverException = null;				//서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지
	
	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			event = (ESM_AGT_009Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_009EventResponse)request.getAttribute("EventResponse");

			if (eventResponse != null) {
				
				updateDate = JSPUtil.getNull((String)eventResponse.getResult());
				element = JSPUtil.getNull(event.getString("param1"));
				
				if(element.length() > 0) {
%>
<script language="javascript">
	parent.document.form.selUpdateDate.value = "<%=updateDate%>";
	parent.document.form.selPorCd.focus();
</script>
<%					
				}
			}
		}
	}catch(Exception e){
		out.println(e.toString());
	}
%>

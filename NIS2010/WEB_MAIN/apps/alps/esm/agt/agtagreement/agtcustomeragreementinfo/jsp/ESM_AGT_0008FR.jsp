<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESM_AGT_008FR.jsp
*@FileTitle : CM에 제공하기 위한 Unit Cost 생성 및 조회 화면 iFrame
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-08
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-02-08 Hwang GyeongNam
* 1.0 최초 생성
* 2009-09-04 : Ho-Jin Lee : Alps 전환
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil" %>
<%
	String ff_cnt_cd	= "";
	String newRow		= "";

	EsmAgt0008Event event = null;
	Exception serverException = null;				//서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지
	
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
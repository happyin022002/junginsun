<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_015GS2.jsp
*@FileTitle : Brokerage Detail & History fo BL Pop-up 화면 요율 정보 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-08
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-02-08 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event.ESM_AGT_015Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event.ESM_AGT_015EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%
	ESM_AGT_015Event event = null;
	ESM_AGT_015EventResponse eventResponse = null;	// RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				// 서버에서 발생한 에러
	DBRowSet rowSet	= null;							// Database ResultSet (요율 정보)
	String strErrMsg = "";							// 에러메세지
	int rowCount = 0;								// 요율 정보 건수
	int i = 1;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_015Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_015EventResponse)request.getAttribute("EventResponse");
			
			if (eventResponse != null) {

				rowSet = eventResponse.getRs();
				
				if(rowSet != null){
					rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%
	if (serverException == null) {
%>
<SHEET>
	<DATA TOTAL="<%=rowCount%>">
<%
			if (rowSet != null) {
				while (rowSet.next()) {
%>
		<TR>
			<TD></TD>
<%
					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
%>
			<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%
					}
					i = 1;
%>
		</TR>
<%
				}
			}
%>
	</DATA>
</SHEET>
<%
	} else {
%>
<ERROR>
	<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
%>
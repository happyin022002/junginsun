<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_050GS.jsp
*@FileTitle : Container type 조회 및 다중 선택(Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-13
*@LastModifier : Sung-An Jang
*@LastVersion : 1.0
* 2008-03-13 Sung-An Jang
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
<%@ page import="com.hanjin.apps.alps.esm.agt.common.event.ESM_AGT_050Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.event.ESM_AGT_050EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

	ESM_AGT_050Event event = null;
	ESM_AGT_050EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				//서버에서 발생한 에러
	DBRowSet rowSet = null;						    //DB ResultSet
	String strErrMsg = "";							//에러메세지

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_050Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_050EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
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
  <DATA>

<%
		int i =1;
		if (rowSet != null) {
			while (rowSet.next()) {
%>
					<TR>
<%
				//for (int j=0; j<rowSet.getMetaData().getColumnCount(); j++) {
%>						
						<TD></TD>
						<TD></TD>
						<TD><%=JSPUtil.getNull(rowSet.getString(i++))%></TD>
						<TD><%=JSPUtil.getNull(rowSet.getString(i++))%></TD>
						<TD><%=JSPUtil.getNull(rowSet.getString(i++))%></TD>
<%
				//}
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
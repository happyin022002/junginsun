<%--
=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_046GS.jsp
*@FileTitle : Office VS Vendor matching Info
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-18
*@LastModifier : SangJun Kwon
*@LastVersion : 1.0
* 2007-12-18 SangJUn Kwon
* 1.0 최초 생성
=========================================================
--%>

<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.event.ESM_AGT_046Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.event.ESM_AGT_046EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

	ESM_AGT_046Event event = null;
	ESM_AGT_046EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				//서버에서 발생한 에러
	DBRowSet rowSet = null;							//DB ResultSet
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_046Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_046EventResponse)request.getAttribute("EventResponse");
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
			int i =1;
			if (rowSet != null) {
				while (rowSet.next()) {
%>
		<TR>
			<TD></TD>
			<TD>R</TD>
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
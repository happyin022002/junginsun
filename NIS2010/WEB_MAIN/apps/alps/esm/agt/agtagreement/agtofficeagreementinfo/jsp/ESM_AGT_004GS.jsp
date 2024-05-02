<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_004GS.jsp
*@FileTitle : Container type size를 조회 및 다중 선택(Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-20
*@LastModifier : Sang-Jun Kwon
*@LastVersion : 1.0
* 2006-11-30 Sang-Jun Kwon
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
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.ESM_AGT_004Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.ESM_AGT_004EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

	ESM_AGT_004Event event = null;
	ESM_AGT_004EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				//서버에서 발생한 에러
	DBRowSet rowSet1 = null;						//DB ResultSet
	DBRowSet rowSet2 = null;						//DB ResultSet
	DBRowSet rowSet3 = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_004Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_004EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet1 = eventResponse.getRs1();
				rowSet2 = eventResponse.getRs2();
				rowSet3 = eventResponse.getRs3();
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
	<ETC-DATA>
    	<ETC KEY="sxml1">
    		<![CDATA[
    		<?xml version="1.0" ?>
    		<SHEET>
				<DATA>
<%
		int i =1;
		if (rowSet1 != null) {
			while (rowSet1.next()) {
%>
					<TR>
<%
				//for (int j=0; j<rowSet1.getMetaData().getColumnCount(); j++) {
%>						
						<TD></TD>
						<TD></TD>
						<TD></TD>
						<TD><%=JSPUtil.getNull(rowSet1.getString(i++))%></TD>
						<TD><%=JSPUtil.getNull(rowSet1.getString(i++))%></TD>
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
			]]>
    	</ETC>
		<ETC KEY="sxml2">
    		<![CDATA[
    		<?xml version="1.0" ?>
    		<SHEET>
				<DATA>
<%
		i =1;
		if (rowSet2 != null) {
			while (rowSet2.next()) {
%>
					<TR>
<%
				//for (int j=0; j<rowSet2.getMetaData().getColumnCount(); j++) {
%>
						<TD></TD>
						<TD></TD>
						<TD></TD>
						<TD><%=JSPUtil.getNull(rowSet2.getString(i++))%></TD>
						<TD><%=JSPUtil.getNull(rowSet2.getString(i++))%></TD>
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
			]]>
    	</ETC>
		<ETC KEY="sxml3">
    		<![CDATA[
    		<?xml version="1.0" ?>
    		<SHEET>
    			<DATA>
<%
		i =1;
		if (rowSet3 != null) {
			while (rowSet3.next()) {
%>
					<TR>
<%				
				//for (int j=0; j<rowSet3.getMetaData().getColumnCount(); j++) { 
%>
						<TD></TD>
						<TD></TD>
						<TD><%=JSPUtil.getNull(rowSet3.getString("chk_yn"))%></TD>
						<TD><%=JSPUtil.getNull(rowSet3.getString("cntr_tpsz_cd"))%></TD>
						<TD><%=JSPUtil.getNull(rowSet3.getString("cntr_tpsz_desc"))%></TD>
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
			]]>
    	</ETC>
    </ETC-DATA>
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
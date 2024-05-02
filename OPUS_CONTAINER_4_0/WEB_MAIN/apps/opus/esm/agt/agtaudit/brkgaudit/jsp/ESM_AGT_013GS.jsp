<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_013GS.jsp
*@FileTitle : Brokerage Commission Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-11
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-11 Hwang GyeongNam
* 1.0 최초 Insert
=========================================================*/
--%>

<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.ESM_AGT_013Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.ESM_AGT_013EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%

	ESM_AGT_013Event event = null;
	ESM_AGT_013EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				//error from server
	DBRowSet rowSet = null;							//DB ResultSet
	String strErrMsg = "";							//error message
	int rowCount	 = 0;							//count of DB resultSET list

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_013Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_013EventResponse)request.getAttribute("EventResponse");
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

	if (serverException == null) {
%>
<SHEET>
	<DATA TOTAL="<%=rowCount%>">
<%
		String brog_sts = "";
		String td_properties = "";
		String td_properties2 = "";

		int i =1;
		if (rowSet != null) {
			while (rowSet.next()) {
				
				td_properties = ""; //Initialization
				td_properties2 = ""; //Initialization
				
				brog_sts = JSPUtil.getNull(rowSet.getString("COMM_PROC_STS_CD"));
				
				if("CE".equals(brog_sts)) {
					td_properties = "COLOR=\"RED\"";
				} else if("CM".equals(brog_sts)) {
					td_properties = "COLOR=\"BLUE\"";
				}

				td_properties2 = td_properties + " Edit=\"false\"";
				
				if("IF".equals(brog_sts)) {
					td_properties = td_properties + " Edit=\"false\"";
				}			
%>
		<TR>
			<TD <%=td_properties%>>R</TD>
			<TD <%=td_properties%>></TD>
			<TD >R</TD>
			<TD <%=td_properties%>></TD>
<%
				for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
					if(j == 1 || j == 2) {
%>
			<TD <%=td_properties%>><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%
					} else if(j == 8 || j == 9){
						if(brog_sts.equals("CS") || brog_sts.equals("CM")){ 
%>							
			<TD <%=td_properties2%>><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%
						}else{
%>
			<TD <%=td_properties%>><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%							
						}
						
					} else {
%>
			<TD <%=td_properties2%>><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%
					}
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
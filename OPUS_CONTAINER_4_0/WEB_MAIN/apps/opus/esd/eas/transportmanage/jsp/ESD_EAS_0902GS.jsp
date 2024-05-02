<%--
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0902.jsp
*@FileTitle : Manage Remark Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="10kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0902Event"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0902EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%
	EsdEas0902Event event = null;
	EsdEas0902EventResponse eventResponse = null;	 //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;					 //error from server
	DBRowSet rowSet = null;							     //DB ResultSet
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								 //count of DB resultSET list

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
	event = (EsdEas0902Event)request.getAttribute("Event");
	eventResponse = (EsdEas0902EventResponse)request.getAttribute("EventResponse");
	if (eventResponse != null) {
		rowSet = eventResponse.getRowSet();
		if(rowSet != null){
	 rowCount = rowSet.getRowCount();
	 //out.println(rowCount);
		} // end if
	} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%
	if (serverException == null) {
		FormCommand formcommand = event.getFormCommand();

		if( formcommand.isCommand(FormCommand.MULTI) || 
			formcommand.isCommand(FormCommand.ADD) || 
			formcommand.isCommand(FormCommand.MODIFY) || 
			formcommand.isCommand(FormCommand.REMOVE) || 
			formcommand.isCommand(FormCommand.REMOVELIST) ){	
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%
		   } else {	%>
<SHEET>
  <DATA TOTAL="<%=rowCount%>">
<%
			int i = 1;
			if (rowSet != null) {
				if(formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.MULTI01)){
					while (rowSet.next()) {
%>
		<TR>
<%
						for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
%>						
			<TD><![CDATA[<%=rowSet.getString(i++)%>]]></TD>
<%
						}
						i = 1;
%>
		</TR>
<%
					}
				}
			}
%>
  </DATA>
</SHEET>
<%
	}
} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
%>
<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_EAS_009GS.jsp
*@FileTitle : Route UnMatch List
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
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0009Event"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0009EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%
	EsdEas0009Event event = null;
	EsdEas0009EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;					 //error from server
	DBRowSet rowSet = null;							   //DB ResultSet
	String strErrMsg = "";								//error message
	int rowCount	 = 0;								 //count of DB resultSET list

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
	event = (EsdEas0009Event)request.getAttribute("Event");
	eventResponse = (EsdEas0009EventResponse)request.getAttribute("EventResponse");
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
			//String xmlString = "";

			int i =1;
			if (rowSet != null) {

				while (rowSet.next()) {
%>
	<TR>
<%
					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
						//if ( j==10 ) break;
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
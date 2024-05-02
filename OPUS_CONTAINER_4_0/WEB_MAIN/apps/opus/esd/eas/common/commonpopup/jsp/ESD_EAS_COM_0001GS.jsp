<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_COM_0001GS.jsp
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.common.popup.event.EsdEasCom0001Event"%>
<%@ page import="com.clt.apps.opus.esd.eas.common.popup.event.EsdEasCom0001EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%
	SignOnUserAccount account = null; 
	EsdEasCom0001Event event = null;
	EsdEasCom0001EventResponse eventResponse = null;	
	Exception serverException = null;					 
	DBRowSet rowSet = null;							   
	String strErrMsg = "";							
	int rowCount	 = 0;								

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
	event = (EsdEasCom0001Event)request.getAttribute("Event");
	eventResponse = (EsdEasCom0001EventResponse)request.getAttribute("EventResponse");
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
	if( serverException == null ) {
		FormCommand formcommand = event.getFormCommand();
		if( formcommand.isCommand(FormCommand.MULTI) ){	
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%
		} else {	
%>
			<SHEET>
				<DATA TOTAL="<%=rowCount%>">
<%
			if( rowSet != null ) {
				while( rowSet.next() ) {
%>
					<TR>
<%
					for( int j=0; j<rowSet.getMetaData().getColumnCount(); j++ ) {
%>
						<TD></TD>
						<TD><![CDATA[<%=rowSet.getString("OFC_CD_NAME")%>]]></TD>
						<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("OFC_CD"))%>]]></TD>
<%
					} //for end
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
	} else {
%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
%>
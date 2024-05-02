<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_SAQ_CODGS.jsp
*@FileTitle      : Common Code
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.common.common.event.EsmSaqCodEvent"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%

	EsmSaqCodEvent event = null;
    //GeneralEventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;                     //error from server
    DBRowSet rowSet = null;                               //count of DB resultSET list
    String strErrMsg = "";                                //error message
    String xml = "";
	    
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsmSaqCodEvent)request.getAttribute("Event");
            GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
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
        FormCommand formcommand = event.getFormCommand();
        if( formcommand.isCommand(FormCommand.SEARCHLIST)){
%>
<SHEET>
  <DATA TOTAL="">
<%
			if (rowSet != null) {
				String code = null;
				String text = null;
                while (rowSet.next()) {
					code = rowSet.getString("code");
					text = rowSet.getString("text");
%>
    <tr>
        <td>R</td>
        <td></td>
        <td><![CDATA[<%=code%>]]></td>
        <td><![CDATA[<%=text%>]]></td>
    </tr>
<%
                }
            }
%>
  </DATA>
</SHEET>
<%
        } else if( formcommand.isCommand(FormCommand.SEARCHLIST02)){
        	xml = HttpUtil.makeXML(request,response); 
	        xml = xml.replaceAll("\"", "'");
%>
		<%=xml%>
<%
		}
    } else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>
<%--=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0112GS.jsp
*@FileTitle : Exception Office Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2008-08-06 Hun-Il Jung
* 1.0 최초 생성
=========================================================--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0112Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0112EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand" %>
<%
	ESD_SCE_0112Event         event           = null;
    ESD_SCE_0112EventResponse eventResponse   = null;
    Exception                serverException = null;
	DBRowSet                 rowSet          = null;
    String                   strErrMsg       = "";
    int                      rowCount        = 0;
    int                      command         = 0 ;

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event         = (ESD_SCE_0112Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0112EventResponse)request.getAttribute("EventResponse");
            command       = event!=null ? event.getFormCommand().getCommand() : 0 ;
            if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					rowCount = rowSet.getRowCount();
				}
            }
        }
    }catch(Exception e) {
        //serverException = e ;
        //strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        out.println(e.getMessage());
    }

	if (serverException == null) {
		if(command==FormCommand.MODIFY){
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%		}
		else{
%>

<SHEET>


  <DATA TOTAL="<%=rowCount%>">
<%		    if (rowSet != null) {
		        while (rowSet.next()) {
%>
    <TR>
        <TD></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("ofc_cd"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("ofc_eng_nm"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("ofc_type"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("loc_cd"))%>]]></TD>
	</TR>
<%				}
    		}
%>
  </DATA>
 
</SHEET>
<%		}
    } else {
%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>
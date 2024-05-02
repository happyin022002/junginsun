<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0026GS.jsp
*@FileTitle : Exception Type Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-12
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-09-12 Se-Hoon PARK
* 1.0 최초 생성
=========================================================--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0026Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0026EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand" %>
<%
	ESD_SCE_0026Event         event           = null;
    ESD_SCE_0026EventResponse eventResponse   = null;
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
        	event         = (ESD_SCE_0026Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0026EventResponse)request.getAttribute("EventResponse");
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
        <TD></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_expt_tp_cd"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_expt_tp_nm"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_expt_tp_desc"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("upd_usr_id"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("upd_dt"))%>]]></TD>        
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("act_flg"))%>]]></TD>
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
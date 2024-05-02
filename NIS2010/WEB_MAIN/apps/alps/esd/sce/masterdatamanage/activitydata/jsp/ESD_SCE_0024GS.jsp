<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0024GS.jsp
*@FileTitle : COP Scheduling Logic Registration
*Open Issues :
*Change history :
*	2006-11-13 : 요건변경으로 인한 재개발
*@LastModifyDate : 2006-11-13
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
=========================================================--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.event.ESD_SCE_0024Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.event.ESD_SCE_0024EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%
	ESD_SCE_0024Event         event           = null;
    ESD_SCE_0024EventResponse eventResponse   = null;
    Exception                serverException = null;
	DBRowSet                 rowSet          = null;	
    String                   strErrMsg       = "";
    int                      command         = 0;
    int                      rowCount        = 0;

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event         = (ESD_SCE_0024Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0024EventResponse)request.getAttribute("EventResponse");
            command       = event.getFormCommand().getCommand() ;
            if (eventResponse != null) {

				rowSet = eventResponse.getRs();
				if(rowSet != null){
					rowCount = rowSet.getRowCount();
				}
            }
        }
    }catch(Exception e) {
        serverException = e ;
        strErrMsg       = new ErrorHandler(serverException).loadPopupMessage();
        out.println(e.toString());
    }

    if (serverException == null) {
    	if(command == FormCommand.MULTI){
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%    	}
    	else{
%>

<SHEET>
  <DATA TOTAL="<%=rowCount%>">
<%			while (rowSet!=null && rowSet.next()) {%>
	
    <TR>
    	<TD></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("skd_lgc_seq"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("cop_skd_lgc_no"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_cd"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_nm"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("cop_foml_cd"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("foml_tm_hrs"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("foml_pct_no"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("fm_eff_dt"))%></TD>
        <TD EDIT="<%=JSPUtil.getNull(rowSet.getString("to_eff_dt")).equals("")?"true":"false"%>"><%=JSPUtil.getNull(rowSet.getString("to_eff_dt"))%></TD>
	</TR>
<%			}%>
  </DATA>
 
</SHEET>
<%    	}
    } else {
%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>
<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0028GS.jsp
*@FileTitle : Exception Notification Subscriber Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-22 Seong-mun Kang
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0028Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0028EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

    ESD_SCE_0028Event         event           = null;
    ESD_SCE_0028EventResponse eventResponse   = null;
    Exception                serverException = null;
    DBRowSet                 rowSet          = null;
    String                   strErrMsg       = "";
    int                      totalCount      = 0 ;
    int                      command         = 0 ;


    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event         = (ESD_SCE_0028Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0028EventResponse)request.getAttribute("EventResponse");
            command       = event.getFormCommand().getCommand() ;

            if (eventResponse != null) {
                rowSet     = eventResponse.getRowSet();
                totalCount = eventResponse.getTotalCount() ;
            }
        }
    }catch(Exception e) {
        //serverException = e ;
        //strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    	out.println(e.getMessage()) ;
    }

    if (serverException == null) {
    	if( command == FormCommand.SEARCH12) {
		%>
				<EUROFFCD>
		<%
				if( rowSet != null ) {
					
					while( rowSet.next() ) {
		%>
						<OFFCD>
						<sub-sortKey><%=rowSet.getString("OFC_CD")%></sub-sortKey>
						</OFFCD>
		<%					
					}
				}
		%>
					<row-count><%=rowSet.getRowCount()%></row-count>
				</EUROFFCD>
		<%
			} else if(command == FormCommand.MULTI){
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%    	}
    	else{
%>
<SHEET>
  <DATA TOTAL="<%=totalCount%>">
<%
		String szActFlg = "";

		while (rowSet != null && rowSet.next()) {

			szActFlg = 	JSPUtil.getNull(rowSet.getString("ACT_FLG"));
%>

    <TR>
    	<TD></TD>
    	<TD></TD>
    	<TD></TD>
        <TD EDIT="<%="N".equals( szActFlg)?"FALSE":"TRUE"%>"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_EXPT_SUBSC_GRP_CD"))%>]]></TD>
        <TD EDIT="<%="N".equals( szActFlg)?"FALSE":"TRUE"%>"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("NTFD_OFC_CD"))%>]]></TD>
        <TD EDIT="<%="N".equals( szActFlg)?"FALSE":"TRUE"%>"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("NTFD_SUBSC_ID"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("NTFD_SUBSC_NM"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("NTFD_SUBSC_USR_EML"))%>]]></TD>
        <TD EDIT="<%="N".equals( szActFlg)?"FALSE":"TRUE"%>"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("CTRL_OFC_CD"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("UPD_USR_ID"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("UPD_DT"))%>]]></TD>
        <TD><![CDATA[<%=szActFlg%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(String.valueOf(rowSet.getInt("COP_EXPT_SUBSC_CS_SEQ") ) )%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("SUBSC_GRP_NTFD_PTY_CD"))%>]]></TD>
	</TR>
<%			}%>
  </DATA>
</SHEET>
<%		}%>

<%	}else{%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%	}%>
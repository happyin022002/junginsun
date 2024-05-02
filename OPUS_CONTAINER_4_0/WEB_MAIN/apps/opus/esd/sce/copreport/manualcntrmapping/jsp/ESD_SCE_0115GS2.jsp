<%--=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0115GS2.jsp
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-09 Hun-Il Jung
* 1.0 최초 생성
=========================================================--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand" %>
<%@page import="com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.event.ESD_SCE_0115Event"%>
<%@page import="com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.event.ESD_SCE_0115EventResponse"%>
<%
	ESD_SCE_0115Event         event           = null;
    ESD_SCE_0115EventResponse eventResponse   = null;
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
        	event         = (ESD_SCE_0115Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0115EventResponse)request.getAttribute("EventResponse");
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
<%		String dist = "";
		if (rowSet != null) {

	        while (rowSet.next()) {
	        	dist = JSPUtil.getNull(rowSet.getString("DIST"));
	        	if(dist.equals("A")){
%>
    <TR>
        <TD></TD>
        <TD></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_NO"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_NO_SPLIT"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNTR_NO"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("TPSZ_CD"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_CRE_DT"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNTR_VOL_QTY"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNTR_RCV_TERM_CD"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNTR_DE_TERM_CD"))%>]]></TD>
	</TR>
<%				}else if(dist.equals("B")){
%>
    <TR>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_NO"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_NO"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_NO_SPLIT"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNTR_NO"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("TPSZ_CD"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_CRE_DT"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("CRE_DT"))%>]]></TD>
	</TR>
<%
				}
			}
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
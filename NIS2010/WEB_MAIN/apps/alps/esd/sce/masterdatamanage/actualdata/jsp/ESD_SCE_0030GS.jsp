<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0030GS.jsp
*@FileTitle : Actual Source Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-31 Seong-mun Kang
* 1.0 최초생성
=========================================================--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.event.ESD_SCE_0030EventResponse" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>

<%	ESD_SCE_0030EventResponse eventResponse   = null ;
	Exception                serverException = null ;
	DBRowSet                 rowSet          = null ;
	String                   errMsg          = "" ;
	int                      totCnt          = 0 ;
	
	try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if(serverException==null){
            eventResponse = (ESD_SCE_0030EventResponse)request.getAttribute("EventResponse") ;
            if (eventResponse != null) {
                rowSet = eventResponse.getRowSet() ;
                totCnt = eventResponse.getTotalCount() ;
            }
        }
    }catch(Exception e) {
        serverException = e ;
        out.println(e.toString());
    }

    if (serverException == null) {
%>

<SHEET>


  <DATA TOTAL="<%=totCnt%>">
<%		while(rowSet!=null&&rowSet.next()){%>
	
    <TR>
        <TD><%=JSPUtil.getNull(rowSet.getString("cntr_no"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("nod_cd"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_nm"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("vndr_seq"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_rcv_tp_nm"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_sts_mapg_cd"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("edi_msg_tp_cd"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("stnd_edi_sts_cd"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("rcv_date"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("rcv_time"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_date"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_time"))%></TD>                        
        <TD><%=JSPUtil.getNull(rowSet.getString("on_time_ck"))%></TD>    
	</TR>
<%		}%>
  </DATA>
  
</SHEET>
<%
    } else {
    	errMsg = new ErrorHandler(serverException).loadPopupMessage() ;
%>
<ERROR>
<MESSAGE> <![CDATA[ <%=errMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>
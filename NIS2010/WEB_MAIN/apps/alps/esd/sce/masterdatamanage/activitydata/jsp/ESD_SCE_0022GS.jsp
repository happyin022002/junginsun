<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0022GS.jsp
*@FileTitle : Activity Attribute Management
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
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
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.event.ESD_SCE_0022Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.event.ESD_SCE_0022EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

    ESD_SCE_0022Event         event           = null;
    ESD_SCE_0022EventResponse eventResponse   = null;
    Exception                serverException = null;
    DBRowSet                 rowSet          = null;
    int                      command         = 0 ;
    int                      totCnt          = 0 ;
    String                   strErrMsg       = "";

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event         = (ESD_SCE_0022Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0022EventResponse)request.getAttribute("EventResponse");
            command       = event.getFormCommand().getCommand() ;
            if (eventResponse != null) {
                rowSet = eventResponse.getRowSet();
            }
        }
    }catch(Exception e) {
        serverException = e ;
        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        out.println(e.toString());
    }

    if (serverException == null) {
    	if(command == FormCommand.MODIFY){
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%    	}
    	else{
%>
<SHEET>
  <DATA TOTAL="<%=totCnt%>">
<%			while (rowSet!=null && rowSet.next()) {
%>    <TR>
        <TD></TD>
        <TD></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_tp_nm"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_cd"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_nm"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("cop_skd_lgc_no"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_stnd_edi_sts_cd"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("cust_vis_flg"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("VNDR_EV_TOL_HRS"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("VNDR_EV_SVC_CATE_CD"))%></TD>
        <TD><%=JSPUtil.getNull(rowSet.getString("act_flg"))%></TD>
	</TR>
<%			}%>
  </DATA>
</SHEET>
<%		}
	}else{%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%	}%>
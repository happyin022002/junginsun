<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0028GS.jsp
*@FileTitle : Exception Notification Subscriber Registration 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-10 Seong-mun Kang
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0028Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0028EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC" %>
<%

    ESD_SCE_0028Event         event           = null;
    ESD_SCE_0028EventResponse eventResponse   = null;
    RequestDataSetBC         dataSet         = null;
    Exception                serverException = null;
    DBRowSet                 rowSet          = null;
    String                   strErrMsg       = "";
    String                   colName         = null ;
    String                   locName         = "" ;
    int                      row             = 0 ;

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event         = (ESD_SCE_0028Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0028EventResponse)request.getAttribute("EventResponse");
            dataSet       = event.getDataSet() ;
            colName       = dataSet.getString("col_name") ;
            row           = dataSet.getInt("row") ;
            
            if (eventResponse != null) {
                rowSet = eventResponse.getRowSet();
                if(rowSet!=null && rowSet.next()){
                	locName = rowSet.getString("loc_nm") ;
                }
            }

        }
    }catch(Exception e) {
        //serverException = e ;
        //strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    	out.println(e.getMessage()) ;
    }

    if (serverException == null) {
%>
<SHEET>
  <DATA>
    <TR ROW="<%=row%>" >
  		<TD COL="<%=colName%>" DATA-TYPE="dtData"><%=locName%></TD>
    </TR>    
  </DATA>
</SHEET>

<%	}else{%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%	}%>
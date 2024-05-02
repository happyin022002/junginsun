<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0029GS.jsp
*@FileTitle : Exception Tolerance Registration
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
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0029Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0029EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC" %>
<%

    ESD_SCE_0029Event         event           = null;
    ESD_SCE_0029EventResponse eventResponse   = null;
    RequestDataSetBC         dataSet         = null;
    Exception                serverException = null;
    DBRowSet                 rowSet          = null;
    String                   strErrMsg       = "";
    String                   actCode         = "NODATA";
    String                   actCode2        = "NODATA";
    int                      row             = 0 ;

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event         = (ESD_SCE_0029Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0029EventResponse)request.getAttribute("EventResponse");
            dataSet       = event.getDataSet() ;
            row           = dataSet.getInt("row") ;
            
            if (eventResponse != null) {
                rowSet = eventResponse.getRowSet();
                if(rowSet!=null && rowSet.next()){
               		actCode = rowSet.getString("act_cd");
               		actCode2 = rowSet.getString("NXT_ACT_CD");
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
  		<TD COL="r_act_cd1" DATA-TYPE="dtData"><![CDATA[<%=actCode%>]]></TD>
  		<TD COL="r_act_cd2" DATA-TYPE="dtData"><![CDATA[<%=actCode2%>]]></TD>
    </TR>    	
	</DATA>
	
</SHEET>

<%	}else{%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%	}%>
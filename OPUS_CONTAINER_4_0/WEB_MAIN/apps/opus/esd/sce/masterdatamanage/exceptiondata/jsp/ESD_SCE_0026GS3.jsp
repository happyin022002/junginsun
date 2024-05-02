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
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC" %>

<%
ESD_SCE_0026Event         event           = null;
ESD_SCE_0026EventResponse eventResponse   = null;
RequestDataSetBC         dataSet         = null;
Exception                serverException = null;
DBRowSet                 rowSet          = null;
String                   strErrMsg       = "";
String                   rf_cop_expt_tp_dtl_cd   = "" ;
String                   rf_fm_expt_cd    = "" ;
String                   rf_to_expt_cd    = "" ;
String                   rf_validation    = "" ;

int                      row             = 0 ;
/*
		param += "&f_fm_expt_cd=f_fm_expt_cd";
		param += "&f_to_expt_cd=f_to_expt_cd";
		param += "&f_validation=f_validation";            		

*/
try {
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    if (serverException != null) {
        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }else{
        event         = (ESD_SCE_0026Event)request.getAttribute("Event");
        eventResponse = (ESD_SCE_0026EventResponse)request.getAttribute("EventResponse");
        dataSet       = event.getDataSet() ;
        row           = dataSet.getInt("row") ;
        
        if (eventResponse != null) {
            rowSet = eventResponse.getRs();
            if(rowSet!=null && rowSet.next()){
            	rf_cop_expt_tp_dtl_cd = rowSet.getString("f_cop_expt_tp_dtl_cd") ;
            	//if(rf_cop_expt_tp_dtl_cd.substring(0,1).equals("1")){
            		rf_to_expt_cd = rowSet.getString("f_to_expt_cd") ;	
            	//}else{
            		rf_fm_expt_cd = rowSet.getString("f_fm_expt_cd") ;
            	//}
            	rf_validation = rowSet.getString("f_validation") ;
            }
        }

    }
}catch(Exception e) {
    //serverException = e ;
    //strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	out.println(e.getMessage());
}

if (serverException == null) {
%>
<SHEET>
<DATA>
<TR ROW="<%=row%>" >
		<TD COL="f_cop_expt_tp_dtl_cd" DATA-TYPE="dtData"><![CDATA[<%=rf_cop_expt_tp_dtl_cd%>]]></TD>
		<TD COL="f_fm_expt_cd" DATA-TYPE="dtData"><![CDATA[<%=rf_fm_expt_cd%>]]></TD>
		<TD COL="f_to_expt_cd" DATA-TYPE="dtData"><![CDATA[<%=rf_to_expt_cd%>]]></TD>
		<TD COL="f_validation" DATA-TYPE="dtData"><![CDATA[<%=rf_validation%>]]></TD>
</TR>    
</DATA>
</SHEET>

<%	}else{%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%	}%>
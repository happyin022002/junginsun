<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0034GS.jsp
*@FileTitle : Visibility Subscriber Information Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-10-30 SeongMun_Kang
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.visibilitydata.event.ESD_SCE_0034EventResponse" %>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler" %>
<%@ page import="com.clt.framework.component.rowset.DBRowSet" %>
<%@ page import="com.clt.framework.component.util.JSPUtil" %>

<%
	ESD_SCE_0034EventResponse eventResponse   = null ;
	Exception				 serverException = null ;
	String					 strErrMsg       = null ;
	DBRowSet				 rowSet		     = null ;
	int					     totCnt		     = 0 ;
	

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ESD_SCE_0034EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRowSet();
				totCnt = eventResponse.getTotalCount();
			}
		}
	}catch(Exception e) {
		//serverException = e ;
		//strErrMsg = new ErrorHandler(e).loadPopupMessage() ;
		out.println();
	}

%>
<%
	if (serverException == null) {
		
%>
	   
<SHEET>
	<DATA TOTAL="<%=totCnt%>">
<%		while(rowSet!=null&&rowSet.next()){%>
		<TR>
		<TD></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("crm_cust_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("sc_no"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cust_tp_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("conti_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("sconti_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cnt_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("por_del_div_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("loc_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cntc_pson_id"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("phn_no"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("vis_eml"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("fax_no"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("snd_cyc_hr"))%>]]></TD>
	</TR>
<%		}%>
  </DATA>
</SHEET>
<%	
	} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
	
%>
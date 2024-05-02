<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0069GS.jsp
*@FileTitle :  Train & Rail Car Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-11-16 SeongMun_Kang
* 1.0 최초 생성
=========================================================*/
%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copreplan.event.ESD_SCE_0069EventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC" %>

<%

	ESD_SCE_0069EventResponse eventResponse   = null ;
	RequestDataSetBC         dataSet         = null ;
	Exception				 serverException = null ;
	String					 strErrMsg       = null ;
	DBRowSet				 rowSet		     = null ;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ESD_SCE_0069EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet  = eventResponse.getRowSet();
				dataSet = eventResponse.getDataSet();
			}
		}
	}catch(Exception e) {
		out.println(e.getMessage());
	}

	if (serverException == null) {
%>
	    
<SHEET>
	<DATA >
<%		for(int i=0; rowSet!=null&&rowSet.next(); i++){%>
		<TR>
			<TD> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_RCV_DT"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_NO"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_NO_SPLIT"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("UMCH"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_NO"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNTR_NO"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNTR_TPSZ_CD"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_STS_CD"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_SUB_STS_CD"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_OFC_CD"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("STATUS"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("PND"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("REP_MAN"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("CFM_FLG"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("CUR_ACT"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_RCV_NO"))%>]]> </TD>			
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
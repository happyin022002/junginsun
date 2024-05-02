<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0071GS.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : minestar
*@LastVersion : 2.0
* 2008-03-03 minestar
* 1.0 최초 생성
* 2009-03-10 JSAN [N200903100120] [SCEM] COP History 화면 보완 요청; Event Date 컬럼을 Event 컬럼의 우측에 위치
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@page import="com.clt.apps.opus.esd.sce.copreport.cophsitory.event.ESD_SCE_0071EventResponse"%>
<%@page import="com.clt.framework.component.rowset.DBRowSet"%>

<%
    ESD_SCE_0071EventResponse eventResponse   = null;
    String                   strErrMsg       = "" ;
    Exception                serverException = null;
	DBRowSet 				 rowSet = null;

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (ESD_SCE_0071EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
				rowSet = eventResponse.getRs();
            } // end if
        } // end else
    }catch(Exception e) {
        serverException = e ;
        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        out.println(e.toString());
    }
	if (serverException == null) {
%>
<%@page import="com.clt.framework.component.util.JSPUtil"%>
<SHEET>
	<DATA>
	<%		for(int i=0; rowSet!=null&&rowSet.next(); i++){
%>
		<TR>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("SEQ"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("COP_NO"))%>]]></TD>
			<TD><![CDATA[ <%=( "COMU0000000".equals( JSPUtil.getNull(rowSet.getString("CNTR_NO")))?"":JSPUtil.getNull(rowSet.getString("CNTR_NO")))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("BKG_NO"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("BKG_NO_SPLIT"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("EVENT"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("CRE_DT"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("CNTR_TPSZ_CD"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("MST_LCL_CD"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("BKG_STS_CD"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("COP_STS_CD"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("COP_SUB_STS_CD"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("R_TERM"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("OB_ROUTE"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("OCN_ROUTE"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("IB_ROUTE"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("D_TERM"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("CRE_USR_ID"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("CRE_OFC_CD"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("UMCH_STS_CD"))%>]]></TD>		
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("OB_BKG_TRO_NO"))%>]]></TD>		
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("IB_BKG_TRO_NO"))%>]]></TD>		
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
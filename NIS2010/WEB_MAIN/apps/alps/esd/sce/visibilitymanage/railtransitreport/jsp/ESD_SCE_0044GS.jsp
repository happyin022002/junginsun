<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_044GS.jsp
*@FileTitle :  Car Location Message (Pop)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-12-06 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.ESD_SCE_0044EventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>

<%
	ESD_SCE_0044EventResponse eventResponse   = null ;
	Exception				 serverException = null ;
	DBRowSet				 rowSet		     = null ;
	String					 strErrMsg       = null ;
	String                   cntrTpszCd      = "" ;
	String                   cntrNo          = "" ;
	int						 totalCount		 = 0 ;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ESD_SCE_0044EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet     = eventResponse.getRowSet();
				totalCount = eventResponse.getTotalCount() ;
			}
		}
	}catch(Exception e) {
		//serverException = e ;
		//strErrMsg = new ErrorHandler(e).loadPopupMessage() ;
		out.println(e.getMessage());
	}

	if (serverException == null) {
%>
	   
<SHEET>
	<DATA TOTAL="<%=totalCount%>">
<%		for(int i=0; rowSet!=null&&rowSet.next(); i++){
			if(i==0){
				cntrTpszCd = JSPUtil.getNull(rowSet.getString("cntr_tpsz_cd")) ;
				cntrNo     = JSPUtil.getNull(rowSet.getString("cntr_no")) ;
			}  
%>
		<TR>
			<TD></TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("full_mty_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("clm_sght_abbr_nm"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("loc_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("arr_ste_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("arr_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("arr_time"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("clm_crr_nm"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("trsp_mod_tp_cd"))%>]]> </TD>
	
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("fm_nod_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("fm_ste_cd"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("to_nod_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("to_ste_cd"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("dep_loc_nm"))%>]]> </TD>
	 		
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("trn_no"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("fcar_no"))%>]]> </TD>
		</TR>
<%		}%>
	</DATA>
	<ETC-DATA>
		<ETC NAME="cntr_tpsz_cd"><%=cntrTpszCd%></ETC>  
		<ETC NAME="cntr_no"><%=cntrNo%></ETC>  
	</ETC-DATA>

</SHEET>
<%	
	} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
	
%>
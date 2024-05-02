<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_043GS.jsp
*@FileTitle :  Car Location Message Inquiry
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
<%@ page import="com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.event.ESD_SCE_0043EventResponse" %>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler" %>
<%@ page import="com.clt.framework.component.rowset.DBRowSet" %>
<%@ page import="com.clt.framework.component.util.JSPUtil" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC" %>

<%
	ESD_SCE_0043EventResponse eventResponse   = null ;
	RequestDataSetBC         dataSet         = null ;
	Exception				 serverException = null ;
	String					 strErrMsg       = null ;
	String                   cntrTpszCd      = "" ;
	DBRowSet				 rowSet		     = null ;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ESD_SCE_0043EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet  = eventResponse.getRowSet();
				dataSet = eventResponse.getDataSet();
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
	<DATA TOTAL="<%=dataSet.getInt("total_count")%>">
<%		for(int i=0; rowSet!=null&&rowSet.next(); i++){
			if(i==0){
				cntrTpszCd = JSPUtil.getNull(rowSet.getString("cntr_tpsz_cd")) ;
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
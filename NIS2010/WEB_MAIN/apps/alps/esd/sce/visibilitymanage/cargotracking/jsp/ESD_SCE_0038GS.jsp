<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0038GS.jsp
*@FileTitle : US Cargo Tracking
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-24
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-11-24 SeongMun_Kang
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.event.ESD_SCE_0038EventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC" %>

<%
	ESD_SCE_0038EventResponse eventResponse   = null ;
	Exception				 serverException = null ;
	String					 strErrMsg       = null ;
	int                      totalCount      = 0 ;
	DBRowSet				 rowSet		     = null ;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ESD_SCE_0038EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet     = eventResponse.getRowSet();
				totalCount = eventResponse.getTotalCount();
				
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
<%		for(int i=0; rowSet!=null&&rowSet.next(); i++){%>
		<TR>
			<TD></TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("cop_no"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("trsp_so_ofc_cty_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("trsp_so_seq"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("eq_no"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("ts"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("bkg_no"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("bkg_no_split"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("vvd"))%>]]> </TD>

			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("por_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("pol_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("pod_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("del_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("rd_term_cd"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("local_ipi"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("c_act"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("c_act_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("c_act_time"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("nod"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("vd_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("vd_time"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("f"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("o"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("c"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("hold"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("hold_r_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("hold_r_time"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("l_free_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("l_free_time"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("hot"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("rail_com"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("fm_nod_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("rail_etd_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("rail_etd_time"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("org_out_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("org_out_time"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("to_nod_cd"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("rail_eta_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("rail_eta_time"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("dest_in_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("dest_in_time"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("l_rail_loc"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("l_rail_ata_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("l_rail_ata_time"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("pick_up_avail"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("gate_out_etd_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("gate_out_etd_time"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("door_eta_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("door_eta_time"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("door_ata_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("door_ata_time"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("expt_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("expt_time"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("occr_nod_cd"))%>]]> </TD>
			
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("sts_desc"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("etd_rail_date"))%>]]> </TD>
			<TD> <![CDATA[ <%=JSPUtil.getNull(rowSet.getString("etd_rail_time"))%>]]> </TD>
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
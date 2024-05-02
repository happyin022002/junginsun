<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0045GS.jsp
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
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.ESD_SCE_0045EventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>

<%
	ESD_SCE_0045EventResponse eventResponse   = null ;
	DBRowSet                 rowSet          = null ;
	Exception				 serverException = null ;
	String					 strErrMsg       = null ;
	int                      totalCount      = 0 ;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ESD_SCE_0045EventResponse)request.getAttribute("EventResponse");
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
<%		while(rowSet!=null&&rowSet.next()){%>
		<TR>
			<TD></TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("eq_no"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("eq_tpsz_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("cgo_tp_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("vvd_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("bkg_no")+rowSet.getString("bkg_no_split"))%>]]> </TD>
			 
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("mst_bl_no"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("sc_no"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("cre_date")+" "+rowSet.getString("cre_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("swo_iss_date")+" "+rowSet.getString("swo_iss_time"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("usa_edi_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("wo_vndr_seq"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("fm_nod_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("to_nod_cd"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("trsp_bnd_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("bkg_hot_de_flg"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("cgor_frt_pay_ind_flg"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("cgor_org_bl_rcvr_ind_flg"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("cstms_acpt_flg"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("c_date")+" "+rowSet.getString("c_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("ib_ipi_locl_ind_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("ibd_cstms_clr_loc_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("nod_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("vd_date")+" "+rowSet.getString("vd_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("hld_flg"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("hld_rmk"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("tml_dwll_tm_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("tml_dep_flg"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("org_splc_loc_nm"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("org_gate_in_date")+" "+rowSet.getString("org_gate_in_time"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("org_dwll_tm_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("org_dep_flg"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("org_gate_out_date")+" "+rowSet.getString("org_gate_out_time"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("itchg_arr_splc_loc_nm"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("chg_arr_in_date")+" "+rowSet.getString("chg_arr_in_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("itchg_n1st_dwll_tm_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("itchg_n1st_dep_flg"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("itchg_splc_loc_nm"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("chg_date")+" "+rowSet.getString("chg_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("itchg_n2nd_dwll_tm_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("itchg_n2nd_dep_flg"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("chg_out_date")+" "+rowSet.getString("chg_out_time"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("dest_loc_nm"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("dest_in_date")+" "+rowSet.getString("dest_in_time"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("dest_n1st_dwll_tm_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("dest_n1st_dep_flg"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("dest_avail_date")+" "+rowSet.getString("dest_avail_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("dest_n2nd_dwll_tm_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("dest_n2nd_dep_flg"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("dest_out_date")+" "+rowSet.getString("dest_out_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_run_tm_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_tztm_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("arr_loc_nm"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("arr_ste_cd"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("evnt_date")+" "+rowSet.getString("evnt_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("crnt_dwll_tm_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("trn_no"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("fcar_no"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("cntr_seal_no"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("itchg_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_co_itchg_pnt_eta_dt"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_itchg_n1st_eta_date")+" "+rowSet.getString("rail_itchg_n1st_eta_time"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_itchg_n2nd_eta_date")+" "+rowSet.getString("rail_itchg_n2nd_eta_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("dwll_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_itchg_n1st_etd_date")+" "+rowSet.getString("rail_itchg_n1st_etd_time"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_itchg_n2nd_etd_date")+" "+rowSet.getString("rail_itchg_n2nd_etd_time"))%>]]> </TD>
 			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("avg_tz_hrs"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_co_dest_pnt_eta_dt"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_dest_n1st_eta_date")+" "+rowSet.getString("rail_dest_n1st_eta_time"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("rail_dest_n2nd_eta_date")+" "+rowSet.getString("rail_dest_n2nd_eta_time"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("tztm_diff_hrs"))%>]]> </TD>
			<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("shpr_nm"))%>]]></TD>
			<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cnee_nm"))%>]]></TD>
			<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("ntfy_nm"))%>]]></TD>

			<TD></TD>
			<TD></TD>
		
 			<TD></TD>
 			<TD></TD>
 			<TD></TD>

		</TR>
<%		}%>
	</DATA>
	
<%			if(totalCount>0){%>
	<ETC-DATA>
	    <ETC NAME="totcnt"><![CDATA[<%=totalCount%>]]></ETC>
	</ETC-DATA>
<%			}%>			
 
</SHEET>
<%	
	} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
	
%>
﻿<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0024.jsp
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.12.06 poong_yeon
* 1.0 최초 생성
*---------------------------------------------------------
* History
* 2010.09.16 최 선 [] 1.1 TRO 에서  UI 호출시  Reset, Confirm, Print 버튼 숨김
* 2011.02.08 이재위 1.17 [CHM-201108673-01] [TRS] Work Order Issue : W/O Preview per B/L 기능 개발
* 2011.05.06 손은주 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.11.17 민정호 [CHM-201114481] [TRS] W/O preview 상에 표현가능한 e-mail, fax 정보 room 확장요청
* 2011.12.22 민정호 [CHM-201115196] [TRS] W/O ISSUE시 S/O History에 agmt no 정보를 남길 수 있도록 기능 수정
* 2012.07.20 김종호 [] [TRS] W/O preview 화면에서 최종 confirm 시 로그인ofc와 S/O지역코드를 비교하기 위한 로직 추가
* 2013.05.06 조인영 [CHM-201324442] [TRS] wo preview 화면에서 e-Mail default 처리
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%!
	private ArrayList splitStr(String src, String delim)
	{
		if(src == null || src.equals("")) return null;
		ArrayList returnV = new ArrayList();

		StringTokenizer st = new StringTokenizer(src, delim);
		String tempNo = null;

		while (st.hasMoreTokens()) {
			tempNo = st.nextToken();
			returnV.add(tempNo);
		}

		if (returnV.size() == 0) returnV.add(src);
		return returnV;
	}
%>

<%
	EsdTrs0024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	SignOnUserAccount account = null;
	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0024Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);
		
	ArrayList trsp_so_ofc_cty_cd = splitStr(StringUtil.xssFilter(request.getParameter("trsp_so_ofc_cty_cd")),",");
	ArrayList trsp_so_seq = splitStr(StringUtil.xssFilter(request.getParameter("trsp_so_seq")),",");
	ArrayList wo_cancel_flag = splitStr(StringUtil.xssFilter(request.getParameter("wo_cancel_flag")),",");
	ArrayList dtn_use_flg = splitStr(StringUtil.xssFilter(request.getParameter("dtn_use_flg")),",");
	ArrayList wo_bl_no_iss_flg = splitStr(StringUtil.xssFilter(request.getParameter("wo_bl_no_iss_flg")),",");
	ArrayList vndr_seq = splitStr(StringUtil.xssFilter(request.getParameter("vndr_seq")),",");
	ArrayList curr_cd = splitStr(StringUtil.xssFilter(request.getParameter("po_local_curr_cd")),",");
	ArrayList bzc_amt = splitStr(StringUtil.xssFilter(request.getParameter("po_basic_rt")),",");
	ArrayList nego_amt = splitStr(StringUtil.xssFilter(request.getParameter("nego_amt")),",");
	ArrayList etc_add_amt = splitStr(StringUtil.xssFilter(request.getParameter("etc_add_amt")),",");
	ArrayList fuel_scg_amt = splitStr(StringUtil.xssFilter(request.getParameter("po_fuel_scg_rt")),",");
	ArrayList scg_vat_amt = splitStr(StringUtil.xssFilter(request.getParameter("po_vat_scg_rt")),",");
	ArrayList toll_fee_amt = splitStr(StringUtil.xssFilter(request.getParameter("toll_fee_amt")),",");
	ArrayList n3pty_bil_flg = splitStr(StringUtil.xssFilter(request.getParameter("n3pty_bil_flg")),",");

	ArrayList po_usd_curr_tot_amt = splitStr(StringUtil.xssFilter(request.getParameter("po_usd_curr_tot_amt")),",");
	
	// GuideLine Rate
	ArrayList gline_vndr_seq = splitStr(StringUtil.xssFilter(request.getParameter("gline_vndr_seq")),",");
	ArrayList gline_curr_cd = splitStr(StringUtil.xssFilter(request.getParameter("gline_po_local_curr_cd")),",");
	ArrayList gline_bzc_amt = splitStr(StringUtil.xssFilter(request.getParameter("gline_po_basic_rt")),",");
	ArrayList gline_nego_amt = splitStr(StringUtil.xssFilter(request.getParameter("gline_nego_amt")),",");
	ArrayList gline_etc_add_amt = splitStr(StringUtil.xssFilter(request.getParameter("gline_etc_add_amt")),",");
	ArrayList gline_fuel_scg_amt = splitStr(StringUtil.xssFilter(request.getParameter("gline_po_fuel_scg_rt")),",");
	ArrayList gline_scg_vat_amt = splitStr(StringUtil.xssFilter(request.getParameter("gline_po_vat_scg_rt")),",");
	ArrayList gline_toll_fee_amt = splitStr(StringUtil.xssFilter(request.getParameter("gline_toll_fee_amt")),",");
	ArrayList gline_po_usd_curr_tot_amt = splitStr(StringUtil.xssFilter(request.getParameter("gline_po_usd_curr_tot_amt")),",");
	// GuideLine Rate
	
	ArrayList cust_cnt_cd = splitStr(StringUtil.xssFilter(request.getParameter("cust_cnt_cd")),",");
	ArrayList cust_seq = splitStr(StringUtil.xssFilter(request.getParameter("cust_seq")),",");
	ArrayList cust_nomi_trkr_flg = splitStr(StringUtil.xssFilter(request.getParameter("cust_nomi_trkr_flg")),",");
	ArrayList cust_nomi_trkr_ind_cd = splitStr(StringUtil.xssFilter(request.getParameter("cust_nomi_trkr_ind_cd")),",");
	ArrayList trsp_sp_cng_rsn_cd = splitStr(StringUtil.xssFilter(request.getParameter("trsp_sp_cng_rsn_cd")),",");
	ArrayList trsp_sp_cng_rsn_rmk = splitStr(StringUtil.xssFilter(request.getParameter("trsp_sp_cng_rsn_rmk")),",");
	ArrayList agmt_mor_cnddt_aply_flg = splitStr(StringUtil.xssFilter(request.getParameter("agmt_mor_cnddt_aply_flg")),",");
	ArrayList trsp_agmt_rt_tp_cd = splitStr(StringUtil.xssFilter(request.getParameter("trsp_agmt_rt_tp_cd")),",");
	ArrayList trsp_agmt_wy_tp_cd = splitStr(StringUtil.xssFilter(request.getParameter("trsp_agmt_wy_tp_cd")),",");

	ArrayList trsp_frst_flg = splitStr(StringUtil.xssFilter(request.getParameter("trsp_frst_flg")),",");
	ArrayList trsp_rjct_rsn_cd = splitStr(StringUtil.xssFilter(request.getParameter("trsp_rjct_rsn_cd")),",");
	ArrayList trsp_dflt_vndr_flg = splitStr(StringUtil.xssFilter(request.getParameter("trsp_dflt_vndr_flg")),",");

	ArrayList trsp_wo_ofc_cty_cd = splitStr(StringUtil.xssFilter(request.getParameter("trsp_wo_ofc_cty_cd")),",");
	ArrayList trsp_wo_seq = splitStr(StringUtil.xssFilter(request.getParameter("trsp_wo_seq")),",");

	ArrayList n1st_nod_pln_dt = splitStr(StringUtil.xssFilter(request.getParameter("n1st_nod_pln_dt")),",");
	ArrayList lst_nod_pln_dt = splitStr(StringUtil.xssFilter(request.getParameter("lst_nod_pln_dt")),",");
	ArrayList dor_nod_pln_dt = splitStr(StringUtil.xssFilter(request.getParameter("dor_nod_pln_dt")),",");
	ArrayList inter_rmk = splitStr(StringUtil.xssFilter(request.getParameter("inter_rmk")),",");
	ArrayList spcl_instr_rmk = splitStr(StringUtil.xssFilter(request.getParameter("spcl_instr_rmk")),",");
	ArrayList nego_rmk = splitStr(StringUtil.xssFilter(request.getParameter("nego_rmk")),",");

	ArrayList form_fctry_nm = splitStr(StringUtil.xssFilter(request.getParameter("form_fctry_nm")),",");
	ArrayList form_dor_pst_cd = splitStr(StringUtil.xssFilter(request.getParameter("form_dor_pst_cd")),",");
	ArrayList form_cntc_pson_phn_no = splitStr(StringUtil.xssFilter(request.getParameter("form_cntc_pson_phn_no")),",");
	ArrayList form_cntc_pson_fax_no = splitStr(StringUtil.xssFilter(request.getParameter("form_cntc_pson_fax_no")),",");
	ArrayList form_cntc_pson_nm = splitStr(StringUtil.xssFilter(request.getParameter("form_cntc_pson_nm")),",");

	ArrayList n3pty_cust_cnt_cd = splitStr(StringUtil.xssFilter(request.getParameter("n3pty_cust_cnt_cd")),",");
	ArrayList n3pty_cust_seq = splitStr(StringUtil.xssFilter(request.getParameter("n3pty_cust_seq")),",");
	ArrayList n3pty_desc = splitStr(StringUtil.xssFilter(request.getParameter("n3pty_desc")),",");
	ArrayList n3pty_vndr_seq = splitStr(StringUtil.xssFilter(request.getParameter("n3pty_vndr_seq")),",");
	ArrayList n3pty_ofc_cd = splitStr(StringUtil.xssFilter(request.getParameter("n3pty_ofc_cd")),",");
	ArrayList n3pty_bil_bzc_amt = splitStr(StringUtil.xssFilter(request.getParameter("n3pty_bil_bzc_amt")),",");
	ArrayList n3pty_bil_tp_cd = splitStr(StringUtil.xssFilter(request.getParameter("n3pty_bil_tp_cd")),",");
	ArrayList n3pty_curr_cd = splitStr(StringUtil.xssFilter(request.getParameter("n3pty_curr_cd")),",");

	
	ArrayList wtr_rcv_term_cd = splitStr(StringUtil.xssFilter(request.getParameter("wtr_rcv_term_cd")),",");
	ArrayList wtr_de_term_cd = splitStr(StringUtil.xssFilter(request.getParameter("wtr_de_term_cd")),",");

	ArrayList trsp_agmt_ofc_cty_cd = splitStr(StringUtil.xssFilter(request.getParameter("po_trsp_agmt_ofc_cty_cd")),",");
	ArrayList trsp_agmt_seq = splitStr(StringUtil.xssFilter(request.getParameter("po_trsp_agmt_seq")),",");	
	ArrayList trsp_agmt_cfm_flg = splitStr(StringUtil.xssFilter(request.getParameter("po_cfm_flg")),",");
	ArrayList trsp_agmt_rt_seq = splitStr(StringUtil.xssFilter(request.getParameter("po_agmt_rt_seq")),",");	
	ArrayList trsp_agmt_upd_dt = splitStr(StringUtil.xssFilter(request.getParameter("po_agmt_upd_dt")),",");	
	
	String trsp_so_no = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("trsp_so_no"))); // W/O 컨펌 시 S/O 지역코드와 일치하는지 확인하기 위해 추가
	
	String eq_mode = "";
	String issued = (StringUtil.xssFilter(request.getParameter("issued"))!=""&&StringUtil.xssFilter(request.getParameter("issued")).equals("Y")?"Y":"N");
	String scg_grp_seq = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("scg_grp_seq")));
	String isInquiry = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("isInquiry")));
	String tro_flg = "";
	String tro_prv_flg = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("tro_prv_flg"))); // TRO 호출시 : 'Y'
	String woPrvGrpBlFlg = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("wo_prv_grp_bl_flg")));
	if (tro_prv_flg.equals("Y")) {
		tro_flg = "Y";
	}else{
		tro_flg = "N";
	}
	
	String det = "";
	String bno = "";
	String cancel = "";
	String n3pty_bil_flgStr = "";

	StringBuffer init_searchStr = new StringBuffer();
	StringBuffer init_wo_searchStr = new StringBuffer();

	if(trsp_so_ofc_cty_cd != null && trsp_so_ofc_cty_cd.size()>0 && trsp_so_ofc_cty_cd.size() == trsp_so_seq.size()) {
		eq_mode = StringUtil.xssFilter(request.getParameter("eq_mode"));

		for(int i=0; i< trsp_so_ofc_cty_cd.size(); i++)
		{
			det = (dtn_use_flg==null?"":(String)dtn_use_flg.get(i));
			bno = (wo_bl_no_iss_flg==null?"":(String)wo_bl_no_iss_flg.get(i));
			cancel = (wo_cancel_flag==null?"":(String)wo_cancel_flag.get(i));
			n3pty_bil_flgStr = (n3pty_bil_flg==null||((String)n3pty_bil_flg.get(i)).trim().equals("")?"N":(String)n3pty_bil_flg.get(i));

			if(det != "" && det.equals("1")){
				det = "Y";
			}else{
				det = "N";
			}

			if(bno != "" && bno.equals("1")){
				bno = "Y";
			}else{
				bno = "N";
			}

			if(cancel != "" && cancel.equals("1")){
				cancel = "Y";
			}else{
				cancel = "N";
			}

			init_searchStr.append( "&ibflag=R&trsp_so_ofc_cty_cd="+(String)trsp_so_ofc_cty_cd.get(i));
			init_searchStr.append( "&trsp_so_seq="+(String)trsp_so_seq.get(i));
			init_searchStr.append( "&wo_cxl_flg="+cancel);
			init_searchStr.append( "&dtn_use_flg="+det);
			init_searchStr.append( "&wo_bl_no_iss_flg="+bno);
			init_searchStr.append( "&vndr_seq="+ (vndr_seq==null||vndr_seq.size()<i+1?"":(String)vndr_seq.get(i)));
			init_searchStr.append( "&curr_cd="+ (curr_cd==null||curr_cd.size()<i+1?"":(String)curr_cd.get(i)));
			init_searchStr.append( "&bzc_amt="+ (bzc_amt==null||bzc_amt.size()<i+1?"":(String)bzc_amt.get(i)));
			init_searchStr.append( "&nego_amt="+ (nego_amt==null||nego_amt.size()<i+1?"":(String)nego_amt.get(i)));
			init_searchStr.append( "&etc_add_amt="+ (etc_add_amt==null||etc_add_amt.size()<i+1?"":(String)etc_add_amt.get(i)));
			init_searchStr.append( "&fuel_scg_amt="+ (fuel_scg_amt==null||fuel_scg_amt.size()<i+1?"":(String)fuel_scg_amt.get(i)));
			init_searchStr.append( "&scg_vat_amt="+ (scg_vat_amt==null||scg_vat_amt.size()<i+1?"":(String)scg_vat_amt.get(i)));
			init_searchStr.append( "&toll_fee_amt="+ (toll_fee_amt==null||toll_fee_amt.size()<i+1?"":(String)toll_fee_amt.get(i)));
			init_searchStr.append( "&usd_ttl_amt="+ (po_usd_curr_tot_amt==null||po_usd_curr_tot_amt.size()<i+1?"":(String)po_usd_curr_tot_amt.get(i)));
			
			// GuideLine Rate
			init_searchStr.append( "&gline_vndr_seq="+ (gline_vndr_seq==null||gline_vndr_seq.size()<i+1?"":(String)gline_vndr_seq.get(i)));
			init_searchStr.append( "&gline_curr_cd="+ (gline_curr_cd==null||gline_curr_cd.size()<i+1?"":(String)gline_curr_cd.get(i)));
			init_searchStr.append( "&gline_bzc_amt="+ (gline_bzc_amt==null||gline_bzc_amt.size()<i+1?"":(String)gline_bzc_amt.get(i)));
			init_searchStr.append( "&gline_nego_amt="+ (gline_nego_amt==null||gline_nego_amt.size()<i+1?"":(String)gline_nego_amt.get(i)));
			init_searchStr.append( "&gline_etc_add_amt="+ (gline_etc_add_amt==null||gline_etc_add_amt.size()<i+1?"":(String)gline_etc_add_amt.get(i)));
			init_searchStr.append( "&gline_fuel_scg_amt="+ (gline_fuel_scg_amt==null||gline_fuel_scg_amt.size()<i+1?"":(String)gline_fuel_scg_amt.get(i)));
			init_searchStr.append( "&gline_scg_vat_amt="+ (gline_scg_vat_amt==null||gline_scg_vat_amt.size()<i+1?"":(String)gline_scg_vat_amt.get(i)));
			init_searchStr.append( "&gline_toll_fee_amt="+ (gline_toll_fee_amt==null||gline_toll_fee_amt.size()<i+1?"":(String)gline_toll_fee_amt.get(i)));
			init_searchStr.append( "&gline_usd_ttl_amt="+ (gline_po_usd_curr_tot_amt==null||gline_po_usd_curr_tot_amt.size()<i+1?"":(String)gline_po_usd_curr_tot_amt.get(i)));
			// GuideLine Rate
			
			init_searchStr.append( "&n3pty_bil_flg="+ n3pty_bil_flgStr);
			init_searchStr.append( "&po_usd_curr_tot_amt="+ (po_usd_curr_tot_amt==null?"":(String)po_usd_curr_tot_amt.get(i)));
			init_searchStr.append( "&cust_cnt_cd="+ (cust_cnt_cd==null?"":(String)cust_cnt_cd.get(i)));
			init_searchStr.append( "&cust_seq="+ (cust_seq==null?"":(String)cust_seq.get(i)));
			init_searchStr.append( "&cust_nomi_trkr_flg="+ (cust_nomi_trkr_flg==null?"":(String)cust_nomi_trkr_flg.get(i)));
			init_searchStr.append( "&cust_nomi_trkr_ind_cd="+ (cust_nomi_trkr_ind_cd==null?"":(String)cust_nomi_trkr_ind_cd.get(i)));
			init_searchStr.append( "&trsp_sp_cng_rsn_cd="+ (trsp_sp_cng_rsn_cd==null?"":(String)trsp_sp_cng_rsn_cd.get(i)));
			init_searchStr.append( "&trsp_sp_cng_rsn_rmk="+ (trsp_sp_cng_rsn_rmk==null?"":(String)trsp_sp_cng_rsn_rmk.get(i)));
			init_searchStr.append( "&agmt_mor_cnddt_aply_flg="+ (agmt_mor_cnddt_aply_flg==null?"":(String)agmt_mor_cnddt_aply_flg.get(i)));
			init_searchStr.append( "&trsp_agmt_rt_tp_cd="+ (trsp_agmt_rt_tp_cd==null?"":(String)trsp_agmt_rt_tp_cd.get(i)));
			init_searchStr.append( "&trsp_agmt_wy_tp_cd="+ (trsp_agmt_wy_tp_cd==null?"":(String)trsp_agmt_wy_tp_cd.get(i)));
			init_searchStr.append( "&trsp_frst_flg="+ (trsp_frst_flg==null?"":(String)trsp_frst_flg.get(i)));
			init_searchStr.append( "&trsp_rjct_rsn_cd="+ (trsp_rjct_rsn_cd==null?"":(String)trsp_rjct_rsn_cd.get(i)));
			init_searchStr.append( "&trsp_dflt_vndr_flg="+ (trsp_dflt_vndr_flg==null?"":(String)trsp_dflt_vndr_flg.get(i)));

			init_searchStr.append( "&n1st_nod_pln_dt="+ (n1st_nod_pln_dt==null||n1st_nod_pln_dt.size()<i+1?"":(String)n1st_nod_pln_dt.get(i)));
			init_searchStr.append( "&lst_nod_pln_dt="+ (lst_nod_pln_dt==null||lst_nod_pln_dt.size()<i+1?"":(String)lst_nod_pln_dt.get(i)));
			init_searchStr.append( "&dor_nod_pln_dt="+ (dor_nod_pln_dt==null||dor_nod_pln_dt.size()<i+1?"":(String)dor_nod_pln_dt.get(i)));
			init_searchStr.append( "&inter_rmk="+ (inter_rmk==null||inter_rmk.size()<i+1?"":(String)inter_rmk.get(i)));
			init_searchStr.append( "&spcl_instr_rmk="+ (spcl_instr_rmk==null||spcl_instr_rmk.size()<i+1?"":(String)spcl_instr_rmk.get(i)));
			init_searchStr.append( "&nego_rmk="+ (nego_rmk==null||nego_rmk.size()<i+1?"":(String)nego_rmk.get(i)));

			init_searchStr.append( "&fctry_nm="+ (form_fctry_nm==null||form_fctry_nm.size()<i+1?"":(String)form_fctry_nm.get(i)));
			init_searchStr.append( "&dor_pst_cd="+ (form_dor_pst_cd==null||form_dor_pst_cd.size()<i+1?"":(String)form_dor_pst_cd.get(i)));
			init_searchStr.append( "&cntc_pson_phn_no="+ (form_cntc_pson_phn_no==null||form_cntc_pson_phn_no.size()<i+1?"":(String)form_cntc_pson_phn_no.get(i)));
			init_searchStr.append( "&cntc_pson_fax_no="+ (form_cntc_pson_fax_no==null||form_cntc_pson_fax_no.size()<i+1?"":(String)form_cntc_pson_fax_no.get(i)));
			init_searchStr.append( "&cntc_pson_nm="+ (form_cntc_pson_nm==null||form_cntc_pson_nm.size()<i+1?"":(String)form_cntc_pson_nm.get(i)));

			init_searchStr.append( "&n3pty_cust_cnt_cd="+ (n3pty_cust_cnt_cd==null||n3pty_cust_cnt_cd.size()<i+1?"":(String)n3pty_cust_cnt_cd.get(i)));
			init_searchStr.append( "&n3pty_cust_seq="+ (n3pty_cust_seq==null||n3pty_cust_seq.size()<i+1?"":(String)n3pty_cust_seq.get(i)));
			init_searchStr.append( "&n3pty_desc="+ (n3pty_desc==null||n3pty_desc.size()<i+1?"":(String)n3pty_desc.get(i)));
			init_searchStr.append( "&n3pty_vndr_seq="+ (n3pty_vndr_seq==null||n3pty_vndr_seq.size()<i+1?"":(String)n3pty_vndr_seq.get(i)));
			init_searchStr.append( "&n3pty_ofc_cd="+ (n3pty_ofc_cd==null||n3pty_ofc_cd.size()<i+1?"":(String)n3pty_ofc_cd.get(i)));
			init_searchStr.append( "&n3pty_bil_bzc_amt="+ (n3pty_bil_bzc_amt==null||n3pty_bil_bzc_amt.size()<i+1?"":(String)n3pty_bil_bzc_amt.get(i)));
			init_searchStr.append( "&n3pty_bil_tp_cd="+ (n3pty_bil_tp_cd==null||n3pty_bil_tp_cd.size()<i+1?"":(String)n3pty_bil_tp_cd.get(i)));
			init_searchStr.append( "&n3pty_curr_cd="+ (n3pty_curr_cd==null||n3pty_curr_cd.size()<i+1?"":(String)n3pty_curr_cd.get(i)));
			
			init_searchStr.append( "&wtr_rcv_term_cd="+ (wtr_rcv_term_cd==null||wtr_rcv_term_cd.size()<i+1?"":(String)wtr_rcv_term_cd.get(i)));
			init_searchStr.append( "&wtr_de_term_cd="+ (wtr_de_term_cd==null||wtr_de_term_cd.size()<i+1?"":(String)wtr_de_term_cd.get(i)));
			
			init_searchStr.append( "&trsp_agmt_ofc_cty_cd="+ (trsp_agmt_ofc_cty_cd==null||trsp_agmt_ofc_cty_cd.size()<i+1?"":(String)trsp_agmt_ofc_cty_cd.get(i)));
			init_searchStr.append( "&trsp_agmt_seq="+ (trsp_agmt_seq==null||trsp_agmt_seq.size()<i+1?"":(String)trsp_agmt_seq.get(i)));
			
			init_searchStr.append( "&trsp_agmt_cfm_flg="+ (trsp_agmt_seq==null||trsp_agmt_seq.size()<i+1?"":(String)trsp_agmt_cfm_flg.get(i)));
			init_searchStr.append( "&trsp_agmt_rt_seq="+ (trsp_agmt_seq==null||trsp_agmt_seq.size()<i+1?"":(String)trsp_agmt_rt_seq.get(i)));
			init_searchStr.append( "&trsp_agmt_upd_dt="+ (trsp_agmt_seq==null||trsp_agmt_seq.size()<i+1?"":(String)trsp_agmt_upd_dt.get(i)));
		}
	}else if(trsp_wo_ofc_cty_cd != null && trsp_wo_ofc_cty_cd.size()>0 && trsp_wo_ofc_cty_cd.size() == trsp_wo_seq.size()) {
		for(int i=0; i< trsp_wo_ofc_cty_cd.size(); i++)
		{
			init_wo_searchStr.append( "&ibflag=R&trsp_wo_ofc_cty_cd="+(String)trsp_wo_ofc_cty_cd.get(i));
			init_wo_searchStr.append( "&trsp_wo_seq="+(String)trsp_wo_seq.get(i));
		}

	}
%>
<html>
<head>
<title>W/O Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	var beforeOneMonth = '<%=beforeOneMonth%>';
	var today = '<%=today%>';

	var init_searchStr = '<%=init_searchStr.toString()%>';
	var init_wo_searchStr = '<%=init_wo_searchStr.toString()%>';
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type='hidden' name='issued' value='<%=issued%>'>
<input type='hidden' name='SCG_GRP_SEQ' value='<%=scg_grp_seq%>'>
<input type='hidden' name='WO_FMT_TP_CD'>
<input type='hidden' name='WO_PRV_GRP_SEQ'>
<input type='hidden' name='WO_ISS_NO'>
<input type='hidden' name='WO_VNDR_SEQ'>
<input type='hidden' name='WO_ISS_STS_CD'>
<input type='hidden' name='TRSP_WO_OFC_CTY_CD'>
<input type='hidden' name='TRSP_WO_SEQ'>
<input type='hidden' name='TRSP_CRR_MOD_CD'>
<input type='hidden' name='TRSP_COST_DTL_MOD_CD'>

<input type='hidden' name='FAX_SYS_CD' value='TRS'>
<input type='hidden' name='FAX_APP_CD'>
<input type='hidden' name='FAX_BATCH_IND' value='N'>
<input type='hidden' name='FAX_TITLE' value='SM Line Work Order'>
<input type='hidden' name='FAX_PARAM'>
<input type='hidden' name='FAX_RCV_INFO'>

<input type='hidden' name='EMAIL_TITLE'>
<input type='hidden' name='EMAIL_CONTENTS'>
<input type='hidden' name='CONTI_CD'>
<input type='hidden' name='WO_CXL_FLG' value='<%=cancel%>'>

<input type='hidden' name='isInquiry' value='<%=isInquiry%>'>
<input type='hidden' name='wo_prv_grp_bl_flg' value='<%=woPrvGrpBlFlg%>'>

<input type='hidden' name='WO_N2ND_EML' value=''>
<input type='hidden' name='WO_N3RD_EML' value=''>

<input type='hidden' name='trsp_so_no' value='<%=trsp_so_no%>'>
<input type='hidden' name='AUTH_APRO_RQST_NO' value=''>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;W/O Preview</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

<%
		if (tro_flg.equals("N")) {
%>
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" id="btn_reset" name="btn_reset">Reset</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" id="btn_confirm" name="btn_confirm">Confirm</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" id="btn_confirm_all" name="btn_confirm_all">Confirm All</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>	
							<td class="btn1_line"></td>
	
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" id="btn_print" name="btn_print">Print</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<!-- Repeat Pattern -->
	
						</tr>
					</table>

				</td></tr>
			</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
<%
		}
%>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

						<!-- : ( Year ) (S) -->
						<table class="search_in" border="0"">
						<tr class="h23">
							<td width="18%">Number Of W/O To Issue</td>
							<td width="10%"><script language="javascript">ComComboObject('wo_group_no', 1, 150, 1);</script></td>
							<td width="2%">/</td>
							<td width="7%"><div align="left" id=wo_group_no_cnt></div></td>
							<td width="63%"></td>
						</tr>
						</table>

						<table class="line_bluedot"><tr><td></td></tr></table>


						<table class="search_in" border="0">
						<tr class="h23">
							<td width="12%">Issue Type</td>
							<td width="34%" class="sm" style="padding-left:6;">
								<!-- 20140730. W/O Preview의 Print Out 기능 수정 -->
								<input type="checkbox" name='WO_PRN_USE_FLG' value='PRN' class="trans">Print Out
								<input type="checkbox" name='WO_EML_USE_FLG' value='EML' class="trans" checked>E-Mail
								<input type="checkbox" name='WO_FAX_USE_FLG' value='FAX' class="trans">Fax
								<input type="checkbox" name='WO_EDI_USE_FLG' value='EDI' class="trans">EDI
								<input type="checkbox" name='WO_DTL_USE_FLG' value='DTL' class="trans" onClick='rdOpen(rdObjects[0], document.form);setWoDtlUseFlg(this);'>Detail Form</td>
							<td width="4%">Rate</td>
							<td width="16%" class="sm">
								<input type="radio" name='RT_DP_USE_FLG' value='Y' class="trans" onClick='rdOpen(rdObjects[0], document.form)' checked>Show
								<input type="radio" name='RT_DP_USE_FLG' value='N' class="trans" onClick='rdOpen(rdObjects[0], document.form)' >Hide</td>
							<td width="9%">Commodity</td>
							<td width="11%" class="sm"><input type="checkbox" name='CMDT_DP_USE_FLG' value="Y" class="trans">&nbsp;FAK</td>
							<td>Pre-Dispatch<input type="checkbox" name='PRE_DIS_USE_FLG' value="Y" class="trans" onClick='clickPreDisPatch(this)'></td></tr>
						</table>


						<table class="search_in" border="0">
						<tr class="h23">
							<td width="13%">W/O Instruction</td>
							<td width="55%"><input type="text" name='WO_RMK' style="width:464;" onBlur='setRmk(this)' maxlength='255'></td>
							<td width="15%">Apply to All<input type="checkbox" name='Apply_To_All' value="Y" class="trans" onClick='clickApplyToAll(this)'></td>
							<td style="padding-left:3;">Internal Use Only<input type="checkbox" name='INTER_USE_FLG' value="Y" class="trans" onClick='clickInterUse(this)'></td>
						</tr>
						<tr class="h23">
							<td>E-mail Address</td>
							<td colspan="2"><input type="text" name='WO_N1ST_EML' onBlur='setEml1(this)' style="width:698;"></td></tr>
						<tr class="h23">
							<td>Fax Number</td>
							<td colspan="2"> 
								<input type="text" name='WO_N1ST_FAX_NO' maxlength=18 onBlur='setFax1(this)' style="width:230;">
								<input type="text" name='WO_N2ND_FAX_NO' maxlength=18 onBlur='setFax2(this)' style="width:230;">
								<input type="text" name='WO_N3RD_FAX_NO' maxlength=18 onBlur='setFax3(this)' style="width:230;"></td></tr>
						</table>
						<!-- : ( Year ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search"><tr><td class="height_10"></td></tr></table>

				<!-- TABLE '#E' : ( Graph BG ) (S) -->
		     	<table border="1" style="width:100%;" height="520" class="grid" >
		       	<tr><td>
					<script language='javascript'>comRdObject('wo_report');</script>
					<!--<br><br><p align="center"><b>HANJIN SHIPPING</b></p><br>-->
					</td></tr>
				</table>
				<!-- TABLE '#E' : ( Graph BG ) (E) -->

				<!-- : ( Seq. ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Seq. ) (E) -->
				<!-- : ( Seq. ) (S) -->
                    <table width="100%" id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                    </table>
                    <table width="100%" id="hiddenTableAuth">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
                    </table>
				<!-- : ( Seq. ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->



</form>
</body>
</html>

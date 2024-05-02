/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderInboxDBDAOsearchInboxExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.09.22 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderInboxDBDAOsearchInboxExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Excel 자료를 조회 한다.
	  * </pre>
	  */
	public WorkOrderInboxDBDAOsearchInboxExcelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderInboxDBDAOsearchInboxExcelRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT trsp_wo_ofc_cty_cd||trsp_wo_seq trsp_wo_no" ).append("\n"); 
		query.append("      ,trsp_so_ofc_cty_cd||trsp_so_seq trsp_so_no" ).append("\n"); 
		query.append("      ,wo_iss_sts_cd issue_type_cd" ).append("\n"); 
		query.append("      ,decode(wo_iss_sts_cd,'C','Correction'" ).append("\n"); 
		query.append("                           ,'I','Issued'" ).append("\n"); 
		query.append("                           ,'J','Rejected'" ).append("\n"); 
		query.append("                           ,'N','Cancellation'" ).append("\n"); 
		query.append("                           ,'P','Partially Rejected'" ).append("\n"); 
		query.append("                           ,'R','Reissued') issue_type_nm" ).append("\n"); 
		query.append("      ,trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("      ,(select intg_cd_val_dp_desc	from com_intg_cd_dtl where intg_cd_id = 'CD00958' and intg_cd_val_ctnt = trsp_cost_dtl_mod_cd)	trsp_kind_nm" ).append("\n"); 
		query.append("      ,trsp_crr_mod_cd" ).append("\n"); 
		query.append("      ,(select intg_cd_val_dp_desc from com_intg_cd_dtl where	intg_cd_id = 'CD00283' and intg_cd_val_ctnt = trsp_crr_mod_cd) trsp_mode_nm" ).append("\n"); 
		query.append("      ,wo_fmt_tp_cd trsp_so_cmb_tp_cd" ).append("\n"); 
		query.append("      ,decode(wo_fmt_tp_cd,'CC','Combined Case 1'" ).append("\n"); 
		query.append("                          ,'CM','Combined Case 2'" ).append("\n"); 
		query.append("                          ,'CY','Combined Case 2'" ).append("\n"); 
		query.append("                          ,'IB','Combined Case 2'" ).append("\n"); 
		query.append("                          ,'NC','Normal'" ).append("\n"); 
		query.append("                          ,'MM','Empty' ) trsp_type_nm" ).append("\n"); 
		query.append("      ,cre_dt" ).append("\n"); 
		query.append("      ,apnt_dt" ).append("\n"); 
		query.append("      ,de_dt" ).append("\n"); 
		query.append("      ,rj_cnt" ).append("\n"); 
		query.append("      ,so_cnt" ).append("\n"); 
		query.append("      ,inv_cnt" ).append("\n"); 
		query.append("      ,decode(tot_cnt,rj_cnt,'Yes',decode(rj_cnt,0,'No','Partially')) wo_rjct_flg" ).append("\n"); 
		query.append("      ,decode(inv_cnt,0,'No',decode(so_cnt,inv_cnt,'Yes','Partially')) invoiced_flg" ).append("\n"); 
		query.append("      ,wo_opn_flg" ).append("\n"); 
		query.append("      ,trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("      ,trsp_so_seq" ).append("\n"); 
		query.append("      ,fm_nod_cd" ).append("\n"); 
		query.append("      ,via_nod_cd" ).append("\n"); 
		query.append("      ,to_nod_cd" ).append("\n"); 
		query.append("      ,dor_nod_cd" ).append("\n"); 
		query.append("      ,delt_flg" ).append("\n"); 
		query.append("      ,eq_no" ).append("\n"); 
		query.append("      ,eq_tpsz_cd" ).append("\n"); 
		query.append("      ,cntr_wgt" ).append("\n"); 
		query.append("      ,vndr_seq" ).append("\n"); 
		query.append("      ,bzc_amt" ).append("\n"); 
		query.append("      ,inv_etc_add_amt" ).append("\n"); 
		query.append("      ,inv_amt" ).append("\n"); 
		query.append("      ,inv_no" ).append("\n"); 
		query.append("      ,decode(trsp_inv_aud_sts_cd ,'CF','Y','N')  inv_cnfm" ).append("\n"); 
		query.append("      ,decode(trsp_inv_aud_sts_cd ,'RC','Submitted'" ).append("\n"); 
		query.append("    		  					  ,'RJ','Rejected'" ).append("\n"); 
		query.append("    		  					  ,'SV','Auditing'" ).append("\n"); 
		query.append("    		  					  ,'DA','Auditing'" ).append("\n"); 
		query.append("    		  					  ,'CF','Auditing'" ).append("\n"); 
		query.append("    		  					  ,'AR','Processing'" ).append("\n"); 
		query.append("								  ,'RA','Processing'" ).append("\n"); 
		query.append("    		  					  ,'IF','Processing'" ).append("\n"); 
		query.append("    		  					  ,'PD','Paid'" ).append("\n"); 
		query.append("    		  					  ,'Undefined' ) spp_trsp_inv_sts_nm" ).append("\n"); 
		query.append("      ,bkg_no" ).append("\n"); 
		query.append("      ,bl_no" ).append("\n"); 
		query.append("      ,vvd_no" ).append("\n"); 
		query.append("      ,trsp_bnd_cd" ).append("\n"); 
		query.append("      ,iss_office" ).append("\n"); 
		query.append("      ,iss_user" ).append("\n"); 
		query.append("      ,remark" ).append("\n"); 
		query.append("      ,'' shpr_cust_nm" ).append("\n"); 
		query.append("      ,'' cnee_cust_nm" ).append("\n"); 
		query.append("      ,lst_loc_cd" ).append("\n"); 
		query.append("      --,pkup_no" ).append("\n"); 
		query.append("      ,free_dt" ).append("\n"); 
		query.append("      ,aval_dt" ).append("\n"); 
		query.append("      ,pre_dis_use_flg" ).append("\n"); 
		query.append("      ,cre_ofc_cd" ).append("\n"); 
		query.append("      ,wo_receiver" ).append("\n"); 
		query.append("      ,email_dt" ).append("\n"); 
		query.append("      ,inv_office" ).append("\n"); 
		query.append("      ,inv_usr" ).append("\n"); 
		query.append("      ,vndr_nm" ).append("\n"); 
		query.append("      ,f" ).append("\n"); 
		query.append("      ,o" ).append("\n"); 
		query.append("      ,c" ).append("\n"); 
		query.append("      ,z.ob_vvd_cd  ob_vvd_cd" ).append("\n"); 
		query.append("      ,z.n1st_nod_pln_dt n1st_nod_pln_dt" ).append("\n"); 
		query.append("      ,z.lst_nod_pln_dt lst_nod_pln_dt" ).append("\n"); 
		query.append("      ,z.spcl_cgo_cntr_tp_cd spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append("      ,z.bkg_qty bkg_qty" ).append("\n"); 
		query.append("      ,z.pod_cd pod_cd" ).append("\n"); 
		query.append("      ,z.wo_tot_amt_usd" ).append("\n"); 
		query.append("      ,z.inv_curr_cd" ).append("\n"); 
		query.append("      ,z.inv_xch_rt" ).append("\n"); 
		query.append("      ,z.full_name" ).append("\n"); 
		query.append("      ,z.eng_addr" ).append("\n"); 
		query.append("      ,z.phn_no" ).append("\n"); 
		query.append("      ,z.fax_no" ).append("\n"); 
		query.append("      ,z.cntc_pson_nm" ).append("\n"); 
		query.append("	  ,CASE WHEN (f||o||c = 'YYY' OR f||o||c = 'YYW')" ).append("\n"); 
		query.append("  	   AND pkup_no IS NOT NULL" ).append("\n"); 
		query.append("  	   AND pkup_no <> ' '" ).append("\n"); 
		query.append("	   AND free_dt IS NOT NULL" ).append("\n"); 
		query.append("       AND free_dt <> ' ' THEN pkup_no " ).append("\n"); 
		query.append("--		AND ctmsts_id_cnt < 1 " ).append("\n"); 
		query.append("--		WHEN (f||o||c = 'YYY'" ).append("\n"); 
		query.append("--         	OR f||o||c = 'YYW')" ).append("\n"); 
		query.append("--  	   AND pkup_no IS NOT NULL" ).append("\n"); 
		query.append("--  	   AND pkup_no <> ' '" ).append("\n"); 
		query.append("--  	   AND ctmsts_id_cnt >= 1 THEN 'Transported' " ).append("\n"); 
		query.append("			ELSE '' " ).append("\n"); 
		query.append("	    END AS pkup_no" ).append("\n"); 
		query.append("--  	  ,CASE WHEN (f||o||c = 'YYY'" ).append("\n"); 
		query.append("--      		OR f||o||c = 'YYW')" ).append("\n"); 
		query.append("-- 	   AND pkup_no IS NOT NULL" ).append("\n"); 
		query.append("--  	   AND pkup_no <> ' '" ).append("\n"); 
		query.append("--  	   AND ctmsts_id_cnt < 1 THEN aval_dt ELSE '' END AS aval_dt" ).append("\n"); 
		query.append("--  	  ,CASE WHEN (f||o||c = 'YYY'" ).append("\n"); 
		query.append("--     		OR f||o||c = 'YYW')" ).append("\n"); 
		query.append("--  	   AND pkup_no IS NOT NULL" ).append("\n"); 
		query.append("--  	   AND pkup_no <> ' '" ).append("\n"); 
		query.append("--       AND ctmsts_id_cnt < 1 THEN free_dt ELSE '' END AS free_dt" ).append("\n"); 
		query.append("FROM (SELECT x.*" ).append("\n"); 
		query.append("            ,so.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("            ,so.trsp_so_seq" ).append("\n"); 
		query.append("            ,so.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("            ,so.trsp_crr_mod_cd" ).append("\n"); 
		query.append("            ,to_char(so.apnt_dt,'YYYY-MM-DD HH24:MI:SS') apnt_dt" ).append("\n"); 
		query.append("            ,to_char(so.de_dt,'YYYY-MM-DD HH24:MI:SS') de_dt" ).append("\n"); 
		query.append("            ,DECODE(so_flag, NULL, rj_flag, so_flag) so_no_flag" ).append("\n"); 
		query.append("            ,so.fm_nod_cd" ).append("\n"); 
		query.append("            ,so.via_nod_cd" ).append("\n"); 
		query.append("            ,so.to_nod_cd" ).append("\n"); 
		query.append("            ,so.dor_nod_cd" ).append("\n"); 
		query.append("            ,so.delt_flg" ).append("\n"); 
		query.append("            ,so.eq_no" ).append("\n"); 
		query.append("            ,so.eq_tpsz_cd" ).append("\n"); 
		query.append("            ,so.cntr_wgt" ).append("\n"); 
		query.append("            ,so.vndr_seq" ).append("\n"); 
		query.append("            ,(nvl(so.bzc_amt,0) + nvl(so.etc_add_amt,0)) bzc_amt" ).append("\n"); 
		query.append("            ,so.inv_etc_add_amt" ).append("\n"); 
		query.append("            ,(nvl(so.inv_bzc_amt,0)+nvl(so.inv_etc_add_amt,0)) inv_amt" ).append("\n"); 
		query.append("            ,so.inv_no" ).append("\n"); 
		query.append("            ,inv.trsp_inv_aud_sts_cd" ).append("\n"); 
		query.append("            ,so.bkg_no" ).append("\n"); 
		query.append("            ,bkg.bl_no" ).append("\n"); 
		query.append("            ,bkg.bl_no_tp" ).append("\n"); 
		query.append("            ,so.vsl_cd||so.skd_voy_no||so.skd_dir_cd    vvd_no" ).append("\n"); 
		query.append("            ,so.trsp_bnd_cd" ).append("\n"); 
		query.append("            ,so.cre_ofc_cd iss_office" ).append("\n"); 
		query.append("            ,so.cre_usr_id iss_user" ).append("\n"); 
		query.append("            ,so.spcl_instr_rmk remark" ).append("\n"); 
		query.append("            ,so.lst_loc_cd" ).append("\n"); 
		query.append("            ,pu.pkup_no" ).append("\n"); 
		query.append("            ,to_char(pu.LST_FREE_DT,'YYYY-MM-DD HH24:MI:SS')    free_dt" ).append("\n"); 
		query.append("    		,to_char(pu.PKUP_AVAL_DT,'YYYY-MM-DD HH24:MI:SS')	aval_dt" ).append("\n"); 
		query.append("    		,inv.cre_ofc_cd   inv_office" ).append("\n"); 
		query.append("    		,nvl(inv.upd_usr_id, inv.cre_usr_id)  inv_usr" ).append("\n"); 
		query.append("    		,vndr.vndr_lgl_eng_nm     vndr_nm" ).append("\n"); 
		query.append("    		,nvl(d.FRT_CLT_FLG,'N') f                                                                                       " ).append("\n"); 
		query.append("            ,nvl(d.OBL_RDEM_FLG,'N') o                                                                                   " ).append("\n"); 
		query.append("            -- POD : 'CA',DEL : 'US'의 경우 Rail AMS 정보를 보여준다.                                                                                " ).append("\n"); 
		query.append("            ,nvl(CASE WHEN (substr(bkg.pod_cd,0,2) = 'CA') and (substr(bkg.del_cd,0,2) = 'US') THEN" ).append("\n"); 
		query.append("                	   (" ).append("\n"); 
		query.append("                		select /*+ index_desc(x XPKBKG_CSTMS_ADV_CNTR_RSLT) */" ).append("\n"); 
		query.append("                		        x.cstms_clr_cd" ).append("\n"); 
		query.append("                		  from bkg_cstms_adv_cntr_rslt x" ).append("\n"); 
		query.append("                		 where x.cnt_cd = 'US'  --상수값" ).append("\n"); 
		query.append("                           and x.bl_no = so.bl_no" ).append("\n"); 
		query.append("                		   and (substr(x.cntr_no,0,length(x.cntr_no)-1) = substr(so.eq_no,0,length(so.eq_no)-1) OR x.cntr_no = substr(so.eq_no,0,length(so.eq_no)-1))" ).append("\n"); 
		query.append("                		   and rownum < 2" ).append("\n"); 
		query.append("                		)" ).append("\n"); 
		query.append("        		 ELSE d.CSTMS_CLR_CD" ).append("\n"); 
		query.append("        		 END,'N' ) as c" ).append("\n"); 
		query.append("    		,(x.rj_cnt + x.so_cnt) tot_cnt" ).append("\n"); 
		query.append("    		,so.ob_vvd_cd" ).append("\n"); 
		query.append("    		,to_char(so.N1ST_NOD_PLN_DT,'YYYY-MM-DD HH24:MI:SS') n1st_nod_pln_dt" ).append("\n"); 
		query.append("    		,to_char(so.LST_NOD_PLN_DT,'YYYY-MM-DD HH24:MI:SS') lst_nod_pln_dt" ).append("\n"); 
		query.append("    		,so.spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append("    		,DECODE(NVL('', 0), 0, qty.CNTR_TPSZ_CD||' '||qty.OP_CNTR_QTY, qty.CNTR_TPSZ_CD||' '||qty.OP_CNTR_QTY||'-SUB '||''||' '||'') AS bkg_qty " ).append("\n"); 
		query.append("    		,bkg.pod_cd" ).append("\n"); 
		query.append("       	    ,(SELECT ROUND((TO_NUMBER(NVL(so.BZC_AMT,0)+NVL(so.NEGO_AMT,0)+NVL(so.FUEL_SCG_AMT,0)+NVL(so.ETC_ADD_AMT,0)+NVL(so.TOLL_FEE_AMT,0)) / RAT.USD_LOCL_XCH_RT),2) WO_TOT_AMT_USD" ).append("\n"); 
		query.append("       	        FROM GL_MON_XCH_RT RAT" ).append("\n"); 
		query.append("       	       WHERE RAT.CURR_CD = so.CURR_CD" ).append("\n"); 
		query.append("       	         AND RAT.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("       	         AND RAT.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("       	      ) AS WO_TOT_AMT_USD" ).append("\n"); 
		query.append("       	    ,so.inv_curr_cd" ).append("\n"); 
		query.append("       	    ,so.inv_xch_rt" ).append("\n"); 
		query.append("    		,y.FULL_NAME" ).append("\n"); 
		query.append("    		,y.ENG_ADDR" ).append("\n"); 
		query.append("    		,y.PHN_NO" ).append("\n"); 
		query.append("    		,y.FAX_NO" ).append("\n"); 
		query.append("    		,y.CNTC_PSON_NM" ).append("\n"); 
		query.append("--			,(SELECT COUNT(MVMT_STS_CD)" ).append("\n"); 
		query.append("--        		FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("--        	   WHERE 1=1" ).append("\n"); 
		query.append("--          		 AND CNTR_NO = SO.EQ_NO" ).append("\n"); 
		query.append("--          		 AND BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("--          		 AND MVMT_STS_CD = 'ID') CTMSTS_ID_CNT" ).append("\n"); 
		query.append("     FROM (SELECT x1.*" ).append("\n"); 
		query.append("                ,(SELECT count(a.trsp_wo_seq) cnt" ).append("\n"); 
		query.append("                    FROM trs_trsp_wrk_ord_rjct_his a" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                  ) rj_cnt" ).append("\n"); 
		query.append("                ,(SELECT MAX(a.trsp_so_ofc_cty_cd ||'^'|| TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("                    FROM trs_trsp_wrk_ord_rjct_his a, trs_trsp_svc_ord b" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                     AND b.trsp_so_ofc_cty_cd = a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND b.trsp_so_seq = a.trsp_so_seq" ).append("\n"); 
		query.append("                     AND NVL(b.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                  ) rj_flag" ).append("\n"); 
		query.append("                ,(SELECT a.trsp_so_ofc_cty_cd ||'^'|| TO_CHAR(a.trsp_so_seq)" ).append("\n"); 
		query.append("                    FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                     AND NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                 ) so_flag" ).append("\n"); 
		query.append("                ,(SELECT count(a.trsp_so_ofc_cty_cd ||TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("                    FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                     AND NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                 ) so_cnt" ).append("\n"); 
		query.append("                ,(SELECT count(a.trsp_so_ofc_cty_cd ||TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("                    FROM trs_trsp_inv_wrk invw, trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                     AND a.inv_no = invw.inv_no" ).append("\n"); 
		query.append("                     AND a.inv_vndr_seq = invw.inv_vndr_seq" ).append("\n"); 
		query.append("                     AND a.trsp_inv_act_sts_cd IS NOT NULL" ).append("\n"); 
		query.append("                 ) inv_cnt" ).append("\n"); 
		query.append("           FROM (SELECT /* index(wo XAK1TRS_TRSP_WRK_ORD, wo XAK2TRS_TRSP_WRK_ORD) */" ).append("\n"); 
		query.append("                        wo.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                       ,wo.trsp_wo_seq" ).append("\n"); 
		query.append("                       ,wo.wo_iss_sts_cd" ).append("\n"); 
		query.append("                       ,wo.wo_fmt_tp_cd" ).append("\n"); 
		query.append("                       ,to_char(wo.cre_dt, 'YYYY-MM-DD HH24:MI:SS') cre_dt" ).append("\n"); 
		query.append("                       ,wo.wo_opn_flg" ).append("\n"); 
		query.append("                       ,wo.wo_vndr_seq" ).append("\n"); 
		query.append("                       ,wo.pre_dis_use_flg" ).append("\n"); 
		query.append("                       ,wo.cre_ofc_cd" ).append("\n"); 
		query.append("                       ,wo.wo_n1st_eml||wo.WO_N2ND_EML||wo.WO_N3RD_EML  wo_receiver" ).append("\n"); 
		query.append("                       ,to_char(nvl(wo.upd_dt,wo.cre_dt),'YYYY-MM-DD HH24:MI:SS') email_dt" ).append("\n"); 
		query.append("                   FROM trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("	                AND (@[vndr_seq] is null OR wo.wo_vndr_seq = @[vndr_seq])" ).append("\n"); 
		query.append("                    AND NVL(wo.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND NVL(wo.inter_use_flg, 'N') != 'Y'" ).append("\n"); 
		query.append("                #if ($wo_no.size() > 0) " ).append("\n"); 
		query.append("                    AND (wo.trsp_wo_ofc_cty_cd,wo.trsp_wo_seq) in (" ).append("\n"); 
		query.append("                	#foreach($wonoKey in ${wo_no}) " ).append("\n"); 
		query.append("                		#if($velocityCount < $wo_no.size()) " ).append("\n"); 
		query.append("                			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("                		#else " ).append("\n"); 
		query.append("                			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("                		#end " ).append("\n"); 
		query.append("                	#end " ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                 )x1) x" ).append("\n"); 
		query.append("                ,TRS_TRSP_SVC_ORD so" ).append("\n"); 
		query.append("                ,TRS_TRSP_INV_WRK inv" ).append("\n"); 
		query.append("                ,BKG_PKUP_NTC_PKUP_NO pu" ).append("\n"); 
		query.append("                ,MDM_LOCATION loc" ).append("\n"); 
		query.append("                ,MDM_VENDOR  vndr" ).append("\n"); 
		query.append("                ,BKG_CGO_RLSE d" ).append("\n"); 
		query.append("          	    ,BKG_BOOKING bkg" ).append("\n"); 
		query.append("        		,BKG_QUANTITY qty" ).append("\n"); 
		query.append("         		,(SELECT VD.VNDR_SEQ AS VNDR_CODE" ).append("\n"); 
		query.append("              			,NVL(VD.VNDR_LGL_ENG_NM,'') AS FULL_NAME" ).append("\n"); 
		query.append("              			,NVL(VD.ENG_ADDR,'') AS ENG_ADDR" ).append("\n"); 
		query.append("              			,NVL(VD_CNTC.PHN_NO,'') AS PHN_NO" ).append("\n"); 
		query.append("              			,NVL(VD_CNTC.FAX_NO ,'') AS FAX_NO" ).append("\n"); 
		query.append("              			,NVL(VD.CNTC_PSON_NM,'') AS CNTC_PSON_NM" ).append("\n"); 
		query.append("        			FROM MDM_VENDOR VD" ).append("\n"); 
		query.append("        	 			,MDM_VNDR_CNTC_PNT VD_CNTC" ).append("\n"); 
		query.append("        		   WHERE 1=1" ).append("\n"); 
		query.append("          			 AND VD.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("         			 AND VD.VNDR_SEQ = VD_CNTC.VNDR_SEQ(+)" ).append("\n"); 
		query.append("         			 AND VD_CNTC.PRMRY_CHK_FLG (+) = 'Y'" ).append("\n"); 
		query.append("         			 AND VD_CNTC.PHN_NO (+) IS NOT NULL" ).append("\n"); 
		query.append("         			 AND VD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         			 AND VD_CNTC.DELT_FLG (+) = 'N') y" ).append("\n"); 
		query.append("           WHERE 1 = 1" ).append("\n"); 
		query.append("             AND x.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("             AND x.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append("             AND so.inv_no = inv.inv_no(+)" ).append("\n"); 
		query.append("        	 AND so.inv_vndr_seq = inv.inv_vndr_seq(+)" ).append("\n"); 
		query.append("             AND so.eq_no = pu.cntr_no(+)" ).append("\n"); 
		query.append("             AND so.bkg_no = pu.bkg_no(+)" ).append("\n"); 
		query.append("             AND pu.del_cd = loc.loc_cd(+)" ).append("\n"); 
		query.append("             --AND pu.ofc_cd = loc.eq_ctrl_ofc_cd(+)" ).append("\n"); 
		query.append("             AND so.vndr_seq = vndr.vndr_seq(+)" ).append("\n"); 
		query.append("        	 AND bkg.bkg_no(+) = so.bkg_no" ).append("\n"); 
		query.append("             AND d.bl_no(+) = bkg.bl_no" ).append("\n"); 
		query.append("             AND qty.bkg_no(+) = so.BKG_NO" ).append("\n"); 
		query.append("        	 AND qty.CNTR_TPSZ_CD(+) = so.EQ_TPSZ_CD" ).append("\n"); 
		query.append("			 AND NVL(TO_DATE(pu.upd_dt, 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('11111111 111111', 'YYYY-MM-DD HH24:MI:SS')) = NVL((" ).append("\n"); 
		query.append("            	SELECT TO_DATE(MAX(Y.UPD_DT), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("            	FROM BKG_PKUP_NTC_PKUP_NO Y" ).append("\n"); 
		query.append("            	WHERE Y.BKG_NO = pu.BKG_NO" ).append("\n"); 
		query.append("              	AND Y.CNTR_NO = pu.CNTR_NO" ).append("\n"); 
		query.append("              	AND Y.PKUP_YD_CD = pu.PKUP_YD_CD), TO_DATE('11111111 111111', 'YYYY-MM-DD HH24:MI:SS'))" ).append("\n"); 
		query.append("--             AND pu.upd_dt = (SELECT MAX(Y.UPD_DT)" ).append("\n"); 
		query.append("--                         FROM BKG_PKUP_NTC_PKUP_NO Y" ).append("\n"); 
		query.append("--                        WHERE Y.BKG_NO  = pu.BKG_NO" ).append("\n"); 
		query.append("--                          AND Y.CNTR_NO = pu.CNTR_NO" ).append("\n"); 
		query.append("--                          AND Y.PKUP_YD_CD = pu.PKUP_YD_CD)" ).append("\n"); 
		query.append("        ORDER BY x.trsp_wo_ofc_cty_cd, x.trsp_wo_seq" ).append("\n"); 
		query.append("         ) z" ).append("\n"); 

	}
}
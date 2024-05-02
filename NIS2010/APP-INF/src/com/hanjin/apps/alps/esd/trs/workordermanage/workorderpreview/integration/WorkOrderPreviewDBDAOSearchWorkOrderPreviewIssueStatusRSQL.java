/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2016.02.29 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search WorkOrder Preview Issue Status
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL").append("\n"); 
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
		query.append("SELECT a.wo_prv_grp_seq" ).append("\n"); 
		query.append("		 ,a.wo_iss_no" ).append("\n"); 
		query.append("		 ,a.wo_fmt_tp_cd" ).append("\n"); 
		query.append("		 ,a.wo_iss_sts_cd" ).append("\n"); 
		query.append("		 ,a.vndr_seq" ).append("\n"); 
		query.append("		 ,a.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("		 ,a.trsp_wo_seq" ).append("\n"); 
		query.append("		 ,a.trsp_crr_mod_cd" ).append("\n"); 
		query.append("		 ,COUNT(wo_iss_no) cnt" ).append("\n"); 
		query.append("		 ,b.vndr_lgl_eng_nm" ).append("\n"); 
		query.append("		 ,b.wo_edi_use_flg" ).append("\n"); 
		query.append("		 ,c.conti_cd" ).append("\n"); 
		query.append("		 ,d.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("		 ,d.trsp_bnd_cd" ).append("\n"); 
		query.append("		 ,a.fm_nod_cd" ).append("\n"); 
		query.append("		 ,a.to_nod_cd" ).append("\n"); 
		query.append("		 ,a.via_nod_cd" ).append("\n"); 
		query.append("		 ,a.dor_nod_cd	" ).append("\n"); 
		query.append("		 ,e.inter_use_flg" ).append("\n"); 
		query.append("		 ,NVL(e.wo_rmk, f.wo_instr_rmk) wo_instr_rmk" ).append("\n"); 
		query.append("		 ,DECODE(MAX(D.SPOT_BID_FLG), 'Y', '',MAX(decode(fx.wo_cc_seq, 1, fx.wo_fax_no))) fax1" ).append("\n"); 
		query.append("		 ,DECODE(MAX(D.SPOT_BID_FLG), 'Y', '',MAX(decode(fx.wo_cc_seq, 2, fx.wo_fax_no))) fax2" ).append("\n"); 
		query.append("		 ,DECODE(MAX(D.SPOT_BID_FLG), 'Y', '',MAX(decode(fx.wo_cc_seq, 3, fx.wo_fax_no))) fax3" ).append("\n"); 
		query.append(",DECODE(MAX(D.SPOT_BID_FLG), 'Y', TRS_COM_SPOT_BID_PKG.GET_MODI_SPOT_BID_VNDR_EML(A.WO_PRV_GRP_SEQ, A.WO_ISS_NO)" ).append("\n"); 
		query.append(",MAX(decode(el.wo_cc_seq, 1, el.wo_eml)) || DECODE(MAX(decode(el.wo_cc_seq, 2, el.wo_eml)),NULL,'',';') ||" ).append("\n"); 
		query.append(" MAX(decode(el.wo_cc_seq, 2, el.wo_eml)) || DECODE(MAX(decode(el.wo_cc_seq, 3, el.wo_eml)),NULL,'',';') ||" ).append("\n"); 
		query.append(" MAX(decode(el.wo_cc_seq, 3, el.wo_eml)) || DECODE(MAX(decode(el.wo_cc_seq, 4, el.wo_eml)),NULL,'',';') ||" ).append("\n"); 
		query.append(" MAX(decode(el.wo_cc_seq, 4, el.wo_eml)) || DECODE(MAX(decode(el.wo_cc_seq, 5, el.wo_eml)),NULL,'',';') ||" ).append("\n"); 
		query.append(" MAX(decode(el.wo_cc_seq, 5, el.wo_eml)) || DECODE(MAX(decode(el.wo_cc_seq, 6, el.wo_eml)),NULL,'',';') ||" ).append("\n"); 
		query.append(" MAX(decode(el.wo_cc_seq, 6, el.wo_eml))) as eml1" ).append("\n"); 
		query.append("		 ,edi.edi_rcvr_nm_use_flg" ).append("\n"); 
		query.append("         ,d.SKD_DIR_CD" ).append("\n"); 
		query.append("         ,(CASE WHEN (A.WO_ISS_STS_CD = 'I' OR A.WO_ISS_STS_CD = 'R' OR A.WO_ISS_STS_CD = 'C')  -- ISSUED 일경우 0이 아닌경우 Y" ).append("\n"); 
		query.append("                THEN (CASE WHEN (NVL(MAX(A.NEGO_AMT), 0) != 0 OR NVL(MIN(A.NEGO_AMT), 0) != 0 ) THEN 'Y' ELSE 'N' END)" ).append("\n"); 
		query.append("                ELSE 'N'" ).append("\n"); 
		query.append("            END) NEGO_FLG" ).append("\n"); 
		query.append("         ,(CASE WHEN (A.WO_ISS_STS_CD = 'I' OR A.WO_ISS_STS_CD = 'R' OR A.WO_ISS_STS_CD = 'C')" ).append("\n"); 
		query.append("                THEN (CASE WHEN (SELECT MAX(CASE WHEN NVL(SDT.SCG_AMT, 0) != 0 THEN 1 ELSE 0 END) KEEP(DENSE_RANK FIRST ORDER BY IWOPT.WO_PRV_GRP_SEQ ASC)" ).append("\n"); 
		query.append("                                   FROM TRS_TRSP_SCG_DTL_TMP SDT," ).append("\n"); 
		query.append("                                        TRS_TRSP_WRK_ORD_PRV_TMP IWOPT" ).append("\n"); 
		query.append("                                  WHERE 1=1" ).append("\n"); 
		query.append("                                    AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N'" ).append("\n"); 
		query.append("                                    AND SDT.LGS_COST_CD IN (SELECT LGS_COST_CD FROM TES_LGS_COST WHERE LGS_COST_SUBJ_CD IN ('SC', 'SM') AND (SUBSTR(LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(LGS_COST_CD, 3, 4) <> 'OTAX'))" ).append("\n"); 
		query.append("                                    AND IWOPT.WO_PRV_GRP_SEQ     = A.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("                                    AND IWOPT.VNDR_SEQ           = A.VNDR_SEQ" ).append("\n"); 
		query.append("                                    AND IWOPT.WO_ISS_NO          = A.WO_ISS_NO" ).append("\n"); 
		query.append("                                    AND SDT.WO_PRV_GRP_SEQ       = @[scg_grp_seq]  --7651257    -- 현재 SCG_DTL_TMP_SEQ" ).append("\n"); 
		query.append("                                    AND IWOPT.TRSP_SO_OFC_CTY_CD = SDT.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                                    AND IWOPT.TRSP_SO_SEQ        = SDT.TRSP_SO_SEQ(+)) != 0" ).append("\n"); 
		query.append("                           THEN 'Y' " ).append("\n"); 
		query.append("                           ELSE 'N' END)" ).append("\n"); 
		query.append("                ELSE 'N'" ).append("\n"); 
		query.append("            END) ADDI_FLG" ).append("\n"); 
		query.append("         , NVL(MAX(D.SPOT_BID_FLG), 'N') AS SPOT_BID_FLG" ).append("\n"); 
		query.append("/*  CHM-201536387  NEGO, SURCHARGE  */" ).append("\n"); 
		query.append("     FROM trs_trsp_wrk_ord_prv_tmp	a" ).append("\n"); 
		query.append("		 ,mdm_vendor b" ).append("\n"); 
		query.append("		 ,mdm_location c" ).append("\n"); 
		query.append("		 ,trs_trsp_svc_ord d" ).append("\n"); 
		query.append("		 ,trs_trsp_wrk_ord e" ).append("\n"); 
		query.append("		 ,trs_trsp_wrk_ord_instr f" ).append("\n"); 
		query.append("		 ,trs_trsp_wrk_ord_cc_fax fx" ).append("\n"); 
		query.append("		 ,trs_trsp_wrk_ord_cc_eml el" ).append("\n"); 
		query.append("		 ,trs_edi_usa_rcvr_dtl edi															" ).append("\n"); 
		query.append("    WHERE wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("  	  AND a.vndr_seq = b.vndr_seq(+)" ).append("\n"); 
		query.append("  	  AND SUBSTR(a.fm_nod_cd, 1, 5) = c.loc_cd" ).append("\n"); 
		query.append("  	  AND a.trsp_so_ofc_cty_cd = d.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("  	  AND a.trsp_so_seq = d.trsp_so_seq" ).append("\n"); 
		query.append("  	  AND a.trsp_wo_ofc_cty_cd = e.trsp_wo_ofc_cty_cd(+)" ).append("\n"); 
		query.append("  	  AND a.trsp_wo_seq = e.trsp_wo_seq(+)						" ).append("\n"); 
		query.append("   	  AND d.trsp_cost_dtl_mod_cd = f.trsp_cost_mod_cd(+)" ).append("\n"); 
		query.append("  	  AND d.trsp_crr_mod_cd = f.trsp_crr_mod_cd(+)								" ).append("\n"); 
		query.append("  	  AND d.trsp_bnd_cd = f.trsp_bnd_cd(+)									" ).append("\n"); 
		query.append("  	  AND d.cre_ofc_cd = f.wo_instr_ofc_cd(+)" ).append("\n"); 
		query.append("  	  AND a.vndr_seq = fx.vndr_seq(+)									" ).append("\n"); 
		query.append("  	  AND a.vndr_seq = el.vndr_seq(+)" ).append("\n"); 
		query.append("  	  AND a.vndr_seq = edi.vndr_seq(+)" ).append("\n"); 
		query.append("  	  AND d.hjl_no is null" ).append("\n"); 
		query.append("  	  AND e.hjl_no is null" ).append("\n"); 
		query.append("  	  AND f.hjl_no is null" ).append("\n"); 
		query.append(" GROUP BY a.wo_prv_grp_seq" ).append("\n"); 
		query.append("		 ,a.wo_iss_no" ).append("\n"); 
		query.append("		 ,a.wo_fmt_tp_cd" ).append("\n"); 
		query.append("		 ,a.wo_iss_sts_cd" ).append("\n"); 
		query.append("		 ,a.vndr_seq" ).append("\n"); 
		query.append("		 ,a.trsp_crr_mod_cd" ).append("\n"); 
		query.append("		 ,a.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("		 ,a.trsp_wo_seq" ).append("\n"); 
		query.append("		 ,b.vndr_lgl_eng_nm" ).append("\n"); 
		query.append("		 ,b.wo_edi_use_flg" ).append("\n"); 
		query.append("		 ,c.conti_cd" ).append("\n"); 
		query.append("		 ,d.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("		 ,d.trsp_bnd_cd" ).append("\n"); 
		query.append("		 ,a.fm_nod_cd" ).append("\n"); 
		query.append("		 ,a.to_nod_cd" ).append("\n"); 
		query.append("		 ,a.via_nod_cd" ).append("\n"); 
		query.append("		 ,a.dor_nod_cd" ).append("\n"); 
		query.append("		 ,f.wo_instr_rmk" ).append("\n"); 
		query.append("		 ,e.wo_rmk" ).append("\n"); 
		query.append("		 ,e.inter_use_flg" ).append("\n"); 
		query.append("		 ,edi.edi_rcvr_nm_use_flg" ).append("\n"); 
		query.append("         ,d.SKD_DIR_CD" ).append("\n"); 
		query.append(" ORDER BY wo_iss_no" ).append("\n"); 

	}
}
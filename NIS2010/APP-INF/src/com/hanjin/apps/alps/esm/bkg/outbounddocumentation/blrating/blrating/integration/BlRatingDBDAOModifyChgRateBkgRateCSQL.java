/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BlRatingDBDAOModifyChgRateBkgRateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOModifyChgRateBkgRateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyChgRateBkgRate
	  * </pre>
	  */
	public BlRatingDBDAOModifyChgRateBkgRateCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_shpr_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_rt_mtch_patt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_payr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_payr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_payr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_prfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rt_whf_expt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_payr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOModifyChgRateBkgRateCSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append("INSERT INTO BKG_RT_HIS (" ).append("\n"); 
		query.append("   BKG_NO, CORR_NO, RT_BL_TP_CD, FRT_TERM_CD, " ).append("\n"); 
		query.append("   BKG_CTRT_TP_CD, PPD_RCV_OFC_CD, PPD_PAYR_CNT_CD, " ).append("\n"); 
		query.append("   PPD_PAYR_CUST_SEQ, CLT_OFC_CD, CLT_PAYR_CNT_CD, " ).append("\n"); 
		query.append("   CLT_PAYR_CUST_SEQ, REV_DIV_CD, BKG_RT_WHF_EXPT_CD, " ).append("\n"); 
		query.append("   WHF_SHPR_RGST_NO, RT_APLY_DT, CGO_RCV_DT, " ).append("\n"); 
		query.append("   DIFF_RMK, AUD_STS_CD, CRE_USR_ID, " ).append("\n"); 
		query.append("   CRE_DT, UPD_USR_ID, UPD_DT, " ).append("\n"); 
		query.append("   PRC_RT_MTCH_PATT_CD, PRC_GEN_SPCL_RT_TP_CD, PRC_CMDT_HDR_SEQ, " ).append("\n"); 
		query.append("   PRC_ROUT_SEQ, CALC_CTRT_TP_CD) " ).append("\n"); 
		query.append("VALUES ( " ).append("\n"); 
		query.append("   @[bkg_no], 'TMP0000001',@[rt_bl_tp_cd], @[frt_term_cd], " ).append("\n"); 
		query.append("   @[bkg_ctrt_tp_cd], @[ppd_rcv_ofc_cd], @[ppd_payr_cnt_cd], " ).append("\n"); 
		query.append("   @[ppd_payr_cust_seq], @[clt_ofc_cd], @[clt_payr_cnt_cd], " ).append("\n"); 
		query.append("   @[clt_payr_cust_seq], @[rev_div_cd], @[bkg_rt_whf_expt_cd], " ).append("\n"); 
		query.append("   @[whf_shpr_rgst_no], TO_DATE(REPLACE(@[rt_aply_dt],'-','') ,'YYYY-MM-DD HH24:MI:SS') , TO_DATE(REPLACE(@[cgo_rcv_dt],'-','') ,'YYYY-MM-DD HH24:MI:SS') , " ).append("\n"); 
		query.append("   @[diff_rmk], @[aud_prfm_flg], @[user_id], " ).append("\n"); 
		query.append("   sysdate, @[user_id], sysdate, " ).append("\n"); 
		query.append("   @[prc_rt_mtch_patt_cd], @[prc_gen_spcl_rt_tp_cd], @[prc_cmdt_hdr_seq], " ).append("\n"); 
		query.append("   @[prc_rout_seq], @[calc_ctrt_tp_cd]" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("INSERT INTO BKG_RATE (" ).append("\n"); 
		query.append("   BKG_NO, RT_BL_TP_CD, FRT_TERM_CD, " ).append("\n"); 
		query.append("   BKG_CTRT_TP_CD, PPD_RCV_OFC_CD, PPD_PAYR_CNT_CD, " ).append("\n"); 
		query.append("   PPD_PAYR_CUST_SEQ, CLT_OFC_CD, CLT_PAYR_CNT_CD, " ).append("\n"); 
		query.append("   CLT_PAYR_CUST_SEQ, REV_DIV_CD, BKG_RT_WHF_EXPT_CD, " ).append("\n"); 
		query.append("   WHF_SHPR_RGST_NO, RT_APLY_DT, CGO_RCV_DT, " ).append("\n"); 
		query.append("   DIFF_RMK, AUD_STS_CD, CRE_USR_ID, " ).append("\n"); 
		query.append("   CRE_DT, UPD_USR_ID, UPD_DT, " ).append("\n"); 
		query.append("   PRC_RT_MTCH_PATT_CD, PRC_GEN_SPCL_RT_TP_CD, PRC_CMDT_HDR_SEQ, " ).append("\n"); 
		query.append("   PRC_ROUT_SEQ, CALC_CTRT_TP_CD) " ).append("\n"); 
		query.append("VALUES ( " ).append("\n"); 
		query.append("   @[bkg_no], @[rt_bl_tp_cd], @[frt_term_cd], " ).append("\n"); 
		query.append("   @[bkg_ctrt_tp_cd], @[ppd_rcv_ofc_cd], @[ppd_payr_cnt_cd], " ).append("\n"); 
		query.append("   @[ppd_payr_cust_seq], @[clt_ofc_cd], @[clt_payr_cnt_cd], " ).append("\n"); 
		query.append("   @[clt_payr_cust_seq], @[rev_div_cd], @[bkg_rt_whf_expt_cd], " ).append("\n"); 
		query.append("   @[whf_shpr_rgst_no], TO_DATE(REPLACE(@[rt_aply_dt],'-','') ,'YYYY-MM-DD HH24:MI:SS') , TO_DATE(REPLACE(@[cgo_rcv_dt],'-','') ,'YYYY-MM-DD HH24:MI:SS') , " ).append("\n"); 
		query.append("   @[diff_rmk], @[aud_prfm_flg], @[user_id], " ).append("\n"); 
		query.append("   sysdate, @[user_id], sysdate, " ).append("\n"); 
		query.append("   @[prc_rt_mtch_patt_cd], @[prc_gen_spcl_rt_tp_cd], @[prc_cmdt_hdr_seq], " ).append("\n"); 
		query.append("   @[prc_rout_seq], @[calc_ctrt_tp_cd]" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
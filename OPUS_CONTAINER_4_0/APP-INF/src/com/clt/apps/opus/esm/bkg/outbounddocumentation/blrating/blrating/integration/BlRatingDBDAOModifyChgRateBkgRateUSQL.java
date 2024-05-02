/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlRatingDBDAOModifyChgRateBkgRateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOModifyChgRateBkgRateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyChgRateBkgRate
	  * </pre>
	  */
	public BlRatingDBDAOModifyChgRateBkgRateUSQL(){
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
		params.put("decl_cgo_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("decl_cgo_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOModifyChgRateBkgRateUSQL").append("\n"); 
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
		query.append("UPDATE " ).append("\n"); 
		query.append("	BKG_RT_HIS" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	RT_BL_TP_CD 	=  @[rt_bl_tp_cd]" ).append("\n"); 
		query.append("	,BKG_CTRT_TP_CD =  @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("	,FRT_TERM_CD 	=  @[frt_term_cd]" ).append("\n"); 
		query.append("	,RT_APLY_DT		= TO_DATE(REPLACE(@[rt_aply_dt],'-','') ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	,PPD_RCV_OFC_CD	= @[ppd_rcv_ofc_cd] " ).append("\n"); 
		query.append("	,PPD_PAYR_CNT_CD 	= @[ppd_payr_cnt_cd] " ).append("\n"); 
		query.append("	,PPD_PAYR_CUST_SEQ 	= @[ppd_payr_cust_seq] " ).append("\n"); 
		query.append("	,CLT_OFC_CD 		= @[clt_ofc_cd]" ).append("\n"); 
		query.append("	,CLT_PAYR_CNT_CD 	= @[clt_payr_cnt_cd] " ).append("\n"); 
		query.append("	,CLT_PAYR_CUST_SEQ 	= @[clt_payr_cust_seq]" ).append("\n"); 
		query.append("	,PRC_RT_MTCH_PATT_CD = @[prc_rt_mtch_patt_cd]" ).append("\n"); 
		query.append("	,PRC_GEN_SPCL_RT_TP_CD = @[prc_gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	,PRC_CMDT_HDR_SEQ = @[prc_cmdt_hdr_seq]" ).append("\n"); 
		query.append("	,PRC_ROUT_SEQ = @[prc_rout_seq]" ).append("\n"); 
		query.append("	,DECL_CGO_CHG_AMT = @[decl_cgo_chg_amt]" ).append("\n"); 
		query.append("	,DECL_CGO_CURR_CD = @[decl_cgo_curr_cd]" ).append("\n"); 
		query.append("	,UPD_USR_ID		=  @[user_id]" ).append("\n"); 
		query.append("	,UPD_DT 		=  sysdate" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO =  @[bkg_no] " ).append("\n"); 
		query.append("	AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("	BKG_RATE " ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	RT_BL_TP_CD 	=  @[rt_bl_tp_cd]" ).append("\n"); 
		query.append("	,BKG_CTRT_TP_CD =  @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("	,FRT_TERM_CD 	=  @[frt_term_cd]" ).append("\n"); 
		query.append("	,RT_APLY_DT		= TO_DATE(REPLACE(@[rt_aply_dt],'-','') ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	,PPD_RCV_OFC_CD	= @[ppd_rcv_ofc_cd] " ).append("\n"); 
		query.append("	,PPD_PAYR_CNT_CD 	= @[ppd_payr_cnt_cd] " ).append("\n"); 
		query.append("	,PPD_PAYR_CUST_SEQ 	= @[ppd_payr_cust_seq] " ).append("\n"); 
		query.append("	,CLT_OFC_CD 		= @[clt_ofc_cd]" ).append("\n"); 
		query.append("	,CLT_PAYR_CNT_CD 	= @[clt_payr_cnt_cd] " ).append("\n"); 
		query.append("	,CLT_PAYR_CUST_SEQ 	= @[clt_payr_cust_seq]" ).append("\n"); 
		query.append("	,PRC_RT_MTCH_PATT_CD = @[prc_rt_mtch_patt_cd]" ).append("\n"); 
		query.append("	,PRC_GEN_SPCL_RT_TP_CD = @[prc_gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	,PRC_CMDT_HDR_SEQ = @[prc_cmdt_hdr_seq]" ).append("\n"); 
		query.append("	,PRC_ROUT_SEQ = @[prc_rout_seq]" ).append("\n"); 
		query.append("	,DECL_CGO_CHG_AMT = @[decl_cgo_chg_amt]" ).append("\n"); 
		query.append("	,DECL_CGO_CURR_CD = @[decl_cgo_curr_cd]" ).append("\n"); 
		query.append("	,UPD_USR_ID		=  @[user_id]" ).append("\n"); 
		query.append("	,UPD_DT 		=  sysdate" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
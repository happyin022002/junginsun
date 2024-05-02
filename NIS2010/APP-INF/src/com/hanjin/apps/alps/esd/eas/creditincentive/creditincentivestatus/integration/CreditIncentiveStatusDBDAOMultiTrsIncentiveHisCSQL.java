/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOMultiTrsIncentiveHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.15 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOMultiTrsIncentiveHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS Incentive History Save
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOMultiTrsIncentiveHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oct_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_rcv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dec_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aug_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_rmn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ut_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sep_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_incnt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("may_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_n2nd_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sep_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nov_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jan_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oct_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mar_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jun_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aug_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incnt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dec_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incnt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incnt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apr_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feb_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apr_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feb_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("may_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cyc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_rcv_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_dt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jan_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jun_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mar_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_rmn_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nov_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jul_cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jul_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incnt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOMultiTrsIncentiveHisCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_TRSP_INCNT_HIS(" ).append("\n"); 
		query.append("	   BSE_YR" ).append("\n"); 
		query.append("	  ,INCNT_NO" ).append("\n"); 
		query.append("	  ,INCNT_HIS_SEQ" ).append("\n"); 
		query.append("	  ,RHQ_CD" ).append("\n"); 
		query.append("	  ,INV_OFC_CD" ).append("\n"); 
		query.append("	  ,INV_TRNS_MOD_CD" ).append("\n"); 
		query.append("	  ,VNDR_SEQ" ).append("\n"); 
		query.append("	  ,ORG_YD_DESC" ).append("\n"); 
		query.append("	  ,DEST_YD_DESC" ).append("\n"); 
		query.append("	  ,EFF_FM_DT" ).append("\n"); 
		query.append("	  ,EFF_TO_DT" ).append("\n"); 
		query.append("	  ,INV_CYC_CD" ).append("\n"); 
		query.append("	  ,INV_ISS_DT_RMK" ).append("\n"); 
		query.append("	  ,FULL_MTY_CD" ).append("\n"); 
		query.append("	  ,LGS_COST_CD" ).append("\n"); 
		query.append("	  ,INCNT_UT_CD" ).append("\n"); 
		query.append("	  ,JAN_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,FEB_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,MAR_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,APR_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,MAY_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,JUN_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,JUL_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,AUG_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,SEP_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,OCT_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,NOV_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,DEC_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,TTL_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,ESTM_CNTR_VOL_QTY" ).append("\n"); 
		query.append("	  ,CURR_CD" ).append("\n"); 
		query.append("	  ,CNTR_UT_INCNT_AMT" ).append("\n"); 
		query.append("	  ,JAN_INCNT_AMT" ).append("\n"); 
		query.append("	  ,FEB_INCNT_AMT" ).append("\n"); 
		query.append("	  ,MAR_INCNT_AMT" ).append("\n"); 
		query.append("	  ,APR_INCNT_AMT" ).append("\n"); 
		query.append("	  ,MAY_INCNT_AMT" ).append("\n"); 
		query.append("	  ,JUN_INCNT_AMT" ).append("\n"); 
		query.append("	  ,JUL_INCNT_AMT" ).append("\n"); 
		query.append("	  ,AUG_INCNT_AMT" ).append("\n"); 
		query.append("	  ,SEP_INCNT_AMT" ).append("\n"); 
		query.append("	  ,OCT_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NOV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,DEC_INCNT_AMT" ).append("\n"); 
		query.append("	  ,TTL_INCNT_AMT" ).append("\n"); 
		query.append("	  ,TTL_RCV_AMT" ).append("\n"); 
		query.append("	  ,TTL_RMN_AMT" ).append("\n"); 
		query.append("	  ,TTL_INCNT_USD_AMT" ).append("\n"); 
		query.append("	  ,TTL_RCV_USD_AMT" ).append("\n"); 
		query.append("	  ,TTL_RMN_USD_AMT" ).append("\n"); 
		query.append("	  ,RCT_DT_RMK" ).append("\n"); 
		query.append("	  ,INCNT_DESC" ).append("\n"); 
		query.append("	  ,INCNT_RMK" ).append("\n"); 
		query.append("	  ,ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,ATCH_N2ND_FILE_LNK_ID " ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("	)VALUES(" ).append("\n"); 
		query.append("	   @[bse_yr]" ).append("\n"); 
		query.append("	  ,@[incnt_no]" ).append("\n"); 
		query.append("	  ,(SELECT CASE WHEN MAX(INCNT_HIS_SEQ) IS NULL THEN 1" ).append("\n"); 
		query.append("                    ELSE MAX(INCNT_HIS_SEQ)+1" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("          FROM EAS_TRSP_INCNT_HIS" ).append("\n"); 
		query.append("         WHERE BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("           AND INCNT_NO = @[incnt_no])" ).append("\n"); 
		query.append("	  ,@[rhq_cd]" ).append("\n"); 
		query.append("	  ,@[inv_ofc_cd]" ).append("\n"); 
		query.append("	  ,@[inv_trns_mod_cd]" ).append("\n"); 
		query.append("	  ,@[vndr_seq]" ).append("\n"); 
		query.append("	  ,@[org_yd_desc]" ).append("\n"); 
		query.append("	  ,@[dest_yd_desc]" ).append("\n"); 
		query.append("	  ,TO_DATE(@[eff_fm_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	  ,TO_DATE(@[eff_to_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	  ,@[inv_cyc_cd]" ).append("\n"); 
		query.append("	  ,@[inv_iss_dt_rmk]" ).append("\n"); 
		query.append("	  ,@[full_mty_cd]" ).append("\n"); 
		query.append("	  ,@[lgs_cost_cd]" ).append("\n"); 
		query.append("	  ,@[incnt_ut_cd]" ).append("\n"); 
		query.append("	  ,@[jan_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[feb_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[mar_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[apr_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[may_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[jun_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[jul_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[aug_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[sep_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[oct_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[nov_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[dec_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[ttl_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[estm_cntr_vol_qty]" ).append("\n"); 
		query.append("	  ,@[curr_cd]" ).append("\n"); 
		query.append("	  ,@[cntr_ut_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[jan_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[feb_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[mar_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[apr_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[may_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[jun_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[jul_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[aug_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[sep_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[oct_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[nov_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[dec_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[ttl_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[ttl_rcv_amt]" ).append("\n"); 
		query.append("	  ,@[ttl_rmn_amt]" ).append("\n"); 
		query.append("	  ,@[ttl_incnt_usd_amt]" ).append("\n"); 
		query.append("	  ,@[ttl_rcv_usd_amt]" ).append("\n"); 
		query.append("	  ,@[ttl_rmn_usd_amt]" ).append("\n"); 
		query.append("	  ,@[rct_dt_rmk]" ).append("\n"); 
		query.append("	  ,@[incnt_desc]" ).append("\n"); 
		query.append("	  ,@[incnt_rmk]" ).append("\n"); 
		query.append("	  ,@[atch_file_lnk_id]" ).append("\n"); 
		query.append("      ,@[atch_n2nd_file_lnk_id]" ).append("\n"); 
		query.append("	  ,@[usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	  ,@[usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOApCancelCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOApCancelCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Cancel
	  * </pre>
	  */
	public AGTAuditDBDAOApCancelCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_pre_locl_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_if_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_locl_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_if_locl_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_pre_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOApCancelCSQL").append("\n"); 
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
		query.append("INSERT INTO AGT_AGN_COMM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("BKG_NO_SPLIT," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("@[ac_seq] + 1, --//ac_seq" ).append("\n"); 
		query.append("COMM_OCCR_INFO_CD," ).append("\n"); 
		query.append("COMM_YRMON," ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("AP_OFC_CD," ).append("\n"); 
		query.append("AP_CTR_CD," ).append("\n"); 
		query.append("OFC_ENG_NM," ).append("\n"); 
		query.append("OTR_COMM_ACCT_CTNT," ).append("\n"); 
		query.append("COMM_STND_COST_CD," ).append("\n"); 
		query.append("COMM_SLAN_CD," ).append("\n"); 
		query.append("COMM_RLANE_CD," ).append("\n"); 
		query.append("COMM_VSL_CD," ).append("\n"); 
		query.append("COMM_SKD_VOY_NO," ).append("\n"); 
		query.append("COMM_SKD_DIR_CD," ).append("\n"); 
		query.append("COMM_REV_DIR_CD," ).append("\n"); 
		query.append("'IC', 	--//comm_proc_sts_cd" ).append("\n"); 
		query.append("'Interface Cancel!', 	--//comm_proc_sts_rsn" ).append("\n"); 
		query.append("NULL, 	--//comm_apro_no" ).append("\n"); 
		query.append("NULL, 	--//asa_no" ).append("\n"); 
		query.append("AGN_AGMT_NO," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("SAIL_ARR_DT," ).append("\n"); 
		query.append("CHG_DDCT_AMT," ).append("\n"); 
		query.append("FDRG_DDCT_AMT," ).append("\n"); 
		query.append("HLG_DDCT_AMT," ).append("\n"); 
		query.append("AGN_AGMT_RT," ).append("\n"); 
		query.append("@[act_pre_comm_amt], 				--//act_pre_comm_amt" ).append("\n"); 
		query.append("@[act_comm_amt], 				--//act_comm_amt" ).append("\n"); 
		query.append("@[act_if_comm_amt], 				--//act_if_comm_amt" ).append("\n"); 
		query.append("@[act_pre_locl_comm_amt], 				--//act_pre_locl_comm_amt" ).append("\n"); 
		query.append("@[act_locl_comm_amt], 				--//act_locl_comm_amt" ).append("\n"); 
		query.append("@[act_if_locl_comm_amt], 				--//act_if_locl_comm_amt" ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("VVD_XCH_RT," ).append("\n"); 
		query.append("MON_XCH_RT," ).append("\n"); 
		query.append("DLY_XCH_RT," ).append("\n"); 
		query.append("OFC_CHR_LVL," ).append("\n"); 
		query.append("OFFST_AGN_FLG," ).append("\n"); 
		query.append("'N', 	--//accl_flg" ).append("\n"); 
		query.append("NULL, 	--//ac_apro_usr_id" ).append("\n"); 
		query.append("NULL, 	--//ac_apro_dt" ).append("\n"); 
		query.append("NULL, 	--//ac_if_usr_id" ).append("\n"); 
		query.append("NULL, 	--//ac_if_dt" ).append("\n"); 
		query.append("APLY_DT," ).append("\n"); 
		query.append("NULL, 	--//csr_no" ).append("\n"); 
		query.append("INV_TAX_RT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("@[upd_usr_id], 	--//upd_usr_id" ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("NULL, 	--//ac_rqst_usr_id" ).append("\n"); 
		query.append("NULL, 	--//ac_rqst_usr_eml" ).append("\n"); 
		query.append("NULL, 	--//ac_rqst_dt" ).append("\n"); 
		query.append("AC_APRO_USR_EML," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("AGN_APRO_RMK," ).append("\n"); 
		query.append("ESTM_USD_AMT," ).append("\n"); 
		query.append("GL_DT," ).append("\n"); 
		query.append("GRS_NET_DIV_CD" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] 	--//bkg_no" ).append("\n"); 
		query.append("AND AGN_CD = @[agn_cd] 	--//agn_cd" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd] 	--//io_bnd_cd" ).append("\n"); 
		query.append("AND AC_TP_CD = @[ac_tp_cd] 	--//ac_tp_cd" ).append("\n"); 
		query.append("AND AC_SEQ = @[ac_seq] 	--//ac_seq" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
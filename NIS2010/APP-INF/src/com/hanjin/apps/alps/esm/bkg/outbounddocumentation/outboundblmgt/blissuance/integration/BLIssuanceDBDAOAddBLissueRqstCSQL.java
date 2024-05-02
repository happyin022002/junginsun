/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBLissueRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddBLissueRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L 발급 요청 시 요청 정보를 ALPS로 I/F
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBLissueRqstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_inv_rcvr_atnd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_usa_bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_rqst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_bl_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_exist_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bank_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_usa_bank_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_inv_rcvr_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remit_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_atnd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_inv_rcvr_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_usa_remit_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remit_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_rct_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_remit_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_bl_obrd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_inv_rcvr_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_usa_acct_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_acct_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_remit_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rqst_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_usa_remit_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddBLissueRqstCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_BL_ISS_RQST" ).append("\n"); 
		query.append(" ( XTER_RQST_NO " ).append("\n"); 
		query.append(", XTER_RQST_SEQ " ).append("\n"); 
		query.append(", BL_ISS_RQST_DT " ).append("\n"); 
		query.append(", RQST_RCT_LOC_CD " ).append("\n"); 
		query.append(", BL_NO " ).append("\n"); 
		query.append(", VSL_CD " ).append("\n"); 
		query.append(", SKD_VOY_NO " ).append("\n"); 
		query.append(", SKD_DIR_CD " ).append("\n"); 
		query.append(", VSL_NM " ).append("\n"); 
		query.append(", RQST_BL_TP_CD " ).append("\n"); 
		query.append(", RQST_CO_NM " ).append("\n"); 
		query.append(", RQST_USR_EML " ).append("\n"); 
		query.append(", RQST_ATND_NM " ).append("\n"); 
		query.append(", RQST_PHN_NO " ).append("\n"); 
		query.append(", BL_RQST_RMK " ).append("\n"); 
		query.append(", ACT_SHPR_NM " ).append("\n"); 
		query.append(", ACT_SHPR_RGST_NO " ).append("\n"); 
		query.append(", TAX_INV_RCVR_CO_NM " ).append("\n"); 
		query.append(", TAX_INV_RCVR_RGST_NO " ).append("\n"); 
		query.append(", TAX_INV_RCVR_ATND_NM " ).append("\n"); 
		query.append(", TAX_INV_RCVR_PHN_NO " ).append("\n"); 
		query.append(", REMIT_CO_NM " ).append("\n"); 
		query.append(", REMIT_KND_CD " ).append("\n"); 
		query.append(", CRR_BANK_CD " ).append("\n"); 
		query.append(", CRR_BANK_ACCT_NO " ).append("\n"); 
		query.append(", CRR_REMIT_AMT " ).append("\n"); 
		query.append(", CRR_REMIT_DT " ).append("\n"); 
		query.append(", BL_ISS_USR_ID " ).append("\n"); 
		query.append(", BL_ISS_STS_CD " ).append("\n"); 
		query.append(", BL_ISS_RMK " ).append("\n"); 
		query.append(", DELT_FLG " ).append("\n"); 
		query.append(", CRE_USR_ID " ).append("\n"); 
		query.append(", CRE_DT " ).append("\n"); 
		query.append(", UPD_USR_ID " ).append("\n"); 
		query.append(", UPD_DT " ).append("\n"); 
		query.append(", CRR_ACCT_CURR_CD " ).append("\n"); 
		query.append(", BL_ISS_REQ_DT" ).append("\n"); 
		query.append(", CUST_ID" ).append("\n"); 
		query.append(", CRR_USA_BANK_CD" ).append("\n"); 
		query.append(", CRR_USA_BANK_ACCT_NO" ).append("\n"); 
		query.append(", CRR_USA_REMIT_AMT" ).append("\n"); 
		query.append(", CRR_USA_REMIT_DT" ).append("\n"); 
		query.append(", CRR_USA_ACCT_CURR_CD" ).append("\n"); 
		query.append(", BL_ISS_RQST_CD" ).append("\n"); 
		query.append(", BL_RCV_TP_CD" ).append("\n"); 
		query.append(", MNL_BL_OBRD_DT" ).append("\n"); 
		query.append(", MNL_BL_ISS_DT" ).append("\n"); 
		query.append(", CERTI_EXIST_FLG" ).append("\n"); 
		query.append(", FRT_DP_FLG" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES ( @[xter_rqst_no] ," ).append("\n"); 
		query.append("	  (SELECT NVL(MAX(XTER_RQST_SEQ) +1, 1) FROM BKG_BL_ISS_RQST WHERE XTER_RQST_NO = @[xter_rqst_no])," ).append("\n"); 
		query.append("	  SYSDATE," ).append("\n"); 
		query.append("      @[rqst_rct_loc_cd] ," ).append("\n"); 
		query.append("      @[bl_no] ," ).append("\n"); 
		query.append("      @[vsl_cd] ," ).append("\n"); 
		query.append("      @[skd_voy_no] ," ).append("\n"); 
		query.append("      @[skd_dir_cd] ," ).append("\n"); 
		query.append("      @[vsl_nm] ," ).append("\n"); 
		query.append("      @[rqst_bl_tp_cd] ," ).append("\n"); 
		query.append("      @[rqst_co_nm] ," ).append("\n"); 
		query.append("      @[rqst_usr_eml] ," ).append("\n"); 
		query.append("      @[rqst_atnd_nm] ," ).append("\n"); 
		query.append("      @[rqst_phn_no] ," ).append("\n"); 
		query.append("      @[bl_rqst_rmk] ," ).append("\n"); 
		query.append("      @[act_shpr_nm] ," ).append("\n"); 
		query.append("      @[act_shpr_rgst_no] ," ).append("\n"); 
		query.append("      @[tax_inv_rcvr_co_nm] ," ).append("\n"); 
		query.append("      @[tax_inv_rcvr_rgst_no] ," ).append("\n"); 
		query.append("      @[tax_inv_rcvr_atnd_nm] ," ).append("\n"); 
		query.append("      @[tax_inv_rcvr_phn_no] ," ).append("\n"); 
		query.append("      @[remit_co_nm] ," ).append("\n"); 
		query.append("      @[remit_knd_cd] ," ).append("\n"); 
		query.append("      @[crr_bank_cd] ," ).append("\n"); 
		query.append("      @[crr_bank_acct_no] ," ).append("\n"); 
		query.append("      @[crr_remit_amt] ," ).append("\n"); 
		query.append("      TO_DATE(@[crr_remit_dt],'YYYY/MM/DD HH24:MI:SS') ," ).append("\n"); 
		query.append("      @[bl_iss_usr_id] ," ).append("\n"); 
		query.append("      @[bl_iss_sts_cd] ," ).append("\n"); 
		query.append("      @[bl_iss_rmk] ," ).append("\n"); 
		query.append("      NVL(@[delt_flg],'N') ," ).append("\n"); 
		query.append("      'WEB' ," ).append("\n"); 
		query.append("      sysdate ," ).append("\n"); 
		query.append("      'WEB' ," ).append("\n"); 
		query.append("      sysdate ," ).append("\n"); 
		query.append("      @[crr_acct_curr_cd] ," ).append("\n"); 
		query.append("	  SYSDATE," ).append("\n"); 
		query.append("      @[upd_usr_id] ," ).append("\n"); 
		query.append("      @[crr_usa_bank_cd] ," ).append("\n"); 
		query.append("      @[crr_usa_bank_acct_no] ," ).append("\n"); 
		query.append("      @[crr_usa_remit_amt] ," ).append("\n"); 
		query.append("      TO_DATE(@[crr_usa_remit_dt],'YYYY/MM/DD HH24:MI:SS') ," ).append("\n"); 
		query.append("      @[crr_usa_acct_curr_cd]," ).append("\n"); 
		query.append("	  nvl(@[bl_iss_rqst_cd],'W')," ).append("\n"); 
		query.append("      @[bl_rcv_tp_cd]," ).append("\n"); 
		query.append("      TO_DATE(@[mnl_bl_obrd_dt],'YYYY-MM-DD')," ).append("\n"); 
		query.append("      TO_DATE(@[mnl_bl_iss_dt],'YYYY-MM-DD')," ).append("\n"); 
		query.append("      @[certi_exist_flg]," ).append("\n"); 
		query.append("      @[frt_dp_flg]" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}
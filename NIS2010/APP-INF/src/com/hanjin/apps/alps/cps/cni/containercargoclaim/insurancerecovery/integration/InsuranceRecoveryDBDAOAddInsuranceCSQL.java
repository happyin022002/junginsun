/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceRecoveryDBDAOAddInsuranceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.03.15 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceRecoveryDBDAOAddInsuranceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insurance 등록
	  * </pre>
	  */
	public InsuranceRecoveryDBDAOAddInsuranceCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_dmnd_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_dmnd_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_fmal_clm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_crspn_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_dmnd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_crspn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_crspn_apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("insur_plcy_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.integration").append("\n"); 
		query.append("FileName : InsuranceRecoveryDBDAOAddInsuranceCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_CGO_CLM_INSUR(" ).append("\n"); 
		query.append("   CGO_CLM_NO" ).append("\n"); 
		query.append(",  INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",  INSUR_REF_NO" ).append("\n"); 
		query.append(",  AGN_CRSPN_TP_CD" ).append("\n"); 
		query.append(",  AGN_CRSPN_APNT_DT" ).append("\n"); 
		query.append(",  AGN_CRSPN_REF_NO" ).append("\n"); 
		query.append(",  CLM_PTY_NO" ).append("\n"); 
		query.append(",  INSUR_PLCY_YR" ).append("\n"); 
		query.append(",  RCVR_USD_AMT" ).append("\n"); 
		query.append(",  INSUR_FMAL_CLM_DT" ).append("\n"); 
		query.append(",  INSUR_DMND_USD_AMT" ).append("\n"); 
		query.append(",  INSUR_DMND_CURR_CD" ).append("\n"); 
		query.append(",  INSUR_DMND_AMT" ).append("\n"); 
		query.append(",  INSUR_XCH_RT" ).append("\n"); 
		query.append(",  INSUR_RCVR_DT" ).append("\n"); 
		query.append(",  INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append(",  INSUR_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append(",  INSUR_RCVR_AMT" ).append("\n"); 
		query.append(",  INSUR_RCVR_XCH_RT" ).append("\n"); 
		query.append(",  INSUR_RMK" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT  " ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   @[cgo_clm_no]" ).append("\n"); 
		query.append(" , @[insur_clm_pty_no]  -- Insurer" ).append("\n"); 
		query.append(" , @[insur_ref_no]" ).append("\n"); 
		query.append(" , @[agn_crspn_tp_cd]" ).append("\n"); 
		query.append(" , @[agn_crspn_apnt_dt]" ).append("\n"); 
		query.append(" , @[agn_crspn_ref_no]" ).append("\n"); 
		query.append(" , @[clm_pty_no] -- Agent Insurer" ).append("\n"); 
		query.append(" , @[insur_plcy_yr]" ).append("\n"); 
		query.append(" , @[rcvr_usd_amt]" ).append("\n"); 
		query.append(" , @[insur_fmal_clm_dt]" ).append("\n"); 
		query.append(" , @[insur_dmnd_usd_amt]" ).append("\n"); 
		query.append(" , @[insur_dmnd_curr_cd]" ).append("\n"); 
		query.append(" , @[insur_dmnd_amt]" ).append("\n"); 
		query.append(" , @[insur_xch_rt]" ).append("\n"); 
		query.append(" , @[insur_rcvr_dt]" ).append("\n"); 
		query.append(" , @[insur_rcvr_usd_amt]" ).append("\n"); 
		query.append(" , @[insur_rcvr_locl_curr_cd]" ).append("\n"); 
		query.append(" , @[insur_rcvr_amt]" ).append("\n"); 
		query.append(" , @[insur_rcvr_xch_rt]" ).append("\n"); 
		query.append(" , @[insur_rmk]" ).append("\n"); 
		query.append(" , @[cre_usr_id]" ).append("\n"); 
		query.append(" , CNI_GET_GMT_FNC(@[upd_usr_id]) " ).append("\n"); 
		query.append(" , @[upd_usr_id]" ).append("\n"); 
		query.append(" , CNI_GET_GMT_FNC(@[upd_usr_id]))" ).append("\n"); 

	}
}
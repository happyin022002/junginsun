/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceDBDAOCustomInsuranceVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.19 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.insurance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceDBDAOCustomInsuranceVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public InsuranceDBDAOCustomInsuranceVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ins_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ins_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cins_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_ctrt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ins_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lmt_ins_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ins_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ins_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lmt_ins_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rins_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bro_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rins_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cins_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("subj_mat_ins_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("int_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_ctrt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ins_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_plcy_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lmt_ins_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lmt_ins_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.insurance.insurance.integration").append("\n"); 
		query.append("FileName : InsuranceDBDAOCustomInsuranceVOCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_INSUR_CTRT (" ).append("\n"); 
		query.append("INSUR_TP_CD" ).append("\n"); 
		query.append(",	INSUR_PLCY_YR" ).append("\n"); 
		query.append(",	INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",	INSUR_CTNT" ).append("\n"); 
		query.append(",	RINS_CLM_PTY_NO" ).append("\n"); 
		query.append(",	RINS_CTNT" ).append("\n"); 
		query.append(",	INS_CLM_PTY_NO" ).append("\n"); 
		query.append(",	INS_CTNT" ).append("\n"); 
		query.append(",	CINS_CLM_PTY_NO" ).append("\n"); 
		query.append(",	CINS_CTNT" ).append("\n"); 
		query.append(",	BRO_CLM_PTY_NO" ).append("\n"); 
		query.append(",	INT_DESC" ).append("\n"); 
		query.append(",	INSUR_CTRT_EFF_DT" ).append("\n"); 
		query.append(",	INSUR_CTRT_EXP_DT" ).append("\n"); 
		query.append(",	SUBJ_MAT_INS_DESC" ).append("\n"); 
		query.append(",	INS_CURR_CD" ).append("\n"); 
		query.append(",	INS_LOCL_AMT" ).append("\n"); 
		query.append(",	INS_XCH_RT" ).append("\n"); 
		query.append(",	INS_USD_AMT" ).append("\n"); 
		query.append(",	LMT_INS_CURR_CD" ).append("\n"); 
		query.append(",	LMT_INS_LOCL_AMT" ).append("\n"); 
		query.append(",	LMT_INS_XCH_RT" ).append("\n"); 
		query.append(",	LMT_INS_USD_AMT" ).append("\n"); 
		query.append(",	INSUR_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[insur_tp_cd]" ).append("\n"); 
		query.append(",	@[insur_plcy_yr]" ).append("\n"); 
		query.append(",	@[insur_clm_pty_no]" ).append("\n"); 
		query.append(",	@[insur_ctnt]" ).append("\n"); 
		query.append(",	@[rins_clm_pty_no]" ).append("\n"); 
		query.append(",	@[rins_ctnt]" ).append("\n"); 
		query.append(",	@[ins_clm_pty_no]" ).append("\n"); 
		query.append(",	@[ins_ctnt]" ).append("\n"); 
		query.append(",	@[cins_clm_pty_no]" ).append("\n"); 
		query.append(",	@[cins_ctnt]" ).append("\n"); 
		query.append(",	@[bro_clm_pty_no]" ).append("\n"); 
		query.append(",	@[int_desc]" ).append("\n"); 
		query.append(",	REPLACE(@[insur_ctrt_eff_dt],'-')" ).append("\n"); 
		query.append(",	REPLACE(@[insur_ctrt_exp_dt],'-')" ).append("\n"); 
		query.append(",	@[subj_mat_ins_desc]" ).append("\n"); 
		query.append(",	@[ins_curr_cd]" ).append("\n"); 
		query.append(",	REPLACE(@[ins_locl_amt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[ins_xch_rt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[ins_usd_amt],',')" ).append("\n"); 
		query.append(",	@[lmt_ins_curr_cd]" ).append("\n"); 
		query.append(",	REPLACE(@[lmt_ins_locl_amt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[lmt_ins_xch_rt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[lmt_ins_usd_amt],',')" ).append("\n"); 
		query.append(",	@[insur_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
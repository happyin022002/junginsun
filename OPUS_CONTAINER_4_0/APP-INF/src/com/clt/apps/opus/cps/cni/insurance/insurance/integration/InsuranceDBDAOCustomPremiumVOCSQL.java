/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceDBDAOCustomPremiumVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.13 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.insurance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceDBDAOCustomPremiumVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Premium을 생성한다
	  * </pre>
	  */
	public InsuranceDBDAOCustomPremiumVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfnd_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfnd_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfnd_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfnd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adj_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfnd_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("insur_prm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfnd_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.insurance.insurance.integration").append("\n"); 
		query.append("FileName : InsuranceDBDAOCustomPremiumVOCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_INSUR_PRM (" ).append("\n"); 
		query.append("	INSUR_TP_CD" ).append("\n"); 
		query.append(",	INSUR_PLCY_YR" ).append("\n"); 
		query.append(",   INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",	INSUR_PRM_TP_CD" ).append("\n"); 
		query.append(",	TTL_LOCL_AMT" ).append("\n"); 
		query.append(",	TTL_CURR_CD" ).append("\n"); 
		query.append(",	TTL_XCH_RT" ).append("\n"); 
		query.append(",	TTL_USD_AMT" ).append("\n"); 
		query.append(",	TTL_DUE_DT" ).append("\n"); 
		query.append(",	TTL_PAY_DT" ).append("\n"); 
		query.append(",	ADJ_LOCL_AMT" ).append("\n"); 
		query.append(",	ADJ_CURR_CD" ).append("\n"); 
		query.append(",	ADJ_XCH_RT" ).append("\n"); 
		query.append(",	ADJ_USD_AMT" ).append("\n"); 
		query.append(",	ADJ_DUE_DT" ).append("\n"); 
		query.append(",	ADJ_PAY_DT" ).append("\n"); 
		query.append(",	RFND_LOCL_AMT" ).append("\n"); 
		query.append(",	RFND_CURR_CD" ).append("\n"); 
		query.append(",	RFND_XCH_RT" ).append("\n"); 
		query.append(",	RFND_USD_AMT" ).append("\n"); 
		query.append(",	RFND_DUE_DT" ).append("\n"); 
		query.append(",	RFND_PAY_DT" ).append("\n"); 
		query.append(",	OTS_LOCL_AMT" ).append("\n"); 
		query.append(",	OTS_CURR_CD" ).append("\n"); 
		query.append(",	OTS_XCH_RT" ).append("\n"); 
		query.append(",	OTS_USD_AMT" ).append("\n"); 
		query.append(",	OTS_DUE_DT" ).append("\n"); 
		query.append(",	OTS_PAY_DT" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[insur_tp_cd]	" ).append("\n"); 
		query.append(",	@[insur_plcy_yr]" ).append("\n"); 
		query.append(",   @[insur_clm_pty_no]" ).append("\n"); 
		query.append(",	@[insur_prm_tp_cd]" ).append("\n"); 
		query.append(",	REPLACE(@[ttl_locl_amt],',')" ).append("\n"); 
		query.append(",	@[ttl_curr_cd]" ).append("\n"); 
		query.append(",	REPLACE(@[ttl_xch_rt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[ttl_usd_amt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[ttl_due_dt],'-')" ).append("\n"); 
		query.append(",	REPLACE(@[ttl_pay_dt],'-')" ).append("\n"); 
		query.append(",	REPLACE(@[adj_locl_amt],',')" ).append("\n"); 
		query.append(",	@[adj_curr_cd]" ).append("\n"); 
		query.append(",	REPLACE(@[adj_xch_rt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[adj_usd_amt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[adj_due_dt],'-')" ).append("\n"); 
		query.append(",	REPLACE(@[adj_pay_dt],'-')" ).append("\n"); 
		query.append(",	REPLACE(@[rfnd_locl_amt],',')" ).append("\n"); 
		query.append(",	@[rfnd_curr_cd]" ).append("\n"); 
		query.append(",	REPLACE(@[rfnd_xch_rt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[rfnd_usd_amt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[rfnd_due_dt],'-')" ).append("\n"); 
		query.append(",	REPLACE(@[rfnd_pay_dt],'-')" ).append("\n"); 
		query.append(",	REPLACE(@[ots_locl_amt],',')" ).append("\n"); 
		query.append(",	@[ots_curr_cd]" ).append("\n"); 
		query.append(",	REPLACE(@[ots_xch_rt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[ots_usd_amt],',')" ).append("\n"); 
		query.append(",	REPLACE(@[ots_due_dt],'-')" ).append("\n"); 
		query.append(",	REPLACE(@[ots_pay_dt],'-')" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
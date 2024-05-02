/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementVersionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.02.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementVersionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement Version Create
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementVersionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementVersionCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_AGMT_VER (" ).append("\n"); 
		query.append("   AGMT_CTY_CD" ).append("\n"); 
		query.append(" , AGMT_SEQ" ).append("\n"); 
		query.append(" , AGMT_VER_SEQ" ).append("\n"); 
		query.append(" , EFF_DT" ).append("\n"); 
		query.append(" , EXP_DT" ).append("\n"); 
		query.append(" , VNDR_SEQ" ).append("\n"); 
		query.append(" , LSE_VNDR_URL" ).append("\n"); 
		query.append(" , LSTM_CD" ).append("\n"); 
		query.append(" , OFC_CD" ).append("\n"); 
		query.append(" , CURR_CD " ).append("\n"); 
		query.append(" , REF_NO " ).append("\n"); 
		query.append(" , DPC_RTO " ).append("\n"); 
		query.append(" , MAX_DPC_RTO" ).append("\n"); 
		query.append(" , CNTR_DPC_LVL_CD" ).append("\n"); 
		query.append(" , PST_WDP_RT_TP_CD" ).append("\n"); 
		query.append(" , WDP_DYS" ).append("\n"); 
		query.append(" , WDP_TP_CD" ).append("\n"); 
		query.append(" , DPP_TP_CD" ).append("\n"); 
		query.append(" , AGMT_DT" ).append("\n"); 
		query.append(" , AGMT_RMK" ).append("\n"); 
		query.append(" , BLD_UP_DT" ).append("\n"); 
		query.append(" , LFT_ONF_CHG_CD" ).append("\n"); 
		query.append(" , LSE_PAY_TERM_DYS" ).append("\n"); 
		query.append(" , LSE_FREE_DYS" ).append("\n"); 
		query.append(" , ITCHG_FEE_FLG" ).append("\n"); 
		query.append(" , DIR_ITCHG_FEE_AMT" ).append("\n"); 
		query.append(" , DPC_VAL_FLG" ).append("\n"); 
		query.append(" , LSE_CTRT_NO" ).append("\n"); 
		query.append(" , AGMT_ACT_FLG" ).append("\n"); 
		query.append(" , BLD_UP_ST_DT" ).append("\n"); 
		query.append(" , BLD_UP_END_DT" ).append("\n"); 
		query.append(" , BLD_DWN_ST_DT" ).append("\n"); 
		query.append(" , BLD_DWN_END_DT" ).append("\n"); 
		query.append(" , DCLN_BAL_FLG" ).append("\n"); 
		query.append(" , OLD_AGMT_NO" ).append("\n"); 
		query.append(" , SLB_FLG" ).append("\n"); 
		query.append(" , CRE_USR_ID" ).append("\n"); 
		query.append(" , CRE_DT" ).append("\n"); 
		query.append(" , UPD_USR_ID" ).append("\n"); 
		query.append(" , UPD_DT" ).append("\n"); 
		query.append(" , LSE_PAY_TP_CD " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   LA.AGMT_CTY_CD" ).append("\n"); 
		query.append(" , LA.AGMT_SEQ" ).append("\n"); 
		query.append(" , @[agmt_ver_seq]" ).append("\n"); 
		query.append(" , TO_DATE(@[eff_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" , TO_DATE(@[exp_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" , LA.VNDR_SEQ" ).append("\n"); 
		query.append(" , LA.LSE_VNDR_URL" ).append("\n"); 
		query.append(" , LA.LSTM_CD" ).append("\n"); 
		query.append(" , LA.OFC_CD" ).append("\n"); 
		query.append(" , LA.CURR_CD" ).append("\n"); 
		query.append(" , LA.REF_NO" ).append("\n"); 
		query.append(" , LA.DPC_RTO" ).append("\n"); 
		query.append(" , LA.MAX_DPC_RTO" ).append("\n"); 
		query.append(" , LA.CNTR_DPC_LVL_CD" ).append("\n"); 
		query.append(" , LA.PST_WDP_RT_TP_CD" ).append("\n"); 
		query.append(" , LA.WDP_DYS" ).append("\n"); 
		query.append(" , LA.WDP_TP_CD" ).append("\n"); 
		query.append(" , LA.DPP_TP_CD" ).append("\n"); 
		query.append(" , LA.AGMT_DT" ).append("\n"); 
		query.append(" , LA.AGMT_RMK" ).append("\n"); 
		query.append(" , LA.BLD_UP_DT" ).append("\n"); 
		query.append(" , LA.LFT_ONF_CHG_CD" ).append("\n"); 
		query.append(" , LA.LSE_PAY_TERM_DYS" ).append("\n"); 
		query.append(" , LA.LSE_FREE_DYS" ).append("\n"); 
		query.append(" , LA.ITCHG_FEE_FLG" ).append("\n"); 
		query.append(" , LA.DIR_ITCHG_FEE_AMT" ).append("\n"); 
		query.append(" , LA.DPC_VAL_FLG" ).append("\n"); 
		query.append(" , LA.LSE_CTRT_NO" ).append("\n"); 
		query.append(" , LA.AGMT_ACT_FLG" ).append("\n"); 
		query.append(" , LA.BLD_UP_ST_DT" ).append("\n"); 
		query.append(" , LA.BLD_UP_END_DT" ).append("\n"); 
		query.append(" , LA.BLD_DWN_ST_DT" ).append("\n"); 
		query.append(" , LA.BLD_DWN_END_DT" ).append("\n"); 
		query.append(" , LA.DCLN_BAL_FLG" ).append("\n"); 
		query.append(" , LA.OLD_AGMT_NO" ).append("\n"); 
		query.append(" , LA.SLB_FLG" ).append("\n"); 
		query.append(" , @[cre_usr_id]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" , @[upd_usr_id]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" , LA.LSE_PAY_TP_CD" ).append("\n"); 
		query.append("FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("WHERE LA.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND   LA.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("AND   ROWNUM         = 1" ).append("\n"); 

	}
}
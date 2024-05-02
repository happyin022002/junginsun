/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementRSQL").append("\n"); 
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
		query.append("SELECT LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , LA.AGMT_SEQ" ).append("\n"); 
		query.append("     , LA.AGMT_LST_VER_SEQ	 " ).append("\n"); 
		query.append("#if ( ${agmt_ver_seq} != '' )" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.OLD_AGMT_NO, LA.OLD_AGMT_NO) AS OLD_AGMT_NO" ).append("\n"); 
		query.append("     , LV.AGMT_VER_SEQ AS AGMT_VER_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(NVL2(LV.LSTM_CD, LV.EFF_DT, LA.LST_EFF_DT),'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(NVL2(LV.LSTM_CD, LV.EXP_DT, LA.LST_EXP_DT),'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , LA.VNDR_SEQ AS VNDR_SEQ" ).append("\n"); 
		query.append("     , MV.VNDR_LGL_ENG_NM AS VNDR_NM " ).append("\n"); 
		query.append("     , LA.LSTM_CD" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.OFC_CD, LA.OFC_CD) AS OFC_CD" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.CURR_CD, LA.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.REF_NO, LA.REF_NO) AS REF_NO" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.LSE_CTRT_NO, LA.LSE_CTRT_NO) AS LSE_CTRT_NO" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.DPC_RTO, LA.DPC_RTO) AS DPC_RTO" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.MAX_DPC_RTO, LA.MAX_DPC_RTO) AS MAX_DPC_RTO" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.CNTR_DPC_LVL_CD, LA.CNTR_DPC_LVL_CD) AS CNTR_DPC_LVL_CD" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.DPP_TP_CD, LA.DPP_TP_CD) AS DPP_TP_CD" ).append("\n"); 
		query.append("     , TO_CHAR(NVL2(LV.LSTM_CD, LV.AGMT_DT, LA.AGMT_DT),'YYYYMMDD') AS AGMT_DT" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.AGMT_RMK, LA.AGMT_RMK) AS AGMT_RMK" ).append("\n"); 
		query.append("     , TO_CHAR(NVL2(LV.LSTM_CD, LV.BLD_UP_DT, LA.BLD_UP_DT),'YYYYMMDD') AS BLD_UP_DT" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.LFT_ONF_CHG_CD, LA.LFT_ONF_CHG_CD) AS LFT_ONF_CHG_CD" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.LSE_PAY_TERM_DYS, LA.LSE_PAY_TERM_DYS) AS LSE_PAY_TERM_DYS" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.LSE_FREE_DYS, LA.LSE_FREE_DYS) AS LSE_FREE_DYS" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.ITCHG_FEE_FLG, LA.ITCHG_FEE_FLG) AS ITCHG_FEE_FLG" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.DIR_ITCHG_FEE_AMT, LA.DIR_ITCHG_FEE_AMT) AS DIR_ITCHG_FEE_AMT" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.LSE_VNDR_URL, LA.LSE_VNDR_URL) AS LSE_VNDR_URL" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.DPC_VAL_FLG, LA.DPC_VAL_FLG) AS DPC_VAL_FLG" ).append("\n"); 
		query.append(" 	 , LA.CRE_USR_ID||' / '||LA.UPD_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(LA.CRE_DT, 'YYYY-MM-DD')||' / '||TO_CHAR(LA.UPD_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("	 ,(SELECT   CASE WHEN COUNT(*) = 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("       FROM     MST_CONTAINER" ).append("\n"); 
		query.append("       WHERE    AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND      AGMT_SEQ = LA.AGMT_SEQ" ).append("\n"); 
		query.append("       AND     (ACIAC_DIV_CD = 'A' OR (ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append("       AND      CNTR_STS_CD IN('SBO','MUO','LST','SRO'))) " ).append("\n"); 
		query.append("	   ) AS AGMT_ACT_FLG" ).append("\n"); 
		query.append("     , NVL2(LV.LSTM_CD, LV.SLB_FLG, LA.SLB_FLG) AS SLB_FLG" ).append("\n"); 
		query.append("	 , NVL2(LV.LSTM_CD, LV.LSE_PAY_TP_CD, LA.LSE_PAY_TP_CD) AS LSE_PAY_TP_CD" ).append("\n"); 
		query.append("     , NVL(TO_CHAR( NVL2(LV.LSTM_CD, LV.BLD_DWN_END_DT, LA.BLD_DWN_END_DT),'YYYY-MM-DD'),'') AS BLD_DWN_END_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , LA.OLD_AGMT_NO" ).append("\n"); 
		query.append("     , LA.AGMT_LST_VER_SEQ AS AGMT_VER_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(LA.LST_EFF_DT,'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(LA.LST_EXP_DT,'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , LA.VNDR_SEQ" ).append("\n"); 
		query.append("     , MV.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("     , LA.LSTM_CD" ).append("\n"); 
		query.append("     , LA.OFC_CD" ).append("\n"); 
		query.append("     , LA.CURR_CD" ).append("\n"); 
		query.append("     , LA.REF_NO" ).append("\n"); 
		query.append("     , LA.LSE_CTRT_NO" ).append("\n"); 
		query.append("     , LA.DPC_RTO" ).append("\n"); 
		query.append("     , LA.MAX_DPC_RTO" ).append("\n"); 
		query.append("     , LA.CNTR_DPC_LVL_CD" ).append("\n"); 
		query.append("     , LA.DPP_TP_CD" ).append("\n"); 
		query.append("     , TO_CHAR(LA.AGMT_DT,'YYYYMMDD') AS AGMT_DT" ).append("\n"); 
		query.append("     , LA.AGMT_RMK" ).append("\n"); 
		query.append("     , TO_CHAR(LA.BLD_UP_DT,'YYYYMMDD') AS BLD_UP_DT" ).append("\n"); 
		query.append("     , LA.LFT_ONF_CHG_CD" ).append("\n"); 
		query.append("     , LA.LSE_PAY_TERM_DYS" ).append("\n"); 
		query.append("     , LA.LSE_FREE_DYS" ).append("\n"); 
		query.append("     , LA.ITCHG_FEE_FLG" ).append("\n"); 
		query.append("     , LA.DIR_ITCHG_FEE_AMT" ).append("\n"); 
		query.append("     , LA.LSE_VNDR_URL" ).append("\n"); 
		query.append("     , LA.DPC_VAL_FLG" ).append("\n"); 
		query.append("     , LA.CRE_USR_ID||' / '||LA.UPD_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(LA.CRE_DT, 'YYYY-MM-DD')||' / '||TO_CHAR(LA.UPD_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("	 ,(SELECT   CASE WHEN COUNT(*) = 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("       FROM     MST_CONTAINER" ).append("\n"); 
		query.append("       WHERE    AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND      AGMT_SEQ = LA.AGMT_SEQ" ).append("\n"); 
		query.append("       AND     (ACIAC_DIV_CD = 'A' OR (ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append("       AND      CNTR_STS_CD IN('SBO','MUO','LST','SRO'))) " ).append("\n"); 
		query.append("	   ) AS AGMT_ACT_FLG" ).append("\n"); 
		query.append("     , LA.SLB_FLG" ).append("\n"); 
		query.append("	 , LA.LSE_PAY_TP_CD" ).append("\n"); 
		query.append("	 , NVL(TO_CHAR(LA.BLD_DWN_END_DT,'YYYY-MM-DD'),'') AS BLD_DWN_END_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT LA" ).append("\n"); 
		query.append("     , MDM_VENDOR    MV" ).append("\n"); 
		query.append("     , LSE_AGMT_VER  LV" ).append("\n"); 
		query.append("WHERE  MV.VNDR_SEQ = LA.VNDR_SEQ" ).append("\n"); 
		query.append("AND    LA.AGMT_CTY_CD = LV.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND    LA.AGMT_SEQ    = LV.AGMT_SEQ(+)" ).append("\n"); 
		query.append("#if ( ${agmt_ver_seq} != '' )" ).append("\n"); 
		query.append("AND    LV.AGMT_VER_SEQ = @[agmt_ver_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    LA.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND    LA.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 

	}
}
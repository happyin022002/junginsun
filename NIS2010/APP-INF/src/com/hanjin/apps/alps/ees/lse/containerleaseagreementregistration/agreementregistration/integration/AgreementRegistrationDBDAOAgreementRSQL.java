/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
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
		query.append("     , LA.AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append("#if ( ${agmt_ver_seq} != '' )" ).append("\n"); 
		query.append("     , LV.AGMT_VER_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(LV.EFF_DT,'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(LV.EXP_DT,'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , LA.AGMT_LST_VER_SEQ AS AGMT_VER_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(LA.LST_EFF_DT,'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(LA.LST_EXP_DT,'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , LA.VNDR_SEQ" ).append("\n"); 
		query.append("     , MV.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("     , LA.LSTM_CD" ).append("\n"); 
		query.append("     , LA.OFC_CD" ).append("\n"); 
		query.append("     , LA.CURR_CD" ).append("\n"); 
		query.append("     , LA.REF_NO" ).append("\n"); 
		query.append("     , LA.LSE_CTRT_NO" ).append("\n"); 
		query.append("     , LA.DPC_RTO DPC_RTO_VAL" ).append("\n"); 
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
		query.append("     , LA.CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(LA.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("	 ,(SELECT   CASE WHEN COUNT(*) = 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("       FROM     MST_CONTAINER" ).append("\n"); 
		query.append("       WHERE    AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND      AGMT_SEQ = LA.AGMT_SEQ" ).append("\n"); 
		query.append("       AND     (ACIAC_DIV_CD = 'A' OR (ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append("       AND      CNTR_STS_CD IN('SBO','MUO','LST','SRO'))) " ).append("\n"); 
		query.append("	   ) AS AGMT_ACT_FLG" ).append("\n"); 
		query.append("     , LA.LSE_AGMT_DOC_NO" ).append("\n"); 
		query.append("     , LA.LSE_AGMT_DOC_DESC" ).append("\n"); 
		query.append("     , YRY_DPC_RTO DPC_RTO" ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT LA" ).append("\n"); 
		query.append("     , MDM_VENDOR    MV" ).append("\n"); 
		query.append("#if ( ${agmt_ver_seq} != '' )" ).append("\n"); 
		query.append("     , LSE_AGMT_VER  LV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  MV.VNDR_SEQ = LA.VNDR_SEQ" ).append("\n"); 
		query.append("#if ( ${agmt_ver_seq} != '' )" ).append("\n"); 
		query.append("AND    LV.AGMT_VER_SEQ = @[agmt_ver_seq]" ).append("\n"); 
		query.append("AND    LV.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    LV.AGMT_SEQ = LA.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    LA.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND    LA.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 

	}
}
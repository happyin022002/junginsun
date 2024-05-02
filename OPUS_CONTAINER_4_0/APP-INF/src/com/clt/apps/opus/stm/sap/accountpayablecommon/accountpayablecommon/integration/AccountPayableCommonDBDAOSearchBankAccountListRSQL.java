/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchBankAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.21
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.21 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchBankAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableCommonDBDAOSearchBankAccountListRSQL
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchBankAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchBankAccountListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       SBB.BANK_NM," ).append("\n"); 
		query.append("       SBB.BANK_BRNC_NM," ).append("\n"); 
		query.append("       SBA.BANK_BRNC_SEQ," ).append("\n"); 
		query.append("       SBA.BANK_ACCT_SEQ," ).append("\n"); 
		query.append("       SBA.BANK_ACCT_NM," ).append("\n"); 
		query.append("       SBA.BANK_ACCT_ALTN_NM," ).append("\n"); 
		query.append("       SBA.BANK_ACCT_DESC, " ).append("\n"); 
		query.append("       SBA.BANK_ACCT_NO," ).append("\n"); 
		query.append("       SBA.BANK_ACCT_TP_NM," ).append("\n"); 
		query.append("       TO_CHAR(SBA.BANK_ACCT_ST_DT, 'YYYYMMDD') AS BANK_ACCT_ST_DT," ).append("\n"); 
		query.append("       TO_CHAR(SBA.INACT_DT,'YYYYMMDD') AS INACT_DT, " ).append("\n"); 
		query.append("       SBA.ACCT_TP_CD," ).append("\n"); 
		query.append("       SBA.CURR_CD," ).append("\n"); 
		query.append("       SBA.CNTC_NM," ).append("\n"); 
		query.append("       DECODE(SBA.ATTR_CTNT1,'OFF','Y','N') AS ATTR_CTNT1," ).append("\n"); 
		query.append("       SBA.ATTR_CTNT2," ).append("\n"); 
		query.append("       SBA.CNTC_AREA_CD," ).append("\n"); 
		query.append("       CNT.CNT_NM AS CNTC_AREA_NM," ).append("\n"); 
		query.append("       SBA.CNTC_PHN_NO," ).append("\n"); 
		query.append("       SBA.MLT_CURR_FLG," ).append("\n"); 
		query.append("       SBA.BANK_ACCT_TP_MN_CD," ).append("\n"); 
		query.append("       SBA.BANK_ACCT_TP_SUB_CD," ).append("\n"); 
		query.append("       SBA.BANK_CATE_CD," ).append("\n"); 
		query.append("       SBA.ASET_CD_CMB_SEQ," ).append("\n"); 
		query.append("       SBA.CHG_CD_CMB_SEQ," ).append("\n"); 
		query.append("       SBA.GAIN_CD_CMB_SEQ," ).append("\n"); 
		query.append("       SBA.LSS_CD_CMB_SEQ," ).append("\n"); 
		query.append("       SBA.OPN_OFC_CD," ).append("\n"); 
		query.append("       SBA.AP_CTRL_OFC_CD," ).append("\n"); 
		query.append("       SBA.AR_OFC_CD," ).append("\n"); 
		query.append("       SBA.DPS_DIV_CD," ).append("\n"); 
		query.append("       SBA.CNTC_TIT_NM," ).append("\n"); 
		query.append("       (SELECT SLD.LU_DESC" ).append("\n"); 
		query.append("        FROM SCO_LU_DTL SLD, SCO_LU_HDR SLH" ).append("\n"); 
		query.append("        WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("        AND SLH.LU_APPL_CD='SAP'" ).append("\n"); 
		query.append("        AND SLH.LU_TP_CD='BANK ACCOUNT TYPE(L)'" ).append("\n"); 
		query.append("        AND SLD.LU_CD = SBA.BANK_ACCT_TP_MN_CD) ACCT_TYPE_L," ).append("\n"); 
		query.append("       (SELECT SLD.LU_DESC" ).append("\n"); 
		query.append("        FROM SCO_LU_DTL SLD, SCO_LU_HDR SLH" ).append("\n"); 
		query.append("        WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("        AND SLH.LU_APPL_CD='SAP'" ).append("\n"); 
		query.append("        AND SLH.LU_TP_CD='BANK ACCOUNT TYPE(M)'" ).append("\n"); 
		query.append("        AND SLD.LU_CD = SBA.BANK_ACCT_TP_MN_CD) ACCT_TYPE_M," ).append("\n"); 
		query.append("			'' AS USR_ID," ).append("\n"); 
		query.append("			'' AS SCH_BANK_ACCT_NO," ).append("\n"); 
		query.append("			'' AS ASET_COA_CO_CD," ).append("\n"); 
		query.append("			'' AS ASET_COA_RGN_CD," ).append("\n"); 
		query.append("			'' AS ASET_COA_CTR_CD," ).append("\n"); 
		query.append("			'' AS ASET_COA_ACCT_NO," ).append("\n"); 
		query.append("			'' AS ASET_COA_INTER_CO_CD," ).append("\n"); 
		query.append("			'' AS ASET_COA_VVD_CD," ).append("\n"); 
		query.append("			'' AS CHG_COA_CO_CD," ).append("\n"); 
		query.append("			'' AS CHG_COA_RGN_CD," ).append("\n"); 
		query.append("			'' AS CHG_COA_CTR_CD," ).append("\n"); 
		query.append("			'' AS CHG_COA_ACCT_NO," ).append("\n"); 
		query.append("			'' AS CHG_COA_INTER_CO_CD," ).append("\n"); 
		query.append("			'' AS CHG_COA_VVD_CD," ).append("\n"); 
		query.append("			'' AS GAIN_COA_CO_CD," ).append("\n"); 
		query.append("			'' AS GAIN_COA_RGN_CD," ).append("\n"); 
		query.append("			'' AS GAIN_COA_CTR_CD," ).append("\n"); 
		query.append("			'' AS GAIN_COA_ACCT_NO," ).append("\n"); 
		query.append("			'' AS GAIN_COA_INTER_CO_CD," ).append("\n"); 
		query.append("			'' AS GAIN_COA_VVD_CD," ).append("\n"); 
		query.append("			'' AS LSS_COA_CO_CD," ).append("\n"); 
		query.append("			'' AS LSS_COA_RGN_CD," ).append("\n"); 
		query.append("			'' AS LSS_COA_CTR_CD," ).append("\n"); 
		query.append("			'' AS LSS_COA_ACCT_No," ).append("\n"); 
		query.append("			'' AS LSS_COA_INTER_CO_CD," ).append("\n"); 
		query.append("			'' AS LSS_COA_VVD_CD             " ).append("\n"); 
		query.append("FROM SAP_BANK_BRNC SBB, SAP_BANK_ACCT SBA, MDM_COUNTRY CNT" ).append("\n"); 
		query.append("WHERE SBB.BANK_BRNC_SEQ = SBA.BANK_BRNC_SEQ" ).append("\n"); 
		query.append("    AND SBA.CNTC_AREA_CD = CNT.CNT_CD(+)" ).append("\n"); 
		query.append("#if (${bank_acct_seq} != '')" ).append("\n"); 
		query.append("	AND SBA.BANK_ACCT_SEQ =@[bank_acct_seq]" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if (${sch_bank_acct_no} != '')" ).append("\n"); 
		query.append("    AND SBA.BANK_ACCT_NO =@[sch_bank_acct_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}
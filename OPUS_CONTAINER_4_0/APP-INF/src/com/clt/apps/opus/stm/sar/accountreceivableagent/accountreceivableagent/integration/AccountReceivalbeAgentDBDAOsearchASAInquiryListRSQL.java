/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivalbeAgentDBDAOsearchASAInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivalbeAgentDBDAOsearchASAInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agent Statement of Account Inquiry
	  * </pre>
	  */
	public AccountReceivalbeAgentDBDAOsearchASAInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no3_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_cre_prd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_cre_prd_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no3_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivalbeAgentDBDAOsearchASAInquiryListRSQL").append("\n"); 
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
		query.append("SELECT   DECODE(GROUPING_ID(SAM.ASA_NO),0, SAM.ASA_NO,'TOTAL') ASA_NO" ).append("\n"); 
		query.append(", SAM.CURR_CD" ).append("\n"); 
		query.append(", DECODE(GROUPING_ID(SAM.ASA_NO),0,MAX(TO_CHAR(TO_DATE(SAM.ASA_PRD_FM_DT,'YYYYMMDD'),'YYYY-MM-DD')))   BIL_CRE_PRD_FM_DT" ).append("\n"); 
		query.append(", DECODE(GROUPING_ID(SAM.ASA_NO),0,MAX(TO_CHAR(TO_DATE(SAM.ASA_PRD_TO_DT,'YYYYMMDD'),'YYYY-MM-DD')))  BIL_CRE_PRD_TO_DT" ).append("\n"); 
		query.append(", DECODE(GROUPING_ID(SAM.ASA_NO),0,SUM(ROUND(SAD.PREV_BAL_AMT, 2)),'') PREV_BAL_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(SAD.REV_RFD_AMT, 2))  REV_RFD_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(SAD.EXPENSE_AMT, 2))  EXPENSE_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(SAD.COMM_AMT, 2))     COMM_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(SAD.RMTC_AMT, 2)) RMTC_AMT" ).append("\n"); 
		query.append(", DECODE(GROUPING_ID(SAM.ASA_NO),0,SUM(ROUND(SAD.LAST_BAL_AMT, 2)),'') LAST_BAL_AMT  " ).append("\n"); 
		query.append(", SUM(ROUND(SAM.ACT_BAL_AMT, 2)) ACTUAL_BAL_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(SAD.UNSET_BAL_AMT, 2)) UNSET_BAL_AMT" ).append("\n"); 
		query.append(", DECODE(GROUPING_ID(SAM.ASA_NO),0,MAX(TO_CHAR(SAM.ASA_FSH_DT,'YYYY-MM-DD')))  AGN_ASA_CRE_DT" ).append("\n"); 
		query.append(", DECODE(GROUPING_ID(SAM.ASA_NO),0,MAX(TO_CHAR(SAM.ASA_APRO_DT,'YYYY-MM-DD HH24:MI:SS'))) APRO_DT" ).append("\n"); 
		query.append(", DECODE(GROUPING_ID(SAM.ASA_NO),0,MAX(SAM.OFC_CD))      OFC_CD" ).append("\n"); 
		query.append(", DECODE(GROUPING_ID(SAM.ASA_NO),0,MAX(SAM.AGN_CD))      AGN_CD" ).append("\n"); 
		query.append(", DECODE(GROUPING_ID(SAM.ASA_NO),0,MAX(SAM.ASA_STS_CD))  ASA_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' AR_OFC_CD" ).append("\n"); 
		query.append(",'' ASA_NO3_FM" ).append("\n"); 
		query.append(",'' ASA_NO3_TO" ).append("\n"); 
		query.append(",'' APPRO" ).append("\n"); 
		query.append("FROM SAR_ASA_MST SAM" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT ASA_NO," ).append("\n"); 
		query.append("       SUM(PREV_BAL_AMT) PREV_BAL_AMT," ).append("\n"); 
		query.append("       SUM(REV_RFD_AMT) REV_RFD_AMT," ).append("\n"); 
		query.append("       SUM(EXPENSE_AMT) EXPENSE_AMT," ).append("\n"); 
		query.append("       SUM(COMM_AMT) COMM_AMT," ).append("\n"); 
		query.append("       SUM(RMTC_AMT) RMTC_AMT," ).append("\n"); 
		query.append("       SUM(LAST_BAL_AMT) LAST_BAL_AMT," ).append("\n"); 
		query.append("       SUM(ACTUAL_BAL_AMT) ACTUAL_BAL_AMT," ).append("\n"); 
		query.append("       SUM(UNSET_BAL_AMT) UNSET_BAL_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ASA_NO," ).append("\n"); 
		query.append("       NVL(ASA_CR_AMT, 0)-NVL(ASA_DR_AMT, 0) PREV_BAL_AMT," ).append("\n"); 
		query.append("       0 REV_RFD_AMT," ).append("\n"); 
		query.append("       0 EXPENSE_AMT," ).append("\n"); 
		query.append("       0 COMM_AMT," ).append("\n"); 
		query.append("       0 RMTC_AMT," ).append("\n"); 
		query.append("       0 LAST_BAL_AMT," ).append("\n"); 
		query.append("       0 ACTUAL_BAL_AMT," ).append("\n"); 
		query.append("      (SELECT SUM(ROUND(SOD.BAL_AMT, 2)) AS BAL_AMT" ).append("\n"); 
		query.append("        FROM SAR_OTS_HDR SOH, " ).append("\n"); 
		query.append("             SAR_OTS_DTL SOD" ).append("\n"); 
		query.append("        WHERE SOH.RHQ_CD            = SOD.RHQ_CD  " ).append("\n"); 
		query.append("        AND SOH.OTS_OFC_CD          = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("        AND SOH.BL_NO               = SOD.BL_NO " ).append("\n"); 
		query.append("        AND SOH.INV_NO              = SOD.INV_NO " ).append("\n"); 
		query.append("        AND SOH.BL_NO = ASA_NO) AS UNSET_BAL_AMT" ).append("\n"); 
		query.append("FROM   SAR_ASA_DTL" ).append("\n"); 
		query.append("WHERE  ASA_DTL_SEQ = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ASA_NO," ).append("\n"); 
		query.append("       0 PREV_BAL_AMT," ).append("\n"); 
		query.append("       ASA_CR_AMT rev_fnd ," ).append("\n"); 
		query.append("       0 EXPENSE_AMT," ).append("\n"); 
		query.append("       0 COMM_AMT," ).append("\n"); 
		query.append("       0 RMTC_AMT," ).append("\n"); 
		query.append("       0 LAST_BAL_AMT," ).append("\n"); 
		query.append("       0 ACTUAL_BAL_AMT," ).append("\n"); 
		query.append("       0 UNSET_BAL_AMT" ).append("\n"); 
		query.append("FROM   SAR_ASA_DTL" ).append("\n"); 
		query.append("WHERE  ASA_DTL_SEQ = 2" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ASA_NO," ).append("\n"); 
		query.append("       0 PREV_BAL_AMT," ).append("\n"); 
		query.append("       (-1)*ASA_DR_AMT REV_RFD_AMT," ).append("\n"); 
		query.append("       0 EXPENSE_AMT," ).append("\n"); 
		query.append("       0 COMM_AMT," ).append("\n"); 
		query.append("       0 RMTC_AMT," ).append("\n"); 
		query.append("       0 LAST_BAL_AMT," ).append("\n"); 
		query.append("       0 ACTUAL_BAL_AMT," ).append("\n"); 
		query.append("       0 UNSET_BAL_AMT" ).append("\n"); 
		query.append("FROM   SAR_ASA_DTL" ).append("\n"); 
		query.append("WHERE  ASA_DTL_SEQ = 3" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ASA_NO," ).append("\n"); 
		query.append("       0 PREV_BAL_AMT," ).append("\n"); 
		query.append("       0 REV_RFD_AMT," ).append("\n"); 
		query.append("       NVL(ASA_DR_AMT, 0)-NVL(ASA_CR_AMT, 0) EXPENSE_AMT," ).append("\n"); 
		query.append("       0 COMM_AMT," ).append("\n"); 
		query.append("       0 RMTC_AMT," ).append("\n"); 
		query.append("       0 LAST_BAL_AMT," ).append("\n"); 
		query.append("       0 ACTUAL_BAL_AMT," ).append("\n"); 
		query.append("       0 UNSET_BAL_AMT" ).append("\n"); 
		query.append("FROM   SAR_ASA_DTL" ).append("\n"); 
		query.append("WHERE  ASA_DTL_SEQ = 4" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ASA_NO," ).append("\n"); 
		query.append("       0 PREV_BAL_AMT," ).append("\n"); 
		query.append("       0 REV_RFD_AMT," ).append("\n"); 
		query.append("       0 EXPENSE_AMT," ).append("\n"); 
		query.append("       NVL(ASA_DR_AMT, 0)-NVL(ASA_CR_AMT, 0) COMM_AMT," ).append("\n"); 
		query.append("       0 RMTC_AMT," ).append("\n"); 
		query.append("       0 LAST_BAL_AMT," ).append("\n"); 
		query.append("       0 ACTUAL_BAL_AMT," ).append("\n"); 
		query.append("       0 UNSET_BAL_AMT" ).append("\n"); 
		query.append("FROM   SAR_ASA_DTL" ).append("\n"); 
		query.append("WHERE  ASA_DTL_SEQ = 5" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ASA_NO," ).append("\n"); 
		query.append("       0 PREV_BAL_AMT," ).append("\n"); 
		query.append("       0 REV_RFD_AMT," ).append("\n"); 
		query.append("       0 EXPENSE_AMT," ).append("\n"); 
		query.append("       0 COMM_AMT," ).append("\n"); 
		query.append("       NVL(ASA_DR_AMT, 0)-NVL(ASA_CR_AMT, 0) RMTC_AMT," ).append("\n"); 
		query.append("       0 LAST_BAL_AMT," ).append("\n"); 
		query.append("       0 ACTUAL_BAL_AMT," ).append("\n"); 
		query.append("       0 UNSET_BAL_AMT" ).append("\n"); 
		query.append("FROM   SAR_ASA_DTL" ).append("\n"); 
		query.append("WHERE  ASA_DTL_SEQ = 6" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ASA_NO," ).append("\n"); 
		query.append("       0 PREV_BAL_AMT," ).append("\n"); 
		query.append("       0 REV_RFD_AMT," ).append("\n"); 
		query.append("       0 EXPENSE_AMT," ).append("\n"); 
		query.append("       0 COMM_AMT," ).append("\n"); 
		query.append("       0 RMTC_AMT," ).append("\n"); 
		query.append("       NVL(ASA_DR_AMT, 0)-NVL(ASA_CR_AMT, 0) LAST_BAL_AMT," ).append("\n"); 
		query.append("       0 ACTUAL_BAL_AMT," ).append("\n"); 
		query.append("       0 UNSET_BAL_AMTbal" ).append("\n"); 
		query.append("FROM   SAR_ASA_DTL" ).append("\n"); 
		query.append("WHERE  ASA_DTL_SEQ = 7" ).append("\n"); 
		query.append(") GROUP BY ASA_NO" ).append("\n"); 
		query.append(") SAD" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND SAM.ASA_NO = SAD.ASA_NO" ).append("\n"); 
		query.append("AND SAM.OFC_CD   = @[ar_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${bil_cre_prd_fm_dt} != '' )" ).append("\n"); 
		query.append("   AND SUBSTR(SAM.ASA_PRD_FM_DT,1,6) >=  REPLACE(@[bil_cre_prd_fm_dt],'-','')       " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${bil_cre_prd_to_dt} != '' )" ).append("\n"); 
		query.append("   AND SUBSTR(SAM.ASA_PRD_TO_DT,1,6) <=  REPLACE(@[bil_cre_prd_to_dt],'-','')       " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${appro} == 'N' )" ).append("\n"); 
		query.append("   AND SAM.ASA_STS_CD IN ('O', 'F') " ).append("\n"); 
		query.append("#elseif ( ${appro} == 'A' )     " ).append("\n"); 
		query.append("   AND SAM.ASA_STS_CD IN ('A') " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${asa_no3_fm} != '' && ${asa_no3_to} != '' ) " ).append("\n"); 
		query.append("   AND TO_NUMBER(SUBSTR(SAM.ASA_NO, 7, 4)) BETWEEN TO_NUMBER(@[asa_no3_fm]) AND TO_NUMBER(@[asa_no3_to])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP by ROLLUP(SAM.ASA_NO), SAM.CURR_CD" ).append("\n"); 

	}
}
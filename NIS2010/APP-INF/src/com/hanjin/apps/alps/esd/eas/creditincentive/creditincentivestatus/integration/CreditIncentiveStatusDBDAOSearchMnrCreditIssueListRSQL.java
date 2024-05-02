/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOSearchMnrCreditIssueListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.05.11 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOSearchMnrCreditIssueListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R Credit Issue Search
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOSearchMnrCreditIssueListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_mkr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cr_usd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOSearchMnrCreditIssueListRSQL").append("\n"); 
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
		query.append("SELECT A.CR_ISS_NO" ).append("\n"); 
		query.append("      ,A.RHQ_CD" ).append("\n"); 
		query.append("      ,A.TEAM_CD" ).append("\n"); 
		query.append("      ,A.MKR_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CR_ISS_DT,'YYYYMMDD') CR_ISS_DT" ).append("\n"); 
		query.append("      ,NVL(A.CR_ISS_UT_AMT,0) CR_ISS_UT_AMT" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.CR_ISS_QTY" ).append("\n"); 
		query.append("      ,A.CR_ISS_TTL_AMT" ).append("\n"); 
		query.append("      ,NVL((SELECT SUM(X.CR_USD_AMT)" ).append("\n"); 
		query.append("              FROM EAS_MNR_CR_USD X" ).append("\n"); 
		query.append("             WHERE X.CR_ISS_NO = A.CR_ISS_NO" ).append("\n"); 
		query.append("               AND X.DELT_FLG = 'N'),0) CR_SUM_USD_AMT" ).append("\n"); 
		query.append("      ,A.CR_ISS_RSN" ).append("\n"); 
		query.append("      ,A.LR_NM" ).append("\n"); 
		query.append("      ,A.AGMT_NO" ).append("\n"); 
		query.append("      ,A.LSTM_CD" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CR_ISS_RMK" ).append("\n"); 
		query.append("      ,A.CR_ISS_EVID_NO" ).append("\n"); 
		query.append("      ,DECODE(A.ATCH_FILE_LNK_ID,'','N','Y') ATCH_FLG" ).append("\n"); 
		query.append("      ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,(SELECT X.USD_LOCL_XCH_RT FROM GL_MON_XCH_RT X WHERE X.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND X.ACCT_XCH_RT_LVL =1 AND X.CURR_CD = A.CURR_CD ) USD_RT" ).append("\n"); 
		query.append("      ,A.DELT_FLG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM EAS_MNR_CR_ISS A" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_fm_dt} !='' && ${s_to_dt} !='')" ).append("\n"); 
		query.append("   AND A.CR_ISS_DT BETWEEN TO_DATE(@[s_fm_dt],'YYYYMMDD') AND TO_DATE(@[s_to_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_mkr_cd} !='')" ).append("\n"); 
		query.append("   AND A.MKR_CD = @[s_mkr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cr_usd_ofc_cd} !='')" ).append("\n"); 
		query.append("   AND A.CR_ISS_NO IN (SELECT CR_ISS_NO" ).append("\n"); 
		query.append("                         FROM EAS_MNR_CR_USD" ).append("\n"); 
		query.append("                        WHERE CR_USD_OFC_CD = @[s_cr_usd_ofc_cd]" ).append("\n"); 
		query.append("                          AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ORDER BY A.CR_ISS_NO" ).append("\n"); 

	}
}
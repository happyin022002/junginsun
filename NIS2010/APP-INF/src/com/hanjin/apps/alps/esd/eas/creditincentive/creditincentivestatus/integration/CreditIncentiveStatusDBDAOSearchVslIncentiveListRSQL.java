/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOSearchVslIncentiveListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.15 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOSearchVslIncentiveListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL Incentive List Search
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOSearchVslIncentiveListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOSearchVslIncentiveListRSQL").append("\n"); 
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
		query.append("SELECT A.BSE_YR" ).append("\n"); 
		query.append("	  ,A.INCNT_NO" ).append("\n"); 
		query.append("	  ,A.RHQ_CD" ).append("\n"); 
		query.append("	  ,A.OFC_CD" ).append("\n"); 
		query.append("	  ,A.PORT_CD" ).append("\n"); 
		query.append("	  ,A.ITM_CD" ).append("\n"); 
		query.append("	  ,A.VNDR_SEQ" ).append("\n"); 
		query.append("	  ,(SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("	  ,A.CURR_CD" ).append("\n"); 
		query.append("	  ,NVL(A.JAN_ESTM_INCNT_AMT,0) JAN_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.JAN_RCV_INCNT_AMT,0) JAN_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.FEB_ESTM_INCNT_AMT,0) FEB_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.FEB_RCV_INCNT_AMT,0) FEB_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.MAR_ESTM_INCNT_AMT,0) MAR_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.MAR_RCV_INCNT_AMT,0) MAR_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.APR_ESTM_INCNT_AMT,0) APR_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.APR_RCV_INCNT_AMT,0) APR_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.MAY_ESTM_INCNT_AMT,0) MAY_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.MAY_RCV_INCNT_AMT,0) MAY_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.JUN_ESTM_INCNT_AMT,0) JUN_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.JUN_RCV_INCNT_AMT,0) JUN_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.JUL_ESTM_INCNT_AMT,0) JUL_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.JUL_RCV_INCNT_AMT,0) JUL_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.AUG_ESTM_INCNT_AMT,0) AUG_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.AUG_RCV_INCNT_AMT,0) AUG_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.SEP_ESTM_INCNT_AMT,0) SEP_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.SEP_RCV_INCNT_AMT,0) SEP_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.OCT_ESTM_INCNT_AMT,0) OCT_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.OCT_RCV_INCNT_AMT,0) OCT_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.NOV_ESTM_INCNT_AMT,0) NOV_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.NOV_RCV_INCNT_AMT,0) NOV_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.DEC_ESTM_INCNT_AMT,0) DEC_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.DEC_RCV_INCNT_AMT,0) DEC_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.TTL_INCNT_AMT,0) TTL_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.TTL_RCV_AMT,0) TTL_RCV_AMT" ).append("\n"); 
		query.append("	  ,NVL(A.TTL_RMN_AMT,0) TTL_RMN_AMT" ).append("\n"); 
		query.append("	  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) YEAR_USD_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) YEAR_USD_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) YEAR_USD_BAL_INCNT_AMT" ).append("\n"); 
		query.append("	  ,A.INSTR_RMK" ).append("\n"); 
		query.append("	  ,A.STL_RMK" ).append("\n"); 
		query.append("	  ,A.INCNT_RMK" ).append("\n"); 
		query.append("	  ,DECODE(A.ATCH_N2ND_FILE_LNK_ID,'','N','Y') ATCH2_FLG" ).append("\n"); 
		query.append("	  ,A.ATCH_N2ND_FILE_LNK_ID" ).append("\n"); 
		query.append("	  ,DECODE(A.ATCH_FILE_LNK_ID,'','N','Y') ATCH_FLG" ).append("\n"); 
		query.append("	  ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("	  ,(SELECT X.USD_LOCL_XCH_RT FROM GL_MON_XCH_RT X WHERE X.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND X.ACCT_XCH_RT_LVL =1 AND X.CURR_CD = A.CURR_CD ) USD_RT" ).append("\n"); 
		query.append("	  ,A.DELT_FLG" ).append("\n"); 
		query.append("	  ,A.CRE_USR_ID" ).append("\n"); 
		query.append("	  ,A.CRE_DT" ).append("\n"); 
		query.append("	  ,A.UPD_USR_ID" ).append("\n"); 
		query.append("	  ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM EAS_VSL_YRY_CR A" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_rhq_cd} !='')" ).append("\n"); 
		query.append("   AND A.RHQ_CD = @[s_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_inv_ofc_cd} !='')" ).append("\n"); 
		query.append("   AND A.OFC_CD = @[s_inv_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bse_yr} !='')" ).append("\n"); 
		query.append("   AND A.BSE_YR = @[s_bse_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_inv_vndr_seq} !='')" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[s_inv_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
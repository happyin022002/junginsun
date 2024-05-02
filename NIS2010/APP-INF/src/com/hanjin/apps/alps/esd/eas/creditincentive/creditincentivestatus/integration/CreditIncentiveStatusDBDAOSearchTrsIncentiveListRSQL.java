/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOSearchTrsIncentiveListRSQL.java
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

public class CreditIncentiveStatusDBDAOSearchTrsIncentiveListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS Incentive List search
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOSearchTrsIncentiveListRSQL(){
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
		query.append("FileName : CreditIncentiveStatusDBDAOSearchTrsIncentiveListRSQL").append("\n"); 
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
		query.append("      ,A.INCNT_NO" ).append("\n"); 
		query.append("      ,A.RHQ_CD" ).append("\n"); 
		query.append("      ,A.INV_OFC_CD" ).append("\n"); 
		query.append("      ,A.INV_TRNS_MOD_CD" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,(SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("      ,A.ORG_YD_DESC" ).append("\n"); 
		query.append("      ,A.DEST_YD_DESC" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EFF_FM_DT,'YYYYMMDD') EFF_FM_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EFF_TO_DT,'YYYYMMDD') EFF_TO_DT" ).append("\n"); 
		query.append("      ,A.INV_CYC_CD" ).append("\n"); 
		query.append("      ,A.INV_ISS_DT_RMK" ).append("\n"); 
		query.append("      ,A.FULL_MTY_CD" ).append("\n"); 
		query.append("      ,A.LGS_COST_CD" ).append("\n"); 
		query.append("      ,A.INCNT_UT_CD" ).append("\n"); 
		query.append("      ,A.JAN_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.FEB_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.MAR_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.APR_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.MAY_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.JUN_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.JUL_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.AUG_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.SEP_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.OCT_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.NOV_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.DEC_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.TTL_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.ESTM_CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,NVL(A.CNTR_UT_INCNT_AMT,0) CNTR_UT_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.JAN_INCNT_AMT,0) JAN_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.FEB_INCNT_AMT,0) FEB_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.MAR_INCNT_AMT,0) MAR_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.APR_INCNT_AMT,0) APR_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.MAY_INCNT_AMT,0) MAY_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.JUN_INCNT_AMT,0) JUN_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.JUL_INCNT_AMT,0) JUL_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.AUG_INCNT_AMT,0) AUG_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.SEP_INCNT_AMT,0) SEP_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.OCT_INCNT_AMT,0) OCT_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.NOV_INCNT_AMT,0) NOV_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.DEC_INCNT_AMT,0) DEC_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.TTL_INCNT_AMT,0) TTL_INCNT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.TTL_RCV_AMT,0) TTL_RCV_AMT" ).append("\n"); 
		query.append("      ,NVL(A.TTL_RMN_AMT,0) TTL_RMN_AMT" ).append("\n"); 
		query.append("      ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,A.TTL_INCNT_AMT) TTL_INCNT_USD_AMT" ).append("\n"); 
		query.append("      ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,A.TTL_RCV_AMT)   TTL_RCV_USD_AMT" ).append("\n"); 
		query.append("      ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,A.TTL_RMN_AMT)   TTL_RMN_USD_AMT" ).append("\n"); 
		query.append("      ,A.RCT_DT_RMK" ).append("\n"); 
		query.append("      ,A.INCNT_DESC" ).append("\n"); 
		query.append("      ,A.INCNT_RMK" ).append("\n"); 
		query.append(" 	  ,DECODE(A.ATCH_N2ND_FILE_LNK_ID,'','N','Y') ATCH2_FLG" ).append("\n"); 
		query.append("	  ,A.ATCH_N2ND_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,DECODE(A.ATCH_FILE_LNK_ID,'','N','Y') ATCH_FLG" ).append("\n"); 
		query.append("      ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,(SELECT X.USD_LOCL_XCH_RT FROM GL_MON_XCH_RT X WHERE X.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND X.ACCT_XCH_RT_LVL =1 AND X.CURR_CD = A.CURR_CD ) USD_RT" ).append("\n"); 
		query.append("      ,A.DELT_FLG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM EAS_TRSP_INCNT A" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_rhq_cd} !='')" ).append("\n"); 
		query.append("   AND A.RHQ_CD = @[s_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_inv_ofc_cd} !='')" ).append("\n"); 
		query.append("   AND A.INV_OFC_CD = @[s_inv_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bse_yr} !='')" ).append("\n"); 
		query.append("   AND A.BSE_YR = @[s_bse_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_inv_vndr_seq} !='')" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[s_inv_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.BSE_YR" ).append("\n"); 
		query.append("         ,A.INCNT_NO" ).append("\n"); 

	}
}
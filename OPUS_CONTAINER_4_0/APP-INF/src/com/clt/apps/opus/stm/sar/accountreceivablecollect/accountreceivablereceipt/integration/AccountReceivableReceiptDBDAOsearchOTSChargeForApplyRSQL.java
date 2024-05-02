/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchOTSChargeForApplyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOsearchOTSChargeForApplyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Apply 대상 OTS Charge 정보 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchOTSChargeForApplyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOsearchOTSChargeForApplyRSQL").append("\n"); 
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
		query.append("SELECT T.INV_OFC_CD OTS_OFC_CD " ).append("\n"); 
		query.append("       , P.BL_NO" ).append("\n"); 
		query.append("       , P.INV_NO" ).append("\n"); 
		query.append("       , P.CHG_TP_CD RCT_APLY_CHG_CD" ).append("\n"); 
		query.append("       , P.BL_CURR_CD RCT_APLY_SRC_CURR_CD" ).append("\n"); 
		query.append("	   , SAR_GET_FMT_MASK_FNC(P.BL_CURR_CD, NVL(SUM(P.BAL_AMT), 0)) OTS_BAL_AMT" ).append("\n"); 
		query.append("	   , SAR_GET_FMT_MASK_FNC(P.BL_CURR_CD, NVL(SUM(P.BAL_AMT), 0)) OTS_APLY_AMT" ).append("\n"); 
		query.append("       , DECODE(@[rct_curr_cd], R.OFC_CURR_CD, Q.LOCL_XCH_RT, 'USD', Q.USD_XCH_RT, DECODE(@[rct_curr_cd], P.BL_CURR_CD, 1, 0)) OTS_XCH_RT" ).append("\n"); 
		query.append("	   , DECODE(@[rct_curr_cd], R.OFC_CURR_CD, Q.LOCL_XCH_RT, 'USD', Q.USD_XCH_RT, DECODE(@[rct_curr_cd], P.BL_CURR_CD, 1, 0)) RCT_APLY_XCH_RT" ).append("\n"); 
		query.append("	   , @[rct_curr_cd] RCT_CURR_CD" ).append("\n"); 
		query.append("	   , SAR_GET_FMT_MASK_FNC(@[rct_curr_cd], ROUND(NVL(SUM(P.BAL_AMT), 0) * NVL(DECODE(@[rct_curr_cd], R.OFC_CURR_CD, Q.LOCL_XCH_RT, 'USD', Q.USD_XCH_RT, DECODE(@[rct_curr_cd], P.BL_CURR_CD, 1, 0)), 0), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[rct_curr_cd]))) RCT_APLY_AMT" ).append("\n"); 
		query.append("	   , SUM(ROUND(NVL(SUM(P.BAL_AMT), 0) * NVL(DECODE(@[rct_curr_cd], R.OFC_CURR_CD, Q.LOCL_XCH_RT, 'USD', Q.USD_XCH_RT, DECODE(@[rct_curr_cd], P.BL_CURR_CD, 1, 0)), 0), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[rct_curr_cd]))) OVER() TTL_APLY_AMT" ).append("\n"); 
		query.append("	   , S.DP_PRCS_KNT" ).append("\n"); 
		query.append("	   , T.INV_OFC_CD||P.BL_NO||P.INV_NO RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("	   , 'N' RCT_APLY_FLG" ).append("\n"); 
		query.append("FROM SAR_OTS_CHG P," ).append("\n"); 
		query.append("     SAR_OTS_DTL Q," ).append("\n"); 
		query.append("     SAR_OTS_HDR R," ).append("\n"); 
		query.append("     SAR_OTS_HIS T," ).append("\n"); 
		query.append("     MDM_CURRENCY S" ).append("\n"); 
		query.append("WHERE P.RHQ_CD = Q.RHQ_CD" ).append("\n"); 
		query.append("AND P.OTS_OFC_CD = Q.OTS_OFC_CD" ).append("\n"); 
		query.append("AND P.BL_NO = Q.BL_NO" ).append("\n"); 
		query.append("AND P.INV_NO = Q.INV_NO" ).append("\n"); 
		query.append("AND P.BL_CURR_CD = Q.BL_CURR_CD" ).append("\n"); 
		query.append("AND P.CHG_TP_CD = Q.CHG_TP_CD" ).append("\n"); 
		query.append("AND R.RHQ_CD = T.RHQ_CD" ).append("\n"); 
		query.append("AND R.OTS_OFC_CD = T.OTS_OFC_CD" ).append("\n"); 
		query.append("AND R.BL_NO = T.BL_NO" ).append("\n"); 
		query.append("AND R.INV_NO = T.INV_NO  " ).append("\n"); 
		query.append("AND P.OTS_HIS_SEQ = T.OTS_HIS_SEQ" ).append("\n"); 
		query.append("AND P.BL_CURR_CD = S.CURR_CD" ).append("\n"); 
		query.append("AND R.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("#if(${ots_cd} == 'COU')" ).append("\n"); 
		query.append("    AND R.OTS_OFC_CD = @[rep_ots_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND R.OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_no} != '')" ).append("\n"); 
		query.append("    AND R.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("    #if(${inv_no} != '')" ).append("\n"); 
		query.append("        AND R.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND R.INV_NO <> '**********'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if(${inv_no} != '')" ).append("\n"); 
		query.append("        AND R.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND R.INV_NO = '**********'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ots_srch_flg} == 'Y')" ).append("\n"); 
		query.append("    AND T.INV_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${chg_tp_cd} != '')" ).append("\n"); 
		query.append("    AND P.CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_curr_cd} != '')" ).append("\n"); 
		query.append("    AND P.BL_CURR_CD = @[bl_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${local_chg_flag} == 'Y')" ).append("\n"); 
		query.append("        #if (${invoice_type} == 'NFRT')" ).append("\n"); 
		query.append("			#if (${bound_type} == 'L')" ).append("\n"); 
		query.append("            AND T.REV_TP_SRC_CD IN ('MIV','MIC','MOS')" ).append("\n"); 
		query.append("			AND (P.CHG_TP_CD IN (SELECT D.LU_CD" ).append("\n"); 
		query.append("                                 FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                                 WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                                 AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                                 AND    D.LU_TP_CD = 'TH LOCAL CHARGE'" ).append("\n"); 
		query.append("                                 AND    D.ENBL_FLG = 'Y') OR P.TJ_SRC_NM  = 'VAT')" ).append("\n"); 
		query.append("			#else           " ).append("\n"); 
		query.append("			AND T.REV_TP_SRC_CD LIKE 'M%' " ).append("\n"); 
		query.append("            AND T.REV_TP_SRC_CD NOT IN ('MDM','MDT')" ).append("\n"); 
		query.append("			AND (P.CHG_TP_CD NOT IN (SELECT D.LU_CD" ).append("\n"); 
		query.append("                                     FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                                     WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                                     AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                                     AND    D.LU_TP_CD = 'TH LOCAL CHARGE'" ).append("\n"); 
		query.append("                                     AND    D.ENBL_FLG = 'Y'))  " ).append("\n"); 
		query.append("            AND P.TJ_SRC_NM  != 'VAT'" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("        AND R.BKG_IO_BND_CD = @[bound_type]   " ).append("\n"); 
		query.append("        AND ( T.REV_TP_SRC_CD IN ('MDM','MDT','MOS') OR T.REV_TP_SRC_CD LIKE 'B%' OR T.REV_TP_SRC_CD LIKE 'C%' )  " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND T.OTS_HIS_TP_CD = 'OTS'" ).append("\n"); 
		query.append("AND R.STL_FLG = 'N'" ).append("\n"); 
		query.append("GROUP BY T.INV_OFC_CD" ).append("\n"); 
		query.append("       	 , P.BL_NO" ).append("\n"); 
		query.append("         , P.INV_NO" ).append("\n"); 
		query.append("         , P.CHG_TP_CD" ).append("\n"); 
		query.append("         , P.BL_CURR_CD" ).append("\n"); 
		query.append("		 , S.DP_PRCS_KNT" ).append("\n"); 
		query.append("         , Q.USD_XCH_RT" ).append("\n"); 
		query.append("         , Q.LOCL_XCH_RT" ).append("\n"); 
		query.append("		 , R.OFC_CURR_CD" ).append("\n"); 
		query.append("HAVING NVL(SUM(P.BAL_AMT), 0) != 0" ).append("\n"); 
		query.append("ORDER BY P.CHG_TP_CD" ).append("\n"); 
		query.append("       	 , P.BL_CURR_CD" ).append("\n"); 

	}
}
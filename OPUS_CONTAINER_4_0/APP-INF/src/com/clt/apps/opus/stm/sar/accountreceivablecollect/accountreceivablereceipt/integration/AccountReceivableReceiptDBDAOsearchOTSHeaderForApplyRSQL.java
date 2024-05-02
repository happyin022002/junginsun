/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchOTSHeaderForApplyRSQL.java
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

public class AccountReceivableReceiptDBDAOsearchOTSHeaderForApplyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Apply 대상 OTS header 정보 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchOTSHeaderForApplyRSQL(){
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
		params.put("bound_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOsearchOTSHeaderForApplyRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.RHQ_CD " ).append("\n"); 
		query.append("	   , A.OTS_OFC_CD OFC_CD" ).append("\n"); 
		query.append("	   , A.BL_NO" ).append("\n"); 
		query.append("       , A.BKG_NO" ).append("\n"); 
		query.append("       , A.INV_NO" ).append("\n"); 
		query.append("       , B.INV_OFC_CD OTS_OFC_CD" ).append("\n"); 
		query.append("       , A.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("       , A.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("       , A.BIL_TO_CUST_CNT_CD||'-'||LPAD(A.BIL_TO_CUST_SEQ, 6, '0') BIL_TO_CUST_CD" ).append("\n"); 
		query.append("       , A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD LOCL_VVD_CD" ).append("\n"); 
		query.append("       , A.TRNK_VVD_CD" ).append("\n"); 
		query.append("       , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("       , DECODE(A.BKG_IO_BND_CD, 'O', 'O/B', 'I/B') IO_BND_CD" ).append("\n"); 
		query.append("       , A.DUE_DT" ).append("\n"); 
		query.append("       , A.CUST_SREP_CD SREP_CD" ).append("\n"); 
		query.append("       , A.OTS_RMK" ).append("\n"); 
		query.append("	   , (SELECT INTG_CD_VAL_DP_DESC              " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE INTG_CD_ID = 'CD02060'" ).append("\n"); 
		query.append("          AND INTG_CD_VAL_CTNT = A.XCH_RT_TP_CD) XCH_RT_TP_NM" ).append("\n"); 
		query.append("	   , A.XCH_RT_TP_CD" ).append("\n"); 
		query.append("       , A.XCH_RT_DT" ).append("\n"); 
		query.append("       , A.CR_MK_FLG CR_FLG" ).append("\n"); 
		query.append("       , A.OTS_SRC_CD AR_FINC_SRC_CD" ).append("\n"); 
		query.append("	   , A.MAX_AR_IF_NO" ).append("\n"); 
		query.append("	   , B.INV_OFC_CD||A.BL_NO||A.INV_NO RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("	   , 'N' RCT_APLY_FLG" ).append("\n"); 
		query.append("	   , A.INV_DT" ).append("\n"); 
		query.append("FROM SAR_OTS_HDR A," ).append("\n"); 
		query.append("     SAR_OTS_HIS B" ).append("\n"); 
		query.append("WHERE A.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("AND A.OTS_OFC_CD = B.OTS_OFC_CD" ).append("\n"); 
		query.append("AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("AND A.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("#if(${ots_cd} == 'COU')" ).append("\n"); 
		query.append("    AND A.OTS_OFC_CD = @[rep_ots_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND A.OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_no} != '')" ).append("\n"); 
		query.append("    AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("    #if(${inv_no} != '')" ).append("\n"); 
		query.append("        AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND A.INV_NO <> '**********'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if(${inv_no} != '')" ).append("\n"); 
		query.append("        AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND A.INV_NO = '**********'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ots_srch_flg} == 'Y')" ).append("\n"); 
		query.append("	AND B.INV_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.OTS_HIS_TP_CD = 'OTS'" ).append("\n"); 
		query.append("AND A.STL_FLG = 'N'" ).append("\n"); 
		query.append("#if (${local_chg_flag} == 'Y')" ).append("\n"); 
		query.append("        #if (${invoice_type} == 'NFRT')" ).append("\n"); 
		query.append("			#if (${bound_type} == 'L')" ).append("\n"); 
		query.append("            AND B.REV_TP_SRC_CD IN ('MIV','MIC','MOS')             " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("            AND ( B.REV_TP_SRC_CD LIKE 'M%' AND B.REV_TP_SRC_CD NOT IN ('MDM','MDT') )" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("        AND A.BKG_IO_BND_CD = @[bound_type]  " ).append("\n"); 
		query.append("        AND ( B.REV_TP_SRC_CD IN ('MDM','MDT','MOS') OR B.REV_TP_SRC_CD LIKE 'B%' OR B.REV_TP_SRC_CD LIKE 'C%' )  " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("       		FROM SAR_OTS_HIS P," ).append("\n"); 
		query.append("            	 SAR_OTS_CHG Q" ).append("\n"); 
		query.append("       		WHERE P.OTS_HIS_SEQ = Q.OTS_HIS_SEQ" ).append("\n"); 
		query.append("       		AND P.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("       		AND P.INV_OFC_CD = B.INV_OFC_CD" ).append("\n"); 
		query.append("       		AND P.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("       		AND P.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("            #if (${local_chg_flag} == 'Y')" ).append("\n"); 
		query.append("				#if (${invoice_type} == 'NFRT')" ).append("\n"); 
		query.append("					#if (${bound_type} == 'L') " ).append("\n"); 
		query.append("                    AND P.REV_TP_SRC_CD IN ('MIV','MIC','MOS')    " ).append("\n"); 
		query.append("                    AND (Q.CHG_TP_CD IN ( SELECT D.LU_CD" ).append("\n"); 
		query.append("                                          FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                                          WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                                          AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                                          AND    D.LU_TP_CD = 'TH LOCAL CHARGE'" ).append("\n"); 
		query.append("                                          AND    D.ENBL_FLG = 'Y') OR Q.TJ_SRC_NM  = 'VAT')" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("                    AND ( P.REV_TP_SRC_CD LIKE 'M%' AND P.REV_TP_SRC_CD NOT IN ('MDM','MDT') )" ).append("\n"); 
		query.append("                    AND (Q.CHG_TP_CD NOT IN (SELECT D.LU_CD" ).append("\n"); 
		query.append("                                             FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                                             WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                                             AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                                             AND    D.LU_TP_CD = 'TH LOCAL CHARGE'" ).append("\n"); 
		query.append("                                             AND    D.ENBL_FLG = 'Y'))" ).append("\n"); 
		query.append("					AND Q.TJ_SRC_NM  != 'VAT'" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("                AND ( P.REV_TP_SRC_CD IN ('MDM','MDT','MOS') OR P.REV_TP_SRC_CD LIKE 'B%' OR P.REV_TP_SRC_CD LIKE 'C%' ) " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("       		GROUP BY P.RHQ_CD" ).append("\n"); 
		query.append("         			, P.INV_OFC_CD" ).append("\n"); 
		query.append("       	 			, P.BL_NO" ).append("\n"); 
		query.append("         			, P.INV_NO" ).append("\n"); 
		query.append("         			, Q.CHG_TP_CD" ).append("\n"); 
		query.append("         			, Q.BL_CURR_CD" ).append("\n"); 
		query.append("       		HAVING SUM(Q.BAL_AMT) != 0)" ).append("\n"); 
		query.append("ORDER BY B.INV_OFC_CD" ).append("\n"); 

	}
}
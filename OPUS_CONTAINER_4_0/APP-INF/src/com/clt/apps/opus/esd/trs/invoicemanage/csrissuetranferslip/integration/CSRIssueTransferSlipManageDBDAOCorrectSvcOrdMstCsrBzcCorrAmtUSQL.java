/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrBzcCorrAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrBzcCorrAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BASIC     AMOUNT CORRECTION
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrBzcCorrAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrBzcCorrAmtUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("   SET S.CSR_BZC_CORR_AMT " ).append("\n"); 
		query.append("         = NVL(" ).append("\n"); 
		query.append("               CASE" ).append("\n"); 
		query.append("                 WHEN NVL(S.DELT_FLG, 'N') = 'Y' THEN NULL" ).append("\n"); 
		query.append("                 WHEN NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = S.INV_CURR_CD AND NVL(DELT_FLG, 'N') = 'N'), 0) = 0 THEN" ).append("\n"); 
		query.append("                 CASE S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append("                   WHEN 'TM' THEN  ( ROUND( ( NVL(S.BZC_AMT, 0)+NVL(S.NEGO_AMT, 0)+NVL(TRS_COMMON_PKG.GET_SCG_DTL_SUM_AMT_FNC(S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ), 0) ) * NVL(S.INV_XCH_RT, 1), 0) ) " ).append("\n"); 
		query.append("                   ELSE  ( ROUND( ( NVL(S.BZC_AMT, 0)+NVL(S.NEGO_AMT, 0)+NVL(TRS_COMMON_PKG.GET_SCG_DTL_SUM_AMT_FNC(S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ), 0) ) / NVL(S.INV_XCH_RT, 1), 0) ) " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                 CASE S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append("                   WHEN 'TM' THEN  ( ROUND( ( NVL(S.BZC_AMT, 0)+NVL(S.NEGO_AMT, 0)+NVL(TRS_COMMON_PKG.GET_SCG_DTL_SUM_AMT_FNC(S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ), 0) ) * NVL(S.INV_XCH_RT, 1), 2) ) " ).append("\n"); 
		query.append("                   ELSE  ( ROUND( ( NVL(S.BZC_AMT, 0)+NVL(S.NEGO_AMT, 0)+NVL(TRS_COMMON_PKG.GET_SCG_DTL_SUM_AMT_FNC(S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ), 0) ) / NVL(S.INV_XCH_RT, 1), 2) ) " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("               END /* EACH_EXG_CAL_SUM_BZC_AMT */" ).append("\n"); 
		query.append("            - (CASE " ).append("\n"); 
		query.append("                 WHEN NVL(S.DELT_FLG, 'N') = 'Y' THEN NULL" ).append("\n"); 
		query.append("                 WHEN NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = S.INV_CURR_CD AND NVL(DELT_FLG, 'N') = 'N'), 0) = 0  THEN" ).append("\n"); 
		query.append("                 CASE S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append("                   WHEN 'TM' THEN  ROUND( (NVL(S.BZC_AMT, 0) + NVL(S.NEGO_AMT, 0)) * NVL(S.INV_XCH_RT, 1), 0) " ).append("\n"); 
		query.append("                                 + ROUND((SELECT SUM(ROUND( NVL(D.SCG_AMT, 0)*NVL(S.INV_XCH_RT, 1), 0))" ).append("\n"); 
		query.append("                                          FROM   TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append("                                          WHERE S.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                          AND   S.TRSP_SO_SEQ = D.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                                        , 0) " ).append("\n"); 
		query.append("                                 + NVL(S.CSR_SCG_CORR_AMT, 0) " ).append("\n"); 
		query.append("                   ELSE ROUND( (NVL(S.BZC_AMT, 0) + NVL(S.NEGO_AMT, 0)) / NVL(S.INV_XCH_RT, 1), 0) " ).append("\n"); 
		query.append("                      + ROUND((SELECT ROUND( NVL(D.SCG_AMT, 0)/NVL(S.INV_XCH_RT, 1), 0)" ).append("\n"); 
		query.append("                               FROM   TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append("                               WHERE S.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                               AND   S.TRSP_SO_SEQ = D.TRSP_SO_SEQ), 0) " ).append("\n"); 
		query.append("                      + NVL(S.CSR_SCG_CORR_AMT, 0) " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                 CASE S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append("                   WHEN 'TM' THEN  ROUND( (NVL(S.BZC_AMT, 0) + NVL(S.NEGO_AMT, 0)) * NVL(S.INV_XCH_RT, 1), 2) " ).append("\n"); 
		query.append("                                 + ROUND((SELECT SUM(ROUND( NVL(D.SCG_AMT, 0)*NVL(S.INV_XCH_RT, 1), 2))" ).append("\n"); 
		query.append("                                          FROM   TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append("                                          WHERE S.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                          AND   S.TRSP_SO_SEQ = D.TRSP_SO_SEQ), 2) " ).append("\n"); 
		query.append("                                 + NVL(S.CSR_SCG_CORR_AMT, 0) " ).append("\n"); 
		query.append("                   ELSE ROUND( (NVL(S.BZC_AMT, 0) + NVL(S.NEGO_AMT, 0)) / NVL(S.INV_XCH_RT, 1), 2) " ).append("\n"); 
		query.append("                      + ROUND((SELECT SUM(ROUND( NVL(D.SCG_AMT, 0)/NVL(S.INV_XCH_RT, 1), 2))" ).append("\n"); 
		query.append("                                FROM   TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append("                                WHERE S.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                AND   S.TRSP_SO_SEQ = D.TRSP_SO_SEQ), 2) " ).append("\n"); 
		query.append("                      + NVL(S.CSR_SCG_CORR_AMT, 0) " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("               END) /* EACH_SO_SUM_EXG_CAL_BZC_AMT */" ).append("\n"); 
		query.append("             , 0)" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0) " ).append("\n"); 
		query.append("	AND	S.INV_NO IN	(" ).append("\n"); 
		query.append("		#foreach( ${key} in ${INV_NO}) " ).append("\n"); 
		query.append("			#if($velocityCount < $INV_NO.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND S.INV_VNDR_SEQ = @[INV_VNDR_SEQ]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOsearchARInvoiceChargeByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOsearchARInvoiceChargeByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchARInvoiceChargeByBL
	  * AR Office Code와 BL Source No나 BKG No로 해당되는 Charge Data를 조회
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOsearchARInvoiceChargeByBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOsearchARInvoiceChargeByBLRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD, CURR_CD, TRF_RT_AMT, RAT_AS_CNTR_QTY, PER_TP_CD, INV_XCH_RT, " ).append("\n"); 
		query.append("       -- DECODE(AR_OFC_CD||IO_BND_CD||INV_REV_TP_SRC_CD||CHG_CD, 'BOMSCIMIVCHC', CHG_FULL_NM||' TO CFS', CHG_FULL_NM) " ).append("\n"); 
		query.append("	   CHG_FULL_NM, " ).append("\n"); 
		query.append("       TVA_FLG, " ).append("\n"); 
		query.append("       CHG_AMT, DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT A.CHG_CD CHG_CD" ).append("\n"); 
		query.append("        	 , A.CURR_CD CURR_CD" ).append("\n"); 
		query.append("        	 , A.TRF_RT_AMT TRF_RT_AMT" ).append("\n"); 
		query.append("        	 , A.RAT_AS_CNTR_QTY RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("        	 , A.PER_TP_CD PER_TP_CD" ).append("\n"); 
		query.append("        	 , A.INV_XCH_RT INV_XCH_RT" ).append("\n"); 
		query.append("       		 , A.CHG_FULL_NM" ).append("\n"); 
		query.append("         	 -- , B.AR_OFC_CD" ).append("\n"); 
		query.append("        	 -- , B.IO_BND_CD" ).append("\n"); 
		query.append("        	 -- , A.INV_REV_TP_SRC_CD" ).append("\n"); 
		query.append("        	 , MAX(A.TVA_FLG) OVER (PARTITION BY A.CHG_CD) AS TVA_FLG" ).append("\n"); 
		query.append("        	 , SUM(A.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("        	 , E.DP_PRCS_KNT DP_PRCS_KNT" ).append("\n"); 
		query.append("        FROM INV_AR_CHG A,INV_AR_MN B,MDM_CURRENCY E" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("		#if (${bl_src_no} != '') 	" ).append("\n"); 
		query.append("			AND B.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${bkg_no} != '') " ).append("\n"); 
		query.append("			AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND B.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("    	AND B.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("	    AND B.BL_INV_CFM_DT IS NOT NULL " ).append("\n"); 
		query.append("    	AND A.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("		-- 2018.05.16 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append("		#if (${ar_ofc_cd} == 'BOMSC') " ).append("\n"); 
		query.append("            AND (((EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                           FROM INV_AR_MN" ).append("\n"); 
		query.append("                           WHERE AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("                           AND BL_SRC_NO = B.BL_SRC_NO" ).append("\n"); 
		query.append("                           AND NVL(IDA_ISS_TP_CD, 'P') IN ('T','C','D')) " ).append("\n"); 
		query.append("                   OR EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        	  FROM INV_AR_MN" ).append("\n"); 
		query.append("                        	  WHERE AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("                        	  AND BL_SRC_NO = B.BL_SRC_NO" ).append("\n"); 
		query.append("                        	  AND NVL(IDA_INV_SPLIT_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("                   AND B.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("                   AND NVL(B.IDA_INV_SPLIT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("            	OR (NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        		FROM INV_AR_MN" ).append("\n"); 
		query.append("                        		WHERE AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("                        		AND BL_SRC_NO = B.BL_SRC_NO" ).append("\n"); 
		query.append("                        		AND NVL(IDA_ISS_TP_CD, 'P') IN ('T','C','D'))" ).append("\n"); 
		query.append("                	AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        			FROM INV_AR_MN" ).append("\n"); 
		query.append("                        			WHERE AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("                        			AND BL_SRC_NO = B.BL_SRC_NO" ).append("\n"); 
		query.append("                        			AND NVL(B.IDA_INV_SPLIT_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("                	AND B.INV_CLR_FLG = 'N'))" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    	GROUP BY A.CHG_CD,A.CURR_CD, A.TRF_RT_AMT, A.RAT_AS_CNTR_QTY, A.PER_TP_CD, A.INV_XCH_RT, A.CHG_FULL_NM, " ).append("\n"); 
		query.append("             	 -- B.AR_OFC_CD, B.IO_BND_CD, A.INV_REV_TP_SRC_CD, " ).append("\n"); 
		query.append("				 A.TVA_FLG, E.DP_PRCS_KNT" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("WHERE CHG_AMT <> 0" ).append("\n"); 
		query.append("ORDER BY CURR_CD, CHG_CD" ).append("\n"); 

	}
}
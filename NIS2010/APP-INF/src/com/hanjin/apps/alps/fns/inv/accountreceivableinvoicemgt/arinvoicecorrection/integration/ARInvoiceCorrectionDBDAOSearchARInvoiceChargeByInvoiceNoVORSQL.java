/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByInvoiceNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.15 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByInvoiceNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByInvoiceNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByInvoiceNoVORSQL").append("\n"); 
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
		query.append("SELECT A.CHG_CD " ).append("\n"); 
		query.append("      , A.CURR_CD " ).append("\n"); 
		query.append("      , A.PER_TP_CD " ).append("\n"); 
		query.append("      , A.TRF_RT_AMT " ).append("\n"); 
		query.append("      , A.RAT_AS_CNTR_QTY RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("      , A.INV_XCH_RT " ).append("\n"); 
		query.append("      , SUM(CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("      , B.TJ_SRC_NM" ).append("\n"); 
		query.append("      , A.INV_XCH_RT_DT" ).append("\n"); 
		query.append("      ,	A.REP_CHG_CD" ).append("\n"); 
		query.append("      ,	A.CHG_FULL_NM" ).append("\n"); 
		query.append("      ,	A.TRF_NO" ).append("\n"); 
		query.append("      ,	A.SOB_ID" ).append("\n"); 
		query.append("      --,	A.INV_REV_TP_SRC_CD" ).append("\n"); 
		query.append("      ,	A.REV_COA_CO_CD" ).append("\n"); 
		query.append("      ,	A.REV_COA_RGN_CD" ).append("\n"); 
		query.append("      ,	A.REV_COA_CTR_CD" ).append("\n"); 
		query.append("      ,	A.REV_COA_ACCT_CD" ).append("\n"); 
		query.append("      ,	A.REV_COA_INTER_CO_CD" ).append("\n"); 
		query.append("      ,	A.REV_COA_VSL_CD" ).append("\n"); 
		query.append("      ,	A.REV_COA_VOY_NO" ).append("\n"); 
		query.append("      ,	A.REV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,	A.REV_COA_DIR_CD" ).append("\n"); 
		query.append("      ,	A.ACCT_CD" ).append("\n"); 
		query.append("      ,	A.TVA_FLG" ).append("\n"); 
		query.append("      ,	A.CHG_RMK" ).append("\n"); 
		query.append("      ,	A.MNL_FLG" ).append("\n"); 
		query.append("      , C.DP_PRCS_KNT" ).append("\n"); 
		query.append("  FROM INV_AR_CHG A, " ).append("\n"); 
		query.append("       INV_AR_AMT B," ).append("\n"); 
		query.append("	   MDM_CURRENCY C" ).append("\n"); 
		query.append(" WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("   AND A.AR_IF_SER_NO = B.AR_IF_SER_NO" ).append("\n"); 
		query.append("   AND A.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("   AND A.AR_IF_NO IN (SELECT DISTINCT MN.AR_IF_NO AR_IF_NO" ).append("\n"); 
		query.append("                      FROM INV_AR_MN MN," ).append("\n"); 
		query.append("                           INV_AR_CHG CHG," ).append("\n"); 
		query.append("                           INV_AR_ISS_DTL DTL" ).append("\n"); 
		query.append("                     WHERE MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("                       AND CHG.AR_IF_NO = DTL.AR_IF_NO" ).append("\n"); 
		query.append("                       AND CHG.CHG_SEQ = DTL.CHG_SEQ" ).append("\n"); 
		query.append("                       AND DTL.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                       AND MN.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                       --AND MN.REV_TP_CD <> 'M' 2009-12-02 김현화 수석" ).append("\n"); 
		query.append("                       AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                       --AND NVL(MN.INV_SPLIT_CD,'N') NOT IN ('M','X') 2010-01-18 이상희 과장" ).append("\n"); 
		query.append("						)   " ).append("\n"); 
		query.append(" GROUP BY A.CHG_CD,A.CURR_CD,A.PER_TP_CD,A.TRF_RT_AMT, A.RAT_AS_CNTR_QTY ,A.INV_XCH_RT, B.TJ_SRC_NM" ).append("\n"); 
		query.append("          , A.INV_XCH_RT_DT" ).append("\n"); 
		query.append("          ,	A.REP_CHG_CD" ).append("\n"); 
		query.append("          ,	A.CHG_FULL_NM" ).append("\n"); 
		query.append("          ,	A.TRF_NO" ).append("\n"); 
		query.append("          ,	A.SOB_ID" ).append("\n"); 
		query.append("          --,	A.INV_REV_TP_SRC_CD" ).append("\n"); 
		query.append("          ,	A.REV_COA_CO_CD" ).append("\n"); 
		query.append("          ,	A.REV_COA_RGN_CD" ).append("\n"); 
		query.append("          ,	A.REV_COA_CTR_CD" ).append("\n"); 
		query.append("          ,	A.REV_COA_ACCT_CD" ).append("\n"); 
		query.append("          ,	A.REV_COA_INTER_CO_CD" ).append("\n"); 
		query.append("          ,	A.REV_COA_VSL_CD" ).append("\n"); 
		query.append("          ,	A.REV_COA_VOY_NO" ).append("\n"); 
		query.append("          ,	A.REV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append("          ,	A.REV_COA_DIR_CD" ).append("\n"); 
		query.append("          ,	A.ACCT_CD" ).append("\n"); 
		query.append("          ,	A.TVA_FLG" ).append("\n"); 
		query.append("          ,	A.CHG_RMK" ).append("\n"); 
		query.append("          ,	A.MNL_FLG" ).append("\n"); 
		query.append("          , C.DP_PRCS_KNT" ).append("\n"); 
		query.append(" HAVING SUM(CHG_AMT) <> 0" ).append("\n"); 
		query.append(" ORDER BY A.CURR_CD" ).append("\n"); 

	}
}
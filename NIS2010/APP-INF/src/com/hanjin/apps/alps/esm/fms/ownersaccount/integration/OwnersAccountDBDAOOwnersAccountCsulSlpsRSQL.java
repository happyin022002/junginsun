/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOOwnersAccountCsulSlpsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOOwnersAccountCsulSlpsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OwnersAccountDBDAOOwnersAccountCsulSlpsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOOwnersAccountCsulSlpsRSQL").append("\n"); 
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
		query.append("SELECT FCS.SLP_TP_CD" ).append("\n"); 
		query.append(",	FCS.SLP_FUNC_CD" ).append("\n"); 
		query.append(",	FCS.SLP_OFC_CD" ).append("\n"); 
		query.append(",	FCS.SLP_ISS_DT" ).append("\n"); 
		query.append(",	FCS.SLP_SER_NO" ).append("\n"); 
		query.append(",	FCS.SLP_SEQ_NO" ).append("\n"); 
		query.append(",	FCS.ACCT_CD" ).append("\n"); 
		query.append(",	FCS.CTR_CD" ).append("\n"); 
		query.append(",	FCS.SLP_LOC_CD" ).append("\n"); 
		query.append(",	FCS.CSR_CURR_CD" ).append("\n"); 
		query.append(",	FCS.CSR_AMT" ).append("\n"); 
		query.append(",	FCS.CSR_DESC" ).append("\n"); 
		query.append(",	FCS.VNDR_SEQ" ).append("\n"); 
		query.append(",	FCS.TRNS_CURR_CD" ).append("\n"); 
		query.append(",	FCS.TRNS_AMT" ).append("\n"); 
		query.append(",	FCS.VAT_FLG" ).append("\n"); 
		query.append(",	FCS.STL_FLG" ).append("\n"); 
		query.append(",	FCS.INV_SEQ" ).append("\n"); 
		query.append(",	FCS.FLET_SRC_TP_CD" ).append("\n"); 
		query.append(",	FCS.VSL_CD" ).append("\n"); 
		query.append(",	FCS.SKD_VOY_NO" ).append("\n"); 
		query.append(",	FCS.SKD_DIR_CD" ).append("\n"); 
		query.append(",	FCS.REV_DIR_CD" ).append("\n"); 
		query.append(",	FCS.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	FCS.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append(",	FCS.ORG_ISS_DT" ).append("\n"); 
		query.append(",	FCS.ORG_SLP_SER_NO" ).append("\n"); 
		query.append(",	FCS.ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append(",   (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = FCS.VNDR_SEQ) VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",	FCS.VSL_CD||FCS.SKD_VOY_NO||FCS.SKD_DIR_CD||FCS.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",	FCS.TO_INV_NO" ).append("\n"); 
		query.append(",	FCS.CRE_USR_ID" ).append("\n"); 
		query.append(",	FCS.CRE_DT" ).append("\n"); 
		query.append(",	FCS.UPD_USR_ID" ).append("\n"); 
		query.append(",	FCS.UPD_DT" ).append("\n"); 
		query.append(",	FCS.ACCT_ITM_SEQ" ).append("\n"); 
		query.append(",   (SELECT MI.ACCT_ITM_NM" ).append("\n"); 
		query.append("       FROM FMS_ACCT_CATE MC, FMS_ACCT_ITM MI" ).append("\n"); 
		query.append("      WHERE MC.FLET_ACCT_CATE_CD = 'OW'" ).append("\n"); 
		query.append("        AND MC.ACCT_CD = MI.ACCT_CD" ).append("\n"); 
		query.append("        AND MC.ACCT_ITM_SEQ = MI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("        AND MC.ACCT_ITM_SEQ = FCS.ACCT_ITM_SEQ) ACCT_ITM_NM" ).append("\n"); 
		query.append(",	FCS.OA_LOC_CD" ).append("\n"); 
		query.append(",	FCS.OA_INV_DT" ).append("\n"); 
		query.append(",	FCS.ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append(",	FCS.PAIR_SLP_TP_CD" ).append("\n"); 
		query.append(",	FCS.PAIR_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	FCS.PAIR_SLP_OFC_CD" ).append("\n"); 
		query.append(",	FCS.PAIR_SLP_ISS_DT" ).append("\n"); 
		query.append(",	FCS.PAIR_SLP_SER_NO" ).append("\n"); 
		query.append(",	FCS.PAIR_SLP_SEQ_NO" ).append("\n"); 
		query.append(",	(SELECT COUNT(1) " ).append("\n"); 
		query.append("       FROM FMS_OWNR_ACCT_ATCH_FILE " ).append("\n"); 
		query.append("      WHERE ATCH_FILE_OA_LNK_ID = FCS.SLP_TP_CD||FCS.SLP_FUNC_CD||FCS.SLP_OFC_CD||FCS.SLP_ISS_DT||FCS.SLP_SER_NO||FCS.SLP_SEQ_NO) ATCH_FILE_OA_LNK_CNT -- Attach File Count" ).append("\n"); 
		query.append(", (SELECT DECODE(P.OA_STL_STS_CD, 'RC', 'Received'," ).append("\n"); 
		query.append("                                   'EA', 'Editing Attachment',       " ).append("\n"); 
		query.append("                                   'HD', 'Holding',  " ).append("\n"); 
		query.append("                                   'CN', 'Cancelled',  " ).append("\n"); 
		query.append("                                   'RF', 'Refund',  " ).append("\n"); 
		query.append("                                   'ST', 'Settled','')" ).append("\n"); 
		query.append("   FROM FMS_OWNR_ACCT_SLP P" ).append("\n"); 
		query.append("   WHERE 1 = 1" ).append("\n"); 
		query.append("     AND FCS.SLP_TP_CD   = P.SLP_TP_CD" ).append("\n"); 
		query.append("     AND FCS.SLP_FUNC_CD = P.SLP_FUNC_CD" ).append("\n"); 
		query.append("     AND FCS.SLP_OFC_CD  = P.SLP_OFC_CD" ).append("\n"); 
		query.append("     AND FCS.SLP_ISS_DT  = P.SLP_ISS_DT" ).append("\n"); 
		query.append("     AND FCS.SLP_SER_NO  = P.SLP_SER_NO" ).append("\n"); 
		query.append("     AND FCS.SLP_SEQ_NO  = P.SLP_SEQ_NO)  OA_STL_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM FMS_CONSULTATION FC, FMS_CSUL_SLP FCS" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND FC.SLP_TP_CD = FCS.SLP_TP_CD" ).append("\n"); 
		query.append("   AND FC.SLP_FUNC_CD = FCS.SLP_FUNC_CD" ).append("\n"); 
		query.append("   AND FC.SLP_OFC_CD = FCS.SLP_OFC_CD" ).append("\n"); 
		query.append("   AND FC.SLP_ISS_DT = FCS.SLP_ISS_DT" ).append("\n"); 
		query.append("   AND FC.SLP_SER_NO = FCS.SLP_SER_NO" ).append("\n"); 
		query.append("#if(${s_flg} == 'R1')" ).append("\n"); 
		query.append("   AND FCS.SLP_TP_CD||FCS.SLP_FUNC_CD||FCS.SLP_OFC_CD||FCS.SLP_ISS_DT||FCS.SLP_SER_NO||FCS.SLP_SEQ_NO = @[csr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND FCS.SLP_TP_CD||FCS.SLP_FUNC_CD||FCS.SLP_OFC_CD||FCS.SLP_ISS_DT||FCS.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 6" ).append("\n"); 

	}
}
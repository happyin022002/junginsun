/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOSearchOwnersAccountCancellationSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
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

public class OwnersAccountDBDAOSearchOwnersAccountCancellationSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OwnersAccountDBDAOSearchOwnersAccountCancellationSlipRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOSearchOwnersAccountCancellationSlipRSQL").append("\n"); 
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
		query.append("SELECT A.SLP_TP_CD" ).append("\n"); 
		query.append("       , A.SLP_FUNC_CD" ).append("\n"); 
		query.append("       , A.SLP_OFC_CD" ).append("\n"); 
		query.append("       , A.SLP_ISS_DT" ).append("\n"); 
		query.append("       , A.SLP_SER_NO" ).append("\n"); 
		query.append("       , A.SLP_SEQ_NO" ).append("\n"); 
		query.append("       , '962111' ACCT_CD" ).append("\n"); 
		query.append("       , A.CTR_CD" ).append("\n"); 
		query.append("       , B.SLP_LOC_CD" ).append("\n"); 
		query.append("       , A.N2ND_CURR_CD CSR_CURR_CD" ).append("\n"); 
		query.append("       , A.N2ND_AMT CSR_AMT" ).append("\n"); 
		query.append("       , A.AP_DESC CSR_DESC" ).append("\n"); 
		query.append("       , A.VNDR_SEQ" ).append("\n"); 
		query.append("       , A.N1ST_CURR_CD TRNS_CURR_CD" ).append("\n"); 
		query.append("       , A.N1ST_AMT TRNS_AMT" ).append("\n"); 
		query.append("       , B.VAT_FLG" ).append("\n"); 
		query.append("       , B.STL_FLG" ).append("\n"); 
		query.append("       , B.INV_SEQ" ).append("\n"); 
		query.append("       , B.FLET_SRC_TP_CD" ).append("\n"); 
		query.append("       , A.VSL_CD" ).append("\n"); 
		query.append("       , A.SKD_VOY_NO" ).append("\n"); 
		query.append("       , A.SKD_DIR_CD" ).append("\n"); 
		query.append("       , A.REV_DIR_CD" ).append("\n"); 
		query.append("	     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("       , A.SLP_TP_CD ORG_SLP_TP_CD" ).append("\n"); 
		query.append("       , A.SLP_FUNC_CD ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("       , A.SLP_OFC_CD ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("       , A.SLP_ISS_DT ORG_ISS_DT" ).append("\n"); 
		query.append("       , A.SLP_SER_NO ORG_SLP_SER_NO" ).append("\n"); 
		query.append("       , A.SLP_SEQ_NO ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("       , B.TO_INV_NO" ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , A.CRE_DT" ).append("\n"); 
		query.append("       , A.UPD_USR_ID" ).append("\n"); 
		query.append("       , A.UPD_DT" ).append("\n"); 
		query.append("       , A.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("       , B.OA_INV_DT" ).append("\n"); 
		query.append("       , B.ATCH_FILE_OA_LNK_ID " ).append("\n"); 
		query.append("       , B.OA_LOC_CD" ).append("\n"); 
		query.append("  FROM FMS_OWNR_ACCT_SLP A," ).append("\n"); 
		query.append("       FMS_CSUL_SLP B" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO =" ).append("\n"); 
		query.append("        B.SLP_TP_CD(+)||B.SLP_FUNC_CD(+)||B.SLP_OFC_CD(+)||B.SLP_ISS_DT(+)||B.SLP_SER_NO(+)||B.SLP_SEQ_NO(+) " ).append("\n"); 
		query.append("#if(${s_csr_no} != '')" ).append("\n"); 
		query.append("   AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO IN ( " ).append("\n"); 
		query.append("	#foreach ($user_csr_no IN ${csrNos})" ).append("\n"); 
		query.append("		#if($velocityCount < $csrNos.size())" ).append("\n"); 
		query.append("			'$user_csr_no'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$user_csr_no'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end              " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOSearchOwnrAcctForCnclListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.21 
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

public class OwnersAccountDBDAOSearchOwnrAcctForCnclListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [ESM_FMS_0101] O/A Inquiry for Cancellation - Retrieve
	  * </pre>
	  */
	public OwnersAccountDBDAOSearchOwnrAcctForCnclListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("supplier",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOSearchOwnrAcctForCnclListRSQL").append("\n"); 
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
		query.append("SELECT A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO AS CSR_NO," ).append("\n"); 
		query.append("       (SELECT I.ACCT_ITM_NM" ).append("\n"); 
		query.append("        FROM FMS_ACCT_ITM I " ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND I.ACCT_CD = '962111'" ).append("\n"); 
		query.append("          AND I.ACCT_ITM_SEQ = A.ACCT_ITM_SEQ) AS ACCT_ITM_NM,  " ).append("\n"); 
		query.append("       A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD_CD,   " ).append("\n"); 
		query.append("       C.OA_LOC_CD," ).append("\n"); 
		query.append("       C.TO_INV_NO," ).append("\n"); 
		query.append("       C.OA_INV_DT," ).append("\n"); 
		query.append("       A.N2ND_CURR_CD AS CSR_CURR_CD," ).append("\n"); 
		query.append("       A.N2ND_AMT AS CSR_AMT," ).append("\n"); 
		query.append("       A.AP_DESC AS CSR_DESC," ).append("\n"); 
		query.append("       (SELECT COUNT(F.FILE_SAV_ID) CNT" ).append("\n"); 
		query.append("        FROM FMS_OWNR_ACCT_ATCH_FILE F" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND F.ATCH_FILE_OA_LNK_ID = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO" ).append("\n"); 
		query.append("        ) AS ATCH_FILE_OA_LNK_CNT," ).append("\n"); 
		query.append("       DECODE(A.OA_STL_STS_CD, 'RC', 'Received'," ).append("\n"); 
		query.append("                               'EA', 'Editing Attachment',       " ).append("\n"); 
		query.append("                               'HD', 'Holding',  " ).append("\n"); 
		query.append("                               'CN', 'Cancelled',  " ).append("\n"); 
		query.append("                               'RF', 'Refund',  " ).append("\n"); 
		query.append("                               'ST', 'Settled','') OA_STL_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM FMS_OWNR_ACCT_SLP A," ).append("\n"); 
		query.append("     FMS_CSUL_SLP C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND A.SLP_TP_CD = C.SLP_TP_CD" ).append("\n"); 
		query.append("  AND A.SLP_FUNC_CD = C.SLP_FUNC_CD" ).append("\n"); 
		query.append("  AND A.SLP_OFC_CD = C.SLP_OFC_CD" ).append("\n"); 
		query.append("  AND A.SLP_ISS_DT = C.SLP_ISS_DT" ).append("\n"); 
		query.append("  AND A.SLP_SER_NO = C.SLP_SER_NO" ).append("\n"); 
		query.append("  AND A.SLP_SEQ_NO = C.SLP_SEQ_NO" ).append("\n"); 
		query.append("  AND A.ACCT_CD = '111071'" ).append("\n"); 
		query.append("  AND NVL(A.OA_STL_STS_CD, 'N') IN ('N', 'ST', 'RC')" ).append("\n"); 
		query.append("  AND A.N1ST_AMT > 0 " ).append("\n"); 
		query.append("  AND A.PAIR_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("  AND A.VNDR_SEQ = @[supplier]" ).append("\n"); 
		query.append("  AND C.PAIR_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vsl_cd} != '')" ).append("\n"); 
		query.append("  AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vel_acct_itm_seq} != '') " ).append("\n"); 
		query.append("  AND A.ACCT_ITM_SEQ IN " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  #foreach($vel_acct_itm_seq IN ${list_acct_itm_seq})" ).append("\n"); 
		query.append("    #if($list_acct_itm_seq.hasNext()) '$vel_acct_itm_seq', #else '$vel_acct_itm_seq' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${csr_fr_dt} != '' && ${csr_to_dt} != '')" ).append("\n"); 
		query.append("  AND A.CRE_DT BETWEEN TO_DATE(@[csr_fr_dt] || '0000', 'YYYYMMDDHH24MI') AND TO_DATE(@[csr_to_dt] || '2359', 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if(${csr_no} != '')" ).append("\n"); 
		query.append("  AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO LIKE @[csr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOSearchNewOwnerAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOSearchNewOwnerAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [ESM_FMS_0097] (New) Owner's Account : Retrieve
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOSearchNewOwnerAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOSearchNewOwnerAccountListRSQL").append("\n"); 
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
		query.append("SELECT NVL(A.OA_STL_STS_CD, 'BL') OA_STL_STS_CD, " ).append("\n"); 
		query.append("       (SELECT COUNT(F.FILE_SAV_ID) CNT" ).append("\n"); 
		query.append("        FROM FMS_OWNR_ACCT_ATCH_FILE F" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND F.ATCH_FILE_OA_LNK_ID = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO" ).append("\n"); 
		query.append("        ) ATTACH," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       (SELECT I.ACCT_ITM_NM" ).append("\n"); 
		query.append("        FROM FMS_ACCT_ITM I " ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND I.ACCT_CD = '962111'" ).append("\n"); 
		query.append("          AND A.ACCT_ITM_SEQ = I.ACCT_ITM_SEQ) ACCT_ITM_NM," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       A.ACCT_CD," ).append("\n"); 
		query.append("       C.OA_LOC_CD," ).append("\n"); 
		query.append("       A.ACCT_ITM_SEQ," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       A.AP_DESC," ).append("\n"); 
		query.append("       A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD," ).append("\n"); 
		query.append("       A.N1ST_AMT USD_AMT," ).append("\n"); 
		query.append("       A.N2ND_CURR_CD LCL," ).append("\n"); 
		query.append("       A.N2ND_AMT AMOUNT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO CSR_SLIP_NO," ).append("\n"); 
		query.append("	   A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO COND_CSR_SLIP_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       A.EFF_DT," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("       A.LOCL_XCH_RT_AMT EX_RATE," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("      A.PAIR_SLP_TP_CD||A.PAIR_SLP_FUNC_CD||A.PAIR_SLP_OFC_CD||A.PAIR_SLP_ISS_DT||A.PAIR_SLP_SER_NO||A.PAIR_SLP_SEQ_NO MATCHING_CSR_SLIP_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT D.OA_INTER_MM_DESC" ).append("\n"); 
		query.append("        FROM FMS_CONSULTATION D" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND D.SLP_TP_CD = A.SLP_TP_CD" ).append("\n"); 
		query.append("          AND D.SLP_FUNC_CD = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("          AND D.SLP_OFC_CD = A.SLP_OFC_CD" ).append("\n"); 
		query.append("          AND D.SLP_ISS_DT = A.SLP_ISS_DT" ).append("\n"); 
		query.append("          AND D.SLP_SER_NO = A.SLP_SER_NO) INTERNAL_MEMO," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("       (SELECT C.PPAY_HIR_NO" ).append("\n"); 
		query.append("        FROM FMS_CONSULTATION C" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND A.CSUL_SLP_TP_CD = C.SLP_TP_CD" ).append("\n"); 
		query.append("          AND A.CSUL_SLP_FUNC_CD = C.SLP_FUNC_CD" ).append("\n"); 
		query.append("          AND A.CSUL_SLP_OFC_CD = C.SLP_OFC_CD" ).append("\n"); 
		query.append("          AND A.CSUL_SLP_ISS_DT = C.SLP_ISS_DT" ).append("\n"); 
		query.append("          AND A.CSUL_SLP_SER_NO = C.SLP_SER_NO) PPAY_HIR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,'' USR_ID,A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.REV_DIR_CD" ).append("\n"); 
		query.append("FROM FMS_OWNR_ACCT_SLP A," ).append("\n"); 
		query.append("     FMS_CSUL_SLP C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND A.SLP_TP_CD = C.SLP_TP_CD(+)" ).append("\n"); 
		query.append("  AND A.SLP_FUNC_CD = C.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("  AND A.SLP_OFC_CD = C.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("  AND A.SLP_ISS_DT = C.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("  AND A.SLP_SER_NO = C.SLP_SER_NO(+)" ).append("\n"); 
		query.append("  AND A.SLP_SEQ_NO = C.SLP_SEQ_NO(+)" ).append("\n"); 
		query.append("  AND A.ACCT_CD = '111071'" ).append("\n"); 
		query.append("  AND SUBSTR(A.EFF_DT, 1, 6) BETWEEN @[eff_dt1]  AND @[eff_dt2]" ).append("\n"); 
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
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("  AND C.OA_LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vel_cmb_sttlmnt} != '')" ).append("\n"); 
		query.append("  AND NVL(A.OA_STL_STS_CD, 'BL') IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  #foreach($vel_cmb_sttlmnt IN ${list_cmb_settlmnt})" ).append("\n"); 
		query.append("    #if($list_cmb_settlmnt.hasNext()) '$vel_cmb_sttlmnt', #else '$vel_cmb_sttlmnt' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
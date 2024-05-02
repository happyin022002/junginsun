/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOSearchAutoGenSlpsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13 
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

public class OwnersAccountDBDAOSearchAutoGenSlpsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Owner's Account 전표 결재가 최종승인처리되고 나면 자동생성되는 전표 데이터를 조회한다.
	  * </pre>
	  */
	public OwnersAccountDBDAOSearchAutoGenSlpsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOSearchAutoGenSlpsRSQL").append("\n"); 
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
		query.append("-- 전표 1" ).append("\n"); 
		query.append("SELECT SLP_TP_CD" ).append("\n"); 
		query.append("       , 'S' SLP_FUNC_CD" ).append("\n"); 
		query.append("       , 'SELADG' SLP_OFC_CD	-- 심사팀 오피스" ).append("\n"); 
		query.append("       , SLP_ISS_DT" ).append("\n"); 
		query.append("       , @[slp_ser_no1] SLP_SER_NO" ).append("\n"); 
		query.append("       , '' SLP_SEQ_NO -- 자동생성될꺼" ).append("\n"); 
		query.append("       , ACCT_CD" ).append("\n"); 
		query.append("       , CTR_CD" ).append("\n"); 
		query.append("       , SLP_LOC_CD" ).append("\n"); 
		query.append("       , CSR_CURR_CD" ).append("\n"); 
		query.append("       , (CSR_AMT * -1) CSR_AMT" ).append("\n"); 
		query.append("       , CSR_DESC" ).append("\n"); 
		query.append("       , 6260 VNDR_SEQ -- 심사팀 벤더코드 넣어주고" ).append("\n"); 
		query.append("       , TRNS_CURR_CD" ).append("\n"); 
		query.append("       , TRNS_AMT" ).append("\n"); 
		query.append("       , VAT_FLG" ).append("\n"); 
		query.append("       , STL_FLG" ).append("\n"); 
		query.append("       , INV_SEQ" ).append("\n"); 
		query.append("       , FLET_SRC_TP_CD" ).append("\n"); 
		query.append("       , VSL_CD" ).append("\n"); 
		query.append("       , SKD_VOY_NO" ).append("\n"); 
		query.append("       , SKD_DIR_CD" ).append("\n"); 
		query.append("       , REV_DIR_CD" ).append("\n"); 
		query.append("	   , VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("       , SLP_TP_CD ORG_SLP_TP_CD" ).append("\n"); 
		query.append("       , SLP_FUNC_CD ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("       , SLP_OFC_CD ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("       , SLP_ISS_DT ORG_ISS_DT" ).append("\n"); 
		query.append("       , SLP_SER_NO ORG_SLP_SER_NO" ).append("\n"); 
		query.append("       , SLP_SEQ_NO ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("       , TO_INV_NO" ).append("\n"); 
		query.append("       , 'SYSTEM' CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , 'SYSTEM' UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("       , OA_INV_DT" ).append("\n"); 
		query.append("       , ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append("  FROM FMS_CSUL_SLP" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO||SLP_SEQ_NO = @[csr_no]" ).append("\n"); 
		query.append("   AND ACCT_CD = '962111'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- 전표 2" ).append("\n"); 
		query.append("SELECT SLP_TP_CD" ).append("\n"); 
		query.append("       , 'S' SLP_FUNC_CD" ).append("\n"); 
		query.append("       , 'SELADG' SLP_OFC_CD	-- 심사팀 오피스" ).append("\n"); 
		query.append("       , SLP_ISS_DT" ).append("\n"); 
		query.append("       , @[slp_ser_no1] SLP_SER_NO" ).append("\n"); 
		query.append("       , '' SLP_SEQ_NO" ).append("\n"); 
		query.append("       , '951111' ACCT_CD" ).append("\n"); 
		query.append("       , CTR_CD" ).append("\n"); 
		query.append("       , SLP_LOC_CD" ).append("\n"); 
		query.append("       , CSR_CURR_CD" ).append("\n"); 
		query.append("       , CSR_AMT" ).append("\n"); 
		query.append("       , CSR_DESC" ).append("\n"); 
		query.append("       , 6260 VNDR_SEQ" ).append("\n"); 
		query.append("       , TRNS_CURR_CD" ).append("\n"); 
		query.append("       , TRNS_AMT" ).append("\n"); 
		query.append("       , VAT_FLG" ).append("\n"); 
		query.append("       , STL_FLG" ).append("\n"); 
		query.append("       , INV_SEQ" ).append("\n"); 
		query.append("       , FLET_SRC_TP_CD" ).append("\n"); 
		query.append("       , '' VSL_CD" ).append("\n"); 
		query.append("       , '' SKD_VOY_NO" ).append("\n"); 
		query.append("       , '' SKD_DIR_CD" ).append("\n"); 
		query.append("       , '' REV_DIR_CD" ).append("\n"); 
		query.append("	   , '' VVD_CD" ).append("\n"); 
		query.append("       , SLP_TP_CD ORG_SLP_TP_CD" ).append("\n"); 
		query.append("       , SLP_FUNC_CD ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("       , SLP_OFC_CD ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("       , SLP_ISS_DT ORG_ISS_DT" ).append("\n"); 
		query.append("       , SLP_SER_NO ORG_SLP_SER_NO" ).append("\n"); 
		query.append("       , SLP_SEQ_NO ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("       , TO_INV_NO" ).append("\n"); 
		query.append("       , 'SYSTEM' CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , 'SYSTEM' UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("       , OA_INV_DT" ).append("\n"); 
		query.append("       , ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append("  FROM FMS_CSUL_SLP B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO||SLP_SEQ_NO = @[csr_no]" ).append("\n"); 
		query.append("   AND ACCT_CD = '962111'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- 전표 3" ).append("\n"); 
		query.append("SELECT SLP_TP_CD" ).append("\n"); 
		query.append("       , 'S' SLP_FUNC_CD" ).append("\n"); 
		query.append("       , 'SELADG' SLP_OFC_CD	-- 심사팀 오피스" ).append("\n"); 
		query.append("       , SLP_ISS_DT" ).append("\n"); 
		query.append("       , @[slp_ser_no2] SLP_SER_NO" ).append("\n"); 
		query.append("       , '' SLP_SEQ_NO" ).append("\n"); 
		query.append("       , '951111' ACCT_CD" ).append("\n"); 
		query.append("       , CTR_CD" ).append("\n"); 
		query.append("       , SLP_LOC_CD" ).append("\n"); 
		query.append("       , 'USD' CSR_CURR_CD -- USD로 변환" ).append("\n"); 
		query.append("       , (SELECT ROUND(FMS_CAL_CURR_RATE_FNC(SUBSTR(A.EFF_DT, 1, 6), A.CSR_CURR_CD, B.CSR_AMT) * -1, 2) USD_AMT" ).append("\n"); 
		query.append("            FROM FMS_CONSULTATION A" ).append("\n"); 
		query.append("           WHERE  A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = " ).append("\n"); 
		query.append("                   B.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||B.SLP_ISS_DT||B.SLP_SER_NO" ).append("\n"); 
		query.append("          ) CSR_AMT" ).append("\n"); 
		query.append("       , CSR_DESC" ).append("\n"); 
		query.append("       , 6260 VNDR_SEQ -- 심사팀 벤더코드 넣어주고" ).append("\n"); 
		query.append("       , TRNS_CURR_CD" ).append("\n"); 
		query.append("       , TRNS_AMT" ).append("\n"); 
		query.append("       , VAT_FLG" ).append("\n"); 
		query.append("       , STL_FLG" ).append("\n"); 
		query.append("       , INV_SEQ" ).append("\n"); 
		query.append("       , FLET_SRC_TP_CD" ).append("\n"); 
		query.append("       , '' VSL_CD" ).append("\n"); 
		query.append("       , '' SKD_VOY_NO" ).append("\n"); 
		query.append("       , '' SKD_DIR_CD" ).append("\n"); 
		query.append("       , '' REV_DIR_CD" ).append("\n"); 
		query.append("	   , '' VVD_CD" ).append("\n"); 
		query.append("       , SLP_TP_CD ORG_SLP_TP_CD" ).append("\n"); 
		query.append("       , SLP_FUNC_CD ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("       , SLP_OFC_CD ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("       , SLP_ISS_DT ORG_ISS_DT" ).append("\n"); 
		query.append("       , SLP_SER_NO ORG_SLP_SER_NO" ).append("\n"); 
		query.append("       , SLP_SEQ_NO ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("       , TO_INV_NO" ).append("\n"); 
		query.append("       , 'SYSTEM' CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , 'SYSTEM' UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("       , OA_INV_DT" ).append("\n"); 
		query.append("       , ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append("  FROM FMS_CSUL_SLP B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO||SLP_SEQ_NO = @[csr_no]" ).append("\n"); 
		query.append("   AND ACCT_CD = '962111'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- 전표 4" ).append("\n"); 
		query.append("SELECT SLP_TP_CD" ).append("\n"); 
		query.append("       , 'S' SLP_FUNC_CD" ).append("\n"); 
		query.append("       , 'SELADG' SLP_OFC_CD	-- 심사팀 오피스" ).append("\n"); 
		query.append("       , SLP_ISS_DT" ).append("\n"); 
		query.append("       , @[slp_ser_no2] SLP_SER_NO" ).append("\n"); 
		query.append("       , '' SLP_SEQ_NO" ).append("\n"); 
		query.append("       , '111071' ACCT_CD" ).append("\n"); 
		query.append("       , CTR_CD" ).append("\n"); 
		query.append("       , SLP_LOC_CD" ).append("\n"); 
		query.append("       , 'USD' CSR_CURR_CD -- USD로 변환" ).append("\n"); 
		query.append("       , (SELECT ROUND(FMS_CAL_CURR_RATE_FNC(SUBSTR(A.EFF_DT, 1, 6), A.CSR_CURR_CD, B.CSR_AMT), 2) USD_AMT" ).append("\n"); 
		query.append("            FROM FMS_CONSULTATION A" ).append("\n"); 
		query.append("           WHERE  A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = " ).append("\n"); 
		query.append("                   B.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||B.SLP_ISS_DT||B.SLP_SER_NO" ).append("\n"); 
		query.append("          ) CSR_AMT" ).append("\n"); 
		query.append("       , CSR_DESC" ).append("\n"); 
		query.append("       , 6260 VNDR_SEQ -- 심사팀 벤더코드 넣어주고" ).append("\n"); 
		query.append("       , TRNS_CURR_CD" ).append("\n"); 
		query.append("       , TRNS_AMT" ).append("\n"); 
		query.append("       , VAT_FLG" ).append("\n"); 
		query.append("       , STL_FLG" ).append("\n"); 
		query.append("       , INV_SEQ" ).append("\n"); 
		query.append("       , FLET_SRC_TP_CD" ).append("\n"); 
		query.append("       , VSL_CD" ).append("\n"); 
		query.append("       , SKD_VOY_NO" ).append("\n"); 
		query.append("       , SKD_DIR_CD" ).append("\n"); 
		query.append("       , REV_DIR_CD" ).append("\n"); 
		query.append("	   , VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("       , SLP_TP_CD ORG_SLP_TP_CD" ).append("\n"); 
		query.append("       , SLP_FUNC_CD ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("       , SLP_OFC_CD ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("       , SLP_ISS_DT ORG_ISS_DT" ).append("\n"); 
		query.append("       , SLP_SER_NO ORG_SLP_SER_NO" ).append("\n"); 
		query.append("       , SLP_SEQ_NO ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("       , TO_INV_NO" ).append("\n"); 
		query.append("       , 'SYSTEM' CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , 'SYSTEM' UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("       , OA_INV_DT" ).append("\n"); 
		query.append("       , ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append("  FROM FMS_CSUL_SLP B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO||SLP_SEQ_NO = @[csr_no]" ).append("\n"); 
		query.append("   AND ACCT_CD = '962111'" ).append("\n"); 

	}
}
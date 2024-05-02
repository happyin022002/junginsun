/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchArSlipDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchArSlipDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR 전표 Detail 계정 항목들을 조회한다 
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchArSlipDetailListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchArSlipDetailListRSQL").append("\n"); 
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
		query.append("SELECT A.FLET_CTRT_NO" ).append("\n"); 
		query.append("     , A.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("     , A.TO_INV_NO BL_NO" ).append("\n"); 
		query.append("     , 'LFC'||LPAD(E.TO_IF_NO+ROWNUM,7,'0') TO_IF_NO" ).append("\n"); 
		query.append("     , SUBSTR(A.TO_INV_NO, 1, 8) INV_NO" ).append("\n"); 
		query.append("     , C.CUST_CNT_CD" ).append("\n"); 
		query.append("     , C.CUST_SEQ" ).append("\n"); 
		query.append("     , A.SLP_TP_CD" ).append("\n"); 
		query.append("     , A.SLP_FUNC_CD" ).append("\n"); 
		query.append("     , A.SLP_OFC_CD" ).append("\n"); 
		query.append("     , A.SLP_ISS_DT" ).append("\n"); 
		query.append("     , A.SLP_SER_NO" ).append("\n"); 
		query.append("     , (SELECT SLP_LOC_CD" ).append("\n"); 
		query.append("          FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("         WHERE FS.SLP_TP_CD = D.SLP_TP_CD" ).append("\n"); 
		query.append("           AND FS.SLP_FUNC_CD = D.SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND FS.SLP_OFC_CD = D.SLP_OFC_CD" ).append("\n"); 
		query.append("           AND FS.SLP_ISS_DT = D.SLP_ISS_DT" ).append("\n"); 
		query.append("           AND FS.SLP_SER_NO = D.SLP_SER_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1) SLP_LOC_CD" ).append("\n"); 
		query.append("     , D.EFF_DT" ).append("\n"); 
		query.append("     , F.VSL_CD" ).append("\n"); 
		query.append("     , F.SKD_VOY_NO" ).append("\n"); 
		query.append("     , F.SKD_DIR_CD" ).append("\n"); 
		query.append("     , F.REV_DIR_CD" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(D.EFF_DT, 'YYYYMMDD') + 30, 'YYYYMMDD') DUE_DT" ).append("\n"); 
		query.append("     , A.INV_AMT" ).append("\n"); 
		query.append("     , A.INV_DESC" ).append("\n"); 
		query.append("     , A.INV_DESC INV_DESC_ENC" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.INV_SEQ" ).append("\n"); 
		query.append("     , A.INV_DTL_SEQ" ).append("\n"); 
		query.append("  FROM FMS_INV_DTL A" ).append("\n"); 
		query.append("     , FMS_CONTRACT C" ).append("\n"); 
		query.append("     , FMS_CONSULTATION D" ).append("\n"); 
		query.append("     , (SELECT TO_NUMBER(NVL(MAX(SUBSTR(AR_IF_NO,4,7)),'0')) TO_IF_NO" ).append("\n"); 
		query.append("          FROM JOO_AR_MN" ).append("\n"); 
		query.append("         WHERE AR_IF_NO LIKE 'LFC%') E" ).append("\n"); 
		query.append("     , (SELECT VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , REV_DIR_CD" ).append("\n"); 
		query.append("          FROM FMS_CSUL_SLP" ).append("\n"); 
		query.append("         WHERE SLP_TP_CD || SLP_FUNC_CD || SLP_OFC_CD || SLP_ISS_DT || SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) F" ).append("\n"); 
		query.append(" WHERE A.SLP_TP_CD = D.SLP_TP_CD" ).append("\n"); 
		query.append("   AND A.SLP_FUNC_CD = D.SLP_FUNC_CD" ).append("\n"); 
		query.append("   AND A.SLP_OFC_CD = D.SLP_OFC_CD" ).append("\n"); 
		query.append("   AND A.SLP_ISS_DT = D.SLP_ISS_DT" ).append("\n"); 
		query.append("   AND A.SLP_SER_NO = D.SLP_SER_NO" ).append("\n"); 
		query.append("   AND A.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("   AND A.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("   AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                      FROM FMS_ACCT_ITM AI" ).append("\n"); 
		query.append("                         , FMS_ACCT_CATE AC" ).append("\n"); 
		query.append("                     WHERE AI.ACCT_CD = AC.ACCT_CD" ).append("\n"); 
		query.append("                       AND AI.ACCT_ITM_SEQ = AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                       AND AC.FLET_ACCT_CATE_CD = 'BR' /*Brokerage*/" ).append("\n"); 
		query.append("                       AND AI.ACCT_CD = A.ACCT_CD" ).append("\n"); 
		query.append("                       AND ROWNUM = 1 )" ).append("\n"); 
		query.append("   AND A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("   AND D.APRO_FLG = 'N'" ).append("\n"); 
		query.append("   AND D.CXL_FLG = 'N'" ).append("\n"); 

	}
}
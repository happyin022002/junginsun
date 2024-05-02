/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchArBunkerSlipDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchArBunkerSlipDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR Bunker 전표 데이타를 가져온다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchArBunkerSlipDetailListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchArBunkerSlipDetailListRSQL").append("\n"); 
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
		query.append("SELECT  D.FLET_CTRT_NO," ).append("\n"); 
		query.append("        '' FLET_ISS_TP_CD," ).append("\n"); 
		query.append("        A.TO_INV_NO BL_NO," ).append("\n"); 
		query.append("        'LFC'||LPAD(E.TO_IF_NO+ROWNUM,7,'0') TO_IF_NO," ).append("\n"); 
		query.append("        SUBSTR(A.TO_INV_NO, 1, 8) INV_NO," ).append("\n"); 
		query.append("        C.CUST_CNT_CD," ).append("\n"); 
		query.append("        C.CUST_SEQ," ).append("\n"); 
		query.append("        A.SLP_TP_CD," ).append("\n"); 
		query.append("        A.SLP_FUNC_CD," ).append("\n"); 
		query.append("        A.SLP_OFC_CD," ).append("\n"); 
		query.append("        A.SLP_ISS_DT," ).append("\n"); 
		query.append("        A.SLP_SER_NO," ).append("\n"); 
		query.append("        (SELECT SLP_LOC_CD" ).append("\n"); 
		query.append("         FROM   FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("         WHERE  FS.SLP_TP_CD     = D.SLP_TP_CD" ).append("\n"); 
		query.append("         AND    FS.SLP_FUNC_CD   = D.SLP_FUNC_CD" ).append("\n"); 
		query.append("         AND    FS.SLP_OFC_CD    = D.SLP_OFC_CD" ).append("\n"); 
		query.append("         AND    FS.SLP_ISS_DT    = D.SLP_ISS_DT" ).append("\n"); 
		query.append("         AND    FS.SLP_SER_NO    = D.SLP_SER_NO" ).append("\n"); 
		query.append("         AND    ROWNUM = 1) SLP_LOC_CD," ).append("\n"); 
		query.append("		D.EFF_DT," ).append("\n"); 
		query.append("        A.VSL_CD," ).append("\n"); 
		query.append("        A.SKD_VOY_NO," ).append("\n"); 
		query.append("        A.SKD_DIR_CD," ).append("\n"); 
		query.append("        A.REV_DIR_CD," ).append("\n"); 
		query.append("        TO_CHAR(TO_DATE(D.EFF_DT, 'YYYYMMDD') + 30, 'YYYYMMDD') DUE_DT," ).append("\n"); 
		query.append("        A.CSR_AMT INV_AMT," ).append("\n"); 
		query.append("        A.CSR_DESC INV_DESC," ).append("\n"); 
		query.append("        HJSEAI_PKG.h_encode(A.CSR_DESC   ,'ERP','KR') INV_DESC_ENC," ).append("\n"); 
		query.append("        A.CSR_CURR_CD CURR_CD," ).append("\n"); 
		query.append("        A.UPD_USR_ID," ).append("\n"); 
		query.append("       (SELECT DECODE(SIGN(E.CSR_AMT), 1, 'Y', 'N')" ).append("\n"); 
		query.append("         FROM FMS_CSUL_SLP E" ).append("\n"); 
		query.append("         WHERE E.ACCT_CD        = '954113'" ).append("\n"); 
		query.append("         AND	 E.SLP_TP_CD 	 = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("         AND	 E.SLP_FUNC_CD 	 = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("         AND	 E.SLP_OFC_CD 	 = SUBSTR(@[csr_no],4,6)" ).append("\n"); 
		query.append("         AND	 E.SLP_ISS_DT 	 = SUBSTR(@[csr_no],10,6)" ).append("\n"); 
		query.append("         AND	 E.SLP_SER_NO 	 = SUBSTR(@[csr_no],16,5)" ).append("\n"); 
		query.append("        ) CHK" ).append("\n"); 
		query.append("FROM    FMS_CSUL_SLP A, FMS_CONTRACT C, FMS_CONSULTATION D," ).append("\n"); 
		query.append("        (SELECT TO_NUMBER(NVL(MAX(SUBSTR(AR_IF_NO,4,7)),'0')) TO_IF_NO" ).append("\n"); 
		query.append("         FROM   JOO_AR_MN" ).append("\n"); 
		query.append("         WHERE  AR_IF_NO LIKE 'LFC%') E" ).append("\n"); 
		query.append("WHERE   A.SLP_TP_CD      = D.SLP_TP_CD" ).append("\n"); 
		query.append("AND		A.SLP_FUNC_CD    = D.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND		A.SLP_OFC_CD     = D.SLP_OFC_CD" ).append("\n"); 
		query.append("AND		A.SLP_ISS_DT     = D.SLP_ISS_DT" ).append("\n"); 
		query.append("AND		A.SLP_SER_NO     = D.SLP_SER_NO" ).append("\n"); 
		query.append("AND     C.FLET_CTRT_NO   = D.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND		A.ACCT_CD        = '110811'" ).append("\n"); 
		query.append("AND		A.SLP_TP_CD 	 = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND		A.SLP_FUNC_CD 	 = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND		A.SLP_OFC_CD 	 = SUBSTR(@[csr_no],4,6)" ).append("\n"); 
		query.append("AND		A.SLP_ISS_DT 	 = SUBSTR(@[csr_no],10,6)" ).append("\n"); 
		query.append("AND		A.SLP_SER_NO 	 = SUBSTR(@[csr_no],16,5)" ).append("\n"); 
		query.append("AND     D.APRO_FLG       = 'N'" ).append("\n"); 
		query.append("AND     D.CXL_FLG        = 'N'" ).append("\n"); 

	}
}
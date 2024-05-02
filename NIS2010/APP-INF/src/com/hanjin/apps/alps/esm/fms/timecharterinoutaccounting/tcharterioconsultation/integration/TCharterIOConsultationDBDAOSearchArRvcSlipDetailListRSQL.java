/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchArRvcSlipDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.19 
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

public class TCharterIOConsultationDBDAOSearchArRvcSlipDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR Reverse 건 조회시
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchArRvcSlipDetailListRSQL(){
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
		query.append("FileName : TCharterIOConsultationDBDAOSearchArRvcSlipDetailListRSQL").append("\n"); 
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
		query.append("SELECT  A.TO_INV_NO BL_NO," ).append("\n"); 
		query.append("'LFC'||LPAD(E.TO_IF_NO+ROWNUM,7,'0') TO_IF_NO," ).append("\n"); 
		query.append("SUBSTR(A.TO_INV_NO, 1, 8) INV_NO," ).append("\n"); 
		query.append("A.CUST_CNT_CD," ).append("\n"); 
		query.append("A.CUST_SEQ," ).append("\n"); 
		query.append("A.SLP_TP_CD," ).append("\n"); 
		query.append("A.SLP_FUNC_CD," ).append("\n"); 
		query.append("A.SLP_OFC_CD," ).append("\n"); 
		query.append("A.SLP_ISS_DT," ).append("\n"); 
		query.append("A.SLP_SER_NO," ).append("\n"); 
		query.append("(SELECT SLP_LOC_CD" ).append("\n"); 
		query.append("FROM   FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("WHERE  FS.SLP_TP_CD     = D.SLP_TP_CD" ).append("\n"); 
		query.append("AND    FS.SLP_FUNC_CD   = D.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND    FS.SLP_OFC_CD    = D.SLP_OFC_CD" ).append("\n"); 
		query.append("AND    FS.SLP_ISS_DT    = D.SLP_ISS_DT" ).append("\n"); 
		query.append("AND    FS.SLP_SER_NO    = D.SLP_SER_NO" ).append("\n"); 
		query.append("AND    ROWNUM = 1) SLP_LOC_CD," ).append("\n"); 
		query.append("D.EFF_DT," ).append("\n"); 
		query.append("F.VSL_CD," ).append("\n"); 
		query.append("F.SKD_VOY_NO," ).append("\n"); 
		query.append("F.SKD_DIR_CD," ).append("\n"); 
		query.append("F.REV_DIR_CD," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(D.EFF_DT, 'YYYYMMDD') + 30, 'YYYYMMDD') DUE_DT," ).append("\n"); 
		query.append("A.CSR_AMT INV_AMT," ).append("\n"); 
		query.append("A.CSR_DESC INV_DESC," ).append("\n"); 
		query.append("HJSEAI_PKG.h_encode(A.CSR_DESC   ,'ERP','KR') INV_DESC_ENC," ).append("\n"); 
		query.append("A.CSR_CURR_CD CURR_CD," ).append("\n"); 
		query.append("A.UPD_USR_ID" ).append("\n"); 
		query.append("FROM    FMS_CSUL_SLP A, FMS_CONSULTATION D," ).append("\n"); 
		query.append("(SELECT TO_NUMBER(NVL(MAX(SUBSTR(AR_IF_NO,4,7)),'0')) TO_IF_NO" ).append("\n"); 
		query.append("FROM   JOO_AR_MN" ).append("\n"); 
		query.append("WHERE  AR_IF_NO LIKE 'LFC%') E," ).append("\n"); 
		query.append("(SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 
		query.append("FROM   FMS_CSUL_SLP" ).append("\n"); 
		query.append("WHERE  SLP_TP_CD 	 = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND	SLP_FUNC_CD  = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND	SLP_OFC_CD 	 = SUBSTR(@[csr_no],4,6)" ).append("\n"); 
		query.append("AND	SLP_ISS_DT 	 = SUBSTR(@[csr_no],10,6)" ).append("\n"); 
		query.append("AND	SLP_SER_NO 	 = SUBSTR(@[csr_no],16,5)" ).append("\n"); 
		query.append("AND    ROWNUM       = 1) F" ).append("\n"); 
		query.append("WHERE   A.SLP_TP_CD      = D.SLP_TP_CD" ).append("\n"); 
		query.append("AND		A.SLP_FUNC_CD    = D.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND		A.SLP_OFC_CD     = D.SLP_OFC_CD" ).append("\n"); 
		query.append("AND		A.SLP_ISS_DT     = D.SLP_ISS_DT" ).append("\n"); 
		query.append("AND		A.SLP_SER_NO     = D.SLP_SER_NO" ).append("\n"); 
		query.append("AND		A.ACCT_CD        NOT IN ('512641', '954112', '954111')" ).append("\n"); 
		query.append("AND		A.SLP_TP_CD 	 = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND		A.SLP_FUNC_CD 	 = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND		A.SLP_OFC_CD 	 = SUBSTR(@[csr_no],4,6)" ).append("\n"); 
		query.append("AND		A.SLP_ISS_DT 	 = SUBSTR(@[csr_no],10,6)" ).append("\n"); 
		query.append("AND		A.SLP_SER_NO 	 = SUBSTR(@[csr_no],16,5)" ).append("\n"); 
		query.append("AND     D.APRO_FLG       = 'N'" ).append("\n"); 
		query.append("AND     D.CXL_FLG        = 'N'" ).append("\n"); 

	}
}
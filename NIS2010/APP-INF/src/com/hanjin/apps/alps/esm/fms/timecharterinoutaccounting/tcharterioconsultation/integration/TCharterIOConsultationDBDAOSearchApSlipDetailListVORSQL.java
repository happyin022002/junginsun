/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchApSlipDetailListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.20 
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

public class TCharterIOConsultationDBDAOSearchApSlipDetailListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전표 Detail 계정 항목들을 조회한다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchApSlipDetailListVORSQL(){
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
		query.append("FileName : TCharterIOConsultationDBDAOSearchApSlipDetailListVORSQL").append("\n"); 
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
		query.append("SELECT  A.SLP_TP_CD, " ).append("\n"); 
		query.append("        A.SLP_FUNC_CD," ).append("\n"); 
		query.append("        A.SLP_OFC_CD," ).append("\n"); 
		query.append("        A.SLP_ISS_DT," ).append("\n"); 
		query.append("        A.SLP_SER_NO," ).append("\n"); 
		query.append("        B.SLP_SEQ_NO," ).append("\n"); 
		query.append("		A.EFF_DT," ).append("\n"); 
		query.append("        A.EVID_TP_CD," ).append("\n"); 
		query.append("        A.CSR_CURR_CD," ).append("\n"); 
		query.append("        A.CSR_USR_ID," ).append("\n"); 
		query.append("        (SELECT O.LOC_CD FROM MDM_ORGANIZATION O, COM_USER U WHERE U.USR_ID = A.CSR_USR_ID AND U.OFC_CD = O.OFC_CD) LOC_CD, " ).append("\n"); 
		query.append("        A.RQST_AMT," ).append("\n"); 
		query.append("        A.RQST_DT," ).append("\n"); 
		query.append("        A.CSR_DESC," ).append("\n"); 
		query.append("	    A.DOC_EVID_TP_CD," ).append("\n"); 
		query.append("        B.ACCT_CD," ).append("\n"); 
		query.append("        B.SLP_LOC_CD," ).append("\n"); 
		query.append("        B.VNDR_SEQ," ).append("\n"); 
		query.append("        B.CUST_CNT_CD," ).append("\n"); 
		query.append("        B.CUST_SEQ," ).append("\n"); 
		query.append("        B.CSR_AMT," ).append("\n"); 
		query.append("        B.CSR_DESC SLP_CSR_DESC," ).append("\n"); 
		query.append("        B.VSL_CD," ).append("\n"); 
		query.append("        B.SKD_VOY_NO," ).append("\n"); 
		query.append("        B.SKD_DIR_CD," ).append("\n"); 
		query.append("        B.REV_DIR_CD," ).append("\n"); 
		query.append("        B.ORG_SLP_TP_CD," ).append("\n"); 
		query.append("        B.ORG_SLP_FUNC_CD," ).append("\n"); 
		query.append("        B.ORG_SLP_OFC_CD," ).append("\n"); 
		query.append("        B.ORG_ISS_DT," ).append("\n"); 
		query.append("        B.ORG_SLP_SER_NO," ).append("\n"); 
		query.append("        B.ORG_SLP_SEQ_NO," ).append("\n"); 
		query.append("	    B.CTR_CD," ).append("\n"); 
		query.append("        NVL(B.AP_SLP_TP_CD||B.AP_SLP_FUNC_CD||B.AP_SLP_OFC_CD||B.AP_SLP_ISS_DT||B.AP_SLP_SER_NO||B.AP_SLP_SEQ_NO, 'N') OA_CSR," ).append("\n"); 
		query.append("        B.TO_INV_NO INV_NO" ).append("\n"); 
		query.append("FROM    FMS_CONSULTATION A, FMS_CSUL_SLP B" ).append("\n"); 
		query.append("WHERE 	A.SLP_TP_CD 	= B.SLP_TP_CD" ).append("\n"); 
		query.append("AND   	A.SLP_FUNC_CD 	= B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_OFC_CD 	= B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_ISS_DT 	= B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND   	A.SLP_SER_NO 	= B.SLP_SER_NO" ).append("\n"); 
		query.append("AND		A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("ORDER BY 6" ).append("\n"); 

	}
}
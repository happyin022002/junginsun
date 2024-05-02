/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchSlipDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.08 
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

public class TCharterIOConsultationDBDAOSearchSlipDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOConsultationDBDAOSearchSlipDetailListRSQL
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchSlipDetailListRSQL(){
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
		query.append("FileName : TCharterIOConsultationDBDAOSearchSlipDetailListRSQL").append("\n"); 
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
		query.append("SELECT SLP_SEQ_NO," ).append("\n"); 
		query.append("	   ACCT_CD," ).append("\n"); 
		query.append("       OWNR_CD," ).append("\n"); 
		query.append("       CTR_CD," ).append("\n"); 
		query.append("       SLP_LOC_CD," ).append("\n"); 
		query.append("       EFF_DT," ).append("\n"); 
		query.append("       CSR_AMT," ).append("\n"); 
		query.append("       CSR_DESC," ).append("\n"); 
		query.append("       CSR_DESC1," ).append("\n"); 
		query.append("       CSR_DESC2," ).append("\n"); 
		query.append("       CSR_DESC3," ).append("\n"); 
		query.append("       VVD_CD," ).append("\n"); 
		query.append("       KEY_NUM," ).append("\n"); 
		query.append("       DR_AMT," ).append("\n"); 
		query.append("       CR_AMT," ).append("\n"); 
		query.append("       FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("       SLP_SEQ_NO ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT TO_CHAR(FS.SLP_SEQ_NO) SLP_SEQ_NO," ).append("\n"); 
		query.append("               FS.ACCT_CD," ).append("\n"); 
		query.append("               DECODE(FS.VNDR_SEQ,NULL,FS.CUST_CNT_CD || ' ' || FS.CUST_SEQ,FS.VNDR_SEQ) OWNR_CD," ).append("\n"); 
		query.append("               FS.CTR_CD," ).append("\n"); 
		query.append("               FS.SLP_LOC_CD," ).append("\n"); 
		query.append("               FC.EFF_DT," ).append("\n"); 
		query.append("               TO_CHAR(FS.CSR_AMT,'FM999,999,999,999,999,990.00') CSR_AMT," ).append("\n"); 
		query.append("               FS.CSR_DESC," ).append("\n"); 
		query.append("               FS.CSR_DESC CSR_DESC1," ).append("\n"); 
		query.append("               FS.CSR_DESC CSR_DESC2," ).append("\n"); 
		query.append("               FS.CSR_DESC CSR_DESC3," ).append("\n"); 
		query.append("               FS.VSL_CD || FS.SKD_VOY_NO || FS.SKD_DIR_CD || FS.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("               CASE WHEN SUBSTR(FC.FLET_CTRT_NO,5,2) = 'TO' OR SUBSTR(@[csr_no],1,3) = '20T' THEN" ).append("\n"); 
		query.append("                         TO_INV_NO" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                         CASE WHEN ORG_SLP_TP_CD IS NOT NULL THEN" ).append("\n"); 
		query.append("                                   FS.ORG_SLP_TP_CD || FS.ORG_SLP_FUNC_CD || FS.ORG_SLP_OFC_CD || FS.ORG_ISS_DT || FS.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("                              WHEN FS.LSG_GR_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("                                   FS.LSG_GR_NO" ).append("\n"); 
		query.append("                              ELSE" ).append("\n"); 
		query.append("                                   FS.SLP_KEY_NO" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                END KEY_NUM," ).append("\n"); 
		query.append("               CASE WHEN SUBSTR(FC.FLET_CTRT_NO,5,2) = 'TO' OR SUBSTR(@[csr_no],1,3) = '20T' THEN" ).append("\n"); 
		query.append("                         DECODE(FS.FLET_SRC_TP_CD,'R1',FS.CSR_AMT,0)" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                         CASE WHEN FS.CSR_AMT > 0 THEN" ).append("\n"); 
		query.append("                                   FS.CSR_AMT" ).append("\n"); 
		query.append("                              ELSE" ).append("\n"); 
		query.append("                                   0" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                END DR_AMT," ).append("\n"); 
		query.append("               CASE WHEN SUBSTR(FC.FLET_CTRT_NO,5,2) = 'TO' OR SUBSTR(@[csr_no],1,3) = '20T' THEN" ).append("\n"); 
		query.append("                         DECODE(FS.FLET_SRC_TP_CD,'R6',FS.CSR_AMT,0)" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                         CASE WHEN FS.CSR_AMT < 0 THEN" ).append("\n"); 
		query.append("                                   FS.CSR_AMT" ).append("\n"); 
		query.append("                              ELSE" ).append("\n"); 
		query.append("                                   0" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                END CR_AMT," ).append("\n"); 
		query.append("               SUBSTR(FC.FLET_CTRT_NO,5,2) FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("          FROM FMS_CONSULTATION FC, FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("         WHERE    FC.SLP_TP_CD " ).append("\n"); 
		query.append("               || FC.SLP_FUNC_CD " ).append("\n"); 
		query.append("               || FC.SLP_OFC_CD " ).append("\n"); 
		query.append("               || FC.SLP_ISS_DT " ).append("\n"); 
		query.append("               || FC.SLP_SER_NO =    FS.SLP_TP_CD " ).append("\n"); 
		query.append("                                  || FS.SLP_FUNC_CD " ).append("\n"); 
		query.append("                                  || FS.SLP_OFC_CD " ).append("\n"); 
		query.append("                                  || FS.SLP_ISS_DT " ).append("\n"); 
		query.append("                                  || FS.SLP_SER_NO" ).append("\n"); 
		query.append("           AND FC.SLP_TP_CD " ).append("\n"); 
		query.append("               || FC.SLP_FUNC_CD " ).append("\n"); 
		query.append("               || FC.SLP_OFC_CD " ).append("\n"); 
		query.append("               || FC.SLP_ISS_DT " ).append("\n"); 
		query.append("               || FC.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("ORDER BY SLP_SEQ_NO" ).append("\n"); 

	}
}
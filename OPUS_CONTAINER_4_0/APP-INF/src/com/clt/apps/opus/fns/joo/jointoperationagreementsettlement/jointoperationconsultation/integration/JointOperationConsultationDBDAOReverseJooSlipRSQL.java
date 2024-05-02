/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOReverseJooSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOReverseJooSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reverse전표생성시 기존SLIP을 읽어 -금액을 insert한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOReverseJooSlipRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOReverseJooSlipRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        A.SLP_TP_CD" ).append("\n"); 
		query.append("       ,A.SLP_FUNC_CD" ).append("\n"); 
		query.append("       ,A.SLP_OFC_CD" ).append("\n"); 
		query.append("       ,A.SLP_ISS_DT" ).append("\n"); 
		query.append("       ,A.SLP_SER_NO" ).append("\n"); 
		query.append("       ,A.SLP_SEQ_NO" ).append("\n"); 
		query.append("       ,A.DR_CR_CD" ).append("\n"); 
		query.append("       ,A.ACCT_CD" ).append("\n"); 
		query.append("       ,CASE WHEN B.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("                  TO_CHAR(B.EAI_EVNT_DT -1, 'YYYYMMDD')" ).append("\n"); 
		query.append("             ELSE TO_CHAR(A.EFF_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        END AS EFF_DT" ).append("\n"); 
		query.append("       ,A.CSR_LOCL_CURR_CD" ).append("\n"); 
		query.append("       ,A.CSR_LOCL_AMT" ).append("\n"); 
		query.append("       ,A.CSR_USD_AMT" ).append("\n"); 
		query.append("       ,A.SLP_DESC" ).append("\n"); 
		query.append("       ,A.CTR_CD" ).append("\n"); 
		query.append("       ,A.LOC_CD" ).append("\n"); 
		query.append("       ,A.RLANE_CD" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.REV_DIR_CD" ).append("\n"); 
		query.append("       ,A.KEY_NO" ).append("\n"); 
		query.append("       ,A.JO_BIL_NO" ).append("\n"); 
		query.append("       ,DECODE(B.REV_YRMON,NULL,'Y','N') AS VVD_CXL_FLG" ).append("\n"); 
		query.append("       ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ,A.BSA_QTY" ).append("\n"); 
		query.append("       ,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("       ,A.ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,A.STL_SEQ" ).append("\n"); 
		query.append("FROM   JOO_SLIP       A," ).append("\n"); 
		query.append("       AR_MST_REV_VVD B" ).append("\n"); 
		query.append("WHERE  A.VSL_CD     = B.VSL_CD      (+)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = B.SKD_VOY_NO  (+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = B.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("AND    A.REV_DIR_CD = B.RLANE_DIR_CD(+)" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD  || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO  = @[csr_no]" ).append("\n"); 

	}
}
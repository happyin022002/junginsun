/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchInterfaceStatusDetailListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.11 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchInterfaceStatusDetailListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Interface Status
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchInterfaceStatusDetailListVORSQL(){
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
		query.append("FileName : TCharterIOConsultationDBDAOSearchInterfaceStatusDetailListVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.SLP_TP_CD  ORG_SLP_TP_CD" ).append("\n"); 
		query.append(",	A.SLP_FUNC_CD ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	A.SLP_OFC_CD ORG_SLP_OFC_CD" ).append("\n"); 
		query.append(",	A.SLP_ISS_DT ORG_SLP_ISS_DT" ).append("\n"); 
		query.append(",	A.SLP_SER_NO ORG_SLP_SER_NO" ).append("\n"); 
		query.append(",	A.SLP_SEQ_NO ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append(",	A.ACCT_CD" ).append("\n"); 
		query.append(",	B.EFF_DT" ).append("\n"); 
		query.append(",	A.CTR_CD" ).append("\n"); 
		query.append(",	A.SLP_LOC_CD" ).append("\n"); 
		query.append(",	A.CSR_CURR_CD" ).append("\n"); 
		query.append(",	A.CSR_AMT" ).append("\n"); 
		query.append(",	A.CSR_DESC" ).append("\n"); 
		query.append(",	(SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) VNDR_CNT_CD" ).append("\n"); 
		query.append(",	A.VNDR_SEQ" ).append("\n"); 
		query.append(",	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",   NVL(A.LSG_GR_NO,'')||NVL(A.AP_SLP_TP_CD||A.AP_SLP_FUNC_CD||A.AP_SLP_OFC_CD||A.AP_SLP_ISS_DT||A.AP_SLP_SER_NO||A.AP_SLP_SEQ_NO,'')||NVL(A.SLP_KEY_NO,'') KEY_NUMBER" ).append("\n"); 
		query.append(",	A.SLP_TP_CD SLP_TP_CD" ).append("\n"); 
		query.append(",	A.SLP_FUNC_CD SLP_FUNC_CD" ).append("\n"); 
		query.append(",	'' SLP_OFC_CD" ).append("\n"); 
		query.append(",	TO_CHAR(SYSDATE, 'YYMMDD') SLP_ISS_DT" ).append("\n"); 
		query.append(",   '' SLP_SER_NO" ).append("\n"); 
		query.append(",   '' SLP_SEQ_NO" ).append("\n"); 
		query.append(",	'' CXL_DESC" ).append("\n"); 
		query.append(",   '' CRE_USR_ID" ).append("\n"); 
		query.append(",   '' UPD_USR_ID" ).append("\n"); 
		query.append(",   CASE WHEN A.SLP_FUNC_CD = 'S' AND A.ORG_SLP_FUNC_CD = 'P' THEN A.ORG_SLP_TP_CD END PRE_SLP_TP_CD" ).append("\n"); 
		query.append(",   CASE WHEN A.SLP_FUNC_CD = 'S' AND A.ORG_SLP_FUNC_CD = 'P' THEN A.ORG_SLP_FUNC_CD END PRE_SLP_FUNC_CD" ).append("\n"); 
		query.append(",   CASE WHEN A.SLP_FUNC_CD = 'S' AND A.ORG_SLP_FUNC_CD = 'P' THEN A.ORG_SLP_OFC_CD END PRE_SLP_OFC_CD" ).append("\n"); 
		query.append(",   CASE WHEN A.SLP_FUNC_CD = 'S' AND A.ORG_SLP_FUNC_CD = 'P' THEN A.ORG_ISS_DT END PRE_SLP_ISS_DT" ).append("\n"); 
		query.append(",   CASE WHEN A.SLP_FUNC_CD = 'S' AND A.ORG_SLP_FUNC_CD = 'P' THEN A.ORG_SLP_SER_NO END PRE_SLP_SER_NO" ).append("\n"); 
		query.append(",   CASE WHEN A.SLP_FUNC_CD = 'S' AND A.ORG_SLP_FUNC_CD = 'P' THEN A.ORG_SLP_SEQ_NO END PRE_SLP_SEQ_NO" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION B, FMS_CSUL_SLP A" ).append("\n"); 
		query.append("WHERE 	A.SLP_TP_CD 	= B.SLP_TP_CD" ).append("\n"); 
		query.append("AND   	A.SLP_FUNC_CD 	= B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_OFC_CD 	= B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_ISS_DT 	= B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND   	A.SLP_SER_NO 	= B.SLP_SER_NO" ).append("\n"); 
		query.append("AND		A.SLP_TP_CD 	= SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND		A.SLP_FUNC_CD 	= SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND		A.SLP_OFC_CD 	= SUBSTR(@[csr_no],4,6)" ).append("\n"); 
		query.append("AND		A.SLP_ISS_DT 	= SUBSTR(@[csr_no],10,6)" ).append("\n"); 
		query.append("AND		A.SLP_SER_NO 	= SUBSTR(@[csr_no],16,5)" ).append("\n"); 

	}
}
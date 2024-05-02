/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchApproveCEOYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.29
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.07.29 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchApproveCEOYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 결재라인에서 중간단계에 CEO가 있는지 조회한다.
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchApproveCEOYnRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchApproveCEOYnRSQL").append("\n"); 
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
		query.append("    SELECT" ).append("\n"); 
		query.append("        CASE WHEN SUM(DECODE(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'N',0,1)) > 0 THEN 'N'" ).append("\n"); 
		query.append("             ELSE 'Y'" ).append("\n"); 
		query.append("             END AS CEO_YN" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("              COUNT(R.APRO_RQST_SEQ) OVER (PARTITION BY R.APRO_RQST_NO) KNT" ).append("\n"); 
		query.append("            , DENSE_RANK() OVER (PARTITION BY R.APRO_RQST_NO ORDER BY R.APRO_RQST_SEQ DESC) RNK" ).append("\n"); 
		query.append("            , R.APRO_USR_ID" ).append("\n"); 
		query.append("            , R.APRO_USR_NM" ).append("\n"); 
		query.append("        FROM FMS_CONSULTATION A, COM_APRO_RQST_HDR H, COM_APRO_CSR_DTL D, COM_APRO_RQST_ROUT R " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = D.CSR_NO" ).append("\n"); 
		query.append("        AND H.APRO_RQST_NO = D.APRO_RQST_NO" ).append("\n"); 
		query.append("        AND H.APRO_RQST_NO = R.APRO_RQST_NO" ).append("\n"); 
		query.append("        AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("    ) X" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND X.RNK <> 1" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationConsultationDBDAOChkLoclAmtAPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.05.15 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOChkLoclAmtAPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP인 경우
	  * ERP로 보내기 전 금액 검증 조회
	  * </pre>
	  */
	public JointOperationConsultationDBDAOChkLoclAmtAPRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOChkLoclAmtAPRSQL").append("\n"); 
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
		query.append("CASE WHEN COUNT(1) > 0 THEN 'Y'" ).append("\n"); 
		query.append("     ELSE 'N'" ).append("\n"); 
		query.append("     END AS DOU_PAY_CHK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    A.CSR_NO, MAX(CSR_LOCL_AMT) CSR_LOCL_AMT, SUM(CSR_AMT) CSR_AMT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT AP.CSR_NO, A.CSR_LOCL_AMT, AP.CSR_AMT " ).append("\n"); 
		query.append("        FROM JOO_CSR A, AP_INV_HDR AP" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||SUBSTR(A.SLP_ISS_DT,3,8)||A.SLP_SER_NO = AP.CSR_NO" ).append("\n"); 
		query.append("        AND AP.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    GROUP BY A.CSR_NO" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CSR_LOCL_AMT <> CSR_AMT" ).append("\n"); 

	}
}
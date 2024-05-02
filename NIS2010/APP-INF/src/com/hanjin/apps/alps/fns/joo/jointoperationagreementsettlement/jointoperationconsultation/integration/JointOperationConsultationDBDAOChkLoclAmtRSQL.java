/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationConsultationDBDAOChkLoclAmtRSQL.java
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

public class JointOperationConsultationDBDAOChkLoclAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이중 결재 여부 조사(2015.05.12)
	  * </pre>
	  */
	public JointOperationConsultationDBDAOChkLoclAmtRSQL(){
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
		query.append("FileName : JointOperationConsultationDBDAOChkLoclAmtRSQL").append("\n"); 
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
		query.append("    A.SLP_NO, MAX(CSR_LOCL_AMT) CSR_LOCL_AMT, SUM(LOCL_AMT) LOCL_AMT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT J.SLP_NO, A.CSR_LOCL_AMT, J.LOCL_AMT " ).append("\n"); 
		query.append("        FROM JOO_CSR A, JOO_AR_MN J" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||SUBSTR(A.SLP_ISS_DT,3,8)||A.SLP_SER_NO = J.SLP_NO" ).append("\n"); 
		query.append("        AND J.SLP_NO = @[csr_no]" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    GROUP BY A.SLP_NO" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CSR_LOCL_AMT <> LOCL_AMT" ).append("\n"); 

	}
}
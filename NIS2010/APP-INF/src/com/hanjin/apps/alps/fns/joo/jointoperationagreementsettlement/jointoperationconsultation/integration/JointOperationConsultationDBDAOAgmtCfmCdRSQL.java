/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationConsultationDBDAOAgmtCfmCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.03.18 민정호
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

public class JointOperationConsultationDBDAOAgmtCfmCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR No.로 Agreement Doc 존재여부를 조회한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOAgmtCfmCdRSQL(){
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
		query.append("FileName : JointOperationConsultationDBDAOAgmtCfmCdRSQL").append("\n"); 
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
		query.append("CASE WHEN (" ).append("\n"); 
		query.append("            SELECT CASE WHEN COUNT(1) > 0 THEN 1" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                        END AGMT_CNT            " ).append("\n"); 
		query.append("            FROM JOO_CSR_AGMT_DOC A" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("           ) > 0 THEN 'Y'" ).append("\n"); 
		query.append("     ELSE" ).append("\n"); 
		query.append("        CASE WHEN (" ).append("\n"); 
		query.append("                        SELECT CASE WHEN COUNT(1) > 0 THEN 1" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                            END AGMT_CNT            " ).append("\n"); 
		query.append("                        FROM JOO_CSR_ATCH_FILE A" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND    A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                        AND    A.JO_AGMT_FILE_TP_CD = 'C' /*C:Contract, G:General*/" ).append("\n"); 
		query.append("                   ) > 0 THEN 'A'" ).append("\n"); 
		query.append("              ELSE 'N'     " ).append("\n"); 
		query.append("              END" ).append("\n"); 
		query.append("     END AGMT_CNT_YN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
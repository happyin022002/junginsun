/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOGWDocMrgVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.08 민정호
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

public class JointOperationConsultationDBDAOGWDocMrgVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GW Contract Link정보를 생성한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOGWDocMrgVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOGWDocMrgVOCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_CSR_AGMT_DOC" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" CSR_NO" ).append("\n"); 
		query.append(",CSR_AGMT_DOC_SEQ " ).append("\n"); 
		query.append(",AGMT_DOC_NO " ).append("\n"); 
		query.append(",AGMT_DOC_DESC" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" @[csr_no] AS CSR_NO" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(CSR_AGMT_DOC_SEQ),0)+1 FROM JOO_CSR_AGMT_DOC WHERE CSR_NO = @[csr_no]) AS CSR_AGMT_DOC_SEQ " ).append("\n"); 
		query.append(",@[agmt_doc_no] AS AGMT_DOC_NO " ).append("\n"); 
		query.append(",@[agmt_doc_desc] AS AGMT_DOC_DESC" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[cre_usr_id] AS CRE_USR_ID " ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[cre_usr_id] AS UPD_USR_ID " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationConsultationDBDAOJooStlCmbClearCsrNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
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

public class JointOperationConsultationDBDAOJooStlCmbClearCsrNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_STL_CMB에 CSR #를 clear시킨다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOJooStlCmbClearCsrNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOJooStlCmbClearCsrNoUSQL").append("\n"); 
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
		query.append("UPDATE JOO_INVOICE" ).append("\n"); 
		query.append("SET    SLP_TP_CD   = NULL," ).append("\n"); 
		query.append("       SLP_FUNC_CD = NULL," ).append("\n"); 
		query.append("       SLP_OFC_CD  = NULL," ).append("\n"); 
		query.append("       SLP_ISS_DT  = NULL," ).append("\n"); 
		query.append("       SLP_SER_NO  = NULL," ).append("\n"); 
		query.append("       UPD_DT      = SYSDATE," ).append("\n"); 
		query.append("       UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE  SLP_TP_CD || SLP_FUNC_CD || SLP_OFC_CD  || SLP_ISS_DT  || SLP_SER_NO  = @[csr_no]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOTaxDtlDelByCsrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.02 
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

public class JointOperationConsultationDBDAOTaxDtlDelByCsrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR번호로 JOO_TAX_DTL을 삭제
	  * </pre>
	  */
	public JointOperationConsultationDBDAOTaxDtlDelByCsrDSQL(){
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
		query.append("FileName : JointOperationConsultationDBDAOTaxDtlDelByCsrDSQL").append("\n"); 
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
		query.append("DELETE JOO_TAX_DTL" ).append("\n"); 
		query.append("WHERE  (TAX_INV_YRMON, OFC_CD, TAX_SER_NO) IN (" ).append("\n"); 
		query.append("SELECT TAX_INV_YRMON, OFC_CD, TAX_SER_NO" ).append("\n"); 
		query.append("FROM   JOO_TAX" ).append("\n"); 
		query.append("WHERE  SLP_TP_CD || SLP_FUNC_CD  || SLP_OFC_CD  || SLP_ISS_DT || SLP_SER_NO  = @[csr_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
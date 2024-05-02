/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSlpProcNextTaxSerNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.08.04 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSlpProcNextTaxSerNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_TAX의 tax_ser_no 채번한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSlpProcNextTaxSerNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_inv_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSlpProcNextTaxSerNoRSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC(A XPKJOO_TAX)*/" ).append("\n"); 
		query.append("LPAD(TO_NUMBER(A.TAX_SER_NO)+1,5,'0') AS TAX_SER_NO" ).append("\n"); 
		query.append("FROM   JOO_TAX A" ).append("\n"); 
		query.append("WHERE  A.TAX_INV_YRMON = @[tax_inv_yrmon]" ).append("\n"); 
		query.append("AND    A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}
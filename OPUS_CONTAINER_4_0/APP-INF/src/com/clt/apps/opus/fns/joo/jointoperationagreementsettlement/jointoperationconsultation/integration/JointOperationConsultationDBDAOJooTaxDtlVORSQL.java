/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOJooTaxDtlVORSQL.java
*@FileTitle : AP CSR Creation Evidence PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.15 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOJooTaxDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * joo_tax_dtl 조회
	  * </pre>
	  */
	public JointOperationConsultationDBDAOJooTaxDtlVORSQL(){
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
		params.put("tax_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("TAX_INV_YRMON" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",TAX_SER_NO" ).append("\n"); 
		query.append(",TAX_SEQ" ).append("\n"); 
		query.append(",ITM_NM" ).append("\n"); 
		query.append(",SPL_AMT" ).append("\n"); 
		query.append(",TAX_AMT" ).append("\n"); 
		query.append(",TTL_AMT" ).append("\n"); 
		query.append(",TO_CHAR(CRE_DT,'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(UPD_DT,'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append("FROM JOO_TAX_DTL" ).append("\n"); 
		query.append("WHERE TAX_INV_YRMON = @[tax_inv_yrmon]" ).append("\n"); 
		query.append("AND   OFC_CD        = @[ofc_cd]" ).append("\n"); 
		query.append("AND   TAX_SER_NO    = @[tax_ser_no]" ).append("\n"); 
		query.append("ORDER BY TAX_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration ").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOJooTaxDtlVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
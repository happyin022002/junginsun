/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOJooTaxVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.07 
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

public class JointOperationConsultationDBDAOJooTaxVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Joo_tax 조회
	  * </pre>
	  */
	public JointOperationConsultationDBDAOJooTaxVORSQL(){
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
		query.append("FileName : JointOperationConsultationDBDAOJooTaxVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" TAX_INV_YRMON" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",TAX_SER_NO" ).append("\n"); 
		query.append(",TAX_VAT_TP_CD" ).append("\n"); 
		query.append(",TAX_DIV_CD" ).append("\n"); 
		query.append(",TAX_PL_CD" ).append("\n"); 
		query.append(",JO_XCH_RT" ).append("\n"); 
		query.append(",SPL_AMT" ).append("\n"); 
		query.append(",TAX_AMT" ).append("\n"); 
		query.append(",TTL_AMT" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",SPL_RGST_NO" ).append("\n"); 
		query.append(",OWNR_NM" ).append("\n"); 
		query.append(",CO_NM" ).append("\n"); 
		query.append(",SPL_ADDR" ).append("\n"); 
		query.append(",BZCT_NM" ).append("\n"); 
		query.append(",BZTP_NM" ).append("\n"); 
		query.append(",BLNK_KNT" ).append("\n"); 
		query.append(",FA_FLG" ).append("\n"); 
		query.append(",TAX_NAID_FLG" ).append("\n"); 
		query.append(",TAX_NSL_FLG" ).append("\n"); 
		query.append(",TO_CHAR(ISS_DT,'YYYYMMDD') AS ISS_DT" ).append("\n"); 
		query.append(",SLP_TP_CD" ).append("\n"); 
		query.append(",SLP_FUNC_CD" ).append("\n"); 
		query.append(",SLP_OFC_CD" ).append("\n"); 
		query.append(",SLP_ISS_DT" ).append("\n"); 
		query.append(",SLP_SER_NO" ).append("\n"); 
		query.append(",TO_CHAR(CRE_DT,'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(UPD_DT,'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",DOC_EVID_TP_CD" ).append("\n"); 
		query.append("FROM  JOO_TAX A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO = @[csr_no]" ).append("\n"); 

	}
}
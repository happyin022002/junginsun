/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOChargeForAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.02 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOChargeForAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeForAuditVO
	  * </pre>
	  */
	public DaoNameDAOChargeForAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.integration").append("\n"); 
		query.append("FileName : DaoNameDAOChargeForAuditRSQL").append("\n"); 
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
		query.append("SELECT '' LOAD_OPTION" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' AUDIT_RESULT" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' T_FROM_DT" ).append("\n"); 
		query.append(",'' CAL_FROM_DT" ).append("\n"); 
		query.append(",'' T_TO_DT" ).append("\n"); 
		query.append(",'' CAL_TO_DT" ).append("\n"); 
		query.append(",'' T_FT_END" ).append("\n"); 
		query.append(",'' CAL_FT_END" ).append("\n"); 
		query.append(",'' T_OVER" ).append("\n"); 
		query.append(",'' CAL_OVER" ).append("\n"); 
		query.append(",'' T_COLLECTION" ).append("\n"); 
		query.append(",'' CAL_COLLECTION" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' FT_CMNC_DT" ).append("\n"); 
		query.append(",'' FT_DYS" ).append("\n"); 
		query.append(",'' SC_NO" ).append("\n"); 
		query.append(",'' RFA_NO" ).append("\n"); 
		query.append(",'' EXCEPTION_AMT" ).append("\n"); 
		query.append(",'' AFT_EXPT_AMT" ).append("\n"); 
		query.append(",'' VVD" ).append("\n"); 
		query.append(",'' VESSEL" ).append("\n"); 
		query.append(",'' VOYAGE" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
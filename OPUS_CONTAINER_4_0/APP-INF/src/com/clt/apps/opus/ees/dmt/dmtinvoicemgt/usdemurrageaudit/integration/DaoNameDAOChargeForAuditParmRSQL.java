/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOChargeForAuditParmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.02 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOChargeForAuditParmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeForAuditParmVO
	  * </pre>
	  */
	public DaoNameDAOChargeForAuditParmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.integration").append("\n"); 
		query.append("FileName : DaoNameDAOChargeForAuditParmRSQL").append("\n"); 
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
		query.append("'' P_LOAD_INPUT" ).append("\n"); 
		query.append(",'' P_LOAD_OPT_INPUT" ).append("\n"); 
		query.append(",'' P_OFC_CD" ).append("\n"); 
		query.append(",'' P_DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' P_FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' T_FROM_DT" ).append("\n"); 
		query.append(",'' T_TO_DT" ).append("\n"); 
		query.append(",'' T_FT_END" ).append("\n"); 
		query.append(",'' T_OVER" ).append("\n"); 
		query.append(",'' T_COLLECTION" ).append("\n"); 
		query.append(",'' VVD" ).append("\n"); 
		query.append(",'' VESSEL" ).append("\n"); 
		query.append(",'' VOYAGE" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
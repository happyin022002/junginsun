/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSetupDBDAOSearchCntrTpSzListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOSearchCntrTpSzListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ACMSetupDBDAOSearchCntrTpSzListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAOSearchCntrTpSzListRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_DESC" ).append("\n"); 
		query.append("  FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append(" WHERE NVL (DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT INTG_CD_VAL_CTNT AS CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("       INTG_CD_VAL_DP_DESC AS CNTR_TPSZ_DESC " ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND INTG_CD_ID = 'CD03155'" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}
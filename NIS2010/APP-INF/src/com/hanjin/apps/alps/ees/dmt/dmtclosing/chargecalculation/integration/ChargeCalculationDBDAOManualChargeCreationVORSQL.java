/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOManualChargeCreationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.14 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOManualChargeCreationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualChargeCreationVO
	  * </pre>
	  */
	public ChargeCalculationDBDAOManualChargeCreationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOManualChargeCreationVORSQL").append("\n"); 
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
		query.append("'' CNTR_NO" ).append("\n"); 
		query.append(",	'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	'' FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",	'' FM_MVMT_DT" ).append("\n"); 
		query.append(",	'' BKG_NO" ).append("\n"); 
		query.append(",	'' BL_NO" ).append("\n"); 
		query.append(",	'' VVD_CD" ).append("\n"); 
		query.append(",	'' VPS_ETA_DT" ).append("\n"); 
		query.append(",	'' SVR_ID" ).append("\n"); 
		query.append(",	'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",	'' AR_ACT_CD" ).append("\n"); 
		query.append(",	'' CNEE_CD" ).append("\n"); 
		query.append(",	'' NTFY_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
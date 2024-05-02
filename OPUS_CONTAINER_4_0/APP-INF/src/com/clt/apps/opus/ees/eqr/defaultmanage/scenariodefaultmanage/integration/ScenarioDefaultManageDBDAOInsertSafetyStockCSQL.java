/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDAOInsertSafetyStockCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.14 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOInsertSafetyStockCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SafetyStock insert문
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOInsertSafetyStockCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration ").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOInsertSafetyStockCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_ECC_SFT_STK" ).append("\n"); 
		query.append("( ECC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SFSTK_LVL_CD" ).append("\n"); 
		query.append(",SFSTK_VOL_QTY" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT," ).append("\n"); 
		query.append(",UPD_USR_ID," ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[ecc_cd]" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",@[sfstk_lvl_cd]" ).append("\n"); 
		query.append(",@[sfstk_vol_qty]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE)" ).append("\n"); 

	}
}

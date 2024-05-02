/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDAODeleteSafetyStockDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.14 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAODeleteSafetyStockDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SafetyStock DELETE
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAODeleteSafetyStockDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration ").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAODeleteSafetyStockDSQL").append("\n"); 
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
		query.append("DELETE FROM EQR_ECC_SFT_STK" ).append("\n"); 
		query.append("WHERE    ECC_CD         = @[ecc_cd]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD   = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND SFSTK_LVL_CD   = @[lvl_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}

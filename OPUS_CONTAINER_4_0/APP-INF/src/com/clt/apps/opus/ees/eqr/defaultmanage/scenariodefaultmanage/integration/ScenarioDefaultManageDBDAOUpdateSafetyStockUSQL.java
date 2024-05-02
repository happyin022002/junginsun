/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOUpdateSafetyStockUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.17 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DBDAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOUpdateSafetyStockUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SafetyStock update
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOUpdateSafetyStockUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfstk_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfstk_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOUpdateSafetyStockUSQL").append("\n"); 
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
		query.append("UPDATE EQR_ECC_SFT_STK" ).append("\n"); 
		query.append("SET  SFSTK_LVL_CD     = @[sfstk_lvl_cd]," ).append("\n"); 
		query.append("SFSTK_VOL_QTY    = @[sfstk_vol_qty]," ).append("\n"); 
		query.append("UPD_USR_ID       = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT           = sysdate" ).append("\n"); 
		query.append("WHERE     ECC_CD          = @[ecc_cd]" ).append("\n"); 
		query.append("AND  CNTR_TPSZ_CD    = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#if (${lvl_cd} != '')" ).append("\n"); 
		query.append("AND  SFSTK_LVL_CD    = @[lvl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}

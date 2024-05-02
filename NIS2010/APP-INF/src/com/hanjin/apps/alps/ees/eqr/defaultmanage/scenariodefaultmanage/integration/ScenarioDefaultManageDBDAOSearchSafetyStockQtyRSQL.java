/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchSafetyStockQtyRSQL.java
*@FileTitle : EQR공통모듈
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.13 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DBDAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchSafetyStockQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너 safety Stock Qty 가져오기
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchSafetyStockQtyRSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfstk_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchSafetyStockQtyRSQL").append("\n"); 
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
		query.append("SELECT SFSTK_VOL_QTY" ).append("\n"); 
		query.append("FROM   EQR_ECC_SFT_STK_BSS" ).append("\n"); 
		query.append("WHERE ECC_CD           = @[ecc_cd]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND SFSTK_LVL_CD = @[sfstk_lvl_cd]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}

/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DailyForecastManageDBDAORemoveMultiOfficeLevelManageDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.04.25 이은섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author EUN-SUP LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAORemoveMultiOfficeLevelManageDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * remove
	  * </pre>
	  */
	public DailyForecastManageDBDAORemoveMultiOfficeLevelManageDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration ").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAORemoveMultiOfficeLevelManageDSQL").append("\n"); 
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
		query.append("DELETE FROM SPC_OFC_LVL" ).append("\n"); 

	}
}
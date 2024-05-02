/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutSlanCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.05.22 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutSlanCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd를 이용해 slan cd를 조회한다.
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutSlanCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutSlanCdRSQL").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("  FROM VSK_VSL_SKD" ).append("\n"); 
		query.append(" WHERE VSL_CD      = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 

	}
}
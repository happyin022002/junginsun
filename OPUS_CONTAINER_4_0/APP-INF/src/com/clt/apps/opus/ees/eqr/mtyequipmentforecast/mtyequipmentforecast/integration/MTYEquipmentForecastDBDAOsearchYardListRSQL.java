/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchYardListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.12.29 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchYardListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ECC내 소속 야드 를 조회한다
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchYardListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchYardListRSQL").append("\n"); 
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
		query.append("C.YD_CD,C.YD_NM" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT A," ).append("\n"); 
		query.append("MDM_LOCATION B," ).append("\n"); 
		query.append("MDM_YARD C" ).append("\n"); 
		query.append("WHERE A.SCC_CD=B.SCC_CD" ).append("\n"); 
		query.append("AND B.LOC_CD = SUBSTR(C.YD_CD,1,5)" ).append("\n"); 
		query.append("AND A.ECC_CD = @[ecc_cd]" ).append("\n"); 
		query.append("ORDER BY C.YD_CD" ).append("\n"); 

	}
}
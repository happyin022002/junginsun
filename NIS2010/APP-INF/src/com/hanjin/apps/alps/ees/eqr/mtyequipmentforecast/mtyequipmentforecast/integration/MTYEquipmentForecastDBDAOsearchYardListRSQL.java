/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchYardListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.06.14 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    C.YD_CD,C.YD_NM " ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT A," ).append("\n"); 
		query.append("     MDM_LOCATION B," ).append("\n"); 
		query.append("     MDM_YARD C" ).append("\n"); 
		query.append("WHERE A.SCC_CD=B.SCC_CD" ).append("\n"); 
		query.append("  AND B.LOC_CD = SUBSTR(C.YD_CD,1,5)" ).append("\n"); 
		query.append("#if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("  AND A.SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("  AND A.ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("  AND A.LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY C.YD_CD" ).append("\n"); 

	}
}
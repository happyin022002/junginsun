/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutFrYdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.11
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.06.11 나상보
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

public class MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutFrYdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd를 이용해 from yard list 를 조회한다.
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutFrYdListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutFrYdListRSQL").append("\n"); 
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
		query.append("WITH ADD_DAY AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.PLN_YR||A.PLN_WK WEEK" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(A.WK_ST_DT , 'YYYYMMDD') - X.REPO_ADD_DYS, 'YYYYMMDD') WK_ST_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(A.WK_END_DT, 'YYYYMMDD') - X.REPO_ADD_DYS, 'YYYYMMDD') WK_END_DT" ).append("\n"); 
		query.append("FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("		SELECT REPO_ADD_DYS" ).append("\n"); 
		query.append("	    FROM" ).append("\n"); 
		query.append("		    (" ).append("\n"); 
		query.append("        		SELECT A.REPO_ADD_DYS" ).append("\n"); 
		query.append("		        FROM EQR_WK_PRD_ADD_DY A," ).append("\n"); 
		query.append("		             (" ).append("\n"); 
		query.append("		                 SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("		                 FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("						 WHERE 1=1" ).append("\n"); 
		query.append("#if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("		                 AND SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("		                 AND ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("		                 AND LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("#end                                  " ).append("\n"); 
		query.append("		             ) B" ).append("\n"); 
		query.append("		        WHERE A.LCC_CD = B.LCC_CD" ).append("\n"); 
		query.append("		        UNION " ).append("\n"); 
		query.append("		        SELECT 0 REPO_ADD_DYS FROM DUAL " ).append("\n"); 
		query.append("	    	    ORDER BY REPO_ADD_DYS DESC  " ).append("\n"); 
		query.append("    		)" ).append("\n"); 
		query.append("		WHERE ROWNUM=1    " ).append("\n"); 
		query.append("    ) X" ).append("\n"); 
		query.append("WHERE A.PLN_YR||A.PLN_WK = @[fcast_yrwk]" ).append("\n"); 
		query.append(")   " ).append("\n"); 
		query.append("SELECT SKD.YD_CD FM_YD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD')||'%%'||SKD.YD_CD FM_ETD_DT" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("      ,ADD_DAY X" ).append("\n"); 
		query.append(" WHERE VSL_CD      = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND VPS_ETD_DT >= TO_DATE(X.WK_ST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("   AND VPS_PORT_CD IN (" ).append("\n"); 
		query.append("                       SELECT A.LOC_CD " ).append("\n"); 
		query.append("                         FROM MDM_LOCATION A " ).append("\n"); 
		query.append("                        WHERE EXISTS (" ).append("\n"); 
		query.append("                                      SELECT 1 " ).append("\n"); 
		query.append("                                        FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("                                       WHERE SCC_CD = A.SCC_CD" ).append("\n"); 
		query.append("#if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                                         AND SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                                         AND ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                                         AND LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                     )        " ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append(" ORDER BY FM_ETD_DT" ).append("\n"); 

	}
}
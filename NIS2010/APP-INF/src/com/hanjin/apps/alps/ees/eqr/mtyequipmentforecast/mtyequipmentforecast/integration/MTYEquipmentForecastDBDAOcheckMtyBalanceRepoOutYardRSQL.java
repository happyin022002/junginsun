/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOcheckMtyBalanceRepoOutYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.18
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.12.18 나상보
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

public class MTYEquipmentForecastDBDAOcheckMtyBalanceRepoOutYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * T/D VVD 가 아닌 경우 입력된 yard code가 해당 ecc/lcc/scc에 포함되는지 체크한다.
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOcheckMtyBalanceRepoOutYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOcheckMtyBalanceRepoOutYardRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CD" ).append("\n"); 
		query.append("FROM MDM_YARD A " ).append("\n"); 
		query.append("WHERE A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if(${to_yd_cd} != '')" ).append("\n"); 
		query.append("AND   A.YD_CD LIKE @[to_yd_cd]||'%'" ).append("\n"); 
		query.append("#elseif(${fm_yd_cd} != '')" ).append("\n"); 
		query.append("AND   A.YD_CD LIKE @[fm_yd_cd]||'%'" ).append("\n"); 
		query.append("AND   A.LOC_CD IN (" ).append("\n"); 
		query.append("                      SELECT A.LOC_CD " ).append("\n"); 
		query.append("                      FROM MDM_LOCATION A " ).append("\n"); 
		query.append("                      WHERE EXISTS (" ).append("\n"); 
		query.append("                                      SELECT 1 " ).append("\n"); 
		query.append("                                      FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("                                      WHERE SCC_CD = A.SCC_CD" ).append("\n"); 
		query.append("#if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                                         AND SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                                         AND ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                                         AND LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   )        " ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LocationDBDAOsearchEqOrgChtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOsearchEqOrgChtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Equipment ORG Chart를 조회합니다.
	  * </pre>
	  */
	public LocationDBDAOsearchEqOrgChtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOsearchEqOrgChtRSQL").append("\n"); 
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
		query.append("SELECT  ROW_NUMBER() OVER (ORDER BY RCC_CD, LCC_CD, ECC_CD, SCC_CD) AS SEQ," ).append("\n"); 
		query.append("        RCC_CD," ).append("\n"); 
		query.append("        LCC_CD," ).append("\n"); 
		query.append("        ECC_CD," ).append("\n"); 
		query.append("        SCC_CD," ).append("\n"); 
		query.append("        DELT_FLG," ).append("\n"); 
		query.append("        TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT," ).append("\n"); 
		query.append("        CRE_USR_ID" ).append("\n"); 
		query.append("  FROM  MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("#if(${delt_flg} != '')" ).append("\n"); 
		query.append("   AND  DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${loc_type} == 'R')" ).append("\n"); 
		query.append("   AND  RCC_CD IN (" ).append("\n"); 
		query.append("#foreach($key in ${arr_location})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_location.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${loc_type} == 'L')" ).append("\n"); 
		query.append("   AND  LCC_CD IN (" ).append("\n"); 
		query.append("#foreach($key in ${arr_location})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_location.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${loc_type} == 'E')" ).append("\n"); 
		query.append("   AND  ECC_CD IN (" ).append("\n"); 
		query.append("#foreach($key in ${arr_location})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_location.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${loc_type} == 'S')" ).append("\n"); 
		query.append("   AND  SCC_CD IN (" ).append("\n"); 
		query.append("#foreach($key in ${arr_location})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_location.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
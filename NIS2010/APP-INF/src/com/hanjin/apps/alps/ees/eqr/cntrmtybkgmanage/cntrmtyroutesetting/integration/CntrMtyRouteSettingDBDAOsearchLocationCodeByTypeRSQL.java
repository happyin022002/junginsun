/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyRouteSettingDBDAOsearchLocationCodeByTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyRouteSettingDBDAOsearchLocationCodeByTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CntrMtyRouteSettingDBDAOsearchLocationCodeByType
	  * </pre>
	  */
	public CntrMtyRouteSettingDBDAOsearchLocationCodeByTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcccd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loccd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration").append("\n"); 
		query.append("FileName : CntrMtyRouteSettingDBDAOsearchLocationCodeByTypeRSQL").append("\n"); 
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
		query.append("WITH RCC_INFO AS " ).append("\n"); 
		query.append("(SELECT A.RCC_CD" ).append("\n"); 
		query.append("   FROM MDM_EQ_ORZ_CHT A, MDM_LOCATION B" ).append("\n"); 
		query.append("  WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("    AND B.LOC_CD = @[loccd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  COUNT(1) CNT " ).append("\n"); 
		query.append(" FROM RCC_INFO" ).append("\n"); 
		query.append("#if(${rcccd} != 'ALL') " ).append("\n"); 
		query.append(" WHERE RCC_CD = @[rcccd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
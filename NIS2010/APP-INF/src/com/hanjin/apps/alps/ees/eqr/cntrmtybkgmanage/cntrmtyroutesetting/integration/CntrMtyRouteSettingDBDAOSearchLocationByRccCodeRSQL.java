/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyRouteSettingDBDAOSearchLocationByRccCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
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

public class CntrMtyRouteSettingDBDAOSearchLocationByRccCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CntrMtyRouteSettingDBDAOSearchLocationByRccCode
	  * </pre>
	  */
	public CntrMtyRouteSettingDBDAOSearchLocationByRccCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loccd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration").append("\n"); 
		query.append("FileName : CntrMtyRouteSettingDBDAOSearchLocationByRccCodeRSQL").append("\n"); 
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
		query.append("SELECT A.RCC_CD RCC" ).append("\n"); 
		query.append("   FROM MDM_EQ_ORZ_CHT A, MDM_LOCATION B" ).append("\n"); 
		query.append("  WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("    AND B.LOC_CD = @[loccd]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchNodCdForOffHireRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchNodCdForOffHireRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Off-Hire일 경우 Grid의 Node  ComboBox Data Search
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchNodCdForOffHireRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchNodCdForOffHireRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SUBSTR(A.YD_CD,6) NOD_CD " ).append("\n"); 
		query.append("      ,A.YARD_TYPE" ).append("\n"); 
		query.append(" FROM (SELECT 'M' AS YARD_TYPE" ).append("\n"); 
		query.append("              ,A.YD_CD" ).append("\n"); 
		query.append("              ,A.OFC_CD" ).append("\n"); 
		query.append("         FROM  MDM_YARD A" ).append("\n"); 
		query.append("              ,MDM_LOCATION B" ).append("\n"); 
		query.append("         WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("           AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("           AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT 'L' AS YARD_TYPE" ).append("\n"); 
		query.append("              ,A.LSE_CO_YD_CD AS YD_CD" ).append("\n"); 
		query.append("              ,B.EQ_CTRL_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("         FROM MDM_LSE_CO_YD A" ).append("\n"); 
		query.append("             ,MDM_LOCATION B" ).append("\n"); 
		query.append("        WHERE A.LSE_CO_YD_CD NOT IN ( SELECT YD_CD " ).append("\n"); 
		query.append("                                        FROM MDM_YARD " ).append("\n"); 
		query.append("                                       WHERE DELT_FLG <> 'Y' )" ).append("\n"); 
		query.append("          AND A.LSE_CO_YD_CD LIKE B.LOC_CD||'%' " ).append("\n"); 
		query.append("          AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.YD_CD LIKE @[loc_cd]||'%'  " ).append("\n"); 
		query.append(" ORDER BY SUBSTR(A.YD_CD,6)" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchExceptionDeleteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchExceptionDeleteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMTCalculationDBDAOSearchExceptionDeleteRSQL
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchExceptionDeleteRSQL(){
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
		params.put("to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchExceptionDeleteRSQL").append("\n"); 
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
		query.append("SELECT 'Y' cal_fg" ).append("\n"); 
		query.append("FROM DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'EXCEPTION_DELETE'" ).append("\n"); 
		query.append("AND ( NVL(ATTR_CTNT2, '') = SUBSTR(@[fm_yd_cd],1,2)" ).append("\n"); 
		query.append("    OR NVL(ATTR_CTNT1, '') = ( SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("            					 FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("            					WHERE   CO_IND_CD = 'H'" ).append("\n"); 
		query.append("              					  AND   CNT_CD = SUBSTR(@[fm_yd_cd],1,2) ) )" ).append("\n"); 
		query.append("AND ATTR_CTNT10 <= SUBSTR(NVL(@[to_mvmt_dt],ATTR_CTNT10),1,8)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOT EXISTS ( SELECT 'X' FROM DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND HRD_CDG_ID = 'EXCEPTION_DELETE'" ).append("\n"); 
		query.append("                    AND NVL(ATTR_CTNT4, '') = SUBSTR(@[fm_yd_cd],1,5)" ).append("\n"); 
		query.append("                    AND NVL(ATTR_CTNT3, '') = 'N'" ).append("\n"); 
		query.append("					AND ROWNUM = 1 )" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'Y' cal_fg" ).append("\n"); 
		query.append("FROM DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'EXCEPTION_DELETE'" ).append("\n"); 
		query.append("AND NVL(ATTR_CTNT4, '') = SUBSTR(@[fm_yd_cd],1,5)" ).append("\n"); 
		query.append("AND NVL(ATTR_CTNT3, '') = 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchEqrLocYardLccInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchEqrLocYardLccInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lcc Yard Info Search
	  * </pre>
	  */
	public CommonDBDAOSearchEqrLocYardLccInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locfmyard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loctoyard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOSearchEqrLocYardLccInfoRSQL").append("\n"); 
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
		query.append("	DECODE(FY.CHK_FLG||TY.CHK_FLG||DECODE(FY.LCC_CD, TY.LCC_CD, 'Y', 'N'), 'YYY', 'Y', 'N') AS YARD_YN" ).append("\n"); 
		query.append("FROM (SELECT " ).append("\n"); 
		query.append("		'Y' AS CHK_FLG" ).append("\n"); 
		query.append("        , ME.LCC_CD  LCC_CD" ).append("\n"); 
		query.append("     FROM MDM_YARD  MY" ).append("\n"); 
		query.append("     	  ,MDM_LOCATION ML" ).append("\n"); 
		query.append("          ,MDM_EQ_ORZ_CHT ME" ).append("\n"); 
		query.append("     WHERE  MY.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         AND    SUBSTR(MY.YD_CD, 1, 5) = ML.LOC_CD" ).append("\n"); 
		query.append("         AND    ML.SCC_CD                 = ME.SCC_CD" ).append("\n"); 
		query.append("         AND    MY.YD_CD                  = NVL(@[locfmyard], @[loctoyard])  -- NVL(:fm_yd_cd, :to_yd_cd)" ).append("\n"); 
		query.append("         AND    ROWNUM                  = 1) FY" ).append("\n"); 
		query.append("     , (SELECT " ).append("\n"); 
		query.append("			'Y' AS CHK_FLG" ).append("\n"); 
		query.append("            , ME.LCC_CD LCC_CD              " ).append("\n"); 
		query.append("        FROM MDM_YARD  MY" ).append("\n"); 
		query.append("             ,MDM_LOCATION ML" ).append("\n"); 
		query.append("             ,MDM_EQ_ORZ_CHT ME" ).append("\n"); 
		query.append("        WHERE MY.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         	AND    SUBSTR(MY.YD_CD, 1, 5) = ML.LOC_CD" ).append("\n"); 
		query.append("         	AND    ML.SCC_CD                 = ME.SCC_CD" ).append("\n"); 
		query.append("         	AND    MY.YD_CD                  = NVL(@[loctoyard], @[locfmyard])  -- NVL(:to_yd_cd, :fm_yd_cd)" ).append("\n"); 
		query.append("         	AND    ROWNUM                  = 1) TY" ).append("\n"); 
		query.append("         " ).append("\n"); 

	}
}
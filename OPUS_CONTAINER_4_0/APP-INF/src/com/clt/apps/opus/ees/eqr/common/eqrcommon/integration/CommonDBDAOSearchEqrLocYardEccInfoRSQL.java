/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchEqrLocYardEccInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchEqrLocYardEccInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eqr Yard search
	  * </pre>
	  */
	public CommonDBDAOSearchEqrLocYardEccInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locyard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchEqrLocYardEccInfoRSQL").append("\n"); 
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
		query.append("SELECT  YD_CD  , REPLACE(YD_NM, '''', ' ') YD_NM  " ).append("\n"); 
		query.append("FROM MDM_YARD                     " ).append("\n"); 
		query.append("WHERE  DELT_FLG <> 'Y'           " ).append("\n"); 
		query.append("AND LOC_CD IN (                 " ).append("\n"); 
		query.append("	SELECT EOC.SCC_CD    " ).append("\n"); 
		query.append("    FROM MDM_EQ_ORZ_CHT EOC" ).append("\n"); 
		query.append("    WHERE EOC.LCC_CD LIKE @[locyard]||'%'" ).append("\n"); 
		query.append("    AND EOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND EOC.RCC_CD = (SELECT SUB.RCC_CD" ).append("\n"); 
		query.append("                      FROM MDM_ORGANIZATION MO, MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append("                      WHERE MO.OFC_CD    =@[off_cd]" ).append("\n"); 
		query.append("                      AND MO.LOC_CD    = SUB.SCC_CD" ).append("\n"); 
		query.append("                      AND SUB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      AND ROWNUM = 1)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("ORDER BY YD_CD" ).append("\n"); 

	}
}
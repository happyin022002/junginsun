/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PercentBaseChargeDBDAOSearchPercentBaseChargeRSQL.java
*@FileTitle : Percent Base CHG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.02 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PercentBaseChargeDBDAOSearchPercentBaseChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PCT_BSE
	  * </pre>
	  */
	public PercentBaseChargeDBDAOSearchPercentBaseChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.integration ").append("\n"); 
		query.append("FileName : PercentBaseChargeDBDAOSearchPercentBaseChargeRSQL").append("\n"); 
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
		query.append("SELECT BSE.PCT_BSE_CD" ).append("\n"); 
		query.append("     , BSE.PATT_DESC" ).append("\n"); 
		query.append("     , BSE.DP_SEQ" ).append("\n"); 
		query.append("     , NVL2(PRF.PCT_BSE_CD ,'Y','N') PRI_SCG_PRF_USE_YN" ).append("\n"); 
		query.append("     , (SELECT MAX(PCT_BSE_CD)" ).append("\n"); 
		query.append("          FROM PRI_SCG_PCT_BSE" ).append("\n"); 
		query.append("       ) MAX_PCT_BSE_CD    " ).append("\n"); 
		query.append("FROM   PRI_SCG_PCT_BSE BSE" ).append("\n"); 
		query.append("     , (SELECT DISTINCT PCT_BSE_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_PRF" ).append("\n"); 
		query.append("       ) PRF" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND  BSE.PCT_BSE_CD = PRF.PCT_BSE_CD(+)" ).append("\n"); 
		query.append("AND  BSE.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}
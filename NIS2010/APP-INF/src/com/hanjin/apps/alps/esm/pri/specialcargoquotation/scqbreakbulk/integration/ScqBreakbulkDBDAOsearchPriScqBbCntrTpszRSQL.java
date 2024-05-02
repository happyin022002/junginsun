/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScqBreakbulkDBDAOsearchPriScqBbCntrTpszRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.06.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOsearchPriScqBbCntrTpszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPriScqBbCntrTpsz
	  * </pre>
	  */
	public ScqBreakbulkDBDAOsearchPriScqBbCntrTpszRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOsearchPriScqBbCntrTpszRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD CD" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD NM" ).append("\n"); 
		query.append("  FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND CNTR_TP_CD IN('A','F','O','P','S','Q')" ).append("\n"); 
		query.append("   AND CNTR_SZ_CD IN('2','4','5')" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD <> 'A2'" ).append("\n"); 
		query.append(" ORDER BY CD" ).append("\n"); 

	}
}
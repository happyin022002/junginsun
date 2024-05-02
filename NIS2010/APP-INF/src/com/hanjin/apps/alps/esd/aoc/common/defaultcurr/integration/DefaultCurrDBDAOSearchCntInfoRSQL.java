/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DefaultCurrDBDAOSearchCntInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.10.09 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DefaultCurrDBDAOSearchCntInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntInfo
	  * </pre>
	  */
	public DefaultCurrDBDAOSearchCntInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration").append("\n"); 
		query.append("FileName : DefaultCurrDBDAOSearchCntInfoRSQL").append("\n"); 
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
		query.append("SELECT B.CNT_NM" ).append("\n"); 
		query.append("      ,D.CONTI_NM" ).append("\n"); 
		query.append("      ,C.SCONTI_NM" ).append("\n"); 
		query.append("      ,B.EU_CNT_FLG" ).append("\n"); 
		query.append("      ,DECODE(E.DELT_FLG, 'Y', 'EUR', B.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(E.DELT_FLG, 'Y', 'Euro', E.CURR_NM) CURR_NM" ).append("\n"); 
		query.append("  FROM MDM_COUNTRY       B" ).append("\n"); 
		query.append("      ,MDM_SUBCONTINENT  C" ).append("\n"); 
		query.append("      ,MDM_CONTINENT     D" ).append("\n"); 
		query.append("      ,MDM_CURRENCY      E" ).append("\n"); 
		query.append(" WHERE B.SCONTI_CD = C.SCONTI_CD(+)" ).append("\n"); 
		query.append("   AND C.CONTI_CD  = D.CONTI_CD(+)" ).append("\n"); 
		query.append("   AND B.CURR_CD   = E.CURR_CD(+)" ).append("\n"); 
		query.append("   AND B.CNT_CD    = @[cnt_cd]" ).append("\n"); 

	}
}
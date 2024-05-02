/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchCostStupMTAbcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.13
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.12.13 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchCostStupMTAbcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchCostStupMTAbcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchCostStupMTAbcListRSQL").append("\n"); 
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
		query.append("SELECT B.cd itm_cd,B.nm itm_nm,b.srt," ).append("\n"); 
		query.append("       NVL(OTR_EXPN_AMT,0) AS COM_AMT" ).append("\n"); 
		query.append("FROM COA_MNL_COST_STUP A," ).append("\n"); 
		query.append("     (SELECT 'MTYTT' cd,'MTY Reposition Cost'    nm ,1 srt from dual union all" ).append("\n"); 
		query.append("      SELECT 'ABCTT' cd,'Business Activity cost' nm ,2 srt from dual" ).append("\n"); 
		query.append("     ) b" ).append("\n"); 
		query.append("WHERE A.COST_YRMON(+) = @[f_cost_yrmon]" ).append("\n"); 
		query.append("  AND A.RLANE_CD(+)   = B.CD  " ).append("\n"); 
		query.append("  AND A.COST_WK(+) = 'XX' " ).append("\n"); 
		query.append(" ORDER BY SRT" ).append("\n"); 

	}
}
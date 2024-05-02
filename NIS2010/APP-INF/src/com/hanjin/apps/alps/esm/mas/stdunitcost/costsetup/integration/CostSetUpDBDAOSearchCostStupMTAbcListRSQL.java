/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CostSetUpDBDAOSearchCostStupMTAbcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.02
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.10.02 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOSearchCostStupMTAbcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CostSetUpDBDAOSearchCostStupMTAbcListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOSearchCostStupMTAbcListRSQL").append("\n"); 
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
		query.append("FROM MAS_MNL_COST_STUP A," ).append("\n"); 
		query.append("     (SELECT 'MTYTT' cd,'MTY Reposition Cost'    nm ,1 srt from dual union all" ).append("\n"); 
		query.append("      SELECT 'ABCTT' cd,'Business Activity cost' nm ,2 srt from dual union all" ).append("\n"); 
		query.append("      SELECT 'GENTT' cd,'General Expense' nm ,3 srt from dual" ).append("\n"); 
		query.append("     ) b" ).append("\n"); 
		query.append("WHERE A.COST_YRMON(+) = @[f_cost_yrmon]" ).append("\n"); 
		query.append("  AND A.RLANE_CD(+)   = B.CD  " ).append("\n"); 
		query.append("  AND A.COST_WK(+) = 'XX' " ).append("\n"); 
		query.append(" ORDER BY SRT" ).append("\n"); 

	}
}
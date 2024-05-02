/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GenExpenseDBDAOSearchGeneralExpenseVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GenExpenseDBDAOSearchGeneralExpenseVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비를 조회한다.
	  * @ SJH.20140731.MOD : B.CPY_NO -> (B.CPY_NO+1)
	  * </pre>
	  */
	public GenExpenseDBDAOSearchGeneralExpenseVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration").append("\n"); 
		query.append("FileName : GenExpenseDBDAOSearchGeneralExpenseVORSQL").append("\n"); 
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
		query.append("WITH GET_MONTH AS (" ).append("\n"); 
		query.append("SELECT B.CPY_NO" ).append("\n"); 
		query.append("     , @[cost_yrmon] YRMON" ).append("\n"); 
		query.append("     , TO_CHAR(ADD_MONTHS(TO_DATE(@[cost_yrmon], 'YYYYMM'), (B.CPY_NO+1)*-1), 'YYYYMM') COL_YRMON" ).append("\n"); 
		query.append("  FROM DUAL A" ).append("\n"); 
		query.append("     , COM_CPY_NO B" ).append("\n"); 
		query.append(" WHERE B.CPY_NO BETWEEN 0 AND 6" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT MAX(DECODE(CPY_NO, 0, UC_AMT)) UC_AMT" ).append("\n"); 
		query.append("     , MAX(DECODE(CPY_NO, 1, UC_AMT)) YRMON1" ).append("\n"); 
		query.append("     , MAX(DECODE(CPY_NO, 2, UC_AMT)) YRMON2" ).append("\n"); 
		query.append("     , MAX(DECODE(CPY_NO, 3, UC_AMT)) YRMON3" ).append("\n"); 
		query.append("     , MAX(DECODE(CPY_NO, 4, UC_AMT)) YRMON4" ).append("\n"); 
		query.append("     , MAX(DECODE(CPY_NO, 5, UC_AMT)) YRMON5" ).append("\n"); 
		query.append("     , MAX(DECODE(CPY_NO, 6, UC_AMT)) YRMON6" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("SELECT B.CPY_NO" ).append("\n"); 
		query.append("     , B.YRMON" ).append("\n"); 
		query.append("     , B.COL_YRMON" ).append("\n"); 
		query.append("     , NVL(A.UC_AMT, 0) UC_AMT" ).append("\n"); 
		query.append("  FROM COA_DMDT_N3RD_PTY A" ).append("\n"); 
		query.append("     , GET_MONTH B" ).append("\n"); 
		query.append(" WHERE A.COST_YRMON(+) = B.COL_YRMON" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD(+) = 'TEU'" ).append("\n"); 
		query.append("   AND STND_COST_CD(+) = '75000000'" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" GROUP BY YRMON" ).append("\n"); 

	}
}
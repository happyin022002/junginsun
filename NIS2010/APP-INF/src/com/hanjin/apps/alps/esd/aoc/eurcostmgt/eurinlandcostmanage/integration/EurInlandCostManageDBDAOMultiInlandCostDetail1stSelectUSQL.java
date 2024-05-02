/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurInlandCostManageDBDAOMultiInlandCostDetail1stSelectUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.10.04 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurInlandCostManageDBDAOMultiInlandCostDetail1stSelectUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiInlandCostDetail1stSelect
	  * </pre>
	  */
	public EurInlandCostManageDBDAOMultiInlandCostDetail1stSelectUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.integration").append("\n"); 
		query.append("FileName : EurInlandCostManageDBDAOMultiInlandCostDetail1stSelectUSQL").append("\n"); 
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
		query.append("UPDATE  AOC_EUR_INLND_TRF_DTL" ).append("\n"); 
		query.append("   SET  COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append(" WHERE (COST_TRF_NO, COST_TRF_ROUT_SEQ, 1) IN (" ).append("\n"); 
		query.append("                                                 SELECT  COST_TRF_NO" ).append("\n"); 
		query.append("                                                       , COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("                                                       , RANK() OVER(PARTITION BY COST_ROUT_GRP_NO ORDER BY INLND_40FT_TTL_AMT ASC, COST_TRF_ROUT_SEQ) AS RNK" ).append("\n"); 
		query.append("                                                 FROM    AOC_EUR_INLND_TRF_DTL" ).append("\n"); 
		query.append("                                                 WHERE   1 = 1" ).append("\n"); 
		query.append("                                                 AND     COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append("                                                 AND     (COST_ROUT_GRP_NO, 'Y') IN (" ).append("\n"); 
		query.append("#foreach ($user_condtions IN ${condtions})" ).append("\n"); 
		query.append("  #if($velocityCount < $condtions.size())" ).append("\n"); 
		query.append("    $user_condtions," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    $user_condtions" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                                 AND     NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 

	}
}
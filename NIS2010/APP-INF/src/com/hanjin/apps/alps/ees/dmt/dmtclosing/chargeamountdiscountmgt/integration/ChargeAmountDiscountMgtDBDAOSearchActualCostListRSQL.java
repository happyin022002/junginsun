/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchActualCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchActualCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchActualCostList
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchActualCostListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchActualCostListRSQL").append("\n"); 
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
		query.append("#if(${sts_desc} == 'Reason' )" ).append("\n"); 
		query.append("SELECT '1' SEQ," ).append("\n"); 
		query.append("		AFT_BKG_ACT_COST_ITM_NM, " ).append("\n"); 
		query.append("		AFT_BKG_ACT_COST_CURR_CD, " ).append("\n"); 
		query.append("		AFT_BKG_ACT_COST_AMT, " ).append("\n"); 
		query.append("		AFT_BKG_ACT_COST_RMK, " ).append("\n"); 
		query.append("		AFT_BKG_ACT_COST_ITM_LVL" ).append("\n"); 
		query.append("   FROM DMT_AFT_BKG_ACT_COST_RQST A" ).append("\n"); 
		query.append("  WHERE A.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("    AND AFT_BKG_ACT_COST_ITM_LVL in ( 8, 9 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT AFT_BKG_ACT_COST_ITM_NM," ).append("\n"); 
		query.append("AFT_BKG_ACT_COST_CURR_CD," ).append("\n"); 
		query.append("AFT_BKG_ACT_COST_AMT," ).append("\n"); 
		query.append("AFT_BKG_ACT_COST_RMK," ).append("\n"); 
		query.append("AFT_BKG_ACT_COST_ITM_LVL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT RANK () OVER (PARTITION BY AFT_BKG_ACT_COST_ITM_LVL ORDER BY SEQ) AS A_RANK" ).append("\n"); 
		query.append("    , AA.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT '1' SEQ,AFT_BKG_ACT_COST_ITM_NM, AFT_BKG_ACT_COST_CURR_CD, AFT_BKG_ACT_COST_AMT, AFT_BKG_ACT_COST_RMK, B.HRD_CDG_ID_SEQ AFT_BKG_ACT_COST_ITM_LVL" ).append("\n"); 
		query.append("        FROM DMT_AFT_BKG_ACT_COST_RQST A, DMT_HRD_CDG_CTNT B" ).append("\n"); 
		query.append("        WHERE A.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("        AND B.HRD_CDG_ID LIKE 'AFT_BKG_ACTUAL_COST'" ).append("\n"); 
		query.append("        AND B.ATTR_CTNT1 = A.AFT_BKG_ACT_COST_ITM_NM" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT '2' SEQ,ATTR_CTNT1, ATTR_CTNT2, 0, '', HRD_CDG_ID_SEQ" ).append("\n"); 
		query.append("         FROM DMT_HRD_CDG_CTNT " ).append("\n"); 
		query.append("        WHERE HRD_CDG_ID LIKE 'AFT_BKG_ACTUAL_COST'" ).append("\n"); 
		query.append("        ) AA" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE A_RANK = 1" ).append("\n"); 
		query.append("ORDER BY AFT_BKG_ACT_COST_ITM_LVL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
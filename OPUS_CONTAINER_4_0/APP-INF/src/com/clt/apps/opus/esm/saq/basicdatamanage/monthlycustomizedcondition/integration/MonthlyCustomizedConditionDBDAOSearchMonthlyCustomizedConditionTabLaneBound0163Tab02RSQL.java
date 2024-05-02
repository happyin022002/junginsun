/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyCustomizedConditionDBDAOSearchMonthlyCustomizedConditionTabLaneBound0163Tab02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.03.29 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyCustomizedConditionDBDAOSearchMonthlyCustomizedConditionTabLaneBound0163Tab02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bound 리스트   
	  * </pre>
	  */
	public MonthlyCustomizedConditionDBDAOSearchMonthlyCustomizedConditionTabLaneBound0163Tab02RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration").append("\n"); 
		query.append("FileName : MonthlyCustomizedConditionDBDAOSearchMonthlyCustomizedConditionTabLaneBound0163Tab02RSQL").append("\n"); 
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
		query.append("SELECT SAQ_TGT_GRP_CD AS TRADE_GROUP ," ).append("\n"); 
		query.append("  A.TRD_CD," ).append("\n"); 
		query.append("  SUB_TRD_CD," ).append("\n"); 
		query.append("  RLANE_CD," ).append("\n"); 
		query.append("  DIR_CD ," ).append("\n"); 
		query.append("  CONV_DIR_CD" ).append("\n"); 
		query.append("FROM SAQ_MON_DIR_CONV A," ).append("\n"); 
		query.append("  SAQ_TGT_GRP_TRD_V B" ).append("\n"); 
		query.append("WHERE BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("  AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("  AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("ORDER BY SAQ_TGT_GRP_CD, A.TRD_CD, SUB_TRD_CD, RLANE_CD, DECODE(DIR_CD, 'E', '00', 'W', '01', DIR_CD)" ).append("\n"); 

	}
}
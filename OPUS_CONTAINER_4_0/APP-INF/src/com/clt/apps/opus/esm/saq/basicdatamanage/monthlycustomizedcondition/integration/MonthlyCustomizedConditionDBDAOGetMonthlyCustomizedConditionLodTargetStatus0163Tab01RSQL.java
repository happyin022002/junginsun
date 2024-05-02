/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyCustomizedConditionDBDAOGetMonthlyCustomizedConditionLodTargetStatus0163Tab01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.23 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyCustomizedConditionDBDAOGetMonthlyCustomizedConditionLodTargetStatus0163Tab01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * status 조회
	  * </pre>
	  */
	public MonthlyCustomizedConditionDBDAOGetMonthlyCustomizedConditionLodTargetStatus0163Tab01RSQL(){
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
		query.append("FileName : MonthlyCustomizedConditionDBDAOGetMonthlyCustomizedConditionLodTargetStatus0163Tab01RSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_VAL_DESC AS STATUS       " ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL,                 " ).append("\n"); 
		query.append("       (                                " ).append("\n"); 
		query.append("         SELECT DISTINCT COND_STS_CD    " ).append("\n"); 
		query.append("           FROM SAQ_MON_LOD_TGT_OFC     " ).append("\n"); 
		query.append("          WHERE BSE_YR     = @[bse_yr]          " ).append("\n"); 
		query.append("            AND BSE_QTR_CD = @[bse_qtr_cd]  )       " ).append("\n"); 
		query.append(" WHERE INTG_CD_ID       = 'CD01387'     " ).append("\n"); 
		query.append("   AND INTG_CD_VAL_CTNT = COND_STS_CD" ).append("\n"); 

	}
}
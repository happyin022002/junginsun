/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetVO0163Tab01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetVO0163Tab01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Description : Load Target - Regional Group Mapping List Search
	  * </pre>
	  */
	public MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetVO0163Tab01RSQL(){
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
		query.append("FileName : MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetVO0163Tab01RSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT SAQ_TGT_GRP_CD," ).append("\n"); 
		query.append("        A.TRD_CD," ).append("\n"); 
		query.append("        A.DIR_CD," ).append("\n"); 
		query.append("        SLS_RHQ_CD" ).append("\n"); 
		query.append("  FROM  SAQ_TGT_GRP_TRD A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT  TRD_CD," ).append("\n"); 
		query.append("                DIR_CD," ).append("\n"); 
		query.append("                SLS_RHQ_CD" ).append("\n"); 
		query.append("          FROM  SAQ_MON_LOD_TGT_OFC" ).append("\n"); 
		query.append("         WHERE  BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("           AND  BSE_QTR_CD = @[bse_qtr_cd] ) B" ).append("\n"); 
		query.append(" WHERE  A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("   AND  A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("ORDER BY SAQ_TGT_GRP_CD, TRD_CD, DIR_CD" ).append("\n"); 

	}
}
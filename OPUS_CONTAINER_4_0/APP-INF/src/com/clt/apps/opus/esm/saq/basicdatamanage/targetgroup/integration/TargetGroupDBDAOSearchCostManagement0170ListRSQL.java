/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TargetGroupDBDAOSearchCostManagement0170ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TargetGroupDBDAOSearchCostManagement0170ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Management List
	  * </pre>
	  */
	public TargetGroupDBDAOSearchCostManagement0170ListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration").append("\n"); 
		query.append("FileName : TargetGroupDBDAOSearchCostManagement0170ListRSQL").append("\n"); 
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
		query.append("SELECT  A.BSE_YR" ).append("\n"); 
		query.append("       ,A.BSE_QTR_CD" ).append("\n"); 
		query.append("       ,A.COST_DIV_CD" ).append("\n"); 
		query.append("       ,A.COST_DIV_DESC" ).append("\n"); 
		query.append("       ,B.APPL_YR" ).append("\n"); 
		query.append("       ,B.APPL_MON" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  @[bse_yr] AS BSE_YR" ).append("\n"); 
		query.append("               ,@[bse_qtr_cd]   AS BSE_QTR_CD" ).append("\n"); 
		query.append("               ,INTG_CD_VAL_CTNT    AS COST_DIV_CD" ).append("\n"); 
		query.append("               ,INTG_CD_VAL_DP_DESC AS COST_DIV_DESC" ).append("\n"); 
		query.append("               ,''     AS APPL_YR" ).append("\n"); 
		query.append("               ,''     AS APPL_MON" ).append("\n"); 
		query.append("          FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  INTG_CD_ID = 'CD01392'" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("       ,SAQ_COST_APPL_BSE B" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  A.BSE_YR = B.BSE_YR(+)" ).append("\n"); 
		query.append("   AND  A.BSE_QTR_CD = B.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("   AND  A.COST_DIV_CD = B.COST_DIV_CD(+)" ).append("\n"); 

	}
}
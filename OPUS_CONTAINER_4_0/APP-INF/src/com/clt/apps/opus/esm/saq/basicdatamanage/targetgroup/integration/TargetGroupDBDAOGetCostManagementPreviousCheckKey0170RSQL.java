/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TargetGroupDBDAOGetCostManagementPreviousCheckKey0170RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.03.09 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TargetGroupDBDAOGetCostManagementPreviousCheckKey0170RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Management Previous Check Key
	  * </pre>
	  */
	public TargetGroupDBDAOGetCostManagementPreviousCheckKey0170RSQL(){
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
		query.append("FileName : TargetGroupDBDAOGetCostManagementPreviousCheckKey0170RSQL").append("\n"); 
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
		query.append("SELECT DISTINCT BSE_YR, " ).append("\n"); 
		query.append("				BSE_QTR_CD  " ).append("\n"); 
		query.append("FROM SAQ_COST_APPL_BSE             " ).append("\n"); 
		query.append("WHERE BSE_YR||BSE_QTR_CD < @[bse_yr]||@[bse_qtr_cd]" ).append("\n"); 
		query.append("#if (${bse_qtr_cd} == '00') " ).append("\n"); 
		query.append("	AND BSE_QTR_CD = '00'             	" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	AND BSE_QTR_CD != '00'            " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND ROWNUM = 1                   " ).append("\n"); 
		query.append("ORDER BY BSE_YR DESC, " ).append("\n"); 
		query.append("		 BSE_QTR_CD DESC" ).append("\n"); 

	}
}
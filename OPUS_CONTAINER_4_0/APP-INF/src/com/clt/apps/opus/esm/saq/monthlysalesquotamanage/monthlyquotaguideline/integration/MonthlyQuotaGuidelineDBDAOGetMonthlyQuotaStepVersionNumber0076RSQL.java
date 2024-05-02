/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaStepVersionNumber0076RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaStepVersionNumber0076RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRD_CD/DIR_CD/MQTA_VER_NO 별 조회
	  * </pre>
	  */
	public MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaStepVersionNumber0076RSQL(){
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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaStepVersionNumber0076RSQL").append("\n"); 
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
		query.append("SELECT TRD_CD, DIR_CD, MAX(MQTA_VER_NO) AS MQTA_VER_NO" ).append("\n"); 
		query.append("FROM   SAQ_MON_QTA_STEP_VER           " ).append("\n"); 
		query.append("WHERE  MQTA_STEP_CD = @[step_cd]      " ).append("\n"); 
		query.append("AND    BSE_YR       = @[year]         " ).append("\n"); 
		query.append("AND    BSE_QTR_CD   = @[bse_qtr_cd]     " ).append("\n"); 
		query.append("AND    GLINE_VER_NO = @[version]      " ).append("\n"); 
		query.append("AND    CRE_OFC_CD   = @[ofc_cd]" ).append("\n"); 
		query.append("GROUP BY TRD_CD, DIR_CD" ).append("\n"); 

	}
}
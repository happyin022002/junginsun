/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaSetpVersionStatus0076RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.24 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaSetpVersionStatus0076RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_QTA_STEP_VER의 "00" 건수와, ("00","XX") 이외의 건수 조회
	  * </pre>
	  */
	public MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaSetpVersionStatus0076RSQL(){
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
		params.put("target_grp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaSetpVersionStatus0076RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      SUM(DECODE(SAQ_STS_CD, '00', 1, 0))             AS STS00," ).append("\n"); 
		query.append("      SUM(DECODE(SAQ_STS_CD, '00', 0, 'XX', 0, 1))    AS STSOTHERS" ).append("\n"); 
		query.append("FROM  SAQ_MON_QTA_STEP_VER  A," ).append("\n"); 
		query.append("      SAQ_TGT_GRP_TRD_V     B" ).append("\n"); 
		query.append("WHERE B.TRD_CD          = A.TRD_CD" ).append("\n"); 
		query.append("AND   B.SAQ_TGT_GRP_CD  = @[target_grp]" ).append("\n"); 
		query.append("AND   A.MQTA_STEP_CD    = '01'" ).append("\n"); 
		query.append("AND   A.BSE_YR          = @[year]" ).append("\n"); 
		query.append("AND   A.BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND   A.GLINE_VER_NO    = @[version]" ).append("\n"); 

	}
}
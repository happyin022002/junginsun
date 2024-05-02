/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOGetMonthlyQuotaSlsRgnStepStatus0156RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.23 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentSlsRHQDBDAOGetMonthlyQuotaSlsRgnStepStatus0156RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * gline_ver_no STEP '04'에 연결된 STEP '05'중 상태별 건수를 체크를 위한 조회
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentSlsRHQDBDAOGetMonthlyQuotaSlsRgnStepStatus0156RSQL(){
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
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glineVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOGetMonthlyQuotaSlsRgnStepStatus0156RSQL").append("\n"); 
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
		query.append("    SUM(DECODE(SAQ_STS_CD, '00', 1, 0)) AS STS00," ).append("\n"); 
		query.append("    SUM(DECODE(SAQ_STS_CD, '00', 0, 'XX', 0, 1)) AS STSOTHERS" ).append("\n"); 
		query.append("FROM  SAQ_MON_QTA_STEP_VER" ).append("\n"); 
		query.append("WHERE  MQTA_STEP_CD = '09'" ).append("\n"); 
		query.append("AND    BSE_YR = @[year]" ).append("\n"); 
		query.append("AND    BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND    TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND    DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND    GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("AND    CRE_OFC_CD IN (" ).append("\n"); 
		query.append("    SELECT DISTINCT SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("    FROM   SAQ_MON_QTA_LOD_TGT" ).append("\n"); 
		query.append("    WHERE  MQTA_STEP_CD = '08'" ).append("\n"); 
		query.append("    AND    BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND    BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND    TRD_CD = @[trade]" ).append("\n"); 
		query.append("    AND    DIR_CD = @[bound]" ).append("\n"); 
		query.append("    AND    MQTA_VER_NO = @[mQtaVerNo] )" ).append("\n"); 

	}
}
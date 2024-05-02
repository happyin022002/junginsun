/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOIsGuidlineTrdDirAllMqtaVerNoFNFC0075RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.23 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOIsGuidlineTrdDirAllMqtaVerNoFNFC0075RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * gline_ver_no 에 관련된 모든 STEP의 mqta_ver_no 가 마지막 단계이면 TRUE, 아니면 FALSE 리턴.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOIsGuidlineTrdDirAllMqtaVerNoFNFC0075RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_quarter",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glineVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOIsGuidlineTrdDirAllMqtaVerNoFNFC0075RSQL").append("\n"); 
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
		query.append("SELECT MIN(DECODE(MQTA_STEP_CD, '01'," ).append("\n"); 
		query.append("                DECODE(COUNT(DISTINCT TRD_CD||DIR_CD||CRE_OFC_CD)," ).append("\n"); 
		query.append("                        SUM(DECODE(SVR.SAQ_STS_CD, 'FN', 1, 0)), '0', '1'))) + -- step01," ).append("\n"); 
		query.append("       MIN(DECODE(MQTA_STEP_CD, '02'," ).append("\n"); 
		query.append("                DECODE(COUNT(DISTINCT TRD_CD||DIR_CD||CRE_OFC_CD)," ).append("\n"); 
		query.append("                        SUM(DECODE(SVR.SAQ_STS_CD, 'FC', 1, 0)), '0', '1'))) + -- step02," ).append("\n"); 
		query.append("       MIN(DECODE(MQTA_STEP_CD, '04'," ).append("\n"); 
		query.append("                DECODE(COUNT(DISTINCT TRD_CD||DIR_CD||CRE_OFC_CD)," ).append("\n"); 
		query.append("                        SUM(DECODE(SVR.SAQ_STS_CD, 'FN', 1, 0)), '0', '1'))) RET -- step04," ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_STEP_VER SVR" ).append("\n"); 
		query.append("WHERE SVR.BSE_YR = @[year]" ).append("\n"); 
		query.append("AND   SVR.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("AND   SVR.GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("AND   SVR.TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND   SVR.DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND   SVR.SAQ_STS_CD <> 'XX'" ).append("\n"); 
		query.append("GROUP BY MQTA_STEP_CD" ).append("\n"); 

	}
}
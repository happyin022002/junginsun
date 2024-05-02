/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoA0048CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.27 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoA0048CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentTrade 에서 Notify 처리시 SETP '02' (RHQ 정보)를 생성한다.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoA0048CSQL(){
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
		params.put("userId",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoA0048CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_STEP_VER (" ).append("\n"); 
		query.append("    MQTA_STEP_CD," ).append("\n"); 
		query.append("    BSE_YR," ).append("\n"); 
		query.append("    BSE_QTR_CD," ).append("\n"); 
		query.append("    TRD_CD," ).append("\n"); 
		query.append("    DIR_CD," ).append("\n"); 
		query.append("    MQTA_VER_NO," ).append("\n"); 
		query.append("    SAQ_STS_CD," ).append("\n"); 
		query.append("    GLINE_VER_NO," ).append("\n"); 
		query.append("    QTA_MST_VER_NO," ).append("\n"); 
		query.append("    INCL_PORT_FLG," ).append("\n"); 
		query.append("    CRE_OFC_CD," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    '02' AS MQTA_STEP_CD," ).append("\n"); 
		query.append("    @[year] AS BSE_YR," ).append("\n"); 
		query.append("    @[bse_quarter] AS BSE_QTR_CD," ).append("\n"); 
		query.append("    @[trade] AS TRD_CD," ).append("\n"); 
		query.append("    @[bound] AS DIR_CD," ).append("\n"); 
		query.append("    TRD.CTRT_RHQ_CD" ).append("\n"); 
		query.append("       ||SUBSTR(TRD.MQTA_VER_NO, LENGTH(TRD.MQTA_VER_NO)-7, 6)" ).append("\n"); 
		query.append("       ||TO_CHAR(NVL(MAX(SUBSTR(STV.MQTA_VER_NO," ).append("\n"); 
		query.append("           LENGTH(STV.MQTA_VER_NO)-1)), 0)+1,'FM09') AS MQTA_VER_NO," ).append("\n"); 
		query.append("    '00' AS SAQ_STS_CD," ).append("\n"); 
		query.append("    @[glineVerNo] AS GLINE_VER_NO," ).append("\n"); 
		query.append("    SUBSTR(@[glineVerNo],-6) AS GLINE_VER_NO," ).append("\n"); 
		query.append("    'N' AS INCL_PORT_FLG," ).append("\n"); 
		query.append("    TRD.CTRT_RHQ_CD AS CRE_OFC_CD," ).append("\n"); 
		query.append("    @[userId] AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    @[userId] AS UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM  SAQ_MON_QTA_STEP_VER STV," ).append("\n"); 
		query.append("      ( SELECT DISTINCT TRD.TRD_CD, TRD.CTRT_RHQ_CD, MQTA_VER_NO" ).append("\n"); 
		query.append("        FROM   SAQ_MON_QTA_TRD TRD" ).append("\n"); 
		query.append("        WHERE  TRD.MQTA_STEP_CD = '01'" ).append("\n"); 
		query.append("        AND    TRD.BSE_YR = @[year]" ).append("\n"); 
		query.append("        AND    TRD.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("        AND    TRD.TRD_CD = @[trade]" ).append("\n"); 
		query.append("        AND    TRD.DIR_CD = @[bound]" ).append("\n"); 
		query.append("        AND    TRD.MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 
		query.append("       ) TRD" ).append("\n"); 
		query.append("WHERE  STV.MQTA_STEP_CD(+) = '02'" ).append("\n"); 
		query.append("AND    STV.BSE_YR(+) = @[year]" ).append("\n"); 
		query.append("AND    STV.BSE_QTR_CD(+) = @[bse_quarter]" ).append("\n"); 
		query.append("AND    STV.TRD_CD(+) = @[trade]" ).append("\n"); 
		query.append("AND    STV.DIR_CD(+) = @[bound]" ).append("\n"); 
		query.append("AND    STV.GLINE_VER_NO(+) = @[glineVerNo]" ).append("\n"); 
		query.append("AND    STV.CRE_OFC_CD(+) = TRD.CTRT_RHQ_CD" ).append("\n"); 
		query.append("AND    STV.TRD_CD(+) = TRD.TRD_CD" ).append("\n"); 
		query.append("GROUP BY TRD.CTRT_RHQ_CD, TRD.MQTA_VER_NO" ).append("\n"); 

	}
}
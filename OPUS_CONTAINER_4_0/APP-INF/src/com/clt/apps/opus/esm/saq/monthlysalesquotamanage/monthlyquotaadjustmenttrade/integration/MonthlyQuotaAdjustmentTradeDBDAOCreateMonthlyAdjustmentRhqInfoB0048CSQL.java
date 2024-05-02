/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoB0048CSQL.java
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

public class MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoB0048CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentTrade 에서 Notify 처리시 SETP '02' (RHQ 정보)를 생성한다.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoB0048CSQL(){
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
		query.append("FileName : MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoB0048CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_TRD (" ).append("\n"); 
		query.append("    MQTA_STEP_CD," ).append("\n"); 
		query.append("    BSE_YR," ).append("\n"); 
		query.append("    BSE_QTR_CD," ).append("\n"); 
		query.append("    TRD_CD," ).append("\n"); 
		query.append("    DIR_CD," ).append("\n"); 
		query.append("    MQTA_VER_NO," ).append("\n"); 
		query.append("    RLANE_CD," ).append("\n"); 
		query.append("    SPRT_GRP_CD," ).append("\n"); 
		query.append("    BSA_GRP_CD," ).append("\n"); 
		query.append("    CTRT_RHQ_CD," ).append("\n"); 
		query.append("    BSE_MON," ).append("\n"); 
		query.append("    SUB_TRD_CD," ).append("\n"); 
		query.append("    LOD_QTY," ).append("\n"); 
		query.append("    GRS_RPB_REV," ).append("\n"); 
		query.append("    CM_UC_AMT," ).append("\n"); 
		query.append("    OPFIT_UC_AMT," ).append("\n"); 
		query.append("    RA_CM_UC_AMT," ).append("\n"); 
		query.append("    RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    '02' AS MQTA_STEP_CD," ).append("\n"); 
		query.append("    TRD.BSE_YR," ).append("\n"); 
		query.append("    TRD.BSE_QTR_CD," ).append("\n"); 
		query.append("    TRD.TRD_CD," ).append("\n"); 
		query.append("    TRD.DIR_CD," ).append("\n"); 
		query.append("    VER.MQTA_VER_NO," ).append("\n"); 
		query.append("    TRD.RLANE_CD," ).append("\n"); 
		query.append("    TRD.SPRT_GRP_CD," ).append("\n"); 
		query.append("    TRD.BSA_GRP_CD," ).append("\n"); 
		query.append("    TRD.CTRT_RHQ_CD," ).append("\n"); 
		query.append("    TRD.BSE_MON," ).append("\n"); 
		query.append("    TRD.SUB_TRD_CD," ).append("\n"); 
		query.append("    TRD.LOD_QTY," ).append("\n"); 
		query.append("    TRD.GRS_RPB_REV," ).append("\n"); 
		query.append("    TRD.CM_UC_AMT," ).append("\n"); 
		query.append("    TRD.OPFIT_UC_AMT," ).append("\n"); 
		query.append("    TRD.RA_CM_UC_AMT," ).append("\n"); 
		query.append("    TRD.RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("    @[userId] AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    @[userId] AS UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_TRD TRD," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT CRE_OFC_CD," ).append("\n"); 
		query.append("           MAX(MQTA_VER_NO) AS MQTA_VER_NO" ).append("\n"); 
		query.append("    FROM   SAQ_MON_QTA_STEP_VER STV" ).append("\n"); 
		query.append("    WHERE  STV.MQTA_STEP_CD = '02'" ).append("\n"); 
		query.append("    AND    STV.BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND    STV.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("    AND    STV.TRD_CD = @[trade]" ).append("\n"); 
		query.append("    AND    STV.DIR_CD = @[bound]" ).append("\n"); 
		query.append("    AND    STV.GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("    GROUP BY CRE_OFC_CD ) VER" ).append("\n"); 
		query.append("WHERE TRD.MQTA_STEP_CD = '01'" ).append("\n"); 
		query.append("AND   TRD.BSE_YR = @[year]" ).append("\n"); 
		query.append("AND   TRD.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("AND   TRD.TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND   TRD.DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND   TRD.MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 
		query.append("AND   VER.CRE_OFC_CD = TRD.CTRT_RHQ_CD" ).append("\n"); 

	}
}
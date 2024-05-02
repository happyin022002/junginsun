/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoD0156CSQL.java
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

public class MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoD0156CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentSlsRhq 의 Save As New Version 을 처리한다.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoD0156CSQL(){
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
		params.put("userId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaStepCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newVersion",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoD0156CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_LOD_TGT (" ).append("\n"); 
		query.append("    MQTA_STEP_CD," ).append("\n"); 
		query.append("    BSE_YR," ).append("\n"); 
		query.append("    BSE_QTR_CD," ).append("\n"); 
		query.append("    TRD_CD," ).append("\n"); 
		query.append("    DIR_CD," ).append("\n"); 
		query.append("    MQTA_VER_NO," ).append("\n"); 
		query.append("    RLANE_CD," ).append("\n"); 
		query.append("    SPRT_GRP_CD," ).append("\n"); 
		query.append("    BSA_GRP_CD," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("    BSE_MON," ).append("\n"); 
		query.append("    POL_CD," ).append("\n"); 
		query.append("    POD_CD," ).append("\n"); 
		query.append("    SUB_TRD_CD," ).append("\n"); 
		query.append("    SLS_RHQ_CD," ).append("\n"); 
		query.append("    SLS_AQ_CD," ).append("\n"); 
		query.append("    LOD_QTY," ).append("\n"); 
		query.append("    GRS_RPB_REV," ).append("\n"); 
		query.append("    CM_UC_AMT," ).append("\n"); 
		query.append("    OPFIT_UC_AMT," ).append("\n"); 
		query.append("    RA_CM_UC_AMT," ).append("\n"); 
		query.append("    RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("    OFC_ADD_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    @[mQtaStepCd] AS MQTA_STEP_CD," ).append("\n"); 
		query.append("    LOD_TGT.BSE_YR," ).append("\n"); 
		query.append("    LOD_TGT.BSE_QTR_CD," ).append("\n"); 
		query.append("    LOD_TGT.TRD_CD," ).append("\n"); 
		query.append("    LOD_TGT.DIR_CD," ).append("\n"); 
		query.append("    @[newVersion] AS MQTA_VER_NO," ).append("\n"); 
		query.append("    LOD_TGT.RLANE_CD," ).append("\n"); 
		query.append("    LOD_TGT.SPRT_GRP_CD," ).append("\n"); 
		query.append("    LOD_TGT.BSA_GRP_CD," ).append("\n"); 
		query.append("    LOD_TGT.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("    LOD_TGT.BSE_MON," ).append("\n"); 
		query.append("    '00000' AS POL_CD," ).append("\n"); 
		query.append("    '00000' AS POD_CD," ).append("\n"); 
		query.append("    LOD_TGT.SUB_TRD_CD," ).append("\n"); 
		query.append("    LOD_TGT.SLS_RHQ_CD," ).append("\n"); 
		query.append("    LOD_TGT.SLS_AQ_CD," ).append("\n"); 
		query.append("    SUM(LOD_TGT.LOD_QTY)," ).append("\n"); 
		query.append("    DECODE(SUM(LOD_TGT.LOD_QTY), 0, 0, SUM(LOD_TGT.LOD_QTY * LOD_TGT.GRS_RPB_REV)/SUM(LOD_TGT.LOD_QTY))," ).append("\n"); 
		query.append("    SUM(LOD_TGT.LOD_QTY * LOD_TGT.CM_UC_AMT)/SUM(LOD_TGT.LOD_QTY)," ).append("\n"); 
		query.append("    SUM(LOD_TGT.LOD_QTY * LOD_TGT.OPFIT_UC_AMT)/SUM(LOD_TGT.LOD_QTY)," ).append("\n"); 
		query.append("    SUM(LOD_TGT.LOD_QTY * LOD_TGT.RA_CM_UC_AMT)/SUM(LOD_TGT.LOD_QTY)," ).append("\n"); 
		query.append("    SUM(LOD_TGT.LOD_QTY * LOD_TGT.RA_OPFIT_UC_AMT)/SUM(LOD_TGT.LOD_QTY)," ).append("\n"); 
		query.append("    LOD_TGT.OFC_ADD_FLG," ).append("\n"); 
		query.append("    @[userId] AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    @[userId] AS UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_LOD_TGT LOD_TGT" ).append("\n"); 
		query.append("WHERE LOD_TGT.MQTA_STEP_CD = '11'" ).append("\n"); 
		query.append("AND   LOD_TGT.BSE_YR = @[year]" ).append("\n"); 
		query.append("AND   LOD_TGT.BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND   LOD_TGT.TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND   LOD_TGT.DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND   LOD_TGT.MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("    LOD_TGT.MQTA_STEP_CD," ).append("\n"); 
		query.append("    LOD_TGT.BSE_YR," ).append("\n"); 
		query.append("    LOD_TGT.BSE_QTR_CD," ).append("\n"); 
		query.append("    LOD_TGT.TRD_CD," ).append("\n"); 
		query.append("    LOD_TGT.DIR_CD," ).append("\n"); 
		query.append("    LOD_TGT.RLANE_CD," ).append("\n"); 
		query.append("    LOD_TGT.SPRT_GRP_CD," ).append("\n"); 
		query.append("    LOD_TGT.BSA_GRP_CD," ).append("\n"); 
		query.append("    LOD_TGT.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("    LOD_TGT.BSE_MON," ).append("\n"); 
		query.append("    LOD_TGT.SUB_TRD_CD," ).append("\n"); 
		query.append("    LOD_TGT.SLS_RHQ_CD," ).append("\n"); 
		query.append("    LOD_TGT.SLS_AQ_CD," ).append("\n"); 
		query.append("    LOD_TGT.OFC_ADD_FLG" ).append("\n"); 

	}
}
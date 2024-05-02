/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentRhqRgnInfoB0085CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentRhqRgnInfoB0085CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentTradeRHQ 에서 'FC' Confirm 처리시 STEP '03' 정보를 기준으로 SETP '04' (RHQ RGN 정보)를 생성한다.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentRhqRgnInfoB0085CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mqtaMdlVerNo",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentRhqRgnInfoB0085CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_RHQ (" ).append("\n"); 
		query.append("    MQTA_STEP_CD," ).append("\n"); 
		query.append("    BSE_YR," ).append("\n"); 
		query.append("    BSE_QTR_CD," ).append("\n"); 
		query.append("    TRD_CD," ).append("\n"); 
		query.append("    DIR_CD," ).append("\n"); 
		query.append("    MQTA_VER_NO," ).append("\n"); 
		query.append("    RLANE_CD," ).append("\n"); 
		query.append("    SPRT_GRP_CD," ).append("\n"); 
		query.append("    BSA_GRP_CD," ).append("\n"); 
		query.append("    CTRT_RGN_OFC_CD," ).append("\n"); 
		query.append("    BSE_MON," ).append("\n"); 
		query.append("    SUB_TRD_CD," ).append("\n"); 
		query.append("    CTRT_RHQ_CD," ).append("\n"); 
		query.append("    CTRT_AQ_CD," ).append("\n"); 
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
		query.append("SELECT /*+ ORDERED USE_HASH(MDT MDD) */" ).append("\n"); 
		query.append("    '04' AS MQTA_STEP_CD," ).append("\n"); 
		query.append("    TRD.BSE_YR," ).append("\n"); 
		query.append("    TRD.BSE_QTR_CD," ).append("\n"); 
		query.append("    TRD.TRD_CD," ).append("\n"); 
		query.append("    TRD.DIR_CD," ).append("\n"); 
		query.append("    VER.MQTA_VER_NO," ).append("\n"); 
		query.append("    TRD.RLANE_CD," ).append("\n"); 
		query.append("    TRD.SPRT_GRP_CD," ).append("\n"); 
		query.append("    TRD.BSA_GRP_CD," ).append("\n"); 
		query.append("    MDD.CTRT_RGN_OFC_CD," ).append("\n"); 
		query.append("    TRD.BSE_MON," ).append("\n"); 
		query.append("    TRD.SUB_TRD_CD," ).append("\n"); 
		query.append("    TRD.CTRT_RHQ_CD," ).append("\n"); 
		query.append("    MDD.CTRT_AQ_CD," ).append("\n"); 
		query.append("    DECODE(TRD.LOD_QTY, 0, 0," ).append("\n"); 
		query.append("        MDD.LOD_QTY*(TRD.LOD_QTY/MDT.TOT_LOD_QTY)) AS LOD_QTY," ).append("\n"); 
		query.append("    DECODE(TRD.LOD_QTY, 0, 0," ).append("\n"); 
		query.append("    (MDD.LOD_QTY*MDD.GRS_RPB_REV*((TRD.LOD_QTY*TRD.GRS_RPB_REV)/MDT.TOT_GRS_REV))" ).append("\n"); 
		query.append("        /(MDD.LOD_QTY*(TRD.LOD_QTY/MDT.TOT_LOD_QTY))) AS GRS_RPB_REV," ).append("\n"); 
		query.append("    MDD.CM_UC_AMT," ).append("\n"); 
		query.append("    MDD.OPFIT_UC_AMT," ).append("\n"); 
		query.append("    MDD.RA_CM_UC_AMT," ).append("\n"); 
		query.append("    MDD.RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("    'N'," ).append("\n"); 
		query.append("    @[userId] AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    @[userId] AS UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_STEP_VER FSV, -- final version number" ).append("\n"); 
		query.append("     SAQ_MON_QTA_TRD TRD, -- final data" ).append("\n"); 
		query.append("    ( -- step 04 new version" ).append("\n"); 
		query.append("    SELECT MAX(MQTA_VER_NO) AS MQTA_VER_NO" ).append("\n"); 
		query.append("    FROM   SAQ_MON_QTA_STEP_VER STV" ).append("\n"); 
		query.append("    WHERE  STV.MQTA_STEP_CD = '04'" ).append("\n"); 
		query.append("    AND    STV.BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND    STV.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("    AND    STV.TRD_CD = @[trade]" ).append("\n"); 
		query.append("    AND    STV.DIR_CD = @[bound]" ).append("\n"); 
		query.append("    AND    STV.GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("    AND    STV.CRE_OFC_CD = @[ofcCd]" ).append("\n"); 
		query.append("    ) VER, (" ).append("\n"); 
		query.append("    SELECT -- Model Result Total" ).append("\n"); 
		query.append("            VVD.RLANE_CD, VVD.SPRT_GRP_CD, VVD.BSA_GRP_CD, VVD.BSE_MON," ).append("\n"); 
		query.append("            MRS.CTRT_RHQ_CD," ).append("\n"); 
		query.append("            DECODE(SUM(MRS.LOD_QTY), 0, 1, SUM(MRS.LOD_QTY)) AS TOT_LOD_QTY," ).append("\n"); 
		query.append("            DECODE(SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY), 0, 1, SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY))" ).append("\n"); 
		query.append("            	   AS TOT_GRS_REV" ).append("\n"); 
		query.append("    FROM   SAQ_MON_FX_MDL_SMRY MRS," ).append("\n"); 
		query.append("           SAQ_MON_TGT_VVD_ADJ VVD" ).append("\n"); 
		query.append("    WHERE  MRS.MQTA_MDL_VER_NO = @[mqtaMdlVerNo]" ).append("\n"); 
		query.append("    AND    MRS.TRD_CD = @[trade]" ).append("\n"); 
		query.append("    AND    MRS.DIR_CD = @[bound]" ).append("\n"); 
		query.append("    AND    MRS.CTRT_RHQ_CD = @[ofcCd]" ).append("\n"); 
		query.append("    AND    VVD.BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND    VVD.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("    AND    VVD.GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("    AND    VVD.BSE_YR = MRS.BSE_YR" ).append("\n"); 
		query.append("    AND    VVD.BSE_MON = MRS.BSE_MON" ).append("\n"); 
		query.append("    AND    VVD.RLANE_CD = MRS.RLANE_CD" ).append("\n"); 
		query.append("    AND    VVD.TRD_CD = MRS.TRD_CD" ).append("\n"); 
		query.append("    AND    VVD.DIR_CD = MRS.DIR_CD" ).append("\n"); 
		query.append("    AND    VVD.VSL_CD = MRS.VSL_CD" ).append("\n"); 
		query.append("    AND    VVD.SKD_VOY_NO = MRS.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND    VVD.SKD_DIR_CD = MRS.SKD_DIR_CD" ).append("\n"); 
		query.append("    GROUP BY VVD.RLANE_CD, VVD.SPRT_GRP_CD, VVD.BSA_GRP_CD, VVD.BSE_MON," ).append("\n"); 
		query.append("    		 MRS.CTRT_RHQ_CD" ).append("\n"); 
		query.append("    ) MDT, (" ).append("\n"); 
		query.append("    SELECT -- Model Result" ).append("\n"); 
		query.append("            MIN(VVD.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("            MIN(VVD.SPRT_GRP_CD) AS SPRT_GRP_CD," ).append("\n"); 
		query.append("            MIN(VVD.BSA_GRP_CD) AS BSA_GRP_CD," ).append("\n"); 
		query.append("            MIN(MRS.CTRT_RGN_OFC_CD) AS CTRT_RGN_OFC_CD," ).append("\n"); 
		query.append("            MIN(VVD.BSE_MON) AS BSE_MON," ).append("\n"); 
		query.append("            MRS.CTRT_RHQ_CD," ).append("\n"); 
		query.append("            MRS.CTRT_AQ_CD," ).append("\n"); 
		query.append("            SUM(MRS.LOD_QTY) AS LOD_QTY," ).append("\n"); 
		query.append("            SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY)/SUM(MRS.LOD_QTY) AS GRS_RPB_REV," ).append("\n"); 
		query.append("            SUM(MRS.CM_UC_AMT*MRS.LOD_QTY)/SUM(MRS.LOD_QTY) AS CM_UC_AMT," ).append("\n"); 
		query.append("            SUM(MRS.RA_CM_UC_AMT*MRS.LOD_QTY)/SUM(MRS.LOD_QTY) AS RA_CM_UC_AMT," ).append("\n"); 
		query.append("            SUM(MRS.OPFIT_UC_AMT*MRS.LOD_QTY)/SUM(MRS.LOD_QTY) AS OPFIT_UC_AMT," ).append("\n"); 
		query.append("            SUM(MRS.RA_OPFIT_UC_AMT*MRS.LOD_QTY)/SUM(MRS.LOD_QTY) AS RA_OPFIT_UC_AMT" ).append("\n"); 
		query.append("    FROM   SAQ_MON_FX_MDL_SMRY MRS," ).append("\n"); 
		query.append("           SAQ_MON_TGT_VVD_ADJ VVD" ).append("\n"); 
		query.append("    WHERE  MRS.MQTA_MDL_VER_NO = @[mqtaMdlVerNo]" ).append("\n"); 
		query.append("    AND    MRS.TRD_CD = @[trade]" ).append("\n"); 
		query.append("    AND    MRS.DIR_CD = @[bound]" ).append("\n"); 
		query.append("    AND    MRS.CTRT_RHQ_CD = @[ofcCd]" ).append("\n"); 
		query.append("    AND    VVD.BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND    VVD.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("    AND    VVD.GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("    AND    VVD.BSE_YR = MRS.BSE_YR" ).append("\n"); 
		query.append("    AND    VVD.BSE_MON = MRS.BSE_MON" ).append("\n"); 
		query.append("    AND    VVD.RLANE_CD = MRS.RLANE_CD" ).append("\n"); 
		query.append("    AND    VVD.TRD_CD = MRS.TRD_CD" ).append("\n"); 
		query.append("    AND    VVD.DIR_CD = MRS.DIR_CD" ).append("\n"); 
		query.append("    AND    VVD.VSL_CD = MRS.VSL_CD" ).append("\n"); 
		query.append("    AND    VVD.SKD_VOY_NO = MRS.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND    VVD.SKD_DIR_CD = MRS.SKD_DIR_CD" ).append("\n"); 
		query.append("    GROUP BY VVD.RLANE_CD, VVD.SPRT_GRP_CD, VVD.BSA_GRP_CD,   MRS.CTRT_RHQ_CD, MRS.CTRT_AQ_CD," ).append("\n"); 
		query.append("            MRS.CTRT_RGN_OFC_CD,VVD.BSE_MON" ).append("\n"); 
		query.append("    ) MDD" ).append("\n"); 
		query.append("WHERE FSV.MQTA_STEP_CD = '03'" ).append("\n"); 
		query.append("AND   FSV.BSE_YR = @[year]" ).append("\n"); 
		query.append("AND   FSV.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("AND   FSV.TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND   FSV.DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND   FSV.GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("AND   FSV.SAQ_STS_CD = 'FN'" ).append("\n"); 
		query.append("AND   TRD.MQTA_STEP_CD = FSV.MQTA_STEP_CD" ).append("\n"); 
		query.append("AND   TRD.BSE_YR = FSV.BSE_YR" ).append("\n"); 
		query.append("AND   TRD.BSE_QTR_CD = FSV.BSE_QTR_CD" ).append("\n"); 
		query.append("AND   TRD.TRD_CD = FSV.TRD_CD" ).append("\n"); 
		query.append("AND   TRD.DIR_CD = FSV.DIR_CD" ).append("\n"); 
		query.append("AND   TRD.MQTA_VER_NO = FSV.MQTA_VER_NO" ).append("\n"); 
		query.append("AND   TRD.CTRT_RHQ_CD = @[ofcCd]" ).append("\n"); 
		query.append("AND   MDD.RLANE_CD = TRD.RLANE_CD" ).append("\n"); 
		query.append("AND   MDD.SPRT_GRP_CD = TRD.SPRT_GRP_CD" ).append("\n"); 
		query.append("AND   MDD.BSA_GRP_CD = TRD.BSA_GRP_CD" ).append("\n"); 
		query.append("AND   MDD.BSE_MON = TRD.BSE_MON" ).append("\n"); 
		query.append("AND   MDD.RLANE_CD = MDT.RLANE_CD" ).append("\n"); 
		query.append("AND   MDD.SPRT_GRP_CD = MDT.SPRT_GRP_CD" ).append("\n"); 
		query.append("AND   MDD.BSA_GRP_CD = MDT.BSA_GRP_CD" ).append("\n"); 
		query.append("AND   MDD.BSE_MON = MDT.BSE_MON" ).append("\n"); 
		query.append("AND   MDD.CTRT_RHQ_CD = TRD.CTRT_RHQ_CD" ).append("\n"); 
		query.append("AND   MDT.CTRT_RHQ_CD = TRD.CTRT_RHQ_CD" ).append("\n"); 
		query.append("AND   TRD.LOD_QTY <> 0" ).append("\n"); 

	}
}
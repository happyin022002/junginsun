/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOCreateSaqMonFxMdlSmry0085CSQL.java
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

public class MonthlyQuotaAdjustmentTradeRHQDBDAOCreateSaqMonFxMdlSmry0085CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_FX_MDL_SMRY의 데이터 생성
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeRHQDBDAOCreateSaqMonFxMdlSmry0085CSQL(){
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
		params.put("mQtaStepCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOCreateSaqMonFxMdlSmry0085CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_FX_MDL_SMRY(" ).append("\n"); 
		query.append("       MQTA_MDL_VER_NO," ).append("\n"); 
		query.append("       BSE_YR," ).append("\n"); 
		query.append("       BSE_MON," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       DIR_CD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       CTRT_RGN_OFC_CD," ).append("\n"); 
		query.append("       SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("       CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST_SEQ," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       CTRT_RHQ_CD," ).append("\n"); 
		query.append("       CTRT_AQ_CD," ).append("\n"); 
		query.append("       SLS_RHQ_CD," ).append("\n"); 
		query.append("       SLS_AQ_CD," ).append("\n"); 
		query.append("       CUST_GRP_ID," ).append("\n"); 
		query.append("       LOD_QTY," ).append("\n"); 
		query.append("       GRS_RPB_REV," ).append("\n"); 
		query.append("       CM_UC_AMT," ).append("\n"); 
		query.append("       OPFIT_UC_AMT," ).append("\n"); 
		query.append("       RA_CM_UC_AMT," ).append("\n"); 
		query.append("       RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("       SVC_MOD_ADJ_AVAL_FLG," ).append("\n"); 
		query.append("       FULL_STVG_UC_AMT," ).append("\n"); 
		query.append("       FULL_TRSP_UC_AMT," ).append("\n"); 
		query.append("       MTY_STVG_UC_AMT," ).append("\n"); 
		query.append("       MTY_TRSP_UC_AMT," ).append("\n"); 
		query.append("       CNTR_FX_UC_AMT," ).append("\n"); 
		query.append("       CHSS_FX_UC_AMT," ).append("\n"); 
		query.append("       AGN_COMM_UT_AMT," ).append("\n"); 
		query.append("       BIZ_ACT_UC_AMT," ).append("\n"); 
		query.append("       SLT_MGMT_UC_AMT," ).append("\n"); 
		query.append("       OWN_VOL_ACT_UC_AMT," ).append("\n"); 
		query.append("       STP_UC_AMT," ).append("\n"); 
		query.append("       EQ_HLD_UC_AMT," ).append("\n"); 
		query.append("       EQ_REPO_UC_AMT," ).append("\n"); 
		query.append("       EQ_SIM_UC_AMT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append("     SMRY.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("     ,SMRY.BSE_YR" ).append("\n"); 
		query.append("     ,SMRY.BSE_MON" ).append("\n"); 
		query.append("     ,SMRY.TRD_CD" ).append("\n"); 
		query.append("     ,SMRY.RLANE_CD" ).append("\n"); 
		query.append("     ,SMRY.DIR_CD" ).append("\n"); 
		query.append("     ,SMRY.VSL_CD" ).append("\n"); 
		query.append("     ,SMRY.SKD_VOY_NO" ).append("\n"); 
		query.append("     ,SMRY.SKD_DIR_CD" ).append("\n"); 
		query.append("     ,SMRY.CTRT_RGN_OFC_CD" ).append("\n"); 
		query.append("     ,SMRY.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("     ,SMRY.CUST_CNT_CD" ).append("\n"); 
		query.append("     ,SMRY.CUST_SEQ" ).append("\n"); 
		query.append("     ,SMRY.POL_CD" ).append("\n"); 
		query.append("     ,SMRY.POD_CD" ).append("\n"); 
		query.append("     ,SMRY.SUB_TRD_CD" ).append("\n"); 
		query.append("     ,SMRY.CTRT_RHQ_CD" ).append("\n"); 
		query.append("     ,SMRY.CTRT_AQ_CD" ).append("\n"); 
		query.append("     ,SMRY.SLS_RHQ_CD" ).append("\n"); 
		query.append("     ,SMRY.SLS_AQ_CD" ).append("\n"); 
		query.append("     ,SMRY.CUST_GRP_ID" ).append("\n"); 
		query.append("     ,SUM(SMRY.LOD_QTY)" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.GRS_RPB_REV*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.CM_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.OPFIT_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.RA_CM_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.RA_OPFIT_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,MAX(SMRY.SVC_MOD_ADJ_AVAL_FLG)" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.FULL_STVG_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.FULL_TRSP_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.MTY_STVG_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.MTY_TRSP_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.CNTR_FX_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.CHSS_FX_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.AGN_COMM_UT_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.BIZ_ACT_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.SLT_MGMT_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.OWN_VOL_ACT_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.STP_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.EQ_HLD_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.EQ_REPO_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,DECODE(SUM(SMRY.LOD_QTY),0,0,SUM(SMRY.EQ_SIM_UC_AMT*SMRY.LOD_QTY)/SUM(SMRY.LOD_QTY))" ).append("\n"); 
		query.append("     ,@[userId]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append("     ,@[userId]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("     SELECT" ).append("\n"); 
		query.append("         SMRY.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("         ,SMRY.BSE_YR" ).append("\n"); 
		query.append("         ,SMRY.BSE_MON" ).append("\n"); 
		query.append("         ,SMRY.TRD_CD" ).append("\n"); 
		query.append("         ,SMRY.RLANE_CD" ).append("\n"); 
		query.append("         ,SMRY.DIR_CD" ).append("\n"); 
		query.append("         ,SMRY.VSL_CD" ).append("\n"); 
		query.append("         ,SMRY.SKD_VOY_NO" ).append("\n"); 
		query.append("         ,SMRY.SKD_DIR_CD" ).append("\n"); 
		query.append("         ,SMRY.CTRT_RGN_OFC_CD" ).append("\n"); 
		query.append("         ,SMRY.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("         ,SMRY.CUST_CNT_CD" ).append("\n"); 
		query.append("         ,SMRY.CUST_SEQ" ).append("\n"); 
		query.append("         ,SMRY.POL_CD" ).append("\n"); 
		query.append("         ,SMRY.POD_CD" ).append("\n"); 
		query.append("         ,SMRY.SUB_TRD_CD" ).append("\n"); 
		query.append("         ,SMRY.CTRT_RHQ_CD" ).append("\n"); 
		query.append("         ,SMRY.CTRT_AQ_CD" ).append("\n"); 
		query.append("         ,SMRY.SLS_RHQ_CD" ).append("\n"); 
		query.append("         ,SMRY.SLS_AQ_CD" ).append("\n"); 
		query.append("         ,SMRY.CUST_GRP_ID" ).append("\n"); 
		query.append("         ,DECODE(SMRY.SAQ_SVC_MOD_CD,'0000',SMRY.LOD_QTY,LOD_QTY - ( ORI_RHQ_LVL_LOD - RHQ_LVL_LOD ) *  LOD_QTY / ORI_RHQ_LVL_LOD) LOD_QTY" ).append("\n"); 
		query.append("         ,SMRY.GRS_RPB_REV" ).append("\n"); 
		query.append("         ,SMRY.CM_UC_AMT" ).append("\n"); 
		query.append("         ,SMRY.OPFIT_UC_AMT" ).append("\n"); 
		query.append("         ,SMRY.RA_CM_UC_AMT" ).append("\n"); 
		query.append("         ,SMRY.RA_OPFIT_UC_AMT" ).append("\n"); 
		query.append("         ,SMRY.SAQ_SVC_MOD_CD" ).append("\n"); 
		query.append("         ,SMRY.SVC_MOD_ADJ_AVAL_FLG" ).append("\n"); 
		query.append("         ,FULL_STVG_UC_AMT" ).append("\n"); 
		query.append("         ,FULL_TRSP_UC_AMT" ).append("\n"); 
		query.append("         ,MTY_STVG_UC_AMT" ).append("\n"); 
		query.append("         ,MTY_TRSP_UC_AMT" ).append("\n"); 
		query.append("         ,CNTR_FX_UC_AMT" ).append("\n"); 
		query.append("         ,CHSS_FX_UC_AMT" ).append("\n"); 
		query.append("         ,AGN_COMM_UT_AMT" ).append("\n"); 
		query.append("         ,BIZ_ACT_UC_AMT" ).append("\n"); 
		query.append("         ,SLT_MGMT_UC_AMT" ).append("\n"); 
		query.append("         ,OWN_VOL_ACT_UC_AMT" ).append("\n"); 
		query.append("         ,STP_UC_AMT" ).append("\n"); 
		query.append("         ,EQ_HLD_UC_AMT" ).append("\n"); 
		query.append("         ,EQ_REPO_UC_AMT" ).append("\n"); 
		query.append("         ,EQ_SIM_UC_AMT" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("       SELECT  /*+ORDERED USE_HASH( SMRY  MIX ADJ   )*/  MIX.MOD_MIX_RTO" ).append("\n"); 
		query.append("             ,SUM(DECODE(SMRY.SAQ_SVC_MOD_CD,'0000',0,SMRY.LOD_QTY))" ).append("\n"); 
		query.append("                     OVER ( PARTITION BY" ).append("\n"); 
		query.append("                          SMRY.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("                          ,SMRY.BSE_YR" ).append("\n"); 
		query.append("                          ,SMRY.BSE_MON" ).append("\n"); 
		query.append("                          ,SMRY.TRD_CD" ).append("\n"); 
		query.append("                          ,SMRY.RLANE_CD" ).append("\n"); 
		query.append("                          ,SMRY.CTRT_RHQ_CD" ).append("\n"); 
		query.append("                          ,SMRY.DIR_CD" ).append("\n"); 
		query.append("                          ,MIX.SPRT_GRP_CD" ).append("\n"); 
		query.append("                          ,MIX.BSA_GRP_CD" ).append("\n"); 
		query.append("                         ) *  MIX.MOD_MIX_RTO  /100  RHQ_LVL_LOD" ).append("\n"); 
		query.append("             ,SUM(DECODE(SMRY.SAQ_SVC_MOD_CD,'0000',0,SMRY.LOD_QTY))" ).append("\n"); 
		query.append("                     OVER ( PARTITION BY" ).append("\n"); 
		query.append("                          SMRY.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("                          ,SMRY.BSE_YR" ).append("\n"); 
		query.append("                          ,SMRY.BSE_MON" ).append("\n"); 
		query.append("                          ,SMRY.TRD_CD" ).append("\n"); 
		query.append("                          ,SMRY.RLANE_CD" ).append("\n"); 
		query.append("                          ,SMRY.CTRT_RHQ_CD" ).append("\n"); 
		query.append("                          ,SMRY.DIR_CD" ).append("\n"); 
		query.append("                          ,MIX.SPRT_GRP_CD" ).append("\n"); 
		query.append("                          ,MIX.BSA_GRP_CD" ).append("\n"); 
		query.append("                          ,MIX.SAQ_SVC_MOD_CD" ).append("\n"); 
		query.append("                         )  ORI_RHQ_LVL_LOD" ).append("\n"); 
		query.append("             ,SMRY.LOD_QTY" ).append("\n"); 
		query.append("             ,SMRY.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("             ,SMRY.BSE_YR" ).append("\n"); 
		query.append("             ,SMRY.BSE_MON" ).append("\n"); 
		query.append("             ,SMRY.TRD_CD" ).append("\n"); 
		query.append("             ,SMRY.RLANE_CD" ).append("\n"); 
		query.append("             ,SMRY.DIR_CD" ).append("\n"); 
		query.append("             ,SMRY.VSL_CD" ).append("\n"); 
		query.append("             ,SMRY.SKD_VOY_NO" ).append("\n"); 
		query.append("             ,SMRY.SKD_DIR_CD" ).append("\n"); 
		query.append("             ,SMRY.CTRT_RGN_OFC_CD" ).append("\n"); 
		query.append("             ,SMRY.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("             ,SMRY.CUST_CNT_CD" ).append("\n"); 
		query.append("             ,SMRY.CUST_SEQ" ).append("\n"); 
		query.append("             ,SMRY.POL_CD" ).append("\n"); 
		query.append("             ,SMRY.POD_CD" ).append("\n"); 
		query.append("             ,SMRY.SUB_TRD_CD" ).append("\n"); 
		query.append("             ,SMRY.CTRT_RHQ_CD" ).append("\n"); 
		query.append("             ,SMRY.CTRT_AQ_CD" ).append("\n"); 
		query.append("             ,SMRY.SLS_RHQ_CD" ).append("\n"); 
		query.append("             ,SMRY.SLS_AQ_CD" ).append("\n"); 
		query.append("             ,SMRY.CUST_GRP_ID" ).append("\n"); 
		query.append("             ,SMRY.SAQ_SVC_MOD_CD" ).append("\n"); 
		query.append("            ,SMRY.GRS_RPB_REV" ).append("\n"); 
		query.append("            ,SMRY.CM_UC_AMT" ).append("\n"); 
		query.append("            ,SMRY.OPFIT_UC_AMT" ).append("\n"); 
		query.append("            ,SMRY.RA_CM_UC_AMT" ).append("\n"); 
		query.append("            ,SMRY.RA_OPFIT_UC_AMT" ).append("\n"); 
		query.append("            ,SMRY.SVC_MOD_ADJ_AVAL_FLG" ).append("\n"); 
		query.append("            ,FULL_STVG_UC_AMT" ).append("\n"); 
		query.append("            ,FULL_TRSP_UC_AMT" ).append("\n"); 
		query.append("            ,MTY_STVG_UC_AMT" ).append("\n"); 
		query.append("            ,MTY_TRSP_UC_AMT" ).append("\n"); 
		query.append("            ,CNTR_FX_UC_AMT" ).append("\n"); 
		query.append("            ,CHSS_FX_UC_AMT" ).append("\n"); 
		query.append("            ,AGN_COMM_UT_AMT" ).append("\n"); 
		query.append("            ,BIZ_ACT_UC_AMT" ).append("\n"); 
		query.append("             ,SLT_MGMT_UC_AMT" ).append("\n"); 
		query.append("             ,OWN_VOL_ACT_UC_AMT" ).append("\n"); 
		query.append("             ,STP_UC_AMT" ).append("\n"); 
		query.append("             ,EQ_HLD_UC_AMT" ).append("\n"); 
		query.append("             ,EQ_REPO_UC_AMT" ).append("\n"); 
		query.append("             ,EQ_SIM_UC_AMT" ).append("\n"); 
		query.append("       FROM SAQ_MON_INIT_MDL_SMRY SMRY" ).append("\n"); 
		query.append(" 	        , SAQ_MON_QTA_OFC_MOD_MIX MIX" ).append("\n"); 
		query.append("            , SAQ_MON_TGT_VVD_ADJ ADJ" ).append("\n"); 
		query.append("       WHERE" ).append("\n"); 
		query.append("            MIX.MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append("           AND MIX.MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 
		query.append("           AND MIX.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("           AND SMRY.BSE_YR = @[year]" ).append("\n"); 
		query.append("           AND SMRY.TRD_CD = @[trade]" ).append("\n"); 
		query.append("           AND SMRY.DIR_CD = @[bound]" ).append("\n"); 
		query.append("           AND SMRY.CTRT_RHQ_CD = @[ofcCd]" ).append("\n"); 
		query.append("           AND SMRY.MQTA_MDL_VER_NO = @[mqtaMdlVerNo]" ).append("\n"); 
		query.append("           AND ADJ.BSE_YR = @[year]" ).append("\n"); 
		query.append("           AND ADJ.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("           AND ADJ.GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("           AND ADJ.TRD_CD = @[trade]" ).append("\n"); 
		query.append("           AND ADJ.DIR_CD = @[bound]" ).append("\n"); 
		query.append("           AND SMRY.RLANE_CD >= '0'" ).append("\n"); 
		query.append("           AND    SMRY.BSE_MON BETWEEN  DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10')" ).append("\n"); 
		query.append("           AND                       DECODE(@[bse_quarter],'1Q','03','2Q','06','3Q','09','4Q','12')" ).append("\n"); 
		query.append("           AND MIX.BSE_YR = @[year]" ).append("\n"); 
		query.append("           AND MIX.TRD_CD = @[trade]" ).append("\n"); 
		query.append("           AND MIX.DIR_CD = @[bound]" ).append("\n"); 
		query.append("           AND MIX.CTRT_RHQ_CD = @[ofcCd]" ).append("\n"); 
		query.append("           AND SMRY.BSE_YR = MIX.BSE_YR" ).append("\n"); 
		query.append("           AND SMRY.TRD_CD = MIX.TRD_CD" ).append("\n"); 
		query.append("           AND SMRY.DIR_CD = MIX.DIR_CD" ).append("\n"); 
		query.append("           AND SMRY.RLANE_CD = MIX.RLANE_CD" ).append("\n"); 
		query.append("           AND SMRY.CTRT_RHQ_CD = MIX.CTRT_RHQ_CD" ).append("\n"); 
		query.append("           AND SMRY.BSE_MON = MIX.BSE_MON" ).append("\n"); 
		query.append("           AND SMRY.SAQ_SVC_MOD_CD = MIX.SAQ_SVC_MOD_CD" ).append("\n"); 
		query.append("           AND    SMRY.BSE_MON = ADJ.BSE_MON" ).append("\n"); 
		query.append("           AND    SMRY.TRD_CD = ADJ.TRD_CD" ).append("\n"); 
		query.append("           AND    SMRY.RLANE_CD = ADJ.RLANE_CD" ).append("\n"); 
		query.append("           AND    SMRY.DIR_CD = ADJ.DIR_CD" ).append("\n"); 
		query.append("           AND    SMRY.VSL_CD = ADJ.VSL_CD" ).append("\n"); 
		query.append("           AND    SMRY.SKD_VOY_NO = ADJ.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND    SMRY.SKD_DIR_CD = ADJ.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND ADJ.SPRT_GRP_CD = MIX.SPRT_GRP_CD" ).append("\n"); 
		query.append("           AND ADJ.BSA_GRP_CD = MIX.BSA_GRP_CD" ).append("\n"); 
		query.append("     ) SMRY" ).append("\n"); 
		query.append(" ) SMRY" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("          SMRY.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("         ,SMRY.BSE_YR" ).append("\n"); 
		query.append("         ,SMRY.BSE_MON" ).append("\n"); 
		query.append("         ,SMRY.TRD_CD" ).append("\n"); 
		query.append("         ,SMRY.RLANE_CD" ).append("\n"); 
		query.append("         ,SMRY.DIR_CD" ).append("\n"); 
		query.append("         ,SMRY.VSL_CD" ).append("\n"); 
		query.append("         ,SMRY.SKD_VOY_NO" ).append("\n"); 
		query.append("         ,SMRY.SKD_DIR_CD" ).append("\n"); 
		query.append("         ,SMRY.CTRT_RGN_OFC_CD" ).append("\n"); 
		query.append("         ,SMRY.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("         ,SMRY.CUST_CNT_CD" ).append("\n"); 
		query.append("         ,SMRY.CUST_SEQ" ).append("\n"); 
		query.append("         ,SMRY.POL_CD" ).append("\n"); 
		query.append("         ,SMRY.POD_CD" ).append("\n"); 
		query.append("         ,SMRY.SUB_TRD_CD" ).append("\n"); 
		query.append("         ,SMRY.CTRT_RHQ_CD" ).append("\n"); 
		query.append("         ,SMRY.CTRT_AQ_CD" ).append("\n"); 
		query.append("         ,SMRY.SLS_RHQ_CD" ).append("\n"); 
		query.append("         ,SMRY.SLS_AQ_CD" ).append("\n"); 
		query.append("         ,SMRY.CUST_GRP_ID" ).append("\n"); 

	}
}
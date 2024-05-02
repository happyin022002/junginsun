/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOCreateLaneAdjustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOCreateLaneAdjustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기존 rlane 에 해당되는 Data를 새로운 rlane Data로 생성한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOCreateLaneAdjustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOCreateLaneAdjustCSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("          MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         ,SLS_FCAST_NO " ).append("\n"); 
		query.append("         ,ALTN_FCAST_SEQ " ).append("\n"); 
		query.append("         ,RLANE_CD " ).append("\n"); 
		query.append("         ,DIR_CD " ).append("\n"); 
		query.append("         ,VSL_CD " ).append("\n"); 
		query.append("         ,SKD_VOY_NO " ).append("\n"); 
		query.append("         ,SKD_DIR_CD " ).append("\n"); 
		query.append("         ,CUST_CNT_CD " ).append("\n"); 
		query.append("         ,CUST_SEQ " ).append("\n"); 
		query.append("         ,CTRT_OFC_CD " ).append("\n"); 
		query.append("         ,SLS_OFC_CD " ).append("\n"); 
		query.append("         ,POR_CD " ).append("\n"); 
		query.append("         ,DEL_CD " ).append("\n"); 
		query.append("         ,N1ST_POL_CD " ).append("\n"); 
		query.append("         ,LST_POD_CD " ).append("\n"); 
		query.append("         ,TRNK_POL_CD " ).append("\n"); 
		query.append("         ,TRNK_POD_CD " ).append("\n"); 
		query.append("         ,FCAST_CNTR_TPSZ_CD " ).append("\n"); 
		query.append("         ,LOD_QTY " ).append("\n"); 
		query.append("         ,CNTR_WGT " ).append("\n"); 
		query.append("         ,GRS_RPB_REV " ).append("\n"); 
		query.append("         ,CM_UC_AMT " ).append("\n"); 
		query.append("         ,OPFIT_UC_AMT " ).append("\n"); 
		query.append("         ,RA_CM_UC_AMT " ).append("\n"); 
		query.append("         ,RA_STP_PFIT_UT_AMT " ).append("\n"); 
		query.append("         ,RA_OPFIT_UC_AMT " ).append("\n"); 
		query.append("         ,MDL_RSLT_FLG " ).append("\n"); 
		query.append("         ,MDL_ALOC_QTY " ).append("\n"); 
		query.append("         ,REP_TRD_CD " ).append("\n"); 
		query.append("         ,REP_SUB_TRD_CD " ).append("\n"); 
		query.append("         ,TRD_CD " ).append("\n"); 
		query.append("         ,SUB_TRD_CD " ).append("\n"); 
		query.append("         ,IOC_CD " ).append("\n"); 
		query.append("         ,CTRT_RHQ_CD " ).append("\n"); 
		query.append("         ,CTRT_AQ_CD " ).append("\n"); 
		query.append("         ,CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("         ,CTRT_SREP_CD " ).append("\n"); 
		query.append("         ,SLS_RHQ_CD " ).append("\n"); 
		query.append("         ,SLS_AQ_CD " ).append("\n"); 
		query.append("         ,SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("         ,SREP_CD " ).append("\n"); 
		query.append("         ,COST_ASGN_STEP_CD " ).append("\n"); 
		query.append("         ,LGS_COST_ASGN_STEP_CD " ).append("\n"); 
		query.append("         ,SVC_MOD_CD " ).append("\n"); 
		query.append("         ,SAQ_SVC_MOD_CD " ).append("\n"); 
		query.append("         ,FULL_STVG_UC_AMT " ).append("\n"); 
		query.append("         ,FULL_TRSP_UC_AMT " ).append("\n"); 
		query.append("         ,MTY_STVG_UC_AMT " ).append("\n"); 
		query.append("         ,MTY_TRSP_UC_AMT " ).append("\n"); 
		query.append("         ,CNTR_FX_UC_AMT " ).append("\n"); 
		query.append("         ,CHSS_FX_UC_AMT " ).append("\n"); 
		query.append("         ,AGN_COMM_UT_AMT " ).append("\n"); 
		query.append("         ,BIZ_ACT_UC_AMT " ).append("\n"); 
		query.append("         ,SLT_MGMT_UC_AMT " ).append("\n"); 
		query.append("         ,OWN_VOL_ACT_UC_AMT " ).append("\n"); 
		query.append("         ,STP_UC_AMT " ).append("\n"); 
		query.append("         ,EQ_HLD_UC_AMT " ).append("\n"); 
		query.append("         ,EQ_REPO_UC_AMT " ).append("\n"); 
		query.append("         ,EQ_SIM_UC_AMT " ).append("\n"); 
		query.append("         ,DMDT_UT_AMT " ).append("\n"); 
		query.append("         ,TML_VOL_INCNT_AMT " ).append("\n"); 
		query.append("         ,SAQ_MISC_REV_AMT " ).append("\n"); 
		query.append("         ,CUST_GRP_ID " ).append("\n"); 
		query.append("         ,DMND_FCAST_UT_NM " ).append("\n"); 
		query.append("         ,DMND_FCAST_GRP_NM " ).append("\n"); 
		query.append("         ,DMND_FCAST_EQ_TPSZ_NO " ).append("\n"); 
		query.append("         ,ST_DT " ).append("\n"); 
		query.append("         ,CRE_USR_ID " ).append("\n"); 
		query.append("         ,CRE_DT " ).append("\n"); 
		query.append("         ,UPD_USR_ID " ).append("\n"); 
		query.append("         ,UPD_DT " ).append("\n"); 
		query.append("         ,ORG_LOD_QTY " ).append("\n"); 
		query.append("         ,ORG_GRS_RPB_REV " ).append("\n"); 
		query.append("         ,ORG_CM_UC_AMT " ).append("\n"); 
		query.append("         ,FCAST_TRNS_STS_CD " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     ," ).append("\n"); 
		query.append("       (SELECT MAX(SLS_FCAST_NO)" ).append("\n"); 
		query.append("         FROM SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("       ) + ROWNUM AS SLS_FCAST_NO " ).append("\n"); 
		query.append("     ,ALTN_FCAST_SEQ " ).append("\n"); 
		query.append("     ,@[org_rlane_cd] AS RLANE_CD " ).append("\n"); 
		query.append("     ,DIR_CD " ).append("\n"); 
		query.append("     ,VSL_CD " ).append("\n"); 
		query.append("     ,SKD_VOY_NO " ).append("\n"); 
		query.append("     ,SKD_DIR_CD " ).append("\n"); 
		query.append("     ,CUST_CNT_CD " ).append("\n"); 
		query.append("     ,CUST_SEQ " ).append("\n"); 
		query.append("     ,CTRT_OFC_CD " ).append("\n"); 
		query.append("     ,SLS_OFC_CD " ).append("\n"); 
		query.append("     ,POR_CD " ).append("\n"); 
		query.append("     ,DEL_CD " ).append("\n"); 
		query.append("     ,N1ST_POL_CD " ).append("\n"); 
		query.append("     ,LST_POD_CD " ).append("\n"); 
		query.append("     ,TRNK_POL_CD " ).append("\n"); 
		query.append("     ,TRNK_POD_CD " ).append("\n"); 
		query.append("     ,FCAST_CNTR_TPSZ_CD " ).append("\n"); 
		query.append("     ,LOD_QTY " ).append("\n"); 
		query.append("     ,CNTR_WGT " ).append("\n"); 
		query.append("     ,GRS_RPB_REV " ).append("\n"); 
		query.append("     ,CM_UC_AMT " ).append("\n"); 
		query.append("     ,OPFIT_UC_AMT " ).append("\n"); 
		query.append("     ,RA_CM_UC_AMT " ).append("\n"); 
		query.append("     ,RA_STP_PFIT_UT_AMT " ).append("\n"); 
		query.append("     ,RA_OPFIT_UC_AMT " ).append("\n"); 
		query.append("     ,MDL_RSLT_FLG " ).append("\n"); 
		query.append("     ,MDL_ALOC_QTY " ).append("\n"); 
		query.append("     ,REP_TRD_CD " ).append("\n"); 
		query.append("     ,REP_SUB_TRD_CD " ).append("\n"); 
		query.append("     ,TRD_CD " ).append("\n"); 
		query.append("     ,SUB_TRD_CD " ).append("\n"); 
		query.append("     ,IOC_CD " ).append("\n"); 
		query.append("     ,CTRT_RHQ_CD " ).append("\n"); 
		query.append("     ,CTRT_AQ_CD " ).append("\n"); 
		query.append("     ,CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("     ,CTRT_SREP_CD " ).append("\n"); 
		query.append("     ,SLS_RHQ_CD " ).append("\n"); 
		query.append("     ,SLS_AQ_CD " ).append("\n"); 
		query.append("     ,SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("     ,SREP_CD " ).append("\n"); 
		query.append("     ,COST_ASGN_STEP_CD " ).append("\n"); 
		query.append("     ,LGS_COST_ASGN_STEP_CD " ).append("\n"); 
		query.append("     ,SVC_MOD_CD " ).append("\n"); 
		query.append("     ,SAQ_SVC_MOD_CD " ).append("\n"); 
		query.append("     ,FULL_STVG_UC_AMT " ).append("\n"); 
		query.append("     ,FULL_TRSP_UC_AMT " ).append("\n"); 
		query.append("     ,MTY_STVG_UC_AMT " ).append("\n"); 
		query.append("     ,MTY_TRSP_UC_AMT " ).append("\n"); 
		query.append("     ,CNTR_FX_UC_AMT " ).append("\n"); 
		query.append("     ,CHSS_FX_UC_AMT " ).append("\n"); 
		query.append("     ,AGN_COMM_UT_AMT " ).append("\n"); 
		query.append("     ,BIZ_ACT_UC_AMT " ).append("\n"); 
		query.append("     ,SLT_MGMT_UC_AMT " ).append("\n"); 
		query.append("     ,OWN_VOL_ACT_UC_AMT " ).append("\n"); 
		query.append("     ,STP_UC_AMT " ).append("\n"); 
		query.append("     ,EQ_HLD_UC_AMT " ).append("\n"); 
		query.append("     ,EQ_REPO_UC_AMT " ).append("\n"); 
		query.append("     ,EQ_SIM_UC_AMT " ).append("\n"); 
		query.append("     ,DMDT_UT_AMT " ).append("\n"); 
		query.append("     ,TML_VOL_INCNT_AMT " ).append("\n"); 
		query.append("     ,SAQ_MISC_REV_AMT " ).append("\n"); 
		query.append("     ,CUST_GRP_ID " ).append("\n"); 
		query.append("     ,DMND_FCAST_UT_NM " ).append("\n"); 
		query.append("     ,DMND_FCAST_GRP_NM " ).append("\n"); 
		query.append("     ,DMND_FCAST_EQ_TPSZ_NO " ).append("\n"); 
		query.append("     ,ST_DT " ).append("\n"); 
		query.append("     ,CRE_USR_ID " ).append("\n"); 
		query.append("     ,CRE_DT " ).append("\n"); 
		query.append("     ,@[user_id] AS UPD_USR_ID " ).append("\n"); 
		query.append("     ,SYSDATE AS UPD_DT " ).append("\n"); 
		query.append("     ,ORG_LOD_QTY " ).append("\n"); 
		query.append("     ,ORG_GRS_RPB_REV " ).append("\n"); 
		query.append("     ,ORG_CM_UC_AMT " ).append("\n"); 
		query.append("     ,'0' AS FCAST_TRNS_STS_CD " ).append("\n"); 
		query.append("  FROM SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("       AND TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("       AND SUB_TRD_CD = @[sub_trd_cd] " ).append("\n"); 
		query.append("       AND RLANE_CD = @[rlane_cd]" ).append("\n"); 

	}
}
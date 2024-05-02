/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOSearchFcmDepRptPastClsHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOSearchFcmDepRptPastClsHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM DEPARTURE REPORT ERROR Past Cleansing History 조회 쿼리 - FcmDepRptErrClsVO 형태
	  * </pre>
	  */
	public VesselReportDBDAOSearchFcmDepRptPastClsHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchFcmDepRptPastClsHisRSQL").append("\n"); 
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
		query.append("SELECT DEP_RPT_CLS_SEQ ," ).append("\n"); 
		query.append("       VSL_CD ," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       	SELECT CNTR_DZN_CAPA" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("        WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("        AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ) AS CNTR_DZN_CAPA ," ).append("\n"); 
		query.append("       VSL_CD ," ).append("\n"); 
		query.append("       CONCAT(SKD_VOY_NO, SKD_DIR_CD) AS SKD_VOY_NO ," ).append("\n"); 
		query.append("       SKD_DIR_CD ," ).append("\n"); 
		query.append("       DEP_PORT_CD ," ).append("\n"); 
		query.append("       CLPT_IND_SEQ ," ).append("\n"); 
		query.append("       DECODE(DEP_RPT_ERR_TP_CD,'PM','PK Mismatched'" ).append("\n"); 
		query.append("        ,DECODE(DEP_RPT_ERR_TP_CD,'PO','PK Overlap'" ).append("\n"); 
		query.append("         ,DECODE(DEP_RPT_ERR_TP_CD,'IE','Item Error'" ).append("\n"); 
		query.append("          ,DECODE(DEP_RPT_ERR_TP_CD,'IM','Item Missing'" ).append("\n"); 
		query.append("           ,DECODE(DEP_RPT_ERR_TP_CD,'MC','Multi Calling'" ).append("\n"); 
		query.append("            ,DECODE(DEP_RPT_ERR_TP_CD,'LM','Last Report Missing'" ).append("\n"); 
		query.append("       )))))) AS DEP_RPT_ERR_TP_CD," ).append("\n"); 
		query.append("       VSL_SLAN_CD ," ).append("\n"); 
		query.append("       NVGT_ML_DIST_CTNT ," ).append("\n"); 
		query.append("       ENG_ML_DIST_CTNT ," ).append("\n"); 
		query.append("       MNVR_IN_ML_DIST_CTNT ," ).append("\n"); 
		query.append("       MNVR_OUT_ML_DIST_CTNT ," ).append("\n"); 
		query.append("       AVG_SPD_CTNT ," ).append("\n"); 
		query.append("       AVG_RPM_PWR_CTNT ," ).append("\n"); 
		query.append("       ARR_FOIL_CTNT ," ).append("\n"); 
		query.append("       ARR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       ARR_DOIL_CTNT ," ).append("\n"); 
		query.append("       ARR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       DEP_FOIL_CTNT ," ).append("\n"); 
		query.append("       DEP_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       DEP_DOIL_CTNT ," ).append("\n"); 
		query.append("       DEP_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_MN_FOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_GNR_FOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_BLR_FOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_MN_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_GNR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_BLR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_MN_DOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_GNR_DOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_BLR_DOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_MN_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_GNR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_BLR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_MN_FOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_GNR_FOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_BLR_FOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_MN_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_GNR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_BLR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_MN_DOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_GNR_DOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_BLR_DOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_MN_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_GNR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       PORT_BLR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       SPL_FOIL_BDR_CTNT ," ).append("\n"); 
		query.append("       SPL_FOIL_ACT_CTNT ," ).append("\n"); 
		query.append("       SPL_FOIL_SULP_CTNT ," ).append("\n"); 
		query.append("       SPL_LOW_SULP_FOIL_BDR_CTNT ," ).append("\n"); 
		query.append("       SPL_LOW_SULP_FOIL_ACT_CTNT ," ).append("\n"); 
		query.append("       SPL_LOW_SULP_FOIL_SULP_CTNT ," ).append("\n"); 
		query.append("       SPL_DOIL_BDR_CTNT ," ).append("\n"); 
		query.append("       SPL_DOIL_ACT_CTNT ," ).append("\n"); 
		query.append("       SPL_DOIL_SULP_CTNT ," ).append("\n"); 
		query.append("       SPL_LOW_SULP_DOIL_BDR_CTNT ," ).append("\n"); 
		query.append("       SPL_LOW_SULP_DOIL_ACT_CTNT ," ).append("\n"); 
		query.append("       SPL_LOW_SULP_DOIL_SULP_CTNT ," ).append("\n"); 
		query.append("       NXT_PORT_CD ," ).append("\n"); 
		query.append("       NVL2(NXT_PORT_ETA_DT,TO_CHAR(NXT_PORT_ETA_DT, 'YYYYMMDDHH24MI'),'') AS NXT_PORT_ETA_DT," ).append("\n"); 
		query.append("       RMN_DIST_CTNT ," ).append("\n"); 
		query.append("       RMN_AVG_SPD_CTNT ," ).append("\n"); 
		query.append("       NVL2(SB_ENG_DT,TO_CHAR(SB_ENG_DT, 'YYYYMMDDHH24MI'),'') AS SB_ENG_DT," ).append("\n"); 
		query.append("       NVL2(PLT_IN_DT,TO_CHAR(PLT_IN_DT, 'YYYYMMDDHH24MI'),'') AS PLT_IN_DT," ).append("\n"); 
		query.append("       NVL2(BFR_BRTH_ANK_DRP_DT,TO_CHAR(BFR_BRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI'),'') AS BFR_BRTH_ANK_DRP_DT," ).append("\n"); 
		query.append("       NVL2(BFR_BRTH_ANK_OFF_DT,TO_CHAR(BFR_BRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI'),'') AS BFR_BRTH_ANK_OFF_DT," ).append("\n"); 
		query.append("       NVL2(VPS_ETB_DT,TO_CHAR(VPS_ETB_DT, 'YYYYMMDDHH24MI'),'') AS VPS_ETB_DT," ).append("\n"); 
		query.append("       NVL2(CGO_WRK_ST_DT,TO_CHAR(CGO_WRK_ST_DT, 'YYYYMMDDHH24MI'),'') AS CGO_WRK_ST_DT," ).append("\n"); 
		query.append("       NVL2(CGO_WRK_END_DT,TO_CHAR(CGO_WRK_END_DT, 'YYYYMMDDHH24MI'),'') AS CGO_WRK_END_DT," ).append("\n"); 
		query.append("       NVL2(VPS_ETD_DT,TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI'),'') AS VPS_ETD_DT," ).append("\n"); 
		query.append("       NVL2(AFT_UNBRTH_ANK_DRP_DT,TO_CHAR(AFT_UNBRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI'),'') AS AFT_UNBRTH_ANK_DRP_DT," ).append("\n"); 
		query.append("       NVL2(AFT_UNBRTH_ANK_OFF_DT,TO_CHAR(AFT_UNBRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI'),'') AS AFT_UNBRTH_ANK_OFF_DT," ).append("\n"); 
		query.append("       NVL2(PLT_OUT_DT,TO_CHAR(PLT_OUT_DT, 'YYYYMMDDHH24MI'),'') AS PLT_OUT_DT," ).append("\n"); 
		query.append("       NVL2(RUP_DT,TO_CHAR(RUP_DT, 'YYYYMMDDHH24MI'),'') AS RUP_DT," ).append("\n"); 
		query.append("       ARR_FWDDR_CTNT ," ).append("\n"); 
		query.append("       ARR_MID_DRFT_CTNT ," ).append("\n"); 
		query.append("       ARR_AFTDR_CTNT ," ).append("\n"); 
		query.append("       ARR_GM_CTNT ," ).append("\n"); 
		query.append("       DEP_FWDDR_CTNT ," ).append("\n"); 
		query.append("       DEP_MID_DRFT_CTNT ," ).append("\n"); 
		query.append("       DEP_AFTDR_CTNT ," ).append("\n"); 
		query.append("       DEP_GM_CTNT ," ).append("\n"); 
		query.append("       FCNTR_OBRD_TEU_CTNT ," ).append("\n"); 
		query.append("       MCNTR_OBRD_TEU_CTNT ," ).append("\n"); 
		query.append("       TTL_CNTR_OBRD_TEU_CTNT ," ).append("\n"); 
		query.append("       DEP_CGO_CTNT ," ).append("\n"); 
		query.append("       DEP_DPL_CTNT ," ).append("\n"); 
		query.append("       RF_CNTR_DCHG_KNT_CTNT ," ).append("\n"); 
		query.append("       RF_CNTR_LOD_KNT_CTNT ," ).append("\n"); 
		query.append("       RF_CNTR_OBRD_KNT_CTNT ," ).append("\n"); 
		query.append("       OLD_VSL_CD ," ).append("\n"); 
		query.append("       OLD_SKD_VOY_NO ," ).append("\n"); 
		query.append("       OLD_SKD_DIR_CD ," ).append("\n"); 
		query.append("       OLD_DEP_PORT_CD ," ).append("\n"); 
		query.append("       OLD_CLPT_IND_SEQ ," ).append("\n"); 
		query.append("       CRE_USR_ID ," ).append("\n"); 
		query.append("       CRE_DT ," ).append("\n"); 
		query.append("       UPD_USR_ID ," ).append("\n"); 
		query.append("       UPD_DT ," ).append("\n"); 
		query.append("       LST_DEP_PORT_CD ," ).append("\n"); 
		query.append("       AVG_PRLR_PCH_VAL ," ).append("\n"); 
		query.append("       SAIL_TM_HRS ," ).append("\n"); 
		query.append("       LST_DEP_FOIL_CTNT ," ).append("\n"); 
		query.append("       LST_DEP_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       LST_DEP_DOIL_CTNT ," ).append("\n"); 
		query.append("       LST_DEP_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_STMNG_MN_ENG_TTL_QTY ," ).append("\n"); 
		query.append("       AVG_PORT_TTL_QTY ," ).append("\n"); 
		query.append("       AVG_PORT_TTL_HR_QTY ," ).append("\n"); 
		query.append("       NVL2(LST_PORT_RUP_DT,TO_CHAR(LST_PORT_RUP_DT, 'YYYYMMDDHH24MI'),'') AS LST_PORT_RUP_DT" ).append("\n"); 
		query.append("  FROM FCM_DEP_RPT_CLS_HIS" ).append("\n"); 
		query.append("  WHERE VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("  AND SKD_VOY_NO = SUBSTR(@[skd_voy_no], 1,4) " ).append("\n"); 
		query.append("  AND SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("  AND DEP_PORT_CD = @[dep_port_cd] " ).append("\n"); 
		query.append("  AND CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("  AND DEP_RPT_ERR_TP_CD NOT IN ('PM', 'MC', 'LM')" ).append("\n"); 
		query.append("  ORDER BY DEP_RPT_CLS_SEQ DESC" ).append("\n"); 

	}
}
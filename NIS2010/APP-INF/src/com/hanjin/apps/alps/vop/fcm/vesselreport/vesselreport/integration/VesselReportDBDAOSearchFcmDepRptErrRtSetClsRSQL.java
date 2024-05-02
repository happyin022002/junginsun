/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOSearchFcmDepRptErrRtSetClsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
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

public class VesselReportDBDAOSearchFcmDepRptErrRtSetClsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM DEPARTURE REPORT ERROR RATE SETTING 조회 쿼리 - FcmDepRptErrClsVO 형태
	  * </pre>
	  */
	public VesselReportDBDAOSearchFcmDepRptErrRtSetClsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchFcmDepRptErrRtSetClsRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD ," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       	SELECT CNTR_DZN_CAPA" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("        WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("        AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ) AS CNTR_DZN_CAPA," ).append("\n"); 
		query.append("       NVGT_ML_DIST_RT AS NVGT_ML_DIST_CTNT ," ).append("\n"); 
		query.append("       ENG_ML_DIST_RT AS ENG_ML_DIST_CTNT ," ).append("\n"); 
		query.append("       MNVR_IN_ML_DIST_RT AS MNVR_IN_ML_DIST_CTNT ," ).append("\n"); 
		query.append("       MNVR_OUT_ML_DIST_RT AS MNVR_OUT_ML_DIST_CTNT ," ).append("\n"); 
		query.append("       AVG_SPD_RT AS AVG_SPD_CTNT ," ).append("\n"); 
		query.append("       AVG_RPM_PWR_RT AS AVG_RPM_PWR_CTNT ," ).append("\n"); 
		query.append("       PRLR_PCH_RT AS AVG_PRLR_PCH_VAL ," ).append("\n"); 
		query.append("       SAIL_TM_RT AS SAIL_TM_HRS ," ).append("\n"); 
		query.append("       ARR_FOIL_RT AS ARR_FOIL_CTNT ," ).append("\n"); 
		query.append("       ARR_LOW_SULP_FOIL_RT AS ARR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       ARR_DOIL_RT AS ARR_DOIL_CTNT ," ).append("\n"); 
		query.append("       ARR_LOW_SULP_DOIL_RT AS ARR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       DEP_FOIL_RT AS DEP_FOIL_CTNT ," ).append("\n"); 
		query.append("       DEP_LOW_SULP_FOIL_RT AS DEP_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("       DEP_DOIL_RT AS DEP_DOIL_CTNT ," ).append("\n"); 
		query.append("       DEP_LOW_SULP_DOIL_RT AS DEP_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("       SEA_STMNG_MN_ENG_RT AS SEA_STMNG_MN_ENG_TTL_QTY ," ).append("\n"); 
		query.append("       PORT_TTL_RT AS AVG_PORT_TTL_QTY ," ).append("\n"); 
		query.append("       PORT_TTL_HR_RT_RT AS AVG_PORT_TTL_HR_QTY ," ).append("\n"); 
		query.append("       SB_ENG_DT_RT AS SB_ENG_DT ," ).append("\n"); 
		query.append("       PLT_IN_DT_RT AS PLT_IN_DT ," ).append("\n"); 
		query.append("       BFR_BRTH_ANK_DRP_DT_RT AS BFR_BRTH_ANK_DRP_DT ," ).append("\n"); 
		query.append("       BFR_BRTH_ANK_OFF_DT_RT AS BFR_BRTH_ANK_OFF_DT ," ).append("\n"); 
		query.append("       VPS_ETB_DT_RT AS VPS_ETB_DT ," ).append("\n"); 
		query.append("       CGO_WRK_ST_DT_RT AS CGO_WRK_ST_DT ," ).append("\n"); 
		query.append("       CGO_WRK_END_DT_RT AS CGO_WRK_END_DT ," ).append("\n"); 
		query.append("       VPS_ETD_DT_RT AS VPS_ETD_DT ," ).append("\n"); 
		query.append("       AFT_UNBRTH_ANK_DRP_DT_RT AS AFT_UNBRTH_ANK_DRP_DT ," ).append("\n"); 
		query.append("       AFT_UNBRTH_ANK_OFF_DT_RT AS AFT_UNBRTH_ANK_OFF_DT ," ).append("\n"); 
		query.append("       PLT_OUT_DT_RT AS PLT_OUT_DT ," ).append("\n"); 
		query.append("       RUP_DT_RT AS RUP_DT ," ).append("\n"); 
		query.append("       FCNTR_OBRD_TEU_RT AS FCNTR_OBRD_TEU_CTNT ," ).append("\n"); 
		query.append("       MCNTR_OBRD_TEU_RT AS MCNTR_OBRD_TEU_CTNT ," ).append("\n"); 
		query.append("       TTL_CNTR_OBRD_TEU_RT AS TTL_CNTR_OBRD_TEU_CTNT ," ).append("\n"); 
		query.append("       DEP_CGO_RT AS DEP_CGO_CTNT ," ).append("\n"); 
		query.append("       RF_CNTR_DCHG_KNT_RT AS RF_CNTR_DCHG_KNT_CTNT ," ).append("\n"); 
		query.append("       RF_CNTR_LOD_KNT_RT AS RF_CNTR_LOD_KNT_CTNT ," ).append("\n"); 
		query.append("       RF_CNTR_OBRD_KNT_RT AS RF_CNTR_OBRD_KNT_CTNT ," ).append("\n"); 
		query.append("       CRE_USR_ID ," ).append("\n"); 
		query.append("       CRE_DT ," ).append("\n"); 
		query.append("       UPD_USR_ID ," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM FCM_DEP_RPT_ERR_RT_SET T1 WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportDBDAOFcmDepRptVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOFcmDepRptVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM_DEP_RPT - insert
	  * </pre>
	  */
	public VesselReportDBDAOFcmDepRptVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration ").append("\n"); 
		query.append("FileName : VesselReportDBDAOFcmDepRptVOCSQL").append("\n"); 
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
		query.append("INSERT INTO FCM_DEP_RPT" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SUBSTR(VOY_DIR_CD, 1, 4) SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(VOY_DIR_CD, 5, 1) SKD_DIR_CD," ).append("\n"); 
		query.append("DEP_PORT_CD," ).append("\n"); 
		query.append("DECODE(CLPT_IND_SEQ, 'F', '1', 'S', '2', 'T', '3') CLPT_IND_SEQ," ).append("\n"); 
		query.append("REF_NO," ).append("\n"); 
		query.append("VSL_SLAN_CD," ).append("\n"); 
		query.append("GMT_TD_HRS," ).append("\n"); 
		query.append("NXT_PORT_CD," ).append("\n"); 
		query.append("DEP_STS_CD," ).append("\n"); 
		query.append("RMN_DIST," ).append("\n"); 
		query.append("RMN_AVG_SPD," ).append("\n"); 
		query.append("NXT_PORT_ETA_DT," ).append("\n"); 
		query.append("SB_ENG_DT," ).append("\n"); 
		query.append("PLT_IN_DT," ).append("\n"); 
		query.append("BFR_BRTH_ANK_DRP_DT," ).append("\n"); 
		query.append("BFR_BRTH_ANK_OFF_DT," ).append("\n"); 
		query.append("VPS_ETB_DT," ).append("\n"); 
		query.append("CGO_WRK_ST_DT," ).append("\n"); 
		query.append("CGO_WRK_END_DT," ).append("\n"); 
		query.append("VPS_ETD_DT," ).append("\n"); 
		query.append("AFT_UNBRTH_ANK_DRP_DT," ).append("\n"); 
		query.append("AFT_UNBRTH_ANK_OFF_DT," ).append("\n"); 
		query.append("PLT_OUT_DT," ).append("\n"); 
		query.append("RUP_DT," ).append("\n"); 
		query.append("MNVR_IN_ML_DIST," ).append("\n"); 
		query.append("MNVR_OUT_ML_DIST," ).append("\n"); 
		query.append("NVGT_ML_DIST," ).append("\n"); 
		query.append("ENG_ML_DIST," ).append("\n"); 
		query.append("AVG_SPD," ).append("\n"); 
		query.append("AVG_RPM_PWR," ).append("\n"); 
		query.append("RUN_HRS_IN_HV_WE," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, 1,                                INSTR(DET_RSN_CTNT, '|', 1, 1) - 1), 1, 1)                                SEA_DET_RSN_CD1  ," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, 1,                                INSTR(DET_RSN_CTNT, '|', 1, 1) - 1), 2)                                   SEA_DET_RSN_HRS1 ," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 1)+1, INSTR(DET_RSN_CTNT, '|', 1, 2) - INSTR(DET_RSN_CTNT, '|', 1, 1)-1), 1, 1) SEA_DET_RSN_CD2  ," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 1)+1, INSTR(DET_RSN_CTNT, '|', 1, 2) - INSTR(DET_RSN_CTNT, '|', 1, 1)-1), 2)    SEA_DET_RSN_HRS2 ," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 2)+1, INSTR(DET_RSN_CTNT, '|', 1, 3) - INSTR(DET_RSN_CTNT, '|', 1, 2)-1), 1, 1) SEA_DET_RSN_CD3  ," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 2)+1, INSTR(DET_RSN_CTNT, '|', 1, 3) - INSTR(DET_RSN_CTNT, '|', 1, 2)-1), 2)    SEA_DET_RSN_HRS3 ," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 3)+1, INSTR(DET_RSN_CTNT, '|', 1, 4) - INSTR(DET_RSN_CTNT, '|', 1, 3)-1), 1, 1) PORT_DET_RSN_CD1 ," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 3)+1, INSTR(DET_RSN_CTNT, '|', 1, 4) - INSTR(DET_RSN_CTNT, '|', 1, 3)-1), 2)    PORT_DET_RSN_HRS1," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 4)+1, INSTR(DET_RSN_CTNT, '|', 1, 5) - INSTR(DET_RSN_CTNT, '|', 1, 4)-1), 1, 1) PORT_DET_RSN_CD2 ," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 4)+1, INSTR(DET_RSN_CTNT, '|', 1, 5) - INSTR(DET_RSN_CTNT, '|', 1, 4)-1), 2)    PORT_DET_RSN_HRS2," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 5)+1, INSTR(DET_RSN_CTNT, '|', 1, 6) - INSTR(DET_RSN_CTNT, '|', 1, 5)-1), 1, 1) PORT_DET_RSN_CD3 ," ).append("\n"); 
		query.append("SUBSTR(SUBSTR(DET_RSN_CTNT, INSTR(DET_RSN_CTNT, '|', 1, 5)+1, INSTR(DET_RSN_CTNT, '|', 1, 6) - INSTR(DET_RSN_CTNT, '|', 1, 5)-1), 2)    PORT_DET_RSN_HRS3," ).append("\n"); 
		query.append("SUBSTR(ARR_DRFT_CTNT,                                 1, INSTR(ARR_DRFT_CTNT, '|', 1, 1) -                                 1) ARR_FWDDR_HGT," ).append("\n"); 
		query.append("SUBSTR(ARR_DRFT_CTNT, INSTR(ARR_DRFT_CTNT, '|', 1, 1)+1, INSTR(ARR_DRFT_CTNT, '|', 1, 2) - INSTR(ARR_DRFT_CTNT, '|', 1, 1)-1) ARR_MID_DRFT_HGT," ).append("\n"); 
		query.append("SUBSTR(ARR_DRFT_CTNT, INSTR(ARR_DRFT_CTNT, '|', 1, 2)+1, INSTR(ARR_DRFT_CTNT, '|', 1, 3) - INSTR(ARR_DRFT_CTNT, '|', 1, 2)-1) ARR_AFTDR_HGT," ).append("\n"); 
		query.append("SUBSTR(ARR_DRFT_CTNT, INSTR(ARR_DRFT_CTNT, '|', 1, 3)+1, INSTR(ARR_DRFT_CTNT, '|', 1, 4) - INSTR(ARR_DRFT_CTNT, '|', 1, 3)-1) ARR_GM_HGT," ).append("\n"); 
		query.append("SUBSTR(ARR_ROB_CTNT,                                1, INSTR(ARR_ROB_CTNT, '|', 1, 1) -                                1) ARR_FOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(ARR_ROB_CTNT, INSTR(ARR_ROB_CTNT, '|', 1, 1)+1, INSTR(ARR_ROB_CTNT, '|', 1, 2) - INSTR(ARR_ROB_CTNT, '|', 1, 1)-1) ARR_DOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(ARR_ROB_CTNT, INSTR(ARR_ROB_CTNT, '|', 1, 2)+1, INSTR(ARR_ROB_CTNT, '|', 1, 3) - INSTR(ARR_ROB_CTNT, '|', 1, 2)-1) ARR_FRSH_WTR_WGT," ).append("\n"); 
		query.append("SUBSTR(ARR_ROB_CTNT, INSTR(ARR_ROB_CTNT, '|', 1, 3)+1, INSTR(ARR_ROB_CTNT, '|', 1, 4) - INSTR(ARR_ROB_CTNT, '|', 1, 3)-1) ARR_BLST_WGT," ).append("\n"); 
		query.append("SUBSTR(ARR_ROB_CTNT, INSTR(ARR_ROB_CTNT, '|', 1, 4)+1, INSTR(ARR_ROB_CTNT, '|', 1, 5) - INSTR(ARR_ROB_CTNT, '|', 1, 4)-1) ARR_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(ARR_ROB_CTNT, INSTR(ARR_ROB_CTNT, '|', 1, 5)+1, INSTR(ARR_ROB_CTNT, '|', 1, 6) - INSTR(ARR_ROB_CTNT, '|', 1, 5)-1) ARR_LOW_SULP_DOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(DEP_DRFT_CTNT,                                 1, INSTR(DEP_DRFT_CTNT, '|', 1, 1) -                                 1) DEP_FWDDR_HGT," ).append("\n"); 
		query.append("SUBSTR(DEP_DRFT_CTNT, INSTR(DEP_DRFT_CTNT, '|', 1, 1)+1, INSTR(DEP_DRFT_CTNT, '|', 1, 2) - INSTR(DEP_DRFT_CTNT, '|', 1, 1)-1) DEP_MID_DRFT_HGT," ).append("\n"); 
		query.append("SUBSTR(DEP_DRFT_CTNT, INSTR(DEP_DRFT_CTNT, '|', 1, 2)+1, INSTR(DEP_DRFT_CTNT, '|', 1, 3) - INSTR(DEP_DRFT_CTNT, '|', 1, 2)-1) DEP_AFTDR_HGT," ).append("\n"); 
		query.append("SUBSTR(DEP_DRFT_CTNT, INSTR(DEP_DRFT_CTNT, '|', 1, 3)+1, INSTR(DEP_DRFT_CTNT, '|', 1, 4) - INSTR(DEP_DRFT_CTNT, '|', 1, 3)-1) DEP_GM_HGT," ).append("\n"); 
		query.append("SUBSTR(DEP_ROB_CTNT,                                1, INSTR(DEP_ROB_CTNT, '|', 1, 1) -                                1) DEP_FOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(DEP_ROB_CTNT, INSTR(DEP_ROB_CTNT, '|', 1, 1)+1, INSTR(DEP_ROB_CTNT, '|', 1, 2) - INSTR(DEP_ROB_CTNT, '|', 1, 1)-1) DEP_DOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(DEP_ROB_CTNT, INSTR(DEP_ROB_CTNT, '|', 1, 2)+1, INSTR(DEP_ROB_CTNT, '|', 1, 3) - INSTR(DEP_ROB_CTNT, '|', 1, 2)-1) DEP_FRSH_WTR_WGT," ).append("\n"); 
		query.append("SUBSTR(DEP_ROB_CTNT, INSTR(DEP_ROB_CTNT, '|', 1, 3)+1, INSTR(DEP_ROB_CTNT, '|', 1, 4) - INSTR(DEP_ROB_CTNT, '|', 1, 3)-1) DEP_BLST_WGT," ).append("\n"); 
		query.append("SUBSTR(DEP_ROB_CTNT, INSTR(DEP_ROB_CTNT, '|', 1, 4)+1, INSTR(DEP_ROB_CTNT, '|', 1, 5) - INSTR(DEP_ROB_CTNT, '|', 1, 4)-1) DEP_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(DEP_ROB_CTNT, INSTR(DEP_ROB_CTNT, '|', 1, 5)+1, INSTR(DEP_ROB_CTNT, '|', 1, 6) - INSTR(DEP_ROB_CTNT, '|', 1, 5)-1) DEP_LOW_SULP_DOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(NXT_DRFT_CTNT,                                 1, INSTR(NXT_DRFT_CTNT, '|', 1, 1) -                                 1) NXT_FWDDR_HGT," ).append("\n"); 
		query.append("SUBSTR(NXT_DRFT_CTNT, INSTR(NXT_DRFT_CTNT, '|', 1, 1)+1, INSTR(NXT_DRFT_CTNT, '|', 1, 2) - INSTR(NXT_DRFT_CTNT, '|', 1, 1)-1) NXT_MID_DRFT_HGT," ).append("\n"); 
		query.append("SUBSTR(NXT_DRFT_CTNT, INSTR(NXT_DRFT_CTNT, '|', 1, 2)+1, INSTR(NXT_DRFT_CTNT, '|', 1, 3) - INSTR(NXT_DRFT_CTNT, '|', 1, 2)-1) NXT_AFTDR_HGT," ).append("\n"); 
		query.append("SUBSTR(NXT_DRFT_CTNT, INSTR(NXT_DRFT_CTNT, '|', 1, 3)+1, INSTR(NXT_DRFT_CTNT, '|', 1, 4) - INSTR(NXT_DRFT_CTNT, '|', 1, 3)-1) NXT_GM_HGT," ).append("\n"); 
		query.append("SUBSTR(NXT_ROB_CTNT,                                1, INSTR(NXT_ROB_CTNT, '|', 1, 1) -                                1) NXT_FOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(NXT_ROB_CTNT, INSTR(NXT_ROB_CTNT, '|', 1, 1)+1, INSTR(NXT_ROB_CTNT, '|', 1, 2) - INSTR(NXT_ROB_CTNT, '|', 1, 1)-1) NXT_DOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(NXT_ROB_CTNT, INSTR(NXT_ROB_CTNT, '|', 1, 2)+1, INSTR(NXT_ROB_CTNT, '|', 1, 3) - INSTR(NXT_ROB_CTNT, '|', 1, 2)-1) NXT_FRSH_WTR_WGT," ).append("\n"); 
		query.append("SUBSTR(NXT_ROB_CTNT, INSTR(NXT_ROB_CTNT, '|', 1, 3)+1, INSTR(NXT_ROB_CTNT, '|', 1, 4) - INSTR(NXT_ROB_CTNT, '|', 1, 3)-1) NXT_BLST_WGT," ).append("\n"); 
		query.append("SUBSTR(NXT_ROB_CTNT, INSTR(NXT_ROB_CTNT, '|', 1, 4)+1, INSTR(NXT_ROB_CTNT, '|', 1, 5) - INSTR(NXT_ROB_CTNT, '|', 1, 4)-1) NXT_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(NXT_ROB_CTNT, INSTR(NXT_ROB_CTNT, '|', 1, 5)+1, INSTR(NXT_ROB_CTNT, '|', 1, 6) - INSTR(NXT_ROB_CTNT, '|', 1, 5)-1) NXT_LOW_SULP_DOIL_WGT," ).append("\n"); 
		query.append("SUBSTR(SEA_FUEL_CSM_CTNT,                                     1, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 1) -                                     1) SEA_MN_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_FUEL_CSM_CTNT, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 1)+1, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 2) - INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 1)-1) SEA_GNR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_FUEL_CSM_CTNT, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 2)+1, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 3) - INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 2)-1) SEA_BLR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_FUEL_CSM_CTNT, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 3)+1, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 4) - INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 3)-1) SEA_MN_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_FUEL_CSM_CTNT, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 4)+1, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 5) - INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 4)-1) SEA_GNR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_FUEL_CSM_CTNT, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 5)+1, INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 6) - INSTR(SEA_FUEL_CSM_CTNT, '|', 1, 5)-1) SEA_BLR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_LOW_SULP_FUEL_CSM_CTNT,                                              1, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 1) -                                              1) SEA_MN_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 1)+1, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 2) - INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 1)-1) SEA_GNR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 2)+1, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 3) - INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 2)-1) SEA_BLR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 3)+1, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 4) - INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 3)-1) SEA_MN_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 4)+1, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 5) - INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 4)-1) SEA_GNR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 5)+1, INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 6) - INSTR(SEA_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 5)-1) SEA_BLR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_FUEL_CSM_CTNT,                                      1, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 1) -                                      1) PORT_MN_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_FUEL_CSM_CTNT, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 1)+1, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 2) - INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 1)-1) PORT_GNR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_FUEL_CSM_CTNT, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 2)+1, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 3) - INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 2)-1) PORT_BLR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_FUEL_CSM_CTNT, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 3)+1, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 4) - INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 3)-1) PORT_MN_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_FUEL_CSM_CTNT, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 4)+1, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 5) - INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 4)-1) PORT_GNR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_FUEL_CSM_CTNT, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 5)+1, INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 6) - INSTR(PORT_FUEL_CSM_CTNT, '|', 1, 5)-1) PORT_BLR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_LOW_SULP_FUEL_CSM_CTNT,                                               1, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 1) -                                               1) PORT_MN_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 1)+1, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 2) - INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 1)-1) PORT_GNR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 2)+1, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 3) - INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 2)-1) PORT_BLR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 3)+1, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 4) - INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 3)-1) PORT_MN_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 4)+1, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 5) - INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 4)-1) PORT_GNR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 5)+1, INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 6) - INSTR(PORT_LOW_SULP_FUEL_CSM_CTNT, '|', 1, 5)-1) PORT_BLR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT,                                1, INSTR(SPL_OIL_CTNT, '|', 1, 1) -                                1) SPL_FOIL_BDR_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1, 1)+1, INSTR(SPL_OIL_CTNT, '|', 1, 2) - INSTR(SPL_OIL_CTNT, '|', 1, 1)-1) SPL_FOIL_ACT_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1, 2)+1, INSTR(SPL_OIL_CTNT, '|', 1, 3) - INSTR(SPL_OIL_CTNT, '|', 1, 2)-1) SPL_FOIL_SULP_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1, 3)+1, INSTR(SPL_OIL_CTNT, '|', 1, 4) - INSTR(SPL_OIL_CTNT, '|', 1, 3)-1) SPL_FOIL_BRG_WGT1," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1, 4)+1, INSTR(SPL_OIL_CTNT, '|', 1, 5) - INSTR(SPL_OIL_CTNT, '|', 1, 4)-1) SPL_FOIL_BRG_WGT2," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1, 5)+1, INSTR(SPL_OIL_CTNT, '|', 1, 6) - INSTR(SPL_OIL_CTNT, '|', 1, 5)-1) SPL_DOIL_BDR_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1, 6)+1, INSTR(SPL_OIL_CTNT, '|', 1, 7) - INSTR(SPL_OIL_CTNT, '|', 1, 6)-1) SPL_DOIL_ACT_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1, 7)+1, INSTR(SPL_OIL_CTNT, '|', 1, 8) - INSTR(SPL_OIL_CTNT, '|', 1, 7)-1) SPL_DOIL_SULP_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1, 8)+1, INSTR(SPL_OIL_CTNT, '|', 1, 9) - INSTR(SPL_OIL_CTNT, '|', 1, 8)-1) SPL_DOIL_BRG_WGT1," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1, 9)+1, INSTR(SPL_OIL_CTNT, '|', 1,10) - INSTR(SPL_OIL_CTNT, '|', 1, 9)-1) SPL_DOIL_BRG_WGT2," ).append("\n"); 
		query.append("SUBSTR(SPL_OIL_CTNT, INSTR(SPL_OIL_CTNT, '|', 1,10)+1, INSTR(SPL_OIL_CTNT, '|', 1,11) - INSTR(SPL_OIL_CTNT, '|', 1,10)-1) SPL_FRSH_WTR_ACT_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT,                                         1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 1) -                                         1) SPL_LOW_SULP_FOIL_BDR_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 1)+1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 2) - INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 1)-1) SPL_LOW_SULP_FOIL_ACT_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 2)+1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 3) - INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 2)-1) SPL_LOW_SULP_FOIL_SULP_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 3)+1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 4) - INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 3)-1) SPL_LOW_SULP_FOIL_BRG_WGT1," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 4)+1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 5) - INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 4)-1) SPL_LOW_SULP_FOIL_BRG_WGT2," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 5)+1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 6) - INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 5)-1) SPL_LOW_SULP_DOIL_BDR_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 6)+1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 7) - INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 6)-1) SPL_LOW_SULP_DOIL_ACT_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 7)+1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 8) - INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 7)-1) SPL_LOW_SULP_DOIL_SULP_WGT," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 8)+1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 9) - INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 8)-1) SPL_LOW_SULP_DOIL_BRG_WGT1," ).append("\n"); 
		query.append("SUBSTR(SPL_LOW_SULP_OIL_CTNT, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 9)+1, INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1,10) - INSTR(SPL_LOW_SULP_OIL_CTNT, '|', 1, 9)-1) SPL_LOW_SULP_DOIL_BRG_WGT2," ).append("\n"); 
		query.append("SEA_DNST," ).append("\n"); 
		query.append("SUBSTR(CNTR_CGO_CTNT,                                 1, INSTR(CNTR_CGO_CTNT, '|', 1, 1) -                                 1) FULL_CNTR_OBRD_TEU," ).append("\n"); 
		query.append("SUBSTR(CNTR_CGO_CTNT, INSTR(CNTR_CGO_CTNT, '|', 1, 1)+1, INSTR(CNTR_CGO_CTNT, '|', 1, 2) - INSTR(CNTR_CGO_CTNT, '|', 1, 1)-1) MTY_CNTR_OBRD_TEU," ).append("\n"); 
		query.append("SUBSTR(CNTR_CGO_CTNT, INSTR(CNTR_CGO_CTNT, '|', 1, 2)+1, INSTR(CNTR_CGO_CTNT, '|', 1, 3) - INSTR(CNTR_CGO_CTNT, '|', 1, 2)-1) TTL_CNTR_OBRD_TEU," ).append("\n"); 
		query.append("SUBSTR(CNTR_CGO_CTNT, INSTR(CNTR_CGO_CTNT, '|', 1, 3)+1, INSTR(CNTR_CGO_CTNT, '|', 1, 4) - INSTR(CNTR_CGO_CTNT, '|', 1, 3)-1) RF_CNTR_DCHG_KNT," ).append("\n"); 
		query.append("SUBSTR(CNTR_CGO_CTNT, INSTR(CNTR_CGO_CTNT, '|', 1, 4)+1, INSTR(CNTR_CGO_CTNT, '|', 1, 5) - INSTR(CNTR_CGO_CTNT, '|', 1, 4)-1) RF_CNTR_LOD_KNT," ).append("\n"); 
		query.append("SUBSTR(CNTR_CGO_CTNT, INSTR(CNTR_CGO_CTNT, '|', 1, 5)+1, INSTR(CNTR_CGO_CTNT, '|', 1, 6) - INSTR(CNTR_CGO_CTNT, '|', 1, 5)-1) RF_CNTR_OBRD_KNT," ).append("\n"); 
		query.append("DEP_CGO_WGT," ).append("\n"); 
		query.append("DEP_DPL_WGT," ).append("\n"); 
		query.append("BLK_LOD_DCHG_STS_CD," ).append("\n"); 
		query.append("BLK_CGO_TP_CD1," ).append("\n"); 
		query.append("BLK_CGO_TP_CD2," ).append("\n"); 
		query.append("BLK_CGO_TP_CD3," ).append("\n"); 
		query.append("BLK_CGO_TP_CD4," ).append("\n"); 
		query.append("BLk_CGO_TP_CD5," ).append("\n"); 
		query.append("SUBSTR(BLK_HLD_LOAD_CTNT,                                     1, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 1) -                                     1) BKL_HLD_LOAD_QTY1," ).append("\n"); 
		query.append("SUBSTR(BLK_HLD_LOAD_CTNT, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 1)+1, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 2) - INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 1)-1) BKL_HLD_LOAD_QTY2," ).append("\n"); 
		query.append("SUBSTR(BLK_HLD_LOAD_CTNT, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 2)+1, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 3) - INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 2)-1) BKL_HLD_LOAD_QTY3," ).append("\n"); 
		query.append("SUBSTR(BLK_HLD_LOAD_CTNT, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 3)+1, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 4) - INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 3)-1) BKL_HLD_LOAD_QTY4," ).append("\n"); 
		query.append("SUBSTR(BLK_HLD_LOAD_CTNT, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 4)+1, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 5) - INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 4)-1) BKL_HLD_LOAD_QTY5," ).append("\n"); 
		query.append("SUBSTR(BLK_HLD_LOAD_CTNT, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 5)+1, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 6) - INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 5)-1) BKL_HLD_LOAD_QTY6," ).append("\n"); 
		query.append("SUBSTR(BLK_HLD_LOAD_CTNT, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 6)+1, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 7) - INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 6)-1) BKL_HLD_LOAD_QTY7," ).append("\n"); 
		query.append("SUBSTR(BLK_HLD_LOAD_CTNT, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 7)+1, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 8) - INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 7)-1) BKL_HLD_LOAD_QTY8," ).append("\n"); 
		query.append("SUBSTR(BLK_HLD_LOAD_CTNT, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 8)+1, INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 9) - INSTR(BLK_HLD_LOAD_CTNT, '|', 1, 8)-1) BKL_HLD_LOAD_QTY9," ).append("\n"); 
		query.append("BLK_DEP_CGO_TTL_WGT," ).append("\n"); 
		query.append("TTL_SLG_WGT," ).append("\n"); 
		query.append("FO_SLG_WGT," ).append("\n"); 
		query.append("INCNR_SLG_WGT," ).append("\n"); 
		query.append("DPL_SLG_WGT," ).append("\n"); 
		query.append("DPL_SLG_SP," ).append("\n"); 
		query.append("RMN_SDG_WGT," ).append("\n"); 
		query.append("FOIL_PURF_DCHG_ITVAL," ).append("\n"); 
		query.append("DEP_RMK," ).append("\n"); 
		query.append("ARR_LAT," ).append("\n"); 
		query.append("ARR_LON," ).append("\n"); 
		query.append("ARR_SAIL_HRS," ).append("\n"); 
		query.append("ARR_NVGT_ML," ).append("\n"); 
		query.append("ARR_ENG_ML," ).append("\n"); 
		query.append("ARR_RPM_PWR," ).append("\n"); 
		query.append("ARR_MN_FOIL_CSM_QTY," ).append("\n"); 
		query.append("ARR_MN_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("ARR_GNR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("ARR_GNR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("ARR_BLR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("ARR_BLR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("ARR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("ARR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("DEP_LAT," ).append("\n"); 
		query.append("DEP_LON," ).append("\n"); 
		query.append("DEP_RPM_PWR," ).append("\n"); 
		query.append("DEP_RPM_MAX_PWR," ).append("\n"); 
		query.append("DEP_RPM_MIN_PWR," ).append("\n"); 
		query.append("DEP_RPM_UUSD_FM," ).append("\n"); 
		query.append("DEP_RPM_UUSD_TO," ).append("\n"); 
		query.append("DEP_ARR_PLT_MGN_HRS," ).append("\n"); 
		query.append("DEP_ARR_PLT_MGN_MNTS," ).append("\n"); 
		query.append("DEP_RSN_FOR_MGN_TM," ).append("\n"); 
		query.append("CAP_NM," ).append("\n"); 
		query.append("CF_ENG_NM," ).append("\n"); 
		query.append("'TEST' CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE CRE_DT," ).append("\n"); 
		query.append("'TEST' UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM FCM_DEP_RPT_LOG" ).append("\n"); 
		query.append("WHERE RCV_SEQ = (SELECT MAX(RCV_SEQ) FROM FCM_DEP_RPT_LOG)" ).append("\n"); 

	}
}
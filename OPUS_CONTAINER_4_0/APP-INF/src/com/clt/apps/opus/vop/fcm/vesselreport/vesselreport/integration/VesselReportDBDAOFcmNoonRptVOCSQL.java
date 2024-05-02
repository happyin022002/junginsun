/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportDBDAOFcmNoonRptVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOFcmNoonRptVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM_NOON_RPT_LOG table 에서 FCM_NOON_RPT table 로 데이타 생성
	  * </pre>
	  */
	public VesselReportDBDAOFcmNoonRptVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration ").append("\n"); 
		query.append("FileName : VesselReportDBDAOFcmNoonRptVOCSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("INSERT INTO FCM_NOON_RPT" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SUBSTR(VOY_DIR_CD, 1, 4) SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(VOY_DIR_CD, 5, 1) SKD_DIR_CD," ).append("\n"); 
		query.append("NOON_RPT_DT," ).append("\n"); 
		query.append("VSL_SLAN_CD," ).append("\n"); 
		query.append("REF_NO," ).append("\n"); 
		query.append("NOON_RPT_LAT," ).append("\n"); 
		query.append("NOON_RPT_LON," ).append("\n"); 
		query.append("WND_FRC WND_DIR_CTNT," ).append("\n"); 
		query.append("'' WND_SCL_NO," ).append("\n"); 
		query.append("SEA_FRC OCN_CRNT_CTNT," ).append("\n"); 
		query.append("'' SEA_STE_NO," ).append("\n"); 
		query.append("VIS_RNG_NO," ).append("\n"); 
		query.append("REPLACE(SAIL_HRMNT, ' ', '0')," ).append("\n"); 
		query.append("NVGT_ML_DIST," ).append("\n"); 
		query.append("SAIL_AVG_SPD," ).append("\n"); 
		query.append("MN_PWR," ).append("\n"); 
		query.append("ENG_ML_DIST," ).append("\n"); 
		query.append("SAIL_AVG_RPM_PWR," ).append("\n"); 
		query.append("SLP_RT," ).append("\n"); 
		query.append("LOD_IND_QTY," ).append("\n"); 
		query.append("RMN_DIST," ).append("\n"); 
		query.append("RMN_AVG_SPD," ).append("\n"); 
		query.append("CRS_NO," ).append("\n"); 
		query.append("MN_FOIL_CSM_QTY," ).append("\n"); 
		query.append("MN_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("GNR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("GNR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("BLR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("BLR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("MN_DOIL_CSM_QTY," ).append("\n"); 
		query.append("MN_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("NXT_PORT_CD," ).append("\n"); 
		query.append("NXT_PORT_ETA_DT," ).append("\n"); 
		query.append("BILGE_CHK_FLG," ).append("\n"); 
		query.append("HLD_GAS_CHK_FLG," ).append("\n"); 
		query.append("HLD_TEMP_CHK_FLG," ).append("\n"); 
		query.append("BLST_XCH_FLG," ).append("\n"); 
		query.append("HLD_CLN_FLG," ).append("\n"); 
		query.append("PSC_PRPR_FLG," ).append("\n"); 
		query.append("DG_SAIL_FLG," ).append("\n"); 
		query.append("DG_SAIL_RMK," ).append("\n"); 
		query.append("NOON_RPT_RMK," ).append("\n"); 
		query.append("'TEST' CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE CRE_DT," ).append("\n"); 
		query.append("'TEST' UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM FCM_NOON_RPT_LOG" ).append("\n"); 
		query.append("WHERE RCV_SEQ = (SELECT MAX(RCV_SEQ) FROM FCM_NOON_RPT_LOG)" ).append("\n"); 

	}
}
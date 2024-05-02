/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOSearchDepRptErrRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
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

public class VesselReportDBDAOSearchDepRptErrRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Departure Report Error Rate 조회
	  * </pre>
	  */
	public VesselReportDBDAOSearchDepRptErrRtRSQL(){
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
		query.append("FileName : VesselReportDBDAOSearchDepRptErrRtRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append("	,NVGT_ML_DIST_RT" ).append("\n"); 
		query.append("	,ENG_ML_DIST_RT" ).append("\n"); 
		query.append("	,MNVR_IN_ML_DIST_RT" ).append("\n"); 
		query.append("	,MNVR_OUT_ML_DIST_RT" ).append("\n"); 
		query.append("	,AVG_SPD_RT" ).append("\n"); 
		query.append("	,AVG_RPM_PWR_RT" ).append("\n"); 
		query.append("	,PRLR_PCH_RT" ).append("\n"); 
		query.append("	,SAIL_TM_RT" ).append("\n"); 
		query.append("	,ARR_FOIL_RT" ).append("\n"); 
		query.append("	,ARR_LOW_SULP_FOIL_RT" ).append("\n"); 
		query.append("	,ARR_DOIL_RT" ).append("\n"); 
		query.append("	,ARR_LOW_SULP_DOIL_RT" ).append("\n"); 
		query.append("	,DEP_FOIL_RT" ).append("\n"); 
		query.append("	,DEP_LOW_SULP_FOIL_RT" ).append("\n"); 
		query.append("	,DEP_DOIL_RT" ).append("\n"); 
		query.append("	,DEP_LOW_SULP_DOIL_RT" ).append("\n"); 
		query.append("	,SEA_STMNG_MN_ENG_RT" ).append("\n"); 
		query.append("	,PORT_TTL_RT" ).append("\n"); 
		query.append("	,PORT_TTL_HR_RT_RT" ).append("\n"); 
		query.append("	,SB_ENG_DT_RT" ).append("\n"); 
		query.append("	,PLT_IN_DT_RT" ).append("\n"); 
		query.append("	,BFR_BRTH_ANK_DRP_DT_RT" ).append("\n"); 
		query.append("	,BFR_BRTH_ANK_OFF_DT_RT" ).append("\n"); 
		query.append("	,VPS_ETB_DT_RT" ).append("\n"); 
		query.append("	,CGO_WRK_ST_DT_RT" ).append("\n"); 
		query.append("	,CGO_WRK_END_DT_RT" ).append("\n"); 
		query.append("	,VPS_ETD_DT_RT" ).append("\n"); 
		query.append("	,AFT_UNBRTH_ANK_DRP_DT_RT" ).append("\n"); 
		query.append("	,AFT_UNBRTH_ANK_OFF_DT_RT" ).append("\n"); 
		query.append("	,PLT_OUT_DT_RT" ).append("\n"); 
		query.append("	,RUP_DT_RT" ).append("\n"); 
		query.append("	,FCNTR_OBRD_TEU_RT" ).append("\n"); 
		query.append("	,MCNTR_OBRD_TEU_RT" ).append("\n"); 
		query.append("	,TTL_CNTR_OBRD_TEU_RT" ).append("\n"); 
		query.append("	,DEP_CGO_RT" ).append("\n"); 
		query.append("	,RF_CNTR_DCHG_KNT_RT" ).append("\n"); 
		query.append("	,RF_CNTR_LOD_KNT_RT" ).append("\n"); 
		query.append("	,RF_CNTR_OBRD_KNT_RT" ).append("\n"); 
		query.append("FROM FCM_DEP_RPT_ERR_RT_SET" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}
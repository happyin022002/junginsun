/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOVslSkdHisInRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.12.11 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOVslSkdHisInRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOVslSkdHisInRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOVslSkdHisInRSQL").append("\n"); 
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
		query.append("SELECT	'' AS VSL_CD" ).append("\n"); 
		query.append(", '' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", '' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", '' AS VSL_SLAN_CD" ).append("\n"); 
		query.append(", '' AS SKD_STS_CD" ).append("\n"); 
		query.append(", '' AS SKD_VOY_TP_CD" ).append("\n"); 
		query.append(", '' AS SKD_USD_IND_CD" ).append("\n"); 
		query.append(", '' AS PF_SKD_TP_CD" ).append("\n"); 
		query.append(", '' AS ST_PORT_CD" ).append("\n"); 
		query.append(", '' AS N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append(", '' AS PSDO_VVD_CD" ).append("\n"); 
		query.append(", '' AS CO_CD" ).append("\n"); 
		query.append(", '' AS SKD_RMK" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS CRE_DT" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS UPD_DT" ).append("\n"); 
		query.append(", '' AS VPS_PORT_CD" ).append("\n"); 
		query.append(", '' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(", '' AS CLPT_SEQ" ).append("\n"); 
		query.append(", '' AS SLAN_CD" ).append("\n"); 
		query.append(", '' AS PORT_SKD_STS_CD" ).append("\n"); 
		query.append(", '' AS PORT_SKD_STS_DESC" ).append("\n"); 
		query.append(", '' AS YD_CD" ).append("\n"); 
		query.append(", '' AS CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(", '' AS PF_ETA_DT" ).append("\n"); 
		query.append(", '' AS PF_ETB_DT" ).append("\n"); 
		query.append(", '' AS PF_ETD_DT" ).append("\n"); 
		query.append(", '' AS INIT_ETA_DT" ).append("\n"); 
		query.append(", '' AS INIT_ETB_DT" ).append("\n"); 
		query.append(", '' AS INIT_ETD_DT" ).append("\n"); 
		query.append(", '' AS VPS_ETA_DT" ).append("\n"); 
		query.append(", '' AS VPS_ETB_DT" ).append("\n"); 
		query.append(", '' AS VPS_ETD_DT" ).append("\n"); 
		query.append(", '' AS VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(", '' AS VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(", '' AS VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append(", '' AS SHP_CALL_NO" ).append("\n"); 
		query.append(", '' AS SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append(", '' AS TML_VSL_CD" ).append("\n"); 
		query.append(", '' AS TML_VOY_NO" ).append("\n"); 
		query.append(", '' AS FT_DT" ).append("\n"); 
		query.append(", '' AS PLISM_YD_CD" ).append("\n"); 
		query.append(", '' AS PLISM_VSL_CD" ).append("\n"); 
		query.append(", '' AS PLISM_VOY_NO" ).append("\n"); 
		query.append(", '' AS SKD_CNG_STS_CD" ).append("\n"); 
		query.append(", '' AS SKD_CNG_STS_DESC" ).append("\n"); 
		query.append(", '' AS TURN_PORT_FLG" ).append("\n"); 
		query.append(", '' AS TURN_PORT_IND_CD" ).append("\n"); 
		query.append(", '' AS TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(", '' AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(", '' AS TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", '' AS IB_CGO_QTY" ).append("\n"); 
		query.append(", '' AS OB_CGO_QTY" ).append("\n"); 
		query.append(", '' AS VPS_RMK" ).append("\n"); 
		query.append(", '' AS PHS_IO_RSN_CD" ).append("\n"); 
		query.append(", '' AS PHS_IO_RMK" ).append("\n"); 
		query.append(", '' AS SKD_BRTH_NO" ).append("\n"); 
		query.append(", '' AS INIT_SKD_INP_FLG" ).append("\n"); 
		query.append(", '' AS OFC_INP_FLG" ).append("\n"); 
		query.append(", '' AS NOON_RPT_INP_FLG" ).append("\n"); 
		query.append(", '' AS DEP_RPT_INP_FLG" ).append("\n"); 
		query.append(", '' AS ACT_INP_FLG" ).append("\n"); 
		query.append(", '' AS PRT_CHK_FLG" ).append("\n"); 
		query.append(", '' AS EDI_SND_KNT" ).append("\n"); 
		query.append(", '' AS PORT_SKP_TP_CD" ).append("\n"); 
		query.append(", '' AS PORT_SKP_RSN_CD" ).append("\n"); 
		query.append(", '' AS PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append(", '' AS TTL_DLAY_HRS" ).append("\n"); 
		query.append(", '' AS TS_PORT_CD" ).append("\n"); 
		query.append(", '' AS USD_FLG" ).append("\n"); 
		query.append(", '' AS ETB_DY_CD" ).append("\n"); 
		query.append(", '' AS ETD_DY_CD" ).append("\n"); 
		query.append(", '' AS PF_SVC_TP_CD" ).append("\n"); 
		query.append(", '' AS PORT_ROTN_SEQ" ).append("\n"); 
		query.append(", '' AS DIR_SEQ" ).append("\n"); 
		query.append(", '' AS USR_ID" ).append("\n"); 
		query.append(", '' AS CNG_LANE_CD" ).append("\n"); 
		query.append(", '' AS CNG_VSL_CD" ).append("\n"); 
		query.append(", '' AS CNG_SKD_VOY_NO" ).append("\n"); 
		query.append(", '' AS CNG_SKD_DIR_CD" ).append("\n"); 
		query.append(", '' AS NEW_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCstSkdSimDtlCalcInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.02.12 정진우
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

public class VesselScheduleMgtDBDAOCstSkdSimDtlCalcInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCstSkdSimDtlCalcInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCstSkdSimDtlCalcInfoRSQL").append("\n"); 
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
		query.append("		'' AS VSL_CD" ).append("\n"); 
		query.append("		, '' AS SKD_VOY_NO" ).append("\n"); 
		query.append("		, '' AS SKD_DIR_CD" ).append("\n"); 
		query.append("		, '' AS VPS_PORT_CD" ).append("\n"); 
		query.append("		, '' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("		, '' AS VSL_SLAN_CD" ).append("\n"); 
		query.append("		, '' AS YD_CD" ).append("\n"); 
		query.append("		, '' AS VPS_ETA_DT" ).append("\n"); 
		query.append("		, '' AS LOC_CD" ).append("\n"); 
		query.append("		, '' AS BSE_YR" ).append("\n"); 
		query.append("		, '' AS BSE_QTR_CD" ).append("\n"); 
		query.append("		, '' AS FM_LOC_CD" ).append("\n"); 
		query.append("		, '' AS TO_LOC_CD" ).append("\n"); 
		query.append("		, '' AS SPD" ).append("\n"); 
		query.append("		, '' AS BNK_UNIT_QTY" ).append("\n"); 
		query.append("		, '' AS BNK_UNIT_AMT" ).append("\n"); 
		query.append("		, '' AS TTL_CHG_AMT" ).append("\n"); 
		query.append("		, '' AS STND_DIST" ).append("\n"); 
		query.append("		, '' AS TS_D2" ).append("\n"); 
		query.append("		, '' AS TS_D4" ).append("\n"); 
		query.append("		, '' AS TM_D2" ).append("\n"); 
		query.append("		, '' AS TM_D4" ).append("\n"); 
		query.append("		, '' AS TP_20_QTY" ).append("\n"); 
		query.append("		, '' AS TP_40_QTY" ).append("\n"); 
		query.append("		, '' AS TIME_DIFF" ).append("\n"); 
		query.append("		, '' AS MNVR_IN_HRS" ).append("\n"); 
		query.append("		, '' AS MNVR_OUT_HRS" ).append("\n"); 
		query.append("		, '' AS CRN_KNT" ).append("\n"); 
		query.append("		, '' AS TML_PROD_QTY" ).append("\n"); 
		query.append("		, '' AS PORT_BUF_HRS" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}
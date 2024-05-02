/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchVskVslPortSkdByVirtualPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.11.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchVskVslPortSkdByVirtualPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Virtual Port에 대한 VVD Port 정보를 조회합니다.
	  * 
	  * ===================================
	  * 2012.11.28 CHM-201220890-01 진마리아 double calling port 에 대한 virtual port calling seq. 수정 (orgTurnClptIndSeq 추가)
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchVskVslPortSkdByVirtualPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchVskVslPortSkdByVirtualPortRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("			PS.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("		,	PS.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("		,	PS.PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append("		,	PS.TTL_DLAY_HRS" ).append("\n"); 
		query.append("		,	PS.TS_PORT_CD" ).append("\n"); 
		query.append("		,	PS.USD_FLG" ).append("\n"); 
		query.append("		,	PS.NOON_RPT_INP_FLG" ).append("\n"); 
		query.append("		,	PS.DEP_RPT_INP_FLG" ).append("\n"); 
		query.append("		,	PS.ACT_INP_FLG" ).append("\n"); 
		query.append("		,	PS.PRT_CHK_FLG" ).append("\n"); 
		query.append("		,	PS.CRE_USR_ID" ).append("\n"); 
		query.append("		,	TO_CHAR(PS.CRE_DT		, 'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("		,	PS.UPD_USR_ID" ).append("\n"); 
		query.append("		,	TO_CHAR(PS.UPD_DT		, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("		,	PS.VSL_CD" ).append("\n"); 
		query.append("		,	PS.SKD_VOY_NO" ).append("\n"); 
		query.append("		,	PS.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	PS.VPS_PORT_CD" ).append("\n"); 
		query.append("		,	PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,	PS.CLPT_SEQ" ).append("\n"); 
		query.append("		,	PS.SLAN_CD" ).append("\n"); 
		query.append("		,	PS.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("		,	PS.YD_CD" ).append("\n"); 
		query.append("		,	PS.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("		,   TO_CHAR(PS.PF_ETA_DT	, 'YYYYMMDDHH24MI'	) AS PF_ETA_DT" ).append("\n"); 
		query.append("		,   TO_CHAR(PS.PF_ETB_DT	, 'YYYYMMDDHH24MI'	) AS PF_ETB_DT" ).append("\n"); 
		query.append("		,   TO_CHAR(PS.PF_ETD_DT	, 'YYYYMMDDHH24MI'	) AS PF_ETD_DT" ).append("\n"); 
		query.append("		,   TO_CHAR(PS.INIT_ETA_DT	, 'YYYYMMDDHH24MI'	) AS INIT_ETA_DT" ).append("\n"); 
		query.append("		,   TO_CHAR(PS.INIT_ETB_DT	, 'YYYYMMDDHH24MI'	) AS INIT_ETB_DT" ).append("\n"); 
		query.append("		,   TO_CHAR(PS.INIT_ETD_DT	, 'YYYYMMDDHH24MI'	) AS INIT_ETD_DT" ).append("\n"); 
		query.append("		,   TO_CHAR(PS.VPS_ETA_DT	, 'YYYYMMDDHH24MI'	) AS VPS_ETA_DT" ).append("\n"); 
		query.append("		,   TO_CHAR(PS.VPS_ETB_DT	, 'YYYYMMDDHH24MI'	) AS VPS_ETB_DT" ).append("\n"); 
		query.append("		,   TO_CHAR(PS.VPS_ETD_DT	, 'YYYYMMDDHH24MI'	) AS VPS_ETD_DT" ).append("\n"); 
		query.append("		,	PS.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("		,	PS.VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("		,	PS.VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append("		,	PS.SHP_CALL_NO" ).append("\n"); 
		query.append("		,	PS.SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append("		,	TO_CHAR(PS.SHP_CALL_NO_UPD_DT, 'YYYYMMDDHH24MI') AS SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append("		,	PS.TML_VSL_CD" ).append("\n"); 
		query.append("		,	PS.TML_VOY_NO" ).append("\n"); 
		query.append("		,	TO_CHAR(PS.FT_DT		, 'YYYYMMDDHH24MI'	) AS FT_DT" ).append("\n"); 
		query.append("		,	PS.PLISM_YD_CD" ).append("\n"); 
		query.append("		,	PS.PLISM_VSL_CD" ).append("\n"); 
		query.append("		,	PS.PLISM_VOY_NO" ).append("\n"); 
		query.append("		,	PS.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("		,	PS.TURN_PORT_FLG" ).append("\n"); 
		query.append("		,	PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("		,	PS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("		,	PS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("		,	PS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,	PS.IB_CGO_QTY" ).append("\n"); 
		query.append("		,	PS.OB_CGO_QTY" ).append("\n"); 
		query.append("		,	PS.VPS_RMK" ).append("\n"); 
		query.append("		,	PS.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("		,	PS.PHS_IO_RMK" ).append("\n"); 
		query.append("		,	PS.SKD_BRTH_NO" ).append("\n"); 
		query.append("		,	PS.INIT_SKD_INP_FLG" ).append("\n"); 
		query.append("		,	PS.OFC_INP_FLG" ).append("\n"); 
		query.append("		,	PS.EDI_SND_KNT" ).append("\n"); 
		query.append("FROM 		VSK_VSL_PORT_SKD		PS" ).append("\n"); 
		query.append("WHERE		PS.VSL_CD 				= @[vsl_cd]" ).append("\n"); 
		query.append("AND			PS.SKD_VOY_NO 			= @[skd_voy_no]" ).append("\n"); 
		query.append("AND			PS.SKD_DIR_CD 			= @[skd_dir_cd]" ).append("\n"); 
		query.append("ORDER BY 	PS.CLPT_SEQ				ASC" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchDeptureReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.10.24 진마리아
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

public class VesselScheduleMgtDBDAOSearchDeptureReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Departure Report 정보를 조회합니다.
	  * 
	  * History
	  * 2012.10.24 CHM-201220527-01 진마리아 Departure/Noon Report 데이터를 FCM 데이터와 I/F하도록 변경 요청
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchDeptureReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchDeptureReportRSQL").append("\n"); 
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
		query.append("SELECT	(VSK_REMOVE_NONE_NUMERIC_FNC(NVL(DEP_FOIL_WGT,0)) + VSK_REMOVE_NONE_NUMERIC_FNC(NVL(DEP_LOW_SULP_FOIL_WGT,0))) AS DEP_FOIL_WGT" ).append("\n"); 
		query.append("		, (VSK_REMOVE_NONE_NUMERIC_FNC(NVL(DEP_DOIL_WGT,0)) + VSK_REMOVE_NONE_NUMERIC_FNC(NVL(DEP_LOW_SULP_DOIL_WGT,0))) AS DEP_DOIL_WGT" ).append("\n"); 
		query.append("		, VSK_REMOVE_NONE_NUMERIC_FNC(DEP_FRSH_WTR_WGT) AS DEP_FRSH_WTR_WGT" ).append("\n"); 
		query.append("		, VSK_REMOVE_NONE_NUMERIC_FNC(DEP_BLST_WGT) AS DEP_BLST_WGT" ).append("\n"); 
		query.append("FROM	FCM_DEP_RPT" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND     VSL_CD      = @[wgt_vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO  = @[wgt_skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD  = @[wgt_skd_dir_cd]" ).append("\n"); 
		query.append("AND     DEP_PORT_CD = @[wgt_port_cd]" ).append("\n"); 
		query.append("AND     CLPT_IND_SEQ= @[wgt_clpt_ind_seq]" ).append("\n"); 

	}
}
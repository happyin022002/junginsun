/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCstSkdByPfSkdUseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchCstSkdByPfSkdUseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proforma Schedule 을 조회합니다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCstSkdByPfSkdUseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCstSkdByPfSkdUseRSQL").append("\n"); 
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
		query.append("SELECT PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("       , YD_CD" ).append("\n"); 
		query.append("       , PORT_ROTN_SEQ" ).append("\n"); 
		query.append("       , DECODE(YD_CD, NULL, '', SUBSTR(YD_CD, 6, 2)) AS TML_CD" ).append("\n"); 
		query.append("	   , TO_DATE(TO_CHAR(TO_DATE(@[vps_etb_dt], 'YYYYMMDD') + (ETB_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETB_TM_HRMNT, 'YYYYMMDD HH24:MI') - NUMTODSINTERVAL(MNVR_IN_HRS,'HOUR') AS PF_ETA_DT" ).append("\n"); 
		query.append("       , TO_DATE(TO_CHAR(TO_DATE(@[vps_etb_dt], 'YYYYMMDD') + (ETB_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETB_TM_HRMNT, 'YYYYMMDD HH24:MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("       , TO_DATE(TO_CHAR(TO_DATE(@[vps_etb_dt], 'YYYYMMDD') + (ETD_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETD_TM_HRMNT, 'YYYYMMDD HH24:MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("       , TO_DATE(TO_CHAR(TO_DATE(@[vps_etb_dt], 'YYYYMMDD') + (ETB_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETB_TM_HRMNT, 'YYYYMMDD HH24:MI') - NUMTODSINTERVAL(MNVR_IN_HRS,'HOUR') AS INIT_ETA_DT" ).append("\n"); 
		query.append("       , TO_DATE(TO_CHAR(TO_DATE(@[vps_etb_dt], 'YYYYMMDD') + (ETB_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETB_TM_HRMNT, 'YYYYMMDD HH24:MI') AS INIT_ETB_DT" ).append("\n"); 
		query.append("       , TO_DATE(TO_CHAR(TO_DATE(@[vps_etb_dt], 'YYYYMMDD') + (ETD_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETD_TM_HRMNT, 'YYYYMMDD HH24:MI') AS INIT_ETD_DT" ).append("\n"); 
		query.append("       , TO_DATE(TO_CHAR(TO_DATE(@[vps_etb_dt], 'YYYYMMDD') + (ETB_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETB_TM_HRMNT, 'YYYYMMDD HH24:MI') - NUMTODSINTERVAL(MNVR_IN_HRS,'HOUR') AS VPS_ETA_DT" ).append("\n"); 
		query.append("       , TO_DATE(TO_CHAR(TO_DATE(@[vps_etb_dt], 'YYYYMMDD') + (ETB_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETB_TM_HRMNT, 'YYYYMMDD HH24:MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("       , TO_DATE(TO_CHAR(TO_DATE(@[vps_etb_dt], 'YYYYMMDD') + (ETD_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETD_TM_HRMNT, 'YYYYMMDD HH24:MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("       , TURN_PORT_FLG" ).append("\n"); 
		query.append("	   , NVL(LNK_SPD, 0) AS LNK_SPD" ).append("\n"); 
		query.append("	   , NVL(SEA_BUF_HRS, 0) AS SEA_BUF_HRS" ).append("\n"); 
		query.append("	   , NVL(PORT_BUF_HRS, 0) AS PORT_BUF_HRS" ).append("\n"); 
		query.append("	   , NVL(TZTM_HRS, 0) AS TZTM_HRS" ).append("\n"); 
		query.append("	   , NVL(ACT_WRK_HRS, 0) AS ACT_WRK_HRS" ).append("\n"); 
		query.append("	   , NVL(LNK_DIST, 0) AS LNK_DIST" ).append("\n"); 
		query.append("	   , NVL(MNVR_OUT_HRS, 0) AS MNVR_OUT_HRS" ).append("\n"); 
		query.append("	   , NVL(MNVR_IN_HRS, 0) AS MNVR_IN_HRS" ).append("\n"); 
		query.append("  FROM VSK_BUD_PF_SKD_DTL A" ).append("\n"); 
		query.append(" WHERE VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("   AND PF_SVC_TP_CD    = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND TURN_PORT_IND_CD != 'F'" ).append("\n"); 
		query.append("   AND PORT_ROTN_SEQ  >= (" ).append("\n"); 
		query.append("                        SELECT PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                          FROM VSK_BUD_PF_SKD_DTL" ).append("\n"); 
		query.append("                         WHERE VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("                           AND PF_SVC_TP_CD    = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("                           AND PORT_CD         = @[vps_port_cd]" ).append("\n"); 
		query.append("                           AND CLPT_SEQ        = @[clpt_seq]" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append(" ORDER BY PORT_ROTN_SEQ" ).append("\n"); 

	}
}
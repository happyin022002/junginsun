/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCstSkdByVvdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.27 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author RYU HYUK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchCstSkdByVvdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Long Range SKD에서 해당 Port의 ETA/ETB/ETD를 조회한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCstSkdByVvdPortRSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCstSkdByVvdPortRSQL").append("\n"); 
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
		query.append("	T1.VSL_CD" ).append("\n"); 
		query.append(",	T1.SKD_VOY_NO" ).append("\n"); 
		query.append(",	T1.SKD_DIR_CD" ).append("\n"); 
		query.append(",	T1.VPS_PORT_CD" ).append("\n"); 
		query.append(",	T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	T1.PORT_SKD_STS_CD" ).append("\n"); 
		query.append(",	to_char(T1.PF_ETA_DT, 'YYYY-MM-DD HH24:MI') PF_ETA_DT" ).append("\n"); 
		query.append(",	to_char(T1.PF_ETB_DT, 'YYYY-MM-DD HH24:MI') PF_ETB_DT" ).append("\n"); 
		query.append(",	to_char(T1.PF_ETD_DT, 'YYYY-MM-DD HH24:MI') PF_ETD_DT" ).append("\n"); 
		query.append(",	to_char(T1.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') VPS_ETA_DT" ).append("\n"); 
		query.append(",	to_char(T1.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') VPS_ETB_DT" ).append("\n"); 
		query.append(",	to_char(T1.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append(",	T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",	T1.VPS_RMK" ).append("\n"); 
		query.append(", 	T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(",	T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(",	T1.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	T2.VSL_ENG_NM" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("		SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD T3, COM_INTG_CD_DTL T4" ).append("\n"); 
		query.append("		WHERE T3.INTG_CD_ID = T4.INTG_CD_ID" ).append("\n"); 
		query.append("		AND T3.OWNR_SUB_SYS_CD = 'VSK'" ).append("\n"); 
		query.append("		AND T3.INTG_CD_ID = 'CD01821'" ).append("\n"); 
		query.append("		AND T4.INTG_CD_VAL_CTNT = T1.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("	) SKD_IND" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("		SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD T3, COM_INTG_CD_DTL T4" ).append("\n"); 
		query.append("		WHERE T3.INTG_CD_ID = T4.INTG_CD_ID" ).append("\n"); 
		query.append("		AND T3.OWNR_SUB_SYS_CD = 'VSK'" ).append("\n"); 
		query.append("		AND T3.INTG_CD_ID = 'CD01825'" ).append("\n"); 
		query.append("		AND T4.INTG_CD_VAL_CTNT = T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("	) CNG_IND" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD T1, MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND T1.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("#if (${clpt_ind_seq} != '') " ).append("\n"); 
		query.append("AND T1.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clpt_seq} != '') " ).append("\n"); 
		query.append("AND T1.CLPT_SEQ = @[clpt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
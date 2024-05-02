/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchVvdByReceviedPsaVoyNoAllRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchVvdByReceviedPsaVoyNoAllRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VVD of vessel schedule, mapping EDI's info.
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchVvdByReceviedPsaVoyNoAllRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("edi_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchVvdByReceviedPsaVoyNoAllRSQL").append("\n"); 
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
		query.append("SELECT VPS.*" ).append("\n"); 
		query.append("  FROM (SELECT VPS.* ," ).append("\n"); 
		query.append("               RANK() OVER (ORDER BY VPS.DIFF_ETA_DT) AS ETA_RANK ," ).append("\n"); 
		query.append("               COUNT(1) OVER() AS TOT_CNT" ).append("\n"); 
		query.append("          FROM (SELECT T2.VSL_CD ," ).append("\n"); 
		query.append("                       T2.SKD_VOY_NO ," ).append("\n"); 
		query.append("                       T2.SKD_DIR_CD ," ).append("\n"); 
		query.append("                       T2.YD_CD ," ).append("\n"); 
		query.append("                       T2.VPS_ETA_DT ," ).append("\n"); 
		query.append("                       T2.VPS_ETB_DT ," ).append("\n"); 
		query.append("                       T2.VPS_ETD_DT ," ).append("\n"); 
		query.append("                       ABS(ROUND(TO_DATE(TO_CHAR(T2.VPS_ETA_DT, 'YYYYMMDDHH24MI'), 'YYYYMMDDHH24MI') - TO_DATE(@[edi_act_arr_dt], 'YYYYMMDDHH24MI'), 2)) AS DIFF_ETA_DT ," ).append("\n"); 
		query.append("                       SUM(1) OVER (PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.YD_CD ORDER BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.YD_CD) AS GRP_VVD_CNT" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD T2 ," ).append("\n"); 
		query.append("                       MDM_VSL_CNTR MDM" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND (T2.SKD_VOY_NO || T2.SKD_DIR_CD =  @[shp_call_no] OR T2.OB_CSSM_VOY_NO =  @[shp_call_no] )" ).append("\n"); 
		query.append("                   AND 'S' != NVL(T2.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("                   AND T2.VSL_CD IN (SELECT VSL_CD" ).append("\n"); 
		query.append("                                      FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("                                     WHERE 1=1 " ).append("\n"); 
		query.append("                                 	   #if (${edi_vsl_nm} != '') " ).append("\n"); 
		query.append("                                       AND VSL_CD = @[edi_vsl_nm]" ).append("\n"); 
		query.append("                                       #end" ).append("\n"); 
		query.append("                                       AND ( LLOYD_NO =  @[lloyd_no] OR CALL_SGN_NO = @[call_sgn_no] )" ).append("\n"); 
		query.append("                                       AND DELT_FLG = 'N' )" ).append("\n"); 
		query.append("                   AND T2.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("                   AND T2.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("                   AND T2.VSL_CD = MDM.VSL_CD(+)" ).append("\n"); 
		query.append("				   AND T2.VT_ADD_CALL_FLG IS NULL " ).append("\n"); 
		query.append("                 --ORDER BY DECODE(VSL_CD , [edi_vsl_nm], 1, MDM.CALL_SGN_NO ,  [call_sgn_no], 2, MDM.LLOYD_NO, [lloyd_no], 3) " ).append("\n"); 
		query.append("             ) VPS " ).append("\n"); 
		query.append("        ) VPS" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 

	}
}
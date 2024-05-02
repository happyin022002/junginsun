/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOIsReverseVesselPortScheduleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOIsReverseVesselPortScheduleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Port Schedule 역전여부체크
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOIsReverseVesselPortScheduleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOIsReverseVesselPortScheduleRSQL").append("\n"); 
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
		query.append("SELECT   NVL(MAX(CASE WHEN SIGN(MIN(PS.VPS_ETA_DT) - TO_DATE(REPLACE(REPLACE(REPLACE(@[vps_etd_dt],CHR(32),''),'-',''),':'),'YYYYMMDDHH24MI')) > 0 THEN 'N' ELSE 'Y' END),'N') AS VPS_REVERSE_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      --,  XX.VPS_ETD_DT  CUR_VPS_ETD_DT" ).append("\n"); 
		query.append("      --,  PS.VPS_ETA_DT  NXT_VPS_ETA_DT" ).append("\n"); 
		query.append("      --,  SIGN(PS.VPS_ETA_DT - XX.VPS_ETD_DT)              " ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("         -------------------------------------------------------" ).append("\n"); 
		query.append("          SELECT   PS.VSL_CD" ).append("\n"); 
		query.append("                ,  PS.TURN_SKD_VOY_NO             " ).append("\n"); 
		query.append("                ,  PS.TURN_SKD_DIR_CD   " ).append("\n"); 
		query.append("                ,  PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                ,  PS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                ,  PS.VPS_ETD_DT" ).append("\n"); 
		query.append("                ,  PS.CLPT_SEQ          " ).append("\n"); 
		query.append("                ,  (SELECT    T1.CLPT_SEQ" ).append("\n"); 
		query.append("                    FROM      VSK_VSL_PORT_SKD  T1" ).append("\n"); 
		query.append("                    WHERE     T1.VSL_CD         = PS.VSL_CD" ).append("\n"); 
		query.append("                    AND       T1.SKD_VOY_NO     = PS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND       T1.SKD_DIR_CD     = PS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND       T1.VPS_PORT_CD    = PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                    AND       T1.CLPT_IND_SEQ   = PS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    )                           AS VIR_VVD_CUR_CLPT_SEQ  " ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("          FROM     VSK_VSL_PORT_SKD             PS" ).append("\n"); 
		query.append("          WHERE    1 = 1" ).append("\n"); 
		query.append("          AND      PS.VSL_CD                    = @[vsl_cd]" ).append("\n"); 
		query.append("          AND      PS.SKD_VOY_NO                = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND      PS.SKD_DIR_CD                = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND      PS.VPS_PORT_CD               = @[vps_port_cd]" ).append("\n"); 
		query.append("          AND      PS.CLPT_IND_SEQ              = @[clpt_ind_seq]" ).append("\n"); 
		query.append("          AND      PS.TURN_PORT_IND_CD          IN ('D','V','F')" ).append("\n"); 
		query.append("         -------------------------------------------------------" ).append("\n"); 
		query.append("         ) XX" ).append("\n"); 
		query.append("    ,    VSK_VSL_PORT_SKD                         PS" ).append("\n"); 
		query.append("WHERE    PS.VSL_CD                                = XX.VSL_CD" ).append("\n"); 
		query.append("AND      PS.SKD_VOY_NO                       	  = XX.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("AND      PS.SKD_DIR_CD                       	  = XX.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("AND      PS.CLPT_SEQ                  			  > XX.VIR_VVD_CUR_CLPT_SEQ " ).append("\n"); 
		query.append("AND		 NVL(PS.SKD_CNG_STS_CD,'*')				  <> 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY PS.VPS_ETA_DT" ).append("\n"); 
		query.append("      ,  XX.VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--ORDER BY PS.CLPT_SEQ                              ASC" ).append("\n"); 

	}
}
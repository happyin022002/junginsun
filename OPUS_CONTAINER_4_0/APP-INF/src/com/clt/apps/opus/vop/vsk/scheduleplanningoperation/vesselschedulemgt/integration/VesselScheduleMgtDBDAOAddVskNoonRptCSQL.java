/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOAddVskNoonRptCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.03.09 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOAddVskNoonRptCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VMS 시스템에서 입력 받은 Noon Report를 생성한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOAddVskNoonRptCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_lat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocn_crnt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_gdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("noon_rpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_ind_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvgt_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vis_rng_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_lon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eng_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wnd_dir_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_act_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmn_avg_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_port_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmn_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wnd_scl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_act_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_ste_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crs_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : VesselScheduleMgtDBDAOAddVskNoonRptCSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_NOON_RPT A" ).append("\n"); 
		query.append("USING DUAL ON (A.VSL_CD          = @[vsl_cd]	" ).append("\n"); 
		query.append("               AND A.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("               AND A.SKD_DIR_CD  = @[skd_dir_cd]	" ).append("\n"); 
		query.append("               AND A.NOON_RPT_DT = TO_DATE(@[noon_rpt_dt], 'YYYYMMDDHH24MISS'))" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      UPDATE SET " ).append("\n"); 
		query.append("             NXT_PORT_CD      	=             @[nxt_port_cd]													                                			" ).append("\n"); 
		query.append("            ,NXT_PORT_ETA_DT  	=             TO_DATE(@[nxt_port_eta_dt], 'YYYYMMDDHH24MISS')											    			" ).append("\n"); 
		query.append("            ,ACT_GDT          	=             TO_DATE(@[act_gdt], 'YYYYMMDDHH24MISS')																	" ).append("\n"); 
		query.append("            ,PORT_LAT         	=             NVL(@[port_lat]         ,0)" ).append("\n"); 
		query.append("            ,PORT_LON         	=             NVL(@[port_lon]         ,0)" ).append("\n"); 
		query.append("            ,SAIL_HRMNT       	=             @[sail_hrmnt]													                                			" ).append("\n"); 
		query.append("            ,NVGT_DIST        	=             NVL(@[nvgt_dist]        ,0)" ).append("\n"); 
		query.append("            ,ENG_ML_DIST      	=             NVL(@[eng_ml_dist]      ,0)" ).append("\n"); 
		query.append("            ,WND_DIR_CTNT     	=             @[wnd_dir_ctnt]												                                			" ).append("\n"); 
		query.append("            ,WND_SCL_NO       	=             NVL(@[wnd_scl_no]       ,0)" ).append("\n"); 
		query.append("            ,OCN_CRNT_CTNT    	=             @[ocn_crnt_ctnt]" ).append("\n"); 
		query.append("            ,SEA_STE_NO       	=             NVL(@[sea_ste_no]       ,0)" ).append("\n"); 
		query.append("            ,VIS_RNG_NO       	=             NVL(@[vis_rng_no]       ,0)" ).append("\n"); 
		query.append("            ,CRNT_ACT_SPD     	=             NVL(@[crnt_act_spd]     ,0)" ).append("\n"); 
		query.append("            ,CRNT_ACT_RPM_PWR 	=             NVL(@[crnt_act_rpm_pwr] ,0)" ).append("\n"); 
		query.append("            ,SLP_RT           	=             NVL(@[slp_rt]           ,0)" ).append("\n"); 
		query.append("            ,RMN_DIST         	=             NVL(@[rmn_dist]         ,0)" ).append("\n"); 
		query.append("            ,RMN_AVG_SPD      	=             NVL(@[rmn_avg_spd]      ,0)" ).append("\n"); 
		query.append("            ,FOIL_CSM_WGT     	=             NVL(@[foil_csm_wgt]     ,0)" ).append("\n"); 
		query.append("            ,DOIL_CSM_WGT     	=             NVL(@[doil_csm_wgt]     ,0)" ).append("\n"); 
		query.append("            ,CRS_NO           	=             NVL(@[crs_no]           ,0)" ).append("\n"); 
		query.append("            ,LOD_IND_QTY      	=             NVL(@[lod_ind_qty]      ,0)" ).append("\n"); 
		query.append("            ,UPD_USR_ID       	=             @[cre_usr_id]" ).append("\n"); 
		query.append("            ,UPD_DT           	=             SYSDATE   " ).append("\n"); 
		query.append("      WHERE  1=1" ).append("\n"); 
		query.append("      AND    A.VSL_CD      = @[vsl_cd]	" ).append("\n"); 
		query.append("      AND    A.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND    A.SKD_DIR_CD  = @[skd_dir_cd]	" ).append("\n"); 
		query.append("      AND    A.NOON_RPT_DT = TO_DATE(@[noon_rpt_dt], 'YYYYMMDDHH24MISS')   " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      INSERT (" ).append("\n"); 
		query.append("             VSL_CD           	--VARCHAR2(4) not null,          				" ).append("\n"); 
		query.append("            ,SKD_VOY_NO       	--VARCHAR2(4) not null,          				" ).append("\n"); 
		query.append("            ,SKD_DIR_CD       	--VARCHAR2(1) not null,          				" ).append("\n"); 
		query.append("            ,NOON_RPT_DT      	--DATE not null,                 				" ).append("\n"); 
		query.append("            ,NXT_PORT_CD      	--VARCHAR2(5),                   				" ).append("\n"); 
		query.append("            ,NXT_PORT_ETA_DT  	--DATE,                          				" ).append("\n"); 
		query.append("            ,ACT_GDT          	--DATE default SYSDATE,          				" ).append("\n"); 
		query.append("            ,PORT_LAT         	--NUMBER(8,5),                   				" ).append("\n"); 
		query.append("            ,PORT_LON         	--NUMBER(8,5),                   				" ).append("\n"); 
		query.append("            ,SAIL_HRMNT       	--VARCHAR2(4),                   				" ).append("\n"); 
		query.append("            ,NVGT_DIST        	--NUMBER(6) default 0,           				" ).append("\n"); 
		query.append("            ,ENG_ML_DIST      	--NUMBER(6) default 0,           				" ).append("\n"); 
		query.append("            ,WND_DIR_CTNT     	--VARCHAR2(50),                  				" ).append("\n"); 
		query.append("            ,WND_SCL_NO       	--NUMBER(4) default 0,           				" ).append("\n"); 
		query.append("            ,OCN_CRNT_CTNT    	--VARCHAR2(50),                  				" ).append("\n"); 
		query.append("            ,SEA_STE_NO       	--NUMBER(4) default 0,           				" ).append("\n"); 
		query.append("            ,VIS_RNG_NO       	--NUMBER(4) default 0,           				" ).append("\n"); 
		query.append("            ,CRNT_ACT_SPD     	--NUMBER(5,3) default 0,         				" ).append("\n"); 
		query.append("            ,CRNT_ACT_RPM_PWR 	--NUMBER(6) default 0,           				" ).append("\n"); 
		query.append("            ,SLP_RT           	--NUMBER(5,2) default 0,         				" ).append("\n"); 
		query.append("            ,RMN_DIST         	--NUMBER(6) default 0,           				" ).append("\n"); 
		query.append("            ,RMN_AVG_SPD      	--NUMBER(5,3) default 0,         				" ).append("\n"); 
		query.append("            ,FOIL_CSM_WGT     	--NUMBER(13,3) default 0,        				" ).append("\n"); 
		query.append("            ,DOIL_CSM_WGT     	--NUMBER(13,3) default 0,        				" ).append("\n"); 
		query.append("            ,CRS_NO           	--NUMBER(4) default 0,           				" ).append("\n"); 
		query.append("            ,LOD_IND_QTY      	--NUMBER(8,2) default 0,         				" ).append("\n"); 
		query.append("            ,CRE_USR_ID       	--VARCHAR2(20) not null,         				" ).append("\n"); 
		query.append("            ,CRE_DT           	--DATE default SYSDATE not null, 				" ).append("\n"); 
		query.append("            ,UPD_USR_ID       	--VARCHAR2(20) not null,         				" ).append("\n"); 
		query.append("            ,UPD_DT           	--DATE default SYSDATE not null  				" ).append("\n"); 
		query.append("            ) VALUES( " ).append("\n"); 
		query.append("             @[vsl_cd]														" ).append("\n"); 
		query.append("            ,@[skd_voy_no]													" ).append("\n"); 
		query.append("            ,@[skd_dir_cd]													" ).append("\n"); 
		query.append("            ,TO_DATE(@[noon_rpt_dt], 'YYYYMMDDHH24MISS')	" ).append("\n"); 
		query.append("            ,@[nxt_port_cd]													" ).append("\n"); 
		query.append("            ,TO_DATE(@[nxt_port_eta_dt], 'YYYYMMDDHH24MISS')											" ).append("\n"); 
		query.append("            ,TO_DATE(@[act_gdt], 'YYYYMMDDHH24MISS')														" ).append("\n"); 
		query.append("            ,NVL(@[port_lat]        ,0)" ).append("\n"); 
		query.append("            ,NVL(@[port_lon]        ,0)" ).append("\n"); 
		query.append("            ,@[sail_hrmnt]													" ).append("\n"); 
		query.append("            ,NVL(@[nvgt_dist]       ,0)" ).append("\n"); 
		query.append("            ,NVL(@[eng_ml_dist]     ,0)" ).append("\n"); 
		query.append("            ,@[wnd_dir_ctnt]												" ).append("\n"); 
		query.append("            ,NVL(@[wnd_scl_no]      ,0)" ).append("\n"); 
		query.append("            ,@[ocn_crnt_ctnt]												" ).append("\n"); 
		query.append("            ,NVL(@[sea_ste_no]      ,0)" ).append("\n"); 
		query.append("            ,NVL(@[vis_rng_no]      ,0)" ).append("\n"); 
		query.append("            ,NVL(@[crnt_act_spd]    ,0)" ).append("\n"); 
		query.append("            ,NVL(@[crnt_act_rpm_pwr],0)" ).append("\n"); 
		query.append("            ,NVL(@[slp_rt]          ,0)" ).append("\n"); 
		query.append("            ,NVL(@[rmn_dist]        ,0)" ).append("\n"); 
		query.append("            ,NVL(@[rmn_avg_spd]     ,0)" ).append("\n"); 
		query.append("            ,NVL(@[foil_csm_wgt]    ,0)" ).append("\n"); 
		query.append("            ,NVL(@[doil_csm_wgt]    ,0)" ).append("\n"); 
		query.append("            ,NVL(@[crs_no]          ,0)" ).append("\n"); 
		query.append("            ,NVL(@[lod_ind_qty]     ,0)" ).append("\n"); 
		query.append("            ,@[cre_usr_id]													" ).append("\n"); 
		query.append("            ,SYSDATE														" ).append("\n"); 
		query.append("            ,@[cre_usr_id]													" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}
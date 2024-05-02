/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOAddActPortSkdHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.02 
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

public class ActualScheduleMgtDBDAOAddActPortSkdHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actaul Schedule 입력 및 변경에 관한 이력을 생성한다.
	  * ---------------------------------------------------------------------------------------
	  * 2010.12.20 CHM-201007578-01 진마리아 INP_DT, INI_USR_ID 컬럼 추가
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOAddActPortSkdHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_atd_inp_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_cre_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_atd_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_atb_inp_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_ata_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_atb_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_ata_inp_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOAddActPortSkdHisCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_ACT_PORT_SKD_HIS (" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	VPS_PORT_CD" ).append("\n"); 
		query.append(",	CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	CNG_SEQ" ).append("\n"); 
		query.append(",	ACT_ARR_DT" ).append("\n"); 
		query.append(",	ACT_BRTH_DT" ).append("\n"); 
		query.append(",	ACT_DEP_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	ACT_ATA_INP_DT" ).append("\n"); 
		query.append(",	ACT_ATA_INP_USR_ID" ).append("\n"); 
		query.append(",	ACT_ATB_INP_DT" ).append("\n"); 
		query.append(",	ACT_ATB_INP_USR_ID" ).append("\n"); 
		query.append(",	ACT_ATD_INP_DT" ).append("\n"); 
		query.append(",	ACT_ATD_INP_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	HIS_CRE_RSN_CD" ).append("\n"); 
		query.append(",	LST_ETA_DT" ).append("\n"); 
		query.append(",	LST_ETB_DT" ).append("\n"); 
		query.append(",	LST_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[vps_port_cd]" ).append("\n"); 
		query.append(",	@[clpt_ind_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("     SELECT  NVL(MAX(CNG_SEQ),0) + 1" ).append("\n"); 
		query.append("     FROM    VSK_ACT_PORT_SKD_HIS	HH" ).append("\n"); 
		query.append("     WHERE   HH.VSL_CD 				= @[vsl_cd]" ).append("\n"); 
		query.append("     AND     HH.SKD_VOY_NO 			= @[skd_voy_no]" ).append("\n"); 
		query.append("     AND     HH.SKD_DIR_CD			= @[skd_dir_cd]" ).append("\n"); 
		query.append("     AND     HH.VPS_PORT_CD 		= @[vps_port_cd]" ).append("\n"); 
		query.append("     AND     HH.CLPT_IND_SEQ 		= @[clpt_ind_seq]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	TO_DATE(@[act_arr_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[act_brth_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[act_dep_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	TO_DATE(@[act_ata_inp_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[act_ata_inp_usr_id]" ).append("\n"); 
		query.append(",	TO_DATE(@[act_atb_inp_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[act_atb_inp_usr_id]" ).append("\n"); 
		query.append(",	TO_DATE(@[act_atd_inp_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[act_atd_inp_usr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[his_cre_rsn_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[lst_eta_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[lst_etb_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[lst_etd_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
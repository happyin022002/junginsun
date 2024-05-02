/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOModifyRsltVslSkdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOModifyRsltVslSkdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_VSL_SKD_RSLT 정보를 수정합니다.
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOModifyRsltVslSkdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_dlay_hrs1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_rmk1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dlay_rsn_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_cng_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dlay_rsn_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_rmk2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_rmk1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_dlay_rsn_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dlay_hrs1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dlay_hrs2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_dlay_hrs2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_dlay_rsn_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_rmk2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOModifyRsltVslSkdUSQL").append("\n"); 
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
		query.append("/*************************************************************************************************/" ).append("\n"); 
		query.append("-- 1.연속 지연(INCL_BRTH_DLAY_HRS, INCL_DEP_DLAY_HRS)" ).append("\n"); 
		query.append("--   : 이전 Port에서 부터 시작한 지연 시간과 자기 Port에서 발생한 지연 시간을 포함한 지연을 의미함." ).append("\n"); 
		query.append("--   (Skip Port는 제외)" ).append("\n"); 
		query.append("--   INCL_BRTH_DLAY_HRS = act_brth_dt - pf_etb_dt : (-) 값은 제외" ).append("\n"); 
		query.append("--   INCL_DEP_DLAY_HRS  = act_dep_dt  - pf_etd_dt : (-) 값은 제외" ).append("\n"); 
		query.append("--------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- 2.자기 지연(XCLD_BRTH_DLAY_HRS, XCLD_DEP_DLAY_HRS)" ).append("\n"); 
		query.append("--   : 순수하게 자기 PORT에서 발생한 지연 시간을 의미한다." ).append("\n"); 
		query.append("--   XCLD_BRTH_DLAY_HRS = arr_dlay_hrs1 + arr_dlay_hrs2" ).append("\n"); 
		query.append("--   XCLD_DEP_DLAY_HRS  = dep_dlay_hrs1 + dep_dlay_hrs2" ).append("\n"); 
		query.append("/*************************************************************************************************/" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("UPDATE VSK_VSL_SKD_RSLT SET" ).append("\n"); 
		query.append("       PF_ETB_DT          = TO_DATE(@[pf_etb_dt], 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("       PF_ETD_DT          = TO_DATE(@[pf_etd_dt], 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("       ARR_DLAY_HRS1      = NVL(@[arr_dlay_hrs1], 0)," ).append("\n"); 
		query.append("       ARR_DLAY_HRS2      = NVL(@[arr_dlay_hrs2], 0)," ).append("\n"); 
		query.append("       ARR_DLAY_RSN_CD1   = @[arr_dlay_rsn_cd1]," ).append("\n"); 
		query.append("       ARR_DLAY_RSN_CD2   = @[arr_dlay_rsn_cd2]," ).append("\n"); 
		query.append("       ARR_RMK1           = @[arr_rmk1]," ).append("\n"); 
		query.append("       ARR_RMK2           = @[arr_rmk2]," ).append("\n"); 
		query.append("       DEP_DLAY_HRS1      = NVL(@[dep_dlay_hrs1], 0)," ).append("\n"); 
		query.append("       DEP_DLAY_HRS2      = NVL(@[dep_dlay_hrs2], 0)," ).append("\n"); 
		query.append("       DEP_DLAY_RSN_CD1   = @[dep_dlay_rsn_cd1]," ).append("\n"); 
		query.append("       DEP_DLAY_RSN_CD2   = @[dep_dlay_rsn_cd2]," ).append("\n"); 
		query.append("       DEP_RMK1           = @[dep_rmk1]," ).append("\n"); 
		query.append("       DEP_RMK2           = @[dep_rmk2]," ).append("\n"); 
		query.append("       XCLD_BRTH_DLAY_HRS = NVL(@[arr_dlay_hrs1], 0) + NVL(@[arr_dlay_hrs2], 0)," ).append("\n"); 
		query.append("       XCLD_DEP_DLAY_HRS  = NVL(@[dep_dlay_hrs1], 0) + NVL(@[dep_dlay_hrs2], 0)," ).append("\n"); 
		query.append("       INCL_BRTH_DLAY_HRS = DECODE(@[skd_cng_sts_cd], 'S', 0, DECODE( SIGN(NVL(ROUND((TO_DATE(@[act_brth_dt], 'YYYY-MM-DD HH24:MI') - TO_DATE(@[pf_etb_dt], 'YYYY-MM-DD HH24:MI'))*24, 0), 0)), -1, 0 , NVL(ROUND((TO_DATE(@[act_brth_dt], 'YYYY-MM-DD HH24:MI') - TO_DATE(@[pf_etb_dt], 'YYYY-MM-DD HH24:MI'))*24, 0), 0)))," ).append("\n"); 
		query.append("       INCL_DEP_DLAY_HRS  = DECODE(@[skd_cng_sts_cd], 'S', 0, DECODE( SIGN(NVL(ROUND((TO_DATE(@[act_dep_dt], 'YYYY-MM-DD HH24:MI' ) - TO_DATE(@[pf_etd_dt], 'YYYY-MM-DD HH24:MI'))*24, 0), 0)), -1, 0 , NVL(ROUND((TO_DATE(@[act_dep_dt] , 'YYYY-MM-DD HH24:MI') - TO_DATE(@[pf_etd_dt], 'YYYY-MM-DD HH24:MI'))*24, 0), 0)))," ).append("\n"); 
		query.append("       UPD_USR_ID         = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SUB_TRD_DIR_CD = @[sub_trd_dir_cd]" ).append("\n"); 
		query.append("AND    VPS_PORT_CD    = @[vps_port_cd]" ).append("\n"); 
		query.append("AND    CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    CLPT_SEQ       = @[clpt_seq]        " ).append("\n"); 
		query.append("AND    SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 

	}
}
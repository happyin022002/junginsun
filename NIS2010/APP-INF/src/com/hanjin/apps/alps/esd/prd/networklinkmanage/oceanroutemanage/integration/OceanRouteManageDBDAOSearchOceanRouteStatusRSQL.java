/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanRouteManageDBDAOSearchOceanRouteStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.18 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOSearchOceanRouteStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOceanRouteStatus
	  * </pre>
	  */
	public OceanRouteManageDBDAOSearchOceanRouteStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocn_ipc_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("multi_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOSearchOceanRouteStatusRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_NL( SL, PS, TL) */" ).append("\n"); 
		query.append("ps.vsl_slan_cd, ps.pf_svc_tp_cd," ).append("\n"); 
		query.append("ps.svc_dur_dys, ps.stnd_svc_spd," ).append("\n"); 
		query.append("TO_CHAR (ps.cre_dt, 'YYYY-MM-DD') cre_dt," ).append("\n"); 
		query.append("TO_CHAR (ps.upd_dt, 'YYYY-MM-DD') upd_dt," ).append("\n"); 
		query.append("ps.slan_stnd_flg," ).append("\n"); 
		query.append("NVL (ps.mml_usd_flg, 'N') prod_ocn_rout_use_flg," ).append("\n"); 
		query.append("NVL (tl.pctl_svc_mod_cd, 'OCN') pctl_svc_mod_cd," ).append("\n"); 
		query.append("NVL (tl.upd_ind_cd, 'N') upd_ind_cd," ).append("\n"); 
		query.append("ps.pf_skd_rmk" ).append("\n"); 
		query.append("FROM   VSK_PF_SKD ps, mdm_vsl_svc_lane sl, prd_svc_lane tl" ).append("\n"); 
		query.append("WHERE  sl.vsl_slan_cd = ps.vsl_slan_cd" ).append("\n"); 
		query.append("AND    sl.vsl_svc_tp_cd <> 'O'" ).append("\n"); 
		query.append("AND    sl.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND    DECODE(NVL(tl.upd_ind_cd, 'N'), 'N', ps.mml_usd_flg || NVL(ps.mml_usd_flg, 'N'), 'YY') <> 'NN'" ).append("\n"); 
		query.append("AND    ps.pf_svc_tp_cd <> 'OFFL'" ).append("\n"); 
		query.append("AND    ps.pf_svc_tp_cd <> 'PTPL'" ).append("\n"); 
		query.append("AND    sl.vsl_slan_cd LIKE @[lane_cd]  || '%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ocn_ipc_flag} !='')" ).append("\n"); 
		query.append("AND    tl.pctl_svc_mod_cd LIKE @[ocn_ipc_flag]  || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${multi_ind} !='')" ).append("\n"); 
		query.append("AND    ps.mml_usd_flg LIKE @[multi_ind]  || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${status} =='')" ).append("\n"); 
		query.append("AND    ps.vsl_slan_cd = tl.vsl_slan_cd(+)" ).append("\n"); 
		query.append("AND    ps.pf_svc_tp_cd = tl.pctl_svc_tp_cd(+)" ).append("\n"); 
		query.append("#elseif(${status} =='N')" ).append("\n"); 
		query.append("AND    ps.vsl_slan_cd = tl.vsl_slan_cd(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    ps.pf_svc_tp_cd = tl.pctl_svc_tp_cd(+)" ).append("\n"); 
		query.append("AND    NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM   prd_svc_lane a" ).append("\n"); 
		query.append("WHERE  ps.vsl_slan_cd = a.vsl_slan_cd AND ps.pf_svc_tp_cd = a.pctl_svc_tp_cd)" ).append("\n"); 
		query.append("#elseif(${status} == 'C')" ).append("\n"); 
		query.append("AND    ps.vsl_slan_cd = tl.vsl_slan_cd(+)" ).append("\n"); 
		query.append("AND    ps.pf_svc_tp_cd = tl.pctl_svc_tp_cd(+)" ).append("\n"); 
		query.append("AND    tl.upd_ind_cd IN ('I', 'U')" ).append("\n"); 
		query.append("#elseif(${status} == 'D')" ).append("\n"); 
		query.append("AND    ps.vsl_slan_cd = tl.vsl_slan_cd(+)" ).append("\n"); 
		query.append("AND    ps.pf_svc_tp_cd = tl.pctl_svc_tp_cd(+)" ).append("\n"); 
		query.append("AND    tl.upd_ind_cd = 'D'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
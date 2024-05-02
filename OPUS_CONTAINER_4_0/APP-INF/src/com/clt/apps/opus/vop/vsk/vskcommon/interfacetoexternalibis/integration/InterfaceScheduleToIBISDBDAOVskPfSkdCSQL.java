/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToIBISDBDAOVskPfSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToIBISDBDAOVskPfSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ..
	  * </pre>
	  */
	public InterfaceScheduleToIBISDBDAOVskPfSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_svc_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_skd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mml_usd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brth_itval_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibis_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_vsl_clss_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_stnd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_dur_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_vsl_clss_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vsl_clss_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("avg_spd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToIBISDBDAOVskPfSkdCSQL").append("\n"); 
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
		query.append("#if (${if_mnpl_cd} == '') " ).append("\n"); 
		query.append("INSERT INTO VSK_PF_SKD_IBIS_IF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      VSL_SLAN_CD" ).append("\n"); 
		query.append("    , PF_SVC_TP_CD" ).append("\n"); 
		query.append("    , IBIS_IF_SEQ" ).append("\n"); 
		query.append("    , IF_SND_CD" ).append("\n"); 
		query.append("    , IF_MNPL_CD" ).append("\n"); 
		query.append("    , SLAN_STND_FLG" ).append("\n"); 
		query.append("    , SVC_DUR_DYS" ).append("\n"); 
		query.append("    , STND_SVC_SPD" ).append("\n"); 
		query.append("    , BRTH_ITVAL_DYS" ).append("\n"); 
		query.append("    , MML_USD_FLG" ).append("\n"); 
		query.append("    , SIM_DT" ).append("\n"); 
		query.append("    , SIM_NO" ).append("\n"); 
		query.append("    , N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append("    , N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append("    , N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("    , N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append("    , N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append("    , N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append("    , CLPT_KNT" ).append("\n"); 
		query.append("    , TTL_DIST" ).append("\n"); 
		query.append("    , MAX_SPD" ).append("\n"); 
		query.append("    , AVG_SPD" ).append("\n"); 
		query.append("    , DELT_FLG" ).append("\n"); 
		query.append("    , PF_SKD_RMK" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("      @[vsl_slan_cd]" ).append("\n"); 
		query.append("    , @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("    , @[ibis_if_seq]" ).append("\n"); 
		query.append("    , NVL((SELECT /*+ INDEX_DESC(A XPKVSK_PF_SKD_IBIS_IF) */ 'N'" ).append("\n"); 
		query.append("            FROM VSK_PF_SKD_IBIS_IF A WHERE VSL_SLAN_CD=@[vsl_slan_cd] AND PF_SVC_TP_CD=@[pf_svc_tp_cd] AND IF_SND_CD='Y' AND ROWNUM=1) ,'X')" ).append("\n"); 
		query.append("    , 'D'" ).append("\n"); 
		query.append("    , @[slan_stnd_flg]" ).append("\n"); 
		query.append("    , @[svc_dur_dys]" ).append("\n"); 
		query.append("    , @[stnd_svc_spd]" ).append("\n"); 
		query.append("    , @[brth_itval_dys]" ).append("\n"); 
		query.append("    , @[mml_usd_flg]" ).append("\n"); 
		query.append("    , @[sim_dt]" ).append("\n"); 
		query.append("    , @[sim_no]" ).append("\n"); 
		query.append("    , @[n1st_vsl_clss_cd]" ).append("\n"); 
		query.append("    , @[n1st_vsl_clss_knt]" ).append("\n"); 
		query.append("    , @[n2nd_vsl_clss_cd]" ).append("\n"); 
		query.append("    , @[n2nd_vsl_clss_knt]" ).append("\n"); 
		query.append("    , @[n3rd_vsl_clss_cd]" ).append("\n"); 
		query.append("    , @[n3rd_vsl_clss_knt]" ).append("\n"); 
		query.append("    , @[clpt_knt]" ).append("\n"); 
		query.append("    , @[ttl_dist]" ).append("\n"); 
		query.append("    , @[max_spd]" ).append("\n"); 
		query.append("    , @[avg_spd]" ).append("\n"); 
		query.append("    , @[delt_flg]" ).append("\n"); 
		query.append("    , @[pf_skd_rmk]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO VSK_PF_SKD_IBIS_IF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      VSL_SLAN_CD" ).append("\n"); 
		query.append("    , PF_SVC_TP_CD" ).append("\n"); 
		query.append("    , IBIS_IF_SEQ" ).append("\n"); 
		query.append("    , IF_SND_CD" ).append("\n"); 
		query.append("    , IF_MNPL_CD" ).append("\n"); 
		query.append("    , SLAN_STND_FLG" ).append("\n"); 
		query.append("    , SVC_DUR_DYS" ).append("\n"); 
		query.append("    , STND_SVC_SPD" ).append("\n"); 
		query.append("    , BRTH_ITVAL_DYS" ).append("\n"); 
		query.append("    , MML_USD_FLG" ).append("\n"); 
		query.append("    , SIM_DT" ).append("\n"); 
		query.append("    , SIM_NO" ).append("\n"); 
		query.append("    , N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append("    , N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append("    , N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("    , N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append("    , N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append("    , N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append("    , CLPT_KNT" ).append("\n"); 
		query.append("    , TTL_DIST" ).append("\n"); 
		query.append("    , MAX_SPD" ).append("\n"); 
		query.append("    , AVG_SPD" ).append("\n"); 
		query.append("    , DELT_FLG" ).append("\n"); 
		query.append("    , PF_SKD_RMK" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      VSL_SLAN_CD" ).append("\n"); 
		query.append("    , PF_SVC_TP_CD" ).append("\n"); 
		query.append("    , @[ibis_if_seq]" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("    , 'I'" ).append("\n"); 
		query.append("    , SLAN_STND_FLG" ).append("\n"); 
		query.append("    , SVC_DUR_DYS" ).append("\n"); 
		query.append("    , STND_SVC_SPD" ).append("\n"); 
		query.append("    , BRTH_ITVAL_DYS" ).append("\n"); 
		query.append("    , MML_USD_FLG" ).append("\n"); 
		query.append("    , SIM_DT" ).append("\n"); 
		query.append("    , SIM_NO" ).append("\n"); 
		query.append("    , N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append("    , N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append("    , N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("    , N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append("    , N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append("    , N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append("    , CLPT_KNT" ).append("\n"); 
		query.append("    , TTL_DIST" ).append("\n"); 
		query.append("    , MAX_SPD" ).append("\n"); 
		query.append("    , AVG_SPD" ).append("\n"); 
		query.append("    , DELT_FLG" ).append("\n"); 
		query.append("    , PF_SKD_RMK" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append(" FROM VSK_PF_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("  AND PF_SVC_TP_CD = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
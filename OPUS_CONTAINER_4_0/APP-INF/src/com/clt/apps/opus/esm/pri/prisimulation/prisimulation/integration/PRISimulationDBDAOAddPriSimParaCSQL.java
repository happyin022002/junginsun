/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAOAddPriSimParaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOAddPriSimParaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PRISimulationDBDAOAddPriSimParaCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnd_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ga_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("goh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_self_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOAddPriSimParaCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SIM_PARA" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("PCTL_NO" ).append("\n"); 
		query.append(", SC_NO" ).append("\n"); 
		query.append(", RFA_NO" ).append("\n"); 
		query.append(", TAA_NO" ).append("\n"); 
		query.append(", PRC_CGO_TP_CD" ).append("\n"); 
		query.append(", EQ_TP_CD" ).append("\n"); 
		query.append(", SUB_TRD_CD" ).append("\n"); 
		query.append(", SVC_SCP_CD" ).append("\n"); 
		query.append(", CMDT_CD" ).append("\n"); 
		query.append(", ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", ACT_CUST_SEQ" ).append("\n"); 
		query.append(", ACT_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", MEAS_QTY" ).append("\n"); 
		query.append(", MEAS_UT_CD" ).append("\n"); 
		query.append(", USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(", CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append(", XTER_SI_CD" ).append("\n"); 
		query.append(", SOC_FLG" ).append("\n"); 
		query.append(", BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(", IMDG_CLSS_CD" ).append("\n"); 
		query.append(", IN_GA_FLG" ).append("\n"); 
		query.append(", HBL_KNT" ).append("\n"); 
		query.append(", MF_SELF_KNT" ).append("\n"); 
		query.append(", DOC_LOC_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append(", DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append(") VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[pctl_no]" ).append("\n"); 
		query.append("#if (${ctrt_tp} == 'S') " ).append("\n"); 
		query.append(", @[ctrt_no]" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append("#elseif (${ctrt_tp} == 'R') " ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", @[ctrt_no]" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append("#elseif (${ctrt_tp} == 'T') " ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", @[ctrt_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", @[cgo_tp_cd]" ).append("\n"); 
		query.append(", @[eq_tp_cd]" ).append("\n"); 
		query.append(", @[sub_trd_cd]" ).append("\n"); 
		query.append(", @[svc_scp_cd]" ).append("\n"); 
		query.append(", @[cmdt_cd]" ).append("\n"); 
		query.append(", @[cust_cnt_cd]" ).append("\n"); 
		query.append(", @[cust_seq]" ).append("\n"); 
		query.append(", @[act_wgt]" ).append("\n"); 
		query.append(", @[wgt_ut_cd]" ).append("\n"); 
		query.append(", @[meas_qty]" ).append("\n"); 
		query.append(", @[meas_ut_cd]" ).append("\n"); 
		query.append(", @[usa_cstms_file_cd]" ).append("\n"); 
		query.append(", @[cnd_cstms_file_cd]" ).append("\n"); 
		query.append(", @[si_cd]" ).append("\n"); 
		query.append(", @[soc_flg]" ).append("\n"); 
		query.append(", @[goh_cd]" ).append("\n"); 
		query.append(", @[imdg_clss_cd]" ).append("\n"); 
		query.append(", @[in_ga_flg]" ).append("\n"); 
		query.append(", @[hbl_knt]" ).append("\n"); 
		query.append(", @[mf_self_knt]" ).append("\n"); 
		query.append(", @[doc_loc_cd]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[org_trns_mod_cd]" ).append("\n"); 
		query.append(", @[dest_trns_mod_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
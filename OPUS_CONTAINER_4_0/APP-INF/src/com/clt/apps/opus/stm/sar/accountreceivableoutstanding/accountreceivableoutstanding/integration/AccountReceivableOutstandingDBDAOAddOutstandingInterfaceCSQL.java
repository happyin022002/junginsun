/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOAddOutstandingInterfaceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOAddOutstandingInterfaceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Outstanding Interface
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOAddOutstandingInterfaceCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_to_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_tp_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_mk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no_split",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_n3rd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ar_offst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tj_src_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOAddOutstandingInterfaceCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_OTS_IF " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    OTS_IF_SEQ" ).append("\n"); 
		query.append("    , IF_NO" ).append("\n"); 
		query.append("    , RHQ_CD" ).append("\n"); 
		query.append("    , AR_OFC_CD" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , OFC_CURR_CD" ).append("\n"); 
		query.append("    , OTS_SRC_CD" ).append("\n"); 
		query.append("    , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , BKG_NO" ).append("\n"); 
		query.append("    , BKG_NO_SPLIT" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , TRNK_VVD_CD" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , LANE_CD" ).append("\n"); 
		query.append("    , SAIL_ARR_DT" ).append("\n"); 
		query.append("    , BKG_IO_BND_CD" ).append("\n"); 
		query.append("    , POR_CD" ).append("\n"); 
		query.append("    , POL_CD" ).append("\n"); 
		query.append("    , POD_CD" ).append("\n"); 
		query.append("    , DEL_CD" ).append("\n"); 
		query.append("    , CUST_SREP_CD" ).append("\n"); 
		query.append("    , DUE_DT" ).append("\n"); 
		query.append("    , STL_FLG" ).append("\n"); 
		query.append("    , BKG_REF_NO" ).append("\n"); 
		query.append("    , AP_AR_OFFST_NO" ).append("\n"); 
		query.append("    , CR_MK_FLG" ).append("\n"); 
		query.append("    , XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , LST_INV_NO" ).append("\n"); 
		query.append("    , OTS_GRP_TP_CD" ).append("\n"); 
		query.append("    , OTS_TP_CD" ).append("\n"); 
		query.append("    , OTS_RMK" ).append("\n"); 
		query.append("    , IF_DT" ).append("\n"); 
		query.append("    , INV_DT" ).append("\n"); 
		query.append("    , CLT_OFC_CD" ).append("\n"); 
		query.append("    , OTS_RT_FLG" ).append("\n"); 
		query.append("    , SC_NO" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , TJ_SRC_NM" ).append("\n"); 
		query.append("    , CHG_TP_CD" ).append("\n"); 
		query.append("    , GL_DT" ).append("\n"); 
		query.append("    , BL_CURR_CD" ).append("\n"); 
		query.append("    , OTS_AMT" ).append("\n"); 
		query.append("    , OTS_IF_FLG" ).append("\n"); 
		query.append("    , REV_TP_SRC_CD" ).append("\n"); 
		query.append("	, XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SAR_OTS_IF_SEQ.NEXTVAL" ).append("\n"); 
		query.append("    , @[if_no]" ).append("\n"); 
		query.append("    , @[rhq_cd]" ).append("\n"); 
		query.append("    , @[ar_ofc_cd]" ).append("\n"); 
		query.append("    , @[bl_no]" ).append("\n"); 
		query.append("    , @[inv_no]" ).append("\n"); 
		query.append("    , @[ofc_curr_cd]" ).append("\n"); 
		query.append("    , @[ots_src_cd]" ).append("\n"); 
		query.append("    , @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("    , @[bil_to_cust_seq]" ).append("\n"); 
		query.append("    , @[shp_to_cust_cnt_cd]" ).append("\n"); 
		query.append("    , @[shp_to_cust_seq]" ).append("\n"); 
		query.append("    , @[bkg_no]" ).append("\n"); 
		query.append("    , @[bkg_no_split]" ).append("\n"); 
		query.append("    , @[vsl_cd]" ).append("\n"); 
		query.append("    , @[skd_voy_no]" ).append("\n"); 
		query.append("    , @[dir_cd]" ).append("\n"); 
		query.append("    , @[trnk_vvd_cd]" ).append("\n"); 
		query.append("    , @[svc_scp_cd]" ).append("\n"); 
		query.append("    , @[lane_cd]" ).append("\n"); 
		query.append("    , @[sail_arr_dt]" ).append("\n"); 
		query.append("    , @[bkg_io_bnd_cd]" ).append("\n"); 
		query.append("    , @[por_cd]" ).append("\n"); 
		query.append("    , @[pol_cd]" ).append("\n"); 
		query.append("    , @[pod_cd]" ).append("\n"); 
		query.append("    , @[del_cd]" ).append("\n"); 
		query.append("    , @[cust_srep_cd]" ).append("\n"); 
		query.append("    , @[due_dt]" ).append("\n"); 
		query.append("    , @[stl_flg]" ).append("\n"); 
		query.append("    , @[bkg_ref_no]" ).append("\n"); 
		query.append("    , @[ap_ar_offst_no]" ).append("\n"); 
		query.append("    , @[cr_mk_flg]" ).append("\n"); 
		query.append("    , @[xch_rt_tp_cd]" ).append("\n"); 
		query.append("    , @[lst_inv_no]" ).append("\n"); 
		query.append("    , @[ots_grp_tp_cd]" ).append("\n"); 
		query.append("    , @[ots_tp_cd]" ).append("\n"); 
		query.append("    , @[ots_rmk]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[inv_dt]" ).append("\n"); 
		query.append("    , @[clt_ofc_cd]" ).append("\n"); 
		query.append("    , @[ots_rt_flg]" ).append("\n"); 
		query.append("    , @[sc_no]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[tj_src_nm]" ).append("\n"); 
		query.append("    , @[chg_tp_cd]" ).append("\n"); 
		query.append("    , @[gl_dt]" ).append("\n"); 
		query.append("    , @[bl_curr_cd]" ).append("\n"); 
		query.append("    , @[ots_amt]" ).append("\n"); 
		query.append("    , @[ots_if_flg]" ).append("\n"); 
		query.append("    , @[rev_tp_src_cd]" ).append("\n"); 
		query.append("	, @[xch_rt_n3rd_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
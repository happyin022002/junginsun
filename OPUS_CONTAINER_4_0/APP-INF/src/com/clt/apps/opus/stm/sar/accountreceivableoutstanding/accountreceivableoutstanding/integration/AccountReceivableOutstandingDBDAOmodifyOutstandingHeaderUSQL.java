/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOmodifyOutstandingHeaderUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
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

public class AccountReceivableOutstandingDBDAOmodifyOutstandingHeaderUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAR_OTS_HDR 테이블에 update
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOmodifyOutstandingHeaderUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ots_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_tp_src_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cr_mk_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sail_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOmodifyOutstandingHeaderUSQL").append("\n"); 
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
		query.append("UPDATE SAR_OTS_HDR SET" ).append("\n"); 
		query.append("    OFC_CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("    , OTS_SRC_CD = @[ots_src_cd]" ).append("\n"); 
		query.append("    , BIL_TO_CUST_CNT_CD = @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("    , BIL_TO_CUST_SEQ = @[bil_to_cust_seq]" ).append("\n"); 
		query.append("    , BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    , VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    , SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    , DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("    , TRNK_VVD_CD = @[trnk_vvd_cd]" ).append("\n"); 
		query.append("    , SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    , LANE_CD = @[lane_cd]" ).append("\n"); 
		query.append("    , SAIL_ARR_DT = @[sail_arr_dt]" ).append("\n"); 
		query.append("    , BKG_IO_BND_CD = @[bkg_io_bnd_cd]" ).append("\n"); 
		query.append("    , POR_CD = @[por_cd]" ).append("\n"); 
		query.append("    , POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    , POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("    , DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("    , CUST_SREP_CD = @[cust_srep_cd]" ).append("\n"); 
		query.append("    , DUE_DT = @[due_dt]" ).append("\n"); 
		query.append("	, STL_FLG = NVL((SELECT 'N'" ).append("\n"); 
		query.append("       	   			 FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("       	   			 WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("       	   			 AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("       	   			 AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       	   			 AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("		   			 AND NVL(BAL_AMT, 0) <> 0" ).append("\n"); 
		query.append("		   			 AND ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("    , BKG_REF_NO = @[bkg_ref_no]" ).append("\n"); 
		query.append("    , AP_AR_OFFST_NO = @[ap_ar_offst_no]" ).append("\n"); 
		query.append("    , CR_MK_FLG = @[cr_mk_flg]" ).append("\n"); 
		query.append("    , XCH_RT_TP_CD = @[xch_rt_tp_cd]" ).append("\n"); 
		query.append("	, OTS_GRP_TP_CD = @[ots_grp_tp_cd]" ).append("\n"); 
		query.append("	, OTS_TP_CD = @[ots_tp_cd]" ).append("\n"); 
		query.append("	, OTS_RMK = @[ots_rmk]" ).append("\n"); 
		query.append("    , IF_DT = SYSDATE" ).append("\n"); 
		query.append("    , INV_DT = @[inv_dt]" ).append("\n"); 
		query.append("    , CLT_OFC_CD = @[clt_ofc_cd]" ).append("\n"); 
		query.append("	, OTS_RT_FLG = NVL((SELECT 'N' " ).append("\n"); 
		query.append("       	   				FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("           				WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("           				AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("           				AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           				AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("						AND NVL(INV_AMT, 0) <> 0" ).append("\n"); 
		query.append("	       				AND (NVL(LOCL_XCH_RT, 0) = 0 OR NVL(USD_XCH_RT, 0) = 0)" ).append("\n"); 
		query.append("           				AND ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("    , SC_NO = @[sc_no]" ).append("\n"); 
		query.append("    , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("    , REV_TP_SRC_CD = @[rev_tp_src_cd]" ).append("\n"); 
		query.append("    , SHP_TO_CUST_CNT_CD = @[shp_to_cust_cnt_cd]" ).append("\n"); 
		query.append("    , SHP_TO_CUST_SEQ = @[shp_to_cust_seq]" ).append("\n"); 
		query.append("    , XCH_RT_N3RD_TP_CD = @[xch_rt_n3rd_tp_cd]" ).append("\n"); 
		query.append("    , XCH_RT_DT = @[xch_rt_dt]" ).append("\n"); 
		query.append("	, MAX_AR_IF_NO = @[max_ar_if_no]" ).append("\n"); 
		query.append("	, SAIL_DT = @[sail_dt]" ).append("\n"); 
		query.append("	, INV_CURR_CD = @[inv_curr_cd]" ).append("\n"); 
		query.append("	, INV_LOCL_XCH_RT = @[inv_locl_xch_rt]" ).append("\n"); 
		query.append("	, INV_USD_XCH_RT = @[inv_usd_xch_rt]" ).append("\n"); 
		query.append("WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND INV_NO = @[inv_no]" ).append("\n"); 

	}
}
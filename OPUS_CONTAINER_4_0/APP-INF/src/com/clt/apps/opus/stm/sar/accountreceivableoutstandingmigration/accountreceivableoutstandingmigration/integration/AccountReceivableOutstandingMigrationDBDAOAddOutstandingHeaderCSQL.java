/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingMigrationDBDAOAddOutstandingHeaderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingMigrationDBDAOAddOutstandingHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAR_OTS_HDR 테이블에 insert
	  * </pre>
	  */
	public AccountReceivableOutstandingMigrationDBDAOAddOutstandingHeaderCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_pay_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingMigrationDBDAOAddOutstandingHeaderCSQL").append("\n"); 
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
		query.append("INSERT INTO OPUSADM_TMP.SAR_OTS_HDR" ).append("\n"); 
		query.append("    (  RHQ_CD" ).append("\n"); 
		query.append("     , OTS_OFC_CD" ).append("\n"); 
		query.append("     , BL_NO" ).append("\n"); 
		query.append("     , INV_NO" ).append("\n"); 
		query.append("     , OFC_CURR_CD" ).append("\n"); 
		query.append("     , OTS_SRC_CD" ).append("\n"); 
		query.append("     , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("     , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , DIR_CD" ).append("\n"); 
		query.append("     , TRNK_VVD_CD" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , LANE_CD" ).append("\n"); 
		query.append("     , SAIL_ARR_DT" ).append("\n"); 
		query.append("     , BKG_IO_BND_CD" ).append("\n"); 
		query.append("     , POR_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , DEL_CD" ).append("\n"); 
		query.append("     , CUST_SREP_CD" ).append("\n"); 
		query.append("     , DUE_DT" ).append("\n"); 
		query.append("     , STL_FLG" ).append("\n"); 
		query.append("     , BKG_REF_NO" ).append("\n"); 
		query.append("     , AP_AR_OFFST_NO" ).append("\n"); 
		query.append("     , CR_MK_FLG" ).append("\n"); 
		query.append("     , XCH_RT_TP_CD" ).append("\n"); 
		query.append("     , OTS_GRP_TP_CD" ).append("\n"); 
		query.append("     , OTS_TP_CD" ).append("\n"); 
		query.append("     , OTS_RMK" ).append("\n"); 
		query.append("     , IF_DT" ).append("\n"); 
		query.append("     , INV_DT" ).append("\n"); 
		query.append("     , CLT_OFC_CD" ).append("\n"); 
		query.append("     , OTS_RT_FLG" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , REV_TP_SRC_CD" ).append("\n"); 
		query.append("     , SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("     , SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("     , XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append("     , XCH_RT_DT" ).append("\n"); 
		query.append("     , MAX_AR_IF_NO" ).append("\n"); 
		query.append("     , SAIL_DT" ).append("\n"); 
		query.append("     , INV_CURR_CD" ).append("\n"); 
		query.append("     , INV_LOCL_XCH_RT" ).append("\n"); 
		query.append("     , INV_USD_XCH_RT" ).append("\n"); 
		query.append("     , OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("     , OTS_PAY_CD" ).append("\n"); 
		query.append("     , ORG_INV_NO" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("       @[rhq_cd]" ).append("\n"); 
		query.append("     , @[ots_ofc_cd]" ).append("\n"); 
		query.append("     , @[bl_no]" ).append("\n"); 
		query.append("     , @[inv_no]" ).append("\n"); 
		query.append("     , @[ofc_curr_cd]" ).append("\n"); 
		query.append("     , @[ots_src_cd]" ).append("\n"); 
		query.append("     , @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("     , @[bil_to_cust_seq]" ).append("\n"); 
		query.append("     , @[bkg_no]" ).append("\n"); 
		query.append("     , @[vsl_cd]" ).append("\n"); 
		query.append("     , @[skd_voy_no]" ).append("\n"); 
		query.append("     , @[dir_cd]" ).append("\n"); 
		query.append("     , @[trnk_vvd_cd]" ).append("\n"); 
		query.append("     , @[svc_scp_cd]" ).append("\n"); 
		query.append("     , @[lane_cd]" ).append("\n"); 
		query.append("     , @[sail_arr_dt]" ).append("\n"); 
		query.append("     , @[bkg_io_bnd_cd]" ).append("\n"); 
		query.append("     , @[por_cd]" ).append("\n"); 
		query.append("     , @[pol_cd]" ).append("\n"); 
		query.append("     , @[pod_cd]" ).append("\n"); 
		query.append("     , @[del_cd]" ).append("\n"); 
		query.append("     , @[cust_srep_cd]" ).append("\n"); 
		query.append("     , @[due_dt]" ).append("\n"); 
		query.append("     , NVL((SELECT  'N'" ).append("\n"); 
		query.append("       	    FROM    OPUSADM_TMP.SAR_OTS_DTL" ).append("\n"); 
		query.append("            WHERE   RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("            AND     OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("            AND     BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            AND     INV_NO = @[inv_no]" ).append("\n"); 
		query.append("            AND     NVL(BAL_AMT, 0) <> 0" ).append("\n"); 
		query.append("            AND     ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("     , @[bkg_ref_no]" ).append("\n"); 
		query.append("     , @[ap_ar_offst_no]" ).append("\n"); 
		query.append("     , @[cr_mk_flg]" ).append("\n"); 
		query.append("     , @[xch_rt_tp_cd]" ).append("\n"); 
		query.append("     , @[ots_grp_tp_cd]" ).append("\n"); 
		query.append("     , @[ots_tp_cd]" ).append("\n"); 
		query.append("     , @[ots_rmk]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[inv_dt]" ).append("\n"); 
		query.append("     , @[clt_ofc_cd]" ).append("\n"); 
		query.append("     , NVL((SELECT  'N' " ).append("\n"); 
		query.append("            FROM    OPUSADM_TMP.SAR_OTS_DTL" ).append("\n"); 
		query.append("            WHERE   RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("            AND     OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("            AND     BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            AND     INV_NO = @[inv_no]" ).append("\n"); 
		query.append("            AND     NVL(INV_AMT, 0) <> 0" ).append("\n"); 
		query.append("            AND     (NVL(LOCL_XCH_RT, 0) = 0 OR NVL(USD_XCH_RT, 0) = 0)" ).append("\n"); 
		query.append("            AND     ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("     , @[sc_no]" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[upd_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[rev_tp_src_cd]" ).append("\n"); 
		query.append("     , @[shp_to_cust_cnt_cd]" ).append("\n"); 
		query.append("     , @[shp_to_cust_seq]" ).append("\n"); 
		query.append("     , @[xch_rt_n3rd_tp_cd]" ).append("\n"); 
		query.append("     , @[xch_rt_dt]" ).append("\n"); 
		query.append("     , @[max_ar_if_no]" ).append("\n"); 
		query.append("     , @[sail_dt]" ).append("\n"); 
		query.append("     , @[inv_curr_cd]" ).append("\n"); 
		query.append("     , @[inv_locl_xch_rt]" ).append("\n"); 
		query.append("     , @[inv_usd_xch_rt]" ).append("\n"); 
		query.append("     , @[obl_iss_ofc_cd]" ).append("\n"); 
		query.append("     , @[ots_pay_cd]" ).append("\n"); 
		query.append("     , @[org_inv_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}
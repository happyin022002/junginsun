/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchArOtsHisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOSearchArOtsHisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search SAR_OTS_HIS
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchArOtsHisListRSQL(){
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
		params.put("shp_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_his_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchArOtsHisListRSQL").append("\n"); 
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
		query.append("SELECT     IF_NO" ).append("\n"); 
		query.append("              , RHQ_CD" ).append("\n"); 
		query.append("              , OTS_OFC_CD" ).append("\n"); 
		query.append("              , BL_NO" ).append("\n"); 
		query.append("              , INV_NO" ).append("\n"); 
		query.append("              , OTS_HIS_SEQ" ).append("\n"); 
		query.append("              , CURR_CD" ).append("\n"); 
		query.append("              , OTS_HIS_TP_CD" ).append("\n"); 
		query.append("              , OTS_SRC_CD" ).append("\n"); 
		query.append("              , IF_DT" ).append("\n"); 
		query.append("              , GL_DT" ).append("\n"); 
		query.append("              , OTS_AMT" ).append("\n"); 
		query.append("              , USD_AMT" ).append("\n"); 
		query.append("              , REF_NO" ).append("\n"); 
		query.append("              , INV_OFC_CD" ).append("\n"); 
		query.append("              , OTS_RMK" ).append("\n"); 
		query.append("              , SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("              , SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("              , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("              , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("              , VSL_CD" ).append("\n"); 
		query.append("              , SKD_VOY_NO" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , SVC_SCP_CD" ).append("\n"); 
		query.append("              , XCH_RT_TP_CD" ).append("\n"); 
		query.append("              , LOCL_XCH_RT" ).append("\n"); 
		query.append("              , USD_XCH_RT" ).append("\n"); 
		query.append("              , BKG_IO_BND_CD" ).append("\n"); 
		query.append("              , XCH_RT_DT" ).append("\n"); 
		query.append("              , POL_CD" ).append("\n"); 
		query.append("              , POD_CD" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , CRE_DT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("              , UPD_DT" ).append("\n"); 
		query.append("              , REV_TP_SRC_CD" ).append("\n"); 
		query.append("              , REV_VVD_CD          " ).append("\n"); 
		query.append("    FROM      SAR_OTS_HIS" ).append("\n"); 
		query.append("    WHERE     1 = 1" ).append("\n"); 
		query.append("           #if( ${if_no} != '')" ).append("\n"); 
		query.append("              AND IF_NO = @[if_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${rhq_cd} != '')" ).append("\n"); 
		query.append("              AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ots_ofc_cd} != '')" ).append("\n"); 
		query.append("              AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${bl_no} != '')" ).append("\n"); 
		query.append("              AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${inv_no} != '')" ).append("\n"); 
		query.append("              AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ots_his_seq} != '')" ).append("\n"); 
		query.append("              AND OTS_HIS_SEQ = @[ots_his_seq]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${curr_cd} != '')" ).append("\n"); 
		query.append("              AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ots_his_tp_cd} != '')" ).append("\n"); 
		query.append("              AND OTS_HIS_TP_CD = @[ots_his_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ots_src_cd} != '')" ).append("\n"); 
		query.append("              AND OTS_SRC_CD = @[ots_src_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("           #if( ${ref_no} != '')" ).append("\n"); 
		query.append("              AND REF_NO = @[ref_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("              AND INV_OFC_CD = @[inv_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ots_rmk} != '')" ).append("\n"); 
		query.append("              AND OTS_RMK = @[ots_rmk]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${shp_to_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("              AND SHP_TO_CUST_CNT_CD = @[shp_to_cust_cnt_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${shp_to_cust_seq} != '')" ).append("\n"); 
		query.append("              AND SHP_TO_CUST_SEQ = @[shp_to_cust_seq]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${bil_to_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("              AND BIL_TO_CUST_CNT_CD = @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${bil_to_cust_seq} != '')" ).append("\n"); 
		query.append("              AND BIL_TO_CUST_SEQ = @[bil_to_cust_seq]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${vsl_cd} != '')" ).append("\n"); 
		query.append("              AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${skd_voy_no} != '')" ).append("\n"); 
		query.append("              AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${dir_cd} != '')" ).append("\n"); 
		query.append("              AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${svc_scp_cd} != '')" ).append("\n"); 
		query.append("              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${xch_rt_tp_cd} != '')" ).append("\n"); 
		query.append("              AND XCH_RT_TP_CD = @[xch_rt_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${locl_xch_rt} != '')" ).append("\n"); 
		query.append("              AND LOCL_XCH_RT = @[locl_xch_rt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${usd_xch_rt} != '')" ).append("\n"); 
		query.append("              AND USD_XCH_RT = @[usd_xch_rt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${bkg_io_bnd_cd} != '')" ).append("\n"); 
		query.append("              AND BKG_IO_BND_CD = @[bkg_io_bnd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${xch_rt_dt} != '')" ).append("\n"); 
		query.append("              AND XCH_RT_DT = @[xch_rt_dt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${pol_cd} != '')" ).append("\n"); 
		query.append("              AND POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${pod_cd} != '')" ).append("\n"); 
		query.append("              AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${cre_usr_id} != '')" ).append("\n"); 
		query.append("              AND CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${cre_dt} != '')" ).append("\n"); 
		query.append("              AND CRE_DT = @[cre_dt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${upd_usr_id} != '')" ).append("\n"); 
		query.append("              AND UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${upd_dt} != '')" ).append("\n"); 
		query.append("              AND UPD_DT = @[upd_dt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${rev_tp_src_cd} != '')" ).append("\n"); 
		query.append("              AND REV_TP_SRC_CD = @[rev_tp_src_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${rev_vvd_cd} != '')" ).append("\n"); 
		query.append("              AND REV_VVD_CD = @[rev_vvd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${agn_expn_tp_cd} != '')" ).append("\n"); 
		query.append("              AND AGN_EXPN_TP_CD = @[agn_expn_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 

	}
}
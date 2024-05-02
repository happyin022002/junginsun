/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddNewSplitMtyRepoBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.22
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.22 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOAddNewSplitMtyRepoBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Split Mty Booking 저장
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddNewSplitMtyRepoBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_split_aval_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddNewSplitMtyRepoBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO bkg_booking" ).append("\n"); 
		query.append("(bkg_no" ).append("\n"); 
		query.append(", bl_no" ).append("\n"); 
		query.append(", bl_no_tp" ).append("\n"); 
		query.append(", slan_cd" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no" ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", rcv_term_cd" ).append("\n"); 
		query.append(", de_term_cd" ).append("\n"); 
		query.append(", por_cd" ).append("\n"); 
		query.append(", pol_cd" ).append("\n"); 
		query.append(", pol_nod_cd" ).append("\n"); 
		query.append(", pod_cd" ).append("\n"); 
		query.append(", pod_nod_cd" ).append("\n"); 
		query.append(", del_cd" ).append("\n"); 
		query.append(", MTY_PKUP_YD_CD" ).append("\n"); 
		query.append(", pre_rly_port_cd" ).append("\n"); 
		query.append(", pst_rly_port_cd" ).append("\n"); 
		query.append(", bkg_ofc_cd" ).append("\n"); 
		query.append(", SLS_RHQ_CD" ).append("\n"); 
		query.append(", SLS_RGN_OFC_CD" ).append("\n"); 
		query.append(", ob_sls_ofc_cd" ).append("\n"); 
		query.append(", doc_usr_id" ).append("\n"); 
		query.append(", bkg_cre_dt" ).append("\n"); 
		query.append(", bkg_sts_cd" ).append("\n"); 
		query.append(", bkg_cgo_tp_cd" ).append("\n"); 
		query.append(", split_flg" ).append("\n"); 
		query.append(", rep_cmdt_cd" ).append("\n"); 
		query.append(", xter_rmk" ).append("\n"); 
		query.append(", inter_rmk" ).append("\n"); 
		query.append(", mty_bkg_sts_Cd" ).append("\n"); 
		query.append(", mty_Split_Aval_Cd" ).append("\n"); 
		query.append(", BKG_CRE_TP_CD" ).append("\n"); 
		query.append(", FM_BKG_NO" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[new_bkg_no] --new bkg No" ).append("\n"); 
		query.append(", @[new_bl_no] --new bl no" ).append("\n"); 
		query.append(", 0 --bl_no_tp" ).append("\n"); 
		query.append(", slan_cd" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no" ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", 'Y'" ).append("\n"); 
		query.append(", 'Y'" ).append("\n"); 
		query.append(", por_cd" ).append("\n"); 
		query.append(", pol_cd" ).append("\n"); 
		query.append(", pol_nod_cd" ).append("\n"); 
		query.append(", substr(@[pod_yd_cd], 1, 5) --pod_cd" ).append("\n"); 
		query.append(", @[pod_yd_cd]               --pod_nod_cd" ).append("\n"); 
		query.append(", substr(@[pod_yd_cd], 1, 5) --del_cd" ).append("\n"); 
		query.append(", MTY_PKUP_YD_CD" ).append("\n"); 
		query.append(", substr(@[pre_rly_port_cd], 1, 5)" ).append("\n"); 
		query.append(", substr(@[pst_rly_port_cd], 1, 5)" ).append("\n"); 
		query.append(", bkg_ofc_cd" ).append("\n"); 
		query.append(", SLS_RHQ_CD" ).append("\n"); 
		query.append(", SLS_RGN_OFC_CD" ).append("\n"); 
		query.append(", ob_sls_ofc_cd" ).append("\n"); 
		query.append(", @[usr_id]    --doc_usr_id" ).append("\n"); 
		query.append(", SYSDATE   --bkg_cre_dt" ).append("\n"); 
		query.append(", 'F'       --bkg_sts_cd" ).append("\n"); 
		query.append(", 'P'       --bkg_cgo_tp_cd" ).append("\n"); 
		query.append(", 'Y' 		--split_flg" ).append("\n"); 
		query.append(", '8609'    --rep_cmdt_cd" ).append("\n"); 
		query.append(", 'Empty Container Repositionning Booking' --xter_rmk" ).append("\n"); 
		query.append(", @[bkg_rmk]" ).append("\n"); 
		query.append(", @[mty_bkg_sts_cd]" ).append("\n"); 
		query.append(", @[mty_split_aval_cd]" ).append("\n"); 
		query.append(", 'S'" ).append("\n"); 
		query.append(", @[bkg_no]" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM bkg_booking" ).append("\n"); 
		query.append("WHERE bkg_no        = @[bkg_no] --원본 bkgNo" ).append("\n"); 
		query.append("and bkg_cgo_tp_cd = 'P'" ).append("\n"); 

	}
}
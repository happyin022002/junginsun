/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddMtyBkgBookingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.26
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.05.26 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOAddMtyBkgBookingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Booking 저장
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddMtyBkgBookingCSQL(){
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
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_svr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_sls_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddMtyBkgBookingCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO bkg_booking (" ).append("\n"); 
		query.append("          bkg_no " ).append("\n"); 
		query.append("        , slan_cd" ).append("\n"); 
		query.append("        , vsl_cd" ).append("\n"); 
		query.append("        , skd_voy_no " ).append("\n"); 
		query.append("        , skd_dir_cd        " ).append("\n"); 
		query.append("        , por_cd" ).append("\n"); 
		query.append("        , pol_cd" ).append("\n"); 
		query.append("        , pol_nod_cd" ).append("\n"); 
		query.append("        , pod_cd" ).append("\n"); 
		query.append("        , pod_nod_cd" ).append("\n"); 
		query.append("        , del_cd" ).append("\n"); 
		query.append("        , pre_rly_port_cd" ).append("\n"); 
		query.append("        , pst_rly_port_cd" ).append("\n"); 
		query.append("        , mty_pkup_yd_cd" ).append("\n"); 
		query.append("        , bkg_ofc_cd" ).append("\n"); 
		query.append("        , sls_rhq_cd" ).append("\n"); 
		query.append("        , sls_rgn_ofc_cd" ).append("\n"); 
		query.append("        , ob_sls_ofc_cd" ).append("\n"); 
		query.append("        , doc_usr_id" ).append("\n"); 
		query.append(",	BKG_CRE_DT" ).append("\n"); 
		query.append(", 	BKG_CRE_GDT" ).append("\n"); 
		query.append("        , bkg_sts_cd" ).append("\n"); 
		query.append("        , bkg_cgo_tp_cd" ).append("\n"); 
		query.append("        , rcv_term_cd" ).append("\n"); 
		query.append("        , de_term_cd" ).append("\n"); 
		query.append("        , rep_cmdt_cd" ).append("\n"); 
		query.append("        , xter_rmk" ).append("\n"); 
		query.append("        , inter_rmk" ).append("\n"); 
		query.append("        , bl_no" ).append("\n"); 
		query.append("        , bl_no_tp" ).append("\n"); 
		query.append("        , mty_bkg_sts_cd" ).append("\n"); 
		query.append("        , mty_cre_svr_cd" ).append("\n"); 
		query.append("        , mty_split_aval_cd" ).append("\n"); 
		query.append("        , cre_usr_id" ).append("\n"); 
		query.append("        , cre_dt" ).append("\n"); 
		query.append("        , upd_usr_id" ).append("\n"); 
		query.append("	 , upd_dt" ).append("\n"); 
		query.append("	,RC_FLG" ).append("\n"); 
		query.append("	,AWK_CGO_FLG" ).append("\n"); 
		query.append("	,BB_CGO_FLG" ).append("\n"); 
		query.append("	,RD_CGO_FLG" ).append("\n"); 
		query.append("	,HNGR_FLG" ).append("\n"); 
		query.append("	,PRCT_FLG" ).append("\n"); 
		query.append("	,SPCL_HIDE_FLG" ).append("\n"); 
		query.append("	,SOC_FLG" ).append("\n"); 
		query.append("	,EQ_SUBST_FLG" ).append("\n"); 
		query.append("	,FD_GRD_FLG" ).append("\n"); 
		query.append("	,FLEX_HGT_FLG" ).append("\n"); 
		query.append("	,ALL_MTR_FLG" ).append("\n"); 
		query.append("	,DBL_BKG_FLG" ).append("\n"); 
		query.append("	,AP_BROG_FLG" ).append("\n"); 
		query.append("	,CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("	,ALT_CUST_CFM_FLG" ).append("\n"); 
		query.append("	,WT_RSN_SPCL_CGO_FLG" ).append("\n"); 
		query.append("	,WT_RSN_HLD_FLG" ).append("\n"); 
		query.append("	,MNL_BKG_NO_FLG" ).append("\n"); 
		query.append("	,BL_ISS_BLCK_FLG" ).append("\n"); 
		query.append("	,SI_FLG" ).append("\n"); 
		query.append("	,XTER_RQST_AUTO_NTC_FLG" ).append("\n"); 
		query.append("	,OVR_VOID_SLT_QTY	" ).append("\n"); 
		query.append("    ,kr_cstms_cust_tp_cd " ).append("\n"); 
		query.append(")VALUES (" ).append("\n"); 
		query.append("          @[bkg_no]" ).append("\n"); 
		query.append("        , (select vsl_slan_Cd from vsk_vsl_skd where vsl_cd = @[vsl_cd] and skd_voy_no = @[skd_voy_no] and skd_Dir_Cd = @[skd_dir_cd])--slan_cd" ).append("\n"); 
		query.append("        , @[vsl_cd]" ).append("\n"); 
		query.append("        , @[skd_voy_no]" ).append("\n"); 
		query.append("        , @[skd_dir_cd]" ).append("\n"); 
		query.append("        , substr(@[pol_yd_cd], 1, 5)--por_Cd" ).append("\n"); 
		query.append("        , substr(@[pol_yd_cd], 1, 5)--pol_cd" ).append("\n"); 
		query.append("        , @[pol_yd_cd]" ).append("\n"); 
		query.append("        , substr(@[pod_yd_cd], 1, 5)--pod_cd" ).append("\n"); 
		query.append("        , @[pod_yd_cd]" ).append("\n"); 
		query.append("        , substr(@[pod_yd_cd], 1, 5)--del_cd" ).append("\n"); 
		query.append("        , @[pre_rly_port_cd]" ).append("\n"); 
		query.append("        , @[pst_rly_port_cd]" ).append("\n"); 
		query.append("        , @[pol_yd_cd]" ).append("\n"); 
		query.append("        , (select ofc_cd from com_user usr where usr.usr_id = @[cre_usr_id])--bkg_ofc_cd" ).append("\n"); 
		query.append("        , @[sls_rhq_cd]--sls_rhq_cd" ).append("\n"); 
		query.append("        , @[sls_rgn_ofc_cd]--sls_rgn_ofc_cd" ).append("\n"); 
		query.append("        , @[ob_sls_cd]--ob_sls_cd" ).append("\n"); 
		query.append("        , @[doc_usr_id]" ).append("\n"); 
		query.append("        , GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),sysdate,BKG_COM_USER_LOC_FNC(@[doc_usr_id]))" ).append("\n"); 
		query.append("		, GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),sysdate,'GMT')" ).append("\n"); 
		query.append("        , 'F'--bkg_sts_cd" ).append("\n"); 
		query.append("        , 'P'--bkg_cgo_tp_cd" ).append("\n"); 
		query.append("        , 'Y'--rcv_term_cd" ).append("\n"); 
		query.append("        , 'Y'--de_term_cd" ).append("\n"); 
		query.append("        , '8609'--rep_cmdt_cd" ).append("\n"); 
		query.append("        , 'Empty Container Repositionning Booking'--xter_rmk" ).append("\n"); 
		query.append("        , @[bkg_rmk]--inter_rmk" ).append("\n"); 
		query.append("        , @[bl_no]" ).append("\n"); 
		query.append("        , '0'" ).append("\n"); 
		query.append("        , @[mty_bkg_sts_cd]" ).append("\n"); 
		query.append("        , @[bkg_cre_svr_cd]" ).append("\n"); 
		query.append("        , @[mty_split_aval_cd]" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("	 , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("	 , SYSDATE" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,0" ).append("\n"); 
		query.append("    ,'E' --kr_cstms_cust_tp_cd	 " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
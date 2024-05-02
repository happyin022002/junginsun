/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BDRCorrectionDBDAOAddBkgCorrectionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOAddBkgCorrectionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOAddBkgCorrectionCSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOAddBkgCorrectionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_sub_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_term_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cxl_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_gen_Corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_acpt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cntr_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_rly_port_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bis_sys_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcre_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_corr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_bkg_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_tro_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnsl_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_tro_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prpst_vsl_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rt_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_mk_desc_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_split_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_otr_rsn_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cmb_modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvde_term_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOAddBkgCorrectionCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CORRECTION (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", CORR_NO" ).append("\n"); 
		query.append(", CA_RSN_CD" ).append("\n"); 
		query.append(", CORR_USR_ID" ).append("\n"); 
		query.append(", BKG_CORR_RMK" ).append("\n"); 
		query.append(", CORR_DT" ).append("\n"); 
		query.append(", CORR_GDT" ).append("\n"); 
		query.append(", RAT_FLG" ).append("\n"); 
		query.append(", EXPN_FLG" ).append("\n"); 
		query.append(", NEW_BKG_CRE_FLG" ).append("\n"); 
		query.append(", RCRE_MODI_FLG" ).append("\n"); 
		query.append(", BKG_CRE_MODI_FLG" ).append("\n"); 
		query.append(", CORR_CXL_FLG" ).append("\n"); 
		query.append(", OB_TRO_MODI_FLG" ).append("\n"); 
		query.append(", IB_TRO_MODI_FLG" ).append("\n"); 
		query.append(", BKG_SPLIT_MODI_FLG" ).append("\n"); 
		query.append(", COD_MODI_FLG" ).append("\n"); 
		query.append(", CXL_MODI_FLG" ).append("\n"); 
		query.append(", CA_RLY_PORT_MODI_FLG" ).append("\n"); 
		query.append(", DG_MODI_FLG" ).append("\n"); 
		query.append(", AWK_MODI_FLG" ).append("\n"); 
		query.append(", RF_MODI_FLG" ).append("\n"); 
		query.append(", BB_MODI_FLG" ).append("\n"); 
		query.append(", RD_MODI_FLG" ).append("\n"); 
		query.append(", HNGR_MODI_FLG" ).append("\n"); 
		query.append(", SOC_MODI_FLG" ).append("\n"); 
		query.append(", EQ_SUB_MODI_FLG" ).append("\n"); 
		query.append(", CUST_MODI_FLG" ).append("\n"); 
		query.append(", BL_MK_DESC_MODI_FLG" ).append("\n"); 
		query.append(", CNSL_MODI_FLG" ).append("\n"); 
		query.append(", BKG_CNTR_MODI_FLG" ).append("\n"); 
		query.append(", CNTR_MF_MODI_FLG" ).append("\n"); 
		query.append(", RT_MODI_FLG" ).append("\n"); 
		query.append(", BL_OBRD_CORR_FLG" ).append("\n"); 
		query.append(", RT_CORR_FLG" ).append("\n"); 
		query.append(", CHG_TERM_CORR_FLG" ).append("\n"); 
		query.append(", RCVDE_TERM_CORR_FLG" ).append("\n"); 
		query.append(", ROUT_CORR_FLG" ).append("\n"); 
		query.append(", CUST_CORR_FLG" ).append("\n"); 
		query.append(", QTY_CORR_FLG" ).append("\n"); 
		query.append(", MEAS_QTY_CORR_FLG" ).append("\n"); 
		query.append(", CMDT_CORR_FLG" ).append("\n"); 
		query.append(", TRNK_VSL_CORR_FLG" ).append("\n"); 
		query.append(", PRPST_VSL_CORR_FLG" ).append("\n"); 
		query.append(", CA_OTR_RSN_CORR_FLG" ).append("\n"); 
		query.append(", BND_CORR_FLG" ).append("\n"); 
		query.append(", BROG_GEN_CORR_FLG" ).append("\n"); 
		query.append(", BIS_SYS_IF_FLG" ).append("\n"); 
		query.append(", BKG_CMB_MODI_FLG" ).append("\n"); 
		query.append(", CORR_OFC_CD" ).append("\n"); 
		query.append(", RDN_NO" ).append("\n"); 
		query.append(", RVIS_SEQ" ).append("\n"); 
		query.append(", RDN_ACPT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[bkg_no]" ).append("\n"); 
		query.append(", @[corr_no]" ).append("\n"); 
		query.append(", @[ca_rsn_cd]" ).append("\n"); 
		query.append(", @[corr_usr_id]" ).append("\n"); 
		query.append(", @[bkg_corr_rmk]" ).append("\n"); 
		query.append("#if (${corr_no} == '0000000001')" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),TO_DATE('1977/05/16','YYYY/MM/DD'),BKG_COM_USER_LOC_FNC(@[cre_usr_id]))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),sysdate,BKG_COM_USER_LOC_FNC(@[cre_usr_id]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${corr_no} == '0000000001')" ).append("\n"); 
		query.append(", TO_DATE('1977/05/16','YYYY/MM/DD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),sysdate,'GMT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", nvl(@[rat_flg],				'N')--RAT_FLG" ).append("\n"); 
		query.append(", nvl(@[expn_flg],               'N')--EXPN_FLG" ).append("\n"); 
		query.append(", nvl(@[new_bkg_cre_flg],        'N')--NEW_BKG_CRE_FLG" ).append("\n"); 
		query.append(", nvl(@[rcre_modi_flg],          'N')--RCRE_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[bkg_cre_modi_flg],       'N')--BKG_CRE_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[corr_cxl_flg],           'N')--CORR_CXL_FLG" ).append("\n"); 
		query.append(", nvl(@[ob_tro_modi_flg],        'N')--OB_TRO_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[ib_tro_modi_flg],        'N')--IB_TRO_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[bkg_split_modi_flg],     'N')--BKG_SPLIT_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[cod_modi_flg],           'N')--cod_modi_flg" ).append("\n"); 
		query.append(", nvl(@[cxl_modi_flg],           'N')--CXL_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[ca_rly_port_modi_flg],   'N')--CA_RLY_PORT_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[dg_modi_flg],            'N')--DG_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[awk_modi_flg],           'N')--AWK_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[rf_modi_flg],            'N')--RF_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[bb_modi_flg],            'N')--BB_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[rd_modi_flg],            'N')--RD_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[hngr_modi_flg],          'N')--HNGR_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[soc_modi_flg],           'N')--SOC_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[eq_sub_modi_flg],        'N')--EQ_SUB_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[cust_modi_flg],          'N')--CUST_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[bl_mk_desc_modi_flg],    'N')--BL_MK_DESC_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[cnsl_modi_flg],          'N')--CNSL_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[bkg_cntr_modi_flg],      'N')--BKG_CNTR_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[cntr_mf_modi_flg],       'N')--CNTR_MF_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[rt_modi_flg],            'N')--RT_MODI_FLG" ).append("\n"); 
		query.append(", nvl(@[bl_obrd_corr_flg],       'N')--BL_OBRD_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[rt_corr_flg],            'N')--RT_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[chg_term_corr_flg],      'N')--CHG_TERM_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[rcvde_term_corr_flg],    'N')--RCVDE_TERM_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[rout_corr_flg],          'N')--ROUT_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[cust_corr_flg],          'N')--CUST_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[qty_corr_flg],           'N')--QTY_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[meas_qty_corr_flg],      'N')--MEAS_QTY_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[cmdt_corr_flg],          'N')--CMDT_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[trnk_vsl_corr_flg],      'N')--TRNK_VSL_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[prpst_vsl_corr_flg],     'N')--PRPST_VSL_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[ca_otr_rsn_corr_flg],    'N')--CA_OTR_RSN_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[bnd_corr_flg],           'N')--BND_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[brog_gen_Corr_flg],      'N')--BROG_GEN_CORR_FLG" ).append("\n"); 
		query.append(", nvl(@[bis_sys_if_flg],         'N')--BIS_SYS_IF_FLG" ).append("\n"); 
		query.append(", nvl(@[bkg_cmb_modi_flg],		'N')--BKG_CMB_MODI_FLG" ).append("\n"); 
		query.append(", @[corr_ofc_cd]" ).append("\n"); 
		query.append(", @[rdn_no]" ).append("\n"); 
		query.append(", @[rvis_seq]" ).append("\n"); 
		query.append(", NVL(@[rdn_acpt_flg], 'N')" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
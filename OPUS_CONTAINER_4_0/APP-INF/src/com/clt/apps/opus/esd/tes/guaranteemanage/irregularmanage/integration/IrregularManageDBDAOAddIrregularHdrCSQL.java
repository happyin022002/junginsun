/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IrregularManageDBDAOAddIrregularHdrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.01 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IrregularManageDBDAOAddIrregularHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Irregular Header Insert
	  * </pre>
	  */
	public IrregularManageDBDAOAddIrregularHdrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cost_sptg_icrz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_prvt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_otr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_sys_err_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cost_xtra_ft_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cost_ocp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_stf_err_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_cxl_wo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cost_team_trkg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cost_mnr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_lack_of_flw_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_late_dis_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_eq_shtg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cost_tnk_ord_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_chss_shtg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cost_otr_tml_chss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cost_tri_axl_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.integration").append("\n"); 
		query.append("FileName : IrregularManageDBDAOAddIrregularHdrCSQL").append("\n"); 
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
		query.append("INSERT	INTO TES_IRR_HDR IH (" ).append("\n"); 
		query.append("IRR_NO" ).append("\n"); 
		query.append(", GNTE_NO" ).append("\n"); 
		query.append(", OFC_CD" ).append("\n"); 
		query.append(", GNTE_TP_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", IRR_TP_CD" ).append("\n"); 
		query.append(", BKG_STS_CD" ).append("\n"); 
		query.append(", RESPB_PTY_NM" ).append("\n"); 
		query.append(", IRR_RSN_RMK" ).append("\n"); 
		query.append(", IRR_PRVT_RMK" ).append("\n"); 
		query.append(", IRR_TTL_AMT" ).append("\n"); 
		query.append(", IRR_STF_ERR_FLG" ).append("\n"); 
		query.append(", IRR_SYS_ERR_FLG" ).append("\n"); 
		query.append(", IRR_CHSS_SHTG_FLG" ).append("\n"); 
		query.append(", IRR_OTR_FLG" ).append("\n"); 
		query.append(", IRR_LATE_DIS_FLG" ).append("\n"); 
		query.append(", IRR_LACK_OF_FLW_FLG" ).append("\n"); 
		query.append(", IRR_CXL_WO_FLG" ).append("\n"); 
		query.append(", IRR_EQ_SHTG_FLG" ).append("\n"); 
		query.append(", OP_COST_OCP_FLG" ).append("\n"); 
		query.append(", OP_COST_TNK_ORD_FLG" ).append("\n"); 
		query.append(", OP_COST_TEAM_TRKG_FLG" ).append("\n"); 
		query.append(", OP_COST_XTRA_FT_FLG" ).append("\n"); 
		query.append(", OP_COST_SPTG_ICRZ_FLG" ).append("\n"); 
		query.append(", OP_COST_OTR_TML_CHSS_FLG" ).append("\n"); 
		query.append(", OP_COST_MNR_FLG" ).append("\n"); 
		query.append(", OP_COST_TRI_AXL_FLG" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES	(" ).append("\n"); 
		query.append("@[irr_no]" ).append("\n"); 
		query.append(", @[gnte_no]" ).append("\n"); 
		query.append(", @[ofc_cd]" ).append("\n"); 
		query.append(", @[gnte_tp_cd]" ).append("\n"); 
		query.append(", @[curr_cd]" ).append("\n"); 
		query.append(", @[irr_tp_cd]" ).append("\n"); 
		query.append(", @[bkg_sts_cd]" ).append("\n"); 
		query.append(", @[respb_pty_nm]" ).append("\n"); 
		query.append(", @[irr_rsn_rmk]" ).append("\n"); 
		query.append(", @[irr_prvt_rmk]" ).append("\n"); 
		query.append(", @[irr_ttl_amt]" ).append("\n"); 
		query.append(", @[irr_stf_err_flg]" ).append("\n"); 
		query.append(", @[irr_sys_err_flg]" ).append("\n"); 
		query.append(", @[irr_chss_shtg_flg]" ).append("\n"); 
		query.append(", @[irr_otr_flg]" ).append("\n"); 
		query.append(", @[irr_late_dis_flg]" ).append("\n"); 
		query.append(", @[irr_lack_of_flw_flg]" ).append("\n"); 
		query.append(", @[irr_cxl_wo_flg]" ).append("\n"); 
		query.append(", @[irr_eq_shtg_flg]" ).append("\n"); 
		query.append(", @[op_cost_ocp_flg]" ).append("\n"); 
		query.append(", @[op_cost_tnk_ord_flg]" ).append("\n"); 
		query.append(", @[op_cost_team_trkg_flg]" ).append("\n"); 
		query.append(", @[op_cost_xtra_ft_flg]" ).append("\n"); 
		query.append(", @[op_cost_sptg_icrz_flg]" ).append("\n"); 
		query.append(", @[op_cost_otr_tml_chss_flg]" ).append("\n"); 
		query.append(", @[op_cost_mnr_flg]" ).append("\n"); 
		query.append(", @[op_cost_tri_axl_flg]" ).append("\n"); 
		query.append(", @[delt_flg]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
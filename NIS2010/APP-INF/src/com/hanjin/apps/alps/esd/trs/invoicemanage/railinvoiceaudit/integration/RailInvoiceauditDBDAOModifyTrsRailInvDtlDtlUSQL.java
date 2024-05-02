/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Invoice 상세 내역을 수정
	  * </pre>
	  */
	public RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_org_nod_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bil_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hzd_mtrl_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmst_repo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_bil_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_trsp_rail_inv_aud_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dest_nod_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_wgt_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_co_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlUSQL").append("\n"); 
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
		query.append("UPDATE  TRS_TRSP_RAIL_INV_DTL" ).append("\n"); 
		query.append("SET     TRSP_SO_OFC_CTY_CD				= @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("      , TRSP_SO_SEQ						= @[trsp_so_seq]" ).append("\n"); 
		query.append("      , EQ_NO							= @[eq_no]" ).append("\n"); 
		query.append("      , EQ_TPSZ_CD						= @[eq_tpsz_cd]" ).append("\n"); 
		query.append("      , CURR_CD							= @[curr_cd]" ).append("\n"); 
		query.append("      , BZC_AMT							= @[bzc_amt]" ).append("\n"); 
		query.append("      , FUEL_SCG_AMT					= @[fuel_scg_amt]" ).append("\n"); 
		query.append("      , OVR_WGT_SCG_AMT					= @[ovr_wgt_scg_amt]" ).append("\n"); 
		query.append("      , HZD_MTRL_SCG_AMT				= @[hzd_mtrl_scg_amt]" ).append("\n"); 
		query.append("      , ETC_ADD_AMT						= @[etc_add_amt]" ).append("\n"); 
		query.append("      , TRSP_INV_CO_IND_CD				= @[trsp_inv_co_ind_cd]" ).append("\n"); 
		query.append("      , NON_BIL_INV_FLG					= CASE @[crnt_trsp_rail_inv_aud_cd] WHEN 'I' THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("      , LGS_COST_CD	                    = TRS_COMMON_PKG.GET_RAIL_LGS_COST_CD_FNC( @[trsp_inv_co_ind_cd], @[trsp_so_ofc_cty_cd], @[cgo_tp_cd], @[fm_nod_cd], @[to_nod_cd])" ).append("\n"); 
		query.append("      , ACCT_CD	                        = TRS_COMMON_PKG.GET_RAIL_ACCT_CD_FNC( @[trsp_inv_co_ind_cd], @[trsp_so_ofc_cty_cd], @[cgo_tp_cd], @[fm_nod_cd], @[to_nod_cd])" ).append("\n"); 
		query.append("      , CRNT_TRSP_RAIL_INV_AUD_CD		= @[crnt_trsp_rail_inv_aud_cd]" ).append("\n"); 
		query.append("      , CGO_TP_CD						= @[cgo_tp_cd]" ).append("\n"); 
		query.append("      , FM_NOD_CD						= @[fm_nod_cd]" ).append("\n"); 
		query.append("      , TO_NOD_CD						= @[to_nod_cd]" ).append("\n"); 
		query.append("      , INV_ORG_NOD_NM					= @[inv_org_nod_nm]" ).append("\n"); 
		query.append("      , INV_DEST_NOD_NM					= @[inv_dest_nod_nm]" ).append("\n"); 
		query.append("      , INV_CURR_CD						= @[inv_curr_cd]" ).append("\n"); 
		query.append("      , INV_BZC_AMT						= @[inv_bzc_amt]" ).append("\n"); 
		query.append("      , INV_BIL_AMT						= @[inv_bil_amt]" ).append("\n"); 
		query.append("      , INV_ETC_ADD_AMT					= @[inv_etc_add_amt]" ).append("\n"); 
		query.append("      , TRSP_INV_TP_CD					= @[trsp_inv_tp_cd]" ).append("\n"); 
		query.append("      , RAIL_BIL_DT						= TO_DATE(@[rail_bil_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("      , WBL_DT							= TO_DATE(@[wbl_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("      , WBL_NO							= @[wbl_no]" ).append("\n"); 
		query.append("      , INV_RMK							= @[inv_rmk]" ).append("\n"); 
		query.append("      , PAY_FLG							= CASE @[pay_flg] WHEN '1' THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("      , UPD_USR_ID						= @[sUsrId]" ).append("\n"); 
		query.append("      , LOCL_UPD_DT						= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sOfcCd])" ).append("\n"); 
		query.append("      , DMST_REPO_FLG                   = DECODE(@[dmst_repo_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append("WHERE   INV_NO						    = @[invNo]" ).append("\n"); 
		query.append("AND	    INV_VNDR_SEQ				    = @[invVndrSeq]" ).append("\n"); 
		query.append("AND	    SUB_INV_SEQ					    = @[sub_inv_seq]" ).append("\n"); 

	}
}
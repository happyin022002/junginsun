/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Invoice 상세 내역을 입력
	  * </pre>
	  */
	public RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlCSQL(){
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
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_trsp_rail_inv_aud_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_RAIL_INV_DTL (" ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("INV_VNDR_SEQ," ).append("\n"); 
		query.append("SUB_INV_SEQ," ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ," ).append("\n"); 
		query.append("ORG_TRSP_RAIL_INV_AUD_CD," ).append("\n"); 
		query.append("CRNT_TRSP_RAIL_INV_AUD_CD," ).append("\n"); 
		query.append("PAY_FLG," ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("EQ_TPSZ_CD," ).append("\n"); 
		query.append("CGO_TP_CD," ).append("\n"); 
		query.append("FM_NOD_CD," ).append("\n"); 
		query.append("TO_NOD_CD," ).append("\n"); 
		query.append("INV_ORG_NOD_NM," ).append("\n"); 
		query.append("INV_DEST_NOD_NM," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("BZC_AMT," ).append("\n"); 
		query.append("FUEL_SCG_AMT," ).append("\n"); 
		query.append("OVR_WGT_SCG_AMT," ).append("\n"); 
		query.append("HZD_MTRL_SCG_AMT," ).append("\n"); 
		query.append("ETC_ADD_AMT," ).append("\n"); 
		query.append("INV_CURR_CD," ).append("\n"); 
		query.append("INV_BZC_AMT," ).append("\n"); 
		query.append("INV_BIL_AMT," ).append("\n"); 
		query.append("INV_ETC_ADD_AMT," ).append("\n"); 
		query.append("TRSP_INV_CO_IND_CD," ).append("\n"); 
		query.append("RAIL_BIL_DT," ).append("\n"); 
		query.append("WBL_DT," ).append("\n"); 
		query.append("WBL_NO," ).append("\n"); 
		query.append("INV_RMK," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("NON_BIL_INV_FLG," ).append("\n"); 
		query.append("TRSP_INV_TP_CD," ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("ACCT_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[invNo]," ).append("\n"); 
		query.append("@[invVndrSeq]," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_INV_DTL_SEQ1.NEXTVAL," ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd]," ).append("\n"); 
		query.append("@[trsp_so_seq]," ).append("\n"); 
		query.append("@[org_trsp_rail_inv_aud_cd]," ).append("\n"); 
		query.append("@[crnt_trsp_rail_inv_aud_cd]," ).append("\n"); 
		query.append("DECODE(@[pay_flg] , '0' , 'N' , 'Y')," ).append("\n"); 
		query.append("@[eq_no]," ).append("\n"); 
		query.append("@[eq_tpsz_cd]," ).append("\n"); 
		query.append("@[cgo_tp_cd]," ).append("\n"); 
		query.append("@[fm_nod_cd]," ).append("\n"); 
		query.append("@[to_nod_cd]," ).append("\n"); 
		query.append("@[inv_org_nod_nm]," ).append("\n"); 
		query.append("@[inv_dest_nod_nm]," ).append("\n"); 
		query.append("@[curr_cd]," ).append("\n"); 
		query.append("@[bzc_amt]," ).append("\n"); 
		query.append("@[fuel_scg_amt]," ).append("\n"); 
		query.append("@[ovr_wgt_scg_amt]," ).append("\n"); 
		query.append("@[hzd_mtrl_scg_amt]," ).append("\n"); 
		query.append("@[etc_add_amt]," ).append("\n"); 
		query.append("@[inv_curr_cd]," ).append("\n"); 
		query.append("@[inv_bzc_amt]," ).append("\n"); 
		query.append("@[inv_bil_amt]," ).append("\n"); 
		query.append("@[inv_etc_add_amt]," ).append("\n"); 
		query.append("@[trsp_inv_co_ind_cd]," ).append("\n"); 
		query.append("TO_DATE(@[rail_bil_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("TO_DATE(@[wbl_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("@[wbl_no]," ).append("\n"); 
		query.append("@[inv_rmk]," ).append("\n"); 
		query.append("@[sOfcCd]," ).append("\n"); 
		query.append("@[sUsrId]," ).append("\n"); 
		query.append("@[sUsrId]," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sOfcCd])," ).append("\n"); 
		query.append("CASE @[crnt_trsp_rail_inv_aud_cd] WHEN 'I' THEN 'Y' ELSE 'N' END," ).append("\n"); 
		query.append("@[trsp_inv_tp_cd]," ).append("\n"); 
		query.append("TRS_COMMON_PKG.GET_RAIL_LGS_COST_CD_FNC( @[trsp_inv_co_ind_cd], @[trsp_so_ofc_cty_cd], @[cgo_tp_cd], @[fm_nod_cd], @[to_nod_cd])," ).append("\n"); 
		query.append("TRS_COMMON_PKG.GET_RAIL_ACCT_CD_FNC    ( @[trsp_inv_co_ind_cd], @[trsp_so_ofc_cty_cd], @[cgo_tp_cd], @[fm_nod_cd], @[to_nod_cd])" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
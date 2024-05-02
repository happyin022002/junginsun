/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.09.28 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiTerminalInvoiceN3rdParyIFInsert
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_N3RD_PTY_IF" ).append("\n"); 
		query.append("(	  TML_IF_OFC_CD" ).append("\n"); 
		query.append(", TML_IF_SEQ" ).append("\n"); 
		query.append(", CALC_COST_GRP_CD" ).append("\n"); 
		query.append(", TML_INV_TP_CD" ).append("\n"); 
		query.append(", TML_N3PTY_IF_STS_CD" ).append("\n"); 
		query.append(", INV_NO" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append(", LGS_COST_CD" ).append("\n"); 
		query.append(", ACCT_CD" ).append("\n"); 
		query.append(", TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", TML_SO_SEQ" ).append("\n"); 
		query.append(", TML_SO_DTL_SEQ" ).append("\n"); 
		query.append(", TML_CRR_CD" ).append("\n"); 
		query.append(", N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append("--, BKG_NO_SPLIT" ).append("\n"); 
		query.append(", BL_NO" ).append("\n"); 
		query.append("--, BL_NO_TP" ).append("\n"); 
		query.append("--, BL_NO_CHK" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(", VNDR_CNT_CD" ).append("\n"); 
		query.append(", N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", N3PTY_OFC_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", IF_AMT" ).append("\n"); 
		query.append(", IF_RMK" ).append("\n"); 
		query.append(", CXL_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", LOCL_UPD_DT" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(  @[tml_if_ofc_cd] 				--TML_IF_OFC_CD" ).append("\n"); 
		query.append(", @[tml_if_seq] 					--TML_IF_SEQ" ).append("\n"); 
		query.append(", @[calc_cost_grp_cd] 				--CALC_COST_GRP_CD" ).append("\n"); 
		query.append(", @[tml_inv_tp_cd] 				--TML_INV_TP_CD" ).append("\n"); 
		query.append(", 'N' 								--TML_N3PTY_IF_STS_CD" ).append("\n"); 
		query.append(", @[inv_no] 						--INV_NO" ).append("\n"); 
		query.append(", @[vndr_seq] 						--VNDR_SEQ" ).append("\n"); 
		query.append(", @[yd_cd] 						--YD_CD" ).append("\n"); 
		query.append(", @[lgs_cost_cd] 					--LGS_COST_CD" ).append("\n"); 
		query.append(", @[acct_cd] 						--ACCT_CD" ).append("\n"); 
		query.append(", @[tml_so_ofc_cty_cd] 			--TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", @[tml_so_seq] 					--TML_SO_SEQ" ).append("\n"); 
		query.append(", @[tml_so_dtl_seq] 				--TML_SO_DTL_SEQ" ).append("\n"); 
		query.append(", @[tml_crr_cd] 					--TML_CRR_CD" ).append("\n"); 
		query.append(", @[n3pty_bil_tp_cd] 				--N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(", @[cntr_no] 					--CNTR_NO" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd] 				--CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[bkg_no] 						--BKG_NO" ).append("\n"); 
		query.append("--, NVL(RTRIM([bkg_no_split],'  '),'  ')--BKG_NO_SPLIT" ).append("\n"); 
		query.append(", @[bl_no] 						--BL_NO" ).append("\n"); 
		query.append("--, [bl_no_tp] 					--BL_NO_TP" ).append("\n"); 
		query.append("--, [bl_no_chk] 					--BL_NO_CHK" ).append("\n"); 
		query.append(", @[io_bnd_cd] 					--IO_BND_CD" ).append("\n"); 
		query.append(", @[vndr_cust_div_cd] 			--VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(", @[vndr_cnt_cd] 				--VNDR_CNT_CD" ).append("\n"); 
		query.append(", @[n3pty_vndr_seq] 				--N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append(", @[cust_cnt_cd] 				--CUST_CNT_CD" ).append("\n"); 
		query.append(", @[cust_seq] 					--CUST_SEQ" ).append("\n"); 
		query.append(", @[n3pty_ofc_cd] 				--N3PTY_OFC_CD" ).append("\n"); 
		query.append(", @[curr_cd] 					--CURR_CD" ).append("\n"); 
		query.append(", @[if_amt] 				--IF_AMT" ).append("\n"); 
		query.append(", @[if_rmk] 				--IF_RMK" ).append("\n"); 
		query.append(", 'N' 						--CXL_FLG" ).append("\n"); 
		query.append(", @[cre_usr_id] 			--CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE 					--CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id]			--UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE					--UPD_DT" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt]) --LOC_CRE_DT 실제적으로 파라미터에 ofc_cd가 들어감" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_upd_dt]) --LOC_UPD_DT 실제적으로 파라미터에 ofc_cd가 들어감" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
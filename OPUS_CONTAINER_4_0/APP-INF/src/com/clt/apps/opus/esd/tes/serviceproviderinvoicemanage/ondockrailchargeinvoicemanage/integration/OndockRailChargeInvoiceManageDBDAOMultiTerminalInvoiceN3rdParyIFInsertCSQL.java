/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.15 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiTerminalInvoiceN3rdParyIFInsert
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL(){
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
		params.put("finc_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("finc_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL").append("\n"); 
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
		query.append(", N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append("--, BKG_NO_SPLIT" ).append("\n"); 
		query.append(", BL_NO" ).append("\n"); 
		query.append("--, BL_NO_TP" ).append("\n"); 
		query.append("--, BL_NO_CHK" ).append("\n"); 
		query.append(", FINC_VSL_CD" ).append("\n"); 
		query.append(", FINC_SKD_VOY_NO" ).append("\n"); 
		query.append(", FINC_SKD_DIR_CD" ).append("\n"); 
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
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", LOCL_UPD_DT" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(  @[tml_if_ofc_cd] 				--	tml_if_ofc_cd" ).append("\n"); 
		query.append(", @[tml_if_seq] 					--	tml_if_seq" ).append("\n"); 
		query.append(", @[tml_inv_tp_cd] 				--	tml_inv_tp_cd" ).append("\n"); 
		query.append(", 'N' 								--	tml_n3pty_if_sts_cd" ).append("\n"); 
		query.append(", @[inv_no] 						--	inv_no" ).append("\n"); 
		query.append(", @[vndr_seq] 						--	vndr_seq" ).append("\n"); 
		query.append(", @[yd_cd] 						--	yd_cd" ).append("\n"); 
		query.append(", @[lgs_cost_cd] 					--	lgs_cost_cd" ).append("\n"); 
		query.append(", @[acct_cd] 						--	acct_cd" ).append("\n"); 
		query.append(", @[tml_so_ofc_cty_cd] 			--	tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", @[tml_so_seq] 					--	tml_so_seq" ).append("\n"); 
		query.append(", @[tml_so_dtl_seq] 				--	tml_so_dtl_seq" ).append("\n"); 
		query.append(", @[n3pty_bil_tp_cd] 				--	n3pty_bil_tp_cd" ).append("\n"); 
		query.append(", @[cntr_no] 						--	cntr_no" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd] 					--	cntr_tpsz_cd" ).append("\n"); 
		query.append(", @[bkg_no] 						--	bkg_no" ).append("\n"); 
		query.append("--, NVL(RTRIM([bkg_no_split],'  '),'  ')	--	bkg_no_split" ).append("\n"); 
		query.append(", @[bl_no] 						--	bl_no" ).append("\n"); 
		query.append("--, [bl_no_tp] 						--	bl_no_tp" ).append("\n"); 
		query.append("--, [bl_no_chk] 					--	bl_no_chk" ).append("\n"); 
		query.append(", @[finc_vsl_cd] 					--	finc_vsl_cd" ).append("\n"); 
		query.append(", @[finc_skd_voy_no] 				--	finc_skd_voy_no" ).append("\n"); 
		query.append(", @[finc_skd_dir_cd] 				--	finc_skd_dir_cd" ).append("\n"); 
		query.append(", @[vndr_cust_div_cd] 				--	vndr_cust_div_cd" ).append("\n"); 
		query.append(", @[vndr_cnt_cd] 					--	vndr_cnt_cd" ).append("\n"); 
		query.append(", @[n3pty_vndr_seq] 				--	n3pty_vndr_seq" ).append("\n"); 
		query.append(", @[cust_cnt_cd] 					--	cust_cnt_cd" ).append("\n"); 
		query.append(", @[cust_seq] 						--	cust_seq" ).append("\n"); 
		query.append(", @[n3pty_ofc_cd] 					--	n3pty_ofc_cd" ).append("\n"); 
		query.append(", @[curr_cd] 						--	curr_cd" ).append("\n"); 
		query.append(", @[if_amt] 						--	if_amt" ).append("\n"); 
		query.append(", @[if_rmk] 						--	if_rmk" ).append("\n"); 
		query.append(", 'N' 								--	cxl_flg" ).append("\n"); 
		query.append(", @[cre_usr_id] 					--	cre_usr_id" ).append("\n"); 
		query.append(", SYSDATE --	cre_dt" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt]) --	locl_cre_dt" ).append("\n"); 
		query.append(", @[upd_usr_id] 				--	cre_usr_id" ).append("\n"); 
		query.append(", SYSDATE --	upd_dt" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_upd_dt]) --	locl_upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
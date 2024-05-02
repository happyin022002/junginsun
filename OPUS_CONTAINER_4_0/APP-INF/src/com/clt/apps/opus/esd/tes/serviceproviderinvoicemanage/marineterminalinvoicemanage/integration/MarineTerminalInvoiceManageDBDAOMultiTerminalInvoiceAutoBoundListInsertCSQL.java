/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceAutoBoundListInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.03.15 박재흥
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

public class MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceAutoBoundListInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiTerminalInvoiceAutoBoundListInsert
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceAutoBoundListInsertCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_tr_vol_val",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_tr_vol_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rvis_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vol_tr_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceAutoBoundListInsertCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_DTL" ).append("\n"); 
		query.append("(TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",TML_SO_SEQ" ).append("\n"); 
		query.append(",TML_SO_DTL_SEQ" ).append("\n"); 
		query.append(",CALC_COST_GRP_CD" ).append("\n"); 
		query.append(",CALC_TP_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",LGS_COST_CD" ).append("\n"); 
		query.append(",ATB_DT" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CALC_VOL_QTY" ).append("\n"); 
		query.append(",FM_TR_VOL_VAL" ).append("\n"); 
		query.append(",TO_TR_VOL_VAL" ).append("\n"); 
		query.append(",RVIS_VOL_QTY" ).append("\n"); 
		query.append(",DCGO_IND_CD" ).append("\n"); 
		query.append(",VOL_TR_UT_CD" ).append("\n"); 
		query.append(",INV_XCH_RT" ).append("\n"); 
		query.append(",CTRT_RT" ).append("\n"); 
		query.append(",INV_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",LOCL_CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",LOCL_UPD_DT" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("( @[tml_so_ofc_cty_cd] 			-- tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", @[tml_so_seq] 				-- tml_so_seq" ).append("\n"); 
		query.append(", @[tml_so_dtl_seq]				-- tml_so_dtl_seq" ).append("\n"); 
		query.append(", @[calc_cost_grp_cd] 			-- calc_cost_grp_cd" ).append("\n"); 
		query.append(", @[calc_tp_cd] 			-- calc_tp_cd" ).append("\n"); 
		query.append(", @[vsl_cd] 			-- vsl_cd" ).append("\n"); 
		query.append(", @[skd_voy_no] 			-- skd_voy_no" ).append("\n"); 
		query.append(", @[skd_dir_cd] 			-- skd_dir_cd" ).append("\n"); 
		query.append(", @[io_bnd_cd] 			-- io_bnd_cd" ).append("\n"); 
		query.append(", @[lgs_cost_cd] 			-- lgs_cost_cd" ).append("\n"); 
		query.append(",TO_DATE(SUBSTR(REPLACE(@[atb_dt],'-'),0,8),'YYYYMMDD') -- atb_dt" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd] 			-- cntr_tpsz_cd" ).append("\n"); 
		query.append(", @[calc_vol_qty] 			-- calc_vol_qty" ).append("\n"); 
		query.append(", @[fm_tr_vol_val] 			-- fm_tr_vol_val" ).append("\n"); 
		query.append(", @[to_tr_vol_val] 			-- to_tr_vol_val" ).append("\n"); 
		query.append(", @[rvis_vol_qty] 			-- rvis_vol_qty" ).append("\n"); 
		query.append(", @[dcgo_ind_cd] 			-- dcgo_ind_cd" ).append("\n"); 
		query.append(", @[vol_tr_ut_cd] 			-- vol_tr_ut_cd" ).append("\n"); 
		query.append(", @[inv_xch_rt] 			-- inv_xch_rt" ).append("\n"); 
		query.append(", @[ctrt_rt] 			-- ctrt_rt" ).append("\n"); 
		query.append(", @[calc_amt] 			-- calc_amt" ).append("\n"); 
		query.append(", @[cre_usr_id] 			-- cre_usr_id" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])		-- locl_cre_dt" ).append("\n"); 
		query.append(", @[upd_usr_id] 			-- upd_usr_id" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_upd_dt])		-- locl_upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
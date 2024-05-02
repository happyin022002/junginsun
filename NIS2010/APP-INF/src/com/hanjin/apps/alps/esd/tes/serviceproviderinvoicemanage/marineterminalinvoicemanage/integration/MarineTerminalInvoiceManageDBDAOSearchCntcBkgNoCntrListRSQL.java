/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchCntcBkgNoCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchCntcBkgNoCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTC항차이면서 NH인 BKG NO. 없는 Container List 조회
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchCntcBkgNoCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dscr_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchCntcBkgNoCntrListRSQL").append("\n"); 
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
		query.append("SELECT    C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		, C.TML_SO_SEQ" ).append("\n"); 
		query.append("		, C.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("		, C.VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("		, C.MODI_FLG" ).append("\n"); 
		query.append("		, C.DSCR_IND_CD" ).append("\n"); 
		query.append("		, C.DSCR_DTL_IND_CD" ).append("\n"); 
		query.append("		, C.RVIS_IND_FLG" ).append("\n"); 
		query.append("		, C.TML_RVIS_IND_FLG" ).append("\n"); 
		query.append("		, C.STO_RVIS_IND_FLG" ).append("\n"); 
		query.append("		, C.STV_RVIS_IND_FLG" ).append("\n"); 
		query.append("		, C.CGO_RVIS_IND_FLG" ).append("\n"); 
		query.append("		, C.RVIS_GATE_IN_FLG" ).append("\n"); 
		query.append("		, C.RVIS_GATE_OUT_FLG" ).append("\n"); 
		query.append("		, C.TML_IF_SEQ" ).append("\n"); 
		query.append("		, C.VSL_CD" ).append("\n"); 
		query.append("		, C.SKD_VOY_NO" ).append("\n"); 
		query.append("		, C.SKD_DIR_CD" ).append("\n"); 
		query.append("		, C.FINC_VSL_CD" ).append("\n"); 
		query.append("		, C.FINC_SKD_VOY_NO" ).append("\n"); 
		query.append("		, C.FINC_SKD_DIR_CD" ).append("\n"); 
		query.append("		, C.IO_BND_CD" ).append("\n"); 
		query.append("		, C.IOC_CD" ).append("\n"); 
		query.append("		, C.LANE_CD" ).append("\n"); 
		query.append("		, C.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("		, C.ATB_DT" ).append("\n"); 
		query.append("		, C.CNTR_NO" ).append("\n"); 
		query.append("		, C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, C.CNTR_STY_CD" ).append("\n"); 
		query.append("		, C.LOCL_TS_IND_CD" ).append("\n"); 
		query.append("		, C.SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append("		, C.RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("		, C.PRE_YD_CD" ).append("\n"); 
		query.append("		, C.MVMT_GATE_IN_DT" ).append("\n"); 
		query.append("		, C.INV_GATE_IN_DT" ).append("\n"); 
		query.append("		, C.GATE_IN_TD_DYS" ).append("\n"); 
		query.append("		, C.MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("		, C.INV_GATE_OUT_DT" ).append("\n"); 
		query.append("		, C.GATE_OUT_TD_DYS" ).append("\n"); 
		query.append("		, C.MVMT_STAY_DYS" ).append("\n"); 
		query.append("		, C.INV_STAY_DYS" ).append("\n"); 
		query.append("		, C.STAY_DIFF_DYS" ).append("\n"); 
		query.append("		, C.DCGO_CLSS_CD" ).append("\n"); 
		query.append("		, C.BB_CGO_FLG" ).append("\n"); 
		query.append("		, C.AWK_CGO_FLG" ).append("\n"); 
		query.append("		, C.RC_FLG" ).append("\n"); 
		query.append("		, C.WRK_DT" ).append("\n"); 
		query.append("		, C.CLM_DT" ).append("\n"); 
		query.append("		, C.RAIL_BIL_DT" ).append("\n"); 
		query.append("		, C.BKG_NO" ).append("\n"); 
		query.append("		, C.BL_NO" ).append("\n"); 
		query.append("		, C.DSCR_RSN" ).append("\n"); 
		query.append("		, C.HNDL_RSLT_RMK" ).append("\n"); 
		query.append("		, C.CNTR_RMK" ).append("\n"); 
		query.append("		, C.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		, C.CALL_YD_IND_SEQ " ).append("\n"); 
		query.append("		, C.LOCL_CRE_DT" ).append("\n"); 
		query.append("		, C.LOCL_UPD_DT" ).append("\n"); 
		query.append("		, C.CRE_USR_ID" ).append("\n"); 
		query.append("		, C.CRE_DT" ).append("\n"); 
		query.append("		, C.UPD_USR_ID" ).append("\n"); 
		query.append("		, C.UPD_DT" ).append("\n"); 
		query.append("		, H.YD_CD" ).append("\n"); 
		query.append("FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("		, TES_TML_SO_CNTR_LIST C" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		H.TML_SO_OFC_CTY_CD = C.TML_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("AND		H.TML_SO_SEQ 		= C.TML_SO_SEQ" ).append("\n"); 
		query.append("AND		C.TML_SO_OFC_CTY_CD	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		C.TML_SO_SEQ		= @[tml_so_seq]" ).append("\n"); 
		query.append("AND		VSL_CD				= @[vsl_cd]" ).append("\n"); 
		query.append("AND		DSCR_IND_CD			= @[dscr_ind_cd]" ).append("\n"); 
		query.append("AND		CNTR_STY_CD			= @[cntr_sty_cd]" ).append("\n"); 
		query.append("AND		NVL(BKG_NO, 'N')	= 'N'" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInvoiceInquiryDBDAOSearchMarineTerminalInvoiceDiscrepancyCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2009.10.28 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInvoiceInquiryDBDAOSearchMarineTerminalInvoiceDiscrepancyCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Marine Terminal Invoice Discrepancy Container 를 조회한다.
	  * </pre>
	  */
	public TerminalInvoiceInquiryDBDAOSearchMarineTerminalInvoiceDiscrepancyCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.integration").append("\n"); 
		query.append("FileName : TerminalInvoiceInquiryDBDAOSearchMarineTerminalInvoiceDiscrepancyCntrRSQL").append("\n"); 
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
		query.append("SELECT   C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",C.TML_SO_SEQ" ).append("\n"); 
		query.append(",C.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append(",C.VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append(",C.MODI_FLG" ).append("\n"); 
		query.append(",C.DSCR_IND_CD" ).append("\n"); 
		query.append(",DECODE(TES_GET_COMCODENAME_FNC('CD00823',C.DSCR_IND_CD),NULL,''" ).append("\n"); 
		query.append(",TES_GET_COMCODENAME_FNC('CD00823',C.DSCR_IND_CD))  DSCR_IND_NM" ).append("\n"); 
		query.append(",C.RVIS_IND_FLG" ).append("\n"); 
		query.append(",C.VSL_CD" ).append("\n"); 
		query.append(",C.SKD_VOY_NO" ).append("\n"); 
		query.append(",C.SKD_DIR_CD" ).append("\n"); 
		query.append(",C.IO_BND_CD" ).append("\n"); 
		query.append(",C.IOC_CD" ).append("\n"); 
		query.append(",C.LANE_CD" ).append("\n"); 
		query.append(",C.LANE_CD LANE_CD2" ).append("\n"); 
		query.append(",TO_CHAR(C.ATB_DT,'YYYY-MM-DD') ATB_DT" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",C.CNTR_STY_CD" ).append("\n"); 
		query.append(",C.LOCL_TS_IND_CD" ).append("\n"); 
		query.append(",SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append(",SUBSTR(C.RCVDE_TERM_IND_CD,0,1)||'/'||SUBSTR(C.RCVDE_TERM_IND_CD,2,1)  RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append(",C.PRE_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(C.MVMT_GATE_IN_DT,'YYYY-MM-DD') MVMT_GATE_IN_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.INV_GATE_IN_DT,'YYYY-MM-DD')  INV_GATE_IN_DT" ).append("\n"); 
		query.append(",C.GATE_IN_TD_DYS" ).append("\n"); 
		query.append(",C.MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append(",C.INV_GATE_OUT_DT" ).append("\n"); 
		query.append(",C.GATE_OUT_TD_DYS" ).append("\n"); 
		query.append(",C.MVMT_STAY_DYS" ).append("\n"); 
		query.append(",C.INV_STAY_DYS" ).append("\n"); 
		query.append(",C.STAY_DIFF_DYS" ).append("\n"); 
		query.append(",C.DCGO_CLSS_CD" ).append("\n"); 
		query.append(",C.BB_CGO_FLG" ).append("\n"); 
		query.append(",TO_CHAR(C.WRK_DT,'YYYY-MM-DD')      WRK_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.CLM_DT,'YYYY-MM-DD')      CLM_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.RAIL_BIL_DT,'YYYY-MM-DD') RAIL_BIL_DT" ).append("\n"); 
		query.append(",C.BKG_NO" ).append("\n"); 
		query.append(",C.BL_NO" ).append("\n"); 
		query.append(",C.DSCR_RSN" ).append("\n"); 
		query.append(",C.HNDL_RSLT_RMK" ).append("\n"); 
		query.append(",C.CNTR_RMK" ).append("\n"); 
		query.append(",C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",C.DSCR_DTL_IND_CD" ).append("\n"); 
		query.append(",C.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append(",C.AWK_CGO_FLG" ).append("\n"); 
		query.append(",C.RC_FLG" ).append("\n"); 
		query.append("FROM TES_TML_SO_VVD_LIST V" ).append("\n"); 
		query.append(",TES_TML_SO_CNTR_LIST C" ).append("\n"); 
		query.append("WHERE V.TML_SO_OFC_CTY_CD = C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND V.TML_SO_SEQ = C.TML_SO_SEQ" ).append("\n"); 
		query.append("AND V.TML_SO_OFC_CTY_CD = @[r_tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND V.TML_SO_SEQ = @[r_tml_so_seq]" ).append("\n"); 
		query.append("AND V.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND V.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("AND C.VRFY_RSLT_IND_CD = 'DC'" ).append("\n"); 
		query.append("AND V.TML_SO_VVD_LIST_SEQ = (SELECT MIN(TML_SO_VVD_LIST_SEQ) + NVL(@[r_seq],0)" ).append("\n"); 
		query.append("FROM TES_TML_SO_VVD_LIST" ).append("\n"); 
		query.append("WHERE TML_SO_OFC_CTY_CD = @[r_tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TML_SO_SEQ = @[r_tml_so_seq]" ).append("\n"); 
		query.append("AND DECODE(@[r_vsl_cd],'','N',VSL_CD) =NVL(@[r_vsl_cd],'N')" ).append("\n"); 
		query.append("AND DECODE(@[r_skd_voy_no],'','N',SKD_VOY_NO) =NVL(@[r_skd_voy_no],'N')" ).append("\n"); 
		query.append("AND DECODE(@[r_skd_dir_cd],'','N',SKD_DIR_CD) =NVL(@[r_skd_dir_cd],'N')" ).append("\n"); 
		query.append("AND DECODE(@[r_io_bnd_cd],'','N',IO_BND_CD) =NVL(@[r_io_bnd_cd],'N'))" ).append("\n"); 

	}
}
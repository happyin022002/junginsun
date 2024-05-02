/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInvoiceInquiryDBDAOSearchMarineTerminalStorageInvoiceDiscrepancyCntrRSQL.java
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

public class TerminalInvoiceInquiryDBDAOSearchMarineTerminalStorageInvoiceDiscrepancyCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Marine Terminal Storage Invoice Discrepancy Container 를 조회한다.
	  * </pre>
	  */
	public TerminalInvoiceInquiryDBDAOSearchMarineTerminalStorageInvoiceDiscrepancyCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("r_tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.integration").append("\n"); 
		query.append("FileName : TerminalInvoiceInquiryDBDAOSearchMarineTerminalStorageInvoiceDiscrepancyCntrRSQL").append("\n"); 
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
		query.append("SELECT B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",B.TML_SO_SEQ" ).append("\n"); 
		query.append(",B.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append(",B.VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append(",B.MODI_FLG" ).append("\n"); 
		query.append(",B.DSCR_IND_CD" ).append("\n"); 
		query.append(",B.RVIS_IND_FLG" ).append("\n"); 
		query.append(",B.VSL_CD" ).append("\n"); 
		query.append(",B.SKD_VOY_NO" ).append("\n"); 
		query.append(",B.SKD_DIR_CD" ).append("\n"); 
		query.append(",B.FINC_VSL_CD" ).append("\n"); 
		query.append(",B.FINC_SKD_VOY_NO" ).append("\n"); 
		query.append(",B.FINC_SKD_DIR_CD" ).append("\n"); 
		query.append(",B.IO_BND_CD" ).append("\n"); 
		query.append(",B.IOC_CD" ).append("\n"); 
		query.append(",B.LANE_CD" ).append("\n"); 
		query.append(",B.ATB_DT" ).append("\n"); 
		query.append(",B.CNTR_NO" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",B.CNTR_STY_CD" ).append("\n"); 
		query.append(",B.LOCL_TS_IND_CD" ).append("\n"); 
		query.append(",B.SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append(",B.RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append(",B.PRE_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(B.MVMT_GATE_IN_DT,'YYYY-MM-DD HH24:MI') MVMT_GATE_IN_DT" ).append("\n"); 
		query.append(",TO_CHAR(B.INV_GATE_IN_DT,'YYYY-MM-DD HH24:MI') INV_GATE_IN_DT" ).append("\n"); 
		query.append(",B.GATE_IN_TD_DYS" ).append("\n"); 
		query.append(",TO_CHAR(B.MVMT_GATE_OUT_DT,'YYYY-MM-DD HH24:MI') MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append(",TO_CHAR(B.INV_GATE_OUT_DT,'YYYY-MM-DD HH24:MI') INV_GATE_OUT_DT" ).append("\n"); 
		query.append(",B.GATE_OUT_TD_DYS" ).append("\n"); 
		query.append(",B.MVMT_STAY_DYS" ).append("\n"); 
		query.append(",B.INV_STAY_DYS" ).append("\n"); 
		query.append(",B.STAY_DIFF_DYS" ).append("\n"); 
		query.append(",B.DCGO_CLSS_CD" ).append("\n"); 
		query.append(",B.BB_CGO_FLG" ).append("\n"); 
		query.append(",B.WRK_DT" ).append("\n"); 
		query.append(",B.CLM_DT" ).append("\n"); 
		query.append(",B.RAIL_BIL_DT" ).append("\n"); 
		query.append(",B.BKG_NO" ).append("\n"); 
		query.append(",B.BL_NO" ).append("\n"); 
		query.append(",B.DSCR_RSN" ).append("\n"); 
		query.append(",B.HNDL_RSLT_RMK" ).append("\n"); 
		query.append(",B.CNTR_RMK" ).append("\n"); 
		query.append(",B.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(B.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",B.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(B.UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM   TES_TML_SO_HDR A" ).append("\n"); 
		query.append(",TES_TML_SO_CNTR_LIST B" ).append("\n"); 
		query.append("WHERE A.TML_SO_OFC_CTY_CD = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TML_SO_SEQ = B.TML_SO_SEQ" ).append("\n"); 
		query.append("AND B.TML_SO_OFC_CTY_CD = @[r_tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND B.TML_SO_SEQ = @[r_tml_so_seq]" ).append("\n"); 
		query.append("AND B.VRFY_RSLT_IND_CD = 'DC'" ).append("\n"); 
		query.append("ORDER BY B.DSCR_IND_CD ASC,B.CNTR_TPSZ_CD ASC,B.CNTR_STY_CD ASC,CNTR_NO ASC" ).append("\n"); 

	}
}
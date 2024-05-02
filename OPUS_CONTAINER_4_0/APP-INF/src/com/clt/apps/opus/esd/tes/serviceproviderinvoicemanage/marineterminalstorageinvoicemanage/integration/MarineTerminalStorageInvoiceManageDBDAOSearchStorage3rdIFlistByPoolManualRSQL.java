/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolManualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.26 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolManualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStorage3rdIFlistByPoolManual
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolManualRSQL(){
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
		params.put("tmp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolManualRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM TMP_TPB_SEQ, @[tmp_dtl_seq] TMP_DTL_SEQ, D.CALC_TP_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_IF_OFC_CD IS NOT NULL AND T.TML_IF_SEQ IS NOT NULL THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END CHK," ).append("\n"); 
		query.append("T.TML_IF_OFC_CD, T.TML_IF_SEQ, T.TML_N3PTY_TP_CD, T.TML_N3PTY_IF_STS_CD," ).append("\n"); 
		query.append("NVL(T.CALC_COST_GRP_CD,D.CALC_COST_GRP_CD) CALC_COST_GRP_CD, T.INV_NO, T.VNDR_SEQ, T.YD_CD," ).append("\n"); 
		query.append("T.LGS_COST_CD, T.ACCT_CD, T.TML_SO_OFC_CTY_CD, T.TML_SO_SEQ," ).append("\n"); 
		query.append("T.TML_SO_DTL_SEQ, T.CSR_NO, T.N3PTY_BIL_TP_CD, T.CNTR_NO," ).append("\n"); 
		query.append("T.CNTR_TPSZ_CD, T.BKG_NO, T.BL_NO," ).append("\n"); 
		query.append("T.FINC_VSL_CD, T.FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("T.FINC_SKD_DIR_CD, T.IO_BND_CD, T.REF_VNDR_SEQ, T.TML_CRR_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'C' THEN T.CUST_CNT_CD||T.CUST_SEQ" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'S' THEN T.N3PTY_OFC_CD" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'V' THEN T.VNDR_CNT_CD||T.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("END TRD_PARTY_VAL," ).append("\n"); 
		query.append("T.VNDR_CUST_DIV_CD, T.VNDR_CNT_CD, T.N3PTY_VNDR_SEQ, T.CUST_CNT_CD," ).append("\n"); 
		query.append("T.CUST_SEQ, T.N3PTY_OFC_CD, T.CURR_CD, T.IF_AMT," ).append("\n"); 
		query.append("T.IF_RMK, T.N3PTY_INV_DT, T.N3PTY_TERM_DT, T.N3PTY_CSR_CURR_CD," ).append("\n"); 
		query.append("T.N3PTY_AMT, T.N3PTY_DESC, T.CXL_FLG" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ        = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = T.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ        = T.TML_SO_SEQ" ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ 	= T.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ = @[tml_so_dtl_seq]" ).append("\n"); 
		query.append("ORDER BY T.LGS_COST_CD ASC, T.CNTR_NO ASC, T.CNTR_TPSZ_CD ASC" ).append("\n"); 

	}
}
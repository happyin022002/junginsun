/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.27 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStorage3rdIFlist
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("def_F",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("param_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("def_M",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("T.CALC_COST_GRP_CD, S.CNTR_NO, S.TML_SO_OFC_CTY_CD, S.TML_SO_SEQ," ).append("\n"); 
		query.append("S.TML_SO_CNTR_LIST_SEQ, S.LGS_COST_CD, S.CNTR_TPSZ_CD, S.IO_BND_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_IF_OFC_CD IS NOT NULL AND T.TML_IF_SEQ IS NOT NULL THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END CHK," ).append("\n"); 
		query.append("T.TML_IF_OFC_CD, T.TML_IF_SEQ, T.TML_N3PTY_TP_CD, T.TML_N3PTY_IF_STS_CD," ).append("\n"); 
		query.append("T.INV_NO, T.VNDR_SEQ, T.YD_CD, T.ACCT_CD," ).append("\n"); 
		query.append("T.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("T.N3PTY_BIL_TP_CD, T.BKG_NO, T.BKG_NO_SPLIT," ).append("\n"); 
		query.append("T.BL_NO, T.BL_NO_TP, T.BL_NO_CHK, T.FINC_VSL_CD, T.FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("T.FINC_SKD_DIR_CD, T.REF_VNDR_SEQ, T.TML_CRR_CD, T.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("T.VNDR_CNT_CD, T.N3PTY_VNDR_SEQ, T.CUST_CNT_CD, T.CUST_SEQ, T.N3PTY_OFC_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'C' THEN T.CUST_CNT_CD||T.CUST_SEQ" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'S' THEN T.N3PTY_OFC_CD" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'V' THEN T.VNDR_CNT_CD||T.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("END TRD_PARTY_VAL," ).append("\n"); 
		query.append("T.CURR_CD, T.IF_AMT, T.IF_RMK, T.N3PTY_INV_DT, T.N3PTY_TERM_DT," ).append("\n"); 
		query.append("T.N3PTY_CSR_CURR_CD, T.N3PTY_AMT, T.N3PTY_DESC, T.CXL_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("H.INV_OFC_CD," ).append("\n"); 
		query.append("L.RVIS_IND_FLG," ).append("\n"); 
		query.append("L.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("L.TML_SO_SEQ," ).append("\n"); 
		query.append("L.TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("L.TML_IF_SEQ," ).append("\n"); 
		query.append("L.CNTR_NO," ).append("\n"); 
		query.append("L.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("L.CNTR_STY_CD," ).append("\n"); 
		query.append("L.IO_BND_CD," ).append("\n"); 
		query.append("DECODE(L.CNTR_STY_CD,'F',@[def_F],@[def_M]) LGS_COST_CD," ).append("\n"); 
		query.append("L.BL_NO," ).append("\n"); 
		query.append("L.CNTR_RMK" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ        = L.TML_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND L.VRFY_RSLT_IND_CD = 'CO'" ).append("\n"); 
		query.append("AND L.CNTR_TPSZ_CD = @[param_cntr_tpsz_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.LGS_COST_CD = @[param_lgs_cost_cd]" ).append("\n"); 
		query.append(") S, TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND S.INV_OFC_CD = T.TML_IF_OFC_CD(+)" ).append("\n"); 
		query.append("AND S.TML_IF_SEQ = T.TML_IF_SEQ(+)" ).append("\n"); 

	}
}
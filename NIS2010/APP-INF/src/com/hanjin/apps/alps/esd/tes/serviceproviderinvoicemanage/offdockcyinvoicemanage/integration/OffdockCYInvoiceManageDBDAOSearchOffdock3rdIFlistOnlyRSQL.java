/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistOnlyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.04.15 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistOnlyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOffdock3rdIFlistOnly
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistOnlyRSQL(){
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
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistOnlyRSQL").append("\n"); 
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
		query.append("T.TML_IF_OFC_CD, T.TML_IF_SEQ, T.TML_N3PTY_TP_CD, T.TML_N3PTY_IF_STS_CD, T.INV_NO," ).append("\n"); 
		query.append("T.VNDR_SEQ, T.YD_CD, T.ACCT_CD, T.TML_SO_OFC_CTY_CD, T.TML_SO_SEQ," ).append("\n"); 
		query.append("T.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("(SELECT N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("FROM    TPB_N3RD_PTY_BIL_TP" ).append("\n"); 
		query.append("WHERE   1   = 1" ).append("\n"); 
		query.append("AND     N3PTY_BIL_TP_CD = T.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(") N3PTY_BIL_TP_CD, T.BKG_NO, T.BL_NO," ).append("\n"); 
		query.append("T.FINC_VSL_CD, T.FINC_SKD_VOY_NO, T.FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("T.REF_VNDR_SEQ, T.TML_CRR_CD, T.VNDR_CUST_DIV_CD, T.VNDR_CNT_CD, T.N3PTY_VNDR_SEQ," ).append("\n"); 
		query.append("T.CUST_CNT_CD, T.CUST_SEQ, T.N3PTY_OFC_CD, T.CURR_CD, T.IF_AMT," ).append("\n"); 
		query.append("T.IF_RMK, T.N3PTY_INV_DT, T.N3PTY_CSR_CURR_CD, T.N3PTY_AMT, T.N3PTY_DESC," ).append("\n"); 
		query.append("T.CXL_FLG, T.CNTR_NO," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'C' THEN T.CUST_CNT_CD|| LPAD(T.CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'S' THEN T.N3PTY_OFC_CD" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'V' THEN T.VNDR_CNT_CD|| LPAD(T.N3PTY_VNDR_SEQ, 6, '0')" ).append("\n"); 
		query.append("END TRD_PARTY_VAL" ).append("\n"); 
		query.append("FROM	TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND	T.TML_SO_OFC_CTY_CD	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND	T.TML_SO_SEQ		= @[tml_so_seq]" ).append("\n"); 
		query.append("AND	T.TML_SO_DTL_SEQ	= @[tml_so_dtl_seq]" ).append("\n"); 

	}
}
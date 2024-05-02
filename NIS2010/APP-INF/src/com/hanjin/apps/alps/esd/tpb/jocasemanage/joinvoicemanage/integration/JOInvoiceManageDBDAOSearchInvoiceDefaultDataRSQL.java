/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchInvoiceDefaultDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchInvoiceDefaultDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceDefaultData
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchInvoiceDefaultDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchInvoiceDefaultDataRSQL").append("\n"); 
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
		query.append("SELECT A.N3PTY_NO" ).append("\n"); 
		query.append(",B.N3PTY_INV_NO" ).append("\n"); 
		query.append(",R.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append(",R.N3PTY_INV_RVIS_CD" ).append("\n"); 
		query.append(",B.N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append(",B.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(",TPB_GET_N3PTY_BIL_TP_NM_FNC(B.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append(",A.N3PTY_SRC_NO" ).append("\n"); 
		query.append(",EQ_NO" ).append("\n"); 
		query.append(",A.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(",DECODE(B.VNDR_CUST_DIV_CD,'V',TO_CHAR(B.VNDR_SEQ),'C',B.CUST_CNT_CD||TO_CHAR(B.CUST_SEQ),'S',B.N3PTY_OFC_CD,'') N3PTY_CD" ).append("\n"); 
		query.append(",DECODE(B.VNDR_CUST_DIV_CD,'V',VNDR_LGL_ENG_NM,'C',CUST_LGL_ENG_NM,'S',B.N3PTY_OFC_CD,'') N3PTY_NM" ).append("\n"); 
		query.append(",B.VSL_CD||B.SKD_VOY_NO||B.FINC_DIR_CD AS REV_VVD" ).append("\n"); 
		query.append(",B.CURR_CD" ).append("\n"); 
		query.append(",B.OTS_AMT" ).append("\n"); 
		query.append(",B.INV_AMT" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(B.CFM_DT,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') AS CFM_DT" ).append("\n"); 
		query.append(",TPB_GET_RCVR_ACT_YN_FNC(B.N3PTY_NO) RCVR_ACT_YN" ).append("\n"); 
		query.append(",'N' AS INVOICE_ABLE" ).append("\n"); 
		query.append(",DECODE(V.OFC_CD,@[user_ofc_cd],'Y','N') AS REVISE_ABLE   -- REVISE" ).append("\n"); 
		query.append(",CASE WHEN R.CLT_AGN_FLG='Y' THEN 'N'" ).append("\n"); 
		query.append("WHEN R.N3PTY_INV_STS_CD='N' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END AS ERPIF_ABLE    -- ERP I/F" ).append("\n"); 
		query.append(",( SELECT COUNT(DISTINCT N3PTY_BIL_TP_CD) FROM TPB_OTS_DTL K WHERE K.N3PTY_NO=A.N3PTY_NO ) AS LENGTH_N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("--2009-07-31" ).append("\n"); 
		query.append(",TO_CHAR(R.IDA_TAX_SEQ) AS IDA_TAX_SEQ" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A, TPB_OTS_GRP B, TPB_OTS_GRP_STS C, TPB_INVOICE V, TPB_INV_RVIS R" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("AND B.N3PTY_INV_NO = V.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND B.N3PTY_INV_NO = R.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND V.LST_N3PTY_INV_RVIS_SEQ = R.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND A.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("AND A.N3PTY_BIL_TP_CD IN ( SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE ACT_FLG='Y' AND N3PTY_BIL_TP_CD ='JO' )" ).append("\n"); 
		query.append("AND B.N3PTY_DELT_TP_CD IN ('N')" ).append("\n"); 
		query.append("AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND C.OTS_STS_CD IN ('I','Y','A','L','N','E')" ).append("\n"); 
		query.append("AND V.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND R.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("AND A.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("#elseif (${s_n3pty_inv_no} != '')" ).append("\n"); 
		query.append("AND B.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 0 = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
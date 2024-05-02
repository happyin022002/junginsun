/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchErpInterfaceCheckData
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL").append("\n"); 
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
		query.append("--- SOURCE" ).append("\n"); 
		query.append("COUNT(DISTINCT A.N3PTY_EXPN_TP_CD) N3PTY_EXPN_TP_CD_CNT," ).append("\n"); 
		query.append("MAX(A.N3PTY_EXPN_TP_CD) N3PTY_EXPN_TP_CD_MAX," ).append("\n"); 
		query.append("--- BILLING CASE" ).append("\n"); 
		query.append("COUNT(DISTINCT Z.N3PTY_BIL_TP_CD) N3PTY_BIL_TP_CD_CNT," ).append("\n"); 
		query.append("MAX(Z.N3PTY_BIL_TP_CD) N3PTY_BIL_TP_CD_MAX," ).append("\n"); 
		query.append("--- 3RD PARTY" ).append("\n"); 
		query.append("COUNT( DISTINCT DECODE(A.VNDR_CUST_DIV_CD, 'V',TO_CHAR(A.VNDR_SEQ), 'C', A.CUST_CNT_CD||A.CUST_SEQ, 'S',A.N3PTY_OFC_CD, NULL) ) TRD_PARTY_CODE_CNT," ).append("\n"); 
		query.append("MAX( DECODE(A.VNDR_CUST_DIV_CD, 'V',TO_CHAR(A.VNDR_SEQ), 'C', A.CUST_CNT_CD||A.CUST_SEQ, 'S',A.N3PTY_OFC_CD, NULL) ) TRD_PARTY_CODE_MAX," ).append("\n"); 
		query.append("--- REVENUE VVD" ).append("\n"); 
		query.append("COUNT( DISTINCT NVL( DECODE(A.N3PTY_SRC_SUB_SYS_CD, 'MNR',NULL, A.VSL_CD||A.SKD_VOY_NO||A.FINC_DIR_CD), '-') ) REVENUE_VVD_CNT," ).append("\n"); 
		query.append("MAX( DECODE(A.N3PTY_SRC_SUB_SYS_CD, 'MNR',NULL, A.VSL_CD||A.SKD_VOY_NO||A.FINC_DIR_CD) ) REVENUE_VVD_MAX," ).append("\n"); 
		query.append("--- CURRENCY" ).append("\n"); 
		query.append("COUNT( DISTINCT Y.CURR_CD ) CURR_CD_CNT," ).append("\n"); 
		query.append("MAX( Y.CURR_CD ) CURR_CD_MAX," ).append("\n"); 
		query.append("--- ACTUAL VVD" ).append("\n"); 
		query.append("COUNT( DISTINCT NVL(Z.VVD_CD,'-' )) VVD_CD_CNT," ).append("\n"); 
		query.append("MAX( Z.VVD_CD ) VVD_CD_MAX," ).append("\n"); 
		query.append("--- CSR NO." ).append("\n"); 
		query.append("COUNT( DISTINCT NVL(Z.CSR_NO,'-' )) CSR_NO_CNT," ).append("\n"); 
		query.append("MAX( Z.CSR_NO ) CSR_NO_MAX," ).append("\n"); 
		query.append("--- MONTH OF GL DATE" ).append("\n"); 
		query.append("COUNT( DISTINCT NVL(SUBSTRB(Z.GL_DT,1,6),'-') ) GL_MONTH_CNT," ).append("\n"); 
		query.append("MAX( SUBSTRB(Z.GL_DT,1,6) ) GL_MONTH_MAX" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A," ).append("\n"); 
		query.append("TPB_OTS_GRP B," ).append("\n"); 
		query.append("TPB_INV_RVIS_DTL Z," ).append("\n"); 
		query.append("TPB_INV_RVIS Y," ).append("\n"); 
		query.append("TPB_INVOICE X" ).append("\n"); 
		query.append("WHERE Y.N3PTY_INV_NO = X.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND Y.N3PTY_INV_NO = Z.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND Y.N3PTY_INV_NO = B.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND B.N3PTY_NO = A.N3PTY_NO" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND X.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND Y.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND Z.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND Y.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND Y.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 

	}
}
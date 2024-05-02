/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.04.30 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceRevisionInfo
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("is_france",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_rmd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_detail_ots_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_xch_rt_original",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_detail_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL").append("\n"); 
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
		query.append("#if (${s_h_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("SELECT A.VNDR_CUST_ADDR||'\\N'||' TEL: '||A.PHN_NO	ENG_ADDR" ).append("\n"); 
		query.append(",A.VNDR_CNT_CD" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_SEQ" ).append("\n"); 
		query.append(",LPAD(TO_CHAR(A.VNDR_SEQ),6,'0')	TRD_PARTY_CODE" ).append("\n"); 
		query.append("#if (${s_curr_cd} == '')" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.CURR_CD) PRCS_CNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",@[s_curr_cd] CURR_CD" ).append("\n"); 
		query.append(",(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[s_curr_cd]) PRCS_CNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",A.FAX_NO" ).append("\n"); 
		query.append(",A.PHN_NO" ).append("\n"); 
		query.append(",A.VNDR_CUST_ADDR" ).append("\n"); 
		query.append(",A.VNDR_CUST_NM" ).append("\n"); 
		query.append(",A.RGST_NO" ).append("\n"); 
		query.append(",A.VNDR_CUST_REF_RMK" ).append("\n"); 
		query.append(",A.BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append(",A.CLT_AGN_RMK" ).append("\n"); 
		query.append(",A.CLT_AGN_FLG" ).append("\n"); 
		query.append(",A.N3PTY_INV_STS_CD" ).append("\n"); 
		query.append(",A.INV_DESC" ).append("\n"); 
		query.append(",A.VNDR_CUST_EML" ).append("\n"); 
		query.append(",TO_CHAR(A.RCV_DUE_DT,'YYYY-MM-DD') RCV_DUE_DT" ).append("\n"); 
		query.append(",DECODE(SUBSTR(A.N3PTY_INV_RVIS_CD,1,1),'4','Y','N') N3PTY_INV_RMD_YN" ).append("\n"); 
		query.append(",A.N3PTY_INV_RVIS_CD AS N3PTY_INV_RMD_NM" ).append("\n"); 
		query.append(",A.N3PTY_INV_RVIS_SEQ HIS_SEQ" ).append("\n"); 
		query.append(",'Y' AS FINAL_FLG" ).append("\n"); 
		query.append(",@[s_detail_n3pty_no] DETAIL_N3PTY_NO" ).append("\n"); 
		query.append(",@[s_detail_ots_sts_cd] DETAIL_OTS_STS_CD" ).append("\n"); 
		query.append(",A.MON_XCH_RT" ).append("\n"); 
		query.append(",NVL(A.NET_AMT,0) NET_AMT" ).append("\n"); 
		query.append(",NVL(A.VAT_AMT,0) VAT_AMT" ).append("\n"); 
		query.append(",NVL(A.ADD_AMT,0) ADD_AMT" ).append("\n"); 
		query.append(",NVL(A.DDCT_AMT,0) DDCT_AMT" ).append("\n"); 
		query.append(",A.INV_AMT TOTAL_AMT" ).append("\n"); 
		query.append(",@[vat_xch_rt_original] VAT_XCH_RT_ORIGINAL" ).append("\n"); 
		query.append(",@[is_france] FRANCE" ).append("\n"); 
		query.append(",B.LNK_N3PTY_INV_NO" ).append("\n"); 
		query.append(",A.CTY_NM, A.STE_CD, A.ZIP_CD, A.USR_INP_CTNT1, A.USR_INP_CTNT2 /* ADDED 'BILL TO' */" ).append("\n"); 
		query.append(",B.OFC_CD AS INV_ISS_OFC_CD       /* ADDED ISSUE OFFICE CODE */" ).append("\n"); 
		query.append(",DECODE(A.N3PTY_INV_RVIS_CD," ).append("\n"); 
		query.append("A.N3PTY_INV_RVIS_CD, DECODE(SUBSTRB(A.N3PTY_INV_RVIS_CD,1,1),'O','Y','R','Y','N')" ).append("\n"); 
		query.append(",'N') AS SAME_VERSION_YN" ).append("\n"); 
		query.append(",TPB_GET_HNDL_OFC_FNC('R',B.OFC_CD) AS INV_ISS_RHQ_CD       /* ADDED ISSUE OFFICE CODE */" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN A.CLT_AGN_FLG IS NULL OR A.CLT_AGN_FLG!='N' THEN 'N'" ).append("\n"); 
		query.append("WHEN A.N3PTY_INV_STS_CD!='N' THEN 'N'" ).append("\n"); 
		query.append("WHEN A.N3PTY_DELT_TP_CD!='N' THEN 'N'" ).append("\n"); 
		query.append("WHEN SUBSTRB(A.N3PTY_INV_RVIS_CD,1,1)!='O' AND SUBSTRB(A.N3PTY_INV_RVIS_CD,1,1)!='R'THEN 'N'" ).append("\n"); 
		query.append("WHEN (SELECT SIGN(NVL(MAX(C.N3PTY_INV_RVIS_SEQ),0)-A.N3PTY_INV_RVIS_SEQ) FROM TPB_INV_RVIS C WHERE C.N3PTY_INV_NO = A.N3PTY_INV_NO AND C.N3PTY_INV_RVIS_SEQ >= A.N3PTY_INV_RVIS_SEQ) = 0 THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END AS ERPIF_YN" ).append("\n"); 
		query.append("FROM TPB_INV_RVIS A, TPB_INVOICE B" ).append("\n"); 
		query.append("WHERE A.N3PTY_INV_NO = B.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND A.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND A.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("AND A.N3PTY_INV_RVIS_CD = @[s_n3pty_inv_rmd_cd]" ).append("\n"); 
		query.append("#elseif (${s_h_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("SELECT A.VNDR_CUST_ADDR||'\\N'||' TEL: '||A.PHN_NO    ENG_ADDR" ).append("\n"); 
		query.append(",'' VNDR_CNT_CD" ).append("\n"); 
		query.append(",'' VNDR_SEQ" ).append("\n"); 
		query.append(",A.CUST_CNT_CD" ).append("\n"); 
		query.append(",A.CUST_SEQ" ).append("\n"); 
		query.append(",A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0')	TRD_PARTY_CODE" ).append("\n"); 
		query.append("#if (${s_curr_cd} == '')" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.CURR_CD) PRCS_CNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",@[s_curr_cd] CURR_CD" ).append("\n"); 
		query.append(",(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[s_curr_cd]) PRCS_CNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",A.FAX_NO" ).append("\n"); 
		query.append(",A.PHN_NO" ).append("\n"); 
		query.append(",A.VNDR_CUST_ADDR" ).append("\n"); 
		query.append(",A.VNDR_CUST_NM" ).append("\n"); 
		query.append(",A.RGST_NO" ).append("\n"); 
		query.append(",A.VNDR_CUST_REF_RMK" ).append("\n"); 
		query.append(",A.BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append(",A.CLT_AGN_RMK" ).append("\n"); 
		query.append(",A.CLT_AGN_FLG" ).append("\n"); 
		query.append(",A.N3PTY_INV_STS_CD" ).append("\n"); 
		query.append(",A.INV_DESC" ).append("\n"); 
		query.append(",A.VNDR_CUST_EML" ).append("\n"); 
		query.append(",TO_CHAR(A.RCV_DUE_DT,'YYYY-MM-DD') RCV_DUE_DT  /* NOT TPB LOCAL DATE */" ).append("\n"); 
		query.append(",DECODE(SUBSTR(A.N3PTY_INV_RVIS_CD,1,1),'4','Y','N') N3PTY_INV_RMD_YN" ).append("\n"); 
		query.append(",A.N3PTY_INV_RVIS_CD AS N3PTY_INV_RMD_NM" ).append("\n"); 
		query.append(",A.N3PTY_INV_RVIS_SEQ HIS_SEQ  /*CORRECTION에서 호출시는 NULL로 처리함.*/" ).append("\n"); 
		query.append(",'Y' AS FINAL_FLG" ).append("\n"); 
		query.append(",@[s_detail_n3pty_no] DETAIL_N3PTY_NO" ).append("\n"); 
		query.append(",@[s_detail_ots_sts_cd] DETAIL_OTS_STS_CD" ).append("\n"); 
		query.append(",A.MON_XCH_RT" ).append("\n"); 
		query.append(",NVL(A.NET_AMT,0) NET_AMT" ).append("\n"); 
		query.append(",NVL(A.VAT_AMT,0) VAT_AMT" ).append("\n"); 
		query.append(",NVL(A.ADD_AMT,0) ADD_AMT" ).append("\n"); 
		query.append(",NVL(A.DDCT_AMT,0) DDCT_AMT" ).append("\n"); 
		query.append(",A.INV_AMT TOTAL_AMT" ).append("\n"); 
		query.append(",@[vat_xch_rt_original] VAT_XCH_RT_ORIGINAL" ).append("\n"); 
		query.append(",@[is_france] FRANCE" ).append("\n"); 
		query.append(",B.LNK_N3PTY_INV_NO" ).append("\n"); 
		query.append(",A.CTY_NM, A.STE_CD, A.ZIP_CD, A.USR_INP_CTNT1, A.USR_INP_CTNT2 /* ADDED 'BILL TO'*/" ).append("\n"); 
		query.append(",B.OFC_CD AS INV_ISS_OFC_CD  /* ADDED ISSUE OFFICE CODE*/" ).append("\n"); 
		query.append(",DECODE(A.N3PTY_INV_RVIS_CD," ).append("\n"); 
		query.append("A.N3PTY_INV_RVIS_CD, DECODE(SUBSTRB(A.N3PTY_INV_RVIS_CD,1,1),'O','Y','R','Y','N')" ).append("\n"); 
		query.append(",'N') AS SAME_VERSION_YN" ).append("\n"); 
		query.append(",TPB_GET_HNDL_OFC_FNC('R',B.OFC_CD) AS INV_ISS_RHQ_CD       /* ADDED ISSUE OFFICE CODE*/" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN A.CLT_AGN_FLG IS NULL OR A.CLT_AGN_FLG!='N' THEN 'N'" ).append("\n"); 
		query.append("WHEN A.N3PTY_INV_STS_CD!='N' THEN 'N'" ).append("\n"); 
		query.append("WHEN A.N3PTY_DELT_TP_CD!='N' THEN 'N'" ).append("\n"); 
		query.append("WHEN SUBSTRB(A.N3PTY_INV_RVIS_CD,1,1)!='O' AND SUBSTRB(A.N3PTY_INV_RVIS_CD,1,1)!='R'THEN 'N'" ).append("\n"); 
		query.append("WHEN (SELECT SIGN(NVL(MAX(C.N3PTY_INV_RVIS_SEQ),0)-A.N3PTY_INV_RVIS_SEQ) FROM TPB_INV_RVIS C WHERE C.N3PTY_INV_NO = A.N3PTY_INV_NO AND C.N3PTY_INV_RVIS_SEQ >= A.N3PTY_INV_RVIS_SEQ) = 0 THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END AS ERPIF_YN" ).append("\n"); 
		query.append("FROM TPB_INV_RVIS A, TPB_INVOICE B" ).append("\n"); 
		query.append("WHERE A.N3PTY_INV_NO = B.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND A.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND A.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("AND A.N3PTY_INV_RVIS_CD = @[s_n3pty_inv_rmd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
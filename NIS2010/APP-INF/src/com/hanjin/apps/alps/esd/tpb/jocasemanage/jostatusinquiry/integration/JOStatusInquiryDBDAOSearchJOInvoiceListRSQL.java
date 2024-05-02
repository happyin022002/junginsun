/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JOStatusInquiryDBDAOSearchJOInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.29
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2013.04.29 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Ja Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOStatusInquiryDBDAOSearchJOInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB JO Invoice Inquiry
	  * </pre>
	  */
	public JOStatusInquiryDBDAOSearchJOInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_rmd_cd_for_search",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no_for_search",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trd_party_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.integration").append("\n"); 
		query.append("FileName : JOStatusInquiryDBDAOSearchJOInvoiceListRSQL").append("\n"); 
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
		query.append("##${s_trd_party_val}" ).append("\n"); 
		query.append("SELECT V.OFC_CD" ).append("\n"); 
		query.append(",D.N3PTY_NO" ).append("\n"); 
		query.append(",R.N3PTY_INV_NO" ).append("\n"); 
		query.append(",R.N3PTY_INV_RVIS_CD" ).append("\n"); 
		query.append(",R.IF_BL_NO" ).append("\n"); 
		query.append(",(SELECT N3PTY_EXPN_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE N3PTY_BIL_TP_CD = D.N3PTY_BIL_TP_CD) AS N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append(",R.CURR_CD" ).append("\n"); 
		query.append(",R.NET_AMT AS OTS_AMT" ).append("\n"); 
		query.append(",R.VAT_AMT" ).append("\n"); 
		query.append(",R.INV_AMT" ).append("\n"); 
		query.append(",R.CLT_AMT" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(R.INV_ISS_LOCL_DT,@[s_usr_ofc_cd]),'YYYY-MM-DD HH24:MI') AS INV_ISS_LOCL_DT" ).append("\n"); 
		query.append(",R.UPD_USR_ID" ).append("\n"); 
		query.append(",R.CLT_AGN_FLG" ).append("\n"); 
		query.append(",R.VNDR_CUST_NM AS TRD_PARTY_NM" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(R.AR_IF_DT,@[s_usr_ofc_cd]),'YYYY-MM-DD HH24:MI') AS AR_IF_DT" ).append("\n"); 
		query.append(",( SELECT COUNT(DISTINCT N3PTY_BIL_TP_CD) FROM TPB_INV_RVIS_DTL S WHERE S.N3PTY_INV_NO = R.N3PTY_INV_NO AND S.N3PTY_INV_RVIS_SEQ = R.N3PTY_INV_RVIS_SEQ ) AS LENGTH_N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(",R.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(",CASE R.VNDR_CUST_DIV_CD WHEN 'V' THEN TO_CHAR(R.VNDR_SEQ)" ).append("\n"); 
		query.append("WHEN 'C' THEN R.CUST_CNT_CD||R.CUST_SEQ" ).append("\n"); 
		query.append("END AS TRD_PARTY_CODE" ).append("\n"); 
		query.append(",R.N3PTY_INV_RVIS_SEQ AS N3PTY_INV_HIS_SEQ" ).append("\n"); 
		query.append("FROM TPB_INVOICE V," ).append("\n"); 
		query.append("TPB_INV_RVIS R," ).append("\n"); 
		query.append("TPB_INV_RVIS_DTL D" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND V.N3PTY_INV_NO = R.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND R.N3PTY_INV_NO = D.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND R.N3PTY_INV_RVIS_SEQ = D.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND D.N3PTY_INV_RVIS_DTL_SEQ = 1" ).append("\n"); 
		query.append("AND D.N3PTY_BIL_TP_CD = 'JO'" ).append("\n"); 
		query.append("#if (${s_cond} == '1')" ).append("\n"); 
		query.append("--invoiced date--" ).append("\n"); 
		query.append("AND R.INV_ISS_LOCL_DT >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_usr_ofc_cd])" ).append("\n"); 
		query.append("AND R.INV_ISS_LOCL_DT < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_usr_ofc_cd]) + 1" ).append("\n"); 
		query.append("AND V.OFC_CD IN (" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE N3PTY_OFC_TP_CD in ('T', 'J')" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("AND RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("AND N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${s_cond} == '2')" ).append("\n"); 
		query.append("--invoice No." ).append("\n"); 
		query.append("AND R.N3PTY_INV_NO = SUBSTRB(@[s_n3pty_inv_no_for_search],1,11)" ).append("\n"); 
		query.append("#if (${s_n3pty_inv_rmd_cd_for_search} != '')" ).append("\n"); 
		query.append("AND R.N3PTY_INV_RVIS_CD LIKE @[s_n3pty_inv_rmd_cd_for_search]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${s_cond} == '3')" ).append("\n"); 
		query.append("--EQ No." ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT S.N3PTY_INV_NO" ).append("\n"); 
		query.append("FROM TPB_INV_RVIS_DTL S" ).append("\n"); 
		query.append("WHERE S.EQ_NO = @[s_eq_no]" ).append("\n"); 
		query.append("AND S.N3PTY_INV_NO = R.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND S.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Collection Agency--" ).append("\n"); 
		query.append("#if (${s_clt_agn_flg} == 'E')" ).append("\n"); 
		query.append("--Excluding" ).append("\n"); 
		query.append("AND R.CLT_AGN_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${s_clt_agn_flg} == 'O')" ).append("\n"); 
		query.append("--Only" ).append("\n"); 
		query.append("AND R.CLT_AGN_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--ERP I/F--" ).append("\n"); 
		query.append("#if (${s_n3pty_inv_sts_cd} == 'E')" ).append("\n"); 
		query.append("--Excluding" ).append("\n"); 
		query.append("AND R.N3PTY_INV_STS_CD = 'N'" ).append("\n"); 
		query.append("#elseif (${s_n3pty_inv_sts_cd} == 'O')" ).append("\n"); 
		query.append("--Only" ).append("\n"); 
		query.append("AND R.N3PTY_INV_STS_CD <> 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--3rd Party--" ).append("\n"); 
		query.append("#if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("AND R.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("#if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("#if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("AND R.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("#elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("AND R.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("#if ($s_trd_party_val.length() > 2)" ).append("\n"); 
		query.append("AND R.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("AND 'Y' = @[s_trd_party_val]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--search version value - A/O/C/R/L--" ).append("\n"); 
		query.append("#if (${s_invce_search_version} == 'O')" ).append("\n"); 
		query.append("--ORG" ).append("\n"); 
		query.append("AND R.N3PTY_INV_RVIS_CD = 'ORG'" ).append("\n"); 
		query.append("#elseif (${s_invce_search_version} == 'C')" ).append("\n"); 
		query.append("--Cxx" ).append("\n"); 
		query.append("AND R.N3PTY_INV_RVIS_CD LIKE 'C%'" ).append("\n"); 
		query.append("#elseif (${s_invce_search_version} == 'R')" ).append("\n"); 
		query.append("--Rxx" ).append("\n"); 
		query.append("AND R.N3PTY_INV_RVIS_CD LIKE 'R%'" ).append("\n"); 
		query.append("#elseif (${s_invce_search_version} == 'L')" ).append("\n"); 
		query.append("--Last Version" ).append("\n"); 
		query.append("AND V.LST_N3PTY_INV_RVIS_SEQ = R.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY R.N3PTY_INV_NO ASC, R.N3PTY_INV_RVIS_SEQ ASC" ).append("\n"); 

	}
}
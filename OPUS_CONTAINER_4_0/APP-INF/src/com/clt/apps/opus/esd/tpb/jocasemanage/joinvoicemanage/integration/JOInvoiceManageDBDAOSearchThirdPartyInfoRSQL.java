/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchThirdPartyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.05.10 변종건
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

public class JOInvoiceManageDBDAOSearchThirdPartyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchThirdPartyInfo
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchThirdPartyInfoRSQL(){
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
		params.put("s_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trd_party_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sheet_set_count",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchThirdPartyInfoRSQL").append("\n"); 
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
		query.append("SELECT B.ENG_ADDR||'\\n'||' Tel: '||'' ENG_ADDR" ).append("\n"); 
		query.append(",A.VNDR_CNT_CD" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_SEQ" ).append("\n"); 
		query.append(",LPAD(TO_CHAR(A.VNDR_SEQ),6,'0')	TRD_PARTY_CODE" ).append("\n"); 
		query.append("#if (${s_curr_cd} != '')" ).append("\n"); 
		query.append(",@[s_curr_cd] CURR_CD" ).append("\n"); 
		query.append(",(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[s_curr_cd]) PRCS_CNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",A.CFM_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append(",(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.CFM_CURR_CD) PRCS_CNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",NULL AS FAX_NO --- C.FAX_NO	/* AS MDM_VNDR_CNTC_PNT WAS CHANGED ... BY KIM JIN-SEUNG IN 2007-06-08 */" ).append("\n"); 
		query.append(",NULL AS PHN_NO --- C.PHN_NO	/* AS MDM_VNDR_CNTC_PNT WAS CHANGED ... BY KIM JIN-SEUNG IN 2007-06-08 */" ).append("\n"); 
		query.append(",B.ENG_ADDR VNDR_CUST_ADDR" ).append("\n"); 
		query.append(",B.VNDR_LGL_ENG_NM	VNDR_CUST_NM" ).append("\n"); 
		query.append(",TPB_GET_HNDL_OFC_FNC('R',@[user_ofc_cd])	RHQ_CD" ).append("\n"); 
		query.append(",NULL AS VNDR_CUST_EML --- C.VNDR_EML /* AS MDM_VNDR_CNTC_PNT WAS CHANGED ... BY KIM JIN-SEUNG IN 2007-06-08 */" ).append("\n"); 
		query.append(",@[bil_to_loc_div_cd]	BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append(",@[s_sheet_set_count]	SHEET_SET_COUNT" ).append("\n"); 
		query.append(",@[vat_xch_rt]	VAT_XCH_RT" ).append("\n"); 
		query.append(",(SELECT TAX_ID FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) RGST_NO" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A" ).append("\n"); 
		query.append(",MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND	  A.N3PTY_NO IN ( NULL" ).append("\n"); 
		query.append("#if (${s_dao_n3pty_no} != '')" ).append("\n"); 
		query.append(", $s_dao_n3pty_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = @[s_trd_party_code]" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("#elseif (${s_h_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("SELECT B.BZET_ADDR||'\\n'||' Tel: '||C.PHN_NO	ENG_ADDR" ).append("\n"); 
		query.append(",'' VNDR_CNT_CD" ).append("\n"); 
		query.append(",'' VNDR_SEQ" ).append("\n"); 
		query.append(",A.CUST_CNT_CD" ).append("\n"); 
		query.append(",A.CUST_SEQ" ).append("\n"); 
		query.append(",A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0')	TRD_PARTY_CODE" ).append("\n"); 
		query.append("#if (${s_curr_cd} != '')" ).append("\n"); 
		query.append(",@[s_curr_cd] CURR_CD" ).append("\n"); 
		query.append(",(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[s_curr_cd]) PRCS_CNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",A.CFM_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append(",(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.CFM_CURR_CD) PRCS_CNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",C.FAX_NO" ).append("\n"); 
		query.append(",C.PHN_NO" ).append("\n"); 
		query.append(",B.BZET_ADDR	VNDR_CUST_ADDR" ).append("\n"); 
		query.append(",D.CUST_LGL_ENG_NM	VNDR_CUST_NM" ).append("\n"); 
		query.append(",TPB_GET_HNDL_OFC_FNC('R',@[user_ofc_cd])	RHQ_CD" ).append("\n"); 
		query.append(",C.CUST_EML	VNDR_CUST_EML" ).append("\n"); 
		query.append(",@[bil_to_loc_div_cd]	BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append(",@[s_sheet_set_count]	SHEET_SET_COUNT" ).append("\n"); 
		query.append(",@[vat_xch_rt]	VAT_XCH_RT" ).append("\n"); 
		query.append(",(SELECT CUST_RGST_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.CUST_CNT_CD AND CUST_SEQ = A.CUST_SEQ) RGST_NO" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A" ).append("\n"); 
		query.append(",MDM_CUST_ADDR B" ).append("\n"); 
		query.append(",MDM_CUST_CNTC_PNT C" ).append("\n"); 
		query.append(",MDM_CUSTOMER D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND	  A.N3PTY_NO IN ( NULL" ).append("\n"); 
		query.append("#if (${s_dao_n3pty_no} != '')" ).append("\n"); 
		query.append(", $s_dao_n3pty_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND 	A.CUST_CNT_CD||A.CUST_SEQ = @[s_trd_party_code]" ).append("\n"); 
		query.append("AND	A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND   A.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND   A.CUST_CNT_CD = D.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = D.CUST_SEQ" ).append("\n"); 
		query.append("/*  2009-03-24 O WAN-KI      1.5 N200903170200, INVOICE 생성시 주소선택 요건 추가. */" ).append("\n"); 
		query.append("AND ( B.PRMRY_CHK_FLG = 'Y' OR B.PRMRY_CHK_FLG IS NULL )" ).append("\n"); 
		query.append("/* 2009-06-11 O WAN-KI      1.8 N200905110239, NAMED BIZ CUSTOMER FLAG 반영. */" ).append("\n"); 
		query.append("AND (D.NMD_CUST_FLG IS NULL OR D.NMD_CUST_FLG != 'Y')" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
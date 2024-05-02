/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchStatusByTPBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusInquiryDBDAOSearchStatusByTPBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStatusByTPB
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchStatusByTPBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_n3pty_src_sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3pty_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_overdue",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ots_amt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_stl_to_clt_cng_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_clt_cng_ofc_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_no_search",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bl_no_all",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ots_sts_cd_detail_open",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_curr_cd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no_all",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ots_amt_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchStatusByTPBRSQL").append("\n"); 
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
		query.append("SELECT   T.N3PTY_NO" ).append("\n"); 
		query.append("       , T.N3PTY_NO_DP_SEQ" ).append("\n"); 
		query.append("       , T.OFC_CD" ).append("\n"); 
		query.append("       , T.N3PTY_SRC_SUB_SYS_CD" ).append("\n"); 
		query.append("       , T.N3PTY_INV_NO" ).append("\n"); 
		query.append("       , T.INV_ISS_DT" ).append("\n"); 
		query.append("       , T.N3PTY_SRC_NO" ).append("\n"); 
		query.append("       , T.BKG_NO_ALL" ).append("\n"); 
		query.append("       , T.BL_NO_ALL" ).append("\n"); 
		query.append("       , T.VVD" ).append("\n"); 
		query.append("       , T.EQ_NO" ).append("\n"); 
		query.append("       , T.N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("       , T.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("       , T.TRD_PARTY_TYPE" ).append("\n"); 
		query.append("       , T.TRD_PARTY_CODE" ).append("\n"); 
		query.append("       , T.TRD_PARTY_NAME" ).append("\n"); 
		query.append("       , T.CLT_ACT_YN" ).append("\n"); 
		query.append("       , T.OTS_STS_NM" ).append("\n"); 
		query.append("       , T.OVERDUE" ).append("\n"); 
		query.append("       , DECODE(@[s_curr_cd_tp],'U','USD',DECODE(T.CURR_CD,'USD',T.BIL_CURR_CD, T.CURR_CD)) AS CURR_CD" ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(T.OTS_AMT,T.CURR_CD, T.RATE_DT + T.GMT_GAP) AS OTS_AMT" ).append("\n"); 
		query.append("       , DECODE(T.CURR_CD,'USD',T.INV_AMT,TPB_GET_USD_AMT_FNC(T.INV_AMT,T.CURR_CD,T.RATE_DT + T.GMT_GAP)) AS INV_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(T.CLT_AMT,T.CURR_CD, T.RATE_DT + T.GMT_GAP) AS CLT_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(T.ADJ_AMT,T.CURR_CD, T.RATE_DT + T.GMT_GAP) AS STL_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(T.BAL_AMT,T.CURR_CD, T.RATE_DT + T.GMT_GAP) AS BAL_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(T.ADD_AMT, T.INV_CURR, T.RATE_DT + T.GMT_GAP) AS ADD_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(T.DDCT_AMT,T.INV_CURR, T.RATE_DT + T.GMT_GAP) AS DDCT_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(T.VAT_AMT, T.INV_CURR, T.RATE_DT + T.GMT_GAP) AS VAT_AMT    " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("       , NVL(DECODE(T.CURR_CD,'USD',ROUND(T.OTS_AMT * TPB_GET_USD_XCH_RT_FNC(T.BIL_CURR_CD,TPB_GET_LCL_DATE_FNC(T.RATE_DT,T.OFC_CD)) ,2),T.OTS_AMT),0.0) AS OTS_AMT" ).append("\n"); 
		query.append("       , NVL(DECODE(T.CURR_CD,'USD',ROUND(T.INV_AMT * TPB_GET_USD_XCH_RT_FNC(T.BIL_CURR_CD,TPB_GET_LCL_DATE_FNC(T.RATE_DT,T.OFC_CD)) ,2),T.INV_AMT),0.0) AS INV_AMT" ).append("\n"); 
		query.append("       , NVL(DECODE(T.CURR_CD,'USD',ROUND(T.CLT_AMT * TPB_GET_USD_XCH_RT_FNC(T.BIL_CURR_CD,TPB_GET_LCL_DATE_FNC(T.RATE_DT,T.OFC_CD)) ,2),T.CLT_AMT),0.0) AS CLT_AMT" ).append("\n"); 
		query.append("       , NVL(DECODE(T.CURR_CD,'USD',ROUND(T.ADJ_AMT * TPB_GET_USD_XCH_RT_FNC(T.BIL_CURR_CD,TPB_GET_LCL_DATE_FNC(T.RATE_DT,T.OFC_CD)) ,2),T.ADJ_AMT),0.0) AS STL_AMT" ).append("\n"); 
		query.append("       , NVL(DECODE(T.CURR_CD,'USD',ROUND(T.BAL_AMT * TPB_GET_USD_XCH_RT_FNC(T.BIL_CURR_CD,TPB_GET_LCL_DATE_FNC(T.RATE_DT,T.OFC_CD)) ,2),T.BAL_AMT),0.0) AS BAL_AMT" ).append("\n"); 
		query.append("       , NVL(DECODE(T.INV_CURR,'USD',ROUND(T.ADD_AMT * TPB_GET_USD_XCH_RT_FNC(T.BIL_CURR_CD,TPB_GET_LCL_DATE_FNC(T.RATE_DT,T.OFC_CD)) ,2),T.ADD_AMT),0.0) AS ADD_AMT" ).append("\n"); 
		query.append("       , NVL(DECODE(T.INV_CURR,'USD',ROUND(T.DDCT_AMT * TPB_GET_USD_XCH_RT_FNC(T.BIL_CURR_CD,TPB_GET_LCL_DATE_FNC(T.RATE_DT,T.OFC_CD)) ,2),T.DDCT_AMT),0.0) AS DDCT_AMT" ).append("\n"); 
		query.append("       , NVL(DECODE(T.INV_CURR,'USD',ROUND(T.VAT_AMT * TPB_GET_USD_XCH_RT_FNC(T.BIL_CURR_CD,TPB_GET_LCL_DATE_FNC(T.RATE_DT,T.OFC_CD)) ,2),T.VAT_AMT),0.0) AS VAT_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , T.IF_USR_ID" ).append("\n"); 
		query.append("       , T.IF_USR_NM" ).append("\n"); 
		query.append("       , T.IF_OFC_CD" ).append("\n"); 
		query.append("       , T.IF_DT" ).append("\n"); 
		query.append("       , T.N3PTY_STL_TP_CD" ).append("\n"); 
		query.append("       , T.STL_RQST_OFC_CD" ).append("\n"); 
		query.append("       , T.STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append("       , T.FM_CLT_CNG_OFC_N3PTY_NO" ).append("\n"); 
		query.append("       , T.EDN_TP_NM" ).append("\n"); 
		query.append("       , T.CSR_NO" ).append("\n"); 
		query.append("       , T.OTS_STS_CD" ).append("\n"); 
		query.append("       , T.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("       , TO_CHAR(T.CFM_DT + T.GMT_GAP,'YYYY-MM-DD') AS CFM_DT" ).append("\n"); 
		query.append("       , T.SO_IF_SEQ" ).append("\n"); 
		query.append("       , T.CRE_DT" ).append("\n"); 
		query.append("       , T.CONTRACT_NO, T.CONTRACT_OFC" ).append("\n"); 
		query.append("       , T.POR_CD" ).append("\n"); 
		query.append("       , T.POL_CD" ).append("\n"); 
		query.append("       , T.POD_CD" ).append("\n"); 
		query.append("       , T.DEL_CD" ).append("\n"); 
		query.append("       , T.RCV_TERM_CD" ).append("\n"); 
		query.append("       , T.DE_TERM_CD" ).append("\n"); 
		query.append("FROM     (       " ).append("\n"); 
		query.append("           SELECT   /*+ USE_NL( B A) NO_MERGE(S) */" ).append("\n"); 
		query.append("                    B.N3PTY_NO" ).append("\n"); 
		query.append("                  , A.N3PTY_NO_DP_SEQ" ).append("\n"); 
		query.append("                  , B.OFC_CD" ).append("\n"); 
		query.append("                  , A.N3PTY_SRC_SUB_SYS_CD" ).append("\n"); 
		query.append("                  , B.N3PTY_INV_NO" ).append("\n"); 
		query.append("                  , NVL2( B.N3PTY_INV_NO, (" ).append("\n"); 
		query.append("                                            SELECT   TO_CHAR(R.INV_UPD_GDT + S.GMT_GAP,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("                                            FROM     TPB_INVOICE V" ).append("\n"); 
		query.append("                                                   , TPB_INV_RVIS R" ).append("\n"); 
		query.append("                                            WHERE    1 = 1" ).append("\n"); 
		query.append("                                            AND      V.N3PTY_INV_NO = R.N3PTY_INV_NO" ).append("\n"); 
		query.append("                                            AND      V.LST_N3PTY_INV_RVIS_SEQ = R.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("                                            AND      V.N3PTY_INV_NO = B.N3PTY_INV_NO" ).append("\n"); 
		query.append("                                            AND      ROWNUM = 1" ).append("\n"); 
		query.append("                                          ), NULL" ).append("\n"); 
		query.append("                    ) AS INV_ISS_DT" ).append("\n"); 
		query.append("                  , A.N3PTY_SRC_NO" ).append("\n"); 
		query.append("                  , A.BKG_NO AS BKG_NO_ALL" ).append("\n"); 
		query.append("                  , A.BL_NO AS BL_NO_ALL" ).append("\n"); 
		query.append("                  , DECODE(B.N3PTY_BIL_TP_CD, 'JO', A.VVD_CD, B.VSL_CD || B.SKD_VOY_NO || SUBSTR(B.FINC_DIR_CD,1,1)) AS VVD" ).append("\n"); 
		query.append("                  , A.EQ_NO" ).append("\n"); 
		query.append("                  , TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("                  , CASE B.VNDR_CUST_DIV_CD WHEN 'V' THEN LPAD(TO_CHAR(B.VNDR_SEQ),6,'0')" ).append("\n"); 
		query.append("                                            WHEN 'C' THEN B.CUST_CNT_CD || LPAD(B.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("                                            WHEN 'S' THEN B.N3PTY_OFC_CD " ).append("\n"); 
		query.append("                    END AS TRD_PARTY_CODE" ).append("\n"); 
		query.append("                  , CASE B.VNDR_CUST_DIV_CD WHEN 'V' THEN A.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("                                            WHEN 'C' THEN A.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("                                            WHEN 'S' THEN B.N3PTY_OFC_CD " ).append("\n"); 
		query.append("                    END AS TRD_PARTY_NAME" ).append("\n"); 
		query.append("                  , CASE B.VNDR_CUST_DIV_CD WHEN 'V' THEN 'Vendor'" ).append("\n"); 
		query.append("                                            WHEN 'C' THEN 'Customer'" ).append("\n"); 
		query.append("                                            WHEN 'S' THEN 'Staff' " ).append("\n"); 
		query.append("                    END AS TRD_PARTY_TYPE" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM TPB_OTS_GRP_RCVR_ACT WHERE N3PTY_NO = B.N3PTY_NO AND N3PTY_CLT_RMK_TP_CD = 'M' AND ROWNUM = 1 ) AS CLT_ACT_YN" ).append("\n"); 
		query.append("                  , CASE WHEN C.OTS_STS_CD IN ('R','T','J') THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD02799',B.OTS_STS_DTL_CD)" ).append("\n"); 
		query.append("                         ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',C.OTS_STS_CD)" ).append("\n"); 
		query.append("                    END AS OTS_STS_NM" ).append("\n"); 
		query.append("                  , CASE WHEN (" ).append("\n"); 
		query.append("                                SELECT   COUNT(1)" ).append("\n"); 
		query.append("                                FROM     TPB_OTS_GRP_STS" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      OTS_STS_CD = 'E'" ).append("\n"); 
		query.append("                                AND      OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("                                AND      N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("                                AND      OTS_STS_SEQ = ( SELECT MAX(OTS_STS_SEQ) FROM TPB_OTS_GRP_STS WHERE N3PTY_NO = B.N3PTY_NO )" ).append("\n"); 
		query.append("                              ) = 0 AND ( SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO ) = 0 THEN TRUNC(SYSDATE - B.CFM_DT)" ).append("\n"); 
		query.append("                         ELSE TRUNC(SYSDATE - (SELECT MAX(CRE_DT) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO) )" ).append("\n"); 
		query.append("                    END AS OVERDUE" ).append("\n"); 
		query.append("                  , B.OTS_AMT" ).append("\n"); 
		query.append("                  , B.INV_AMT" ).append("\n"); 
		query.append("                  , B.CLT_AMT" ).append("\n"); 
		query.append("                  , B.ADJ_AMT" ).append("\n"); 
		query.append("                  , B.BAL_AMT" ).append("\n"); 
		query.append("                  , S.GMT_GAP" ).append("\n"); 
		query.append("                  , B.CURR_CD" ).append("\n"); 
		query.append("                  , ( SELECT O.BIL_CURR_CD FROM MDM_ORGANIZATION O WHERE O.OFC_CD = B.OFC_CD ) AS BIL_CURR_CD" ).append("\n"); 
		query.append("                  , CASE WHEN C.OTS_STS_CD IN ( 'D', 'E', 'L', 'A' ) THEN B.CFM_DT ELSE SYSDATE END AS RATE_DT" ).append("\n"); 
		query.append("                  , B.CRE_USR_ID AS IF_USR_ID" ).append("\n"); 
		query.append("                  , ( SELECT U.USR_NM FROM COM_USER U WHERE USR_ID = B.CRE_USR_ID AND USE_FLG = 'Y' AND ROWNUM = 1 ) AS IF_USR_NM" ).append("\n"); 
		query.append("                  , A.IF_OFC_CD AS IF_OFC_CD" ).append("\n"); 
		query.append("                  , TO_CHAR(A.IF_DT,'YYYY-MM-DD HH24:MI') AS IF_DT" ).append("\n"); 
		query.append("                  , ( SELECT COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00589',N3PTY_STL_TP_CD) FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' ) AS N3PTY_STL_TP_CD" ).append("\n"); 
		query.append("                  , ( SELECT STL_RQST_OFC_CD FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' AND E.N3PTY_STL_TP_CD = 'O' ) AS STL_RQST_OFC_CD" ).append("\n"); 
		query.append("                  , ( SELECT STL_TO_CLT_CNG_OFC_CD FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' AND E.N3PTY_STL_TP_CD = 'O' ) AS STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append("                  , A.FM_CLT_CNG_OFC_N3PTY_NO" ).append("\n"); 
		query.append("                  , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00587', A.EAC_TP_CD) AS EDN_TP_NM" ).append("\n"); 
		query.append("                  , DECODE(A.N3PTY_BIL_TP_CD,'JO',A.CSR_NO,NULL) AS CSR_NO" ).append("\n"); 
		query.append("                  , C.OTS_STS_CD" ).append("\n"); 
		query.append("                  , B.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("                  , A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("                  , B.CFM_DT" ).append("\n"); 
		query.append("                  , 0 AS SO_IF_SEQ" ).append("\n"); 
		query.append("                  , TO_CHAR(B.CRE_DT,'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("                  , (SELECT NVL(BB.SC_NO,NVL(BB.RFA_NO,'')) FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS CONTRACT_NO" ).append("\n"); 
		query.append("                  , (SELECT BB.CTRT_OFC_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS CONTRACT_OFC" ).append("\n"); 
		query.append("                  , (SELECT BB.POR_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS POR_CD" ).append("\n"); 
		query.append("                  , (SELECT BB.POL_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS POL_CD" ).append("\n"); 
		query.append("                  , (SELECT BB.POD_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS POD_CD" ).append("\n"); 
		query.append("                  , (SELECT BB.DEL_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS DEL_CD" ).append("\n"); 
		query.append("                  , (SELECT BB.RCV_TERM_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS RCV_TERM_CD" ).append("\n"); 
		query.append("                  , (SELECT BB.DE_TERM_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS DE_TERM_CD" ).append("\n"); 
		query.append("                  , R.CURR_CD AS INV_CURR" ).append("\n"); 
		query.append("                  , R.ADD_AMT" ).append("\n"); 
		query.append("                  , R.DDCT_AMT" ).append("\n"); 
		query.append("                  , R.VAT_AMT" ).append("\n"); 
		query.append("           FROM     TPB_OTS_GRP B" ).append("\n"); 
		query.append("                  , TPB_OTS_DTL A" ).append("\n"); 
		query.append("                  , TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("                  , TPB_INV_RVIS R" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   OFC_CD" ).append("\n"); 
		query.append("                             , MDM_LOCATION.LOC_CD" ).append("\n"); 
		query.append("                             , SYSDATE" ).append("\n"); 
		query.append("                             , GLOBALDATE_PKG.TIME_CONV_FNC('GMT', SYSDATE - ( 9 / 24 ), MDM_LOCATION.LOC_CD ) AS GMT_DT" ).append("\n"); 
		query.append("                             , GLOBALDATE_PKG.TIME_CONV_FNC('GMT', SYSDATE - ( 9 / 24 ), MDM_LOCATION.LOC_CD ) - SYSDATE AS GMT_GAP" ).append("\n"); 
		query.append("                      FROM     MDM_LOCATION" ).append("\n"); 
		query.append("                             , MDM_ORGANIZATION" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MDM_LOCATION.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      AND      MDM_LOCATION.LOC_CD = MDM_ORGANIZATION.LOC_CD " ).append("\n"); 
		query.append("                      AND      MDM_ORGANIZATION.OFC_CD = @[s_user_ofc_cd]" ).append("\n"); 
		query.append("                    ) S" ).append("\n"); 
		query.append("           WHERE    1 = 1 " ).append("\n"); 
		query.append("           AND      B.N3PTY_NO = C.N3PTY_NO " ).append("\n"); 
		query.append("           AND      B.N3PTY_NO = A.N3PTY_NO" ).append("\n"); 
		query.append("           AND      NVL(B.N3PTY_INV_NO,'X') = R.N3PTY_INV_NO(+)" ).append("\n"); 
		query.append("           AND      ( SELECT NVL(MAX(R2.N3PTY_INV_RVIS_SEQ), 1) FROM TPB_INV_RVIS R2 WHERE R2.N3PTY_INV_NO = NVL(B.N3PTY_INV_NO,'X') ) = NVL(R.N3PTY_INV_RVIS_SEQ, 1)" ).append("\n"); 
		query.append("           AND      B.N3PTY_DELT_TP_CD IN ('N','C','S') " ).append("\n"); 
		query.append("           AND      C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("#if (${bkg_cntr_no} != 'S') " ).append("\n"); 
		query.append("           AND      A.N3PTY_NO_DP_SEQ = 1 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND      B.OFC_CD IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   OFC_CD " ).append("\n"); 
		query.append("                      FROM     TPB_HNDL_OFC " ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      N3PTY_OFC_TP_CD = 'T'" ).append("\n"); 
		query.append("                      AND      DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      AND      RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("    #if (${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("                      AND      OFC_CD IN ( SELECT OFC_CD FROM TPB_HNDL_OFC WHERE N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd] )" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    #if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("                      AND      OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end                   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_ots_sts_cd_detail_close} != 'S')" ).append("\n"); 
		query.append("           AND      A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND      A.N3PTY_BIL_TP_CD IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   N3PTY_BIL_TP_CD " ).append("\n"); 
		query.append("                      FROM     TPB_N3RD_PTY_BIL_TP " ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      N3PTY_BIL_TP_CD != 'JO'" ).append("\n"); 
		query.append("#if (${s_if_type} == 'R')" ).append("\n"); 
		query.append("                      AND      N3PTY_IF_TP_CD IN ('R')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                      AND      N3PTY_IF_TP_CD IN ('M','S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#if (${s_n3pty_src_sub_sys_cd} != '')" ).append("\n"); 
		query.append("           AND      A.N3PTY_SRC_SUB_SYS_CD = @[s_n3pty_src_sub_sys_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_bil_tp_cd} != '')" ).append("\n"); 
		query.append("           AND      A.N3PTY_BIL_TP_CD = @[s_n3pty_bil_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_inv_no} != '')" ).append("\n"); 
		query.append("           AND      B.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_overdue} != '')" ).append("\n"); 
		query.append("           AND      CASE WHEN ( SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'E' AND N3PTY_NO = B.N3PTY_NO  AND OTS_STS_LST_FLG = 'Y') = 0 AND ( SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO) = 0 THEN TRUNC(SYSDATE - B.CFM_DT)" ).append("\n"); 
		query.append("                         ELSE TRUNC(SYSDATE - (SELECT MAX(CRE_DT) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO) )" ).append("\n"); 
		query.append("                    END >= @[s_overdue]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bkg_no_all} != '')" ).append("\n"); 
		query.append("           AND      EXISTS" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   'X'" ).append("\n"); 
		query.append("                      FROM     TPB_OTS_DTL BD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      BD.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("                      AND      BD.BKG_NO = @[s_bkg_no_all]" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bl_no_all} != '')" ).append("\n"); 
		query.append("           AND      EXISTS" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   'X'" ).append("\n"); 
		query.append("                      FROM     TPB_OTS_DTL BD " ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      BD.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("                      AND      BD.BL_NO = @[s_bl_no_all]" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vvd} != '')" ).append("\n"); 
		query.append("           AND      B.VSL_CD || B.SKD_VOY_NO || SUBSTR(B.FINC_DIR_CD,1,1) = @[s_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_src_no} != '')" ).append("\n"); 
		query.append("           AND      A.N3PTY_SRC_NO = @[s_n3pty_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_no_search} != '')" ).append("\n"); 
		query.append("           AND      B.N3PTY_NO = @[s_n3pty_no_search]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_edn_tp_cd} == 'A')" ).append("\n"); 
		query.append("           AND      A.EAC_TP_CD != 'N'" ).append("\n"); 
		query.append("#elseif (${s_edn_tp_cd} != '')" ).append("\n"); 
		query.append("           AND      A.EAC_TP_CD = @[s_edn_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("	 #if (${s_ots_amt_from} != '')" ).append("\n"); 
		query.append("           AND      TPB_GET_USD_AMT_FNC(B.OTS_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) >= @[s_ots_amt_from]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${s_ots_amt_to} != '')" ).append("\n"); 
		query.append("           AND      TPB_GET_USD_AMT_FNC(B.OTS_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) <= @[s_ots_amt_to]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 #if (${s_ots_amt_from} != '')" ).append("\n"); 
		query.append("           AND      NVL(TPB_GET_LOCL_AMT_FNC(B.OTS_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)),0.0) >= @[s_ots_amt_from]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${s_ots_amt_to} != '')" ).append("\n"); 
		query.append("           AND      NVL(TPB_GET_LOCL_AMT_FNC(B.OTS_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)),0.0) <= @[s_ots_amt_to]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_csr_no} != '')" ).append("\n"); 
		query.append("           AND      A.CSR_NO = @[s_csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_eq_no} != '')" ).append("\n"); 
		query.append("           AND      EXISTS" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   'X'" ).append("\n"); 
		query.append("                      FROM     TPB_OTS_DTL BD " ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      BD.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("                      AND      BD.EQ_NO = @[s_eq_no]" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_fm_clt_cng_ofc_n3pty_no} != '')" ).append("\n"); 
		query.append("           AND      EXISTS ( SELECT 0 FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' AND E.N3PTY_STL_TP_CD = 'O' AND E.STL_RQST_OFC_CD = @[s_fm_clt_cng_ofc_n3pty_no] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_stl_to_clt_cng_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND      EXISTS ( SELECT 0 FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' AND E.N3PTY_STL_TP_CD = 'O' AND E.STL_TO_CLT_CNG_OFC_CD = @[s_stl_to_clt_cng_ofc_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("           AND      A.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("		#if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("			#if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("           AND      A.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("			#elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("           AND      A.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("				#if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("           AND      A.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("           AND      A.N3PTY_OFC_CD = @[s_trd_party_val]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_ots_sts_cd} != 'T')" ).append("\n"); 
		query.append("           AND      ( C.OTS_STS_CRE_DT >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_user_ofc_cd]) AND C.OTS_STS_CRE_DT < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_user_ofc_cd])+1)" ).append("\n"); 
		query.append("	#if (${s_ots_sts_cd} == 'P')" ).append("\n"); 
		query.append("           AND      ( ( C.OTS_STS_CD = 'D' AND A.N3PTY_DELT_TP_CD IN ('S','C') ) OR ( C.OTS_STS_CD IN ('E','L','A') AND A.N3PTY_DELT_TP_CD = 'N' ) )" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("     #if (${s_ots_sts_cd_detail_close} == 'E')" ).append("\n"); 
		query.append("           AND      C.OTS_STS_CD = 'E' " ).append("\n"); 
		query.append("           AND      A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("     #elseif (${s_ots_sts_cd_detail_close} == 'L')" ).append("\n"); 
		query.append("           AND      C.OTS_STS_CD IN ('L','A') " ).append("\n"); 
		query.append("           AND      A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("     #elseif (${s_ots_sts_cd_detail_close} == 'D')" ).append("\n"); 
		query.append("           AND      C.OTS_STS_CD = 'D' " ).append("\n"); 
		query.append("           AND      A.N3PTY_DELT_TP_CD = 'C'" ).append("\n"); 
		query.append("     #elseif (${s_ots_sts_cd_detail_close} == 'S') " ).append("\n"); 
		query.append("           AND      C.OTS_STS_CD = 'D' " ).append("\n"); 
		query.append("           AND      A.N3PTY_DELT_TP_CD = 'S'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND      C.OTS_STS_CD NOT IN ('D','E','L','A')" ).append("\n"); 
		query.append("           AND      A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("     #if (${s_ots_sts_cd_detail_open} != 'ALL')" ).append("\n"); 
		query.append("           AND      C.OTS_STS_CD = @[s_ots_sts_cd_detail_open]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ) T" ).append("\n"); 
		query.append("ORDER BY T.N3PTY_NO" ).append("\n"); 
		query.append("       , T.N3PTY_NO_DP_SEQ" ).append("\n"); 

	}
}
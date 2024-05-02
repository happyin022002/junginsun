/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchActivityByConfirmedTPBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.25 
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

public class StatusInquiryDBDAOSearchActivityByConfirmedTPBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당점소의 조회기간내에 Confirm된 TPB를 조회한다
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchActivityByConfirmedTPBRSQL(){
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
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchActivityByConfirmedTPBRSQL").append("\n"); 
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
		query.append("SELECT   *" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   B.N3PTY_NO" ).append("\n"); 
		query.append("                  , ROWNUM AS N3PTY_NO_DP_SEQ" ).append("\n"); 
		query.append("                  , ( SELECT RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = A.CFM_OFC_CD AND DELT_FLG = 'N' AND N3PTY_OFC_TP_CD = 'T') AS RHQ" ).append("\n"); 
		query.append("                  , A.CFM_OFC_CD" ).append("\n"); 
		query.append("                  , A.N3PTY_SRC_SUB_SYS_CD" ).append("\n"); 
		query.append("                  , B.N3PTY_INV_NO" ).append("\n"); 
		query.append("                  , NVL2( B.N3PTY_INV_NO, (" ).append("\n"); 
		query.append("                                            SELECT   TO_CHAR(TPB_GET_LCL_DATE_FNC(R.INV_UPD_GDT, @[s_user_ofc_cd]), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("                                            FROM     TPB_INVOICE V" ).append("\n"); 
		query.append("                                                   , TPB_INV_RVIS R" ).append("\n"); 
		query.append("                                            WHERE    1 = 1" ).append("\n"); 
		query.append("                                            AND      V.N3PTY_INV_NO = R.N3PTY_INV_NO" ).append("\n"); 
		query.append("                                            AND      V.LST_N3PTY_INV_RVIS_SEQ = R.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("                                            AND      V.N3PTY_INV_NO=B.N3PTY_INV_NO" ).append("\n"); 
		query.append("                                            AND      ROWNUM = 1" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("                                        , NULL" ).append("\n"); 
		query.append("                    ) AS INV_ISS_DT" ).append("\n"); 
		query.append("                  , A.N3PTY_SRC_NO" ).append("\n"); 
		query.append("                  , A.BKG_NO AS BKG_NO_ALL" ).append("\n"); 
		query.append("                  , A.BL_NO AS BL_NO_ALL" ).append("\n"); 
		query.append("                  , DECODE(B.N3PTY_BIL_TP_CD, 'JO', A.VVD_CD, B.VSL_CD || B.SKD_VOY_NO || SUBSTR(A.FINC_DIR_CD, 1, 1)) AS VVD" ).append("\n"); 
		query.append("                  , A.EQ_NO" ).append("\n"); 
		query.append("                  , TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("                  , CASE B.VNDR_CUST_DIV_CD WHEN 'V' THEN LPAD(TO_CHAR(B.VNDR_SEQ), 6, '0') WHEN 'C' THEN B.CUST_CNT_CD || LPAD(B.CUST_SEQ, 6, '0') WHEN 'S' THEN B.N3PTY_OFC_CD END AS TRD_PARTY_CODE" ).append("\n"); 
		query.append("                  , CASE B.VNDR_CUST_DIV_CD WHEN 'V' THEN A.VNDR_LGL_ENG_NM WHEN 'C' THEN A.CUST_LGL_ENG_NM WHEN 'S' THEN B.N3PTY_OFC_CD END AS TRD_PARTY_NAME" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   COUNT(1)" ).append("\n"); 
		query.append("                      FROM     TPB_OTS_GRP_RCVR_ACT" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("                      AND      N3PTY_CLT_RMK_TP_CD = 'M'" ).append("\n"); 
		query.append("                      AND      ROWNUM = 1" ).append("\n"); 
		query.append("                    ) AS CLT_ACT_YN" ).append("\n"); 
		query.append("                  , CASE WHEN C.OTS_STS_CD IN ('R','T','J') THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD02799',B.OTS_STS_DTL_CD)" ).append("\n"); 
		query.append("                         ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',C.OTS_STS_CD)" ).append("\n"); 
		query.append("                    END AS OTS_STS_NM" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   CASE WHEN COUNT(1) = 0 THEN TRUNC(SYSDATE - B.CFM_DT) ELSE TRUNC(SYSDATE - MAX(CRE_DT)) END" ).append("\n"); 
		query.append("                      FROM     TPB_OTS_GRP_STS" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      OTS_STS_CD = 'T'" ).append("\n"); 
		query.append("                      AND      N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("                    ) AS OVERDUE" ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("                  , TPB_GET_USD_AMT_FNC(B.OTS_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS OTS_AMT" ).append("\n"); 
		query.append("                  , TPB_GET_USD_AMT_FNC(B.INV_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS INV_AMT" ).append("\n"); 
		query.append("                  , TPB_GET_USD_AMT_FNC(B.CLT_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS CLT_AMT" ).append("\n"); 
		query.append("                  , TPB_GET_USD_AMT_FNC(B.ADJ_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS STL_AMT" ).append("\n"); 
		query.append("                  , TPB_GET_USD_AMT_FNC(B.BAL_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS BAL_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                  , NVL(DECODE(B.CURR_CD,'USD',ROUND(B.OTS_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.OTS_AMT),0.0) AS OTS_AMT" ).append("\n"); 
		query.append("                  , NVL(DECODE(B.CURR_CD,'USD',ROUND(B.INV_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.INV_AMT),0.0) AS INV_AMT" ).append("\n"); 
		query.append("                  , NVL(DECODE(B.CURR_CD,'USD',ROUND(B.CLT_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.CLT_AMT),0.0) AS CLT_AMT" ).append("\n"); 
		query.append("                  , NVL(DECODE(B.CURR_CD,'USD',ROUND(B.ADJ_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.ADJ_AMT),0.0) AS STL_AMT" ).append("\n"); 
		query.append("                  , NVL(DECODE(B.CURR_CD,'USD',ROUND(B.BAL_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.BAL_AMT),0.0) AS BAL_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  , B.CRE_USR_ID AS IF_USR_ID" ).append("\n"); 
		query.append("                  , A.IF_OFC_CD AS IF_OFC_CD" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00589', N3PTY_STL_TP_CD)" ).append("\n"); 
		query.append("                      FROM     TPB_ADJ_STS E" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      E.N3PTY_NO=A.N3PTY_NO" ).append("\n"); 
		query.append("                      AND      E.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("                    ) AS N3PTY_STL_TP_CD" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   STL_RQST_OFC_CD" ).append("\n"); 
		query.append("                      FROM     TPB_ADJ_STS E" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      E.N3PTY_NO=A.N3PTY_NO" ).append("\n"); 
		query.append("                      AND      E.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("                      AND      E.N3PTY_STL_TP_CD = 'O'" ).append("\n"); 
		query.append("                    ) AS STL_RQST_OFC_CD" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append("                      FROM     TPB_ADJ_STS E" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      E.N3PTY_NO=A.N3PTY_NO" ).append("\n"); 
		query.append("                      AND      E.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("                      AND      E.N3PTY_STL_TP_CD = 'O'" ).append("\n"); 
		query.append("                    ) AS STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append("                  , A.FM_CLT_CNG_OFC_N3PTY_NO" ).append("\n"); 
		query.append("                  , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00587', A.EAC_TP_CD) AS EDN_TP_NM" ).append("\n"); 
		query.append("                  , CASE WHEN A.N3PTY_BIL_TP_CD = 'JO' THEN A.CSR_NO ELSE NULL END AS CSR_NO" ).append("\n"); 
		query.append("                  , C.OTS_STS_CD" ).append("\n"); 
		query.append("                  , B.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("                  ----조회 기준 통화 : 조회office의 Local통화 와 USD  " ).append("\n"); 
		query.append("                  , CASE WHEN @[s_curr_cd_tp] = 'U' THEN 'USD'" ).append("\n"); 
		query.append("                         ELSE (" ).append("\n"); 
		query.append("                                SELECT  NVL(MAX(O.BIL_CURR_CD), B.CURR_CD)" ).append("\n"); 
		query.append("                                FROM    MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                                WHERE   1 = 1" ).append("\n"); 
		query.append("                                AND     O.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                    END AS CURR_CD" ).append("\n"); 
		query.append("                  , A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("                  , TO_CHAR(TPB_GET_LCL_DATE_FNC(B.CFM_DT, @[s_user_ofc_cd]), 'YYYY-MM-DD') AS CFM_DT" ).append("\n"); 
		query.append("                  , TO_CHAR(TO_DATE(SUBSTR(B.N3PTY_NO,7,4),'YYMM'),'YY-MM') AS CFM_MON" ).append("\n"); 
		query.append("                  , 0 AS SO_IF_SEQ" ).append("\n"); 
		query.append("                  , TO_CHAR(B.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("           FROM     TPB_OTS_GRP B" ).append("\n"); 
		query.append("                  , TPB_OTS_DTL A" ).append("\n"); 
		query.append("                  , TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("--[Inquiry Option Start]----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("--1.RHQ/C.OFFICE/OFFICE: <Default:로그인 Office> " ).append("\n"); 
		query.append("----RHQ --- All(회사전체)/HAMUR/NYCNA/SHAAS/SINWA" ).append("\n"); 
		query.append("----Control Office --- TPB에서 구성한 Hierarchy 기준의 산하 office(All포함)" ).append("\n"); 
		query.append("----Office --- Candidate를 confirm한 office (주의-responsible office가 아님)" ).append("\n"); 
		query.append("           AND      A.CFM_OFC_CD IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   OFC_CD" ).append("\n"); 
		query.append("                      FROM     TPB_HNDL_OFC" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      N3PTY_OFC_TP_CD = 'T'" ).append("\n"); 
		query.append("                      AND      DELT_FLG = 'N'" ).append("\n"); 
		query.append("                #if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("                      AND      RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("				#if (${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("                      AND      OFC_CD IN" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                 SELECT   OFC_CD" ).append("\n"); 
		query.append("                                 FROM     TPB_HNDL_OFC" ).append("\n"); 
		query.append("                                 WHERE    N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("				#if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("                      AND      OFC_CD = @[s_if_ofc_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("--2.Confirmed Date <Default: 1달, 최장 1년>" ).append("\n"); 
		query.append("--  AND TO_CHAR(TPB_GET_LCL_DATE_FNC(A.CFM_DT, 'HAMBB'), 'YYYY-MM-DD') BETWEEN  '2010-01-01' AND '2010-12-31'  " ).append("\n"); 
		query.append("--[Inquiry Option End]------------------------------------------------------------------------------------------------------------------  " ).append("\n"); 
		query.append("#if (${s_if_type} == 'S')" ).append("\n"); 
		query.append("           AND      A.N3PTY_BIL_TP_CD IN ( SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE N3PTY_IF_TP_CD IN ('S','M') )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND      A.N3PTY_BIL_TP_CD IN ( SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE N3PTY_IF_TP_CD = 'R' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND      A.N3PTY_BIL_TP_CD NOT IN ('JO')" ).append("\n"); 
		query.append("           AND      A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("           AND      A.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("           AND      TO_DATE(SUBSTR(B.N3PTY_NO,7,4),'YYMM') BETWEEN TO_DATE(@[s_sdate],'YYMM') AND TO_DATE(@[s_edate],'YYMM')" ).append("\n"); 
		query.append("           AND      B.N3PTY_NO = A.N3PTY_NO" ).append("\n"); 
		query.append("           AND      B.N3PTY_DELT_TP_CD IN ('N','C','S')" ).append("\n"); 
		query.append("           AND      C.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("           AND      C.OTS_STS_LST_FLG = 'Y'            " ).append("\n"); 
		query.append("         ) D" ).append("\n"); 
		query.append("ORDER BY D.N3PTY_NO_DP_SEQ" ).append("\n"); 
		query.append("       , D.N3PTY_NO" ).append("\n"); 

	}
}
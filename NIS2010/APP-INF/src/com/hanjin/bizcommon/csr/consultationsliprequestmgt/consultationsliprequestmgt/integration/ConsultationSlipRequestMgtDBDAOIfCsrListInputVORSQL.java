/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOIfCsrListInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOIfCsrListInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.08.31 김영철 [CHM-201005571-01] [VOP-PSO] 공통 CSR내 Invoice 조건 칼럼 추가요청건(INV_NO로 조회부분 수정)
	  * 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 쿼리 수정
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOIfCsrListInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOIfCsrListInputVORSQL").append("\n"); 
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
		query.append("SELECT   B.IF_DT" ).append("\n"); 
		query.append("       , B.CSR_NO" ).append("\n"); 
		query.append("       , (SELECT DECODE(VNDR_CNT_CD,'KR',VNDR_LOCL_LANG_NM,VNDR_LGL_ENG_NM)" ).append("\n"); 
		query.append("         FROM    MDM_VENDOR" ).append("\n"); 
		query.append("         WHERE   VNDR_SEQ = B.VNDR_NO" ).append("\n"); 
		query.append("         ) INV_DESC" ).append("\n"); 
		query.append("       , B.CSR_CURR_CD" ).append("\n"); 
		query.append("       , B.CSR_AMT" ).append("\n"); 
		query.append("       , B.DUE_DT" ).append("\n"); 
		query.append("       , B.IF_STATUS" ).append("\n"); 
		query.append("       , B.ATTR_CTNT2" ).append("\n"); 
		query.append("       , B.IF_ERR_RSN" ).append("\n"); 
		query.append("       , TO_CHAR(B.VNDR_NO, '000000') VNDR_NO" ).append("\n"); 
		query.append("       , B.VNDR_TERM_NM" ).append("\n"); 
		query.append("       , B.AFT_ACT_FLG" ).append("\n"); 
		query.append("       , TO_CHAR(MAX(B.INV_ISS_DT),'YYYY-MM-DD') INV_ISS_DT" ).append("\n"); 
		query.append("       , TO_CHAR(MAX(B.INV_RCV_DT),'YYYY-MM-DD') INV_RCV_DT" ).append("\n"); 
		query.append("       , COUNT(B.CSR_NO) NO_OF_INV" ).append("\n"); 
		query.append("       , B.IF_FLG" ).append("\n"); 
		query.append("       , B.RCV_ERR_FLG" ).append("\n"); 
		query.append("       , B.APRO_RQST_NO" ).append("\n"); 
		query.append("       , B.PAY_GRP_LU_CD" ).append("\n"); 
		query.append("       , B.COST_OFC_CD " ).append("\n"); 
		query.append("       ,'' fm_eff_dt" ).append("\n"); 
		query.append("       ,'' to_eff_dt" ).append("\n"); 
		query.append("	   ,'' search_csr_no" ).append("\n"); 
		query.append("	   ,'' dt_status " ).append("\n"); 
		query.append("	   ,'' ofc_cd" ).append("\n"); 
		query.append("       ,'' upd_usr_id " ).append("\n"); 
		query.append("	   ,'' inv_sts_cd" ).append("\n"); 
		query.append("	   ,'' inv_sub_sys_cd" ).append("\n"); 
		query.append("	   ,'' if_no" ).append("\n"); 
		query.append("       , B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("	   , B.CSR_USD_AMT" ).append("\n"); 
		query.append("	   , NVL(B.CSR_APRO_TP_CD,'AL') CSR_APRO_TP_CD" ).append("\n"); 
		query.append("       , B.CRE_USR_ID" ).append("\n"); 
		query.append("       , ( CASE WHEN B.GW_AGMT_DOC_CFM_CD IS NOT NULL" ).append("\n"); 
		query.append("           		THEN ( CASE WHEN B.GW_AGMT_DOC_CFM_CD = 'P' THEN 'Y'" ).append("\n"); 
		query.append("                       WHEN B.GW_AGMT_DOC_CFM_CD = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END )" ).append("\n"); 
		query.append("         	ELSE NVL(B.AGMT_DOC_CFM_CD,'N')" ).append("\n"); 
		query.append("    		END ) AGMT_DOC_CFM_CD " ).append("\n"); 
		query.append("	   , NVL(B.AGMT_FILE_CFM_CD,'N') AGMT_FILE_CFM_CD   " ).append("\n"); 
		query.append("       , (CASE WHEN" ).append("\n"); 
		query.append("        NVL(( SELECT COUNT(F.ATCH_FILE_ID)" ).append("\n"); 
		query.append("        		FROM COM_AP_FILE_UPLD F" ).append("\n"); 
		query.append("        		WHERE 1=1" ).append("\n"); 
		query.append("        		AND F.AP_FILE_DIV_CD = 'C'" ).append("\n"); 
		query.append("        		AND F.CSR_NO = B.CSR_NO " ).append("\n"); 
		query.append("        		AND F.CSR_FILE_UPLD_TP_CD = 'FU'				" ).append("\n"); 
		query.append("				AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        	),0) > 0 THEN 'Y'    " ).append("\n"); 
		query.append("    	  ELSE 'N'" ).append("\n"); 
		query.append("          END ) FILE_UPLD_FLG" ).append("\n"); 
		query.append("       , AP_COM_CHK_ALPS2GW_FNC(B.CSR_NO,@[ofc_cd]) CHK_GW_2_AL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("         ( SELECT TO_CHAR(A.IF_DT,'YYYY-MM-DD') IF_DT" ).append("\n"); 
		query.append("               , A.CSR_NO" ).append("\n"); 
		query.append("               , H.COST_OFC_CD" ).append("\n"); 
		query.append("               , A.CSR_CURR_CD" ).append("\n"); 
		query.append("			   ,DECODE(H.INV_CURR_CD, 'KRW', ROUND(NVL(A.CSR_AMT,0),0)" ).append("\n"); 
		query.append("			      				  , 'JPY', ROUND(NVL(A.CSR_AMT,0),0)" ).append("\n"); 
		query.append("								  , ROUND(NVL(A.CSR_AMT,0),2)) CSR_AMT" ).append("\n"); 
		query.append("               , SUBSTR(A.INV_TERM_DT, 1, 4) ||'/' ||SUBSTR(A.INV_TERM_DT, 5, 2) ||'/' ||SUBSTR(A.INV_TERM_DT, 7, 2) DUE_DT" ).append("\n"); 
		query.append("               , CASE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD    = 'J' OR H.INV_STS_CD = 'G'" ).append("\n"); 
		query.append("                         THEN 'A/P Rejected'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'E'" ).append("\n"); 
		query.append("                         THEN 'I/F Error'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("						 WHEN H.INV_STS_CD = 'X' AND H.CSR_NO IS NOT NULL AND A.AFT_ACT_FLG = 'N'" ).append("\n"); 
		query.append("						 THEN 'I/F Error Cancelled'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						 WHEN H.INV_STS_CD = 'C' AND H.CSR_NO IS NOT NULL AND A.AFT_ACT_FLG = 'N' " ).append("\n"); 
		query.append("                         THEN 'Approval Request Cancelled'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'C' AND H.CSR_NO IS NOT NULL  AND 1 = (SELECT count(*) FROM AP_PAY_INV K WHERE K.CSR_NO  = H.CSR_NO AND K.INV_STS_CD = 'G' AND ROWNUM = 1)" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                         THEN 'A/P Rejected'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'C' AND H.CSR_NO IS NOT NULL  AND 1 = (SELECT count(*) FROM AP_PAY_INV K WHERE K.CSR_NO  = H.CSR_NO AND K.INV_STS_CD = 'B' AND ROWNUM = 1)" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                         THEN 'Disapproved'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						 WHEN H.INV_STS_CD = 'A' AND A.IF_FLG IS NULL AND A.APRO_FLG = 'N' AND A.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("                         THEN 'Requesting Approval'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'P'" ).append("\n"); 
		query.append("                             AND A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("                         THEN 'I/F Success'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD    = 'R' OR H.INV_STS_CD = 'B'" ).append("\n"); 
		query.append("                         THEN 'Disapproved'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'A'" ).append("\n"); 
		query.append("                             AND A.IF_FLG IS NULL" ).append("\n"); 
		query.append("                         THEN DECODE(A.APRO_FLG" ).append("\n"); 
		query.append("                                   ,'Y','Sending'" ).append("\n"); 
		query.append("                                   ,'Approval Requested')" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("                         THEN 'Paid'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'X' AND H.CSR_NO IS NOT NULL AND A.AFT_ACT_FLG = 'X'" ).append("\n"); 
		query.append("                         THEN 'Approval Request Cancelled'" ).append("\n"); 
		query.append("						 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         ELSE H.INV_STS_CD" ).append("\n"); 
		query.append("                 END IF_STATUS" ).append("\n"); 
		query.append("               , A.ATTR_CTNT2" ).append("\n"); 
		query.append("               , A.IF_ERR_RSN" ).append("\n"); 
		query.append("               , A.VNDR_NO" ).append("\n"); 
		query.append("               , A.VNDR_TERM_NM" ).append("\n"); 
		query.append("               , A.AFT_ACT_FLG" ).append("\n"); 
		query.append("               , H.INV_ISS_DT" ).append("\n"); 
		query.append("               , C.APRO_RQST_NO" ).append("\n"); 
		query.append("               , H.INV_RCV_DT" ).append("\n"); 
		query.append("               , A.IF_FLG" ).append("\n"); 
		query.append("               , A.RCV_ERR_FLG" ).append("\n"); 
		query.append("               , H.INV_STS_CD " ).append("\n"); 
		query.append("               , A.PAY_GRP_LU_CD " ).append("\n"); 
		query.append("               , A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("			   , A.CSR_USD_AMT" ).append("\n"); 
		query.append("			   , A.CSR_APRO_TP_CD" ).append("\n"); 
		query.append("			   , A.CRE_USR_ID      " ).append("\n"); 
		query.append("			   , A.AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			   , A.GW_AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			   , A.AGMT_FILE_CFM_CD         " ).append("\n"); 
		query.append("         FROM    AP_PAY_INV H" ).append("\n"); 
		query.append("               , COM_APRO_CSR_DTL C" ).append("\n"); 
		query.append("#if (${dt_status} == 'IU') " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("               , COM_APRO_RQST_HDR R" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               , AP_INV_HDR A" ).append("\n"); 
		query.append("         WHERE   1                    =1" ).append("\n"); 
		query.append("#if (${dt_status} == 'IU' || ${dt_status} == 'AV') " ).append("\n"); 
		query.append("             AND H.CSR_NO             = C.CSR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			 AND H.CSR_NO             = C.CSR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dt_status} == 'IU')" ).append("\n"); 
		query.append("#elseif (${dt_status} == 'AV')" ).append("\n"); 
		query.append("			 AND C.APRO_RQST_NO       = R.APRO_RQST_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			 AND C.APRO_RQST_NO       = R.APRO_RQST_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			 AND H.CSR_NO             = A.CSR_NO" ).append("\n"); 
		query.append("             AND H.INV_OFC_CD         = @[ofc_cd]" ).append("\n"); 
		query.append("             AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("             AND NVL(A.CSR_APRO_TP_CD,'AL') = 'AL'" ).append("\n"); 
		query.append("             AND NVL(A.RQST_APRO_STEP_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${src_ctnt} == 'SO_M&R') " ).append("\n"); 
		query.append("			AND A.SRC_CTNT           IN ('SO_M&R', 'EQ')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			AND A.SRC_CTNT           = @[src_ctnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_no}=='CSR') 	 " ).append("\n"); 
		query.append("	#if (${search_csr_no}=='null' || ${search_csr_no} == '') " ).append("\n"); 
		query.append("		#if (${dt_status} == 'AR') --Approval Requested" ).append("\n"); 
		query.append(" 			 AND R.RQST_ST_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421" ).append("\n"); 
		query.append("		#elseif (${dt_status} == 'RA') --Requesting Approval" ).append("\n"); 
		query.append("			 AND (A.CSR_APRO_STEP_ASGN_RQST_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 )" ).append("\n"); 
		query.append("		#elseif (${dt_status} == 'AV') --Approved or Disapproved" ).append("\n"); 
		query.append("		 	 AND (" ).append("\n"); 
		query.append("					( R.APSTS_CD IN ('C','R') " ).append("\n"); 
		query.append("					  AND R.RQST_END_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 )" ).append("\n"); 
		query.append("				     OR A.IF_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421" ).append("\n"); 
		query.append("				 )" ).append("\n"); 
		query.append("		#elseif (${dt_status} == 'IU')  --I/F Status Updated" ).append("\n"); 
		query.append("			 AND (A.IF_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.CSR_NO LIKE '%'||@[search_csr_no]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND H.INV_NO LIKE '%'||@[search_csr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_status} == 'RA')" ).append("\n"); 
		query.append("			--AND H.INV_STS_CD = 'A' AND A.IF_FLG IS NULL AND A.APRO_FLG = 'N'" ).append("\n"); 
		query.append("            --AND A.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("            AND 1=2" ).append("\n"); 
		query.append("#elseif (${if_status} == 'AR')" ).append("\n"); 
		query.append("			AND H.INV_STS_CD = 'A' AND A.IF_FLG IS NULL AND A.APRO_FLG = 'N'" ).append("\n"); 
		query.append("            AND A.RQST_APRO_STEP_FLG IS NULL" ).append("\n"); 
		query.append("#elseif (${if_status} == 'SD') " ).append("\n"); 
		query.append("			AND A.IF_FLG IS NULL AND A.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${if_status} == 'SC') " ).append("\n"); 
		query.append("            AND H.INV_STS_CD = 'P' AND A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("#elseif (${if_status} == 'IE') " ).append("\n"); 
		query.append("            AND H.INV_STS_CD = 'E'" ).append("\n"); 
		query.append("#elseif (${if_status} == 'RJ')" ).append("\n"); 
		query.append("            AND H.INV_STS_CD = 'J'" ).append("\n"); 
		query.append("#elseif (${if_status} == 'DA')" ).append("\n"); 
		query.append("            AND H.INV_STS_CD = 'R'" ).append("\n"); 
		query.append("#elseif (${if_status} == 'SP')" ).append("\n"); 
		query.append("			AND H.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT TO_CHAR(A.IF_DT,'YYYY-MM-DD') IF_DT" ).append("\n"); 
		query.append("               , A.CSR_NO" ).append("\n"); 
		query.append("               , H.COST_OFC_CD" ).append("\n"); 
		query.append("               , A.CSR_CURR_CD" ).append("\n"); 
		query.append("			   ,DECODE(H.INV_CURR_CD, 'KRW', ROUND(NVL(A.CSR_AMT,0),0)" ).append("\n"); 
		query.append("			      				  , 'JPY', ROUND(NVL(A.CSR_AMT,0),0)" ).append("\n"); 
		query.append("								  , ROUND(NVL(A.CSR_AMT,0),2)) CSR_AMT" ).append("\n"); 
		query.append("               , SUBSTR(A.INV_TERM_DT, 1, 4) ||'/' ||SUBSTR(A.INV_TERM_DT, 5, 2) ||'/' ||SUBSTR(A.INV_TERM_DT, 7, 2) DUE_DT" ).append("\n"); 
		query.append("               , CASE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD    = 'J' OR H.INV_STS_CD = 'G'" ).append("\n"); 
		query.append("                         THEN 'A/P Rejected'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'E'" ).append("\n"); 
		query.append("                         THEN 'I/F Error'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("						 WHEN H.INV_STS_CD = 'X' AND H.CSR_NO IS NOT NULL AND A.AFT_ACT_FLG = 'N'" ).append("\n"); 
		query.append("						 THEN 'I/F Error Cancelled'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						 WHEN H.INV_STS_CD = 'C' AND H.CSR_NO IS NOT NULL AND A.AFT_ACT_FLG = 'N' " ).append("\n"); 
		query.append("                         THEN 'Approval Request Cancelled'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'C' AND H.CSR_NO IS NOT NULL  AND 1 = (SELECT count(*) FROM AP_PAY_INV K WHERE K.CSR_NO  = H.CSR_NO AND K.INV_STS_CD = 'G' AND ROWNUM = 1)" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                         THEN 'A/P Rejected'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'C' AND H.CSR_NO IS NOT NULL  AND 1 = (SELECT count(*) FROM AP_PAY_INV K WHERE K.CSR_NO  = H.CSR_NO AND K.INV_STS_CD = 'B' AND ROWNUM = 1)" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                         THEN 'Disapproved'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						 WHEN H.INV_STS_CD = 'A' AND A.IF_FLG IS NULL AND A.APRO_FLG = 'N' AND A.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("                         THEN 'Requesting Approval'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'P'" ).append("\n"); 
		query.append("                             AND A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("                         THEN 'I/F Success'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD    = 'R' OR H.INV_STS_CD = 'B'" ).append("\n"); 
		query.append("                         THEN 'Disapproved'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'A'" ).append("\n"); 
		query.append("                             AND A.IF_FLG IS NULL" ).append("\n"); 
		query.append("                         THEN DECODE(A.APRO_FLG" ).append("\n"); 
		query.append("                                   ,'Y','Sending'" ).append("\n"); 
		query.append("                                   ,'Approval Requested')" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("                         THEN 'Paid'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'X' AND H.CSR_NO IS NOT NULL AND A.AFT_ACT_FLG = 'X'" ).append("\n"); 
		query.append("                         THEN 'Approval Request Cancelled'" ).append("\n"); 
		query.append("						 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         ELSE H.INV_STS_CD" ).append("\n"); 
		query.append("                 END IF_STATUS" ).append("\n"); 
		query.append("               , A.ATTR_CTNT2" ).append("\n"); 
		query.append("               , A.IF_ERR_RSN" ).append("\n"); 
		query.append("               , A.VNDR_NO" ).append("\n"); 
		query.append("               , A.VNDR_TERM_NM" ).append("\n"); 
		query.append("               , A.AFT_ACT_FLG" ).append("\n"); 
		query.append("               , H.INV_ISS_DT" ).append("\n"); 
		query.append("               , '' APRO_RQST_NO" ).append("\n"); 
		query.append("               , H.INV_RCV_DT" ).append("\n"); 
		query.append("               , A.IF_FLG" ).append("\n"); 
		query.append("               , A.RCV_ERR_FLG" ).append("\n"); 
		query.append("               , H.INV_STS_CD " ).append("\n"); 
		query.append("               , A.PAY_GRP_LU_CD " ).append("\n"); 
		query.append("               , A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("			   , A.CSR_USD_AMT" ).append("\n"); 
		query.append("			   , A.CSR_APRO_TP_CD" ).append("\n"); 
		query.append("			   , A.CRE_USR_ID   " ).append("\n"); 
		query.append("			   , A.AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			   , A.GW_AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			   , A.AGMT_FILE_CFM_CD  " ).append("\n"); 
		query.append("         FROM    AP_PAY_INV H" ).append("\n"); 
		query.append("               , AP_INV_HDR A" ).append("\n"); 
		query.append("         WHERE   1                    =1" ).append("\n"); 
		query.append("			 AND H.CSR_NO             = A.CSR_NO" ).append("\n"); 
		query.append("             AND H.INV_OFC_CD         = @[ofc_cd]" ).append("\n"); 
		query.append("             AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("             AND NVL(A.CSR_APRO_TP_CD,'AL') = 'GW' --IN ('AL','GW')" ).append("\n"); 
		query.append("             AND NVL(A.RQST_APRO_STEP_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${src_ctnt} == 'SO_M&R') " ).append("\n"); 
		query.append("			AND A.SRC_CTNT           IN ('SO_M&R', 'EQ')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			AND A.SRC_CTNT           = @[src_ctnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_no}=='CSR') 	 " ).append("\n"); 
		query.append("	#if (${search_csr_no}=='null' || ${search_csr_no} == '') " ).append("\n"); 
		query.append("		#if (${dt_status} == 'AR') --Approval Requested" ).append("\n"); 
		query.append("             AND ( A.CSR_APRO_STEP_ASGN_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 ) --TOBE" ).append("\n"); 
		query.append("		#elseif (${dt_status} == 'RA') --Requesting Approval" ).append("\n"); 
		query.append("			 AND (A.CSR_APRO_STEP_ASGN_RQST_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 )" ).append("\n"); 
		query.append("		#elseif (${dt_status} == 'AV') --Approved or Disapproved" ).append("\n"); 
		query.append("			 AND (( A.CSR_APRO_CMPL_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 )" ).append("\n"); 
		query.append("			OR ( A.CSR_RJCT_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 ))" ).append("\n"); 
		query.append("		#elseif (${dt_status} == 'IU') --I/F Status Updated" ).append("\n"); 
		query.append("			 AND (A.IF_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.CSR_NO LIKE '%'||@[search_csr_no]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND H.INV_NO LIKE '%'||@[search_csr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_status} == 'RA')" ).append("\n"); 
		query.append("			--AND H.INV_STS_CD = 'A' AND A.IF_FLG IS NULL AND A.APRO_FLG = 'N'" ).append("\n"); 
		query.append("            --AND A.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("            AND 1=2" ).append("\n"); 
		query.append("#elseif (${if_status} == 'AR')" ).append("\n"); 
		query.append("			AND H.INV_STS_CD = 'A' AND A.IF_FLG IS NULL AND A.APRO_FLG = 'N'" ).append("\n"); 
		query.append("            AND A.RQST_APRO_STEP_FLG IS NULL" ).append("\n"); 
		query.append("#elseif (${if_status} == 'SD') " ).append("\n"); 
		query.append("			AND A.IF_FLG IS NULL AND A.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${if_status} == 'SC') " ).append("\n"); 
		query.append("            AND H.INV_STS_CD = 'P' AND A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("#elseif (${if_status} == 'IE') " ).append("\n"); 
		query.append("            AND H.INV_STS_CD = 'E'" ).append("\n"); 
		query.append("#elseif (${if_status} == 'RJ')" ).append("\n"); 
		query.append("            AND H.INV_STS_CD = 'J'" ).append("\n"); 
		query.append("#elseif (${if_status} == 'DA')" ).append("\n"); 
		query.append("            AND H.INV_STS_CD = 'R'" ).append("\n"); 
		query.append("#elseif (${if_status} == 'SP')" ).append("\n"); 
		query.append("			AND H.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT TO_CHAR(A.IF_DT,'YYYY-MM-DD') IF_DT" ).append("\n"); 
		query.append("               , A.CSR_NO" ).append("\n"); 
		query.append("               , H.COST_OFC_CD" ).append("\n"); 
		query.append("               , A.CSR_CURR_CD" ).append("\n"); 
		query.append("			   ,DECODE(H.INV_CURR_CD, 'KRW', ROUND(NVL(A.CSR_AMT,0),0)" ).append("\n"); 
		query.append("			      				  , 'JPY', ROUND(NVL(A.CSR_AMT,0),0)" ).append("\n"); 
		query.append("								  , ROUND(NVL(A.CSR_AMT,0),2)) CSR_AMT" ).append("\n"); 
		query.append("               , SUBSTR(A.INV_TERM_DT, 1, 4) ||'/' ||SUBSTR(A.INV_TERM_DT, 5, 2) ||'/' ||SUBSTR(A.INV_TERM_DT, 7, 2) DUE_DT" ).append("\n"); 
		query.append("               , CASE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD    = 'J' OR H.INV_STS_CD = 'G'" ).append("\n"); 
		query.append("                         THEN 'A/P Rejected'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'E'" ).append("\n"); 
		query.append("                         THEN 'I/F Error'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("						 WHEN H.INV_STS_CD = 'X' AND H.CSR_NO IS NOT NULL AND A.AFT_ACT_FLG = 'N'" ).append("\n"); 
		query.append("						 THEN 'I/F Error Cancelled'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						 WHEN H.INV_STS_CD = 'C' AND H.CSR_NO IS NOT NULL AND A.AFT_ACT_FLG = 'N' " ).append("\n"); 
		query.append("                         THEN 'Approval Request Cancelled'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'C' AND H.CSR_NO IS NOT NULL  AND 1 = (SELECT count(*) FROM AP_PAY_INV K WHERE K.CSR_NO  = H.CSR_NO AND K.INV_STS_CD = 'G' AND ROWNUM = 1)" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                         THEN 'A/P Rejected'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'C' AND H.CSR_NO IS NOT NULL  AND 1 = (SELECT count(*) FROM AP_PAY_INV K WHERE K.CSR_NO  = H.CSR_NO AND K.INV_STS_CD = 'B' AND ROWNUM = 1)" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                         THEN 'Disapproved'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						 WHEN H.INV_STS_CD = 'A' AND A.IF_FLG IS NULL AND A.APRO_FLG = 'N' AND A.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("                         THEN 'Requesting Approval'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'P'" ).append("\n"); 
		query.append("                             AND A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("                         THEN 'I/F Success'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD    = 'R' OR H.INV_STS_CD = 'B'" ).append("\n"); 
		query.append("                         THEN 'Disapproved'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'A'" ).append("\n"); 
		query.append("                             AND A.IF_FLG IS NULL" ).append("\n"); 
		query.append("                         THEN DECODE(A.APRO_FLG" ).append("\n"); 
		query.append("                                   ,'Y','Sending'" ).append("\n"); 
		query.append("                                   ,'Approval Requested')" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("                         THEN 'Paid'" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         WHEN H.INV_STS_CD = 'X' AND H.CSR_NO IS NOT NULL AND A.AFT_ACT_FLG = 'X'" ).append("\n"); 
		query.append("                         THEN 'Approval Request Cancelled'" ).append("\n"); 
		query.append("						 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         ELSE H.INV_STS_CD" ).append("\n"); 
		query.append("                 END IF_STATUS" ).append("\n"); 
		query.append("               , A.ATTR_CTNT2" ).append("\n"); 
		query.append("               , A.IF_ERR_RSN" ).append("\n"); 
		query.append("               , A.VNDR_NO" ).append("\n"); 
		query.append("               , A.VNDR_TERM_NM" ).append("\n"); 
		query.append("               , A.AFT_ACT_FLG" ).append("\n"); 
		query.append("               , H.INV_ISS_DT" ).append("\n"); 
		query.append("               , '' APRO_RQST_NO" ).append("\n"); 
		query.append("               , H.INV_RCV_DT" ).append("\n"); 
		query.append("               , A.IF_FLG" ).append("\n"); 
		query.append("               , A.RCV_ERR_FLG" ).append("\n"); 
		query.append("               , H.INV_STS_CD " ).append("\n"); 
		query.append("               , A.PAY_GRP_LU_CD " ).append("\n"); 
		query.append("               , A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("			   , A.CSR_USD_AMT" ).append("\n"); 
		query.append("			   , A.CSR_APRO_TP_CD" ).append("\n"); 
		query.append("			   , A.CRE_USR_ID   " ).append("\n"); 
		query.append("			   , A.AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			   , A.GW_AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			   , A.AGMT_FILE_CFM_CD  " ).append("\n"); 
		query.append("         FROM    AP_PAY_INV H" ).append("\n"); 
		query.append("               , AP_INV_HDR A" ).append("\n"); 
		query.append("         WHERE   1                    =1" ).append("\n"); 
		query.append("			 AND H.CSR_NO             = A.CSR_NO" ).append("\n"); 
		query.append("             AND H.INV_OFC_CD         = @[ofc_cd]" ).append("\n"); 
		query.append("             AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("             --AND A.CSR_APRO_TP_CD IN ('AL','GW') --?곴??놁씠" ).append("\n"); 
		query.append("             AND NVL(A.RQST_APRO_STEP_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#if (${src_ctnt} == 'SO_M&R') " ).append("\n"); 
		query.append("			AND A.SRC_CTNT           IN ('SO_M&R', 'EQ')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			AND A.SRC_CTNT           = @[src_ctnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_no}=='CSR') 	 " ).append("\n"); 
		query.append("	#if (${search_csr_no}=='null' || ${search_csr_no} == '') " ).append("\n"); 
		query.append("		#if (${dt_status} == 'RA') --Requesting Approval" ).append("\n"); 
		query.append("			 AND ( A.CSR_APRO_STEP_ASGN_DT IS NULL AND " ).append("\n"); 
		query.append("                  (A.CSR_APRO_STEP_ASGN_RQST_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 ))" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			 AND 1=2 " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.CSR_NO LIKE '%'||@[search_csr_no]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND H.INV_NO LIKE '%'||@[search_csr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_status} == 'RA')" ).append("\n"); 
		query.append("			AND H.INV_STS_CD = 'A' AND A.IF_FLG IS NULL AND A.APRO_FLG = 'N'" ).append("\n"); 
		query.append("            --AND A.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${if_status} == 'AL')" ).append("\n"); 
		query.append("			AND 1=1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${search_tp_cd} == 'AL')" ).append("\n"); 
		query.append("	AND NVL(B.CSR_APRO_TP_CD,'AL') = 'AL'" ).append("\n"); 
		query.append("#elseif (${search_tp_cd} == 'GW')" ).append("\n"); 
		query.append("	AND NVL(B.CSR_APRO_TP_CD,'AL') = 'GW'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY B.IF_DT" ).append("\n"); 
		query.append("       , B.CSR_NO" ).append("\n"); 
		query.append("       , B.CSR_CURR_CD" ).append("\n"); 
		query.append("       , B.CSR_AMT" ).append("\n"); 
		query.append("       , B.DUE_DT" ).append("\n"); 
		query.append("       , B.IF_STATUS" ).append("\n"); 
		query.append("       , B.ATTR_CTNT2" ).append("\n"); 
		query.append("       , B.IF_ERR_RSN" ).append("\n"); 
		query.append("       , B.VNDR_NO" ).append("\n"); 
		query.append("       , B.VNDR_TERM_NM" ).append("\n"); 
		query.append("       , B.AFT_ACT_FLG" ).append("\n"); 
		query.append("       , B.IF_FLG" ).append("\n"); 
		query.append("       , B.RCV_ERR_FLG" ).append("\n"); 
		query.append("       , B.APRO_RQST_NO" ).append("\n"); 
		query.append("       , B.PAY_GRP_LU_CD" ).append("\n"); 
		query.append("       , B.COST_OFC_CD " ).append("\n"); 
		query.append("       , B.ACCT_XCH_RT_YRMON " ).append("\n"); 
		query.append("	   , B.CSR_USD_AMT " ).append("\n"); 
		query.append("       , B.AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("	   , B.GW_AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("	   , B.AGMT_FILE_CFM_CD" ).append("\n"); 
		query.append("       , B.CSR_APRO_TP_CD" ).append("\n"); 
		query.append("       , B.CRE_USR_ID" ).append("\n"); 
		query.append("ORDER BY B.CSR_NO ASC" ).append("\n"); 

	}
}
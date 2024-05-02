/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4009
	  * Outstanding Inquiry by Customer N Issue for Sales Rep
	  * 김기태
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frdt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cuno2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reg_ex",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grop_cust",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryList2RSQL").append("\n"); 
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
		query.append("WITH MN_DATA AS (" ).append("\n"); 
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("        DMDT_INV_NO" ).append("\n"); 
		query.append("       ,M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("       ,M.ACT_PAYR_SEQ " ).append("\n"); 
		query.append("       ,DMDT_VT_INV_STS_CD" ).append("\n"); 
		query.append("       ,( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE M.ACT_PAYR_SEQ = VNDR_SEQ AND ROWNUM = 1 ) VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("       ,M.INV_CURR_CD" ).append("\n"); 
		query.append("       ,( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE M.ACT_PAYR_CNT_CD = CUST_CNT_CD AND M.ACT_PAYR_SEQ = CUST_SEQ AND ROWNUM = 1 ) CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       ,M.DMDT_TRF_CD " ).append("\n"); 
		query.append("       ,M.INV_CHG_AMT" ).append("\n"); 
		query.append("       ,M.TAX_AMT" ).append("\n"); 
		query.append("       ,M.DMDT_INV_STS_CD " ).append("\n"); 
		query.append("       ,M.TAX_RTO" ).append("\n"); 
		query.append("       ,M.INV_AMT" ).append("\n"); 
		query.append("       ,M.CRE_OFC_CD" ).append("\n"); 
		query.append("       ,INV_XCH_RT" ).append("\n"); 
		query.append("       ,TO_CHAR(AR_IF_DT, 'YYYY-MM-DD') AS AR_IF_DT" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN ATTR_CTNT1 IS NULL THEN 	-- AUTO I/F 가 아닐 경우 (INVOICE 발행 OFFICE 가 AUTO I/F 대상 OFFICE 가 아닐 경우)" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("					WHEN DMDT_INV_STS_CD = 'I' AND DMDT_AR_IF_CD = 'Y' THEN " ).append("\n"); 
		query.append("						'Y'" ).append("\n"); 
		query.append("					ELSE " ).append("\n"); 
		query.append("						'N'" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE 	-- AUTO I/F 일 경우 (INVOICE 발행 OFFICE 가 AUTO I/F 대상 OFFICE 일 경우)" ).append("\n"); 
		query.append("				NVL(OTS_CLT_FLG, 'N')" ).append("\n"); 
		query.append("	    END V_COLLECTED				" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN ATTR_CTNT1 IS NOT NULL THEN " ).append("\n"); 
		query.append("				'Y' " ).append("\n"); 
		query.append("			ELSE " ).append("\n"); 
		query.append("				'N' " ).append("\n"); 
		query.append("		END AUTO_AR_IF_OFC_FLG       -- AUTO I/F OFFICE 인지 여부를 나타내는 FLAG	 " ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  SYS_AREA_GRP_ID SVR_ID " ).append("\n"); 
		query.append("			  FROM  COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("             WHERE  CNT_CD = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT  CNT_CD " ).append("\n"); 
		query.append("						  FROM  MDM_LOCATION " ).append("\n"); 
		query.append("						 WHERE  LOC_CD = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  LOC_CD " ).append("\n"); 
		query.append("									  FROM  MDM_ORGANIZATION " ).append("\n"); 
		query.append("									 WHERE  OFC_CD = SUBSTR(M.CRE_OFC_CD, 0, 5)" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("					) " ).append("\n"); 
		query.append("			   AND  CO_IND_CD = 'H'" ).append("\n"); 
		query.append("		) SVR_ID" ).append("\n"); 
		query.append("       ,(SELECT SC_NO  FROM BKG_BOOKING WHERE BKG_NO = M.BKG_NO ) AS SC_NO" ).append("\n"); 
		query.append("       ,(SELECT RFA_NO FROM BKG_BOOKING WHERE BKG_NO = M.BKG_NO ) AS RFA_NO" ).append("\n"); 
		query.append("       ,(SELECT TAA_NO FROM BKG_BOOKING WHERE BKG_NO = M.BKG_NO ) AS TAA_NO" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			SELECT  USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("    	      FROM  GL_MON_XCH_RT" ).append("\n"); 
		query.append("        	 WHERE  1 = 1" ).append("\n"); 
		query.append("	           AND  ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') " ).append("\n"); 
		query.append("	           AND  ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("    	       AND  CURR_CD = M.INV_CURR_CD " ).append("\n"); 
		query.append("		) AS USD_LOCL_XCH_RT -- USD 환율" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("  FROM  DMT_INV_MN    		M	" ).append("\n"); 
		query.append("	   ,DMT_HRD_CDG_CTNT 	D" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  M.CRE_OFC_CD = D.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND  D.HRD_CDG_ID(+) = 'AUTO_AR_IF_OFC'" ).append("\n"); 
		query.append("   AND  M.CRE_DT  BETWEEN TO_DATE(REPLACE(@[frdt2],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[todt2],'-',''), 'YYYYMMDD') + .99999       /* INVOICE ISSUE DATE */" ).append("\n"); 
		query.append("#if ( ${isof} != '' )" ).append("\n"); 
		query.append("   AND M.CRE_OFC_CD IN (#foreach( $is_ofc_cd in ${tempISOFList}) #if($velocityCount < $tempISOFList.size()) '$is_ofc_cd', #else '$is_ofc_cd' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (M.DMDT_INV_STS_CD = 'I' or (M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C'))	-- NOT CANCELED INVOICE or VIRTUAL INVOICE modified 2014.12.30 by jameskai" ).append("\n"); 
		query.append("#if ( ${arif} != '' )" ).append("\n"); 
		query.append("   AND ( 1!=1 " ).append("\n"); 
		query.append("		#if (${uncollected} == 'N')" ).append("\n"); 
		query.append("        OR ( DMDT_INV_STS_CD = 'I' AND DMDT_AR_IF_CD = 'N' )" ).append("\n"); 
		query.append("		OR ( DMDT_INV_STS_CD = 'X' AND DMDT_AR_IF_CD = 'N' AND M.DMDT_VT_INV_STS_CD = 'C' )" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${collected} == 'Y')" ).append("\n"); 
		query.append("		OR DMDT_AR_IF_CD = 'Y'" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${hold} == 'H')" ).append("\n"); 
		query.append("		OR DMDT_AR_IF_CD = 'H'" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${hold_Litigation} == 'L')" ).append("\n"); 
		query.append("		OR (DMDT_AR_IF_CD = 'H' AND INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${tftp} != 'A' )" ).append("\n"); 
		query.append("    AND M.DMDT_TRF_CD IN (#foreach( $dmdt_trf_cd_p in ${tempTFTPList}) #if($velocityCount < $tempTFTPList.size())'$dmdt_trf_cd_p', #else '$dmdt_trf_cd_p' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${payc2} != '' )" ).append("\n"); 
		query.append("   and  M.ACT_PAYR_CNT_CD     =   decode(length(@[payc2]), 8, nvl(substr(@[payc2], 1, 2), M.ACT_PAYR_CNT_CD), 6, M.ACT_PAYR_CNT_CD, M.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("   and  M.ACT_PAYR_SEQ        =   decode(length(@[payc2]), 8, nvl(substr(@[payc2], 3, 6), M.ACT_PAYR_SEQ),    6, @[payc2],           M.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${prg_ex_in_cd2} == 'EX' )" ).append("\n"); 
		query.append("   and  nvl(M.PRG_FLG, 'N') = 'N'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("#elseif ( ${prg_ex_in_cd2} == 'ON' )" ).append("\n"); 
		query.append("   and  nvl(M.PRG_FLG, 'N') = 'Y'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cuno2} != '' )" ).append("\n"); 
		query.append("   and  M.BKG_NO in" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			select  BKG_NO" ).append("\n"); 
		query.append("			  from  BKG_CUSTOMER    BC" ).append("\n"); 
		query.append("			 where  BC.CUST_CNT_CD = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						case when @[cuno2] is null then BC.CUST_CNT_CD else substr(@[cuno2], 1, 2) end" ).append("\n"); 
		query.append("					) -- 2013.10.22 (ALPS 통합 로그 Error) 숫자 컬럼에 문자 입력시 ORACLE Exception Error가 발생하지 않도록 처리함." ).append("\n"); 
		query.append("			   and  BC.CUST_SEQ = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						case when @[cuno2] is null then BC.CUST_SEQ" ).append("\n"); 
		query.append("							 when REGEXP_INSTR(substr(@[cuno2], 3, 6), '[[:alpha:]]', 1, 1) = 0 then to_number(substr(@[cuno2], 3, 6))" ).append("\n"); 
		query.append("							 else -999999" ).append("\n"); 
		query.append("						end" ).append("\n"); 
		query.append("					)	-- 2013.10.22 (ALPS 통합 로그 Error) 숫자 컬럼에 문자 입력시 ORACLE Exception Error가 발생하지 않도록 처리함.;" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("	#if ( ${cutp} != 'A,S,C,N' )" ).append("\n"); 
		query.append("		#if ( ${cutp} == '' )" ).append("\n"); 
		query.append("			   and  1 = 1" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			   and  BKG_CUST_TP_CD in " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						#foreach( $bkg_cust_tp_cd_p in ${tempCUTPList}) " ).append("\n"); 
		query.append("							#if($velocityCount < $tempCUTPList.size()) " ).append("\n"); 
		query.append("							   '$bkg_cust_tp_cd_p', " ).append("\n"); 
		query.append("							#else " ).append("\n"); 
		query.append("							   '$bkg_cust_tp_cd_p' " ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			   and  BKG_CUST_TP_CD in ('S','C','N')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${grop_cust} != '' )" ).append("\n"); 
		query.append("   AND  ( M.ACT_PAYR_CNT_CD, M.ACT_PAYR_SEQ ) IN" ).append("\n"); 
		query.append("			( SELECT A.CUST_CNT_CD, A.CUST_SEQ FROM MDM_CUSTOMER A, MDM_CUST_PERF_GRP B" ).append("\n"); 
		query.append("			   WHERE A.CUST_GRP_ID = B.CUST_GRP_ID" ).append("\n"); 
		query.append("				 AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("				 AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("				 AND A.CUST_GRP_ID = 'G-'||@[grop_cust] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${scNoList} != '' || ${rfaNoList} != '' || ${taaNoList} != '' )" ).append("\n"); 
		query.append("	AND (1 = 0 " ).append("\n"); 
		query.append("#if ( ${scNoList} != '' )" ).append("\n"); 
		query.append("   	OR (SELECT SC_NO FROM BKG_BOOKING WHERE BKG_NO = M.BKG_NO ) IN (" ).append("\n"); 
		query.append("			#foreach( $scNo in ${scNoList}) #if($velocityCount < $scNoList.size()) '$scNo', #else '$scNo' #end #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${rfaNoList} != '' )" ).append("\n"); 
		query.append("   	OR (SELECT RFA_NO FROM BKG_BOOKING WHERE BKG_NO = M.BKG_NO ) IN (" ).append("\n"); 
		query.append("			#foreach( $rfaNo in ${rfaNoList}) #if($velocityCount < $rfaNoList.size()) '$rfaNo', #else '$rfaNo' #end #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${taaNoList} != '' )" ).append("\n"); 
		query.append("   	OR (SELECT TAA_NO FROM BKG_BOOKING WHERE BKG_NO = M.BKG_NO ) IN (" ).append("\n"); 
		query.append("			#foreach( $taaNo in ${taaNoList}) #if($velocityCount < $taaNoList.size()) '$taaNo', #else '$taaNo' #end #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${coll} != '' && ${coll} != 'A' )	 " ).append("\n"); 
		query.append("	#if ( ${coll} == 'N' ) " ).append("\n"); 
		query.append("   AND  CASE " ).append("\n"); 
		query.append("			WHEN D.ATTR_CTNT1 IS NOT NULL AND M.DMDT_AR_IF_CD = 'Y' THEN " ).append("\n"); 
		query.append("				NVL(OTS_CLT_FLG, 'N')" ).append("\n"); 
		query.append("            WHEN D.ATTR_CTNT1 IS NOT NULL AND M.DMDT_INV_STS_CD = 'X' AND M.DMDT_AR_IF_CD = 'N' THEN " ).append("\n"); 
		query.append("				'Y'" ).append("\n"); 
		query.append("            WHEN M.DMDT_INV_STS_CD = 'I' AND M.DMDT_AR_IF_CD = 'Y' THEN " ).append("\n"); 
		query.append("				'Y'" ).append("\n"); 
		query.append("            WHEN M.DMDT_INV_STS_CD = 'I' AND M.DMDT_AR_IF_CD = 'N' THEN " ).append("\n"); 
		query.append("				'N'" ).append("\n"); 
		query.append("            WHEN M.DMDT_INV_STS_CD IN ( 'C','X' ) THEN " ).append("\n"); 
		query.append("				'Y'" ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("				'N' " ).append("\n"); 
		query.append("		END  = 'N'" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  CASE " ).append("\n"); 
		query.append("			WHEN D.ATTR_CTNT1 IS NOT NULL AND M.DMDT_AR_IF_CD = 'Y' THEN " ).append("\n"); 
		query.append("				NVL(OTS_CLT_FLG, 'N')" ).append("\n"); 
		query.append("            WHEN D.ATTR_CTNT1 IS NOT NULL AND M.DMDT_INV_STS_CD = 'X' AND M.DMDT_AR_IF_CD = 'N' THEN " ).append("\n"); 
		query.append("				'Y'" ).append("\n"); 
		query.append("            WHEN M.DMDT_INV_STS_CD = 'I' AND M.DMDT_AR_IF_CD = 'Y' THEN " ).append("\n"); 
		query.append("				'Y'" ).append("\n"); 
		query.append("            WHEN M.DMDT_INV_STS_CD = 'I' AND M.DMDT_AR_IF_CD = 'N' THEN " ).append("\n"); 
		query.append("				'N'" ).append("\n"); 
		query.append("            WHEN M.DMDT_INV_STS_CD IN ( 'C','X' ) THEN " ).append("\n"); 
		query.append("				'Y'" ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("				'N' " ).append("\n"); 
		query.append("		END  = 'Y'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PRI_INFO AS (" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("      FROM ( SELECT /*+ LEADING(A,HDR,MN,PTY) USE_NL(HDR,MN,PTY) */ " ).append("\n"); 
		query.append("                    A.*, NVL(MN.REAL_CUST_SLS_OFC_CD, PTY.CTRT_CUST_SLS_OFC_CD) PRI_OFC_CD" ).append("\n"); 
		query.append("                    , NVL(MN.REAL_CUST_SREP_CD, PTY.CTRT_CUST_SREP_CD) PRI_SREP_CD" ).append("\n"); 
		query.append("                    , CASE WHEN REAL_CUST_CNT_CD||TRIM(TO_CHAR(REAL_CUST_SEQ,'000000')) IS NULL " ).append("\n"); 
		query.append("                                THEN PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("                           ELSE REAL_CUST_CNT_CD END CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                    , CASE WHEN REAL_CUST_CNT_CD||TRIM(TO_CHAR(REAL_CUST_SEQ,'000000')) IS NULL " ).append("\n"); 
		query.append("                                THEN PTY.CUST_SEQ" ).append("\n"); 
		query.append("                           ELSE REAL_CUST_SEQ END CTRT_CUST_SEQ" ).append("\n"); 
		query.append("               FROM MN_DATA A," ).append("\n"); 
		query.append("                    PRI_SP_HDR HDR, " ).append("\n"); 
		query.append("                    PRI_SP_MN MN, " ).append("\n"); 
		query.append("                    PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND A.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("                AND A.SC_NO = HDR.SC_NO" ).append("\n"); 
		query.append("#if ( ${ctof} != '' )" ).append("\n"); 
		query.append("   	AND NVL(MN.REAL_CUST_SLS_OFC_CD, PTY.CTRT_CUST_SLS_OFC_CD) IN (" ).append("\n"); 
		query.append("			#foreach( $ctrt_ofc_cd in ${tempCTOFList}) #if($velocityCount < $tempCTOFList.size()) '$ctrt_ofc_cd', #else '$ctrt_ofc_cd' #end #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_srep_flg2} == 'Y' && ${ob_srep_cd2} != '' )" ).append("\n"); 
		query.append("   	AND NVL(MN.REAL_CUST_SREP_CD, PTY.CTRT_CUST_SREP_CD) = @[ob_srep_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("    AND MN.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("    AND MN.AMDT_SEQ = (SELECT /*+ NO_UNNEST */ " ).append("\n"); 
		query.append("                              MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                       FROM PRI_SP_MN " ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                         AND PROP_STS_CD = MN.PROP_STS_CD " ).append("\n"); 
		query.append("                       )    " ).append("\n"); 
		query.append("    AND PTY.PROP_NO                  = MN.PROP_NO" ).append("\n"); 
		query.append("    AND PTY.AMDT_SEQ                  = MN.AMDT_SEQ" ).append("\n"); 
		query.append("    AND PTY.PRC_CTRT_PTY_TP_CD        = 'C'" ).append("\n"); 
		query.append("#if ( ${scNoList} != '' )" ).append("\n"); 
		query.append("		   AND HDR.SC_NO IN (" ).append("\n"); 
		query.append("			#foreach( $scNo in ${scNoList}) #if($velocityCount < $scNoList.size()) '$scNo', #else '$scNo' #end #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${ctrt_cust} != '' )" ).append("\n"); 
		query.append("   and  CASE WHEN REAL_CUST_CNT_CD||TRIM(TO_CHAR(REAL_CUST_SEQ,'000000')) IS NULL " ).append("\n"); 
		query.append("                                THEN PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("                           ELSE REAL_CUST_CNT_CD END     =   substr(@[ctrt_cust], 1, 2)" ).append("\n"); 
		query.append("   and  CASE WHEN REAL_CUST_CNT_CD||TRIM(TO_CHAR(REAL_CUST_SEQ,'000000')) IS NULL " ).append("\n"); 
		query.append("                                THEN PTY.CUST_SEQ" ).append("\n"); 
		query.append("                           ELSE REAL_CUST_SEQ END        =   substr(@[ctrt_cust], 3, 6)" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("             SELECT /*+ LEADING(A) USE_NL(HDR,MN) */" ).append("\n"); 
		query.append("                    A.*, NVL(MN.RESPB_SLS_OFC_CD, MN.PROP_OFC_CD) PRI_OFC_CD" ).append("\n"); 
		query.append("                    , NVL(MN.RESPB_SREP_CD, MN.PROP_SREP_CD) PRI_SREP_CD" ).append("\n"); 
		query.append("                    , MN.CTRT_CUST_CNT_CD, MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("               FROM MN_DATA A," ).append("\n"); 
		query.append("                    PRI_RP_HDR HDR, " ).append("\n"); 
		query.append("                    PRI_RP_MN MN" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("                AND A.RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("                AND A.RFA_NO = HDR.RFA_NO" ).append("\n"); 
		query.append("#if ( ${ctof} != '' )" ).append("\n"); 
		query.append("   	AND NVL(MN.RESPB_SLS_OFC_CD, MN.PROP_OFC_CD) IN (" ).append("\n"); 
		query.append("			#foreach( $ctrt_ofc_cd in ${tempCTOFList}) #if($velocityCount < $tempCTOFList.size()) '$ctrt_ofc_cd', #else '$ctrt_ofc_cd' #end #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_srep_flg2} == 'Y' && ${ob_srep_cd2} != '' )" ).append("\n"); 
		query.append("   	AND NVL(MN.RESPB_SREP_CD, MN.PROP_SREP_CD) = @[ob_srep_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("    AND MN.PROP_STS_CD  = 'A' " ).append("\n"); 
		query.append("    AND MN.AMDT_SEQ = (SELECT /*+ NO_UNNEST */" ).append("\n"); 
		query.append("                              MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                       FROM PRI_RP_MN " ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                         AND PROP_STS_CD = MN.PROP_STS_CD " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#if ( ${rfaNoList} != '' )" ).append("\n"); 
		query.append("		   AND HDR.RFA_NO IN (" ).append("\n"); 
		query.append("			#foreach( $rfaNo in ${rfaNoList}) #if($velocityCount < $rfaNoList.size()) '$rfaNo', #else '$rfaNo' #end #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${ctrt_cust} != '' )" ).append("\n"); 
		query.append("   and  MN.CTRT_CUST_CNT_CD     =   substr(@[ctrt_cust], 1, 2)" ).append("\n"); 
		query.append("   and  MN.CTRT_CUST_SEQ        =   substr(@[ctrt_cust], 3, 6)" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("             SELECT /*+ LEADING(A) USE_NL(MN)  */" ).append("\n"); 
		query.append("                    A.*, MN.RESPB_SLS_OFC_CD PRI_OFC_CD" ).append("\n"); 
		query.append("                    , MN.RESPB_SREP_CD PRI_SREP_CD" ).append("\n"); 
		query.append("                    , MN.CTRT_CUST_CNT_CD, MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("               FROM MN_DATA A," ).append("\n"); 
		query.append("                    PRI_TAA_HDR HDR, " ).append("\n"); 
		query.append("                    PRI_TAA_MN MN" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("                AND A.TAA_NO IS NOT NULL" ).append("\n"); 
		query.append("                AND A.TAA_NO = HDR.TAA_NO" ).append("\n"); 
		query.append("#if ( ${ctof} != '' )" ).append("\n"); 
		query.append("   	AND MN.RESPB_SLS_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach( $ctrt_ofc_cd in ${tempCTOFList}) #if($velocityCount < $tempCTOFList.size()) '$ctrt_ofc_cd', #else '$ctrt_ofc_cd' #end #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_srep_flg2} == 'Y' && ${ob_srep_cd2} != '' )" ).append("\n"); 
		query.append("   	AND MN.RESPB_SREP_CD = @[ob_srep_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND HDR.TAA_PROP_NO = MN.TAA_PROP_NO" ).append("\n"); 
		query.append("    AND MN.CFM_FLG  = 'Y' " ).append("\n"); 
		query.append("    AND MN.AMDT_SEQ = (SELECT /*+ NO_UNNEST */ MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                       FROM PRI_TAA_MN " ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND TAA_PROP_NO = MN.TAA_PROP_NO" ).append("\n"); 
		query.append("                         AND CFM_FLG = MN.CFM_FLG " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#if ( ${taaNoList} != '' )" ).append("\n"); 
		query.append("		   AND HDR.TAA_NO IN (" ).append("\n"); 
		query.append("			#foreach( $taaNo in ${taaNoList}) #if($velocityCount < $taaNoList.size()) '$taaNo', #else '$taaNo' #end #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${ctrt_cust} != '' )" ).append("\n"); 
		query.append("   and  MN.CTRT_CUST_CNT_CD     =   substr(@[ctrt_cust], 1, 2)" ).append("\n"); 
		query.append("   and  MN.CTRT_CUST_SEQ        =   substr(@[ctrt_cust], 3, 6)" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", MAIN AS (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    select  M.DMDT_INV_NO, decode(M.ACT_PAYR_CNT_CD , '00' , '' , M.ACT_PAYR_CNT_CD)||to_char(M.ACT_PAYR_SEQ , 'FM000000')		as PAYERC" ).append("\n"); 
		query.append("    	   ,replace( nvl(M.CUST_LGL_ENG_NM , M.VNDR_LGL_ENG_NM ) , '/' , '_' )									as PAYERN     /* PAYER NAME - CUSTOMER NAME OR VENDOR NAME */" ).append("\n"); 
		query.append("    	   ,M.INV_CURR_CD                                               										as INVOCR     /* INVOICE CURRENCY */" ).append("\n"); 
		query.append("    	   ,M.DMDT_TRF_CD                                                                                      	as TARFTP" ).append("\n"); 
		query.append("    	   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("    			 then 1" ).append("\n"); 
		query.append("                 else 0" ).append("\n"); 
		query.append("            end																									as VTINVCNT" ).append("\n"); 
		query.append("    	   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("    			 then" ).append("\n"); 
		query.append("    					(" ).append("\n"); 
		query.append("    						select  sum(T3.BIL_AMT)" ).append("\n"); 
		query.append("    						  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("    							   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("    							   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("    						 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("    						   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("    						   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("    						   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("    						   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    						   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("    						   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("    						   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("    						   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("    						   and  T2.CHG_SEQ				= T3.CHG_SEQ" ).append("\n"); 
		query.append("    					)" ).append("\n"); 
		query.append("    			 else" ).append("\n"); 
		query.append("    					M.INV_CHG_AMT" ).append("\n"); 
		query.append("    		end																								as INV_CHG_AMT" ).append("\n"); 
		query.append("    	   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("    			 then" ).append("\n"); 
		query.append("    					case when nvl(M.TAX_RTO, 0) = 0" ).append("\n"); 
		query.append("    					     then 0" ).append("\n"); 
		query.append("    						 else" ).append("\n"); 
		query.append("    								(" ).append("\n"); 
		query.append("    									select  sum(T3.BIL_AMT/M.TAX_RTO)" ).append("\n"); 
		query.append("    									  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("    										   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("    										   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("    									 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("    									   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("    									   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("    									   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("    									   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    									   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("    									   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("    									   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("    									   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("    									   and  T2.CHG_SEQ				= T3.CHG_SEQ" ).append("\n"); 
		query.append("    									)" ).append("\n"); 
		query.append("    					end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    			 else" ).append("\n"); 
		query.append("    					M.TAX_AMT" ).append("\n"); 
		query.append("    		end																								as TAX_AMT   " ).append("\n"); 
		query.append("    	   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("    			 then" ).append("\n"); 
		query.append("    					case when nvl(M.TAX_RTO, 0) = 0" ).append("\n"); 
		query.append("    						 then " ).append("\n"); 
		query.append("    								(" ).append("\n"); 
		query.append("    									select  sum(T3.BIL_AMT)" ).append("\n"); 
		query.append("    									  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("    										   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("    										   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("    									 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("    									   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("    									   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("    									   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("    									   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    									   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("    									   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("    									   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("    									   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("    									   and  T2.CHG_SEQ				= T3.CHG_SEQ															" ).append("\n"); 
		query.append("    								)" ).append("\n"); 
		query.append("    						 else" ).append("\n"); 
		query.append("    								(" ).append("\n"); 
		query.append("    									select  sum(T3.BIL_AMT + T3.BIL_AMT/M.TAX_RTO)" ).append("\n"); 
		query.append("    									  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("    										   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("    										   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("    									 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("    									   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("    									   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("    									   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("    									   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    									   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("    									   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("    									   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("    									   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("    									   and  T2.CHG_SEQ				= T3.CHG_SEQ														" ).append("\n"); 
		query.append("    								)" ).append("\n"); 
		query.append("    					end" ).append("\n"); 
		query.append("    			 else" ).append("\n"); 
		query.append("    					M.INV_AMT" ).append("\n"); 
		query.append("    		end																												AS INV_AMT" ).append("\n"); 
		query.append("    	   ,M.PRI_SREP_CD AS CTRT_SREP_CD" ).append("\n"); 
		query.append("       ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', COL_CHARGE, DECODE(V_COLLECTED, 'Y', INV_CHG_AMT, 0)) 								AS COL_CHARGE" ).append("\n"); 
		query.append("       ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', COL_TAX,    DECODE(V_COLLECTED, 'Y', TAX_AMT, 0)) 									AS COL_TAX" ).append("\n"); 
		query.append("       ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', TO_CHAR(B.COL_DATE, 'YYYY-MM-DD'), DECODE(V_COLLECTED, 'Y', AR_IF_DT, NULL)) 		AS COL_DATE						   " ).append("\n"); 
		query.append("    	-- 미수금(INVOICE CURRENCY)" ).append("\n"); 
		query.append("       ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', INV_AMT-(NVL(COL_CHARGE,0)+NVL(COL_TAX,0)), DECODE(V_COLLECTED, 'Y', 0, INV_AMT))  	AS UNCOL_AMT" ).append("\n"); 
		query.append("       ,TO_CHAR(B.COL_DUE_DT, 'YYYY-MM-DD') AS COL_DUE_DT" ).append("\n"); 
		query.append("       , USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("       , OTS_SH_GRP_CD, SND_CYC_CD, SND_CNTR_LIST_FLG, SND_INV_FLG" ).append("\n"); 
		query.append("       , (SELECT DECODE(COUNT(PAYR_CNTC_PNT_EML), 0, 'N', 'Y')" ).append("\n"); 
		query.append("          FROM   DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("          WHERE  SYS_AREA_GRP_ID = M.SVR_ID" ).append("\n"); 
		query.append("          AND    CUST_CNT_CD = M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("          AND    CUST_SEQ = M.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("          AND    REGEXP_LIKE(PAYR_CNTC_PNT_EML, @[reg_ex])) EML_EXIST_FLG" ).append("\n"); 
		query.append("       , M.PRI_OFC_CD AS CTRT_OFC_CD" ).append("\n"); 
		query.append("       , M.CTRT_CUST_CNT_CD || LPAD(M.CTRT_CUST_SEQ, 6, 0) CTRT_CUST_CD" ).append("\n"); 
		query.append("       , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = M.CTRT_CUST_CNT_CD AND CUST_SEQ = M.CTRT_CUST_SEQ) CTRT_CUST_NM" ).append("\n"); 
		query.append("       , DECODE(SC_NO, NULL, DECODE(RFA_NO, NULL, DECODE(TAA_NO, NULL, 'OTH', 'TAA'), 'RFA'), 'SC') CTRT_TP" ).append("\n"); 
		query.append("       , DECODE(SC_NO, NULL, DECODE(RFA_NO, NULL, TAA_NO, RFA_NO), SC_NO) CTRT_NO" ).append("\n"); 
		query.append("    FROM PRI_INFO M, DMT_PAYR_INFO P" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("         SELECT " ).append("\n"); 
		query.append("             A.DMDT_INV_NO " ).append("\n"); 
		query.append("    	    ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'M',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) AS COL_CHARGE" ).append("\n"); 
		query.append("            ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'V',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) AS COL_TAX" ).append("\n"); 
		query.append("            ,MAX(INV_PAY_DT) AS COL_DATE" ).append("\n"); 
		query.append("            ,MAX(INV_PAY_COFF_DT) AS COL_DUE_DT" ).append("\n"); 
		query.append("          FROM DMT_INV_OTS_PAY_RCV A, MN_DATA B" ).append("\n"); 
		query.append("          WHERE A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("          GROUP BY A.DMDT_INV_NO" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("      WHERE M.DMDT_INV_NO = B.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("        AND M.ACT_PAYR_CNT_CD = P.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("        AND M.ACT_PAYR_SEQ = P.CUST_SEQ(+)" ).append("\n"); 
		query.append("        AND M.SVR_ID = P.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("    #if ( ${coll} != '' && ${coll} != 'A' )	 " ).append("\n"); 
		query.append("    	AND  " ).append("\n"); 
		query.append("        #if ( ${coll} == 'N' ) " ).append("\n"); 
		query.append("        		DECODE(AUTO_AR_IF_OFC_FLG, 'Y', INV_AMT-(NVL(COL_CHARGE,0)+NVL(COL_TAX,0)), DECODE(V_COLLECTED, 'Y', 0, INV_AMT)) != 0 " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("        		DECODE(AUTO_AR_IF_OFC_FLG, 'Y', INV_AMT-(NVL(COL_CHARGE,0)+NVL(COL_TAX,0)), DECODE(V_COLLECTED, 'Y', 0, INV_AMT)) = 0 " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select  CTRT_SREP_CD" ).append("\n"); 
		query.append("        , CTRT_OFC_CD" ).append("\n"); 
		query.append("#if ( ${chk_ctrt_cust} != '' && ${chk_ctrt_cust} != 'N' )" ).append("\n"); 
		query.append("        , CTRT_CUST_CD" ).append("\n"); 
		query.append("        , CTRT_CUST_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_ctrt_no} != '' && ${chk_ctrt_no} != 'N' )" ).append("\n"); 
		query.append("        , CTRT_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_payr_info} != '' && ${chk_payr_info} != 'N' )	 " ).append("\n"); 
		query.append("        , PAYERC" ).append("\n"); 
		query.append("        , PAYERN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,sum(INVOCN )                     					as INVOCN" ).append("\n"); 
		query.append("#if(${chk_usd} != '' && ${chk_usd} == 'Y')" ).append("\n"); 
		query.append("       ,'USD'	as INVOCR" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       ,INVOCR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'DMIF', 1, 0)) 					as DMIFYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'DTIC', 1, 0)) 					as DTICYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'DMOF', 1, 0)) 					as DMOFYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'DTOC', 1, 0)) 					as DTOCYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'CTIC', 1, 0)) 					as CTICYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'CTOC', 1, 0)) 					as CTOCYN" ).append("\n"); 
		query.append("	   ,case when sum(VTINVCNT) > 0 then 'Y' else 'N' end	as DMDT_VT_INV_YN" ).append("\n"); 
		query.append("#if(${chk_usd} != '' && ${chk_usd} == 'Y')" ).append("\n"); 
		query.append("       ,ROUND(sum(BLLAMT ), 2)  					AS BLLAMT" ).append("\n"); 
		query.append("       ,ROUND(sum(TAXAMT ), 2)                     	as TAXAMT" ).append("\n"); 
		query.append("       ,ROUND(sum(TOTAMT ), 2)     					as TOTAMT" ).append("\n"); 
		query.append("       ,ROUND(sum(COL_CHARGE), 2) 					AS COL_CHARGE" ).append("\n"); 
		query.append("       ,ROUND(sum(COL_TAX), 2)  					AS COL_TAX" ).append("\n"); 
		query.append("	   ,ROUND(sum(UNCOL_AMT), 2)  					AS UNCOL_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       ,sum(BLLAMT )                     					as BLLAMT" ).append("\n"); 
		query.append("       ,sum(TAXAMT )                     					as TAXAMT" ).append("\n"); 
		query.append("       ,sum(TOTAMT )                     					as TOTAMT" ).append("\n"); 
		query.append("       ,sum(COL_CHARGE) AS COL_CHARGE" ).append("\n"); 
		query.append("       ,sum(COL_TAX) AS COL_TAX" ).append("\n"); 
		query.append("	   ,sum(UNCOL_AMT) AS UNCOL_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,CASE WHEN MAX(COL_DATE) = '0000-01-01' THEN '' ELSE MAX(COL_DATE) END AS COL_DATE" ).append("\n"); 
		query.append("       , CTRT_TP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from    (" ).append("\n"); 
		query.append("			select  PAYERC" ).append("\n"); 
		query.append("				   ,PAYERN" ).append("\n"); 
		query.append("				   ,CTRT_SREP_CD" ).append("\n"); 
		query.append("				   ,INVOCR" ).append("\n"); 
		query.append("				   ,TARFTP" ).append("\n"); 
		query.append("				   ,nvl(count(*) , 0 )                                         												as INVOCN     /* INVOICE 개수 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${chk_usd} != '' && ${chk_usd} == 'Y')" ).append("\n"); 
		query.append("				   ,nvl(sum(INV_CHG_AMT/USD_LOCL_XCH_RT ) , 0 )                                                                     		as BLLAMT     /* TOTAL INVOICE BILLING AMOUNT */" ).append("\n"); 
		query.append("				   ,nvl(sum(TAX_AMT/USD_LOCL_XCH_RT     ) , 0 )                                                                     		as TAXAMT     /* TOTAL INVOICE TAX AMOUNT */" ).append("\n"); 
		query.append("				   ,nvl(sum(INV_AMT/USD_LOCL_XCH_RT     ) , 0 )                                                                     		as TOTAMT     /* TOTAL INVOICE AMOUNT = TOTAL BILLING AMOUNT + TOTAL TAX AMOUNT */			" ).append("\n"); 
		query.append("				   ,sum(UNCOL_AMT/USD_LOCL_XCH_RT) 											AS UNCOL_AMT" ).append("\n"); 
		query.append("				   ,sum(COL_CHARGE/USD_LOCL_XCH_RT)											AS COL_CHARGE" ).append("\n"); 
		query.append("				   ,sum(COL_TAX/USD_LOCL_XCH_RT)											AS COL_TAX" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				   ,nvl(sum(INV_CHG_AMT ) , 0 )                                                                     		as BLLAMT     /* TOTAL INVOICE BILLING AMOUNT */" ).append("\n"); 
		query.append("				   ,nvl(sum(TAX_AMT     ) , 0 )                                                                     		as TAXAMT     /* TOTAL INVOICE TAX AMOUNT */" ).append("\n"); 
		query.append("				   ,nvl(sum(INV_AMT     ) , 0 )                                                                     		as TOTAMT     /* TOTAL INVOICE AMOUNT = TOTAL BILLING AMOUNT + TOTAL TAX AMOUNT */			" ).append("\n"); 
		query.append("				   ,sum(UNCOL_AMT) 											AS UNCOL_AMT" ).append("\n"); 
		query.append("				   ,sum(COL_CHARGE)											AS COL_CHARGE" ).append("\n"); 
		query.append("				   ,sum(COL_TAX)											AS COL_TAX" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				   ,sum(VTINVCNT)																							as VTINVCNT" ).append("\n"); 
		query.append("                   ,MAX(CASE WHEN COL_DATE IS NULL THEN '0000-01-01' ELSE COL_DATE END) AS COL_DATE" ).append("\n"); 
		query.append("				   , USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , CTRT_OFC_CD" ).append("\n"); 
		query.append("                   , CTRT_CUST_CD" ).append("\n"); 
		query.append("                   , CTRT_CUST_NM" ).append("\n"); 
		query.append("                   , CTRT_TP" ).append("\n"); 
		query.append("                   , CTRT_NO" ).append("\n"); 
		query.append("			  from  MAIN" ).append("\n"); 
		query.append("			group by PAYERC" ).append("\n"); 
		query.append("                    ,PAYERN" ).append("\n"); 
		query.append("					,INVOCR" ).append("\n"); 
		query.append("					,TARFTP" ).append("\n"); 
		query.append("					, CTRT_SREP_CD" ).append("\n"); 
		query.append("                    , CTRT_OFC_CD" ).append("\n"); 
		query.append("                    , CTRT_CUST_CD" ).append("\n"); 
		query.append("                    , CTRT_CUST_NM" ).append("\n"); 
		query.append("                    , CTRT_TP" ).append("\n"); 
		query.append("                    , CTRT_NO" ).append("\n"); 
		query.append("					, USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append(" where  1 = 1" ).append("\n"); 
		query.append("group by CTRT_SREP_CD" ).append("\n"); 
		query.append("        , CTRT_OFC_CD" ).append("\n"); 
		query.append("#if ( ${chk_ctrt_cust} != '' && ${chk_ctrt_cust} != 'N' )" ).append("\n"); 
		query.append("        , CTRT_CUST_CD" ).append("\n"); 
		query.append("        , CTRT_CUST_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_ctrt_no} != '' && ${chk_ctrt_no} != 'N' )" ).append("\n"); 
		query.append("        , CTRT_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_payr_info} != '' && ${chk_payr_info} != 'N' )	 " ).append("\n"); 
		query.append("        , PAYERC" ).append("\n"); 
		query.append("        , PAYERN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${chk_usd} != '' && ${chk_usd} == 'Y')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        , INVOCR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , CTRT_TP" ).append("\n"); 
		query.append("order by CTRT_SREP_CD" ).append("\n"); 

	}
}
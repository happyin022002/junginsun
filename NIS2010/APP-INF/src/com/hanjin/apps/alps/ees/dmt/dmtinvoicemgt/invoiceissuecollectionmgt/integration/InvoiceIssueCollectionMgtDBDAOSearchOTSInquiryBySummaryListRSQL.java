/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4009
	  * Outstanding Inquiry by Customer N Issue
	  * 이성훈
	  * SungHoon, Lee
	  * 2011.06.02 김현화[] DATE 조건 형식변경
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_rhq_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfan",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cuno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL").append("\n"); 
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
		query.append("       ,V.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("       ,M.INV_CURR_CD " ).append("\n"); 
		query.append("       ,V.DELT_FLG " ).append("\n"); 
		query.append("       ,U.DELT_FLG" ).append("\n"); 
		query.append("       ,U.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       ,M.DMDT_TRF_CD " ).append("\n"); 
		query.append("       ,M.INV_CHG_AMT" ).append("\n"); 
		query.append("       ,M.TAX_AMT" ).append("\n"); 
		query.append("       ,M.DMDT_INV_STS_CD " ).append("\n"); 
		query.append("       ,M.TAX_RTO" ).append("\n"); 
		query.append("       ,M.INV_AMT" ).append("\n"); 
		query.append("       ,V.DELT_FLG AS V_DELT_FLG" ).append("\n"); 
		query.append("       ,U.DELT_FLG AS U_DELT_FLG" ).append("\n"); 
		query.append("       ,M.CRE_OFC_CD" ).append("\n"); 
		query.append("       ,INV_XCH_RT" ).append("\n"); 
		query.append("       ,TO_CHAR(AR_IF_DT, 'YYYY-MM-DD') AS AR_IF_DT" ).append("\n"); 
		query.append("--     ,CASE " ).append("\n"); 
		query.append("--			WHEN (NVL(OTS_CLT_FLG,'N') !='Y' AND DMDT_INV_STS_CD = 'I' AND DMDT_AR_IF_CD = 'Y' AND ATTR_CTNT1 IS NULL) THEN" ).append("\n"); 
		query.append("--				'Y'" ).append("\n"); 
		query.append("--          ELSE " ).append("\n"); 
		query.append("--				'N'" ).append("\n"); 
		query.append("--      END V_COLLECTED  " ).append("\n"); 
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
		query.append("		END V_COLLECTED				" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN ATTR_CTNT1 IS NOT NULL THEN " ).append("\n"); 
		query.append("				'Y' " ).append("\n"); 
		query.append("			ELSE " ).append("\n"); 
		query.append("				'N' " ).append("\n"); 
		query.append("		END AUTO_AR_IF_OFC_FLG       -- AUTO I/F OFFICE 인지 여부를 나타내는 FLAG	 " ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  SYS_AREA_GRP_ID SVR_ID " ).append("\n"); 
		query.append("			  FROM  COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			 WHERE  CNT_CD = " ).append("\n"); 
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
		query.append("	#if ( ${chk_srep_flg} == 'Y' )" ).append("\n"); 
		query.append("       ,B.OB_SREP_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("  FROM  DMT_INV_MN    		M				" ).append("\n"); 
		query.append("       ,MDM_CUSTOMER  		U" ).append("\n"); 
		query.append("       ,MDM_VENDOR    		V" ).append("\n"); 
		query.append("	   ,DMT_HRD_CDG_CTNT 	D" ).append("\n"); 
		query.append("	#if ( ${chk_srep_flg} == 'Y' )" ).append("\n"); 
		query.append("       ,BKG_BOOKING   B" ).append("\n"); 
		query.append("	#end     " ).append("\n"); 
		query.append("	#if ( ${h_rhq_off} != 'SELHO' )" ).append("\n"); 
		query.append("       ,MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  M.CRE_OFC_CD = D.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND  D.HRD_CDG_ID(+) = 'AUTO_AR_IF_OFC'" ).append("\n"); 
		query.append("#if ( ${chk_srep_flg} == 'Y' )" ).append("\n"); 
		query.append("   AND  M.BKG_NO     = B.BKG_NO (+) -- Purge Booking data exists." ).append("\n"); 
		query.append("	#if ( ${ob_srep_cd} != '' )" ).append("\n"); 
		query.append("   AND  B.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND  M.CRE_DT BETWEEN TO_DATE(REPLACE(@[frdt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[todt],'-',''), 'YYYYMMDD') + .99999       /* INVOICE ISSUE DATE */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${isof} != '' )" ).append("\n"); 
		query.append("   AND  M.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach( $cre_ofc_cd_p in ${tempISOFList}) " ).append("\n"); 
		query.append("				#if($velocityCount < $tempISOFList.size()) '$cre_ofc_cd_p', #else '$cre_ofc_cd_p' #end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  (M.DMDT_INV_STS_CD = 'I' or (M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C'))	-- NOT CANCELED INVOICE or VIRTUAL INVOICE modified 2014.12.30 by jameskai" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${h_rhq_off} != 'SELHO' )" ).append("\n"); 
		query.append("   and  M.CRE_OFC_CD         = MO.OFC_CD" ).append("\n"); 
		query.append("   and  MO.AR_HD_QTR_OFC_CD  = @[h_rhq_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${arif} != '' )" ).append("\n"); 
		query.append("	AND ( 1!=1 " ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("   and  M.ACT_PAYR_CNT_CD   =   U.CUST_CNT_CD(+)                                    /* PAYER NAME 가져오기 위해 OUTER JOIN */" ).append("\n"); 
		query.append("   and  M.ACT_PAYR_SEQ      =   U.CUST_SEQ(+)" ).append("\n"); 
		query.append("   and  M.ACT_PAYR_SEQ      =   V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${tftp} != 'A' )" ).append("\n"); 
		query.append("   and  M.DMDT_TRF_CD in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			#foreach( $dmdt_trf_cd_p in ${tempTFTPList}) " ).append("\n"); 
		query.append("				#if($velocityCount < $tempTFTPList.size()) " ).append("\n"); 
		query.append("				   '$dmdt_trf_cd_p', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("				   '$dmdt_trf_cd_p' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and  M.ACT_PAYR_CNT_CD     =   decode(length(@[payc]), 8, nvl(substr(@[payc], 1, 2), M.ACT_PAYR_CNT_CD), 6, M.ACT_PAYR_CNT_CD, M.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("   and  M.ACT_PAYR_SEQ        =   decode(length(@[payc]), 8, nvl(substr(@[payc], 3, 6), M.ACT_PAYR_SEQ),    6, @[payc],           M.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("   and  (   /* ------------------------------------------------------------------- SC NO */" ).append("\n"); 
		query.append("			M.SC_NO     =   nvl(substr(@[scno], 1, 10), M.SC_NO)" ).append("\n"); 
		query.append("			or" ).append("\n"); 
		query.append("			nvl(M.SC_NO, ' ') = nvl(substr( @[scno], 1, 10), ' ')" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   and  (   /* ------------------------------------------------------------------- RFA NO */" ).append("\n"); 
		query.append("			M.RFA_NO     =   nvl(substr(@[rfan], 1, 10), M.RFA_NO)" ).append("\n"); 
		query.append("			or" ).append("\n"); 
		query.append("			nvl(M.RFA_NO, ' ') = nvl(substr(@[rfan], 1, 10), ' ')" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#if ( ${prg_ex_in_cd} == 'EX' )" ).append("\n"); 
		query.append("   and  nvl(M.PRG_FLG, 'N') = 'N'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("#elseif ( ${prg_ex_in_cd} == 'ON' )" ).append("\n"); 
		query.append("   and  nvl(M.PRG_FLG, 'N') = 'Y'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${cuno} != '' )" ).append("\n"); 
		query.append("   and  M.BKG_NO in" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			select  BKG_NO" ).append("\n"); 
		query.append("			  from  BKG_CUSTOMER    BC" ).append("\n"); 
		query.append("			 where  BC.CUST_CNT_CD = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						case when @[cuno] is null then BC.CUST_CNT_CD else substr(@[cuno], 1, 2) end" ).append("\n"); 
		query.append("					) -- 2013.10.22 (ALPS 통합 로그 Error) 숫자 컬럼에 문자 입력시 ORACLE Exception Error가 발생하지 않도록 처리함." ).append("\n"); 
		query.append("			   and  BC.CUST_SEQ = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						case when @[cuno] is null then BC.CUST_SEQ" ).append("\n"); 
		query.append("							 when REGEXP_INSTR(substr(@[cuno], 3, 6), '[[:alpha:]]', 1, 1) = 0 then to_number(substr(@[cuno], 3, 6))" ).append("\n"); 
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
		query.append(")" ).append("\n"); 
		query.append("select  PAYERC" ).append("\n"); 
		query.append("       ,PAYERN" ).append("\n"); 
		query.append("#if ( ${chk_srep_flg} == 'Y' )" ).append("\n"); 
		query.append("       ,OB_SREP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,sum(INVOCN )                     					as INVOCN" ).append("\n"); 
		query.append("       ,INVOCR" ).append("\n"); 
		query.append("       ,sum(BLLAMT )                     					as BLLAMT" ).append("\n"); 
		query.append("       ,sum(TAXAMT )                     					as TAXAMT" ).append("\n"); 
		query.append("       ,sum(TOTAMT )                     					as TOTAMT" ).append("\n"); 
		query.append("       ,USEFLG" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'DMIF', 1, 0)) 					as DMIFYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'DTIC', 1, 0)) 					as DTICYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'DMOF', 1, 0)) 					as DMOFYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'DTOC', 1, 0)) 					as DTOCYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'CTIC', 1, 0)) 					as CTICYN" ).append("\n"); 
		query.append("       ,sum(decode(TARFTP, 'CTOC', 1, 0)) 					as CTOCYN" ).append("\n"); 
		query.append("	   ,case when sum(VTINVCNT) > 0 then 'Y' else 'N' end	as DMDT_VT_INV_YN" ).append("\n"); 
		query.append("       ,sum(COL_CHARGE) AS COL_CHARGE" ).append("\n"); 
		query.append("       ,sum(COL_TAX) AS COL_TAX" ).append("\n"); 
		query.append("       ,MAX(COL_DATE) AS COL_DATE" ).append("\n"); 
		query.append("	   ,sum(UNCOL_AMT) AS UNCOL_AMT" ).append("\n"); 
		query.append("--       , SND_CYC_CD" ).append("\n"); 
		query.append("       , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("            FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE  INTG_CD_ID = 'CD03506'" ).append("\n"); 
		query.append("            AND INTG_CD_VAL_CTNT = SND_CYC_CD" ).append("\n"); 
		query.append("            AND    APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("            AND    APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD')) AS SND_CYC_CD" ).append("\n"); 
		query.append("--	   , OTS_SH_GRP_CD       " ).append("\n"); 
		query.append("       , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("            FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE  INTG_CD_ID = 'CD03507'" ).append("\n"); 
		query.append("            AND INTG_CD_VAL_CTNT = OTS_SH_GRP_CD" ).append("\n"); 
		query.append("            AND    APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("            AND    APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD')) AS OTS_SH_GRP_CD" ).append("\n"); 
		query.append("	   , SND_CNTR_LIST_FLG" ).append("\n"); 
		query.append("	   , SND_INV_FLG" ).append("\n"); 
		query.append("       , EML_EXIST_FLG" ).append("\n"); 
		query.append("from    (" ).append("\n"); 
		query.append("			select  PAYERC" ).append("\n"); 
		query.append("				   ,PAYERN" ).append("\n"); 
		query.append("				#if ( ${chk_srep_flg} == 'Y' )        " ).append("\n"); 
		query.append("				   ,OB_SREP_CD" ).append("\n"); 
		query.append("				#end 				   " ).append("\n"); 
		query.append("				   ,INVOCR" ).append("\n"); 
		query.append("				   ,USEFLG" ).append("\n"); 
		query.append("				   ,TARFTP" ).append("\n"); 
		query.append("				   ,nvl(count(*) , 0 )                                         												as INVOCN     /* INVOICE 개수 */" ).append("\n"); 
		query.append("				   ,nvl(sum(INV_CHG_AMT ) , 0 )                                                                     		as BLLAMT     /* TOTAL INVOICE BILLING AMOUNT */" ).append("\n"); 
		query.append("				   ,nvl(sum(TAX_AMT     ) , 0 )                                                                     		as TAXAMT     /* TOTAL INVOICE TAX AMOUNT */" ).append("\n"); 
		query.append("				   ,nvl(sum(INV_AMT     ) , 0 )                                                                     		as TOTAMT     /* TOTAL INVOICE AMOUNT = TOTAL BILLING AMOUNT + TOTAL TAX AMOUNT */			" ).append("\n"); 
		query.append("   				   ,sum(VTINVCNT)																							as VTINVCNT" ).append("\n"); 
		query.append("				   ,sum(UNCOL_AMT) 											AS UNCOL_AMT" ).append("\n"); 
		query.append("				   ,sum(COL_CHARGE)											AS COL_CHARGE" ).append("\n"); 
		query.append("				   ,sum(COL_TAX)											AS COL_TAX" ).append("\n"); 
		query.append("                   ,max(COL_DATE)											AS COL_DATE" ).append("\n"); 
		query.append("--				   ,SUM(DECODE(AUTO_AR_IF_OFC_FLG, 'Y', COL_CHARGE, 0))		AS COL_CHARGE" ).append("\n"); 
		query.append("--    			   ,SUM(DECODE(AUTO_AR_IF_OFC_FLG, 'Y', COL_TAX,    0))		AS COL_TAX" ).append("\n"); 
		query.append("--    			   ,MAX(DECODE(AUTO_AR_IF_OFC_FLG, 'Y', COL_DATE, NULL))	AS COL_DATE" ).append("\n"); 
		query.append("				   , OTS_SH_GRP_CD" ).append("\n"); 
		query.append("				   , SND_CYC_CD" ).append("\n"); 
		query.append("				   , SND_CNTR_LIST_FLG" ).append("\n"); 
		query.append("				   , SND_INV_FLG" ).append("\n"); 
		query.append("                   , EML_EXIST_FLG" ).append("\n"); 
		query.append("			  from  (" ).append("\n"); 
		query.append("						select  decode(M.ACT_PAYR_CNT_CD , '00' , '' , M.ACT_PAYR_CNT_CD)||to_char(M.ACT_PAYR_SEQ , 'FM000000')		as PAYERC" ).append("\n"); 
		query.append("							   ,REPLACE( nvl(M.CUST_LGL_ENG_NM , M.VNDR_LGL_ENG_NM ) , '/' , '_' )									as PAYERN     /* PAYER NAME - CUSTOMER NAME OR VENDOR NAME */" ).append("\n"); 
		query.append("							   ,M.INV_CURR_CD                                               										as INVOCR     /* INVOICE CURRENCY */" ).append("\n"); 
		query.append("							   ,decode(nvl(M.CUST_LGL_ENG_NM , 'A' ) , 'A' , V_DELT_FLG , U_DELT_FLG )                          	as USEFLG" ).append("\n"); 
		query.append("							   ,M.DMDT_TRF_CD                                                                                      	as TARFTP" ).append("\n"); 
		query.append("							   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("									 then 1" ).append("\n"); 
		query.append("                                     else 0" ).append("\n"); 
		query.append("                                end																									as VTINVCNT" ).append("\n"); 
		query.append("							   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("									 then" ).append("\n"); 
		query.append("											(" ).append("\n"); 
		query.append("												select  sum(T3.BIL_AMT)" ).append("\n"); 
		query.append("												  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("													   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("													   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("												 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("												   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("												   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("												   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("												   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("												   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("												   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("												   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("												   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("												   and  T2.CHG_SEQ				= T3.CHG_SEQ" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("									 else" ).append("\n"); 
		query.append("											M.INV_CHG_AMT" ).append("\n"); 
		query.append("								end																								as INV_CHG_AMT" ).append("\n"); 
		query.append("							   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("									 then" ).append("\n"); 
		query.append("											case when nvl(M.TAX_RTO, 0) = 0" ).append("\n"); 
		query.append("											     then 0" ).append("\n"); 
		query.append("												 else" ).append("\n"); 
		query.append("														(" ).append("\n"); 
		query.append("															select  sum(T3.BIL_AMT/M.TAX_RTO)" ).append("\n"); 
		query.append("															  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("																   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("																   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("															 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("															   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("															   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("															   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("															   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("															   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("															   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("															   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("															   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("															   and  T2.CHG_SEQ				= T3.CHG_SEQ" ).append("\n"); 
		query.append("															)" ).append("\n"); 
		query.append("											end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									 else" ).append("\n"); 
		query.append("											M.TAX_AMT" ).append("\n"); 
		query.append("								end																								as TAX_AMT   " ).append("\n"); 
		query.append("							   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("									 then" ).append("\n"); 
		query.append("											case when nvl(M.TAX_RTO, 0) = 0" ).append("\n"); 
		query.append("												 then " ).append("\n"); 
		query.append("														(" ).append("\n"); 
		query.append("															select  sum(T3.BIL_AMT)" ).append("\n"); 
		query.append("															  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("																   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("																   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("															 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("															   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("															   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("															   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("															   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("															   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("															   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("															   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("															   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("															   and  T2.CHG_SEQ				= T3.CHG_SEQ															" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("												 else" ).append("\n"); 
		query.append("														(" ).append("\n"); 
		query.append("															select  sum(T3.BIL_AMT + T3.BIL_AMT/M.TAX_RTO)" ).append("\n"); 
		query.append("															  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("																   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("																   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("															 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("															   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("															   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("															   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("															   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("															   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("															   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("															   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("															   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("															   and  T2.CHG_SEQ				= T3.CHG_SEQ														" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("											end" ).append("\n"); 
		query.append("									 else" ).append("\n"); 
		query.append("											M.INV_AMT" ).append("\n"); 
		query.append("								end																												AS INV_AMT" ).append("\n"); 
		query.append("							#if ( ${chk_srep_flg} == 'Y' )        " ).append("\n"); 
		query.append("							   ,M.OB_SREP_CD" ).append("\n"); 
		query.append("							#end       " ).append("\n"); 
		query.append("						   ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', COL_CHARGE, DECODE(V_COLLECTED, 'Y', INV_CHG_AMT, 0)) 								AS COL_CHARGE" ).append("\n"); 
		query.append("						   ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', COL_TAX,    DECODE(V_COLLECTED, 'Y', TAX_AMT, 0)) 									AS COL_TAX" ).append("\n"); 
		query.append("						   ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', TO_CHAR(B.COL_DATE, 'YYYY-MM-DD'), DECODE(V_COLLECTED, 'Y', AR_IF_DT, NULL)) 		AS COL_DATE						   " ).append("\n"); 
		query.append("							-- 미수금(INVOICE CURRENCY)" ).append("\n"); 
		query.append("						   ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', INV_AMT-(NVL(COL_CHARGE,0)+NVL(COL_TAX,0)), DECODE(V_COLLECTED, 'Y', 0, INV_AMT))  	AS UNCOL_AMT" ).append("\n"); 
		query.append("                           ,TO_CHAR(B.COL_DUE_DT, 'YYYY-MM-DD') AS COL_DUE_DT" ).append("\n"); 
		query.append("						   , OTS_SH_GRP_CD, SND_CYC_CD, SND_CNTR_LIST_FLG, SND_INV_FLG" ).append("\n"); 
		query.append("                           , (SELECT DECODE(COUNT(PAYR_CNTC_PNT_EML), 0, 'N', 'Y')" ).append("\n"); 
		query.append("                              FROM   DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("                              WHERE  SYS_AREA_GRP_ID = M.SVR_ID" ).append("\n"); 
		query.append("                              AND    CUST_CNT_CD = M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("                              AND    CUST_SEQ = M.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("                              AND    REGEXP_LIKE(PAYR_CNTC_PNT_EML, @[reg_ex])) EML_EXIST_FLG" ).append("\n"); 
		query.append("						FROM MN_DATA M, DMT_PAYR_INFO P" ).append("\n"); 
		query.append("                        ,(" ).append("\n"); 
		query.append("                             SELECT " ).append("\n"); 
		query.append("                                 A.DMDT_INV_NO " ).append("\n"); 
		query.append("							    ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'M',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) AS COL_CHARGE" ).append("\n"); 
		query.append("    	                        ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'V',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) AS COL_TAX" ).append("\n"); 
		query.append("                                ,MAX(INV_PAY_DT) AS COL_DATE" ).append("\n"); 
		query.append("                                ,MAX(INV_PAY_COFF_DT) AS COL_DUE_DT" ).append("\n"); 
		query.append("                              FROM DMT_INV_OTS_PAY_RCV A, MN_DATA B" ).append("\n"); 
		query.append("                              WHERE A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("                              GROUP BY A.DMDT_INV_NO" ).append("\n"); 
		query.append("                          ) B" ).append("\n"); 
		query.append("                          WHERE M.DMDT_INV_NO = B.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("                            AND M.ACT_PAYR_CNT_CD = P.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                            AND M.ACT_PAYR_SEQ = P.CUST_SEQ(+)" ).append("\n"); 
		query.append("                            AND M.SVR_ID = P.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("#if ( ${coll} != '' && ${coll} != 'A' )	 " ).append("\n"); 
		query.append("				AND  " ).append("\n"); 
		query.append("	#if ( ${coll} == 'N' ) " ).append("\n"); 
		query.append("					DECODE(AUTO_AR_IF_OFC_FLG, 'Y', INV_AMT-(NVL(COL_CHARGE,0)+NVL(COL_TAX,0)), DECODE(V_COLLECTED, 'Y', 0, INV_AMT)) != 0 " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("					DECODE(AUTO_AR_IF_OFC_FLG, 'Y', INV_AMT-(NVL(COL_CHARGE,0)+NVL(COL_TAX,0)), DECODE(V_COLLECTED, 'Y', 0, INV_AMT)) = 0 " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			group by PAYERC" ).append("\n"); 
		query.append("                    ,PAYERN" ).append("\n"); 
		query.append("					,INVOCR" ).append("\n"); 
		query.append("					,USEFLG" ).append("\n"); 
		query.append("					,TARFTP" ).append("\n"); 
		query.append("					, OTS_SH_GRP_CD" ).append("\n"); 
		query.append("					, SND_CYC_CD" ).append("\n"); 
		query.append("					, SND_CNTR_LIST_FLG" ).append("\n"); 
		query.append("					, SND_INV_FLG" ).append("\n"); 
		query.append("					, EML_EXIST_FLG" ).append("\n"); 
		query.append("				#if ( ${chk_srep_flg} == 'Y' )" ).append("\n"); 
		query.append("					,OB_SREP_CD" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(" where  1 = 1" ).append("\n"); 
		query.append("group by PAYERC" ).append("\n"); 
		query.append("        ,PAYERN" ).append("\n"); 
		query.append("        ,INVOCR" ).append("\n"); 
		query.append("        ,USEFLG" ).append("\n"); 
		query.append("		, OTS_SH_GRP_CD" ).append("\n"); 
		query.append("		, SND_CYC_CD" ).append("\n"); 
		query.append("		, SND_CNTR_LIST_FLG" ).append("\n"); 
		query.append("		, SND_INV_FLG" ).append("\n"); 
		query.append("        , EML_EXIST_FLG" ).append("\n"); 
		query.append("	#if ( ${chk_srep_flg} == 'Y' )" ).append("\n"); 
		query.append("        ,OB_SREP_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("order by PAYERC" ).append("\n"); 
		query.append("	#if ( ${chk_srep_flg} == 'Y' )" ).append("\n"); 
		query.append("        ,OB_SREP_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_DMT_4011
	  * Outstanding Inquiry by Customer N Issue - Detail(s)
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cutp",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL").append("\n"); 
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
		query.append("SELECT  M.DMDT_INV_NO" ).append("\n"); 
		query.append("       ,M.VSL_CD" ).append("\n"); 
		query.append("       ,M.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,M.SKD_DIR_CD  " ).append("\n"); 
		query.append("       ,M.BKG_NO       " ).append("\n"); 
		query.append("       ,M.BL_NO        " ).append("\n"); 
		query.append("       ,M.TAX_RTO" ).append("\n"); 
		query.append("       ,M.INV_CURR_CD  " ).append("\n"); 
		query.append("       ,M.INV_CHG_AMT" ).append("\n"); 
		query.append("       ,M.TAX_AMT" ).append("\n"); 
		query.append("       ,M.INV_AMT" ).append("\n"); 
		query.append("       ,M.DMDT_TRF_CD      " ).append("\n"); 
		query.append("       ,M.CRE_DT                    " ).append("\n"); 
		query.append("       ,M.CRE_OFC_CD" ).append("\n"); 
		query.append("       ,M.POR_CD" ).append("\n"); 
		query.append("       ,M.POL_CD" ).append("\n"); 
		query.append("       ,M.POD_CD" ).append("\n"); 
		query.append("       ,M.DEL_CD" ).append("\n"); 
		query.append("       ,B.OB_SREP_CD" ).append("\n"); 
		query.append("       ,A.ORG_CHG_AMT" ).append("\n"); 
		query.append("       ,B.RFA_NO" ).append("\n"); 
		query.append("       ,B.SC_NO" ).append("\n"); 
		query.append("       ,B.TAA_NO" ).append("\n"); 
		query.append("       ,SH.CUST_CNT_CD AS S_CUST_CNT_CD" ).append("\n"); 
		query.append("       ,SH.CUST_SEQ AS S_CUST_SEQ" ).append("\n"); 
		query.append("       ,SH.CUST_NM AS S_CUST_NM" ).append("\n"); 
		query.append("       ,CN.CUST_CNT_CD AS C_CUST_CNT_CD" ).append("\n"); 
		query.append("       ,CN.CUST_SEQ AS C_CUST_SEQ" ).append("\n"); 
		query.append("       ,CN.CUST_NM AS C_CUST_NM" ).append("\n"); 
		query.append("       ,SUM(A.CMDT_EXPT_AMT) AS CMDT_EXPT_AMT" ).append("\n"); 
		query.append("       ,SUM(A.SC_RFA_EXPT_AMT) AS SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("       ,SUM(A.AFT_EXPT_DC_AMT) AS AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("       ,M.INV_RMK" ).append("\n"); 
		query.append("       ,M.CXL_RMK" ).append("\n"); 
		query.append("       ,M.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("       ,M.DMDT_VT_INV_STS_CD" ).append("\n"); 
		query.append("       ,OTS_CLT_FLG" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN (NVL(OTS_CLT_FLG,'N') !='Y' AND DMDT_INV_STS_CD = 'I' AND DMDT_AR_IF_CD = 'Y' AND ATTR_CTNT1 IS NULL) THEN " ).append("\n"); 
		query.append("				'Y'" ).append("\n"); 
		query.append("			ELSE " ).append("\n"); 
		query.append("				'N'" ).append("\n"); 
		query.append("		END V_COLLECTED" ).append("\n"); 
		query.append("	   ,INV_XCH_RT" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  DMT_INV_MN   		M" ).append("\n"); 
		query.append("       ,DMT_INV_DTL	 		MD" ).append("\n"); 
		query.append("       ,BKG_BOOKING  		B" ).append("\n"); 
		query.append("       ,DMT_CHG_CALC 		A" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER 		SH" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER 		CN" ).append("\n"); 
		query.append("       ,DMT_HRD_CDG_CTNT 	D" ).append("\n"); 
		query.append("#if (${h_rhq_off} != 'SELHO')" ).append("\n"); 
		query.append("       ,MDM_ORGANIZATION 	MO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE  1 = 1 " ).append("\n"); 
		query.append("   AND  M.DMDT_INV_NO   = MD.DMDT_INV_NO    (+)" ).append("\n"); 
		query.append("   AND  MD.DMDT_INV_NO  = A.DMDT_INV_NO     (+) " ).append("\n"); 
		query.append("   AND  MD.CNTR_NO      = A.CNTR_NO         (+)" ).append("\n"); 
		query.append("   AND  M.CRE_OFC_CD    = D.ATTR_CTNT1      (+)" ).append("\n"); 
		query.append("   AND  D.HRD_CDG_ID(+) = 'AUTO_AR_IF_OFC'" ).append("\n"); 
		query.append("   AND  M.BKG_NO        = SH.BKG_NO         (+)" ).append("\n"); 
		query.append("   AND  'S'             = SH.BKG_CUST_TP_CD (+)" ).append("\n"); 
		query.append("   AND  M.BKG_NO        = CN.BKG_NO         (+)" ).append("\n"); 
		query.append("   AND  'C'             = CN.BKG_CUST_TP_CD (+)" ).append("\n"); 
		query.append("   AND  M.BKG_NO        = B.BKG_NO          (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${arif} != '')" ).append("\n"); 
		query.append("   AND  ( 1!=1 " ).append("\n"); 
		query.append("		#if (${uncollected} == 'N')" ).append("\n"); 
		query.append("		OR (DMDT_INV_STS_CD  IN ('I','X','C') AND DMDT_AR_IF_CD = 'N')								--// AUTO I/F OFFICE 가 아닌 경우" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${collected} == 'Y')" ).append("\n"); 
		query.append("		OR ( DMDT_AR_IF_CD = 'Y' )" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${hold} == 'H')" ).append("\n"); 
		query.append("		OR M.DMDT_AR_IF_CD = 'H'" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${hold_Litigation} == 'L')" ).append("\n"); 
		query.append("		OR (M.DMDT_AR_IF_CD = 'H' AND M.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${h_rhq_off} != 'SELHO' )" ).append("\n"); 
		query.append("   AND  M.CRE_OFC_CD        = MO.OFC_CD" ).append("\n"); 
		query.append("   AND  MO.AR_HD_QTR_OFC_CD = @[h_rhq_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  M.CRE_DT BETWEEN TO_DATE(REPLACE(@[frdt],'-',''),'YYYYMMDD') + .00000 AND TO_DATE(REPLACE(@[todt],'-',''),'YYYYMMDD') + .99999   /* INVOICE ISSUE DATE */" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("#if ( ${isof} != '' )" ).append("\n"); 
		query.append("   AND  M.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach( $cre_ofc_cd_p in ${tempISOFList}) " ).append("\n"); 
		query.append("  #if($velocityCount < $tempISOFList.size()) " ).append("\n"); 
		query.append("     '$cre_ofc_cd_p', " ).append("\n"); 
		query.append("  #else " ).append("\n"); 
		query.append("     '$cre_ofc_cd_p' " ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  (M.DMDT_INV_STS_CD  = 'I' or (M.DMDT_INV_STS_CD = 'X' AND M.DMDT_VT_INV_STS_CD = 'C'))		-- NOT CANCELED INVOICE or VIRTUAL INVOICE modified 2014.12.30 by jameskai" ).append("\n"); 
		query.append("   AND  M.ACT_PAYR_CNT_CD  = DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 1, 2), M.ACT_PAYR_CNT_CD), 6, M.ACT_PAYR_CNT_CD, M.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("   AND  M.ACT_PAYR_SEQ     = DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 3, 6), M.ACT_PAYR_SEQ),    6, @[payc],           M.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${tftp} != 'A' )" ).append("\n"); 
		query.append("AND  M.DMDT_TRF_CD in " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach( $dmdt_trf_cd_p in ${tempTFTPList}) " ).append("\n"); 
		query.append("  #if($velocityCount < $tempTFTPList.size()) " ).append("\n"); 
		query.append("     '$dmdt_trf_cd_p', " ).append("\n"); 
		query.append("  #else " ).append("\n"); 
		query.append("     '$dmdt_trf_cd_p' " ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND  (                                                                       /*  SC NO  */" ).append("\n"); 
		query.append("M.SC_NO             =  NVL(SUBSTR(@[scno], 1, 10), M.SC_NO)" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("NVL(M.SC_NO, ' ')   =  NVL(SUBSTR(@[scno], 1, 10), ' ')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND	(	/* ---------------------------------------------------------------- RFA NO		*/" ).append("\n"); 
		query.append("M.RFA_NO     		=  NVL(SUBSTR( @[rfan], 1, 10), M.RFA_NO)" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("NVL(M.RFA_NO, ' ') 	=  NVL(SUBSTR( @[rfan], 1, 10), ' ')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if( ${cuno} != '')" ).append("\n"); 
		query.append(" AND  M.BKG_NO  in " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select  BKG_NO" ).append("\n"); 
		query.append("from  BKG_CUSTOMER    BC" ).append("\n"); 
		query.append("where  BC.CUST_CNT_CD = NVL(SUBSTR(@[cuno], 1, 2), BC.CUST_CNT_CD)" ).append("\n"); 
		query.append(" AND  BC.CUST_SEQ    = NVL(SUBSTR(@[cuno], 3, 6), BC.CUST_SEQ)" ).append("\n"); 
		query.append(" AND  (" ).append("\n"); 
		query.append("		DECODE(NVL(@[cutp],''),'','A',@[cutp]) = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if ( ${cutp} != 'A' )" ).append("\n"); 
		query.append("		or BKG_CUST_TP_CD in " ).append("\n"); 
		query.append("		   (" ).append("\n"); 
		query.append("			#foreach( $bkg_cust_tp_cd_p in ${tempCUTPList}) " ).append("\n"); 
		query.append("				#if($velocityCount < $tempCUTPList.size()) " ).append("\n"); 
		query.append("				   '$bkg_cust_tp_cd_p', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("				   '$bkg_cust_tp_cd_p' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		   )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${prg_ex_in_cd} == 'EX' )" ).append("\n"); 
		query.append("AND  NVL(M.PRG_FLG, 'N') = 'N'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("#elseif ( ${prg_ex_in_cd} == 'ON' )" ).append("\n"); 
		query.append("AND  NVL(M.PRG_FLG, 'N') = 'Y'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY  M.DMDT_INV_NO" ).append("\n"); 
		query.append("         ,M.VSL_CD" ).append("\n"); 
		query.append("         ,M.SKD_VOY_NO" ).append("\n"); 
		query.append("         ,M.SKD_DIR_CD  " ).append("\n"); 
		query.append("         ,M.BKG_NO       " ).append("\n"); 
		query.append("         ,M.BL_NO        " ).append("\n"); 
		query.append("         ,M.TAX_RTO" ).append("\n"); 
		query.append("         ,M.INV_CURR_CD  " ).append("\n"); 
		query.append("         ,M.INV_CHG_AMT" ).append("\n"); 
		query.append("         ,M.TAX_AMT" ).append("\n"); 
		query.append("         ,M.INV_AMT" ).append("\n"); 
		query.append("         ,M.DMDT_TRF_CD      " ).append("\n"); 
		query.append("         ,M.CRE_DT                    " ).append("\n"); 
		query.append("         ,M.CRE_OFC_CD" ).append("\n"); 
		query.append("         ,M.POR_CD" ).append("\n"); 
		query.append("         ,M.POL_CD" ).append("\n"); 
		query.append("         ,M.POD_CD" ).append("\n"); 
		query.append("         ,M.DEL_CD" ).append("\n"); 
		query.append("         ,B.OB_SREP_CD" ).append("\n"); 
		query.append("         ,A.ORG_CHG_AMT" ).append("\n"); 
		query.append("         ,B.RFA_NO" ).append("\n"); 
		query.append("         ,B.SC_NO" ).append("\n"); 
		query.append("         ,B.TAA_NO" ).append("\n"); 
		query.append("         ,SH.CUST_CNT_CD " ).append("\n"); 
		query.append("         ,SH.CUST_SEQ " ).append("\n"); 
		query.append("         ,SH.CUST_NM " ).append("\n"); 
		query.append("         ,CN.CUST_CNT_CD " ).append("\n"); 
		query.append("         ,CN.CUST_SEQ " ).append("\n"); 
		query.append("         ,CN.CUST_NM " ).append("\n"); 
		query.append("         ,M.INV_RMK" ).append("\n"); 
		query.append("         ,M.CXL_RMK" ).append("\n"); 
		query.append("         ,M.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("         ,M.DMDT_VT_INV_STS_CD" ).append("\n"); 
		query.append("         ,OTS_CLT_FLG" ).append("\n"); 
		query.append("         ,CASE " ).append("\n"); 
		query.append("			WHEN (NVL(OTS_CLT_FLG,'N') !='Y' AND DMDT_INV_STS_CD = 'I' AND DMDT_AR_IF_CD = 'Y' AND ATTR_CTNT1 IS NULL) THEN " ).append("\n"); 
		query.append("				'Y'" ).append("\n"); 
		query.append("			ELSE " ).append("\n"); 
		query.append("			'N'" ).append("\n"); 
		query.append("		  END" ).append("\n"); 
		query.append("		 ,INV_XCH_RT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  N.*" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  CASE " ).append("\n"); 
		query.append("						WHEN A3.CNT_CD = 'IN' AND A1.CRE_DT >= TO_DATE(A4.ATTR_CTNT1, 'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("							THEN SUBSTR(A1.DMDT_INV_NO, 4, 1)" ).append("\n"); 
		query.append("						ELSE" ).append("\n"); 
		query.append("							SUBSTR(A1.DMDT_INV_NO, 3, 1)" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			  FROM  DMT_INV_MN			A1" ).append("\n"); 
		query.append("			       ,MDM_ORGANIZATION  	A2" ).append("\n"); 
		query.append("				   ,MDM_LOCATION      	A3" ).append("\n"); 
		query.append("				   ,DMT_HRD_CDG_CTNT	A4" ).append("\n"); 
		query.append("			 WHERE  A1.DMDT_INV_NO = N.INVNOO" ).append("\n"); 
		query.append("			   AND  A1.CRE_OFC_CD  = A2.OFC_CD" ).append("\n"); 
		query.append("			   AND  A2.LOC_CD      = A3.LOC_CD" ).append("\n"); 
		query.append("			   AND  A4.HRD_CDG_ID = 'IDA_TAX_APPL_DT'" ).append("\n"); 
		query.append("	    ) AS DMDT_INV_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T.*" ).append("\n"); 
		query.append("--	,DECODE(V_COLLECTED,'Y','',COL_CHARGE1) AS COL_CHARGE" ).append("\n"); 
		query.append("--	,DECODE(V_COLLECTED,'Y','',COL_TAX1) AS COL_TAX" ).append("\n"); 
		query.append("    ,COL_CHARGE1 AS COL_CHARGE" ).append("\n"); 
		query.append("	,COL_TAX1 AS COL_TAX" ).append("\n"); 
		query.append("	,NVL(INVAMT,0) - (NVL(COL_CHARGE1,0)+NVL(COL_TAX1,0))  AS UNCOL_AMT" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("select  INVNOO" ).append("\n"); 
		query.append("	   ,VVDCDD" ).append("\n"); 
		query.append("	   ,BKGNOO" ).append("\n"); 
		query.append("	   ,BLNOOO" ).append("\n"); 
		query.append("	   ,CURRCY" ).append("\n"); 
		query.append("	   ,BILAMT" ).append("\n"); 
		query.append("	   ,TAXAMT" ).append("\n"); 
		query.append("	   ,INVAMT" ).append("\n"); 
		query.append("	   ,TARFTP" ).append("\n"); 
		query.append("	   ,ISSEDT" ).append("\n"); 
		query.append("	   ,ISSEOF" ).append("\n"); 
		query.append("	   ,INVOVD" ).append("\n"); 
		query.append("	   ,SHEETP" ).append("\n"); 
		query.append("	   ,POR_CD" ).append("\n"); 
		query.append("	   ,POL_CD" ).append("\n"); 
		query.append("	   ,POD_CD" ).append("\n"); 
		query.append("	   ,DEL_CD" ).append("\n"); 
		query.append("	   ,OB_SREP_CD" ).append("\n"); 
		query.append("	   ,RFA_NO" ).append("\n"); 
		query.append("	   ,SC_NO" ).append("\n"); 
		query.append("	   ,TAA_NO" ).append("\n"); 
		query.append("	   ,SH_CUST_CD" ).append("\n"); 
		query.append("	   ,SH_CUST_NM" ).append("\n"); 
		query.append("	   ,CN_CUST_CD" ).append("\n"); 
		query.append("	   ,CN_CUST_NM" ).append("\n"); 
		query.append("	   ,INV_RMK" ).append("\n"); 
		query.append("       ,sum(ORG_CHG_AMT) 			as ORG_CHG_AMT" ).append("\n"); 
		query.append("	   ,sum(NVL(CMDT_EXPT_AMT,0)) 	as CMDT_EXPT_AMT" ).append("\n"); 
		query.append("	   ,sum(SC_RFA_EXPT_AMT) 		as SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("	   ,sum(AFT_EXPT_DC_AMT) 		as AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	   ,max(DMDT_VT_INV_YN)			as DMDT_VT_INV_YN" ).append("\n"); 
		query.append("	   ,max(DMDT_VT_INV_NO)			as DMDT_VT_INV_NO" ).append("\n"); 
		query.append("	   ,max(DMDT_VT_INV_STS_CD)		as DMDT_VT_INV_STS_CD" ).append("\n"); 
		query.append("	   ,max(COL_CHARGE) AS COL_CHARGE1" ).append("\n"); 
		query.append("       ,max(COL_TAX) AS COL_TAX1" ).append("\n"); 
		query.append("	   ,TO_CHAR(MAX(COL_DATE), 'YYYY-MM-DD') AS COL_DATE" ).append("\n"); 
		query.append("	   ,MAX(OTS_CLT_FLG) AS OTS_CLT_FLG" ).append("\n"); 
		query.append("	   ,MAX(V_COLLECTED) AS V_COLLECTED" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("			select  M.DMDT_INV_NO											as INVNOO        /*  INVOICE NO                  */" ).append("\n"); 
		query.append("				   ,M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD                    as VVDCDD        /*  VVD                         */" ).append("\n"); 
		query.append("				   ,M.BKG_NO                                                as BKGNOO        /*  BKG NO                      */" ).append("\n"); 
		query.append("				   ,M.BL_NO                                                 as BLNOOO        /*  BL NO                       */" ).append("\n"); 
		query.append("				   ,M.INV_CURR_CD                                           as CURRCY        /*  INVOICE CURRENCY            */" ).append("\n"); 
		query.append("				   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("						 then" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									select  sum(T3.BIL_AMT)" ).append("\n"); 
		query.append("									  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("										   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("										   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("									 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("									   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("									   and  T2.CHG_SEQ				= T3.CHG_SEQ" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						 else" ).append("\n"); 
		query.append("								M.INV_CHG_AMT" ).append("\n"); 
		query.append("					end														as BILAMT		/*  INVOICE BILLING AMOUNT      */" ).append("\n"); 
		query.append("				   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("						 then" ).append("\n"); 
		query.append("								case when NVL(M.TAX_RTO, 0) = 0 " ).append("\n"); 
		query.append("									 then 0" ).append("\n"); 
		query.append("									 else " ).append("\n"); 
		query.append("											(" ).append("\n"); 
		query.append("												select  sum(T3.BIL_AMT/M.TAX_RTO)" ).append("\n"); 
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
		query.append("								end" ).append("\n"); 
		query.append("						 else" ).append("\n"); 
		query.append("								M.TAX_AMT" ).append("\n"); 
		query.append("					end														as TAXAMT   	/*  INVOICE TAX AMOUNT          */" ).append("\n"); 
		query.append("				   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("						 then" ).append("\n"); 
		query.append("								case when NVL(M.TAX_RTO, 0) = 0 " ).append("\n"); 
		query.append("									 then  " ).append("\n"); 
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
		query.append("											)									 " ).append("\n"); 
		query.append("									 else" ).append("\n"); 
		query.append("											(" ).append("\n"); 
		query.append("												select  sum(T3.BIL_AMT + T3.BIL_AMT/M.TAX_RTO)" ).append("\n"); 
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
		query.append("											)									 " ).append("\n"); 
		query.append("								end" ).append("\n"); 
		query.append("						 else" ).append("\n"); 
		query.append("								M.INV_AMT" ).append("\n"); 
		query.append("					end														as INVAMT		 /*  INVOICE AMOUNT              */" ).append("\n"); 
		query.append("				   ,M.DMDT_TRF_CD                                           as TARFTP        /*  TARIFF TYPE                 */" ).append("\n"); 
		query.append("                   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("                         then ''" ).append("\n"); 
		query.append("                         else to_char(M.CRE_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                    end														as ISSEDT        /*  INVOICE ISSUE DATE          */" ).append("\n"); 
		query.append("                   ,M.CRE_OFC_CD											as ISSEOF        /*  INVOICE ISSUE OFFICE        */" ).append("\n"); 
		query.append("                   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("                         then 0" ).append("\n"); 
		query.append("                         else TO_DATE(to_char(sysdate ,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(to_char(M.CRE_DT,'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("                    end														as INVOVD        /*  INVOICE OVER DAY = sysdate - ISSUE DATE #ADD 2007.12.03 */" ).append("\n"); 
		query.append("				   ,'O' SHEETP" ).append("\n"); 
		query.append("				   ,M.POR_CD" ).append("\n"); 
		query.append("				   ,M.POL_CD" ).append("\n"); 
		query.append("				   ,M.POD_CD" ).append("\n"); 
		query.append("				   ,M.DEL_CD" ).append("\n"); 
		query.append("				   ,M.OB_SREP_CD" ).append("\n"); 
		query.append("				   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("						 then" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									select  sum(T3.ORG_CHG_AMT)" ).append("\n"); 
		query.append("									  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("										   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("										   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("									 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("									   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("									   and  T2.CHG_SEQ				= T3.CHG_SEQ" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						 else" ).append("\n"); 
		query.append("								M.ORG_CHG_AMT" ).append("\n"); 
		query.append("					end														as ORG_CHG_AMT" ).append("\n"); 
		query.append("				   ,M.RFA_NO" ).append("\n"); 
		query.append("				   ,M.SC_NO" ).append("\n"); 
		query.append("				   ,M.TAA_NO" ).append("\n"); 
		query.append("				   ,S_CUST_CNT_CD||S_CUST_SEQ 							as SH_CUST_CD" ).append("\n"); 
		query.append("				   ,S_CUST_NM 												as SH_CUST_NM" ).append("\n"); 
		query.append("				   ,C_CUST_CNT_CD||C_CUST_SEQ 							as CN_CUST_CD" ).append("\n"); 
		query.append("				   ,C_CUST_NM 												as CN_CUST_NM" ).append("\n"); 
		query.append("				   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("						 then" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									select  sum(T3.CMDT_EXPT_AMT)" ).append("\n"); 
		query.append("									  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("										   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("										   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("									 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("									   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("									   and  T2.CHG_SEQ				= T3.CHG_SEQ" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						 else" ).append("\n"); 
		query.append("								M.CMDT_EXPT_AMT" ).append("\n"); 
		query.append("					end														as CMDT_EXPT_AMT" ).append("\n"); 
		query.append("				   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("						 then" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									select  sum(T3.SC_RFA_EXPT_AMT)" ).append("\n"); 
		query.append("									  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("										   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("										   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("									 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("									   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("									   and  T2.CHG_SEQ				= T3.CHG_SEQ" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						 else" ).append("\n"); 
		query.append("								M.SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("					end														as SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("				   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("						 then" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									select  sum(T3.AFT_EXPT_DC_AMT)" ).append("\n"); 
		query.append("									  from  DMT_INV_MN   	T1" ).append("\n"); 
		query.append("										   ,DMT_INV_DTL  	T2" ).append("\n"); 
		query.append("										   ,DMT_CHG_CALC	T3" ).append("\n"); 
		query.append("									 where  T1.DMDT_INV_NO			= M.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= M.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T1.DMDT_INV_NO 			= T2.DMDT_INV_NO" ).append("\n"); 
		query.append("									   and  T1.CRE_OFC_CD  			= T2.CRE_OFC_CD" ).append("\n"); 
		query.append("									   and  T2.SYS_AREA_GRP_ID 		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   and  T2.CNTR_NO 				= T3.CNTR_NO" ).append("\n"); 
		query.append("									   and  T2.CNTR_CYC_NO 			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   and  T2.DMDT_TRF_CD 			= T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   and  T2.DMDT_CHG_LOC_DIV_CD 	= T3.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("									   and  T2.CHG_SEQ				= T3.CHG_SEQ" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						 else" ).append("\n"); 
		query.append("								M.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("					end														as AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("                   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("                         then M.CXL_RMK" ).append("\n"); 
		query.append("                         else M.INV_RMK" ).append("\n"); 
		query.append("                    end														as INV_RMK" ).append("\n"); 
		query.append("                   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("                         then 'Y'" ).append("\n"); 
		query.append("                         else 'N'" ).append("\n"); 
		query.append("                    end														as DMDT_VT_INV_YN" ).append("\n"); 
		query.append("                   ,case when M.DMDT_INV_STS_CD = 'X' and M.DMDT_VT_INV_STS_CD = 'C' " ).append("\n"); 
		query.append("                         then M.DMDT_INV_NO" ).append("\n"); 
		query.append("                         else ''" ).append("\n"); 
		query.append("                    end														as DMDT_VT_INV_NO								" ).append("\n"); 
		query.append("				   ,M.DMDT_VT_INV_STS_CD									as DMDT_VT_INV_STS_CD" ).append("\n"); 
		query.append("                    ,CASE WHEN (V_COLLECTED = 'Y')" ).append("\n"); 
		query.append("                       THEN  INV_CHG_AMT" ).append("\n"); 
		query.append("                       ELSE  B.COL_CHARGE " ).append("\n"); 
		query.append("                     END COL_CHARGE" ).append("\n"); 
		query.append("                    ,CASE WHEN (V_COLLECTED = 'Y')" ).append("\n"); 
		query.append("                       THEN  TAX_AMT" ).append("\n"); 
		query.append("                       ELSE  B.COL_TAX " ).append("\n"); 
		query.append("                     END COL_TAX" ).append("\n"); 
		query.append("                    ,B.COL_DATE" ).append("\n"); 
		query.append("					,OTS_CLT_FLG,V_COLLECTED" ).append("\n"); 
		query.append("			FROM MN_DATA M" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                    SELECT " ).append("\n"); 
		query.append("                        A.DMDT_INV_NO " ).append("\n"); 
		query.append("                        , SUM(DECODE(DMDT_INV_PAY_TP_CD,'M',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) AS COL_CHARGE" ).append("\n"); 
		query.append("                        , SUM(DECODE(DMDT_INV_PAY_TP_CD,'V',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) AS COL_TAX" ).append("\n"); 
		query.append("                        , MAX(INV_PAY_DT)  AS COL_DATE" ).append("\n"); 
		query.append("                        , MAX(INV_PAY_COFF_DT) AS COL_DUE_DT" ).append("\n"); 
		query.append("                    FROM DMT_INV_OTS_PAY_RCV A ,(SELECT DISTINCT DMDT_INV_NO ,INV_XCH_RT,INV_CURR_CD FROM MN_DATA)B" ).append("\n"); 
		query.append("                    WHERE B.DMDT_INV_NO = A.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("                    GROUP BY A.DMDT_INV_NO" ).append("\n"); 
		query.append("                ) B      " ).append("\n"); 
		query.append("            WHERE M.DMDT_INV_NO = B.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("group by INVNOO,VVDCDD,BKGNOO,BLNOOO,CURRCY,BILAMT,TAXAMT,INVAMT,TARFTP,ISSEDT,ISSEOF,INVOVD,SHEETP,POR_CD,POL_CD,POD_CD,DEL_CD,OB_SREP_CD,RFA_NO,SC_NO,TAA_NO,SH_CUST_CD,SH_CUST_NM,CN_CUST_CD,CN_CUST_NM,INV_RMK" ).append("\n"); 
		query.append("order by INVNOO" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(") N" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	#if (${coll} != 'All')" ).append("\n"); 
		query.append("		#if (${coll} == 'N')" ).append("\n"); 
		query.append("		AND N.UNCOL_AMT != 0" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("		#if (${coll} == 'Y')" ).append("\n"); 
		query.append("		AND N.UNCOL_AMT = 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 

	}
}
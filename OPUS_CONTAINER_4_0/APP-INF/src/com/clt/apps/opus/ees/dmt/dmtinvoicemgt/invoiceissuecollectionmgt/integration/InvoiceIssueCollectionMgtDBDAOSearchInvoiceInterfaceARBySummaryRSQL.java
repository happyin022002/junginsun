/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARBySummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.21 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARBySummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 발행된 INV를 PAYER별로 묶어서 조회
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARBySummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_hold",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARBySummaryRSQL").append("\n"); 
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
		query.append("SELECT   DECODE (M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("                ,'00', ''" ).append("\n"); 
		query.append("                ,M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         || TO_CHAR (M.ACT_PAYR_SEQ, 'FM000000') AS PAYER_CD" ).append("\n"); 
		query.append("        ,NVL (COUNT (*), 0) AS INV_CNT" ).append("\n"); 
		query.append("        ,M.INV_CURR_CD AS INV_CURR_CD" ).append("\n"); 
		query.append("        ,NVL (SUM (M.INV_CHG_AMT), 0) AS INV_CHG_AMT" ).append("\n"); 
		query.append("        ,NVL (SUM (M.TAX_AMT), 0) AS TAX_AMT" ).append("\n"); 
		query.append("        ,NVL (SUM (M.INV_AMT), 0) AS INV_AMT" ).append("\n"); 
		query.append("        ,NVL (U.CUST_LGL_ENG_NM, V.VNDR_LGL_ENG_NM) AS PAYER_NM" ).append("\n"); 
		query.append("        ,DECODE (NVL (U.DELT_FLG, V.DELT_FLG)" ).append("\n"); 
		query.append("                ,'Y', 'Y'" ).append("\n"); 
		query.append("                ,'N'" ).append("\n"); 
		query.append("                ) AS PAYER_FLG" ).append("\n"); 
		query.append("    FROM DMT_INV_MN M" ).append("\n"); 
		query.append("        ,MDM_CUSTOMER U" ).append("\n"); 
		query.append("        ,MDM_VENDOR V" ).append("\n"); 
		query.append("   WHERE M.CRE_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} != '') " ).append("\n"); 
		query.append("     AND M.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("        #foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("            #if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     AND (   M.DMDT_AR_IF_CD = 'N'" ).append("\n"); 
		query.append("          OR M.DMDT_AR_IF_CD = DECODE (@[chk_hold]" ).append("\n"); 
		query.append("                                      ,'Y', 'H'" ).append("\n"); 
		query.append("                                      ,'N'" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("--선택 조회 1: DATE 일 경우" ).append("\n"); 
		query.append("#if (${cond_type} == 'date')         " ).append("\n"); 
		query.append("     AND M.CRE_DT BETWEEN TO_DATE (@[fm_dt], 'yyyymmdd')" ).append("\n"); 
		query.append("                      AND TO_DATE (@[to_dt], 'yyyymmdd')" ).append("\n"); 
		query.append("                          + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("--선택 조회 2: INV 종류를 선택 했을 경우" ).append("\n"); 
		query.append("#if (${cond_type} == 'inv')" ).append("\n"); 
		query.append("	#if (${inv_no} != '')" ).append("\n"); 
		query.append("	AND M.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("		#foreach( $inv_cd in ${inv_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $inv_no_list.size()) '$inv_cd', #else '$inv_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${bkg_no} != '')	" ).append("\n"); 
		query.append("	AND M.BKG_NO IN (" ).append("\n"); 
		query.append("		#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bl_no} != '')" ).append("\n"); 
		query.append("	AND M.BL_NO IN (" ).append("\n"); 
		query.append("		#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $bl_no_list.size()) '$bl_cd', #else '$bl_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cd} != '')     " ).append("\n"); 
		query.append("	#if (${cust_len} == '8')" ).append("\n"); 
		query.append("     AND M.ACT_PAYR_CNT_CD = NVL (SUBSTR (@[cust_cd]" ).append("\n"); 
		query.append("                                         ,1" ).append("\n"); 
		query.append("                                         ,2" ).append("\n"); 
		query.append("                                         ), M.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("     AND M.ACT_PAYR_SEQ = NVL (SUBSTR (@[cust_cd]" ).append("\n"); 
		query.append("                                      ,3" ).append("\n"); 
		query.append("                                      ,6" ).append("\n"); 
		query.append("                                      ), M.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 AND M.ACT_PAYR_SEQ = NVL (SUBSTR (@[cust_cd]" ).append("\n"); 
		query.append("                                      ,1" ).append("\n"); 
		query.append("                                      ,6" ).append("\n"); 
		query.append("                                      ), M.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end                                      " ).append("\n"); 
		query.append("     AND ( (M.DMDT_INV_STS_CD = 'I') OR (M.DMDT_INV_STS_CD = 'C' AND CR_INV_NO IS NOT NULL))" ).append("\n"); 
		query.append("     AND U.CUST_CNT_CD(+) = M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("     AND U.CUST_SEQ(+) = M.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("     AND V.VNDR_SEQ(+) = M.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("GROUP BY DECODE (M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("                ,'00', ''" ).append("\n"); 
		query.append("                ,M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         || TO_CHAR (M.ACT_PAYR_SEQ, 'FM000000')" ).append("\n"); 
		query.append("        ,M.INV_CURR_CD" ).append("\n"); 
		query.append("        ,NVL (U.CUST_LGL_ENG_NM, V.VNDR_LGL_ENG_NM)" ).append("\n"); 
		query.append("        ,DECODE (NVL (U.DELT_FLG, V.DELT_FLG)" ).append("\n"); 
		query.append("                ,'Y', 'Y'" ).append("\n"); 
		query.append("                ,'N'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("ORDER BY 1 ASC" ).append("\n"); 

	}
}
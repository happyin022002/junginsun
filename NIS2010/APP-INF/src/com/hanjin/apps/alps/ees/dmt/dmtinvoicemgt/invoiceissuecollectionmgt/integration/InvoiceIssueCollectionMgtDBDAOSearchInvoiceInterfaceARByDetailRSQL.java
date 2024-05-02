/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARByDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.06 
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

public class InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARByDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceInterfaceARByDetail
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARByDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("session_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_hold",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sh_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sh_inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARByDetailRSQL").append("\n"); 
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
		query.append("SELECT  M.DMDT_INV_NO" ).append("\n"); 
		query.append("	   ,M.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("	   ,ROUND (NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[session_ofc_cd]),SYSDATE) - M.CRE_DT) AS OVER_DAYS" ).append("\n"); 
		query.append("	   ,M.INV_CURR_CD" ).append("\n"); 
		query.append("       ,M.INV_CHG_AMT" ).append("\n"); 
		query.append("       ,M.TAX_AMT" ).append("\n"); 
		query.append("       ,M.INV_AMT" ).append("\n"); 
		query.append("       ,M.DMDT_TRF_CD" ).append("\n"); 
		query.append("       ,M.BL_NO" ).append("\n"); 
		query.append("       ,M.BKG_NO" ).append("\n"); 
		query.append(" 	   ,M.CR_INV_NO" ).append("\n"); 
		query.append("	   ,DMDT_INV_STS_CD" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			SELECT  CASE " ).append("\n"); 
		query.append("						WHEN A2.CNT_CD = 'IN' AND M.CRE_DT >= TO_DATE(A3.ATTR_CTNT1, 'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("							THEN SUBSTR(M.DMDT_INV_NO, 4, 1)" ).append("\n"); 
		query.append("						ELSE" ).append("\n"); 
		query.append("							SUBSTR(M.DMDT_INV_NO, 3, 1)" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			  FROM  MDM_ORGANIZATION  	A1" ).append("\n"); 
		query.append("				   ,MDM_LOCATION      	A2" ).append("\n"); 
		query.append("				   ,DMT_HRD_CDG_CTNT	A3" ).append("\n"); 
		query.append("			 WHERE  A1.OFC_CD     = M.CRE_OFC_CD" ).append("\n"); 
		query.append("			   AND  A1.LOC_CD     = A2.LOC_CD" ).append("\n"); 
		query.append("			   AND  A3.HRD_CDG_ID = 'IDA_TAX_APPL_DT'" ).append("\n"); 
		query.append("	    ) AS DMDT_INV_TP_CD" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  FROM  DMT_INV_MN M" ).append("\n"); 
		query.append(" WHERE  M.CRE_OFC_CD = @[ofc_cd]" ).append("\n"); 
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
		query.append("##  --선택 조회 1: DATE 일 경우" ).append("\n"); 
		query.append("#if (${cond_type} == 'date')         " ).append("\n"); 
		query.append("     AND M.CRE_DT BETWEEN TO_DATE (@[fm_dt], 'yyyymmdd') AND TO_DATE (@[to_dt], 'yyyymmdd') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("##  --선택 조회 2: INV 종류를 선택 했을 경우" ).append("\n"); 
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
		query.append("     AND ( (M.DMDT_INV_STS_CD = 'I') OR (M.DMDT_INV_STS_CD = 'C' AND CR_INV_NO IS NOT NULL))" ).append("\n"); 
		query.append("#if (${sh_cust_cd} != '')     " ).append("\n"); 
		query.append("	 AND DECODE (M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("                ,'00', ''" ).append("\n"); 
		query.append("                ,M.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         || TO_CHAR (M.ACT_PAYR_SEQ, 'FM000000') = @[sh_cust_cd]" ).append("\n"); 
		query.append("#end                                      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 AND M.INV_CURR_CD = @[sh_inv_curr_cd] " ).append("\n"); 
		query.append("ORDER BY 1 ASC" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByContainerRSQL").append("\n"); 
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
		query.append("SELECT M.BKG_NO" ).append("\n"); 
		query.append("	, M.BL_NO" ).append("\n"); 
		query.append("	, M.CNTR_CNT" ).append("\n"); 
		query.append("	, M.GB" ).append("\n"); 
		query.append("	, M.CNTR_NO" ).append("\n"); 
		query.append("	, M.OFC_CD" ).append("\n"); 
		query.append("	, M.DMDT_TRF_CD" ).append("\n"); 
		query.append("	, M.ACT_CNT_CD" ).append("\n"); 
		query.append("	, M.ACT_CUST_SEQ" ).append("\n"); 
		query.append("	, M.CUST_CD" ).append("\n"); 
		query.append("	, M.CUST_NM" ).append("\n"); 
		query.append("	, M.SC_NO" ).append("\n"); 
		query.append("	, M.RFA_NO" ).append("\n"); 
		query.append("	, M.AR_CURR_CD" ).append("\n"); 
		query.append("	, M.VSL_CD" ).append("\n"); 
		query.append("	, M.SKD_VOY_NO" ).append("\n"); 
		query.append("	, M.SKD_DIR_CD" ).append("\n"); 
		query.append("	, M.POL_CD" ).append("\n"); 
		query.append("	, M.POD_CD" ).append("\n"); 
		query.append("	, M.POR_CD" ).append("\n"); 
		query.append("	, M.DEL_CD" ).append("\n"); 
		query.append("	, M.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	, M.ORG_CHG_AMT" ).append("\n"); 
		query.append("	, M.SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("	, M.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	, M.BIL_AMT" ).append("\n"); 
		query.append("	, M.CHG_CUST_CNT_CD" ).append("\n"); 
		query.append("	, M.CHG_CUST_SEQ" ).append("\n"); 
		query.append("	, M.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("    ,(SELECT  NVL(MAX(R.DMDT_DELT_RQST_STS_CD),'N')" ).append("\n"); 
		query.append("      FROM DMT_CHG_DELT_RQST_APRO R, DMT_CHG_CALC S, DMT_CHG_BKG_CNTR T" ).append("\n"); 
		query.append("      WHERE   R.SYS_AREA_GRP_ID = S.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("      AND R.CNTR_NO     = S.CNTR_NO " ).append("\n"); 
		query.append("      AND R.CNTR_CYC_NO = S.CNTR_CYC_NO " ).append("\n"); 
		query.append("      AND R.DMDT_TRF_CD = S.DMDT_TRF_CD" ).append("\n"); 
		query.append("      AND R.DMDT_CHG_LOC_DIV_CD = S.DMDT_CHG_LOC_DIV_CD " ).append("\n"); 
		query.append("      AND R.CHG_SEQ             = S.CHG_SEQ" ).append("\n"); 
		query.append("      AND S.SYS_AREA_GRP_ID = T.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("      AND S.CNTR_NO     = T.CNTR_NO " ).append("\n"); 
		query.append("      AND S.CNTR_CYC_NO = T.CNTR_CYC_NO" ).append("\n"); 
		query.append("   	  AND T.BKG_NO 	= M.BKG_NO " ).append("\n"); 
		query.append("      AND T.SYS_AREA_GRP_ID = M.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("      AND R.DMDT_TRF_CD = M.DMDT_TRF_CD" ).append("\n"); 
		query.append("      AND S.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("      AND S.DMDT_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("      )  AS DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT A.BKG_NO " ).append("\n"); 
		query.append("        , A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		, A.BL_NO 	AS BL_NO" ).append("\n"); 
		query.append("		, '' 		AS CNTR_CNT" ).append("\n"); 
		query.append("		, DECODE(B.CHG_SEQ, 1, 'G', 'B') AS GB" ).append("\n"); 
		query.append("		, A.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("		, B.OFC_CD 	AS OFC_CD" ).append("\n"); 
		query.append("		, B.DMDT_TRF_CD AS DMDT_TRF_CD" ).append("\n"); 
		query.append("		, B.ACT_CNT_CD 	AS ACT_CNT_CD" ).append("\n"); 
		query.append("		, B.ACT_CUST_SEQ AS ACT_CUST_SEQ" ).append("\n"); 
		query.append("		, B.CUST_CNT_CD AS CHG_CUST_CNT_CD" ).append("\n"); 
		query.append("		, B.CUST_SEQ AS CHG_CUST_SEQ" ).append("\n"); 
		query.append("		, DECODE(B.ACT_CNT_CD, '00', '', B.ACT_CNT_CD) ||" ).append("\n"); 
		query.append("              DECODE(B.ACT_CUST_SEQ,  0, '', LPAD(B.ACT_CUST_SEQ, 6, '0')) AS CUST_CD" ).append("\n"); 
		query.append("		, DECODE(B.ACT_CNT_CD, '00', (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR" ).append("\n"); 
		query.append("                                          WHERE VNDR_SEQ = B.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                                       , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                                          WHERE CUST_CNT_CD = B.ACT_CNT_CD" ).append("\n"); 
		query.append("                                          AND CUST_SEQ = B.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("              ) AS CUST_NM" ).append("\n"); 
		query.append("		, A.SC_NO				AS SC_NO" ).append("\n"); 
		query.append("		, A.RFA_NO 				AS RFA_NO" ).append("\n"); 
		query.append("		, B.BZC_TRF_CURR_CD 	AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("		, B.ORG_CHG_AMT 		AS ORG_CHG_AMT" ).append("\n"); 
		query.append("		, B.SC_RFA_EXPT_AMT 	AS SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("		, B.AFT_EXPT_DC_AMT 	AS AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("		, B.BIL_AMT 			AS BIL_AMT" ).append("\n"); 
		query.append("		, CASE WHEN (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd]) IN ('MTRBS', 'TORBB', 'VANBS') THEN 'USD'" ).append("\n"); 
		query.append("          ELSE (SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("          END AS AR_CURR_CD" ).append("\n"); 
		query.append("		, A.VSL_CD 				AS VSL_CD" ).append("\n"); 
		query.append("		, A.SKD_VOY_NO			AS SKD_VOY_NO" ).append("\n"); 
		query.append("		, A.SKD_DIR_CD			AS SKD_DIR_CD" ).append("\n"); 
		query.append("		, A.POL_CD				AS POL_CD" ).append("\n"); 
		query.append("		, A.POD_CD				AS POD_CD" ).append("\n"); 
		query.append("		, A.POR_CD				AS POR_CD" ).append("\n"); 
		query.append("		, A.DEL_CD				AS DEL_CD" ).append("\n"); 
		query.append("		, B.DMDT_CHG_LOC_DIV_CD AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	FROM DMT_CHG_BKG_CNTR A, DMT_CHG_CALC B , COM_SYS_AREA_GRP_ID C" ).append("\n"); 
		query.append("	WHERE A.CNTR_NO 	= B.CNTR_NO" ).append("\n"); 
		query.append("	AND A.CNTR_CYC_NO 	= B.CNTR_CYC_NO" ).append("\n"); 
		query.append("	AND (							-- OFC_TRNS_FLG 상태에 따라 쿼리가 달라짐" ).append("\n"); 
		query.append("			(	B.OFC_TRNS_FLG = 'Y'" ).append("\n"); 
		query.append("				AND C.SYS_AREA_GRP_ID = A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				AND C.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("                                FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("				AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("				AND DECODE(B.OFC_TRNS_RHQ_CNG_FLG, 'Y', B.SYS_AREA_GRP_ID, A.SYS_AREA_GRP_ID)=B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("       OR" ).append("\n"); 
		query.append("       		(" ).append("\n"); 
		query.append("				B.OFC_TRNS_FLG = 'N'" ).append("\n"); 
		query.append("				AND C.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("                                FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("				AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("       			AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID       " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	AND B.OFC_CD 		= @[s_ofc_cd]" ).append("\n"); 
		query.append("#if (${jspno} == '4013') " ).append("\n"); 
		query.append("	AND B.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("	           '$dmdt_trf_no', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$dmdt_trf_no' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	AND B.DMDT_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("	AND A.BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("		#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("			'$bkg_cd', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$bkg_cd' " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#if (${s_chg_type} == 'G') " ).append("\n"); 
		query.append("	AND B.CHG_SEQ = 1" ).append("\n"); 
		query.append("	#elseif (${s_chg_type} == 'B') " ).append("\n"); 
		query.append("	AND B.CHG_SEQ <> 1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	#if (${s_dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("	AND B.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("	           '$dmdt_trf_no', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$dmdt_trf_no' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND B.DMDT_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("	#if (${s_cont_type} == 'date') " ).append("\n"); 
		query.append("	AND (TO_CHAR(B.CFM_DT,'YYYYMMDD') BETWEEN @[fm_cfm_dt] AND @[to_cfm_dt])" ).append("\n"); 
		query.append("	#elseif (${s_cont_type} == 'cntr') " ).append("\n"); 
		query.append("		#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("			AND A.BKG_NO IN (" ).append("\n"); 
		query.append("			#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("					'$bkg_cd', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$bkg_cd' " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_bl_no} != '')	" ).append("\n"); 
		query.append("			AND A.BL_NO IN (" ).append("\n"); 
		query.append("			#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("					'$bl_cd', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$bl_cd' " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_cntr_no} != '')	" ).append("\n"); 
		query.append("			AND A.CNTR_NO IN (" ).append("\n"); 
		query.append("			#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $cntr_no_list.size()) " ).append("\n"); 
		query.append("					'$cntr_cd', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$cntr_cd' " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_chg_type} == 'G') " ).append("\n"); 
		query.append("	AND B.CHG_SEQ = 1" ).append("\n"); 
		query.append("	#elseif (${s_chg_type} == 'B') " ).append("\n"); 
		query.append("	AND B.CHG_SEQ <> 1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_cust_cd} != '') " ).append("\n"); 
		query.append("	AND B.ACT_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("	AND LPAD(B.ACT_CUST_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_sc_no} != '') " ).append("\n"); 
		query.append("	AND A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_rfa_no} != '') " ).append("\n"); 
		query.append("	AND A.RFA_NO = @[s_rfa_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("## 조건 추가(2010.01.12)" ).append("\n"); 
		query.append("	AND ((B.DUL_TP_EXPT_FLG= 'Y' AND SUBSTR(B.DMDT_TRF_CD,1,1)  = 'C')" ).append("\n"); 
		query.append("    	OR" ).append("\n"); 
		query.append("    	(B.DUL_TP_EXPT_FLG ='N'))" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ORDER BY M.BKG_NO" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 
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

public class InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("	, BL_NO" ).append("\n"); 
		query.append("	, CNTR_CNT" ).append("\n"); 
		query.append("	, '' AS GB" ).append("\n"); 
		query.append("	, CNTR_NO" ).append("\n"); 
		query.append("	, OFC_CD" ).append("\n"); 
		query.append("	, DMDT_TRF_CD" ).append("\n"); 
		query.append("	, DECODE(ACT_CNT_CD,'00','',ACT_CNT_CD) AS ACT_CNT_CD" ).append("\n"); 
		query.append("	, DECODE(ACT_CUST_SEQ,0,'',ACT_CUST_SEQ) AS ACT_CUST_SEQ" ).append("\n"); 
		query.append("	, DECODE(CUST_CD,'00','',CUST_CD) AS CUST_CD" ).append("\n"); 
		query.append("	, CUST_NM" ).append("\n"); 
		query.append("	, SC_NO" ).append("\n"); 
		query.append("	, RFA_NO" ).append("\n"); 
		query.append("	, AR_CURR_CD" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, POL_CD" ).append("\n"); 
		query.append("	, POD_CD" ).append("\n"); 
		query.append("	, POR_CD" ).append("\n"); 
		query.append("	, DEL_CD" ).append("\n"); 
		query.append("	, BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	, ORG_CHG_AMT" ).append("\n"); 
		query.append("	, SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("	, AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	, BIL_AMT" ).append("\n"); 
		query.append("	, CHG_CUST_CNT_CD" ).append("\n"); 
		query.append("	, CHG_CUST_SEQ" ).append("\n"); 
		query.append("	, '' AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("    , DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT A.BKG_NO" ).append("\n"); 
		query.append("		, MIN(A.BL_NO) AS BL_NO" ).append("\n"); 
		query.append("		, COUNT(A.CNTR_NO) AS CNTR_CNT" ).append("\n"); 
		query.append("		, '' CNTR_NO" ).append("\n"); 
		query.append("		, MIN(B.OFC_CD) AS OFC_CD" ).append("\n"); 
		query.append("		, MIN(B.DMDT_TRF_CD) AS DMDT_TRF_CD" ).append("\n"); 
		query.append("		, MIN(B.ACT_CNT_CD) AS ACT_CNT_CD" ).append("\n"); 
		query.append("		, MIN(B.ACT_CUST_SEQ) AS ACT_CUST_SEQ" ).append("\n"); 
		query.append("		, MIN(B.CUST_CNT_CD) AS CHG_CUST_CNT_CD" ).append("\n"); 
		query.append("		, MIN(B.CUST_SEQ) AS CHG_CUST_SEQ" ).append("\n"); 
		query.append("		, MIN(DECODE(B.ACT_CNT_CD, '00', '', B.ACT_CNT_CD) ||" ).append("\n"); 
		query.append("              DECODE(B.ACT_CUST_SEQ,  0, '', LPAD(B.ACT_CUST_SEQ, 6, '0'))" ).append("\n"); 
		query.append("              ) AS CUST_CD" ).append("\n"); 
		query.append("		, MIN(DECODE(B.ACT_CNT_CD, '00', (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR" ).append("\n"); 
		query.append("                                          WHERE VNDR_SEQ = B.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                                       , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                                          WHERE CUST_CNT_CD = B.ACT_CNT_CD" ).append("\n"); 
		query.append("                                          AND CUST_SEQ = B.ACT_CUST_SEQ))" ).append("\n"); 
		query.append("              ) AS CUST_NM" ).append("\n"); 
		query.append("		, MIN(A.SC_NO) AS SC_NO" ).append("\n"); 
		query.append("		, MIN(A.RFA_NO) AS RFA_NO" ).append("\n"); 
		query.append("		, MIN(B.BZC_TRF_CURR_CD) AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("		, SUM(B.ORG_CHG_AMT) AS ORG_CHG_AMT" ).append("\n"); 
		query.append("		, SUM(B.SC_RFA_EXPT_AMT) AS SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("		, SUM(B.AFT_EXPT_DC_AMT) AS AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("		, SUM(B.BIL_AMT) AS BIL_AMT" ).append("\n"); 
		query.append("		, (SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd]) AS AR_CURR_CD" ).append("\n"); 
		query.append("		, MIN(A.VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("		, MIN(A.SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("		, MIN(A.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("		, MIN(A.POL_CD) AS POL_CD" ).append("\n"); 
		query.append("		, MIN(A.POD_CD) AS POD_CD" ).append("\n"); 
		query.append("		, MIN(A.POR_CD) AS POR_CD" ).append("\n"); 
		query.append("		, MIN(A.DEL_CD) AS DEL_CD" ).append("\n"); 
		query.append("        , MAX(NVL(R.DMDT_DELT_RQST_STS_CD,'N'))  AS DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("	FROM DMT_CHG_BKG_CNTR A," ).append("\n"); 
		query.append("         DMT_CHG_CALC B , " ).append("\n"); 
		query.append("         COM_SYS_AREA_GRP_ID C," ).append("\n"); 
		query.append("          DMT_CHG_DELT_RQST_APRO R" ).append("\n"); 
		query.append("	WHERE A.CNTR_NO   = B.CNTR_NO" ).append("\n"); 
		query.append("	AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("    AND B.CNTR_NO 		= R.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND B.CNTR_CYC_NO 	= R.CNTR_CYC_NO(+)" ).append("\n"); 
		query.append("    AND B.SYS_AREA_GRP_ID = R.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("    AND B.DMDT_TRF_CD = R.DMDT_TRF_CD(+)" ).append("\n"); 
		query.append("	AND (							-- OFC_TRNS_FLG 상태에 따라 쿼리가 달라짐" ).append("\n"); 
		query.append("			(	NVL(B.OFC_TRNS_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("				AND C.SYS_AREA_GRP_ID = A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				AND C.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("                                FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("				AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("				AND DECODE(B.OFC_TRNS_RHQ_CNG_FLG, 'Y', B.SYS_AREA_GRP_ID, A.SYS_AREA_GRP_ID)=B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("       OR" ).append("\n"); 
		query.append("       		(" ).append("\n"); 
		query.append("				NVL(B.OFC_TRNS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("				AND C.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("                                FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("				AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("       			AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID       " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	AND B.OFC_CD 		= @[s_ofc_cd]" ).append("\n"); 
		query.append("	AND B.DMDT_CHG_STS_CD = 'C'" ).append("\n"); 
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
		query.append("	#if (${s_cont_type} == 'date') " ).append("\n"); 
		query.append("	AND TO_CHAR(B.CFM_DT,'YYYYMMDD') BETWEEN @[fm_cfm_dt] AND @[to_cfm_dt]" ).append("\n"); 
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
		query.append("		#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("	AND LPAD(B.ACT_CUST_SEQ,6,'0') = LPAD(@[s_cust_cd],6,'0')" ).append("\n"); 
		query.append("		#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("	AND B.ACT_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("	AND LPAD(B.ACT_CUST_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_sc_no} != '') " ).append("\n"); 
		query.append("	AND A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rfa_no} != '') " ).append("\n"); 
		query.append("	AND A.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("-- 조건 추가(2010.01.12)" ).append("\n"); 
		query.append("	AND ((B.DUL_TP_EXPT_FLG= 'Y' AND SUBSTR(B.DMDT_TRF_CD,1,1)  = 'C')" ).append("\n"); 
		query.append("    	OR" ).append("\n"); 
		query.append("    	(B.DUL_TP_EXPT_FLG ='N'))" ).append("\n"); 
		query.append("	GROUP BY A.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 

	}
}
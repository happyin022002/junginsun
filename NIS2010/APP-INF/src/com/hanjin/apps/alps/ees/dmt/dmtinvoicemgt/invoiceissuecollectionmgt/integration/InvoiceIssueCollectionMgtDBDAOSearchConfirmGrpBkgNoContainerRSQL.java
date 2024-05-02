/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.12 
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

public class InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoContainerRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoContainerRSQL").append("\n"); 
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
		query.append("SELECT M.BKG_NO, M.DMDT_TRF_CD, M.POR_CD, M.DEL_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT A.BKG_NO ,B.DMDT_TRF_CD, A.POR_CD, A.DEL_CD, B.FM_MVMT_DT" ).append("\n"); 
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
		query.append("   ORDER BY B.FM_MVMT_DT DESC" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}
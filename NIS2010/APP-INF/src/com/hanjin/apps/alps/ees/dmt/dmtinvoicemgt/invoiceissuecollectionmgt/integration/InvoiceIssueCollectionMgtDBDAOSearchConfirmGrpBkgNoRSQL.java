/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoRSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoRSQL").append("\n"); 
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
		query.append("select  BKG_NO, DMDT_TRF_CD, POR_CD, DEL_CD" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("			select  A.BKG_NO, B.DMDT_TRF_CD, A.POR_CD, A.DEL_CD, B.FM_MVMT_DT" ).append("\n"); 
		query.append("			  from  DMT_CHG_BKG_CNTR 		A" ).append("\n"); 
		query.append("				   ,DMT_CHG_CALC 			B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   ,DMT_CHG_DELT_RQST_APRO 	R" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			 where  A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               and  A.CNTR_NO         = B.CNTR_NO" ).append("\n"); 
		query.append("			   and  A.CNTR_CYC_NO     = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  B.CNTR_NO 		  = R.CNTR_NO(+)" ).append("\n"); 
		query.append("			   and  B.CNTR_CYC_NO 	  = R.CNTR_CYC_NO(+)" ).append("\n"); 
		query.append("			   and  B.SYS_AREA_GRP_ID = R.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("			   and  B.DMDT_TRF_CD     = R.DMDT_TRF_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			and  B.OFC_CD 			= @[s_ofc_cd]" ).append("\n"); 
		query.append("			and  B.DMDT_CHG_STS_CD 	= 'C'" ).append("\n"); 
		query.append("			#if (${s_dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("			and B.DMDT_TRF_CD in " ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					#foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("						#if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("						   '$dmdt_trf_no', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("						   '$dmdt_trf_no' " ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_cont_type} == 'date') " ).append("\n"); 
		query.append("			and to_char(B.CFM_DT,'YYYYMMDD') between @[fm_cfm_dt] and @[to_cfm_dt]" ).append("\n"); 
		query.append("			#elseif (${s_cont_type} == 'cntr') " ).append("\n"); 
		query.append("				#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("					and A.BKG_NO in " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("								#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("									'$bkg_cd', " ).append("\n"); 
		query.append("								#else " ).append("\n"); 
		query.append("									'$bkg_cd' " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${s_bl_no} != '')	" ).append("\n"); 
		query.append("					and A.BL_NO in " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("								#if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("									'$bl_cd', " ).append("\n"); 
		query.append("								#else " ).append("\n"); 
		query.append("									'$bl_cd' " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${s_cntr_no} != '')	" ).append("\n"); 
		query.append("					and A.CNTR_NO in " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("								#if($velocityCount < $cntr_no_list.size()) " ).append("\n"); 
		query.append("									'$cntr_cd', " ).append("\n"); 
		query.append("								#else " ).append("\n"); 
		query.append("									'$cntr_cd' " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_chg_type} == 'G') " ).append("\n"); 
		query.append("			and B.CHG_SEQ = 1" ).append("\n"); 
		query.append("			#elseif (${s_chg_type} == 'B') " ).append("\n"); 
		query.append("			and B.CHG_SEQ <> 1" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_cust_cd} != '') " ).append("\n"); 
		query.append("				#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("			and LPAD(B.ACT_CUST_SEQ,6,'0') = LPAD(@[s_cust_cd],6,'0')" ).append("\n"); 
		query.append("				#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("			and B.ACT_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("			and LPAD(B.ACT_CUST_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_sc_no} != '') " ).append("\n"); 
		query.append("			and A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${rfa_no} != '') " ).append("\n"); 
		query.append("			and A.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		## 조건 추가(2010.01.12)" ).append("\n"); 
		query.append("			and ((B.DUL_TP_EXPT_FLG= 'Y' and SUBSTR(B.DMDT_TRF_CD,1,1)  = 'C') or (B.DUL_TP_EXPT_FLG ='N'))" ).append("\n"); 
		query.append("			ORDER by B.FM_MVMT_DT DESC" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}
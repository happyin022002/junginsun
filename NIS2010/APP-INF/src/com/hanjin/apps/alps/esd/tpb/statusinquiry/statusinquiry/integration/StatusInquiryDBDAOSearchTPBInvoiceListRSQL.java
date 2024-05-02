/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchTPBInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusInquiryDBDAOSearchTPBInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB -> Status & Performance -> TPB Invoice Inquiry
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchTPBInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no_for_search",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trd_party_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_rmd_cd_for_search",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchTPBInvoiceListRSQL").append("\n"); 
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
		query.append("##${s_trd_party_val}" ).append("\n"); 
		query.append("SELECT   IT.OFC_CD" ).append("\n"); 
		query.append("       , SC.IDA_GST_RGST_NO AS SM_IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       , ID.N3PTY_NO" ).append("\n"); 
		query.append("       , IM.N3PTY_INV_NO" ).append("\n"); 
		query.append("       , IM.N3PTY_INV_RVIS_SEQ AS N3PTY_INV_HIS_SEQ" ).append("\n"); 
		query.append("       , IM.N3PTY_INV_RVIS_CD" ).append("\n"); 
		query.append("       , TO_CHAR(TPB_GET_LCL_DATE_FNC(IM.INV_ISS_LOCL_DT,@[s_usr_ofc_cd]),'YYYY-MM-DD HH24:MI') AS INV_ISS_LOCL_DT" ).append("\n"); 
		query.append("       , IM.UPD_USR_ID" ).append("\n"); 
		query.append("       , IM.CLT_AGN_FLG" ).append("\n"); 
		query.append("       , TO_CHAR(TPB_GET_LCL_DATE_FNC(IM.AR_IF_DT,@[s_usr_ofc_cd]),'YYYY-MM-DD HH24:MI') AS AR_IF_DT" ).append("\n"); 
		query.append("       , ID.BKG_NO" ).append("\n"); 
		query.append("       , IM.IF_BL_NO" ).append("\n"); 
		query.append("       , NVL(CC.IDA_SPCL_ECN_ZN_UT_FLG,'N') AS N3PTY_IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append("       , IM.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("       , CASE IM.VNDR_CUST_DIV_CD WHEN 'V' THEN TRIM(TO_CHAR(IM.VNDR_SEQ,'000000'))" ).append("\n"); 
		query.append("                                  WHEN 'C' THEN IM.CUST_CNT_CD||TRIM(TO_CHAR(IM.CUST_SEQ,'000000'))" ).append("\n"); 
		query.append("         END AS TRD_PARTY_CODE" ).append("\n"); 
		query.append("       , IM.VNDR_CUST_NM AS TRD_PARTY_NM" ).append("\n"); 
		query.append("       , CASE IM.VNDR_CUST_DIV_CD WHEN 'V' THEN CV.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("                                  WHEN 'C' THEN CC.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("         END AS N3PTY_IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       , BT.N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("       , BT.IDA_SAC_CD" ).append("\n"); 
		query.append("       , IM.CURR_CD" ).append("\n"); 
		query.append("       , IM.NET_AMT AS OTS_AMT" ).append("\n"); 
		query.append("       , IM.ADD_AMT" ).append("\n"); 
		query.append("       , IM.DDCT_AMT" ).append("\n"); 
		query.append("       , IM.VAT_AMT + NVL(IM.LOCL_TAX_AMT,0) AS VAT_AMT" ).append("\n"); 
		query.append("       , IM.INV_AMT" ).append("\n"); 
		query.append("       , IM.CLT_AMT" ).append("\n"); 
		query.append("       , SS.IDA_STE_CD AS SM_IDA_STE_CD" ).append("\n"); 
		query.append("       , CS.IDA_STE_CD AS N3PTY_IDA_STE_CD" ).append("\n"); 
		query.append("       , CASE WHEN SC.IDA_GST_RGST_NO IS NULL THEN 'Yes' ELSE 'No' END AS RVS_CHG_FLG" ).append("\n"); 
		query.append("       , NVL(IM.NET_AMT,0) + NVL(IM.ADD_AMT,0) - NVL(IM.DDCT_AMT,0) AS TAXABL_AMT" ).append("\n"); 
		query.append("       , IM.IDA_IGST_RTO" ).append("\n"); 
		query.append("       , IM.IDA_IGST_AMT" ).append("\n"); 
		query.append("       , IM.IDA_CGST_RTO" ).append("\n"); 
		query.append("       , IM.IDA_CGST_AMT" ).append("\n"); 
		query.append("       , IM.IDA_SGST_RTO" ).append("\n"); 
		query.append("       , IM.IDA_SGST_AMT" ).append("\n"); 
		query.append("       , IM.IDA_UGST_RTO" ).append("\n"); 
		query.append("       , IM.IDA_UGST_AMT" ).append("\n"); 
		query.append("       , IM.VAT_AMT AS IDA_GST_TAX_AMT" ).append("\n"); 
		query.append("       , ( SELECT COUNT(DISTINCT N3PTY_BIL_TP_CD) FROM TPB_INV_RVIS_DTL S WHERE S.N3PTY_INV_NO = IM.N3PTY_INV_NO AND S.N3PTY_INV_RVIS_SEQ = IM.N3PTY_INV_RVIS_SEQ ) AS LENGTH_N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("       , OL.CNT_CD" ).append("\n"); 
		query.append("FROM     TPB_INVOICE IT" ).append("\n"); 
		query.append("       , TPB_INV_RVIS IM" ).append("\n"); 
		query.append("       , TPB_INV_RVIS_DTL ID" ).append("\n"); 
		query.append("       , TPB_N3RD_PTY_BIL_TP BT" ).append("\n"); 
		query.append("--Table For India Taxtion" ).append("\n"); 
		query.append("       , MDM_ORGANIZATION SO" ).append("\n"); 
		query.append("       , MDM_LOCATION OL" ).append("\n"); 
		query.append("       , MDM_CUSTOMER SC -- Office Code에 해당하는 Customer 정보를 가져오기 위한 조인 ( SM 상선용 )" ).append("\n"); 
		query.append("       , MDM_LOCATION SL -- Office Code와 Customer에 매핑되는 Location 정보를 가져오기 위한 조인 ( SM 상선용 )" ).append("\n"); 
		query.append("       , MDM_STATE SS -- Office Code와 Customer에 매핑되는 State 정보를 가져오기 위한 조인 ( SM 상선용 )" ).append("\n"); 
		query.append("       , MDM_CUSTOMER CC -- Invoice Customer에 해당하는 Customer 정보를 가져오기 위한 조인 ( Customer용 )" ).append("\n"); 
		query.append("       , MDM_VENDOR CV -- Invoice Vendor에 해당하는 Vendor 정보를 가져오기 위한 조인 ( Customer용 )" ).append("\n"); 
		query.append("       , MDM_LOCATION CL -- Invoice Customer/Vendor에 매핑되는 Location 정보를 가져오기 위한 조인 ( Customer용 )" ).append("\n"); 
		query.append("       , MDM_STATE CS -- Invoice Customer/Vendor에 매핑되는 State 정보를 가져오기 위한 조인 ( Customer용 )" ).append("\n"); 
		query.append("--Table For India Taxtion" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      IT.N3PTY_INV_NO = IM.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_NO = ID.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_RVIS_SEQ = ID.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND      ID.N3PTY_BIL_TP_CD = BT.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("--Join For India Taxtion" ).append("\n"); 
		query.append("AND      IT.OFC_CD = SO.OFC_CD" ).append("\n"); 
		query.append("AND      SO.LOC_CD = OL.LOC_CD" ).append("\n"); 
		query.append("AND      SO.REP_CUST_CNT_CD = SC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND      SO.REP_CUST_SEQ = SC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND      NVL(SC.LOC_CD,'KRSEL') = SL.LOC_CD" ).append("\n"); 
		query.append("AND      SL.CNT_CD = SS.CNT_CD(+)" ).append("\n"); 
		query.append("AND      SL.STE_CD = SS.STE_CD(+)" ).append("\n"); 
		query.append("AND      IM.CUST_CNT_CD = CC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND      IM.CUST_SEQ = CC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND      IM.VNDR_SEQ = CV.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND      CL.LOC_CD = CASE WHEN IM.VNDR_CUST_DIV_CD = 'C' THEN CC.LOC_CD ELSE CV.LOC_CD END" ).append("\n"); 
		query.append("AND      CL.CNT_CD = CS.CNT_CD(+)" ).append("\n"); 
		query.append("AND      CL.STE_CD = CS.STE_CD(+)" ).append("\n"); 
		query.append("--Join For India Taxtion" ).append("\n"); 
		query.append("AND      ID.N3PTY_INV_RVIS_DTL_SEQ = 1" ).append("\n"); 
		query.append("AND      BT.N3PTY_BIL_TP_CD != 'JO'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_if_type} == 'S') " ).append("\n"); 
		query.append("AND      BT.N3PTY_IF_TP_CD IN ('M','S')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND      BT.N3PTY_IF_TP_CD = 'R'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_cond} == '1') " ).append("\n"); 
		query.append("AND      IM.INV_ISS_LOCL_DT >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_usr_ofc_cd])" ).append("\n"); 
		query.append("AND      IM.INV_ISS_LOCL_DT < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_usr_ofc_cd]) + 1" ).append("\n"); 
		query.append("AND      IT.OFC_CD IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   OFC_CD" ).append("\n"); 
		query.append("           FROM     TPB_HNDL_OFC" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      N3PTY_OFC_TP_CD = 'T'" ).append("\n"); 
		query.append("	#if (${s_if_rhq_cd} != '') " ).append("\n"); 
		query.append("           AND      RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("           AND      N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND      OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${s_cond} == '2')" ).append("\n"); 
		query.append("--invoice NSO." ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_NO = SUBSTRB(@[s_n3pty_inv_no_for_search],1,11)" ).append("\n"); 
		query.append("	#if (${s_n3pty_inv_rmd_cd_for_search} != '')" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_RVIS_CD LIKE @[s_n3pty_inv_rmd_cd_for_search]||'%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#elseif (${s_cond} == '3')" ).append("\n"); 
		query.append("--EQ NSO." ).append("\n"); 
		query.append("AND      EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   S.N3PTY_INV_NO" ).append("\n"); 
		query.append("           FROM     TPB_INV_RVIS_DTL S" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      S.EQ_NO = @[s_eq_no]" ).append("\n"); 
		query.append("           AND      S.N3PTY_INV_NO = IM.N3PTY_INV_NO" ).append("\n"); 
		query.append("           AND      S.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("--Collection Agency" ).append("\n"); 
		query.append("#if (${s_clt_agn_flg} == 'E') " ).append("\n"); 
		query.append("--Excluding" ).append("\n"); 
		query.append("AND      IM.CLT_AGN_FLG = 'N'  " ).append("\n"); 
		query.append("#elseif (${s_clt_agn_flg} == 'O')" ).append("\n"); 
		query.append("--Only" ).append("\n"); 
		query.append("AND      IM.CLT_AGN_FLG = 'Y'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--ERP I/F" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_inv_sts_cd} == 'E')" ).append("\n"); 
		query.append("--Excluding" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_STS_CD = 'N'  " ).append("\n"); 
		query.append("#elseif (${s_n3pty_inv_sts_cd} == 'O')" ).append("\n"); 
		query.append("--Only" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_STS_CD <> 'N'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--- 3rd Party --- " ).append("\n"); 
		query.append("#if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("AND      IM.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("    #if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("        #if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("AND      IM.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("		#elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("AND      IM.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("			#if ($s_trd_party_val.length() > 2)" ).append("\n"); 
		query.append("AND      IM.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("AND      'Y' = @[s_trd_party_val]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- search version value - A/O/C/R/L" ).append("\n"); 
		query.append("#if (${s_invce_search_version} == 'O')" ).append("\n"); 
		query.append("--ORG" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_RVIS_CD = 'ORG'" ).append("\n"); 
		query.append("#elseif (${s_invce_search_version} == 'C')" ).append("\n"); 
		query.append("--Cxx" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_RVIS_CD LIKE 'C%'" ).append("\n"); 
		query.append("#elseif (${s_invce_search_version} == 'R')" ).append("\n"); 
		query.append("--Rxx" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_RVIS_CD LIKE 'R%'" ).append("\n"); 
		query.append("#elseif (${s_invce_search_version} == 'L')" ).append("\n"); 
		query.append("--Last Version" ).append("\n"); 
		query.append("AND      IT.LST_N3PTY_INV_RVIS_SEQ = IM.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY IM.N3PTY_INV_NO ASC" ).append("\n"); 
		query.append("       , IM.N3PTY_INV_RVIS_SEQ ASC" ).append("\n"); 

	}
}
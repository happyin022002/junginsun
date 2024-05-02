/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ExpenseMgtDBDAOsearchPayableInvoiceListByINVDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOsearchPayableInvoiceListByINVDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOsearchPayableInvoiceListByINVDataRSQL
	  * -- 2014.11 10만불 결제관련
	  * </pre>
	  */
	public ExpenseMgtDBDAOsearchPayableInvoiceListByINVDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_type_code",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOsearchPayableInvoiceListByINVDataRSQL").append("\n"); 
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
		query.append("SELECT   ORD.COST_OFC_CD" ).append("\n"); 
		query.append("       , A.PAY_INV_SEQ" ).append("\n"); 
		query.append("       , A.INV_NO WO_NO" ).append("\n"); 
		query.append("       , A.MNR_INP_TP_CD AS WO_TYPE_CODE" ).append("\n"); 
		query.append("       , D.MNR_CD_DESC AS WO_TYPE" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.ORD_VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("       , ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.ORD_VNDR_SEQ ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.MNR_PRNR_SEQ) AS MNR_PRNR_SEQ" ).append("\n"); 
		query.append("       , V.VNDR_LGL_ENG_NM AS PAY_VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("       , TO_CHAR(A.RCV_DT , 'YYYY-MM-DD') AS RCV_DT" ).append("\n"); 
		query.append("       , TO_CHAR(A.EFF_DT , 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("       , TO_CHAR(A.ISS_DT , 'YYYY-MM-DD') AS ISS_DT" ).append("\n"); 
		query.append("       , TO_CHAR(A.CFM_DT , 'YYYY-MM-DD') AS CFM_DT" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[user_ofc_cd]), 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("       , A.BZC_AMT AS MNR_WRK_AMT" ).append("\n"); 
		query.append("       , A.SLS_TAX_AMT" ).append("\n"); 
		query.append("       , A.VAT_AMT" ).append("\n"); 
		query.append("       , A.WHLD_TAX_AMT" ).append("\n"); 
		query.append("       , A.TTL_AMT" ).append("\n"); 
		query.append("       , A.MNR_INV_RMK" ).append("\n"); 
		query.append("       , A.MNR_INV_STS_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   MGC.MNR_CD_DESC" ).append("\n"); 
		query.append("           FROM     MNR_GEN_CD MGC " ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      DECODE(A.MNR_INV_STS_CD, 'HC', API.INV_STS_CD,A.MNR_INV_STS_CD) = MGC.MNR_CD_ID " ).append("\n"); 
		query.append("           AND      MGC.PRNT_CD_ID IN ('CD00027', 'CD00042')" ).append("\n"); 
		query.append("           AND      ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS MNR_INV_STS_NM" ).append("\n"); 
		query.append("       , A.GEN_PAY_TERM_CD AS PAY_TERM_DYS" ).append("\n"); 
		query.append("       , A.CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("       , A.ISS_OFC_CD" ).append("\n"); 
		query.append("       , API.CSR_NO" ).append("\n"); 
		query.append("       , A.INV_RGST_NO" ).append("\n"); 
		query.append("       , E.DP_PRCS_KNT" ).append("\n"); 
		query.append("       , FILE_SEQ" ).append("\n"); 
		query.append("       , NVL(A.ENV_CHG_TAX, 0) AS ENV_CHG_TAX -- 인도지역의 SBC Tax" ).append("\n"); 
		query.append("       , L.CNT_CD" ).append("\n"); 
		query.append("       , V.IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append("       , CASE WHEN V.IDA_GST_RGST_NO IS NULL THEN 'N' ELSE 'Y' END AS IDA_GST_RGST_NO_FLG" ).append("\n"); 
		query.append("       , V.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   S.IDA_STE_CD" ).append("\n"); 
		query.append("           FROM     MDM_STATE S" ).append("\n"); 
		query.append("                  , MDM_LOCATION L" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      S.CNT_CD = L.CNT_CD" ).append("\n"); 
		query.append("           AND      S.STE_CD = L.STE_CD" ).append("\n"); 
		query.append("           AND      L.LOC_CD = V.LOC_CD" ).append("\n"); 
		query.append("         ) AS IDA_STE_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   S.STE_NM" ).append("\n"); 
		query.append("           FROM     MDM_STATE S" ).append("\n"); 
		query.append("                  , MDM_LOCATION L" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      S.CNT_CD = L.CNT_CD" ).append("\n"); 
		query.append("           AND      S.STE_CD = L.STE_CD" ).append("\n"); 
		query.append("           AND      L.LOC_CD = V.LOC_CD" ).append("\n"); 
		query.append("         ) AS IDA_STE_NM" ).append("\n"); 
		query.append("FROM     MNR_PAY_INV_WRK A" ).append("\n"); 
		query.append("       , MDM_VENDOR V" ).append("\n"); 
		query.append("       , MNR_GEN_CD D" ).append("\n"); 
		query.append("       , MDM_CURRENCY E" ).append("\n"); 
		query.append("       , AP_PAY_INV API" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   DISTINCT B.PAY_INV_SEQ" ).append("\n"); 
		query.append("                  , A.COST_OFC_CD" ).append("\n"); 
		query.append("	       FROM     MNR_ORD_HDR A" ).append("\n"); 
		query.append("                  , MNR_ORD_DTL B" ).append("\n"); 
		query.append("		   WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD " ).append("\n"); 
		query.append("		   AND      A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("		   AND      A.COST_OFC_CD= @[cost_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND      B.PAY_INV_SEQ > 1" ).append("\n"); 
		query.append("         ) ORD" ).append("\n"); 
		query.append("       , MDM_ORGANIZATION O" ).append("\n"); 
		query.append("       , MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.MNR_PRNR_SEQ = V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND      A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("AND      D.PRNT_CD_ID(+)='CD00019'" ).append("\n"); 
		query.append("AND      A.MNR_INP_TP_CD = D.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND      A.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("AND	     A.PAY_INV_SEQ = ORD.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND      ORD.COST_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND      O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("AND      A.ISS_OFC_CD = @[inv_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${cost_ofc_cd} == '')" ).append("\n"); 
		query.append("AND      A.ISS_OFC_CD = @[user_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${woNos} != '')" ).append("\n"); 
		query.append("AND	     A.INV_NO IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("    #foreach ($user_woNos IN ${woNos})" ).append("\n"); 
		query.append("        #if($velocityCount < $woNos.size())" ).append("\n"); 
		query.append("				'$user_woNos'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("				'$user_woNos'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end			  " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${input_date_type_code}=='R')" ).append("\n"); 
		query.append("AND      A.RCV_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${input_date_type_code}=='C')" ).append("\n"); 
		query.append("AND      A.UPD_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("AND      A.INV_RGST_NO IS NOT NULL" ).append("\n"); 
		query.append("	#elseif (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("AND      A.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${invNos} != '')" ).append("\n"); 
		query.append("AND	     A.INV_NO IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("    #foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("        #if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("				'$user_invNos'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("				'$user_invNos'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end			  " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("AND      A.ORD_VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${input_type_code} != '') " ).append("\n"); 
		query.append("AND      A.MNR_INP_TP_CD= @[input_type_code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND      API.INV_SUB_SYS_CD(+)='MNR'	" ).append("\n"); 
		query.append("AND      A.INV_RGST_NO = API.INV_RGST_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_inv_sts_cd} != '') " ).append("\n"); 
		query.append("    #if (${InvStsLen} == '2') " ).append("\n"); 
		query.append("AND      A.MNR_INV_STS_CD= @[mnr_inv_sts_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("AND      API.INV_STS_CD = @[mnr_inv_sts_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${csrNos} != '')" ).append("\n"); 
		query.append("AND	     A.INV_RGST_NO IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   API.INV_RGST_NO " ).append("\n"); 
		query.append("           FROM     AP_PAY_INV API " ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      API.INV_SUB_SYS_CD = 'MNR'" ).append("\n"); 
		query.append("           AND      API.CSR_NO IN" ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("    #foreach ($user_csrNos IN ${csrNos})" ).append("\n"); 
		query.append("        #if($velocityCount < $csrNos.size())" ).append("\n"); 
		query.append("                        '$user_csrNos'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                        '$user_csrNos'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end			  " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_wo_no} != '')" ).append("\n"); 
		query.append("AND	     A.PAY_INV_SEQ IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("		   SELECT   B.PAY_INV_SEQ" ).append("\n"); 
		query.append("		   FROM     MNR_ORD_HDR A" ).append("\n"); 
		query.append("                  , MNR_ORD_DTL B" ).append("\n"); 
		query.append("		   WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD " ).append("\n"); 
		query.append("		   AND      A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("		   AND      A.MNR_ORD_SEQ IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("    #foreach ($user_invWoNos IN ${invWoNos})" ).append("\n"); 
		query.append("        #if($velocityCount < $invWoNos.size())" ).append("\n"); 
		query.append("					$user_invWoNos," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("					$user_invWoNos" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
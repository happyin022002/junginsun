/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ExpenseMgtDBDAOsearchPayableInvoiceListByINVSPPDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.06 
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

public class ExpenseMgtDBDAOsearchPayableInvoiceListByINVSPPDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOsearchPayableInvoiceListByINVSPPDataRSQL
	  * </pre>
	  */
	public ExpenseMgtDBDAOsearchPayableInvoiceListByINVSPPDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOsearchPayableInvoiceListByINVSPPDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.PAY_INV_SEQ" ).append("\n"); 
		query.append(",A.INV_NO WO_NO" ).append("\n"); 
		query.append(",A.MNR_INP_TP_CD  WO_TYPE_CODE" ).append("\n"); 
		query.append(",D.MNR_CD_DESC WO_TYPE" ).append("\n"); 
		query.append(",MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.ORD_VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append(",B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.MNR_PRNR_SEQ) MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ=A.MNR_PRNR_SEQ) PAY_VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",TO_CHAR(A.RCV_DT , 'yyyy-mm-dd') RCV_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.EFF_DT , 'yyyy-mm-dd') EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.ISS_DT , 'yyyy-mm-dd') ISS_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.CFM_DT , 'yyyy-mm-dd') CFM_DT" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[user_ofc_cd]), 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.BZC_AMT MNR_WRK_AMT" ).append("\n"); 
		query.append(",A.SLS_TAX_AMT" ).append("\n"); 
		query.append(",A.VAT_AMT" ).append("\n"); 
		query.append(",A.WHLD_TAX_AMT" ).append("\n"); 
		query.append(",A.TTL_AMT" ).append("\n"); 
		query.append(",A.MNR_INV_RMK" ).append("\n"); 
		query.append(",A.MNR_INV_STS_CD" ).append("\n"); 
		query.append(", (SELECT MGC.MNR_CD_DESC FROM MNR_GEN_CD MGC " ).append("\n"); 
		query.append("         WHERE DECODE(A.MNR_INV_STS_CD, 'HC', (SELECT API.INV_STS_CD FROM  AP_PAY_INV API WHERE A.INV_RGST_NO = API.INV_RGST_NO AND API.INV_SUB_SYS_CD='MNR' AND ROWNUM = 1)," ).append("\n"); 
		query.append("               A.MNR_INV_STS_CD) = MGC.MNR_CD_ID " ).append("\n"); 
		query.append("         AND MGC.PRNT_CD_ID IN ('CD00027', 'CD00042')" ).append("\n"); 
		query.append("         AND ROWNUM = 1) MNR_INV_STS_NM" ).append("\n"); 
		query.append(",A.GEN_PAY_TERM_CD PAY_TERM_DYS" ).append("\n"); 
		query.append(",A.CURR_CD CURR_CD" ).append("\n"); 
		query.append(",A.ISS_OFC_CD" ).append("\n"); 
		query.append(",A.CSR_NO" ).append("\n"); 
		query.append(",E.DP_PRCS_KNT" ).append("\n"); 
		query.append(",NVL(A.ENV_CHG_TAX, 0) ENV_CHG_TAX -- 인도지역의 SBC Tax" ).append("\n"); 
		query.append("FROM MNR_PAY_INV_WRK A, MDM_VENDOR B, MNR_GEN_CD D, MDM_CURRENCY E" ).append("\n"); 
		query.append("WHERE A.ORD_VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.MNR_INP_TP_CD = 'W'" ).append("\n"); 
		query.append("AND D.PRNT_CD_ID(+)='CD00019'" ).append("\n"); 
		query.append("AND A.MNR_INP_TP_CD = D.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND A.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("#if (${woNos} != '')" ).append("\n"); 
		query.append("	AND	A.INV_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_woNos IN ${woNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $woNos.size())" ).append("\n"); 
		query.append("				'$user_woNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_woNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${input_date_type_code}=='R')" ).append("\n"); 
		query.append("   		AND TO_CHAR(A.RCV_DT, 'yyyy-mm-dd') BETWEEN @[from_dt] AND @[to_dt]" ).append("\n"); 
		query.append("	#elseif (${input_date_type_code}=='C')" ).append("\n"); 
		query.append("   		AND A.UPD_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("	#elseif (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("   		AND A.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${invNos} != '')" ).append("\n"); 
		query.append("	AND	A.INV_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("				'$user_invNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_invNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("	AND A.ORD_VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${input_type_code} != '') " ).append("\n"); 
		query.append("	AND A.MNR_INP_TP_CD= @[input_type_code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_inv_sts_cd} != '') " ).append("\n"); 
		query.append("	AND A.MNR_INV_STS_CD= @[mnr_inv_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${csrNos} != '')" ).append("\n"); 
		query.append("	AND	A.CSR_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_csrNos IN ${csrNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $csrNos.size())" ).append("\n"); 
		query.append("				'$user_csrNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_csrNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_wo_no} != '')" ).append("\n"); 
		query.append("	AND	A.PAY_INV_SEQ IN (" ).append("\n"); 
		query.append("		SELECT B.PAY_INV_SEQ" ).append("\n"); 
		query.append("		FROM MNR_ORD_HDR A, MNR_ORD_DTL B" ).append("\n"); 
		query.append("		WHERE A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD " ).append("\n"); 
		query.append("		AND A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("		AND A.MNR_ORD_SEQ IN (" ).append("\n"); 
		query.append("			#foreach ($user_invWoNos IN ${invWoNos})" ).append("\n"); 
		query.append("				#if($velocityCount < $invWoNos.size())" ).append("\n"); 
		query.append("					$user_invWoNos," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					$user_invWoNos" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end			  " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pay_inv_seq} != '')" ).append("\n"); 
		query.append("	AND A.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
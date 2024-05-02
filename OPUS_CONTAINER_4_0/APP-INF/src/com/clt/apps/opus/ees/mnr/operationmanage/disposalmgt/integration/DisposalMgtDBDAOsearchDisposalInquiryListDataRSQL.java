/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalInquiryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalInquiryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DisposalMgtDBDAOsearchDisposalInquiryListDataRSQL
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalInquiryListDataRSQL(){
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
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalInquiryListDataRSQL").append("\n"); 
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
		query.append("SELECT   DISTINCT " ).append("\n"); 
		query.append("         A.RCV_INV_SEQ" ).append("\n"); 
		query.append("        ,A.MNR_GRP_TP_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_TP_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("        ,A.INV_NO" ).append("\n"); 
		query.append("        ,A.MNR_INV_REF_NO" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("         WHEN A.MNR_INV_STS_CD = 'HC' THEN" ).append("\n"); 
		query.append("             (SELECT /*+ INDEX_DESC (IAI XPKINV_AR_IF_MN) */ " ).append("\n"); 
		query.append("                     DECODE(IAA.INV_ERP_IF_STS_CD, 'N', (SELECT MGC.MNR_CD_DESC" ).append("\n"); 
		query.append("                                                         FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("                                                         WHERE A.MNR_INV_STS_CD = MGC.MNR_CD_ID" ).append("\n"); 
		query.append("                                                         AND   MGC.PRNT_CD_ID = 'CD00081'" ).append("\n"); 
		query.append("                                                         AND ROWNUM =1),            " ).append("\n"); 
		query.append("                                                   'E', IAA.ERR_DESC," ).append("\n"); 
		query.append("                                                   'Y', 'SAR Interfaced' " ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("              FROM  INV_AR_IF_MN IAI, INV_AR_AMT IAA" ).append("\n"); 
		query.append("              WHERE IAI.AR_IF_NO = IAA.AR_IF_NO" ).append("\n"); 
		query.append("              AND   A.INV_NO     = IAI.BL_SRC_NO" ).append("\n"); 
		query.append("              AND   ROWNUM = 1)      " ).append("\n"); 
		query.append("         ELSE " ).append("\n"); 
		query.append("            (SELECT MGC.MNR_CD_DESC" ).append("\n"); 
		query.append("             FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("             WHERE A.MNR_INV_STS_CD = MGC.MNR_CD_ID" ).append("\n"); 
		query.append("             AND   MGC.PRNT_CD_ID = 'CD00081'" ).append("\n"); 
		query.append("             AND ROWNUM =1)            " ).append("\n"); 
		query.append("         END MNR_INV_STS_CD" ).append("\n"); 
		query.append("		,NVL((SELECT DECODE(BO.STL_FLG,'Y','Settled','N','Not Settled')" ).append("\n"); 
		query.append("			  FROM SAR_OTS_HDR BO" ).append("\n"); 
		query.append("			  WHERE BO.BL_NO = A.INV_NO" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), 'Not Settled') INV_STL_STS_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CFM_DT, 'yyyy-mm-dd') CFM_DT" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("        ,A.VAT_AMT" ).append("\n"); 
		query.append("        ,A.WHLD_TAX_AMT" ).append("\n"); 
		query.append("        ,A.TTL_AMT" ).append("\n"); 
		query.append("        ,A.INV_PAY_MZD_CD" ).append("\n"); 
		query.append("        ,A.CHK_TRNS_NO" ).append("\n"); 
		query.append("        ,A.GL_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(A.ISS_DT, 'yyyy-mm-dd') ISS_DT" ).append("\n"); 
		query.append("        ,A.ISS_OFC_CD" ).append("\n"); 
		query.append("        ,A.MNR_INV_REF_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(A.INV_DUE_DT, 'yyyy-mm-dd') INV_DUE_DT" ).append("\n"); 
		query.append("        ,A.BANK_NM" ).append("\n"); 
		query.append("        ,A.BANK_ACCT_NO" ).append("\n"); 
		query.append("        ,A.MNR_BIL_TO_NM" ).append("\n"); 
		query.append("        ,A.MNR_INV_RMK" ).append("\n"); 
		query.append("        ,A.CLT_STL_FLG" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("		,B.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,E.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK A, MNR_PARTNER B, MDM_CURRENCY E, INV_AR_IF_MN IAI, INV_AR_AMT IAA" ).append("\n"); 
		query.append("WHERE A.MNR_PRNR_CNT_CD = B.MNR_PRNR_CNT_CD(+)" ).append("\n"); 
		query.append("	AND A.MNR_PRNR_SEQ = B.MNR_PRNR_SEQ(+)" ).append("\n"); 
		query.append("    AND A.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("#if(${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("	AND A.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(NVL(@[inv_ofc_cd],MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()), TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(NVL(@[inv_ofc_cd],MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()), TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND   A.ISS_OFC_CD IN ( SELECT D.OFC_CD" ).append("\n"); 
		query.append("                    FROM   MNR_OFC_GEN_INFO D" ).append("\n"); 
		query.append("                    WHERE  D.UPPR_OFC_CD  =  @[inv_ofc_cd]" ).append("\n"); 
		query.append("                         AND    D.MNR_GRP_TP_CD = 'OFC'" ).append("\n"); 
		query.append("                         AND    D.COST_CD       = 'MR'" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT @[inv_ofc_cd]" ).append("\n"); 
		query.append("                    FROM DUAL" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${dispNos} != '')" ).append("\n"); 
		query.append("	AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("             FROM MNR_DISP_DTL E             " ).append("\n"); 
		query.append("             WHERE A.RCV_INV_SEQ = E.RCV_INV_SEQ" ).append("\n"); 
		query.append("				AND	E.DISP_NO IN (" ).append("\n"); 
		query.append("					#foreach ($user_dispNos IN ${dispNos})" ).append("\n"); 
		query.append("						#if($velocityCount < $dispNos.size())" ).append("\n"); 
		query.append("							'$user_dispNos'," ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							'$user_dispNos'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end			  " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("             	AND ROWNUM = 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dispRlseNos} != '')" ).append("\n"); 
		query.append("	AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("             FROM MNR_DISP_DTL E             " ).append("\n"); 
		query.append("             WHERE A.RCV_INV_SEQ = E.RCV_INV_SEQ" ).append("\n"); 
		query.append("				AND	E.DISP_RLSE_NO IN (" ).append("\n"); 
		query.append("					#foreach ($user_dispRlseNos IN ${dispRlseNos})" ).append("\n"); 
		query.append("						#if($velocityCount < $dispRlseNos.size())" ).append("\n"); 
		query.append("							'$user_dispRlseNos'," ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							'$user_dispRlseNos'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end			  " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("             	AND ROWNUM = 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_no_list} != '')" ).append("\n"); 
		query.append("	AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("             FROM MNR_DISP_DTL E             " ).append("\n"); 
		query.append("             WHERE A.RCV_INV_SEQ = E.RCV_INV_SEQ" ).append("\n"); 
		query.append("				AND	E.EQ_NO IN (" ).append("\n"); 
		query.append("					#foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("						#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("							'$user_eqNos'," ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							'$user_eqNos'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end			  " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("             	AND ROWNUM = 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cd} != '') " ).append("\n"); 
		query.append("	AND A.MNR_PRNR_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("	AND A.MNR_PRNR_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_inv_sts_cd} == 'ALL') " ).append("\n"); 
		query.append("	AND IAI.AR_IF_NO = IAA.AR_IF_NO(+)" ).append("\n"); 
		query.append("	AND A.INV_NO     = IAI.BL_SRC_NO(+)" ).append("\n"); 
		query.append("#elseif (${mnr_inv_sts_cd} == 'HS') " ).append("\n"); 
		query.append("	AND IAI.AR_IF_NO = IAA.AR_IF_NO(+)" ).append("\n"); 
		query.append("	AND A.INV_NO     = IAI.BL_SRC_NO(+)" ).append("\n"); 
		query.append("	AND a.MNR_INV_STS_CD = 'HS'" ).append("\n"); 
		query.append("#elseif (${mnr_inv_sts_cd} == 'HC') " ).append("\n"); 
		query.append("	AND IAI.AR_IF_NO = IAA.AR_IF_NO" ).append("\n"); 
		query.append("	AND A.INV_NO     = IAI.BL_SRC_NO" ).append("\n"); 
		query.append("	and A.MNR_INV_STS_CD= 'HC'" ).append("\n"); 
		query.append("	and IAA.INV_ERP_IF_STS_CD <> 'Y'" ).append("\n"); 
		query.append("#elseif (${mnr_inv_sts_cd} == 'EI') " ).append("\n"); 
		query.append("	AND IAI.AR_IF_NO = IAA.AR_IF_NO" ).append("\n"); 
		query.append("	AND A.INV_NO     = IAI.BL_SRC_NO" ).append("\n"); 
		query.append("	and IAA.INV_ERP_IF_STS_CD = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND IAI.AR_IF_NO = IAA.AR_IF_NO(+)" ).append("\n"); 
		query.append("	AND A.INV_NO     = IAI.BL_SRC_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
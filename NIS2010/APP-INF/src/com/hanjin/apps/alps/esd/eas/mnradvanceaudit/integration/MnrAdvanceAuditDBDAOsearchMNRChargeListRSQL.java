/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMNRChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMNRChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNR 심의 대상 목록 조회
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMNRChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cost_group_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_auto_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_expn_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_csr_status",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMNRChargeListRSQL").append("\n"); 
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
		query.append("SELECT   EI.INV_NO" ).append("\n"); 
		query.append("       , EI.VNDR_SEQ" ).append("\n"); 
		query.append("       , V.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("       , EI.EQ_KND_CD" ).append("\n"); 
		query.append("       , DECODE(EI.EQ_KND_CD, 'U', 'Container', 'Z', 'Chassis', 'G', 'M.G. Set', EI.EQ_KND_CD) AS EQ_KND_CD_NM" ).append("\n"); 
		query.append("       , EI.EXPN_AUD_STS_CD AS AUDIT_RESULT" ).append("\n"); 
		query.append("       , EI.CRE_USR_ID" ).append("\n"); 
		query.append("       , EI.CRE_DT" ).append("\n"); 
		query.append("       , EI.UPD_USR_ID" ).append("\n"); 
		query.append("       , EI.UPD_DT" ).append("\n"); 
		query.append("       , EI.EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("       , EI.EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("       , ( SELECT USR_NM FROM COM_USER U WHERE EI.EXPN_AUD_RSLT_USR_ID = U.USR_ID ) AS EXPN_AUD_RSLT_USR_NM" ).append("\n"); 
		query.append("       , EI.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("       , EI.EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("       , EI.RHQ_CD AS RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("       , EI.INV_OFC_CD" ).append("\n"); 
		query.append("       , EI.INV_CFM_DT" ).append("\n"); 
		query.append("       , EI.AUTO_EXPN_AUD_STS_CD AS AUTO_AUDIT" ).append("\n"); 
		query.append("       , EI.CURR_CD AS WO_CURR_CD" ).append("\n"); 
		query.append("       , EI.WO_AMT AS COST_AMT" ).append("\n"); 
		query.append("       , EI.INV_AMT" ).append("\n"); 
		query.append("       , EI.CURR_CNG_FLG AS REFL_EX_YN" ).append("\n"); 
		query.append("       , EI.INV_DIFF_AMT CHG_WO_AMT" ).append("\n"); 
		query.append("       , EI.INV_DIFF_RTO" ).append("\n"); 
		query.append("       , EI.INV_DIFF_RTO AS INV_DIFF_PCT" ).append("\n"); 
		query.append("       , EI.INV_DIFF_RTO AS WO_INV_RTO" ).append("\n"); 
		query.append("       , EI.CRE_OFC_CD" ).append("\n"); 
		query.append("       , EI.LOCL_CRE_DT" ).append("\n"); 
		query.append("       , EI.INV_CHG_AMT " ).append("\n"); 
		query.append("       , EI.WO_VRFY_FLG AS WK_VRFY_YN" ).append("\n"); 
		query.append("       , EI.ESTM_VRFY_FLG AS EST_VRFY_YN" ).append("\n"); 
		query.append("       , EI.ESTM_VRFY_DESC AS EST_VRFY_DESC" ).append("\n"); 
		query.append("       , EI.WO_VRFY_DESC" ).append("\n"); 
		query.append("       , EI.INV_RGST_NO" ).append("\n"); 
		query.append("       , EI.AUTO_AUD_CFM_DT AS CHECKED_DT" ).append("\n"); 
		query.append("       , TO_CHAR(EI.AUTO_AUD_CFM_DT, 'YYYY-MM-DD') AS AUDIT_DT" ).append("\n"); 
		query.append("       , EI.AUTO_AUD_CFM_USR_ID AS CHECKED_USER_ID" ).append("\n"); 
		query.append("       , ( SELECT USR_NM FROM COM_USER U WHERE EI.AUTO_AUD_CFM_USR_ID = U.USR_ID ) AS CHECKED_USER_NM " ).append("\n"); 
		query.append("       , AP.CSR_NO" ).append("\n"); 
		query.append("       , MI.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("       , TO_CHAR(MI.ISS_DT, 'YYYY-MM-DD') AS ISS_DT" ).append("\n"); 
		query.append("       , MI.ISS_OFC_CD" ).append("\n"); 
		query.append("       , TO_CHAR(TO_DATE(IM.PAY_DT, 'YYYYMMDD'), 'YYYY-MM-DD')  AS AP_PAY_DT" ).append("\n"); 
		query.append("       , TO_CHAR(TO_DATE(IM.INV_TERM_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS PAY_DUE_DT" ).append("\n"); 
		query.append("       , TO_CHAR(MI.CFM_DT, 'YYYY-MM-DD') AS CFM_DT" ).append("\n"); 
		query.append("       , AP.INV_RMK" ).append("\n"); 
		query.append("       , AP.INV_STS_CD" ).append("\n"); 
		query.append("       , ( SELECT MGC.MNR_CD_DESC FROM MNR_GEN_CD MGC WHERE AP.INV_STS_CD = MGC.MNR_CD_ID AND MGC.PRNT_CD_ID = 'CD00042' AND ROWNUM = 1 ) AS INV_STS_NM" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   DECODE(MAX(CFM.EAC_NO), NULL, '', 'Y') " ).append("\n"); 
		query.append("           FROM     EAS_MNR_CFM_INV_DTL CFM" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      EI.INV_NO = CFM.INV_NO" ).append("\n"); 
		query.append("           AND      EI.VNDR_SEQ = CFM.VNDR_SEQ" ).append("\n"); 
		query.append("           AND      EI.EQ_KND_CD = CFM.EQ_KND_CD" ).append("\n"); 
		query.append("         ) AS EAC_YN" ).append("\n"); 
		query.append("       , MI.MNR_INP_TP_CD" ).append("\n"); 
		query.append("       , MI.CRE_USR_ID" ).append("\n"); 
		query.append("       , CASE WHEN MI.MNR_INP_TP_CD = 'M' THEN ( SELECT USR_NM FROM COM_USER U WHERE MI.CRE_USR_ID = U.USR_ID )" ).append("\n"); 
		query.append("              WHEN MI.MNR_INP_TP_CD = 'W' THEN NVL( ( SELECT MNR_PRNR_LGL_ENG_NM FROM MNR_PARTNER P WHERE MI.CRE_USR_ID = P.SP_PTAL_ID AND ROWNUM = 1 ), MI.CRE_USR_ID )" ).append("\n"); 
		query.append("              ELSE MI.CRE_USR_ID" ).append("\n"); 
		query.append("         END AS INV_CRE_USER_NM" ).append("\n"); 
		query.append("       , CASE WHEN EI.ESTM_VRFY_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("              WHEN EI.WO_VRFY_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("              WHEN EI.EXPN_MAX_PRMT_RTO < EI.INV_DIFF_RTO THEN '0'" ).append("\n"); 
		query.append("              WHEN EI.MLT_WO_CURR_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("              WHEN EI.EXPN_AUD_STS_CD IS NOT NULL THEN '0'" ).append("\n"); 
		query.append("              WHEN EI.INV_DIFF_RTO <= -1 AND EI.EXPN_AUD_STS_CD IS NULL THEN '1'" ).append("\n"); 
		query.append("              WHEN EI.ESTM_VRFY_DESC IS NOT NULL THEN '1'" ).append("\n"); 
		query.append("              WHEN EI.WO_VRFY_DESC IS NOT NULL THEN '1'" ).append("\n"); 
		query.append("              WHEN EI.AUTO_EXPN_AUD_STS_CD = 'F' THEN '1'" ).append("\n"); 
		query.append("              WHEN ABS(EI.INV_DIFF_RTO) < 1 AND EI.EXPN_AUD_STS_CD IS NULL THEN '1' " ).append("\n"); 
		query.append("              WHEN EI.EXPN_MAX_PRMT_RTO > EI.INV_DIFF_RTO AND EI.EXPN_AUD_STS_CD IS NULL THEN '1'" ).append("\n"); 
		query.append("              ELSE '0'" ).append("\n"); 
		query.append("         END SEL" ).append("\n"); 
		query.append("       , CASE WHEN EI.WO_VRFY_FLG = 'Y' THEN ''" ).append("\n"); 
		query.append("              WHEN EI.ESTM_VRFY_FLG = 'Y' THEN ''" ).append("\n"); 
		query.append("              WHEN EI.EXPN_MAX_PRMT_RTO < EI.INV_DIFF_RTO THEN ''" ).append("\n"); 
		query.append("              WHEN EI.MLT_WO_CURR_FLG = 'Y' THEN ''" ).append("\n"); 
		query.append("              WHEN EI.EXPN_AUD_STS_CD IS NOT NULL THEN ''" ).append("\n"); 
		query.append("              WHEN EI.INV_DIFF_RTO <= -1 AND EI.EXPN_AUD_STS_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("              WHEN EI.ESTM_VRFY_DESC IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("              WHEN EI.WO_VRFY_DESC IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("              WHEN EI.AUTO_EXPN_AUD_STS_CD = 'F' THEN 'E'" ).append("\n"); 
		query.append("              WHEN ABS(EI.INV_DIFF_RTO) < 1 AND EI.EXPN_AUD_STS_CD IS NULL THEN 'P' " ).append("\n"); 
		query.append("              WHEN EI.EXPN_MAX_PRMT_RTO > EI.INV_DIFF_RTO AND EI.EXPN_AUD_STS_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("         END SELECT_FLG" ).append("\n"); 
		query.append("       , CASE WHEN EI.WO_VRFY_FLG = 'Y' THEN ''" ).append("\n"); 
		query.append("              WHEN EI.ESTM_VRFY_FLG = 'Y' THEN ''" ).append("\n"); 
		query.append("              WHEN EI.EXPN_MAX_PRMT_RTO < EI.INV_DIFF_RTO THEN ''" ).append("\n"); 
		query.append("              WHEN EI.MLT_WO_CURR_FLG = 'Y' THEN ''" ).append("\n"); 
		query.append("              WHEN EI.EXPN_AUD_STS_CD IS NOT NULL THEN ''" ).append("\n"); 
		query.append("              WHEN EI.INV_DIFF_RTO <= -1 AND EI.EXPN_AUD_STS_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("              WHEN EI.ESTM_VRFY_DESC IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("              WHEN EI.WO_VRFY_DESC IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("              WHEN EI.AUTO_EXPN_AUD_STS_CD = 'F' THEN 'E'" ).append("\n"); 
		query.append("              WHEN ABS(EI.INV_DIFF_RTO) < 1 AND EI.EXPN_AUD_STS_CD IS NULL THEN 'P' " ).append("\n"); 
		query.append("              WHEN EI.EXPN_MAX_PRMT_RTO > EI.INV_DIFF_RTO AND EI.EXPN_AUD_STS_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("         END SELECT_FLG_TEMP" ).append("\n"); 
		query.append("       , MI.CURR_CD AS INV_CURR_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   MAX(BAT_PROG_STS_CD)" ).append("\n"); 
		query.append("           FROM     EAS_AUTO_AUD_BAT X" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      SUB_SYS_CD = 'MNR'" ).append("\n"); 
		query.append("           AND      X.INV_NO        = EI.INV_NO" ).append("\n"); 
		query.append("           AND      X.INV_VNDR_SEQ  = EI.VNDR_SEQ" ).append("\n"); 
		query.append("           AND      X.EQ_KND_CD     = EI.EQ_KND_CD" ).append("\n"); 
		query.append("           AND      X.CRE_DT > SYSDATE - 1" ).append("\n"); 
		query.append("         ) BAT_PROG_STS_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   MAX(INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append("           FROM     EAS_AUTO_AUD_BAT BAT" ).append("\n"); 
		query.append("                  , COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      EI.INV_NO = BAT.INV_NO" ).append("\n"); 
		query.append("           AND      EI.VNDR_SEQ = BAT.INV_VNDR_SEQ" ).append("\n"); 
		query.append("           AND      EI.EQ_KND_CD = BAT.EQ_KND_CD" ).append("\n"); 
		query.append("           AND      BAT.SUB_SYS_CD = 'MNR'" ).append("\n"); 
		query.append("           AND      BAT.BAT_PROG_STS_CD = CD.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           AND      CD.INTG_CD_ID = 'CD03051'" ).append("\n"); 
		query.append("           AND      BAT.CRE_DT > SYSDATE - 1" ).append("\n"); 
		query.append("         ) BAT_PROG_STS_NM" ).append("\n"); 
		query.append("       , EI.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("       , DECODE(EI.MLT_WO_CURR_FLG, 'Y', 'Y', NULL) AS MLT_WO_CURR_FLG" ).append("\n"); 
		query.append("       , EI.AUD_CURR_CD AS INV_AUD_CURR_CD" ).append("\n"); 
		query.append("       , EI.AUD_DIFF_AMT AS INV_AUD_DIFF_AMT" ).append("\n"); 
		query.append("       , EI.AUD_USD_DIFF_AMT AS INV_AUD_USD_DIFF_AMT" ).append("\n"); 
		query.append("FROM     EAS_MNR_CFM_INV EI" ).append("\n"); 
		query.append("       , AP_PAY_INV AP" ).append("\n"); 
		query.append("       , AP_INV_HDR IM" ).append("\n"); 
		query.append("       , MDM_VENDOR V" ).append("\n"); 
		query.append("       , MNR_PAY_INV_WRK MI" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      EI.INV_NO = AP.INV_NO" ).append("\n"); 
		query.append("AND      EI.INV_RGST_NO = AP.INV_RGST_NO" ).append("\n"); 
		query.append("AND      AP.CSR_NO = IM.CSR_NO(+)" ).append("\n"); 
		query.append("AND      EI.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("AND      EI.INV_NO = MI.INV_NO" ).append("\n"); 
		query.append("AND      EI.INV_RGST_NO = MI.INV_RGST_NO" ).append("\n"); 
		query.append("AND      AP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND      MI.MNR_INV_STS_CD = 'HC'" ).append("\n"); 
		query.append("AND      IM.RCV_ERR_FLG(+) IS NULL --E(AP REJECT) OR NULL" ).append("\n"); 
		query.append("AND      IM.IF_FLG(+) IS NULL -- Y(정상) E(ERROR) NULL(진행안함)" ).append("\n"); 
		query.append("AND      IM.AFT_ACT_FLG(+) IS NULL -- N(CANCEL) X(CANCEL : ) NULL(정상)" ).append("\n"); 
		query.append("AND      EI.INV_CFM_DT BETWEEN TO_DATE(@[s_start_dt] || '000000', 'YYYY-MM-DDHH24MISS') AND TO_DATE(@[s_end_dt] || '235959', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("#if(${s_rhq_ofc_cd} != 'ALL' && ${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("AND      AP.INV_OFC_CD IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   OFC_CD " ).append("\n"); 
		query.append("           FROM     MDM_ORGANIZATION" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      DELT_FLG = 'N'" ).append("\n"); 
		query.append("           CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("           START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_ofc_cd} != 'ALL' && ${s_ofc_cd} != '')" ).append("\n"); 
		query.append("AND      AP.INV_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_cost_group_cd} != 'ALL' && ${s_cost_group_cd} !='')" ).append("\n"); 
		query.append("AND      EI.EQ_KND_CD = @[s_cost_group_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_vndr_seq} !='')" ).append("\n"); 
		query.append("AND      AP.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_csr_no} !='')" ).append("\n"); 
		query.append("AND      AP.CSR_NO IN (" ).append("\n"); 
		query.append("	#foreach ($user_csrNos IN ${csrNos})" ).append("\n"); 
		query.append("		#if($velocityCount < $csrNos.size())" ).append("\n"); 
		query.append("                    '$user_csrNos'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("                    '$user_csrNos'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end              " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_csr_status} !='ALL' && ${s_csr_status} !='')" ).append("\n"); 
		query.append("AND      AP.INV_STS_CD = @[s_csr_status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_inv_no} !='')" ).append("\n"); 
		query.append("AND      MI.INV_NO IN (" ).append("\n"); 
		query.append("	#foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("		#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("                    '$user_invNos'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("                    '$user_invNos'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_auto_aud_sts_cd} != 'ALL' && ${s_auto_aud_sts_cd} != '')" ).append("\n"); 
		query.append("AND      EI.AUTO_EXPN_AUD_STS_CD = @[s_auto_aud_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_expn_aud_sts_cd} != 'ALL' && ${s_expn_aud_sts_cd} != '')" ).append("\n"); 
		query.append("	#if(${s_expn_aud_sts_cd} == 'N')" ).append("\n"); 
		query.append("AND      EI.EXPN_AUD_STS_CD IS NULL " ).append("\n"); 
		query.append("	#elseif(${s_expn_aud_sts_cd} == 'D')" ).append("\n"); 
		query.append("AND      EI.EXPN_AUD_STS_CD IS NOT NULL " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("AND      EI.EXPN_AUD_STS_CD = @[s_expn_aud_sts_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_cost_cd} !='')" ).append("\n"); 
		query.append("AND      EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   'X'" ).append("\n"); 
		query.append("           FROM     MNR_ORD_DTL DTL" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      MI.PAY_INV_SEQ = DTL.PAY_INV_SEQ" ).append("\n"); 
		query.append("           AND      DTL.COST_CD IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("    #foreach ($user_costCds IN ${costCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $costCds.size())" ).append("\n"); 
		query.append("                '$user_costCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                '$user_costCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_difference} != 'ALL' && ${s_difference} != '')" ).append("\n"); 
		query.append("    #if(${s_difference} == 'E')" ).append("\n"); 
		query.append("AND      EI.ESTM_VRFY_FLG = 'Y'" ).append("\n"); 
		query.append("    #elseif(${s_difference} == 'W')" ).append("\n"); 
		query.append("AND      EI.WO_VRFY_FLG = 'Y'" ).append("\n"); 
		query.append("    #elseif(${s_difference} == 'M')" ).append("\n"); 
		query.append("AND      EI.MLT_WO_CURR_FLG = 'Y'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        #if(${s_err_type} == 'ZERO')" ).append("\n"); 
		query.append("AND      EI.INV_DIFF_AMT = 0" ).append("\n"); 
		query.append("        #elseif(${s_err_type} == 'PLUS')" ).append("\n"); 
		query.append("AND      EI.INV_DIFF_AMT > 0" ).append("\n"); 
		query.append("        #elseif(${s_err_type} == 'MINUS')" ).append("\n"); 
		query.append("AND      EI.INV_DIFF_AMT < 0" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("AND      EI.INV_DIFF_AMT != 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_difference} == 'E' && ${s_err_type} != '')" ).append("\n"); 
		query.append("AND      EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   'X'" ).append("\n"); 
		query.append("           FROM     MNR_RPR_RQST_HDR RH" ).append("\n"); 
		query.append("                  , MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("                  , MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                  , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("           AND      RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("           AND      RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("           AND      RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND      RH.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("           AND      RH.RQST_EQ_NO = OD.EQ_NO" ).append("\n"); 
		query.append("           AND      OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND      OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("           AND      OD.PAY_INV_SEQ = MI.PAY_INV_SEQ" ).append("\n"); 
		query.append("           AND      OH.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("           AND      RD.MNR_VRFY_TP_CD IN (" ).append("\n"); 
		query.append("    #foreach ($user_errTypes IN ${errTypes})" ).append("\n"); 
		query.append("        #if($velocityCount < $errTypes.size())" ).append("\n"); 
		query.append("                           '$user_errTypes'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                           '$user_errTypes'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_difference} == 'W' && ${s_err_type} != '')" ).append("\n"); 
		query.append("AND      EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   'X'" ).append("\n"); 
		query.append("           FROM     MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                  , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND      OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("           AND      OD.PAY_INV_SEQ = MI.PAY_INV_SEQ" ).append("\n"); 
		query.append("           AND      OH.EQ_KND_CD = EI.EQ_KND_CD" ).append("\n"); 
		query.append("           AND      OH.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("           AND      OD.MNR_VRFY_TP_CD IN (" ).append("\n"); 
		query.append("    #foreach ($user_errTypes IN ${errTypes})" ).append("\n"); 
		query.append("        #if($velocityCount < $errTypes.size())" ).append("\n"); 
		query.append("                           '$user_errTypes'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                           '$user_errTypes'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("                    )              " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
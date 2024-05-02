/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOSearchPreAuditList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOSearchPreAuditList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
	  *   RMK 오류(컬럼명 DIFF) 수정
	  * 2016.06.14 CHM-201642096 (긴급) EAS Auto Audit Performnace 수정 요청(A/P Rjected 대상 제외)
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOSearchPreAuditList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vessel",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("canalChargeType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("costCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("portlChargeType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vesselClass",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auditStatus",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accountCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yardCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diffNum",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("portCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("serviceChargeType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contractType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("divChargeType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sExpnAudStsCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOSearchPreAuditList2RSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT '' SEL, '' IBFLAG, '' SELECT_FLG" ).append("\n"); 
		query.append("     , T1.ISS_CTY_CD" ).append("\n"); 
		query.append("     , T1.SO_SEQ" ).append("\n"); 
		query.append("     , MAX(T1.SO_DTL_SEQ) SO_DTL_SEQ" ).append("\n"); 
		query.append("     , MAX(T1.EAC_NO) EAC_NO" ).append("\n"); 
		query.append("     , MAX(T1.VSL_CD) VSL_CD" ).append("\n"); 
		query.append("     , MAX(T1.CNTR_VSL_CLSS_CAPA) CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("     , MAX(T1.PORT_CHG_AUD_CHK_CD) AS SELECT_FLG_TEMP" ).append("\n"); 
		query.append("	 --, '계산' AUTO_AUDIT_FLG --AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("     , MAX(T1.AUTO_EXPN_AUD_STS_CD )                  AS AUTO_AUDIT_FLG" ).append("\n"); 
		query.append("     , MAX(T1.RHQ_CD   )                              AS RHQ" ).append("\n"); 
		query.append("     , MAX(T1.INV_OFC_CD  )                           AS OFFICE" ).append("\n"); 
		query.append("     , MAX(SUBSTR(T1.YD_CD,1,5) )                     AS PORT" ).append("\n"); 
		query.append("     , MAX(T1.YD_CD   )                               AS YARD" ).append("\n"); 
		query.append("     , T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD        AS VVD" ).append("\n"); 
		query.append("     , MAX(DECODE(T1.DP_IO_BND_CD, 'I', 'IN', 'O', 'OUT', 'IN/OUT')) AS BOUND" ).append("\n"); 
		query.append("     , MAX(T1.VPS_ETB_DT    )  AS VPS_ATB_DT" ).append("\n"); 
		query.append("     , MAX(T1.ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("     , MAX(MA.ACCT_ENG_NM) AS ACCT_NM" ).append("\n"); 
		query.append("     , T1.LGS_COST_CD AS COST_CD" ).append("\n"); 
		query.append("     , C.LGS_COST_FULL_NM AS COST_NM" ).append("\n"); 
		query.append("     , MAX(T1.VNDR_SEQ )                               AS SP_NO" ).append("\n"); 
		query.append("     , MAX(T1.INV_NO) INV_NO" ).append("\n"); 
		query.append("--     , (SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("     , MAX((SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = T1.INV_CRE_USR_ID)) AS CRE_USR_ID " ).append("\n"); 
		query.append("     , MAX(TO_CHAR(T1.ISS_DT,'YYYY-MM-DD'))    ISS_DT" ).append("\n"); 
		query.append("     , MAX(T1.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("     , MAX(T1.CALC_AMT)                               AS TARIFF_COST" ).append("\n"); 
		query.append("     , MAX(DECODE(T1.CALC_AMT, NULL, DECODE(T1.ADJ_AMT, NULL, T1.LOCL_AMT, T1.ADJ_AMT), T1.ADJ_AMT)) AS ADJCOST" ).append("\n"); 
		query.append("     --, T1.LOCL_AMT                               AS AMOUNT" ).append("\n"); 
		query.append("     , MAX(INV_AMT)                                AS AMOUNT" ).append("\n"); 
		query.append("     --, MAX(T1.DIFF_AMT)                             DIFF" ).append("\n"); 
		query.append("     --, MAX(T1.DIFF_AMT)                             DIFF" ).append("\n"); 
		query.append("     , CASE WHEN NVL(MAX(T1.CALC_AMT),0) = 0 THEN NULL ELSE " ).append("\n"); 
		query.append("		ROUND((MAX(INV_AMT) - MAX(T1.CALC_AMT)) / MAX(T1.CALC_AMT) * 100 , 2 ) END DIFF" ).append("\n"); 
		query.append("     , MAX(T1.FOML_DESC)                              AS FOML1" ).append("\n"); 
		query.append("     , MAX(T1.XPR_DESC )                              AS FOML2" ).append("\n"); 
		query.append("     , MAX(T1.DIFF_RMK)                               AS RMK" ).append("\n"); 
		query.append("------------" ).append("\n"); 
		query.append("#if (${chargeType} == '00' || ${chargeType} == '01' || ${chargeType} == '02')" ).append("\n"); 
		query.append("------------ chargetype '00', '01', '02'" ).append("\n"); 
		query.append("     , MAX(T1.BRTH_HRS) AS BERTHING_HOUR" ).append("\n"); 
		query.append("     , MAX(SUBSTR(T1.ST_PORT_CD, 0, 2)) COUNTRY_OF_NP" ).append("\n"); 
		query.append("     , MAX(T1.NET_RGST_TONG_WGT) AS NRT" ).append("\n"); 
		query.append("     , MAX(T1.ARR_TUG_BOT_KNT) ARR_TUG_BOT_KNT" ).append("\n"); 
		query.append("     , MAX(T1.DEP_TUG_BOT_KNT) DEP_TUG_BOT_KNT" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${chargeType} == '00' || ${chargeType} == '01' || ${chargeType} == '02' || ${chargeType} == '03')" ).append("\n"); 
		query.append("------------ chargetype '00', '01', '02', '03'" ).append("\n"); 
		query.append("     , MAX(T1.GRS_RGST_TONG_WGT) AS GRT " ).append("\n"); 
		query.append("     , MAX(T1.LST_PORT_CD  )   LAST_PORT--LST_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chargeType} == '00' || ${chargeType} == '03')" ).append("\n"); 
		query.append("------------ chargetype '00', '03'" ).append("\n"); 
		query.append("     , MAX(T1.SUZ_GT_WGT) SUZ_GT_WGT" ).append("\n"); 
		query.append("     , MAX(T1.MADN_VOY_SUZ_NET_TONG_WGT) MADN_VOY_SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("	 , '' AS NIGHT_FLG" ).append("\n"); 
		query.append("     , MAX(T1.SDR_XCH_RT) SDR_RT" ).append("\n"); 
		query.append("     , MAX(T1.VSL_TR_NO) SCG_CAR_TIER" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("     , MAX(DECODE(T1.PORT_CHG_AUD_CHK_CD,'','',(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = T1.UPD_USR_ID))) AS UPD_USR_ID" ).append("\n"); 
		query.append("     , MAX(DECODE(T1.PORT_CHG_AUD_CHK_CD,'','',(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = T1.PORT_CHG_AUD_USR_ID))) AS AUDIT_USR_ID --심사자" ).append("\n"); 
		query.append("     , MAX(DECODE(T1.PORT_CHG_AUD_CHK_CD,'','',TO_CHAR(PORT_CHG_AUD_DT, 'YYYY-MM-DD'))) AUDIT_DT --심사일" ).append("\n"); 
		query.append("     , MAX(T1.PORT_CHG_AUD_RSLT_RMK) PORT_CHG_AUD_RSLT_RMK" ).append("\n"); 
		query.append("     , MAX(T1.PORT_CHG_AUD_RSLT_USR_ID) PORT_CHG_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("     , MAX((SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = T1.PORT_CHG_AUD_RSLT_USR_ID)) AS PORT_CHG_AUD_RSLT_USR_NM" ).append("\n"); 
		query.append("     , MAX(T1.PAY_TERM_DYS) PAY_TERM_DYS" ).append("\n"); 
		query.append("     , MAX(AI.CSR_NO)    CSR_NO -- INV 테이블 걸어서 실시간으로" ).append("\n"); 
		query.append("     , MAX(TO_CHAR(AI.PAY_DUE_DT, 'YYYY-MM-DD')) PAY_DUE_DT-- INV 테이블 걸어서 실시간으로 하거나 없으면 PAY_TERM_DYS로 계산해서 사용" ).append("\n"); 
		query.append("     , MAX(AI.AP_PAY_DT) AP_PAY_DT -- INV 테이블 걸어서 실시간으로" ).append("\n"); 
		query.append("     --, MAX(TO_CHAR(T1.UPD_DT,'YYYY-MM-DD')) UPD_DT" ).append("\n"); 
		query.append("     , MAX(TO_CHAR(T1.INV_CFM_DT,'YYYY-MM-DD')) upd_dt --INV_CFM_DT -- Invoice Confirmed" ).append("\n"); 
		query.append("     , MAX(T1.ATCH_FILE_LNK_ID) ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("     , MAX(T1.EXPN_AUD_RSLT_CD) EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("     --, FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , MAX(B.BAT_PROG_STS_CD) bat_prog_sts_cd -- 배치상태 코드" ).append("\n"); 
		query.append("     , DECODE(MAX(B.BAT_PROG_STS_CD), 'P', 'Progressing', 'B','Created') bat_prog_sts_NM-- 배치상태 코드 " ).append("\n"); 
		query.append("	 , AUD_CURR_CD AS INV_AUD_CURR_CD" ).append("\n"); 
		query.append("	 , AUD_DIFF_AMT AS INV_AUD_DIFF_AMT" ).append("\n"); 
		query.append("	 , AUD_USD_DIFF_AMT AS INV_AUD_USD_DIFF_AMT" ).append("\n"); 
		query.append("  FROM EAS_PORT_SO_CFM_INV T1, TES_LGS_COST C, MDM_ACCOUNT MA, EAS_PORT_SO_CHG_ACCT CS" ).append("\n"); 
		query.append("       , AP_PAY_INV AI" ).append("\n"); 
		query.append("       , AP_INV_HDR AH" ).append("\n"); 
		query.append("       , PSO_CHARGE PSO" ).append("\n"); 
		query.append("       , EAS_AUTO_AUD_BAT B" ).append("\n"); 
		query.append("WHERE T1.ACCT_CD = MA.ACCT_CD" ).append("\n"); 
		query.append("AND T1.LGS_COST_CD = C.LGS_COST_CD" ).append("\n"); 
		query.append("AND T1.RHQ_CD = CS.AUD_OFC_CD" ).append("\n"); 
		query.append("AND T1.LGS_COST_CD = CS.LGS_COST_CD" ).append("\n"); 
		query.append("AND T1.ISS_CTY_CD = PSO.ISS_CTY_CD " ).append("\n"); 
		query.append("AND T1.SO_SEQ = PSO.SO_SEQ" ).append("\n"); 
		query.append("AND PSO.INV_RGST_NO  = AI.INV_RGST_NO" ).append("\n"); 
		query.append("AND AI.CSR_NO       = AH.CSR_NO(+)" ).append("\n"); 
		query.append("AND B.SUB_SYS_CD(+) = 'PSO'" ).append("\n"); 
		query.append("AND T1.ISS_CTY_CD   = B.ISS_CTY_CD(+)" ).append("\n"); 
		query.append("AND T1.SO_SEQ       = B.SO_SEQ(+)" ).append("\n"); 
		query.append("AND T1.SO_DTL_SEQ   = B.SO_DTL_SEQ(+)" ).append("\n"); 
		query.append("--검색조건" ).append("\n"); 
		query.append("#if ( ${rhq} !='' )" ).append("\n"); 
		query.append("--RHQ" ).append("\n"); 
		query.append("AND RHQ_CD      = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${csr_no} !='' )" ).append("\n"); 
		query.append("--CSR NO" ).append("\n"); 
		query.append("AND AI.CSR_NO IN (" ).append("\n"); 
		query.append(" #foreach( ${key} IN ${csrNos}) " ).append("\n"); 
		query.append("   #if($velocityCount < $csrNos.size()) " ).append("\n"); 
		query.append("     '${key}'," ).append("\n"); 
		query.append("   #else " ).append("\n"); 
		query.append("     '${key}'" ).append("\n"); 
		query.append("   #end " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("--INV NO" ).append("\n"); 
		query.append(" AND T1.INV_NO IN (" ).append("\n"); 
		query.append(" #foreach( ${key} IN ${invNos}) " ).append("\n"); 
		query.append("   #if($velocityCount < $invNos.size()) " ).append("\n"); 
		query.append("     '${key}'," ).append("\n"); 
		query.append("   #else " ).append("\n"); 
		query.append("     '${key}'" ).append("\n"); 
		query.append("   #end " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${auditStatus} !='ALL' && ${diffNum} !='')" ).append("\n"); 
		query.append("--audit status" ).append("\n"); 
		query.append("AND EXISTS  (" ).append("\n"); 
		query.append("   SELECT 'Y'" ).append("\n"); 
		query.append("     FROM EAS_PORT_SO_CHG_ACCT S" ).append("\n"); 
		query.append("    WHERE S.LGS_COST_CD = T1.LGS_COST_CD" ).append("\n"); 
		query.append("      AND S.LGS_COST_AUD_FLG      = 'Y'" ).append("\n"); 
		query.append("      AND CASE WHEN NVL(T1.CALC_AMT, 0) = 0 THEN 0" ).append("\n"); 
		query.append("               ELSE S.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("          END" ).append("\n"); 
		query.append("          <=" ).append("\n"); 
		query.append("          CASE WHEN NVL(T1.CALC_AMT, 0) = 0 THEN 0" ).append("\n"); 
		query.append("               ELSE ROUND((LOCL_AMT - T1.CALC_AMT) / T1.CALC_AMT * 100, 3)" ).append("\n"); 
		query.append("          END" ).append("\n"); 
		query.append("      AND ROWNUM = 1" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${office} !='ALL' && ${office} !='') " ).append("\n"); 
		query.append("--OFFICE, as is pso.cost_ofc_cd" ).append("\n"); 
		query.append("AND @[office] IN (T1.INV_OFC_CD, DECODE(PSO.COST_OFC_CD,'PUSMOV', 'SELIB', PSO.COST_OFC_CD)) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${period1} !='' && ${period2} !='' ) " ).append("\n"); 
		query.append("--Period period1 period2 INV_CFM_DT로 변경" ).append("\n"); 
		query.append("AND T1.INV_CFM_DT BETWEEN TO_DATE(@[period1],'YYYY-MM-DD') AND TO_DATE(@[period2],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND LENGTH(T1.LGS_COST_CD) = 6" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--2번째 줄 조회조건:123" ).append("\n"); 
		query.append("#if (${chargeType} == '01' || ${chargeType} == '02' || ${chargeType} == '03')" ).append("\n"); 
		query.append("AND CS.LGS_COST_AUD_FLG = DECODE(@[divChargeType],'1','Y','2','N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CHARGE TYPE : PORT CHARGE, PORT SERVICE CHARGE" ).append("\n"); 
		query.append("#if (${chargeType} == '01' )" ).append("\n"); 
		query.append(" --PORT CHARGE 선택시" ).append("\n"); 
		query.append("   AND C.ACCT_CD NOT IN ('999999', '511795')" ).append("\n"); 
		query.append("   AND C.ACCT_CD LIKE '5117%'" ).append("\n"); 
		query.append("   AND MA.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chargeType} == '02' ) " ).append("\n"); 
		query.append(" --PORT SERVICE CHARGE 선택시" ).append("\n"); 
		query.append("   AND C.ACCT_CD LIKE '5118%'" ).append("\n"); 
		query.append("   AND MA.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chargeType} == '03' ) " ).append("\n"); 
		query.append("--Canal Transit Fee 선택시" ).append("\n"); 
		query.append("   AND C.ACCT_CD LIKE '5119%'" ).append("\n"); 
		query.append("   AND MA.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${chargeType} != '' && ${chargeType} == '04') ) " ).append("\n"); 
		query.append("--Other 선택시" ).append("\n"); 
		query.append("   AND C.ACCT_CD <> '999999' " ).append("\n"); 
		query.append("   AND (C.ACCT_CD IN ('564611', '511795') OR MA.ACCT_ENG_NM LIKE 'OTHER PORT%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chargeType} == '00')" ).append("\n"); 
		query.append("--chargeType 00" ).append("\n"); 
		query.append("  AND C.ACCT_CD NOT IN ('999999', '511795')" ).append("\n"); 
		query.append("  #if (${portlChargeType} == '' && ${serviceChargeType} == '' && ${canalChargeType} == '' && ${otherChargeType} == '')" ).append("\n"); 
		query.append("      AND ((SUBSTR(C.ACCT_CD,0,4) IN ('5117', '5118', '5119') AND CS.LGS_COST_AUD_FLG = DECODE(@[divChargeType],'1','Y','2','N')))" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("      #if (${divChargeType} == '1')" ).append("\n"); 
		query.append("            #if (${otherChargeType} != '564611')" ).append("\n"); 
		query.append("                AND ((SUBSTR(C.ACCT_CD,0,4) IN (@[portlChargeType], @[serviceChargeType], @[canalChargeType]) AND CS.LGS_COST_AUD_FLG = DECODE(@[divChargeType],'1','Y','2','N')))" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                AND ((SUBSTR(C.ACCT_CD,0,4) IN (@[portlChargeType], @[serviceChargeType], @[canalChargeType]) AND CS.LGS_COST_AUD_FLG = DECODE(@[divChargeType],'1','Y','2','N')) OR (C.ACCT_CD IN ('564611', '511795') OR MA.ACCT_ENG_NM LIKE 'OTHER PORT%'))" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            #if (${otherChargeType} == '564611')" ).append("\n"); 
		query.append("                AND ((SUBSTR(C.ACCT_CD,0,4) IN (DECODE(@[portlChargeType],'5117','null','5117'), DECODE(@[serviceChargeType],'5118','null','5118'), DECODE(@[canalChargeType],'5119','null','5119')) AND CS.LGS_COST_AUD_FLG = DECODE(@[divChargeType],'1','Y','2','N')))" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                AND ((SUBSTR(C.ACCT_CD,0,4) IN (DECODE(@[portlChargeType],'5117','null','5117'), DECODE(@[serviceChargeType],'5118','null','5118'), DECODE(@[canalChargeType],'5119','null','5119')) AND CS.LGS_COST_AUD_FLG = DECODE(@[divChargeType],'1','Y','2','N')) OR (C.ACCT_CD IN ('564611', '511795') OR MA.ACCT_ENG_NM LIKE 'OTHER PORT%'))" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${accountCode} !='' ) " ).append("\n"); 
		query.append("--ACCOUNT CODE" ).append("\n"); 
		query.append("AND T1.ACCT_CD = @[accountCode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${costCode} !='' )" ).append("\n"); 
		query.append("--COST CODE" ).append("\n"); 
		query.append("AND T1.LGS_COST_CD = @[costCode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${portCode} !='' ) " ).append("\n"); 
		query.append("--PORT CODE" ).append("\n"); 
		query.append("AND T1.YD_CD LIKE @[portCode]||@[yardCd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${spNo} !='' ) " ).append("\n"); 
		query.append("--SP NO" ).append("\n"); 
		query.append("AND T1.VNDR_SEQ = @[spNo]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${contractType} !='' && ${contractType} !='ALL' && ${period1} !='' && ${period2} !='') " ).append("\n"); 
		query.append("--Contract type " ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT V.VSL_CD FROM MDM_VSL_CNTR V WHERE V.VSL_CD IN (SELECT F.VSL_CD FROM FMS_CONTRACT F WHERE FLET_CTRT_TP_CD IN (@[contractType])))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${vesselClass} !='' && ${vesselClass} !='ALL' ) " ).append("\n"); 
		query.append("--Vessel Class" ).append("\n"); 
		query.append("AND T1.CNTR_VSL_CLSS_CAPA =  @[vesselClass]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${vessel} !='' ) " ).append("\n"); 
		query.append("--Vessel" ).append("\n"); 
		query.append("AND T1.VSL_CD = @[vessel]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${remark} !='' ) " ).append("\n"); 
		query.append("--Diff" ).append("\n"); 
		query.append("AND UPPER(T1.DIFF_RMK) LIKE '%'||UPPER(@[remark])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Audit Status로 조회시	" ).append("\n"); 
		query.append("#if(${expn_aud_sts_cd} == 'N')	" ).append("\n"); 
		query.append("-- Audit Status 'N'" ).append("\n"); 
		query.append("    AND T1.PORT_CHG_AUD_CHK_CD IS NULL	" ).append("\n"); 
		query.append("#elseif(${expn_aud_sts_cd} == 'D') 	" ).append("\n"); 
		query.append("-- Audit Status 'D'" ).append("\n"); 
		query.append("    AND T1.PORT_CHG_AUD_CHK_CD IS NOT NULL	" ).append("\n"); 
		query.append("#elseif(${expn_aud_sts_cd} == 'P' || ${expn_aud_sts_cd} == 'E' || ${expn_aud_sts_cd} == 'A')" ).append("\n"); 
		query.append("-- Audit Status 'P', 'E', 'A'" ).append("\n"); 
		query.append("    AND T1.PORT_CHG_AUD_CHK_CD = @[expn_aud_sts_cd]" ).append("\n"); 
		query.append("#elseif(${expn_aud_sts_cd} == 'I')" ).append("\n"); 
		query.append("-- Audit Status 'I'" ).append("\n"); 
		query.append("    AND T1.EAC_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${if_status} != '')" ).append("\n"); 
		query.append("--CSR Status" ).append("\n"); 
		query.append("AND (CASE WHEN AI.INV_STS_CD = 'D' THEN 'D' -- Paid" ).append("\n"); 
		query.append("          WHEN AH.IF_FLG = 'Y' AND AH.RCV_ERR_FLG IS NULL THEN 'P' -- I/F Success" ).append("\n"); 
		query.append("          WHEN AH.RCV_ERR_FLG = 'E' THEN 'J' -- A/P Rejected" ).append("\n"); 
		query.append("          WHEN AH.IF_FLG = 'E' THEN 'E' -- I/F Error" ).append("\n"); 
		query.append("          WHEN AH.IF_FLG IS NULL AND AH.APRO_FLG = 'Y' AND AH.IF_ERR_RSN = 'Sending...' THEN 'S' -- Sending" ).append("\n"); 
		query.append("          WHEN AI.INV_STS_CD = 'R' OR AI.INV_STS_CD = 'B' OR AH.CSR_RJCT_DT IS NOT NULL THEN 'R' -- Disapproved" ).append("\n"); 
		query.append("          WHEN AH.IF_FLG IS NULL AND NVL(AH.RQST_APRO_STEP_FLG,'N') = 'N' THEN 'A' -- Approval Requested" ).append("\n"); 
		query.append("          WHEN AH.IF_FLG IS NULL AND NVL(AH.RQST_APRO_STEP_FLG,'N') = 'Y' THEN 'L' -- Requesting Approval" ).append("\n"); 
		query.append("          WHEN PSO.PSO_CHG_STS_CD = 'A' THEN 'C'" ).append("\n"); 
		query.append("     END) = @[if_status]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NVL(AH.RCV_ERR_FLG, 'X') <> 'E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${auditStatus}!= '')" ).append("\n"); 
		query.append("-- Auto Audit Status로 조회시 " ).append("\n"); 
		query.append("    AND T1.AUTO_EXPN_AUD_STS_CD = @[auditStatus]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sExpnAudStsCd}!= '')" ).append("\n"); 
		query.append("	#if (${sExpnAudStsCd} == 'N')" ).append("\n"); 
		query.append("-- sExpnAudStsCd 'N'" ).append("\n"); 
		query.append("    	AND T1.PORT_CHG_AUD_CHK_CD IS NULL" ).append("\n"); 
		query.append("	#elseif (${sExpnAudStsCd} == 'D')" ).append("\n"); 
		query.append("-- sExpnAudStsCd 'D'" ).append("\n"); 
		query.append("		AND T1.PORT_CHG_AUD_CHK_CD IS NOT NULL" ).append("\n"); 
		query.append("-- sExpnAudStsCd 'N', 'D' 아닌경우" ).append("\n"); 
		query.append("	#elseif (${sExpnAudStsCd} != 'N' && ${sExpnAudStsCd} != 'D')" ).append("\n"); 
		query.append("		AND T1.PORT_CHG_AUD_CHK_CD = @[sExpnAudStsCd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY T1.ISS_CTY_CD" ).append("\n"); 
		query.append("     , T1.SO_SEQ" ).append("\n"); 
		query.append("     , T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD" ).append("\n"); 
		query.append("     , T1.LGS_COST_CD , C.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("     , T1.AUD_CURR_CD" ).append("\n"); 
		query.append("     , T1.AUD_DIFF_AMT" ).append("\n"); 
		query.append("     , T1.AUD_USD_DIFF_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") WHERE 1=1" ).append("\n"); 
		query.append("#if ((${diff} =='01' || ${diff} =='02' || ${diff} =='03') && (${diffNum} !=''))" ).append("\n"); 
		query.append("-- DIFF" ).append("\n"); 
		query.append("    AND DIFF" ).append("\n"); 
		query.append("          #if ( ${diff} =='01') " ).append("\n"); 
		query.append("            <= TO_NUMBER(@[diffNum])" ).append("\n"); 
		query.append("          #elseif ( ${diff} =='02') " ).append("\n"); 
		query.append("            = TO_NUMBER(@[diffNum])" ).append("\n"); 
		query.append("          #elseif ( ${diff} =='03') " ).append("\n"); 
		query.append("            >= TO_NUMBER(@[diffNum])" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
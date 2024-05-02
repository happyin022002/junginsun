/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOsearchSumRptByPeriodInvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOsearchSumRptByPeriodInvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Invoice Summary 
	  * [2015.04.23] 000002, PSO > '000001', 'COM'
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * [2015.09.09]IN 일대 VOY_NO, DIR_CD 를 다시 돌려서 조회하는 로직 추가.
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOsearchSumRptByPeriodInvRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("combo1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_port_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOsearchSumRptByPeriodInvRSQL").append("\n"); 
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
		query.append("WITH V_STATUS AS (" ).append("\n"); 
		query.append("    SELECT STATUS_CD" ).append("\n"); 
		query.append("         , STATUS_NM" ).append("\n"); 
		query.append("         , STATUS_SEQ" ).append("\n"); 
		query.append("      FROM (SELECT INTG_CD_VAL_CTNT AS STATUS_CD" ).append("\n"); 
		query.append("                 , INTG_CD_VAL_DP_DESC AS STATUS_NM" ).append("\n"); 
		query.append("                 , INTG_CD_VAL_DP_SEQ AS STATUS_SEQ" ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE INTG_CD_ID='CD02355'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     ORDER BY STATUS_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_STATUS;" ).append("\n"); 
		query.append("SELECT M.*" ).append("\n"); 
		query.append("  FROM (SELECT M.VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("             , M.INV_OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("             , M.ISS_CTY_CD" ).append("\n"); 
		query.append("             , M.SO_SEQ" ).append("\n"); 
		query.append("             , SUBSTR(M.YD_CD, 1, 5) AS PORT_CD" ).append("\n"); 
		query.append("             , M.YD_CD" ).append("\n"); 
		query.append("             , NVL(M.VSL_SLAN_CD, ( SELECT SLAN_CD" ).append("\n"); 
		query.append("                                      FROM AR_MST_REV_VVD V" ).append("\n"); 
		query.append("                                     WHERE V.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("                                       AND V.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       AND V.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       AND ROWNUM = 1 )) AS VSL_SLAN_CD" ).append("\n"); 
		query.append("             , M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("             , C.ACCT_CD" ).append("\n"); 
		query.append("             , C.ACCT_ENG_NM" ).append("\n"); 
		query.append("             , M.LGS_COST_CD AS COST_CD" ).append("\n"); 
		query.append("             , C.LGS_COST_FULL_NM AS COST_NM" ).append("\n"); 
		query.append("             , M.VNDR_SEQ" ).append("\n"); 
		query.append("             , (SELECT V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR V" ).append("\n"); 
		query.append("                 WHERE V.VNDR_SEQ = M.VNDR_SEQ" ).append("\n"); 
		query.append("                   AND NVL(V.DELT_FLG,'N') = 'N' ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("             , M.CURR_CD" ).append("\n"); 
		query.append("             , LOCL_AMT AS LOCL_AMT" ).append("\n"); 
		query.append("             , USD_AMT AS USD_AMT" ).append("\n"); 
		query.append("             --, LISTAGG (M.DIFF_RMK, ',') WITHIN GROUP (ORDER BY M.DIFF_RMK) AS DIFF_RMK" ).append("\n"); 
		query.append("             , M.DIFF_RMK" ).append("\n"); 
		query.append("             , MC.CNTR_VSL_CLSS_CAPA AS VSL_CLSS" ).append("\n"); 
		query.append("             , M.INV_NO" ).append("\n"); 
		query.append("             --, M.STATUS" ).append("\n"); 
		query.append("             , (SELECT STATUS_NM" ).append("\n"); 
		query.append("                  FROM V_STATUS V" ).append("\n"); 
		query.append("                 WHERE V.STATUS_CD = M.STATUS" ).append("\n"); 
		query.append("               ) AS STATUS" ).append("\n"); 
		query.append("             , M.CSR_NO" ).append("\n"); 
		query.append("             , M.IO" ).append("\n"); 
		query.append("             , M.CALC_AMT" ).append("\n"); 
		query.append("             , M.ADJ_AMT" ).append("\n"); 
		query.append("             , M.XPR_DESC" ).append("\n"); 
		query.append("             , M.FOML_DESC" ).append("\n"); 
		query.append("             , M.RLANE_CD" ).append("\n"); 
		query.append("             , M.REV_VVD" ).append("\n"); 
		query.append("             , M.CRE_USR_ID" ).append("\n"); 
		query.append("             , TO_CHAR(M.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("             , M.UPD_USR_ID" ).append("\n"); 
		query.append("             , TO_CHAR(M.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("             , CASE WHEN M.IO = 'IN' AND M.LOCL_AMT = 0 AND M.USD_AMT = 0 THEN 'N'" ).append("\n"); 
		query.append("                    ELSE 'Y'" ).append("\n"); 
		query.append("               END CHK_DATA" ).append("\n"); 
		query.append("             , M.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , M.ACT_DT" ).append("\n"); 
		query.append("             , TO_CHAR(M.PAY_DUE_DT,'YYYY-MM-DD') AS PAY_DUE_DT" ).append("\n"); 
		query.append("             , TO_CHAR(TO_DATE(M.PAY_DT,'YYYY-MM-DD'),'YYYY-MM-DD') AS PAY_DT" ).append("\n"); 
		query.append("          FROM (SELECT M.ISS_CTY_CD" ).append("\n"); 
		query.append("                     , M.SO_SEQ" ).append("\n"); 
		query.append("                     , M.VNDR_SEQ" ).append("\n"); 
		query.append("                     , M.YD_CD" ).append("\n"); 
		query.append("                     , M.CURR_CD" ).append("\n"); 
		query.append("                     , D.VSL_CD" ).append("\n"); 
		query.append("                     , DECODE(D.VT_VVD_FLG,'Y',SUBSTR(D.TURN_VVD_CD,5,4), D.SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     , DECODE(D.VT_VVD_FLG,'Y',SUBSTR(D.TURN_VVD_CD,9,1), D.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     #if ( ${date_type} == 'VVD')" ).append("\n"); 
		query.append("                     , S.SLAN_CD AS VSL_SLAN_CD" ).append("\n"); 
		query.append("                     #else" ).append("\n"); 
		query.append("                     , (SELECT S.VSL_SLAN_CD" ).append("\n"); 
		query.append("                          FROM VSK_VSL_SKD S" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND S.VSl_CD                 = D.VSL_CD" ).append("\n"); 
		query.append("                           AND S.SKD_VOY_NO             = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND S.SKD_DIR_CD             = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                        ) AS VSL_SLAN_CD" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     , D.LGS_COST_CD" ).append("\n"); 
		query.append("                     , D.ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append("                     , NVL(SUM(LOCL_AMT)    OVER(PARTITION BY D.ISS_CTY_CD, D.SO_SEQ, D.SO_DTL_SEQ), M.INV_LOCL_AMT ) AS LOCL_AMT --TL USD Amount" ).append("\n"); 
		query.append("                     , NVL(SUM(USD_AMT)     OVER(PARTITION BY D.ISS_CTY_CD, D.SO_SEQ, D.SO_DTL_SEQ), M.TTL_USD_AMT  ) AS USD_AMT" ).append("\n"); 
		query.append("                     , DIFF_RMK" ).append("\n"); 
		query.append("                     , (CASE WHEN D.ORG_SO_DTL_SEQ = D.SO_DTL_SEQ THEN 1" ).append("\n"); 
		query.append("                             WHEN D.SO_DTL_SEQ IS NULL THEN 1" ).append("\n"); 
		query.append("                             ELSE 0" ).append("\n"); 
		query.append("                        END) AS RNK" ).append("\n"); 
		query.append("                     , NVL(LOC.VOP_PORT_CTRL_OFC_CD, LOC.SLS_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("                     , (SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND OFC_KND_CD = '2'" ).append("\n"); 
		query.append("                           AND PRNT_OFC_CD = (  SELECT OFC_CD" ).append("\n"); 
		query.append("                                                  FROM TABLE ( COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001', 'COM'))" ).append("\n"); 
		query.append("                                                 WHERE ROWNUM = 1)" ).append("\n"); 
		query.append("                         START WITH OFC_CD = LOC.SLS_OFC_CD" ).append("\n"); 
		query.append("                       CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD" ).append("\n"); 
		query.append("                       ) AS VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("                     , M.INV_NO" ).append("\n"); 
		query.append("                     , DECODE(AP.CSR_NO, NULL, DECODE( M.PSO_CHG_STS_CD, 'A', 'C', 'S'), AP.INV_STS_CD) AS STATUS" ).append("\n"); 
		query.append("                     , AP.CSR_NO" ).append("\n"); 
		query.append("                     , NVL(D.CRE_USR_ID , M.CRE_USR_ID  ) AS CRE_USR_ID" ).append("\n"); 
		query.append("                     , NVL(D.CRE_DT     , M.CRE_DT      ) AS CRE_DT" ).append("\n"); 
		query.append("                     , NVL(D.UPD_USR_ID , M.UPD_USR_ID  ) AS UPD_USR_ID" ).append("\n"); 
		query.append("                     , NVL(D.UPD_DT     , M.UPD_DT      ) AS UPD_DT" ).append("\n"); 
		query.append("                     , DECODE(D.IO_BND_CD, 'I', 'IN', 'O', 'OUT', '') AS IO" ).append("\n"); 
		query.append("                     , NVL(SUM(D.CALC_AMT)  OVER(PARTITION BY D.ISS_CTY_CD, D.SO_SEQ, D.SO_DTL_SEQ), 0) AS CALC_AMT --Tariff Cost" ).append("\n"); 
		query.append("                     , NVL(SUM(D.ADJ_AMT)   OVER(PARTITION BY D.ISS_CTY_CD, D.SO_SEQ, D.SO_DTL_SEQ), 0) AS ADJ_AMT --Adjustment Amount" ).append("\n"); 
		query.append("                     , D.XPR_DESC" ).append("\n"); 
		query.append("                     , D.FOML_DESC" ).append("\n"); 
		query.append("                     , D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD||D.REV_DIR_CD AS REV_VVD" ).append("\n"); 
		query.append("                     --, NVL(GEV.CORR_VSL_CD, D.VSL_CD) || NVL(GEV.CORR_SKD_VOY_NO, D.SKD_VOY_NO)||NVL(GEV.CORR_SKD_DIR_CD, D.SKD_DIR_CD)||NVL(GEV.CORR_REV_DIR_CD, D.REV_DIR_CD) AS REV_VVD" ).append("\n"); 
		query.append("                     , D.RLANE_CD" ).append("\n"); 
		query.append("                     , D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , (SELECT TO_CHAR(VPS.VPS_ETD_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND VPS.VSL_CD       = D.VSL_CD" ).append("\n"); 
		query.append("                           AND VPS.SKD_VOY_NO   = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND VPS.SKD_DIR_CD   = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND VPS.YD_CD        = M.YD_CD" ).append("\n"); 
		query.append("                           AND VPS.CLPT_IND_SEQ = D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                       ) AS ACT_DT /*2016.05.10 ETD Add*/" ).append("\n"); 
		query.append("                     , AP.PAY_DUE_DT" ).append("\n"); 
		query.append("                     , (SELECT AIH.PAY_DT" ).append("\n"); 
		query.append("                          FROM AP_INV_HDR AIH" ).append("\n"); 
		query.append("                         WHERE AIH.CSR_NO = AP.CSR_NO" ).append("\n"); 
		query.append("                       ) AS PAY_DT" ).append("\n"); 
		query.append("                  FROM PSO_CHARGE M" ).append("\n"); 
		query.append("                     , PSO_CHG_DTL D" ).append("\n"); 
		query.append("                 #if ( ${date_type} == 'VVD')" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                     , MDM_LOCATION LOC" ).append("\n"); 
		query.append("                     , AP_PAY_INV AP" ).append("\n"); 
		query.append("                     --, GL_ERR_VVD GEV" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                #if ( ${date_type} == 'CR' || ${date_type} == 'IS')" ).append("\n"); 
		query.append("                   AND M.ISS_CTY_CD             = D.ISS_CTY_CD(+)" ).append("\n"); 
		query.append("                   AND M.SO_SEQ                 = D.SO_SEQ(+)" ).append("\n"); 
		query.append("                   AND SUBSTR(M.YD_CD, 1, 5)    = LOC.LOC_CD(+)" ).append("\n"); 
		query.append("                #elseif ( ${date_type} == 'VVD')" ).append("\n"); 
		query.append("                   AND M.ISS_CTY_CD             = D.ISS_CTY_CD" ).append("\n"); 
		query.append("                   AND M.SO_SEQ                 = D.SO_SEQ" ).append("\n"); 
		query.append("                   AND D.VSl_CD                 = S.VSL_CD" ).append("\n"); 
		query.append("                   AND D.SKD_VOY_NO             = S.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND D.SKD_DIR_CD             = S.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND M.YD_CD                  = S.YD_CD" ).append("\n"); 
		query.append("                   AND D.CLPT_IND_SEQ           = S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   AND SUBSTR(M.YD_CD, 1, 5)    = LOC.LOC_CD" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                   AND AP.INV_SUB_SYS_CD(+)     = 'PSO'" ).append("\n"); 
		query.append("                   AND M.INV_RGST_NO            = AP.INV_RGST_NO(+)" ).append("\n"); 
		query.append("                   AND M.INV_OFC_CD             = AP.INV_OFC_CD(+)" ).append("\n"); 
		query.append("                #if ( ${date_type} == 'CR')" ).append("\n"); 
		query.append("                   AND NVL(D.CRE_DT, M.CRE_DT)  BETWEEN TO_DATE(@[from_date], 'YYYY-MM-DD') AND TO_DATE(@[to_date], 'YYYY-MM-DD') + .99999 /* 조건 : invoice creation = CR */" ).append("\n"); 
		query.append("                #elseif ( ${date_type} == 'IS')" ).append("\n"); 
		query.append("                   AND M.ISS_DT                 BETWEEN TO_DATE(@[from_date], 'YYYY-MM-DD') AND TO_DATE(@[to_date], 'YYYY-MM-DD') + .99999 /* 조건 : issue date = IS  */" ).append("\n"); 
		query.append("                #elseif ( ${date_type} == 'VVD')" ).append("\n"); 
		query.append("                   AND S.VPS_ETD_DT             BETWEEN TO_DATE(@[from_date], 'YYYY-MM-DD') AND TO_DATE(@[to_date], 'YYYY-MM-DD') + .99999 /* 조건 : etd date = VVD  */" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                /* 조건 : Vendor가 있는 경우 */" ).append("\n"); 
		query.append("                #if(${vndr_seq} != '')" ).append("\n"); 
		query.append("                   AND M.VNDR_SEQ               = @[vndr_seq] --'183842'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                /* 조건 : PORT가 있는 경우*/" ).append("\n"); 
		query.append("                #if( ${port_cd}!='' && ${term_code} =='')" ).append("\n"); 
		query.append("                   AND M.YD_CD                  LIKE @[port_cd] ||'%'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                /* 조건 : term */" ).append("\n"); 
		query.append("                #if( ${port_cd}!='' && ${term_code}!='')" ).append("\n"); 
		query.append("                   AND M.YD_CD                  IN ( '${term_code}' )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                   --AND GEV.ERR_VSL_CD       (+) = D.VSL_CD" ).append("\n"); 
		query.append("                   --AND GEV.ERR_SKD_VOY_NO   (+) = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                   --AND GEV.ERR_SKD_DIR_CD   (+) = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                   --AND GEV.ERR_REV_DIR_CD   (+) = D.REV_DIR_CD" ).append("\n"); 
		query.append("                   --AND GEV.AVAL_FLG         (+) = 'Y'" ).append("\n"); 
		query.append("               ) M" ).append("\n"); 
		query.append("             , (SELECT MA.ACCT_CD" ).append("\n"); 
		query.append("                     , MA.ACCT_ENG_NM" ).append("\n"); 
		query.append("                     , TES.LGS_COST_CD" ).append("\n"); 
		query.append("                     , TES.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                  FROM TES_LGS_COST TES" ).append("\n"); 
		query.append("                     , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND TES.LGS_COST_SUBJ_CD     IN ('PT','CN')" ).append("\n"); 
		query.append("                   AND TES.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("                   AND TES.ACCT_CD              = MA.ACCT_CD" ).append("\n"); 
		query.append("                   AND NVL(MA.DELT_FLG,'N')     = 'N'" ).append("\n"); 
		query.append("                 ORDER BY TES.LGS_COST_OPT_NO" ).append("\n"); 
		query.append("               ) C" ).append("\n"); 
		query.append("             , (SELECT MAX(MC.CNTR_VSL_CLSS_CAPA) CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                     , MC.VSL_CD" ).append("\n"); 
		query.append("                  FROM MDM_VSL_CNTR MC" ).append("\n"); 
		query.append("                 GROUP BY MC.VSL_CD" ).append("\n"); 
		query.append("               ) MC" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("            --AND RNK = 1" ).append("\n"); 
		query.append("           AND M.LGS_COST_CD        = C.LGS_COST_CD(+)" ).append("\n"); 
		query.append("           AND M.VSL_CD             = MC.VSL_CD(+)" ).append("\n"); 
		query.append("        /*조건 : CTRL H/Q */" ).append("\n"); 
		query.append("        #if(${vskd_port_rhq_cd} != '' && ${vskd_port_rhq_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND M.VSKD_PORT_RHQ_CD   = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        /*조건 : Office */" ).append("\n"); 
		query.append("        #if(${sls_ofc_cd} != '' && ${sls_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND M.INV_OFC_CD         = @[sls_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        /*조건 : VVD : vsl_cd */" ).append("\n"); 
		query.append("        #if( ${vsl_cd}!='')" ).append("\n"); 
		query.append("           AND M.VSL_CD             = @[vsl_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        /*조건 : VVD : skd_voy_no */" ).append("\n"); 
		query.append("        #if( ${skd_voy_no}!='')" ).append("\n"); 
		query.append("           AND M.SKD_VOY_NO         = @[skd_voy_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        /*조건 : VVD : skd_dir_cd */" ).append("\n"); 
		query.append("        #if( ${skd_dir_cd}!='')" ).append("\n"); 
		query.append("           AND M.SKD_DIR_CD         = @[skd_dir_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        /*조건 : Lane Code */" ).append("\n"); 
		query.append("        #if ( ${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("           AND M.VSL_SLAN_CD        = @[vsl_slan_cd] -- NE4" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        /*조건 : Account, Cost Code */" ).append("\n"); 
		query.append("        #if( ${combo1}!= 'ALL' && ${combo1}!= '' )" ).append("\n"); 
		query.append("           AND C.ACCT_CD            LIKE DECODE(@[combo1], '110911', '511911', @[combo1]) || '%' --ACCOUNT가 110911이면 511911로 바꿈" ).append("\n"); 
		query.append("           AND C.LGS_COST_CD        LIKE DECODE(@[combo1], '110911', '____', '______') --ACCOUNT가 110911이면 COST_CD가 네자리인것만 조회" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        /* 조건 : VESSEL CLASS */" ).append("\n"); 
		query.append("        #if ( ${cntr_vsl_clss_capa} != 'ALL' && ${cntr_vsl_clss_capa} != '')" ).append("\n"); 
		query.append("           AND MC.CNTR_VSL_CLSS_CAPA = @[cntr_vsl_clss_capa] --9000" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        /* 조건 : Status */" ).append("\n"); 
		query.append("        #if ( ${status} != 'ALL' && ${status} != '')" ).append("\n"); 
		query.append("           AND M.STATUS             = @[status] --Status" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("       ) M" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND M.CHK_DATA = 'Y' /*펜들럼일때 M.IO = IN , M.LOCL_AMT = 0 , M.USD_AMT = 0 대상 제외. */" ).append("\n"); 
		query.append(" ORDER BY M.SLS_OFC_CD" ).append("\n"); 
		query.append("     , M.CRE_DT" ).append("\n"); 
		query.append("     , M.INV_NO" ).append("\n"); 
		query.append("     , M.COST_CD" ).append("\n"); 

	}
}
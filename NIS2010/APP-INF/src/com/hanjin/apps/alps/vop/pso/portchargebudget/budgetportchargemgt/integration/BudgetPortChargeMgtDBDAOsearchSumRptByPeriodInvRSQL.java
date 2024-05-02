/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOsearchSumRptByPeriodInvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * Invoice summary 조회
	  * ========================================================
	  * 2010.09.15 진마리아 CHM-201005696-01 지점및 지역 본부에서 Port charge inovice summary 수정
	  * 2010.11.24 이석준 CHM-201007342-01 Cost Code가 6자리인 것만 나오도록 조회 로직 변경
	  * 2011.01.12 이석준 CHM-201108296-01 Port Charge Invoice Summary 조회 로직 변경
	  * 2011.03.04 진마리아 CHM-201108565-01 Port Charge Invoice Summary 조회 로직 변경
	  * 2011.03.15 진마리아 CHM-201109192-01 Port Charge Invoice Summary 로직 변경
	  * 2011.10.07 진마리아 CHM-201113739-01 Invocie Created Date, Issue Date로 조회시 ALPS내 스케줄 Check없이 invocie내 data로 조회 가능하도록 로직 수정
	  * 2011.12.19 진마리아 CHM-201114861-01 yard 다중 선택 시 조회 가능하도록 로직 수정
	  * 2014.07.22 이성훈 CHM-201430727 [PSO] Tariff 및 Adjustment Cost 칼럼 추가
	  * 2015.01.02 김기원 CHM-201433349 Port Charge Invoice Summary report 화면 기능 변경
	  * 2015.08.17 김기원 CHM-201537022  조직코드 변경
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
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
		query.append("select  M.VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("       ,M.INV_OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("       ,M.ISS_CTY_CD" ).append("\n"); 
		query.append("       ,M.SO_SEQ" ).append("\n"); 
		query.append("       ,substr(M.YD_CD, 1, 5) AS PORT_CD" ).append("\n"); 
		query.append("       ,M.YD_CD" ).append("\n"); 
		query.append("       ,M.VSL_SLAN_CD" ).append("\n"); 
		query.append("       ,M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("       ,C.ACCT_CD ACCT_CD" ).append("\n"); 
		query.append("       ,MA.ACCT_ENG_NM" ).append("\n"); 
		query.append("       ,M.LGS_COST_CD COST_CD" ).append("\n"); 
		query.append("       ,C.LGS_COST_FULL_NM COST_NM" ).append("\n"); 
		query.append("       ,M.VNDR_SEQ" ).append("\n"); 
		query.append("       ,V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("       ,M.CURR_CD " ).append("\n"); 
		query.append("#if ( ${date_type} == 'CR') " ).append("\n"); 
		query.append("       ,TO_CHAR(M.CRE_DT,'YYYY-MM-DD HH24:MI')  AS CON_DT       " ).append("\n"); 
		query.append("        -- VVD ETD 조회 조건" ).append("\n"); 
		query.append("#elseif ( ${date_type} == 'VVD')" ).append("\n"); 
		query.append("       ,TO_CHAR(M.VPS_ETD_DT,'YYYY-MM-DD HH24:MI')  AS CON_DT    " ).append("\n"); 
		query.append("#elseif ( ${date_type} == 'IS')        " ).append("\n"); 
		query.append("        -- issue date 조건" ).append("\n"); 
		query.append("       ,TO_CHAR(M.ISS_DT,'YYYY-MM-DD HH24:MI')  AS CON_DT    " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("       ,sum(LOCL_AMT)    LOCL_AMT" ).append("\n"); 
		query.append("       ,sum(USD_AMT)     USD_AMT" ).append("\n"); 
		query.append("       ,sum(TARIFF_COST) TARIFF_COST" ).append("\n"); 
		query.append("       ,sum(ADJUST_COST) ADJUST_COST" ).append("\n"); 
		query.append("#if (${diff_rmk} == 'Y')" ).append("\n"); 
		query.append("       ,MAX(M.DIFF_RMK) DIFF_RMK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       ,decode(" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                  select  sign(count(*)-1)" ).append("\n"); 
		query.append("                    from  PSO_CHG_DTL T1" ).append("\n"); 
		query.append("                   where  T1.ISS_CTY_CD = M.ISS_CTY_CD" ).append("\n"); 
		query.append("                     and  T1.SO_SEQ = M.SO_SEQ" ).append("\n"); 
		query.append("                     and  T1.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("                     and  T1.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("                     and  T1.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("                     and  T1.LGS_COST_CD = M.LGS_COST_CD" ).append("\n"); 
		query.append("                     and  T1.DIFF_RMK IS NOT NULL" ).append("\n"); 
		query.append("                ), 1, '(*)' || max(DIFF_RMK) || ', AND OTHER THINGS.', max(DIFF_RMK)" ).append("\n"); 
		query.append("              ) DIFF_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,max(MC.CNTR_VSL_CLSS_CAPA) AS VSL_CLSS" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("          select  TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("            from  VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("           where  VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("             and  SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("             and  SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("             and  VPS_PORT_CD = SUBSTR(M.YD_CD, 1, 5)" ).append("\n"); 
		query.append("             and  CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("        ) BERTH_DATE" ).append("\n"); 
		query.append("       , max(M.INV_NO) INV_NO" ).append("\n"); 
		query.append("       , max(M.CSR_NO) CSR_NO" ).append("\n"); 
		query.append("       , max(M.STATUS) STATUS" ).append("\n"); 
		query.append("	     , max(M.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("          select  M.ISS_CTY_CD" ).append("\n"); 
		query.append("                 ,M.SO_SEQ" ).append("\n"); 
		query.append("                 ,M.VNDR_SEQ" ).append("\n"); 
		query.append("                 ,M.YD_CD" ).append("\n"); 
		query.append("                 ,M.CURR_CD" ).append("\n"); 
		query.append("                 ,D.VSL_CD" ).append("\n"); 
		query.append("                 ,D.SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,D.SKD_DIR_CD" ).append("\n"); 
		query.append("#if ( ${date_type} == 'CR') " ).append("\n"); 
		query.append("                 ,M.CRE_DT       " ).append("\n"); 
		query.append("        -- VVD ETD 조회 조건" ).append("\n"); 
		query.append("#elseif ( ${date_type} == 'VVD')" ).append("\n"); 
		query.append("                 ,S.VPS_ETD_DT" ).append("\n"); 
		query.append("#elseif ( ${date_type} == 'IS')        " ).append("\n"); 
		query.append("        -- issue date 조건" ).append("\n"); 
		query.append("                 ,M.ISS_DT" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${date_type} == 'VVD') " ).append("\n"); 
		query.append("                 ,S.SLAN_CD VSL_SLAN_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                 ,(" ).append("\n"); 
		query.append("                    select  VSL_SLAN_CD" ).append("\n"); 
		query.append("                      from  MDM_REV_LANE" ).append("\n"); 
		query.append("                     where  RLANE_CD = D.RLANE_CD" ).append("\n"); 
		query.append("                  ) VSL_SLAN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 ,D.LGS_COST_CD" ).append("\n"); 
		query.append("                 ,D.ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append("                 ,( SELECT SUM(LOCL_AMT) FROM PSO_CHG_DTL " ).append("\n"); 
		query.append("                     WHERE ISS_CTY_CD     = M.ISS_CTY_CD   " ).append("\n"); 
		query.append("                       AND SO_SEQ         = M.SO_SEQ " ).append("\n"); 
		query.append("                       AND ORG_SO_DTL_SEQ = D.ORG_SO_DTL_SEQ " ).append("\n"); 
		query.append("                       AND LGS_COST_CD    = D.LGS_COST_CD ) AS LOCL_AMT" ).append("\n"); 
		query.append("                 , ( SELECT SUM(USD_AMT) FROM PSO_CHG_DTL " ).append("\n"); 
		query.append("                      WHERE ISS_CTY_CD     = M.ISS_CTY_CD " ).append("\n"); 
		query.append("                        AND SO_SEQ         = M.SO_SEQ " ).append("\n"); 
		query.append("                        AND ORG_SO_DTL_SEQ = D.ORG_SO_DTL_SEQ " ).append("\n"); 
		query.append("                        AND LGS_COST_CD    = D.LGS_COST_CD ) AS USD_AMT" ).append("\n"); 
		query.append("                 , ( SELECT SUM(CALC_AMT) FROM PSO_CHG_DTL " ).append("\n"); 
		query.append("                      WHERE ISS_CTY_CD     = M.ISS_CTY_CD " ).append("\n"); 
		query.append("                        AND SO_SEQ         = M.SO_SEQ " ).append("\n"); 
		query.append("                        AND ORG_SO_DTL_SEQ = D.ORG_SO_DTL_SEQ " ).append("\n"); 
		query.append("                        AND LGS_COST_CD    = D.LGS_COST_CD ) AS TARIFF_COST" ).append("\n"); 
		query.append("                 , NVL(( SELECT SUM(DECODE(CALC_AMT, 0, DECODE(ADJ_AMT, 0, LOCL_AMT, ADJ_AMT), ADJ_AMT)) " ).append("\n"); 
		query.append("                           FROM PSO_CHG_DTL " ).append("\n"); 
		query.append("                          WHERE ISS_CTY_CD     = M.ISS_CTY_CD " ).append("\n"); 
		query.append("                            AND SO_SEQ         = M.SO_SEQ " ).append("\n"); 
		query.append("                            AND ORG_SO_DTL_SEQ = D.ORG_SO_DTL_SEQ " ).append("\n"); 
		query.append("                            AND LGS_COST_CD    = D.LGS_COST_CD ),0) AS ADJUST_COST" ).append("\n"); 
		query.append("                -- ,nvl(sum(LOCL_AMT) over(partition by D.ISS_CTY_CD, D.SO_SEQ, D.ORG_SO_DTL_SEQ), 0) LOCL_AMT" ).append("\n"); 
		query.append("                -- ,nvl(sum(USD_AMT)  over(partition by D.ISS_CTY_CD, D.SO_SEQ, D.ORG_SO_DTL_SEQ), 0) USD_AMT" ).append("\n"); 
		query.append("                -- ,nvl(sum(CALC_AMT) over(partition by D.ISS_CTY_CD, D.SO_SEQ, D.ORG_SO_DTL_SEQ), 0) TARIFF_COST" ).append("\n"); 
		query.append("                -- ,nvl(sum(decode(CALC_AMT, null, decode(ADJ_AMT, null, LOCL_AMT, ADJ_AMT), ADJ_AMT)) over(partition by D.ISS_CTY_CD, D.SO_SEQ, D.ORG_SO_DTL_SEQ), 0) ADJUST_COST" ).append("\n"); 
		query.append("                 ,DIFF_RMK" ).append("\n"); 
		query.append("                 ,(case when ORG_SO_DTL_SEQ = SO_DTL_SEQ then 1 else 0 end) RNK" ).append("\n"); 
		query.append("                 ,M.INV_OFC_CD" ).append("\n"); 
		query.append("                 ,(" ).append("\n"); 
		query.append("                    select  distinct OFC_CD" ).append("\n"); 
		query.append("                      from  MDM_ORGANIZATION" ).append("\n"); 
		query.append("                     where  1 = 1" ).append("\n"); 
		query.append("                       and  OFC_KND_CD = '2'" ).append("\n"); 
		query.append("                       and  PRNT_OFC_CD = 'SELDC'" ).append("\n"); 
		query.append("                    start with OFC_CD = LOC.SLS_OFC_CD" ).append("\n"); 
		query.append("                    connect by prior PRNT_OFC_CD = OFC_CD" ).append("\n"); 
		query.append("                  ) VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("                 ,M.INV_NO" ).append("\n"); 
		query.append("                 ,AP.CSR_NO" ).append("\n"); 
		query.append("                 ,decode(AP.CSR_NO, NULL, decode(M.PSO_CHG_STS_CD, 'A', 'Confirmed', 'Received')," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                            select  INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("                              from  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                             where  INTG_CD_ID = 'CD02355' " ).append("\n"); 
		query.append("                               and  INTG_CD_VAL_CTNT = AP.INV_STS_CD" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                  ) STATUS" ).append("\n"); 
		query.append("                 ,M.CRE_USR_ID" ).append("\n"); 
		query.append("            from  PSO_CHARGE M" ).append("\n"); 
		query.append("                 ,PSO_CHG_DTL D" ).append("\n"); 
		query.append("#if (${date_type} == 'VVD') " ).append("\n"); 
		query.append("                 ,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("                 ,AP_PAY_INV AP" ).append("\n"); 
		query.append("           where  M.ISS_CTY_CD = D.ISS_CTY_CD" ).append("\n"); 
		query.append("             and  M.SO_SEQ = D.SO_SEQ" ).append("\n"); 
		query.append("             and  LOC.LOC_CD = substr(M.YD_CD, 1, 5)" ).append("\n"); 
		query.append("#if (${date_type} == 'VVD') " ).append("\n"); 
		query.append("             and  D.VSl_CD = S.VSL_CD" ).append("\n"); 
		query.append("             and  D.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("             and  D.SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("             and  M.YD_CD = S.YD_CD" ).append("\n"); 
		query.append("             and  S.CLPT_SEQ = (" ).append("\n"); 
		query.append("                                  select  min(CLPT_SEQ) " ).append("\n"); 
		query.append("                                    from  VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                   where  VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("                                     and  SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     and  SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     and  YD_CD = S.YD_CD" ).append("\n"); 
		query.append("                                     and  nvl(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             and  M.INV_RGST_NO = AP.INV_RGST_NO(+)" ).append("\n"); 
		query.append("             and  AP.INV_SUB_SYS_CD(+) = 'PSO'" ).append("\n"); 
		query.append("             and  M.INV_OFC_CD = AP.INV_OFC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        -- invoice creation 조회조건" ).append("\n"); 
		query.append("        #if ( ${date_type} == 'CR')        " ).append("\n"); 
		query.append("             and  M.CRE_DT between TO_DATE(@[from_date], 'YYYY-MM-DD') and TO_DATE(@[to_date], 'YYYY-MM-DD') + .99999" ).append("\n"); 
		query.append("        -- VVD ETD 조회 조건" ).append("\n"); 
		query.append("        #elseif ( ${date_type} == 'VVD')" ).append("\n"); 
		query.append("             and  S.VPS_ETD_DT between TO_DATE(@[from_date], 'YYYY-MM-DD') and TO_DATE(@[to_date], 'YYYY-MM-DD') + .99999" ).append("\n"); 
		query.append("        #elseif ( ${date_type} == 'IS')        " ).append("\n"); 
		query.append("        -- issue date 조건" ).append("\n"); 
		query.append("             and  M.ISS_DT between TO_DATE(@[from_date], 'YYYY-MM-DD') and TO_DATE(@[to_date], 'YYYY-MM-DD') + .99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        -- Vendor가 있는 경우" ).append("\n"); 
		query.append("        #if(${vndr_seq} != '')" ).append("\n"); 
		query.append("             and  M.VNDR_SEQ = @[vndr_seq]   --'183842'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        -- PORT가 있는 경우" ).append("\n"); 
		query.append("        #if( ${port_cd}!='' && ${term_code} =='')" ).append("\n"); 
		query.append("             and  M.YD_CD like @[port_cd] ||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if( ${port_cd}!='' && ${term_code}!='')" ).append("\n"); 
		query.append("             and  M.YD_CD in( ${term_code} )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        -- Country code가  있는 경우" ).append("\n"); 
		query.append("        #if( ${cnt_cd}!='')" ).append("\n"); 
		query.append("             and  M.YD_CD like @[cnt_cd] ||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        -- Created ID가 있는 경우" ).append("\n"); 
		query.append("        #if( ${cre_usr_id}!='')" ).append("\n"); 
		query.append("             and  M.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ) M" ).append("\n"); 
		query.append("       ,TES_LGS_COST C" ).append("\n"); 
		query.append("       ,MDM_VENDOR V" ).append("\n"); 
		query.append("       ,MDM_ACCOUNT MA" ).append("\n"); 
		query.append("       ,MDM_VSL_CNTR MC" ).append("\n"); 
		query.append(" where  RNK = 1" ).append("\n"); 
		query.append("   and  M.LGS_COST_CD = C.LGS_COST_CD" ).append("\n"); 
		query.append("   and  M.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("   and  C.ACCT_CD = MA.ACCT_CD" ).append("\n"); 
		query.append("   and  M.VSL_CD = MC.VSL_CD" ).append("\n"); 
		query.append("#if(${vskd_port_rhq_cd} != '' && ${vskd_port_rhq_cd} != 'ALL')" ).append("\n"); 
		query.append("   and  M.VSKD_PORT_RHQ_CD = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sls_ofc_cd} != '' && ${sls_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("   and  M.INV_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- ACCOUNT CODE" ).append("\n"); 
		query.append("#if( ${arr_acct_cd}!='' && ${arr_acct_cd}!='All')  " ).append("\n"); 
		query.append("and  C.ACCT_CD in ( select decode(ACCT_CD,'110911','511911',ACCT_CD)" ).append("\n"); 
		query.append("                    from MDM_ACCOUNT" ).append("\n"); 
		query.append("                  where ACCT_CD  IN ( #foreach($key IN ${acct_cd})						" ).append("\n"); 
		query.append("                                        #if($velocityCount < $acct_cd.size()) '$key',					" ).append("\n"); 
		query.append("                                        #else '$key' #end " ).append("\n"); 
		query.append("                                      #end ))                                             	" ).append("\n"); 
		query.append("and  C.LGS_COST_CD like ( select decode(LGS_COST_CD, '110911','____', '______')  " ).append("\n"); 
		query.append("                            from TES_LGS_COST" ).append("\n"); 
		query.append("                           where LGS_COST_CD  IN ( #foreach($key IN ${acct_cd})					" ).append("\n"); 
		query.append("                                                     #if($velocityCount < $acct_cd.size())	  '$key',					" ).append("\n"); 
		query.append("                                                     #else '$key' #end " ).append("\n"); 
		query.append("                                                   #end ))||'%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("--VVD 가 있는 경우" ).append("\n"); 
		query.append("#if( ${vsl_cd}!='')" ).append("\n"); 
		query.append("   and  M.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${skd_voy_no}!='')" ).append("\n"); 
		query.append("   and  M.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${skd_dir_cd}!='')" ).append("\n"); 
		query.append("   and  M.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- VESSEL CLASS" ).append("\n"); 
		query.append("#if ( ${cntr_vsl_clss_capa} != 'ALL' && ${cntr_vsl_clss_capa} != '')" ).append("\n"); 
		query.append("   and  MC.CNTR_VSL_CLSS_CAPA = @[cntr_vsl_clss_capa] --9000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- Lane Code" ).append("\n"); 
		query.append("#if ( ${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("   and  M.VSL_SLAN_CD = @[vsl_slan_cd] -- NE4" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and  length(C.LGS_COST_CD) = 6" ).append("\n"); 
		query.append("group by M.ISS_CTY_CD, M.SO_SEQ, M.YD_CD, M.VSL_CD, M.SKD_VOY_NO, M.SKD_DIR_CD, M.VSL_SLAN_CD, C.ACCT_CD, MA.ACCT_ENG_NM, " ).append("\n"); 
		query.append("        M.LGS_COST_CD, C.LGS_COST_FULL_NM, M.VNDR_SEQ, V.VNDR_LGL_ENG_NM, M.CURR_CD, M.INV_OFC_CD, M.VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("#if ( ${diff_rmk} == 'Y')" ).append("\n"); 
		query.append(", M.DIFF_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${date_type} == 'CR')  " ).append("\n"); 
		query.append(" , M.CRE_DT" ).append("\n"); 
		query.append("#elseif ( ${date_type} == 'VVD')" ).append("\n"); 
		query.append(" , M.VPS_ETD_DT" ).append("\n"); 
		query.append("#elseif ( ${date_type} == 'IS') " ).append("\n"); 
		query.append(" , M.ISS_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY  -- invoice creation 조회조건" ).append("\n"); 
		query.append("        #if ( ${date_type} == 'CR')        " ).append("\n"); 
		query.append("              M.CRE_DT ,substr(M.YD_CD, 1, 5) ,M.YD_CD,M.VSL_SLAN_CD,M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD,C.ACCT_CD,M.VNDR_SEQ" ).append("\n"); 
		query.append("        -- VVD ETD 조회 조건" ).append("\n"); 
		query.append("        #elseif ( ${date_type} == 'VVD')" ).append("\n"); 
		query.append("              M.VPS_ETD_DT,substr(M.YD_CD, 1, 5) ,M.YD_CD,M.VSL_SLAN_CD,M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD,C.ACCT_CD,M.VNDR_SEQ" ).append("\n"); 
		query.append("        #elseif ( ${date_type} == 'IS')        " ).append("\n"); 
		query.append("        -- issue date 조건" ).append("\n"); 
		query.append("              M.ISS_DT,substr(M.YD_CD, 1, 5) ,M.YD_CD,M.VSL_SLAN_CD,M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD,C.ACCT_CD,M.VNDR_SEQ" ).append("\n"); 
		query.append("        #end" ).append("\n"); 

	}
}
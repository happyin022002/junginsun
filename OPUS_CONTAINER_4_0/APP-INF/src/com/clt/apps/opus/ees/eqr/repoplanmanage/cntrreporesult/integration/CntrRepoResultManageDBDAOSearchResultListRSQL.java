/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrRepoResultManageDBDAOSearchResultListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoResultManageDBDAOSearchResultListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchResultList
	  * 
	  * 2010.12.23 이병훈  [CHM-201007931-01] [EQR] - Empty Repo Result 기능 보완
	  * </pre>
	  */
	public CntrRepoResultManageDBDAOSearchResultListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.integration").append("\n"); 
		query.append("FileName : CntrRepoResultManageDBDAOSearchResultListRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("  ROWNUM SEQ" ).append("\n"); 
		query.append("  , FM_LOC " ).append("\n"); 
		query.append("  , TO_LOC" ).append("\n"); 
		query.append("  , PERIOD" ).append("\n"); 
		query.append("  , DECODE(TRANSMODE, 'TD', 'Truck', 'RD', 'Rail', 'WD', 'Water', TRANSMODE) TRANSMODE" ).append("\n"); 
		query.append("  , TOTAL" ).append("\n"); 
		query.append("#foreach ($key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append("  , ${key}CNTR_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select " ).append("\n"); 
		query.append("	FM_LOC " ).append("\n"); 
		query.append("  , TO_LOC" ).append("\n"); 
		query.append("  , YYYYMM PERIOD" ).append("\n"); 
		query.append("  , MOD_CD TRANSMODE" ).append("\n"); 
		query.append("  , TOTAL" ).append("\n"); 
		query.append("#foreach ($key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append("  , ${key}CNTR_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("	  substr(A.FM_NOD_CD, 1, 5) FM_LOC" ).append("\n"); 
		query.append("      ,substr(A.TO_NOD_CD, 1, 5) TO_LOC" ).append("\n"); 
		query.append("      ,to_char(A.LOCL_CRE_DT, 'YYYY-MM-DD') YYYYMM" ).append("\n"); 
		query.append("      ,TRSP_CRR_MOD_CD MOD_CD" ).append("\n"); 
		query.append("      ,SUM(1) TOTAL" ).append("\n"); 
		query.append("     #foreach ($key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append("      ,SUM(Decode(A.EQ_TPSZ_CD, '${key}', 1, 0)) ${key}CNTR_QTY" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("	#if( $arrFmLoc.size() > 0 && ${fmloctp} != 'ALL')" ).append("\n"); 
		query.append("      ,MDM_LOCATION L1" ).append("\n"); 
		query.append("      ,MDM_EQ_ORZ_CHT E1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if( $arrToLoc.size() > 0 && ${toloctp} != 'ALL')" ).append("\n"); 
		query.append("      ,MDM_LOCATION L2" ).append("\n"); 
		query.append("      ,MDM_EQ_ORZ_CHT E2" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    WHERE A.CGO_TP_CD = 'M'" ).append("\n"); 
		query.append("      AND A.EQ_KND_CD ='U'" ).append("\n"); 
		query.append("      AND A.DELT_FLG <>'Y'" ).append("\n"); 
		query.append("--      TP/SZ CONDITION" ).append("\n"); 
		query.append("     #if( $arrCntrTpszCd.size() > 0)" ).append("\n"); 
		query.append("      AND A.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("	     #foreach ($key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append("			#if($velocityCount == 1) " ).append("\n"); 
		query.append("      		'${key}'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			,'${key}'" ).append("\n"); 
		query.append("	     	#end     " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("     #end   " ).append("\n"); 
		query.append("--       PERIOD CONDITION" ).append("\n"); 
		query.append("     #if( ${period} == 'Day')" ).append("\n"); 
		query.append("      AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate], 'YYYYMMDD') AND TO_DATE(@[todate], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("     #elseif ( ${period} == 'Week')" ).append("\n"); 
		query.append("      AND A.LOCL_CRE_DT BETWEEN (" ).append("\n"); 
		query.append("        SELECT TO_DATE(WK_ST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("        FROM EQR_WK_PRD" ).append("\n"); 
		query.append("        WHERE PLN_YR || PLN_WK = @[fmdate]) AND (" ).append("\n"); 
		query.append("        SELECT TO_DATE(WK_END_DT, 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("        FROM EQR_WK_PRD" ).append("\n"); 
		query.append("        WHERE PLN_YR || PLN_WK = @[todate])" ).append("\n"); 
		query.append("     #elseif ( ${period} == 'Month') " ).append("\n"); 
		query.append("     AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate], 'YYYYMM') AND LAST_DAY(TO_DATE(@[todate], 'YYYYMM')) + 0.99999  " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("--      LOCATION CONDITION" ).append("\n"); 
		query.append("     #if( $arrFmLoc.size() > 0 && ${fmloctp} != 'ALL')" ).append("\n"); 
		query.append("      AND substr(A.FM_NOD_CD, 1, 5) = L1.LOC_CD" ).append("\n"); 
		query.append("      AND L1.SCC_CD = E1.SCC_CD" ).append("\n"); 
		query.append("	  #if (${fmloctp} == 'R')" ).append("\n"); 
		query.append("		AND E1.RCC_CD IN(" ).append("\n"); 
		query.append("      #elseif (${fmloctp} == 'L')" ).append("\n"); 
		query.append("		AND E1.LCC_CD IN(" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        AND E1.ECC_CD IN(" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	     #foreach ($key in ${arrFmLoc})" ).append("\n"); 
		query.append("			#if($velocityCount == 1) " ).append("\n"); 
		query.append("      		'${key}'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			,'${key}'" ).append("\n"); 
		query.append("	     	#end     " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if( $arrToLoc.size() > 0 && ${toloctp} != 'ALL')" ).append("\n"); 
		query.append("      AND substr(A.TO_NOD_CD, 1, 5) = L2.LOC_CD" ).append("\n"); 
		query.append("      AND L2.SCC_CD = E2.SCC_CD" ).append("\n"); 
		query.append("      #if (${toloctp} == 'R')" ).append("\n"); 
		query.append("		AND E2.RCC_CD IN(" ).append("\n"); 
		query.append("      #elseif (${toloctp} == 'L')" ).append("\n"); 
		query.append("		AND E2.LCC_CD IN(" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        AND E2.ECC_CD IN(" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	     #foreach ($key in ${arrToLoc})" ).append("\n"); 
		query.append("			#if($velocityCount == 1) " ).append("\n"); 
		query.append("      		'${key}'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			,'${key}'" ).append("\n"); 
		query.append("	     	#end     " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--      TRANSMODE CONDITION   " ).append("\n"); 
		query.append("	#if( ${transmode} == 'ALL')" ).append("\n"); 
		query.append("		AND A.TRSP_CRR_MOD_CD IN ('TD','RD','WD')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if( $arrMode.size() > 0)" ).append("\n"); 
		query.append("			AND A.TRSP_CRR_MOD_CD IN (" ).append("\n"); 
		query.append("			#foreach ($key in ${arrMode})" ).append("\n"); 
		query.append("				#if($velocityCount == 1) " ).append("\n"); 
		query.append("					'${key}'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'${key}'" ).append("\n"); 
		query.append("				#end     " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("--      Water(WD), Rail(RD), Truck(TD), Water Rail(WR), Water Truck(WT), Rail Water(RW), Truck Water(TW), Rail Truck(RT), Truck Rail(TR)" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("    GROUP BY substr(A.FM_NOD_CD, 1, 5), substr(A.TO_NOD_CD, 1, 5), to_char(A.LOCL_CRE_DT, 'YYYY-MM-DD'), TRSP_CRR_MOD_CD --,  A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 미주 rail의 경우 Mode 를  ALL, Rail 선택시 조회한다." ).append("\n"); 
		query.append("#if (${isUnion} == 'TRUE')" ).append("\n"); 
		query.append("    union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("	  substr(A.FM_NOD_CD, 1, 5) FM_LOC" ).append("\n"); 
		query.append("      ,substr(A.TO_NOD_CD, 1, 5) TO_LOC" ).append("\n"); 
		query.append("      ,to_char(A.LOCL_CRE_DT, 'YYYY-MM-DD') YYYYMM" ).append("\n"); 
		query.append("      ,'RD' MOD_CD" ).append("\n"); 
		query.append("      ,SUM(1) TOTAL" ).append("\n"); 
		query.append("     #foreach ($key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append("      ,SUM(Decode(A.EQ_TPSZ_CD, '${key}', 1, 0)) ${key}CNTR_QTY" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("    from trs_trsp_rail_bil_ord a" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        select trsp_so_ofc_cty_cd," ).append("\n"); 
		query.append("          trsp_so_seq," ).append("\n"); 
		query.append("          curr_cd," ).append("\n"); 
		query.append("          sum(BZC_AMT) BZC_AMT" ).append("\n"); 
		query.append("        from trs_trsp_rail_bil_vndr_set" ).append("\n"); 
		query.append("        group by trsp_so_ofc_cty_cd, trsp_so_seq, curr_cd ) b" ).append("\n"); 
		query.append("	#if( $arrFmLoc.size() > 0 && ${fmloctp} != 'ALL')" ).append("\n"); 
		query.append("      ,MDM_LOCATION L1" ).append("\n"); 
		query.append("      ,MDM_EQ_ORZ_CHT E1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if( $arrToLoc.size() > 0 && ${toloctp} != 'ALL')" ).append("\n"); 
		query.append("      ,MDM_LOCATION L2" ).append("\n"); 
		query.append("      ,MDM_EQ_ORZ_CHT E2" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    where a.TRSP_SO_OFC_CTY_CD = b.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      and a.TRSP_SO_SEQ = b.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      and a.CGO_TP_CD = 'M'" ).append("\n"); 
		query.append("      and a.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("--      TP/SZ CONDITION" ).append("\n"); 
		query.append("     #if( $arrCntrTpszCd.size() > 0)" ).append("\n"); 
		query.append("      AND A.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("	     #foreach ($key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append("			#if($velocityCount == 1) " ).append("\n"); 
		query.append("      		'${key}'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			,'${key}'" ).append("\n"); 
		query.append("	     	#end     " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("     #end    " ).append("\n"); 
		query.append("--       PERIOD CONDITION" ).append("\n"); 
		query.append("     #if( ${period} == 'Day')" ).append("\n"); 
		query.append("      AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate], 'YYYYMMDD') AND TO_DATE(@[todate], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("     #elseif ( ${period} == 'Week')" ).append("\n"); 
		query.append("      AND A.LOCL_CRE_DT BETWEEN (" ).append("\n"); 
		query.append("        SELECT TO_DATE(WK_ST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("        FROM EQR_WK_PRD" ).append("\n"); 
		query.append("        WHERE PLN_YR || PLN_WK = @[fmdate]) AND (" ).append("\n"); 
		query.append("        SELECT TO_DATE(WK_END_DT, 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("        FROM EQR_WK_PRD" ).append("\n"); 
		query.append("        WHERE PLN_YR || PLN_WK = @[todate])" ).append("\n"); 
		query.append("     #elseif ( ${period} == 'Month') " ).append("\n"); 
		query.append("     AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate], 'YYYYMM') AND LAST_DAY(TO_DATE(@[todate], 'YYYYMM')) + 0.99999  " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("--      LOCATION CONDITION" ).append("\n"); 
		query.append("     #if( $arrFmLoc.size() > 0 && ${fmloctp} != 'ALL')" ).append("\n"); 
		query.append("      AND substr(A.FM_NOD_CD, 1, 5) = L1.LOC_CD" ).append("\n"); 
		query.append("      AND L1.SCC_CD = E1.SCC_CD" ).append("\n"); 
		query.append("      #if (${fmloctp} == 'R')" ).append("\n"); 
		query.append("		AND E1.RCC_CD IN(" ).append("\n"); 
		query.append("      #elseif (${fmloctp} == 'L')" ).append("\n"); 
		query.append("		AND E1.LCC_CD IN(" ).append("\n"); 
		query.append("	  #else" ).append("\n"); 
		query.append("      	AND E1.ECC_CD IN(" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	     #foreach ($key in ${arrFmLoc})" ).append("\n"); 
		query.append("			#if($velocityCount == 1) " ).append("\n"); 
		query.append("      		'${key}'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			,'${key}'" ).append("\n"); 
		query.append("	     	#end     " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if( $arrToLoc.size() > 0 && ${toloctp} != 'ALL')" ).append("\n"); 
		query.append("      AND substr(A.TO_NOD_CD, 1, 5) = L2.LOC_CD" ).append("\n"); 
		query.append("      AND L2.SCC_CD = E2.SCC_CD" ).append("\n"); 
		query.append("      #if (${toloctp} == 'R')" ).append("\n"); 
		query.append("		AND E2.RCC_CD IN(" ).append("\n"); 
		query.append("      #elseif (${toloctp} == 'L')" ).append("\n"); 
		query.append("		AND E2.LCC_CD IN(" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("      	AND E2.ECC_CD IN(" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	     #foreach ($key in ${arrToLoc})" ).append("\n"); 
		query.append("			#if($velocityCount == 1) " ).append("\n"); 
		query.append("      		'${key}'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			,'${key}'" ).append("\n"); 
		query.append("	     	#end     " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    GROUP BY substr(A.FM_NOD_CD, 1, 5), substr(A.TO_NOD_CD, 1, 5), to_char(A.LOCL_CRE_DT, 'YYYY-MM-DD'), 'RL' --,  A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("ORDER BY  FM_LOC, TO_LOC, YYYYMM,  MOD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
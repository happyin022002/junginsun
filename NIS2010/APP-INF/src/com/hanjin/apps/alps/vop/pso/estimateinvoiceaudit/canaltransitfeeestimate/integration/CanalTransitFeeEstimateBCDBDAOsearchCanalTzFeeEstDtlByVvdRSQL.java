/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD별 상세 운항통합비를 조회합니다.
	  * -------------------------------------------------------------------
	  * ** 변경이력 **
	  * -------------------------------------------------------------------
	  * [CHM-201005061-01]
	  * Due Date를 무조건 ETA-1 기준으로 조회
	  * (이후 로직에서 휴일연산함)
	  * -------------------------------------------------------------------
	  * 2012.03.09 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발 - ATCH_FILE_NO, INV_ATCH_FILE_NO 추가
	  * 2012.03.14 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
	  * </pre>
	  */
	public CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL").append("\n"); 
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
		query.append("SELECT   SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("         ,LOCL_XCH_RT" ).append("\n"); 
		query.append("         ,TR_VOL_VAL" ).append("\n"); 
		query.append("         ,SCG_RT_AMT" ).append("\n"); 
		query.append("         ,DUE_DT" ).append("\n"); 
		query.append("         ,VNDR_SEQ" ).append("\n"); 
		query.append("         ,PSO_BZTP_CD" ).append("\n"); 
		query.append("         ,VSL_CD" ).append("\n"); 
		query.append("         ,SKD_VOY_NO" ).append("\n"); 
		query.append("         ,SKD_DIR_CD" ).append("\n"); 
		query.append("         ,YD_CD" ).append("\n"); 
		query.append("         ,CALL_SEQ" ).append("\n"); 
		query.append("         ,LGS_COST_CD" ).append("\n"); 
		query.append("         ,LGS_COST_FULL_NM" ).append("\n"); 
		query.append("         ,RQST_AMT" ).append("\n"); 
		query.append("         ,DIFF_RMK" ).append("\n"); 
		query.append("         ,CALC_AMT" ).append("\n"); 
		query.append("         ,YD_CHG_NO" ).append("\n"); 
		query.append("         ,YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("         ,DFLT_XPR_DESC" ).append("\n"); 
		query.append("         ,SYS_XPR_DESC" ).append("\n"); 
		query.append("         ,DFLT_SYS_XPR_DESC" ).append("\n"); 
		query.append("         ,INV_NO" ).append("\n"); 
		query.append("		 ,INV_RGST_NO" ).append("\n"); 
		query.append("         ,(SELECT X.CNTR_PNM_CAPA" ).append("\n"); 
		query.append("             FROM MDM_VSL_CNTR X" ).append("\n"); 
		query.append("            WHERE X.VSL_CD = Z.VSL_CD" ).append("\n"); 
		query.append("          ) CNTR_PNM_CAPA" ).append("\n"); 
		query.append("         ,VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT MAX(SUZ_NET_TONG_WGT) SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("            ,MAX(LOCL_XCH_RT) LOCL_XCH_RT" ).append("\n"); 
		query.append("            ,MAX(TR_VOL_VAL) TR_VOL_VAL" ).append("\n"); 
		query.append("            ,MAX(SCG_RT_AMT) SCG_RT_AMT" ).append("\n"); 
		query.append("            ,MAX(DUE_DT) DUE_DT" ).append("\n"); 
		query.append("            ,MAX(VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append("            ,MAX(PSO_BZTP_CD) PSO_BZTP_CD" ).append("\n"); 
		query.append("            ,MAX(VSL_CD) VSL_CD" ).append("\n"); 
		query.append("            ,MAX(SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append("            ,MAX(SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("            ,MAX(YD_CD) YD_CD" ).append("\n"); 
		query.append("            ,MAX(CALL_SEQ) CALL_SEQ" ).append("\n"); 
		query.append("            ,LGS_COST_CD" ).append("\n"); 
		query.append("            ,MAX(LGS_COST_FULL_NM) LGS_COST_FULL_NM" ).append("\n"); 
		query.append("            ,MAX(RQST_AMT) RQST_AMT" ).append("\n"); 
		query.append("            ,MAX(DIFF_RMK) DIFF_RMK" ).append("\n"); 
		query.append("            ,MAX(CALC_AMT) CALC_AMT" ).append("\n"); 
		query.append("            ,YD_CHG_NO" ).append("\n"); 
		query.append("            ,YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("            ,MAX(DFLT_XPR_DESC) DFLT_XPR_DESC" ).append("\n"); 
		query.append("            ,MAX(SYS_XPR_DESC) SYS_XPR_DESC" ).append("\n"); 
		query.append("            ,MAX(DFLT_SYS_XPR_DESC) DFLT_SYS_XPR_DESC" ).append("\n"); 
		query.append("            ,MAX(INV_NO) INV_NO" ).append("\n"); 
		query.append("            ,MAX(INV_RGST_NO) INV_RGST_NO" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT T5.SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("                   ,T5.LOCL_XCH_RT" ).append("\n"); 
		query.append("                   ,T5.TR_VOL_VAL" ).append("\n"); 
		query.append("                   ,T5.SCG_RT_AMT" ).append("\n"); 
		query.append("                   ,(SELECT TO_CHAR(VPS_ETD_DT-1, 'YYYYMMDD')" ).append("\n"); 
		query.append("                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                      WHERE VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                        AND SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                        AND SKD_DIR_CD= substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                        AND YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                    ) DUE_DT" ).append("\n"); 
		query.append("                   ,T5.VNDR_SEQ" ).append("\n"); 
		query.append("                   ,T1.PSO_BZTP_CD" ).append("\n"); 
		query.append("                   ,T1.VSL_CD" ).append("\n"); 
		query.append("                   ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                   ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                   ,T1.YD_CD" ).append("\n"); 
		query.append("                   ,T1.CALL_SEQ" ).append("\n"); 
		query.append("                   ,NVL(T2.LGS_COST_CD, T1.LGS_COST_CD) LGS_COST_CD" ).append("\n"); 
		query.append("                   ,(SELECT X.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                       FROM TES_LGS_COST X" ).append("\n"); 
		query.append("                      WHERE X.LGS_COST_CD = T1.LGS_COST_CD" ).append("\n"); 
		query.append("                    ) LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                   , ( SELECT SUM(RQST_AMT) FROM PSO_CNL_TZ_FEE_DTL A" ).append("\n"); 
		query.append("                                           WHERE A.VSL_CD = T5.VSL_CD " ).append("\n"); 
		query.append("                                             AND A.SKD_VOY_NO = T5.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             AND A.SKD_DIR_CD = T5.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             AND A.CALL_SEQ = T5.CALL_SEQ" ).append("\n"); 
		query.append("                                             AND A.YD_CD = T5.YD_CD " ).append("\n"); 
		query.append("                                             AND T1.LGS_COST_CD LIKE SUBSTR(A.LGS_COST_CD,1,4)||'%' ) RQST_AMT" ).append("\n"); 
		query.append("                   ,REPLACE(REPLACE(T1.DIFF_RMK, CHR(13), TO_CHAR(00)), CHR(10), TO_CHAR(1)) DIFF_RMK" ).append("\n"); 
		query.append("                   ,NULL CALC_AMT" ).append("\n"); 
		query.append("                   ,T2.YD_CHG_NO" ).append("\n"); 
		query.append("                   ,T2.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                   ,T4.DFLT_XPR_DESC" ).append("\n"); 
		query.append("                   ,T4.SYS_XPR_DESC" ).append("\n"); 
		query.append("                   ,T4.DFLT_SYS_XPR_DESC" ).append("\n"); 
		query.append("                   ,'' INV_NO" ).append("\n"); 
		query.append("                   ,'' INV_RGST_NO" ).append("\n"); 
		query.append("            FROM PSO_CNL_TZ_FEE T5" ).append("\n"); 
		query.append("                , PSO_CNL_TZ_FEE_DTL T1" ).append("\n"); 
		query.append("                , ( SELECT LGS_COST_CD" ).append("\n"); 
		query.append("                          , MAX(YD_CHG_NO) YD_CHG_NO" ).append("\n"); 
		query.append("                          , MAX(YD_CHG_VER_SEQ) YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                     FROM PSO_YD_CHG" ).append("\n"); 
		query.append("                    WHERE YD_CD = @[yd_cd]--'EGSUZT1'" ).append("\n"); 
		query.append("                    AND VNDR_SEQ = @[vndr_seq]--100870" ).append("\n"); 
		query.append("                    AND TO_DATE( @[rev_yrmon], 'YYYYMM') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("                    GROUP BY LGS_COST_CD" ).append("\n"); 
		query.append("                  ) T2" ).append("\n"); 
		query.append("                , PSO_YD_CHG_XPR T3" ).append("\n"); 
		query.append("                , PSO_CHG_XPR T4" ).append("\n"); 
		query.append("            WHERE T5.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("            AND T5.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND T5.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND T5.CALL_SEQ = T1.CALL_SEQ" ).append("\n"); 
		query.append("            AND T5.YD_CD = T1.YD_CD" ).append("\n"); 
		query.append("            AND T2.LGS_COST_CD (+) like T1.LGS_COST_CD || '%'" ).append("\n"); 
		query.append("            AND T2.YD_CHG_NO = T3.YD_CHG_NO (+)" ).append("\n"); 
		query.append("            AND T2.YD_CHG_VER_SEQ = T3.YD_CHG_VER_SEQ (+)" ).append("\n"); 
		query.append("            and T3.CHG_XPR_NO = T4.CHG_XPR_NO (+)" ).append("\n"); 
		query.append("            and T5.PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("            #if( ${call_seq} != '')" ).append("\n"); 
		query.append("            AND T5.CALL_SEQ IN ( SELECT MAX(CALL_SEQ) " ).append("\n"); 
		query.append("                                FROM PSO_CNL_TZ_FEE TZF " ).append("\n"); 
		query.append("                                WHERE TZF.PSO_BZTP_CD	= T5.PSO_BZTP_CD" ).append("\n"); 
		query.append("                                AND TZF.VSL_CD	    = T5.VSL_CD	" ).append("\n"); 
		query.append("                                AND TZF.SKD_VOY_NO	= T5.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                AND TZF.SKD_DIR_CD	= T5.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                AND TZF.YD_CD	    = T5.YD_CD" ).append("\n"); 
		query.append("                                AND TZF.BUD_SCNR_NO = T5.BUD_SCNR_NO" ).append("\n"); 
		query.append("                                AND TZF.REV_YRMON 	= T5.REV_YRMON" ).append("\n"); 
		query.append("                                AND TZF.VNDR_SEQ 	= T5.VNDR_SEQ" ).append("\n"); 
		query.append("                                AND TZF.REV_YRMON        = @[rev_yrmon]" ).append("\n"); 
		query.append("                                AND TZF.CNL_TZ_BZTP_CD   = 'E')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if( ${vndr_seq} != '')" ).append("\n"); 
		query.append("            AND T5.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if( ${yd_cd} != '' ) " ).append("\n"); 
		query.append("            AND T5.YD_CD = @[yd_cd]--'EGSUZT1'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if( ${vvd} != '')" ).append("\n"); 
		query.append("            AND T5.VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("            AND T5.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("            AND T5.SKD_DIR_CD = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            AND (@[sts] <> 10 and @[sts] <> 12)   -- ('12' <> 10 and '12' <> 12 )" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("            SELECT   T5.SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("                     ,T5.LOCL_XCH_RT" ).append("\n"); 
		query.append("                     ,T5.TR_VOL_VAL" ).append("\n"); 
		query.append("                     ,T5.SCG_RT_AMT" ).append("\n"); 
		query.append("                     ,(SELECT TO_CHAR(NVL(P.AP_PAY_DT,X.DUE_DT), 'YYYYMMDD') " ).append("\n"); 
		query.append("                         FROM PSO_CHARGE X" ).append("\n"); 
		query.append("                             , AP_PAY_INV P" ).append("\n"); 
		query.append("                        WHERE X.ISS_CTY_CD = T6.ISS_CTY_CD " ).append("\n"); 
		query.append("			              AND X.SO_SEQ = T6.SO_SEQ" ).append("\n"); 
		query.append("			              AND X.INV_NO = P.INV_NO(+)" ).append("\n"); 
		query.append("			              AND P.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("			          ) DUE_DT" ).append("\n"); 
		query.append("			         ,T5.VNDR_SEQ" ).append("\n"); 
		query.append("			         ,T1.PSO_BZTP_CD" ).append("\n"); 
		query.append("			         ,T1.VSL_CD" ).append("\n"); 
		query.append("			         ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("			         ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			         ,T1.YD_CD" ).append("\n"); 
		query.append("			         ,T1.CALL_SEQ" ).append("\n"); 
		query.append("			         ,T1.LGS_COST_CD" ).append("\n"); 
		query.append("			         ,(SELECT x.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("			             FROM TES_LGS_COST x" ).append("\n"); 
		query.append("			            WHERE x.LGS_COST_CD = T1.LGS_COST_CD" ).append("\n"); 
		query.append("			          ) LGS_COST_FULL_NM" ).append("\n"); 
		query.append("			          , ( SELECT SUM(RQST_AMT) " ).append("\n"); 
		query.append("			                FROM PSO_CNL_TZ_FEE_DTL A" ).append("\n"); 
		query.append("                           WHERE A.VSL_CD = T5.VSL_CD" ).append("\n"); 
		query.append("                             AND A.SKD_VOY_NO = T5.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND A.SKD_DIR_CD = T5.SKD_DIR_CD" ).append("\n"); 
		query.append("                             AND A.CALL_SEQ = T5.CALL_SEQ" ).append("\n"); 
		query.append("                             AND A.YD_CD = T5.YD_CD " ).append("\n"); 
		query.append("                             AND T1.LGS_COST_CD LIKE SUBSTR(A.LGS_COST_CD,1,4)||'%' )  RQST_AMT" ).append("\n"); 
		query.append("			         ,REPLACE (REPLACE (T1.DIFF_RMK, CHR (13), TO_CHAR (00)),CHR (10),TO_CHAR (1)) DIFF_RMK" ).append("\n"); 
		query.append("			         ,T1.CALC_AMT" ).append("\n"); 
		query.append("			         ,T1.YD_CHG_NO" ).append("\n"); 
		query.append("			         ,T1.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("			         ,T1.XPR_DESC" ).append("\n"); 
		query.append("			         ,T1.foml_DESC" ).append("\n"); 
		query.append("			         ,'' DFLT_SYS_XPR_DESC" ).append("\n"); 
		query.append("			         ,T6.INV_NO" ).append("\n"); 
		query.append("			         ,T6.INV_RGST_NO /*2009.12.15 add*/" ).append("\n"); 
		query.append("            FROM PSO_CNL_TZ_FEE T5" ).append("\n"); 
		query.append("                 ,PSO_CNL_TZ_FEE_DTL T1" ).append("\n"); 
		query.append("                 ,PSO_CHARGE T6" ).append("\n"); 
		query.append("            WHERE T5.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("            AND T5.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND T5.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND T5.CALL_SEQ = T1.CALL_SEQ" ).append("\n"); 
		query.append("            AND T5.YD_CD = T1.YD_CD" ).append("\n"); 
		query.append("            AND T6.ISS_CTY_CD = T5.ISS_CTY_CD" ).append("\n"); 
		query.append("            AND T6.SO_SEQ = T5.SO_SEQ" ).append("\n"); 
		query.append("            AND T5.PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("            AND T5.CALL_SEQ IN ( SELECT MAX(CALL_SEQ) " ).append("\n"); 
		query.append("                                FROM PSO_CNL_TZ_FEE TZF " ).append("\n"); 
		query.append("                                WHERE TZF.PSO_BZTP_CD	= T5.PSO_BZTP_CD" ).append("\n"); 
		query.append("                                AND TZF.VSL_CD	= T5.VSL_CD	" ).append("\n"); 
		query.append("                                AND TZF.SKD_VOY_NO	= T5.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                AND TZF.SKD_DIR_CD	= T5.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                AND TZF.YD_CD	= T5.YD_CD" ).append("\n"); 
		query.append("                                AND TZF.BUD_SCNR_NO 	= T5.BUD_SCNR_NO" ).append("\n"); 
		query.append("                                AND TZF.REV_YRMON 	= T5.REV_YRMON" ).append("\n"); 
		query.append("                                AND TZF.VNDR_SEQ 	= T5.VNDR_SEQ" ).append("\n"); 
		query.append("                                AND TZF.REV_YRMON        = @[rev_yrmon]" ).append("\n"); 
		query.append("                                AND TZF.CNL_TZ_BZTP_CD   = 'E' )" ).append("\n"); 
		query.append("            AND T5.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("            #if( ${vndr_seq} != '')" ).append("\n"); 
		query.append("            AND T5.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if( ${yd_cd} != '' ) " ).append("\n"); 
		query.append("            AND T5.YD_CD = @[yd_cd]--'EGSUZT1'" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("            #if( ${vvd} != '')" ).append("\n"); 
		query.append("            AND T5.VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("            AND T5.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("            AND T5.SKD_DIR_CD= substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            AND ( @[sts] = 10 or @[sts] = 12 )  --('12' = 10 or 12 = 12 )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("      GROUP BY LGS_COST_CD, YD_CHG_NO, YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("      ) Z" ).append("\n"); 
		query.append("ORDER BY Z.LGS_COST_CD" ).append("\n"); 

	}
}
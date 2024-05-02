/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.09
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.12.09 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchBasicTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Tariff Creation
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffRSQL").append("\n"); 
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
		query.append("WITH MAIN AS (" ).append("\n"); 
		query.append("SELECT    B.SYS_AREA_GRP_ID                                         AS SVR_ID" ).append("\n"); 
		query.append("        , B.DMDT_TRF_CD" ).append("\n"); 
		query.append("        , B.TRF_SEQ" ).append("\n"); 
		query.append("        , B.TRF_GRP_SEQ" ).append("\n"); 
		query.append("        , B.DMDT_BZC_TRF_GRP_NM" ).append("\n"); 
		query.append("        , TO_CHAR(B.EFF_DT, 'YYYY-MM-DD')                           AS EFF_DT" ).append("\n"); 
		query.append("        , NVL(TO_CHAR(B.EXP_DT,'YYYY-MM-DD'), '-')                  AS EXP_DT" ).append("\n"); 
		query.append("		, (SELECT CASE" ).append("\n"); 
		query.append("        	 WHEN B.EFF_DT - TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') <= 0" ).append("\n"); 
		query.append("			   AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - B.EXP_DT <= 0 THEN 'Y'" ).append("\n"); 
		query.append("	         ELSE 'N'" ).append("\n"); 
		query.append("		       END" ).append("\n"); 
		query.append("		  FROM DUAL)                                                AS CURR_FLG	-- 현재 적용중인 Tariff라면 'Y' 아니면 'N'" ).append("\n"); 
		query.append("        , DECODE(B.UPD_OFC_CD, NULL, B.CRE_OFC_CD, B.UPD_OFC_CD)    AS USER_OFFICE" ).append("\n"); 
		query.append("        , C.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("        , C.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("        , D.INTG_CD_VAL_DP_DESC                                     AS DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append("        , E.INTG_CD_VAL_DP_DESC                                     AS DMDT_CGO_TP_NM" ).append("\n"); 
		query.append("        , B.XCLD_SAT_FLG" ).append("\n"); 
		query.append("        , B.XCLD_SUN_FLG" ).append("\n"); 
		query.append("        , B.XCLD_HOL_FLG" ).append("\n"); 
		query.append("        , B.DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  INTG_CD_VAL_DESC " ).append("\n"); 
		query.append("        FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE   INTG_CD_ID          = 'CD01964'" ).append("\n"); 
		query.append("        AND     INTG_CD_VAL_CTNT    = B.DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append("        )                                                           AS DMDT_CHG_CMNC_TP_NM" ).append("\n"); 
		query.append("        , B.CMNC_HR" ).append("\n"); 
		query.append("        , B.CURR_CD" ).append("\n"); 
		query.append("        , A.CFM_FLG                                                 AS RGN_CFM_FLG" ).append("\n"); 
		query.append("        , B.CFM_FLG                                                 AS GRP_CFM_FLG" ).append("\n"); 
		query.append("        , CEIL(B.EFF_DT - SYSDATE)                                  AS EFF_DAY" ).append("\n"); 
		query.append("        , B.DMDT_TRF_GRP_TP_CD" ).append("\n"); 
		query.append("        , '' USR_ID" ).append("\n"); 
		query.append("        , '' OFC_CD" ).append("\n"); 
		query.append("        , '' WKND1" ).append("\n"); 
		query.append("        , '' WKND2" ).append("\n"); 
		query.append("        , '' RGN_CFM_SEQ" ).append("\n"); 
		query.append("        , '' CRNT_CFM_FLG" ).append("\n"); 
		query.append("        , '' BUTTON_MODE" ).append("\n"); 
		query.append("        , B.DMDT_BZC_TRF_GRP_NM                                     AS DMDT_BZC_TRF_GRP_NM2" ).append("\n"); 
		query.append("        , B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE   INTG_CD_ID          = 'CD03257'" ).append("\n"); 
		query.append("        AND     INTG_CD_VAL_CTNT    = B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        )                                                           AS DMDT_DE_TERM_NM" ).append("\n"); 
		query.append("FROM    DMT_TRF_RGN     A, " ).append("\n"); 
		query.append("        DMT_TRF_GRP     B, " ).append("\n"); 
		query.append("        DMT_TRF_CMB     C," ).append("\n"); 
		query.append("        COM_INTG_CD_DTL D, " ).append("\n"); 
		query.append("        COM_INTG_CD_DTL E" ).append("\n"); 
		query.append("WHERE   A.SYS_AREA_GRP_ID   = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     A.DMDT_TRF_CD       = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND     A.TRF_SEQ           = B.TRF_SEQ" ).append("\n"); 
		query.append("AND     B.SYS_AREA_GRP_ID   = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     B.DMDT_TRF_CD       = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND     B.TRF_SEQ           = C.TRF_SEQ" ).append("\n"); 
		query.append("AND     B.DMDT_DE_TERM_CD   = C.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("AND     B.TRF_GRP_SEQ       = C.TRF_GRP_SEQ" ).append("\n"); 
		query.append("AND     D.INTG_CD_VAL_CTNT  = C.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("AND     E.INTG_CD_VAL_CTNT  = C.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("AND     D.INTG_CD_ID        = 'CD02053'" ).append("\n"); 
		query.append("AND     E.INTG_CD_ID        = 'CD01963'" ).append("\n"); 
		query.append("AND     A.DMDT_TRF_CD       = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     A.CVRG_CONTI_CD     = @[cvrg_conti_cd]" ).append("\n"); 
		query.append("AND     A.CVRG_CNT_CD       = NVL(@[cvrg_cnt_cd] , ' ')" ).append("\n"); 
		query.append("AND     A.CVRG_RGN_CD       = NVL(@[cvrg_rgn_cd] , ' ')" ).append("\n"); 
		query.append("AND     A.CVRG_STE_CD       = NVL(@[cvrg_ste_cd] , ' ')" ).append("\n"); 
		query.append("AND     A.CVRG_LOC_CD       = NVL(@[cvrg_loc_cd] , ' ')" ).append("\n"); 
		query.append("AND     A.CVRG_YD_CD        = NVL(@[cvrg_yd_cd]  , ' ')" ).append("\n"); 
		query.append("AND     A.ORG_DEST_CONTI_CD = @[org_dest_conti_cd]" ).append("\n"); 
		query.append("AND     A.ORG_DEST_CNT_CD   = NVL(@[org_dest_cnt_cd], ' ')" ).append("\n"); 
		query.append("AND     A.ORG_DEST_RGN_CD   = NVL(@[org_dest_rgn_cd], ' ')" ).append("\n"); 
		query.append("AND     A.ORG_DEST_STE_CD   = NVL(@[org_dest_ste_cd], ' ')" ).append("\n"); 
		query.append("AND     A.ORG_DEST_LOC_CD   = NVL(@[org_dest_loc_cd], ' ')" ).append("\n"); 
		query.append("AND     B.DMDT_DE_TERM_CD   = @[dmdt_de_term_cd]" ).append("\n"); 
		query.append("#if (${ui_code} == '1001') " ).append("\n"); 
		query.append("AND     A.SUTH_CHN_USE_FLG  = 'N'" ).append("\n"); 
		query.append("#elseif (${ui_code} == '4014') " ).append("\n"); 
		query.append("AND     A.SUTH_CHN_USE_FLG  = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_cntr_tp_cd} != '') " ).append("\n"); 
		query.append("AND     C.DMDT_CNTR_TP_CD       = @[dmdt_cntr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_cgo_tp_cd} != '') " ).append("\n"); 
		query.append("AND     C.DMDT_CGO_TP_CD        = @[dmdt_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${all_flg} == '')" ).append("\n"); 
		query.append("--AND     B.EXP_DT IS NULL" ).append("\n"); 
		query.append("AND     C.TRF_GRP_SEQ = (" ).append("\n"); 
		query.append("                        SELECT  MAX(S.TRF_GRP_SEQ)" ).append("\n"); 
		query.append("                        FROM    DMT_TRF_CMB S" ).append("\n"); 
		query.append("                        WHERE   C.SYS_AREA_GRP_ID   = S.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                        AND     C.DMDT_TRF_CD       = S.DMDT_TRF_CD" ).append("\n"); 
		query.append("                        AND     C.TRF_SEQ           = S.TRF_SEQ" ).append("\n"); 
		query.append("                        AND     C.DMDT_DE_TERM_CD   = S.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                        AND     C.DMDT_CNTR_TP_CD   = S.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("                        AND     C.DMDT_CGO_TP_CD    = S.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.EFF_DT, B.DMDT_BZC_TRF_GRP_NM, B.DMDT_DE_TERM_CD, B.TRF_GRP_SEQ,D.INTG_CD_VAL_DP_SEQ, E.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("TEMP AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(RN) RN" ).append("\n"); 
		query.append("             , MAX(EXP_DT) EXP_DT" ).append("\n"); 
		query.append("          FROM (SELECT ROW_NUMBER() OVER (" ).append("\n"); 
		query.append("                         ORDER BY EXP_DT, TRF_SEQ, TRF_GRP_SEQ, DMDT_CNTR_TP_CD) AS RN" ).append("\n"); 
		query.append("                     , MAIN.*" ).append("\n"); 
		query.append("                  FROM MAIN)" ).append("\n"); 
		query.append("         GROUP BY DMDT_CNTR_TP_CD, DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  SVR_ID" ).append("\n"); 
		query.append("     , DMDT_TRF_CD" ).append("\n"); 
		query.append("     , TRF_SEQ" ).append("\n"); 
		query.append("     , TRF_GRP_SEQ" ).append("\n"); 
		query.append("     , DMDT_BZC_TRF_GRP_NM" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , MAIN.EXP_DT AS EXP_DT" ).append("\n"); 
		query.append("     , CURR_FLG -- 현재 적용중인 Tariff라면 'Y' 아니면 'N'" ).append("\n"); 
		query.append("     , USER_OFFICE" ).append("\n"); 
		query.append("     , DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("     , DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("     , DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append("     , DMDT_CGO_TP_NM" ).append("\n"); 
		query.append("     , XCLD_SAT_FLG" ).append("\n"); 
		query.append("     , XCLD_SUN_FLG" ).append("\n"); 
		query.append("     , XCLD_HOL_FLG" ).append("\n"); 
		query.append("     , DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append("     , DMDT_CHG_CMNC_TP_NM" ).append("\n"); 
		query.append("     , CMNC_HR" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , RGN_CFM_FLG" ).append("\n"); 
		query.append("     , GRP_CFM_FLG" ).append("\n"); 
		query.append("     , EFF_DAY" ).append("\n"); 
		query.append("     , DMDT_TRF_GRP_TP_CD" ).append("\n"); 
		query.append("     , USR_ID" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , WKND1" ).append("\n"); 
		query.append("     , WKND2" ).append("\n"); 
		query.append("     , RGN_CFM_SEQ" ).append("\n"); 
		query.append("     , CRNT_CFM_FLG" ).append("\n"); 
		query.append("     , BUTTON_MODE" ).append("\n"); 
		query.append("     , DMDT_BZC_TRF_GRP_NM2" ).append("\n"); 
		query.append("     , DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("     , DMDT_DE_TERM_NM" ).append("\n"); 
		query.append("  FROM (SELECT ROW_NUMBER() OVER (" ).append("\n"); 
		query.append("                 ORDER BY EXP_DT, TRF_SEQ, TRF_GRP_SEQ, DMDT_CNTR_TP_CD) AS RN" ).append("\n"); 
		query.append("             , MAIN.*" ).append("\n"); 
		query.append("          FROM MAIN) MAIN" ).append("\n"); 
		query.append("     , TEMP TEMP" ).append("\n"); 
		query.append(" WHERE MAIN.RN = TEMP.RN" ).append("\n"); 
		query.append("   AND MAIN.EXP_DT = TEMP.EXP_DT" ).append("\n"); 
		query.append(" ORDER BY TRF_SEQ, TRF_GRP_SEQ, DMDT_CNTR_TP_CD" ).append("\n"); 

	}
}
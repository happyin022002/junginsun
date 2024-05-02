/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BasicDataDBDAOCreateTargerVvdFixByCoaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOCreateTargerVvdFixByCoaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA 대상항차 + BSA 정보로 Target vvd data 생성
	  * - IP 구간에 대한 BSA를 실적기반의 LOAD로 세팅
	  * - IAS Sector sales 를 하면서 IP 구간에 대한 BSA를 0으로 원복 추가적으로 PF SVC TP를 가져오도록 변경
	  * 
	  * 2015.06.15 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.04.20 CHM-201640366 Target VVD Fix 월기준 항차 생성 등 개선 CSR
	  * 2016.05.24 김용습 mas에서 vvd가져올때 연도는 sls_yrmon, 월은 cost_yrmon 기준
	  * </pre>
	  */
	public BasicDataDBDAOCreateTargerVvdFixByCoaCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCreateTargerVvdFixByCoaCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_TGT_VVD (" ).append("\n"); 
		query.append("     BSE_TP_CD" ).append("\n"); 
		query.append("    ,BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,VSL_CD" ).append("\n"); 
		query.append("    ,SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,BSE_MON" ).append("\n"); 
		query.append("    ,BSE_WK" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,IOC_CD" ).append("\n"); 
		query.append("    ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("    ,DELT_FLG" ).append("\n"); 
		query.append("    ,PF_SVC_TP_CD" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT   " ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("SELECT @[f_bse_tp_cd] " ).append("\n"); 
		query.append("      ,@[f_bse_yr] " ).append("\n"); 
		query.append("      ,@[f_bse_qtr_cd]" ).append("\n"); 
		query.append("      ,VVD.TRD_CD" ).append("\n"); 
		query.append("      ,VVD.RLANE_CD" ).append("\n"); 
		query.append("      ,VVD.DIR_CD" ).append("\n"); 
		query.append("      ,VVD.VSL_CD" ).append("\n"); 
		query.append("      ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,VVD.DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(VVD.COST_YRMON,5,6) BSE_MON" ).append("\n"); 
		query.append("      ,VVD.COST_WK" ).append("\n"); 
		query.append("      ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,VVD.IOC_CD" ).append("\n"); 
		query.append("      --,NVL(BSA.FNL_HJS_BSA_CAPA,0) FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      --,MAX(NVL(BSA.FNL_HJS_BSA_CAPA,0)) OVER (PARTITION BY VVD.RLANE_CD,VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.DIR_CD) FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      ,CASE WHEN LANE.IAS_SCTR_FLG IS NULL THEN DECODE(VVD.SUB_TRD_CD,'IP',NVL(PFMC.LOD_QTY,0),NVL(BSA.FNL_HJS_BSA_CAPA,0)) ELSE NVL(BSA.FNL_HJS_BSA_CAPA,0) END FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,VSK.PF_SKD_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD VVD" ).append("\n"); 
		query.append("      ,BSA_VVD_MST BSA" ).append("\n"); 
		query.append("      ,SQM_QTA_LANE_MGMT LANE" ).append("\n"); 
		query.append("      ,VSK_VSL_SKD VSK" ).append("\n"); 
		query.append("      ,( SELECT TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,SUB_TRD_CD" ).append("\n"); 
		query.append("              ,ROUND(SUM(LOD_QTY)/13,0) LOD_QTY" ).append("\n"); 
		query.append("          FROM SQM_PERF_IF" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BSE_TP_CD   = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("           AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("           AND SUB_TRD_CD  = 'IP'" ).append("\n"); 
		query.append("           AND OFC_VW_CD   = 'C'" ).append("\n"); 
		query.append("           AND SQM_LVL_CD  = '2'" ).append("\n"); 
		query.append("           AND QTA_TGT_CD  = 'D'" ).append("\n"); 
		query.append("         GROUP BY TRD_CD, RLANE_CD, DIR_CD,SUB_TRD_CD" ).append("\n"); 
		query.append("        )PFMC" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.SLS_YRMON,0,4) = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.COST_YRMON, 5) BETWEEN (CASE WHEN @[f_bse_qtr_cd] = '1Q' THEN '01' WHEN @[f_bse_qtr_cd] = '2Q' THEN '04' WHEN @[f_bse_qtr_cd] = '3Q' THEN '07' WHEN @[f_bse_qtr_cd] = '4Q' THEN '10' ELSE '01' END) " ).append("\n"); 
		query.append("                                              AND (CASE WHEN @[f_bse_qtr_cd] = '1Q' THEN '03' WHEN @[f_bse_qtr_cd] = '2Q' THEN '06' WHEN @[f_bse_qtr_cd] = '3Q' THEN '09' WHEN @[f_bse_qtr_cd] = '4Q' THEN '12' ELSE '12' END)" ).append("\n"); 
		query.append("   AND VVD.TRD_CD       = BSA.TRD_CD(+)" ).append("\n"); 
		query.append("   AND VVD.RLANE_CD     = BSA.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = BSA.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO   = BSA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND VVD.DIR_CD       = BSA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND VVD.TRD_CD       = LANE.TRD_CD" ).append("\n"); 
		query.append("   AND VVD.RLANE_CD     = LANE.RLANE_CD" ).append("\n"); 
		query.append("   AND VVD.SUB_TRD_CD   = LANE.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND VVD.IOC_CD       = DECODE(VVD.RLANE_CD,'RBCCO','I',VVD.IOC_CD)" ).append("\n"); 
		query.append("   AND VVD.DIR_CD       = NVL(LANE.LANE_DIR_CD,VVD.DIR_CD)" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = VSK.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO   = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.DIR_CD       = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.SLAN_CD      = VSK.VSL_SLAN_CD   " ).append("\n"); 
		query.append("   AND VVD.DIR_CD       = PFMC.DIR_CD(+)" ).append("\n"); 
		query.append("   AND VVD.TRD_CD       = PFMC.TRD_CD(+)" ).append("\n"); 
		query.append("   AND VVD.RLANE_CD     = PFMC.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND VVD.SUB_TRD_CD   = PFMC.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("   AND VVD.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("   AND LANE.SQM_ACT_FLG = 'Y'" ).append("\n"); 

	}
}
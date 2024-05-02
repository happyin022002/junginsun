/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddTargetVVDCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOCreateQtaLoadRevForSectorAddTargetVVDCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Creation 시 확정데이터가 있을 경우
	  * 해당 시점의 선택된 노선의 PF Group에 대한 COA Target VVD 정보를 Fix한다.
	  * 
	  * * 2014.07.09 이혜민    AND A1.RLANE_CD     = A4.RLANE_CD 조건 추가
	  * * 2014.07.25 이혜민    QTA Set up by HO for IAS Sector_Add Creation 시 Bound 삽입 A1.DIR_CD = [@dir_cd] 조건 추가
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.03.21 CHM-201640668 Planning Add Creation 로직 수정
	  * </pre>
	  */
	public PlanningDBDAOCreateQtaLoadRevForSectorAddTargetVVDCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddTargetVVDCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SCTR_ADD_TGT_VVD(BSE_TP_CD, BSE_YR, BSE_QTR_CD, TRD_CD, RLANE_CD, PF_GRP_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BSE_MON, BSE_WK, SUB_TRD_CD, IOC_CD, GRP_BSA_CAPA, FNL_BSA_CAPA, PF_SVC_TP_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       @[bse_tp_cd] " ).append("\n"); 
		query.append("      ,@[bse_yr] " ).append("\n"); 
		query.append("      ,@[bse_qtr_cd]" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A4.PF_GRP_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(A1.SLS_YRMON,5,6) BSE_MON" ).append("\n"); 
		query.append("      ,A1.COST_WK" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,0 AS GRP_BSA_CAPA" ).append("\n"); 
		query.append("      ,ROUND(NVL(A2.FNL_HJS_BSA_CAPA,0)) FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      ,A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD A1" ).append("\n"); 
		query.append("      ,BSA_VVD_MST A2" ).append("\n"); 
		query.append("      ,VSK_VSL_SKD A3" ).append("\n"); 
		query.append("      ,SQM_SCTR_PF_GRP A4" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(A1.SLS_YRMON,0,4) = @[bse_yr]" ).append("\n"); 
		query.append("   AND SUBSTR(A1.COST_YRMON, 5) BETWEEN (CASE WHEN @[bse_qtr_cd] = '1Q' THEN '01' WHEN @[bse_qtr_cd] = '2Q' THEN '04' WHEN @[bse_qtr_cd] = '3Q' THEN '07' WHEN @[bse_qtr_cd] = '4Q' THEN '10' ELSE '01' END) " ).append("\n"); 
		query.append("                                              AND (CASE WHEN @[bse_qtr_cd] = '1Q' THEN '03' WHEN @[bse_qtr_cd] = '2Q' THEN '06' WHEN @[bse_qtr_cd] = '3Q' THEN '09' WHEN @[bse_qtr_cd] = '4Q' THEN '12' ELSE '12' END)" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = NVL(@[dir_cd], A1.DIR_CD)  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A4.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A2.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.VSL_CD       = A2.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO   = A2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.VSL_CD       = A3.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO   = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A1.SLAN_CD      = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND A4.BSE_TP_CD    = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND A4.BSE_YR       = @[bse_yr]" ).append("\n"); 
		query.append("   AND A4.BSE_QTR_CD   = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A4.PF_SVC_TP_CD = A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("   AND A4.PF_GRP_CD    = @[pf_grp_cd]" ).append("\n"); 
		query.append("   AND A1.DELT_FLG     = 'N'" ).append("\n"); 

	}
}
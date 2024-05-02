/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCVesselUtDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2015.11.11 Kim sung wook
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCVesselUtDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AverageUCVesselUtDetail
	  * 2015.03.10 김시몬 VSL CLASS CAPA 보여지도록 추가
	  * 2015.04.30 김시몬 TTL_DAYS를 TTL_DYS로 변경
	  * 2015.09.15 CHM-201537876 OP4 단가 생성 관련 기능 추가 요청 
	  * 2015.10.27 Average U/C_Vessel Pooling2 (OP Fixed & Variable cost, etc) 1 CYCLE 오류 시 색구분자 생성 요청
	  * 2015.11.05 1 CYCLE 관련 월별 VESSEL(MAS_POOL_VSL_RGST) 정보를 Start Month 및 Duration의 범위 기간내 존재하는지 가장 최근것을 가져와 사용하도록 로직 보완 
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCVesselUtDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCVesselUtDetailRSQL").append("\n"); 
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
		query.append("WITH " ).append("\n"); 
		query.append("CT_DATA AS (" ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append("--        NVL2(A.HUL_BND_CD, A.COST_YRMON, 'TTL') AS COST_YRMON," ).append("\n"); 
		query.append("       A.COST_YRMON," ).append("\n"); 
		query.append("--       NVL2(A.HUL_BND_CD, A.TRD_CD, '') AS TRD_CD," ).append("\n"); 
		query.append("--       NVL2(A.HUL_BND_CD, A.SUB_TRD_CD, '') AS SUB_TRD_CD," ).append("\n"); 
		query.append("--       NVL2(A.HUL_BND_CD, A.RLANE_CD, '') AS RLANE_CD," ).append("\n"); 
		query.append("--       NVL2(A.HUL_BND_CD, A.DIR_CD, '') AS DIR_CD," ).append("\n"); 
		query.append("        A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD, A.DIR_CD," ).append("\n"); 
		query.append("       A.HUL_BND_CD," ).append("\n"); 
		query.append("       A.VSL_OSHP_CD, " ).append("\n"); 
		query.append("       B.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("       A.VVD," ).append("\n"); 
		query.append("       A.VSL_CD," ).append("\n"); 
		query.append("       A.SKD_VOY_NO," ).append("\n"); 
		query.append("       A.TTL_AMT," ).append("\n"); 
		query.append("       A.TTL_DAYS," ).append("\n"); 
		query.append("       A.EFF_YRMON," ).append("\n"); 
		query.append("       A.DHIR_AMT," ).append("\n"); 
		query.append("       A.VVD_BSA_CAPA," ).append("\n"); 
		query.append("--       NVL2(A.HUL_BND_CD, A.TEU_UC_AMT, " ).append("\n"); 
		query.append("--         DECODE(SUM(A.VVD_BSA_CAPA) OVER(PARTITION BY A.TRD_CD,A.RLANE_CD,A.DIR_CD,A.VSL_OSHP_CD),0,0, " ).append("\n"); 
		query.append("--                SUM(A.TTL_AMT) OVER(PARTITION BY A.TRD_CD,A.RLANE_CD,A.DIR_CD,A.VSL_OSHP_CD) " ).append("\n"); 
		query.append("--                / SUM(A.VVD_BSA_CAPA) OVER(PARTITION BY A.TRD_CD,A.RLANE_CD,A.DIR_CD,A.VSL_OSHP_CD))) AS TEU_UC_AMT," ).append("\n"); 
		query.append("A.TEU_UC_AMT," ).append("\n"); 
		query.append("       A.STND_COST_CD," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.FREQ_NO," ).append("\n"); 
		query.append("       A.MAX_RNK," ).append("\n"); 
		query.append("--       NVL2(A.HUL_BND_CD, '', A.CYCLE_FLG) AS CYCLE_FLG," ).append("\n"); 
		query.append("       A.CYCLE_FLG," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT COST_WK FROM MAS_MON_VVD " ).append("\n"); 
		query.append("              WHERE TRD_CD = A.TRD_CD AND RLANE_CD = A.RLANE_CD AND DIR_CD = A.DIR_CD AND VSL_CD = A.VSL_CD AND SKD_VOY_NO = A.SKD_VOY_NO AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("       ) COST_WK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT COST_YRMON," ).append("\n"); 
		query.append("               TRD_CD," ).append("\n"); 
		query.append("               SUB_TRD_CD," ).append("\n"); 
		query.append("               RLANE_CD," ).append("\n"); 
		query.append("               DIR_CD," ).append("\n"); 
		query.append("               HUL_BND_CD," ).append("\n"); 
		query.append("               VSL_OSHP_CD,  " ).append("\n"); 
		query.append("               VVD," ).append("\n"); 
		query.append("               VSL_CD," ).append("\n"); 
		query.append("               SKD_VOY_NO," ).append("\n"); 
		query.append("               SUM(TTL_AMT) AS TTL_AMT," ).append("\n"); 
		query.append("               TTL_DAYS," ).append("\n"); 
		query.append("               EFF_YRMON," ).append("\n"); 
		query.append("               DHIR_AMT," ).append("\n"); 
		query.append("               SUM(VVD_BSA_CAPA) AS VVD_BSA_CAPA," ).append("\n"); 
		query.append("               DECODE(SUM(VVD_BSA_CAPA), 0 , 0, SUM(TTL_AMT) / SUM(VVD_BSA_CAPA)) AS TEU_UC_AMT," ).append("\n"); 
		query.append("               STND_COST_CD," ).append("\n"); 
		query.append("               UPD_USR_ID," ).append("\n"); 
		query.append("               FREQ_NO," ).append("\n"); 
		query.append("               MAX_RNK," ).append("\n"); 
		query.append("               MIN(CYCLE_FLG) AS CYCLE_FLG" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT COST_YRMON," ).append("\n"); 
		query.append("                       TRD_CD," ).append("\n"); 
		query.append("                       SUB_TRD_CD," ).append("\n"); 
		query.append("                       RLANE_CD," ).append("\n"); 
		query.append("                       DIR_CD," ).append("\n"); 
		query.append("                       HUL_BND_CD," ).append("\n"); 
		query.append("                       VSL_OSHP_CD,  " ).append("\n"); 
		query.append("                       VVD," ).append("\n"); 
		query.append("                       VSL_CD," ).append("\n"); 
		query.append("                       SKD_VOY_NO," ).append("\n"); 
		query.append("                       TTL_AMT," ).append("\n"); 
		query.append("                       TTL_DAYS," ).append("\n"); 
		query.append("                       EFF_YRMON," ).append("\n"); 
		query.append("                       DHIR_AMT," ).append("\n"); 
		query.append("                       VVD_BSA_CAPA," ).append("\n"); 
		query.append("                       TEU_UC_AMT," ).append("\n"); 
		query.append("                       STND_COST_CD," ).append("\n"); 
		query.append("                       UPD_USR_ID," ).append("\n"); 
		query.append("                       FREQ_NO," ).append("\n"); 
		query.append("                       MAX_RNK," ).append("\n"); 
		query.append("                       DECODE(FREQ_NO, MAX_RNK, 'Y', 'N') AS CYCLE_FLG" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A1.COST_YRMON," ).append("\n"); 
		query.append("                               A1.TRD_CD," ).append("\n"); 
		query.append("                               A1.SUB_TRD_CD," ).append("\n"); 
		query.append("                               A1.RLANE_CD," ).append("\n"); 
		query.append("                               A1.DIR_CD," ).append("\n"); 
		query.append("                               A1.HUL_BND_CD," ).append("\n"); 
		query.append("                               A1.VSL_OSHP_CD,  " ).append("\n"); 
		query.append("                               A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD AS VVD," ).append("\n"); 
		query.append("                               A1.VSL_CD," ).append("\n"); 
		query.append("                               A1.SKD_VOY_NO," ).append("\n"); 
		query.append("                               A1.TTL_AMT," ).append("\n"); 
		query.append("                               A1.TTL_DYS AS TTL_DAYS," ).append("\n"); 
		query.append("                               A1.EFF_FM_YRMON || DECODE(A1.EFF_FM_YRMON,NULL,'',' ~ ')|| A1.EFF_TO_YRMON AS EFF_YRMON," ).append("\n"); 
		query.append("                               A1.DHIR_AMT," ).append("\n"); 
		query.append("                               A1.VVD_BSA_CAPA," ).append("\n"); 
		query.append("                               A1.TEU_UC_AMT," ).append("\n"); 
		query.append("                               A1.STND_COST_CD," ).append("\n"); 
		query.append("                               A1.UPD_USR_ID," ).append("\n"); 
		query.append("                               B1.FREQ_NO," ).append("\n"); 
		query.append("                               COUNT(1) OVER(PARTITION BY A1.COST_YRMON,A1.TRD_CD,A1.SUB_TRD_CD,A1.RLANE_CD,A1.DIR_CD) AS MAX_RNK" ).append("\n"); 
		query.append("                          FROM MAS_POOL_UT_COST_DTL A1," ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                SELECT COST_YRMON,TRD_CD,RLANE_CD,VSL_OSHP_CD,SUB_TRD_CD," ).append("\n"); 
		query.append("                                       SUM(FREQ_NO) OVER(PARTITION BY COST_YRMON,TRD_CD,RLANE_CD,SUB_TRD_CD) AS FREQ_NO" ).append("\n"); 
		query.append("                                  FROM MAS_LANE_VSL_TP_FREQ B1" ).append("\n"); 
		query.append("                                 WHERE B1.COST_YRMON      = REPLACE(@[f_yearweek], '-', '')" ).append("\n"); 
		query.append("                                   AND B1.FREQ_NO         > 0 " ).append("\n"); 
		query.append("                               ) B1" ).append("\n"); 
		query.append("                         WHERE A1.COST_YRMON   = REPLACE(@[f_yearweek], '-', '')" ).append("\n"); 
		query.append("                           AND A1.STND_COST_CD = @[f_cobcost]   " ).append("\n"); 
		query.append("                           AND A1.COST_YRMON   = B1.COST_YRMON(+)" ).append("\n"); 
		query.append("                           AND A1.TRD_CD       = B1.TRD_CD(+)" ).append("\n"); 
		query.append("                           AND A1.RLANE_CD     = B1.RLANE_CD(+)" ).append("\n"); 
		query.append("                           AND A1.SUB_TRD_CD   = B1.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("                           AND A1.VSL_OSHP_CD  = B1.VSL_OSHP_CD(+)" ).append("\n"); 
		query.append("        #if(${f_vsl_cd} != '')" ).append("\n"); 
		query.append("                           AND A1.VSL_CD       = @[f_vsl_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${f_trd_cd} != '')" ).append("\n"); 
		query.append("                           AND A1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${f_rlane_cd} != '')" ).append("\n"); 
		query.append("                           AND A1.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${f_dir_cd} != '')" ).append("\n"); 
		query.append("                           AND A1.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${f_hul_bnd_cd} != '')" ).append("\n"); 
		query.append("                           AND A1.HUL_BND_CD   = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("               ) " ).append("\n"); 
		query.append("         GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                                 (COST_YRMON,TRD_CD,SUB_TRD_CD,RLANE_CD,DIR_CD,HUL_BND_CD,VSL_OSHP_CD,  VVD,VSL_CD,SKD_VOY_NO,TTL_AMT,TTL_DAYS,EFF_YRMON,DHIR_AMT,VVD_BSA_CAPA,TEU_UC_AMT,STND_COST_CD,UPD_USR_ID,FREQ_NO,MAX_RNK)," ).append("\n"); 
		query.append("                                 (COST_YRMON,TRD_CD,SUB_TRD_CD,RLANE_CD,DIR_CD)" ).append("\n"); 
		query.append("                                )   " ).append("\n"); 
		query.append("         ORDER BY COST_YRMON," ).append("\n"); 
		query.append("               TRD_CD," ).append("\n"); 
		query.append("               SUB_TRD_CD," ).append("\n"); 
		query.append("               RLANE_CD," ).append("\n"); 
		query.append("               DIR_CD," ).append("\n"); 
		query.append("               VVD" ).append("\n"); 
		query.append("       ) A, --MAS_POOL_VSL_RGST B" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT VSL_CD, VSL_CLSS_CAPA, VSL_OSHP_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT COST_YRMON, VSL_CD, VSL_CLSS_CAPA, VSL_OSHP_CD," ).append("\n"); 
		query.append("                       MAX(COST_YRMON) OVER(PARTITION BY VSL_CD) AS MAX_COST_YRMON" ).append("\n"); 
		query.append("                  FROM MAS_POOL_VSL_RGST A" ).append("\n"); 
		query.append("--                       (SELECT MIN(EFF_FM_YRMON) AS EFF_FM_YRMON, " ).append("\n"); 
		query.append("--                               MAX(EFF_TO_YRMON) AS EFF_TO_YRMON" ).append("\n"); 
		query.append("--                          FROM MAS_POOL_UT_COST_DTL" ).append("\n"); 
		query.append("--                         WHERE COST_YRMON   = REPLACE('2015-11', '-', '')" ).append("\n"); 
		query.append("--                           AND STND_COST_CD = '54350000'" ).append("\n"); 
		query.append("--                       ) B " ).append("\n"); 
		query.append("                 WHERE COST_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[f_yearweek], '-', ''),'YYYYMM'),- 2),'YYYYMM') AND REPLACE(@[f_yearweek], '-', '')" ).append("\n"); 
		query.append("                   AND NVL(CHTR_OUT_FLG,'N') != 'Y'    " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE COST_YRMON = MAX_COST_YRMON                           " ).append("\n"); 
		query.append("       ) B " ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   --AND A.COST_YRMON  = B.COST_YRMON(+)" ).append("\n"); 
		query.append("   AND A.VSL_CD      = B.VSL_CD(+)" ).append("\n"); 
		query.append("--   AND A.VSL_OSHP_CD = B.VSL_OSHP_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", INV_DATA AS (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("SELECT A.TRD_CD,A.SUB_TRD_CD,A.RLANE_CD,A.HUL_BND_CD,A.VSL_CD,A.SKD_VOY_NO,A.DIR_CD, (A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD) VVD, A.VSL_OSHP_CD,A.TTL_AMT,A.TTL_DYS,A.VVD_BSA_CAPA, B.VSL_CLSS_CAPA, STND_COST_CD" ).append("\n"); 
		query.append("  FROM MAS_POOL_UT_COST_DTL A," ).append("\n"); 
		query.append("       (SELECT VSL_CD,    " ).append("\n"); 
		query.append("               VSL_OSHP_CD,   " ).append("\n"); 
		query.append("               VSL_CLSS_CAPA" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT A1.VSL_CD,    " ).append("\n"); 
		query.append("                       A1.VSL_OSHP_CD,   " ).append("\n"); 
		query.append("                       A1.VSL_CLSS_CAPA, " ).append("\n"); 
		query.append("                       A1.VSL_SEQ, " ).append("\n"); 
		query.append("                       MAX(A1.VSL_SEQ) OVER(PARTITION BY A1.VSL_CD, A1.VSL_OSHP_CD, A1.VSL_CLSS_CAPA) AS VSL_MAX_SEQ" ).append("\n"); 
		query.append("                  FROM MAS_VSL_RGST A1" ).append("\n"); 
		query.append("                 WHERE 1 = 1   " ).append("\n"); 
		query.append("                   AND NVL(A1.DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("                   AND REPLACE(@[f_yearweek], '-', '') BETWEEN  TO_CHAR(NVL(A1.VSL_APLY_FM_DT, A1.VSL_RETN_FM_DT),'YYYYMM') AND 		   " ).append("\n"); 
		query.append("                                         TO_CHAR(NVL(A1.VSL_APLY_TO_DT , A1.VSL_RETN_TO_DT),'YYYYMM')" ).append("\n"); 
		query.append("               )    " ).append("\n"); 
		query.append("         WHERE VSL_SEQ = VSL_MAX_SEQ" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append(" WHERE A.COST_YRMON   = REPLACE(@[f_yearweek], '-', '')" ).append("\n"); 
		query.append("   AND STND_COST_CD = @[f_cobcost]" ).append("\n"); 
		query.append("   AND A.VSL_OSHP_CD IN (" ).append("\n"); 
		query.append("                       DECODE(STND_COST_CD,'54400000','OTH','54350000','CHT','OWN')," ).append("\n"); 
		query.append("                       DECODE(STND_COST_CD,'54400000','OTH','54350000','CHT','53101000','CHT','53102000','CHT','53200000','CHT','43102011','CHT','OWN')," ).append("\n"); 
		query.append("                       DECODE(STND_COST_CD,'54400000','OTH','54350000','CHT','OWN')" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("   AND NVL(A.TTL_AMT,0) = 0" ).append("\n"); 
		query.append("   AND A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.VSL_OSHP_CD = B.VSL_OSHP_CD" ).append("\n"); 
		query.append(" ORDER BY A.TRD_CD,A.SUB_TRD_CD,A.RLANE_CD,A.DIR_CD,A.VSL_OSHP_CD,A.VSL_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT NVL2(C.HUL_BND_CD, C.COST_YRMON, 'TTL') AS COST_YRMON," ).append("\n"); 
		query.append("       NVL2(C.HUL_BND_CD, C.TRD_CD, '') AS TRD_CD," ).append("\n"); 
		query.append("       NVL2(C.HUL_BND_CD, C.SUB_TRD_CD, '') AS SUB_TRD_CD," ).append("\n"); 
		query.append("       NVL2(C.HUL_BND_CD, C.RLANE_CD, '') AS RLANE_CD," ).append("\n"); 
		query.append("       NVL2(C.HUL_BND_CD, C.DIR_CD, '') AS DIR_CD," ).append("\n"); 
		query.append("       NVL2(C.HUL_BND_CD, C.TEU_UC_AMT, " ).append("\n"); 
		query.append("         DECODE(SUM(C.VVD_BSA_CAPA) OVER(PARTITION BY C.TRD_CD,C.RLANE_CD,C.DIR_CD,C.VSL_OSHP_CD),0,0, " ).append("\n"); 
		query.append("                SUM(C.TTL_AMT) OVER(PARTITION BY C.TRD_CD,C.RLANE_CD,C.DIR_CD,C.VSL_OSHP_CD) " ).append("\n"); 
		query.append("                / SUM(C.VVD_BSA_CAPA) OVER(PARTITION BY C.TRD_CD,C.RLANE_CD,C.DIR_CD,C.VSL_OSHP_CD))) AS TEU_UC_AMT," ).append("\n"); 
		query.append("       NVL2(C.HUL_BND_CD, '', C.CYCLE_FLG) AS CYCLE_FLG," ).append("\n"); 
		query.append("       C.HUL_BND_CD," ).append("\n"); 
		query.append("       C.VSL_OSHP_CD, " ).append("\n"); 
		query.append("       C.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("       C.VVD," ).append("\n"); 
		query.append("       C.VSL_CD," ).append("\n"); 
		query.append("       C.SKD_VOY_NO," ).append("\n"); 
		query.append("       C.TTL_AMT," ).append("\n"); 
		query.append("       C.TTL_DAYS," ).append("\n"); 
		query.append("       C.EFF_YRMON," ).append("\n"); 
		query.append("       C.DHIR_AMT," ).append("\n"); 
		query.append("       C.VVD_BSA_CAPA," ).append("\n"); 
		query.append("       C.STND_COST_CD," ).append("\n"); 
		query.append("       C.UPD_USR_ID," ).append("\n"); 
		query.append("       C.FREQ_NO," ).append("\n"); 
		query.append("       C.MAX_RNK," ).append("\n"); 
		query.append("       C.COST_WK," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("--운하 통과 VVD 에 대해서 적용" ).append("\n"); 
		query.append("        CASE WHEN C.STND_COST_CD = '53102000' THEN" ).append("\n"); 
		query.append("            CASE WHEN " ).append("\n"); 
		query.append("                       (SELECT COUNT(1)" ).append("\n"); 
		query.append("                           FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                          WHERE A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("                            AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND A.SKD_DIR_CD = C.DIR_CD" ).append("\n"); 
		query.append("                            AND A.VPS_PORT_CD IN ('EGSUZ', 'PAPAC')" ).append("\n"); 
		query.append("                            AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                        ) >= 1 THEN" ).append("\n"); 
		query.append("                 DECODE( I.VVD , NULL,'N','Y')" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 'N'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            DECODE( I.VVD , NULL,'N','Y')" ).append("\n"); 
		query.append("       END  MIS_TTL" ).append("\n"); 
		query.append("FROM CT_DATA C , INV_DATA I" ).append("\n"); 
		query.append("WHERE C.VVD = I.VVD(+)" ).append("\n"); 
		query.append("AND C.TRD_CD = I.TRD_CD(+)" ).append("\n"); 
		query.append("AND C.SUB_TRD_CD = I.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("AND C.RLANE_CD = I.RLANE_CD(+)" ).append("\n"); 
		query.append(" ORDER BY C.COST_YRMON," ).append("\n"); 
		query.append("               C.TRD_CD," ).append("\n"); 
		query.append("               C.SUB_TRD_CD," ).append("\n"); 
		query.append("               C.RLANE_CD," ).append("\n"); 
		query.append("               C.DIR_CD," ).append("\n"); 
		query.append("               C.VSL_OSHP_CD, " ).append("\n"); 
		query.append("               C.COST_WK," ).append("\n"); 
		query.append("               C.VVD" ).append("\n"); 

	}
}
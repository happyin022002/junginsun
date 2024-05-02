/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOSearchBunkerTariffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.07
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.07.07 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchBunkerTariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBunkerTariffList SELECT
	  * 2010.09.08 이상용   [CHM-201005893] MIN 값이 아니라 SLS_YRMON 과 조인하도록 변경
	  * 2011.11.18 최윤성 [CHM-201110236-01] Bunker Fee 메뉴 컬럼 추가
	  *  - SLANE, RLANE, DIR, VSL CLASS CAPA 에 따른 해당 주차의 VESSEL 정보 제공
	  *    한주에 노선별 VVD정보는 하나만 오는 것이 일반적이나 그렇치 않은 경우가 존재하여
	  *    아래와 같이 CONNECT BY를 사용하여 동일 노선의 동일 사이즈의 VESSEL 코드를 조회 하도록 함
	  * </pre>
	  */
	public NetworkCostDBDAOSearchBunkerTariffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchBunkerTariffListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(D1.COST_YRMON||D1.COST_WK, D2.COST_YRMON||D2.COST_WK, 'R', 'I') FLAG" ).append("\n"); 
		query.append("      ,D2.COST_YRMON                                  COST_YRMON" ).append("\n"); 
		query.append("      ,D2.COST_WK                                	  COST_WK" ).append("\n"); 
		query.append("      ,D2.SLAN_CD                                     SLAN_CD" ).append("\n"); 
		query.append("      ,D2.RLANE_CD                                    RLANE_CD" ).append("\n"); 
		query.append("      ,D2.VSL_CLSS_CAPA                               VSL_CLSS_CAPA" ).append("\n"); 
		query.append("      ,D2.DIR_CD                                      DIR_CD" ).append("\n"); 
		query.append("	  ,D2.HUL_BND_CD" ).append("\n"); 
		query.append("      ,D1.FOIL_CSM                                    FOIL_CSM" ).append("\n"); 
		query.append("      ,D1.FOIL_UC_AMT                                 FOIL_UC_AMT" ).append("\n"); 
		query.append("      ,D1.DOIL_CSM                                    DOIL_CSM" ).append("\n"); 
		query.append("      ,D1.DOIL_UC_AMT                                 DOIL_UC_AMT" ).append("\n"); 
		query.append("      ,D2.VSL_INFO" ).append("\n"); 
		query.append("  FROM COA_BNK_TRF D1" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("          SELECT C1.COST_YRMON" ).append("\n"); 
		query.append("                ,C1.COST_WK" ).append("\n"); 
		query.append("                ,C1.SLAN_CD" ).append("\n"); 
		query.append("                ,C1.RLANE_CD" ).append("\n"); 
		query.append("                ,C1.DIR_CD" ).append("\n"); 
		query.append("				,C1.HUL_BND_CD" ).append("\n"); 
		query.append("                ,C1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                ,MAX(SYS_CONNECT_BY_PATH(C1.VSL_CD,'/'))  VSL_INFO" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                  SELECT B1.COST_YRMON" ).append("\n"); 
		query.append("                        ,B1.COST_WK" ).append("\n"); 
		query.append("                        ,B1.SLAN_CD" ).append("\n"); 
		query.append("                        ,B1.RLANE_CD" ).append("\n"); 
		query.append("                        ,B1.DIR_CD" ).append("\n"); 
		query.append("						,B1.HUL_BND_CD" ).append("\n"); 
		query.append("                        ,B1.VSL_CD" ).append("\n"); 
		query.append("                        ,ROW_NUMBER () OVER (PARTITION BY B1.COST_YRMON, B1.COST_WK, B1.SLAN_CD, B1.RLANE_CD, B1.DIR_CD, B1.VSL_CLSS_CAPA ORDER BY B1.VSL_CD) RNUM" ).append("\n"); 
		query.append("                        ,B1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                          SELECT DISTINCT " ).append("\n"); 
		query.append("#if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("                                 A1.SLS_YRMON COST_YRMON" ).append("\n"); 
		query.append("                                ,A1.COST_WK COST_WK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                 A1.COST_YRMON AS COST_YRMON" ).append("\n"); 
		query.append("                                ,A1.COST_WK COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                ,A1.SLAN_CD" ).append("\n"); 
		query.append("                                ,A1.RLANE_CD" ).append("\n"); 
		query.append("                                ,A1.DIR_CD" ).append("\n"); 
		query.append("								, (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = A3.HUL_BND_CD) HUL_BND_CD" ).append("\n"); 
		query.append("                                ,A1.VSL_CD" ).append("\n"); 
		query.append("                                ,NVL(A2.VSL_CLSS_CAPA,0) VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                            FROM COA_MON_VVD A1" ).append("\n"); 
		query.append("                                ,COA_VSL_RGST A2" ).append("\n"); 
		query.append("                                ,COA_LANE_RGST A3" ).append("\n"); 
		query.append("                           WHERE 1=1" ).append("\n"); 
		query.append("                             AND A1.TRD_CD                = A3.TRD_CD" ).append("\n"); 
		query.append("                             AND A1.RLANE_CD              = A3.RLANE_CD" ).append("\n"); 
		query.append("                             AND A1.IOC_CD                = A3.IOC_CD" ).append("\n"); 
		query.append("                             AND A1.DIR_CD                = A3.DIR_CD " ).append("\n"); 
		query.append("                             AND A3.TRD_CD                <> 'COM'" ).append("\n"); 
		query.append("                             AND A3.VSL_LANE_TP_CD        IN ('JO','SC')" ).append("\n"); 
		query.append("                             AND A1.VSL_CD                = A2.VSL_CD" ).append("\n"); 
		query.append("                             AND A1.N1ST_LODG_PORT_ETD_DT BETWEEN A2.VSL_APLY_FM_DT AND A2.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                             AND A2.VOP_CD                = 'HJS'" ).append("\n"); 
		query.append("#if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("                             AND SUBSTR(A1.SLS_YRMON,1,4)||A1.COST_WK = @[sls_yrmon]||@[cost_wk]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                             AND A1.COST_YRMON            = @[sls_yrmon]||@[cost_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                             AND A1.SLAN_CD               = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                             AND A1.RLANE_CD              = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_clss_capa} != '')" ).append("\n"); 
		query.append("                             AND NVL(A2.VSL_CLSS_CAPA,0)  = @[vsl_clss_capa]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                             AND A1.DELT_FLG              = 'N'" ).append("\n"); 
		query.append("                             AND A2.DELT_FLG              = 'N'" ).append("\n"); 
		query.append("                             AND A3.DELT_FLG              = 'N'" ).append("\n"); 
		query.append("							 AND A1.SUB_TRD_CD <> 'IP' " ).append("\n"); 
		query.append("                          ) B1" ).append("\n"); 
		query.append("                  ) C1" ).append("\n"); 
		query.append("             START WITH C1.RNUM = 1  " ).append("\n"); 
		query.append("           CONNECT BY PRIOR C1.RNUM          = C1.RNUM -1" ).append("\n"); 
		query.append("                        AND PRIOR C1.COST_YRMON    = C1.COST_YRMON" ).append("\n"); 
		query.append("                        AND PRIOR C1.COST_WK       = C1.COST_WK" ).append("\n"); 
		query.append("                        AND PRIOR C1.SLAN_CD       = C1.SLAN_CD" ).append("\n"); 
		query.append("                        AND PRIOR C1.RLANE_CD      = C1.RLANE_CD" ).append("\n"); 
		query.append("                        AND PRIOR C1.DIR_CD        = C1.DIR_CD" ).append("\n"); 
		query.append("                        AND PRIOR C1.VSL_CLSS_CAPA = C1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("             GROUP BY C1.COST_YRMON" ).append("\n"); 
		query.append("                     ,C1.COST_WK" ).append("\n"); 
		query.append("                     ,C1.SLAN_CD" ).append("\n"); 
		query.append("                     ,C1.RLANE_CD" ).append("\n"); 
		query.append("                     ,C1.DIR_CD" ).append("\n"); 
		query.append("					 ,C1.HUL_BND_CD" ).append("\n"); 
		query.append("                     ,C1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("       ) D2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND D2.COST_YRMON    = D1.COST_YRMON    (+)" ).append("\n"); 
		query.append("   AND D2.COST_WK       = D1.COST_WK       (+)" ).append("\n"); 
		query.append("   AND D2.SLAN_CD       = D1.SLAN_CD       (+)" ).append("\n"); 
		query.append("   AND D2.RLANE_CD      = D1.RLANE_CD      (+)" ).append("\n"); 
		query.append("   AND D2.DIR_CD        = D1.SLAN_DIR_CD   (+)" ).append("\n"); 
		query.append("   AND D2.VSL_CLSS_CAPA = D1.VSL_CLSS_CAPA (+)" ).append("\n"); 
		query.append(" ORDER BY D2.COST_YRMON" ).append("\n"); 
		query.append("         ,D2.COST_WK" ).append("\n"); 
		query.append("         ,D2.SLAN_CD" ).append("\n"); 
		query.append("         ,D2.RLANE_CD" ).append("\n"); 
		query.append("         ,D2.DIR_CD" ).append("\n"); 
		query.append("		 ,D2.HUL_BND_CD" ).append("\n"); 
		query.append("         ,D2.VSL_CLSS_CAPA" ).append("\n"); 

	}
}
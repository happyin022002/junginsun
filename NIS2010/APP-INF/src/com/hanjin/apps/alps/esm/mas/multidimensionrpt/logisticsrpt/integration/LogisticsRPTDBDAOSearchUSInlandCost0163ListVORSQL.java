/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchUSInlandCost0163ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LogisticsRPTDBDAOSearchUSInlandCost0163ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRD_INLND_ROUT_MST 테이블의 데이터 조회
	  * </pre>
	  */
	public LogisticsRPTDBDAOSearchUSInlandCost0163ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_inout",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration").append("\n"); 
		query.append("FileName : LogisticsRPTDBDAOSearchUSInlandCost0163ListVORSQL").append("\n"); 
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
		query.append("WITH LOC AS (" ).append("\n"); 
		query.append("         SELECT *" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (SELECT ROUT_ORG_NOD_CD                     AS FM_NOD" ).append("\n"); 
		query.append("                      , SUBSTR(ROUT_ORG_NOD_CD,1,5)         AS FM_LOC" ).append("\n"); 
		query.append("                      , MAS_LOC_FNC(ROUT_ORG_NOD_CD,'ECC')  AS FM_ECC" ).append("\n"); 
		query.append("                      , MAS_LOC_FNC(ROUT_ORG_NOD_CD,'LCC')  AS FM_LCC" ).append("\n"); 
		query.append("                      , MAS_LOC_FNC(ROUT_ORG_NOD_CD,'RCC')  AS FM_RCC" ).append("\n"); 
		query.append("                      , HUB_NOD_CD                          AS HUB_NOD" ).append("\n"); 
		query.append("                      , SUBSTR(HUB_NOD_CD,1,5)              AS HUB_LOC" ).append("\n"); 
		query.append("                      , MAS_LOC_FNC(HUB_NOD_CD,'ECC')       AS HUB_ECC" ).append("\n"); 
		query.append("                      , MAS_LOC_FNC(HUB_NOD_CD,'LCC')       AS HUB_LCC" ).append("\n"); 
		query.append("                      , MAS_LOC_FNC(HUB_NOD_CD,'RCC')       AS HUB_RCC" ).append("\n"); 
		query.append("                      , ROUT_DEST_NOD_CD                    AS TO_NOD" ).append("\n"); 
		query.append("                      , SUBSTR(ROUT_DEST_NOD_CD,1,5)        AS TO_LOC" ).append("\n"); 
		query.append("                      , MAS_LOC_FNC(ROUT_DEST_NOD_CD,'ECC') AS TO_ECC" ).append("\n"); 
		query.append("                      , MAS_LOC_FNC(ROUT_DEST_NOD_CD,'LCC') AS TO_LCC" ).append("\n"); 
		query.append("                      , MAS_LOC_FNC(ROUT_DEST_NOD_CD,'RCC') AS TO_RCC" ).append("\n"); 
		query.append("                      , ROUT_SEQ" ).append("\n"); 
		query.append("                      , @[f_inout] AS INOUT" ).append("\n"); 
		query.append("                      , DECODE(NVL(HUB_NOD_CD,'X'),'X','N','Y') ISHUB" ).append("\n"); 
		query.append("                   FROM PRD_INLND_ROUT_MST M" ).append("\n"); 
		query.append("                      , PRD_NODE N" ).append("\n"); 
		query.append("                      , PRD_NODE N1" ).append("\n"); 
		query.append("                  WHERE ROUT_ORG_NOD_CD LIKE @[f_from] ||'%'" ).append("\n"); 
		query.append("                    AND ROUT_DEST_NOD_CD LIKE @[f_to] ||'%'" ).append("\n"); 
		query.append("                    AND PCTL_IO_BND_CD                = @[f_inout]" ).append("\n"); 
		query.append("                    AND NVL(M.DELT_FLG,'N')           = 'N'" ).append("\n"); 
		query.append("                    AND NVL(INLND_ROUT_BKG_FLG, 'N')  = 'Y'" ).append("\n"); 
		query.append("                    AND M.ROUT_ORG_NOD_CD             = N.NOD_CD" ).append("\n"); 
		query.append("                    AND M.ROUT_DEST_NOD_CD            = N1.NOD_CD" ).append("\n"); 
		query.append("                    AND  'OK' =   (CASE   WHEN @[f_inout] = 'I'  AND N.NOD_TP_CD IN ('M','B') AND @[f_group] = 'Door' AND N1.NOD_TP_CD ='Z' THEN 'OK' " ).append("\n"); 
		query.append("                                          WHEN @[f_inout] = 'I'  AND N.NOD_TP_CD IN ('M','B') AND @[f_group] = 'CY' AND N1.NOD_TP_CD <> 'Z' THEN 'OK' " ).append("\n"); 
		query.append("                                          WHEN @[f_inout] = 'O'  AND N1.NOD_TP_CD IN ('M','B') AND @[f_group] = 'Door' AND N.NOD_TP_CD ='Z' THEN 'OK' " ).append("\n"); 
		query.append("                                          WHEN @[f_inout] = 'O'  AND N1.NOD_TP_CD IN ('M','B') AND @[f_group] = 'CY' AND N.NOD_TP_CD <>'Z' THEN 'OK' ELSE 'XX'" ).append("\n"); 
		query.append("                                   END)" ).append("\n"); 
		query.append("               ORDER BY PRIO_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          WHERE ROWNUM = 1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("      ,LNK AS (" ).append("\n"); 
		query.append("         SELECT LNK_FM_NOD_CD" ).append("\n"); 
		query.append("              , LNK_TO_NOD_CD" ).append("\n"); 
		query.append("              , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , FULL_MTY_CD" ).append("\n"); 
		query.append("              , MAS_COST_SRC_CD" ).append("\n"); 
		query.append("              , COST_LOC_GRP_CD" ).append("\n"); 
		query.append("              , STND_COST_USD_AMT" ).append("\n"); 
		query.append("           FROM MAS_LNK_AVG_STND_COST A1" ).append("\n"); 
		query.append("              , LOC A2" ).append("\n"); 
		query.append("          WHERE COST_YRMON = CASE WHEN MAS_BZC_COST_YRMON_FNC('')<TO_CHAR(SYSDATE,'yyyymm') THEN MAS_BZC_COST_YRMON_FNC('') " ).append("\n"); 
		query.append("                                  ELSE TO_CHAR(SYSDATE, 'yyyymm') END" ).append("\n"); 
		query.append("            AND CNTR_TPSZ_CD  <> 'BOX'" ).append("\n"); 
		query.append("            AND LNK_FM_NOD_CD IN (A2.FM_LOC" ).append("\n"); 
		query.append("                                 ,A2.FM_ECC" ).append("\n"); 
		query.append("                                 ,A2.FM_LCC" ).append("\n"); 
		query.append("                                 ,A2.FM_RCC " ).append("\n"); 
		query.append("                                 ,A2.HUB_LOC" ).append("\n"); 
		query.append("                                 ,A2.HUB_ECC" ).append("\n"); 
		query.append("                                 ,A2.HUB_LCC" ).append("\n"); 
		query.append("                                 ,A2.HUB_RCC " ).append("\n"); 
		query.append("                                 ,A2.TO_LOC" ).append("\n"); 
		query.append("                                 ,A2.TO_ECC" ).append("\n"); 
		query.append("                                 ,A2.TO_LCC" ).append("\n"); 
		query.append("                                 ,A2.TO_RCC) " ).append("\n"); 
		query.append("            AND LNK_TO_NOD_CD IN (A2.FM_LOC" ).append("\n"); 
		query.append("                                 ,A2.FM_ECC" ).append("\n"); 
		query.append("                                 ,A2.FM_LCC" ).append("\n"); 
		query.append("                                 ,A2.FM_RCC " ).append("\n"); 
		query.append("                                 ,A2.HUB_LOC" ).append("\n"); 
		query.append("                                 ,A2.HUB_ECC" ).append("\n"); 
		query.append("                                 ,A2.HUB_LCC" ).append("\n"); 
		query.append("                                 ,A2.HUB_RCC " ).append("\n"); 
		query.append("                                 ,A2.TO_LOC" ).append("\n"); 
		query.append("                                 ,A2.TO_ECC" ).append("\n"); 
		query.append("                                 ,A2.TO_LCC" ).append("\n"); 
		query.append("                                 ,A2.TO_RCC " ).append("\n"); 
		query.append("                                 ) " ).append("\n"); 
		query.append("            AND ((FULL_MTY_CD = 'F' AND COST_LOC_GRP_CD = 'C' AND MAS_COST_SRC_CD IN ('TRLCRD','TRLCTD','TRDRTD','SCFURD','SCFUTD')) OR " ).append("\n"); 
		query.append("                 (FULL_MTY_CD = 'M' AND MAS_COST_SRC_CD IN ('TRMTRD','TRMTTD','SMFURD','SMFUTD')) )" ).append("\n"); 
		query.append("            AND (A1.CNTR_TPSZ_CD LIKE 'D%' )" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("         SELECT B1.LNK_FM_NOD_CD" ).append("\n"); 
		query.append("              , B1.LNK_TO_NOD_CD" ).append("\n"); 
		query.append("              , B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , B1.FULL_MTY_CD" ).append("\n"); 
		query.append("              , B1.MAS_COST_SRC_CD" ).append("\n"); 
		query.append("              , B1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("              , B1.STND_COST_USD_AMT" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (SELECT LNK_FM_NOD_CD" ).append("\n"); 
		query.append("                      , LNK_TO_NOD_CD" ).append("\n"); 
		query.append("                      , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , FULL_MTY_CD" ).append("\n"); 
		query.append("                      , MAS_COST_SRC_CD" ).append("\n"); 
		query.append("                      , COST_LOC_GRP_CD" ).append("\n"); 
		query.append("                      , STND_COST_USD_AMT" ).append("\n"); 
		query.append("                   FROM MAS_LNK_AVG_STND_COST A1" ).append("\n"); 
		query.append("                      , LOC A2" ).append("\n"); 
		query.append("                  WHERE COST_YRMON = CASE WHEN MAS_BZC_COST_YRMON_FNC('')<TO_CHAR(SYSDATE,'yyyymm') " ).append("\n"); 
		query.append("                                          THEN MAS_BZC_COST_YRMON_FNC('') ELSE TO_CHAR(SYSDATE,'yyyymm') END" ).append("\n"); 
		query.append("                    AND CNTR_TPSZ_CD  <> 'BOX'" ).append("\n"); 
		query.append("                    AND LNK_FM_NOD_CD IN (A2.FM_LOC" ).append("\n"); 
		query.append("                                         ,A2.FM_ECC" ).append("\n"); 
		query.append("                                         ,A2.FM_LCC" ).append("\n"); 
		query.append("                                         ,A2.FM_RCC " ).append("\n"); 
		query.append("                                         ,A2.HUB_LOC" ).append("\n"); 
		query.append("                                         ,A2.HUB_ECC" ).append("\n"); 
		query.append("                                         ,A2.HUB_LCC" ).append("\n"); 
		query.append("                                         ,A2.HUB_RCC " ).append("\n"); 
		query.append("                                         ,A2.TO_LOC" ).append("\n"); 
		query.append("                                         ,A2.TO_ECC" ).append("\n"); 
		query.append("                                         ,A2.TO_LCC" ).append("\n"); 
		query.append("                                         ,A2.TO_RCC) " ).append("\n"); 
		query.append("                    AND LNK_TO_NOD_CD IN (A2.FM_LOC" ).append("\n"); 
		query.append("                                         ,A2.FM_ECC" ).append("\n"); 
		query.append("                                         ,A2.FM_LCC" ).append("\n"); 
		query.append("                                         ,A2.FM_RCC " ).append("\n"); 
		query.append("                                         ,A2.HUB_LOC" ).append("\n"); 
		query.append("                                         ,A2.HUB_ECC" ).append("\n"); 
		query.append("                                         ,A2.HUB_LCC" ).append("\n"); 
		query.append("                                         ,A2.HUB_RCC " ).append("\n"); 
		query.append("                                         ,A2.TO_LOC" ).append("\n"); 
		query.append("                                         ,A2.TO_ECC" ).append("\n"); 
		query.append("                                         ,A2.TO_LCC" ).append("\n"); 
		query.append("                                         ,A2.TO_RCC " ).append("\n"); 
		query.append("                                         ) " ).append("\n"); 
		query.append("                    AND ((FULL_MTY_CD = 'F' AND COST_LOC_GRP_CD = 'C' AND MAS_COST_SRC_CD IN ('TRLCRD','TRLCTD','TRDRTD','SCFURD','SCFUTD')) OR " ).append("\n"); 
		query.append("                         (FULL_MTY_CD = 'M' AND MAS_COST_SRC_CD IN ('TRMTRD','TRMTTD','SMFURD','SMFUTD')) )" ).append("\n"); 
		query.append("                    AND A1.CNTR_TPSZ_CD IN ( '20', '40' )" ).append("\n"); 
		query.append("                ) B1" ).append("\n"); 
		query.append("              ,( SELECT DISTINCT SPCL_CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   FROM MAS_SPCL_REPO_CNTR_RGST" ).append("\n"); 
		query.append("                  WHERE SPCL_CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n"); 
		query.append("                    AND SPCL_CNTR_TPSZ_CD NOT LIKE 'RD_'" ).append("\n"); 
		query.append("                    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND SPCL_CNTR_TPSZ_CD LIKE 'D%'" ).append("\n"); 
		query.append("                ) B2" ).append("\n"); 
		query.append("          WHERE SUBSTR(B1.CNTR_TPSZ_CD,1,1) = DECODE(SUBSTR(B2.CNTR_TPSZ_CD,-1),'2','2','3','2','4')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" SELECT BOUND" ).append("\n"); 
		query.append("      , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , FM_LOC" ).append("\n"); 
		query.append("      , HUB_LOC" ).append("\n"); 
		query.append("      , TO_LOC" ).append("\n"); 
		query.append("      , TTL_COST" ).append("\n"); 
		query.append("      , R_AMT" ).append("\n"); 
		query.append("      , T_AMT" ).append("\n"); 
		query.append("      , M_AMT" ).append("\n"); 
		query.append("      , R_RMK" ).append("\n"); 
		query.append("      , T_RMK" ).append("\n"); 
		query.append("      , M_RMK" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT DECODE(@[f_inout],'I','I/B','O','O/B') AS BOUND" ).append("\n"); 
		query.append("              , E1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , E1.FM_LOC" ).append("\n"); 
		query.append("              , E1.HUB_LOC" ).append("\n"); 
		query.append("              , E1.TO_LOC" ).append("\n"); 
		query.append("              , SUM(ROUND(NVL(DECODE(E1.HUB_LOC,NULL,0,E1.R_LOC_AMT),0),0)) --location 단가만 사용" ).append("\n"); 
		query.append("                +SUM(CASE WHEN @[f_group] ='CY' AND DECODE(@[f_inout],'I',E1.TO_LOC,'O',E1.FM_LOC) = E1.HUB_LOC THEN 0" ).append("\n"); 
		query.append("                         ELSE ROUND(NVL(E1.T_LOC_AMT,0),0)" ).append("\n"); 
		query.append("                    END) --location 단가만 사용" ).append("\n"); 
		query.append("                +SUM(CASE WHEN @[f_inout]  ='O' OR ( @[f_inout] = 'I' AND  @[f_group] ='Door' AND E1.HUB_LOC =NULL ) THEN 0" ).append("\n"); 
		query.append("                         ELSE ROUND(NVL(COALESCE(E1.M_LOC_AMT,E1.M_ECC_AMT,E1.M_LCC_AMT,E1.M_US_AMT,E1.M_RCC_AMT),0),0)" ).append("\n"); 
		query.append("                    END) --Mty는 level 관계 없음" ).append("\n"); 
		query.append("                AS TTL_COST" ).append("\n"); 
		query.append("              , SUM(ROUND(NVL(DECODE(E1.HUB_LOC,NULL,0,E1.R_LOC_AMT),0),0)) AS R_AMT" ).append("\n"); 
		query.append("              , MIN(DECODE(E1.HUB_LOC,NULL,'Y',NVL(E1.R_TRLCRD_FLG,'N'))) OVER (PARTITION BY E1.FM_LOC, E1.HUB_LOC, E1.TO_LOC)  ||" ).append("\n"); 
		query.append("                MIN(DECODE(E1.HUB_LOC,NULL,'Y',NVL(E1.R_SCFURD_FLG,'N'))) OVER (PARTITION BY E1.FM_LOC, E1.HUB_LOC, E1.TO_LOC)  || " ).append("\n"); 
		query.append("                MIN(CASE WHEN @[f_group] ='CY' AND DECODE(@[f_inout],'I',E1.TO_LOC,'O',E1.FM_LOC) = E1.HUB_LOC THEN 'Y'" ).append("\n"); 
		query.append("                         ELSE NVL(E1.T_TRCK_FLG,'N')" ).append("\n"); 
		query.append("                    END) OVER (PARTITION BY E1.FM_LOC, E1.HUB_LOC, E1.TO_LOC)  ||" ).append("\n"); 
		query.append("                MIN(CASE WHEN @[f_group] ='CY' AND DECODE(@[f_inout],'I',E1.TO_LOC,'O',E1.FM_LOC) = E1.HUB_LOC THEN 'Y'" ).append("\n"); 
		query.append("                         ELSE NVL(E1.T_SCFUTD_FLG,'N')" ).append("\n"); 
		query.append("                    END) OVER (PARTITION BY E1.FM_LOC, E1.HUB_LOC, E1.TO_LOC) COST_CHECK " ).append("\n"); 
		query.append("              , SUM(CASE WHEN @[f_group] ='CY' AND DECODE(@[f_inout],'I',E1.TO_LOC,'O',E1.FM_LOC) = E1.HUB_LOC THEN 0" ).append("\n"); 
		query.append("                         ELSE ROUND(NVL(E1.T_LOC_AMT,0),0)" ).append("\n"); 
		query.append("                    END) AS T_AMT" ).append("\n"); 
		query.append("              , SUM(CASE WHEN @[f_inout]  ='O' OR ( @[f_inout] = 'I' AND  @[f_group] ='Door' AND E1.HUB_LOC =NULL ) THEN 0" ).append("\n"); 
		query.append("                         ELSE ROUND(NVL(COALESCE(E1.M_LOC_AMT,E1.M_ECC_AMT,E1.M_LCC_AMT,E1.M_US_AMT,E1.M_RCC_AMT),0),0)" ).append("\n"); 
		query.append("                    END) AS M_AMT" ).append("\n"); 
		query.append("              , MAX(CASE WHEN NVL(E1.R_LOC_AMT,0) <> 0 THEN 'Location' END) AS R_RMK " ).append("\n"); 
		query.append("              , MAX(CASE WHEN NVL(E1.T_LOC_AMT,0) <> 0 THEN 'Location' END) AS T_RMK " ).append("\n"); 
		query.append("              , MAX(CASE WHEN NVL(E1.M_LOC_AMT,0) <> 0 THEN 'Location' " ).append("\n"); 
		query.append("                         WHEN NVL(E1.M_ECC_AMT,0) <> 0 THEN 'ECC' " ).append("\n"); 
		query.append("                         WHEN NVL(E1.M_LCC_AMT,0) <> 0 THEN 'LCC' " ).append("\n"); 
		query.append("                         WHEN NVL(E1.M_US_AMT,0) <> 0 THEN '80% of Full' " ).append("\n"); 
		query.append("                         WHEN NVL(E1.M_RCC_AMT,0) <> 0 THEN 'RCC' END) AS M_RMK " ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (SELECT D1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , D1.FM_LOC" ).append("\n"); 
		query.append("                      , D1.HUB_LOC" ).append("\n"); 
		query.append("                      , D1.TO_LOC" ).append("\n"); 
		query.append("                        ---> ANALYTIC FUNCTION" ).append("\n"); 
		query.append("                      , MAX(SUM(D1.R_LOC_AMT)) OVER (PARTITION BY D1.FM_LOC, D1.HUB_LOC, D1.TO_LOC ORDER BY D1.CNTR_TPSZ_CD ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  AS R_LOC_AMT" ).append("\n"); 
		query.append("                      , MAX(R_TRLCRD_FLG) AS R_TRLCRD_FLG" ).append("\n"); 
		query.append("                      , MAX(R_SCFURD_FLG) AS R_SCFURD_FLG" ).append("\n"); 
		query.append("                      , MAX(SUM(D1.T_LOC_AMT)) OVER (PARTITION BY D1.FM_LOC, D1.HUB_LOC, D1.TO_LOC ORDER BY D1.CNTR_TPSZ_CD ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  AS T_LOC_AMT" ).append("\n"); 
		query.append("                      , MAX(T_TRCK_FLG) AS T_TRCK_FLG" ).append("\n"); 
		query.append("                      , MAX(T_SCFUTD_FLG ) AS T_SCFUTD_FLG" ).append("\n"); 
		query.append("                      , MAX(SUM(D1.M_LOC_AMT)) OVER (PARTITION BY D1.FM_LOC, D1.HUB_LOC, D1.TO_LOC ORDER BY D1.CNTR_TPSZ_CD ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  AS M_LOC_AMT" ).append("\n"); 
		query.append("                      , MAX(SUM(D1.M_ECC_AMT)) OVER (PARTITION BY D1.FM_LOC, D1.HUB_LOC, D1.TO_LOC ORDER BY D1.CNTR_TPSZ_CD ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  AS M_ECC_AMT" ).append("\n"); 
		query.append("                      , MAX(SUM(D1.M_LCC_AMT)) OVER (PARTITION BY D1.FM_LOC, D1.HUB_LOC, D1.TO_LOC ORDER BY D1.CNTR_TPSZ_CD ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  AS M_LCC_AMT" ).append("\n"); 
		query.append("                      , MAX(SUM(D1.M_US_AMT)) OVER (PARTITION BY D1.FM_LOC, D1.HUB_LOC, D1.TO_LOC ORDER BY D1.CNTR_TPSZ_CD ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)   AS M_US_AMT" ).append("\n"); 
		query.append("                      , MAX(SUM(D1.M_RCC_AMT)) OVER (PARTITION BY D1.FM_LOC, D1.HUB_LOC, D1.TO_LOC ORDER BY D1.CNTR_TPSZ_CD ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  AS M_RCC_AMT" ).append("\n"); 
		query.append("                      , MAX(M_TRMT_FLG) AS M_TRMT_FLG" ).append("\n"); 
		query.append("                      , MAX(M_SCMT_FLG) AS M_SCMT_FLG" ).append("\n"); 
		query.append("                   FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                         SELECT A2.FM_LOC" ).append("\n"); 
		query.append("                              , A2.HUB_LOC" ).append("\n"); 
		query.append("                              , A2.TO_LOC" ).append("\n"); 
		query.append("                              , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              , SUM(STND_COST_USD_AMT)                       AS R_LOC_AMT" ).append("\n"); 
		query.append("                              , MAX(DECODE(A1.MAS_COST_SRC_CD,'TRLCRD','Y')) AS R_TRLCRD_FLG" ).append("\n"); 
		query.append("                              , MAX(DECODE(A1.MAS_COST_SRC_CD,'SCFURD','Y')) AS R_SCFURD_FLG" ).append("\n"); 
		query.append("                              , NULL                                         AS T_LOC_AMT" ).append("\n"); 
		query.append("                              , NULL                                         AS T_TRCK_FLG" ).append("\n"); 
		query.append("                              , NULL                                         AS T_SCFUTD_FLG" ).append("\n"); 
		query.append("                              , NULL                                         AS M_LOC_AMT" ).append("\n"); 
		query.append("                              , NULL                                         AS M_ECC_AMT" ).append("\n"); 
		query.append("                              , NULL                                         AS M_LCC_AMT" ).append("\n"); 
		query.append("                              , NULL                                         AS M_US_AMT" ).append("\n"); 
		query.append("                              , NULL                                         AS M_RCC_AMT" ).append("\n"); 
		query.append("                              , NULL                                         AS M_TRMT_FLG" ).append("\n"); 
		query.append("                              , NULL                                         AS M_SCMT_FLG" ).append("\n"); 
		query.append("                           FROM LNK A1" ).append("\n"); 
		query.append("                              , LOC A2" ).append("\n"); 
		query.append("                          WHERE A1.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("                            AND A1.MAS_COST_SRC_CD IN ('TRLCRD','SCFURD')" ).append("\n"); 
		query.append("                            AND A1.LNK_FM_NOD_CD || A1.LNK_TO_NOD_CD " ).append("\n"); 
		query.append("                                IN ( CASE WHEN A2.ISHUB = 'Y' THEN DECODE(A2.INOUT,'I', A2.FM_LOC, 'O', A2.HUB_LOC) END " ).append("\n"); 
		query.append("                                  || CASE WHEN A2.ISHUB = 'Y' THEN DECODE(A2.INOUT,'I', A2.HUB_LOC,'O', A2.TO_LOC) END )" ).append("\n"); 
		query.append("                       GROUP BY A2.FM_LOC" ).append("\n"); 
		query.append("                              , A2.HUB_LOC" ).append("\n"); 
		query.append("                              , A2.TO_LOC" ).append("\n"); 
		query.append("                              , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                         SELECT A2.FM_LOC" ).append("\n"); 
		query.append("                              , A2.HUB_LOC" ).append("\n"); 
		query.append("                              , A2.TO_LOC" ).append("\n"); 
		query.append("                              , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              , NULL                                                                   AS R_LOC_AMT" ).append("\n"); 
		query.append("                              , NULL                                                                   AS R_TRLCRD_FLG" ).append("\n"); 
		query.append("                              , NULL                                                                   AS R_SCFURD_FLG" ).append("\n"); 
		query.append("                              , NULL                                                                   AS T_LOC_AMT" ).append("\n"); 
		query.append("                              , NULL                                                                   AS T_TRCK_FLG" ).append("\n"); 
		query.append("                              , NULL                                                                   AS T_SCFUTD_FLG" ).append("\n"); 
		query.append("                              , NULL                                                                   AS M_LOC_AMT" ).append("\n"); 
		query.append("                              , NULL                                                                   AS M_ECC_AMT" ).append("\n"); 
		query.append("                              , NULL                                                                   AS M_LCC_AMT" ).append("\n"); 
		query.append("                              , SUM(CASE WHEN A1.COST_LOC_GRP_CD = 'C' THEN STND_COST_USD_AMT END)*0.8 AS M_US_AMT" ).append("\n"); 
		query.append("                              , NULL                                                                   AS M_RCC_AMT" ).append("\n"); 
		query.append("                              , NULL                                                                   AS M_TRMT_FLG" ).append("\n"); 
		query.append("                              , NULL                                                                   AS M_SCMT_FLG" ).append("\n"); 
		query.append("                           FROM LNK A1" ).append("\n"); 
		query.append("                              , LOC A2" ).append("\n"); 
		query.append("                          WHERE A1.FULL_MTY_CD      = 'F'" ).append("\n"); 
		query.append("                            AND A1.MAS_COST_SRC_CD IN('TRLCRD', 'SCFURD')" ).append("\n"); 
		query.append("                            AND A1.COST_LOC_GRP_CD  = 'C'" ).append("\n"); 
		query.append("                            AND A1.LNK_FM_NOD_CD    = CASE WHEN A2.ISHUB = 'Y' AND A2.INOUT = 'I' THEN A2.HUB_LOC ELSE 'ZZ' END" ).append("\n"); 
		query.append("                            AND A1.LNK_TO_NOD_CD    = CASE WHEN A2.ISHUB = 'Y' AND A2.INOUT = 'I' THEN A2.FM_LOC  ELSE 'ZZ' END" ).append("\n"); 
		query.append("                       GROUP BY A2.FM_LOC" ).append("\n"); 
		query.append("                              , A2.HUB_LOC" ).append("\n"); 
		query.append("                              , A2.TO_LOC" ).append("\n"); 
		query.append("                              , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                         SELECT C1.FM_LOC" ).append("\n"); 
		query.append("                              , C1.HUB_LOC" ).append("\n"); 
		query.append("                              , C1.TO_LOC" ).append("\n"); 
		query.append("                              , C1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              , NULL              AS R_LOC_AMT" ).append("\n"); 
		query.append("                              , NULL              AS R_TRLCRD_FLG" ).append("\n"); 
		query.append("                              , NULL              AS R_SCFURD_FLG" ).append("\n"); 
		query.append("                              , SUM(C1.T_LOC_AMT) AS T_LOC_AMT" ).append("\n"); 
		query.append("                              , MAX(T_TRCK_FLG)   AS T_TRCK_FLG" ).append("\n"); 
		query.append("                              , MAX(T_SCFUTD_FLG) AS T_SCFUTD_FLG" ).append("\n"); 
		query.append("                              , NULL              AS M_LOC_AMT" ).append("\n"); 
		query.append("                              , NULL              AS M_ECC_AMT" ).append("\n"); 
		query.append("                              , NULL              AS M_LCC_AMT" ).append("\n"); 
		query.append("                              , NULL              AS M_US_AMT" ).append("\n"); 
		query.append("                              , NULL              AS M_RCC_AMT" ).append("\n"); 
		query.append("                              , NULL              AS M_TRMT_FLG" ).append("\n"); 
		query.append("                              , NULL              AS M_SCMT_FLG" ).append("\n"); 
		query.append("                           FROM" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                 SELECT A2.FM_LOC" ).append("\n"); 
		query.append("                                      , A2.HUB_LOC" ).append("\n"); 
		query.append("                                      , A2.TO_LOC" ).append("\n"); 
		query.append("                                      , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      , SUM(CASE WHEN A2.INOUT = 'I' AND @[f_group] = 'CY' AND A2.ISHUB = 'Y' AND A2.HUB_NOD = A2.TO_NOD THEN NULL " ).append("\n"); 
		query.append("                                                 WHEN A2.INOUT = 'O' AND @[f_group] = 'CY' AND A2.ISHUB = 'Y' AND A2.HUB_NOD = A2.FM_NOD THEN NULL " ).append("\n"); 
		query.append("                                                 ELSE STND_COST_USD_AMT END) AS T_LOC_AMT" ).append("\n"); 
		query.append("                                      , MAX(DECODE(A1.MAS_COST_SRC_CD,DECODE(@[f_group],'CY','TRLCTD','Door','TRDRTD'),'Y')) AS T_TRCK_FLG" ).append("\n"); 
		query.append("                                      , NULL AS T_SCFUTD_FLG" ).append("\n"); 
		query.append("                                   FROM LNK A1" ).append("\n"); 
		query.append("                                      , LOC A2" ).append("\n"); 
		query.append("                                  WHERE A1.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("                                    AND A1.MAS_COST_SRC_CD = DECODE(@[f_group],'CY','TRLCTD','Door','TRDRTD')" ).append("\n"); 
		query.append("                                    AND A1.LNK_FM_NOD_CD || A1.LNK_TO_NOD_CD " ).append("\n"); 
		query.append("                                        IN ( CASE WHEN A2.ISHUB = 'Y' THEN DECODE(A2.INOUT,'I', A2.HUB_LOC, 'O', A2.FM_LOC) WHEN A2.ISHUB = 'N' THEN A2.FM_LOC END" ).append("\n"); 
		query.append("                                          || CASE WHEN A2.ISHUB = 'Y' THEN DECODE(A2.INOUT,'I', A2.TO_LOC, 'O', A2.HUB_LOC) WHEN A2.ISHUB = 'N' THEN A2.TO_LOC END )" ).append("\n"); 
		query.append("                               GROUP BY A2.FM_LOC" ).append("\n"); 
		query.append("                                      , A2.HUB_LOC" ).append("\n"); 
		query.append("                                      , A2.TO_LOC" ).append("\n"); 
		query.append("                                      , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("                              UNION ALL" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                                 SELECT A2.FM_LOC" ).append("\n"); 
		query.append("                                      , A2.HUB_LOC" ).append("\n"); 
		query.append("                                      , A2.TO_LOC" ).append("\n"); 
		query.append("                                      , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      , SUM(CASE WHEN A2.INOUT = 'I' AND @[f_group] = 'CY' AND A2.ISHUB = 'Y' AND A2.HUB_NOD = A2.TO_NOD THEN NULL " ).append("\n"); 
		query.append("                                                 WHEN A2.INOUT = 'O' AND @[f_group] = 'CY' AND A2.ISHUB = 'Y' AND A2.HUB_NOD = A2.FM_NOD THEN NULL " ).append("\n"); 
		query.append("                                                 ELSE STND_COST_USD_AMT END) AS T_LOC_AMT" ).append("\n"); 
		query.append("                                      , NULL AS T_TRCK_FLG" ).append("\n"); 
		query.append("                                      , MAX(DECODE(A1.MAS_COST_SRC_CD,'SCFUTD','Y')) AS T_SCFUTD_FLG" ).append("\n"); 
		query.append("                                   from LNK A1" ).append("\n"); 
		query.append("                                      , LOC A2" ).append("\n"); 
		query.append("                                  WHERE A1.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("                                    AND A1.MAS_COST_SRC_CD = 'SCFUTD'" ).append("\n"); 
		query.append("                                    AND A1.LNK_FM_NOD_CD || A1.LNK_TO_NOD_CD" ).append("\n"); 
		query.append("                                        IN ( CASE WHEN A2.ISHUB = 'Y' THEN DECODE(A2.INOUT,'I', A2.HUB_LOC, 'O', A2.FM_LOC) WHEN A2.ISHUB = 'N' THEN A2.FM_LOC END" ).append("\n"); 
		query.append("                                          || CASE WHEN A2.ISHUB = 'Y' THEN DECODE(A2.INOUT,'I', A2.TO_LOC, 'O', A2.HUB_LOC) WHEN A2.ISHUB = 'N' THEN A2.TO_LOC END)" ).append("\n"); 
		query.append("                               GROUP BY A2.FM_LOC" ).append("\n"); 
		query.append("                                      , A2.HUB_LOC" ).append("\n"); 
		query.append("                                      , A2.TO_LOC" ).append("\n"); 
		query.append("                                      , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                ) C1" ).append("\n"); 
		query.append("                       GROUP BY C1.FM_LOC" ).append("\n"); 
		query.append("                              , C1.HUB_LOC" ).append("\n"); 
		query.append("                              , C1.TO_LOC" ).append("\n"); 
		query.append("                              , C1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("						 SELECT FM_LOC" ).append("\n"); 
		query.append("							  , HUB_LOC" ).append("\n"); 
		query.append("							  , TO_LOC" ).append("\n"); 
		query.append("							  , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("							  , NULL AS R_LOC_AMT" ).append("\n"); 
		query.append("							  , NULL AS R_TRLCRD_FLG" ).append("\n"); 
		query.append("							  , NULL AS R_SCFURD_FLG" ).append("\n"); 
		query.append("							  , NULL AS T_LOC_AMT" ).append("\n"); 
		query.append("							  , NULL AS T_TRCK_FLG" ).append("\n"); 
		query.append("							  , NULL AS T_SCFUTD_FLG" ).append("\n"); 
		query.append("							  , SUM(M_LOC_AMT)  AS M_LOC_AMT" ).append("\n"); 
		query.append("							  , SUM(M_ECC_AMT)  AS M_ECC_AMT" ).append("\n"); 
		query.append("							  , SUM(M_LCC_AMT)  AS M_LCC_AMT" ).append("\n"); 
		query.append("							  , NULL AS M_US_AMT" ).append("\n"); 
		query.append("							  , SUM(M_RCC_AMT)  AS M_RCC_AMT" ).append("\n"); 
		query.append("							  , MAX(M_TRMT_FLG) AS M_TRMT_FLG" ).append("\n"); 
		query.append("							  , MAX(M_SCMT_FLG) AS M_SCMT_FLG" ).append("\n"); 
		query.append("						   FROM" ).append("\n"); 
		query.append("								(SELECT A2.FM_LOC" ).append("\n"); 
		query.append("									  , A2.HUB_LOC" ).append("\n"); 
		query.append("									  , A2.TO_LOC" ).append("\n"); 
		query.append("									  , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("									  , (CASE WHEN A1.COST_LOC_GRP_CD = 'C' THEN A1. STND_COST_USD_AMT END)     AS M_LOC_AMT" ).append("\n"); 
		query.append("									  , (CASE WHEN A1.COST_LOC_GRP_CD = 'E' THEN A1. STND_COST_USD_AMT END)     AS M_ECC_AMT" ).append("\n"); 
		query.append("									  , (CASE WHEN A1.COST_LOC_GRP_CD = 'L' THEN A1. STND_COST_USD_AMT END)     AS M_LCC_AMT" ).append("\n"); 
		query.append("									  , (CASE WHEN A1.COST_LOC_GRP_CD = 'R' THEN A1. STND_COST_USD_AMT END)     AS M_RCC_AMT" ).append("\n"); 
		query.append("									  , DECODE(A1.MAS_COST_SRC_CD,DECODE(A2.ISHUB,'Y', 'TRMTRD', 'TRMTTD'),'Y') AS M_TRMT_FLG" ).append("\n"); 
		query.append("									  , DECODE(A1.MAS_COST_SRC_CD,DECODE(A2.ISHUB,'Y', 'SMFURD', 'SMFUTD'),'Y') AS M_SCMT_FLG" ).append("\n"); 
		query.append("								   FROM LNK A1" ).append("\n"); 
		query.append("									  , LOC A2" ).append("\n"); 
		query.append("								  WHERE A1.FULL_MTY_CD  = 'M'" ).append("\n"); 
		query.append("									AND A1.MAS_COST_SRC_CD IN (DECODE(A2.ISHUB,'Y', 'TRMTRD', 'TRMTTD'), DECODE(A2.ISHUB,'Y', 'SMFURD', 'SMFUTD'))" ).append("\n"); 
		query.append("									AND A2.INOUT        = 'I'" ).append("\n"); 
		query.append("									AND A1.COST_LOC_GRP_CD || A1.LNK_FM_NOD_CD||A1.LNK_TO_NOD_CD                                     " ).append("\n"); 
		query.append("										IN ( 'C'|| CASE WHEN A2.ISHUB = 'Y' THEN A2.HUB_LOC  WHEN A2.ISHUB = 'N' AND @[f_group] = 'CY'  THEN A2.TO_LOC  ELSE '' END " ).append("\n"); 
		query.append("												|| CASE WHEN A2.ISHUB = 'Y' THEN A2.FM_LOC   WHEN A2.ISHUB = 'N' AND @[f_group] = 'CY'  THEN A2.FM_LOC ELSE ''  END " ).append("\n"); 
		query.append("										   ,'E' || CASE WHEN A2.ISHUB = 'Y' THEN A2.HUB_ECC  WHEN A2.ISHUB = 'N' AND @[f_group] = 'CY'  THEN A2.TO_LOC  ELSE '' END " ).append("\n"); 
		query.append("												|| CASE WHEN A2.ISHUB = 'Y' THEN A2.FM_ECC   WHEN A2.ISHUB = 'N' AND @[f_group] = 'CY'  THEN A2.FM_LOC  ELSE '' END " ).append("\n"); 
		query.append("										   ,'L' || CASE WHEN A2.ISHUB = 'Y' THEN A2.HUB_LCC  WHEN A2.ISHUB = 'N' AND @[f_group] = 'CY'  THEN A2.TO_LOC  ELSE '' END " ).append("\n"); 
		query.append("												|| CASE WHEN A2.ISHUB = 'Y' THEN A2.FM_LCC   WHEN A2.ISHUB = 'N' AND @[f_group] = 'CY'  THEN A2.FM_LOC ELSE ''  END " ).append("\n"); 
		query.append("										   ,'R' || CASE WHEN A2.ISHUB = 'Y' THEN A2.HUB_RCC  WHEN A2.ISHUB = 'N' AND @[f_group] = 'CY'  THEN A2.TO_LOC ELSE ''  END " ).append("\n"); 
		query.append("												|| CASE WHEN A2.ISHUB = 'Y' THEN A2.FM_RCC   WHEN A2.ISHUB = 'N' AND @[f_group] = 'CY'  THEN A2.FM_LOC ELSE ''  END " ).append("\n"); 
		query.append("										 ) " ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("					   GROUP BY FM_LOC" ).append("\n"); 
		query.append("							  , HUB_LOC" ).append("\n"); 
		query.append("							  , TO_LOC" ).append("\n"); 
		query.append("							  , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                        ) D1" ).append("\n"); 
		query.append("               GROUP BY D1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , D1.FM_LOC" ).append("\n"); 
		query.append("                      , D1.HUB_LOC" ).append("\n"); 
		query.append("                      , D1.TO_LOC" ).append("\n"); 
		query.append("                ) E1" ).append("\n"); 
		query.append("       GROUP BY E1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , E1.FM_LOC" ).append("\n"); 
		query.append("              , E1.HUB_LOC" ).append("\n"); 
		query.append("              , E1.TO_LOC" ).append("\n"); 
		query.append("              , E1.R_TRLCRD_FLG" ).append("\n"); 
		query.append("              , E1.R_SCFURD_FLG" ).append("\n"); 
		query.append("              , E1.T_TRCK_FLG" ).append("\n"); 
		query.append("              , E1.T_SCFUTD_FLG" ).append("\n"); 
		query.append("        )   " ).append("\n"); 
		query.append("      WHERE COST_CHECK ='YYYY'" ).append("\n"); 

	}
}
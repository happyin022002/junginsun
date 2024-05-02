/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOCreateBunkerTariffCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class NetworkCostDBDAOCreateBunkerTariffCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bunker Tariff 정보를 생성한다.
	  * [CHM-201111114-01] Creation 시 FO 단가가 0 인 것은 복사하지 않도록 로직 추가
	  * [CHM-201432939] 관리회계 개선 프로젝트 개발 요청 AVG FOIL, TRADE, SUB TRADE 추가
	  * </pre>
	  */
	public NetworkCostDBDAOCreateBunkerTariffCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreateBunkerTariffCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_BNK_TRF D1	" ).append("\n"); 
		query.append(" USING (		" ).append("\n"); 
		query.append("       SELECT  CREATE_YRMON AS COST_YRMON		" ).append("\n"); 
		query.append("              ,CREATE_WK AS COST_WK		" ).append("\n"); 
		query.append("              ,SLAN_CD		" ).append("\n"); 
		query.append("              ,RLANE_CD		" ).append("\n"); 
		query.append("              ,SLAN_DIR_CD		" ).append("\n"); 
		query.append("              ,VSL_CLSS_CAPA		" ).append("\n"); 
		query.append("              ,FOIL_CSM		" ).append("\n"); 
		query.append("              ,FOIL_UC_AMT		" ).append("\n"); 
		query.append("              ,FOIL_AMT		" ).append("\n"); 
		query.append("              ,DOIL_CSM		" ).append("\n"); 
		query.append("              ,DOIL_UC_AMT		" ).append("\n"); 
		query.append("              ,DOIL_AMT" ).append("\n"); 
		query.append("              ,TRD_CD      -- 2014.12.24 추가" ).append("\n"); 
		query.append("              ,SUB_TRD_CD  -- 2014.12.24 추가" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_DESC(D2 XPKMAS_BNK_TRF)*/" ).append("\n"); 
		query.append("                       SUM(D2.FOIL_CSM) / MAX(ROWNUM)" ).append("\n"); 
		query.append("                  FROM MAS_BNK_TRF D2" ).append("\n"); 
		query.append("                 WHERE D2.COST_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(D3.CREATE_YRMON,'YYYYMM'),-3),'YYYYMM') AND TO_CHAR(ADD_MONTHS(TO_DATE(D3.CREATE_YRMON,'YYYYMM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("                   AND D2.RLANE_CD      = D3.RLANE_CD" ).append("\n"); 
		query.append("                   AND D2.SLAN_DIR_CD   = D3.SLAN_DIR_CD" ).append("\n"); 
		query.append("                   AND D2.VSL_CLSS_CAPA = D3.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                   AND D2.FOIL_CSM      > 0" ).append("\n"); 
		query.append("               ) AS FOIL_AVG_CSM       		" ).append("\n"); 
		query.append("         FROM 		" ).append("\n"); 
		query.append("            (		" ).append("\n"); 
		query.append("            SELECT C1.COST_YRMON AS CREATE_YRMON		" ).append("\n"); 
		query.append("                  ,C1.COST_WK    AS CREATE_WK		" ).append("\n"); 
		query.append("                  ,C2.COST_YRMON AS SOURCE_YRMON		" ).append("\n"); 
		query.append("                  ,C2.COST_WK    AS SOURCE_WK		" ).append("\n"); 
		query.append("                  ,MAX(C2.COST_YRMON||C2.COST_WK) OVER (PARTITION BY C2.SLAN_CD, C2.RLANE_CD, C2.SLAN_DIR_CD, C2.VSL_CLSS_CAPA) MAX_COST_WK 		" ).append("\n"); 
		query.append("                  ,C2.SLAN_CD		" ).append("\n"); 
		query.append("                  ,C2.RLANE_CD		" ).append("\n"); 
		query.append("                  ,C2.SLAN_DIR_CD		" ).append("\n"); 
		query.append("                  ,C2.VSL_CLSS_CAPA		" ).append("\n"); 
		query.append("                  ,C2.FOIL_CSM		" ).append("\n"); 
		query.append("                  ,C2.FOIL_UC_AMT		" ).append("\n"); 
		query.append("                  ,C2.FOIL_AMT		" ).append("\n"); 
		query.append("                  ,C2.DOIL_CSM		" ).append("\n"); 
		query.append("                  ,C2.DOIL_UC_AMT		" ).append("\n"); 
		query.append("                  ,C2.DOIL_AMT" ).append("\n"); 
		query.append("                  ,C1.TRD_CD      -- 2014.12.24 추가" ).append("\n"); 
		query.append("                  ,C1.SUB_TRD_CD  -- 2014.12.24 추가		" ).append("\n"); 
		query.append("            FROM (		" ).append("\n"); 
		query.append("                  SELECT DISTINCT		" ).append("\n"); 
		query.append("                        B1.SLS_YRMON AS COST_YRMON		" ).append("\n"); 
		query.append("                       ,B1.COST_WK 		" ).append("\n"); 
		query.append("                       ,B1.SLAN_CD		" ).append("\n"); 
		query.append("                       ,B1.RLANE_CD		" ).append("\n"); 
		query.append("                       ,B1.DIR_CD		" ).append("\n"); 
		query.append("                       ,B2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                       ,B1.TRD_CD      -- 2014.12.24 추가" ).append("\n"); 
		query.append("                       ,B1.SUB_TRD_CD  -- 2014.12.24 추가" ).append("\n"); 
		query.append("                   FROM MAS_MON_VVD B1		" ).append("\n"); 
		query.append("                      ,(		" ).append("\n"); 
		query.append("                       SELECT A1.VSL_SEQ         VSL_SEQ		" ).append("\n"); 
		query.append("                             ,A1.VSL_CD          VSL_CD		" ).append("\n"); 
		query.append("                             ,A1.VSL_TP_CD       VSL_TP_CD		" ).append("\n"); 
		query.append("                             ,A1.VSL_OSHP_CD     VSL_OSHP_CD		" ).append("\n"); 
		query.append("                             ,A1.VOP_CD          VOP_CD                 		" ).append("\n"); 
		query.append("                             ,A1.VSL_CLSS_CAPA   VSL_CLSS_CAPA		" ).append("\n"); 
		query.append("                             ,A1.VSL_APLY_FM_DT  FM_DT		" ).append("\n"); 
		query.append("                             ,A1.VSL_APLY_TO_DT  TO_DT		" ).append("\n"); 
		query.append("                         FROM MAS_VSL_RGST A1		" ).append("\n"); 
		query.append("                        WHERE 1 = 1		" ).append("\n"); 
		query.append("                          AND NVL(A1.DELT_FLG, 'N') = 'N'		" ).append("\n"); 
		query.append("                      ) B2		" ).append("\n"); 
		query.append("                      ,MAS_LANE_RGST B3		" ).append("\n"); 
		query.append("                 WHERE B1.VSL_CD          = B2.VSL_CD		" ).append("\n"); 
		query.append("                   AND B1.TRD_CD          = B3.TRD_CD		" ).append("\n"); 
		query.append("                   AND B1.RLANE_CD        = B3.RLANE_CD		" ).append("\n"); 
		query.append("                   AND B1.IOC_CD          = B3.IOC_CD		" ).append("\n"); 
		query.append("                   AND B1.DIR_CD          = B3.DIR_CD		" ).append("\n"); 
		query.append("                   AND B1.SLS_YRMON      LIKE @[cost_yrmon]||'%'	" ).append("\n"); 
		query.append("                   AND B1.COST_WK          = @[cost_wk]		" ).append("\n"); 
		query.append("                   AND B1.DELT_FLG         = 'N'		" ).append("\n"); 
		query.append("            	   AND NVL(B3.DELT_FLG,'N')= 'N'	" ).append("\n"); 
		query.append("                   AND B2.VOP_CD           = 'SML'		" ).append("\n"); 
		query.append("                   AND B3.TRD_CD           <> 'COM'		" ).append("\n"); 
		query.append("                   AND B3.VSL_LANE_TP_CD   IN ('JO','SC')		" ).append("\n"); 
		query.append("                   AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')		" ).append("\n"); 
		query.append("                      BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')		" ).append("\n"); 
		query.append("                      AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("					  AND B1.SUB_TRD_CD <> 'IP'		" ).append("\n"); 
		query.append("                 ) C1		" ).append("\n"); 
		query.append("                 ,MAS_BNK_TRF C2		" ).append("\n"); 
		query.append("                 ,(SELECT PREV_WK_12, PREV_WK_1		" ).append("\n"); 
		query.append("                     FROM (		" ).append("\n"); 
		query.append("                           SELECT LAG (COST_YR || COST_WK, 12) OVER (ORDER BY COST_YR || COST_WK) AS PREV_WK_12		" ).append("\n"); 
		query.append("                                 ,LAG (COST_YR || COST_WK, 1) OVER (ORDER BY COST_YR || COST_WK) AS PREV_WK_1		" ).append("\n"); 
		query.append("                             FROM MAS_WK_PRD		" ).append("\n"); 
		query.append("                            WHERE COST_YR || COST_WK <= @[cost_yrmon] || @[cost_wk]		" ).append("\n"); 
		query.append("                         ORDER BY COST_YR || COST_WK DESC		" ).append("\n"); 
		query.append("                         )              		" ).append("\n"); 
		query.append("                    WHERE ROWNUM = 1) C3		" ).append("\n"); 
		query.append("            WHERE 1=1		" ).append("\n"); 
		query.append("              AND C1.SLAN_CD        = C2.SLAN_CD		" ).append("\n"); 
		query.append("              AND C1.RLANE_CD       = C2.RLANE_CD		" ).append("\n"); 
		query.append("              AND C1.DIR_CD         = C2.SLAN_DIR_CD		" ).append("\n"); 
		query.append("              AND C1.VSL_CLSS_CAPA  = C2.VSL_CLSS_CAPA		" ).append("\n"); 
		query.append("              AND SUBSTR(C2.COST_YRMON, 1, 4)||C2.COST_WK  BETWEEN PREV_WK_12 AND PREV_WK_1" ).append("\n"); 
		query.append("              AND C2.FOIL_UC_AMT >0) D3 -- 0 으로 생성된 단가는 복사하지 않음		" ).append("\n"); 
		query.append("        WHERE SOURCE_YRMON||SOURCE_WK = MAX_COST_WK		" ).append("\n"); 
		query.append("      ) D2		" ).append("\n"); 
		query.append("ON (		" ).append("\n"); 
		query.append("         D1.COST_YRMON    = D2.COST_YRMON		" ).append("\n"); 
		query.append("     AND D1.COST_WK       = D2.COST_WK		" ).append("\n"); 
		query.append("     AND D1.SLAN_CD       = D2.SLAN_CD		" ).append("\n"); 
		query.append("     AND D1.RLANE_CD      = D2.RLANE_CD		" ).append("\n"); 
		query.append("     AND D1.SLAN_DIR_CD   = D2.SLAN_DIR_CD		" ).append("\n"); 
		query.append("     AND D1.VSL_CLSS_CAPA = D2.VSL_CLSS_CAPA		" ).append("\n"); 
		query.append("    )		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("WHEN MATCHED THEN		" ).append("\n"); 
		query.append("      UPDATE		" ).append("\n"); 
		query.append("         SET  D1.FOIL_CSM      = D2.FOIL_CSM		" ).append("\n"); 
		query.append("             ,D1.FOIL_UC_AMT   = D2.FOIL_UC_AMT" ).append("\n"); 
		query.append("             ,D1.OLD_FOIL_UC_AMT   = D2.FOIL_UC_AMT" ).append("\n"); 
		query.append("             ,D1.FOIL_AMT      = D2.FOIL_AMT		" ).append("\n"); 
		query.append("             ,D1.DOIL_CSM      = D2.DOIL_CSM		" ).append("\n"); 
		query.append("             ,D1.DOIL_UC_AMT   = D2.DOIL_UC_AMT		" ).append("\n"); 
		query.append("             ,D1.DOIL_AMT      = D2.DOIL_AMT	" ).append("\n"); 
		query.append("             ,D1.UPD_USR_ID    = @[upd_usr_id]		" ).append("\n"); 
		query.append("             ,D1.UPD_DT        = SYSDATE             " ).append("\n"); 
		query.append("             ,D1.FOIL_AVG_CSM  = D2.FOIL_AVG_CSM -- 20141224 추가	" ).append("\n"); 
		query.append("             ,D1.TRD_CD        = D2.TRD_CD       -- 2014.12.24 추가" ).append("\n"); 
		query.append("             ,D1.SUB_TRD_CD    = D2.SUB_TRD_CD   -- 2014.12.24 추가		" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN		" ).append("\n"); 
		query.append("      INSERT(		" ).append("\n"); 
		query.append("             D1.COST_YRMON		" ).append("\n"); 
		query.append("            ,D1.COST_WK		" ).append("\n"); 
		query.append("            ,D1.SLAN_CD		" ).append("\n"); 
		query.append("            ,D1.RLANE_CD		" ).append("\n"); 
		query.append("            ,D1.SLAN_DIR_CD		" ).append("\n"); 
		query.append("            ,D1.VSL_CLSS_CAPA		" ).append("\n"); 
		query.append("            ,D1.FOIL_CSM		" ).append("\n"); 
		query.append("            ,D1.FOIL_UC_AMT	" ).append("\n"); 
		query.append("            ,D1.OLD_FOIL_UC_AMT	" ).append("\n"); 
		query.append("            ,D1.FOIL_AMT		" ).append("\n"); 
		query.append("            ,D1.DOIL_CSM		" ).append("\n"); 
		query.append("            ,D1.DOIL_UC_AMT		" ).append("\n"); 
		query.append("            ,D1.DOIL_AMT		" ).append("\n"); 
		query.append("            ,D1.CRE_USR_ID		" ).append("\n"); 
		query.append("            ,D1.CRE_DT		" ).append("\n"); 
		query.append("            ,D1.UPD_USR_ID		" ).append("\n"); 
		query.append("            ,D1.UPD_DT" ).append("\n"); 
		query.append("            ,D1.FOIL_AVG_CSM  -- 2014.12.24 추가" ).append("\n"); 
		query.append("            ,D1.TRD_CD        -- 2014.12.24 추가" ).append("\n"); 
		query.append("            ,D1.SUB_TRD_CD    -- 2014.12.24 추가		" ).append("\n"); 
		query.append("      )VALUES(		" ).append("\n"); 
		query.append("             D2.COST_YRMON		" ).append("\n"); 
		query.append("            ,D2.COST_WK		" ).append("\n"); 
		query.append("            ,D2.SLAN_CD		" ).append("\n"); 
		query.append("            ,D2.RLANE_CD		" ).append("\n"); 
		query.append("            ,D2.SLAN_DIR_CD		" ).append("\n"); 
		query.append("            ,D2.VSL_CLSS_CAPA		" ).append("\n"); 
		query.append("            ,D2.FOIL_CSM		" ).append("\n"); 
		query.append("            ,D2.FOIL_UC_AMT" ).append("\n"); 
		query.append("            ,D2.FOIL_UC_AMT		" ).append("\n"); 
		query.append("            ,D2.FOIL_AMT		" ).append("\n"); 
		query.append("            ,D2.DOIL_CSM		" ).append("\n"); 
		query.append("            ,D2.DOIL_UC_AMT		" ).append("\n"); 
		query.append("            ,D2.DOIL_AMT		" ).append("\n"); 
		query.append("            ,@[cre_usr_id]		" ).append("\n"); 
		query.append("            ,SYSDATE		" ).append("\n"); 
		query.append("            ,@[upd_usr_id]		" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,D2.FOIL_AVG_CSM -- 20141224 추가" ).append("\n"); 
		query.append("            ,D2.TRD_CD       -- 2014.12.24 추가" ).append("\n"); 
		query.append("            ,D2.SUB_TRD_CD   -- 2014.12.24 추가		" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}
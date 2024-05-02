/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchEqFcstDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchEqFcstDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Projection Detail
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchEqFcstDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchEqFcstDetailRSQL").append("\n"); 
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
		query.append("WITH DUMMY_DATA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT A.FCAST_YRWK WEEK" ).append("\n"); 
		query.append("              ,A.BSE_DT  -- 20141202 신규추가          " ).append("\n"); 
		query.append("              ,A.CNTR_PKUP_SCC_CD" ).append("\n"); 
		query.append("              ,A.RLANE_CD   " ).append("\n"); 
		query.append("              ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              ,A.SLS_OFC_CD" ).append("\n"); 
		query.append("              ,A.POL_ECC_CD" ).append("\n"); 
		query.append("              ,A.POL_ETB_DT" ).append("\n"); 
		query.append("              ,A.FCAST_TTL_QTY" ).append("\n"); 
		query.append("              ,SUM(NVL(A.D2_FCAST_QTY,0)+NVL(A.D4_FCAST_QTY,0)+NVL(A.D5_FCAST_QTY,0)+NVL(A.D7_FCAST_QTY,0)) TOTAL_QTY" ).append("\n"); 
		query.append("              ,SUM(NVL(A.D2_FCAST_QTY,0)) D2_QTY" ).append("\n"); 
		query.append("              ,SUM(NVL(A.D4_FCAST_QTY,0)) D4_QTY" ).append("\n"); 
		query.append("              ,SUM(NVL(A.D5_FCAST_QTY,0)) D5_QTY" ).append("\n"); 
		query.append("              ,SUM(NVL(A.D7_FCAST_QTY,0)) D7_QTY" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,A.AVG_TT_DYS " ).append("\n"); 
		query.append("              ,A.D2_FCAST_RTO " ).append("\n"); 
		query.append("              ,A.D4_FCAST_RTO" ).append("\n"); 
		query.append("              ,A.D5_FCAST_RTO" ).append("\n"); 
		query.append("              ,A.D7_FCAST_RTO           " ).append("\n"); 
		query.append("              ,A.OTR_FCAST_RTO" ).append("\n"); 
		query.append("              ,A.RN ROW_SEQ  -- 20141202 신규추가" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            -- 20141211 수정" ).append("\n"); 
		query.append("            --SELECT ROW_NUMBER() OVER(PARTITION BY A.FCAST_YRWK, A.RLANE_CD, A.SLS_OFC_CD, A.POL_ECC_CD, A.CNTR_PKUP_SCC_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD ORDER BY A.BSE_DT DESC  ) AS RN" ).append("\n"); 
		query.append("            SELECT /*+ NO_MERGE(B) */ DENSE_RANK() OVER(PARTITION BY A.RLANE_CD, A.SLS_OFC_CD, A.POL_ECC_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD ORDER BY A.BSE_DT DESC  ) AS RN" ).append("\n"); 
		query.append("                  ,A.FCAST_YRWK" ).append("\n"); 
		query.append("                  ,A.RLANE_CD" ).append("\n"); 
		query.append("                  ,A.SLS_OFC_CD" ).append("\n"); 
		query.append("                  ,A.POL_ECC_CD" ).append("\n"); 
		query.append("                  ,A.CNTR_PKUP_SCC_CD" ).append("\n"); 
		query.append("                  ,A.VSL_CD" ).append("\n"); 
		query.append("                  ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,A.SKD_DIR_CD              " ).append("\n"); 
		query.append("                  ,A.BSE_DT" ).append("\n"); 
		query.append("                  ,A.POL_ETB_DT" ).append("\n"); 
		query.append("                  ,A.AVG_TT_DYS" ).append("\n"); 
		query.append("                  ,A.FCAST_TTL_QTY" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                  ,A.D2_FCAST_QTY" ).append("\n"); 
		query.append("                  ,A.D4_FCAST_QTY" ).append("\n"); 
		query.append("                  ,A.D5_FCAST_QTY" ).append("\n"); 
		query.append("                  ,A.D7_FCAST_QTY" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                  ,A.D2_FCAST_RTO" ).append("\n"); 
		query.append("                  ,A.D4_FCAST_RTO" ).append("\n"); 
		query.append("                  ,A.D5_FCAST_RTO" ).append("\n"); 
		query.append("                  ,A.D7_FCAST_RTO" ).append("\n"); 
		query.append("                  ,A.OTR_FCAST_RTO" ).append("\n"); 
		query.append("                  ,A.EQ_FCAST_RTO_LVL_CD -- 20141216 신규추가" ).append("\n"); 
		query.append("            FROM  EQR_CTRL_OB_FCAST_SNAP A" ).append("\n"); 
		query.append("                 ,(" ).append("\n"); 
		query.append("                     SELECT DISTINCT RLANE_CD, SLS_OFC_CD, POL_ECC_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                     FROM EQR_CTRL_OB_FCAST_SNAP " ).append("\n"); 
		query.append("                     WHERE FCAST_YRWK BETWEEN @[fm_week] AND @[to_week]" ).append("\n"); 
		query.append("		         #if(${rlane_cd} != '')" ).append("\n"); 
		query.append("		             AND   RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("		         #end" ).append("\n"); 
		query.append("                     AND   EQ_FCAST_RTO_LVL_CD NOT IN (0, 9)" ).append("\n"); 
		query.append("                  ) B            " ).append("\n"); 
		query.append("            -- 20141216 신규추가" ).append("\n"); 
		query.append("            WHERE A.RLANE_CD   = B.RLANE_CD  " ).append("\n"); 
		query.append("            AND   A.SLS_OFC_CD = B.SLS_OFC_CD" ).append("\n"); 
		query.append("            AND   A.POL_ECC_CD = B.POL_ECC_CD" ).append("\n"); 
		query.append("            AND   A.VSL_CD     = B.VSL_CD " ).append("\n"); 
		query.append("            AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND   A.SKD_DIR_CD = B.SKD_DIR_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND   A.EQ_FCAST_RTO_LVL_CD NOT IN (0, 9) -- 0 은 RATIO와 연결되지 않음. " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("        -- 20141216 수정 " ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("              SELECT DISTINCT A.SCC_CD" ).append("\n"); 
		query.append("              FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("              #if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                 WHERE A.SCC_CD = @[loc_cd]  -- E:ECC, L:LCC, S:SCC " ).append("\n"); 
		query.append("              #elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                 WHERE A.ECC_CD = @[loc_cd]  -- E:ECC, L:LCC, S:SCC " ).append("\n"); 
		query.append("              #elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                 WHERE A.LCC_CD = @[loc_cd]  -- E:ECC, L:LCC, S:SCC " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("        -- 20141202 신규추가" ).append("\n"); 
		query.append("#if(${create_chk_box} != 'Y')" ).append("\n"); 
		query.append("        WHERE A.RN = 1   -- 모든데이터가 같고 BSE_DT 만 다른 것중 마지막 BSE_DT 를 꺼냅니다. (Create Date 체크 안되어 있으면)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        WHERE (A.RN = 1 OR A.RN BETWEEN @[fm_date] AND @[to_date])    -- Create Date 에 체크되면" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND A.FCAST_YRWK BETWEEN @[fm_week] AND @[to_week]  -- 팝업오픈 조건값" ).append("\n"); 
		query.append("        -- 20141215 신규추가" ).append("\n"); 
		query.append("#if(${rlane_cd} != '')" ).append("\n"); 
		query.append("        AND   A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND   A.EQ_FCAST_RTO_LVL_CD NOT IN (0, 9) -- 0 은 RATIO와 연결되지 않음." ).append("\n"); 
		query.append("        AND   A.CNTR_PKUP_SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        GROUP BY A.FCAST_YRWK" ).append("\n"); 
		query.append("              ,A.BSE_DT  -- 20141202 신규추가" ).append("\n"); 
		query.append("              ,A.CNTR_PKUP_SCC_CD" ).append("\n"); 
		query.append("              ,A.RLANE_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.SLS_OFC_CD" ).append("\n"); 
		query.append("              ,A.POL_ECC_CD" ).append("\n"); 
		query.append("              ,A.POL_ETB_DT" ).append("\n"); 
		query.append("              ,A.FCAST_TTL_QTY" ).append("\n"); 
		query.append("              ,A.AVG_TT_DYS" ).append("\n"); 
		query.append("              ,A.D2_FCAST_RTO" ).append("\n"); 
		query.append("              ,A.D4_FCAST_RTO" ).append("\n"); 
		query.append("              ,A.D5_FCAST_RTO" ).append("\n"); 
		query.append("              ,A.D7_FCAST_RTO" ).append("\n"); 
		query.append("              ,A.OTR_FCAST_RTO" ).append("\n"); 
		query.append("              ,A.RN   -- 20141202 신규추가" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT WEEK" ).append("\n"); 
		query.append("      ,BSE_DT -- 20141202 신규추가" ).append("\n"); 
		query.append("      ,CNTR_PKUP_SCC_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,SLS_OFC_CD" ).append("\n"); 
		query.append("      ,POL_ECC_CD" ).append("\n"); 
		query.append("      ,POL_ETB_DT" ).append("\n"); 
		query.append("      ,FCAST_TTL_QTY -- SALES PROJECTION" ).append("\n"); 
		query.append("      ,TOTAL_QTY     -- TOTAL BOX" ).append("\n"); 
		query.append("      ,D2_QTY" ).append("\n"); 
		query.append("      ,D4_QTY" ).append("\n"); 
		query.append("      ,D5_QTY" ).append("\n"); 
		query.append("      ,D7_QTY" ).append("\n"); 
		query.append("      ,AVG_TT_DYS    -- TURN TIME" ).append("\n"); 
		query.append("      ,D2_FCAST_RTO" ).append("\n"); 
		query.append("      ,D4_FCAST_RTO" ).append("\n"); 
		query.append("      ,D5_FCAST_RTO" ).append("\n"); 
		query.append("      ,D7_FCAST_RTO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(      " ).append("\n"); 
		query.append("    SELECT 1 RN" ).append("\n"); 
		query.append("          ,WEEK" ).append("\n"); 
		query.append("          ,BSE_DT " ).append("\n"); 
		query.append("          ,CNTR_PKUP_SCC_CD" ).append("\n"); 
		query.append("          ,RLANE_CD" ).append("\n"); 
		query.append("          ,VVD" ).append("\n"); 
		query.append("          ,SLS_OFC_CD" ).append("\n"); 
		query.append("          ,POL_ECC_CD" ).append("\n"); 
		query.append("          ,POL_ETB_DT" ).append("\n"); 
		query.append("          ,FCAST_TTL_QTY -- SALES PROJECTION" ).append("\n"); 
		query.append("          ,TOTAL_QTY     -- TOTAL BOX" ).append("\n"); 
		query.append("          ,D2_QTY" ).append("\n"); 
		query.append("          ,D4_QTY" ).append("\n"); 
		query.append("          ,D5_QTY" ).append("\n"); 
		query.append("          ,D7_QTY" ).append("\n"); 
		query.append("          ,AVG_TT_DYS    -- TURN TIME" ).append("\n"); 
		query.append("          ,D2_FCAST_RTO" ).append("\n"); 
		query.append("          ,D4_FCAST_RTO" ).append("\n"); 
		query.append("          ,D5_FCAST_RTO" ).append("\n"); 
		query.append("          ,D7_FCAST_RTO" ).append("\n"); 
		query.append("    FROM DUMMY_DATA    " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("    UNION ALL  " ).append("\n"); 
		query.append("    SELECT 1 RN" ).append("\n"); 
		query.append("          ,WEEK||' TOTAL'" ).append("\n"); 
		query.append("          ,NULL BSE_DT" ).append("\n"); 
		query.append("          ,NULL CNTR_PKUP_SCC_CD" ).append("\n"); 
		query.append("          ,NULL RLANE_CD" ).append("\n"); 
		query.append("          ,NULL VVD" ).append("\n"); 
		query.append("          ,NULL SLS_OFC_CD" ).append("\n"); 
		query.append("          ,NULL POL_ECC_CD" ).append("\n"); 
		query.append("          ,NULL POL_ETB_DT" ).append("\n"); 
		query.append("          ,NULL FCAST_TTL_QTY -- SALES PROJECTION" ).append("\n"); 
		query.append("          ,SUM(TOTAL_QTY)     -- TOTAL BOX" ).append("\n"); 
		query.append("          ,SUM(D2_QTY)" ).append("\n"); 
		query.append("          ,SUM(D4_QTY)" ).append("\n"); 
		query.append("          ,SUM(D5_QTY)" ).append("\n"); 
		query.append("          ,SUM(D7_QTY)" ).append("\n"); 
		query.append("          ,NULL AVG_TT_DYS    -- TURN TIME" ).append("\n"); 
		query.append("          ,NULL D2_FCAST_RTO" ).append("\n"); 
		query.append("          ,NULL D4_FCAST_RTO" ).append("\n"); 
		query.append("          ,NULL D5_FCAST_RTO" ).append("\n"); 
		query.append("          ,NULL D7_FCAST_RTO" ).append("\n"); 
		query.append("    FROM DUMMY_DATA" ).append("\n"); 
		query.append("    WHERE ROW_SEQ = 1" ).append("\n"); 
		query.append("    GROUP BY WEEK" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION ALL  " ).append("\n"); 
		query.append("    SELECT 0 RN" ).append("\n"); 
		query.append("          ,'TOTAL'" ).append("\n"); 
		query.append("          ,NULL BSE_DT" ).append("\n"); 
		query.append("          ,NULL CNTR_PKUP_SCC_CD" ).append("\n"); 
		query.append("          ,NULL RLANE_CD" ).append("\n"); 
		query.append("          ,NULL VVD" ).append("\n"); 
		query.append("          ,NULL SLS_OFC_CD" ).append("\n"); 
		query.append("          ,NULL POL_ECC_CD" ).append("\n"); 
		query.append("          ,NULL POL_ETB_DT" ).append("\n"); 
		query.append("          ,NULL FCAST_TTL_QTY -- SALES PROJECTION" ).append("\n"); 
		query.append("          ,SUM(TOTAL_QTY)     -- TOTAL BOX" ).append("\n"); 
		query.append("          ,SUM(D2_QTY)" ).append("\n"); 
		query.append("          ,SUM(D4_QTY)" ).append("\n"); 
		query.append("          ,SUM(D5_QTY)" ).append("\n"); 
		query.append("          ,SUM(D7_QTY)" ).append("\n"); 
		query.append("          ,NULL AVG_TT_DYS    -- TURN TIME" ).append("\n"); 
		query.append("          ,NULL D2_FCAST_RTO" ).append("\n"); 
		query.append("          ,NULL D4_FCAST_RTO" ).append("\n"); 
		query.append("          ,NULL D5_FCAST_RTO" ).append("\n"); 
		query.append("          ,NULL D7_FCAST_RTO" ).append("\n"); 
		query.append("    FROM DUMMY_DATA" ).append("\n"); 
		query.append("    WHERE ROW_SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- 20141202 신규추가" ).append("\n"); 
		query.append("ORDER BY RN||WEEK, CNTR_PKUP_SCC_CD, RLANE_CD, VVD, SLS_OFC_CD, POL_ECC_CD, BSE_DT -- Create Check Box 체크되면 표시" ).append("\n"); 

	}
}
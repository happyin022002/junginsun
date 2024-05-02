/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOSearchAddGuidelineConfigRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOSearchAddGuidelineConfigRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane으로 가장 빠른 VVD, ETA 조회
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOSearchAddGuidelineConfigRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOSearchAddGuidelineConfigRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_ASC(A XAK3VSK_VSL_PORT_SKD) */ " ).append("\n"); 
		query.append("       A.VSL_CD      " ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,A.VPS_PORT_CD                        POL_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.VPS_ETA_DT, 'YYYYMMDD')    EFF_ST_DT  -- HIDDEN" ).append("\n"); 
		query.append("      ,TO_CHAR(VPS_ETA_DT, 'MON-DD')    ETA_DT     -- 화면표현" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append(" WHERE A.SLAN_CD = SUBSTR(@[lane],6)       -- 입력값" ).append("\n"); 
		query.append("   AND A.VPS_ETA_DT > SYSDATE  -- 선택한 Lane의 아시아 항 Bound에서 First Calling POL의 ETA가 현재시점에서 가장 가까운 VVD" ).append("\n"); 
		query.append("   AND A.CLPT_SEQ = 1  -- first Calling" ).append("\n"); 
		query.append("-- DIRECTION 결정 쿼리" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD IN (" ).append("\n"); 
		query.append("                        SELECT VSL_SLAN_DIR_CD " ).append("\n"); 
		query.append("                        FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("                        WHERE TRD_CD                 = @[trade] -- TRADE" ).append("\n"); 
		query.append("                        AND   SUB_TRD_CD             = SUBSTR(@[subtrade],4,2)  -- SUB TRADE" ).append("\n"); 
		query.append("                        AND   SUBSTR(RLANE_CD, 0, 3) = SUBSTR(@[lane],6) -- LANE" ).append("\n"); 
		query.append("                        AND   TO_CONTI_CD            = 'A'   -- 하드코딩, TO ASIA" ).append("\n"); 
		query.append("                        AND   DELT_FLG               = 'N'   -- 하드코딩" ).append("\n"); 
		query.append("                        AND   ROWNUM                 = 1" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("   AND ROWNUM = 1              -- 하드코딩" ).append("\n"); 

	}
}
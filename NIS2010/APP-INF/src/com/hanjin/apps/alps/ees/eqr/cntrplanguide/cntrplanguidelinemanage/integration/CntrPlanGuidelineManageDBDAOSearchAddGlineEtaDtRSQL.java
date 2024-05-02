/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOSearchAddGlineEtaDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOSearchAddGlineEtaDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOSearchAddGlineEtaDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOSearchAddGlineEtaDtRSQL").append("\n"); 
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
		query.append("       TO_CHAR(VPS_ETA_DT, 'MON-DD')    	ETA_DT     -- 화면표현" ).append("\n"); 
		query.append("      ,TO_CHAR(A.VPS_ETA_DT, 'YYYYMMDD')    EFF_ST_DT  -- HIDDEN" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append(" --WHERE A.SLAN_CD       = SUBSTR([lane],6)	" ).append("\n"); 
		query.append(" WHERE A.SLAN_CD       = @[lane]			        -- 입력값" ).append("\n"); 
		query.append("   AND VSL_CD          = SUBSTR(@[s_vvd_cd], 0, 4)  -- VVD 변수" ).append("\n"); 
		query.append("   AND SKD_VOY_NO      = SUBSTR(@[s_vvd_cd], 5, 4)  -- VVD 변수" ).append("\n"); 
		query.append("   AND SKD_DIR_CD      = SUBSTR(@[s_vvd_cd], 9, 1)  -- VVD 변수" ).append("\n"); 
		query.append("   AND VPS_PORT_CD     = @[s_pol_cd]  -- POL_CD 변수" ).append("\n"); 
		query.append("#if (${h_eta_dt} != '') " ).append("\n"); 
		query.append("   AND A.VPS_ETA_DT > TO_DATE(@[h_eta_dt],'YYYYMMDD HH24MISS')+0.99999 --GUIDELINE AMEND" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("--   AND A.VPS_ETA_DT > SYSDATE  --GUIDELINE ADD" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   AND CALL_YD_IND_SEQ = 1                          -- 하드코딩" ).append("\n"); 
		query.append("--   AND VPS_PORT_CD IN (" ).append("\n"); 
		query.append("--                        SELECT LOC_CD " ).append("\n"); 
		query.append("--                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("--                         WHERE CONTI_CD      <> 'A'  -- 하드코딩, ASIA 제외" ).append("\n"); 
		query.append("--                           AND CALL_PORT_FLG = 'Y'   -- 하드코딩, PORT 만 검색" ).append("\n"); 
		query.append("--                           AND DELT_FLG      = 'N'   -- 하드코딩, DELT 제거" ).append("\n"); 
		query.append("--                     )" ).append("\n"); 
		query.append("  ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}
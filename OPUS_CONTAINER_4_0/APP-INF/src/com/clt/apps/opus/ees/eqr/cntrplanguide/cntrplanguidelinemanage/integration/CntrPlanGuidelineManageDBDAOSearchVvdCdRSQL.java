/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOSearchVvdCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.19 
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

public class CntrPlanGuidelineManageDBDAOSearchVvdCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Add/Amend Popup의 Form에 VVD를 변경할 경우 POL, ETA를 조회한다.
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOSearchVvdCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("h_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOSearchVvdCdRSQL").append("\n"); 
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
		query.append(" 	   VSL_CD||SKD_VOY_NO||SKD_DIR_CD 	  VVD_CD" ).append("\n"); 
		query.append("	  ,VPS_PORT_CD                        POL_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(VPS_ETA_DT, 'YYYYMMDD')    EFF_ST_DT -- HIDDEN" ).append("\n"); 
		query.append("      ,TO_CHAR(VPS_ETA_DT, 'MON-DD')  	  ETA_DT    -- 화면표현" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND SLAN_CD		  = SUBSTR(@[lane],6)" ).append("\n"); 
		query.append("  AND VSL_CD          = SUBSTR(@[s_vvd_cd], 0, 4)  -- VVD 변수" ).append("\n"); 
		query.append("  AND SKD_VOY_NO      = SUBSTR(@[s_vvd_cd], 5, 4)  -- VVD 변수" ).append("\n"); 
		query.append("  AND SKD_DIR_CD      = SUBSTR(@[s_vvd_cd], 9, 1)  -- VVD 변수" ).append("\n"); 
		query.append("#if (${h_eta_dt} != '') " ).append("\n"); 
		query.append("  AND VPS_ETA_DT > TO_DATE(@[h_eta_dt],'YYYYMMDD HH24MISS')+0.99999 --GUIDELINE AMEND" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" -- AND VPS_ETA_DT > SYSDATE  --GUIDELINE ADD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}
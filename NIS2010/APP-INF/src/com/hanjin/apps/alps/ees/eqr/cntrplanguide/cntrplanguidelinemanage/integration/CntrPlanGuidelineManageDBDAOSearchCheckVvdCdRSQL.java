/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOSearchCheckVvdCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.19 
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

public class CntrPlanGuidelineManageDBDAOSearchCheckVvdCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Form의 VVD 코드 변경시 Lane의 유효한 VVD인지 체크한다.
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOSearchCheckVvdCdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOSearchCheckVvdCdRSQL").append("\n"); 
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
		query.append("-- VVD_CHECK : T-존재, F-미존재" ).append("\n"); 
		query.append("SELECT CASE WHEN COUNT(1) >= 1 THEN 'T' " ).append("\n"); 
		query.append("            WHEN COUNT(1) =  0 THEN 'F'                   " ).append("\n"); 
		query.append("       END VVD_CHECK     " ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VSL_CD     = SUBSTR(@[s_vvd_cd], 0, 4)  -- VVD 변수" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[s_vvd_cd], 5, 4)  -- VVD 변수" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[s_vvd_cd], 9, 1)  -- VVD 변수" ).append("\n"); 
		query.append("#if (${h_eta_dt} != '') " ).append("\n"); 
		query.append("   AND VPS_ETA_DT > TO_DATE(@[h_eta_dt],'YYYYMMDD HH24MISS')+0.99999 --GUIDELINE AMEND" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  -- AND VPS_ETA_DT > SYSDATE  --GUIDELINE ADD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOSearchAddGlineVvdRSQL.java
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

public class CntrPlanGuidelineManageDBDAOSearchAddGlineVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOSearchAddGlineVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOSearchAddGlineVvdRSQL").append("\n"); 
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
		query.append(" 	   A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append(" WHERE A.SLAN_CD = @[lane]     -- 입력값" ).append("\n"); 
		query.append("   AND A.VPS_ETA_DT > SYSDATE  -- 하드코딩" ).append("\n"); 
		query.append("   AND A.TURN_PORT_FLG = 'N'   -- 하드코딩" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOCheckPodCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOCheckPodCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POD Add시 입력받은 POD Code의 유효성 체크
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOCheckPodCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration ").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOCheckPodCdRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(LOC_CD) > 0 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END AS POD_CHK" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append(" WHERE PORT_INLND_CD = 'Y'" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("   AND LOC_CD =@[pod_cd]" ).append("\n"); 

	}
}
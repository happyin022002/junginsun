/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchRLaneComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchRLaneComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Combo List 조회
	  * </pre>
	  */
	public CommonDBDAOSearchRLaneComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchRLaneComboListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.TRD_CD    ," ).append("\n"); 
		query.append("                  B.SUB_TRD_CD," ).append("\n"); 
		query.append("                  A.RLANE_CD  ," ).append("\n"); 
		query.append("                  A.RLANE_NM" ).append("\n"); 
		query.append("    FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("         MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("   WHERE A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("     AND A.VSL_TP_CD  = 'C'" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("#if (${ipc} != 'true')" ).append("\n"); 
		query.append("     AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND B.DELT_FLG  IN ('N', @[del])" ).append("\n"); 
		query.append("     AND B.TRD_CD    <> 'COM'" ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("	 AND B.TRD_CD     IN (@[trade]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.TRD_CD    ," ).append("\n"); 
		query.append("         B.SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD" ).append("\n"); 

	}
}
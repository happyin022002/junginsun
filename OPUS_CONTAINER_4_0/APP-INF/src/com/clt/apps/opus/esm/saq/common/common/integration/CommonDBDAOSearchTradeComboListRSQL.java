/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchTradeComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.02.28 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchTradeComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade Combo List 조회
	  * </pre>
	  */
	public CommonDBDAOSearchTradeComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOSearchTradeComboListRSQL").append("\n"); 
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
		query.append("  SELECT B.TRD_CD," ).append("\n"); 
		query.append("         TRD_NM" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT DISTINCT B.TRD_CD" ).append("\n"); 
		query.append("              FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                   MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                   MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("             WHERE A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("               AND A.VSL_TP_CD   = 'C'" ).append("\n"); 
		query.append("#if (${isRepTrade} == 'true')" ).append("\n"); 
		query.append("               AND A.REP_TRD_CD  = B.TRD_CD /* Rep Trade 경우 추가 option 조건 */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               AND B.DELT_FLG   IN ('N', @[del])" ).append("\n"); 
		query.append("               AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("               AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("               AND DECODE(C.VSL_SVC_TP_CD,'I',C.CO_CD,'1') = DECODE(C.VSL_SVC_TP_CD,'I','H','1') " ).append("\n"); 
		query.append("               AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         MDM_TRADE B" ).append("\n"); 
		query.append("   WHERE A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("ORDER BY B.TRD_CD" ).append("\n"); 

	}
}
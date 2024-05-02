/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchSubTradeComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
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

public class CommonDBDAOSearchSubTradeComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sub Trade 콤보를 조회한다.
	  * Trade Code | Sub Trade Code | Sub Trade Name
	  * </pre>
	  */
	public CommonDBDAOSearchSubTradeComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSubTradeComboListRSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD    ," ).append("\n"); 
		query.append("         B.SUB_TRD_CD, " ).append("\n"); 
		query.append("         NVL(B.SUB_TRD_NM, ( SELECT T.TRD_NM" ).append("\n"); 
		query.append("                               FROM MDM_TRADE T" ).append("\n"); 
		query.append("                              WHERE T.TRD_CD = A.TRD_CD)" ).append("\n"); 
		query.append("         ) SUB_TRD_NM " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT DISTINCT" ).append("\n"); 
		query.append("                   B.TRD_CD  ," ).append("\n"); 
		query.append("                   SUB_TRD_CD" ).append("\n"); 
		query.append("              FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                   MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                   MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("             WHERE A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("               AND A.VSL_TP_CD   = 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${isRepTrade} == 'true')" ).append("\n"); 
		query.append("               AND A.REP_TRD_CD  = B.TRD_CD /* Rep Trade 경우 추가 option 조건 */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               AND B.DELT_FLG   IN ('N', @[del])" ).append("\n"); 
		query.append("               AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("               AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("               AND DECODE(C.VSL_SVC_TP_CD,'I',C.CO_CD,'1') = DECODE(C.VSL_SVC_TP_CD,'I','H','1') " ).append("\n"); 
		query.append("               AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("			   #if (${trdCd} != '')" ).append("\n"); 
		query.append("			   AND B.TRD_CD = @[trdCd]" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         MDM_SUB_TRD B" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${isAll} == 'true')" ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.TRD_CD    ," ).append("\n"); 
		query.append("         B.SUB_TRD_CD" ).append("\n"); 

	}
}
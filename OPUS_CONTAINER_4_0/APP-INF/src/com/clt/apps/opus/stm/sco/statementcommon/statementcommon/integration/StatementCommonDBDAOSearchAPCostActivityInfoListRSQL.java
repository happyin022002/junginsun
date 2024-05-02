/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchAPCostActivityInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchAPCostActivityInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAPCostActivityInfoList
	  * </pre>
	  */
	public StatementCommonDBDAOSearchAPCostActivityInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_mdl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchAPCostActivityInfoListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     SACAI.SRC_MDL_CD" ).append("\n"); 
		query.append("    ,SACAI.ACT_COST_CD" ).append("\n"); 
		query.append("    ,SACAI.CONV_ACCT_CD" ).append("\n"); 
		query.append("    ,SACAI.ACT_COST_NM" ).append("\n"); 
		query.append("    ,SACAI.ACT_DT_NM" ).append("\n"); 
		query.append("    ,SACAI.ACT_PLC_NM" ).append("\n"); 
		query.append("    ,DECODE(SACAI.ENBL_FLG,'Y','1','0') AS ENBL_FLG" ).append("\n"); 
		query.append("    ,'' USR_ID" ).append("\n"); 
		query.append("    ,NVL(SACAI.ACCL_FLG, 'N') AS ACCL_FLG" ).append("\n"); 
		query.append("FROM SCO_AP_COST_ACT_INFO SACAI" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${src_mdl_cd} != '')" ).append("\n"); 
		query.append("   AND  SACAI.SRC_MDL_CD = @[src_mdl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cost_cd} != '')" ).append("\n"); 
		query.append("   AND  SACAI.ACT_COST_CD LIKE @[act_cost_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND  NVL(SACAI.ENBL_FLG, 'N') = @[del_flg]" ).append("\n"); 
		query.append("ORDER BY 1,2,3" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AverageRPBDBDAOSearchLaneRPBListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AverageRPBDBDAOSearchLaneRPBListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLaneRPBList
	  * </pre>
	  */
	public AverageRPBDBDAOSearchLaneRPBListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rpb_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.integration").append("\n"); 
		query.append("FileName : AverageRPBDBDAOSearchLaneRPBListRSQL").append("\n"); 
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
		query.append("SELECT RPB_YRMON" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , IOC_CD" ).append("\n"); 
		query.append("     , DIR_CD" ).append("\n"); 
		query.append("     , NET_20FT_AVG_REV" ).append("\n"); 
		query.append("     , OFT_20FT_AVG_REV" ).append("\n"); 
		query.append("     , MISC_20FT_AVG_REV" ).append("\n"); 
		query.append("     , SCR_20FT_AVG_REV" ).append("\n"); 
		query.append("     , NET_40FT_AVG_REV" ).append("\n"); 
		query.append("     , OFT_40FT_AVG_REV" ).append("\n"); 
		query.append("     , MISC_40FT_AVG_REV" ).append("\n"); 
		query.append("     , SCR_40FT_AVG_REV" ).append("\n"); 
		query.append("FROM MAS_MON_LANE_RPB" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND RPB_YRMON =  REPLACE(@[f_rpb_yrmon],'-','')" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '') " ).append("\n"); 
		query.append("  AND RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ioc_cd} != '') " ).append("\n"); 
		query.append("  AND IOC_CD = @[f_ioc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '') " ).append("\n"); 
		query.append("  AND DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RPB_YRMON" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , IOC_CD" ).append("\n"); 
		query.append("     , DIR_CD" ).append("\n"); 

	}
}
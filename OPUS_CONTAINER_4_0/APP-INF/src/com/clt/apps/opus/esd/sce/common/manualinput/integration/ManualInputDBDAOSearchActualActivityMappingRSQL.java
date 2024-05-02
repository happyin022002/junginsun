/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManualInputDBDAOSearchActualActivityMappingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.03.10 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOSearchActualActivityMappingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchActualActivityMapping
	  * </pre>
	  */
	public ManualInputDBDAOSearchActualActivityMappingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration").append("\n"); 
		query.append("FileName : ManualInputDBDAOSearchActualActivityMappingRSQL").append("\n"); 
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
		query.append("SELECT ACT_CD" ).append("\n"); 
		query.append("     , ACT_RCV_TP_CD" ).append("\n"); 
		query.append("     , ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("     , ACT_FLG" ).append("\n"); 
		query.append("     , RAIL_ITCHG_FLG" ).append("\n"); 
		query.append("FROM SCE_ACT_ACT_MAPG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${frm_act_cd} != '') " ).append("\n"); 
		query.append("AND ACT_CD = @[frm_act_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${frm_act_sts_mapg_cd} != '') " ).append("\n"); 
		query.append("AND ACT_STS_MAPG_CD = @[frm_act_sts_mapg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY ACT_CD, ACT_RCV_TP_CD, ACT_STS_MAPG_CD" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimConsumListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.10.22 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimConsumListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ConsumList 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimConsumListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimConsumListRSQL").append("\n"); 
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
		query.append("SELECT VSL_CLSS_CAPA, BZC_VSL_SPD, FOIL_SAIL_CSM" ).append("\n"); 
		query.append("FROM COA_BNK_CSM" ).append("\n"); 
		query.append("WHERE VSL_CLSS_CAPA = @[f_vsl_clss_capa]" ).append("\n"); 
		query.append("ORDER BY BZC_VSL_SPD" ).append("\n"); 

	}
}
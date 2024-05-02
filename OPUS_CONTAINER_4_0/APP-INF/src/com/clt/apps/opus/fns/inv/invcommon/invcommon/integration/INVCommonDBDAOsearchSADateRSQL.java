/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : INVCommonDBDAOsearchSADateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchSADateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSADate
	  * </pre>
	  */
	public INVCommonDBDAOsearchSADateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchSADateRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[bnd], 'O', TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD'), TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD')) SA_DATE" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD =  SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD =  @[port]" ).append("\n"); 
		query.append("#if (${bnd} == 'O')" ).append("\n"); 
		query.append("AND A.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DECODE(A.TURN_PORT_IND_CD, 'D', '1', 'V', '1', 'F', '1', '2')" ).append("\n"); 

	}
}
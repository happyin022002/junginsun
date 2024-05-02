/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DefaultCurrDBDAOMultiCntDefaultCurrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.10.09 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DefaultCurrDBDAOMultiCntDefaultCurrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiCntDefaultCurr
	  * </pre>
	  */
	public DefaultCurrDBDAOMultiCntDefaultCurrDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration").append("\n"); 
		query.append("FileName : DefaultCurrDBDAOMultiCntDefaultCurrDSQL").append("\n"); 
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
		query.append("DELETE FROM AOC_TRF_CURR" ).append("\n"); 
		query.append(" WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonDBDAOSearchLocYardInitialInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2010.01.13 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN YONGCHAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchLocYardInitialInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL, INLAND(WATER)의 EXECUTE ROW 생성하면서 YARD 정보를 검색 item --> VSL(059)           = 'V' , INLAND(WATER)(080) = 'W'
	  * </pre>
	  */
	public CommonDBDAOSearchLocYardInitialInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLocYardInitialInfoRSQL").append("\n"); 
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
		query.append("SELECT MIN(DISTINCT TML_CD) AS LOC_YARD" ).append("\n"); 
		query.append("FROM PRD_PORT_TML_MTX" ).append("\n"); 
		query.append("WHERE PORT_CD     = @[ecc]" ).append("\n"); 
		query.append("AND   VSL_SLAN_CD = @[vsl]" ).append("\n"); 

	}
}
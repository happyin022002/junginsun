/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PRICommonDBDAOSearchChargeListForPctBseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.10
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.10.10 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HojinSong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOSearchChargeListForPctBseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Percent Base Charge 를 위한 Charge List 조회
	  * </pre>
	  */
	public PRICommonDBDAOSearchChargeListForPctBseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOSearchChargeListForPctBseRSQL").append("\n"); 
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
		query.append("SELECT	CHG_CD AS CD" ).append("\n"); 
		query.append("       ,CHG_NM AS NM" ).append("\n"); 
		query.append("FROM	MDM_CHARGE" ).append("\n"); 
		query.append("WHERE 	DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY CHG_CD" ).append("\n"); 

	}
}
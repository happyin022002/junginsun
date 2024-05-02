/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MSTCommonDBDAOSearchHumidityControlCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSTCommonDBDAOSearchHumidityControlCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Humidity Control Code 조회
	  * </pre>
	  */
	public MSTCommonDBDAOSearchHumidityControlCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration").append("\n"); 
		query.append("FileName : MSTCommonDBDAOSearchHumidityControlCodeListRSQL").append("\n"); 
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
		query.append("SELECT  INTG_CD_VAL_CTNT CODE, INTG_CD_VAL_DP_DESC AS CODE_NM  --INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE   INTG_CD_ID   = 'CD30023'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ " ).append("\n"); 

	}
}
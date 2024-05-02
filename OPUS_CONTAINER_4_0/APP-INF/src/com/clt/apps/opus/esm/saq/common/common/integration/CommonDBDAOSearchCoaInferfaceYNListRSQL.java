/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchCoaInferfaceYNListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
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

public class CommonDBDAOSearchCoaInferfaceYNListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Base Data Preparation COA Interface 버튼 활성화 여부 조회
	  * </pre>
	  */
	public CommonDBDAOSearchCoaInferfaceYNListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchCoaInferfaceYNListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(MAX(FCAST_TRNS_STS_CD), 'N', 'N', 'Y') AS TEXT " ).append("\n"); 
		query.append("     , 'COA_STS_CD' AS CODE " ).append("\n"); 
		query.append("  FROM SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append(" WHERE MQTA_MDL_VER_NO = TO_CHAR(SYSDATE, 'YY') || TO_CHAR(ADD_MONTHS(SYSDATE,3), 'Q') || 'Q01'" ).append("\n"); 

	}
}
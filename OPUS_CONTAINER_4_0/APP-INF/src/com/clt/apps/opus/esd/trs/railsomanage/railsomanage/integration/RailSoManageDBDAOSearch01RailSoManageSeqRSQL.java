/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailSoManageDBDAOSearch01RailSoManageSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.01.06 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch01RailSoManageSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail I/B SO 대상 TEMP SEQUENCE 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch01RailSoManageSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration ").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch01RailSoManageSeqRSQL").append("\n"); 
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
		query.append("SELECT TRS_TRSP_RAIL_BIL_ORD_TMP_SEQ1.NEXTVAL SEQ FROM DUAL" ).append("\n"); 

	}
}
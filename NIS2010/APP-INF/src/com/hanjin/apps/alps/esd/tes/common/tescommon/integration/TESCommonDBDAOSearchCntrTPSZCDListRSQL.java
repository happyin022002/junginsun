/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESCommonDBDAOSearchCntrTPSZCDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchCntrTPSZCDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Type Size List Inquiry
	  * </pre>
	  */
	public TESCommonDBDAOSearchCntrTPSZCDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchCntrTPSZCDListRSQL").append("\n"); 
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
		query.append("SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(CNTR_TPSZ_CD,'|')),'|')" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	ROWNUM ROW_ID" ).append("\n"); 
		query.append(", Z.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM	MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY  CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 

	}
}
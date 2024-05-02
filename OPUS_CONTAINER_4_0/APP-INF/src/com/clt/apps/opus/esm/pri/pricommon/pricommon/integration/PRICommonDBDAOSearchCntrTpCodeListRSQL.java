/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PRICommonDBDAOSearchCntrTpCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOSearchCntrTpCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * retrieving MDM Container Type
	  * </pre>
	  */
	public PRICommonDBDAOSearchCntrTpCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOSearchCntrTpCodeListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    CNTR_TP_CD AS CD" ).append("\n"); 
		query.append("   ,CNTR_TP_DESC AS NM" ).append("\n"); 
		query.append("   ,(CNTR_TP_CD || '|' || CNTR_TP_DESC) AS ETC5" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY DECODE(CNTR_TP_CD, 'D',1,'R',2,'F',3,'A',4,'O',5,'S',6,7)" ).append("\n"); 

	}
}
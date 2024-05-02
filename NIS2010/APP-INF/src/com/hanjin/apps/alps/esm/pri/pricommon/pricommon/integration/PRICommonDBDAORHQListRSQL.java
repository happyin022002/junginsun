/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORHQListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.03 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORHQListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sc rhq 콤보
	  * </pre>
	  */
	public PRICommonDBDAORHQListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORHQListRSQL").append("\n"); 
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
		query.append("SELECT	OFC_CD AS CD" ).append("\n"); 
		query.append(",OFC_CD AS NM" ).append("\n"); 
		query.append("FROM	MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE	OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("AND		DELT_FLG  = 'N'" ).append("\n"); 
		query.append("ORDER BY OFC_CD" ).append("\n"); 

	}
}
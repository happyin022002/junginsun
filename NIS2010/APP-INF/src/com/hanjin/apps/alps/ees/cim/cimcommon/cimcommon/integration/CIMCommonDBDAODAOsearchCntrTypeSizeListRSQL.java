/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CIMCommonDBDAODAOsearchCntrTypeSizeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.13 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class CIMCommonDBDAODAOsearchCntrTypeSizeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tpsz 리스트 값 조회
	  * </pre>
	  */
	public CIMCommonDBDAODAOsearchCntrTypeSizeListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT 	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM 	MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE 	ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("ORDER BY RPT_DP_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.cim.cimcommon.cimcommon.integration ").append("\n"); 
		query.append("FileName : CIMCommonDBDAODAOsearchCntrTypeSizeListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
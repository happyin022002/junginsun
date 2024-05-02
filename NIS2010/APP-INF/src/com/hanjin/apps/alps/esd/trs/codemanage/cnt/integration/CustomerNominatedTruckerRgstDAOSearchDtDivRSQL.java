/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstDAOSearchDtDivRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.05
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.08.05 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerRgstDAOSearchDtDivRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDtDiv
	  * </pre>
	  */
	public CustomerNominatedTruckerRgstDAOSearchDtDivRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerRgstDAOSearchDtDivRSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("      ,INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append(" WHERE INTG_CD_ID = 'CD02005'" ).append("\n"); 
		query.append("   AND INTG_CD_VAL_CTNT IN ('00', '01', '02', '03')" ).append("\n"); 

	}
}
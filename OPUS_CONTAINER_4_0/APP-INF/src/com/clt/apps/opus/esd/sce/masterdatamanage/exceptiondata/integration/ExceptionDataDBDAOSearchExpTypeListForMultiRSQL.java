/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchExpTypeListForMultiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.09 이중환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchExpTypeListForMultiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select list for multi
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchExpTypeListForMultiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration ").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchExpTypeListForMultiRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(EXPT_CD,1,1) R_COP_EXPT_TP_CD, EXPT_CD_NM R_COP_EXPT_TP_NM, EXPT_CD_DESC R_COP_EXPT_TP_DESC" ).append("\n"); 
		query.append(",UPD_USR_ID R_USR_ID, TO_CHAR(UPD_DT,'YYYY/MM/DD HH24:MI:SS') R_UPD_DT, ACT_FLG R_ACT_FLG" ).append("\n"); 
		query.append("FROM   SCE_EXPT_CD" ).append("\n"); 
		query.append("WHERE  SUBSTR(EXPT_CD, 2, LENGTH(EXPT_CD) ) = '0000000'" ).append("\n"); 
		query.append("ORDER BY SUBSTR(EXPT_CD,1,1)" ).append("\n"); 

	}
}
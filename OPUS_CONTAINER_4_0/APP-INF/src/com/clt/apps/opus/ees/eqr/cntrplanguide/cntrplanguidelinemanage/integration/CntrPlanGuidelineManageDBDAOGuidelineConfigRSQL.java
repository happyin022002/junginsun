/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOGuidelineConfigRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.04
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.04.04 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOGuidelineConfigRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOGuidelineConfigRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOGuidelineConfigRSQL").append("\n"); 
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
		query.append("--SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', SYSDATE, [ofc_cd]), 'YYYY-MM-DD') LCL_DT " ).append("\n"); 
		query.append("--  FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') LCL_DT " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalFinderDAOSearchPaymenetOfficeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDAOSearchPaymenetOfficeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExternalFinderDAOSearchPaymenetOfficeCodeListRSQL
	  * </pre>
	  */
	public ExternalFinderDAOSearchPaymenetOfficeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDAOSearchPaymenetOfficeCodeListRSQL").append("\n"); 
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
		query.append("SELECT FP.PPT_CTNT OFC_CD," ).append("\n"); 
		query.append("       FP.PPT_CTNT || ' ' || MO.OFC_KRN_NM OFC_NM" ).append("\n"); 
		query.append("  FROM FMS_PPT_SET FP, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append(" WHERE FP.PPT_CTNT = MO.OFC_CD" ).append("\n"); 
		query.append("   AND FP.PPT_NM = 'OFFICE_CODE'" ).append("\n"); 
		query.append("   AND NVL(MO.DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}
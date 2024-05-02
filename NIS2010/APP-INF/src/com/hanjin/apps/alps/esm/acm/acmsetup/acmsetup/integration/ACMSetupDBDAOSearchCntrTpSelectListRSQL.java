/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOSearchCntrTpSelectListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.14 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOSearchCntrTpSelectListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Type Selection 목록을 조회
	  * </pre>
	  */
	public ACMSetupDBDAOSearchCntrTpSelectListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAOSearchCntrTpSelectListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("           CNTR_TP_CD," ).append("\n"); 
		query.append("           CNTR_TP_DESC" ).append("\n"); 
		query.append("      FROM MDM_CNTR_TP" ).append("\n"); 
		query.append("     WHERE NVL (DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  ORDER BY CNTR_TP_CD" ).append("\n"); 

	}
}
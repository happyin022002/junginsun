/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmValidationDBDAOMdmCurrencyVORSQL.java
*@FileTitle : curr_cd check
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.07 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmValidationDBDAOMdmCurrencyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CgmValidationDBDAOMdmCurrencyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.integration").append("\n"); 
		query.append("FileName : CgmValidationDBDAOMdmCurrencyVORSQL").append("\n"); 
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
		query.append("SELECT CURR_CD" ).append("\n"); 
		query.append(",CURR_NM" ).append("\n"); 
		query.append(",CURR_DESC" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",FM_EFF_DT" ).append("\n"); 
		query.append(",TO_EFF_DT" ).append("\n"); 
		query.append(",DP_PRCS_KNT" ).append("\n"); 
		query.append(",XTD_PRCS_KNT" ).append("\n"); 
		query.append("FROM MDM_CURRENCY" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 

	}
}
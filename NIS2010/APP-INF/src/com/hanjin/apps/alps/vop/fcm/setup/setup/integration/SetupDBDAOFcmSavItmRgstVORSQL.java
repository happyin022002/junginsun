/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SetupDBDAOFcmSavItmRgstVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.04 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SetupDBDAOFcmSavItmRgstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Saving Item Registratiron 정보를 조회합니다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * </pre>
	  */
	public SetupDBDAOFcmSavItmRgstVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.setup.setup.integration").append("\n"); 
		query.append("FileName : SetupDBDAOFcmSavItmRgstVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append(" SAV_ITM_CD" ).append("\n"); 
		query.append(",VSL_CLSS_SUB_CD" ).append("\n"); 
		query.append(",SAV_CSM_SUB_ITM_CD" ).append("\n"); 
		query.append(",ITM_NM" ).append("\n"); 
		query.append(",ITM_CSM_RTO" ).append("\n"); 
		query.append(",ITM_UT_PRC" ).append("\n"); 
		query.append(",CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",ITM_TRND_LINE_CD" ).append("\n"); 
		query.append(",TRND_LINE_SEQ" ).append("\n"); 
		query.append(",TRND_LINE_NO" ).append("\n"); 
		query.append(",N1ST_COEF_VAL" ).append("\n"); 
		query.append(",N1ST_VAR_DGR_VAL" ).append("\n"); 
		query.append(",N2ND_COEF_VAL" ).append("\n"); 
		query.append(",N2ND_VAR_DGR_VAL" ).append("\n"); 
		query.append(",TRND_LINE_CONS_VAL" ).append("\n"); 
		query.append("FROM FCM_SAV_ITM_RGST" ).append("\n"); 
		query.append("ORDER BY SAV_ITM_CD,SAV_CSM_SUB_ITM_CD,CNTR_VSL_CLSS_CAPA,ITM_TRND_LINE_CD" ).append("\n"); 

	}
}
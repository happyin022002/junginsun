/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ConstraintItemDBDAOSearchConstraintItemListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintItemDBDAOSearchConstraintItemListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MDL_CNST 정보 조회
	  * </pre>
	  */
	public ConstraintItemDBDAOSearchConstraintItemListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.integration").append("\n"); 
		query.append("FileName : ConstraintItemDBDAOSearchConstraintItemListRSQL").append("\n"); 
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
		query.append("  SELECT MDL_CNST_CD   ," ).append("\n"); 
		query.append("         MDL_CNST_NM   ," ).append("\n"); 
		query.append("         YQTA_EDIT_FLG ," ).append("\n"); 
		query.append("         YQTA_USE_FLG  ," ).append("\n"); 
		query.append("         RALOC_EDIT_FLG," ).append("\n"); 
		query.append("         MQTA_EDIT_FLG ," ).append("\n"); 
		query.append("         MQTA_USE_FLG  ," ).append("\n"); 
		query.append("         RALOC_USE_FLG ," ).append("\n"); 
		query.append("         CRE_USR_ID    ," ).append("\n"); 
		query.append("         UPD_USR_ID" ).append("\n"); 
		query.append("    FROM SAQ_MDL_CNST" ).append("\n"); 
		query.append("ORDER BY MDL_CNST_CD" ).append("\n"); 

	}
}
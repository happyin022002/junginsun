/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RailSoManageDBDAOVerifyRailSoManageDeltChkRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOVerifyRailSoManageDeltChkRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O 삭제 여부 체크
	  * </pre>
	  */
	public RailSoManageDBDAOVerifyRailSoManageDeltChkRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration ").append("\n"); 
		query.append("FileName : RailSoManageDBDAOVerifyRailSoManageDeltChkRSQLRSQL").append("\n"); 
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
		query.append("SELECT TRSP_SO_OFC_CTY_CD||TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DELT_FLG = 'Y'" ).append("\n"); 
		query.append("AND (TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach( ${key} in ${soGrpKey})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("('$key.velParamField1','$key.velParamField2')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$key.velParamField1','$key.velParamField2')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}
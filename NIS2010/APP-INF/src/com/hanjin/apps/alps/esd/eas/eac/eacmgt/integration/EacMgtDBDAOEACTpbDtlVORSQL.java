/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEACTpbDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOEACTpbDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC TrpDtlGrid 화면의 VO 생성쿼리
	  * </pre>
	  */
	public EacMgtDBDAOEACTpbDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEACTpbDtlVORSQL").append("\n"); 
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
		query.append("SELECT '' AS EAC_DTL_SEQ" ).append("\n"); 
		query.append("     , '' AS EQ_KND_CD" ).append("\n"); 
		query.append("     , '' AS EQ_NO" ).append("\n"); 
		query.append("     , '' AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , '' AS DIFF_INV_AMT" ).append("\n"); 
		query.append("     , '' AS EAC_NO" ).append("\n"); 
		query.append("     , '' AS AUDR_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
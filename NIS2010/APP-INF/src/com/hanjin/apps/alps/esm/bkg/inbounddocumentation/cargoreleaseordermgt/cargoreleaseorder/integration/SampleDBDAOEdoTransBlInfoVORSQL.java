/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SampleDBDAOEdoTransBlInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SampleDBDAOEdoTransBlInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EdoTransBlInfoVO 생성용 쿼리
	  * </pre>
	  */
	public SampleDBDAOEdoTransBlInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : SampleDBDAOEdoTransBlInfoVORSQL").append("\n"); 
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
		query.append(" '' BKG_NO" ).append("\n"); 
		query.append(",'' POR_CD" ).append("\n"); 
		query.append(",'' RC_FLG" ).append("\n"); 
		query.append(",'' CNT_CD" ).append("\n"); 
		query.append(",'' CNT_NM" ).append("\n"); 
		query.append(",'' SCONTI_NM" ).append("\n"); 
		query.append(",'' CONTI_NM" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}
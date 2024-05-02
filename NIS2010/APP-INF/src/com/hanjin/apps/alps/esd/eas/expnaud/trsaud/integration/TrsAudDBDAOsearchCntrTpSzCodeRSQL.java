/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAudDBDAOsearchCntrTpSzCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOsearchCntrTpSzCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Type Size Code 조회
	  * </pre>
	  */
	public TrsAudDBDAOsearchCntrTpSzCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration ").append("\n"); 
		query.append("FileName : TrsAudDBDAOsearchCntrTpSzCodeRSQL").append("\n"); 
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
		query.append("SELECT	CNTR_TPSZ_CD code_cd, " ).append("\n"); 
		query.append("		CNTR_TPSZ_CD code_nm" ).append("\n"); 
		query.append("  FROM	MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append(" WHERE	DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}
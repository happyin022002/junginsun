/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RASCommonDBDAOBkgRevUmchTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RASCommonDBDAOBkgRevUmchTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRevUmchTp
	  * </pre>
	  */
	public RASCommonDBDAOBkgRevUmchTpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration").append("\n"); 
		query.append("FileName : RASCommonDBDAOBkgRevUmchTpRSQL").append("\n"); 
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
		query.append("SELECT UMCH_TP_CD AS CD" ).append("\n"); 
		query.append(",      UMCH_TP_DESC AS NM" ).append("\n"); 
		query.append("FROM BKG_REV_UMCH_TP" ).append("\n"); 
		query.append("WHERE UMCH_TP_CD IN ('D','E','F','O','T')" ).append("\n"); 
		query.append("#if (${rdn_knd_cd} == 'B' || ${rdn_knd_cd} == 'C')" ).append("\n"); 
		query.append("AND UMCH_TP_CD IN ('D','E','F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rdn_knd_cd} == 'M')" ).append("\n"); 
		query.append("AND UMCH_TP_CD IN ('O','T')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}
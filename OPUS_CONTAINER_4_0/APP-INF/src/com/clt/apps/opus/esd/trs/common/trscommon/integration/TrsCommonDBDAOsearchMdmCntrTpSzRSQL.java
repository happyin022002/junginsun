/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrsCommonDBDAOsearchMdmCntrTpSzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOsearchMdmCntrTpSzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMdmCntrTpSz
	  * </pre>
	  */
	public TrsCommonDBDAOsearchMdmCntrTpSzRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOsearchMdmCntrTpSzRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if( ${eq_radio} == 'U')" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY RPT_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${eq_radio} == 'Z')" ).append("\n"); 
		query.append("SELECT EQ_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  FROM CGM_EQ_TP_SZ" ).append("\n"); 
		query.append(" WHERE EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append(" ORDER BY DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${eq_radio} == 'G')" ).append("\n"); 
		query.append("SELECT EQ_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  FROM CGM_EQ_TP_SZ" ).append("\n"); 
		query.append(" WHERE EQ_KND_CD = 'G'" ).append("\n"); 
		query.append(" ORDER BY DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
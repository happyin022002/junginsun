/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : INVCommonDBDAOSearchChargeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOSearchChargeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchChargeCodeList
	  * </pre>
	  */
	public INVCommonDBDAOSearchChargeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOSearchChargeCodeListRSQL").append("\n"); 
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
		query.append("SELECT ' ' CHG_CD, ' ' CHG_NM" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CHG_CD, CHG_NM" ).append("\n"); 
		query.append("  FROM MDM_CHARGE" ).append("\n"); 
		query.append(" WHERE NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CHG_CD, DECODE(CHG_CD,'JOP','TERMINAL STEVEDORAGE','CRC', 'MIS. REVENUE(CNTR) - EQ RENTAL', CHG_NM) CHG_NM" ).append("\n"); 
		query.append("  FROM MDM_CHARGE" ).append("\n"); 
		query.append(" WHERE CHG_CD IN ('JOP','CRC')  -- MDM에서는 삭제되었으나 사용중" ).append("\n"); 
		query.append("ORDER BY CHG_CD" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisDBDAOGetPoolListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.10 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisDBDAOGetPoolListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전체 Pool Chss 목록을 조회한다
	  * </pre>
	  */
	public PoolChassisDBDAOGetPoolListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration ").append("\n"); 
		query.append("FileName : PoolChassisDBDAOGetPoolListRSQL").append("\n"); 
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
		query.append("SELECT CHSS_POOL_CD" ).append("\n"); 
		query.append(",CHSS_POOL_NM" ).append("\n"); 
		query.append("FROM TRS_TRSP_CHSS_POOL" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}
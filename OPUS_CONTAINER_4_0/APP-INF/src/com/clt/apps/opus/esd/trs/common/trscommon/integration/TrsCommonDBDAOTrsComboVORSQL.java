/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrsCommonDBDAOTrsComboVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.20
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2011.10.20 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HwangHyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOTrsComboVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TrsCommonDBDAOTrsComboVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOTrsComboVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' cntr_vndr_svc_cd" ).append("\n"); 
		query.append(",'' vndr_cost_cd" ).append("\n"); 
		query.append(",'' vndr_cnt_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
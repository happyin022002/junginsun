/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDAOMdmCntrSzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.13 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung Jun Lee
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class PRICommonDBDAOMdmCntrSzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mdm_cntr_sz select
	  * </pre>
	  */
	public PRICommonDBDAOMdmCntrSzRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT cntr_sz_cd as cd," ).append("\n"); 
		query.append("cntr_sz_desc as nm" ).append("\n"); 
		query.append("FROM mdm_cntr_sz" ).append("\n"); 
		query.append("where delt_flg = 'N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ").append("\n"); 
		query.append("FileName : PRICommonDAOMdmCntrSzRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
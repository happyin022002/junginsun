/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORsltOfcListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltOfcListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltOfcListVO
	  * </pre>
	  */
	public PRICommonDBDAORsltOfcListVORSQL(){
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
		query.append("SELECT" ).append("\n"); 
		query.append("ofc_cd cd," ).append("\n"); 
		query.append("ofc_eng_nm nm" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("mdm_organization" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("delt_flg = 'N'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("ofc_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltOfcListVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOGetYardFaxEmailInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.05 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOGetYardFaxEmailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOGetYardFaxEmailInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOGetYardFaxEmailInfoRSQL").append("\n"); 
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
		query.append("SELECT YD_CD," ).append("\n"); 
		query.append("       FAX_NO," ).append("\n"); 
		query.append("       YD_EML," ).append("\n"); 
		query.append("	   YD_NM" ).append("\n"); 
		query.append("  FROM MDM_YARD" ).append("\n"); 
		query.append(" WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("   AND YD_CD = @[empty_cy]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityDBDAORsltGrpCmdtListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.04 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.commodity.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAORsltGrpCmdtListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy 쿼리
	  * </pre>
	  */
	public CommodityDBDAORsltGrpCmdtListVORSQL(){
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
		query.append("'' AS CD" ).append("\n"); 
		query.append(",	'' AS NM" ).append("\n"); 
		query.append(",	'' SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.commodity.integration ").append("\n"); 
		query.append("FileName : CommodityDBDAORsltGrpCmdtListVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
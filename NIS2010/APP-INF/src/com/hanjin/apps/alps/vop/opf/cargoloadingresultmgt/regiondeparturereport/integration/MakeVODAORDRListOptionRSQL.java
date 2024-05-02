/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVODAORDRListOptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.19 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAORDRListOptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성 쿼리 없어서 생성 생성쿼리 생성.
	  * </pre>
	  */
	public MakeVODAORDRListOptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : MakeVODAORDRListOptionRSQL").append("\n"); 
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
		query.append("SELECT  '' VSL_CD" ).append("\n"); 
		query.append(",       '' VOY_NO" ).append("\n"); 
		query.append(",       '' DIR_CD" ).append("\n"); 
		query.append(",       '' REGION" ).append("\n"); 
		query.append(",       '' OPR_CD" ).append("\n"); 
		query.append(",       '' OPT_OPR_CD" ).append("\n"); 
		query.append(",       '' PORT_CD" ).append("\n"); 
		query.append(",       '' QTY1" ).append("\n"); 
		query.append(",       '' QTY2" ).append("\n"); 
		query.append(",       '' QTY3" ).append("\n"); 
		query.append(",       '' QTY4" ).append("\n"); 
		query.append(",       '' QTY5" ).append("\n"); 
		query.append(",       '' QTY6" ).append("\n"); 
		query.append(",       '' QTY7" ).append("\n"); 
		query.append(",       '' QTY8" ).append("\n"); 
		query.append(",       '' QTY9" ).append("\n"); 
		query.append(",       '' QTY10" ).append("\n"); 
		query.append(",       '' QTY11" ).append("\n"); 
		query.append(",       '' QTY12" ).append("\n"); 
		query.append(",       '' QTY13" ).append("\n"); 
		query.append(",       '' QTY14" ).append("\n"); 
		query.append(",       '' QTY15" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}
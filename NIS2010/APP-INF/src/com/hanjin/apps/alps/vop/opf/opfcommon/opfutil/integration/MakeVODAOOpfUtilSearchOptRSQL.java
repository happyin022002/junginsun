/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MakeVODAOOpfUtilSearchOptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.28 
* 1.0 Creation
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAOOpfUtilSearchOptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combo Sc Cutomer VO 작성.
	  * </pre>
	  */
	public MakeVODAOOpfUtilSearchOptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : MakeVODAOOpfUtilSearchOptRSQL").append("\n"); 
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
		query.append("SELECT  '' PORT_CD" ).append("\n"); 
		query.append(",       '' VSL_CD" ).append("\n"); 
		query.append(",       '' VOY_NO" ).append("\n"); 
		query.append(",       '' DIR_CD" ).append("\n"); 
		query.append(",       '' VAL" ).append("\n"); 
		query.append(",       '' NAME" ).append("\n"); 
		query.append(",       '' CALL_IND" ).append("\n"); 
		query.append(",		'' YD_CD" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}
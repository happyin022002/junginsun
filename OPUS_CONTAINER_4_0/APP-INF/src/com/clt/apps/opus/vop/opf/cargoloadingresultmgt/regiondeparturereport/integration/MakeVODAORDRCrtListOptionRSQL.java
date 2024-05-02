/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVODAORDRCrtListOptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.10 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAORDRCrtListOptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR Creation 조회옵션등을 관리하는 VO
	  * Dao Name을 MakeVO 로 관리한다.
	  * </pre>
	  */
	public MakeVODAORDRCrtListOptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : MakeVODAORDRCrtListOptionRSQL").append("\n"); 
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
		query.append("SELECT '' VSL_CD" ).append("\n"); 
		query.append(",      '' VOY_NO" ).append("\n"); 
		query.append(",      '' DIR_CD" ).append("\n"); 
		query.append(",      '' REGION" ).append("\n"); 
		query.append(",      '' PORT_CD" ).append("\n"); 
		query.append(",      '' NEXT_PORT" ).append("\n"); 
		query.append(",      '' ETA" ).append("\n"); 
		query.append(",      '' NEXT_CANAL" ).append("\n"); 
		query.append(",      '' ETA_CANAL" ).append("\n"); 
		query.append(",      '' REMARK" ).append("\n"); 
		query.append(",      '' SEGMENT" ).append("\n"); 
		query.append(",      '' UPDATE_USER" ).append("\n"); 
		query.append(",      '' MOVE_PORT_CD" ).append("\n"); 
		query.append(",      '' CALL_IND" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}
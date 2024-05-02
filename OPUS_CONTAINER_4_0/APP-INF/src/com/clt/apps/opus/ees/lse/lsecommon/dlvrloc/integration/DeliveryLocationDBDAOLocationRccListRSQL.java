/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DeliveryLocationDBDAOLocationRccListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.10 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.dlvrloc.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DeliveryLocationDBDAOLocationRccListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_EQ_ORZ_CHT RCC Code Search
	  * </pre>
	  */
	public DeliveryLocationDBDAOLocationRccListRSQL(){
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
		query.append("SELECT DISTINCT RCC_CD" ).append("\n"); 
		query.append("FROM   MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.dlvrloc.integration").append("\n"); 
		query.append("FileName : DeliveryLocationDBDAOLocationRccListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
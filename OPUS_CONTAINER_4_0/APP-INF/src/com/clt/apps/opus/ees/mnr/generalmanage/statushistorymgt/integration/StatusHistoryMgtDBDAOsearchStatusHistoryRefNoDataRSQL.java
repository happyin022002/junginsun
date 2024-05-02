/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatusHistoryMgtDBDAOsearchStatusHistoryRefNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.09
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.04.09 한종희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jonghee HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusHistoryMgtDBDAOsearchStatusHistoryRefNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ------------------------------------------------------------------------------------------------------------------------------
	  * StatusHistory 의 Ref No 생성 조회
	  * 2014-04-09 by Jonghee HAN 최초 Total Loss status flag 생성시 SQL 오류 수정, NVL 처리 추가
	  * ------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public StatusHistoryMgtDBDAOsearchStatusHistoryRefNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.integration").append("\n"); 
		query.append("FileName : StatusHistoryMgtDBDAOsearchStatusHistoryRefNoDataRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(MNR_STS_REF_NO), 0) + 1 FROM MNR_STS_HIS" ).append("\n"); 

	}
}
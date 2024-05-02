/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneInformationMgtDBDAOScgRgnShpOprCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.02.18 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneInformationMgtDBDAOScgRgnShpOprCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public LaneInformationMgtDBDAOScgRgnShpOprCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOScgRgnShpOprCdRSQL").append("\n"); 
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
		query.append("SELECT  RGN_SHP_OPR_CD	AS	VAL, RGN_SHP_OPR_DESC 	AS	NAME" ).append("\n"); 
		query.append("FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("WHERE   DELT_FLG != 'Y'" ).append("\n"); 

	}
}
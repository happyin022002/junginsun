/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MovementDBDAOContainerMovementStatusRSQL.java
*@FileTitle : sdfsdf
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.10 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.movement.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MovementDBDAOContainerMovementStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Movement Status를 조회합니다.
	  * </pre>
	  */
	public MovementDBDAOContainerMovementStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.movement.intergration").append("\n"); 
		query.append("FileName : MovementDBDAOContainerMovementStatusRSQL").append("\n"); 
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
		query.append("SELECT  MVMT_STS_CD, MVMT_STS_NM" ).append("\n"); 
		query.append("FROM    MDM_MVMT_STS" ).append("\n"); 
		query.append("WHERE   DELT_FLG='N'" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}
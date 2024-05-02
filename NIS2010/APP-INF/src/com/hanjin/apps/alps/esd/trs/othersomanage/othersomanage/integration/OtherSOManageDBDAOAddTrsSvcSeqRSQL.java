/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSOManageDBDAOAddTrsSvcSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.09.16 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOAddTrsSvcSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_SVC_ORD에서 사용될 S/O Sequence를 조회
	  * </pre>
	  */
	public OtherSOManageDBDAOAddTrsSvcSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration ").append("\n"); 
		query.append("FileName : OtherSOManageDBDAOAddTrsSvcSeqRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD_SEQ1.NEXTVAL seq" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 

	}
}
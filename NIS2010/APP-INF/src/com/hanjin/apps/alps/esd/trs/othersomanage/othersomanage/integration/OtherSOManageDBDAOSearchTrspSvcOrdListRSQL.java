/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OtherSOManageDBDAOSearchTrspSvcOrdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOSearchTrspSvcOrdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_SVC_ORD  LIST
	  * </pre>
	  */
	public OtherSOManageDBDAOSearchTrspSvcOrdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDBDAOSearchTrspSvcOrdListRSQL").append("\n"); 
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
		query.append("A.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ," ).append("\n"); 
		query.append("A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM 	TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("WHERE 	1=1" ).append("\n"); 
		query.append("#if ($TRSP_SO_SEQ.size() > 0)" ).append("\n"); 
		query.append("and" ).append("\n"); 
		query.append("#foreach( ${key} in ${TRSP_SO_SEQ})" ).append("\n"); 
		query.append("#if($velocityCount < $TRSP_SO_SEQ.size())" ).append("\n"); 
		query.append("(  A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ ) IN ((SUBSTR('$key',1,3),SUBSTR('$key',4)))" ).append("\n"); 
		query.append("AND A.HJL_NO IS NULL" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(  A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ) IN ((SUBSTR('$key',1,3),SUBSTR('$key',4)))" ).append("\n"); 
		query.append("AND A.HJL_NO IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
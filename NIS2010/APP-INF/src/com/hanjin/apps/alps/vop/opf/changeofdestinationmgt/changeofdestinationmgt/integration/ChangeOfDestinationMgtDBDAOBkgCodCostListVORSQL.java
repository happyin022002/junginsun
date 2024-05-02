/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOBkgCodCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2010.04.27 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOBkgCodCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOBkgCodCostListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOBkgCodCostListVORSQL").append("\n"); 
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
		query.append("SELECT '' AS BKG_NO" ).append("\n"); 
		query.append(",      '' AS COD_RQST_SEQ" ).append("\n"); 
		query.append(",      '' AS CHG_CD" ).append("\n"); 
		query.append(",      '' AS CURR_CD" ).append("\n"); 
		query.append(",      '' AS CHG_UT_AMT" ).append("\n"); 
		query.append(",      '' AS RAT_UT_CD        --tpsz 변경" ).append("\n"); 
		query.append(",      '' AS RAT_AS_QTY" ).append("\n"); 
		query.append(",      '' AS CHG_AMT" ).append("\n"); 
		query.append(",      '' AS CGO_CATE_CD" ).append("\n"); 
		query.append(",      '' AS COST_CD_RQST_SEQ" ).append("\n"); 
		query.append(",      '' AS CNTR_CGO_TP_CD    --F/M" ).append("\n"); 
		query.append(",      '' AS COD_RHND_PORT_CD" ).append("\n"); 
		query.append(",      '' AS VVD" ).append("\n"); 
		query.append(",      '' AS CNTR" ).append("\n"); 
		query.append(",      '' AS PORT" ).append("\n"); 
		query.append(",      '' AS POSITION" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}
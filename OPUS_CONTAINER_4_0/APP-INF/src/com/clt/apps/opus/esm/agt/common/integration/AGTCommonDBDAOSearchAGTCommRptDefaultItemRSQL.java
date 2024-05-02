/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommonDBDAOSearchAGTCommRptDefaultItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.04.14 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOSearchAGTCommRptDefaultItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAGTCommRptDefaultItem
	  * </pre>
	  */
	public AGTCommonDBDAOSearchAGTCommRptDefaultItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("userId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchAGTCommRptDefaultItemRSQL").append("\n"); 
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
		query.append("RPT_ITM_DESC," ).append("\n"); 
		query.append("LOWER(RPT_ITM_COL_NM) AS RPT_ITM_COL_NM" ).append("\n"); 
		query.append("FROM AGT_RPT_ITM_INFO_DTL" ).append("\n"); 
		query.append("WHERE CRE_USR_ID = @[userId]" ).append("\n"); 
		query.append("AND SLCT_ITM_FOM_SEQ = @[seq]" ).append("\n"); 
		query.append("ORDER BY AC_RPT_ITM_CD" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CalculateDBDAOPriPrsInCalculateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.29 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CalculateDBDAOPriPrsInCalculateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Used Route CASE Info
	  * </pre>
	  */
	public CalculateDBDAOPriPrsInCalculateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration").append("\n"); 
		query.append("FileName : CalculateDBDAOPriPrsInCalculateVORSQL").append("\n"); 
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
		query.append("	'' AS ROUT_CS_NO" ).append("\n"); 
		query.append("	,'' AS ROUT_CS_CLSS_NO" ).append("\n"); 
		query.append("	,'' AS ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("	,'' AS TRI_PROP_NO" ).append("\n"); 
		query.append("	,'' AS AMDT_SEQ" ).append("\n"); 
		query.append("	,'' AS PRS_ROUT_CS_BAT_RSLT_CD" ).append("\n"); 
		query.append("	,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
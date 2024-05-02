/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommonDBDAOSearchCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOSearchCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrList
	  * </pre>
	  */
	public AGTCommonDBDAOSearchCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sSpclCntrType",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchCntrListRSQL").append("\n"); 
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
		query.append("DECODE( INSTR(@[sSpclCntrType],CNTR_TP_CD), 0, 0, 1) AS SELVAL" ).append("\n"); 
		query.append(", CNTR_TP_CD" ).append("\n"); 
		query.append(", CNTR_TP_DESC" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP" ).append("\n"); 
		query.append("WHERE NVL (DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY CNTR_TP_CD" ).append("\n"); 

	}
}
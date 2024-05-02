/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateGuidelineDBDAOLoadExcelCheckRepCmdtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.14 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateGuidelineDBDAOLoadExcelCheckRepCmdtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rep. Commodity Code Check.
	  * </pre>
	  */
	public RFARateGuidelineDBDAOLoadExcelCheckRepCmdtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.integration").append("\n"); 
		query.append("FileName : RFARateGuidelineDBDAOLoadExcelCheckRepCmdtRSQL").append("\n"); 
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
		query.append("SELECT REP_CMDT_CD AS CD" ).append("\n"); 
		query.append(",REP_CMDT_NM AS NM" ).append("\n"); 
		query.append("FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("WHERE REP_CMDT_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 

	}
}
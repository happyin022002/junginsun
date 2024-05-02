/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesRepInfoManageDBDAOsearchSRepNameByUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.24
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.06.24 이창원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRepInfoManageDBDAOsearchSRepNameByUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SalesRepInfoManageDBDAOsearchSRepNameByUser
	  * </pre>
	  */
	public SalesRepInfoManageDBDAOsearchSRepNameByUserRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration ").append("\n"); 
		query.append("FileName : SalesRepInfoManageDBDAOsearchSRepNameByUserRSQL").append("\n"); 
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
		query.append("SELECT SREP_CD,OFC_CD,SREP_NM FROM MDM_SLS_REP" ).append("\n"); 
		query.append("WHERE EMPE_CD = @[usr_id]" ).append("\n"); 

	}
}
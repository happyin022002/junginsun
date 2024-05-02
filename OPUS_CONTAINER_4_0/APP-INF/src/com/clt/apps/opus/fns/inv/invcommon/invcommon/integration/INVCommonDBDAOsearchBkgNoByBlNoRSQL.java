/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : INVCommonDBDAOsearchBkgNoByBlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.27 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchBkgNoByBlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVCommonDBDAOsearchBkgNoByBlNoRSQL
	  * </pre>
	  */
	public INVCommonDBDAOsearchBkgNoByBlNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchBkgNoByBlNoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM   BKG_BOOKING" ).append("\n"); 
		query.append("WHERE  BL_NO= @[bl_src_no]" ).append("\n"); 

	}
}
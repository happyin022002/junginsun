/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCGInternalFinderDBDAOSearchRSOforSpecificPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOSearchRSOforSpecificPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieving RSO for Specific Port Code
	  * </pre>
	  */
	public SCGInternalFinderDBDAOSearchRSOforSpecificPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration ").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOSearchRSOforSpecificPortRSQL").append("\n"); 
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
		query.append("SELECT    X.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("       ,  X.LOC_CD" ).append("\n"); 
		query.append("FROM      SCG_RGN_SHP_OPR_PORT  X" ).append("\n"); 
		query.append("WHERE     X.LOC_CD              = @[loc_cd]" ).append("\n"); 
		query.append("AND       X.DELT_FLG            = 'N'" ).append("\n"); 

	}
}
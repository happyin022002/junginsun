/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchVerifyResultDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchVerifyResultDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchVerifyResultDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchVerifyResultDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if(${searchVel}=='W')" ).append("\n"); 
		query.append("MNR_CD_DESC AS MNR_CD_DP_DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MNR_CD_DP_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM MNR_GEN_CD" ).append("\n"); 
		query.append(" WHERE PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("   AND MNR_CD_ID = @[searchkey]" ).append("\n"); 

	}
}
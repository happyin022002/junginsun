/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LocationDBDAOCheckSccCdMdmYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOCheckSccCdMdmYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_YARD Check
	  * </pre>
	  */
	public LocationDBDAOCheckSccCdMdmYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration ").append("\n"); 
		query.append("FileName : LocationDBDAOCheckSccCdMdmYardRSQL").append("\n"); 
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
		query.append("SELECT  EQ_SCC_CD" ).append("\n"); 
		query.append("  FROM  MDM_YARD" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  EQ_SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("   AND  DELT_FLG <> 'Y'" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchOfcLccCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchOfcLccCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchOfcLccCdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchOfcLccCdDataRSQL").append("\n"); 
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
		query.append("SELECT LCC_CD" ).append("\n"); 
		query.append("  FROM ( SELECT LCC_CD" ).append("\n"); 
		query.append("           FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("          WHERE SCC_CD = (SELECT SCC_CD" ).append("\n"); 
		query.append("                            FROM MDM_LOCATION" ).append("\n"); 
		query.append("                           WHERE LOC_CD = (SELECT LOC_CD" ).append("\n"); 
		query.append("                                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                            WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}
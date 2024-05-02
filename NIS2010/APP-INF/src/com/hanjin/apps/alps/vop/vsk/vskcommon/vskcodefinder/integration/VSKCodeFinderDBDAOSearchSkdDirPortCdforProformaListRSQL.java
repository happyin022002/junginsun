/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchSkdDirPortCdforProformaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchSkdDirPortCdforProformaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 Vessel Service Lane의 Proforma 데이터중 direction+port 조합으로 데이터 추출한다.
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchSkdDirPortCdforProformaListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchSkdDirPortCdforProformaListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("        X.SKD_DIR_CD	AS SKD_DIR_CD" ).append("\n"); 
		query.append("      , X.PORT_CD		AS VPS_PORT_CD" ).append("\n"); 
		query.append("FROM    VSK_PF_SKD_DTL   X" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     X.VSL_SLAN_CD    = @[vsl_slan_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY X.SKD_DIR_CD ASC" ).append("\n"); 
		query.append("      ,  X.PORT_CD    ASC" ).append("\n"); 

	}
}
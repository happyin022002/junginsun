/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchCostOfficeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchCostOfficeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CgmCodeMgtDB.SearchCostOfficeData
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchCostOfficeDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchCostOfficeDataRSQL").append("\n"); 
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
		query.append("#if (${chss_mgst_inv_knd_cd} == 'LS') " ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		A.AP_OFC_CD AS CODE1" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		MDM_ORGANIZATION A, " ).append("\n"); 
		query.append("    	MDM_LOCATION B " ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("    	AND A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	SELECT AP_OFC_CD AS CODE1" ).append("\n"); 
		query.append("	FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("	WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
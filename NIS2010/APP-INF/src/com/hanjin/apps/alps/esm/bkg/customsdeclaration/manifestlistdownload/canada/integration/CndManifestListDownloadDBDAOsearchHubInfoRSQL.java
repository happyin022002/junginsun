/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchHubInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchHubInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHubInfo
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchHubInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchHubInfoRSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR( MAX( NVL( POD_YD_NO, '  ') ||HUB_LOC_CD) , 3) HUB_LOC_CD" ).append("\n"); 
		query.append("      , SUBSTR( MAX( NVL( POD_YD_NO, '  ') ||GDS_DESC) , 3) GDS_DESC" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CND_GDS_LOC" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_yd_no} != '') " ).append("\n"); 
		query.append("AND     POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND     NVL(POD_YD_NO, 'NL' ) IN ('NL',SUBSTR(@[pod_yd_no], 6) )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND     POD_YD_NO IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     DEL_CD = @[del_cd]" ).append("\n"); 

	}
}
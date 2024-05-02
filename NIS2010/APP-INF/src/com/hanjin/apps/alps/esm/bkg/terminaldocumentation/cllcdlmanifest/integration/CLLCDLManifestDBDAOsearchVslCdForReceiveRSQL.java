/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchVslCdForReceiveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.10.21 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchVslCdForReceiveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVslCdForReceive
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchVslCdForReceiveRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("keyword",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchVslCdForReceiveRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD IN_VVDCLL" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE CALL_SGN_NO = RTRIM(@[keyword])" ).append("\n"); 
		query.append("AND '1' = @[search_gubun]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MAX(VSL_CD) IN_VVDCLL" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD LIKE RTRIM(@[keyword])||'%'" ).append("\n"); 
		query.append("AND '2' = @[search_gubun]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MAX(VSL_CD) IN_VVDCLL" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE	VSL_ENG_NM LIKE RTRIM(@[keyword])||'%'" ).append("\n"); 
		query.append("AND '3' = @[search_gubun]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT VSL_CD IN_VVDCLL" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE LLOYD_NO = RTRIM(@[keyword])" ).append("\n"); 
		query.append("AND '4' = @[search_gubun]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT VSL_CD IN_VVDCLL" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = RTRIM(@[keyword])" ).append("\n"); 
		query.append("AND '5' = @[search_gubun]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'CHIN' IN_VVDCLL" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_ENG_NM LIKE RTRIM(@[keyword])||'%'" ).append("\n"); 
		query.append("AND '6' = @[search_gubun]" ).append("\n"); 

	}
}
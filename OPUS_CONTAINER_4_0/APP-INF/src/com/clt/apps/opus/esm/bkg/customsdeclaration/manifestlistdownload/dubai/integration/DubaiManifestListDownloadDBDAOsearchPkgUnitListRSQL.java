/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiManifestListDownloadDBDAOsearchPkgUnitListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.04 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOsearchPkgUnitListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPkgUnitList
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOsearchPkgUnitListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOsearchPkgUnitListRSQL").append("\n"); 
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
		query.append("SELECT CNT_CD" ).append("\n"); 
		query.append("      ,ATTR_CTNT3" ).append("\n"); 
		query.append("      ,ATTR_CTNT1" ).append("\n"); 
		query.append("      ,ATTR_CTNT2" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CSTMS_DIV_ID" ).append("\n"); 
		query.append("      ,CSTMS_DIV_ID_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append(" WHERE CNT_CD = 'AE'" ).append("\n"); 
		query.append("   AND CSTMS_DIV_ID = 'DUBAI_PCK_CD'" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${attr_ctnt3} != '') " ).append("\n"); 
		query.append("   AND ATTR_CTNT3 = @[attr_ctnt3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt1} != '') " ).append("\n"); 
		query.append("   AND ATTR_CTNT1 = @[attr_ctnt1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY ATTR_CTNT1" ).append("\n"); 

	}
}
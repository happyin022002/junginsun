/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchVVDByPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.18 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Subin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchVVDByPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaVVDInfoVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchVVDByPodRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  V.VSL_CD," ).append("\n"); 
		query.append("V.SKD_VOY_NO," ).append("\n"); 
		query.append("V.SKD_DIR_CD," ).append("\n"); 
		query.append("B.SLAN_CD" ).append("\n"); 
		query.append("FROM    BKG_BOOKING B, BKG_VVD V" ).append("\n"); 
		query.append("WHERE   B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND		B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND     V.POD_CD = 'USLGB'" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchVVDByPodRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
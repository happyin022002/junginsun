/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOcheckUsPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.01.11 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOcheckUsPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkUsPort
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOcheckUsPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOcheckUsPortRSQL").append("\n"); 
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
		query.append("SELECT  VSL_CD" ).append("\n"); 
		query.append("FROM  (SELECT MIN(CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append(") CAPORT" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("WHERE	SKD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND  SKD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND  SKD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND  SKD.VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("AND  SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("AND  SKD.CLPT_SEQ < CAPORT.CLPT_SEQ" ).append("\n"); 
		query.append("AND  ROWNUM = 1" ).append("\n"); 

	}
}
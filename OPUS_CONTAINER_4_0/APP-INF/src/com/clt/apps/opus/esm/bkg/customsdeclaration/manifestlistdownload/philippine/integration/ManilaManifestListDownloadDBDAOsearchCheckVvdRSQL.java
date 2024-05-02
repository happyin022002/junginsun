/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManilaManifestListDownloadDBDAOsearchCheckVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.21 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class ManilaManifestListDownloadDBDAOsearchCheckVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 VVD 등록여부 체크
	  * </pre>
	  */
	public ManilaManifestListDownloadDBDAOsearchCheckVvdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});
 
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT 'x'  OK_FLAG" ).append("\n"); 
		query.append("FROM  dual" ).append("\n"); 
		query.append("WHERE EXISTS ( SELECT 'y'" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD    = @[skd_dir_cd])" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
		query.append("FileName : ManilaManifestListDownloadDBDAOsearchCheckVvdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
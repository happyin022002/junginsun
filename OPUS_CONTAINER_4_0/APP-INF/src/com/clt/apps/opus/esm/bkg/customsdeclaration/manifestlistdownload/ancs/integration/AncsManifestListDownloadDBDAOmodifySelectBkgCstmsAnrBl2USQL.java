/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOmodifySelectBkgCstmsAnrBl2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.09.30 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOmodifySelectBkgCstmsAnrBl2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * u
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOmodifySelectBkgCstmsAnrBl2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOmodifySelectBkgCstmsAnrBl2USQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ANR_BL_LOG A" ).append("\n"); 
		query.append("SET VVD_SEQ = (SELECT VVD_SEQ" ).append("\n"); 
		query.append("               FROM BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("               WHERE A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("               AND B.VSL_CD = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("			   AND B.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("			   AND B.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("               AND B.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 

	}
}
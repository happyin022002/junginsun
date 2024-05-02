/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArgManifestListDownloadDBDAOupdateInTransitArgBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.05.20 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArgManifestListDownloadDBDAOupdateInTransitArgBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsArgBl
	  * </pre>
	  */
	public ArgManifestListDownloadDBDAOupdateInTransitArgBlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.integration").append("\n"); 
		query.append("FileName : ArgManifestListDownloadDBDAOupdateInTransitArgBlCSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ARG_BL" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("  IN_TZ_FLG = NVL(@[in_tz_flg],'N')" ).append("\n"); 
		query.append(" ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(" ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]" ).append("\n"); 

	}
}
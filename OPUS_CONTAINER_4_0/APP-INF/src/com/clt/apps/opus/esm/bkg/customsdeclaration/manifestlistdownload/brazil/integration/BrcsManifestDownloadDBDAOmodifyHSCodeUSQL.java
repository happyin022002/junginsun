/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrcsManifestDownloadDBDAOmodifyHSCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsManifestDownloadDBDAOmodifyHSCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HS CODE 를 수정한다.
	  * </pre>
	  */
	public BrcsManifestDownloadDBDAOmodifyHSCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cate_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brz_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration").append("\n"); 
		query.append("FileName : BrcsManifestDownloadDBDAOmodifyHSCodeUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_CMDT" ).append("\n"); 
		query.append("SET CMDT_DESC = @[cmdt_desc]" ).append("\n"); 
		query.append("	, CMDT_CATE_CTNT = @[cmdt_cate_ctnt]" ).append("\n"); 
		query.append("	, UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	, UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE CNT_CD = 'BR'" ).append("\n"); 
		query.append("AND MF_CMDT_CD = @[brz_cmdt_cd]" ).append("\n"); 

	}
}
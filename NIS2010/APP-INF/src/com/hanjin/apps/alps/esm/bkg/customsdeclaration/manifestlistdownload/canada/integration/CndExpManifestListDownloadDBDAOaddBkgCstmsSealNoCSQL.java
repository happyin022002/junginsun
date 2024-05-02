/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOaddBkgCstmsSealNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.24 
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

public class CndExpManifestListDownloadDBDAOaddBkgCstmsSealNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsSealNo
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOaddBkgCstmsSealNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("seal_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOaddBkgCstmsSealNoCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO  BKG_CSTMS_SEAL_NO" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        CNT_CD" ).append("\n"); 
		query.append("       ,CSTMS_DIV_ID" ).append("\n"); 
		query.append("       ,BL_NO" ).append("\n"); 
		query.append("       ,CNTR_NO" ).append("\n"); 
		query.append("       ,SEAL_NO_SEQ" ).append("\n"); 
		query.append("       ,SEAL_NO" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("        @[cnt_cd]" ).append("\n"); 
		query.append("       ,@[cstms_div_id]" ).append("\n"); 
		query.append("       ,@[bl_no]" ).append("\n"); 
		query.append("       ,@[cntr_no]" ).append("\n"); 
		query.append("       ,@[seal_no_seq]" ).append("\n"); 
		query.append("       ,@[seal_no]" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ) " ).append("\n"); 

	}
}
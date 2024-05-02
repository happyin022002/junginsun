/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOaddJpcusBlMdCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.19
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOaddJpcusBlMdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addJpcusBlMd
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOaddJpcusBlMdCSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO BKG_CSTMS_JP_BL_MK (" ).append("\n");
		query.append("BL_NO" ).append("\n");
		query.append(",	BL_SPLIT_NO" ).append("\n");
		query.append(",	BL_SEQ" ).append("\n");
		query.append(",	DIFF_RMK" ).append("\n");
		query.append(",	BL_DESC" ).append("\n");
		query.append(",	CRE_USR_ID" ).append("\n");
		query.append(",	CRE_DT" ).append("\n");
		query.append(",	UPD_USR_ID" ).append("\n");
		query.append(",	UPD_DT" ).append("\n");
		query.append(") VALUES(" ).append("\n");
		query.append("@[bl_no]" ).append("\n");
		query.append(",	DECODE(NVL(@[bl_split_no],'  '),'  ','  ',LPAD(TO_CHAR(NVL((@[bl_split_no]),0)),2,0))" ).append("\n");
		query.append(",	@[bl_seq]" ).append("\n");
		query.append(",	@[diff_rmk]" ).append("\n");
		query.append(",	@[bl_desc]" ).append("\n");
		query.append(",	@[cre_usr_id]" ).append("\n");
		query.append(",	SYSDATE" ).append("\n");
		query.append(",	@[cre_usr_id]" ).append("\n");
		query.append(",	SYSDATE" ).append("\n");
		query.append(")" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n");
		query.append("FileName : JapanManifestListDownloadDBDAOaddJpcusBlMdCSQL").append("\n");
		query.append("*/").append("\n");
	}
}
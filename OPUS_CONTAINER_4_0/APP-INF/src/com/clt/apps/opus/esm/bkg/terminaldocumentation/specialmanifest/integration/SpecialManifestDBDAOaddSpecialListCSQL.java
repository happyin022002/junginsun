/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAOaddSpecialListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier :
*@LastVersion : 1.0
* 2009.08.07
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOaddSpecialListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * special UN No 정보를 저장한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOaddSpecialListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_id_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n");
		query.append("FileName : SpecialManifestDBDAOaddSpecialListCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_EUR_DG_SPCL (" ).append("\n");
		query.append("CRE_DT" ).append("\n");
		query.append(",	UPD_USR_ID" ).append("\n");
		query.append(",	UPD_DT" ).append("\n");
		query.append(",	IMDG_UN_NO" ).append("\n");
		query.append(",	SPCL_ID_DESC" ).append("\n");
		query.append(",	CRE_USR_ID" ).append("\n");
		query.append(",   ANR_SPCL_TP_ID" ).append("\n");
		query.append(") VALUES(" ).append("\n");
		query.append("SYSDATE" ).append("\n");
		query.append(",	@[upd_usr_id]" ).append("\n");
		query.append(",	SYSDATE" ).append("\n");
		query.append(",	@[imdg_un_no]" ).append("\n");
		query.append(",	@[spcl_id_desc]" ).append("\n");
		query.append(",	@[cre_usr_id]" ).append("\n");
		query.append(",   SUBSTR(@[spcl_id_desc], 1,3)" ).append("\n");
		query.append(")" ).append("\n");

	}
}
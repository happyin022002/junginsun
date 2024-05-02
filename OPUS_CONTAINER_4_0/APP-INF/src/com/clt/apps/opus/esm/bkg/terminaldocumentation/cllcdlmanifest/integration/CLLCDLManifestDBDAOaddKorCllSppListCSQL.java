/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOaddKorCllSppListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.15
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOaddKorCllSppListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addKorCllSppList
	  * </pre>
	  */
	public CLLCDLManifestDBDAOaddKorCllSppListCSQL(){
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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOaddKorCllSppListCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_CD_CONV_CTNT" ).append("\n");
		query.append("(" ).append("\n");
		query.append("CNT_CD" ).append("\n");
		query.append(",   CSTMS_DIV_ID" ).append("\n");
		query.append(",   CSTMS_DIV_ID_SEQ" ).append("\n");
		query.append(",   ATTR_CTNT1" ).append("\n");
		query.append(",   ATTR_CTNT2" ).append("\n");
		query.append(",   DELT_FLG" ).append("\n");
		query.append(",   UPD_USR_ID" ).append("\n");
		query.append(",   UPD_DT" ).append("\n");
		query.append(",   CRE_USR_ID" ).append("\n");
		query.append(",   CRE_DT" ).append("\n");
		query.append(")" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("(" ).append("\n");
		query.append("@[cnt_cd]" ).append("\n");
		query.append(",   @[cstms_div_id]" ).append("\n");
		query.append(",   (SELECT NVL(MAX(CSTMS_DIV_ID_SEQ), 0) + 1 CSTMS_DIV_ID_SEQ" ).append("\n");
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n");
		query.append("WHERE CNT_CD = @[cnt_cd]" ).append("\n");
		query.append("AND CSTMS_DIV_ID = @[cstms_div_id])" ).append("\n");
		query.append(",    @[attr_ctnt1]" ).append("\n");
		query.append(",    @[attr_ctnt2]" ).append("\n");
		query.append(",    @[delt_flg]" ).append("\n");
		query.append(",    @[upd_usr_id]" ).append("\n");
		query.append(",    SYSDATE" ).append("\n");
		query.append(",    @[cre_usr_id]" ).append("\n");
		query.append(",    SYSDATE" ).append("\n");
		query.append(")" ).append("\n");

	}
}
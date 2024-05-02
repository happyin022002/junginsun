/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOaddBlMdListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.02
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOaddBlMdListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addBlMdList
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOaddBlMdListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_mk_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_mk_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chn_mf_snd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOaddBlMdListCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_CHN_MK (" ).append("\n");
		query.append("BL_NO," ).append("\n");
		query.append("BL_MK_SEQ," ).append("\n");
		query.append("BL_MK_DESC," ).append("\n");
		query.append("CHN_BL_CLSS_CD, -- 데이터 존재하면 무조건 '1'" ).append("\n");
		query.append("CHN_MF_SND_IND_CD," ).append("\n");
		query.append("CRE_DT," ).append("\n");
		query.append("CRE_USR_ID," ).append("\n");
		query.append("UPD_DT," ).append("\n");
		query.append("UPD_USR_ID )" ).append("\n");
		query.append("VALUES (" ).append("\n");
		query.append("@[bl_no]," ).append("\n");
		query.append("@[bl_mk_seq]," ).append("\n");
		query.append("@[bl_mk_desc]," ).append("\n");
		query.append("'1'," ).append("\n");
		query.append("@[chn_mf_snd_ind_cd]," ).append("\n");
		query.append("SYSDATE," ).append("\n");
		query.append("@[cre_usr_id]," ).append("\n");
		query.append("SYSDATE," ).append("\n");
		query.append("@[upd_usr_id]" ).append("\n");
		query.append(")" ).append("\n");

	}
}
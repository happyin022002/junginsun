/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOaddBlDlHisCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.12.22 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOaddBlDlHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addBlDlHis
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOaddBlDlHisCSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOaddBlDlHisCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_CHN_DL_HIS (" ).append("\n");
		query.append("	CHN_MF_SND_IND_CD," ).append("\n");
		query.append("	BL_NO," ).append("\n");
		query.append("	VSL_CD," ).append("\n");
		query.append("	SKD_VOY_NO," ).append("\n");
		query.append("    SKD_DIR_CD," ).append("\n");
		query.append("    DL_SEQ," ).append("\n");
		query.append("    POL_CD," ).append("\n");
		query.append("	POD_CD," ).append("\n");
		query.append("	OFC_CD," ).append("\n");
		query.append("	DELT_FLG," ).append("\n");
		query.append("	MF_DL_DT," ).append("\n");
		query.append("	CRE_DT," ).append("\n");
		query.append("	CRE_USR_ID," ).append("\n");
		query.append("	UPD_DT," ).append("\n");
		query.append("	UPD_USR_ID )" ).append("\n");
		query.append("VALUES (" ).append("\n");
		query.append("    @[chn_mf_snd_ind_cd]," ).append("\n");
		query.append("	@[bl_no]," ).append("\n");
		query.append("	@[vsl_cd]," ).append("\n");
		query.append("	@[skd_voy_no]," ).append("\n");
		query.append("    @[skd_dir_cd]," ).append("\n");
		query.append("	NVL((SELECT MAX(TO_number(DL_SEQ))" ).append("\n");
		query.append("		     FROM BKG_CSTMS_CHN_DL_HIS A" ).append("\n");
		query.append("		     WHERE 1=1" ).append("\n");
		query.append("		     AND CHN_MF_SND_IND_CD = @[chn_mf_snd_ind_cd]" ).append("\n");
		query.append("		     AND BL_NO = @[bl_no]" ).append("\n");
		query.append("			 AND VSL_CD = @[vsl_cd]" ).append("\n");
		query.append("			 AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n");
		query.append("    		 AND SKD_DIR_CD = @[skd_dir_cd] ), 0)+1," ).append("\n");
		query.append("    @[pol_cd]," ).append("\n");
		query.append("	@[pod_cd]," ).append("\n");
		query.append("	@[bl_iss_ofc_cd]," ).append("\n");
		query.append("	'N'," ).append("\n");
		query.append("	SYSDATE," ).append("\n");
		query.append("	SYSDATE," ).append("\n");
		query.append("	@[cre_usr_id]," ).append("\n");
		query.append("	SYSDATE," ).append("\n");
		query.append("	@[upd_usr_id]" ).append("\n");
		query.append(")" ).append("\n");

	}
}
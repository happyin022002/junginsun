/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOaddBlCntrDgListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.02.06 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOaddBlCntrDgListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addBlCntrDgList
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOaddBlCntrDgListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_telcm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chn_mf_snd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ems_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flsh_pnt_cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOaddBlCntrDgListCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_CHN_DG_CGO (" ).append("\n");
		query.append("BL_NO," ).append("\n");
		query.append("DCGO_SEQ," ).append("\n");
		query.append("IMDG_UN_NO," ).append("\n");
		query.append("IMDG_CLSS_CD," ).append("\n");
		query.append("CNTR_NO," ).append("\n");
		query.append("IMDG_PG_NO," ).append("\n");
		query.append("IMDG_SUBS_RSK_LBL_CD," ).append("\n");
		query.append("CNTC_PSON_TELCM_NO," ).append("\n");
		query.append("CNTC_PSON_NM," ).append("\n");
		query.append("CHN_MF_SND_IND_CD," ).append("\n");
		query.append("FLSH_PNT_CDO_TEMP," ).append("\n");
		query.append("EMS_NO," ).append("\n");
		query.append("CRE_DT," ).append("\n");
		query.append("CRE_USR_ID," ).append("\n");
		query.append("UPD_DT," ).append("\n");
		query.append("UPD_USR_ID )" ).append("\n");
		query.append("VALUES (" ).append("\n");
		query.append("@[bl_no]," ).append("\n");
		query.append("@[dcgo_seq]," ).append("\n");
		query.append("@[imdg_un_no]," ).append("\n");
		query.append("@[imdg_clss_cd]," ).append("\n");
		query.append("@[cntr_no]," ).append("\n");
		query.append("NVL(@[imdg_pg_no], ' ')," ).append("\n");
		query.append("@[imdg_subs_rsk_lbl_cd]," ).append("\n");
		query.append("SUBSTR(@[cntc_pson_telcm_no],1,50)," ).append("\n");
		query.append("@[cntc_pson_nm]," ).append("\n");
		query.append("@[chn_mf_snd_ind_cd]," ).append("\n");
		query.append("@[flsh_pnt_cdo_temp]," ).append("\n");
		query.append("@[ems_no]," ).append("\n");
		query.append("SYSDATE," ).append("\n");
		query.append("@[cre_usr_id]," ).append("\n");
		query.append("SYSDATE," ).append("\n");
		query.append("@[upd_usr_id]" ).append("\n");
		query.append(")" ).append("\n");

	}
}
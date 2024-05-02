/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOmodifyBlGeneralUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.05
*@LastModifier :
*@LastVersion : 1.0
* 2013.08.05
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOmodifyBlGeneralUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * modifyBlGeneral
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOmodifyBlGeneralUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chn_mf_snd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOmodifyBlGeneralUSQL").append("\n");
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
		query.append("UPDATE	BKG_CSTMS_CHN_BL" ).append("\n");
		query.append("SET	BKG_POL_CD		   =	NVL(@[bkg_pol_cd],' ')," ).append("\n");
		query.append("	BKG_POD_CD		   =	@[bkg_pod_cd]," ).append("\n");
		query.append("	POR_CD			   =	@[por_cd]," ).append("\n");
		query.append("	POL_CD			   =	@[pol_cd]," ).append("\n");
		query.append("	POD_CD			   =	@[pod_cd]," ).append("\n");
		query.append("	DEL_CD			   =	@[del_cd]," ).append("\n");
		query.append("	BL_ISS_DT		   =	TO_DATE(REPLACE(@[bl_iss_dt], '-', ''), 'YYYYMMDD')," ).append("\n");
		query.append("	BL_OBRD_DT		   =	TO_DATE(REPLACE(@[bl_obrd_dt], '-', ''), 'YYYYMMDD')," ).append("\n");
		query.append("	CHN_CSTMS_TRSP_MOD_CD =	@[chn_cstms_trsp_mod_cd]," ).append("\n");
		query.append("	RCV_TERM_CD		   =	@[rcv_term_cd]," ).append("\n");
		query.append("	DE_TERM_CD		   =	@[de_term_cd]," ).append("\n");
		query.append("	FRT_TERM_CD        =    decode(@[frt_term_cd], ' ', null, @[frt_term_cd])," ).append("\n");
		query.append("	CSTMS_DESC		   =	@[cstms_desc]," ).append("\n");
		query.append("	PCK_QTY			   =	NVL(REPLACE(@[pck_qty], ',', ''), 0)," ).append("\n");
		query.append("	PCK_TP_CD		   =	@[pck_tp_cd]," ).append("\n");
		query.append("	ACT_WGT			   =	NVL(REPLACE(@[act_wgt], ',', ''), 0)," ).append("\n");
		query.append("	WGT_UT_CD		   =	decode(@[wgt_ut_cd], ' ', null, @[wgt_ut_cd])," ).append("\n");
		query.append("	MEAS_QTY		   =	NVL(REPLACE(@[meas_qty], ',', ''), 0)," ).append("\n");
		query.append("	MEAS_UT_CD         =    decode(@[meas_ut_cd], ' ', null, @[meas_ut_cd])," ).append("\n");
		query.append("	UPD_DT		       =	SYSDATE," ).append("\n");
		query.append("	UPD_USR_ID		   =	@[upd_usr_id]" ).append("\n");
		query.append("WHERE	BL_NO		   =	@[bl_no]" ).append("\n");
		query.append("AND	CHN_MF_SND_IND_CD  =	@[chn_mf_snd_ind_cd]" ).append("\n");

	}
}
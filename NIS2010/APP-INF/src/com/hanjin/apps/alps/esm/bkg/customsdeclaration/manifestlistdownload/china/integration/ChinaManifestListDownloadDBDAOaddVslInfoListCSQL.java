/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOaddVslInfoListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.23
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.06.23 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOaddVslInfoListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addVslInfoList
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOaddVslInfoListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_clpt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chn_mf_snd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_call_sgn_port_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nxt_clpt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOaddVslInfoListCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_CHN_VVD (" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("PORT_CD," ).append("\n"); 
		query.append("PRE_CLPT_CD," ).append("\n"); 
		query.append("NXT_CLPT_CD," ).append("\n"); 
		query.append("VSL_NM," ).append("\n"); 
		query.append("CALL_SGN_NO," ).append("\n"); 
		query.append("ETA_DT," ).append("\n"); 
		query.append("ETD_DT," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("--MF_SND_DT," ).append("\n"); 
		query.append("--MF_SND_USR_ID," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("LLOYD_NO," ).append("\n"); 
		query.append("ETB_DT )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[vsl_cd]									VSL_CD," ).append("\n"); 
		query.append("@[skd_voy_no]								SKD_VOY_NO," ).append("\n"); 
		query.append("@[skd_dir_cd]								SKD_DIR_CD," ).append("\n"); 
		query.append("@[port_cd]									PORT_CD," ).append("\n"); 
		query.append("@[pre_clpt_cd]								PRE_CLPT_CD," ).append("\n"); 
		query.append("@[nxt_clpt_cd]								NXT_CLPT_CD," ).append("\n"); 
		query.append("@[vsl_nm]									VSL_NM," ).append("\n"); 
		query.append("@[vsl_call_sgn_port_loc_cd]					CALL_SGN_NO," ).append("\n"); 
		query.append("TO_DATE(@[eta_dt], 'YYYYMMDD HH24MISS')		ETA_DT," ).append("\n"); 
		query.append("TO_DATE(@[etd_dt], 'YYYYMMDD HH24MISS')		ETD_DT," ).append("\n"); 
		query.append("SYSDATE										CRE_DT," ).append("\n"); 
		query.append("@[cre_usr_id]								CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE										UPD_DT," ).append("\n"); 
		query.append("@[upd_usr_id]								UPD_USR_ID," ).append("\n"); 
		query.append("@[slan_cd]									SLAN_CD," ).append("\n"); 
		query.append("@[chn_mf_snd_ind_cd]						CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("@[lloyd_no]									LLOYD_NO," ).append("\n"); 
		query.append("TO_DATE(@[etb_dt], 'YYYYMMDD HH24MISS')		ETB_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(CHN_MF_SND_IND_CD) AS CNT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CHN_VVD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("AND CHN_MF_SND_IND_CD = @[chn_mf_snd_ind_cd]" ).append("\n"); 
		query.append("AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.CNT = 0" ).append("\n"); 

	}
}
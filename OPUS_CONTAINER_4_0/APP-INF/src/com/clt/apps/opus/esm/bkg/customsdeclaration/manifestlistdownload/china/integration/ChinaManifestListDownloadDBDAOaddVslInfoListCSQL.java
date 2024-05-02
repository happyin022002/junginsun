/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOaddVslInfoListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18 
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
		params.put("bkg_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_CHN_VVD" ).append("\n"); 
		query.append("       (VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        PORT_CD," ).append("\n"); 
		query.append("        PRE_CLPT_CD," ).append("\n"); 
		query.append("        NXT_CLPT_CD," ).append("\n"); 
		query.append("        VSL_NM," ).append("\n"); 
		query.append("        CALL_SGN_NO," ).append("\n"); 
		query.append("        ETA_DT," ).append("\n"); 
		query.append("        ETD_DT," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        --MF_SND_DT," ).append("\n"); 
		query.append("        --MF_SND_USR_ID," ).append("\n"); 
		query.append("        SLAN_CD," ).append("\n"); 
		query.append("        CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("        LLOYD_NO," ).append("\n"); 
		query.append("        ETB_DT," ).append("\n"); 
		query.append("        BKG_VSL_CD," ).append("\n"); 
		query.append("        BKG_SKD_VOY_NO," ).append("\n"); 
		query.append("        BKG_SKD_DIR_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" SELECT @[vsl_cd] AS VSL_CD," ).append("\n"); 
		query.append("        @[skd_voy_no] AS SKD_VOY_NO," ).append("\n"); 
		query.append("        @[skd_dir_cd] AS SKD_DIR_CD," ).append("\n"); 
		query.append("        @[port_cd] AS PORT_CD," ).append("\n"); 
		query.append("        @[pre_clpt_cd] AS PRE_CLPT_CD," ).append("\n"); 
		query.append("        @[nxt_clpt_cd] AS NXT_CLPT_CD," ).append("\n"); 
		query.append("        @[vsl_nm] AS VSL_NM," ).append("\n"); 
		query.append("        @[call_sgn_no] AS CALL_SGN_NO," ).append("\n"); 
		query.append("        TO_DATE(@[eta_dt], 'YYYYMMDD HH24MISS') AS ETA_DT," ).append("\n"); 
		query.append("        TO_DATE(@[etd_dt], 'YYYYMMDD HH24MISS') AS ETD_DT," ).append("\n"); 
		query.append("        SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("        @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("        @[upd_usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("        @[slan_cd] AS SLAN_CD," ).append("\n"); 
		query.append("        @[chn_mf_snd_ind_cd] AS CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("        @[lloyd_no] AS LLOYD_NO," ).append("\n"); 
		query.append("        TO_DATE(@[etb_dt], 'YYYYMMDD HH24MISS') AS ETB_DT," ).append("\n"); 
		query.append("        @[bkg_vsl_cd] AS BKG_VSL_CD," ).append("\n"); 
		query.append("        @[bkg_skd_voy_no] AS BKG_SKD_VOY_NO," ).append("\n"); 
		query.append("        @[bkg_skd_dir_cd] AS BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   FROM (SELECT COUNT(CHN_MF_SND_IND_CD) AS CNT" ).append("\n"); 
		query.append("           FROM BKG_CSTMS_CHN_VVD" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND CHN_MF_SND_IND_CD = @[chn_mf_snd_ind_cd]" ).append("\n"); 
		query.append("            AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("            AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("            AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("            AND PORT_CD = @[port_cd]) A" ).append("\n"); 
		query.append("  WHERE A.CNT = 0" ).append("\n"); 

	}
}
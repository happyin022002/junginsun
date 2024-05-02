/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOaddBlAwkardCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.06.02 민정호
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

public class ChinaManifestListDownloadDBDAOaddBlAwkardCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBlAwkardCntr
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOaddBlAwkardCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_dim_rt_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_dim_lf_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_dim_fnt_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_hgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_dim_rear_len",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOaddBlAwkardCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_CHN_AWK (" ).append("\n"); 
		query.append("CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("BL_NO," ).append("\n"); 
		query.append("AWK_SEQ_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("OVR_DIM_FNT_LEN," ).append("\n"); 
		query.append("OVR_DIM_REAR_LEN," ).append("\n"); 
		query.append("OVR_HGT," ).append("\n"); 
		query.append("OVR_DIM_LF_LEN," ).append("\n"); 
		query.append("OVR_DIM_RT_LEN," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT  )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[chn_mf_snd_ind_cd]," ).append("\n"); 
		query.append("@[bl_no]," ).append("\n"); 
		query.append("NVL((SELECT MAX(TO_number(AWK_SEQ_NO))" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CHN_AWK A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CHN_MF_SND_IND_CD = @[chn_mf_snd_ind_cd]" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]), 0)+1," ).append("\n"); 
		query.append("@[cntr_no]," ).append("\n"); 
		query.append("DECODE(@[ovr_dim_fnt_len], 0, '', @[ovr_dim_fnt_len])," ).append("\n"); 
		query.append("DECODE(@[ovr_dim_rear_len], 0, '', @[ovr_dim_rear_len])," ).append("\n"); 
		query.append("DECODE(@[ovr_hgt], 0, '', @[ovr_hgt])," ).append("\n"); 
		query.append("DECODE(@[ovr_dim_lf_len], 0, '', @[ovr_dim_lf_len])," ).append("\n"); 
		query.append("DECODE(@[ovr_dim_rt_len], 0, '', @[ovr_dim_rt_len])," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE	 )" ).append("\n"); 

	}
}
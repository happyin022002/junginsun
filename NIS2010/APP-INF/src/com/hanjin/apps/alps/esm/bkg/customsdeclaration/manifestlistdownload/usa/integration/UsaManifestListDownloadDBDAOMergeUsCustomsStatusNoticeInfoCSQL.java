/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOMergeUsCustomsStatusNoticeInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOMergeUsCustomsStatusNoticeInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Save Customs Status Notice Set-Up
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOMergeUsCustomsStatusNoticeInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auto_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ntc_msg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOMergeUsCustomsStatusNoticeInfoCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_NTC_STUP TAR" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT  @[hndl_ofc_cd] HNDL_OFC_CD," ).append("\n"); 
		query.append("            @[ntc_msg_tp_cd] NTC_MSG_TP_CD," ).append("\n"); 
		query.append("            @[auto_snd_flg] AUTO_SND_FLG," ).append("\n"); 
		query.append("            @[hndl_ofc_addr] HNDL_OFC_ADDR, " ).append("\n"); 
		query.append("            @[hndl_ofc_eml] HNDL_OFC_EML," ).append("\n"); 
		query.append("            @[cstms_ntc_msg] CSTMS_NTC_MSG,            " ).append("\n"); 
		query.append("            @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("            @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("   ) SRC" ).append("\n"); 
		query.append("   ON (TAR.HNDL_OFC_CD = SRC.HNDL_OFC_CD AND TAR.NTC_MSG_TP_CD = SRC.NTC_MSG_TP_CD )" ).append("\n"); 
		query.append("   WHEN MATCHED THEN " ).append("\n"); 
		query.append("     UPDATE SET " ).append("\n"); 
		query.append("        TAR.AUTO_SND_FLG = SRC.AUTO_SND_FLG," ).append("\n"); 
		query.append("        TAR.HNDL_OFC_ADDR = HNDL_OFC_ADDR," ).append("\n"); 
		query.append("        TAR.HNDL_OFC_EML = HNDL_OFC_EML," ).append("\n"); 
		query.append("        TAR.CSTMS_NTC_MSG = CSTMS_NTC_MSG," ).append("\n"); 
		query.append("        TAR.UPD_USR_ID = SRC.UPD_USR_ID," ).append("\n"); 
		query.append("        TAR.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("     WHERE TAR.HNDL_OFC_CD = SRC.HNDL_OFC_CD AND TAR.NTC_MSG_TP_CD = SRC.NTC_MSG_TP_CD" ).append("\n"); 
		query.append("   WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("     INSERT (TAR.HNDL_OFC_CD,TAR.AUTO_SND_FLG,TAR.HNDL_OFC_ADDR,TAR.HNDL_OFC_EML,TAR.NTC_MSG_TP_CD,TAR.CSTMS_NTC_MSG,TAR.CRE_USR_ID,TAR.UPD_USR_ID)" ).append("\n"); 
		query.append("     VALUES (SRC.HNDL_OFC_CD,SRC.AUTO_SND_FLG,SRC.HNDL_OFC_ADDR,SRC.HNDL_OFC_EML,SRC.NTC_MSG_TP_CD,SRC.CSTMS_NTC_MSG,SRC.CRE_USR_ID,SRC.UPD_USR_ID)" ).append("\n"); 

	}
}
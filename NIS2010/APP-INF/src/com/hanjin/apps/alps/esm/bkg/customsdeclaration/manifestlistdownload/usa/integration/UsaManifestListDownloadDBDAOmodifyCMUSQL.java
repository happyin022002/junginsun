/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyCMUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.22 
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

public class UsaManifestListDownloadDBDAOmodifyCMUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCM
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyCMUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prior_ntc_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prior_ntc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ams_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_gds_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prior_ntc_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prior_ntc_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mk_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyCMUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_ADV_CNTR_MF MF" ).append("\n"); 
		query.append("USING ( " ).append("\n"); 
		query.append("    SELECT @[cnt_cd] AS CNT_CD, " ).append("\n"); 
		query.append("           @[bl_no] AS BL_NO, " ).append("\n"); 
		query.append("           @[cmdt_gds_seq] AS CMDT_GDS_SEQ," ).append("\n"); 
		query.append("           @[cntr_no] AS CNTR_NO" ).append("\n"); 
		query.append("    FROM DUAL " ).append("\n"); 
		query.append(") TM" ).append("\n"); 
		query.append("ON ( MF.CNT_CD       = TM.CNT_CD        AND " ).append("\n"); 
		query.append("     MF.BL_NO        = TM.BL_NO         AND " ).append("\n"); 
		query.append("     MF.CMDT_GDS_SEQ = TM.CMDT_GDS_SEQ  AND " ).append("\n"); 
		query.append("     MF.CNTR_NO      = TM.CNTR_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE     " ).append("\n"); 
		query.append("        SET      UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("        ,        UPD_DT = SYSDATE" ).append("\n"); 
		query.append("        ,        PCK_QTY = NVL(@[pck_qty], 0)" ).append("\n"); 
		query.append("        ,        AMS_PCK_TP_CD = @[ams_pck_tp_cd]" ).append("\n"); 
		query.append("        ,        GRS_WGT = NVL(@[grs_wgt], 0)" ).append("\n"); 
		query.append("        ,        WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append("        ,        MK_DESC = @[mk_desc]" ).append("\n"); 
		query.append("        ,        CGO_DESC = @[cgo_desc]" ).append("\n"); 
		query.append("        ,        HAMO_CMDT_CD = @[hamo_cmdt_cd]" ).append("\n"); 
		query.append("        ,        PRIOR_NTC_SND_FLG = NVL(@[prior_ntc_snd_flg], 'N')" ).append("\n"); 
		query.append("        ,        PRIOR_NTC_CFM_FLG =  DECODE(@[prior_ntc_cfm_flg],'0','N','1','Y')" ).append("\n"); 
		query.append("        ,        PRIOR_NTC_CFM_DT = TO_DATE(@[prior_ntc_cfm_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("        ,        PRIOR_NTC_RMK = @[prior_ntc_rmk]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT ( CNT_CD" ).append("\n"); 
		query.append("                ,BL_NO" ).append("\n"); 
		query.append("                ,CMDT_GDS_SEQ" ).append("\n"); 
		query.append("                ,CNTR_NO" ).append("\n"); 
		query.append("                ,PCK_QTY" ).append("\n"); 
		query.append("                ,AMS_PCK_TP_CD" ).append("\n"); 
		query.append("                ,GRS_WGT" ).append("\n"); 
		query.append("                ,WGT_UT_CD" ).append("\n"); 
		query.append("                ,MK_DESC" ).append("\n"); 
		query.append("                ,CGO_DESC" ).append("\n"); 
		query.append("                ,HAMO_CMDT_CD" ).append("\n"); 
		query.append("                ,PRIOR_NTC_SND_FLG" ).append("\n"); 
		query.append("                ,PRIOR_NTC_CFM_FLG" ).append("\n"); 
		query.append("                ,PRIOR_NTC_CFM_DT" ).append("\n"); 
		query.append("                ,PRIOR_NTC_RMK" ).append("\n"); 
		query.append("                ,CRE_USR_ID" ).append("\n"); 
		query.append("                ,CRE_DT" ).append("\n"); 
		query.append("                ,UPD_USR_ID" ).append("\n"); 
		query.append("                ,UPD_DT )" ).append("\n"); 
		query.append("        VALUES ( @[cnt_cd]" ).append("\n"); 
		query.append("                ,@[bl_no]" ).append("\n"); 
		query.append("                ,NVL((SELECT /*+ index_desc(A XPKBKG_CSTMS_ADV_CNTR_MF MF) */   " ).append("\n"); 
		query.append("                             CMDT_GDS_SEQ " ).append("\n"); 
		query.append("                      FROM   BKG_CSTMS_ADV_CNTR_MF A" ).append("\n"); 
		query.append("                      WHERE  1=1" ).append("\n"); 
		query.append("                      AND	 CNT_CD = @[cnt_cd]  " ).append("\n"); 
		query.append("                      AND    BL_NO = @[bl_no] " ).append("\n"); 
		query.append("                      AND    ROWNUM = 1   " ).append("\n"); 
		query.append("                    ),0)+1" ).append("\n"); 
		query.append("                ,@[cntr_no]" ).append("\n"); 
		query.append("                ,NVL(@[pck_qty], 0)" ).append("\n"); 
		query.append("                ,@[ams_pck_tp_cd]" ).append("\n"); 
		query.append("                ,NVL(@[grs_wgt], 0)" ).append("\n"); 
		query.append("                ,@[wgt_ut_cd]" ).append("\n"); 
		query.append("                ,@[mk_desc]" ).append("\n"); 
		query.append("                ,@[cgo_desc]" ).append("\n"); 
		query.append("                ,@[hamo_cmdt_cd]" ).append("\n"); 
		query.append("                ,NVL(@[prior_ntc_snd_flg], 'N')" ).append("\n"); 
		query.append("                ,DECODE(@[prior_ntc_cfm_flg],'0','N','1','Y')" ).append("\n"); 
		query.append("                ,TO_DATE(@[prior_ntc_cfm_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                ,@[prior_ntc_rmk]" ).append("\n"); 
		query.append("                ,@[usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE" ).append("\n"); 
		query.append("                ,@[usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE )" ).append("\n"); 

	}
}
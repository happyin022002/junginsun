/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PickUpNoticeDBDAOmergePkupNtcStupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOmergePkupNtcStupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PickNotice Form Setting정보를 등록한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOmergePkupNtcStupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("auto_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_ntc_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_snd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_tit_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foc_clr_rmk_stup_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eclz_obl_cpy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("each_foc_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trkr_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOmergePkupNtcStupCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_PKUP_NTC_STUP A " ).append("\n"); 
		query.append("USING (SELECT @[pkup_ntc_snd_tp_cd] AS PKUP_NTC_SND_TP_CD," ).append("\n"); 
		query.append("              @[ofc_cd]             AS OFC_CD," ).append("\n"); 
		query.append("              DECODE(nvl(@[del_cd],'ALL'),'ALL','*',@[del_cd]) AS DEL_CD," ).append("\n"); 
		query.append("              @[auto_ntc_flg]       AS AUTO_NTC_FLG," ).append("\n"); 
		query.append("              @[each_foc_ntc_flg]   AS EACH_FOC_NTC_FLG," ).append("\n"); 
		query.append("              @[trkr_ntc_flg]       AS TRKR_NTC_FLG," ).append("\n"); 
		query.append("              @[auto_ntc_yd_flg]    AS AUTO_NTC_YD_FLG," ).append("\n"); 
		query.append("              @[eclz_obl_cpy_flg]   AS ECLZ_OBL_CPY_FLG," ).append("\n"); 
		query.append("              @[foc_clr_rmk_stup_flg] AS FOC_CLR_RMK_STUP_FLG," ).append("\n"); 
		query.append("              @[hd_tit_ctnt]        AS HD_TIT_CTNT," ).append("\n"); 
		query.append("              @[cre_usr_id]         AS CRE_USR_ID," ).append("\n"); 
		query.append("              @[upd_usr_id]         AS UPD_USR_ID" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (A.PKUP_NTC_SND_TP_CD = B.PKUP_NTC_SND_TP_CD" ).append("\n"); 
		query.append("    AND A.OFC_CD         = B.OFC_CD" ).append("\n"); 
		query.append("    AND A.DEL_CD         = B.DEL_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("    SET " ).append("\n"); 
		query.append("    	AUTO_NTC_FLG = B.AUTO_NTC_FLG" ).append("\n"); 
		query.append("    ,	EACH_FOC_NTC_FLG = B.EACH_FOC_NTC_FLG" ).append("\n"); 
		query.append("    ,	TRKR_NTC_FLG = B.TRKR_NTC_FLG" ).append("\n"); 
		query.append("    ,   AUTO_NTC_YD_FLG = B.AUTO_NTC_YD_FLG" ).append("\n"); 
		query.append("    ,	ECLZ_OBL_CPY_FLG = B.ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append("    ,	FOC_CLR_RMK_STUP_FLG = B.FOC_CLR_RMK_STUP_FLG" ).append("\n"); 
		query.append("    ,	HD_TIT_CTNT = B.HD_TIT_CTNT" ).append("\n"); 
		query.append("    ,	UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append("    ,	UPD_DT = SYSDATE        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("    (PKUP_NTC_SEQ," ).append("\n"); 
		query.append("     PKUP_NTC_SND_TP_CD," ).append("\n"); 
		query.append("     OFC_CD," ).append("\n"); 
		query.append("     DEL_CD," ).append("\n"); 
		query.append("     AUTO_NTC_FLG," ).append("\n"); 
		query.append("     EACH_FOC_NTC_FLG," ).append("\n"); 
		query.append("     TRKR_NTC_FLG," ).append("\n"); 
		query.append("     AUTO_NTC_YD_FLG," ).append("\n"); 
		query.append("     ECLZ_OBL_CPY_FLG," ).append("\n"); 
		query.append("     FOC_CLR_RMK_STUP_FLG," ).append("\n"); 
		query.append("     HD_TIT_CTNT," ).append("\n"); 
		query.append("     CRE_USR_ID," ).append("\n"); 
		query.append("     CRE_DT," ).append("\n"); 
		query.append("     UPD_USR_ID," ).append("\n"); 
		query.append("     UPD_DT )" ).append("\n"); 
		query.append("        VALUES( " ).append("\n"); 
		query.append("        nvl((SELECT /*+ INDEX_DESC(T XPKBKG_PKUP_NTC_STUP) */" ).append("\n"); 
		query.append("                    PKUP_NTC_SEQ" ).append("\n"); 
		query.append("             FROM   BKG_PKUP_NTC_STUP T" ).append("\n"); 
		query.append("             WHERE ROWNUM = 1),0)+1" ).append("\n"); 
		query.append("    ,	B.PKUP_NTC_SND_TP_CD" ).append("\n"); 
		query.append("    ,	B.OFC_CD" ).append("\n"); 
		query.append("    ,	B.DEL_CD" ).append("\n"); 
		query.append("    ,	B.AUTO_NTC_FLG" ).append("\n"); 
		query.append("    ,	B.EACH_FOC_NTC_FLG" ).append("\n"); 
		query.append("    ,	B.TRKR_NTC_FLG" ).append("\n"); 
		query.append("    ,   B.AUTO_NTC_YD_FLG" ).append("\n"); 
		query.append("    ,	B.ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append("    ,	B.FOC_CLR_RMK_STUP_FLG" ).append("\n"); 
		query.append("    ,	B.HD_TIT_CTNT" ).append("\n"); 
		query.append("    ,	B.CRE_USR_ID" ).append("\n"); 
		query.append("    ,	SYSDATE" ).append("\n"); 
		query.append("    ,	B.UPD_USR_ID" ).append("\n"); 
		query.append("    ,	SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}
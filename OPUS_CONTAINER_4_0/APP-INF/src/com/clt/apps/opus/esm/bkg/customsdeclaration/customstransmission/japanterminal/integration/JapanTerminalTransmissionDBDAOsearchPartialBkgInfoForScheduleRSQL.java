/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchPartialBkgInfoForScheduleRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.04.19 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchPartialBkgInfoForScheduleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchPartialBkgInfoForSchedule
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchPartialBkgInfoForScheduleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bat_skd_prd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_edi_snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bat_skd_prd_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchPartialBkgInfoForScheduleRSQL").append("\n");
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
		query.append("SELECT T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD VVD_CD," ).append("\n");
		query.append("       T.VSL_CD," ).append("\n");
		query.append("       T.SKD_VOY_NO," ).append("\n");
		query.append("       T.SKD_DIR_CD," ).append("\n");
		query.append("       T.POL_CD," ).append("\n");
		query.append("       T.POL_YD_CD," ).append("\n");
		query.append("       T.POR_CD," ).append("\n");
		query.append("       T.POR_YD_CD," ).append("\n");
		query.append("       T.CALL_SGN_NO," ).append("\n");
		query.append("       T.BKG_NO," ).append("\n");
		query.append("       DECODE(T.SNACCS_TML_EDI_STS_CNG_FLG, 'Y', T.SNACCS_TML_EDI_STS_CD, DECODE(B.BKG_STS_CD, 'X', 'D', NVL2(T.BKG_NO, 'Rv', 'R'))) BKRBKC," ).append("\n");
		query.append("       DECODE(T.SNACCS_TML_EDI_STS_CNG_FLG, 'Y', T.SNACCS_TML_EDI_STS_CD, DECODE(B.BKG_STS_CD, 'X', 'D', NVL2(T.BKG_NO, 'V', 'R'))) BE_BKRBKC," ).append("\n");
		query.append("       TO_CHAR(T.EDI_SND_DT, 'YYYY-MM-DD') EDI_SND_DT," ).append("\n");
		query.append("       TO_CHAR(T.EDI_SND_DT, 'HH:MM:SS') EDI_SND_TM," ).append("\n");
		query.append("       NVL(T.SNACCS_TML_EDI_STS_CNG_FLG, 'N') SNACCS_TML_EDI_STS_CNG_FLG," ).append("\n");
		query.append("       T.EDI_SND_OFC_CD," ).append("\n");
		query.append("       T.EDI_SND_USR_ID," ).append("\n");
		query.append("       T.OTR_NTFY_YD_CD," ).append("\n");
		query.append("       T.CNTR_TPSZ_CD1," ).append("\n");
		query.append("       T.CNTR_VOL_QTY1, " ).append("\n");
		query.append("       T.CNTR_TPSZ_CD2, " ).append("\n");
		query.append("       T.CNTR_VOL_QTY2, " ).append("\n");
		query.append("       T.CNTR_TPSZ_CD3, " ).append("\n");
		query.append("       T.CNTR_VOL_QTY3, " ).append("\n");
		query.append("       T.CNTR_TPSZ_CD4, " ).append("\n");
		query.append("       T.CNTR_VOL_QTY4, " ).append("\n");
		query.append("       T.CNTR_TPSZ_CD5, " ).append("\n");
		query.append("       T.CNTR_VOL_QTY5" ).append("\n");
		query.append("  FROM BKG_TML_EDI_JP_BL T ," ).append("\n");
		query.append("       BKG_BOOKING B ," ).append("\n");
		query.append("       BKG_TML_EDI_JP_BAT_VVD_SKD S" ).append("\n");
		query.append(" WHERE T.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("   AND T.BKG_SKD_SEQ = 0" ).append("\n");
		query.append("   AND T.PRT_FLG = 'Y'" ).append("\n");
		query.append("   AND T.VSL_CD = S.VSL_CD" ).append("\n");
		query.append("   AND T.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n");
		query.append("   AND T.SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n");
		query.append("   AND T.POL_CD = S.POL_CD" ).append("\n");
		query.append("   AND T.POL_YD_CD = S.POL_YD_CD" ).append("\n");
		query.append("   AND T.POR_CD = S.POR_CD" ).append("\n");
		query.append("   AND T.POR_YD_CD = S.POR_YD_CD" ).append("\n");
		query.append("   AND (NVL(T.OTR_NTFY_YD_CD, 'X') = NVL(S.OTR_NTFY_YD_CD, 'X') OR T.OTR_NTFY_YD_CD IS NOT NULL )" ).append("\n");
		query.append("#if (${in_vvd_cd} != '') " ).append("\n");
		query.append("AND S.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("AND S.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("AND S.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${in_pol_cd} != '') " ).append("\n");
		query.append("AND S.POL_CD = @[in_pol_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${in_por_cd} != '') " ).append("\n");
		query.append("AND S.POR_CD = @[in_por_cd] " ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${in_bat_skd_prd_fm_dt} != '' && ${in_bat_skd_prd_to_dt} != '') " ).append("\n");
		query.append("" ).append("\n");
		query.append("AND ( (  BAT_SKD_PRD_FM_DT BETWEEN TO_DATE(@[in_bat_skd_prd_fm_dt], 'YYYY-MM-DD') " ).append("\n");
		query.append("                         AND TO_DATE(@[in_bat_skd_prd_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n");
		query.append("" ).append("\n");
		query.append("OR  BAT_SKD_PRD_TO_DT BETWEEN TO_DATE(@[in_bat_skd_prd_fm_dt], 'YYYY-MM-DD') " ).append("\n");
		query.append("                         AND TO_DATE(@[in_bat_skd_prd_to_dt], 'YYYY-MM-DD') + 0.99999 " ).append("\n");
		query.append(")" ).append("\n");
		query.append("OR (BAT_SKD_PRD_FM_DT <= TO_DATE(@[in_bat_skd_prd_fm_dt], 'YYYY-MM-DD') " ).append("\n");
		query.append(" " ).append("\n");
		query.append("AND  BAT_SKD_PRD_TO_DT >= TO_DATE(@[in_bat_skd_prd_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n");
		query.append(")" ).append("\n");
		query.append(")" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${in_edi_snd_usr_id} != '') " ).append("\n");
		query.append("AND S.EDI_SND_USR_ID = @[in_edi_snd_usr_id]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("--POL과 USER ID 둘중 하나로만 검색시에 스케줄 생성된지 일년된 것으로 데이터 검색" ).append("\n");
		query.append("#if ((${in_pol_cd} != ''&&${in_vvd_cd} == ''&&${in_bat_skd_prd_fm_dt} == '' && ${in_bat_skd_prd_to_dt} == ''&&${in_edi_snd_usr_id} == ''&&${in_por_cd} == '')" ).append("\n");
		query.append("     ||(${in_pol_cd} == ''&&${in_vvd_cd} == ''&&${in_bat_skd_prd_fm_dt} == '' && ${in_bat_skd_prd_to_dt} == ''&&${in_edi_snd_usr_id} != ''&&${in_por_cd} == ''))" ).append("\n");
		query.append("AND S.CRE_DT >=  sysdate - 365 " ).append("\n");
		query.append("#end" ).append("\n");

	}
}
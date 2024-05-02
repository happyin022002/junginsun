/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchVesselListForScheduleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchVesselListForScheduleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Schedule로 등록된 Vessel List를 조회해 온다.
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchVesselListForScheduleRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchVesselListForScheduleRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("POL_CD," ).append("\n"); 
		query.append("POL_YD_CD," ).append("\n"); 
		query.append("POL_YD_CD BE_POL_YD_CD," ).append("\n"); 
		query.append("POR_CD," ).append("\n"); 
		query.append("POR_YD_CD," ).append("\n"); 
		query.append("POR_YD_CD BE_POR_YD_CD," ).append("\n"); 
		query.append("CALL_SGN_NO," ).append("\n"); 
		query.append("OTR_NTFY_YD_CD," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT,'YYYY-MM-DD') CREATE_DT," ).append("\n"); 
		query.append("TO_CHAR(BAT_SKD_PRD_FM_DT,'YYYY-MM-DD') BAT_SKD_PRD_FM_DT," ).append("\n"); 
		query.append("TO_CHAR(BAT_SKD_PRD_TO_DT,'YYYY-MM-DD') BAT_SKD_PRD_TO_DT," ).append("\n"); 
		query.append("EDI_SND_OFC_CD," ).append("\n"); 
		query.append("EDI_SND_USR_ID," ).append("\n"); 
		query.append("SKD_DELT_FLG," ).append("\n"); 
		query.append("DELT_USR_ID," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DECODE(NVL(A.ACT_CRR_CD, B.CRR_CD),'SML','Y','N') CRR_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD A, MDM_VSL_CNTR B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("  AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") CHK_VSL_FLG," ).append("\n"); 
		query.append("JP_TML_VSL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_TML_EDI_JP_BAT_VVD_SKD BAT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_vvd_cd} != '') " ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_pol_cd} != '') " ).append("\n"); 
		query.append("AND POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_por_cd} != '') " ).append("\n"); 
		query.append("AND POR_CD = @[in_por_cd] " ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${in_edi_snd_usr_id} != '') " ).append("\n"); 
		query.append("AND EDI_SND_USR_ID = @[in_edi_snd_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--POL과 USER ID 둘중 하나로만 검색시에 스케줄 생성된지 일년된 것으로 데이터 검색" ).append("\n"); 
		query.append("#if ((${in_pol_cd} != ''&&${in_vvd_cd} == ''&&${in_bat_skd_prd_fm_dt} == '' && ${in_bat_skd_prd_to_dt} == ''&&${in_edi_snd_usr_id} == ''&&${in_por_cd} == '')" ).append("\n"); 
		query.append("     ||(${in_pol_cd} == ''&&${in_vvd_cd} == ''&&${in_bat_skd_prd_fm_dt} == '' && ${in_bat_skd_prd_to_dt} == ''&&${in_edi_snd_usr_id} != ''&&${in_por_cd} == ''))" ).append("\n"); 
		query.append("AND CRE_DT >=  sysdate - 365 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SKD_DELT_FLG='N'" ).append("\n"); 

	}
}
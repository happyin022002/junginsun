/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOaddVslSkdHisCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.30
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.03.30 조원주
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

public class JapanTerminalTransmissionDBDAOaddVslSkdHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BKG_TML_EDI_JP_VVD_SKD_HIS 테이블에 BKG_TML_EDI_JP_BAT_VVD_SKD의 이력 남기는 쿼리
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOaddVslSkdHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_skd_prd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("otr_ntfy_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bat_skd_prd_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOaddVslSkdHisCSQL").append("\n");
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
		query.append("INSERT INTO BKG_TML_EDI_JP_VVD_SKD_HIS (" ).append("\n");
		query.append("VSL_CD," ).append("\n");
		query.append("SKD_VOY_NO," ).append("\n");
		query.append("SKD_DIR_CD," ).append("\n");
		query.append("POL_CD," ).append("\n");
		query.append("POL_YD_CD," ).append("\n");
		query.append("POR_CD," ).append("\n");
		query.append("POR_YD_CD," ).append("\n");
		query.append("SKD_HIS_SEQ," ).append("\n");
		query.append("OTR_NTFY_YD_CD," ).append("\n");
		query.append("BAT_SKD_PRD_FM_DT," ).append("\n");
		query.append("BAT_SKD_PRD_TO_DT, " ).append("\n");
		query.append("EDI_SND_OFC_CD," ).append("\n");
		query.append("EDI_SND_USR_ID," ).append("\n");
		query.append("CRE_USR_ID," ).append("\n");
		query.append("CRE_DT," ).append("\n");
		query.append("UPD_USR_ID," ).append("\n");
		query.append("UPD_DT" ).append("\n");
		query.append(") VALUES( " ).append("\n");
		query.append("	SUBSTR(@[vvd_cd],1,4)" ).append("\n");
		query.append(",   SUBSTR(@[vvd_cd],5,4)	" ).append("\n");
		query.append(",   SUBSTR(@[vvd_cd],9,1)" ).append("\n");
		query.append(",	@[pol_cd]" ).append("\n");
		query.append(",	@[pol_yd_cd]" ).append("\n");
		query.append(",	@[por_cd]" ).append("\n");
		query.append(",	NVL(@[por_yd_cd],' ')" ).append("\n");
		query.append(",	NVL((SELECT MAX(SKD_HIS_SEQ)+1 " ).append("\n");
		query.append("     FROM BKG_TML_EDI_JP_VVD_SKD_HIS" ).append("\n");
		query.append("     WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd_cd]" ).append("\n");
		query.append("     AND POL_CD = @[pol_cd]" ).append("\n");
		query.append("     AND POL_YD_CD = @[pol_yd_cd]" ).append("\n");
		query.append("     AND POR_CD = @[por_cd]" ).append("\n");
		query.append("     AND POR_YD_CD = NVL(@[por_yd_cd],' ')" ).append("\n");
		query.append("     GROUP BY VSL_CD,SKD_VOY_NO, SKD_DIR_CD ,POL_CD,POL_YD_CD,POR_CD,POR_YD_CD ),1) " ).append("\n");
		query.append(",   @[otr_ntfy_yd_cd]" ).append("\n");
		query.append(",   TO_DATE(@[bat_skd_prd_fm_dt],'YYYYMMDD HH24:MI:SS')" ).append("\n");
		query.append(",   TO_DATE(@[bat_skd_prd_to_dt],'YYYYMMDD HH24:MI:SS')" ).append("\n");
		query.append(",   @[edi_snd_ofc_cd]" ).append("\n");
		query.append(",   @[edi_snd_usr_id]" ).append("\n");
		query.append(",   @[cre_usr_id]" ).append("\n");
		query.append(",   sysdate" ).append("\n");
		query.append(",   @[cre_usr_id]" ).append("\n");
		query.append(",   sysdate" ).append("\n");
		query.append(")" ).append("\n");

	}
}
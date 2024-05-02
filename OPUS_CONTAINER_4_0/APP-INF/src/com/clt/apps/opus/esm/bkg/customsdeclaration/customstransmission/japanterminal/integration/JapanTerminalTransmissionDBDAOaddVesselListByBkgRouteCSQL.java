/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOaddVesselListByBkgRouteCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.07
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.06.07 조원주
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

public class JapanTerminalTransmissionDBDAOaddVesselListByBkgRouteCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BKG Route 로 조회한 후 정보를 저장
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOaddVesselListByBkgRouteCSQL(){
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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_tml_vsl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : JapanTerminalTransmissionDBDAOaddVesselListByBkgRouteCSQL").append("\n");
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
		query.append("INSERT INTO BKG_TML_EDI_JP_BAT_VVD_SKD (" ).append("\n");
		query.append("VSL_CD," ).append("\n");
		query.append("SKD_VOY_NO," ).append("\n");
		query.append("SKD_DIR_CD," ).append("\n");
		query.append("JP_TML_VSL_NO," ).append("\n");
		query.append("POL_CD," ).append("\n");
		query.append("POL_YD_CD," ).append("\n");
		query.append("POR_CD," ).append("\n");
		query.append("POR_YD_CD," ).append("\n");
		query.append("CALL_SGN_NO," ).append("\n");
		query.append("OTR_NTFY_YD_CD," ).append("\n");
		query.append("BAT_SKD_PRD_FM_DT," ).append("\n");
		query.append("BAT_SKD_PRD_TO_DT," ).append("\n");
		query.append("EDI_SND_OFC_CD," ).append("\n");
		query.append("EDI_SND_USR_ID," ).append("\n");
		query.append("SKD_DELT_FLG, " ).append("\n");
		query.append("DELT_USR_ID," ).append("\n");
		query.append("CRE_USR_ID," ).append("\n");
		query.append("CRE_DT," ).append("\n");
		query.append("UPD_USR_ID," ).append("\n");
		query.append("UPD_DT" ).append("\n");
		query.append(") VALUES( " ).append("\n");
		query.append("	SUBSTR(@[vvd_cd],1,4)" ).append("\n");
		query.append(",   SUBSTR(@[vvd_cd],5,4)	" ).append("\n");
		query.append(",   SUBSTR(@[vvd_cd],9,1)" ).append("\n");
		query.append(",   @[jp_tml_vsl_no]" ).append("\n");
		query.append(",	@[pol_cd]" ).append("\n");
		query.append(",	@[pol_yd_cd]" ).append("\n");
		query.append(",	@[por_cd]" ).append("\n");
		query.append("#if(${por_yd_cd} != '')" ).append("\n");
		query.append(",	@[por_yd_cd]" ).append("\n");
		query.append("#else" ).append("\n");
		query.append(",   ' '" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(",   @[call_sgn_no] " ).append("\n");
		query.append(",   @[otr_ntfy_yd_cd]" ).append("\n");
		query.append(",   TO_DATE(@[bat_skd_prd_fm_dt],'YYYY-MM-DD')" ).append("\n");
		query.append(",   TO_DATE(@[bat_skd_prd_to_dt],'YYYY-MM-DD')" ).append("\n");
		query.append(",   @[ofc_cd]" ).append("\n");
		query.append(",   @[cre_usr_id]" ).append("\n");
		query.append(",   'N'" ).append("\n");
		query.append(",   @[delt_usr_id]" ).append("\n");
		query.append(",   @[cre_usr_id]" ).append("\n");
		query.append(",   sysdate" ).append("\n");
		query.append(",   @[cre_usr_id]" ).append("\n");
		query.append(",   sysdate" ).append("\n");
		query.append(")" ).append("\n");

	}
}
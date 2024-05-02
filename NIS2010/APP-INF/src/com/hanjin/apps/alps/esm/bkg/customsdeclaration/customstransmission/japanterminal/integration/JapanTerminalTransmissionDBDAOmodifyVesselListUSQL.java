/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOmodifyVesselListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.21
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.05.21 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOmodifyVesselListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD단위로 조회된 vessel List를 수정한다.
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOmodifyVesselListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bat_skd_prd_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOmodifyVesselListUSQL").append("\n"); 
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
		query.append("UPDATE BKG_TML_EDI_JP_BAT_VVD_SKD " ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("   OTR_NTFY_YD_CD = NVL(@[otr_ntfy_yd_cd],'')" ).append("\n"); 
		query.append("#if( ${bat_skd_prd_fm_dt} == '' )" ).append("\n"); 
		query.append(", BAT_SKD_PRD_FM_DT	= (SELECT TO_CHAR(S.VPS_ETA_DT-14,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                               FROM VSK_VSL_PORT_SKD S,BKG_VVD V" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                AND V.POL_CD=@[pol_cd]" ).append("\n"); 
		query.append("                                AND S.VSL_CD=V.VSL_CD" ).append("\n"); 
		query.append("                                AND S.SKD_VOY_NO=V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND S.SKD_DIR_CD=V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND S.VPS_PORT_CD=V.POL_CD)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--값이 없는 경우만 스케줄꺼 가져오게 하고 있을경우는 가져온다" ).append("\n"); 
		query.append(",  BAT_SKD_PRD_FM_DT = TO_DATE(@[bat_skd_prd_fm_dt],'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${bat_skd_prd_to_dt} == '' )" ).append("\n"); 
		query.append(", BAT_SKD_PRD_TO_DT	= (SELECT TO_CHAR(S.VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                               FROM VSK_VSL_PORT_SKD S,BKG_VVD V" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                AND V.POL_CD=@[pol_cd]" ).append("\n"); 
		query.append("                                AND S.VSL_CD=V.VSL_CD" ).append("\n"); 
		query.append("                                AND S.SKD_VOY_NO=V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND S.SKD_DIR_CD=V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND S.VPS_PORT_CD=V.POL_CD)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",  BAT_SKD_PRD_TO_DT= TO_DATE(@[bat_skd_prd_to_dt],'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",   UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",   UPD_DT = sysdate" ).append("\n"); 
		query.append(",   SKD_DELT_FLG = @[skd_delt_flg]" ).append("\n"); 
		query.append(",   EDI_SND_OFC_CD =@[ofc_cd]" ).append("\n"); 
		query.append(",   EDI_SND_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",   JP_TML_VSL_NO = @[jp_tml_vsl_no]" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("AND POL_CD=@[pol_cd]" ).append("\n"); 
		query.append("AND POR_CD=@[por_cd]" ).append("\n"); 
		query.append("AND	POL_YD_CD = @[pol_yd_cd]" ).append("\n"); 
		query.append("AND POR_YD_CD = NVL(@[por_yd_cd],' ')" ).append("\n"); 

	}
}
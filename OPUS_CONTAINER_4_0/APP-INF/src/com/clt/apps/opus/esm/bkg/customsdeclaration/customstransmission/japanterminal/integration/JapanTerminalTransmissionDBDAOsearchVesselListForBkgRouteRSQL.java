/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchVesselListForBkgRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchVesselListForBkgRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchVesselListForBkgRouteRSQL(){
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
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchVesselListForBkgRouteRSQL").append("\n"); 
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
		query.append("SELECT V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("       NVL(S.OB_CSSM_VOY_NO, V.SKD_VOY_NO||V.SKD_DIR_CD) AS JP_TML_VSL_NO," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POL_NOD_CD AS POL_YD_CD," ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POR_NOD_CD AS POR_YD_CD," ).append("\n"); 
		query.append("       M.CALL_SGN_NO," ).append("\n"); 
		query.append("       TO_CHAR(S.VPS_ETA_DT-14, 'YYYY-MM-DD') AS BAT_SKD_PRD_FM_DT," ).append("\n"); 
		query.append("       TO_CHAR(S.VPS_ETA_DT, 'YYYY-MM-DD') AS BAT_SKD_PRD_TO_DT," ).append("\n"); 
		query.append("       (SELECT DECODE(NVL(A.ACT_CRR_CD, B.CRR_CD), COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), 'Y', 'N')" ).append("\n"); 
		query.append("          FROM VSK_VSL_SKD A," ).append("\n"); 
		query.append("               MDM_VSL_CNTR B" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND A.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("           AND A.VSL_CD = B.VSL_CD ) AS CHK_VSL_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD V," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("       MDM_VSL_CNTR M" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND V.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#if(${in_pol_cd} == '') --조회 검색 조건 없을 시" ).append("\n"); 
		query.append("   AND V.POL_CD LIKE 'JP%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND V.POL_CD=@[in_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.BKG_NO=V.BKG_NO" ).append("\n"); 
		query.append("   AND B.POL_CD=V.POL_CD" ).append("\n"); 
		query.append("#if(${in_por_cd} != '')" ).append("\n"); 
		query.append("   AND B.POR_CD=@[in_por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_bat_skd_prd_fm_dt} != '')" ).append("\n"); 
		query.append("   AND S.VPS_ETA_DT-14 >= TO_DATE(@[in_bat_skd_prd_fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_bat_skd_prd_to_dt} != '')" ).append("\n"); 
		query.append("   AND S.VPS_ETA_DT <= TO_DATE(@[in_bat_skd_prd_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND S.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("   AND S.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND S.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND S.VPS_PORT_CD = V.POL_CD" ).append("\n"); 
		query.append("   AND S.CLPT_IND_SEQ = V.POL_CLPT_IND_SEQ --double calling 여부 문의" ).append("\n"); 
		query.append("   AND M.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("   AND NOT EXISTS(SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_TML_EDI_JP_BAT_VVD_SKD S" ).append("\n"); 
		query.append("                   WHERE 1 = 1" ).append("\n"); 
		query.append("                     AND V.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("                     AND V.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND V.SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND B.POL_CD = S.POL_CD" ).append("\n"); 
		query.append("                     AND B.POL_NOD_CD = S.POL_YD_CD" ).append("\n"); 
		query.append("                     AND B.POR_CD = S.POR_CD" ).append("\n"); 
		query.append("                     AND (B.POR_NOD_CD = S.POR_YD_CD OR B.POR_NOD_CD IS NULL) ) -- check aleady exist in SKD" ).append("\n"); 
		query.append(" GROUP BY V.VSL_CD," ).append("\n"); 
		query.append("       V.SKD_VOY_NO," ).append("\n"); 
		query.append("       V.SKD_DIR_CD," ).append("\n"); 
		query.append("       NVL(S.OB_CSSM_VOY_NO, V.SKD_VOY_NO||V.SKD_DIR_CD)," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POL_NOD_CD," ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POR_NOD_CD," ).append("\n"); 
		query.append("       S.VPS_ETA_DT," ).append("\n"); 
		query.append("       M.CALL_SGN_NO" ).append("\n"); 

	}
}
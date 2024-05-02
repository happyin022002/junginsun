/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchEQFlagStatusListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchEQFlagStatusListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQFlagStatus 조회
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchEQFlagStatusListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_dmg_flg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_dmg_flg_dt_over_day",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchEQFlagStatusListDataRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("ROW_NUMBER() OVER (ORDER BY B.EQ_NO) AS ROW_SEQ" ).append("\n"); 
		query.append(",  B.EQ_NO" ).append("\n"); 
		query.append(",  B.EQ_TYPE EQ_KND_CD" ).append("\n"); 
		query.append(",  B.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",  DECODE(A.MNR_DMG_FLG, 'Y', '1', '0') MNR_DMG_FLG" ).append("\n"); 
		query.append(",  A.MNR_HNGR_FLG" ).append("\n"); 
		query.append(",  A.MNR_DONA_FLG" ).append("\n"); 
		query.append(",  A.MNR_SCRP_FLG" ).append("\n"); 
		query.append(",  A.MNR_RPR_FLG" ).append("\n"); 
		query.append(",  A.MNR_TTL_LSS_FLG" ).append("\n"); 
		query.append(",  A.MNR_DISP_FLG" ).append("\n"); 
		query.append(",  A.MNR_DISP_SEL_FLG" ).append("\n"); 
		query.append(",  A.DISP_RSN_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",  A.HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append(",  DECODE(A.MNR_DMG_FLG, 'Y',  TO_CHAR(A.MNR_DMG_FLG_DT,'YYYY-MM-DD HH24:MI')) AS MNR_DMG_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_HNGR_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_DONA_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_SCRP_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_RPR_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_TTL_LSS_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_DISP_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_DISP_SEL_FLG_DT" ).append("\n"); 
		query.append(",  B.CRNT_YD_CD MNR_DMG_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_DONA_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_SCRP_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_RPR_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_TTL_LSS_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_DISP_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_DISP_SEL_FLG_YD_CD" ).append("\n"); 
		query.append("--,  A.MNR_STS_RMK" ).append("\n"); 
		query.append(",  FH.MNR_FLG_RMK AS MNR_STS_RMK" ).append("\n"); 
		query.append(",  A.CRE_USR_ID" ).append("\n"); 
		query.append(",  A.CRE_DT" ).append("\n"); 
		query.append(",  A.UPD_USR_ID" ).append("\n"); 
		query.append(",  A.UPD_DT" ).append("\n"); 
		query.append(",  DECODE(A.MNR_DMG_FLG, 'Y', TRUNC(SYSDATE - A.MNR_DMG_FLG_DT ) + 1, null) AS MNR_DMG_FLG_DT_OVER_DAY" ).append("\n"); 
		query.append("FROM 	MNR_EQ_STS A, MNR_EQ_STS_V B" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	EQ_NO," ).append("\n"); 
		query.append("	MNR_STS_FLG," ).append("\n"); 
		query.append("	MNR_FLG_INP_TP_CD," ).append("\n"); 
		query.append("    CRE_OFC_CD," ).append("\n"); 
		query.append("    MNR_FLG_RMK" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("		MLH.EQ_NO," ).append("\n"); 
		query.append("		MLH.MNR_STS_FLG," ).append("\n"); 
		query.append("		MLH.MNR_FLG_INP_TP_CD," ).append("\n"); 
		query.append("		CRE_OFC_CD," ).append("\n"); 
		query.append("		ROW_NUMBER() OVER (PARTITION BY MLH.EQ_NO ORDER BY MLH.MNR_FLG_SEQ DESC) RANK," ).append("\n"); 
		query.append("        MNR_FLG_RMK" ).append("\n"); 
		query.append("		FROM MNR_FLG_HIS MLH" ).append("\n"); 
		query.append("		WHERE MLH.MNR_FLG_TP_CD = 'DMG'" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("	WHERE RANK = 1" ).append("\n"); 
		query.append(") FH" ).append("\n"); 
		query.append("WHERE	B.EQ_NO = A.EQ_NO(+)" ).append("\n"); 
		query.append("AND     B.EQ_NO = FH.EQ_NO(+)" ).append("\n"); 
		query.append("AND     B.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND     B.EQ_TYPE = @[eq_knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_dmg_flg_yd_cd} != '')" ).append("\n"); 
		query.append("	#if (${flg_yd_type} == 'L')" ).append("\n"); 
		query.append("    AND B.CRNT_YD_CD IN ( SELECT MY.YD_CD" ).append("\n"); 
		query.append("                            FROM MDM_YARD MY, MDM_EQ_ORZ_CHT ME, MDM_LOCATION ML" ).append("\n"); 
		query.append("                           WHERE MY.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("                             AND ML.SCC_CD = ME.SCC_CD" ).append("\n"); 
		query.append("                             AND ME.LCC_CD = @[mnr_dmg_flg_yd_cd] )" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND	B.CRNT_YD_CD = @[mnr_dmg_flg_yd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND	B.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("				'$user_tpszCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_tpszCds'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_list} != '')" ).append("\n"); 
		query.append("	AND	B.EQ_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("				'$user_eqNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eqNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${flag_type} != 'ALL')" ).append("\n"); 
		query.append("	AND NVL(A.MNR_DMG_FLG,'N') = @[flag_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_dmg_flg_dt_over_day} != '')" ).append("\n"); 
		query.append("	AND TRUNC(SYSDATE - A.MNR_DMG_FLG_DT + 1) >= REPLACE(@[mnr_dmg_flg_dt_over_day],',','')" ).append("\n"); 
		query.append("	AND NVL(A.MNR_DMG_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("  AND ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.08.09 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 콤보 데이터 조회
	  * CODE|NAME으로 구성됨
	  * </pre>
	  */
	public CommonDBDAOSearchComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchComboListRSQL").append("\n"); 
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
		query.append("#if (${method} == 'Trade')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Trade List를  가져 온다 */" ).append("\n"); 
		query.append("   SELECT B.TRD_CD CODE" ).append("\n"); 
		query.append("		, B.TRD_NM NAME" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("             SELECT DISTINCT" ).append("\n"); 
		query.append("                    B.TRD_CD" ).append("\n"); 
		query.append("               FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                    MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                    MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("              WHERE A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("                AND A.VSL_TP_CD   = 'C'" ).append("\n"); 
		query.append("#if (${is_rep_trade} == 'true')" ).append("\n"); 
		query.append("                /* Rep Trade 경우 추가 option 조건 */" ).append("\n"); 
		query.append("                AND A.REP_TRD_CD  = B.TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND B.DELT_FLG   IN ('N', @[del])" ).append("\n"); 
		query.append("                AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("                AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         MDM_TRADE B" ).append("\n"); 
		query.append("   WHERE A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("ORDER BY B.TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${method} == 'SubTrade')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sub Trade List를  가져 온다 */" ).append("\n"); 
		query.append("   SELECT A.TRD_CD" ).append("\n"); 
		query.append("		, B.SUB_TRD_CD		CODE" ).append("\n"); 
		query.append("		, (A.TRD_CD || '|' || B.SUB_TRD_CD  || '|' || " ).append("\n"); 
		query.append("				NVL(B.SUB_TRD_NM, ( SELECT T.TRD_NM FROM MDM_TRADE T" ).append("\n"); 
		query.append("                               		 WHERE T.TRD_CD = A.TRD_CD )" ).append("\n"); 
		query.append("          )) AS NAME" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("             SELECT DISTINCT" ).append("\n"); 
		query.append("                    B.TRD_CD  ," ).append("\n"); 
		query.append("                    SUB_TRD_CD" ).append("\n"); 
		query.append("               FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                    MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                    MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("              WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                AND A.VSL_TP_CD  = 'C'" ).append("\n"); 
		query.append("#if (${is_rep_trade} == 'true')" ).append("\n"); 
		query.append("                AND A.REP_TRD_CD = B.TRD_CD  /* REP TRADE 경우 추가 OPTION 조건 */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND B.DELT_FLG   IN ('N', @[del])" ).append("\n"); 
		query.append("                AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("                AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("          ) A," ).append("\n"); 
		query.append("          MDM_SUB_TRD B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if (${is_all} == 'true')" ).append("\n"); 
		query.append("      AND A.SUB_TRD_CD = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.TRD_CD    ," ).append("\n"); 
		query.append("          B.SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${method} == 'RLane')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Lane List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         B.TRD_CD    ," ).append("\n"); 
		query.append("         B.SUB_TRD_CD ," ).append("\n"); 
		query.append("         A.RLANE_CD CODE," ).append("\n"); 
		query.append("		(B.TRD_CD || '|' || B.SUB_TRD_CD || '|' || A.RLANE_CD || '|' || A.RLANE_NM) AS NAME" ).append("\n"); 
		query.append("    FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("         MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("         MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("   WHERE A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("     AND A.VSL_TP_CD    = 'C'" ).append("\n"); 
		query.append("#if (${ipc} != 'true')" ).append("\n"); 
		query.append("     AND A.REP_TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND B.DELT_FLG   IN ('N', @[del])" ).append("\n"); 
		query.append("     AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("     AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("     AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("     AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("ORDER BY B.TRD_CD    ," ).append("\n"); 
		query.append("         B.SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${method} == 'RHQ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* RHQ List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT T.OFC_CD   	CODE ," ).append("\n"); 
		query.append("         T.OFC_ENG_NM	NAME" ).append("\n"); 
		query.append("    FROM SPC_OFC_LVL T," ).append("\n"); 
		query.append("         MAS_WK_PRD  W" ).append("\n"); 
		query.append("   WHERE T.OFC_LVL = 2" ).append("\n"); 
		query.append("     AND W.COST_YR || W.COST_WK BETWEEN T.OFC_APLY_FM_YRWK AND T.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("     AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("     AND T.DELT_FLG IN ('N', @[del])" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("#elseif (${method} == 'ScgGrpCmdtCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SCG_GRP_CMDT_CD AS CD," ).append("\n"); 
		query.append("	   SCG_GRP_CMDT_DESC AS NM" ).append("\n"); 
		query.append("  FROM PRI_SCG_GRP_CMDT" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[code]" ).append("\n"); 
		query.append("   AND CHG_CD = NVL(@[etc2], 'GRI')" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${method} == 'CommonCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Common Code List를  가져 온다  */" ).append("\n"); 
		query.append("  SELECT INTG_CD_VAL_CTNT    AS CODE" ).append("\n"); 
		query.append("        ,INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("		,INTG_CD_VAL_CTNT CD " ).append("\n"); 
		query.append("		,INTG_CD_VAL_DESC NM" ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   WHERE INTG_CD_ID = @[code]" ).append("\n"); 
		query.append("AND      (APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${method} == 'SkipRsnCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Skip Reason를  가져 온다  */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    INTG_CD_VAL_CTNT	AS CODE," ).append("\n"); 
		query.append("    INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("FROM  COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01830'" ).append("\n"); 
		query.append("ORDER BY  CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${method} == 'PoRsnCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Phase Out Reason를  가져 온다  */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    INTG_CD_VAL_CTNT	AS CODE," ).append("\n"); 
		query.append("    INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("FROM  COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01819'" ).append("\n"); 
		query.append("ORDER BY  CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
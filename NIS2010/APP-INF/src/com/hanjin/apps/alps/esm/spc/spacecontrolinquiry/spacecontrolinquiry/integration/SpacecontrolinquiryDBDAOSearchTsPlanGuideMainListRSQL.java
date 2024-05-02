/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchTsPlanGuideMainListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchTsPlanGuideMainListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [T/S Plan & guide main list]을 [조회]합니다.
	  * 
	  * * 2016.07.14 [CHM-201642304] 이혜민 T/S Plan & Guide 기능 Logic 수정 
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchTsPlanGuideMainListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchTsPlanGuideMainListRSQL").append("\n"); 
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
		query.append("WITH VSK_DATA_TMP AS (" ).append("\n"); 
		query.append("SELECT DISTINCT 'VSK' AS FLG" ).append("\n"); 
		query.append("			     , SPC_GET_REP_TRD_FNC(A1.RLANE_CD) AS REP_TRD_CD" ).append("\n"); 
		query.append("				 , SPC_GET_REP_SUB_TRD_FNC(A1.RLANE_CD) AS REP_SUB_TRD_CD" ).append("\n"); 
		query.append("				 , A1.RLANE_CD" ).append("\n"); 
		query.append("				 , A1.DIR_CD" ).append("\n"); 
		query.append("				 , A1.COST_WK" ).append("\n"); 
		query.append("				 , A2.VSL_CD||A2.SKD_VOY_NO||A2.SKD_DIR_CD AS VVD_CD                                                                           " ).append("\n"); 
		query.append("				 , A2.IRR_PORT_CD" ).append("\n"); 
		query.append("				 , A2.IRR_YD_CD" ).append("\n"); 
		query.append("				 , A2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("				 , A2.SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("                 , A2.SKD_CNG_RSN_NM" ).append("\n"); 
		query.append("				 , A2.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("				 , A2.TS_RMK" ).append("\n"); 
		query.append("				 , '' AS USR_RMK" ).append("\n"); 
		query.append("				 , A2.CRR_CD" ).append("\n"); 
		query.append("				 , 'AUTO' AS CRE_USR_ID" ).append("\n"); 
		query.append("				 , 'AUTO' AS UPD_USR_ID" ).append("\n"); 
		query.append("				 , SYSDATE AS UPD_DT                                                 " ).append("\n"); 
		query.append("			FROM MAS_MON_VVD A1, " ).append("\n"); 
		query.append("				 (" ).append("\n"); 
		query.append("					--일반적인 Skip, Phase Out, Phase In" ).append("\n"); 
		query.append("                    SELECT DISTINCT V2.SLAN_CD" ).append("\n"); 
		query.append("                            , V2.VSL_CD" ).append("\n"); 
		query.append("                            , V2.SKD_VOY_NO" ).append("\n"); 
		query.append("                            , V2.SKD_DIR_CD" ).append("\n"); 
		query.append("                            , V2.VPS_PORT_CD AS IRR_PORT_CD" ).append("\n"); 
		query.append("                            , SUBSTR(V2.YD_CD, -2) AS IRR_YD_CD" ).append("\n"); 
		query.append("                            , V2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                            , CASE WHEN V2.SKD_CNG_STS_CD = 'S'" ).append("\n"); 
		query.append("                                   THEN (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                B.INTG_CD_VAL_CTNT AS CODE" ).append("\n"); 
		query.append("                                             FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                            WHERE B.INTG_CD_ID = 'CD01830'" ).append("\n"); 
		query.append("                                              AND B.INTG_CD_VAL_CTNT = V2.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                    WHEN V2.SKD_CNG_STS_CD = 'O' OR V2.SKD_CNG_STS_CD = 'I'" ).append("\n"); 
		query.append("                                    THEN (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                B.INTG_CD_VAL_CTNT AS CODE" ).append("\n"); 
		query.append("                                             FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                            WHERE B.INTG_CD_ID = 'CD01819'" ).append("\n"); 
		query.append("                                              AND B.INTG_CD_VAL_CTNT = V2.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                    END AS SKD_CNG_RSN_CD                            " ).append("\n"); 
		query.append("                            , CASE WHEN V2.SKD_CNG_STS_CD = 'S'" ).append("\n"); 
		query.append("                                   THEN (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                B.INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("                                             FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                            WHERE B.INTG_CD_ID = 'CD01830'" ).append("\n"); 
		query.append("                                              AND B.INTG_CD_VAL_CTNT = V2.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                    WHEN V2.SKD_CNG_STS_CD = 'O' OR V2.SKD_CNG_STS_CD = 'I'" ).append("\n"); 
		query.append("                                    THEN (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                B.INTG_CD_VAL_DESC AS NAME" ).append("\n"); 
		query.append("                                             FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                            WHERE B.INTG_CD_ID = 'CD01819'" ).append("\n"); 
		query.append("                                              AND B.INTG_CD_VAL_CTNT = V2.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                    END AS SKD_CNG_RSN_NM" ).append("\n"); 
		query.append("                            , DECODE(V2.PORT_SKP_TP_CD, 'F', 'Y', 'I', 'N') AS PORT_SKP_TP_CD" ).append("\n"); 
		query.append("                            , DECODE(SKD_CNG_STS_CD, 'S', V2.VPS_RMK, 'O', V2.PHS_IO_RMK) AS TS_RMK " ).append("\n"); 
		query.append("                            , NVL(V1.ACT_CRR_CD, M.CRR_CD) AS CRR_CD " ).append("\n"); 
		query.append("                    FROM    VSK_VSL_SKD V1" ).append("\n"); 
		query.append("                            , VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append("                            , MDM_VSL_CNTR M" ).append("\n"); 
		query.append("                    WHERE   1=1" ).append("\n"); 
		query.append("                    AND     V1.VSL_SLAN_CD = V2.SLAN_CD" ).append("\n"); 
		query.append("                    AND     V1.VSL_CD      = V2.VSL_CD" ).append("\n"); 
		query.append("                    AND     V1.SKD_VOY_NO  = V2.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     V1.SKD_DIR_CD  = V2.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     V1.VSL_CD      = M.VSL_CD" ).append("\n"); 
		query.append("                    AND     NVL(V2.SKD_CNG_STS_CD, '*') IN ('S', 'O', 'I')" ).append("\n"); 
		query.append("--                    AND     V2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                    AND     V2.VPS_PORT_CD NOT IN ('RUNJK','EGSUZ','PAPAC')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--                    UNION ALL     " ).append("\n"); 
		query.append("--                    --Phase Out시 PF 스케줄상 Skip 된 뒷 Port : Skip(O)" ).append("\n"); 
		query.append("--                    SELECT DISTINCT" ).append("\n"); 
		query.append("--                            B1.VSL_SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("--                          , B1.VSL_CD" ).append("\n"); 
		query.append("--                          , B1.SKD_VOY_NO" ).append("\n"); 
		query.append("--                          , B1.SKD_DIR_CD" ).append("\n"); 
		query.append("--                          , B2.PORT_CD AS IRR_PORT_CD" ).append("\n"); 
		query.append("--                          , SUBSTR(B2.YD_CD, -2) AS IRR_YD_CD" ).append("\n"); 
		query.append("--                          , 'K' AS SKD_CNG_STS_CD" ).append("\n"); 
		query.append("--                          , '' AS SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("--                          , '' AS SKD_CNG_RSN_NM" ).append("\n"); 
		query.append("--                          , 'X' AS PORT_SKP_TP_CD" ).append("\n"); 
		query.append("--                          , '' AS TS_RMK" ).append("\n"); 
		query.append("--                          , B1.CRR_CD" ).append("\n"); 
		query.append("--                    FROM (" ).append("\n"); 
		query.append("--                            SELECT A1.VSL_CD" ).append("\n"); 
		query.append("--                                 , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("--                                 , A1.SKD_DIR_CD" ).append("\n"); 
		query.append("--                                 , A1.VPS_PORT_CD" ).append("\n"); 
		query.append("--                                 , A1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("--                                 , A1.CLPT_SEQ" ).append("\n"); 
		query.append("--                                 , A1.YD_CD" ).append("\n"); 
		query.append("--                                 , A1.VSL_SLAN_CD" ).append("\n"); 
		query.append("--                                 , A1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("--                                 , A1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("--                                 , A1.PF_PORT_ROTN_SEQ" ).append("\n"); 
		query.append("--                                 , A1.REF_VSL_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_SKD_VOY_NO" ).append("\n"); 
		query.append("--                                 , A1.REF_SKD_DIR_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_VPS_PORT_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_CLPT_IND_SEQ" ).append("\n"); 
		query.append("--                                 , A1.REF_CLPT_SEQ" ).append("\n"); 
		query.append("--                                 , A1.REF_YD_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_VSL_SLAN_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_PF_SVC_TP_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_PORT_ROTN_SEQ" ).append("\n"); 
		query.append("--                                 , NVL(A3.ACT_CRR_CD, A4.CRR_CD) AS CRR_CD " ).append("\n"); 
		query.append("--                            FROM VSK_PHS_IO_HIS A1" ).append("\n"); 
		query.append("--                                ,VSK_VSL_PORT_SKD A2" ).append("\n"); 
		query.append("--                                ,VSK_VSL_SKD A3" ).append("\n"); 
		query.append("--                                ,MDM_VSL_CNTR A4" ).append("\n"); 
		query.append("--                            WHERE A1.VSL_CD       = A2.VSL_CD" ).append("\n"); 
		query.append("--                            AND A1.SKD_VOY_NO     = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("--                            AND A1.SKD_DIR_CD     = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("--                            AND A1.VPS_PORT_CD    = A2.VPS_PORT_CD" ).append("\n"); 
		query.append("--                            AND A1.CLPT_IND_SEQ   = A2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("--                            AND A1.SKD_CNG_STS_CD = A2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("--                            AND A3.VSL_SLAN_CD    = A2.SLAN_CD" ).append("\n"); 
		query.append("--                            AND A3.VSL_CD         = A2.VSL_CD" ).append("\n"); 
		query.append("--                            AND A3.SKD_VOY_NO     = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("--                            AND A3.SKD_DIR_CD     = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("--                            AND A3.VSL_CD         = A4.VSL_CD" ).append("\n"); 
		query.append("--                    ) B1, VSK_PF_SKD_DTL B2" ).append("\n"); 
		query.append("--                    WHERE 1=1" ).append("\n"); 
		query.append("--                    AND NVL(B1.REF_VSL_SLAN_CD,   B1.VSL_SLAN_CD)      = B2.VSL_SLAN_CD" ).append("\n"); 
		query.append("--                    AND NVL(B1.REF_PF_SVC_TP_CD,  B1.PF_SVC_TP_CD)     = B2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("--                    AND NVL(B1.REF_SKD_DIR_CD,    B1.SKD_DIR_CD)       = B2.SKD_DIR_CD" ).append("\n"); 
		query.append("--                    AND DECODE(B1.SKD_CNG_STS_CD,'O',NVL(B1.REF_PORT_ROTN_SEQ, B1.PF_PORT_ROTN_SEQ) ) < B2.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--                    UNION ALL" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--                    --Phase In시 PF 스케줄상 Skip 된 앞 Port : Skip(I)" ).append("\n"); 
		query.append("--                    SELECT DISTINCT" ).append("\n"); 
		query.append("--                            B1.VSL_SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("--                          , B1.VSL_CD" ).append("\n"); 
		query.append("--                          , B1.SKD_VOY_NO" ).append("\n"); 
		query.append("--                          , B1.SKD_DIR_CD" ).append("\n"); 
		query.append("--                          , B2.PORT_CD AS IRR_PORT_CD" ).append("\n"); 
		query.append("--                          , SUBSTR(B2.YD_CD, -2) AS IRR_YD_CD" ).append("\n"); 
		query.append("--                          , 'P' AS SKD_CNG_STS_CD" ).append("\n"); 
		query.append("--                          , '' AS SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("--                          , '' AS SKD_CNG_RSN_NM" ).append("\n"); 
		query.append("--                          , 'X' AS PORT_SKP_TP_CD" ).append("\n"); 
		query.append("--                          , '' AS TS_RMK" ).append("\n"); 
		query.append("--                          , B1.CRR_CD" ).append("\n"); 
		query.append("--                    FROM (" ).append("\n"); 
		query.append("--                            SELECT A1.VSL_CD" ).append("\n"); 
		query.append("--                                 , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("--                                 , A1.SKD_DIR_CD" ).append("\n"); 
		query.append("--                                 , A1.VPS_PORT_CD" ).append("\n"); 
		query.append("--                                 , A1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("--                                 , A1.CLPT_SEQ" ).append("\n"); 
		query.append("--                                 , A1.YD_CD" ).append("\n"); 
		query.append("--                                 , A1.VSL_SLAN_CD" ).append("\n"); 
		query.append("--                                 , A1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("--                                 , A1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("--                                 , A1.PF_PORT_ROTN_SEQ" ).append("\n"); 
		query.append("--                                 , A1.REF_VSL_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_SKD_VOY_NO" ).append("\n"); 
		query.append("--                                 , A1.REF_SKD_DIR_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_VPS_PORT_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_CLPT_IND_SEQ" ).append("\n"); 
		query.append("--                                 , A1.REF_CLPT_SEQ" ).append("\n"); 
		query.append("--                                 , A1.REF_YD_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_VSL_SLAN_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_PF_SVC_TP_CD" ).append("\n"); 
		query.append("--                                 , A1.REF_PORT_ROTN_SEQ" ).append("\n"); 
		query.append("--                                 , NVL(A3.ACT_CRR_CD, A4.CRR_CD) AS CRR_CD " ).append("\n"); 
		query.append("--                            FROM VSK_PHS_IO_HIS A1" ).append("\n"); 
		query.append("--                                ,VSK_VSL_PORT_SKD A2" ).append("\n"); 
		query.append("--                                ,VSK_VSL_SKD A3" ).append("\n"); 
		query.append("--                                ,MDM_VSL_CNTR A4" ).append("\n"); 
		query.append("--                            WHERE A1.VSL_CD       = A2.VSL_CD" ).append("\n"); 
		query.append("--                            AND A1.SKD_VOY_NO     = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("--                            AND A1.SKD_DIR_CD     = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("--                            AND A1.VPS_PORT_CD    = A2.VPS_PORT_CD" ).append("\n"); 
		query.append("--                            AND A1.CLPT_IND_SEQ   = A2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("--                            AND A1.SKD_CNG_STS_CD = A2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("--                            AND A3.VSL_SLAN_CD    = A2.SLAN_CD" ).append("\n"); 
		query.append("--                            AND A3.VSL_CD         = A2.VSL_CD" ).append("\n"); 
		query.append("--                            AND A3.SKD_VOY_NO     = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("--                            AND A3.SKD_DIR_CD     = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("--                            AND A3.VSL_CD         = A4.VSL_CD" ).append("\n"); 
		query.append("--                    ) B1, VSK_PF_SKD_DTL B2" ).append("\n"); 
		query.append("--                    WHERE 1=1" ).append("\n"); 
		query.append("--                    AND NVL(B1.REF_VSL_SLAN_CD,   B1.VSL_SLAN_CD)      = B2.VSL_SLAN_CD" ).append("\n"); 
		query.append("--                    AND NVL(B1.REF_PF_SVC_TP_CD,  B1.PF_SVC_TP_CD)     = B2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("--                    AND NVL(B1.REF_SKD_DIR_CD,    B1.SKD_DIR_CD)       = B2.SKD_DIR_CD" ).append("\n"); 
		query.append("--                    AND DECODE(B1.SKD_CNG_STS_CD,'I',NVL(B1.REF_PORT_ROTN_SEQ, B1.PF_PORT_ROTN_SEQ) ) > B2.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("				 ) A2" ).append("\n"); 
		query.append("			WHERE A1.VSL_CD(+)     = A2.VSL_CD" ).append("\n"); 
		query.append("			  AND A1.SKD_VOY_NO(+) = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("			  AND A1.DIR_CD(+)     = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("			  AND A1.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("			  AND A1.TRD_CD        = SPC_GET_REP_TRD_FNC(A1.RLANE_CD)" ).append("\n"); 
		query.append("			  AND A1.SUB_TRD_CD    = SPC_GET_REP_SUB_TRD_FNC(A1.RLANE_CD)" ).append("\n"); 
		query.append("			#if(${vvd} == '')  " ).append("\n"); 
		query.append("			  AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK IN" ).append("\n"); 
		query.append("				(SELECT /*+ INDEX(D XPKMAS_WK_PRD)*/ D.COST_YR||D.COST_WK" ).append("\n"); 
		query.append("				   FROM MAS_WK_PRD D" ).append("\n"); 
		query.append("				  WHERE D.COST_YR||D.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("					AND ROWNUM               <= TO_NUMBER(@[duration])" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			  AND SPC_GET_REP_TRD_FNC(A1.RLANE_CD)        = @[trade]" ).append("\n"); 
		query.append("			  AND SPC_GET_REP_SUB_TRD_FNC(A1.RLANE_CD)    = @[subtrade]" ).append("\n"); 
		query.append("			#if(${lane} != '')" ).append("\n"); 
		query.append("			  AND A1.RLANE_CD                             = @[lane]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${bound} != '')" ).append("\n"); 
		query.append("			  AND A1.DIR_CD                               = @[bound]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			  AND A2.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("			  AND A2.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("			  AND A2.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--VSK 데이터 중에서 SPC에 저장한 것 제외" ).append("\n"); 
		query.append(", VSK_DATA AS (" ).append("\n"); 
		query.append("SELECT B1.FLG" ).append("\n"); 
		query.append("		 , B1.REP_TRD_CD" ).append("\n"); 
		query.append("		 , B1.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("		 , B1.RLANE_CD" ).append("\n"); 
		query.append("		 , B1.DIR_CD" ).append("\n"); 
		query.append("		 , B1.COST_WK" ).append("\n"); 
		query.append("		 , B1.VVD_CD                                                                           " ).append("\n"); 
		query.append("		 , B1.IRR_PORT_CD" ).append("\n"); 
		query.append("		 , B1.IRR_YD_CD" ).append("\n"); 
		query.append("		 , B1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("		 , B1.SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("         , B1.SKD_CNG_RSN_NM" ).append("\n"); 
		query.append("		 , B1.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("		 , B1.TS_RMK" ).append("\n"); 
		query.append("		 , B1.USR_RMK" ).append("\n"); 
		query.append("		 , B1.CRR_CD" ).append("\n"); 
		query.append("		 , B1.CRE_USR_ID" ).append("\n"); 
		query.append("		 , B1.UPD_USR_ID" ).append("\n"); 
		query.append("		 , B1.UPD_DT" ).append("\n"); 
		query.append("         , B1.VVD_CD AS EXIST_FLG" ).append("\n"); 
		query.append("	FROM VSK_DATA_TMP B1		  " ).append("\n"); 
		query.append("	WHERE (B1.REP_TRD_CD, B1.REP_SUB_TRD_CD, B1.RLANE_CD, B1.VVD_CD, B1.IRR_PORT_CD, B1.IRR_YD_CD, B1.CRE_USR_ID) " ).append("\n"); 
		query.append("		NOT IN (SELECT REP_TRD_CD, REP_SUB_TRD_CD, RLANE_CD, VVD_CD, IRR_PORT_CD, IRR_YD_CD, CRE_USR_ID FROM SPC_TS_PLN_GID_MN) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SPC_DATA_TMP AS (" ).append("\n"); 
		query.append("SELECT DISTINCT 'SPC' AS FLG" ).append("\n"); 
		query.append("		      , A1.REP_TRD_CD" ).append("\n"); 
		query.append("              , A1.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("              , A1.RLANE_CD" ).append("\n"); 
		query.append("              , A1.DIR_CD" ).append("\n"); 
		query.append("              , A2.COST_WK" ).append("\n"); 
		query.append("              , A1.VVD_CD" ).append("\n"); 
		query.append("              , A1.IRR_PORT_CD" ).append("\n"); 
		query.append("              , A1.IRR_YD_CD" ).append("\n"); 
		query.append("              , A1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("              , CASE WHEN A1.SKD_CNG_STS_CD = 'S'" ).append("\n"); 
		query.append("                               THEN (" ).append("\n"); 
		query.append("                                        SELECT" ).append("\n"); 
		query.append("                                            B.INTG_CD_VAL_CTNT AS CODE" ).append("\n"); 
		query.append("                                         FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                        WHERE B.INTG_CD_ID = 'CD01830'" ).append("\n"); 
		query.append("                                          AND B.INTG_CD_VAL_CTNT = A1.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                WHEN A1.SKD_CNG_STS_CD = 'O'  OR A1.SKD_CNG_STS_CD = 'I'" ).append("\n"); 
		query.append("                                THEN (" ).append("\n"); 
		query.append("                                        SELECT" ).append("\n"); 
		query.append("                                            B.INTG_CD_VAL_CTNT AS CODE" ).append("\n"); 
		query.append("                                         FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                        WHERE B.INTG_CD_ID = 'CD01819'" ).append("\n"); 
		query.append("                                          AND B.INTG_CD_VAL_CTNT = A1.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                END AS SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("              , CASE WHEN A1.SKD_CNG_STS_CD = 'S'" ).append("\n"); 
		query.append("                               THEN (" ).append("\n"); 
		query.append("                                        SELECT" ).append("\n"); 
		query.append("                                            B.INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("                                         FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                        WHERE B.INTG_CD_ID = 'CD01830'" ).append("\n"); 
		query.append("                                          AND B.INTG_CD_VAL_CTNT = A1.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                WHEN A1.SKD_CNG_STS_CD = 'O' OR A1.SKD_CNG_STS_CD = 'I'" ).append("\n"); 
		query.append("                                THEN (" ).append("\n"); 
		query.append("                                        SELECT" ).append("\n"); 
		query.append("                                            B.INTG_CD_VAL_DESC AS NAME" ).append("\n"); 
		query.append("                                         FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                        WHERE B.INTG_CD_ID = 'CD01819'" ).append("\n"); 
		query.append("                                          AND B.INTG_CD_VAL_CTNT = A1.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                END AS SKD_CNG_RSN_NM   " ).append("\n"); 
		query.append("              , A1.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("              , A1.TS_RMK" ).append("\n"); 
		query.append("              , A1.USR_RMK" ).append("\n"); 
		query.append("              , A1.CRR_CD" ).append("\n"); 
		query.append("              , A1.CRE_USR_ID" ).append("\n"); 
		query.append("              , A1.UPD_USR_ID" ).append("\n"); 
		query.append("              , A1.UPD_DT" ).append("\n"); 
		query.append("        FROM  SPC_TS_PLN_GID_MN A1, MAS_MON_VVD A2    " ).append("\n"); 
		query.append("        WHERE SUBSTR(A1.VVD_CD, 1, 4) = A2.VSL_CD" ).append("\n"); 
		query.append("          AND SUBSTR(A1.VVD_CD, 5, 4) = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND SUBSTR(A1.VVD_CD, 9, 1) = A2.DIR_CD" ).append("\n"); 
		query.append("          AND A1.RLANE_CD   		  = A2.RLANE_CD" ).append("\n"); 
		query.append("          AND A2.DELT_FLG      		  = 'N'" ).append("\n"); 
		query.append("          AND A2.TRD_CD               = SPC_GET_REP_TRD_FNC(A2.RLANE_CD)" ).append("\n"); 
		query.append("          AND A2.SUB_TRD_CD           = SPC_GET_REP_SUB_TRD_FNC(A2.RLANE_CD)" ).append("\n"); 
		query.append("        #if(${vvd} == '')  " ).append("\n"); 
		query.append("          AND SUBSTR(A2.SLS_YRMON, 1, 4)||A2.COST_WK IN" ).append("\n"); 
		query.append("            (SELECT /*+ INDEX(D XPKMAS_WK_PRD)*/ D.COST_YR||D.COST_WK" ).append("\n"); 
		query.append("               FROM MAS_WK_PRD D" ).append("\n"); 
		query.append("              WHERE D.COST_YR||D.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                AND ROWNUM               <= TO_NUMBER(@[duration])" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          AND A1.REP_TRD_CD        = @[trade]" ).append("\n"); 
		query.append("          AND A1.REP_SUB_TRD_CD    = @[subtrade]" ).append("\n"); 
		query.append("        #if(${lane} != '')" ).append("\n"); 
		query.append("          AND A1.RLANE_CD          = @[lane]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${bound} != '')" ).append("\n"); 
		query.append("          AND A1.DIR_CD            = @[bound]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          AND A1.VVD_CD     = @[vvd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--SPC 데이터 중에서 VSK에 없는 것 제외(VSK에서 들어와서 저장했다가 VSK에서 삭제된 것)" ).append("\n"); 
		query.append(", SPC_DATA AS (" ).append("\n"); 
		query.append("SELECT B1.FLG" ).append("\n"); 
		query.append("		 , B1.REP_TRD_CD" ).append("\n"); 
		query.append("		 , B1.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("		 , B1.RLANE_CD" ).append("\n"); 
		query.append("		 , B1.DIR_CD" ).append("\n"); 
		query.append("		 , B1.COST_WK" ).append("\n"); 
		query.append("		 , B1.VVD_CD                                                                           " ).append("\n"); 
		query.append("		 , B1.IRR_PORT_CD" ).append("\n"); 
		query.append("		 , B1.IRR_YD_CD" ).append("\n"); 
		query.append("		 , B1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("		 , B1.SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("         , B1.SKD_CNG_RSN_NM" ).append("\n"); 
		query.append("		 , B1.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("		 , B1.TS_RMK" ).append("\n"); 
		query.append("		 , B1.USR_RMK" ).append("\n"); 
		query.append("		 , B1.CRR_CD" ).append("\n"); 
		query.append("		 , B1.CRE_USR_ID" ).append("\n"); 
		query.append("		 , B1.UPD_USR_ID" ).append("\n"); 
		query.append("		 , B1.UPD_DT" ).append("\n"); 
		query.append("         , DECODE(B1.CRE_USR_ID, 'AUTO', NVL(B2.VVD_CD,'N'), B1.VVD_CD) AS EXIST_FLG" ).append("\n"); 
		query.append("	FROM SPC_DATA_TMP B1, VSK_DATA_TMP B2" ).append("\n"); 
		query.append("    WHERE B1.REP_TRD_CD     = B2.REP_TRD_CD(+)" ).append("\n"); 
		query.append("    AND B1.REP_SUB_TRD_CD   = B2.REP_SUB_TRD_CD(+)" ).append("\n"); 
		query.append("    AND B1.RLANE_CD         = B2.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND B1.VVD_CD           = B2.VVD_CD(+)" ).append("\n"); 
		query.append("    AND B1.IRR_PORT_CD      = B2.IRR_PORT_CD(+)" ).append("\n"); 
		query.append("    AND B1.IRR_YD_CD        = B2.IRR_YD_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ALL_DATA AS (" ).append("\n"); 
		query.append("SELECT C1.FLG" ).append("\n"); 
		query.append("      ,C1.REP_TRD_CD" ).append("\n"); 
		query.append("      ,C1.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("      ,C1.RLANE_CD" ).append("\n"); 
		query.append("      ,C1.DIR_CD" ).append("\n"); 
		query.append("      ,C1.COST_WK" ).append("\n"); 
		query.append("      ,C1.VVD_CD" ).append("\n"); 
		query.append("      ,C1.IRR_PORT_CD" ).append("\n"); 
		query.append("      ,C1.IRR_YD_CD" ).append("\n"); 
		query.append("      ,C1.EXIST_FLG" ).append("\n"); 
		query.append("      ,C1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("      ,DECODE((SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM SPC_TS_PLN_GID_DTL C2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND C1.REP_TRD_CD     = C2.REP_TRD_CD" ).append("\n"); 
		query.append("           AND C1.REP_SUB_TRD_CD = C2.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("           AND C1.RLANE_CD       = C2.RLANE_CD" ).append("\n"); 
		query.append("           AND C1.VVD_CD         = C2.VVD_CD" ).append("\n"); 
		query.append("           AND C1.IRR_PORT_CD    = C2.IRR_PORT_CD" ).append("\n"); 
		query.append("           AND C1.IRR_YD_CD      = C2.IRR_YD_CD" ).append("\n"); 
		query.append("        ), 0, 'N', 'Y')  TS_PLN_GID_DTL" ).append("\n"); 
		query.append("      ,C1.SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("      ,C1.SKD_CNG_RSN_NM" ).append("\n"); 
		query.append("      ,NVL(C1.PORT_SKP_TP_CD, 'X') AS PORT_SKP_TP_CD" ).append("\n"); 
		query.append("      ,C1.TS_RMK" ).append("\n"); 
		query.append("      ,C1.USR_RMK" ).append("\n"); 
		query.append("      ,C1.CRR_CD" ).append("\n"); 
		query.append("      ,C1.CRE_USR_ID" ).append("\n"); 
		query.append("      ,C1.UPD_USR_ID" ).append("\n"); 
		query.append("      ,DECODE(C1.UPD_USR_ID, 'AUTO', '', TO_CHAR(C1.UPD_DT,'YYYY-MM-DD HH24:MM')) AS UPD_DT" ).append("\n"); 
		query.append("FROM VSK_DATA C1   " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT C2.FLG" ).append("\n"); 
		query.append("      ,C2.REP_TRD_CD" ).append("\n"); 
		query.append("      ,C2.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("      ,C2.RLANE_CD" ).append("\n"); 
		query.append("      ,C2.DIR_CD" ).append("\n"); 
		query.append("      ,C2.COST_WK" ).append("\n"); 
		query.append("      ,C2.VVD_CD" ).append("\n"); 
		query.append("      ,C2.IRR_PORT_CD" ).append("\n"); 
		query.append("      ,C2.IRR_YD_CD" ).append("\n"); 
		query.append("      ,C2.EXIST_FLG" ).append("\n"); 
		query.append("      ,C2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("      ,DECODE((SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM SPC_TS_PLN_GID_DTL C3" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND C2.REP_TRD_CD     = C3.REP_TRD_CD" ).append("\n"); 
		query.append("           AND C2.REP_SUB_TRD_CD = C3.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("           AND C2.RLANE_CD       = C3.RLANE_CD" ).append("\n"); 
		query.append("           AND C2.VVD_CD         = C3.VVD_CD" ).append("\n"); 
		query.append("           AND C2.IRR_PORT_CD    = C3.IRR_PORT_CD" ).append("\n"); 
		query.append("           AND C2.IRR_YD_CD      = C3.IRR_YD_CD" ).append("\n"); 
		query.append("        ), 0, 'N', 'Y')  TS_PLN_GID_DTL" ).append("\n"); 
		query.append("      ,C2.SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("      ,C2.SKD_CNG_RSN_NM" ).append("\n"); 
		query.append("      ,C2.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("      ,C2.TS_RMK" ).append("\n"); 
		query.append("      ,C2.USR_RMK" ).append("\n"); 
		query.append("      ,C2.CRR_CD" ).append("\n"); 
		query.append("      ,C2.CRE_USR_ID" ).append("\n"); 
		query.append("      ,C2.UPD_USR_ID" ).append("\n"); 
		query.append("      ,DECODE(C2.UPD_USR_ID, 'AUTO', '', TO_CHAR(C2.UPD_DT,'YYYY-MM-DD HH24:MM')) AS UPD_DT" ).append("\n"); 
		query.append("FROM SPC_DATA C2  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT D1.FLG" ).append("\n"); 
		query.append("      ,D1.REP_TRD_CD" ).append("\n"); 
		query.append("      ,D1.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("      ,D1.RLANE_CD" ).append("\n"); 
		query.append("      ,D1.DIR_CD" ).append("\n"); 
		query.append("      ,D1.COST_WK" ).append("\n"); 
		query.append("      ,D1.VVD_CD" ).append("\n"); 
		query.append("      ,D1.IRR_PORT_CD" ).append("\n"); 
		query.append("      ,D1.IRR_YD_CD" ).append("\n"); 
		query.append("      ,D1.EXIST_FLG" ).append("\n"); 
		query.append("      ,D1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("      ,D1.TS_PLN_GID_DTL" ).append("\n"); 
		query.append("      ,D1.SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("      ,D1.SKD_CNG_RSN_NM" ).append("\n"); 
		query.append("      ,D1.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("      ,D1.TS_RMK" ).append("\n"); 
		query.append("      ,D1.USR_RMK" ).append("\n"); 
		query.append("      ,D1.CRR_CD" ).append("\n"); 
		query.append("      ,D1.CRE_USR_ID" ).append("\n"); 
		query.append("      ,D1.UPD_USR_ID" ).append("\n"); 
		query.append("      ,D1.UPD_DT" ).append("\n"); 
		query.append("FROM ALL_DATA D1" ).append("\n"); 
		query.append("ORDER BY D1.REP_TRD_CD" ).append("\n"); 
		query.append("       , D1.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("       , D1.RLANE_CD" ).append("\n"); 
		query.append("       , D1.DIR_CD" ).append("\n"); 
		query.append("       , D1.COST_WK" ).append("\n"); 
		query.append("       , D1.VVD_CD" ).append("\n"); 
		query.append("       , D1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("       , D1.IRR_PORT_CD" ).append("\n"); 
		query.append("       , D1.IRR_YD_CD" ).append("\n"); 
		query.append("       , D1.SKD_CNG_RSN_CD" ).append("\n"); 
		query.append("       , D1.UPD_USR_ID DESC" ).append("\n"); 

	}
}
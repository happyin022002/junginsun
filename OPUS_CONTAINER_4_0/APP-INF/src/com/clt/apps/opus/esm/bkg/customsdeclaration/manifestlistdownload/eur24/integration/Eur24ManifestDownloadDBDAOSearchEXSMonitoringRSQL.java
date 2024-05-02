/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchEXSMonitoringRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.31
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.31 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchEXSMonitoringRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EXS Monitoring 화면을 조회하는 쿼리
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchEXSMonitoringRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_b_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_to_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_from_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchEXSMonitoringRSQL").append("\n"); 
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
		query.append("SELECT J.VVD" ).append("\n"); 
		query.append("     , J.LANE" ).append("\n"); 
		query.append("     , J.EU_POL" ).append("\n"); 
		query.append("     , J.BKG_POL" ).append("\n"); 
		query.append("     , J.OFC_CD" ).append("\n"); 
		query.append("     , J.BL_TOT_CNT" ).append("\n"); 
		query.append("     , J.EXS_SNT_CNT" ).append("\n"); 
		query.append("     , J.EXS_SNT_ACCP" ).append("\n"); 
		query.append("     , J.EXS_SNT_REJT" ).append("\n"); 
		query.append("     , J.EXS_SNT_DONL" ).append("\n"); 
		query.append("     , J.EXS_SNT_NRCV" ).append("\n"); 
		query.append("     , J.EXS_SNT_HOLD" ).append("\n"); 
		query.append("     , J.EXS_SNT_RELS" ).append("\n"); 
		query.append("     , J.EXS_UNSNT_CNT" ).append("\n"); 
		query.append("     , J.EXS_AMD_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(EXS_SNT_CNT, 0)) OVER() AS SENT_BL_CNT " ).append("\n"); 
		query.append("     , SUM(NVL(EXS_SNT_ACCP, 0)) OVER() AS ACC_BL_CNT " ).append("\n"); 
		query.append("     , SUM(NVL(EXS_SNT_REJT, 0)) OVER() AS REJ_BL_CNT " ).append("\n"); 
		query.append("     , SUM(NVL(EXS_SNT_DONL, 0)) OVER() AS DONLD_BL_CNT " ).append("\n"); 
		query.append("     , SUM(NVL(EXS_SNT_NRCV, 0)) OVER() AS NRCV_BL_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(EXS_SNT_HOLD, 0)) OVER() AS HOLD_BL_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(EXS_SNT_RELS, 0)) OVER() AS RELS_BL_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(EXS_UNSNT_CNT, 0)) OVER() AS UNSENT_BL_CNT " ).append("\n"); 
		query.append("     , SUM(NVL(BL_TOT_CNT, 0)) OVER() AS TOTAL_BL_CNT " ).append("\n"); 
		query.append("     , COUNT(DISTINCT VVD) OVER() AS TOTAL_VVD_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(EXS_AMD_CNT, 0)) OVER() AS TOTAL_AMD_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT J1.VVD" ).append("\n"); 
		query.append("         , J1.LANE" ).append("\n"); 
		query.append("         , J1.EU_POL" ).append("\n"); 
		query.append("         , J1.BKG_POL" ).append("\n"); 
		query.append("         , J1.OFC_CD " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("         , COUNT(J1.VSL_CD) AS BL_TOT_CNT " ).append("\n"); 
		query.append("         , COUNT(J1.MSG_SND_NO) AS EXS_SNT_CNT" ).append("\n"); 
		query.append("         , COUNT(DECODE(BKG_GET_TOKEN_FNC(RCV,3), 'A', 1)) AS EXS_SNT_ACCP" ).append("\n"); 
		query.append("         , COUNT(CASE WHEN BKG_GET_TOKEN_FNC(RCV,3) = 'R' AND BKG_GET_TOKEN_FNC(RCV,5) !='351' THEN '1' END) AS EXS_SNT_REJT" ).append("\n"); 
		query.append("         , COUNT(CASE WHEN BKG_GET_TOKEN_FNC(RCV,3) = 'R' AND BKG_GET_TOKEN_FNC(RCV,5) ='351' THEN '1' END) AS EXS_SNT_DONL" ).append("\n"); 
		query.append("         , COUNT(DECODE(J1.MSG_SND_NO, NULL, NULL, DECODE(BKG_GET_TOKEN_FNC(RCV,3), NULL, 1))) AS EXS_SNT_NRCV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , COUNT(CASE WHEN BKG_GET_TOKEN_FNC(RCV,5) = '561' OR BKG_GET_TOKEN_FNC(RCV,3) = 'D' OR BKG_GET_TOKEN_FNC(RCV,3) = 'P'" ).append("\n"); 
		query.append("                      THEN 1" ).append("\n"); 
		query.append("                 END) AS EXS_SNT_HOLD" ).append("\n"); 
		query.append("         , COUNT(DECODE(BKG_GET_TOKEN_FNC(RCV,3), 'L', 1)) AS EXS_SNT_RELS" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         , COUNT(J1.VSL_CD)-COUNT(J1.MSG_SND_NO) AS EXS_UNSNT_CNT" ).append("\n"); 
		query.append("         , COUNT(DECODE(SUBSTR(J1.MSG_SND_NO, 18, 3), '613', J1.MSG_SND_NO, NULL)) AS EXS_AMD_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               T1.VSL_CD" ).append("\n"); 
		query.append("             , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("             , T1.SKD_DIR_CD " ).append("\n"); 
		query.append("             , T1.VSL_SLAN_CD	AS LANE" ).append("\n"); 
		query.append("             , T1.POL_YD_CD		AS EU_POL" ).append("\n"); 
		query.append("             , T1.BKG_POL" ).append("\n"); 
		query.append("             , T1.OFC_CD" ).append("\n"); 
		query.append("             , T1.BL_NO" ).append("\n"); 
		query.append("             , T1.EU_BL_NO" ).append("\n"); 
		query.append("             , T1.MSG_SND_NO" ).append("\n"); 
		query.append("             , T1.VVD" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("              , ( SELECT EDI_RCV_DT||','||EDI_RCV_SEQ||','|| ACK_RCV_STS_CD||','|| TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI')||','||EUR_CSTMS_ACK_CD||','||ACK_KND_ID" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_EUR_IO_RCV" ).append("\n"); 
		query.append("                    WHERE BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                      AND EDI_RCV_DT > ' '" ).append("\n"); 
		query.append("                      AND EDI_RCV_SEQ > 0" ).append("\n"); 
		query.append("                      AND RCV_TMS = ( SELECT MAX(RCV_TMS)" ).append("\n"); 
		query.append("                                        FROM BKG_CSTMS_EUR_IO_RCV RCV" ).append("\n"); 
		query.append("                                       WHERE RCV.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                                         AND RCV.EDI_RCV_DT > ' '" ).append("\n"); 
		query.append("                                         AND RCV.EDI_RCV_SEQ > 0" ).append("\n"); 
		query.append("                                         AND RCV.MSG_RCV_NO = T1.MSG_SND_NO " ).append("\n"); 
		query.append("                                         AND (RCV.ACK_KND_ID != 'S' OR RCV.ACK_RCV_STS_CD != 'A') ) ) RCV" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            SELECT EU_BL.BL_NO AS EU_BL_NO" ).append("\n"); 
		query.append("                    , EU_BL.MSG_SND_NO" ).append("\n"); 
		query.append("                    , BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                    , BKG.*" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                SELECT VVD.VSL_CD" ).append("\n"); 
		query.append("                     , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("                     , SKD.VSL_SLAN_CD" ).append("\n"); 
		query.append("                     , VVD.POL_CD" ).append("\n"); 
		query.append("                     , VVD.POL_YD_CD" ).append("\n"); 
		query.append("                     , BKG.POL_CD       AS BKG_POL" ).append("\n"); 
		query.append("                     , BKG.BL_NO" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                     #if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("                        , BKG.BKG_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("                     #else" ).append("\n"); 
		query.append("                        , MDM_LOC.EQ_CTRL_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     , BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("                     , MDM_LOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                     , VSK_VSL_SKD SKD" ).append("\n"); 
		query.append("                     , BKG_BOOKING BKG" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("                     , BKG_CSTMS_CD_CONV_CTNT EU_CNT" ).append("\n"); 
		query.append("                     , MDM_LOCATION MDM_LOC" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("                   AND BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_YD_CD = VSK.YD_CD" ).append("\n"); 
		query.append("                   AND VVD.POD_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   AND EU_CNT.CSTMS_DIV_ID = 'EU_MEMBER_CNT'" ).append("\n"); 
		query.append("                   AND EU_CNT.CNT_CD = 'EU'" ).append("\n"); 
		query.append("                   AND EU_CNT.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND VSK.VPS_PORT_CD LIKE EU_CNT.ATTR_CTNT1 || '%'" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   AND VVD.POL_CD = MDM_LOC.LOC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   #if (${p_from_dt} != '')" ).append("\n"); 
		query.append("                   		AND VSK.VPS_ETB_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("				   #if (${p_to_dt} != '')" ).append("\n"); 
		query.append("                   		AND VSK.VPS_ETB_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   #if (${p_pol} != '')				-- EU POL" ).append("\n"); 
		query.append("                        AND VVD.POL_YD_CD LIKE @[p_pol]||'%'" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   #if (${p_b_ofc_cd} != '')		-- POL OFC / BKG_OFC" ).append("\n"); 
		query.append("                        #if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("                            AND BKG.BKG_OFC_CD = @[p_b_ofc_cd]" ).append("\n"); 
		query.append("                        #elseif (${p_rhq_gb} == 'PO')" ).append("\n"); 
		query.append("                            AND MDM_LOC.EQ_CTRL_OFC_CD = @[p_b_ofc_cd] " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   #if (${p_vvd} != '')				-- VVD" ).append("\n"); 
		query.append("                        AND VVD.VSL_CD = SUBSTR(@[p_vvd], 1, 4)" ).append("\n"); 
		query.append("                        AND VVD.SKD_VOY_NO = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("                        AND VVD.SKD_DIR_CD = SUBSTR(@[p_vvd], 9, 1)" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   #if (${cond_lane} != '')			-- LANE" ).append("\n"); 
		query.append("                        AND SKD.VSL_SLAN_CD = @[cond_lane]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("                ) BKG" ).append("\n"); 
		query.append("                , BKG_CSTMS_EUR_IO_BL EU_BL" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND BKG.BL_NO = EU_BL.BL_NO(+)    " ).append("\n"); 
		query.append("              AND BKG.VSL_CD = EU_BL.VSL_CD(+)" ).append("\n"); 
		query.append("              AND BKG.SKD_VOY_NO = EU_BL.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("              AND BKG.SKD_DIR_CD = EU_BL.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("              AND BKG.POL_CD = EU_BL.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("              AND EU_BL.BND_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("              ) T1" ).append("\n"); 
		query.append("        ) J1" ).append("\n"); 
		query.append("    GROUP BY J1.VVD, J1.LANE, J1.EU_POL, J1.BKG_POL, J1.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) J" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("ORDER BY VVD, LANE, EU_POL, BKG_POL, OFC_CD" ).append("\n"); 

	}
}
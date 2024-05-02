/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOSearchVnorSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOSearchVnorSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VNOR Summary Inquiry 조회합니다.
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOSearchVnorSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_stup_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOSearchVnorSummaryRSQL").append("\n"); 
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
		query.append("WITH FMS_INFO AS (" ).append("\n"); 
		query.append("	SELECT VSL_CD" ).append("\n"); 
		query.append("           ,SKD_VOY_NO" ).append("\n"); 
		query.append("           ,SKD_DIR_CD" ).append("\n"); 
		query.append("           ,VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("           ,VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("           ,CR_CHK_FLG" ).append("\n"); 
		query.append("           ,FMS_STS_CD" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("        SELECT O.VSL_CD" ).append("\n"); 
		query.append("               ,O.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,O.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,O.VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("               ,O.VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("               ,O.CR_CHK_FLG" ).append("\n"); 
		query.append("               ,CASE WHEN C.APRO_FLG = 'Y' THEN 'A'" ).append("\n"); 
		query.append("                    WHEN C.APRO_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("                    WHEN I.VNOR_SEQ IS NOT NULL THEN 'S'" ).append("\n"); 
		query.append("                    WHEN F.VNOR_ITM_PROC_CD = 'P' THEN 'C'" ).append("\n"); 
		query.append("                    ELSE NULL" ).append("\n"); 
		query.append("               END FMS_STS_CD" ).append("\n"); 
		query.append("               ,O.CRE_DT" ).append("\n"); 
		query.append("        FROM FMS_VNOR O, FMS_VNOR_ITM F, FMS_INV_DTL I, FMS_CONSULTATION C" ).append("\n"); 
		query.append("        WHERE O.VSL_CD = F.VSL_CD" ).append("\n"); 
		query.append("          AND O.VNOR_SEQ = F.VNOR_SEQ" ).append("\n"); 
		query.append("          AND F.VSL_CD       = I.VSL_CD(+)" ).append("\n"); 
		query.append("          AND F.VNOR_SEQ     = I.VNOR_SEQ(+)" ).append("\n"); 
		query.append("          AND F.VNOR_ITM_SEQ = I.VNOR_ITM_SEQ(+)" ).append("\n"); 
		query.append("          AND I.SLP_TP_CD = C.SLP_TP_CD(+)" ).append("\n"); 
		query.append("          AND I.SLP_FUNC_CD = C.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("          AND I.SLP_OFC_CD = C.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("          AND I.SLP_ISS_DT = C.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("          AND I.SLP_SER_NO = C.SLP_SER_NO(+)  " ).append("\n"); 
		query.append("          AND F.VNOR_ITM_FLET_ADD_CD = 'O'" ).append("\n"); 
		query.append("          AND F.VNOR_ITM_CD = 'OH'" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${from_date} != '')" ).append("\n"); 
		query.append("	AND CRE_DT >= TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("	AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vnor_stup_sts_cd} == 'S' || ${vnor_stup_sts_cd} == 'N' || ${vnor_stup_sts_cd} == 'A' || ${vnor_stup_sts_cd} == 'C')" ).append("\n"); 
		query.append("	AND FMS_STS_CD = @[vnor_stup_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("OPF.VSL_CD" ).append("\n"); 
		query.append(",OPF.VNOR_SEQ" ).append("\n"); 
		query.append(",OPF.SKD_VOY_NO || OPF.SKD_DIR_CD AS SKD_VOY_NO" ).append("\n"); 
		query.append(",TO_CHAR(OPF.CRE_DT, 'YYYY.MM.DD HH24:MI') AS SA_DT" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT TO_CHAR(CRE_DT, 'YYYY.MM.DD HH24:MI')" ).append("\n"); 
		query.append("    FROM FMS_INFO" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND SKD_VOY_NO = OPF.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND SKD_DIR_CD = OPF.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND VNOR_OFFH_FM_DT = OPF.VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("    AND VNOR_OFFH_TO_DT = OPF.VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("    AND CR_CHK_FLG = OPF.CR_CHK_FLG" ).append("\n"); 
		query.append(") AS SU_DT" ).append("\n"); 
		query.append(",TO_CHAR(OPF.VNOR_OFFH_FM_DT, 'YYYY.MM.DD HH24:MI') AS VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append(",TO_CHAR(OPF.VNOR_OFFH_TO_DT, 'YYYY.MM.DD HH24:MI') AS VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT VNOR_ITM_VAL" ).append("\n"); 
		query.append("    FROM OPF_VNOR_ITM" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND VNOR_SEQ = OPF.VNOR_SEQ" ).append("\n"); 
		query.append("    AND VNOR_MN_ITM_FLG = 'Y'" ).append("\n"); 
		query.append("    AND VNOR_ITM_CD = 'OH'" ).append("\n"); 
		query.append(") AS OH_ITM_VAL" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT VNOR_ITM_RMK" ).append("\n"); 
		query.append("    FROM OPF_VNOR_ITM" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND VNOR_SEQ = OPF.VNOR_SEQ" ).append("\n"); 
		query.append("    AND VNOR_MN_ITM_FLG = 'Y'" ).append("\n"); 
		query.append("    AND VNOR_ITM_CD = 'OH'" ).append("\n"); 
		query.append(") AS OH_ITM_RMK" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD03385'" ).append("\n"); 
		query.append("    AND INTG_CD_VAL_CTNT = OPF.VNOR_VSL_STS_CD" ).append("\n"); 
		query.append(") AS VNOR_VSL_STS_CD" ).append("\n"); 
		query.append(",OPF.VNOR_FM_PORT_CD" ).append("\n"); 
		query.append(",OPF.VNOR_TO_PORT_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD03388'" ).append("\n"); 
		query.append("    AND INTG_CD_VAL_CTNT = OPF.VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append(") AS VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD03384'" ).append("\n"); 
		query.append("    AND INTG_CD_VAL_CTNT = OPF.VNOR_OFFH_TP_CD" ).append("\n"); 
		query.append(") AS VNOR_OFFH_TP_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD03389'" ).append("\n"); 
		query.append("    AND INTG_CD_VAL_CTNT = OPF.VNOR_STUP_STS_CD" ).append("\n"); 
		query.append(") AS VNOR_STUP_STS_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD03391'" ).append("\n"); 
		query.append("    AND INTG_CD_VAL_CTNT = (" ).append("\n"); 
		query.append("        SELECT FMS_STS_CD" ).append("\n"); 
		query.append("        FROM FMS_INFO" ).append("\n"); 
		query.append("        WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("        AND SKD_VOY_NO = OPF.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = OPF.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND VNOR_OFFH_FM_DT = OPF.VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("        AND VNOR_OFFH_TO_DT = OPF.VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("        AND CR_CHK_FLG = OPF.CR_CHK_FLG" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(") AS FMS_STS_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT SUM(VNOR_ITM_VAL)" ).append("\n"); 
		query.append("    FROM OPF_VNOR_ITM" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND VNOR_SEQ = OPF.VNOR_SEQ" ).append("\n"); 
		query.append("    AND VNOR_MN_ITM_FLG = 'N'" ).append("\n"); 
		query.append("    AND VNOR_ITM_CD = 'HF'" ).append("\n"); 
		query.append(") AS HF_ITM_VAL" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT SUM(VNOR_ITM_VAL)" ).append("\n"); 
		query.append("    FROM OPF_VNOR_ITM" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND VNOR_SEQ = OPF.VNOR_SEQ" ).append("\n"); 
		query.append("    AND VNOR_MN_ITM_FLG = 'N'" ).append("\n"); 
		query.append("    AND VNOR_ITM_CD = 'MD'" ).append("\n"); 
		query.append(") AS MD_ITM_VAL" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT SUM(VNOR_ITM_VAL)" ).append("\n"); 
		query.append("    FROM OPF_VNOR_ITM" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND VNOR_SEQ = OPF.VNOR_SEQ" ).append("\n"); 
		query.append("    AND VNOR_MN_ITM_FLG = 'N'" ).append("\n"); 
		query.append("    AND VNOR_ITM_CD = 'LF'" ).append("\n"); 
		query.append(") AS LF_ITM_VAL" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT SUM(VNOR_ITM_VAL)" ).append("\n"); 
		query.append("    FROM OPF_VNOR_ITM" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND VNOR_SEQ = OPF.VNOR_SEQ" ).append("\n"); 
		query.append("    AND VNOR_MN_ITM_FLG = 'N'" ).append("\n"); 
		query.append("    AND VNOR_ITM_CD = 'LD'" ).append("\n"); 
		query.append(") AS LD_ITM_VAL" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT SUM(VNOR_ITM_VAL)" ).append("\n"); 
		query.append("    FROM OPF_VNOR_ITM" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND VNOR_SEQ = OPF.VNOR_SEQ" ).append("\n"); 
		query.append("    AND VNOR_MN_ITM_FLG = 'N'" ).append("\n"); 
		query.append("    AND VNOR_ITM_CD = 'PC'" ).append("\n"); 
		query.append(") AS PC_ITM_VAL" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT SUM(VNOR_ITM_VAL)" ).append("\n"); 
		query.append("    FROM OPF_VNOR_ITM" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND VNOR_SEQ = OPF.VNOR_SEQ" ).append("\n"); 
		query.append("    AND VNOR_MN_ITM_FLG = 'N'" ).append("\n"); 
		query.append("    AND VNOR_ITM_CD = 'TC'" ).append("\n"); 
		query.append(") AS TC_ITM_VAL" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT SUM(VNOR_ITM_VAL)" ).append("\n"); 
		query.append("    FROM OPF_VNOR_ITM" ).append("\n"); 
		query.append("    WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("    AND VNOR_SEQ = OPF.VNOR_SEQ" ).append("\n"); 
		query.append("    AND VNOR_MN_ITM_FLG = 'N'" ).append("\n"); 
		query.append("    AND VNOR_ITM_CD = 'OT'" ).append("\n"); 
		query.append(") AS OT_ITM_VAL" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    CASE WHEN (SELECT MAX(VNOR_ITM_OFC_CD) FROM OPF_VNOR_ITM WHERE VSL_CD = OPF.VSL_CD AND VNOR_SEQ = OPF.VNOR_SEQ AND VNOR_ITM_CD = 'PC') != NULL" ).append("\n"); 
		query.append("        THEN (SELECT MAX(VNOR_ITM_OFC_CD) FROM OPF_VNOR_ITM WHERE VSL_CD = OPF.VSL_CD AND VNOR_SEQ = OPF.VNOR_SEQ AND VNOR_ITM_CD = 'PC')" ).append("\n"); 
		query.append("        ELSE (SELECT MAX(VNOR_ITM_OFC_CD) FROM OPF_VNOR_ITM WHERE VSL_CD = OPF.VSL_CD AND VNOR_SEQ = OPF.VNOR_SEQ)" ).append("\n"); 
		query.append("    END" ).append("\n"); 
		query.append(") AS VNOR_ITM_OFC_CD" ).append("\n"); 
		query.append(",(TO_CHAR(OPF.VNOR_OFFH_FM_DT, 'YYYY.MM.DD.HH24:MI')" ).append("\n"); 
		query.append("			|| '-'" ).append("\n"); 
		query.append("			|| TO_CHAR(OPF.VNOR_OFFH_TO_DT, 'YYYY.MM.DD.HH24:MI')" ).append("\n"); 
		query.append("			|| OPF.CR_CHK_FLG" ).append("\n"); 
		query.append("			|| OPF.VNOR_SEQ" ).append("\n"); 
		query.append("		) AS OFF_HIRE_TIME_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	CASE WHEN (" ).append("\n"); 
		query.append("		SELECT CRE_USR_ID" ).append("\n"); 
		query.append("		FROM FMS_INFO" ).append("\n"); 
		query.append("		WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("		AND SKD_VOY_NO = OPF.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND SKD_DIR_CD = OPF.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND VNOR_OFFH_FM_DT = OPF.VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("		AND VNOR_OFFH_TO_DT = OPF.VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("		AND CR_CHK_FLG = OPF.CR_CHK_FLG" ).append("\n"); 
		query.append("	) != NULL" ).append("\n"); 
		query.append("	THEN (" ).append("\n"); 
		query.append("		SELECT CRE_USR_ID" ).append("\n"); 
		query.append("		FROM FMS_INFO" ).append("\n"); 
		query.append("		WHERE VSL_CD = OPF.VSL_CD" ).append("\n"); 
		query.append("		AND SKD_VOY_NO = OPF.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND SKD_DIR_CD = OPF.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND VNOR_OFFH_FM_DT = OPF.VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("		AND VNOR_OFFH_TO_DT = OPF.VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("		AND CR_CHK_FLG = OPF.CR_CHK_FLG" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	ELSE OPF.CRE_USR_ID" ).append("\n"); 
		query.append("	END" ).append("\n"); 
		query.append(") AS CREATED_BY" ).append("\n"); 
		query.append("#if (${vnor_stup_sts_cd} == 'S' || ${vnor_stup_sts_cd} == 'N' || ${vnor_stup_sts_cd} == 'A' || ${vnor_stup_sts_cd} == 'C')" ).append("\n"); 
		query.append("FROM OPF_VNOR OPF, FMS_INFO FMS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM OPF_VNOR OPF" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${vnor_stup_sts_cd} == 'S' || ${vnor_stup_sts_cd} == 'N' || ${vnor_stup_sts_cd} == 'A' || ${vnor_stup_sts_cd} == 'C')" ).append("\n"); 
		query.append("	AND OPF.VSL_CD = FMS.VSL_CD" ).append("\n"); 
		query.append("	AND OPF.SKD_VOY_NO = FMS.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND OPF.SKD_DIR_CD = FMS.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND OPF.VNOR_OFFH_FM_DT = FMS.VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("	AND OPF.VNOR_OFFH_TO_DT = FMS.VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("	AND OPF.CR_CHK_FLG = FMS.CR_CHK_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_date} != '')" ).append("\n"); 
		query.append("	AND OPF.CRE_DT >= TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_date} != '')" ).append("\n"); 
		query.append("	AND OPF.CRE_DT <= TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("	AND OPF.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vnor_offh_knd_cd} != '' && ${vnor_offh_knd_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND OPF.VNOR_OFFH_KND_CD = @[vnor_offh_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vnor_offh_tp_cd} != '' && ${vnor_offh_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND OPF.VNOR_OFFH_TP_CD = @[vnor_offh_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vnor_stup_sts_cd} == 'SA' || ${vnor_stup_sts_cd} == 'SU')" ).append("\n"); 
		query.append("	AND OPF.VNOR_STUP_STS_CD = @[vnor_stup_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY OPF.CRE_DT DESC" ).append("\n"); 

	}
}
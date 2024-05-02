/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchMGSInventoryDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [EES_CGM_2075] M.G.Set Inventory Detail : Retrieve
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchMGSInventoryDetailDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_dtch",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aciac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sty_dys_ov",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryDetailDataRSQL").append("\n"); 
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
		query.append("WITH HEAD AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A.EQ_NO" ).append("\n"); 
		query.append("         , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("         , A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("         , A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') as AGMT_NO" ).append("\n"); 
		query.append("         , DECODE(A.ACIAC_DIV_CD, 'A', 'Y', 'N') AS ACIAC_DIV_CD" ).append("\n"); 
		query.append("         , NVL(A.DMG_FLG, 'N') AS DMG_FLG" ).append("\n"); 
		query.append("         , NVL(A.DISP_FLG, 'N') AS DISP_FLG" ).append("\n"); 
		query.append("         , A.CHSS_MVMT_DT" ).append("\n"); 
		query.append("    FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("    WHERE A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${eq_no} != '')" ).append("\n"); 
		query.append("    AND A.EQ_NO in ($eq_no)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- MAIN QUERY" ).append("\n"); 
		query.append("SELECT A.EQ_NO" ).append("\n"); 
		query.append("      ,MAS_LOC_FNC(CASE WHEN A.ATCH_DTCH = 'Attached' THEN A.LST_YD" ).append("\n"); 
		query.append("                        WHEN A.ATCH_DTCH = 'Detached' THEN A.DTCH_YD_CD" ).append("\n"); 
		query.append("                         END, 'SCC') AS SCC_CD" ).append("\n"); 
		query.append("      ,MAS_LOC_FNC(CASE WHEN A.ATCH_DTCH = 'Attached' THEN A.LST_YD" ).append("\n"); 
		query.append("                        WHEN A.ATCH_DTCH = 'Detached' THEN A.DTCH_YD_CD" ).append("\n"); 
		query.append("                         END, 'LCC') AS LCC_CD" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("      ,A.AGMT_NO" ).append("\n"); 
		query.append("      ,A.ACIAC_DIV_CD" ).append("\n"); 
		query.append("      ,A.DMG_FLG" ).append("\n"); 
		query.append("      ,A.DISP_FLG" ).append("\n"); 
		query.append("      ,A.ATCH_DTCH" ).append("\n"); 
		query.append("      ,CASE WHEN A.ATCH_DTCH = 'Attached' THEN A.LST_YD" ).append("\n"); 
		query.append("            WHEN A.ATCH_DTCH = 'Detached' THEN A.DTCH_YD_CD" ).append("\n"); 
		query.append("       END LST_YD" ).append("\n"); 
		query.append("      -- Last Status Date" ).append("\n"); 
		query.append("      ,CASE WHEN A.ATCH_DTCH = 'Attached' THEN TO_CHAR(A.STS_UPD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("            WHEN A.ATCH_DTCH = 'Detached' THEN A.DTCH_DT_YMD" ).append("\n"); 
		query.append("       END STS_UPD_DT" ).append("\n"); 
		query.append("      ,CASE WHEN A.ATCH_DTCH = 'Attached' THEN ROUND(SYSDATE - A.STS_UPD_DT)" ).append("\n"); 
		query.append("            WHEN A.ATCH_DTCH = 'Detached' THEN ROUND(SYSDATE - to_date(A.DTCH_DT_YMD || DTCH_DT_HD, 'yyyymmddhh24mi'))" ).append("\n"); 
		query.append("       END STAY_DYS" ).append("\n"); 
		query.append("      ,A.CNTR_CHSS" ).append("\n"); 
		query.append("       -- LAST MOVEMENT" ).append("\n"); 
		query.append("      ,CASE WHEN A.ATCH_DTCH = 'Attached' AND A.EQ_TPSZ_CD = 'CLG' THEN (SELECT X.CNMV_STS_CD      FROM MST_CONTAINER X WHERE X.CNTR_NO = A.CNTR_CHSS) --CNMV_DT" ).append("\n"); 
		query.append("            WHEN A.ATCH_DTCH = 'Attached' AND A.EQ_TPSZ_CD = 'UMG' THEN (SELECT X.CHSS_MVMT_STS_CD FROM CGM_EQUIPMENT X WHERE X.EQ_NO   = A.CNTR_CHSS)" ).append("\n"); 
		query.append("       END CHSS_MVMT_STS_CD  " ).append("\n"); 
		query.append("       -- LAST MOVMENT DATE" ).append("\n"); 
		query.append("      ,CASE WHEN A.ATCH_DTCH = 'Attached' AND A.EQ_TPSZ_CD = 'CLG' THEN (SELECT X.CNMV_DT      FROM MST_CONTAINER X WHERE X.CNTR_NO = A.CNTR_CHSS) --CNMV_DT" ).append("\n"); 
		query.append("            WHEN A.ATCH_DTCH = 'Attached' AND A.EQ_TPSZ_CD = 'UMG' THEN (SELECT X.CHSS_MVMT_DT FROM CGM_EQUIPMENT X WHERE X.EQ_NO   = A.CNTR_CHSS)" ).append("\n"); 
		query.append("       END CHSS_MVMT_DT   " ).append("\n"); 
		query.append("      ,A.ATCH_DT_YMD" ).append("\n"); 
		query.append("      ,A.ATCH_DT_HD" ).append("\n"); 
		query.append("      ,A.ATCH_YD_CD" ).append("\n"); 
		query.append("      ,A.DTCH_DT_YMD" ).append("\n"); 
		query.append("      ,A.DTCH_DT_HD" ).append("\n"); 
		query.append("      ,A.DTCH_YD_CD" ).append("\n"); 
		query.append("      ,A.UPD_DT_YMD" ).append("\n"); 
		query.append("      ,A.UPD_DT_HD" ).append("\n"); 
		query.append("      ,U.OFC_CD" ).append("\n"); 
		query.append("      ,NVL(U.USR_NM, A.UPD_USR_ID) as USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT DECODE(TO_CHAR(D.DTCH_DT, 'YYYY'), '8888', D.ATCH_DT, D.DTCH_DT) LAST_DT, ROW_NUMBER() OVER(PARTITION BY A.EQ_NO  ORDER BY DECODE(TO_CHAR(D.DTCH_DT, 'YYYY'), '8888', D.ATCH_DT, D.DTCH_DT) DESC) RN  " ).append("\n"); 
		query.append("          ,A.EQ_NO" ).append("\n"); 
		query.append("          ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("          ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("          ,A.AGMT_NO" ).append("\n"); 
		query.append("          ,A.ACIAC_DIV_CD" ).append("\n"); 
		query.append("          ,A.DMG_FLG" ).append("\n"); 
		query.append("          ,A.DISP_FLG" ).append("\n"); 
		query.append("          ,DECODE(D.DTCH_YD_CD , null, DECODE(D.ATCH_YD_CD, NULL, '', 'Attached'), 'Detached') as ATCH_DTCH" ).append("\n"); 
		query.append("          -- LAST_YARD" ).append("\n"); 
		query.append("          ,CASE WHEN A.EQ_TPSZ_CD = 'CLG' THEN (SELECT X.CRNT_YD_CD FROM MST_CONTAINER X WHERE X.CNTR_NO = DECODE(A.EQ_TPSZ_CD, 'CLG', D.CNTR_NO, 'UMG', D.CHSS_NO))" ).append("\n"); 
		query.append("                WHEN A.EQ_TPSZ_CD = 'UMG' THEN (SELECT X.CRNT_YD_CD FROM CGM_EQUIPMENT X WHERE X.EQ_NO   = DECODE(A.EQ_TPSZ_CD, 'CLG', D.CNTR_NO, 'UMG', D.CHSS_NO))" ).append("\n"); 
		query.append("           END LST_YD" ).append("\n"); 
		query.append("          -- Last Status Date" ).append("\n"); 
		query.append("          ,CASE WHEN A.EQ_TPSZ_CD = 'CLG' THEN (SELECT X.CNMV_DT      FROM MST_CONTAINER X WHERE X.CNTR_NO = DECODE(A.EQ_TPSZ_CD, 'CLG', D.CNTR_NO, 'UMG', D.CHSS_NO))" ).append("\n"); 
		query.append("                WHEN A.EQ_TPSZ_CD = 'UMG' THEN (SELECT X.CHSS_MVMT_DT FROM CGM_EQUIPMENT X WHERE X.EQ_NO   = DECODE(A.EQ_TPSZ_CD, 'CLG', D.CNTR_NO, 'UMG', D.CHSS_NO))" ).append("\n"); 
		query.append("           END STS_UPD_DT" ).append("\n"); 
		query.append("          ,DECODE(A.EQ_TPSZ_CD, 'CLG', D.CNTR_NO, 'UMG', D.CHSS_NO) CNTR_CHSS" ).append("\n"); 
		query.append("          ,DECODE(D.ATCH_DT, null, '', TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(D.ATCH_DT,'YYYYMMDD')) AS ATCH_DT_YMD" ).append("\n"); 
		query.append("          ,DECODE(D.ATCH_DT, null, '', TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(D.ATCH_DT,'HH24MI')) AS ATCH_DT_HD" ).append("\n"); 
		query.append("          ,NVL(D.ATCH_YD_CD, '') AS ATCH_YD_CD" ).append("\n"); 
		query.append("          ,DECODE (D.DTCH_DT, null, '', TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(D.DTCH_DT,'YYYYMMDD')) AS DTCH_DT_YMD" ).append("\n"); 
		query.append("          ,DECODE (D.DTCH_DT, null, '', TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(D.DTCH_DT,'HH24MI')) AS DTCH_DT_HD" ).append("\n"); 
		query.append("          ,NVL(D.DTCH_YD_CD, '') AS DTCH_YD_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(D.UPD_DT,'YYYYMMDD') AS UPD_DT_YMD" ).append("\n"); 
		query.append("          ,TO_CHAR(D.UPD_DT,'HH24MI') AS UPD_DT_HD" ).append("\n"); 
		query.append("          ,D.UPD_USR_ID" ).append("\n"); 
		query.append("    FROM HEAD A" ).append("\n"); 
		query.append("        ,CGM_EQ_ATCH_DTCH_HIS D" ).append("\n"); 
		query.append("    WHERE A.EQ_NO = D.EQ_NO(+)   -- outer join " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A , COM_USER U" ).append("\n"); 
		query.append("WHERE  A.RN = 1" ).append("\n"); 
		query.append("AND A.UPD_USR_ID = U.USR_ID(+)" ).append("\n"); 
		query.append("#if (${loc_list} != '')" ).append("\n"); 
		query.append("  #if (${loc_cd} == 'R')" ).append("\n"); 
		query.append("AND MAS_LOC_FNC(A.LST_YD, 'RCC') in ($loc_list)" ).append("\n"); 
		query.append("  #elseif (${loc_cd} == 'L')" ).append("\n"); 
		query.append("AND MAS_LOC_FNC(A.LST_YD, 'LCC') in ($loc_list)" ).append("\n"); 
		query.append("  #elseif (${loc_cd} == 'E')" ).append("\n"); 
		query.append("AND MAS_LOC_FNC(A.LST_YD, 'ECC') in ($loc_list)" ).append("\n"); 
		query.append("  #elseif (${loc_cd} == 'S')" ).append("\n"); 
		query.append("AND MAS_LOC_FNC(A.LST_YD, 'SCC') in ($loc_list)" ).append("\n"); 
		query.append("  #elseif (${loc_cd} == 'Y')" ).append("\n"); 
		query.append("AND A.LST_YD in ($loc_list)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${aciac_div_cd} != '')" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = @[aciac_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${atch_dtch} != '')" ).append("\n"); 
		query.append("AND A.ATCH_DTCH = @[atch_dtch]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sty_dys_ov} != '')" ).append("\n"); 
		query.append("AND ROUND(sysdate - A.STS_UPD_DT) >= @[sty_dys_ov]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
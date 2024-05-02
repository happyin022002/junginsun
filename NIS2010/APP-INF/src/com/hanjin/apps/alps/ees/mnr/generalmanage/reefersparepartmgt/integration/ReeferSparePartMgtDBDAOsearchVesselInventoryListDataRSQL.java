/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOsearchVesselInventoryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReeferSparePartMgtDBDAOsearchVesselInventoryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOsearchVesselInventoryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_invt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOsearchVesselInventoryListDataRSQL").append("\n"); 
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
		query.append("WITH PC AS (" ).append("\n"); 
		query.append("SELECT SPR_PRT_VER_SEQ, SPR_PRT_VNDR_SEQ, SPR_UT_MDL_NM, VNDR_NM, SPR_PRT_DP_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT SPR_PRT_VER_SEQ, SPR_PRT_VNDR_SEQ, SPR_UT_MDL_NM        " ).append("\n"); 
		query.append("        , CASE WHEN SPR_UT_MDL_NM = 'GE' THEN 'General'" ).append("\n"); 
		query.append("            ELSE ( SELECT NVL(VNDR_ABBR_NM,VNDR_LGL_ENG_NM) AS VNDR_NM" ).append("\n"); 
		query.append("                    FROM MDM_VENDOR V" ).append("\n"); 
		query.append("                    WHERE V.VNDR_SEQ = C.SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("                    AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   ) " ).append("\n"); 
		query.append("          END AS VNDR_NM" ).append("\n"); 
		query.append("		, MAX(C.SPR_PRT_DP_SEQ) AS SPR_PRT_DP_SEQ" ).append("\n"); 
		query.append("    FROM MNR_VSL_SPR_PRT_CD C" ).append("\n"); 
		query.append("    WHERE C.SPR_PRT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND C.SPR_PRT_VER_SEQ = (" ).append("\n"); 
		query.append("#if (${spr_prt_invt_no} == '') " ).append("\n"); 
		query.append("                                SELECT MAX(SPR_PRT_VER_SEQ) AS SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("                                FROM MNR_VSL_SPR_PRT_CD" ).append("\n"); 
		query.append("                                WHERE SPR_PRT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${spr_prt_invt_no} != '')" ).append("\n"); 
		query.append("								SELECT MAX( SPR_PRT_VER_SEQ ) AS SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("                                FROM MNR_VSL_SPR_PRT_INVT IT" ).append("\n"); 
		query.append("                                WHERE SPR_PRT_INVT_NO = @[spr_prt_invt_no]" ).append("\n"); 
		query.append("                                AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("    GROUP BY C.SPR_PRT_VER_SEQ, C.SPR_PRT_VNDR_SEQ, C.SPR_UT_MDL_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) SAM" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ORDER BY SPR_PRT_VER_SEQ, SPR_PRT_DP_SEQ, VNDR_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MV AS (" ).append("\n"); 
		query.append("    SELECT SPR_PRT_INVT_NO, CRE_USR_ID, CRE_DT" ).append("\n"); 
		query.append("    -- SELECT *" ).append("\n"); 
		query.append("    FROM MNR_VSL_SPR_PRT_INVT IT" ).append("\n"); 
		query.append("    WHERE SPR_PRT_INVT_NO = @[spr_prt_invt_no]" ).append("\n"); 
		query.append("    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND SPR_PRT_INVT_VER_SEQ = (" ).append("\n"); 
		query.append("                                    SELECT MIN(SPR_PRT_INVT_VER_SEQ) AS SPR_PRT_INVT_VER_SEQ" ).append("\n"); 
		query.append("                                    FROM MNR_VSL_SPR_PRT_INVT IV" ).append("\n"); 
		query.append("                                    WHERE IV.SPR_PRT_INVT_NO = @[spr_prt_invt_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    GROUP BY IV.SPR_PRT_INVT_NO" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("	GROUP BY SPR_PRT_INVT_NO, CRE_USR_ID, CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VSPI AS (" ).append("\n"); 
		query.append("    SELECT SPR_PRT_INVT_NO" ).append("\n"); 
		query.append("		, MAX(SPR_PRT_INVT_VER_SEQ) AS SPR_PRT_INVT_VER_SEQ" ).append("\n"); 
		query.append("		, LANE_CD, VSL_CD" ).append("\n"); 
		query.append("        , SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("        , SPR_PRT_TP_CD" ).append("\n"); 
		query.append("        , MAX(SPR_PRT_VER_SEQ) AS SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("        -- select *" ).append("\n"); 
		query.append("    FROM MNR_VSL_SPR_PRT_INVT IT" ).append("\n"); 
		query.append("    WHERE SPR_PRT_INVT_NO = @[spr_prt_invt_no]" ).append("\n"); 
		query.append("	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND SPR_PRT_INVT_VER_SEQ = (" ).append("\n"); 
		query.append("                                    SELECT MAX(SPR_PRT_INVT_VER_SEQ) AS SPR_PRT_INVT_VER_SEQ" ).append("\n"); 
		query.append("                                    FROM MNR_VSL_SPR_PRT_INVT IV" ).append("\n"); 
		query.append("                                    WHERE IV.SPR_PRT_INVT_NO = @[spr_prt_invt_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    GROUP BY IV.SPR_PRT_INVT_NO" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("    GROUP BY SPR_PRT_INVT_NO, SPR_PRT_INVT_VER_SEQ, LANE_CD, VSL_CD, SPR_PRT_VNDR_SEQ, SPR_PRT_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SPI.SPR_PRT_INVT_NO, rownum AS SPR_PRT_INVT_SEQ, SPI.SPR_PRT_INVT_VER_SEQ" ).append("\n"); 
		query.append("    , SPI.LANE_CD, SPI.VSL_CD" ).append("\n"); 
		query.append("    , ( SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("        WHERE VSL_CD = SPI.VSL_CD" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("       )AS VSL_NM" ).append("\n"); 
		query.append("    , ( SELECT CRR_CD" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("        WHERE VSL_CD = SPI.VSL_CD" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("       )  AS CRR_CD" ).append("\n"); 
		query.append("    , SPI.SPR_PRT_TP_CD" ).append("\n"); 
		query.append("    , SPI.SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("    , SPI.SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("    , SPI.VNDR_NM" ).append("\n"); 
		query.append("    , SPI.SPR_UT_MDL_NM" ).append("\n"); 
		query.append("    , SPI.SPR_UT_SHR_CD" ).append("\n"); 
		query.append("    , SPI.SPR_PRT_CRNT_AMT" ).append("\n"); 
		query.append("	, 'N' AS DELT_FLG" ).append("\n"); 
		query.append("	, MV.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("	, TO_CHAR(MV.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("	, '' AS UPD_USR_ID" ).append("\n"); 
		query.append("	, '' AS UPD_DT" ).append("\n"); 
		query.append("	, '' AS OFC_CD" ).append("\n"); 
		query.append("	, '' AS FROM_DT" ).append("\n"); 
		query.append("	, '' AS TO_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT VSPI.SPR_PRT_INVT_NO" ).append("\n"); 
		query.append("            , VSPI.SPR_PRT_INVT_VER_SEQ, VSPI.LANE_CD" ).append("\n"); 
		query.append("            , VSPI.VSL_CD" ).append("\n"); 
		query.append("            , VSPI.SPR_PRT_TP_CD" ).append("\n"); 
		query.append("            , VSPI.SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("            , VSPI.SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("            , PC.VNDR_NM" ).append("\n"); 
		query.append("            , PC.SPR_UT_MDL_NM" ).append("\n"); 
		query.append("            , NVL(" ).append("\n"); 
		query.append("                    (SELECT SPR_UT_SHR_CD" ).append("\n"); 
		query.append("                       FROM MNR_VSL_SPR_PRT_INVT" ).append("\n"); 
		query.append("                      WHERE SPR_PRT_INVT_NO = VSPI.SPR_PRT_INVT_NO" ).append("\n"); 
		query.append("                        AND SPR_PRT_INVT_VER_SEQ = VSPI.SPR_PRT_INVT_VER_SEQ" ).append("\n"); 
		query.append("						AND SPR_PRT_VNDR_SEQ = VSPI.SPR_PRT_VNDR_SEQ						" ).append("\n"); 
		query.append("                        AND LANE_CD = VSPI.LANE_CD" ).append("\n"); 
		query.append("                        AND VSL_CD = VSPI.VSL_CD" ).append("\n"); 
		query.append("                        AND SPR_PRT_TP_CD = VSPI.SPR_PRT_TP_CD" ).append("\n"); 
		query.append("                        AND SPR_UT_MDL_NM = PC.SPR_UT_MDL_NM" ).append("\n"); 
		query.append("                        AND SPR_PRT_VER_SEQ = VSPI.SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("                    ), '') AS SPR_UT_SHR_CD" ).append("\n"); 
		query.append("            , NVL(" ).append("\n"); 
		query.append("                    (SELECT SPR_PRT_CRNT_AMT " ).append("\n"); 
		query.append("                       FROM MNR_VSL_SPR_PRT_CD" ).append("\n"); 
		query.append("                      WHERE SPR_PRT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        AND SPR_PRT_VNDR_SEQ = VSPI.SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("                        AND SPR_PRT_TP_CD = VSPI.SPR_PRT_TP_CD" ).append("\n"); 
		query.append("						AND SPR_UT_MDL_NM = PC.SPR_UT_MDL_NM" ).append("\n"); 
		query.append("                        AND SPR_PRT_VER_SEQ = (" ).append("\n"); 
		query.append("                                                   SELECT MAX(SPR_PRT_VER_SEQ)" ).append("\n"); 
		query.append("                                                   FROM MNR_VSL_SPR_PRT_CD" ).append("\n"); 
		query.append("                                                   WHERE SPR_PRT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                    AND SPR_PRT_VNDR_SEQ = VSPI.SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("                                                    AND SPR_PRT_TP_CD = VSPI.SPR_PRT_TP_CD" ).append("\n"); 
		query.append("                                                    AND SPR_PRT_VER_SEQ = VSPI.SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                    ),0) AS SPR_PRT_CRNT_AMT" ).append("\n"); 
		query.append("            , PC.SPR_PRT_DP_SEQ" ).append("\n"); 
		query.append("            , TO_NUMBER( VSPI.SPR_PRT_VNDR_SEQ ) AS VNDR_SEQ_NUM   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM PC" ).append("\n"); 
		query.append("            , VSPI" ).append("\n"); 
		query.append("        WHERE PC.SPR_PRT_VNDR_SEQ = VSPI.SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("    ) SPI" ).append("\n"); 
		query.append("    , MV" ).append("\n"); 
		query.append("WHERE SPI. SPR_PRT_INVT_NO = MV.SPR_PRT_INVT_NO   " ).append("\n"); 
		query.append("ORDER BY SPI.SPR_PRT_INVT_NO, SPI.LANE_CD, SPI.VSL_CD, SPI.SPR_PRT_TP_CD, SPI.SPR_PRT_VER_SEQ, SPI.SPR_PRT_DP_SEQ, SPI.VNDR_SEQ_NUM" ).append("\n"); 

	}
}
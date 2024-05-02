/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlRouteCountryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.18
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.07.18 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlRouteCountryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchBlRouteCountryRSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlRouteCountryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlRouteCountryRSQL").append("\n"); 
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
		query.append("/*  Eur24BlRouteCntListVOs Eur24CustomsTransmissionDBDAOSearchBlRouteCountry ( blNo) */" ).append("\n"); 
		query.append("/* 2011.06.27 그리스 부도 사태로 한시적으로 수정함*/" ).append("\n"); 
		query.append("/* 2011.07.21 그리스 복구 작업 1*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_type} != 'FI') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("CASE WHEN ROUTE_CNT = 'GR' AND TEMP_CLPT_SEQ = 0 THEN TEMP_ROUTE_CNT" ).append("\n"); 
		query.append("ELSE ROUTE_CNT END  AS ROUTE_CNT" ).append("\n"); 
		query.append(",CLPT_SEQ,TEMP_CLPT_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("          SUBSTR(VPS_PORT_CD,1,2) AS ROUTE_CNT" ).append("\n"); 
		query.append("          , MIN(CLPT_SEQ)         AS CLPT_SEQ" ).append("\n"); 
		query.append("		  , MAX(A.MVMT_REF_NO) MVMT_REF_NO" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("          SELECT MIN(DECODE(A.POL_CD, B.VPS_PORT_CD, CLPT_SEQ)) POL_SEQ ," ).append("\n"); 
		query.append("            MAX(DECODE(A.POD_CD, B.VPS_PORT_CD, CLPT_SEQ)) POD_SEQ," ).append("\n"); 
		query.append("			MAX(A.MVMT_REF_NO) AS MVMT_REF_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_BL A," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("         WHERE A.BL_NO=@[bl_no]" ).append("\n"); 
		query.append("           AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_cD = B.SKD_dIR_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ) A" ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("        WHERE B.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("          AND B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND B.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND B.CLPT_SEQ BETWEEN A. POL_SEQ AND A.POD_SEQ" ).append("\n"); 
		query.append("      GROUP BY SUBSTR(VPS_PORT_CD,1,2) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ) A," ).append("\n"); 
		query.append("  (SELECT 'IT' AS TEMP_ROUTE_CNT, 1 AS TEMP_CLPT_SEQ FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT 'IT'                  , 0                  FROM DUAL ) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE TEMP_CLPT_SEQ =1 OR ( SUBSTR(A.MVMT_REF_NO,1 ,4) = '11IT' AND ROUTE_CNT = 'GR' AND TEMP_CLPT_SEQ = 0)" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ,TEMP_CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT ROUTE_CNT" ).append("\n"); 
		query.append("     , MAX(NO) AS CLPT_SEQ " ).append("\n"); 
		query.append("FROM (SELECT SUBSTR(A.VPS_PORT_CD, 1, 2) AS ROUTE_CNT" ).append("\n"); 
		query.append("           , ROWNUM NO" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("           , ( SELECT SKD1.VSL_CD, SKD1.SKD_VOY_NO, SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                    , SKD1.VPS_PORT_CD AS POL_CD, SKD1.CLPT_SEQ AS POL_CLPT_SEQ" ).append("\n"); 
		query.append("                    , SKD2.VPS_PORT_CD AS POD_CD, SKD2.CLPT_SEQ AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("                 FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                    , BKG_BOOKING BKG" ).append("\n"); 
		query.append("                    , BKG_BL_DOC BD" ).append("\n"); 
		query.append("                    , VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("                    , VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("                  AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                  AND BKG.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("                  AND BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  AND BKG.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                  AND VVD.VSL_CD         = SKD1.VSL_CD" ).append("\n"); 
		query.append("                  AND VVD.SKD_VOY_NO     = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND VVD.SKD_DIR_CD     = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VVD.POL_CD         = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND VVD.POL_CLPT_IND_SEQ = SKD1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND NVL(SKD1.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                  AND VVD.VSL_CD         = SKD2.VSL_CD" ).append("\n"); 
		query.append("                  AND VVD.SKD_VOY_NO     = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND VVD.SKD_DIR_CD     = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VVD.POD_CD         = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND VVD.POD_CLPT_IND_SEQ = SKD2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND NVL(SKD2.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                ORDER BY VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ" ).append("\n"); 
		query.append("             ) B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND A.CLPT_SEQ >= B.POL_CLPT_SEQ" ).append("\n"); 
		query.append("        AND A.CLPT_SEQ <= B.POD_CLPT_SEQ" ).append("\n"); 
		query.append("        AND NVL(A.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("GROUP BY ROUTE_CNT" ).append("\n"); 
		query.append("ORDER BY 2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfVvdDtlInitialListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfVvdDtlInitialListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한진조직코드변환
	  * :SELBB->SELSC,PUSBB->PUSSC
	  * 2011.03.30 김영철 [CHM-201109395] Korea Wharfage 보완 요청 - VSL에 정상된 할인률값을 조회함.
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfVvdDtlInitialListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfVvdDtlInitialListRSQL").append("\n"); 
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
		query.append("SELECT PORT_SEQ," ).append("\n"); 
		query.append("       UNLD_TP_CD," ).append("\n"); 
		query.append("       TTL_TON_QTY," ).append("\n"); 
		query.append("#if (${ofc_cd} == 'PUSBS' || ${ofc_cd} == 'SELSC' || ${ofc_cd} == 'PUSSC')       " ).append("\n"); 
		query.append("	   CASE WHEN KR_WHF_DC_CD = 0 AND KR_WHF_DC_RSN_CD IN ('1','2','6','9') THEN '4' " ).append("\n"); 
		query.append("       ELSE KR_WHF_DC_CD" ).append("\n"); 
		query.append("       END AS KR_WHF_DC_CD," ).append("\n"); 
		query.append("#else  " ).append("\n"); 
		query.append("       KR_WHF_DC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} == 'PUSBS' || ${ofc_cd} == 'SELSC' || ${ofc_cd} == 'PUSSC')  " ).append("\n"); 
		query.append("       CASE WHEN KR_WHF_DC_RSN_CD IN ('1','2','6','9') THEN '100%'" ).append("\n"); 
		query.append("       ELSE RATE" ).append("\n"); 
		query.append("       END AS RATE," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       RATE," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       KR_WHF_DC_RSN_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       UPD_FLG" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(SELECT ROWNUM AS PORT_SEQ," ).append("\n"); 
		query.append("CASE B.SORT_VALUE WHEN 'dd20' THEN '6'" ).append("\n"); 
		query.append("WHEN 'dd40' THEN '8'" ).append("\n"); 
		query.append("WHEN 'dd45' THEN '9'" ).append("\n"); 
		query.append("ELSE '2'" ).append("\n"); 
		query.append("END AS UNLD_TP_CD," ).append("\n"); 
		query.append("SUM ( CASE SUBSTR(B.SORT_KEY, 1, 1) WHEN 'B' THEN A.RTON" ).append("\n"); 
		query.append("ELSE CASE B.SORT_VALUE WHEN A.DDD20 THEN A.D20" ).append("\n"); 
		query.append("WHEN A.DDD40 THEN A.D40" ).append("\n"); 
		query.append("WHEN A.DDD45 THEN A.D45" ).append("\n"); 
		query.append("END END) AS TTL_TON_QTY," ).append("\n"); 
		query.append("( SELECT WHF_VOL_DC_CD FROM BKG_KR_WHF_VOL A" ).append("\n"); 
		query.append("   WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("     AND DECODE(@[whf_bnd_cd],'IN',SUBSTR(A.WHF_BND_CD,1,1),'ON',SUBSTR(A.WHF_BND_CD,1,1),A.WHF_BND_CD) = DECODE(@[whf_bnd_cd],'IN','I','ON','O',@[whf_bnd_cd])" ).append("\n"); 
		query.append("     AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("     AND ROWNUM = 1 ) AS KR_WHF_DC_CD," ).append("\n"); 
		query.append("( SELECT WHF_VOL_DC_CD FROM BKG_KR_WHF_VOL A" ).append("\n"); 
		query.append("   WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("     AND DECODE(@[whf_bnd_cd],'IN',SUBSTR(A.WHF_BND_CD,1,1),'ON',SUBSTR(A.WHF_BND_CD,1,1),A.WHF_BND_CD) = DECODE(@[whf_bnd_cd],'IN','I','ON','O',@[whf_bnd_cd])" ).append("\n"); 
		query.append("     AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("     AND ROWNUM = 1 ) AS RATE," ).append("\n"); 
		query.append("--CASE WHEN A.SORT_KEY IN ('I', 'J') THEN '4'" ).append("\n"); 
		query.append("--WHEN SUBSTR('OO', 1, 1) = 'I' THEN '0'" ).append("\n"); 
		query.append("--ELSE '1'" ).append("\n"); 
		query.append("--END AS KR_WHF_DC_CD," ).append("\n"); 
		query.append("--CASE WHEN A.SORT_KEY IN ('I', 'J') THEN '4'" ).append("\n"); 
		query.append("--WHEN SUBSTR('OO', 1, 1) = 'I' THEN '0'" ).append("\n"); 
		query.append("--ELSE '1'" ).append("\n"); 
		query.append("--END AS RATE," ).append("\n"); 
		query.append("CASE WHEN A.SORT_KEY IN ('BS', 'S') THEN '6'" ).append("\n"); 
		query.append("WHEN A.SORT_KEY IN ('BD', 'D') THEN '3'" ).append("\n"); 
		query.append("WHEN A.SORT_KEY IN ('BX', 'BI', 'X', 'I') THEN '9'" ).append("\n"); 
		query.append("WHEN A.SORT_KEY IN ('BJ', 'J') THEN '2'" ).append("\n"); 
		query.append("WHEN A.SORT_KEY IN ('BK', 'K') THEN '1'" ).append("\n"); 
		query.append("END AS KR_WHF_DC_RSN_CD," ).append("\n"); 
		query.append("'I' AS UPD_FLG" ).append("\n"); 
		query.append("FROM ( SELECT DECODE(NVL(TRIM(AA.WFG_EXPT_CD), 'Z'), 'Z', 'N', 'B', 'N', AA.WFG_EXPT_CD) AS SORT_KEY," ).append("\n"); 
		query.append("       SUM(BB.TAX_TEU_QTY + BB.EXPT_TEU_QTY) AS D20, 'dd20' AS DDD20," ).append("\n"); 
		query.append("       SUM(BB.TAX_FEU_QTY + BB.EXPT_FEU_QTY) AS D40, 'dd40' AS DDD40," ).append("\n"); 
		query.append("       SUM(BB.TAX_45FT_QTY + BB.EXPT_45FT_QTY) AS D45, 'dd45' AS DDD45," ).append("\n"); 
		query.append("       0 AS RTON" ).append("\n"); 
		query.append("  FROM ( SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BL_NO, A.WHF_BND_CD, A.WFG_EXPT_CD, MAX(CHG_RT_SEQ) CHG_RT_SEQ" ).append("\n"); 
		query.append("  FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND DECODE(@[whf_bnd_cd],'IN',SUBSTR(A.WHF_BND_CD,1,1),'ON',SUBSTR(A.WHF_BND_CD,1,1),A.WHF_BND_CD) = DECODE(@[whf_bnd_cd],'IN','I','ON','O',@[whf_bnd_cd])" ).append("\n"); 
		query.append("   AND DECODE(SUBSTR(@[whf_bnd_cd], 1, 1), 'O', A.WHF_POL_cd, A.WHF_POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("   AND NVL(A.WHF_BL_STS_CD, ' ') != 'D'" ).append("\n"); 
		query.append("   AND A.WHF_AMT >= 0" ).append("\n"); 
		query.append("   AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND B.WHF_BND_CD = A.WHF_BND_CD" ).append("\n"); 
		query.append("   AND B.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("   --AND NVL( B.KR_WHF_EXPT_CD, ' ') != 'D'" ).append("\n"); 
		query.append(" GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BL_NO, A.WHF_BND_CD, A.WFG_EXPT_CD ) AA, BKG_KR_WHF_RT BB" ).append("\n"); 
		query.append(" WHERE BB.VSL_CD(+) = AA.VSL_CD" ).append("\n"); 
		query.append("   AND BB.SKD_VOY_NO(+) = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND BB.SKD_DIR_CD(+) = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND BB.WHF_BND_CD(+) = AA.WHF_BND_CD" ).append("\n"); 
		query.append("   AND BB.BL_NO(+) = AA.BL_NO" ).append("\n"); 
		query.append("   AND BB.CHG_RT_SEQ(+) = AA.CHG_RT_SEQ" ).append("\n"); 
		query.append(" GROUP BY DECODE(NVL(TRIM(AA.WFG_EXPT_CD), 'Z'), 'Z', 'N', 'B', 'N', AA.WFG_EXPT_CD)" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(NVL(TRIM(AA.WFG_EXPT_CD), 'Z'), 'Z', 'BN', 'B', 'BN', 'B' || AA.WFG_EXPT_CD)," ).append("\n"); 
		query.append("       SUM(BB.BLK_TEU_QTY + BB.EXPT_TEU_QTY) AS D20, 'dd20' AS DDD20," ).append("\n"); 
		query.append("       SUM(BB.BLK_FEU_QTY + BB.EXPT_FEU_QTY) AS D40, 'dd40' AS DDD40," ).append("\n"); 
		query.append("       SUM(BB.BLK_45FT_QTY + BB.EXPT_45FT_QTY) AS D45, 'dd45' AS DDD45," ).append("\n"); 
		query.append("       SUM(BB.RTON_WGT)" ).append("\n"); 
		query.append("  FROM ( SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BL_NO, A.WHF_BND_CD, A.WFG_EXPT_CD, MAX(CHG_RT_SEQ) CHG_RT_SEQ" ).append("\n"); 
		query.append("  FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND DECODE(@[whf_bnd_cd],'IN',SUBSTR(A.WHF_BND_CD,1,1),'ON',SUBSTR(A.WHF_BND_CD,1,1),A.WHF_BND_CD) = DECODE(@[whf_bnd_cd],'IN','I','ON','O',@[whf_bnd_cd])" ).append("\n"); 
		query.append("   AND DECODE(SUBSTR(@[whf_bnd_cd], 1, 1), 'O', A.WHF_POL_cd, A.WHF_POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("   AND NVL(A.WHF_BL_STS_CD, ' ') != 'D'" ).append("\n"); 
		query.append("   AND A.WHF_AMT >= 0" ).append("\n"); 
		query.append("   AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND B.WHF_BND_CD = A.WHF_BND_CD" ).append("\n"); 
		query.append("   AND B.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("   --AND NVL( B.KR_WHF_EXPT_CD, ' ') != 'D'" ).append("\n"); 
		query.append(" GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BL_NO, A.WHF_BND_CD, A.WFG_EXPT_CD ) AA, BKG_KR_WHF_RT BB" ).append("\n"); 
		query.append(" WHERE BB.VSL_CD(+) = AA.VSL_CD" ).append("\n"); 
		query.append("   AND BB.SKD_VOY_NO(+) = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND BB.SKD_DIR_CD(+) = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND BB.WHF_BND_CD(+) = AA.WHF_BND_CD" ).append("\n"); 
		query.append("   AND BB.BL_NO(+) = AA.BL_NO" ).append("\n"); 
		query.append("   AND BB.CHG_RT_SEQ(+) = AA.CHG_RT_SEQ" ).append("\n"); 
		query.append("   AND BB.KR_CSTMS_FRT_TP_CD = 'BLK'" ).append("\n"); 
		query.append(" GROUP BY DECODE(NVL(TRIM(AA.WFG_EXPT_CD), 'Z'), 'Z', 'BN', 'B', 'BN', 'B' || AA.WFG_EXPT_CD) ) A, ( SELECT 'dd20' AS SORT_VALUE ,'N' AS SORT_KEY FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd40'   ,'N'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd45'   ,'N'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd20'   ,'S'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd40'   ,'S'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd45'   ,'S'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd20'   ,'D'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd40'   ,'D'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd45'   ,'D'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd20'   ,'X'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd40'   ,'X'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd45'   ,'X'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd20'   ,'I'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd40'   ,'I'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd45'   ,'I'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd20'   ,'J'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd40'   ,'J'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd45'   ,'J'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd20'   ,'K'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd40'   ,'K'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'dd45'   ,'K'      FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'BLK'    ,'BS'     FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'BLK'    ,'BD'     FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'BLK'    ,'BX'     FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'BLK'    ,'BI'     FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'BLK'    ,'BJ'     FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'BLK'    ,'BK'     FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 'BLK'    ,'BN'     FROM DUAL ) B" ).append("\n"); 
		query.append("WHERE A.SORT_KEY = B.SORT_KEY" ).append("\n"); 
		query.append("GROUP BY ROWNUM," ).append("\n"); 
		query.append("CASE B.SORT_VALUE WHEN 'dd20' THEN '6'" ).append("\n"); 
		query.append("WHEN 'dd40' THEN '8'" ).append("\n"); 
		query.append("WHEN 'dd45' THEN '9'" ).append("\n"); 
		query.append("ELSE '2'" ).append("\n"); 
		query.append("END ," ).append("\n"); 
		query.append("CASE WHEN A.SORT_KEY IN ('BS', 'S') THEN '6'" ).append("\n"); 
		query.append("WHEN A.SORT_KEY IN ('BD', 'D') THEN '3'" ).append("\n"); 
		query.append("WHEN A.SORT_KEY IN ('BX', 'BI', 'X', 'I') THEN '9'" ).append("\n"); 
		query.append("WHEN A.SORT_KEY IN ('BJ', 'J') THEN '2'" ).append("\n"); 
		query.append("WHEN A.SORT_KEY IN ('BK', 'K') THEN '1'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--WHERE TTL_TON_QTY > 0" ).append("\n"); 

	}
}
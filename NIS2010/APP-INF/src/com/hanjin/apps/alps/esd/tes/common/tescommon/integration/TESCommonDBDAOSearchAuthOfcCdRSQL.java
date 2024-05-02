/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TESCommonDBDAOSearchAuthOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchAuthOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAuthOfcCd
	  * </pre>
	  */
	public TESCommonDBDAOSearchAuthOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("no_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("no_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchAuthOfcCdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("--        act_tp ACT_TP," ).append("\n"); 
		query.append("--        B.OFC_CD," ).append("\n"); 
		query.append("--        B.OFC_TP_CD," ).append("\n"); 
		query.append("--        B.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("--        DECODE(C.CNT_CD,'HQ','KR',C.CNT_CD) CNT_CD," ).append("\n"); 
		query.append("        NVL(" ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("        WHEN B.OFC_TP_CD IN ('HT')" ).append("\n"); 
		query.append("        THEN 'Y'" ).append("\n"); 
		query.append("        WHEN B.OFC_TP_CD IN ('HQ','QT')" ).append("\n"); 
		query.append("        THEN" ).append("\n"); 
		query.append("           (SELECT" ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN COUNT(X.OFC_CD) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                ELSE 'N1' || @[act_tp]" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT OFC_CD" ).append("\n"); 
		query.append("                FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                START WITH OFC_CD = (SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[no_ofc_cd])" ).append("\n"); 
		query.append("                ) X" ).append("\n"); 
		query.append("            WHERE X.OFC_CD = @[cre_ofc_cd])" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN @[act_tp] = 'AGMT' --//LOGIN OFC와 YARD의 Country가 동일한 것에만 권한 부여" ).append("\n"); 
		query.append("            THEN" ).append("\n"); 
		query.append("--               (SELECT --// AS-IS" ).append("\n"); 
		query.append("--                    CASE" ).append("\n"); 
		query.append("--                    WHEN Y.LOC_CD IS NOT NULL" ).append("\n"); 
		query.append("--                    THEN DECODE(SUBSTR(Y.LOC_CD,1,2),DECODE(L.CNT_CD,'HQ','KR',L.CNT_CD),'Y','N2'|| [act_tp])" ).append("\n"); 
		query.append("--                    ELSE 'N2'|| [act_tp]" ).append("\n"); 
		query.append("--                    END" ).append("\n"); 
		query.append("--                FROM MDM_YARD Y, MDM_LOCATION L" ).append("\n"); 
		query.append("--                WHERE Y.LOC_CD = L.LOC_CD(+)" ).append("\n"); 
		query.append("--				AND   Y.OFC_CD =  [cre_ofc_cd]" ).append("\n"); 
		query.append("--				AND   Y.YD_CD = nvl( [no_yd_cd],'') AND NVL(Y.DELT_FLG,'N')='N')--// AGMT CRE OFC            " ).append("\n"); 
		query.append("               (SELECT --// TO-BE" ).append("\n"); 
		query.append("                    CASE" ).append("\n"); 
		query.append("                    WHEN Y.OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("                    THEN 'Y'" ).append("\n"); 
		query.append("					-- Login Office와 Agreement Yard의 Control Office의 'Parent Office' 혹은 'AR Office'가 동일한 경우" ).append("\n"); 
		query.append("                    WHEN (SELECT COUNT(X.OFC_CD) " ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                            SELECT OFC_CD" ).append("\n"); 
		query.append("                            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                            WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                            START WITH OFC_CD = (SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                 FROM MDM_YARD Y , MDM_ORGANIZATION M" ).append("\n"); 
		query.append("                                                 WHERE Y.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("                                                 AND Y.YD_CD = nvl(@[no_yd_cd], '') " ).append("\n"); 
		query.append("                                                 AND NVL(Y.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("                            ) X" ).append("\n"); 
		query.append("                        WHERE X.OFC_CD = @[cre_ofc_cd]) > 0 " ).append("\n"); 
		query.append("                    THEN 'Y' " ).append("\n"); 
		query.append("                    ------------------------------------------------" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                        -- LOGIN OFC와 YARD의 Ctrl OFC가 동일한 경우" ).append("\n"); 
		query.append("                        CASE WHEN Y.LOC_CD IS NOT NULL AND Y.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("                        	THEN DECODE(SUBSTR(Y.LOC_CD, 1, 2), DECODE(C.CNT_CD, 'HQ', 'KR', C.CNT_CD), 'Y', 'N2' || @[act_tp])" ).append("\n"); 
		query.append("							-- 지점이지만 독립점소로 HQ 권한을 가진 OFFICE 포함 (SELBB = SELIB, TYOBB = TYOIB) " ).append("\n"); 
		query.append("							-- CHM-201538996 블라디보스톡 대리점가상 RHQ신설 관련 TES 하드코딩 요청건 (VVOBA = VVOIA)" ).append("\n"); 
		query.append("                        	ELSE CASE WHEN (SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = Y.OFC_CD) IN (SUBSTR(@[cre_ofc_cd], 1, 3) || 'IB', SUBSTR(@[cre_ofc_cd], 1, 3) || 'IA')" ).append("\n"); 
		query.append("								  THEN 'Y'" ).append("\n"); 
		query.append("								  ELSE 'N2' || @[act_tp]" ).append("\n"); 
		query.append("								  END" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                FROM MDM_YARD Y " ).append("\n"); 
		query.append("                WHERE Y.YD_CD = nvl(@[no_yd_cd], '') AND NVL(Y.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("--               (SELECT --// 2014-02까지" ).append("\n"); 
		query.append("--                    CASE" ).append("\n"); 
		query.append("--                    WHEN Y.LOC_CD IS NOT NULL" ).append("\n"); 
		query.append("--                    THEN DECODE(SUBSTR(Y.LOC_CD,1,2),DECODE(C.CNT_CD,'HQ','KR',C.CNT_CD),'Y','N2'|| [act_tp])" ).append("\n"); 
		query.append("--                    ELSE 'N2'|| [act_tp]" ).append("\n"); 
		query.append("--                    END" ).append("\n"); 
		query.append("--                FROM MDM_YARD Y" ).append("\n"); 
		query.append("--                WHERE Y.YD_CD = nvl([no_yd_cd],'') AND NVL(Y.DELT_FLG,'N')='N')-- no_ofc_cd == AGMT CRE OFC (AGMT HDR GRID에서 추출)" ).append("\n"); 
		query.append("            WHEN @[act_tp] = 'INV'  --//LOGIN OFC와 하위 OFC에 권한 부여" ).append("\n"); 
		query.append("            THEN" ).append("\n"); 
		query.append("               (SELECT" ).append("\n"); 
		query.append("                    CASE" ).append("\n"); 
		query.append("                    WHEN COUNT(X.OFC_CD) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N2' || @[act_tp]" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT OFC_CD" ).append("\n"); 
		query.append("                    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                    WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                    START WITH OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("                    ) X" ).append("\n"); 
		query.append("                WHERE X.OFC_CD = @[no_ofc_cd]) --AGMT CRE OFC (AGMT HDR GRID에서 추출)" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        END, 'X') AUTH_OFCS" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION B," ).append("\n"); 
		query.append("     (SELECT C.LOC_CD, C.CNT_CD FROM MDM_LOCATION C WHERE NVL(C.DELT_FLG,'N') <> 'Y') C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.OFC_CD = @[cre_ofc_cd] --LOGIN OFC" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND B.LOC_CD = C.LOC_CD(+)" ).append("\n"); 

	}
}
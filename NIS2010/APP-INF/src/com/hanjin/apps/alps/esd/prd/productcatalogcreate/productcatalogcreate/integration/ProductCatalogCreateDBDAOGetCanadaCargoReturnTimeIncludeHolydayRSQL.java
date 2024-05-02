/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeIncludeHolydayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeIncludeHolydayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail cut off time 산출시 12월 25일, 1월 1일이 포함되어 있는지 여부를 확인하여 계산에서 제외할지 여부를 조회한다
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeIncludeHolydayRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeIncludeHolydayRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("MAX(CASE WHEN HL.HL_DY BETWEEN POL_ETA-ARR_DT AND POL_ETA THEN 1" ).append("\n"); 
		query.append("     ELSE 0 END) AS INC_HLYDY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    A1.*" ).append("\n"); 
		query.append(", DECODE(UPPER(POL_ETA_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                        'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                        'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                        'SAT',ARR_SAT_DYS) ARR_DT                                    " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT (SELECT CASE WHEN SUBSTR(PRDM.POL_CD,1,2)='US' THEN TRUNC(COALESCE(MIN(VPS_ETB_DT),MIN(VPS_ETA_DT),MIN(PF_ETA_DT)))" ).append("\n"); 
		query.append("                     ELSE TRUNC(COALESCE(MIN(VPS_ETA_DT),MIN(PF_ETA_DT)))" ).append("\n"); 
		query.append("                     END " ).append("\n"); 
		query.append("         FROM PRD_PROD_CTL_ROUT_DTL E, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("         WHERE E.PCTL_NO = PRDM.PCTL_NO" ).append("\n"); 
		query.append("         AND E.ORG_NOD_CD LIKE PRDM.POL_CD||'%'" ).append("\n"); 
		query.append("         AND E.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("         AND E.TRSP_MOD_CD = 'VD'" ).append("\n"); 
		query.append("         AND E.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("         AND E.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND E.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND E.ORG_NOD_CD = V.YD_CD" ).append("\n"); 
		query.append("         AND NVL(V.PORT_SKD_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("         ) POL_ETA" ).append("\n"); 
		query.append("         ,TO_CHAR((SELECT CASE WHEN SUBSTR(PRDM.POL_CD,1,2)='US' THEN TRUNC(COALESCE(MIN(VPS_ETB_DT),MIN(VPS_ETA_DT),MIN(PF_ETA_DT)))" ).append("\n"); 
		query.append("                     ELSE TRUNC(COALESCE(MIN(VPS_ETA_DT),MIN(PF_ETA_DT)))" ).append("\n"); 
		query.append("                     END " ).append("\n"); 
		query.append("         FROM PRD_PROD_CTL_ROUT_DTL E, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("         WHERE E.PCTL_NO = PRDM.PCTL_NO" ).append("\n"); 
		query.append("         AND E.ORG_NOD_CD LIKE PRDM.POL_CD||'%'" ).append("\n"); 
		query.append("         AND E.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("         AND E.TRSP_MOD_CD = 'VD' -- 미주는 FEEDER 없음" ).append("\n"); 
		query.append("         AND E.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("         AND E.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND E.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND E.ORG_NOD_CD = V.YD_CD" ).append("\n"); 
		query.append("         AND NVL(V.PORT_SKD_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("         ),'DY','NLS_DATE_LANGUAGE=ENGLISH') POL_ETA_DAY" ).append("\n"); 
		query.append("         ,CCTM.*" ).append("\n"); 
		query.append("         ------------------------------por node add" ).append("\n"); 
		query.append("         ,RANK() OVER(PARTITION BY PRDM.POL_NOD_CD ORDER BY DECODE(PRDM.POL_NOD_CD ,CCTM.POL_NOD_CD, 1, 2) ," ).append("\n"); 
		query.append("                                                          DECODE((" ).append("\n"); 
		query.append("                                                                    SELECT ORG_NOD_CD" ).append("\n"); 
		query.append("                                                                    FROM PRD_PROD_CTL_ROUT_DTL D " ).append("\n"); 
		query.append("                                                                    WHERE D.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                                                                    AND D.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("                                                                    AND D.TRSP_MOD_CD = 'RD' " ).append("\n"); 
		query.append("                                                                    AND ROWNUM = 1 " ).append("\n"); 
		query.append("                                                                   ) ,CCTM.POR_NOD_CD, 1, 2) )  rn" ).append("\n"); 
		query.append("    FROM PRD_PROD_CTL_MST PRDM, PRD_CND_TML_CCT_MGMT CCTM " ).append("\n"); 
		query.append("    WHERE CCTM.POR_CD = (" ).append("\n"); 
		query.append("                            SELECT SUBSTR(ORG_NOD_CD,1,5) " ).append("\n"); 
		query.append("                            FROM PRD_PROD_CTL_ROUT_DTL D " ).append("\n"); 
		query.append("                            WHERE D.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                            AND D.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("                            AND D.TRSP_MOD_CD = 'RD' " ).append("\n"); 
		query.append("                            AND ROWNUM = 1 " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("    ------------------------------por node add" ).append("\n"); 
		query.append("    AND CCTM.POR_NOD_CD = DECODE( CCTM.POR_NOD_CD, ' ', CCTM.POR_NOD_CD," ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                    SELECT ORG_NOD_CD" ).append("\n"); 
		query.append("                                    FROM PRD_PROD_CTL_ROUT_DTL D " ).append("\n"); 
		query.append("                                    WHERE D.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                                    AND D.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("                                    AND D.TRSP_MOD_CD = 'RD' " ).append("\n"); 
		query.append("                                    AND ROWNUM = 1 " ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("    AND DECODE(LENGTH(CCTM.POL_NOD_CD),5,PRDM.POL_CD ,PRDM.POL_NOD_CD  )  = CCTM.POL_NOD_CD -- JSY , POL 이 5또는 7자리로 변경, 컬럼명 변경" ).append("\n"); 
		query.append("    AND PRDM.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A1" ).append("\n"); 
		query.append("WHERE RN=1" ).append("\n"); 
		query.append(") CON" ).append("\n"); 
		query.append(", ( ---- 현재 시점으로부터 -2년 + 1년간을 검사할 수 있도록 DUMMY DATA 생성" ).append("\n"); 
		query.append("SELECT TO_DATE(Y.YR||D.DY, 'YYYYMMDD') HL_DY  FROM" ).append("\n"); 
		query.append("  (SELECT EXTRACT(YEAR FROM SYSDATE)-2 YR FROM DUAL UNION" ).append("\n"); 
		query.append("   SELECT EXTRACT(YEAR FROM SYSDATE)-1 YR FROM DUAL UNION" ).append("\n"); 
		query.append("   SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL UNION" ).append("\n"); 
		query.append("   SELECT EXTRACT(YEAR FROM SYSDATE)+1 FROM DUAL) Y" ).append("\n"); 
		query.append(", (SELECT '1225' DY FROM DUAL UNION" ).append("\n"); 
		query.append("   SELECT '0101' FROM DUAL) D" ).append("\n"); 
		query.append(") HL" ).append("\n"); 

	}
}
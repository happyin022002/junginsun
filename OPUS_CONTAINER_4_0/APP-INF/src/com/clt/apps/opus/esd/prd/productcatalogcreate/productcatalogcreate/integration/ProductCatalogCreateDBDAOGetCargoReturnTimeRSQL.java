/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOGetCargoReturnTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOGetCargoReturnTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Export Cargo Available Return Time 개발
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOGetCargoReturnTimeRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOGetCargoReturnTimeRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR((CASE" ).append("\n"); 
		query.append("         WHEN FULL_RTN_YD_CD IS NOT NULL AND HUB_NOD_CD IS NOT NULL AND FULL_RTN_YD_CD = HUB_NOD_CD THEN" ).append("\n"); 
		query.append("          NVL(PRD_GET_INLND_CCT_FNC(PCTL_NO), TRUNC(POL_ETA - (SUM_HRS - LAST_DWELL + START_DWELL) / 24))" ).append("\n"); 
		query.append("         WHEN FULL_RTN_YD_CD IS NOT NULL AND HUB_NOD_CD IS NOT NULL AND FULL_RTN_YD_CD <> HUB_NOD_CD THEN" ).append("\n"); 
		query.append("          NVL(PRD_GET_INLND_CCT_FNC(PCTL_NO) - ((TT + 6) / 24), (TRUNC(POL_ETA - (SUM_HRS - LAST_DWELL + START_DWELL) / 24)))" ).append("\n"); 
		query.append("       END), 'YYYYMMDD') CUT_OFF" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("       ----Rail Receiving to date " ).append("\n"); 
		query.append("       ----- full retrun cy 와 같은 경우 : Inland cct date" ).append("\n"); 
		query.append("       ----- full return cy 와 다른 경우 : full return cy dwell ( 6시간) + full return에서 rail ramp 까지 transit time" ).append("\n"); 
		query.append(" --     , (CASE" ).append("\n"); 
		query.append(" --        WHEN FULL_RTN_YD_CD IS NOT NULL AND HUB_NOD_CD IS NOT NULL AND FULL_RTN_YD_CD = HUB_NOD_CD THEN" ).append("\n"); 
		query.append(" --         NVL(PRD_GET_INLND_CCT_FNC(PCTL_NO), TRUNC(POL_ETA - (SUM_HRS - LAST_DWELL + START_DWELL) / 24))" ).append("\n"); 
		query.append(" --        WHEN FULL_RTN_YD_CD IS NOT NULL AND HUB_NOD_CD IS NOT NULL AND FULL_RTN_YD_CD <> HUB_NOD_CD THEN" ).append("\n"); 
		query.append(" --         NVL(PRD_GET_INLND_CCT_FNC(PCTL_NO)- ((TT + 6) / 24), (TRUNC(POL_ETA - (SUM_HRS - LAST_DWELL + START_DWELL) / 24)) )" ).append("\n"); 
		query.append(" --      END) - NVL('', 3) RTN_TIME" ).append("\n"); 
		query.append("----Rail receiving from date " ).append("\n"); 
		query.append("----- Rail Receiving to date - dem free date ( 없으면 default 3일)" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT M.PCTL_NO" ).append("\n"); 
		query.append("               ,M.POL_CD" ).append("\n"); 
		query.append("               ,IM.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("               ,IM.HUB_NOD_CD" ).append("\n"); 
		query.append("               ,NVL((SELECT 'Y' FROM PRD_PROD_CTL_QTY Q WHERE Q.PCTL_NO = M.PCTL_NO AND Q.CNTR_TPSZ_CD LIKE 'R%' AND ROWNUM = 1) ,'N') RF_FLG" ).append("\n"); 
		query.append("               ,(SELECT MIN(TRUNC(VPS_ETA_DT)) - 1 --ETA 날짜는 제외하고, 그 전날을 기준으로 산출" ).append("\n"); 
		query.append("                   FROM PRD_PROD_CTL_ROUT_DTL E, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                  WHERE E.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                    AND E.ORG_NOD_CD LIKE M.POL_CD || '%'" ).append("\n"); 
		query.append("                    AND E.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("                    AND E.TRSP_MOD_CD = 'VD' -- 미주는 Feeder 없음" ).append("\n"); 
		query.append("                    AND E.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                    AND E.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND E.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND E.ORG_NOD_CD = V.YD_CD" ).append("\n"); 
		query.append("                    AND NVL(V.PORT_SKD_STS_CD, 'X') <> 'S') POL_ETA" ).append("\n"); 
		query.append("               ,MAX((CASE" ).append("\n"); 
		query.append("                      WHEN D.PCTL_SEQ = (SELECT MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("                                           FROM PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("                                          WHERE D2.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                            AND D2.TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("                                            AND D2.PCTL_NO = M.PCTL_NO) THEN" ).append("\n"); 
		query.append("                       (SELECT DECODE(NVL(M.PRM_CUST_FLG, 'N')" ).append("\n"); 
		query.append("                                     ,'Y'" ).append("\n"); 
		query.append("                                     ,DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                                              WHERE Q.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                                                AND Q.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                            ,'Y'" ).append("\n"); 
		query.append("                                            ,NVL(RF_MIN_DWLL_HRS, 24)" ).append("\n"); 
		query.append("                                            ,NVL(DRY_MIN_DWLL_HRS, 24))" ).append("\n"); 
		query.append("                                     ,DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                                              WHERE Q.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                                                AND Q.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                            ,'Y'" ).append("\n"); 
		query.append("                                            ,NVL(RF_AVG_DWLL_HRS, 24)" ).append("\n"); 
		query.append("                                            ,NVL(DRY_AVG_DWLL_HRS, 24)))" ).append("\n"); 
		query.append("                          FROM MDM_YARD" ).append("\n"); 
		query.append("                         WHERE YD_CD = D.ORG_NOD_CD)" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                       0" ).append("\n"); 
		query.append("                    END)) * 0.5 START_DWELL" ).append("\n"); 
		query.append("               , --RD 시작 Node의 D.well Time의 1/2" ).append("\n"); 
		query.append("                --//       포함 되어 있는 Rail Ramp Dwell Range 만큼 조기 반입 결과 초래 ,Inland Rail Ramp Dwell 의 1/2 값 반영" ).append("\n"); 
		query.append("                MAX((CASE" ).append("\n"); 
		query.append("                      WHEN D.PCTL_SEQ = (SELECT max(PCTL_SEQ)" ).append("\n"); 
		query.append("                                           FROM PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("                                          WHERE D2.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                            AND D2.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("                                            AND D2.PCTL_NO = M.PCTL_NO) AND D.TRSP_MOD_CD = 'TD' THEN" ).append("\n"); 
		query.append("                       (SELECT DECODE(NVL(M.PRM_CUST_FLG, 'N')" ).append("\n"); 
		query.append("                                     ,'Y'" ).append("\n"); 
		query.append("                                     ,DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                                              WHERE Q.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                                                AND Q.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                            ,'Y'" ).append("\n"); 
		query.append("                                            ,NVL(RF_MIN_DWLL_HRS, 24)" ).append("\n"); 
		query.append("                                            ,NVL(DRY_MIN_DWLL_HRS, 24))" ).append("\n"); 
		query.append("                                     ,DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                                              WHERE Q.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                                                AND Q.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                            ,'Y'" ).append("\n"); 
		query.append("                                            ,NVL(RF_AVG_DWLL_HRS, 24)" ).append("\n"); 
		query.append("                                            ,NVL(DRY_AVG_DWLL_HRS, 24)))" ).append("\n"); 
		query.append("                          FROM MDM_YARD" ).append("\n"); 
		query.append("                         WHERE YD_CD = D.ORG_NOD_CD)" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                       0" ).append("\n"); 
		query.append("                    END)) LAST_DWELL" ).append("\n"); 
		query.append("               , --마지막 구간이 TD이면, 그 구간 시작 Node의 D.well Time : 마지막 구간이 TD일때만 적용" ).append("\n"); 
		query.append("                SUM((CASE" ).append("\n"); 
		query.append("                      WHEN D.NOD_LNK_DIV_CD = 'N' THEN" ).append("\n"); 
		query.append("                       (SELECT DECODE(NVL(M.PRM_CUST_FLG, 'N')" ).append("\n"); 
		query.append("                                     ,'Y'" ).append("\n"); 
		query.append("                                     ,DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                                              WHERE Q.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                                                AND Q.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                            ,'Y'" ).append("\n"); 
		query.append("                                            ,NVL(RF_MIN_DWLL_HRS, 24)" ).append("\n"); 
		query.append("                                            ,NVL(DRY_MIN_DWLL_HRS, 24))" ).append("\n"); 
		query.append("                                     ,DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                                              WHERE Q.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                                                AND Q.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                            ,'Y'" ).append("\n"); 
		query.append("                                            ,NVL(RF_AVG_DWLL_HRS, 24)" ).append("\n"); 
		query.append("                                            ,NVL(DRY_AVG_DWLL_HRS, 24)))" ).append("\n"); 
		query.append("                          FROM MDM_YARD" ).append("\n"); 
		query.append("                         WHERE YD_CD = D.ORG_NOD_CD)" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                       TZ_DWLL_TM_HRS" ).append("\n"); 
		query.append("                    END)) SUM_HRS" ).append("\n"); 
		query.append("               , --RD 시작 Node의 ~ Hub Node까지의 T.Time + Hub Node의 D.well Time + Hub Node ~ POL 까지의 T.Time" ).append("\n"); 
		query.append("                MAX((SELECT L.TZTM_HRS" ).append("\n"); 
		query.append("                      FROM PRD_INLND_EACH_LNK L" ).append("\n"); 
		query.append("                     WHERE L.LNK_ORG_NOD_CD = IM.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                       AND L.LNK_DEST_NOD_CD = IM.HUB_NOD_CD" ).append("\n"); 
		query.append("                       AND L.TRSP_MOD_CD = 'TD'" ).append("\n"); 
		query.append("                       AND IM.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                       AND IM.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                       AND IM.ROUT_SEQ = D.ROUT_SEQ)) TT" ).append("\n"); 
		query.append("          FROM PRD_PROD_CTL_ROUT_DTL D, PRD_PROD_CTL_MST M, PRD_INLND_ROUT_MST IM" ).append("\n"); 
		query.append("         WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("           AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("           AND IM.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND IM.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND IM.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("           AND D.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("           AND (M.POL_CD LIKE 'US%' OR M.POL_CD LIKE 'CA%')" ).append("\n"); 
		query.append("           AND D.PCTL_SEQ BETWEEN (SELECT MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL D2 WHERE D2.PCTL_IO_BND_CD = 'O' AND D2.TRSP_MOD_CD = 'RD' AND D2.PCTL_NO = M.PCTL_NO)" ).append("\n"); 
		query.append("           AND (SELECT MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL D2 WHERE D2.PCTL_IO_BND_CD = 'O' AND D2.NOD_LNK_DIV_CD = 'L' AND D2.PCTL_NO = M.PCTL_NO)" ).append("\n"); 
		query.append("         GROUP BY M.PCTL_NO, M.POL_CD, IM.FULL_RTN_YD_CD, IM.HUB_NOD_CD        " ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}
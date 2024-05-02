/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOGetCargoReturnTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.13 
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

public class ProductCatalogCreateDBDAOGetCargoReturnTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Export Cargo Available Return Time 개발
	  * [[[ 하기는 계산 수식입니다. ]]]
	  * VVD ETA(시간만 버림) 
	  * – ROUND((RD 시작 Node의 D.well Time의 1/2 +  RD 시작 Node의 ~ Hub Node까지의 T.Time + Hub Node의 D.well Time + Hub Node ~ POL 까지의 T.Time) 
	  *              - (마지막 구간이 TD이면, 그 구간 시작 Node의 D.well Time : 마지막 구간이 TD일때만 적용),0) 
	  * - 1 day(Buffer Time) 입니다
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
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
		query.append("SELECT   TO_CHAR(POL_ETA - ROUND((SUM_HRS - LAST_DWELL + START_DWELL)/24), 'YYYYMMDD') RTN_TIME, -- RTN_TIME계산 기준일자" ).append("\n"); 
		query.append("         --TO_CHAR(POL_ETA - ROUND((SUM_HRS - LAST_DWELL + START_DWELL)/24) - 1, 'YYYYMMDD') RTN_TIME, -- 계산된 DWELL은 반올림 ROUND 처리한다." ).append("\n"); 
		query.append("	     TO_CHAR(TRUNC(CCT) - ROUND((SUM_HRS - LAST_DWELL + START_DWELL)/24) , 'YYYYMMDD') CUT_OFF -- to-be 요건 (buffer day 빠짐.)" ).append("\n"); 
		query.append("	     ,TO_CHAR(TRUNC(CCT) - ROUND((SUM_HRS - LAST_DWELL + START_DWELL)/24)   " ).append("\n"); 
		query.append("        	      - (SELECT RCV_ITVAL_DYS" ).append("\n"); 
		query.append("                          FROM PRD_USA_CCT_ITVAL_MGMT CCTI" ).append("\n"); 
		query.append("                         WHERE LTST_RCV_DY_CD = TO_CHAR(TRUNC(CCT) - ROUND((SUM_HRS - LAST_DWELL + START_DWELL)/24),'DY','NLS_DATE_LANGUAGE=ENGLISH')  )" ).append("\n"); 
		query.append("                   ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	      ERD " ).append("\n"); 
		query.append("	     ,TO_CHAR(TRUNC(CCT) - ROUND((SUM_HRS - LAST_DWELL + START_DWELL)/24),'DY','NLS_DATE_LANGUAGE=ENGLISH') LRD_DY" ).append("\n"); 
		query.append("	     ,(SELECT RCV_ITVAL_DYS" ).append("\n"); 
		query.append("                  FROM PRD_USA_CCT_ITVAL_MGMT CCTI" ).append("\n"); 
		query.append("                 WHERE LTST_RCV_DY_CD = TO_CHAR(TRUNC(CCT) - ROUND((SUM_HRS - LAST_DWELL + START_DWELL)/24),'DY','NLS_DATE_LANGUAGE=ENGLISH')  ) RCV_ITVAL_DYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("(   " ).append("\n"); 
		query.append("    SELECT   " ).append("\n"); 
		query.append("    M.PCTL_NO,   " ).append("\n"); 
		query.append("    M.POL_CD,   " ).append("\n"); 
		query.append("    NVL((SELECT 'Y'   " ).append("\n"); 
		query.append("         FROM PRD_PROD_CTL_QTY Q   " ).append("\n"); 
		query.append("         WHERE Q.PCTL_NO = M.PCTL_NO   " ).append("\n"); 
		query.append("           AND Q.CNTR_TPSZ_CD LIKE 'R%'   " ).append("\n"); 
		query.append("           AND ROWNUM =1),'N') RF_FLG, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT DISTINCT TO_DATE(TO_CHAR(PRD_GET_CCT_FNC(PRDD.ORG_NOD_CD,PRDD.VSL_SLAN_CD,PRDD.SKD_DIR_CD,DECODE(PRDM.RF_SPCL_FLG,'Y','RF',DECODE(DG_SPCL_FLG,'Y','DG','DR'))," ).append("\n"); 
		query.append("                                                        NVL(VSLS.VPS_ETB_DT,PRDD.ARR_ST_DT),NVL(VSLS.VPS_ETD_DT,PRDD.ARR_ST_DT),  PRDD.VSL_CD||PRDD.SKD_VOY_NO||PRDD.SKD_DIR_CD)," ).append("\n"); 
		query.append("                                        'YYYY/mm/dd HH24:MI')," ).append("\n"); 
		query.append("                                'YYYY/mm/dd HH24:MI') CCT" ).append("\n"); 
		query.append("          FROM PRD_PROD_CTL_MST PRDM,PRD_PROD_CTL_ROUT_DTL PRDD,VSK_VSL_PORT_SKD VSLS" ).append("\n"); 
		query.append("         WHERE PRDM.PCTL_NO = M.PCTL_NO --'B120608031019252'" ).append("\n"); 
		query.append("    	   AND PRDM.PCTL_NO = PRDD.PCTL_NO" ).append("\n"); 
		query.append("    	   AND PRDD.PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("    	   AND PRDD.TRSP_MOD_CD IN ('WD','VD')" ).append("\n"); 
		query.append("    	   AND SUBSTR(PRDD.ORG_NOD_CD,1,5) = PRDM.POL_CD" ).append("\n"); 
		query.append("    	   AND VSLS.VSL_CD(+) = PRDD.VSL_CD" ).append("\n"); 
		query.append("    	   AND VSLS.SKD_VOY_NO(+) = PRDD.SKD_VOY_NO" ).append("\n"); 
		query.append("    	   AND VSLS.SKD_DIR_CD(+) = PRDD.SKD_DIR_CD" ).append("\n"); 
		query.append("    	   AND VSLS.CLPT_IND_SEQ(+) = PRDD.ORG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    	   AND VSLS.YD_CD(+) = PRDD.ORG_NOD_CD	" ).append("\n"); 
		query.append("    ) CCT,     " ).append("\n"); 
		query.append("    (SELECT MIN(TRUNC(NVL(PF_ETA_DT,VPS_ETA_DT))) --ETA 날짜는 제외하고, 그 전날을 기준으로 산출 (전날은 하루로 포함되어야 하므로, ETA에서 TRIM만 처리한다) -- 20120308" ).append("\n"); 
		query.append("     FROM PRD_PROD_CTL_ROUT_DTL E, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("     WHERE E.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("     AND E.ORG_NOD_CD LIKE M.POL_CD||'%'" ).append("\n"); 
		query.append("     AND E.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("     AND E.TRSP_MOD_CD = 'VD' -- 미주는 Feeder 없음" ).append("\n"); 
		query.append("     AND E.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("     AND E.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND E.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND E.ORG_NOD_CD = V.YD_CD" ).append("\n"); 
		query.append("     AND E.ORG_CLPT_IND_SEQ = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     AND NVL(V.PORT_SKD_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("     ) POL_ETA,  " ).append("\n"); 
		query.append("    MAX((CASE WHEN D.PCTL_SEQ = (SELECT MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL D2   " ).append("\n"); 
		query.append("                                  WHERE D2.PCTL_IO_BND_CD = 'O'   " ).append("\n"); 
		query.append("                                  AND D2.TRSP_MOD_CD ='RD'   " ).append("\n"); 
		query.append("                                  AND D2.PCTL_NO = M.PCTL_NO)   " ).append("\n"); 
		query.append("              THEN (  SELECT DECODE(NVL(M.PRM_CUST_FLG, 'N'), 'Y',   " ).append("\n"); 
		query.append("                                    DECODE(   (SELECT 'Y'   " ).append("\n"); 
		query.append("                                               FROM PRD_PROD_CTL_QTY Q   " ).append("\n"); 
		query.append("                                               WHERE Q.PCTL_NO = M.PCTL_NO   " ).append("\n"); 
		query.append("                                                 AND Q.CNTR_TPSZ_CD LIKE 'R%'   " ).append("\n"); 
		query.append("                                                 AND ROWNUM =1),    'Y', NVL(OB_RF_MIN_DWLL_HRS, 24), NVL(OB_DRY_MIN_DWLL_HRS, 24)),   " ).append("\n"); 
		query.append("                                      DECODE(   (SELECT 'Y'   " ).append("\n"); 
		query.append("                                                 FROM PRD_PROD_CTL_QTY Q   " ).append("\n"); 
		query.append("                                                 WHERE Q.PCTL_NO = M.PCTL_NO   " ).append("\n"); 
		query.append("                                                   AND Q.CNTR_TPSZ_CD LIKE 'R%'   " ).append("\n"); 
		query.append("                                                   AND ROWNUM =1),  'Y', NVL(OB_RF_AVG_DWLL_HRS, 24), NVL(OB_DRY_AVG_DWLL_HRS, 24)))   " ).append("\n"); 
		query.append("                        FROM MDM_YARD   " ).append("\n"); 
		query.append("                       WHERE YD_CD = D.ORG_NOD_CD                             )   " ).append("\n"); 
		query.append("              ELSE 0   " ).append("\n"); 
		query.append("         END))* 0.5 START_DWELL,   --RD 시작 Node의 D.well Time의 1/2" ).append("\n"); 
		query.append("        														  --//	포함 되어 있는 Rail Ramp Dwell Range 만큼 조기 반입 결과 초래 ,Inland Rail Ramp Dwell 의 1/2 값 반영" ).append("\n"); 
		query.append("    MAX((CASE WHEN D.PCTL_SEQ = (SELECT max(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL D2   " ).append("\n"); 
		query.append("                                  WHERE D2.PCTL_IO_BND_CD = 'O'   " ).append("\n"); 
		query.append("                                    AND D2.NOD_LNK_DIV_CD = 'L'   " ).append("\n"); 
		query.append("                                    AND D2.PCTL_NO = M.PCTL_NO   " ).append("\n"); 
		query.append("                                  )   " ).append("\n"); 
		query.append("               AND D.TRSP_MOD_CD ='TD'   " ).append("\n"); 
		query.append("              THEN (  SELECT DECODE(NVL(M.PRM_CUST_FLG, 'N'), 'Y',   " ).append("\n"); 
		query.append("                                    DECODE(   (SELECT 'Y'   " ).append("\n"); 
		query.append("                                               FROM PRD_PROD_CTL_QTY Q   " ).append("\n"); 
		query.append("                                               WHERE Q.PCTL_NO = M.PCTL_NO   " ).append("\n"); 
		query.append("                                                 AND Q.CNTR_TPSZ_CD LIKE 'R%'   " ).append("\n"); 
		query.append("                                                 AND ROWNUM =1),    'Y', NVL(OB_RF_MIN_DWLL_HRS, 24), NVL(OB_DRY_MIN_DWLL_HRS, 24)),   " ).append("\n"); 
		query.append("                                      DECODE(   (SELECT 'Y'   " ).append("\n"); 
		query.append("                                                 FROM PRD_PROD_CTL_QTY Q   " ).append("\n"); 
		query.append("                                                 WHERE Q.PCTL_NO = M.PCTL_NO   " ).append("\n"); 
		query.append("                                                   AND Q.CNTR_TPSZ_CD LIKE 'R%'   " ).append("\n"); 
		query.append("                                                   AND ROWNUM =1),  'Y', NVL(OB_RF_AVG_DWLL_HRS, 24), NVL(OB_DRY_AVG_DWLL_HRS, 24)))   " ).append("\n"); 
		query.append("                        FROM MDM_YARD   " ).append("\n"); 
		query.append("                       WHERE YD_CD = D.ORG_NOD_CD )   " ).append("\n"); 
		query.append("              ELSE 0   " ).append("\n"); 
		query.append("       END)) LAST_DWELL,   --마지막 구간이 TD이면, 그 구간 시작 Node의 D.well Time : 마지막 구간이 TD일때만 적용" ).append("\n"); 
		query.append("    SUM (   " ).append("\n"); 
		query.append("        (CASE WHEN D.NOD_LNK_DIV_CD = 'N'   " ).append("\n"); 
		query.append("              THEN  (   " ).append("\n"); 
		query.append("                    SELECT DECODE(NVL(M.PRM_CUST_FLG, 'N'), 'Y',   " ).append("\n"); 
		query.append("                            DECODE(   (SELECT 'Y'   " ).append("\n"); 
		query.append("                                       FROM PRD_PROD_CTL_QTY Q   " ).append("\n"); 
		query.append("                                       WHERE Q.PCTL_NO = M.PCTL_NO   " ).append("\n"); 
		query.append("                                         AND Q.CNTR_TPSZ_CD LIKE 'R%'   " ).append("\n"); 
		query.append("                                         AND ROWNUM =1),    'Y', NVL(OB_RF_MIN_DWLL_HRS, 24), NVL(OB_DRY_MIN_DWLL_HRS, 24)),   " ).append("\n"); 
		query.append("                              DECODE(   (SELECT 'Y'   " ).append("\n"); 
		query.append("                                         FROM PRD_PROD_CTL_QTY Q   " ).append("\n"); 
		query.append("                                         WHERE Q.PCTL_NO = M.PCTL_NO   " ).append("\n"); 
		query.append("                                           AND Q.CNTR_TPSZ_CD LIKE 'R%'   " ).append("\n"); 
		query.append("                                           AND ROWNUM =1),  'Y', NVL(OB_RF_AVG_DWLL_HRS, 24), NVL(OB_DRY_AVG_DWLL_HRS, 24)))   " ).append("\n"); 
		query.append("                    FROM MDM_YARD   " ).append("\n"); 
		query.append("                    WHERE YD_CD = D.ORG_NOD_CD )   " ).append("\n"); 
		query.append("              ELSE TZ_DWLL_TM_HRS   " ).append("\n"); 
		query.append("          END)   " ).append("\n"); 
		query.append("    ) SUM_HRS   --RD 시작 Node의 ~ Hub Node까지의 T.Time + Hub Node의 D.well Time + Hub Node ~ POL 까지의 T.Time" ).append("\n"); 
		query.append("    FROM PRD_PROD_CTL_ROUT_DTL D, PRD_PROD_CTL_MST M   " ).append("\n"); 
		query.append("    WHERE M.PCTL_NO = @[pctl_no]   " ).append("\n"); 
		query.append("      AND M.PCTL_NO = D.PCTL_NO   " ).append("\n"); 
		query.append("      AND D.PCTL_IO_BND_CD ='O'   " ).append("\n"); 
		query.append("      AND ( M.POL_CD LIKE 'US%'   " ).append("\n"); 
		query.append("         OR M.POL_CD LIKE 'CA%' )   " ).append("\n"); 
		query.append("      AND D.PCTL_SEQ BETWEEN   " ).append("\n"); 
		query.append("                     (SELECT MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL D2   " ).append("\n"); 
		query.append("                      WHERE D2.PCTL_IO_BND_CD = 'O'   " ).append("\n"); 
		query.append("                      AND D2.TRSP_MOD_CD ='RD'   " ).append("\n"); 
		query.append("                      AND D2.PCTL_NO = M.PCTL_NO)   " ).append("\n"); 
		query.append("                     AND   " ).append("\n"); 
		query.append("                     (SELECT MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL D2   " ).append("\n"); 
		query.append("                      WHERE D2.PCTL_IO_BND_CD = 'O'   " ).append("\n"); 
		query.append("                      AND D2.NOD_LNK_DIV_CD = 'L'   " ).append("\n"); 
		query.append("                      AND D2.PCTL_NO = M.PCTL_NO)   " ).append("\n"); 
		query.append("    GROUP BY M.PCTL_NO,M.POL_CD   " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
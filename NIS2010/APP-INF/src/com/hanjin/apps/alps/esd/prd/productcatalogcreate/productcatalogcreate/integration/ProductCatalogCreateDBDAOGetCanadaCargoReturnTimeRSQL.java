/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.13 
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

public class ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeRSQL
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("holyday",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("    DECODE(UPPER(POL_ETA_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                              'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                              'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                              'SAT',ARR_SAT_DYS) LRD_DT" ).append("\n"); 
		query.append("    ,(CASE WHEN POL_NOD_CD LIKE 'US%'    --US일 경우 ETA 대신 CCT FNC 추가                  " ).append("\n"); 
		query.append("           THEN TO_CHAR(US_CCT - TO_NUMBER(@[holyday]) - DECODE(UPPER(US_CCT_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                     'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                     'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                     'SAT',ARR_SAT_DYS),'YYYYMMDD')||NVL(CCT_HRMNT,'0000')   -- US LRD" ).append("\n"); 
		query.append("           ELSE TO_CHAR(POL_ETA - TO_NUMBER(@[holyday]) - DECODE(UPPER(POL_ETA_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                     'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                     'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                     'SAT',ARR_SAT_DYS),'YYYYMMDD')||NVL(CCT_HRMNT,'0000')  --CA LRD" ).append("\n"); 
		query.append("      END) CUT_OFF   --LRD" ).append("\n"); 
		query.append("    ,(CASE WHEN POL_NOD_CD LIKE 'US%'    --US일 경우 ETA 대신 CCT FNC 추가                  " ).append("\n"); 
		query.append("           THEN TO_CHAR(US_CCT - TO_NUMBER(@[holyday]) - DECODE(UPPER(US_CCT_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                         'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                         'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                         'SAT',ARR_SAT_DYS),'DY','NLS_DATE_LANGUAGE=ENGLISH')   -- US LRD" ).append("\n"); 
		query.append("           ELSE TO_CHAR(POL_ETA - TO_NUMBER(@[holyday]) - DECODE(UPPER(POL_ETA_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                         'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                         'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                         'SAT',ARR_SAT_DYS),'DY','NLS_DATE_LANGUAGE=ENGLISH')  --CA LRD" ).append("\n"); 
		query.append("      END) LRD_DAY" ).append("\n"); 
		query.append("    ,(CASE WHEN POL_NOD_CD LIKE 'US%'    --US일 경우 ETA 대신 CCT FNC 추가" ).append("\n"); 
		query.append("           THEN (SELECT RCV_ITVAL_DYS" ).append("\n"); 
		query.append("                   FROM PRD_USA_CCT_ITVAL_MGMT CCTI" ).append("\n"); 
		query.append("                  WHERE LTST_RCV_DY_CD = TO_CHAR(US_CCT - DECODE(UPPER(US_CCT_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                                                         'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                                                         'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                                                         'SAT',ARR_SAT_DYS),'DY','NLS_DATE_LANGUAGE=ENGLISH') " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("                (SELECT RCV_ITVAL_DYS" ).append("\n"); 
		query.append("                   FROM PRD_CND_CCT_ITVAL_MGMT CCTI" ).append("\n"); 
		query.append("                  WHERE LTST_RCV_DY_CD = TO_CHAR(POL_ETA - DECODE(UPPER(POL_ETA_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                                                         'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                                                         'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                                                         'SAT',ARR_SAT_DYS),'DY','NLS_DATE_LANGUAGE=ENGLISH')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("     END) IVAL" ).append("\n"); 
		query.append("    ,(CASE WHEN POL_NOD_CD LIKE 'US%'   --US일 경우 ETA 대신 CCT FNC 추가" ).append("\n"); 
		query.append("           THEN TO_CHAR(US_CCT - TO_NUMBER(@[holyday]) - DECODE(US_CCT_DAY,'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                                      'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                                      'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                                      'SAT',ARR_SAT_DYS)" ).append("\n"); 
		query.append("                 - (SELECT RCV_ITVAL_DYS" ).append("\n"); 
		query.append("                      FROM PRD_USA_CCT_ITVAL_MGMT CCTI" ).append("\n"); 
		query.append("                     WHERE LTST_RCV_DY_CD = TO_CHAR(US_CCT - DECODE(UPPER(US_CCT_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                                                                      'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                                                                      'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                                                                      'SAT',ARR_SAT_DYS),'DY','NLS_DATE_LANGUAGE=ENGLISH')                 " ).append("\n"); 
		query.append("                    ),'YYYYMMDDhh24mi')  -- US ERD" ).append("\n"); 
		query.append("           ELSE TO_CHAR(POL_ETA - TO_NUMBER(@[holyday]) - DECODE(POL_ETA_DAY,'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                  'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                  'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                  'SAT',ARR_SAT_DYS)" ).append("\n"); 
		query.append("                 - (SELECT RCV_ITVAL_DYS" ).append("\n"); 
		query.append("                      FROM PRD_CND_CCT_ITVAL_MGMT CCTI" ).append("\n"); 
		query.append("                     WHERE LTST_RCV_DY_CD = TO_CHAR(POL_ETA - DECODE(UPPER(POL_ETA_DAY),'SUN',ARR_SUN_DYS,'MON',ARR_MON_DYS," ).append("\n"); 
		query.append("                                                                                        'TUE',ARR_TUE_DYS,'WED',ARR_WED_DYS," ).append("\n"); 
		query.append("                                                                                        'THU',ARR_THU_DYS,'FRI',ARR_FRI_DYS," ).append("\n"); 
		query.append("                                                                                        'SAT',ARR_SAT_DYS),'DY','NLS_DATE_LANGUAGE=ENGLISH')" ).append("\n"); 
		query.append("                   ),'YYYYMMDDhh24mi')  -- CA ERD" ).append("\n"); 
		query.append("     END) RTN_TIME --ERD " ).append("\n"); 
		query.append("    ,RN" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT --PRDD.* --COUNT(PRDD.PCTL_NO),PRDD.PCTL_NO" ).append("\n"); 
		query.append("        --(SELECT MIN(TRUNC(NVL(PF_ETA_DT,VPS_ETA_DT))) --ETA 날짜는 제외하고, 그 전날을 기준으로 산출 (전날은 하루로 포함되어야 하므로, ETA에서 TRIM만 처리한다) -- 20120308" ).append("\n"); 
		query.append("        (SELECT CASE WHEN SUBSTR(PRDM.POL_CD,1,2)='US' THEN TRUNC(COALESCE(MIN(VPS_ETB_DT),MIN(VPS_ETA_DT),MIN(PF_ETA_DT)))" ).append("\n"); 
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
		query.append("         ) POL_ETA" ).append("\n"); 
		query.append("         ,TO_CHAR((SELECT CASE WHEN SUBSTR(PRDM.POL_CD,1,2)='US' THEN TRUNC(COALESCE(MIN(VPS_ETB_DT),MIN(VPS_ETA_DT),MIN(PF_ETA_DT)))" ).append("\n"); 
		query.append("                     ELSE TRUNC(COALESCE(MIN(VPS_ETA_DT),MIN(PF_ETA_DT)))" ).append("\n"); 
		query.append("                     END --ETA 날짜는 제외하고, 그 전날을 기준으로 산출 (전날은 하루로 포함되어야 하므로, ETA에서 TRIM만 처리한다) -- 20120308" ).append("\n"); 
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
		query.append("                                                                   ) ,CCTM.POR_NOD_CD, 1, 2) )  RN" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("         ,NVL((SELECT PRD_GET_CCT_FNC(skd.pol_nod_cd, SKD.SLAN_CD, SKD.SLAN_DIR_CD, SKD.CGO_TP_CD, SKD.VPS_ETB_DT, SKD.VPS_ETD_DT, SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD) CCT" ).append("\n"); 
		query.append("                                                     FROM (SELECT SKD.SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                                 , CASE WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("                                                                        ELSE 'AL' END CGO_TP_CD" ).append("\n"); 
		query.append("                                                                 , VPS_ETB_DT" ).append("\n"); 
		query.append("                                                                 , VPS_ETD_DT" ).append("\n"); 
		query.append("                                                                 , pol_nod_cd" ).append("\n"); 
		query.append("                                                                 , VVD.VSL_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                               FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                                              WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("																AND VVD.VSL_CD	   NOT IN ('HJXX','HJYY','HJZZ')" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                AND VVD.POL_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                AND BK.BKG_NO      = nvl(@[bkg_no],'') " ).append("\n"); 
		query.append("							     ) SKD" ).append("\n"); 
		query.append("             ), '') US_CCT      -- 20151218 유저 요청으로 US 지역 rail cut off 계산시 ETA 대신 CCT 사용" ).append("\n"); 
		query.append("         ,TO_CHAR(NVL((select PRD_GET_CCT_FNC(skd.pol_nod_cd, SKD.SLAN_CD, SKD.SLAN_DIR_CD, SKD.CGO_TP_CD, SKD.VPS_ETB_DT, SKD.VPS_ETD_DT, SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD) CCT" ).append("\n"); 
		query.append("                                                     FROM (SELECT SKD.SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                                 , CASE WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("                                                                        ELSE 'AL' END CGO_TP_CD" ).append("\n"); 
		query.append("                                                                 , VPS_ETB_DT" ).append("\n"); 
		query.append("                                                                 , VPS_ETD_DT" ).append("\n"); 
		query.append("                                                                 , pol_nod_cd" ).append("\n"); 
		query.append("                                                                 , VVD.VSL_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                               FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                                              WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("																AND VVD.VSL_CD	   NOT IN ('HJXX','HJYY','HJZZ')" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                AND VVD.POL_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                AND BK.BKG_NO      = nvl(@[bkg_no],'') " ).append("\n"); 
		query.append("							     ) skd" ).append("\n"); 
		query.append("             ), '') ,'DY','NLS_DATE_LANGUAGE=ENGLISH') US_CCT_DAY" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         ,NVL((SELECT DISTINCT PRD_GET_CCT_FNC(D.ORG_NOD_CD,D.VSL_SLAN_CD,D.SKD_DIR_CD,DECODE(M.RF_SPCL_FLG,'Y','RF',DECODE(M.DG_SPCL_FLG,'Y','DG','DR')),NVL(S.VPS_ETB_DT,D.ARR_ST_DT),NVL(S.VPS_ETD_DT,D.ARR_ST_DT), D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD) CCT      " ).append("\n"); 
		query.append("                 FROM PRD_PROD_CTL_MST M,PRD_PROD_CTL_ROUT_DTL D,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                  AND M.PCTL_NO =D.PCTL_NO" ).append("\n"); 
		query.append("                  AND D.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                  AND D.TRSP_MOD_CD IN ('WD','VD')" ).append("\n"); 
		query.append("                  AND SUBSTR(D.ORG_NOD_CD,1,5) = M.POL_CD" ).append("\n"); 
		query.append("                  AND S.VSL_CD(+) = D.VSL_CD" ).append("\n"); 
		query.append("                  AND S.SKD_VOY_NO(+) = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND S.SKD_DIR_CD(+) = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND S.CLPT_IND_SEQ(+) = D.ORG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND S.YD_CD(+) = D.ORG_NOD_CD" ).append("\n"); 
		query.append("	           ), '') US_CCT -- 2016.02.22 시뮬레이션일때도 동일한 값이 나오게 하기 위해 소스 수정" ).append("\n"); 
		query.append("         ,TO_CHAR(NVL((SELECT DISTINCT PRD_GET_CCT_FNC(D.ORG_NOD_CD,D.VSL_SLAN_CD,D.SKD_DIR_CD,DECODE(M.RF_SPCL_FLG,'Y','RF',DECODE(M.DG_SPCL_FLG,'Y','DG','DR')),NVL(S.VPS_ETB_DT,D.ARR_ST_DT),NVL(S.VPS_ETD_DT,D.ARR_ST_DT), D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD) CCT      " ).append("\n"); 
		query.append("                 FROM PRD_PROD_CTL_MST M,PRD_PROD_CTL_ROUT_DTL D,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                  AND M.PCTL_NO =D.PCTL_NO" ).append("\n"); 
		query.append("                  AND D.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                  AND D.TRSP_MOD_CD IN ('WD','VD')" ).append("\n"); 
		query.append("                  AND SUBSTR(D.ORG_NOD_CD,1,5) = M.POL_CD" ).append("\n"); 
		query.append("                  AND S.VSL_CD(+) = D.VSL_CD" ).append("\n"); 
		query.append("                  AND S.SKD_VOY_NO(+) = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND S.SKD_DIR_CD(+) = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND S.CLPT_IND_SEQ(+) = D.ORG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND S.YD_CD(+) = D.ORG_NOD_CD" ).append("\n"); 
		query.append("	           ), ''),'DY','NLS_DATE_LANGUAGE=ENGLISH') US_CCT_DAY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         --,row_number() over(partition by CCTM.POR_CD,CCTM.POL_NOD_CD order by trim(CCTM.POR_NOD_CD) )  rn" ).append("\n"); 
		query.append("    FROM PRD_PROD_CTL_MST PRDM, PRD_CND_TML_CCT_MGMT CCTM --,PRD_PROD_CTL_ROUT_DTL PRDD" ).append("\n"); 
		query.append("--    WHERE PRDM.POR_CD = CCTM.POR_CD" ).append("\n"); 
		query.append("    WHERE CCTM.POR_CD = (" ).append("\n"); 
		query.append("                            SELECT SUBSTR(ORG_NOD_CD,1,5) " ).append("\n"); 
		query.append("                            FROM PRD_PROD_CTL_ROUT_DTL D " ).append("\n"); 
		query.append("                            WHERE D.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                            AND D.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("                            AND D.TRSP_MOD_CD = 'RD' " ).append("\n"); 
		query.append("                            AND ROWNUM = 1 " ).append("\n"); 
		query.append("--                            ORDER BY D.PCTL_SEQ" ).append("\n"); 
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
		query.append("    ------------------------------" ).append("\n"); 
		query.append("--    AND PRDM.POL_CD = CCTM.POL_CD" ).append("\n"); 
		query.append("--    AND PRDM.POL_nod_CD = CCTM.POL_CD -- JSY , POL 이 7자리로 변경" ).append("\n"); 
		query.append("    AND DECODE(LENGTH(CCTM.POL_NOD_CD),5,PRDM.POL_CD ,PRDM.POL_NOD_CD  )  = CCTM.POL_NOD_CD -- JSY , POL 이 5또는 7자리로 변경, 컬럼명 변경" ).append("\n"); 
		query.append("    AND PRDM.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("WHERE RN = 1" ).append("\n"); 

	}
}
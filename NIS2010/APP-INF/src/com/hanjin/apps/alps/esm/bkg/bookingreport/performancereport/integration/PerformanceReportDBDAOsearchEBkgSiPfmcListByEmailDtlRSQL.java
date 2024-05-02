/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchEBkgSiPfmcListByEmailDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOsearchEBkgSiPfmcListByEmailDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email, Fax 여부 확인
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchEBkgSiPfmcListByEmailDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchEBkgSiPfmcListByEmailDtlRSQL").append("\n"); 
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
		query.append("SELECT XX.DPCS" ).append("\n"); 
		query.append("     , REG.REGION REGION_CD" ).append("\n"); 
		query.append("     , GSO.GSO" ).append("\n"); 
		query.append("     , XX.BKG_OFC_CD OFC_CD" ).append("\n"); 
		query.append("     , XX.DURATION DURATION" ).append("\n"); 
		query.append("	 , XX.BKG_NO" ).append("\n"); 
		query.append("     , SUM(SI_CNT) SI_CNT" ).append("\n"); 
		query.append("     , SUM( NVL( DECODE(XTER_RQST_VIA_CD,'EML'," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                    SELECT DECODE(COUNT(*), 0, 1, 0)" ).append("\n"); 
		query.append("                    FROM NISADM.BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                    WHERE RQST_DT BETWEEN ADD_MONTHS(TO_DATE(REPLACE(@[duration_from_dt],'-',''), 'YYYYMMDD'), -3) AND TO_DATE(REPLACE(@[duration_from_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                      AND XTER_RQST_VIA_CD = 'EML'" ).append("\n"); 
		query.append("                      AND DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("                      AND BKG_NO = XX.BKG_NO), 0),0)) EML_FLG" ).append("\n"); 
		query.append("     , SUM( NVL( DECODE(XTER_RQST_VIA_CD,'ULD'," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                    SELECT DECODE(COUNT(*), 0, 1, 0)" ).append("\n"); 
		query.append("                    FROM NISADM.BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                    WHERE RQST_DT BETWEEN ADD_MONTHS(TO_DATE(REPLACE(@[duration_from_dt],'-',''), 'YYYYMMDD'), -3) AND TO_DATE(REPLACE(@[duration_from_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                      AND XTER_RQST_VIA_CD = 'ULD'" ).append("\n"); 
		query.append("                      AND DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("                      AND BKG_NO = XX.BKG_NO), 0),0)) ULD_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  /* 2015.01.23  e-SI CHM-201533777 Performance Report by SI Auto 메뉴 로직 변경 */" ).append("\n"); 
		query.append("     , COUNT( DISTINCT (SELECT DECODE(COUNT(*), 0, DPCS_BKG, NULL)" ).append("\n"); 
		query.append("                          FROM BKG_XTER_RQST_MST x" ).append("\n"); 
		query.append("                         WHERE X.RQST_DT BETWEEN ADD_MONTHS(TO_DATE(REPLACE(@[duration_from_dt],'-',''), 'YYYYMMDD'), -3) AND TO_DATE(REPLACE(@[duration_from_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                           AND X.XTER_RQST_VIA_CD in( 'EML','ULD')" ).append("\n"); 
		query.append("                           AND X.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("                           AND X.BKG_NO = XX.DPCS_BKG)" ).append("\n"); 
		query.append("             ) SI_AUTO_BKG_CNT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT /*+ INDEX(XM XAK5BKG_XTER_RQST_MST) */" ).append("\n"); 
		query.append("      DECODE(NVL(DOL.OFC_CD, 'NON DPCS'), 'NON DPCS', 'NON DPCS', 'DPCS') DPCS ," ).append("\n"); 
		query.append("      XM.BKG_NO," ).append("\n"); 
		query.append("      ( SELECT BKG_OFC_CD" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_NO = XM.BKG_NO ) BKG_OFC_CD, " ).append("\n"); 
		query.append("      XM.XTER_RQST_VIA_CD, " ).append("\n"); 
		query.append("	  /* 2015.01.23  e-SI CHM-201533777 Performance Report by SI Auto 메뉴 로직 변경 */" ).append("\n"); 
		query.append("      DECODE(XTER_RQST_VIA_CD,'ULD',XM.BKG_NO, 'EML',XM.BKG_NO, NULL) DPCS_BKG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      TO_CHAR(XM.RQST_DT,'YYYY-MM') DURATION ," ).append("\n"); 
		query.append("      COUNT(XTER_RQST_NO) SI_CNT" ).append("\n"); 
		query.append("    FROM BKG_XTER_RQST_MST XM,BKG_SR_FAX F," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT ATTR_CTNT1 OFC_CD" ).append("\n"); 
		query.append("        FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("        WHERE HRD_CDG_ID = 'DPCS_OFC_LIST' ) DOL" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND XM.RQST_DT > TO_DATE(REPLACE(@[duration_from_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("      AND XM.RQST_DT < TO_DATE(REPLACE(@[duration_to_dt],'-',''), 'YYYYMMDD')+1" ).append("\n"); 
		query.append("      AND SUBSTR(XM.BKG_NO, 1, 3) = DOL.OFC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  /* 2015.01.23  e-SI CHM-201533777 Performance Report by SI Auto 메뉴 로직 변경 */" ).append("\n"); 
		query.append("      AND XM.FAX_LOG_REF_NO = F.FAX_LOG_REF_NO" ).append("\n"); 
		query.append("      AND XM.XTER_RQST_NO = F.SR_NO" ).append("\n"); 
		query.append("      AND NVL(F.BKG_NO_MTCH_STS_CD,'S') = 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    GROUP BY DOL.OFC_CD, TO_CHAR(XM.RQST_DT,'YYYY-MM'),XM.XTER_RQST_VIA_CD, XM.BKG_NO" ).append("\n"); 
		query.append("         ) XX" ).append("\n"); 
		query.append("    , BKG_OFC_LVL_V GSO" ).append("\n"); 
		query.append("    , BKG_OFC_LVL_V REG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND REG.OFC_CD = XX.BKG_OFC_CD" ).append("\n"); 
		query.append("  AND GSO.OFC_CD = XX.BKG_OFC_CD" ).append("\n"); 
		query.append("  AND XX.BKG_OFC_CD IN (${ofc_cd})" ).append("\n"); 
		query.append("#if (${region_cd} != 'ALL') " ).append("\n"); 
		query.append("  AND XX.BKG_OFC_CD IN(SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION = @[region_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND XX.BKG_OFC_CD NOT IN ( SELECT ATTR_CTNT1 NON_OFC_CD 	FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'DPCS_NON_OFC_LIST' )" ).append("\n"); 
		query.append("GROUP BY XX.DPCS, XX.BKG_NO,XX.BKG_OFC_CD, XX.DURATION, REG.REGION, GSO.GSO" ).append("\n"); 
		query.append("ORDER BY XX.DPCS,REG.REGION, GSO.GSO, XX.BKG_OFC_CD, XX.BKG_NO" ).append("\n"); 

	}
}
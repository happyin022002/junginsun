/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchPctlOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.18
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.10.18 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchPctlOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port Closing Inquiry[ESM_BKG_0914]
	  * PCT (Port Closing Time) 현황 조회 화면 -1.Office_List
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchPctlOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_staff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gso",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_status",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchPctlOfficeListRSQL").append("\n"); 
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
		query.append("#if (${dt_type} == 'PCT')" ).append("\n"); 
		query.append("    SELECT /*+ ALL_ROWS */" ).append("\n"); 
		query.append("           OLA.REGION RHQ_CD" ).append("\n"); 
		query.append("          ,OLA.GSO BKG_OFC_CD" ).append("\n"); 
		query.append("          ,OLA.OFC_CD B_OFC" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(COUNT(BK.BKG_NO))) TTL" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(SUM(DECODE(BK.BKG_STS_CD, 'F', 1, 'S', 1, 0)))) FIRM_TTL" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(SUM(DECODE(BK.BKG_STS_CD, 'W', 1, 0)))) WAIT_TTL" ).append("\n"); 
		query.append("		  ,TRIM(TO_CHAR(SUM(CASE WHEN BK.CUST_TO_ORD_FLG ='Y' AND (NVL(BN.CUST_SEQ,0) <> 0) THEN 1 " ).append("\n"); 
		query.append("                                 WHEN BC.BKG_CUST_TP_CD = 'C' AND (NVL(BC.CUST_SEQ,0) <> 0 OR NVL(BK.INDIV_PSON_FLG,'N') ='Y') THEN 1 ELSE 0 END)))CNEE_TTL" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(SUM(DECODE(BKG_RATE_RESULT_FNC(BK.BKG_NO), 'F', 1, 0)))) RFIRM_TTL" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(SUM(DECODE(BKG_RATE_RESULT_FNC(BK.BKG_NO), 'N', 1, 0)))) NULL_TTL" ).append("\n"); 
		query.append("          ,'' BKG_STS_CD" ).append("\n"); 
		query.append("          ,'' BKG_RT_STS_CD" ).append("\n"); 
		query.append("          ,'' REV_STATUS" ).append("\n"); 
		query.append("          ,'' BKG_STAFF" ).append("\n"); 
		query.append("          ,'' FR_DT" ).append("\n"); 
		query.append("          ,'' TO_DT" ).append("\n"); 
		query.append("          ,'' POL_CD" ).append("\n"); 
		query.append("          ,'' VVD_CD" ).append("\n"); 
		query.append("          ,'' GSO" ).append("\n"); 
		query.append("          ,'' DT_TYPE  --PCT,ETD" ).append("\n"); 
		query.append("          ,'0'  S_BL_TTL" ).append("\n"); 
		query.append("          ,'0'  O_BL_TTL" ).append("\n"); 
		query.append("          ,'0'  S_CNEE_TTL" ).append("\n"); 
		query.append("          ,'0'  O_CNEE_TTL" ).append("\n"); 
		query.append("          ,'0'  S_NTFY_TTL" ).append("\n"); 
		query.append("          ,'0'  O_NTFY_TTL" ).append("\n"); 
		query.append("          ,''   BL_TYPE" ).append("\n"); 
		query.append("          ,'0'   BL_TTL" ).append("\n"); 
		query.append("          ,'0'   NTFY_TTL" ).append("\n"); 
		query.append("          ,''   DOWN_TP_O" ).append("\n"); 
		query.append("          ,''   DOWN_TP_B" ).append("\n"); 
		query.append("          ,''   DOWN_TP_T" ).append("\n"); 
		query.append("          ,SUM(BK.CNTR_CFM) AS CNTR_CFM" ).append("\n"); 
		query.append("          ,COUNT(BK.BKG_NO) - SUM(BK.CNTR_CFM) AS CNTR_NONCFM" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT BK.BKG_NO" ).append("\n"); 
		query.append("                  ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("                  ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("                  ,(SELECT NVL(COUNT(*),0)" ).append("\n"); 
		query.append("                      FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                     WHERE BKG_DOC_PROC_TP_CD IN('CNTCFM', 'CNTRLS')" ).append("\n"); 
		query.append("                       AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) AS CNTR_CFM" ).append("\n"); 
		query.append("				,BK.INDIV_PSON_FLG" ).append("\n"); 
		query.append("				,BK.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("              FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("            #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("               AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("               AND BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${bkg_rt_sts_cd} != '' && ${bkg_rt_sts_cd} != 'A')" ).append("\n"); 
		query.append("               AND BKG_RATE_RESULT_FNC(BK.BKG_NO)  = @[bkg_rt_sts_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${bkg_staff} != '')" ).append("\n"); 
		query.append("               AND BK.DOC_USR_ID LIKE @[bkg_staff] || '%%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${fr_dt} != '')" ).append("\n"); 
		query.append("               AND BK.PORT_CLZ_DT   >= TO_DATE(@[fr_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${to_dt} != '')" ).append("\n"); 
		query.append("               AND BK.PORT_CLZ_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${pol_cd} != '')" ).append("\n"); 
		query.append("               AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("               AND BK.VSL_CD =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("               AND BK.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("               AND BK.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${slan_cd} != 'All')" ).append("\n"); 
		query.append("               AND BK.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("           ) BK" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER BN" ).append("\n"); 
		query.append("          ,BKG_VVD VVD" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("          ,(SELECT ROWNUM" ).append("\n"); 
		query.append("                  ,REGION" ).append("\n"); 
		query.append("                  ,GSO" ).append("\n"); 
		query.append("                  ,OFC_CD" ).append("\n"); 
		query.append("              FROM BKG_OFC_LVL_V" ).append("\n"); 
		query.append("            ) OLA" ).append("\n"); 
		query.append("    #if (${rev_status} != '')" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("            SELECT S.*" ).append("\n"); 
		query.append("                  ,DECODE(NVL(REV_LANE, 'N'), 'N', 'N', 'Y') REV_STATUS" ).append("\n"); 
		query.append("              FROM MDM_VSL_SVC_LANE S" ).append("\n"); 
		query.append("                  ,(" ).append("\n"); 
		query.append("                    SELECT DISTINCT SUBSTR(RLANE_CD, 1, 3) REV_LANE" ).append("\n"); 
		query.append("                      FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("                     WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   ) R" ).append("\n"); 
		query.append("             WHERE S.VSL_SLAN_CD = R.REV_LANE(+)" ).append("\n"); 
		query.append("           ) REV" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     WHERE BK.BKG_OFC_CD = OLA.OFC_CD" ).append("\n"); 
		query.append("       AND OLA.REGION IS NOT NULL" ).append("\n"); 
		query.append("       AND BC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("       AND BN.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("       AND BC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("       AND BN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("       AND VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("       AND VPS.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("       AND VPS.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VPS.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VPS.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("       AND VPS.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("       AND VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ = (SELECT /*+ INDEX(VVD XPKBKG_VVD) */" ).append("\n"); 
		query.append("                                                       BV.VSL_PRE_PST_CD || BV.VSL_SEQ" ).append("\n"); 
		query.append("                                                  FROM BKG_VVD BV" ).append("\n"); 
		query.append("                                                 WHERE BV.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                   AND ROWNUM =1)" ).append("\n"); 
		query.append("    #if (${rev_status} != '')" ).append("\n"); 
		query.append("       AND VVD.SLAN_CD = REV.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rhq_cd} != '')" ).append("\n"); 
		query.append("       AND OLA.REGION = @[rhq_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${gso} != '')" ).append("\n"); 
		query.append("       AND OLA.GSO = @[gso]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rev_status} != '')" ).append("\n"); 
		query.append("       AND NVL(REV.REV_STATUS, 'N') = @[rev_status]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cntr_cfm} == 'Y')" ).append("\n"); 
		query.append("       AND BK.CNTR_CFM > 0" ).append("\n"); 
		query.append("    #elseif (${cntr_cfm} == 'N')" ).append("\n"); 
		query.append("       AND BK.CNTR_CFM = 0" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    GROUP BY OLA.REGION, OLA.GSO, OLA.OFC_CD" ).append("\n"); 
		query.append("    ORDER BY OLA.REGION, OLA.GSO, OLA.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${dt_type} =='ETD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT REGION RHQ_CD" ).append("\n"); 
		query.append("          ,GSO BKG_OFC_CD" ).append("\n"); 
		query.append("          ,OFC_CD B_OFC" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(COUNT(TTL))) TTL" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(SUM(DECODE(BKG_STS_CD, 'F', 1, 'S', 1, 0)))) FIRM_TTL" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(SUM(DECODE(BKG_STS_CD, 'W', 1, 0)))) WAIT_TTL" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(SUM(CASE WHEN BKG_CUST_TP_CD = 'C' AND (NVL(CUST_SEQ,0) <> 0 OR NVL(INDIV_PSON_FLG,'N') ='Y') THEN 1 ELSE 0 END)))CNEE_TTL" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(SUM(DECODE(BKG_RATE_RESULT_FNC(TTL), 'F', 1, 0)))) RFIRM_TTL" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(SUM(DECODE(BKG_RATE_RESULT_FNC(TTL), 'N', 1, 0)))) NULL_TTL" ).append("\n"); 
		query.append("          ,SUM(CNTR_CFM) AS CNTR_CFM" ).append("\n"); 
		query.append("          ,COUNT(TTL) - SUM(CNTR_CFM) AS CNTR_NONCFM" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT /*+ ALL_ROWS */" ).append("\n"); 
		query.append("                   BK.BKG_NO TTL" ).append("\n"); 
		query.append("                  ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("                  ,BKG_RATE_RESULT_FNC(BK.BKG_NO)  BKG_RT_STS_CD" ).append("\n"); 
		query.append("                  ,BK.CNTR_CFM" ).append("\n"); 
		query.append("                  ,OLA.REGION REGION" ).append("\n"); 
		query.append("                  ,OLA.GSO GSO" ).append("\n"); 
		query.append("                  ,OLA.OFC_CD" ).append("\n"); 
		query.append("                  ,C.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                  ,C.CUST_CNT_CD" ).append("\n"); 
		query.append("				  ,C.CUST_SEQ" ).append("\n"); 
		query.append("				  ,BK.INDIV_PSON_FLG" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("		            SELECT BK.BKG_NO" ).append("\n"); 
		query.append("		                  ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("		                  ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("		                  ,BK.POL_CD" ).append("\n"); 
		query.append("		                  ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("		                      FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("		                     WHERE BKG_DOC_PROC_TP_CD IN('CNTCFM', 'CNTRLS')" ).append("\n"); 
		query.append("		                       AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("		                       AND BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		                       AND ROWNUM = 1" ).append("\n"); 
		query.append("		                   ) AS CNTR_CFM" ).append("\n"); 
		query.append("						  ,BK.INDIV_PSON_FLG" ).append("\n"); 
		query.append("		              FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("		             WHERE 1=1" ).append("\n"); 
		query.append("		               AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("		               AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("		            #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("		               AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("		            #end" ).append("\n"); 
		query.append("		            #if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("		               AND BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("		            #end" ).append("\n"); 
		query.append("		            #if (${bkg_rt_sts_cd} != '' && ${bkg_rt_sts_cd} != 'A')" ).append("\n"); 
		query.append("		               AND BKG_RATE_RESULT_FNC(BK.BKG_NO)  = @[bkg_rt_sts_cd]" ).append("\n"); 
		query.append("		            #end" ).append("\n"); 
		query.append("		            #if (${bkg_staff} != '')" ).append("\n"); 
		query.append("		               AND BK.DOC_USR_ID LIKE @[bkg_staff] || '%%'" ).append("\n"); 
		query.append("		            #end" ).append("\n"); 
		query.append("		            #if (${pol_cd} != '')" ).append("\n"); 
		query.append("		               AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("		            #end" ).append("\n"); 
		query.append("		            #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("		               AND BK.VSL_CD =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("		               AND BK.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		               AND BK.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("		            #end" ).append("\n"); 
		query.append("		            #if (${slan_cd} != 'All')" ).append("\n"); 
		query.append("		               AND BK.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                   ) BK" ).append("\n"); 
		query.append("                  ,BKG_CUSTOMER C" ).append("\n"); 
		query.append("                  ,BKG_VVD         VVD" ).append("\n"); 
		query.append("                  ,VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                  ,(SELECT ROWNUM" ).append("\n"); 
		query.append("                          ,REGION" ).append("\n"); 
		query.append("                          ,GSO" ).append("\n"); 
		query.append("                          ,OFC_CD" ).append("\n"); 
		query.append("                      FROM BKG_OFC_LVL_V" ).append("\n"); 
		query.append("                   ) OLA" ).append("\n"); 
		query.append("                #if (${rev_status} != '')" ).append("\n"); 
		query.append("                  ,(" ).append("\n"); 
		query.append("                    SELECT S.*, DECODE(NVL(REV_LANE, 'N'), 'N', 'N', 'Y') REV_STATUS" ).append("\n"); 
		query.append("                      FROM MDM_VSL_SVC_LANE S" ).append("\n"); 
		query.append("                          ,(" ).append("\n"); 
		query.append("                            SELECT DISTINCT SUBSTR(RLANE_CD, 1, 3) REV_LANE" ).append("\n"); 
		query.append("                              FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("                             WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            ) R" ).append("\n"); 
		query.append("                     WHERE S.VSL_SLAN_CD = R.REV_LANE(+)) REV" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("             WHERE BK.BKG_OFC_CD = OLA.OFC_CD" ).append("\n"); 
		query.append("               AND OLA.REGION IS NOT NULL" ).append("\n"); 
		query.append("               AND C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("               AND C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("               AND BK.BKG_NO           =  VVD.BKG_NO" ).append("\n"); 
		query.append("               AND BK.POL_CD           =  VVD.POL_CD" ).append("\n"); 
		query.append("               AND VPS.VSL_CD          =  VVD.VSL_CD" ).append("\n"); 
		query.append("               AND VPS.SKD_VOY_NO      =  VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VPS.SKD_DIR_CD      =  VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VPS.CLPT_IND_SEQ    =  VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("               AND VPS.VPS_PORT_CD     =  VVD.POL_CD" ).append("\n"); 
		query.append("            #if (${fr_dt} != '')" ).append("\n"); 
		query.append("               AND VPS.VPS_ETD_DT >= TO_DATE(@[fr_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${to_dt} != '')" ).append("\n"); 
		query.append("               AND VPS.VPS_ETD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${rhq_cd} != '')" ).append("\n"); 
		query.append("               AND OLA.REGION = @[rhq_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${gso} != '')" ).append("\n"); 
		query.append("               AND OLA.GSO = @[gso]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${rev_status} != '')" ).append("\n"); 
		query.append("               AND NVL(REV.REV_STATUS, 'N') = @[rev_status]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${rev_status} != '')" ).append("\n"); 
		query.append("               AND VPS.SLAN_CD = REV.VSL_SLAN_CD" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    #if (${cntr_cfm} == 'Y')" ).append("\n"); 
		query.append("		       AND BK.CNTR_CFM > 0" ).append("\n"); 
		query.append("		    #elseif (${cntr_cfm} == 'N')" ).append("\n"); 
		query.append("		       AND BK.CNTR_CFM = 0" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    GROUP BY REGION, GSO, OFC_CD" ).append("\n"); 
		query.append("    ORDER BY REGION, GSO, OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
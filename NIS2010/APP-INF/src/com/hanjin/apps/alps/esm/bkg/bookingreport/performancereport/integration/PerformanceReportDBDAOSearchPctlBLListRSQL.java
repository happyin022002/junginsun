/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchPctlBLListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.27 
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

public class PerformanceReportDBDAOSearchPctlBLListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port Closing Inquiry[ESM_BKG_0914]
	  * PCT (Port Closing Time) 현황 조회 화면-2.B/L List
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchPctlBLListRSQL(){
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
		params.put("gso",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchPctlBLListRSQL").append("\n"); 
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
		query.append("SELECT TB.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("#if (${dt_type} == 'PCT')" ).append("\n"); 
		query.append("--------------------------------------------------------------------------------" ).append("\n"); 
		query.append("    SELECT /*+ ALL_ROWS */" ).append("\n"); 
		query.append("           BK.BKG_NO" ).append("\n"); 
		query.append("          ,BK.BL_NO || BK.BL_NO_TP  BL_NO" ).append("\n"); 
		query.append("          ,DECODE(NVL(SC.CUST_SEQ,'0'),'0','',TRIM(SC.CUST_CNT_CD) || TRIM(TO_CHAR(NVL(SC.CUST_SEQ, 0), '000000'))) SHPR_CD" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(SUBSTR(SC.CUST_NM, 1, 50), CHR(13), ''), CHR(10), '') SHPR_NM" ).append("\n"); 
		query.append("          ,BK.POL_CD" ).append("\n"); 
		query.append("          ,DECODE(BMO.BL_CVRD_TP_CD, 'C', 'F', BKG_RATE_RESULT_FNC(BK.BKG_NO)) BKG_RT_STS_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS') ATD" ).append("\n"); 
		query.append("          ,TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS') ETD" ).append("\n"); 
		query.append("          ,VPS.VSL_CD || VPS.SKD_VOY_NO || VPS.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("          ,VPS.SLAN_CD" ).append("\n"); 
		query.append("          ,NVL(REV.REV_STATUS, 'N') REV_STATUS" ).append("\n"); 
		query.append("          ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("          ,BK.SI_FLG" ).append("\n"); 
		query.append("          ,DECODE(BK.INDIV_PSON_FLG,'Y','Individual',DECODE(NVL(CC.CUST_SEQ,'0'),'0','',TRIM(CC.Cust_Cnt_Cd) || TRIM(TO_CHAR(NVL(CC.CUST_SEQ, 0), '000000')))) CNEE_CD" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(SUBSTR(CC.CUST_NM, 1, 50), CHR(13), ''), CHR(10), '') CNEE_NM" ).append("\n"); 
		query.append("          ,BK.Bkg_Ofc_Cd" ).append("\n"); 
		query.append("          ,BK.DOC_USR_ID     BKG_STF" ).append("\n"); 
		query.append("          ,DECODE(BK.CUST_TO_ORD_FLG, 'Y', 'O', 'S') BL_TYPE" ).append("\n"); 
		query.append("          ,DECODE(NVL(NC.CUST_SEQ,'0'),'0','',TRIM(NC.Cust_Cnt_CD) || TRIM(TO_CHAR(NVL(NC.CUST_SEQ, 0), '000000'))) NTFY_CD" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(SUBSTR(NC.CUST_NM, 1, 50), CHR(13), ''), CHR(10), '') NTFY_NM" ).append("\n"); 
		query.append("          ,TO_CHAR(BK.PORT_CLZ_DT, 'YYYY-MM-DD') BKG_PCT_DT" ).append("\n"); 
		query.append("          ,BK.SC_NO" ).append("\n"); 
		query.append("          ,BK.RFA_NO" ).append("\n"); 
		query.append("          ,'' BKG_STAFF" ).append("\n"); 
		query.append("          ,'' FR_DT" ).append("\n"); 
		query.append("          ,'' TO_DT" ).append("\n"); 
		query.append("          ,'' GSO" ).append("\n"); 
		query.append("          ,'' DT_TYPE  --PCT,ETD" ).append("\n"); 
		query.append("          ,'' SEL_BKG_OFC_CD" ).append("\n"); 
		query.append("          ,''   DOWN_TP_O" ).append("\n"); 
		query.append("          ,''   DOWN_TP_B" ).append("\n"); 
		query.append("          ,''   DOWN_TP_T" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("           SELECT DECODE(COUNT(*), 0, 'N', 'Y')" ).append("\n"); 
		query.append("	         FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("            WHERE BKG_DOC_PROC_TP_CD IN ('CNTCFM', 'CNTRLS')" ).append("\n"); 
		query.append("              AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("              AND BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("           ) AS CNTR_CFM" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("          ,BKG_BL_DOC  BMO" ).append("\n"); 
		query.append("          ,BKG_VVD VVD" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER NC" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER CC" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER SC" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("            SELECT S.*, DECODE(NVL(REV_LANE, 'N'), 'N', 'N', 'Y') REV_STATUS" ).append("\n"); 
		query.append("              FROM MDM_VSL_SVC_LANE S" ).append("\n"); 
		query.append("                  ,(" ).append("\n"); 
		query.append("                    SELECT DISTINCT SUBSTR(RLANE_CD, 1, 3) REV_LANE" ).append("\n"); 
		query.append("                      FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("                     WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   ) R" ).append("\n"); 
		query.append("             WHERE S.VSL_SLAN_CD = R.REV_LANE(+)" ).append("\n"); 
		query.append("            ) REV" ).append("\n"); 
		query.append("    #if (${down_tp_t} == 'TOT')" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("            SELECT ROWNUM" ).append("\n"); 
		query.append("                  ,REGION" ).append("\n"); 
		query.append("                  ,GSO" ).append("\n"); 
		query.append("                  ,OFC_CD" ).append("\n"); 
		query.append("              FROM BKG_OFC_LVL_V" ).append("\n"); 
		query.append("            ) OLA" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND BK.Bkg_Ofc_Cd = OLA.OFC_CD" ).append("\n"); 
		query.append("       AND OLA.REGION IS NOT NULL" ).append("\n"); 
		query.append("       #if (${rhq_cd} != '')" ).append("\n"); 
		query.append("       AND OLA.REGION = @[rhq_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${gso} != '')" ).append("\n"); 
		query.append("       AND OLA.GSO = @[gso]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND BK.Bkg_Ofc_Cd = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("     WHERE  1=1" ).append("\n"); 
		query.append("       #if (${sel_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND BK.Bkg_Ofc_Cd = @[sel_bkg_ofc_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("     AND BK.BKG_NO = BMO.BKG_NO" ).append("\n"); 
		query.append("     AND CC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("     AND CC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("     AND SC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("     AND SC.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("     AND NC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("     AND NC.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("     AND VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("     AND VPS.SLAN_CD = REV.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("     AND VPS.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("     AND VPS.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND VPS.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND VPS.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("     AND VPS.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("     AND BK.BKG_CRE_DT > TO_DATE('20060101', 'YYYYMMDD')" ).append("\n"); 
		query.append("     AND VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ = (SELECT /*+ INDEX(VVD XPKBKG_VVD) */" ).append("\n"); 
		query.append("                                                     BV.VSL_PRE_PST_CD || BV.VSL_SEQ" ).append("\n"); 
		query.append("                                                FROM BKG_VVD BV" ).append("\n"); 
		query.append("                                               WHERE BV.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                 AND ROWNUM =1)" ).append("\n"); 
		query.append("    #if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_rt_sts_cd} != '' && ${bkg_rt_sts_cd} != 'A')" ).append("\n"); 
		query.append("       AND BKG_RATE_RESULT_FNC(BK.BKG_NO) = @[bkg_rt_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rev_status} != '')" ).append("\n"); 
		query.append("       AND NVL(REV.REV_STATUS, 'N') = @[rev_status]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_staff} != '')" ).append("\n"); 
		query.append("       AND BK.DOC_USR_ID LIKE @[bkg_staff] || '%%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fr_dt} != '')" ).append("\n"); 
		query.append("       AND BK.PORT_CLZ_DT   >= TO_DATE(@[fr_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${to_dt} != '')" ).append("\n"); 
		query.append("       AND BK.PORT_CLZ_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("       AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("       AND BK.VSL_CD =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("       AND BK.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("       AND BK.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${slan_cd} != 'All')" ).append("\n"); 
		query.append("       AND BK.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    -------------------------------------------" ).append("\n"); 
		query.append("    #if (${down_tp_t} == 'TOT')" ).append("\n"); 
		query.append("    ORDER BY OLA.REGION,OLA.GSO, BK.BKG_OFC_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    -------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${dt_type} =='ETD')" ).append("\n"); 
		query.append("--------------------------------------------------------------------------------" ).append("\n"); 
		query.append("    SELECT /*+ ALL_ROWS */" ).append("\n"); 
		query.append("           BK.BKG_NO" ).append("\n"); 
		query.append("          ,BK.BL_NO || BK.BL_NO_TP BL_NO" ).append("\n"); 
		query.append("          ,TRIM(SC.CUST_CNT_CD) || TRIM(TO_CHAR(NVL(SC.CUST_SEQ, 0), '000000')) SHPR_CD" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(SUBSTR(SC.CUST_NM, 1, 50), CHR(13), ''), CHR(10), '') SHPR_NM" ).append("\n"); 
		query.append("          ,BK.POL_CD POL_CD" ).append("\n"); 
		query.append("          ,DECODE(BMO.BL_CVRD_TP_CD, 'C', 'F', BKG_RATE_RESULT_FNC(BK.BKG_NO)) BKG_RT_STS_CD" ).append("\n"); 
		query.append("          ,VAS.ACT_DEP_DT   ATD" ).append("\n"); 
		query.append("          ,TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS') ETD" ).append("\n"); 
		query.append("          ,VPS.VSL_CD || VPS.SKD_VOY_NO || VPS.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("          ,VPS.SLAN_CD" ).append("\n"); 
		query.append("          ,NVL(REV.REV_STATUS, 'N') REV_STATUS" ).append("\n"); 
		query.append("          ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("          ,BK.SI_FLG" ).append("\n"); 
		query.append("          ,DECODE(BK.INDIV_PSON_FLG,'Y','Individual',TRIM(CC.CUST_CNT_CD) || TRIM(TO_CHAR(NVL(CC.CUST_SEQ, 0), '000000'))) CNEE_CD" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(SUBSTR(CC.CUST_NM, 1, 50), CHR(13), ''), CHR(10), '') CNEE_NM" ).append("\n"); 
		query.append("          ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("          ,BK.DOC_USR_ID BKG_STF" ).append("\n"); 
		query.append("          ,DECODE(BK.CUST_TO_ORD_FLG, 'Y', 'O', 'S') BL_TYPE" ).append("\n"); 
		query.append("          ,TRIM(NC.CUST_CNT_CD) || TRIM(TO_CHAR(NVL(NC.CUST_SEQ, 0), '000000')) NTFY_CD" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(SUBSTR(NC.CUST_NM, 1, 50), CHR(13), ''), CHR(10), '') NTFY_NM" ).append("\n"); 
		query.append("          ,TO_CHAR(BK.PORT_CLZ_DT, 'YYYY-MM-DD') BKG_PCT_DT" ).append("\n"); 
		query.append("          ,BK.SC_NO" ).append("\n"); 
		query.append("          ,BK.RFA_NO" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("           SELECT DECODE(COUNT(*), 0, 'N', 'Y')" ).append("\n"); 
		query.append("	         FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("            WHERE BKG_DOC_PROC_TP_CD IN ('CNTCFM', 'CNTRLS')" ).append("\n"); 
		query.append("              AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("              AND BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("           ) AS CNTR_CFM" ).append("\n"); 
		query.append("    FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append("          ,BKG_BL_DOC BMO" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER CC" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER NC" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER SC" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("            SELECT S.*, DECODE(NVL(REV_LANE, 'N'), 'N', 'N', 'Y') REV_STATUS" ).append("\n"); 
		query.append("              FROM MDM_VSL_SVC_LANE S" ).append("\n"); 
		query.append("                  ,(SELECT DISTINCT SUBSTR(RLANE_CD, 1, 3) REV_LANE" ).append("\n"); 
		query.append("                      FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("                     WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    ) R" ).append("\n"); 
		query.append("             WHERE S.VSL_SLAN_CD = R.REV_LANE(+)" ).append("\n"); 
		query.append("           ) REV" ).append("\n"); 
		query.append("          ,BKG_VVD         VVD" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("            SELECT /*+ USE_NL(VPS VVD VAP) */" ).append("\n"); 
		query.append("                   VPS.VSL_CD" ).append("\n"); 
		query.append("                  ,VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,VAP.ACT_DEP_DT" ).append("\n"); 
		query.append("                  ,VPS.SLAN_CD" ).append("\n"); 
		query.append("                  ,VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD  VPS" ).append("\n"); 
		query.append("                  ,BKG_VVD           VVD" ).append("\n"); 
		query.append("                  ,VSK_ACT_PORT_SKD VAP" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND VPS.VPS_PORT_CD   =   VVD.POL_CD" ).append("\n"); 
		query.append("               AND VPS.VSL_CD       =   VVD.VSL_CD" ).append("\n"); 
		query.append("               AND VPS.SKD_VOY_NO   =   VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VPS.SKD_DIR_CD   =   VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VPS.VSL_CD        =   VAP.VSL_CD" ).append("\n"); 
		query.append("               AND VPS.SKD_VOY_NO   =   VAP.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VPS.SKD_DIR_CD   =   VAP.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VPS.VPS_PORT_CD  =   VAP.VPS_PORT_CD" ).append("\n"); 
		query.append("               AND VPS.CLPT_IND_SEQ =   VAP.CLPT_IND_SEQ" ).append("\n"); 
		query.append("               AND VPS.CLPT_IND_SEQ =    VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("            #if (${fr_dt} != '')" ).append("\n"); 
		query.append("               AND VPS.VPS_ETD_DT >= TO_DATE(@[fr_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${to_dt} != '')" ).append("\n"); 
		query.append("               AND VPS.VPS_ETD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            GROUP BY VPS.VSL_CD,VPS.SKD_VOY_NO,VPS.SKD_DIR_CD,VAP.ACT_DEP_DT,VPS.SLAN_CD,VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("           ) VAS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    -------------------------------------------" ).append("\n"); 
		query.append("    #if (${down_tp_t} == 'TOT')" ).append("\n"); 
		query.append("           ,(" ).append("\n"); 
		query.append("             SELECT ROWNUM" ).append("\n"); 
		query.append("                   ,REGION" ).append("\n"); 
		query.append("                   ,GSO" ).append("\n"); 
		query.append("                   ,OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_OFC_LVL_V" ).append("\n"); 
		query.append("            ) OLA" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND BK.Bkg_Ofc_Cd = OLA.OFC_CD" ).append("\n"); 
		query.append("       AND OLA.REGION IS NOT NULL" ).append("\n"); 
		query.append("       #if (${rhq_cd} != '')" ).append("\n"); 
		query.append("       AND OLA.REGION = @[rhq_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${gso} != '')" ).append("\n"); 
		query.append("       AND OLA.GSO = @[gso]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND BK.Bkg_Ofc_Cd = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       #if (${sel_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND BK.Bkg_Ofc_Cd = @[sel_bkg_ofc_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    -------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("       AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("       AND VPS.SLAN_CD = REV.VSL_SLAN_CD" ).append("\n"); 
		query.append("       AND BK.BKG_NO = BMO.BKG_NO" ).append("\n"); 
		query.append("       AND CC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("       AND CC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("       AND SC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("       AND SC.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("       AND NC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("       AND NC.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("       AND BK.POL_CD           = VVD.POL_CD" ).append("\n"); 
		query.append("       AND BK.BKG_NO           = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND VPS.VSL_CD          = VVD.VSL_CD" ).append("\n"); 
		query.append("       AND VPS.SKD_VOY_NO      = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VPS.SKD_DIR_CD      = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VPS.CLPT_IND_SEQ    = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND VPS.VPS_PORT_CD     = VVD.POL_CD" ).append("\n"); 
		query.append("       AND VPS.VSL_CD          = VAS.VSL_CD(+)" ).append("\n"); 
		query.append("       AND VPS.SKD_VOY_NO      = VAS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND VPS.SKD_DIR_CD      = VAS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       AND VPS.VPS_PORT_CD     = VAS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_rt_sts_cd} != '' && ${bkg_rt_sts_cd} != 'A')" ).append("\n"); 
		query.append("       AND BKG_RATE_RESULT_FNC(BK.BKG_NO) = @[bkg_rt_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rev_status} != '')" ).append("\n"); 
		query.append("       AND NVL(REV.REV_STATUS, 'N') = @[rev_status]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_staff} != '')" ).append("\n"); 
		query.append("       AND BK.DOC_USR_ID LIKE @[bkg_staff] || '%%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("       AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fr_dt} != '')" ).append("\n"); 
		query.append("       AND VPS.VPS_ETD_DT >= TO_DATE(@[fr_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${to_dt} != '')" ).append("\n"); 
		query.append("       AND VPS.VPS_ETD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("       AND BK.VSL_CD =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("       AND BK.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("       AND BK.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${slan_cd} != 'All')" ).append("\n"); 
		query.append("       AND BK.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    -------------------------------------------" ).append("\n"); 
		query.append("    #if (${down_tp_t} == 'TOT')" ).append("\n"); 
		query.append("    ORDER  BY OLA.REGION,OLA.GSO, BK.BKG_OFC_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    -------------------------------------------" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 
		query.append("#if (${cntr_cfm} != '')" ).append("\n"); 
		query.append(" WHERE TB.CNTR_CFM = @[cntr_cfm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
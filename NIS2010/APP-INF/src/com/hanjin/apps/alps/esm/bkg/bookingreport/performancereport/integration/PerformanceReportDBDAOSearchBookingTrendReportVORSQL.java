/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBookingTrendReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.28 
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

public class PerformanceReportDBDAOSearchBookingTrendReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.10.08 김영철 [CHM-201006186-01] 
	  *   1. 조회조건으로 Contract Office및  Sales Rep.조건 추가
	  *   2. Direct Down Load(B/L Detail) List상에 Contract Office및 Contract Sales Rep. 추가반영 및 일부항목 Label수정
	  *   3. Load기준 FEU로 조회시 환산오류 수정.   
	  * 2015.06.08 COA_BKG_REV_DTL ==>MAS_BKG_REV_DTL 변경
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBookingTrendReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_etd_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_etd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cxl_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cxl_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchBookingTrendReportVORSQL").append("\n"); 
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
		query.append("#if (${sql_tp} != '')" ).append("\n"); 
		query.append("SELECT '' VVD" ).append("\n"); 
		query.append("      ,'' BL_NO" ).append("\n"); 
		query.append("      ,'' SLAN_CD" ).append("\n"); 
		query.append("      ,'' POR_CD" ).append("\n"); 
		query.append("      ,'' POL_CD" ).append("\n"); 
		query.append("      ,'' POD_CD" ).append("\n"); 
		query.append("      ,'' DEL_CD" ).append("\n"); 
		query.append("      ,'' ETD_DT" ).append("\n"); 
		query.append("      ,'' ETD_WK" ).append("\n"); 
		query.append("      ,'' COST_WK" ).append("\n"); 
		query.append("      ,'' CUST_CNT_CD" ).append("\n"); 
		query.append("      ,'' CUST_SEQ" ).append("\n"); 
		query.append("      ,'' CUST_NM" ).append("\n"); 
		query.append("      ,'' LOAD" ).append("\n"); 
		query.append("      ,'' CM" ).append("\n"); 
		query.append("      ,'' CMPB" ).append("\n"); 
		query.append("      ,'' D_1" ).append("\n"); 
		query.append("      ,'' D_2" ).append("\n"); 
		query.append("      ,'' D_3" ).append("\n"); 
		query.append("      ,'' D_4" ).append("\n"); 
		query.append("      ,'' D_5" ).append("\n"); 
		query.append("      ,'' D_6" ).append("\n"); 
		query.append("      ,'' D_7" ).append("\n"); 
		query.append("      ,'' D_8" ).append("\n"); 
		query.append("      ,'' D_8" ).append("\n"); 
		query.append("      ,'' D_9" ).append("\n"); 
		query.append("      ,'' D_10" ).append("\n"); 
		query.append("      ,'' D_11" ).append("\n"); 
		query.append("      ,'' D_12" ).append("\n"); 
		query.append("      ,'' D_13" ).append("\n"); 
		query.append("      ,'' D_14" ).append("\n"); 
		query.append("      ,'' D_15" ).append("\n"); 
		query.append("      ,'' D_16" ).append("\n"); 
		query.append("      ,'' D_17" ).append("\n"); 
		query.append("      ,'' D_18" ).append("\n"); 
		query.append("      ,'' D_19" ).append("\n"); 
		query.append("      ,'' D_20" ).append("\n"); 
		query.append("      ,'' D_21" ).append("\n"); 
		query.append("      ,'' D_22" ).append("\n"); 
		query.append("      ,'' D_23" ).append("\n"); 
		query.append("      ,'' D_24" ).append("\n"); 
		query.append("      ,'' D_25" ).append("\n"); 
		query.append("      ,'' D_26" ).append("\n"); 
		query.append("      ,'' D_27" ).append("\n"); 
		query.append("      ,'' D_28" ).append("\n"); 
		query.append("      ,'' PK_TP" ).append("\n"); 
		query.append("      ,'' VVD_SIG" ).append("\n"); 
		query.append("      ,'' COA_YEAR" ).append("\n"); 
		query.append("      ,'' FROM_WK" ).append("\n"); 
		query.append("      ,'' TO_WK" ).append("\n"); 
		query.append("      ,'' TRADE" ).append("\n"); 
		query.append("      ,'' S_TRADE" ).append("\n"); 
		query.append("      ,'' OB_SLS_OFC_CD" ).append("\n"); 
		query.append("      ,'' OB_SLS_OFC_SUB" ).append("\n"); 
		query.append("      ,'' OB_SREP_CD" ).append("\n"); 
		query.append("      ,'' BKG_OFC_CD" ).append("\n"); 
		query.append("      ,'' BKG_OFC_SUB" ).append("\n"); 
		query.append("      ,'' CUST_CD" ).append("\n"); 
		query.append("      ,'' DIS_OP" ).append("\n"); 
		query.append("      ,'' DIS_VAL" ).append("\n"); 
		query.append("      ,'' UNIT_OP" ).append("\n"); 
		query.append("      ,'' CM_CUR" ).append("\n"); 
		query.append("      ,'' DIS_DAYS" ).append("\n"); 
		query.append("      ,'' SEL_OP" ).append("\n"); 
		query.append("      ,'' GRP_OP" ).append("\n"); 
		query.append("	  ,'' BKG_CXL_FR_DT" ).append("\n"); 
		query.append("	  ,'' BKG_CXL_TO_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-----------------------" ).append("\n"); 
		query.append("	  ,'' CHK_CXL_BKG_ONLY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  ,'' BKG_STS_CD" ).append("\n"); 
		query.append("      ,'' VVD_SLAN_CD" ).append("\n"); 
		query.append("      ,'' BKG_CRE_DT" ).append("\n"); 
		query.append("	  ,'' BKG_CRE_WK" ).append("\n"); 
		query.append("	  ,'' BKG_CXL_DT" ).append("\n"); 
		query.append("	  ,'' BKG_CXL_WK" ).append("\n"); 
		query.append("	  ,'' CMDT_CD" ).append("\n"); 
		query.append("      ,'' CMDT_NM" ).append("\n"); 
		query.append("      ,'' INTER_RMK" ).append("\n"); 
		query.append("      ,'' XTER_RMK" ).append("\n"); 
		query.append("      ,'' C_TEU" ).append("\n"); 
		query.append("      ,'' C_FEU" ).append("\n"); 
		query.append("      ,'' BKG_NO" ).append("\n"); 
		query.append("	  ,'' TRNK_VVD_CD" ).append("\n"); 
		query.append(" 	  ,'' CNTR_TP_SZ" ).append("\n"); 
		query.append("	  ,'' POL_ETD_FR_DT" ).append("\n"); 
		query.append("	  ,'' POL_ETD_TO_DT	" ).append("\n"); 
		query.append("	  ,'' SEL_SLAN_CD" ).append("\n"); 
		query.append("	  ,'' SEL_VVD" ).append("\n"); 
		query.append("	  ,'' SEL_POL_CD" ).append("\n"); 
		query.append("	  ,'' SEL_ETD_DT" ).append("\n"); 
		query.append("	  ,'' SEL_COST_WK" ).append("\n"); 
		query.append("	  ,'' SEL_OB_SREP_CD" ).append("\n"); 
		query.append("	  ,'' SEL_CUST_CD" ).append("\n"); 
		query.append("	  ,'' OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	  ,'' S_BKG_OFC_CD" ).append("\n"); 
		query.append("	  ,'' SC_NO" ).append("\n"); 
		query.append("	  ,'' RFA_NO" ).append("\n"); 
		query.append("  	  ,'' TAA_NO" ).append("\n"); 
		query.append("      ,'' TRD_CD" ).append("\n"); 
		query.append("      ,'' SUB_TRD_CD" ).append("\n"); 
		query.append("      ,'' RLANE_CD     " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WITH BKG_VVD_DATE AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT  B.BKG_NO" ).append("\n"); 
		query.append("         , DRL.TRD_CD" ).append("\n"); 
		query.append("         , DRL.SUB_TRD_CD" ).append("\n"); 
		query.append("         , DRL.RLANE_CD" ).append("\n"); 
		query.append("         , M.VSL_CD " ).append("\n"); 
		query.append("         , M.SKD_VOY_NO " ).append("\n"); 
		query.append("         , M.SKD_DIR_CD " ).append("\n"); 
		query.append("   FROM    BKG_VVD BV" ).append("\n"); 
		query.append("         , BKG_BOOKING B" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("            SELECT V.TRD_CD" ).append("\n"); 
		query.append("                     , V.SUB_TRD_CD" ).append("\n"); 
		query.append("                     , V.RLANE_CD" ).append("\n"); 
		query.append("                     , V.DIR_CD" ).append("\n"); 
		query.append("                     , V.VSL_CD" ).append("\n"); 
		query.append("                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V.DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V.IOC_CD" ).append("\n"); 
		query.append("            FROM    MDM_REV_LANE RL" ).append("\n"); 
		query.append("                   , MAS_MON_VVD V" ).append("\n"); 
		query.append("            WHERE   RL.RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("            AND     V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           ) M" ).append("\n"); 
		query.append("         , MDM_DTL_REV_LANE DRL" ).append("\n"); 
		query.append("         , MDM_REV_LANE RL" ).append("\n"); 
		query.append("   WHERE   B.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("   AND     M.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("   AND     M.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND     M.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND     RL.VSL_SLAN_CD = BV.SLAN_CD" ).append("\n"); 
		query.append("   AND     DRL.RLANE_CD = RL.RLANE_CD" ).append("\n"); 
		query.append("   AND     DRL.RLANE_CD = M.RLANE_CD" ).append("\n"); 
		query.append("   AND     DRL.VSL_SLAN_DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("   AND     DRL.IOC_CD = M.IOC_CD" ).append("\n"); 
		query.append("   AND     DRL.TRD_CD = M.TRD_CD" ).append("\n"); 
		query.append("   AND     DRL.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND     DRL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND     DRL.FM_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, M.DIR_CD) FROM MDM_LOCATION L WHERE L.LOC_CD = BV.POL_CD )" ).append("\n"); 
		query.append("   AND     DRL.TO_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, M.DIR_CD) FROM MDM_LOCATION L WHERE L.LOC_CD = BV.POD_CD )" ).append("\n"); 
		query.append("   AND     RL.RLANE_CD = M.RLANE_CD" ).append("\n"); 
		query.append("   AND     RL.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND     RL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("), TEMP_T AS (" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT distinct BK.BKG_NO" ).append("\n"); 
		query.append("	  ,GIJUN.VSL_CD || GIJUN.SKD_VOY_NO || GIJUN.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("      ,GIJUN.VSL_CD" ).append("\n"); 
		query.append("      ,GIJUN.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,GIJUN.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,GIJUN.SLAN_CD" ).append("\n"); 
		query.append("      ,GIJUN.POL_CD" ).append("\n"); 
		query.append("      ,GIJUN.POD_CD" ).append("\n"); 
		query.append("	  ,TO_CHAR(GIJUN.VPS_ETD_DT,'MM/DD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(GIJUN.VPS_ETD_DT,'WW') AS COST_WK" ).append("\n"); 
		query.append("      ,GIJUN.VPS_ETD_WK" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,BK.OB_SREP_CD" ).append("\n"); 
		query.append("      ,BC.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,BC.CUST_SEQ" ).append("\n"); 
		query.append("      ,BC.CUST_CNT_CD || LPAD(BC.CUST_SEQ, 6,'0') AS CUST_CD" ).append("\n"); 
		query.append("      ,MC.CUST_LGL_ENG_NM AS CUST_NM " ).append("\n"); 
		query.append("      ,MC.CUST_STS_CD" ).append("\n"); 
		query.append("      ,XDT.BY_SEQ" ).append("\n"); 
		query.append("      ,XDT.BY_DT" ).append("\n"); 
		query.append("	  ,BK.BKG_CRE_DT" ).append("\n"); 
		query.append("      ,BB.TRD_CD" ).append("\n"); 
		query.append("      ,BB.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,BB.RLANE_CD      " ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER BC  " ).append("\n"); 
		query.append("      ,MDM_CUSTOMER MC " ).append("\n"); 
		query.append("      ,(SELECT ROWNUM BY_SEQ, sysdate - ROWNUM + 1 AS BY_DT" ).append("\n"); 
		query.append("       FROM   DUAL" ).append("\n"); 
		query.append("       CONNECT BY LEVEL <= 29) XDT " ).append("\n"); 
		query.append("      ,(SELECT  " ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("	/*+ Rule */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				BK.BKG_NO" ).append("\n"); 
		query.append("                ,VVD.SLAN_CD" ).append("\n"); 
		query.append("        		,VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("				,VVD.VSL_CD" ).append("\n"); 
		query.append("        		,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        		,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("				,VVD.POL_CD" ).append("\n"); 
		query.append("				,VVD.POD_CD" ).append("\n"); 
		query.append("        		,SKD.VPS_ETD_DT VPS_ETD_DT" ).append("\n"); 
		query.append("        		,TO_CHAR(SKD.VPS_ETD_DT,'WW') VPS_ETD_WK" ).append("\n"); 
		query.append("    	FROM VSK_VSL_PORT_SKD SKD, BKG_VVD VVD" ).append("\n"); 
		query.append("    	,    BKG_BOOKING BK" ).append("\n"); 
		query.append("    	" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,(SELECT COLUMN_VALUE AS VVD_CD FROM table(BKG_SPLIT_FNC(@[vvd],','))) TEMP " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("    	AND   VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("    	AND   VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ =   (SELECT MIN(BV.VSL_PRE_PST_CD || BV.VSL_SEQ) " ).append("\n"); 
		query.append("                                                  	FROM   BKG_VVD BV" ).append("\n"); 
		query.append("                                                  	WHERE  BV.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("		AND  SKD.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("        AND  SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("        AND  SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND  SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND  SKD.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		AND VVD.BKG_NO = BK.BKG_NO     " ).append("\n"); 
		query.append("        AND VVD.POL_CD = BK.POL_CD " ).append("\n"); 
		query.append("        AND BK.BKG_CGO_TP_CD = 'F' " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		#if (${chk_cxl_bkg_only} == 'Y') " ).append("\n"); 
		query.append("			AND BK.BKG_STS_CD  = 'X'" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			AND BK.BKG_STS_CD  <> 'X'  " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	  " ).append("\n"); 
		query.append("#if (${pol_etd_fr_dt} != ''  ) " ).append("\n"); 
		query.append("		#if (${pol_etd_fr_dt} != '')" ).append("\n"); 
		query.append("		   AND SKD.VPS_ETD_DT >=  TO_DATE(@[pol_etd_fr_dt],'YYYY-MM-DD' )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pol_etd_to_dt} != '')" ).append("\n"); 
		query.append("		   AND SKD.VPS_ETD_DT <=  TO_DATE(@[pol_etd_to_dt],'YYYY-MM-DD' ) + 0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("#if (${bkg_cxl_fr_dt} != '')" ).append("\n"); 
		query.append("      	  #if (${bkg_cxl_fr_dt} != '') " ).append("\n"); 
		query.append("		   AND BK.BKG_CXL_DT >= TO_DATE(@[bkg_cxl_fr_dt],'YYYY-MM-DD' )" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("		  #if (${bkg_cxl_to_dt} != '') " ).append("\n"); 
		query.append("           AND BK.BKG_CXL_DT <= TO_DATE(@[bkg_cxl_to_dt],'YYYY-MM-DD' ) + 0.99999" ).append("\n"); 
		query.append("          #end    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("          AND VVD.VSL_CD    =  SUBSTR(TEMP.VVD_CD,1,4)    " ).append("\n"); 
		query.append("      	  AND VVD.SKD_VOY_NO = SUBSTR(TEMP.VVD_CD,5,4)" ).append("\n"); 
		query.append("      	  AND VVD.SKD_DIR_CD = SUBSTR(TEMP.VVD_CD,9,1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  --AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("           AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) GIJUN" ).append("\n"); 
		query.append("        , BKG_VVD_DATE BB" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    GIJUN.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND    NVL(BK.BL_NO_TP, 'M') IN ('0', 'M')" ).append("\n"); 
		query.append("AND    BK.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BC.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND    BC.CUST_CNT_CD = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    BC.CUST_SEQ    = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    GIJUN.BKG_NO = BB.BKG_NO(+)" ).append("\n"); 
		query.append("AND    GIJUN.VSL_CD = BB.VSL_CD(+)" ).append("\n"); 
		query.append("AND    GIJUN.SKD_VOY_NO = BB.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    GIJUN.SKD_DIR_CD = BB.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND exists (SELECT 'X' " ).append("\n"); 
		query.append("			FROM BKG_VVD BV " ).append("\n"); 
		query.append("			WHERE BV.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("			AND BV.VSL_PRE_PST_CD = 'T' " ).append("\n"); 
		query.append("			AND TRIM(BV.POD_CD) = @[pod_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '' && ${bkg_ofc_sub} == '')" ).append("\n"); 
		query.append("AND    BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${bkg_ofc_cd} != '' && ${bkg_ofc_sub} != '')" ).append("\n"); 
		query.append("AND    BK.BKG_OFC_CD IN (SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                           FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                          WHERE @[bkg_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                  OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '' && ${ob_sls_ofc_sub} == '')" ).append("\n"); 
		query.append("AND    BK.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ob_sls_ofc_cd} != '' && ${ob_sls_ofc_sub} != '')" ).append("\n"); 
		query.append("AND    BK.OB_SLS_OFC_CD IN (SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                              FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                             WHERE @[ob_sls_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                        OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("AND    BK.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '' && ${ctrt_ofc_sub} == '')" ).append("\n"); 
		query.append("AND    BK.CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ctrt_ofc_cd} != '' && ${ctrt_ofc_sub} != '')" ).append("\n"); 
		query.append("AND    BK.CTRT_OFC_CD IN (SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                              FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                             WHERE @[ctrt_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                        OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${ctrt_srep_cd} != '')" ).append("\n"); 
		query.append("AND    BK.CTRT_SREP_CD = @[ctrt_srep_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cd} != '')" ).append("\n"); 
		query.append("AND BC.CUST_CNT_CD || BC.CUST_SEQ = SUBSTR(@[cust_cd],1,2)||TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT X.VSL_CD || X.SKD_VOY_NO || X.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,X.SLAN_CD" ).append("\n"); 
		query.append("      ,X.POL_CD" ).append("\n"); 
		query.append("      ,X.VPS_ETD_DT AS ETD_DT" ).append("\n"); 
		query.append("      ,X.COST_WK" ).append("\n"); 
		query.append("#if (${sel_op} != '')" ).append("\n"); 
		query.append("      ${sel_op}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,X.TRD_CD" ).append("\n"); 
		query.append("      ,X.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,X.RLANE_CD" ).append("\n"); 
		query.append("	  ,SUM(DECODE(X.BY_SEQ,1,X.N_TEU,0)) AS LOAD" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,2,X.C_TEU,0)) AS D_1" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,3,X.C_TEU,0)) AS D_2" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,4,X.C_TEU,0)) AS D_3" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,5,X.C_TEU,0)) AS D_4" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,6,X.C_TEU,0)) AS D_5" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,7,X.C_TEU,0)) AS D_6" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,8,X.C_TEU,0)) AS D_7" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,9,X.C_TEU,0)) AS D_8" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,10,X.C_TEU,0)) AS D_9" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,11,X.C_TEU,0)) AS D_10" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,12,X.C_TEU,0)) AS D_11" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,13,X.C_TEU,0)) AS D_12" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,14,X.C_TEU,0)) AS D_13" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,15,X.C_TEU,0)) AS D_14" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,16,X.C_TEU,0)) AS D_15" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,17,X.C_TEU,0)) AS D_16" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,18,X.C_TEU,0)) AS D_17" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,19,X.C_TEU,0)) AS D_18" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,20,X.C_TEU,0)) AS D_19" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,21,X.C_TEU,0)) AS D_20" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,22,X.C_TEU,0)) AS D_21" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,23,X.C_TEU,0)) AS D_22" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,24,X.C_TEU,0)) AS D_23" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,25,X.C_TEU,0)) AS D_24" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,26,X.C_TEU,0)) AS D_25" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,27,X.C_TEU,0)) AS D_26" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,28,X.C_TEU,0)) AS D_27" ).append("\n"); 
		query.append("      ,SUM(DECODE(X.BY_SEQ,29,X.C_TEU,0)) AS D_28 " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("        SELECT T.BKG_NO" ).append("\n"); 
		query.append("              ,T.VVD_CD" ).append("\n"); 
		query.append("              ,T.SLAN_CD" ).append("\n"); 
		query.append("              ,T.VSL_CD              " ).append("\n"); 
		query.append("              ,T.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,T.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,T.POL_CD" ).append("\n"); 
		query.append("              --,T.VPS_ETA_DT" ).append("\n"); 
		query.append("              ,T.VPS_ETD_DT" ).append("\n"); 
		query.append("			  ,T.COST_WK" ).append("\n"); 
		query.append("              ,T.OB_SREP_CD" ).append("\n"); 
		query.append("              ,T.CUST_CNT_CD" ).append("\n"); 
		query.append("              ,T.CUST_SEQ" ).append("\n"); 
		query.append("              ,T.CUST_CD" ).append("\n"); 
		query.append("              ,T.CUST_NM" ).append("\n"); 
		query.append("              ,T.CUST_STS_CD" ).append("\n"); 
		query.append("              ,T.BY_SEQ" ).append("\n"); 
		query.append("              ,T.BY_DT" ).append("\n"); 
		query.append("			  ,TO_DATE(TO_CHAR(T.BY_DT,'YYYYMMDD'),'YYYYMMDD')-TO_DATE(TO_CHAR(T.BKG_CRE_DT,'YYYYMMDD'),'YYYYMMDD') AS D_CNT" ).append("\n"); 
		query.append("			  ,(SELECT SUM(((NVL(BKG_OFT_REV,0)+NVL(BKG_MISC_REV,0)+NVL(SCR_CHG_REV,0)+NVL(BKG_REV,0)) - NVL(ESTM_CM_COST_AMT,0)) * DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2','2',1)) FROM MAS_BKG_REV_DTL WHERE T.bkg_NO =BKG_NO) CM" ).append("\n"); 
		query.append("			 -- ,(SELECT SUM(((NVL(BKG_OFT_REV,0)+NVL(BKG_MISC_REV,0)+NVL(SCR_CHG_REV,0)+NVL(BKG_REV,0)) - NVL(ESTM_CM_COST_AMT,0)) * DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',1,1)) FROM MAS_BKG_REV_DTL WHERE T.bkg_NO =BKG_NO) CM" ).append("\n"); 
		query.append("              ,(SELECT SUM(((BKG_OFT_REV+BKG_MISC_REV+SCR_CHG_REV+BKG_REV) - ESTM_CM_COST_AMT) * DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',${unit_op},1)) FROM MAS_BKG_REV_DTL WHERE T.bkg_NO =BKG_NO) CMPB" ).append("\n"); 
		query.append("              ,NVL((SELECT " ).append("\n"); 
		query.append("#if(${unit_op} == '2') -- TEU" ).append("\n"); 
		query.append("							NVL(SM.CNTR_TEU_QTY,0)  + (NVL(SM.CNTR_FEU_QTY,0) * ${unit_op}) " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("							NVL(SM.CNTR_TEU_QTY,0)/2  + (NVL(SM.CNTR_FEU_QTY,0)) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  FROM BKG_DPCS_PROC_SMRY SM " ).append("\n"); 
		query.append("                 WHERE SM.BKG_NO = T.BKG_NO " ).append("\n"); 
		query.append("                   AND SM.DOC_KND_STS_CD = '8'" ).append("\n"); 
		query.append("                   AND SM.BKG_DOC_DT   =  (SELECT MAX(SM2.BKG_DOC_DT) " ).append("\n"); 
		query.append("                                             FROM BKG_DPCS_PROC_SMRY SM2 " ).append("\n"); 
		query.append("                                            WHERE 1=1" ).append("\n"); 
		query.append("                                              AND SM2.BKG_NO = T.BKG_NO " ).append("\n"); 
		query.append("                                              AND SM2.DOC_KND_STS_CD = '8'" ).append("\n"); 
		query.append("                                              AND SM2.BKG_DOC_DT <= TO_CHAR(T.BY_DT,'YYYYMMDD')  )     " ).append("\n"); 
		query.append("				)," ).append("\n"); 
		query.append("#if(${unit_op} == '2') --TEU" ).append("\n"); 
		query.append("				(SELECT SUM(DECODE(SUBSTR(QT.CNTR_TPSZ_CD,-1),'2', QT.OP_CNTR_QTY , QT.OP_CNTR_QTY * ${unit_op}) )" ).append("\n"); 
		query.append("      				FROM BKG_QUANTITY QT " ).append("\n"); 
		query.append("      				WHERE 1=1" ).append("\n"); 
		query.append("      				AND   QT.BKG_NO = T.BKG_NO)                 " ).append("\n"); 
		query.append("                ) AS C_TEU," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				(SELECT SUM(DECODE(SUBSTR(QT.CNTR_TPSZ_CD,-1),'2', QT.OP_CNTR_QTY/2 , QT.OP_CNTR_QTY * ${unit_op}) )" ).append("\n"); 
		query.append("      				FROM BKG_QUANTITY QT " ).append("\n"); 
		query.append("      				WHERE 1=1" ).append("\n"); 
		query.append("      				AND   QT.BKG_NO = T.BKG_NO)                  " ).append("\n"); 
		query.append("                ) AS C_TEU," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${unit_op} == '2') -- TEU" ).append("\n"); 
		query.append("                  (SELECT SUM(DECODE(SUBSTR(QT.CNTR_TPSZ_CD,-1),'2', QT.OP_CNTR_QTY , QT.OP_CNTR_QTY * ${unit_op}) )" ).append("\n"); 
		query.append("      				FROM BKG_QUANTITY QT " ).append("\n"); 
		query.append("      				WHERE 1=1" ).append("\n"); 
		query.append("      				AND   QT.BKG_NO = T.BKG_NO) N_TEU" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                  (SELECT SUM(DECODE(SUBSTR(QT.CNTR_TPSZ_CD,-1),'2', QT.OP_CNTR_QTY/2 , QT.OP_CNTR_QTY * ${unit_op}) )" ).append("\n"); 
		query.append("      				FROM BKG_QUANTITY QT " ).append("\n"); 
		query.append("      				WHERE 1=1" ).append("\n"); 
		query.append("      				AND   QT.BKG_NO = T.BKG_NO) N_TEU" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("              ,T.TRD_CD" ).append("\n"); 
		query.append("              ,T.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,T.RLANE_CD" ).append("\n"); 
		query.append("          FROM TEMP_T T" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------    " ).append("\n"); 
		query.append(") X   " ).append("\n"); 
		query.append("WHERE X.D_CNT >= 0" ).append("\n"); 
		query.append("#if (${cm_cur} != '' && ${cm_cur} != '0' )" ).append("\n"); 
		query.append("AND X.CM > ${cm_cur}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY X.VVD_CD" ).append("\n"); 
		query.append("        ,X.SLAN_CD" ).append("\n"); 
		query.append("        ,X.VSL_CD" ).append("\n"); 
		query.append("        ,X.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,X.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,X.POL_CD" ).append("\n"); 
		query.append("        ,X.VPS_ETD_DT" ).append("\n"); 
		query.append("		,X.COST_WK" ).append("\n"); 
		query.append("        ,X.TRD_CD" ).append("\n"); 
		query.append("        ,X.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,X.RLANE_CD   " ).append("\n"); 
		query.append("#if (${grp_op} != '')" ).append("\n"); 
		query.append("      ${grp_op}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY X.SLAN_CD,X.VVD_CD,X.POL_CD,X.VPS_ETD_DT ${grp_op}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
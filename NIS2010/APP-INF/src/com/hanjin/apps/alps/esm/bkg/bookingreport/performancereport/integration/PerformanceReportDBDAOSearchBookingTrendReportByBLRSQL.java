/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBookingTrendReportByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.08 
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

public class PerformanceReportDBDAOSearchBookingTrendReportByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * 2010.10.08 김영철 [CHM-201006186-01] 
	  *   1. 조회조건으로 Contract Office및  Sales Rep.조건 추가
	  *   2. Direct Down Load(B/L Detail) List상에 Contract Office및 Contract Sales Rep. 추가반영 및 일부항목 Label수정
	  *   3. Load기준 FEU로 조회시 환산오류 수정.
	  * 2015.06.08 COA_BKG_REV_DTL ==>MAS_BKG_REV_DTL 변경
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBookingTrendReportByBLRSQL(){
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
		params.put("sel_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sel_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sel_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sel_cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cxl_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchBookingTrendReportByBLRSQL").append("\n"); 
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
		query.append("WITH TEMP_T AS (" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT GIJUN.VSL_CD || GIJUN.SKD_VOY_NO || GIJUN.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("      ,GIJUN.VSL_CD" ).append("\n"); 
		query.append("      ,GIJUN.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,GIJUN.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,BK.SLAN_CD" ).append("\n"); 
		query.append("      ,BK.POR_CD" ).append("\n"); 
		query.append("	  ,BK.POL_CD" ).append("\n"); 
		query.append("      ,BK.POD_CD" ).append("\n"); 
		query.append("      ,BK.DEL_CD" ).append("\n"); 
		query.append("      ,GIJUN.VPS_ETD_DT" ).append("\n"); 
		query.append("      ,GIJUN.VPS_ETD_WK" ).append("\n"); 
		query.append("      ,BK.BKG_NO" ).append("\n"); 
		query.append("      ,BK.BL_NO" ).append("\n"); 
		query.append("      ,BK.OB_SREP_CD" ).append("\n"); 
		query.append("      ,BC.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,BC.CUST_SEQ" ).append("\n"); 
		query.append("      ,BC.CUST_CNT_CD || LPAD(BC.CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append("      ,MC.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("      ,MC.CUST_STS_CD" ).append("\n"); 
		query.append("      ,XDT.BY_SEQ" ).append("\n"); 
		query.append("      ,XDT.BY_DT" ).append("\n"); 
		query.append("	  ,BK.BKG_CRE_DT" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER BC  " ).append("\n"); 
		query.append("      ,MDM_CUSTOMER MC " ).append("\n"); 
		query.append("      ,(SELECT ROWNUM BY_SEQ, sysdate - ROWNUM + 1 AS BY_DT" ).append("\n"); 
		query.append("       FROM   DUAL" ).append("\n"); 
		query.append("       CONNECT BY LEVEL <= 15) XDT " ).append("\n"); 
		query.append("      ,(SELECT  BK.BKG_NO" ).append("\n"); 
		query.append("                ,VVD.SLAN_CD" ).append("\n"); 
		query.append("        		,VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("				,VVD.VSL_CD" ).append("\n"); 
		query.append("        		,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        		,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("				,VVD.POL_CD" ).append("\n"); 
		query.append("				,VVD.POD_CD" ).append("\n"); 
		query.append("        		,SKD.VPS_ETD_DT VPS_ETD_DT" ).append("\n"); 
		query.append("        		,TO_CHAR(SKD.VPS_ETD_DT,'WW') VPS_ETD_WK" ).append("\n"); 
		query.append("    	FROM BKG_VVD VVD" ).append("\n"); 
		query.append("    	,    BKG_BOOKING BK" ).append("\n"); 
		query.append("    	,    VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,(SELECT COLUMN_VALUE AS VVD_CD FROM table(BKG_SPLIT_FNC(@[vvd],','))) TEMP " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("    	AND   VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		AND  SKD.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("        AND  SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("        AND  SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND  SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND  SKD.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ	" ).append("\n"); 
		query.append("    	AND  VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ =   (SELECT MIN(BV.VSL_PRE_PST_CD || BV.VSL_SEQ) " ).append("\n"); 
		query.append("                                                  	FROM   BKG_VVD BV" ).append("\n"); 
		query.append("                                                  	WHERE  BV.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("        AND BK.BKG_CGO_TP_CD = 'F' " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${chk_cxl_bkg_only} == 'Y') " ).append("\n"); 
		query.append("			AND BK.BKG_STS_CD  = 'X'" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			AND BK.BKG_STS_CD  <> 'X'  " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_etd_fr_dt} != ''  ) " ).append("\n"); 
		query.append("		#if (${pol_etd_fr_dt} != '')" ).append("\n"); 
		query.append("		   AND SKD.VPS_ETD_DT >=  TO_DATE(@[pol_etd_fr_dt],'YYYY-MM-DD' )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pol_etd_to_dt} != '')" ).append("\n"); 
		query.append("		   AND SKD.VPS_ETD_DT <=  TO_DATE(@[pol_etd_to_dt],'YYYY-MM-DD' )+ 0.99999" ).append("\n"); 
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
		query.append("          #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND VVD.VSL_CD    =  SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("		   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sel_vvd} != '')" ).append("\n"); 
		query.append("           AND VVD.VSL_CD    =  SUBSTR(@[sel_vvd],1,4) " ).append("\n"); 
		query.append("		   AND VVD.SKD_VOY_NO = SUBSTR(@[sel_vvd],5,4)" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = SUBSTR(@[sel_vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("         AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sel_pol_cd} != '')" ).append("\n"); 
		query.append("         AND VVD.POL_CD = @[sel_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("#if (${sel_slan_cd} != '')" ).append("\n"); 
		query.append("		 AND BK.SLAN_CD = @[sel_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) GIJUN" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    GIJUN.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND    NVL(BK.BL_NO_TP, 'M') IN ('0', 'M')" ).append("\n"); 
		query.append("AND    BK.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BC.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND    BC.CUST_CNT_CD = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    BC.CUST_SEQ    = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND exists (SELECT 'X' " ).append("\n"); 
		query.append("			FROM BKG_VVD BV " ).append("\n"); 
		query.append("			WHERE BV.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("			AND BV.VSL_PRE_PST_CD = 'T' " ).append("\n"); 
		query.append("			AND TRIM(BV.POD_CD) = @[pod_cd])" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("AND    BK.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${sel_ob_srep_cd} != '')" ).append("\n"); 
		query.append("AND    BK.OB_SREP_CD = @[sel_ob_srep_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cust_cd} != '')" ).append("\n"); 
		query.append("AND    BC.CUST_CNT_CD || LPAD(BC.CUST_SEQ, 6, '0') = @[cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_cust_cd} != '')" ).append("\n"); 
		query.append("AND    BC.CUST_CNT_CD || LPAD(BC.CUST_SEQ, 6, '0') = @[sel_cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_etd_dt} != '')" ).append("\n"); 
		query.append("AND  TO_CHAR(GIJUN.VPS_ETD_DT,'MM/DD') =@[sel_etd_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_cost_wk} != '')" ).append("\n"); 
		query.append("AND  TO_CHAR(GIJUN.VPS_ETD_DT,'WW') =@[sel_cost_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT X.VVD_CD AS VVD" ).append("\n"); 
		query.append("      ,X.BL_NO" ).append("\n"); 
		query.append("      ,X.POR_CD" ).append("\n"); 
		query.append("      ,X.POL_CD" ).append("\n"); 
		query.append("      ,X.POD_CD" ).append("\n"); 
		query.append("      ,X.DEL_CD" ).append("\n"); 
		query.append("      ,X.OB_SREP_CD" ).append("\n"); 
		query.append("      ,X.CUST_CD" ).append("\n"); 
		query.append("      ,REPLACE(X.CUST_NM,CHR(13) || CHR(10),' ') AS CUST_NM" ).append("\n"); 
		query.append("      ,TRUNC(SUM(DECODE(X.BY_SEQ,1,X.N_TEU,0)),1) AS LOAD" ).append("\n"); 
		query.append("	  ,TRUNC(X.CM) AS CM" ).append("\n"); 
		query.append("	  ,TRUNC(X.CMPB/SUM(DECODE(X.BY_SEQ,1,NVL(X.C_TEU,0),0))) AS CMPB" ).append("\n"); 
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
		query.append("FROM (" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("        SELECT T.BKG_NO" ).append("\n"); 
		query.append("              ,T.BL_NO" ).append("\n"); 
		query.append("              ,T.VVD_CD" ).append("\n"); 
		query.append("              ,T.SLAN_CD" ).append("\n"); 
		query.append("              ,T.VSL_CD              " ).append("\n"); 
		query.append("              ,T.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,T.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,T.POR_CD" ).append("\n"); 
		query.append("              ,T.POL_CD" ).append("\n"); 
		query.append("              ,T.POD_CD" ).append("\n"); 
		query.append("              ,T.DEL_CD" ).append("\n"); 
		query.append("             -- ,T.VPS_ETA_DT" ).append("\n"); 
		query.append("              ,T.VPS_ETD_DT" ).append("\n"); 
		query.append("              ,T.OB_SREP_CD" ).append("\n"); 
		query.append("              ,T.CUST_CNT_CD" ).append("\n"); 
		query.append("              ,T.CUST_SEQ" ).append("\n"); 
		query.append("              ,T.CUST_CD" ).append("\n"); 
		query.append("              ,T.CUST_NM" ).append("\n"); 
		query.append("              ,T.CUST_STS_CD" ).append("\n"); 
		query.append("              ,T.BY_SEQ" ).append("\n"); 
		query.append("              ,T.BY_DT" ).append("\n"); 
		query.append("			  ,TO_DATE(TO_CHAR(T.BY_DT, 'YYYYMMDD'), 'YYYYMMDD')-TO_DATE(TO_CHAR(T.BKG_CRE_DT, 'YYYYMMDD'), 'YYYYMMDD') AS D_CNT" ).append("\n"); 
		query.append("              ,(SELECT SUM(((NVL(BKG_OFT_REV,0)+NVL(BKG_MISC_REV,0)+NVL(SCR_CHG_REV,0)+NVL(BKG_REV,0)) - NVL(ESTM_CM_COST_AMT,0)) * DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',${unit_op},1)) FROM MAS_BKG_REV_DTL WHERE T.bkg_NO =BKG_NO) CM" ).append("\n"); 
		query.append("              ,(SELECT SUM(((NVL(BKG_OFT_REV,0)+NVL(BKG_MISC_REV,0)+NVL(SCR_CHG_REV,0)+NVL(BKG_REV,0)) - NVL(ESTM_CM_COST_AMT,0)) * DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',${unit_op},1)) FROM MAS_BKG_REV_DTL WHERE T.bkg_NO =BKG_NO) CMPB" ).append("\n"); 
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
		query.append("                            " ).append("\n"); 
		query.append("          FROM TEMP_T T" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------    " ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE X.D_CNT >= 0   " ).append("\n"); 
		query.append("GROUP BY X.VVD_CD" ).append("\n"); 
		query.append("        ,X.BL_NO" ).append("\n"); 
		query.append("        ,X.POR_CD" ).append("\n"); 
		query.append("        ,X.POL_CD" ).append("\n"); 
		query.append("        ,X.POD_CD" ).append("\n"); 
		query.append("        ,X.DEL_CD" ).append("\n"); 
		query.append("        ,X.OB_SREP_CD" ).append("\n"); 
		query.append("        ,X.CUST_CD" ).append("\n"); 
		query.append("        ,X.CUST_NM" ).append("\n"); 
		query.append("        ,X.CUST_STS_CD" ).append("\n"); 
		query.append("        ,x.CM" ).append("\n"); 
		query.append("        ,X.CMPB" ).append("\n"); 
		query.append("		--,X.C_TEU" ).append("\n"); 
		query.append("ORDER BY X.VVD_CD,X.POL_CD,X.OB_SREP_CD,X.CUST_CD,X.CUST_STS_CD" ).append("\n"); 

	}
}
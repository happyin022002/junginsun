/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBookingTrendDetailReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.29 
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

public class PerformanceReportDBDAOSearchBookingTrendDetailReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Daily Booking Trend by Customer Detail
	  * 2010.10.08 김영철 [CHM-201006186-01] 
	  *   1. 조회조건으로 Contract Office및  Sales Rep.조건 추가
	  *   2. Direct Down Load(B/L Detail) List상에 Contract Office및 Contract Sales Rep. 추가반영 및 일부항목 Label수정
	  *   3. Load기준 FEU로 조회시 환산오류 수정.
	  * 2015.06.08 COA_BKG_REV_DTL ==>MAS_BKG_REV_DTL 변경
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBookingTrendDetailReportVORSQL(){
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
		query.append("FileName : PerformanceReportDBDAOSearchBookingTrendDetailReportVORSQL").append("\n"); 
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
		query.append("        ,GIJUN.VSL_CD" ).append("\n"); 
		query.append("        ,GIJUN.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,GIJUN.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,GIJUN.SLAN_CD AS VVD_SLAN_CD" ).append("\n"); 
		query.append("	    ,BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD AS TRNK_VVD_CD" ).append("\n"); 
		query.append("        ,BK.SLAN_CD" ).append("\n"); 
		query.append("        ,BK.POR_CD" ).append("\n"); 
		query.append("        ,BK.POL_CD" ).append("\n"); 
		query.append("        ,BK.POD_CD" ).append("\n"); 
		query.append("        ,BV.POD_CD POD_CD_TRUNK" ).append("\n"); 
		query.append("        ,BK.DEL_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(GIJUN.VPS_ETD_DT,'YYYY-MM-DD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("        ,GIJUN.VPS_ETD_WK" ).append("\n"); 
		query.append("        ,BK.BKG_NO" ).append("\n"); 
		query.append("        ,BK.BL_NO" ).append("\n"); 
		query.append("        ,BK.BKG_STS_CD   ---" ).append("\n"); 
		query.append("        ,BC.CUST_CNT_CD" ).append("\n"); 
		query.append("        ,BC.CUST_SEQ" ).append("\n"); 
		query.append("        ,BC.CUST_CNT_CD || LPAD(BC.CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append("        ,MC.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("        ,MC.CUST_STS_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(BK.BKG_CRE_DT,'YYYY-MM-DD') AS BKG_CRE_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(BK.BKG_CRE_DT,'WW') BKG_CRE_WK" ).append("\n"); 
		query.append("        ,TO_CHAR(BK.BKG_CXL_DT,'YYYY-MM-DD') AS BKG_CXL_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(BK.BKG_CXL_DT,'WW') BKG_CXL_WK" ).append("\n"); 
		query.append("        ,BK.OB_SREP_CD" ).append("\n"); 
		query.append("		,BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("		,BK.BKG_OFC_CD " ).append("\n"); 
		query.append("		,BK.SC_NO" ).append("\n"); 
		query.append("		,BK.RFA_NO" ).append("\n"); 
		query.append("		,BK.TAA_NO" ).append("\n"); 
		query.append("		,BK.CTRT_OFC_CD" ).append("\n"); 
		query.append("		,BK.CTRT_SREP_CD" ).append("\n"); 
		query.append("        ,BK.CMDT_CD" ).append("\n"); 
		query.append("        ,(SELECT MC.CMDT_NM FROM MDM_COMMODITY MC WHERE MC.CMDT_CD = BK.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("        ,BK.INTER_RMK" ).append("\n"); 
		query.append("        ,BK.XTER_RMK" ).append("\n"); 
		query.append("        ,(SELECT SUM(((NVL(BKG_OFT_REV,0)+NVL(BKG_MISC_REV,0)+NVL(SCR_CHG_REV,0)+NVL(BKG_REV,0)) - NVL(ESTM_CM_COST_AMT,0)) * DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',2,1)) FROM MAS_BKG_REV_DTL WHERE BK.bkg_NO =BKG_NO) CM" ).append("\n"); 
		query.append("        ,(SELECT SUM(DECODE(SUBSTR(QT.CNTR_TPSZ_CD,-1),'2', QT.OP_CNTR_QTY ,0 ))" ).append("\n"); 
		query.append("        FROM BKG_QUANTITY QT " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND   QT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("        ) AS C_TEU" ).append("\n"); 
		query.append("        ,(SELECT SUM(DECODE(SUBSTR(QT.CNTR_TPSZ_CD,-1),'2', 0, QT.OP_CNTR_QTY  ))" ).append("\n"); 
		query.append("        FROM BKG_QUANTITY QT" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND   QT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("        ) AS C_FEU" ).append("\n"); 
		query.append("		,bkg_join_fnc(CURSOR(SELECT  QT.CNTR_TPSZ_CD || '-' || QT.OP_CNTR_QTY" ).append("\n"); 
		query.append("		FROM BKG_QUANTITY QT" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("		AND   QT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		)) AS CNTR_TP_SZ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append(",BKG_CUSTOMER BC" ).append("\n"); 
		query.append(",MDM_CUSTOMER MC" ).append("\n"); 
		query.append(",BKG_VVD      BV" ).append("\n"); 
		query.append(",(SELECT  " ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,(SELECT COLUMN_VALUE AS VVD_CD FROM table(BKG_SPLIT_FNC(@[vvd],','))) TEMP " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("    	AND   VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("    	AND   VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ =   (SELECT MIN(BV.VSL_PRE_PST_CD || BV.VSL_SEQ) " ).append("\n"); 
		query.append("                                                  	FROM   BKG_VVD BV" ).append("\n"); 
		query.append("                                                  	WHERE  BV.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("        AND BK.BKG_CGO_TP_CD = 'F' " ).append("\n"); 
		query.append("		AND  SKD.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("        AND  SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("        AND  SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND  SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND  SKD.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		AND VVD.BKG_NO = BK.BKG_NO     " ).append("\n"); 
		query.append("        AND VVD.POL_CD = BK.POL_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${chk_cxl_bkg_only} == 'Y') " ).append("\n"); 
		query.append("		AND BK.BKG_STS_CD  = 'X'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	  " ).append("\n"); 
		query.append("#if (${pol_etd_fr_dt} != ''  ) " ).append("\n"); 
		query.append("		#if (${pol_etd_fr_dt} != '')" ).append("\n"); 
		query.append("		   AND SKD.VPS_ETD_DT >=  TO_DATE(@[pol_etd_fr_dt],'YYYY-MM-DD' )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pol_etd_to_dt} != '')" ).append("\n"); 
		query.append("		   AND SKD.VPS_ETD_DT <=  TO_DATE(@[pol_etd_to_dt],'YYYY-MM-DD' ) +0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("#end            " ).append("\n"); 
		query.append("#if (${bkg_cxl_fr_dt} != '')" ).append("\n"); 
		query.append("      	  #if (${bkg_cxl_fr_dt} != '') " ).append("\n"); 
		query.append("		   AND BK.BKG_CXL_DT >= TO_DATE(@[bkg_cxl_fr_dt],'YYYY-MM-DD' )          " ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("		  #if (${bkg_cxl_to_dt} != '') " ).append("\n"); 
		query.append("           AND BK.BKG_CXL_DT <= TO_DATE(@[bkg_cxl_to_dt],'YYYY-MM-DD' ) + 0.99999" ).append("\n"); 
		query.append("          #end    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("          AND VVD.VSL_CD    =  SUBSTR(TEMP.VVD_CD,1,4)    " ).append("\n"); 
		query.append("      	  AND VVD.SKD_VOY_NO = SUBSTR(TEMP.VVD_CD,5,4)" ).append("\n"); 
		query.append("      	  AND VVD.SKD_DIR_CD = SUBSTR(TEMP.VVD_CD,9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("          AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") GIJUN" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    GIJUN.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND    NVL(BK.BL_NO_TP, 'M') IN ('0', 'M')" ).append("\n"); 
		query.append("AND    BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND    BC.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND    BC.CUST_CNT_CD = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    BC.CUST_SEQ    = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    BK.BKG_NO      = BV.BKG_NO" ).append("\n"); 
		query.append("AND    BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("          AND TRIM(BV.POD_CD) = @[pod_cd]" ).append("\n"); 
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
		query.append("#if (${ctrt_ofc_cd} != '' && ${ctrt_ofc_sub} == '')" ).append("\n"); 
		query.append("AND    BK.CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ctrt_ofc_cd} != '' && ${ctrt_ofc_sub} != '')" ).append("\n"); 
		query.append("AND    BK.CTRT_OFC_CD IN (SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                              FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                             WHERE @[ctrt_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                        OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${ctrt_srep_cd} != '')" ).append("\n"); 
		query.append("AND    BK.ctrt_SREP_CD = @[ctrt_srep_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cd} != '')" ).append("\n"); 
		query.append("AND BC.CUST_CNT_CD || BC.CUST_SEQ = SUBSTR(@[cust_cd],1,2)||TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT T.BKG_NO" ).append("\n"); 
		query.append("    ,T.BL_NO" ).append("\n"); 
		query.append("    ,T.BKG_STS_CD" ).append("\n"); 
		query.append("    ,T.VVD_CD AS VVD" ).append("\n"); 
		query.append("    ,T.TRNK_VVD_CD" ).append("\n"); 
		query.append("    ,T.SLAN_CD" ).append("\n"); 
		query.append("    ,T.VVD_SLAN_CD" ).append("\n"); 
		query.append("    ,T.VSL_CD" ).append("\n"); 
		query.append("    ,T.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,T.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,T.POR_CD" ).append("\n"); 
		query.append("    ,T.POL_CD" ).append("\n"); 
		query.append("    ,T.POD_CD" ).append("\n"); 
		query.append("    ,T.DEL_CD" ).append("\n"); 
		query.append("    ,T.POD_CD_TRUNK" ).append("\n"); 
		query.append("    ,T.VPS_ETD_DT AS ETD_DT" ).append("\n"); 
		query.append("	,T.VPS_ETD_WK AS ETD_WK" ).append("\n"); 
		query.append("    ,T.CUST_CNT_CD" ).append("\n"); 
		query.append("    ,T.CUST_SEQ" ).append("\n"); 
		query.append("    ,T.CUST_CD" ).append("\n"); 
		query.append("    ,T.CUST_NM" ).append("\n"); 
		query.append("    ,T.CUST_STS_CD" ).append("\n"); 
		query.append("    ,T.BKG_CRE_DT" ).append("\n"); 
		query.append("    ,T.BKG_CRE_WK" ).append("\n"); 
		query.append("    ,T.BKG_CXL_DT" ).append("\n"); 
		query.append("    ,T.BKG_CXL_WK" ).append("\n"); 
		query.append("    ,T.OB_SREP_CD" ).append("\n"); 
		query.append("    ,T.CMDT_CD" ).append("\n"); 
		query.append("    ,T.CMDT_NM" ).append("\n"); 
		query.append("    ,T.INTER_RMK" ).append("\n"); 
		query.append("    ,T.XTER_RMK" ).append("\n"); 
		query.append("    ,T.CM" ).append("\n"); 
		query.append("#if(${unit_op} =='TEU')" ).append("\n"); 
		query.append("    ,(T.C_TEU + T.C_FEU*2) LOAD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	,(T.C_TEU/2 + T.C_FEU) LOAD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${unit_op} =='TEU')" ).append("\n"); 
		query.append("    ,ROUND((T.CM / (T.C_TEU + (T.C_FEU*2))),2) CMPB" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	,ROUND((T.CM / ((T.C_TEU/2) + T.C_FEU)),2) CMPB" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,T.C_TEU" ).append("\n"); 
		query.append("    ,T.C_FEU" ).append("\n"); 
		query.append("    ,T.CNTR_TP_SZ" ).append("\n"); 
		query.append("	,T.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	,T.BKG_OFC_CD AS S_BKG_OFC_CD" ).append("\n"); 
		query.append("	,T.SC_NO" ).append("\n"); 
		query.append("	,T.RFA_NO" ).append("\n"); 
		query.append("	,T.TAA_NO" ).append("\n"); 
		query.append("	,T.CTRT_OFC_CD" ).append("\n"); 
		query.append("	,T.CTRT_SREP_CD" ).append("\n"); 
		query.append("FROM TEMP_T T" ).append("\n"); 
		query.append("ORDER BY T.CMDT_NM,T.BKG_STS_CD,T.SLAN_CD,T.VPS_ETD_DT,T.VVD_CD" ).append("\n"); 

	}
}
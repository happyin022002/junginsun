/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchCntrListBkgWiseByLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchCntrListBkgWiseByLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container List by Location BKG-wise
	  * 
	  * [CHM-201110675-01] 나상보 [CIM] Land Inventory With CNTR List 화면 POL ETD 기능 보완
	  * 2011.07.11 신자영 [CHM-201112083-01] Land Inventory With CNTR List 화면의 POL, POD 컬럼 추가 요청
	  * 2012.02.08 신자영 [CHM-201216058-01] [CIM] Land Inventory with cntr list 기능 보완
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchCntrListBkgWiseByLocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_tp_cd_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plst_flr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdt_ext_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d2_payld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_tp_cd_m",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_tp_cd_h",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_use_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchCntrListBkgWiseByLocRSQL").append("\n"); 
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
		query.append("SELECT A.SUB_LOC_CD" ).append("\n"); 
		query.append("	,A.CRNT_YD_CD" ).append("\n"); 
		query.append("	,A.CNTR_NO" ).append("\n"); 
		query.append("	,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,A.LSTM_CD" ).append("\n"); 
		query.append("	,A.CNMV_STS_CD" ).append("\n"); 
		query.append("	,A.FULL_FLG" ).append("\n"); 
		query.append("	,A.AGMT_NO" ).append("\n"); 
		query.append("	,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("	,LTRIM(TO_CHAR(A.STAY_DAYS,'9,999')) STAY_DAYS" ).append("\n"); 
		query.append("	,A.BKG_NO" ).append("\n"); 
		query.append("	,A.BL_NO" ).append("\n"); 
		query.append("	,A.VVD" ).append("\n"); 
		query.append("	,A.NEXT_VVD" ).append("\n"); 
		query.append("	,A.POR_CD" ).append("\n"); 
		query.append("    ,A.POL_CD" ).append("\n"); 
		query.append("    ,A.POD_CD" ).append("\n"); 
		query.append("	,A.DEL_CD" ).append("\n"); 
		query.append("	,A.POL_ETD " ).append("\n"); 
		query.append("	#if (${view_customer} == 'Y') " ).append("\n"); 
		query.append("   	    ,A.SHPR" ).append("\n"); 
		query.append("        ,A.CNEE " ).append("\n"); 
		query.append("        ,A.NTFY" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	,A.SC_RFA_NO" ).append("\n"); 
		query.append("	,A.DE_TERM_CD" ).append("\n"); 
		query.append("	,A.RF_TP_CD" ).append("\n"); 
		query.append("	#if (${view_commodity} == 'Y')" ).append("\n"); 
		query.append("		,A.REP_CMDT_NM" ).append("\n"); 
		query.append("		,A.MK_DESC" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	#if (${cnt_cd} == 'US')" ).append("\n"); 
		query.append("		,(SELECT B.IBD_TRSP_NO" ).append("\n"); 
		query.append("		  FROM BKG_CSTMS_ADV_IBD B" ).append("\n"); 
		query.append("		  WHERE B.BL_NO=A.BL_NO" ).append("\n"); 
		query.append("		  AND   B.CNT_CD ='US') PKUP_NO		" ).append("\n"); 
		query.append("		,A.FRT_CLT_FLG" ).append("\n"); 
		query.append("		,A.OBL_RDEM_FLG" ).append("\n"); 
		query.append("		,A.CSTMS_CLR_CD CSTMS_CLR_FLG " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    ,A.LESSOR" ).append("\n"); 
		query.append("	,A.MFT_DT" ).append("\n"); 
		query.append("	,LTRIM(TO_CHAR(A.GWGT,'9,999,999')) GWGT" ).append("\n"); 
		query.append("	,LTRIM(TO_CHAR(A.PWGT,'9,999,999')) PWGT" ).append("\n"); 
		query.append("	,LTRIM(TO_CHAR(A.TWGT,'9,999,999')) TWGT" ).append("\n"); 
		query.append("    ,A.CMDT_CD" ).append("\n"); 
		query.append("    , CASE WHEN A.DTY_FREE_DT2 IS NOT NULL THEN" ).append("\n"); 
		query.append("          A.DTY_FREE_DT2" ).append("\n"); 
		query.append("      ELSE  " ).append("\n"); 
		query.append("         (SELECT  (MIN (TO_CHAR (C.FT_END_DT, 'YYYY-MM-DD')) OVER (PARTITION BY C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD, C.DMDT_CHG_LOC_DIV_CD ))" ).append("\n"); 
		query.append("          FROM DMT_CHG_CALC C" ).append("\n"); 
		query.append("          WHERE (C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO) IN (" ).append("\n"); 
		query.append("                  SELECT D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                        ,D.CNTR_NO" ).append("\n"); 
		query.append("                        ,D.CNTR_CYC_NO" ).append("\n"); 
		query.append("                  FROM DMT_CHG_BKG_CNTR D" ).append("\n"); 
		query.append("                  WHERE D.BKG_NO = A.BKG_NO )" ).append("\n"); 
		query.append("          AND  C.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("          AND C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'L', 'N', 'U')" ).append("\n"); 
		query.append("          AND (   (    C.DMDT_TRF_CD = 'DMIF'" ).append("\n"); 
		query.append("                AND C.DMDT_CHG_LOC_DIV_CD = 'POD')" ).append("\n"); 
		query.append("                OR (    C.DMDT_TRF_CD = 'CTIC'" ).append("\n"); 
		query.append("                AND C.DMDT_CHG_LOC_DIV_CD = 'DEL')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          AND ROWNUM < 2" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("     END   DTY_FREE_DT" ).append("\n"); 
		query.append("	,DECODE(A.DCGO_FLG, 'Y', A.DCGO_FLG, '') DG_FLG" ).append("\n"); 
		query.append("    ,(SELECT V.SLAN_CD" ).append("\n"); 
		query.append("      FROM BKG_VVD V " ).append("\n"); 
		query.append("      WHERE V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD = A.VVD" ).append("\n"); 
		query.append("        AND V.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("     ) LANE1" ).append("\n"); 
		query.append("    ,(SELECT V.SLAN_CD " ).append("\n"); 
		query.append("      FROM BKG_VVD V " ).append("\n"); 
		query.append("      WHERE V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD = A.NEXT_VVD" ).append("\n"); 
		query.append("        AND V.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("     ) LANE2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cnmv_sts_cd} == 'ID')" ).append("\n"); 
		query.append("       ,A.VNDR_SEQ" ).append("\n"); 
		query.append("       ,A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("       ,A.PHN_NO" ).append("\n"); 
		query.append("       ,DECODE(A.VNDR_EML2, '', A.VNDR_EML, A.VNDR_EML  ||';'|| A.VNDR_EML2) VNDR_EML" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   ,(SELECT /*+ index( B XPKBKG_CONTAINER ) */" ).append("\n"); 
		query.append("            LTRIM(TO_CHAR(B.CNTR_WGT,'9,999,999'))" ).append("\n"); 
		query.append("     FROM BKG_CONTAINER B " ).append("\n"); 
		query.append("     WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("     AND B.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 
		query.append("     ) BWGT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		A.SUB_LOC_CD" ).append("\n"); 
		query.append("		,A.CRNT_YD_CD" ).append("\n"); 
		query.append("		,A.CNTR_NO" ).append("\n"); 
		query.append("		,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,A.LSTM_CD" ).append("\n"); 
		query.append("		,A.CNMV_STS_CD" ).append("\n"); 
		query.append("		,A.FULL_FLG" ).append("\n"); 
		query.append("		,A.AGMT_NO" ).append("\n"); 
		query.append("		,A.CNMV_DT" ).append("\n"); 
		query.append("		,A.STAY_DAYS" ).append("\n"); 
		query.append("		,A.BKG_NO" ).append("\n"); 
		query.append("		,A.BL_NO" ).append("\n"); 
		query.append("		,A.VVD1 VVD" ).append("\n"); 
		query.append("		,DECODE(LENGTH(A.VVD2), 7, NULL, SUBSTR(A.VVD2,1,9)) NEXT_VVD" ).append("\n"); 
		query.append("		,A.POR_CD" ).append("\n"); 
		query.append("		,A.POL_CD" ).append("\n"); 
		query.append("		,A.POD_CD" ).append("\n"); 
		query.append("		,A.DEL_CD" ).append("\n"); 
		query.append("		 #if (${ts_cntr_behind} != '')" ).append("\n"); 
		query.append("		 ,DECODE(A.VVD2,NULL,'',(SELECT /*+ INDEX_DESC( D XPKVSK_VSL_PORT_SKD ) */ " ).append("\n"); 
		query.append("		                            	TO_CHAR(E.ACT_DEP_DT,'YYYY-MM-DD') " ).append("\n"); 
		query.append("		                            FROM VSK_VSL_PORT_SKD D,VSK_ACT_PORT_SKD E" ).append("\n"); 
		query.append("		                            WHERE SUBSTR(A.VVD2,1,4) = D.VSL_CD" ).append("\n"); 
		query.append("		                            AND SUBSTR(A.VVD2,5,4) = D.SKD_VOY_NO" ).append("\n"); 
		query.append("		                            AND SUBSTR(A.VVD2,9,1) = D.SKD_DIR_CD" ).append("\n"); 
		query.append("	    	                        AND SUBSTR(A.CRNT_YD_CD,1,5) = D.VPS_PORT_CD" ).append("\n"); 
		query.append("	    	                        AND D.YD_CD = SUBSTR(A.VVD2,10,7)" ).append("\n"); 
		query.append("									AND D.VSL_CD=E.VSL_CD" ).append("\n"); 
		query.append("									AND D.SKD_VOY_NO=E.SKD_VOY_NO" ).append("\n"); 
		query.append("									AND D.SKD_DIR_CD=E.SKD_DIR_CD" ).append("\n"); 
		query.append("									AND D.VPS_PORT_CD=E.VPS_PORT_CD" ).append("\n"); 
		query.append("									AND D.CLPT_IND_SEQ=E.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		                            AND ROWNUM =1" ).append("\n"); 
		query.append("		                        )     " ).append("\n"); 
		query.append("		 	 )" ).append("\n"); 
		query.append("		 #else" ).append("\n"); 
		query.append("	     ,DECODE(A.VVD2,NULL,'',(SELECT /*+ INDEX_DESC(D XPKVSK_VSL_PORT_SKD ) */ " ).append("\n"); 
		query.append("	                                     TO_CHAR(MAX(D.VPS_ETD_DT),'YYYY-MM-DD')" ).append("\n"); 
		query.append("	                              FROM VSK_VSL_PORT_SKD D                                    " ).append("\n"); 
		query.append("	                              WHERE D.VSL_CD = SUBSTR(A.VVD2,1,4)" ).append("\n"); 
		query.append("	                              AND D.SKD_VOY_NO = SUBSTR(A.VVD2,5,4)" ).append("\n"); 
		query.append("	                              AND D.SKD_DIR_CD = SUBSTR(A.VVD2,9,1)" ).append("\n"); 
		query.append("	                              AND D.YD_CD = SUBSTR(A.VVD2,10,7)))" ).append("\n"); 
		query.append("		 #end POL_ETD" ).append("\n"); 
		query.append("		 #if (${view_customer} == 'Y')" ).append("\n"); 
		query.append("	        ,REPLACE(SUBSTR(E.CUST_NM,1,50),CHR(13)||chr(10),' ')  SHPR" ).append("\n"); 
		query.append("	        ,REPLACE(SUBSTR(F.CUST_NM,1,50),CHR(13)||chr(10),' ')  CNEE" ).append("\n"); 
		query.append("	        ,REPLACE(SUBSTR(G.CUST_NM,1,50),CHR(13)||chr(10),' ')  NTFY" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("		,A.SC_NO" ).append("\n"); 
		query.append("		,A.RFA_NO" ).append("\n"); 
		query.append("		,A.SC_RFA_NO" ).append("\n"); 
		query.append("		,A.DE_TERM_CD" ).append("\n"); 
		query.append("		,A.RF_TP_CD" ).append("\n"); 
		query.append("		#if (${view_commodity} == 'Y')" ).append("\n"); 
		query.append("	    	,(SELECT D.CMDT_NM FROM MDM_COMMODITY D" ).append("\n"); 
		query.append("	    	  WHERE   A.CMDT_CD = D.CMDT_CD" ).append("\n"); 
		query.append("	    	 ) REP_CMDT_NM" ).append("\n"); 
		query.append("	    	,(SELECT REPLACE(SUBSTR(X.CNTR_MF_GDS_DESC,1,100),CHR(13)||chr(10),' ') MK_DESC" ).append("\n"); 
		query.append("	    		FROM BKG_CNTR_MF_DESC X" ).append("\n"); 
		query.append("	    	   WHERE A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("	    	   AND A.CNTR_NO=X.CNTR_NO" ).append("\n"); 
		query.append("	           AND ROWNUM=1" ).append("\n"); 
		query.append("	         ) MK_DESC" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("		,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			,A.PKUP_NO" ).append("\n"); 
		query.append("			,A.FRT_CLT_FLG" ).append("\n"); 
		query.append("			,A.OBL_RDEM_FLG" ).append("\n"); 
		query.append("			,A.CSTMS_CLR_CD" ).append("\n"); 
		query.append("			,A.DTY_FREE_DT  DTY_FREE_DT2" ).append("\n"); 
		query.append("	    ,(SELECT X.VNDR_ABBR_NM" ).append("\n"); 
		query.append("	    FROM MDM_VENDOR X" ).append("\n"); 
		query.append("	    WHERE A.VNDR_SEQ = X.VNDR_SEQ) LESSOR" ).append("\n"); 
		query.append("		,A.MFT_DT" ).append("\n"); 
		query.append("		,A.GWGT" ).append("\n"); 
		query.append("		,A.PWGT" ).append("\n"); 
		query.append("		,A.TWGT" ).append("\n"); 
		query.append("	    ,A.CMDT_CD" ).append("\n"); 
		query.append("		,A.DCGO_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("          #if (${cnmv_sts_cd} == 'ID')" ).append("\n"); 
		query.append("            ,A.VNDR_SEQ2 VNDR_SEQ" ).append("\n"); 
		query.append("            ,A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("            ,A.PHN_NO" ).append("\n"); 
		query.append("            ,(SELECT B.VNDR_EML" ).append("\n"); 
		query.append("              FROM MDM_VNDR_CNTC_PNT  B" ).append("\n"); 
		query.append("              WHERE B.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("              AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("              AND B.VNDR_EML IS NOT NULL" ).append("\n"); 
		query.append("              AND ROWNUM = 1) VNDR_EML" ).append("\n"); 
		query.append("            ,(SELECT B.VNDR_EML" ).append("\n"); 
		query.append("                FROM MDM_VNDR_CNTC_PNT  B" ).append("\n"); 
		query.append("                WHERE B.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("                AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("                AND B.VNDR_EML IS NOT NULL" ).append("\n"); 
		query.append("                AND B.VNDR_EML <> " ).append("\n"); 
		query.append("                     (SELECT B.VNDR_EML" ).append("\n"); 
		query.append("                      FROM MDM_VNDR_CNTC_PNT  B" ).append("\n"); 
		query.append("                      WHERE B.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("                      AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("                      AND B.VNDR_EML IS NOT NULL" ).append("\n"); 
		query.append("                      AND ROWNUM = 1" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                AND ROWNUM = 1) VNDR_EML2 " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("			     A.SUB_LOC_CD" ).append("\n"); 
		query.append("			    ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("			    ,A.CNTR_NO" ).append("\n"); 
		query.append("			    ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			    ,A.LSTM_CD" ).append("\n"); 
		query.append("			    ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("			    ,A.FULL_FLG" ).append("\n"); 
		query.append("				,A.AGMT_NO" ).append("\n"); 
		query.append("			    ,A.CNMV_DT" ).append("\n"); 
		query.append("			    ,A.STAY_DAYS" ).append("\n"); 
		query.append("				,A.BKG_NO" ).append("\n"); 
		query.append("				,A.BL_NO" ).append("\n"); 
		query.append("				,A.VVD1" ).append("\n"); 
		query.append("				,A.VVD2" ).append("\n"); 
		query.append("				,A.POR_CD" ).append("\n"); 
		query.append("				,A.POL_CD" ).append("\n"); 
		query.append("				,A.POD_CD" ).append("\n"); 
		query.append("				,A.DEL_CD" ).append("\n"); 
		query.append("				,A.SC_NO" ).append("\n"); 
		query.append("				,A.RFA_NO" ).append("\n"); 
		query.append("				,A.SC_NO||A.RFA_NO SC_RFA_NO" ).append("\n"); 
		query.append("				,A.DE_TERM_CD" ).append("\n"); 
		query.append("				,DECODE(A.RF_TP_CD,'C','CA','M','MG','H','HU',A.RF_TP_CD) RF_TP_CD" ).append("\n"); 
		query.append("				,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("				,SUBSTR(A.PKUP_NO,1,12) PKUP_NO" ).append("\n"); 
		query.append("				,SUBSTR(A.PKUP_NO,13) DTY_FREE_DT" ).append("\n"); 
		query.append("			   	,A.FRT_CLT_FLG" ).append("\n"); 
		query.append("				,A.OBL_RDEM_FLG" ).append("\n"); 
		query.append("				,A.CSTMS_CLR_CD" ).append("\n"); 
		query.append("			    ,A.MFT_DT" ).append("\n"); 
		query.append("			    ,DECODE(C.CNTR_GRS_WGT,NULL,D.CNTR_TPSZ_LODG_WGT,C.CNTR_GRS_WGT) gwgt" ).append("\n"); 
		query.append("			    ,DECODE(CNTR_GRS_WGT - TARE_WGT,NULL,CNTR_TPSZ_LODG_WGT - CNTR_TPSZ_TARE_WGT,CNTR_GRS_WGT - TARE_WGT) pwgt" ).append("\n"); 
		query.append("			    ,DECODE(TARE_WGT,NULL,CNTR_TPSZ_TARE_WGT,TARE_WGT) twgt" ).append("\n"); 
		query.append("			    ,A.CMDT_CD REP_CMDT_CD" ).append("\n"); 
		query.append("				,A.VNDR_SEQ" ).append("\n"); 
		query.append("				,A.CMDT_CD" ).append("\n"); 
		query.append("				,A.DCGO_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 #if (${cnmv_sts_cd} == 'ID')" ).append("\n"); 
		query.append("                    ,A.VNDR_SEQ2" ).append("\n"); 
		query.append("                    ,(SELECT X.VNDR_ABBR_NM " ).append("\n"); 
		query.append("                	    FROM MDM_VENDOR X" ).append("\n"); 
		query.append("                	    WHERE X.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("                      AND X.DELT_FLG = 'N') VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                    ,(SELECT B.PHN_NO" ).append("\n"); 
		query.append("                      FROM MDM_VNDR_CNTC_PNT  B" ).append("\n"); 
		query.append("                      WHERE B.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("                      AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("                      AND B.PHN_NO IS NOT NULL" ).append("\n"); 
		query.append("                      AND ROWNUM = 1) PHN_NO" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			    FROM " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("					    SELECT" ).append("\n"); 
		query.append("							 A.AGMT_CTY_CD" ).append("\n"); 
		query.append("							,A.AGMT_SEQ" ).append("\n"); 
		query.append("					        ,DECODE(@[loc_type_code],'1',LCC_CD,'2',SCC_CD,'3',SCC_CD,'4',SCC_CD,'5',SCC_CD) SUB_LOC_CD" ).append("\n"); 
		query.append("					        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("					        ,A.CNTR_NO" ).append("\n"); 
		query.append("					        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("					        ,A.LSTM_CD" ).append("\n"); 
		query.append("					        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("							,DECODE(A.FULL_FLG,'Y','F','M') FULL_FLG" ).append("\n"); 
		query.append("							,A.AGMT_CTY_CD||A.AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("					        ,A.CNMV_DT CNMV_DT" ).append("\n"); 
		query.append("							,CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - A.CNMV_DT) STAY_DAYS" ).append("\n"); 
		query.append("					        ,A.BKG_NO" ).append("\n"); 
		query.append("							,B.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					        ,DECODE(A.CNMV_STS_CD,'MT',(SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD" ).append("\n"); 
		query.append("					                                    FROM CTM_MOVEMENT B" ).append("\n"); 
		query.append("					                                    WHERE A.CNTR_NO=B.CNTR_NO" ).append("\n"); 
		query.append("					                                    AND   A.BKG_NO=B.BKG_NO" ).append("\n"); 
		query.append("					                                    AND   B.MVMT_STS_CD='VD'" ).append("\n"); 
		query.append("					                                    AND   B.BKG_CGO_TP_CD='P'" ).append("\n"); 
		query.append("														AND   A.CRNT_YD_CD = B.ORG_YD_CD" ).append("\n"); 
		query.append("					                                    AND ROWNUM = 1)," ).append("\n"); 
		query.append("					                              'TS',(SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD FROM BKG_VVD B" ).append("\n"); 
		query.append("		                                                WHERE  A.BKG_NO=B.BKG_NO" ).append("\n"); 
		query.append("		                                                AND    SUBSTR(A.CRNT_YD_CD,1,5) = B.POD_CD" ).append("\n"); 
		query.append("													    AND ROWNUM = 1" ).append("\n"); 
		query.append("													    )" ).append("\n"); 
		query.append("		                                         ,DECODE(SUBSTR(A.CNMV_STS_CD,1,1),'I'," ).append("\n"); 
		query.append("	                                         	 (SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD FROM BKG_VVD B" ).append("\n"); 
		query.append("	                                               WHERE  A.BKG_NO=B.BKG_NO" ).append("\n"); 
		query.append("	                                               AND    SUBSTR(A.CRNT_YD_CD,1,5) = B.POD_CD" ).append("\n"); 
		query.append("												   AND ROWNUM = 1" ).append("\n"); 
		query.append("												   ))" ).append("\n"); 
		query.append("																   " ).append("\n"); 
		query.append("					        ) VVD1" ).append("\n"); 
		query.append("					        ,DECODE(A.CNMV_STS_CD,'TS',(SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD||B.POL_YD_CD FROM BKG_VVD B" ).append("\n"); 
		query.append("					                                               WHERE  A.BKG_NO=B.BKG_NO" ).append("\n"); 
		query.append("					                                               AND    SUBSTR(A.CRNT_YD_CD,1,5) = B.POL_CD" ).append("\n"); 
		query.append("																   AND ROWNUM = 1" ).append("\n"); 
		query.append("																   )" ).append("\n"); 
		query.append("					                                         ,DECODE(SUBSTR(A.CNMV_STS_CD,1,1),'O',(SELECT /*+ INDEX(B XPKBKG_VVD) */ B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD||B.POL_YD_CD FROM BKG_VVD B" ).append("\n"); 
		query.append("					                                               WHERE  A.BKG_NO=B.BKG_NO" ).append("\n"); 
		query.append("																   AND ROWNUM = 1" ).append("\n"); 
		query.append("																   ))" ).append("\n"); 
		query.append("					        ) VVD2" ).append("\n"); 
		query.append("					        " ).append("\n"); 
		query.append("							,B.POR_CD" ).append("\n"); 
		query.append("							,B.POL_CD" ).append("\n"); 
		query.append("							,B.POD_CD" ).append("\n"); 
		query.append("							,B.DEL_CD" ).append("\n"); 
		query.append("							,B.SC_NO" ).append("\n"); 
		query.append("							,B.RFA_NO" ).append("\n"); 
		query.append("							,B.RCV_TERM_CD||'/'||B.DE_TERM_CD DE_TERM_CD" ).append("\n"); 
		query.append("							,A.RF_TP_CD" ).append("\n"); 
		query.append("							,B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("							#if (${cnt_cd} == 'US')" ).append("\n"); 
		query.append("							,(SELECT RPAD(PKUP_NO,12)||TO_CHAR(LST_FREE_DT,'YYYY-MM-DD') FROM BKG_PKUP_NTC_PKUP_NO" ).append("\n"); 
		query.append("							  WHERE BKG_NO=A.BKG_NO" ).append("\n"); 
		query.append("							  AND CNTR_NO= A.CNTR_NO" ).append("\n"); 
		query.append("							  AND ROWNUM=1" ).append("\n"); 
		query.append("							  ) PKUP_NO" ).append("\n"); 
		query.append("						        ,F.FRT_CLT_FLG  " ).append("\n"); 
		query.append("					    	    ,F.OBL_RDEM_FLG " ).append("\n"); 
		query.append("                                ,DECODE(SUBSTR(B.POD_CD,1,2)||SUBSTR(B.DEL_CD,1,2),'CAUS',  (SELECT /*+ INDEX_DESC(X XPKBKG_CSTMS_ADV_CNTR_RSLT) */" ).append("\n"); 
		query.append("                                                                                              X.CSTMS_CLR_CD" ).append("\n"); 
		query.append("                                                                                            FROM BKG_CSTMS_ADV_CNTR_RSLT X" ).append("\n"); 
		query.append("                                                                                            WHERE X.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                                                                              AND X.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("                                                                                              AND (SUBSTR(X.CNTR_NO, 0, LENGTH(X.CNTR_NO)-1) = SUBSTR(A.CNTR_NO, 0, LENGTH(A.CNTR_NO)-1)" ).append("\n"); 
		query.append("                                                                                                  OR X.CNTR_NO = SUBSTR(A.CNTR_NO, 0, LENGTH(A.CNTR_NO)-1) )" ).append("\n"); 
		query.append("                                                                                              AND ROWNUM < 2),F.CSTMS_CLR_CD) CSTMS_CLR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("								,'' PKUP_NO" ).append("\n"); 
		query.append("						        ,'' FRT_CLT_FLG  " ).append("\n"); 
		query.append("					    	    ,'' OBL_RDEM_FLG    " ).append("\n"); 
		query.append("					        	,'' CSTMS_CLR_CD" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("					        ,TO_CHAR(A.MFT_DT,'YYYY-MM-DD') MFT_DT" ).append("\n"); 
		query.append("					        ,A.CNTR_SPEC_NO" ).append("\n"); 
		query.append("					        ,B.CMDT_CD" ).append("\n"); 
		query.append("							,A.VNDR_SEQ" ).append("\n"); 
		query.append("							,B.DCGO_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         #if (${cnmv_sts_cd} == 'ID')" ).append("\n"); 
		query.append("                            ,(SELECT M.VNDR_SEQ " ).append("\n"); 
		query.append("                              FROM CTM_MOVEMENT M " ).append("\n"); 
		query.append("                              WHERE M.CNTR_NO = A.CNTR_NO " ).append("\n"); 
		query.append("                              AND M.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("                              AND M.CNMV_ID_NO = A.CNMV_ID_NO) VNDR_SEQ2" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					    FROM MST_CONTAINER A,BKG_BOOKING B" ).append("\n"); 
		query.append("							#if (${cnt_cd} == 'US')" ).append("\n"); 
		query.append("								,BKG_CGO_RLSE F" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("					    WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("					    AND   A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("						#if (${cnt_cd} == 'US')" ).append("\n"); 
		query.append("							AND B.BL_NO=F.BL_NO(+)" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					    AND   A.CNTR_USE_CO_CD = @[cntr_use_co_cd]" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						#if(${off_hire_flg} != '')" ).append("\n"); 
		query.append(" 							AND (" ).append("\n"); 
		query.append("                                ( A.LSTM_CD = 'LT' AND NVL(A.min_onh_dys,0) > 0" ).append("\n"); 
		query.append("                                 AND  TRUNC(SYSDATE) > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                                OR" ).append("\n"); 
		query.append("                  				( A.LSTM_CD = 'LT' AND NVL(A.min_onh_dys,0) = 0" ).append("\n"); 
		query.append("                     			AND  TRUNC(SYSDATE) - ( SELECT /*+ INDEX_DESC (S XPKLSE_AGMT_VER) */ TRUNC(EXP_DT)" ).append("\n"); 
		query.append("                                                                  FROM   LSE_AGMT_VER S" ).append("\n"); 
		query.append("                                                                  WHERE  S.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                  AND    S.AGMT_SEQ    = A.AGMT_SEQ" ).append("\n"); 
		query.append("                                                                  AND    ROWNUM = 1" ).append("\n"); 
		query.append("                               							) > 0" ).append("\n"); 
		query.append("                 				)" ).append("\n"); 
		query.append("                				OR" ).append("\n"); 
		query.append("                 				( A.LSTM_CD IN ('ST', 'SI', 'OF', 'MI')" ).append("\n"); 
		query.append("                     			AND TRUNC(SYSDATE)  > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                 				)" ).append("\n"); 
		query.append("            				)" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("						#if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("							AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("						#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("							AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("						#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("							AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("						#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("							AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("						#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("							AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("					    #if (${full_flg} != '')" ).append("\n"); 
		query.append("					    	AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("					    #end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					    #if (${imdt_ext_flg} != '')" ).append("\n"); 
		query.append("					        AND A.IMDT_EXT_FLG =@[imdt_ext_flg]" ).append("\n"); 
		query.append("					    #end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					    #if (${plst_flr_flg} != '')" ).append("\n"); 
		query.append("					        AND A.PLST_FLR_FLG =@[plst_flr_flg]" ).append("\n"); 
		query.append("					    #end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					    #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("					    	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("					    #end      " ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					    #if (${cntr_no} != '')" ).append("\n"); 
		query.append("					    	AND SUBSTR(A.CNTR_NO,0,4) = @[cntr_no]" ).append("\n"); 
		query.append("					    #end  " ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("					    	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("					    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("					        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("					            	             FROM dual )" ).append("\n"); 
		query.append("					    				        )" ).append("\n"); 
		query.append("					    #end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					    #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_cntr} != '' || ${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("					        AND A.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("					    #end  " ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					    #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_tp_cd_m} != '')" ).append("\n"); 
		query.append("					        AND A.RF_TP_CD IN(@[rf_tp_cd_c],@[rf_tp_cd_h],@[rf_tp_cd_m])" ).append("\n"); 
		query.append("					    #end  " ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("						#if (${rd_cgo_flg} != '' || ${rf_cntr} != '')" ).append("\n"); 
		query.append("					        AND B.RD_CGO_FLG IN(@[rf_cntr],@[rd_cgo_flg])" ).append("\n"); 
		query.append("					    #end          " ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					    #if (${soc_cd} != '')" ).append("\n"); 
		query.append("					    	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("					    		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("					    	#else" ).append("\n"); 
		query.append("					    		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("					    	#end" ).append("\n"); 
		query.append("					    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   						#if (${uclm_ls_div_cd} == 'E')" ).append("\n"); 
		query.append("       						AND NVL(A.UCLM_LS_DIV_CD,'X') <> 'U'" ).append("\n"); 
		query.append("						#elseif(${uclm_ls_div_cd} == 'O')" ).append("\n"); 
		query.append("       						AND A.UCLM_LS_DIV_CD = 'U'" ).append("\n"); 
		query.append("   						#end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("    					#if (${cntr_hngr_rck_cd} != '')" ).append("\n"); 
		query.append("    						AND (A.CNTR_HNGR_RCK_CD IS NOT NULL  OR  A.CNTR_HNGR_BAR_ATCH_KNT > 0)" ).append("\n"); 
		query.append("    					#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					    #if (${disp_flg} != '')" ).append("\n"); 
		query.append("					    	AND A.DISP_FLG = @[disp_flg]" ).append("\n"); 
		query.append("					    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   						#if (${dg_flg} != '')" ).append("\n"); 
		query.append("    						AND B.DCGO_FLG  = @[dg_flg]" ).append("\n"); 
		query.append("   						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					    #if (${d2_payld_flg} != '')" ).append("\n"); 
		query.append("							AND A.CNTR_TPSZ_CD='D2'" ).append("\n"); 
		query.append("					    	AND A.D2_PAYLD_FLG = @[d2_payld_flg]" ).append("\n"); 
		query.append("					    #end" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						#if (${over_stay_days} != '')" ).append("\n"); 
		query.append("    						AND  CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - CNMV_DT) >= @[over_stay_days]" ).append("\n"); 
		query.append("    					#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					    #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("					    	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("					    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("					        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("					            	             FROM dual )" ).append("\n"); 
		query.append("					    				        )" ).append("\n"); 
		query.append("					    #end" ).append("\n"); 
		query.append("					 	#if (${ts_cntr_behind} != '')" ).append("\n"); 
		query.append("					    	  AND A.CNMV_STS_CD='TS'" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("					        #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("					        	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("					        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("					            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("					                	             FROM dual )" ).append("\n"); 
		query.append("					        				        )" ).append("\n"); 
		query.append("					            AND A.CNMV_STS_CD NOT IN('VL','XX','VD')" ).append("\n"); 
		query.append("					        #elseif (${d2_payld_flg} == '')" ).append("\n"); 
		query.append("					            AND A.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("					            'CD'" ).append("\n"); 
		query.append("					            ,'CE'" ).append("\n"); 
		query.append("					            ,'CI'" ).append("\n"); 
		query.append("					            ,'CM'" ).append("\n"); 
		query.append("					            ,'CO'" ).append("\n"); 
		query.append("					            ,'CP'" ).append("\n"); 
		query.append("					            ,'CT'" ).append("\n"); 
		query.append("					            ,'CX'" ).append("\n"); 
		query.append("					            ,'EN'" ).append("\n"); 
		query.append("					            ,'IC'" ).append("\n"); 
		query.append("					            ,'ID'" ).append("\n"); 
		query.append("					            ,'MT'" ).append("\n"); 
		query.append("					            ,'OC'" ).append("\n"); 
		query.append("					            ,'OP'" ).append("\n"); 
		query.append("					            ,'TN'" ).append("\n"); 
		query.append("					            ,'TS'" ).append("\n"); 
		query.append("					            )" ).append("\n"); 
		query.append("					        #end" ).append("\n"); 
		query.append("					    #end" ).append("\n"); 
		query.append("					) A" ).append("\n"); 
		query.append("			    	,MST_CNTR_SPEC C" ).append("\n"); 
		query.append("			    	,MDM_CNTR_TP_SZ D" ).append("\n"); 
		query.append("			    WHERE A.CNTR_SPEC_NO=C.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("			    AND A.CNTR_TPSZ_CD=D.CNTR_TPSZ_CD	" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("	#if (${view_customer} == 'Y')" ).append("\n"); 
		query.append("	    ,BKG_CUSTOMER E, BKG_CUSTOMER F, BKG_CUSTOMER G" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	#if (${view_customer} == 'Y')" ).append("\n"); 
		query.append("	    AND A.BKG_NO =E.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND A.BKG_NO =F.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND A.BKG_NO =G.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND E.BKG_CUST_TP_CD(+) ='S'" ).append("\n"); 
		query.append("	    AND F.BKG_CUST_TP_CD(+) ='C'" ).append("\n"); 
		query.append("	    AND G.BKG_CUST_TP_CD(+) ='N'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${next_vvd} != '')" ).append("\n"); 
		query.append("		AND SUBSTR(A.VVD2,1,9) = @[next_vvd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ts_cntr_behind} != '')" ).append("\n"); 
		query.append("	 AND SUBSTR(@[rcc_date],1,4)||'-'||SUBSTR(@[rcc_date],5,2)||'-'||SUBSTR(@[rcc_date],7,2) > A.POL_ETD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
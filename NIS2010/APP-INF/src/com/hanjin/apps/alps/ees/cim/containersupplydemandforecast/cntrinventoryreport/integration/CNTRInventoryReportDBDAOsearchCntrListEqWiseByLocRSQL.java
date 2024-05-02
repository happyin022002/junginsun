/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.11 
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

public class CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container List by Location
	  * 2011.05.13 남궁진호[CHM-201110740-01] M/Date 조건 추가에 따른 SQL수정 CNTR 생산년도 Fr~To 조건추가
	  * 2012.02.08 신자영 [CHM-201216058-01] [CIM] Land Inventory with cntr list 기능 보완
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL(){
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
		params.put("dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("froms",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tos",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL").append("\n"); 
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
		query.append("SELECT AA.*" ).append("\n"); 
		query.append("       ,(SELECT A.YD_NM FROM MDM_YARD A WHERE A.YD_CD = AA.CRNT_YD_CD) YD_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     A.SUB_LOC_CD" ).append("\n"); 
		query.append("    ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("    ,A.CNTR_NO" ).append("\n"); 
		query.append("    ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,A.LSTM_CD" ).append("\n"); 
		query.append("    ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("	,A.FULL_FLG" ).append("\n"); 
		query.append("	,A.AGMT_NO" ).append("\n"); 
		query.append("    ,A.CNMV_DT" ).append("\n"); 
		query.append("	,LTRIM(TO_CHAR(A.STAY_DAYS,'9,999')) STAY_DAYS" ).append("\n"); 
		query.append("    ,A.BKG_NO" ).append("\n"); 
		query.append("    ,A.BL_NO" ).append("\n"); 
		query.append("	,A.VVD" ).append("\n"); 
		query.append("    ,DECODE(A.DMG_FLG,'Y',A.DMG_FLG,'') DMG_FLG" ).append("\n"); 
		query.append("	,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID='CD02012' AND INTG_CD_VAL_CTNT=A.CNTR_HNGR_RCK_CD) CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("	,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("    ,A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("    ,DECODE(A.DISP_FLG,'Y',A.DISP_FLG,'') DISP_FLG" ).append("\n"); 
		query.append("    ,DECODE(A.IMDT_EXT_FLG,'Y',A.IMDT_EXT_FLG,'') IMDT_EXT_FLG" ).append("\n"); 
		query.append("    ,DECODE(A.UCLM_LS_FLG,'Y',A.UCLM_LS_FLG,'') UCLM_LS_FLG" ).append("\n"); 
		query.append("    ,DECODE(A.PLST_FLR_FLG,'Y',A.PLST_FLR_FLG,'') PLST_FLR_FLG" ).append("\n"); 
		query.append("	,A.DE_TERM_CD" ).append("\n"); 
		query.append("	,A.RF_TP_CD" ).append("\n"); 
		query.append("    ,PSA_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${view_customer} == 'Y')" ).append("\n"); 
		query.append("        ,REPLACE(SUBSTR(B.CUST_NM,1,50),CHR(13)||chr(10),' ')  SHPR" ).append("\n"); 
		query.append("        ,REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||chr(10),' ')  CNEE" ).append("\n"); 
		query.append("        ,REPLACE(SUBSTR(D.CUST_NM,1,50),CHR(13)||chr(10),' ')  NTFY" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${view_commodity} == 'Y')" ).append("\n"); 
		query.append("    	,(SELECT D.CMDT_NM FROM MDM_COMMODITY D" ).append("\n"); 
		query.append("    	  WHERE   A.CMDT_CD = D.CMDT_CD" ).append("\n"); 
		query.append("    	 ) REP_CMDT_NM" ).append("\n"); 
		query.append("    	,(SELECT REPLACE(SUBSTR(X.CNTR_MF_GDS_DESC,1,100),CHR(13)||chr(10),' ') MK_DESC" ).append("\n"); 
		query.append("    		FROM BKG_CNTR_MF_DESC X" ).append("\n"); 
		query.append("    	   WHERE A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("    	   AND A.CNTR_NO=X.CNTR_NO" ).append("\n"); 
		query.append("           AND ROWNUM=1" ).append("\n"); 
		query.append("         ) MK_DESC" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,(SELECT X.VNDR_ABBR_NM" ).append("\n"); 
		query.append("      FROM MDM_VENDOR X" ).append("\n"); 
		query.append("      WHERE A.VNDR_SEQ = X.VNDR_SEQ) LESSOR" ).append("\n"); 
		query.append("    ,A.MFT_DT" ).append("\n"); 
		query.append("	#if (${over_stay_days} != '' &&  ${over_stay_days} != '0')" ).append("\n"); 
		query.append("	    ,NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0) FT_DYS" ).append("\n"); 
		query.append("	    ,SUBSTR(A.FT_END_DYS,1,10) FT_END_DT" ).append("\n"); 
		query.append("	    ,CASE WHEN A.STAY_DAYS-NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0) >99999 THEN" ).append("\n"); 
		query.append("			99999" ).append("\n"); 
		query.append("		 ELSE" ).append("\n"); 
		query.append("	 	    A.STAY_DAYS-NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0)" ).append("\n"); 
		query.append("		 END  ACT_DYS " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	,DECODE(A.DCGO_FLG, 'Y', A.DCGO_FLG, '') DG_FLG" ).append("\n"); 
		query.append("    ,CASE WHEN A.LSTM_CD = 'LT' AND NVL(A.MIN_ONH_DYS,0) = 0 THEN" ).append("\n"); 
		query.append("            CASE WHEN TRUNC(SYSDATE) - ( SELECT /*+ INDEX_DESC (S XPKLSE_AGMT_VER) */ TRUNC(EXP_DT)" ).append("\n"); 
		query.append("                                  		   FROM LSE_AGMT_VER S" ).append("\n"); 
		query.append("                                  		   WHERE  S.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                  		   AND    S.AGMT_SEQ    = A.AGMT_SEQ" ).append("\n"); 
		query.append("                                  		   AND    ROWNUM = 1   " ).append("\n"); 
		query.append("                                       ) > 0" ).append("\n"); 
		query.append("             	   THEN  'Y'" ).append("\n"); 
		query.append("          ELSE '' " ).append("\n"); 
		query.append("          END" ).append("\n"); 
		query.append("     WHEN A.LSTM_CD = 'LT' AND NVL(A.MIN_ONH_DYS,0) > 0 THEN" ).append("\n"); 
		query.append("            CASE WHEN TRUNC(SYSDATE)  > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                 THEN  'Y'" ).append("\n"); 
		query.append("            ELSE '' END" ).append("\n"); 
		query.append("     WHEN A.LSTM_CD IN ('ST', 'SI', 'OF', 'MI') THEN" ).append("\n"); 
		query.append("               CASE WHEN TRUNC(SYSDATE)  > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                  THEN  'Y'" ).append("\n"); 
		query.append("          ELSE '' END" ).append("\n"); 
		query.append("    ELSE '' END OFF_HIRE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(    " ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        DECODE(@[loc_type_code],'1',LCC_CD,'2',SCC_CD,'3',SCC_CD,'4',SCC_CD,'5',SCC_CD) SUB_LOC_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("    	,DECODE(A.FULL_FLG,'Y','F','M') FULL_FLG" ).append("\n"); 
		query.append("		,A.AGMT_CTY_CD||A.AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("    	,CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - A.CNMV_DT) STAY_DAYS" ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,B.BL_NO" ).append("\n"); 
		query.append("    	,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        ,A.DMG_FLG" ).append("\n"); 
		query.append("    	,A.CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("		,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("        ,A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("        ,A.DISP_FLG" ).append("\n"); 
		query.append("        ,A.IMDT_EXT_FLG" ).append("\n"); 
		query.append("        ,DECODE(A.UCLM_LS_DIV_CD,'U','Y','N') UCLM_LS_FLG" ).append("\n"); 
		query.append("        ,A.PLST_FLR_FLG" ).append("\n"); 
		query.append("		,B.RCV_TERM_CD||'/'||B.DE_TERM_CD DE_TERM_CD" ).append("\n"); 
		query.append("    	,A.RF_TP_CD" ).append("\n"); 
		query.append("    	,B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.MFT_DT,'YYYY-MM-DD') MFT_DT" ).append("\n"); 
		query.append("    	,A.VNDR_SEQ" ).append("\n"); 
		query.append("    	,B.CMDT_CD" ).append("\n"); 
		query.append("		#if (${over_stay_days} != '' &&  ${over_stay_days} != '0')" ).append("\n"); 
		query.append("	        ,(SELECT  MAX(NVL(TO_CHAR(FT_END_DT,'YYYY-MM-DD'),'1111-11-11')||LTRIM(TO_CHAR(FT_DYS,'0000')))" ).append("\n"); 
		query.append("	        FROM DMT_CHG_CALC E,DMT_CHG_BKG_CNTR F" ).append("\n"); 
		query.append("	        WHERE E.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("	        AND E.SYS_AREA_GRP_ID  =  A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	        AND E.CNTR_CYC_NO = A. CNMV_CYC_NO" ).append("\n"); 
		query.append("	        AND E.CHG_SEQ = 1" ).append("\n"); 
		query.append("	        AND E.FM_MVMT_YD_CD = A.CRNT_YD_CD" ).append("\n"); 
		query.append("	        AND E.DMDT_CHG_STS_CD <> 'E'" ).append("\n"); 
		query.append("	        AND F.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("	        AND F.SYS_AREA_GRP_ID  = E.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	        AND F.CNTR_CYC_NO = E.CNTR_CYC_NO" ).append("\n"); 
		query.append("	        AND F.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("			AND A.CNMV_STS_CD NOT IN ('TS','MT')" ).append("\n"); 
		query.append("			) FT_END_DYS  " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		,B.DCGO_FLG" ).append("\n"); 
		query.append("        ,A.AGMT_CTY_CD" ).append("\n"); 
		query.append("	 	,A.AGMT_SEQ" ).append("\n"); 
		query.append("        ,A.MIN_ONH_DYS" ).append("\n"); 
		query.append("        ,A.ONH_DT" ).append("\n"); 
		query.append("        ,C.PSA_NO" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A,BKG_BOOKING B," ).append("\n"); 
		query.append("         ( SELECT * FROM" ).append("\n"); 
		query.append("                (SELECT BKG_NO, PSA_NO, ROW_NUMBER() OVER (PARTITION BY BKG_NO ORDER BY DCGO_SEQ, DG_CNTR_SEQ) AS RN FROM BKG_DG_CGO)" ).append("\n"); 
		query.append("          WHERE RN = '1') C" ).append("\n"); 
		query.append("    WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("    AND   A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("    AND   A.BKG_NO =C.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${psa_no} != '')" ).append("\n"); 
		query.append("        AND C.PSA_NO IN ('1','1D','1S','2','1S/2S' ) " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND   A.CNTR_USE_CO_CD = @[cntr_use_co_cd]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if(${off_hire_flg} != '')" ).append("\n"); 
		query.append(" 		AND (" ).append("\n"); 
		query.append("                  ( A.LSTM_CD = 'LT' AND NVL(A.min_onh_dys,0) > 0" ).append("\n"); 
		query.append("                      AND  TRUNC(SYSDATE) > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                  OR" ).append("\n"); 
		query.append("                  ( A.LSTM_CD = 'LT' AND NVL(A.min_onh_dys,0) = 0" ).append("\n"); 
		query.append("                     AND  TRUNC(SYSDATE) - ( SELECT /*+ INDEX_DESC (S XPKLSE_AGMT_VER) */ TRUNC(EXP_DT)" ).append("\n"); 
		query.append("                                                                  FROM   LSE_AGMT_VER S" ).append("\n"); 
		query.append("                                                                  WHERE  S.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                  AND    S.AGMT_SEQ    = A.AGMT_SEQ" ).append("\n"); 
		query.append("                                                                  AND    ROWNUM = 1" ).append("\n"); 
		query.append("                               ) > 0" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append("                 ( A.LSTM_CD IN ('ST', 'SI', 'OF', 'MI','OL')" ).append("\n"); 
		query.append("                     AND TRUNC(SYSDATE)  > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("    	AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("    	AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("    	AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("    	AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("    	AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${full_flg} != '')" ).append("\n"); 
		query.append("    	AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${imdt_ext_flg} != '')" ).append("\n"); 
		query.append("        AND A.IMDT_EXT_FLG =@[imdt_ext_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${plst_flr_flg} != '')" ).append("\n"); 
		query.append("        AND A.PLST_FLR_FLG =@[plst_flr_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("    	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("    #end      " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${cntr_no} != '')" ).append("\n"); 
		query.append("    	AND SUBSTR(A.CNTR_NO,0,4) = @[cntr_no]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_cntr} != '' || ${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("        AND A.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_tp_cd_m} != '')" ).append("\n"); 
		query.append("        AND A.RF_TP_CD IN(@[rf_tp_cd_c],@[rf_tp_cd_h],@[rf_tp_cd_m])" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${rd_cgo_flg} != '' || ${rf_cntr} != '')" ).append("\n"); 
		query.append("        AND B.RD_CGO_FLG IN(@[rf_cntr],@[rd_cgo_flg])" ).append("\n"); 
		query.append("    #end          " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${soc_cd} != '')" ).append("\n"); 
		query.append("    	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("    		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("    	#else" ).append("\n"); 
		query.append("    		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   	#if (${uclm_ls_div_cd} == 'E')" ).append("\n"); 
		query.append("       	AND NVL(A.UCLM_LS_DIV_CD,'X') <> 'U'" ).append("\n"); 
		query.append("	#elseif(${uclm_ls_div_cd} == 'O')" ).append("\n"); 
		query.append("       	AND A.UCLM_LS_DIV_CD = 'U'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("        AND A.CNMV_STS_CD NOT IN('VL','XX','VD')" ).append("\n"); 
		query.append("    #elseif (${d2_payld_flg} == '')" ).append("\n"); 
		query.append("        AND A.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("        'CD'" ).append("\n"); 
		query.append("        ,'CE'" ).append("\n"); 
		query.append("        ,'CI'" ).append("\n"); 
		query.append("        ,'CM'" ).append("\n"); 
		query.append("        ,'CO'" ).append("\n"); 
		query.append("        ,'CP'" ).append("\n"); 
		query.append("        ,'CT'" ).append("\n"); 
		query.append("        ,'CX'" ).append("\n"); 
		query.append("        ,'EN'" ).append("\n"); 
		query.append("        ,'IC'" ).append("\n"); 
		query.append("        ,'ID'" ).append("\n"); 
		query.append("        ,'MT'" ).append("\n"); 
		query.append("        ,'OC'" ).append("\n"); 
		query.append("        ,'OP'" ).append("\n"); 
		query.append("        ,'TN'" ).append("\n"); 
		query.append("        ,'TS'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${over_stay_days} != '')" ).append("\n"); 
		query.append("    	AND  CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - CNMV_DT) >= @[over_stay_days]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${cntr_hngr_rck_cd} != '')" ).append("\n"); 
		query.append("    	AND (A.CNTR_HNGR_RCK_CD IS NOT NULL  OR  A.CNTR_HNGR_BAR_ATCH_KNT > 0)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${disp_flg} != '')" ).append("\n"); 
		query.append("    	AND A.DISP_FLG = @[disp_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${d2_payld_flg} != '')" ).append("\n"); 
		query.append("    	AND A.CNTR_TPSZ_CD='D2'" ).append("\n"); 
		query.append("    	AND A.D2_PAYLD_FLG = @[d2_payld_flg]" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("	#if (${view_flg} == 'eq') " ).append("\n"); 
		query.append("		#if (${froms} != '') " ).append("\n"); 
		query.append("			AND TO_CHAR(MFT_DT,'YYYY') BETWEEN @[froms] AND @[tos]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${dg_flg} != '')" ).append("\n"); 
		query.append("    	AND B.DCGO_FLG  = @[dg_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("#if (${view_customer} == 'Y')" ).append("\n"); 
		query.append(", BKG_CUSTOMER B, BKG_CUSTOMER C, BKG_CUSTOMER D" ).append("\n"); 
		query.append("WHERE A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("AND  A.BKG_NO =C.BKG_NO(+)" ).append("\n"); 
		query.append("AND  A.BKG_NO =D.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_CUST_TP_CD(+) ='S'" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD(+) ='C'" ).append("\n"); 
		query.append("AND D.BKG_CUST_TP_CD(+) ='N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") AA" ).append("\n"); 

	}
}
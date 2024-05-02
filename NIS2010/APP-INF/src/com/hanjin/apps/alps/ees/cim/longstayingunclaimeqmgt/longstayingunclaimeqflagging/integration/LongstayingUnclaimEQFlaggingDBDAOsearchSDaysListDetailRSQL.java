/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Full/ MTY 장기체화 장비의 BKG 및 Movement 정보등을 컨테이너 번호별로 일괄적으로 조회한다.
	  * 2012.01.25 신자영 [CHM-201215785-01] CNTR STAYING DAYS 추가 개발
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("code_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntrprefix",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListDetailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("         A.SUB_LOC_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("    	,A.FULL_FLG" ).append("\n"); 
		query.append("        ,A.CNMV_DT" ).append("\n"); 
		query.append("		,LTRIM(TO_CHAR(A.STAY_DAYS,'9,999')) STAY_DAYS" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("		,DECODE(SUBSTR(A.FT_END_DYS,1,4),NULL,0,TO_NUMBER(SUBSTR(A.FT_END_DYS,1,4))) FT_DYS" ).append("\n"); 
		query.append("		,SUBSTR(A.FT_END_DYS,5) FT_END_DT" ).append("\n"); 
		query.append("		,TO_CHAR(A.STAY_DAYS-DECODE(SUBSTR(A.FT_END_DYS,1,4),NULL,0,TO_NUMBER(SUBSTR(A.FT_END_DYS,1,4))),'9,999') ACT_DYS	" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("		,NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0) FT_DYS" ).append("\n"); 
		query.append("	    ,SUBSTR(A.FT_END_DYS,1,10) FT_END_DT" ).append("\n"); 
		query.append("	    ,CASE WHEN A.STAY_DAYS-NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0) >99999 THEN" ).append("\n"); 
		query.append("			99999" ).append("\n"); 
		query.append("		 ELSE" ).append("\n"); 
		query.append("	 	    A.STAY_DAYS-NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0)" ).append("\n"); 
		query.append("		 END  ACT_DYS " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,A.BL_NO" ).append("\n"); 
		query.append("        ,SHPR                               " ).append("\n"); 
		query.append("        ,CNEE                               " ).append("\n"); 
		query.append("        ,NTFY     " ).append("\n"); 
		query.append("    	,REP_CMDT_NM" ).append("\n"); 
		query.append("        ,MK_DESC" ).append("\n"); 
		query.append("    	,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    	,A.OB_SREP_CD" ).append("\n"); 
		query.append("		,DECODE(A.DMG_FLG,'Y',A.DMG_FLG,'') DMG_FLG" ).append("\n"); 
		query.append("		,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID='CD02012' AND INTG_CD_VAL_CTNT=A.CNTR_HNGR_RCK_CD) CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("    	,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("    	,A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("		,DECODE(A.DISP_FLG,'Y',A.DISP_FLG,'') DISP_FLG" ).append("\n"); 
		query.append("		,DECODE(A.IMDT_EXT_FLG,'Y',A.IMDT_EXT_FLG,'') IMDT_EXT_FLG" ).append("\n"); 
		query.append("		,DECODE(A.UCLM_LS_FLG,'Y',A.UCLM_LS_FLG,'') UCLM_LS_FLG" ).append("\n"); 
		query.append("		,DECODE(A.PLST_FLR_FLG,'Y',A.PLST_FLR_FLG,'') PLST_FLR_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        DECODE(@[loc_type_code],'1',LCC_CD,'2',SCC_CD,'3',SCC_CD,'4',SCC_CD,'5',SCC_CD,'7',ECC_CD) SUB_LOC_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("    	,DECODE(A.FULL_FLG,'Y','F','M') FULL_FLG" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("		,CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS')- A.CNMV_DT ) STAY_DAYS" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("            SELECT  LTRIM(TO_CHAR(FT_DYS,'0000')) || TO_CHAR(FT_END_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("            FROM DMT_CHG_CALC E,DMT_CHG_BKG_CNTR F" ).append("\n"); 
		query.append("            WHERE E.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("            AND E.SYS_AREA_GRP_ID  =  A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("            AND E.CNTR_CYC_NO = A. CNMV_CYC_NO" ).append("\n"); 
		query.append("            AND E.CHG_SEQ = 1" ).append("\n"); 
		query.append("            AND (DECODE(A.CNMV_STS_CD, 'IC','VD', A.CNMV_STS_CD) = E.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("                        OR  DECODE(A.CNMV_STS_CD,'IC','IC','') = E.FM_MVMT_STS_CD)" ).append("\n"); 
		query.append("            AND E.DMDT_CHG_STS_CD <> 'E'" ).append("\n"); 
		query.append("            AND F.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("            AND F.SYS_AREA_GRP_ID  =  E.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("            AND F.CNTR_CYC_NO = E.CNTR_CYC_NO" ).append("\n"); 
		query.append("            AND F.BKG_NO = A.BKG_NO    " ).append("\n"); 
		query.append("       	 	AND ROWNUM =1" ).append("\n"); 
		query.append("        ) FT_END_DYS" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("		,(SELECT  MAX(NVL(TO_CHAR(FT_END_DT,'YYYY-MM-DD'),'1111-11-11')||LTRIM(TO_CHAR(FT_DYS,'0000')))" ).append("\n"); 
		query.append("        FROM DMT_CHG_CALC E,DMT_CHG_BKG_CNTR F" ).append("\n"); 
		query.append("        WHERE E.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("        AND E.SYS_AREA_GRP_ID  =  A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND E.CNTR_CYC_NO = A. CNMV_CYC_NO" ).append("\n"); 
		query.append("        AND E.CHG_SEQ = 1" ).append("\n"); 
		query.append("        AND E.FM_MVMT_YD_CD = A.CRNT_YD_CD" ).append("\n"); 
		query.append("        AND E.DMDT_CHG_STS_CD <> 'E'" ).append("\n"); 
		query.append("        AND F.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("        AND F.SYS_AREA_GRP_ID  = E.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND F.CNTR_CYC_NO = E.CNTR_CYC_NO" ).append("\n"); 
		query.append("        AND F.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		AND A.CNMV_STS_CD NOT IN ('TS','MT')" ).append("\n"); 
		query.append("		) FT_END_DYS " ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,B.BL_NO" ).append("\n"); 
		query.append("        ,(SELECT REPLACE(SUBSTR(W.CUST_NM,1,50),CHR(13)||chr(10),' ')" ).append("\n"); 
		query.append("        FROM BKG_CUSTOMER W                                          " ).append("\n"); 
		query.append("        WHERE A.BKG_NO = W.BKG_NO                                    " ).append("\n"); 
		query.append("        AND W.BKG_CUST_TP_CD='S') SHPR                               " ).append("\n"); 
		query.append("                                                                     " ).append("\n"); 
		query.append("        ,(SELECT REPLACE(SUBSTR(W.CUST_NM,1,50),CHR(13)||chr(10),' ')" ).append("\n"); 
		query.append("        FROM BKG_CUSTOMER W                                          " ).append("\n"); 
		query.append("        WHERE A.BKG_NO = W.BKG_NO                                    " ).append("\n"); 
		query.append("        AND W.BKG_CUST_TP_CD='C') CNEE                               " ).append("\n"); 
		query.append("                                                                     " ).append("\n"); 
		query.append("        ,(SELECT REPLACE(SUBSTR(W.CUST_NM,1,50),CHR(13)||chr(10),' ')" ).append("\n"); 
		query.append("        FROM BKG_CUSTOMER W                                          " ).append("\n"); 
		query.append("        WHERE A.BKG_NO = W.BKG_NO                                    " ).append("\n"); 
		query.append("        AND W.BKG_CUST_TP_CD='N') NTFY     " ).append("\n"); 
		query.append("    	,(SELECT D.REP_CMDT_NM FROM MDM_REP_CMDT D" ).append("\n"); 
		query.append("    	   WHERE   B.REP_CMDT_CD = D.REP_CMDT_CD" ).append("\n"); 
		query.append("    	) REP_CMDT_NM" ).append("\n"); 
		query.append("        ,(SELECT REPLACE(X.MK_DESC,CHR(13)||chr(10),' ')" ).append("\n"); 
		query.append("        FROM BKG_BL_MK_DESC X" ).append("\n"); 
		query.append("        WHERE A.BKG_NO = X.BKG_NO) MK_DESC" ).append("\n"); 
		query.append("    	,B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    	,B.OB_SREP_CD" ).append("\n"); 
		query.append("    	,A.DMG_FLG" ).append("\n"); 
		query.append("		,A.CNTR_HNGR_RCK_CD " ).append("\n"); 
		query.append("		,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("    	,A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("    	,A.DISP_FLG" ).append("\n"); 
		query.append("    	,A.IMDT_EXT_FLG" ).append("\n"); 
		query.append("    	,DECODE(A.UCLM_LS_DIV_CD,'U','Y','N') UCLM_LS_FLG" ).append("\n"); 
		query.append("    	,A.PLST_FLR_FLG" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A,BKG_BOOKING B" ).append("\n"); 
		query.append("    WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("    AND   A.CNMV_STS_CD NOT IN ('XX','VL')" ).append("\n"); 
		query.append("    AND   A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("    AND B.OB_SLS_OFC_CD =@[ofc_cd]    " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${cntr_yd_cd} != '')" ).append("\n"); 
		query.append("    AND SUBSTR(A.CRNT_YD_CD,1,2) = @[cntr_yd_cd]    " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${cntrprefix} != '')" ).append("\n"); 
		query.append("    AND SUBSTR(A.CNTR_NO,0,4) = @[cntrprefix]    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_hngr_rck_cd} == 'Y')" ).append("\n"); 
		query.append("    AND (A.CNTR_HNGR_RCK_CD IS NOT NULL OR  A.CNTR_HNGR_BAR_ATCH_KNT > 0)   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${disp_flg} == 'Y')" ).append("\n"); 
		query.append("   AND A.DISP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${d2_payld_flg} == 'Y')" ).append("\n"); 
		query.append("   AND AND A.D2_PAYLD_FLG = 'Y'" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("    AND   A.CNTR_USE_CO_CD = @[cntr_use_co_cd]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("    	AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("    	AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("    	AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("        AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("        AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("        AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("        AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    #end     " ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("    	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${uclm_ls_div_cd} == 'E')" ).append("\n"); 
		query.append("    	AND NVL(A.UCLM_LS_DIV_CD,'X') <> 'U'" ).append("\n"); 
		query.append("    #elseif(${uclm_ls_div_cd} == 'O')" ).append("\n"); 
		query.append("    	AND A.UCLM_LS_DIV_CD = 'U'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${full_flg} != '')" ).append("\n"); 
		query.append("    	AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("    #end        " ).append("\n"); 
		query.append("    #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    #if (${soc_cd} != '')" ).append("\n"); 
		query.append("    	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("    		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("    	#else" ).append("\n"); 
		query.append("    		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${code_flg} != '')" ).append("\n"); 
		query.append("      #if (${sub_loc_cd} != '')" ).append("\n"); 
		query.append("    	  AND DECODE(@[code_flg],NULL,RCC_CD,'R',RCC_CD,'L',LCC_CD,'E',ECC_CD,'S',SCC_CD,'Y',CRNT_YD_CD) =@[sub_loc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("      #if (${sub_loc_cd} != '')" ).append("\n"); 
		query.append("    	  AND DECODE(@[loc_type_code],NULL,RCC_CD,'1',LCC_CD,'2',ECC_CD,'3',SCC_CD,'4',SCC_CD,'5',CRNT_YD_CD,'6',CRNT_YD_CD,'7',ECC_CD) =@[sub_loc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${sub_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[sub_cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sub_cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[sub_cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.STAY_DAYS >= NVL(@[over_stay_days],0)" ).append("\n"); 
		query.append("ORDER BY A.SUB_LOC_CD,A.CRNT_YD_CD,A.CNTR_NO,A.CNTR_TPSZ_CD,A.LSTM_CD,A.CNMV_STS_CD" ).append("\n"); 

	}
}
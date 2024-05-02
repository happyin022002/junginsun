/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysTotalCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOsearchSDaysTotalCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Staying Days Summary 총갯수
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchSDaysTotalCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rcc_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("start_stay_days",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysTotalCntRSQL").append("\n"); 
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
		query.append("         COUNT(*) AS TOTAL_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        DECODE(@[loc_type_code],'1',LCC_CD,'2',SCC_CD,'3',SCC_CD,'4',SCC_CD,'5',SCC_CD) SUB_LOC_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,A.VNDR_SEQ VNDR_CD" ).append("\n"); 
		query.append("        ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ=A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("        ,MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ) AGMT_NO" ).append("\n"); 
		query.append("		,B.SLAN_CD   SLN_CD" ).append("\n"); 
		query.append("        ,B.SLAN_CD   SLN_LANE_CD" ).append("\n"); 
		query.append("        ,B.SVC_SCP_CD SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("    	,DECODE(A.FULL_FLG,'Y','F','M') FULL_FLG" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("		#if (${sub_loc_cd} != '')" ).append("\n"); 
		query.append("			,CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS')- A.CNMV_DT ) STAY_DAYS" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("    			,CEIL(TO_DATE((SELECT DISTINCT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.RCC_CD),'YYYYMMDD HH24:mi:SS')  FROM MDM_EQ_ORZ_CHT MEQC WHERE MEQC.RCC_CD=A.RCC_CD AND ROWNUM =1),'yyyy-MM-dd HH24:mi:SS')- A.CNMV_DT ) STAY_DAYS" ).append("\n"); 
		query.append("    		#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("    			,CEIL(TO_DATE((SELECT DISTINCT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.RCC_CD),'YYYYMMDD HH24:mi:SS')  FROM MDM_EQ_ORZ_CHT MEQC WHERE MEQC.LCC_CD=A.LCC_CD AND ROWNUM =1),'yyyy-MM-dd HH24:mi:SS')- A.CNMV_DT ) STAY_DAYS" ).append("\n"); 
		query.append("    		#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("    			,CEIL(TO_DATE((SELECT DISTINCT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.RCC_CD),'YYYYMMDD HH24:mi:SS')  FROM MDM_EQ_ORZ_CHT MEQC WHERE MEQC.LCC_CD=A.LCC_CD AND ROWNUM =1),'yyyy-MM-dd HH24:mi:SS')- A.CNMV_DT ) STAY_DAYS" ).append("\n"); 
		query.append("    		#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("        		,CEIL(TO_DATE((SELECT DISTINCT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.RCC_CD),'YYYYMMDD HH24:mi:SS')  FROM MDM_EQ_ORZ_CHT MEQC WHERE MEQC.ECC_CD=A.ECC_CD AND ROWNUM =1),'yyyy-MM-dd HH24:mi:SS')- A.CNMV_DT ) STAY_DAYS" ).append("\n"); 
		query.append("    		#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("        		,CEIL(TO_DATE((SELECT DISTINCT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.RCC_CD),'YYYYMMDD HH24:mi:SS')  FROM MDM_EQ_ORZ_CHT MEQC WHERE MEQC.SCC_CD=A.SCC_CD AND ROWNUM =1),'yyyy-MM-dd HH24:mi:SS')- A.CNMV_DT ) STAY_DAYS" ).append("\n"); 
		query.append("    		#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("				,CEIL(TO_DATE((SELECT DISTINCT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.RCC_CD),'YYYYMMDD HH24:mi:SS')  FROM MDM_EQ_ORZ_CHT MEQC WHERE MEQC.SCC_CD=(SELECT SCC_CD FROM MDM_LOCATION WHERE LOC_CD=SUBSTR(@[loc_cd],1,5)) AND ROWNUM =1),'yyyy-MM-dd HH24:mi:SS')- A.CNMV_DT ) STAY_DAYS" ).append("\n"); 
		query.append("    		#end     " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
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
		query.append("		AND ROWNUM =1" ).append("\n"); 
		query.append("		) FT_END_DYS " ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,B.BL_NO" ).append("\n"); 
		query.append("        ,(SELECT REPLACE(REPLACE(SUBSTR(W.CUST_NM,1,50),CHR(13)||chr(10),' '), CHR(10), ' ')" ).append("\n"); 
		query.append("        FROM BKG_CUSTOMER W                                          " ).append("\n"); 
		query.append("        WHERE A.BKG_NO = W.BKG_NO                                    " ).append("\n"); 
		query.append("        AND W.BKG_CUST_TP_CD='S') SHPR                               " ).append("\n"); 
		query.append("                                                                     " ).append("\n"); 
		query.append("        ,(SELECT REPLACE(REPLACE(SUBSTR(W.CUST_NM,1,50),CHR(13)||chr(10),' '), CHR(10), ' ')" ).append("\n"); 
		query.append("        FROM BKG_CUSTOMER W                                          " ).append("\n"); 
		query.append("        WHERE A.BKG_NO = W.BKG_NO                                    " ).append("\n"); 
		query.append("        AND W.BKG_CUST_TP_CD='C') CNEE                               " ).append("\n"); 
		query.append("                                                                     " ).append("\n"); 
		query.append("        ,(SELECT REPLACE(REPLACE(SUBSTR(W.CUST_NM,1,50),CHR(13)||chr(10),' '), CHR(10), ' ')" ).append("\n"); 
		query.append("        FROM BKG_CUSTOMER W                                          " ).append("\n"); 
		query.append("        WHERE A.BKG_NO = W.BKG_NO                                    " ).append("\n"); 
		query.append("        AND W.BKG_CUST_TP_CD='N') NTFY     " ).append("\n"); 
		query.append("    	,(SELECT D.REP_CMDT_NM FROM MDM_REP_CMDT D" ).append("\n"); 
		query.append("    	   WHERE   B.REP_CMDT_CD = D.REP_CMDT_CD" ).append("\n"); 
		query.append("    	) REP_CMDT_NM" ).append("\n"); 
		query.append("        ,(SELECT REPLACE(REPLACE(X.MK_DESC,CHR(13)||chr(10),' '), CHR(10), ' ')" ).append("\n"); 
		query.append("        FROM BKG_BL_MK_DESC X" ).append("\n"); 
		query.append("        WHERE A.BKG_NO = X.BKG_NO) MK_DESC" ).append("\n"); 
		query.append("    	,B.OB_SLS_OFC_CD" ).append("\n"); 
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
		query.append("    " ).append("\n"); 
		query.append("	#if(${loc_cd} != '')" ).append("\n"); 
		query.append("    	#if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("    		AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("    		AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("    		AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("    	    AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("   	 	#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("       	 	AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("        	AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("    	#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("    #if (${sub_loc_cd} != '')" ).append("\n"); 
		query.append("    	AND DECODE(@[loc_type_code],NULL,RCC_CD,'1',LCC_CD,'2',ECC_CD,'3',SCC_CD,'4',SCC_CD,'5',CRNT_YD_CD,'6',CRNT_YD_CD) =@[sub_loc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
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
		query.append("    " ).append("\n"); 
		query.append("    ORDER BY A.LCC_CD,A.CRNT_YD_CD,A.CNTR_NO,A.CNTR_TPSZ_CD,A.LSTM_CD,A.CNMV_STS_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("#if ((${start_stay_days} != '' && ${end_stay_days} == '')  || (${start_stay_days} == '366'  && ${end_stay_days} == ''))" ).append("\n"); 
		query.append("	WHERE A.STAY_DAYS >= NVL(@[start_stay_days],0) " ).append("\n"); 
		query.append("#elseif (${start_stay_days} == '0' || ${start_stay_days} == '0')" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	WHERE A.STAY_DAYS >= NVL(@[start_stay_days],0) AND A.STAY_DAYS <= NVL(${end_stay_days},0)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
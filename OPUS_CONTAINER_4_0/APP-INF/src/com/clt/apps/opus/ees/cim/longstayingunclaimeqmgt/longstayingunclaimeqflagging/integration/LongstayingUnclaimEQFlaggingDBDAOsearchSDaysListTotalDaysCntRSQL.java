/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22 
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

public class LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total S/Days” 현황을 컨테이너별 “최초반입일시/야드” 및 “현 MVMT 및 Yard 정보”등을 포함하여 체류일수를 총갯수한다.
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysCntRSQL(){
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
		params.put("mvmt_status_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) TOTAL_CNT FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     MAX(A.SUB_LOC_CD) SUB_LOC_CD   " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("         A.LOC_CD " ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,A.VNDR_CD" ).append("\n"); 
		query.append("        ,A.VNDR_NM" ).append("\n"); 
		query.append("        ,A.AGMT_NO" ).append("\n"); 
		query.append("        ,A.SLN_CD   " ).append("\n"); 
		query.append("        ,A.SLN_LANE_CD   " ).append("\n"); 
		query.append("        ,A.SERVICE_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,A.CNMV_CYC_NO" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("        ,A.SUB_LOC_CD" ).append("\n"); 
		query.append("        ,A.PLST_FLR_FLG" ).append("\n"); 
		query.append("        ,A.UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("        ,A.IMDT_EXT_FLG" ).append("\n"); 
		query.append("        ,A.DISP_FLG" ).append("\n"); 
		query.append("        ,A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("		,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("        ,A.CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("        ,A.DMG_FLG" ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,A.CNMV_DT" ).append("\n"); 
		query.append("        ,DECODE(A.FULL_FLG,'Y','F','M') FULL_FLG" ).append("\n"); 
		query.append("        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,DECODE(A.UCLM_LS_DIV_CD,'U','Y','N') UCLM_LS_FLG" ).append("\n"); 
		query.append("        ,SUBSTR(CNMV_EVNT_DT,20,2) MVMT_STS_CD" ).append("\n"); 
		query.append("        ,SUBSTR(CNMV_EVNT_DT,22,7) ORG_YD_CD" ).append("\n"); 
		query.append("        ,TO_DATE(SUBSTR(CNMV_EVNT_DT,1,19),'yyyy-MM-dd HH24:mi:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append("        ,CEIL(TO_DATE(A.CNMV_DT,'yyyy-MM-dd HH24:mi:SS')  - TO_DATE(SUBSTR(CNMV_EVNT_DT,1,19),'yyyy-MM-dd HH24:mi:SS')) STAY_DAYS" ).append("\n"); 
		query.append("        ,CEIL((TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - TO_DATE(SUBSTR(CNMV_EVNT_DT,1,19),'yyyy-MM-dd HH24:mi:SS'))) TOT_DAYS" ).append("\n"); 
		query.append("    FROM(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            DECODE(@[loc_type_code],'2',A.ECC_CD,'3',A.SCC_CD,'4',A.SCC_CD,A.CRNT_YD_CD) LOC_CD " ).append("\n"); 
		query.append("            ,A.CNTR_NO" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,A.VNDR_SEQ VNDR_CD" ).append("\n"); 
		query.append("            ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ=A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("            ,MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ) AGMT_NO" ).append("\n"); 
		query.append("            ,C.SLAN_CD   SLN_CD" ).append("\n"); 
		query.append("        	,C.SLAN_CD   SLN_LANE_CD" ).append("\n"); 
		query.append("        	,C.SVC_SCP_CD SERVICE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,A.CNMV_CYC_NO" ).append("\n"); 
		query.append("            ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("            ,A.SCC_CD SUB_LOC_CD" ).append("\n"); 
		query.append("            ,A.PLST_FLR_FLG" ).append("\n"); 
		query.append("            ,A.UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("            ,A.IMDT_EXT_FLG" ).append("\n"); 
		query.append("            ,A.DISP_FLG" ).append("\n"); 
		query.append("            ,A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("			,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("			,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL  WHERE INTG_CD_ID='CD02012' AND INTG_CD_VAL_CTNT=A.CNTR_HNGR_RCK_CD) CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("            ,A.DMG_FLG" ).append("\n"); 
		query.append("            ,A.BKG_NO" ).append("\n"); 
		query.append("            ,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("            ,A.FULL_FLG" ).append("\n"); 
		query.append("            ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("            ,A.LSTM_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,(SELECT /*+ INDEX_DESC(B XAK11CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                     MIN(TO_CHAR(B.CNMV_EVNT_DT,'yyyy-MM-dd HH24:mi:SS')||B.MVMT_STS_CD||B.ORG_YD_CD) " ).append("\n"); 
		query.append("              FROM  CTM_MOVEMENT B " ).append("\n"); 
		query.append("              		#if (${loc_type_code} == '5')	--SCC" ).append("\n"); 
		query.append("              			,MDM_LOCATION C" ).append("\n"); 
		query.append("              		#elseif( ${loc_type_code} == '2' || ${loc_type_code} == '3'  || ${loc_type_code} == '4' )	--LCC,ECC" ).append("\n"); 
		query.append("                  	   ,MDM_LOCATION C" ).append("\n"); 
		query.append("                  	   ,MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("              		#end" ).append("\n"); 
		query.append("              WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("              AND   A.CNMV_CYC_NO  = B.CNMV_CYC_NO" ).append("\n"); 
		query.append("              AND   B.MVMT_STS_CD IN ('CM','CP','CI','CO','CD','CT','CE',  'IC', 'ID', 'MT', 'OP', 'OC', 'TN', 'EN', 'TS')" ).append("\n"); 
		query.append("              #if (${loc_type_code} == '5')	  --ECC" ).append("\n"); 
		query.append("              	  AND C.LOC_CD = SUBSTR(B.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("              #elseif( ${loc_type_code} == '2' || ${loc_type_code} == '3'  || ${loc_type_code} == '4' )" ).append("\n"); 
		query.append("                  AND C.LOC_CD = SUBSTR(B.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                  AND C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("	          #if (${loc_type_code} == '2')" ).append("\n"); 
		query.append("		      	  AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	          #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("			      AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	          #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("			      AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	          #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("			      AND C.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	          #elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("		      	  AND B.ORG_YD_CD = @[loc_cd]" ).append("\n"); 
		query.append("	          #end 	          " ).append("\n"); 
		query.append("	         ) CNMV_EVNT_DT" ).append("\n"); 
		query.append("        FROM  MST_CONTAINER A,  BKG_BOOKING C" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("		AND   A.BKG_NO =C.BKG_NO(+)" ).append("\n"); 
		query.append("        AND   A.CNMV_STS_CD IN ( 'CD','CE','CI','CM','CO','CP','CT','CX', 'EN','IC','ID','MT','OC','OP','TN','TS','VD')" ).append("\n"); 
		query.append("        #if (${loc_type_code} == '2')" ).append("\n"); 
		query.append("        	AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("        	AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("            AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("            AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("            AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #end     " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("        	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                	             FROM dual )" ).append("\n"); 
		query.append("        				        )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("        	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    	#if (${uclm_ls_div_cd} == 'E')" ).append("\n"); 
		query.append("        	AND NVL(A.UCLM_LS_DIV_CD,'X') <> 'U'" ).append("\n"); 
		query.append("		#elseif(${uclm_ls_div_cd} == 'O')" ).append("\n"); 
		query.append("        	AND A.UCLM_LS_DIV_CD = 'U'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                	             FROM dual )" ).append("\n"); 
		query.append("        				        )" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${soc_cd} != '')" ).append("\n"); 
		query.append("        	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("        		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("        	#else" ).append("\n"); 
		query.append("        		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end	     " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${full_flg} != '')" ).append("\n"); 
		query.append("			AND A.FULL_FLG=@[full_flg]" ).append("\n"); 
		query.append("        #end        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("        	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                	             FROM dual )" ).append("\n"); 
		query.append("        				        )" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("		#if (${sub_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("			AND A.CNTR_TPSZ_CD =@[sub_cntr_tpsz_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#end              			        		        " ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    WHERE  CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - TO_DATE(SUBSTR(CNMV_EVNT_DT,1,19),'yyyy-MM-dd HH24:mi:SS')) >= @[over_stay_days]" ).append("\n"); 
		query.append(") A, CTM_MOVEMENT B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${sub_loc_cd} != '')" ).append("\n"); 
		query.append("	#if (${loc_type_code} == '5' ||  ${loc_type_code} == '6' ) " ).append("\n"); 
		query.append("		AND A.CRNT_YD_CD =@[sub_loc_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.LOC_CD =@[sub_loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNMV_CYC_NO = B.CNMV_CYC_NO " ).append("\n"); 
		query.append("#if (${mvmt_status_cd} != '')" ).append("\n"); 
		query.append("	AND   B.MVMT_STS_CD = @[mvmt_status_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO" ).append("\n"); 
		query.append(") Z" ).append("\n"); 

	}
}
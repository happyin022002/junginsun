/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisLongStayingReportDBDAOSearchChassisLongStayingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 이율규
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisLongStayingReportDBDAOSearchChassisLongStayingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미주 내 L/Staying Chassis의 정보를 추출
	  * </pre>
	  */
	public ChassisLongStayingReportDBDAOSearchChassisLongStayingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("beyond_fdays",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("staying_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.integration").append("\n"); 
		query.append("FileName : ChassisLongStayingReportDBDAOSearchChassisLongStayingRSQL").append("\n"); 
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
		query.append("	(SELECT " ).append("\n"); 
		query.append("			M.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("			MDM_CUSTOMER M" ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("			B.CTRT_CUST_CNT_CD = M.CUST_CNT_CD AND " ).append("\n"); 
		query.append("			B.CTRT_CUST_SEQ = M.CUST_SEQ" ).append("\n"); 
		query.append("	) AS SC_CUST_NM," ).append("\n"); 
		query.append("    C.INVT_SEQ," ).append("\n"); 
		query.append("    C.VSL_CD," ).append("\n"); 
		query.append("    C.SKD_VOY_NO," ).append("\n"); 
		query.append("    C.SKD_DIR_CD," ).append("\n"); 
		query.append("    C.BKG_NO," ).append("\n"); 
		query.append("    C.CNTR_NO," ).append("\n"); 
		query.append("    C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    C.CHSS_NO," ).append("\n"); 
		query.append("    C.YD_CD," ).append("\n"); 
		query.append("	E.ECC_CD," ).append("\n"); 
		query.append("    C.FULL_MTY_CD," ).append("\n"); 
		query.append("    C.IO_BND_CD," ).append("\n"); 
		query.append("    C.MVMT_FSH_FLG," ).append("\n"); 
		query.append("    C.MVMT_STS_CD," ).append("\n"); 
		query.append("    C.MVMT_EVNT_DT," ).append("\n"); 
		query.append("    C.FM_MVMT_STS_CD," ).append("\n"); 
		query.append("    TO_CHAR(C.FM_MVMT_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') FM_MVMT_EVNT_DT," ).append("\n"); 
		query.append("    C.YD_STAY_DYS," ).append("\n"); 
		query.append("    C.TML_FREE_DYS," ).append("\n"); 
		query.append("    C.CLK_STOP_DYS," ).append("\n"); 
		query.append("    C.DE_RCV_TERM_CD," ).append("\n"); 
		query.append("    C.CHSS_EXPT_FLG," ).append("\n"); 
		query.append("    C.CLK_STOP_FLG," ).append("\n"); 
		query.append("    C.CHSS_PAY_FLG," ).append("\n"); 
		query.append("    C.AGN_AGMT_NO," ).append("\n"); 
		query.append("    C.CHSS_POOL_CD," ).append("\n"); 
		query.append("    C.CHSS_VNDR_SEQ," ).append("\n"); 
		query.append("    C.CHSS_DLY_CHG_AMT," ).append("\n"); 
		query.append("    C.CHSS_TTL_CHG_AMT," ).append("\n"); 
		query.append("    C.TRK_VNDR_SEQ," ).append("\n"); 
		query.append("    C.POL_POD_YD_CD," ).append("\n"); 
		query.append("    C.POR_DEL_YD_CD," ).append("\n"); 
		query.append("    TO_CHAR(C.ETD_ETA_DT,'YYYY-MM-DD HH24:MI:SS') ETD_ETA_DT," ).append("\n"); 
		query.append("    C.CRE_USR_ID," ).append("\n"); 
		query.append("    C.CRE_DT," ).append("\n"); 
		query.append("    C.UPD_USR_ID," ).append("\n"); 
		query.append("    C.UPD_DT," ).append("\n"); 
		query.append("    CASE WHEN B.SC_NO IS NOT NULL  THEN B.SC_NO" ).append("\n"); 
		query.append("         WHEN B.RFA_NO IS NOT NULL THEN B.RFA_NO||'(RFA)'" ).append("\n"); 
		query.append("         WHEN B.TAA_NO IS NOT NULL THEN B.TAA_NO||'(TAA)'" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("    END  AS SC_RFA_NO," ).append("\n"); 
		query.append("	(SELECT B.VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE C.CHSS_VNDR_SEQ=B.VNDR_SEQ) CHSS_VNDR_NM," ).append("\n"); 
		query.append("	(SELECT B.VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE C.TRK_VNDR_SEQ=B.VNDR_SEQ) TRK_VNDR_NM," ).append("\n"); 
		query.append("    (SELECT REPLACE(SUBSTR(G.CUST_NM,1,50),CHR(13)||CHR(10),' ') FROM BKG_CUSTOMER G WHERE  C.BKG_NO =G.BKG_NO AND G.BKG_CUST_TP_CD ='S') AS SHPR," ).append("\n"); 
		query.append("    (SELECT REPLACE(SUBSTR(G.CUST_NM,1,50),CHR(13)||CHR(10),' ') FROM BKG_CUSTOMER G WHERE  C.BKG_NO =G.BKG_NO AND G.BKG_CUST_TP_CD ='C') AS CNEE," ).append("\n"); 
		query.append("    (SELECT M.CMDT_NM FROM MDM_COMMODITY M WHERE  B.CMDT_CD =M.CMDT_CD) AS CMDT_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	CGM_CHSS_LONG_STAY_INVT C," ).append("\n"); 
		query.append("	BKG_BOOKING B, " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("    	ECC_CD," ).append("\n"); 
		query.append("		Y.YD_CD " ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	    MDM_EQ_ORZ_CHT C," ).append("\n"); 
		query.append("	    MDM_LOCATION L," ).append("\n"); 
		query.append("	    MDM_YARD Y" ).append("\n"); 
		query.append("	WHERE" ).append("\n"); 
		query.append("	    C.SCC_CD = L.SCC_CD AND" ).append("\n"); 
		query.append("	    L.LOC_CD = Y.LOC_CD" ).append("\n"); 
		query.append("	) E" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    C.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("	AND E.YD_CD = C.YD_CD" ).append("\n"); 
		query.append("#if (${bound_cd} == 'Y')" ).append("\n"); 
		query.append("	AND C.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound_cd} == 'N')" ).append("\n"); 
		query.append("	AND C.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${fm_dt} != '' && ${lt_dt} != '') " ).append("\n"); 
		query.append("	AND	C.MVMT_EVNT_DT BETWEEN TO_DATE( REPLACE(@[fm_dt],'-',''), 'YYYYMMDD') AND TO_DATE( REPLACE(@[lt_dt],'-',''), 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${staying_days} != '')" ).append("\n"); 
		query.append(" 	AND C.YD_STAY_DYS >= @[staying_days]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${beyond_fdays} != '')" ).append("\n"); 
		query.append("	AND C.CLK_STOP_DYS >= @[beyond_fdays]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mvmt_sts_cd_list} != '')" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   	#foreach($mvmt_sts_cd in ${mvmt_sts_cd_list})" ).append("\n"); 
		query.append("   		#if($velocityCount < $mvmt_sts_cd_list.size())" ).append("\n"); 
		query.append("   			C.FM_MVMT_STS_CD  = '$mvmt_sts_cd' OR" ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			C.FM_MVMT_STS_CD = '$mvmt_sts_cd'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("   	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no_list} != '') 	-- BKG NO" ).append("\n"); 
		query.append("   	AND (" ).append("\n"); 
		query.append("   	#foreach($bkg_no in ${bkg_no_list})" ).append("\n"); 
		query.append("   		#if($velocityCount < $bkg_no_list.size())" ).append("\n"); 
		query.append("   			C.BKG_NO = '$bkg_no' OR" ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			C.BKG_NO = '$bkg_no'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("   	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no_list} != '') 	-- CNTR NO" ).append("\n"); 
		query.append("   	AND (" ).append("\n"); 
		query.append("   	#foreach($cntr_no in ${cntr_no_list})" ).append("\n"); 
		query.append("   		#if($velocityCount < $cntr_no_list.size())" ).append("\n"); 
		query.append("   			C.CNTR_NO = '$cntr_no' OR" ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			C.CNTR_NO = '$cntr_no'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("   	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_list} != '') 	-- TP/SZ" ).append("\n"); 
		query.append("   	AND (" ).append("\n"); 
		query.append("   	#foreach($cntr_tpsz_cd in ${cntr_tpsz_cd_list})" ).append("\n"); 
		query.append("   		#if($velocityCount < $cntr_tpsz_cd_list.size())" ).append("\n"); 
		query.append("   			C.CNTR_TPSZ_CD = '$cntr_tpsz_cd' OR" ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			C.CNTR_TPSZ_CD = '$cntr_tpsz_cd'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("   	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   #if (${sc_no_list} != '') 	-- S/C NO" ).append("\n"); 
		query.append("   	AND (" ).append("\n"); 
		query.append("   	#foreach($sc_no in ${sc_no_list})" ).append("\n"); 
		query.append("   		#if($velocityCount < $sc_no_list.size())" ).append("\n"); 
		query.append("   			B.SC_NO = '$sc_no' OR" ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			B.SC_NO = '$sc_no'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("   	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_list_list} != '') 	-- Location" ).append("\n"); 
		query.append("   	AND C.YD_CD in (SELECT " ).append("\n"); 
		query.append("						Y.YD_CD" ).append("\n"); 
		query.append("					FROM" ).append("\n"); 
		query.append("					    MDM_EQ_ORZ_CHT C," ).append("\n"); 
		query.append("					    MDM_LOCATION L," ).append("\n"); 
		query.append("					    MDM_YARD Y" ).append("\n"); 
		query.append("					WHERE" ).append("\n"); 
		query.append("					    C.SCC_CD = L.SCC_CD AND" ).append("\n"); 
		query.append("					    L.LOC_CD = Y.LOC_CD AND	(" ).append("\n"); 
		query.append("			#foreach($loc_list in ${loc_list_list})" ).append("\n"); 
		query.append("				#if($velocityCount < $loc_list_list.size())			" ).append("\n"); 
		query.append("					#if (${loc_cd} == 'R')" ).append("\n"); 
		query.append("						C.RCC_CD = '$loc_list' OR" ).append("\n"); 
		query.append("					#end	" ).append("\n"); 
		query.append("					#if (${loc_cd} == 'L')" ).append("\n"); 
		query.append("						C.LCC_CD = '$loc_list' OR" ).append("\n"); 
		query.append("					#end	" ).append("\n"); 
		query.append("					#if (${loc_cd} == 'E')" ).append("\n"); 
		query.append("						C.ECC_CD = '$loc_list' OR" ).append("\n"); 
		query.append("	  				#end	" ).append("\n"); 
		query.append("	  				#if (${loc_cd} == 'S')" ).append("\n"); 
		query.append("  						C.SCC_CD = '$loc_list' OR" ).append("\n"); 
		query.append("  					#end	" ).append("\n"); 
		query.append("  					#if (${loc_cd} == 'Y')" ).append("\n"); 
		query.append("  						Y.YD_CD = '$loc_list' OR" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#else		" ).append("\n"); 
		query.append("	   				#if (${loc_cd} == 'R')" ).append("\n"); 
		query.append("						C.RCC_CD = '$loc_list'" ).append("\n"); 
		query.append("					#end	" ).append("\n"); 
		query.append("					#if (${loc_cd} == 'L')" ).append("\n"); 
		query.append("						C.LCC_CD = '$loc_list'" ).append("\n"); 
		query.append("					#end	" ).append("\n"); 
		query.append("		  			#if (${loc_cd} == 'E')" ).append("\n"); 
		query.append("						C.ECC_CD = '$loc_list'" ).append("\n"); 
		query.append("					#end	" ).append("\n"); 
		query.append("					#if (${loc_cd} == 'S')" ).append("\n"); 
		query.append("						C.SCC_CD = '$loc_list'" ).append("\n"); 
		query.append("					#end	" ).append("\n"); 
		query.append("					#if (${loc_cd} == 'Y')" ).append("\n"); 
		query.append("						Y.YD_CD = '$loc_list'" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_no_list} != '') 	-- VVD 검색조건 있을때만 사용" ).append("\n"); 
		query.append("		AND (" ).append("\n"); 
		query.append("    	#foreach($vvd_no in ${vvd_no_list})" ).append("\n"); 
		query.append("    		#if($velocityCount < $vvd_no_list.size())" ).append("\n"); 
		query.append("    			(C.VSL_CD = SUBSTR('$vvd_no', 1, 4) AND C.SKD_VOY_NO = SUBSTR('$vvd_no', 5, 4) AND C.SKD_DIR_CD = SUBSTR('$vvd_no', 9, 1)) OR" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("    			(C.VSL_CD = SUBSTR('$vvd_no', 1, 4) AND C.SKD_VOY_NO = SUBSTR('$vvd_no', 5, 4) AND C.SKD_DIR_CD = SUBSTR('$vvd_no', 9, 1))" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
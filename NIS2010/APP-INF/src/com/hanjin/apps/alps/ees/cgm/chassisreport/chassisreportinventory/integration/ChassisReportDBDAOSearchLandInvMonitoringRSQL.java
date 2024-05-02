/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisReportDBDAOSearchLandInvMonitoringRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisReportDBDAOSearchLandInvMonitoringRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Land Inventory Monitoring 조회
	  * - CHM-201534671, 신용찬, 1. COP_HDR 에서 MASTER='Y' 인 MST_BKG_NO 로 TRS 정보를 조회(TRS는 MASTER BKG 으로 W/O 생성)
	  *                                        2. FACTORY NAME 정보 추가
	  *                                        3. NTFY 조회 되던 내용 CNEE 로 수정
	  *                                        4. VVD 검색조건 추가, (EVENT DATE 는 OPTINAL)
	  * - CHM-201537162, 신용찬, TRS W/O FM ND 추가, TRS W/O 연결조건 변경
	  * - 2015 조직코드개편 Chang-Young Kim
	  * </pre>
	  */
	public ChassisReportDBDAOSearchLandInvMonitoringRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_del_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finish_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hdn_lt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hdn_fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdn_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdn_fm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdn_org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.integration").append("\n"); 
		query.append("FileName : ChassisReportDBDAOSearchLandInvMonitoringRSQL").append("\n"); 
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
		query.append("WITH LV_PARM AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT MVMT_CD," ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'MG' THEN 'ID'" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'MP' THEN 'MT'  -- 최초 장비 on-hire한 mt" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'MO' THEN 'ENTN'" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'VD(MTY)'  THEN 'VD'" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'VD(Full)' THEN 'VD'   " ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'VL(MTY)'  THEN 'MT'" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'VL(Full)' THEN 'OCTS'        " ).append("\n"); 
		query.append("                ELSE SUBSTR(MVMT_CD,1,2) " ).append("\n"); 
		query.append("           END WHERE_MVMT," ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'MG' THEN 'MT'" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'MP' THEN ''" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'MO' THEN 'MT'" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'VD(MTY)'  THEN 'MT'" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'VD(Full)' THEN 'ICTS'" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'VL(MTY)' THEN  'VL'" ).append("\n"); 
		query.append("                WHEN MVMT_CD = 'VL(Full)' THEN 'VL'" ).append("\n"); 
		query.append("                WHEN INSTR(MVMT_CD,'-') > 0 THEN SUBSTR(MVMT_CD,4,2)" ).append("\n"); 
		query.append("                ELSE ''" ).append("\n"); 
		query.append("           END TO_DT_MVMT  " ).append("\n"); 
		query.append("    FROM (SELECT @[mvmt_sts_cd] MVMT_CD FROM DUAL)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",LV_CNTR_LIST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  M.SYS_AREA_GRP_ID," ).append("\n"); 
		query.append("            P.MVMT_CD," ).append("\n"); 
		query.append("            P.TO_DT_MVMT," ).append("\n"); 
		query.append("            M.CNTR_NO," ).append("\n"); 
		query.append("            M.MVMT_STS_CD," ).append("\n"); 
		query.append("            G.LCC_CD," ).append("\n"); 
		query.append("            G.ECC_CD," ).append("\n"); 
		query.append("            G.SCC_CD," ).append("\n"); 
		query.append("            L.LOC_CD," ).append("\n"); 
		query.append("            DECODE(M.MVMT_STS_CD,'MT',NULL,M.BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("            DECODE(M.MVMT_STS_CD,'MT',NULL,M.BL_NO) AS BL_NO," ).append("\n"); 
		query.append("            -- CHM-201534671, 신용찬, COP_HDR 에서 MASTER='Y' 인 MST_BKG_NO 로 TRS 정보를 조회(TRS는 MASTER BKG 으로 W/O 생성)" ).append("\n"); 
		query.append("            -- COP MASTER = Y 인 데이터 미리 발췌하여 TRS INFO 에서는 MST_BKG_NO 를 BKG_NO 대신 사용" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT CASE WHEN A.COP_NO = A.MST_COP_NO THEN DECODE(M.MVMT_STS_CD,'MT',NULL,M.BKG_NO)" ).append("\n"); 
		query.append("                                                         ELSE (" ).append("\n"); 
		query.append("                                                                 SELECT BKG_NO FROM SCE_COP_HDR" ).append("\n"); 
		query.append("                                                                 WHERE COP_NO =" ).append("\n"); 
		query.append("                                                                        (" ).append("\n"); 
		query.append("                                                                            SELECT A.MST_COP_NO FROM SCE_COP_HDR A" ).append("\n"); 
		query.append("                                                                            WHERE BKG_NO = DECODE(M.MVMT_STS_CD,'MT',NULL,M.BKG_NO)" ).append("\n"); 
		query.append("                                                                            AND   CNTR_NO= M.CNTR_NO  " ).append("\n"); 
		query.append("                                                                         )                                                         " ).append("\n"); 
		query.append("                                                         " ).append("\n"); 
		query.append("                                                              )" ).append("\n"); 
		query.append("                       END                                       " ).append("\n"); 
		query.append("                FROM SCE_COP_HDR A" ).append("\n"); 
		query.append("                WHERE BKG_NO  = DECODE(M.MVMT_STS_CD,'MT',NULL,M.BKG_NO) " ).append("\n"); 
		query.append("                AND   CNTR_NO = M.CNTR_NO   " ).append("\n"); 
		query.append("                AND   ROWNUM = 1      " ).append("\n"); 
		query.append("            ) MST_BKG_NO, " ).append("\n"); 
		query.append("            M.CNMV_YR," ).append("\n"); 
		query.append("            M.CNMV_ID_NO," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                -- MO 가 아닌 경우 체크 위함" ).append("\n"); 
		query.append("                SELECT /*+ INDEX (M2 XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("                       M2.MVMT_STS_CD||'$'||TO_CHAR(M2.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS')||'$'||CEIL((M2.CNMV_EVNT_DT-M.CNMV_EVNT_DT))||'$'||M2.ORG_YD_CD||'$'||NVL(M2.MVMT_CRE_TP_CD,'C')||'$'||M2.CNMV_CYC_NO" ).append("\n"); 
		query.append("                FROM CTM_MOVEMENT M2" ).append("\n"); 
		query.append("                WHERE M2.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("                AND M2.CNMV_YR || TO_CHAR(M2.CNMV_SEQ, '0000') ||M2.CNMV_SPLIT_NO > M.CNMV_YR||TO_CHAR(M.CNMV_SEQ,'0000')||M.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                AND M2.MVMT_STS_CD IN(M2.MVMT_STS_CD,SUBSTR(P.TO_DT_MVMT,1,2),SUBSTR(P.TO_DT_MVMT,3,2))" ).append("\n"); 
		query.append("                AND P.MVMT_CD <> 'MO'" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                -- MO 경우에 한해 체크 위함" ).append("\n"); 
		query.append("                SELECT /*+ ORDERED USE_NL(M2 LL GG) INDEX_ASC ( M2 XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("        #if (${loc_cd} == 'R') " ).append("\n"); 
		query.append("        			CASE WHEN GG.RCC_CD = G.RCC_CD THEN NULL -- 화면 LOC LEVEL 따라 (RCC 선택된 경우)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${loc_cd} == 'L') " ).append("\n"); 
		query.append("        			CASE WHEN GG.LCC_CD = G.LCC_CD THEN NULL -- 화면 LOC LEVEL 따라 (LCC 선택된 경우)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${loc_cd} == 'E') " ).append("\n"); 
		query.append("        			CASE WHEN GG.ECC_CD = G.ECC_CD THEN NULL -- 화면 LOC LEVEL 따라 (ECC 선택된 경우)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${loc_cd} == 'S') " ).append("\n"); 
		query.append("        			CASE WHEN GG.SCC_CD = G.SCC_CD THEN NULL -- 화면 LOC LEVEL 따라 (SCC 선택된 경우)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${loc_cd} == 'Y') " ).append("\n"); 
		query.append("        			CASE WHEN M2.ORG_YD_CD = Y.YD_CD THEN NULL -- 화면 LOC LEVEL 따라 (YD_CD 선택된 경우)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                            ELSE M2.MVMT_STS_CD||'$'||TO_CHAR(M2.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS')||'$'||CEIL((M2.CNMV_EVNT_DT-M.CNMV_EVNT_DT))||'$'||M2.ORG_YD_CD||'$'||NVL(M2.MVMT_CRE_TP_CD,'C')||'$'||M2.CNMV_CYC_NO" ).append("\n"); 
		query.append("                       END     " ).append("\n"); 
		query.append("                FROM CTM_MOVEMENT  M2" ).append("\n"); 
		query.append("                   , MDM_LOCATION  LL" ).append("\n"); 
		query.append("                   , MDM_EQ_ORZ_CHT  GG" ).append("\n"); 
		query.append("                WHERE M2.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("                AND  M2.CNMV_YR || TO_CHAR(M2.CNMV_SEQ, '0000') ||M2.CNMV_SPLIT_NO > M.CNMV_YR||TO_CHAR(M.CNMV_SEQ,'0000')||M.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                AND SUBSTR(M2.ORG_YD_CD, 1, 5)  = LL.LOC_CD" ).append("\n"); 
		query.append("                AND LL.SCC_CD                   = GG.SCC_CD" ).append("\n"); 
		query.append("                AND M2.MVMT_STS_CD              = 'MT'        " ).append("\n"); 
		query.append("                AND M2.CNMV_CYC_NO              = M.CNMV_CYC_NO" ).append("\n"); 
		query.append("                AND M2.FCNTR_FLG                = 'N'" ).append("\n"); 
		query.append("                AND P.MVMT_CD                   = 'MO'" ).append("\n"); 
		query.append("                AND ROWNUM    = 1         " ).append("\n"); 
		query.append("            ) LT_INFO" ).append("\n"); 
		query.append("    FROM CTM_MOVEMENT M " ).append("\n"); 
		query.append("       , MDM_EQ_ORZ_CHT G" ).append("\n"); 
		query.append("       , MDM_LOCATION L " ).append("\n"); 
		query.append("       , MDM_YARD Y " ).append("\n"); 
		query.append("       , LV_PARM P" ).append("\n"); 
		query.append("#if (${vvd_no_list} != '') 	-- VVD 검색조건 있을때만 사용" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT M.BKG_NO FROM BKG_BOOKING M" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("    	    AND (" ).append("\n"); 
		query.append("    	#foreach($vvd_no in ${vvd_no_list})" ).append("\n"); 
		query.append("    		#if($velocityCount < $vvd_no_list.size())" ).append("\n"); 
		query.append("    			(M.VSL_CD = SUBSTR('$vvd_no', 1, 4) AND M.SKD_VOY_NO = SUBSTR('$vvd_no', 5, 4) AND M.SKD_DIR_CD = SUBSTR('$vvd_no', 9, 1)) OR" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("    			(M.VSL_CD = SUBSTR('$vvd_no', 1, 4) AND M.SKD_VOY_NO = SUBSTR('$vvd_no', 5, 4) AND M.SKD_DIR_CD = SUBSTR('$vvd_no', 9, 1))" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	        )" ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd_no_list} != '') 	-- VVD 검색조건 있을때만 사용" ).append("\n"); 
		query.append("    AND   M.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_dt} != '' && ${lt_dt} != '') " ).append("\n"); 
		query.append("    AND   M.CNMV_EVNT_DT BETWEEN  TO_DATE( REPLACE(@[fm_dt],'-',''), 'YYYYMMDD') AND TO_DATE( REPLACE(@[lt_dt],'-',''), 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND   M.MVMT_STS_CD IN(SUBSTR(P.WHERE_MVMT,1,2),SUBSTR(P.WHERE_MVMT,3,2))" ).append("\n"); 
		query.append("    AND   M.ORG_YD_CD   = Y.YD_CD" ).append("\n"); 
		query.append("    AND   Y.LOC_CD      = L.LOC_CD" ).append("\n"); 
		query.append("    AND   L.SCC_CD      = G.SCC_CD" ).append("\n"); 
		query.append("    #if (${loc_list_list} != '') 	-- Location" ).append("\n"); 
		query.append("    	AND (" ).append("\n"); 
		query.append("    	#foreach($loc_list in ${loc_list_list})" ).append("\n"); 
		query.append("    		#if($velocityCount < $loc_list_list.size())			" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'R')" ).append("\n"); 
		query.append("    				G.RCC_CD = '$loc_list' OR" ).append("\n"); 
		query.append("    			#end	" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'L')" ).append("\n"); 
		query.append("    				G.LCC_CD = '$loc_list' OR" ).append("\n"); 
		query.append("    			#end	" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'E')" ).append("\n"); 
		query.append("    				G.ECC_CD = '$loc_list' OR" ).append("\n"); 
		query.append("    			#end	" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'S')" ).append("\n"); 
		query.append("    				G.SCC_CD = '$loc_list' OR" ).append("\n"); 
		query.append("    			#end	" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'Y')" ).append("\n"); 
		query.append("    				M.ORG_YD_CD = '$loc_list' OR" ).append("\n"); 
		query.append("    			#end" ).append("\n"); 
		query.append("    		#else		" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'R')" ).append("\n"); 
		query.append("    				G.RCC_CD = '$loc_list'" ).append("\n"); 
		query.append("    			#end	" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'L')" ).append("\n"); 
		query.append("    				G.LCC_CD = '$loc_list'" ).append("\n"); 
		query.append("    			#end	" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'E')" ).append("\n"); 
		query.append("    				G.ECC_CD = '$loc_list'" ).append("\n"); 
		query.append("    			#end	" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'S')" ).append("\n"); 
		query.append("    				G.SCC_CD = '$loc_list'" ).append("\n"); 
		query.append("    			#end	" ).append("\n"); 
		query.append("    			#if (${loc_cd} == 'Y')" ).append("\n"); 
		query.append("    				M.ORG_YD_CD = '$loc_list'" ).append("\n"); 
		query.append("    			#end" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${hdn_org_yd_cd} != '')" ).append("\n"); 
		query.append("    	AND ORG_YD_CD = @[hdn_org_yd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND   (CASE WHEN P.MVMT_CD = 'MO' THEN NVL(M.MVMT_CRE_TP_CD, '  ') ELSE '1' END)  NOT IN('C','L')" ).append("\n"); 
		query.append("    AND   (  ((CASE WHEN P.MVMT_CD = 'MP' THEN M.CNMV_CYC_NO ELSE -1 END)  = (CASE WHEN P.MVMT_CD = 'MP' THEN 1 ELSE -1 END)) OR" ).append("\n"); 
		query.append("             ((CASE WHEN P.MVMT_CD = 'MP' THEN M.CNMV_RMK ELSE '1' END)  =   (CASE WHEN P.MVMT_CD = 'MP' THEN 'LSI' ELSE '1' END))" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("    AND   (CASE WHEN  SUBSTR(P.MVMT_CD,1,2) IN ('EN','TN') THEN M.FCNTR_FLG " ).append("\n"); 
		query.append("                ELSE '1' " ).append("\n"); 
		query.append("           END) " ).append("\n"); 
		query.append("         =(CASE WHEN P.MVMT_CD IN ('EN(MTY)','TN(MTY)')   THEN 'N'" ).append("\n"); 
		query.append("                WHEN P.MVMT_CD IN ('EN(Full)','TN(Full)') THEN 'Y'" ).append("\n"); 
		query.append("                ELSE '1' " ).append("\n"); 
		query.append("            END)" ).append("\n"); 
		query.append("    #if (${cntr_no_list} != '') 	-- CNTR NO" ).append("\n"); 
		query.append("    	AND (" ).append("\n"); 
		query.append("    	#foreach($cntr_no in ${cntr_no_list})" ).append("\n"); 
		query.append("    		#if($velocityCount < $cntr_no_list.size())" ).append("\n"); 
		query.append("    			M.CNTR_NO = '$cntr_no' OR" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("    			M.CNTR_NO = '$cntr_no'" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd_list} != '') 	-- TP/SZ" ).append("\n"); 
		query.append("    	AND (" ).append("\n"); 
		query.append("    	#foreach($cntr_tpsz_cd in ${cntr_tpsz_cd_list})" ).append("\n"); 
		query.append("    		#if($velocityCount < $cntr_tpsz_cd_list.size())" ).append("\n"); 
		query.append("    			M.CNTR_TPSZ_CD = '$cntr_tpsz_cd' OR" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("    			M.CNTR_TPSZ_CD = '$cntr_tpsz_cd'" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${hdn_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND CNTR_TPSZ_CD = @[hdn_cntr_tpsz_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",LV_CNTR_INFO AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A.SYS_AREA_GRP_ID," ).append("\n"); 
		query.append("           A.MVMT_CD," ).append("\n"); 
		query.append("           A.TO_DT_MVMT," ).append("\n"); 
		query.append("           A.LCC_CD," ).append("\n"); 
		query.append("           A.ECC_CD," ).append("\n"); 
		query.append("           A.SCC_CD," ).append("\n"); 
		query.append("           A.LOC_CD," ).append("\n"); 
		query.append("           C.ORG_YD_CD," ).append("\n"); 
		query.append("           C.CNTR_NO," ).append("\n"); 
		query.append("           C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           C.FCNTR_FLG," ).append("\n"); 
		query.append("           DECODE(LTRIM(SUBSTR(A.LT_INFO,1,2)),NULL,'N','Y') FINISHED," ).append("\n"); 
		query.append("           -- If finished, From MVMT Event Date ~ Latter MVMT Event Date,If not, From MVMT Event Date ~ Today (data retrieved date)" ).append("\n"); 
		query.append("           -- 2014.07.04 Gi Chul Kim Modifed (S)" ).append("\n"); 
		query.append("           -- TO_NUMBER(SUBSTR(A.LT_INFO, INSTR(A.LT_INFO, '$', 1, 2) + 1, INSTR(A.LT_INFO, '$', 1, 3) - INSTR(A.LT_INFO, '$', 1, 2) - 1)) AS STAY_DYS," ).append("\n"); 
		query.append("           CASE WHEN DECODE(LTRIM(SUBSTR(A.LT_INFO,1,2)),NULL,'N','Y') = 'Y' THEN        " ).append("\n"); 
		query.append("                     TO_NUMBER(SUBSTR(A.LT_INFO, INSTR(A.LT_INFO, '$', 1, 2) + 1, INSTR(A.LT_INFO, '$', 1, 3) - INSTR(A.LT_INFO, '$', 1, 2) - 1))" ).append("\n"); 
		query.append("                ELSE CEIL(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,SUBSTR(C.ORG_YD_CD,1,5)) - C.CNMV_EVNT_DT)" ).append("\n"); 
		query.append("           END AS STAY_DYS," ).append("\n"); 
		query.append("           -- 2014.07.04 Gi Chul Kim Modifed (E)" ).append("\n"); 
		query.append("           C.MVMT_STS_CD AS FM_STS_CD," ).append("\n"); 
		query.append("           C.CNMV_EVNT_DT AS FM_DT," ).append("\n"); 
		query.append("		   CGM_SUBSTR_FNC(A.LT_INFO, 3, '$') AS LT_YD_CD, " ).append("\n"); 
		query.append("           SUBSTR(A.LT_INFO,1,2) LT_STS_CD," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.LT_INFO, 1, '$') AS LT_DT, " ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.LT_INFO, 4, '$') AS LT_CRE_TP," ).append("\n"); 
		query.append("           --수정      " ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("                SELECT  TO_NUMBER(SUBSTR(MAX(NVL(TO_CHAR(FT_END_DT,'YYYY-MM-DD'),'1111-11-11')||LTRIM(TO_CHAR(FT_DYS,'0000'))),11))" ).append("\n"); 
		query.append("                FROM DMT_CHG_CALC E" ).append("\n"); 
		query.append("                    ,DMT_CHG_BKG_CNTR F" ).append("\n"); 
		query.append("                WHERE E.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                AND   E.SYS_AREA_GRP_ID  =  C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                AND   E.CNTR_CYC_NO = C.CNMV_CYC_NO" ).append("\n"); 
		query.append("                AND   E.CHG_SEQ = 1" ).append("\n"); 
		query.append("                AND   E.FM_MVMT_YD_CD = C.ORG_YD_CD" ).append("\n"); 
		query.append("                AND   E.DMDT_CHG_STS_CD <> 'E'" ).append("\n"); 
		query.append("                AND   F.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                AND   F.SYS_AREA_GRP_ID  = E.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                AND   F.CNTR_CYC_NO = E.CNTR_CYC_NO" ).append("\n"); 
		query.append("                AND   F.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                AND   C.MVMT_STS_CD NOT IN ('TS','MT')" ).append("\n"); 
		query.append("           ) AS FREE_DAYS,       " ).append("\n"); 
		query.append("            --수정         " ).append("\n"); 
		query.append("           DECODE(C.OB_CNTR_FLG,'Y',B.RCV_TERM_CD,'N', B.DE_TERM_CD,'') DE_TERM_CD, -- 2014.07.01 Chang Young Kim Updated In accordance with the 'CHM-201430787'" ).append("\n"); 
		query.append("           CASE WHEN B.SC_NO IS NOT NULL  THEN B.SC_NO" ).append("\n"); 
		query.append("                WHEN B.RFA_NO IS NOT NULL THEN B.RFA_NO||'(RFA)'" ).append("\n"); 
		query.append("                WHEN B.TAA_NO IS NOT NULL THEN B.TAA_NO||'(TAA)'" ).append("\n"); 
		query.append("                ELSE ''" ).append("\n"); 
		query.append("           END  SC_RFA_NO," ).append("\n"); 
		query.append("           (SELECT M.CUST_LGL_ENG_NM FROM MDM_CUSTOMER M WHERE CTRT_CUST_CNT_CD = M.CUST_CNT_CD AND B.CTRT_CUST_SEQ = M.CUST_SEQ) AS SC_CUST_NM," ).append("\n"); 
		query.append("           --수정" ).append("\n"); 
		query.append("           CASE WHEN  C.MVMT_STS_CD IN('OP','ID') AND DECODE(C.OB_CNTR_FLG,'Y',B.RCV_TERM_CD,'N', B.DE_TERM_CD,'') <> 'D' THEN -- 2014.07.01 Chang Young Kim, 'CHM-201430787'" ).append("\n"); 
		query.append("                      (CASE WHEN SUBSTR(C.CNTR_TPSZ_CD,1,1) = 'R'  AND  B.DEL_CD = 'USOAK' AND C.OB_CNTR_FLG = 'N'  AND " ).append("\n"); 
		query.append("                                (SELECT C.RD_CGO_FLG FROM BKG_CONTAINER C WHERE A.BKG_NO= C.BKG_NO AND A.CNTR_NO=C.CNTR_NO) ='N' " ).append("\n"); 
		query.append("                                THEN 'Y'" ).append("\n"); 
		query.append("                            --20150401 추가, 신용찬, SC=AEN110235, DOOR 아니고 POD 가 지정된 곳이며, OB_CNTR_FLG=N 이면 EXCEPTION     " ).append("\n"); 
		query.append("                            WHEN  B.SC_NO='AEN110235' AND C.OB_CNTR_FLG = 'N' AND B.POD_CD IN ('CAPRR','CAVAN','USSEA','USTIW','USPDX','USOAK','USLAX','USLGB')  " ).append("\n"); 
		query.append("                                THEN 'Y' " ).append("\n"); 
		query.append("                            -- SC=AEN110235, DOOR 아니고 POD 가 지정된 곳 아니고, DEL_CD 가 지정된 곳이고, OB_CNTR_FLG=N 이면  N 리턴 (EXCEPTION 아님)" ).append("\n"); 
		query.append("                            WHEN  B.SC_NO='AEN110235' AND C.OB_CNTR_FLG = 'N' AND B.POD_CD NOT IN ('CAPRR','CAVAN','USSEA','USTIW','USPDX','USOAK','USLAX','USLGB')" ).append("\n"); 
		query.append("                                  AND B.DEL_CD IN ('USADV','USCSF','USCHS','USZGB','USGSA','USHGR','USJAX','USISM','USMVP','USNYC','USORF','USNWB','USPFP','USPPY','USPFD','USPWN','USSAV','USSVH','USTHM','USVLD','USBAF','USILM')" ).append("\n"); 
		query.append("                                THEN 'N'" ).append("\n"); 
		query.append("                            ELSE      " ).append("\n"); 
		query.append("                                DECODE(CGM_SC_EXP_CHK_FNC(C.CNTR_NO,C.CNMV_CYC_NO,C.CNMV_EVNT_DT,C.MVMT_STS_CD,B.SC_NO,A.SCC_CD,C.CNTR_TPSZ_CD,C.BKG_NO),'0','Y','1','N')" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("                ELSE 'N' " ).append("\n"); 
		query.append("           END  AS CHZ_EXCEPT," ).append("\n"); 
		query.append("           --수정" ).append("\n"); 
		query.append("           C.VNDR_SEQ AS TRK_VNDR_SEQ," ).append("\n"); 
		query.append("           C.CHSS_NO," ).append("\n"); 
		query.append("           A.BKG_NO," ).append("\n"); 
		query.append("           A.BL_NO," ).append("\n"); 
		query.append("           C.OB_CNTR_FLG," ).append("\n"); 
		query.append("           B.POL_NOD_CD,B.POD_NOD_CD," ).append("\n"); 
		query.append("           DECODE(C.OB_CNTR_FLG,'Y','O','I') AS BND_CD," ).append("\n"); 
		query.append("           DECODE(C.OB_CNTR_FLG,'Y',B.POL_NOD_CD,B.POD_NOD_CD) AS POL_POD_NOD," ).append("\n"); 
		query.append("           DECODE(C.OB_CNTR_FLG,'Y',B.POR_NOD_CD,B.DEL_NOD_CD) AS POR_DEL_NOD," ).append("\n"); 
		query.append("           B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS TRNK_VVD," ).append("\n"); 
		query.append("           DECODE(C.OB_CNTR_FLG,'Y',B.POL_ETD_DT,B.POL_ETD_DT) AS POLETD_PODETA," ).append("\n"); 
		query.append("           (SELECT REPLACE(SUBSTR(G.CUST_NM,1,50),CHR(13)||CHR(10),' ') FROM BKG_CUSTOMER G WHERE  A.BKG_NO =G.BKG_NO AND G.BKG_CUST_TP_CD ='S') AS SHPR," ).append("\n"); 
		query.append("           (SELECT REPLACE(SUBSTR(G.CUST_NM,1,50),CHR(13)||CHR(10),' ') FROM BKG_CUSTOMER G WHERE  A.BKG_NO =G.BKG_NO AND G.BKG_CUST_TP_CD ='C') AS CNEE, -- NTFY-->CNEE 로 수정" ).append("\n"); 
		query.append("           (SELECT M.CMDT_NM FROM MDM_COMMODITY M WHERE  B.CMDT_CD =M.CMDT_CD) AS CMDT_NM," ).append("\n"); 
		query.append("           (SELECT C.RD_CGO_FLG FROM BKG_CONTAINER C WHERE A.BKG_NO= C.BKG_NO AND A.CNTR_NO=C.CNTR_NO) AS RD_CGO_FLG," ).append("\n"); 
		query.append("           C.CNTR_DMG_FLG," ).append("\n"); 
		query.append("           B.CTRT_OFC_CD," ).append("\n"); 
		query.append("           (SELECT SREP_NM FROM MDM_SLS_REP WHERE SREP_CD = B.CTRT_SREP_CD) AS SREP_NM," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("               SELECT  C.DMDT_CHG_STS_CD||'$'||" ).append("\n"); 
		query.append("                       C.FM_MVMT_STS_CD||'$'||" ).append("\n"); 
		query.append("                       C.TO_MVMT_STS_CD||'$'||" ).append("\n"); 
		query.append("                       C.DMDT_TRF_CD||'$'||" ).append("\n"); 
		query.append("                       C.FT_DYS||'$'||" ).append("\n"); 
		query.append("                       C.FX_FT_OVR_DYS||'$'||" ).append("\n"); 
		query.append("                       TO_CHAR(C.FM_MVMT_DT, 'YYYY-MM-DD')||'$'||" ).append("\n"); 
		query.append("                       TO_CHAR(C.TO_MVMT_DT, 'YYYY-MM-DD')||'$'||" ).append("\n"); 
		query.append("                       (" ).append("\n"); 
		query.append("                       SELECT TO_CHAR(CM.CNMV_EVNT_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                       FROM   CTM_MOVEMENT CM" ).append("\n"); 
		query.append("                       WHERE  CM.CNTR_NO     = C.CNTR_NO" ).append("\n"); 
		query.append("                       AND    CM.CNMV_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                       AND    CM.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("                       AND    ROWNUM         = 1" ).append("\n"); 
		query.append("                       )||'$'||              " ).append("\n"); 
		query.append("                       TO_CHAR(C.FT_CMNC_DT, 'YYYY-MM-DD')||'$'||" ).append("\n"); 
		query.append("                       TO_CHAR(C.FT_END_DT, 'YYYY-MM-DD')||'$'||" ).append("\n"); 
		query.append("                       C.BZC_TRF_CURR_CD||'$'||" ).append("\n"); 
		query.append("                       C.BIL_AMT||'$'||" ).append("\n"); 
		query.append("                       NVL(C.UCLM_FLG,'N')||'$'" ).append("\n"); 
		query.append("                 FROM DMT_CHG_CALC C" ).append("\n"); 
		query.append("                 WHERE (C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO) IN (" ).append("\n"); 
		query.append("                             SELECT D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                   ,D.CNTR_NO" ).append("\n"); 
		query.append("                                   ,D.CNTR_CYC_NO" ).append("\n"); 
		query.append("                             FROM DMT_CHG_BKG_CNTR D" ).append("\n"); 
		query.append("                             WHERE D.SYS_AREA_GRP_ID = A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                             AND   D.CNTR_NO=A.CNTR_NO" ).append("\n"); 
		query.append("                             AND   D.BKG_NO=A.BKG_NO )" ).append("\n"); 
		query.append("                 AND  C.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                 AND  C.FM_MVMT_STS_CD in (A.MVMT_STS_CD, decode(A.MVMT_STS_CD, 'IC', 'VD'))" ).append("\n"); 
		query.append("                 AND  ROWNUM=1" ).append("\n"); 
		query.append("            ) AS DMT_INFO," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                 --CHM-201537162, 신용찬, TRS W/O FM ND 추가, TRS W/O 연결조건 변경" ).append("\n"); 
		query.append("                 SELECT  (CASE WHEN SO.HJL_NO IS NOT NULL " ).append("\n"); 
		query.append("                            THEN (SELECT HJL_VNDR_SEQ " ).append("\n"); 
		query.append("                                 FROM TRS_TRSP_HJL_SVC_ORD " ).append("\n"); 
		query.append("                                 WHERE TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                 AND TRSP_SO_SEQ = SO.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                            ELSE SO.VNDR_SEQ" ).append("\n"); 
		query.append("                       END) ||'$'||" ).append("\n"); 
		query.append("                       TO_CHAR (SO.APNT_DT, 'YYYY-MM-DD HH24:MI:SS')||'$'||" ).append("\n"); 
		query.append("                       TO_CHAR (SO.DE_DT, 'YYYY-MM-DD HH24:MI:SS')||'$'||" ).append("\n"); 
		query.append("                       WRK.TRSP_INV_AUD_STS_CD||'$'||" ).append("\n"); 
		query.append("                       TO_CHAR (WRK.INV_CFM_DT, 'YYYY-MM-DD')||'$'||D.USR_NM||'$'||                    -- 2014.07.01 Chang Young Kim Updated In accordance with the 'CHM-201430787'" ).append("\n"); 
		query.append("                       SO.FM_NOD_CD||'$'||  -- 2015.07.22 Door W/O From 정보 추가, 신용찬, (요청 by 지연 차장)  " ).append("\n"); 
		query.append("                       REPLACE(REPLACE(REPLACE(SO.FCTRY_NM, CHR(13), ' '), CHR(10), ' '), CHR(34), '') -- 2015.03.17, FACTORY NAME 추가, Shin YongChan" ).append("\n"); 
		query.append("                 FROM  TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                      ,TRS_TRSP_WRK_ORD WO " ).append("\n"); 
		query.append("                      ,TRS_TRSP_INV_WRK WRK" ).append("\n"); 
		query.append("                      ,COM_USER D" ).append("\n"); 
		query.append("                 WHERE A.CNTR_NO             = SO.EQ_NO(+)" ).append("\n"); 
		query.append("                 -- CHM-201534671, 신용찬, COP_HDR 에서 MASTER='Y' 인 MST_BKG_NO 로 TRS 정보를 조회(TRS는 MASTER BKG 으로 W/O 생성)" ).append("\n"); 
		query.append("                 --AND   A.BKG_NO              = SO.BKG_NO(+)" ).append("\n"); 
		query.append("                 AND   A.MST_BKG_NO          = SO.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND   SO.EQ_KND_CD(+)       ='U'" ).append("\n"); 
		query.append("                 AND   SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                 AND   SO.TRSP_WO_SEQ        = WO.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("                 AND   SO.INV_NO             = WRK.INV_NO(+) " ).append("\n"); 
		query.append("                 AND   SO.INV_VNDR_SEQ       = WRK.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 -- CHM-201537162, 신용찬, MVMT Yard와 Door W/O From 비교로직 제거, DOOR W/O 를 찾는것으로 수정(요청 BY 지연 차장)" ).append("\n"); 
		query.append("                 --AND   C.ORG_YD_CD           = SO.FM_NOD_CD(+)" ).append("\n"); 
		query.append("                 AND   SO.TRSP_COST_DTL_MOD_CD = 'DR' -- DOOR W/O" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND   SO.DELT_FLG(+)        = 'N' " ).append("\n"); 
		query.append("                 AND   WO.CRE_USR_ID         = D.USR_ID(+) -- 2014.07.01 Chang Young Kim Added In accordance with the 'CHM-201430787'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 -- 2015.07.27 로직 추가, 신용찬, (요청 by 지연 차장) " ).append("\n"); 
		query.append("                 -- BOOKING RECEIVE / DELIVERY 모두 DOOR 이면, SO 생성 OFFICE 가 NYCNA HQ 하부의 OFC 만 조회" ).append("\n"); 
		query.append("                 -- BOOKING RECEIVE / DELIVERY 모두 DOOR 가 아니면 동일한 OFC를 검색하는 쿼리로 가동(조회결과 영향 없음)   " ).append("\n"); 
		query.append("                 AND   NVL(TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(SO.CRE_OFC_CD), 'X') = DECODE(B.RCV_TERM_CD||B.DE_TERM_CD, 'DD', 'NYCRA', NVL(TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(SO.CRE_OFC_CD), 'X'))" ).append("\n"); 
		query.append("                 AND   ROWNUM=1 " ).append("\n"); 
		query.append("            ) TRS_INFO," ).append("\n"); 
		query.append("                 -- 수정" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                      (CASE WHEN C1.AMT_AUD_FLG IN ('N')                THEN C1.AMT_AUD_FLG" ).append("\n"); 
		query.append("                            WHEN A.MVMT_STS_CD  IN ('MT')                THEN (CASE WHEN (NVL(D1.ON_TML_MTY_CHG_FLG,'N') = 'N') OR " ).append("\n"); 
		query.append("                                                                                       (D1.BILABL_SPCL_CNTR_TP_NM IS NOT NULL AND INSTR(D1.BILABL_SPCL_CNTR_TP_NM,C.CNTR_TPSZ_CD) =0) THEN 'N'" ).append("\n"); 
		query.append("                                                                                  ELSE 'Y'" ).append("\n"); 
		query.append("                                                                            END)" ).append("\n"); 
		query.append("                            WHEN A.MVMT_STS_CD  IN ('IC','OC','TS')      THEN D1.ON_TML_CHG_FLG" ).append("\n"); 
		query.append("                            WHEN A.MVMT_STS_CD  IN ('CI','CM','CO')      THEN D1.DMST_ON_TML_CHG_FLG" ).append("\n"); 
		query.append("                            WHEN A.MVMT_STS_CD  IN ('CD','CE','CP')      THEN D1.DMST_PD_CHG_FLG" ).append("\n"); 
		query.append("                            WHEN A.MVMT_STS_CD  IN ('EN','ID','OP','TN') THEN 'Y'" ).append("\n"); 
		query.append("                       END)||'$'||C1.CHSS_POOL_RT_AMT||'$'||" ).append("\n"); 
		query.append("                       B1.AGMT_OFC_CTY_CD||B1.AGMT_SEQ||'$'||" ).append("\n"); 
		query.append("                       B1.CHSS_POOL_CD||'$'||" ).append("\n"); 
		query.append("                       B1.VNDR_SEQ||'$'||                  " ).append("\n"); 
		query.append("                       D1.BILABL_SPCL_CNTR_TP_NM||'$'" ).append("\n"); 
		query.append("                 -- 수정" ).append("\n"); 
		query.append("                FROM  CGM_AGREEMENT B1" ).append("\n"); 
		query.append("                    , CGM_AGMT_CPS_RT C1 " ).append("\n"); 
		query.append("                    , CGM_AGMT_CPS_COND D1" ).append("\n"); 
		query.append("                WHERE B1.EQ_KND_CD       ='Z' " ).append("\n"); 
		query.append("                AND   B1.LST_VER_FLG     ='Y' " ).append("\n"); 
		query.append("                AND   B1.AGMT_LSTM_CD    ='ZP'" ).append("\n"); 
		query.append("                AND   B1.AGMT_OFC_CTY_CD = C1.AGMT_OFC_CTY_CD  " ).append("\n"); 
		query.append("                AND   B1.AGMT_SEQ        = C1.AGMT_SEQ  " ).append("\n"); 
		query.append("                AND   B1.AGMT_VER_NO     = C1.AGMT_VER_NO" ).append("\n"); 
		query.append("                AND   A.SCC_CD           = C1.LOC_CD" ).append("\n"); 
		query.append("                AND   C1.AGMT_OFC_CTY_CD = D1.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                AND   C1.AGMT_SEQ        = D1.AGMT_SEQ(+)" ).append("\n"); 
		query.append("                AND   C1.AGMT_VER_NO     = D1.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                AND   C.ORG_YD_CD        = D1.YD_CD(+)" ).append("\n"); 
		query.append("                AND   ROWNUM=1" ).append("\n"); 
		query.append("            ) AS CHZ_INFO" ).append("\n"); 
		query.append("    FROM  LV_CNTR_LIST A" ).append("\n"); 
		query.append("         ,BKG_BOOKING B" ).append("\n"); 
		query.append("         ,CTM_MOVEMENT C" ).append("\n"); 
		query.append("    WHERE A.BKG_NO  = B.BKG_NO(+)" ).append("\n"); 
		query.append("    AND   A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("    AND   A.CNMV_YR = C.CNMV_YR" ).append("\n"); 
		query.append("    AND   A.CNMV_ID_NO = C.CNMV_ID_NO" ).append("\n"); 
		query.append("    #if (${sc_no_list} != '') 	-- S/C NO" ).append("\n"); 
		query.append("    	AND (" ).append("\n"); 
		query.append("    	#foreach($sc_no in ${sc_no_list})" ).append("\n"); 
		query.append("    		#if($velocityCount < $sc_no_list.size())" ).append("\n"); 
		query.append("    			B.SC_NO = '$sc_no' OR" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("    			B.SC_NO = '$sc_no'" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${rcv_del_term} != '') " ).append("\n"); 
		query.append("    	#if (${rcv_del_term} == 'O') " ).append("\n"); 
		query.append("    		--AND   C.BKG_RCV_TERM_CD NOT IN ('Y','D') 2014.07.10 Chang Young Kim" ).append("\n"); 
		query.append("            AND   DECODE(C.OB_CNTR_FLG,'Y',B.RCV_TERM_CD,'N',B.DE_TERM_CD,'') NOT IN ('Y','D')  -- RVC/DEL TERM Others : O 경우" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${rcv_del_term} != 'O')" ).append("\n"); 
		query.append("    		--AND   C.BKG_RCV_TERM_CD = [rcv_del_term] 2014.07.10 Chang Young Kim" ).append("\n"); 
		query.append("            AND   DECODE(C.OB_CNTR_FLG,'Y',B.RCV_TERM_CD,'N',B.DE_TERM_CD,'') = @[rcv_del_term] -- RVC/DEL TERM Others : O 아닐 경우" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bound_cd} != '') " ).append("\n"); 
		query.append("    	AND   C.OB_CNTR_FLG = @[bound_cd]	-- BOUND" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_no_list} != '') 	-- BKG NO" ).append("\n"); 
		query.append("    	AND (" ).append("\n"); 
		query.append("    	#foreach($bkg_no in ${bkg_no_list})" ).append("\n"); 
		query.append("    		#if($velocityCount < $bkg_no_list.size())" ).append("\n"); 
		query.append("    			A.BKG_NO = '$bkg_no' OR" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("    			A.BKG_NO = '$bkg_no'" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND   DECODE(A.TO_DT_MVMT,NULL,'1',NVL(SUBSTR(A.LT_INFO,1,2),'1')) IN (NVL(SUBSTR(A.TO_DT_MVMT,1,2),'1'),SUBSTR(A.TO_DT_MVMT,3,2))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           A.LCC_CD," ).append("\n"); 
		query.append("           A.ECC_CD," ).append("\n"); 
		query.append("           A.SCC_CD," ).append("\n"); 
		query.append("           A.LOC_CD," ).append("\n"); 
		query.append("           A.ORG_YD_CD," ).append("\n"); 
		query.append("           A.CNTR_NO," ).append("\n"); 
		query.append("           A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           A.MVMT_CD," ).append("\n"); 
		query.append("           DECODE(A.FCNTR_FLG,'Y','F','M') AS FCNTR_FLG, -- 2014.07.01 Chang Young Kim Updated In accordance with the 'CHM-201430787'" ).append("\n"); 
		query.append("           A.FINISHED," ).append("\n"); 
		query.append("           A.FM_STS_CD," ).append("\n"); 
		query.append("           TO_CHAR(A.FM_DT,'YYYY-MM-DD') AS FM_DT," ).append("\n"); 
		query.append("           TO_CHAR(A.FM_DT,'HH24:MI') AS FM_TM," ).append("\n"); 
		query.append("           A.LT_YD_CD," ).append("\n"); 
		query.append("           A.LT_STS_CD," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(A.LT_DT, 'YYYY/MM/DD HH24:MI:SS'),'YYYY-MM-DD') AS LT_DT," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(A.LT_DT, 'YYYY/MM/DD HH24:MI:SS'),'HH24:MI') AS LT_TM," ).append("\n"); 
		query.append("           A.LT_CRE_TP," ).append("\n"); 
		query.append("           A.STAY_DYS,           " ).append("\n"); 
		query.append("           A.FREE_DAYS," ).append("\n"); 
		query.append("           -- Finished = Latter MVMT DT - LFD, Unfinished = Today - LFD, If clock stopped, Finished = Latter MVMT DT - CS Date, Unfinished = Today - CS Date" ).append("\n"); 
		query.append("           CASE WHEN SUBSTR(A.DMT_INFO,6,2)='CS' " ).append("\n"); 
		query.append("                     THEN CEIL(DECODE(A.FINISHED,'Y',TO_DATE(A.LT_DT,'YYYY-MM-DD HH24:MI:SS'),SYSDATE) - TO_DATE(SUBSTR(A.DMT_INFO, INSTR(A.DMT_INFO, '$', 1, 7) + 1,  INSTR(A.DMT_INFO, '$', 1, 8) -  INSTR(A.DMT_INFO, '$', 1, 7) - 1) ,'YYYY-MM-DD HH24:MI:SS'))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                      CEIL(DECODE(A.FINISHED,'Y',TO_DATE(A.LT_DT,'YYYY-MM-DD HH24:MI:SS'),SYSDATE) - TO_DATE(SUBSTR(A.DMT_INFO, INSTR(A.DMT_INFO, '$', 1, 10) + 1,  INSTR(A.DMT_INFO, '$', 1, 11) -  INSTR(A.DMT_INFO, '$', 1, 10) - 1) ,'YYYY-MM-DD HH24:MI:SS'))" ).append("\n"); 
		query.append("           END BYND_FDYS,           " ).append("\n"); 
		query.append("           A.DE_TERM_CD," ).append("\n"); 
		query.append("           A.SC_RFA_NO," ).append("\n"); 
		query.append("           A.SC_CUST_NM," ).append("\n"); 
		query.append("           DECODE(SUBSTR(A.DMT_INFO,6,2),'CS','Y','N') AS CS_FLG,       " ).append("\n"); 
		query.append("           DECODE(SUBSTR(A.DMT_INFO,6,2),'CS',CGM_SUBSTR_FNC(A.DMT_INFO, 7, '$')) AS CS_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           -- 수정" ).append("\n"); 
		query.append("           A.CHZ_EXCEPT," ).append("\n"); 
		query.append("           NVL(SUBSTR(A.CHZ_INFO, 1,1),'N') AS CHZ_PAY_FLG," ).append("\n"); 
		query.append("		   CGM_SUBSTR_FNC(A.CHZ_INFO, 1, '$') AS CHZ_RT," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.CHZ_INFO, 2, '$') AS CHZ_AGMT_NO," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.CHZ_INFO, 3, '$') AS CHZ_POOL_CD," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.CHZ_INFO, 4, '$') AS CHZ_VNDR_SEQ," ).append("\n"); 
		query.append("           (SELECT V.VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = CGM_SUBSTR_FNC(A.CHZ_INFO, 4, '$')) AS CHZ_VNDR_NM," ).append("\n"); 
		query.append("		   (CASE WHEN NVL(SUBSTR(A.CHZ_INFO, 1,1),'N') = 'Y' THEN A.STAY_DYS * CGM_SUBSTR_FNC(A.CHZ_INFO, 1, '$')" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)  AS CHZ_TOT," ).append("\n"); 
		query.append("          -- 수정" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           A.TRK_VNDR_SEQ," ).append("\n"); 
		query.append("           (SELECT B.VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE A.TRK_VNDR_SEQ = B.VNDR_SEQ) AS TRK_VNDR_NM," ).append("\n"); 
		query.append("           A.CHSS_NO," ).append("\n"); 
		query.append("           (SELECT INTG_CD_VAL_DP_DESC  FROM COM_INTG_CD_DTL CD  WHERE CD.INTG_CD_ID = 'CD01967' AND CD.INTG_CD_VAL_CTNT = SUBSTR(A.DMT_INFO,1,1)) AS DMT_CHG_STS_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 1, '$') AS DMT_FM_STS_CD," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 2, '$') AS DMT_TO_STS_CD," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 3, '$') AS DMT_TRF_CD," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 4, '$') AS DMT_FT_DYS," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 5, '$') AS DMT_BILL_DYS," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 6, '$') AS DMT_FM_DT," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 7, '$') AS DMT_TO_DT," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 8, '$') AS DMT_MT_DT,        " ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 9, '$') AS DMT_FT_CMNC_DT,     " ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 10, '$') AS DMT_FT_END_DT," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 11, '$') AS DMT_CURR_CD," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 12, '$') AS DMT_BIL_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           SUBSTR(A.TRS_INFO, 1, INSTR(A.TRS_INFO, '$', 1, 1) - 1) AS TRS_VNDR_SEQ," ).append("\n"); 
		query.append("           (SELECT B.VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE SUBSTR(A.TRS_INFO, 1, INSTR(A.TRS_INFO, '$', 1, 1) - 1) = B.VNDR_SEQ) AS TRS_VNDR_NM," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.TRS_INFO, 5, '$') AS TRS_WO_ISS_USR_NM, " ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.TRS_INFO, 6, '$') AS TRS_WO_FM_YD, -- CHM-201537162, 신규컬럼 추가" ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(CGM_SUBSTR_FNC(A.TRS_INFO, 1, '$'),'YYYY/MM/DD HH24:MI:SS'), 'YYYY-MM-DD') AS TRS_APPT_DT," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(CGM_SUBSTR_FNC(A.TRS_INFO, 1, '$'),'YYYY/MM/DD HH24:MI:SS'), 'HH24:MI:SS') AS TRS_APPT_TM," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(CGM_SUBSTR_FNC(A.TRS_INFO, 2, '$'),'YYYY/MM/DD HH24:MI:SS'), 'YYYY-MM-DD') AS TRS_DE_DT," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(CGM_SUBSTR_FNC(A.TRS_INFO, 2, '$'),'YYYY/MM/DD HH24:MI:SS'), 'HH24:MI:SS') AS TRS_DE_TM," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT INTG_CD_VAL_DP_DESC  " ).append("\n"); 
		query.append("            FROM COM_INTG_CD_DTL CD  " ).append("\n"); 
		query.append("            WHERE CD.INTG_CD_ID = 'CD00824' " ).append("\n"); 
		query.append("            AND CD.INTG_CD_VAL_CTNT = CGM_SUBSTR_FNC(A.TRS_INFO, 3, '$')" ).append("\n"); 
		query.append("           ) AS TRS_INV_STS_CD," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.TRS_INFO, 4, '$') AS TRS_INV_CFM_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           A.BKG_NO," ).append("\n"); 
		query.append("           A.BL_NO," ).append("\n"); 
		query.append("           A.BND_CD," ).append("\n"); 
		query.append("           A.POL_POD_NOD," ).append("\n"); 
		query.append("           A.POR_DEL_NOD," ).append("\n"); 
		query.append("           A.TRNK_VVD," ).append("\n"); 
		query.append("           TO_CHAR(A.POLETD_PODETA,'YYYY-MM-DD HH24:MI') AS POLETD_PODETA," ).append("\n"); 
		query.append("           SUBSTR(A.TRS_INFO, INSTR(A.TRS_INFO, '$', 1, 7)+1) AS TRS_FACT_NM," ).append("\n"); 
		query.append("           A.SHPR," ).append("\n"); 
		query.append("           A.CNEE,  -- NTFY-->CNEE 로 변경, 2015-03-17, 신용찬" ).append("\n"); 
		query.append("           A.CMDT_NM," ).append("\n"); 
		query.append("           NVL(A.RD_CGO_FLG,'N') AS RD_CGO_FLG," ).append("\n"); 
		query.append("           NVL(A.CNTR_DMG_FLG,'N') AS CNTR_DMG_FLG," ).append("\n"); 
		query.append("           CGM_SUBSTR_FNC(A.DMT_INFO, 13, '$') AS DMT_UC_FLG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           A.CTRT_OFC_CD," ).append("\n"); 
		query.append("           A.SREP_NM" ).append("\n"); 
		query.append("    FROM LV_CNTR_INFO A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${finish_cd} != '') " ).append("\n"); 
		query.append("	AND FINISHED = @[finish_cd] --FINISHED" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${staying_days} != '') " ).append("\n"); 
		query.append("	AND STAY_DYS  >= @[staying_days]  -- STAYING DAYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${beyond_fdays} != '') " ).append("\n"); 
		query.append("	AND BYND_FDYS >= @[beyond_fdays]  -- BEYOND F.DAYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cargo_type} != '') " ).append("\n"); 
		query.append("	#if (${cargo_type} == 'R')" ).append("\n"); 
		query.append("		AND NVL(RD_CGO_FLG,'N') = 'Y' --CGO TYPE - REEFER 경우" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cargo_type} == 'F')" ).append("\n"); 
		query.append("		AND FCNTR_FLG  = 'Y' -- CARGO TYPE  - FULL 경우" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cargo_type} == 'E')" ).append("\n"); 
		query.append("		AND FCNTR_FLG  = 'N' --CARGO TYPE - EMPTY 경우" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- ADDED BY Chang Young Kim, 20140703 (START)" ).append("\n"); 
		query.append("#if (${hdn_fcntr_flg} != '')" ).append("\n"); 
		query.append("	AND FCNTR_FLG = @[hdn_fcntr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hdn_fm_sts_cd} != '')" ).append("\n"); 
		query.append("	AND FM_STS_CD = @[hdn_fm_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hdn_lt_sts_cd} != '')" ).append("\n"); 
		query.append("	AND LT_STS_CD = @[hdn_lt_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- ADDED BY Chang Young Kim, 20140703 (END)" ).append("\n"); 

	}
}
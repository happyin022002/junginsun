/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchReportByRaterUserGroupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
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

public class PerformanceReportDBDAOSearchReportByRaterUserGroupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchReportByRaterUserGroupListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchReportByRaterUserGroupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atnd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pfm_by_queue_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchReportByRaterUserGroupListRSQL").append("\n"); 
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
		query.append("SELECT ATND_USR_ID AS USER_ID, NAME AS USER_NM, BL_CNT_ID AS BL_CNT, ORI_SI_CNT AS TOT_ORI_SI_CNT" ).append("\n"); 
		query.append("    --★" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(USR_ORI_TIME,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(USR_ORI_TIME,'SS') TOT_USR_ORI_TIME" ).append("\n"); 
		query.append("    ,ORI_SI_CNT AS TOT_ORI_PNT " ).append("\n"); 
		query.append("    ,USR_SC_FLG_BKG ,USR_RFA_FLG_BKG,USR_TAA_FLG_BKG,USR_SELF_FLG_BKG,USR_PRE_FLG_BKG" ).append("\n"); 
		query.append("    --★" ).append("\n"); 
		query.append("    , AMD_CNT_ID AS tot_amend_cnt" ).append("\n"); 
		query.append("    , (USR_RFA_PNT+USR_SC_PNT+USR_TAA_PNT+USR_SELF_PNT+USR_PRE_PNT+(AMD_CNT_ID*1)) ADD_POINT --★" ).append("\n"); 
		query.append("    , (USR_RFA_PNT+USR_SC_PNT+USR_TAA_PNT+USR_SELF_PNT+USR_PRE_PNT+(AMD_CNT_ID*1))+(ORI_SI_CNT*1) AS TTT_POINT --★" ).append("\n"); 
		query.append("    , TRUNC((BKG_GET_CONV_INTVAL_TIME_FNC(USR_TIME,'')*60+BKG_GET_CONV_INTVAL_TIME_FNC(USR_TIME,'SS'))/BL_CNT_ID,2)  AS AVER_TIME --★" ).append("\n"); 
		query.append("    , (BKG_GET_CONV_INTVAL_TIME_FNC(USR_TIME,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(USR_TIME,'SS') TT_TIME--★" ).append("\n"); 
		query.append("    , HIS_COUNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        DECODE(RN_BY_ID,1,SUM(RFA_FLG_BKG) OVER(PARTITION BY ATND_USR_ID ),0) AS USR_RFA_FLG_BKG --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(SC_FLG_BKG) OVER(PARTITION BY ATND_USR_ID ),0) AS USR_SC_FLG_BKG --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(TAA_FLG_BKG) OVER(PARTITION BY ATND_USR_ID ),0) AS USR_TAA_FLG_BKG --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(SELF_FLG_BKG) OVER(PARTITION BY ATND_USR_ID ),0) AS USR_SELF_FLG_BKG --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(PRE_FLG_BKG) OVER(PARTITION BY ATND_USR_ID ),0) AS USR_PRE_FLG_BKG --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(ORI_CNT) OVER(PARTITION BY ATND_USR_ID ),0) ORI_SI_CNT  --★--> B/L CNT, ORI S/I TOTAL" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,nvl(SUM(ORI_in_time) OVER(PARTITION BY ATND_USR_ID ),0),0) USR_ORI_TIME --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(RFA_PNT) OVER(PARTITION BY ATND_USR_ID ),0) USR_RFA_PNT --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(SC_PNT) OVER(PARTITION BY ATND_USR_ID ),0) USR_SC_PNT --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(TAA_PNT) OVER(PARTITION BY ATND_USR_ID ),0) USR_TAA_PNT --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(SELF_PNT) OVER(PARTITION BY ATND_USR_ID ),0) USR_SELF_PNT --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(PRE_PNT) OVER(PARTITION BY ATND_USR_ID ),0) USR_PRE_PNT --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(SR_PROC_HRS) OVER(PARTITION BY ATND_USR_ID ),0) USR_TIME --★" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,  ((BKG_GET_CONV_INTVAL_TIME_FNC((SUM(SR_PROC_HRS) OVER(PARTITION BY ATND_USR_ID )),'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC((SUM(SR_PROC_HRS) OVER(PARTITION BY ATND_USR_ID )),'SS'))  ,0) CON_USR_TIME --★" ).append("\n"); 
		query.append("        ,CASE WHEN SUM(ORI_in_time) OVER(PARTITION BY ATND_USR_ID ) = 0 OR SUM(ORI_CNT) OVER(PARTITION BY ATND_USR_ID ) = 0 THEN 0 " ).append("\n"); 
		query.append("              ELSE DECODE(RN_BY_ID,1,SUM(ORI_in_time) OVER(PARTITION BY ATND_USR_ID )/SUM(ORI_CNT) OVER(PARTITION BY ATND_USR_ID ),0) " ).append("\n"); 
		query.append("         END AS ORI_avg_time" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(USR_BKG_O_PNT) OVER(PARTITION BY ATND_USR_ID ),0) AS USR_ORI_PNT   " ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(DECODE(HIS_DUP_NM,1, 1, 0)) OVER(PARTITION BY ATND_USR_ID ),0) AS HIS_COUNT   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        --TYPE A-" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(AMD_CNT) OVER(PARTITION BY ATND_USR_ID ),0) AS AMD_CNT_id      " ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(AMD_TIME) OVER(PARTITION BY ATND_USR_ID ),0) AMD_TIME_ID" ).append("\n"); 
		query.append("        ,CASE WHEN decode(RN_BY_ID,1,SUM(AMD_CNT) OVER(PARTITION BY ATND_USR_ID ),0) = 0 OR decode(RN_BY_ID,1,SUM(AMD_TIME) OVER(PARTITION BY ATND_USR_ID ),0) = 0 THEN 0" ).append("\n"); 
		query.append("              ELSE DECODE(SR_AMD_TP_CD,'A', decode(RN_BY_ID,1, TRUNC(SUM(AMD_TIME) OVER(PARTITION BY ATND_USR_ID )/SUM(AMD_CNT) OVER(PARTITION BY ATND_USR_ID ),2) ,0), 0) " ).append("\n"); 
		query.append("         END AVG_AMD_TIME_ID" ).append("\n"); 
		query.append("        ,DECODE(RN_BY_ID,1,SUM(USR_BKG_A_PNT) OVER(PARTITION BY ATND_USR_ID ),0) USR_A_PNT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,(SELECT  USR_NM FROM COM_USER WHERE USR_ID = c.ATND_USR_ID) NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,C.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            DECODE(USER_SR_BKG_NM,1 ,DECODE(RATE_TYPE,'RFA',1,0),0) RFA_FLG_BKG" ).append("\n"); 
		query.append("            ,DECODE(USER_SR_BKG_NM,1 ,DECODE(RATE_TYPE,'S/C',1,0),0) SC_FLG_BKG" ).append("\n"); 
		query.append("            ,DECODE(USER_SR_BKG_NM,1 ,DECODE(RATE_TYPE,'TAA',1,0),0) TAA_FLG_BKG" ).append("\n"); 
		query.append("            ,DECODE(USER_SR_BKG_NM,1 ,SELF_AUDIT,0) SELF_FLG_BKG" ).append("\n"); 
		query.append("            ,DECODE(USER_SR_BKG_NM,1 ,PRE_RATE,0) PRE_FLG_BKG" ).append("\n"); 
		query.append("            ,CASE WHEN SR_AMD_TP_CD NOT IN('O','N') THEN 0" ).append("\n"); 
		query.append("                 WHEN SR_AMD_TP_CD IN('O','N') AND USER_SR_BKG_NM > 1 THEN 0" ).append("\n"); 
		query.append("                 ELSE 1" ).append("\n"); 
		query.append("            END ORI_CNT" ).append("\n"); 
		query.append("            ------------" ).append("\n"); 
		query.append("            ,CASE WHEN SR_AMD_TP_CD IN('O','N') THEN SR_PROC_HRS --to_number(INPUT_ELAPSED)" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END ORI_in_time" ).append("\n"); 
		query.append("            ----------- 개별 time     " ).append("\n"); 
		query.append("            ----TYPE A--------" ).append("\n"); 
		query.append("            --USER_SEQ_BKG_NM : (ATND_USR_ID,SR_AMD_TP_CD,A.BKG_NO,A.SR_NO,SR_AMD_SEQ ) 그룹별  (SR_AMD_SEQ,SR_HIS_SEQ)ORDER순으로 정렬" ).append("\n"); 
		query.append("            ,CASE WHEN SR_AMD_TP_CD = 'A' AND USER_SEQ_BKG_NM = 1 THEN 1" ).append("\n"); 
		query.append("                  ELSE 0" ).append("\n"); 
		query.append("             END AMD_CNT" ).append("\n"); 
		query.append("            ,CASE WHEN SR_AMD_TP_CD = 'A' THEN SR_PROC_HRS --to_number(INPUT_ELAPSED)" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END AMD_time   " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("            ,'******' ppp" ).append("\n"); 
		query.append("            ,CASE WHEN SR_AMD_TP_CD IN('O','N') AND USER_SR_BKG_NM = 1 and BL_RT_FLG ='Y' THEN 1" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END ORI_rate_pnt" ).append("\n"); 
		query.append("            ,CASE WHEN  USER_SR_BKG_NM =1 --BKG 별 1번만 적용 로직 ,SR_AMD_TP_CD IN('O','N') 이조건을 줘야하는지?" ).append("\n"); 
		query.append("                   AND 'RFA' = RATE_TYPE" ).append("\n"); 
		query.append("                  THEN  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = 'R' --SUBSTR(SR_STS_CD,0,1) --RD,AD,ID" ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'F' --RFA" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("            END AS RFA_PNT " ).append("\n"); 
		query.append("            ,CASE WHEN  USER_SR_BKG_NM =1 --BKG 별 1번만 적용 로직 ,SR_AMD_TP_CD IN('O','N') 이조건을 줘야하는지?" ).append("\n"); 
		query.append("                   AND 'S/C' = RATE_TYPE" ).append("\n"); 
		query.append("                  THEN  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = 'R' --SUBSTR(SR_STS_CD,0,1) --RD,AD,ID" ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'S' --S/C" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("            END AS SC_PNT   " ).append("\n"); 
		query.append("            ,CASE WHEN  USER_SR_BKG_NM =1 --BKG 별 1번만 적용 로직 ,SR_AMD_TP_CD IN('O','N') 이조건을 줘야하는지?" ).append("\n"); 
		query.append("                   AND 'TAA' = RATE_TYPE" ).append("\n"); 
		query.append("                  THEN  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = 'R' --SUBSTR(SR_STS_CD,0,1) --RD,AD,ID" ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'X' --TAA" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("            END AS TAA_PNT " ).append("\n"); 
		query.append("            ,CASE WHEN  USER_SR_BKG_NM =1 --BKG 별 1번만 적용 로직 ,SR_AMD_TP_CD IN('O','N') 이조건을 줘야하는지?" ).append("\n"); 
		query.append("                   AND 1 = SELF_AUDIT" ).append("\n"); 
		query.append("                  THEN  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = 'R' --SUBSTR(SR_STS_CD,0,1) --RD,AD,ID" ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'D' --SELF" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("            END AS SELF_PNT" ).append("\n"); 
		query.append("            ,CASE WHEN  USER_SR_BKG_NM =1 --BKG 별 1번만 적용 로직 ,SR_AMD_TP_CD IN('O','N') 이조건을 줘야하는지?" ).append("\n"); 
		query.append("                   AND PRE_RATE >= 1" ).append("\n"); 
		query.append("                  THEN  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = 'R' --SUBSTR(SR_STS_CD,0,1) --RD,AD,ID" ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'P' --PRE" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("            END AS PRE_PNT                                            " ).append("\n"); 
		query.append("            -- point" ).append("\n"); 
		query.append("            --rn_bkg (전체대상 bkg rownum)" ).append("\n"); 
		query.append("            --SR_BKG_NM :   그룹 (A.BKG_NO,SR_STS_CD) 별(=sr_sts_cd는 한종류이므로 bkg 그룹별과 같음) , order (SR_AMD_SEQ,SR_HIS_SEQ )순 rownum " ).append("\n"); 
		query.append("            -- bkg별 기준:  rn_bkg (전체대상 bkg rownum) =1 인것에 각각 구하고 rn_by_id=1 에 모음. " ).append("\n"); 
		query.append("            ,CASE WHEN USER_SR_BKG_NM =1 --SR_STS_CD,BKG 별 1번만 적용 로직(여기선 SR은 동일하므로 BKG별이됨)" ).append("\n"); 
		query.append("                   AND SR_AMD_TP_CD IN('O','N') " ).append("\n"); 
		query.append("                  THEN NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                            FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                           WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                             AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                             AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                             AND ATTR_CTNT3 = 'O' --" ).append("\n"); 
		query.append("                         ),0)" ).append("\n"); 
		query.append("                   ELSE 0" ).append("\n"); 
		query.append("            END USR_BKG_O_PNT" ).append("\n"); 
		query.append("            ,CASE WHEN USER_SEQ_BKG_NM =1 --SR_STS_CD,BKG,AMD_TP,AMD_SEQ 별 1번만 적용 로직(여기선 SR은 동일하므로 BKG,SR_NO별이됨)" ).append("\n"); 
		query.append("                   AND SR_AMD_TP_CD ='A'" ).append("\n"); 
		query.append("                  THEN NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                            FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                           WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                             AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                             AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                             AND ATTR_CTNT3 = 'A' --" ).append("\n"); 
		query.append("                         ),0)" ).append("\n"); 
		query.append("                  ELSE 0" ).append("\n"); 
		query.append("            END USR_BKG_A_PNT    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --        ,NVL((SELECT  ATTR_CTNT5 " ).append("\n"); 
		query.append("    --             FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("    --            WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("    --              AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) --i,R" ).append("\n"); 
		query.append("    --              AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("    --              AND ATTR_CTNT3 = B.SR_AMD_TP_CD -- L All,O Original,A Amend,B BL Confim,T Addition,E AES,C CAED,I IE" ).append("\n"); 
		query.append("    --            ),0) AS BAS_PNT        " ).append("\n"); 
		query.append("            ,B.* " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("                        SELECT /*+  ORDERED  */" ).append("\n"); 
		query.append("        --                BKG_JOIN_FNC(CURSOR(SELECT DISTINCT RGN_OFC_CD FROM BKG_EML_ACCT_STUP S WHERE S.BKG_OFC_CD = B.BKG_OFC_CD ),'')AS  REGION" ).append("\n"); 
		query.append("                        ATND_USR_ID," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER(PARTITION BY ATND_USR_ID ORDER BY ATND_USR_ID) RN_BY_ID, -- 1번에 total 구해서 둠." ).append("\n"); 
		query.append("                        H.SR_STS_CD,H.SR_HIS_SEQ" ).append("\n"); 
		query.append("                        -- SR_AMD_SEQ 가 가장낮은 HIS_DUP_NM 1번에 BKG_NO별 데이터를 모아두고 " ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY A.SR_KND_CD, A.SR_NO, A.BKG_NO,SR_HIS_SEQ  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) HIS_DUP_NM" ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY A.SR_KND_CD,SR_STS_CD, A.SR_NO, A.BKG_NO,SR_HIS_SEQ  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) HIS_DUP_NM2" ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY A.BKG_NO,SR_STS_CD  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) SR_BKG_NM" ).append("\n"); 
		query.append("                        -- sts,bkg 별 row, " ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY ATND_USR_ID,A.BKG_NO,SR_STS_CD  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) USER_SR_BKG_NM" ).append("\n"); 
		query.append("                        -- bkg,sr_no 별 row, sr_crnt_rqst 기준, " ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY ATND_USR_ID,SR_AMD_TP_CD,A.BKG_NO,A.SR_NO,SR_AMD_SEQ  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) USER_SEQ_BKG_NM" ).append("\n"); 
		query.append("                        ,COUNT(DISTINCT A.RQST_RN) OVER (PARTITION BY A.BKG_NO ,SR_STS_CD) SI_CNT --해당 BKG에 SR_STS_CD의 RQST갯수-> S/I #" ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER(PARTITION BY A.BKG_NO ORDER BY A.BKG_NO) RN_BKG" ).append("\n"); 
		query.append("                        ,COUNT(DISTINCT H.ATND_USR_ID) OVER (PARTITION BY A.BKG_NO,SR_STS_CD   ) STAFF_CNT" ).append("\n"); 
		query.append("                        ,COUNT(DISTINCT A.BKG_NO ) OVER (PARTITION BY SR_STS_CD) BKG_CNT_SR" ).append("\n"); 
		query.append("                        ,DECODE(DECODE(SUBSTR(RFA_NO,0,3),'DUM',NULL,RFA_NO),NULL,DECODE(SC_NO,NULL,DECODE(TAA_NO,NULL,NULL,'TAA'),'S/C'),'RFA') RATE_TYPE " ).append("\n"); 
		query.append("                        ,(SELECT DECODE(AUD_STS_CD,'Y',1, 0) FROM BKG_RATE WHERE BKG_NO = A.BKG_NO) AS SELF_AUDIT" ).append("\n"); 
		query.append("                        ,(SELECT COUNT(1) FROM BKG_CHG_RT WHERE BKG_NO = A.BKG_NO) AS PRE_RATE --BRE100381400" ).append("\n"); 
		query.append("                        ------------------------" ).append("\n"); 
		query.append("                        ,count(distinct a.bkg_no) over (partition by H.ATND_USR_ID) bl_cnt_id" ).append("\n"); 
		query.append("                        ,COUNT(DISTINCT A.SR_NO) OVER(PARTITION BY H.ATND_USR_ID,A.BKG_NO,SR_AMD_TP_CD ) CNT_USER_AM_TP" ).append("\n"); 
		query.append("                        ------------------------" ).append("\n"); 
		query.append("                        ,A.RQST_RN,A.SRC,A.SR_KND_CD,A.SR_NO,A.BKG_NO,A.SR_AMD_TP_CD,A.SR_AMD_SEQ,A.SR_URG_CD" ).append("\n"); 
		query.append("                        ,A.SR_AMD_KND_CD,A.RCV_OFC_CD,A.DPCS_OFC_CD,A.SR_CRNT_STS_CD,A.SR_CRNT_INFO_CD,A.BL_DOC_INP_FLG" ).append("\n"); 
		query.append("                        ,A.BL_RT_FLG,A.BL_AUD_FLG,A.SR_WRK_STS_CD,A.BL_DRFT_FAX_OUT_FLG " ).append("\n"); 
		query.append("                        ,H.ST_DT, H.ST_GDT " ).append("\n"); 
		query.append("                        ,RFA_NO,B.TAA_NO,B.SC_NO, H.SR_PROC_HRS,G.DPCS_WRK_GRP_CD" ).append("\n"); 
		query.append("                        ,BKG_COM_INTG_CD_NM_FNC('CD02100',G.DPCS_WRK_GRP_CD) AS USER_GROUP" ).append("\n"); 
		query.append("                        ,NVL(BKG_COM_INTG_CD_NM_FNC('CD01577',A.SR_AMD_TP_CD),'ORIGINAL') AS SI_KIND --ORIGINAL:N(OLD),O(현재)" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                            /*" ).append("\n"); 
		query.append("                            * 해당 기간안에  ORIGINAL 을 포함된 RQST찾는다.NYC107621300" ).append("\n"); 
		query.append("                            * 찾은 ORIGINAL BKG에 해당하는 히스토리를 가져온다. (ID,RD,AD)" ).append("\n"); 
		query.append("                            */" ).append("\n"); 
		query.append("                            SELECT /*+ index(r XAK10BKG_SR_CRNT_RQST ) */ /* 2014.11.24 튜닝 힌트 추가*/" ).append("\n"); 
		query.append("                            ROWNUM RQST_RN ," ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            BKG_COM_INTG_CD_NM_FNC('CD01581',R.SR_KND_CD) AS SRC" ).append("\n"); 
		query.append("                            ,SR_KND_CD,SR_NO, BKG_NO, SR_AMD_TP_CD, SR_AMD_SEQ, SR_URG_CD, SR_AMD_KND_CD, RCV_OFC_CD" ).append("\n"); 
		query.append("                            ,DPCS_OFC_CD, SR_CRNT_STS_CD, SR_CRNT_INFO_CD, BL_DOC_INP_FLG, BL_RT_FLG, BL_AUD_FLG,SR_WRK_STS_CD,BL_DRFT_FAX_OUT_FLG" ).append("\n"); 
		query.append("                            FROM BKG_SR_CRNT_RQST R" ).append("\n"); 
		query.append("                                WHERE  1=1" ).append("\n"); 
		query.append("                                AND R.DPCS_OFC_CD = NVL(@[dpcs_ofc_cd], R.DPCS_OFC_CD)" ).append("\n"); 
		query.append("                                AND (  1=2" ).append("\n"); 
		query.append("						        #if (${pfm_by_queue_cd} == 'I') " ).append("\n"); 
		query.append("                                  OR (BL_DOC_INP_DT >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                                      AND  BL_DOC_INP_DT <= TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI')+0.00068 ) " ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                #if (${pfm_by_queue_cd} == 'R') " ).append("\n"); 
		query.append("                                  OR ( BL_RT_DT >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                                      AND  BL_RT_DT <= TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI')+0.00068 ) " ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                #if (${pfm_by_queue_cd} == 'A') " ).append("\n"); 
		query.append("                                  OR ( BL_AUD_DT >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                                      AND  BL_AUD_DT <=TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI') +0.00068) " ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("                              ) A                    " ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                            ,BKG_SR_HIS H" ).append("\n"); 
		query.append("                            ,BKG_DPCS_USR_GRP G" ).append("\n"); 
		query.append("                            ,BKG_BOOKING B" ).append("\n"); 
		query.append("                            ,BKG_RATE BR" ).append("\n"); 
		query.append("                        WHERE 1 = 1" ).append("\n"); 
		query.append("                          AND A.SR_KND_CD =  H.SR_KND_CD --FAX,EMAIL,EDI" ).append("\n"); 
		query.append("                          AND A.SR_NO =  H.SR_NO" ).append("\n"); 
		query.append("                          AND A.BKG_NO =  H.BKG_NO" ).append("\n"); 
		query.append("                          AND A.BKG_NO= B.BKG_NO" ).append("\n"); 
		query.append("                          AND A.BKG_NO= BR.BKG_NO" ).append("\n"); 
		query.append("                          AND B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD LIKE  DECODE(NVL(@[vvd_cd],''), '', '' ,@[vvd_cd])|| '%'" ).append("\n"); 
		query.append("                          AND H.ATND_USR_ID  = G.USR_ID(+)" ).append("\n"); 
		query.append("                          AND H.ATND_USR_ID = NVL(@[atnd_usr_id],H.ATND_USR_ID )" ).append("\n"); 
		query.append("                          AND H.SR_STS_CD = decode(@[pfm_by_queue_cd],'I','ID','R','RD')" ).append("\n"); 
		query.append("                          AND EXISTS (SELECT 'Y' --DISTINCT RGN_OFC_CD " ).append("\n"); 
		query.append("                                FROM BKG_EML_ACCT_STUP S WHERE S.BKG_OFC_CD = B.BKG_OFC_CD AND S.RGN_OFC_CD = NVL(DECODE(@[region],'A','',@[region]),S.RGN_OFC_CD) AND ROWNUM = 1" ).append("\n"); 
		query.append("                             )   " ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("        )B                         " ).append("\n"); 
		query.append("    ) C     " ).append("\n"); 
		query.append(") D           " ).append("\n"); 
		query.append("WHERE D.RN_BY_ID = 1" ).append("\n"); 

	}
}
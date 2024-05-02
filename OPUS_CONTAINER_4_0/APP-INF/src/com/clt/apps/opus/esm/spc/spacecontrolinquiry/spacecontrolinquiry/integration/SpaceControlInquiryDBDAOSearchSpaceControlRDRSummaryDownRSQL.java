/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryDownRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryDownRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 2010년 시스템 개발 계획
	  * 2010.12.20 이준범 [CHM-201005916-01] 정렬기준 변경
	  * 1) 검색조건 추가 : Lane 항목
	  * 2011.07.05 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
	  *  - Total Weight 항목 추가
	  * 2011.10.05 김종준 [CHM-201113755-01] 
	  * 	-IOC가 ‘O’인 경우에만 조회가 가능토록 되어있으나, WAFIE와 마찬가지로 NBSIM 노선의 경우,
	  * 	  Intra 노선이지만, Ocean 처럼 인식되어 데이터가 조회될 수 있도록 보완 요청
	  * </pre>
	  */
	public SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryDownRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("operator",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryDownRSQL").append("\n"); 
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
		query.append("SELECT  OPERATOR,WEEK,TRADE,SUB_TRADE,LANE,VVD,BOUND" ).append("\n"); 
		query.append("        ,DECODE(BSA,0,DECODE(B_BSA,0,C_BSA,B_BSA),-- RDR Alloc에 없으면 BSA MGMT 값 적용" ).append("\n"); 
		query.append("                     DECODE(B_LAST_FLG,1,BSA,-1,B_BSA,0,C_BSA)) BSA -- RDR Alloc이 있으면 Update Date일자 비교하여 최근것을 적용" ).append("\n"); 
		query.append("        ,FULL,MTY,TTL_LOAD,TTL_WGT,FULL_LF,TTL_LF " ).append("\n"); 
		query.append("  FROM (     " ).append("\n"); 
		query.append("        SELECT OPERATOR,WEEK,TRADE,SUB_TRADE,LANE,VVD,BOUND," ).append("\n"); 
		query.append("               A.BSA," ).append("\n"); 
		query.append("               NVL(B.BSA_CAPA,0) B_BSA," ).append("\n"); 
		query.append("               NVL(C.BSA_CAPA,0) C_BSA," ).append("\n"); 
		query.append("               NVL(B.UPD_DT,TO_DATE('19900101','YYYYMMDD')) B_UPD_DT," ).append("\n"); 
		query.append("               NVL(C.UPD_DT,TO_DATE('19900101','YYYYMMDD')) C_UPD_DT," ).append("\n"); 
		query.append("               SIGN(NVL(A.UPD_DT,TO_DATE('19900101','YYYYMMDD')) - NVL(B.UPD_DT,TO_DATE('19900101','YYYYMMDD'))) B_LAST_FLG," ).append("\n"); 
		query.append("               SIGN(NVL(A.UPD_DT,TO_DATE('19900101','YYYYMMDD')) - NVL(C.UPD_DT,TO_DATE('19900101','YYYYMMDD'))) C_LAST_FLG,                             " ).append("\n"); 
		query.append("               FULL,MTY,TTL_LOAD,TTL_WGT,FULL_LF,TTL_LF " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT Operator,  " ).append("\n"); 
		query.append("                       Week, " ).append("\n"); 
		query.append("                       Trade," ).append("\n"); 
		query.append("                       Sub_Trade," ).append("\n"); 
		query.append("                       Lane," ).append("\n"); 
		query.append("                       VVD," ).append("\n"); 
		query.append("                       VSL_CD,SKD_VOY_NO,DIR_CD," ).append("\n"); 
		query.append("                       Bound," ).append("\n"); 
		query.append("                       BSA," ).append("\n"); 
		query.append("                       FULL," ).append("\n"); 
		query.append("                       EMPTY AS MTY," ).append("\n"); 
		query.append("                       (FULL + EMPTY) AS TTL_LOAD," ).append("\n"); 
		query.append("                       WGT AS TTL_WGT," ).append("\n"); 
		query.append("                       ROUND(DECODE(BSA, 0, 0, DECODE(FULL, 0, 0, FULL * 100 / BSA)), 1) || '%' AS FULL_LF," ).append("\n"); 
		query.append("                       ROUND(DECODE(BSA, 0, 0, DECODE((FULL + EMPTY), 0, 0, (FULL + EMPTY) * 100 / BSA)), 1) || '%' AS TTL_LF," ).append("\n"); 
		query.append("                       UPD_DT" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT B.OPR_CD     AS Operator,  " ).append("\n"); 
		query.append("                               M.COST_WK    AS Week, " ).append("\n"); 
		query.append("                               M.TRD_CD     AS Trade," ).append("\n"); 
		query.append("                               M.SUB_TRD_CD AS Sub_Trade," ).append("\n"); 
		query.append("                               M.RLANE_CD   AS Lane," ).append("\n"); 
		query.append("                               M.VSL_CD||M.SKD_VOY_NO||M.DIR_CD AS VVD," ).append("\n"); 
		query.append("                               M.VSL_CD,M.SKD_VOY_NO,M.DIR_CD," ).append("\n"); 
		query.append("                               M.DIR_CD AS Bound," ).append("\n"); 
		query.append("                               SUM(B.BSA) AS BSA," ).append("\n"); 
		query.append("                               SUM(B.FULL) AS FULL," ).append("\n"); 
		query.append("                               SUM(B.EMPTY) AS EMPTY," ).append("\n"); 
		query.append("                               SUM(B.WGT) AS WGT," ).append("\n"); 
		query.append("                               MAX(B.UPD_DT) AS UPD_DT" ).append("\n"); 
		query.append("                          FROM COA_MON_VVD M," ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                  SELECT A.VSL_CD," ).append("\n"); 
		query.append("                                         A.VOY_NO," ).append("\n"); 
		query.append("                                         A.DIR_CD," ).append("\n"); 
		query.append("                                         A.OPR_CD," ).append("\n"); 
		query.append("                                         A.REGION," ).append("\n"); 
		query.append("                                         NVL(B.BSA_SLOT, 0) AS BSA," ).append("\n"); 
		query.append("                                         SUM(DECODE(A.TYPE, 'F', A.SLOT_QTY, 0) + DECODE(A.TYPE, 'A', A.SLOT_QTY, 0)) AS FULL," ).append("\n"); 
		query.append("                                         SUM(DECODE(A.TYPE, 'E', A.SLOT_QTY, 0)) AS EMPTY," ).append("\n"); 
		query.append("                                         SUM(DECODE(A.TYPE, 'F', A.WEIGHT, 'A', A.WEIGHT, 'E', A.WEIGHT, 0)) AS WGT," ).append("\n"); 
		query.append("                                         MAX(B.UPDATE_TIME) UPD_DT" ).append("\n"); 
		query.append("                                    FROM RDR_UTILIZE    A," ).append("\n"); 
		query.append("                                         RDR_ALLOCATION B" ).append("\n"); 
		query.append("                                   WHERE A.VSL_CD = B.VSL_CD (+)" ).append("\n"); 
		query.append("                                     AND A.VOY_NO = B.VOY_NO (+)" ).append("\n"); 
		query.append("                                     AND A.DIR_CD = B.DIR_CD (+)" ).append("\n"); 
		query.append("                                     AND A.OPR_CD = B.OPR_CD (+)" ).append("\n"); 
		query.append("                                     AND A.REGION = B.REGION (+)" ).append("\n"); 
		query.append("                #if (${rhq} == 'A')" ).append("\n"); 
		query.append("                                      AND A.REGION IN ('A', 'D', 'E')" ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("                   #if (${rhq} == 'M')" ).append("\n"); 
		query.append("                                 AND A.REGION IN ('M', 'S')" ).append("\n"); 
		query.append("                   #else" ).append("\n"); 
		query.append("                                 AND A.REGION = @[rhq]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                                GROUP BY A.REGION," ).append("\n"); 
		query.append("                                         A.VSL_CD," ).append("\n"); 
		query.append("                                         A.VOY_NO," ).append("\n"); 
		query.append("                                         A.DIR_CD," ).append("\n"); 
		query.append("                                         A.OPR_CD," ).append("\n"); 
		query.append("                                         NVL(B.BSA_SLOT, 0)" ).append("\n"); 
		query.append("                               ) B," ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                  SELECT /*+ INDEX (P, XPKCOA_WK_PRD)*/" ).append("\n"); 
		query.append("                                         P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                                         ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                                    FROM COA_WK_PRD P" ).append("\n"); 
		query.append("                               WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                 AND ROWNUM               <= @[duration]" ).append("\n"); 
		query.append("                               ) P" ).append("\n"); 
		query.append("                         WHERE SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK = P.COST_YRWK" ).append("\n"); 
		query.append("                           AND (M.DELT_FLG IS NULL OR M.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                    #if (${trade} != '')" ).append("\n"); 
		query.append("                           AND M.TRD_CD     = @[trade]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    #if (${bound} != '')" ).append("\n"); 
		query.append("                           AND M.DIR_CD     = @[bound]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    #if (${operator} != '')" ).append("\n"); 
		query.append("                           AND B.OPR_CD     = @[operator]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                           AND M.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("             		#if (${subtrade} != '')" ).append("\n"); 
		query.append("                            AND M.SUB_TRD_CD     = @[subtrade]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                           AND DECODE(M.RLANE_CD, 'WAFIE', 'O', 'NBSIM', 'O', M.IOC_CD)     = 'O'" ).append("\n"); 
		query.append("                           AND M.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                           AND M.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                           AND M.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("        #if (${rhq} == 'A')" ).append("\n"); 
		query.append("               AND B.REGION IN ('A', 'D',DECODE(M.RLANE_CD||M.DIR_CD,'AE1AEW','E','D'))" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rhq} =='E')" ).append("\n"); 
		query.append("			   AND B.REGION = DECODE(M.RLANE_CD,'AE1AE',DECODE(M.DIR_CD,'E','E','XXX'),'E')" ).append("\n"); 
		query.append("        #end                       " ).append("\n"); 
		query.append("                   GROUP BY B.OPR_CD," ).append("\n"); 
		query.append("                            M.COST_WK," ).append("\n"); 
		query.append("                            M.TRD_CD," ).append("\n"); 
		query.append("                            M.SUB_TRD_CD," ).append("\n"); 
		query.append("                            M.RLANE_CD," ).append("\n"); 
		query.append("                            M.VSL_CD||M.SKD_VOY_NO||M.DIR_CD," ).append("\n"); 
		query.append("                            M.VSL_CD,M.SKD_VOY_NO,M.DIR_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                                     " ).append("\n"); 
		query.append("                ) A," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                select TRD_CD,SUB_TRD_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,CRR_CD," ).append("\n"); 
		query.append("                       BSA_CAPA,UPD_DT" ).append("\n"); 
		query.append("                  from SPC_BSA_MGMT" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                    #if (${trade} != '')" ).append("\n"); 
		query.append("                           AND TRD_CD     = @[trade]" ).append("\n"); 
		query.append("                    #end      " ).append("\n"); 
		query.append("       				#if (${subtrade} != '')" ).append("\n"); 
		query.append("                         AND SUB_TRD_CD     = @[subtrade]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${bound} != '')" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD     = @[bound]" ).append("\n"); 
		query.append("                    #end       " ).append("\n"); 
		query.append("                    #if (${operator} != '')" ).append("\n"); 
		query.append("                           AND CRR_CD     = @[operator]" ).append("\n"); 
		query.append("                    #end     " ).append("\n"); 
		query.append("                ) B," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                select DISTINCT TRD_CD,SUB_TRD_CD,VSL_CD,SKD_DIR_CD,CRR_CD," ).append("\n"); 
		query.append("                       FIRST_VALUE(BSA_CAPA) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,VSL_CD,CRR_CD,SKD_DIR_CD ORDER BY BSA_SEQ DESC) BSA_CAPA," ).append("\n"); 
		query.append("                       FIRST_VALUE(UPD_DT) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,VSL_CD,CRR_CD,SKD_DIR_CD ORDER BY BSA_SEQ DESC) UPD_DT" ).append("\n"); 
		query.append("                  from SPC_BSA_MGMT" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    #if (${trade} != '')" ).append("\n"); 
		query.append("                           AND TRD_CD     = @[trade]" ).append("\n"); 
		query.append("                    #end      " ).append("\n"); 
		query.append("                    #if (${bound} != '')" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD     = @[bound]" ).append("\n"); 
		query.append("                    #end       " ).append("\n"); 
		query.append("     				#if (${subtrade} != '')" ).append("\n"); 
		query.append("                         AND SUB_TRD_CD     = @[subtrade]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${operator} != '')" ).append("\n"); 
		query.append("                           AND CRR_CD     = @[operator]" ).append("\n"); 
		query.append("                    #end           " ).append("\n"); 
		query.append("                ) C       " ).append("\n"); 
		query.append("             WHERE A.TRADE        = B.TRD_CD(+)" ).append("\n"); 
		query.append("               AND A.SUB_TRADE    = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("               AND A.VSL_CD       = B.VSL_CD(+)" ).append("\n"); 
		query.append("               AND A.SKD_VOY_NO   = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("               AND A.DIR_CD       = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("               AND A.OPERATOR     = B.CRR_CD(+)" ).append("\n"); 
		query.append("               AND A.TRADE        = C.TRD_CD(+)" ).append("\n"); 
		query.append("               AND A.SUB_TRADE    = C.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("               AND A.VSL_CD       = C.VSL_CD(+)" ).append("\n"); 
		query.append("               AND A.DIR_CD       = C.SKD_DIR_CD(+)   " ).append("\n"); 
		query.append("               AND A.OPERATOR     = C.CRR_CD(+)" ).append("\n"); 
		query.append("        )       " ).append("\n"); 
		query.append("  ORDER BY WEEK   ," ).append("\n"); 
		query.append("           TRADE    ," ).append("\n"); 
		query.append("           SUB_TRADE," ).append("\n"); 
		query.append("           LANE ," ).append("\n"); 
		query.append("           VVD," ).append("\n"); 
		query.append("           BOUND," ).append("\n"); 
		query.append("           OPERATOR" ).append("\n"); 

	}
}
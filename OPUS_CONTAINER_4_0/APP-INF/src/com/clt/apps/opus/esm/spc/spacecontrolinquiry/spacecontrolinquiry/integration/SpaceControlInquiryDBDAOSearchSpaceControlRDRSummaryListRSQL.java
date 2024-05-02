/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.04 
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

public class SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 2010년 시스템 개발 계획
	  * 2010.09.16 이윤정 [CHM-201005916-01] Weekly L/F by Carrier 화면의 조회 결과 값에 따른 색상 변경 
	  * 2010.12.20 이준범 [CHM-201005916-01] 정렬기준 변경
	  * 1) Weekly L/F by POL/POD 와 마찬가지로 Sub Trade / TTL BSA 정렬
	  * 2) Carrier Code 정렬 : HJS/COS/KKL/YML + 나머지 알파벳순
	  * 2011.03.02 이석준 [CHM-201109016-01] 
	  *                 RDR에 BSA정보가 없을시 SPC_BSA_MGMT TABLE에서 BSA 정보를 보여주도록 쿼리 수정
	  * 2011.03.30 이석준[CHM-201109754-01]
	  *                 AE1AE LANE은 EUROUPE으로 되어 있으나 SHAAS가 조회시에 조회될 수 있도록 수정
	  * 2011.07.01 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
	  *  - Total Weight 항목 추가
	  * 2011.10.05 김종준 [CHM-201113755-01] 
	  * 	-IOC가 ‘O’인 경우에만 조회가 가능토록 되어있으나, WAFIE와 마찬가지로 NBSIM 노선의 경우,
	  * 	  Intra 노선이지만, Ocean 처럼 인식되어 데이터가 조회될 수 있도록 보완 요청
	  * 2011.10.05 김종준 [CHM-201113755-01] 
	  * 	-IOC가 ‘O’인 경우에만 조회가 가능토록 되어있으나, WAFIE와 마찬가지로 NBSIM 노선의 경우,
	  * 	  Intra 노선이지만, Ocean 처럼 인식되어 데이터가 조회될 수 있도록 보완 요청
	  * </pre>
	  */
	public SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryListRSQL(){
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
		query.append("FileName : SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryListRSQL").append("\n"); 
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
		query.append("WITH COA_MON_VVD_LV AS(" ).append("\n"); 
		query.append("SELECT  TRD_CD,SUB_TRD_CD,RLANE_CD,DIR_CD,COST_YR,COST_MON,NUM," ).append("\n"); 
		query.append("        COST_WK,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VVD,OPR_CD," ).append("\n"); 
		query.append("        DECODE(BSA,0,DECODE(B_BSA,0,C_BSA,B_BSA),-- RDR Alloc에 없으면 BSA MGMT 값 적용" ).append("\n"); 
		query.append("                     DECODE(B_LAST_FLG,1,BSA,-1,B_BSA,0,C_BSA)) BSA, -- RDR Alloc이 있으면 Update Date일자 비교하여 최근것을 적용" ).append("\n"); 
		query.append("        FULL,EMPTY, WGT" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("    SELECT A.TRD_CD,A.SUB_TRD_CD,A.RLANE_CD,A.DIR_CD,A.COST_YR,A.COST_MON,A.NUM," ).append("\n"); 
		query.append("           A.COST_WK,A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.VVD,A.OPR_CD," ).append("\n"); 
		query.append("--           DECODE(A.BSA,0,DECODE(NVL(B.BSA_CAPA,0),0,NVL(C.BSA_CAPA,0),NVL(B.BSA_CAPA,0)),A.BSA) BSA," ).append("\n"); 
		query.append("           A.BSA," ).append("\n"); 
		query.append("           NVL(B.BSA_CAPA,0) B_BSA," ).append("\n"); 
		query.append("           NVL(C.BSA_CAPA,0) C_BSA," ).append("\n"); 
		query.append("           NVL(B.UPD_DT,TO_DATE('19900101','YYYYMMDD')) B_UPD_DT," ).append("\n"); 
		query.append("           NVL(C.UPD_DT,TO_DATE('19900101','YYYYMMDD')) C_UPD_DT," ).append("\n"); 
		query.append("           SIGN(NVL(A.UPD_DT,TO_DATE('19900101','YYYYMMDD')) - NVL(B.UPD_DT,TO_DATE('19900101','YYYYMMDD'))) B_LAST_FLG," ).append("\n"); 
		query.append("           SIGN(NVL(A.UPD_DT,TO_DATE('19900101','YYYYMMDD')) - NVL(C.UPD_DT,TO_DATE('19900101','YYYYMMDD'))) C_LAST_FLG,   " ).append("\n"); 
		query.append("           A.FULL,A.EMPTY, A.WGT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("                   M.SUB_TRD_CD," ).append("\n"); 
		query.append("                   M.RLANE_CD  ," ).append("\n"); 
		query.append("                   M.DIR_CD    ," ).append("\n"); 
		query.append("                   SUBSTR(M.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("                   SUBSTR(M.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
		query.append("                   P.RNUM NUM  ," ).append("\n"); 
		query.append("                   M.COST_WK   ," ).append("\n"); 
		query.append("                   M.VSL_CD    ," ).append("\n"); 
		query.append("                   M.SKD_VOY_NO," ).append("\n"); 
		query.append("                   M.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("                   M.VSL_CD||M.SKD_VOY_NO||M.DIR_CD AS VVD," ).append("\n"); 
		query.append("                   B.OPR_CD," ).append("\n"); 
		query.append("                   SUM(B.BSA) AS BSA  ," ).append("\n"); 
		query.append("                   SUM(B.FULL) AS FULL ," ).append("\n"); 
		query.append("                   SUM(B.EMPTY) AS EMPTY ," ).append("\n"); 
		query.append("                   SUM(B.WGT) AS WGT ," ).append("\n"); 
		query.append("                   MAX(B.UPD_DT) AS UPD_DT" ).append("\n"); 
		query.append("              FROM COA_MON_VVD M," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                      SELECT A.VSL_CD," ).append("\n"); 
		query.append("                             A.VOY_NO," ).append("\n"); 
		query.append("                             A.DIR_CD," ).append("\n"); 
		query.append("                             A.OPR_CD," ).append("\n"); 
		query.append("                             A.REGION," ).append("\n"); 
		query.append("                             NVL(B.BSA_SLOT, 0) AS BSA," ).append("\n"); 
		query.append("                             SUM(DECODE(A.TYPE, 'F', A.SLOT_QTY, 0) + DECODE(A.TYPE, 'A', A.SLOT_QTY, 0)) AS FULL," ).append("\n"); 
		query.append("                             SUM(DECODE(A.TYPE, 'E', A.SLOT_QTY, 0)) AS EMPTY," ).append("\n"); 
		query.append("                             SUM(DECODE(A.TYPE, 'F', A.WEIGHT, 'A', A.WEIGHT, 'E', A.WEIGHT, 0)) AS WGT," ).append("\n"); 
		query.append("                             MAX(B.UPDATE_TIME) UPD_DT" ).append("\n"); 
		query.append("                        FROM RDR_UTILIZE    A," ).append("\n"); 
		query.append("                             RDR_ALLOCATION B" ).append("\n"); 
		query.append("                       WHERE A.VSL_CD = B.VSL_CD (+)" ).append("\n"); 
		query.append("                         AND A.VOY_NO = B.VOY_NO (+)" ).append("\n"); 
		query.append("                         AND A.DIR_CD = B.DIR_CD (+)" ).append("\n"); 
		query.append("                         AND A.OPR_CD = B.OPR_CD (+)" ).append("\n"); 
		query.append("                         AND A.REGION = B.REGION (+)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${rhq} == 'A')" ).append("\n"); 
		query.append("                         AND A.REGION IN ('A', 'D','E')" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("        	#if (${rhq} == 'M')" ).append("\n"); 
		query.append("                         AND A.REGION IN ('M', 'S')" ).append("\n"); 
		query.append("        	#else" ).append("\n"); 
		query.append("                         AND A.REGION = @[rhq]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                    GROUP BY A.VSL_CD," ).append("\n"); 
		query.append("                             A.VOY_NO," ).append("\n"); 
		query.append("                             A.DIR_CD," ).append("\n"); 
		query.append("                             A.OPR_CD," ).append("\n"); 
		query.append("                             A.REGION," ).append("\n"); 
		query.append("                             NVL(B.BSA_SLOT, 0)" ).append("\n"); 
		query.append("                   ) B," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                      SELECT /*+ INDEX (P, XPKCOA_WK_PRD)*/" ).append("\n"); 
		query.append("                             P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                             ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                        FROM COA_WK_PRD P" ).append("\n"); 
		query.append("                       WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                         AND ROWNUM               <= @[duration]" ).append("\n"); 
		query.append("                   ) P" ).append("\n"); 
		query.append("             WHERE SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK = P.COST_YRWK" ).append("\n"); 
		query.append("               AND (M.DELT_FLG IS NULL OR M.DELT_FLG = 'N')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("        #if (${trade} != '')" ).append("\n"); 
		query.append("               AND M.TRD_CD     = @[trade]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${subtrade} != '')" ).append("\n"); 
		query.append("               AND M.SUB_TRD_CD     = @[subtrade]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${bound} != '')" ).append("\n"); 
		query.append("               AND M.DIR_CD     = @[bound]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${operator} != '')" ).append("\n"); 
		query.append("               AND B.OPR_CD     = @[operator]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("               AND M.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("               AND DECODE(M.RLANE_CD, 'WAFIE', 'O', 'NBSIM', 'O', M.IOC_CD)     = 'O'" ).append("\n"); 
		query.append("               AND M.VSL_CD     = B.VSL_CD " ).append("\n"); 
		query.append("               AND M.SKD_VOY_NO = B.VOY_NO " ).append("\n"); 
		query.append("               AND M.DIR_CD     = B.DIR_CD " ).append("\n"); 
		query.append("        #if (${rhq} == 'A')" ).append("\n"); 
		query.append("               AND B.REGION IN ('A', 'D',DECODE(M.RLANE_CD||M.DIR_CD,'AE1AEW','E','D'))" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rhq} =='E')" ).append("\n"); 
		query.append("			   AND B.REGION = DECODE(M.RLANE_CD,'AE1AE',DECODE(M.DIR_CD,'E','E','XXX'),'E')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("          GROUP BY M.TRD_CD    ," ).append("\n"); 
		query.append("                   M.SUB_TRD_CD," ).append("\n"); 
		query.append("                   M.RLANE_CD  ," ).append("\n"); 
		query.append("                   M.DIR_CD    ," ).append("\n"); 
		query.append("                   SUBSTR(M.SLS_YRMON, 1, 4) ," ).append("\n"); 
		query.append("                   SUBSTR(M.SLS_YRMON, 5)    ," ).append("\n"); 
		query.append("                   P.RNUM  ," ).append("\n"); 
		query.append("                   M.COST_WK   ," ).append("\n"); 
		query.append("                   M.VSL_CD    ," ).append("\n"); 
		query.append("                   M.SKD_VOY_NO," ).append("\n"); 
		query.append("                   M.DIR_CD," ).append("\n"); 
		query.append("                   M.VSL_CD||M.SKD_VOY_NO||M.DIR_CD ," ).append("\n"); 
		query.append("                   B.OPR_CD" ).append("\n"); 
		query.append("               ) A," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        select TRD_CD,SUB_TRD_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,CRR_CD," ).append("\n"); 
		query.append("               BSA_CAPA,UPD_DT" ).append("\n"); 
		query.append("          from SPC_BSA_MGMT" ).append("\n"); 
		query.append("         WHERE 1=1    " ).append("\n"); 
		query.append("        #if (${trade} != '')" ).append("\n"); 
		query.append("               AND TRD_CD     = @[trade]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${subtrade} != '')" ).append("\n"); 
		query.append("               AND SUB_TRD_CD     = @[subtrade]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${bound} != '')" ).append("\n"); 
		query.append("               AND SKD_DIR_CD     = @[bound]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${operator} != '')" ).append("\n"); 
		query.append("               AND CRR_CD     = @[operator]" ).append("\n"); 
		query.append("        #end           " ).append("\n"); 
		query.append("      ) B," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        select DISTINCT TRD_CD,SUB_TRD_CD,VSL_CD,SKD_DIR_CD,CRR_CD," ).append("\n"); 
		query.append("               FIRST_VALUE(BSA_CAPA) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,VSL_CD,CRR_CD,SKD_DIR_CD ORDER BY BSA_SEQ DESC) BSA_CAPA," ).append("\n"); 
		query.append("               FIRST_VALUE(UPD_DT) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,VSL_CD,CRR_CD,SKD_DIR_CD ORDER BY BSA_SEQ DESC) UPD_DT" ).append("\n"); 
		query.append("          from SPC_BSA_MGMT" ).append("\n"); 
		query.append("          WHERE 1=1  " ).append("\n"); 
		query.append("        #if (${trade} != '')" ).append("\n"); 
		query.append("               AND TRD_CD     = @[trade]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${subtrade} != '')" ).append("\n"); 
		query.append("               AND SUB_TRD_CD     = @[subtrade]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${bound} != '')" ).append("\n"); 
		query.append("               AND SKD_DIR_CD     = @[bound]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${operator} != '')" ).append("\n"); 
		query.append("               AND CRR_CD     = @[operator]" ).append("\n"); 
		query.append("        #end              " ).append("\n"); 
		query.append("      ) C   " ).append("\n"); 
		query.append("     WHERE A.TRD_CD       = B.TRD_CD(+)" ).append("\n"); 
		query.append("       AND A.SUB_TRD_CD   = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("       AND A.VSL_CD       = B.VSL_CD(+)" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO   = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD   = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       AND A.OPR_CD       = B.CRR_CD(+)" ).append("\n"); 
		query.append("       AND A.TRD_CD       = C.TRD_CD(+)" ).append("\n"); 
		query.append("       AND A.SUB_TRD_CD   = C.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("       AND A.VSL_CD       = C.VSL_CD(+)" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD   = C.SKD_DIR_CD(+)   " ).append("\n"); 
		query.append("       AND A.OPR_CD       = C.CRR_CD(+)      " ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append(", BASE_DATA AS (" ).append("\n"); 
		query.append("    SELECT TRD_CD    ," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           COST_YR   ," ).append("\n"); 
		query.append("           COST_MON  ," ).append("\n"); 
		query.append("           NUM       ," ).append("\n"); 
		query.append("           COST_WK   ," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           VVD       , " ).append("\n"); 
		query.append("           CASE WHEN B.CPY_NO = '0' THEN 'VVD'" ).append("\n"); 
		query.append("                                    ELSE 'ITEM'" ).append("\n"); 
		query.append("            END AS OPR_CD," ).append("\n"); 
		query.append("           0 AS BSA  ," ).append("\n"); 
		query.append("           0 AS FULL ," ).append("\n"); 
		query.append("           0 AS EMPTY," ).append("\n"); 
		query.append("           0 AS WGT" ).append("\n"); 
		query.append("      FROM COA_MON_VVD_LV A," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("              SELECT CPY_NO" ).append("\n"); 
		query.append("                FROM COM_CPY_NO" ).append("\n"); 
		query.append("                WHERE CPY_NO < 2" ).append("\n"); 
		query.append("           ) B" ).append("\n"); 
		query.append("  GROUP BY TRD_CD    ," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           COST_YR   ," ).append("\n"); 
		query.append("           COST_MON  ," ).append("\n"); 
		query.append("           NUM       ," ).append("\n"); 
		query.append("           COST_WK   ," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           VVD       ," ).append("\n"); 
		query.append("           CPY_NO" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT TRD_CD    ," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           COST_YR   ," ).append("\n"); 
		query.append("           COST_MON  ," ).append("\n"); 
		query.append("           NUM       ," ).append("\n"); 
		query.append("           COST_WK   ," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           VVD       ," ).append("\n"); 
		query.append("           OPR_CD    ," ).append("\n"); 
		query.append("           BSA       ," ).append("\n"); 
		query.append("           FULL      ," ).append("\n"); 
		query.append("           EMPTY     ," ).append("\n"); 
		query.append("           WGT" ).append("\n"); 
		query.append("      FROM COA_MON_VVD_LV" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BASE_DATA2 AS (" ).append("\n"); 
		query.append("    SELECT 1 AS BSA_AVG ," ).append("\n"); 
		query.append("           Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD    ," ).append("\n"); 
		query.append("           Z1.OPR_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#set($primate = 'new_dur')" ).append("\n"); 
		query.append("#if(${duration} == '1')" ).append("\n"); 
		query.append("	#set($new_dur = ['1'])" ).append("\n"); 
		query.append("#elseif(${duration} == '2')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2'])" ).append("\n"); 
		query.append("#elseif(${duration} == '3')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3'])" ).append("\n"); 
		query.append("#elseif(${duration} == '4')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4'])" ).append("\n"); 
		query.append("#elseif(${duration} == '5')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5'])" ).append("\n"); 
		query.append("#elseif(${duration} == '6')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6'])" ).append("\n"); 
		query.append("#elseif(${duration} == '7')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7'])" ).append("\n"); 
		query.append("#elseif(${duration} == '8')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8'])" ).append("\n"); 
		query.append("#elseif(${duration} == '9')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9'])" ).append("\n"); 
		query.append("#elseif(${duration} == '10')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10'])" ).append("\n"); 
		query.append("#elseif(${duration} == '11')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11'])" ).append("\n"); 
		query.append("#elseif(${duration} == '12')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12'])" ).append("\n"); 
		query.append("#elseif(${duration} == '13')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13'])" ).append("\n"); 
		query.append("#elseif(${duration} == '14')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14'])" ).append("\n"); 
		query.append("#elseif(${duration} == '15')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15'])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("           MIN(DECODE(Z1.NUM, ${key}, Z1.VVD))              AS MIN_VVD$key," ).append("\n"); 
		query.append("           MAX(DECODE(Z1.NUM, ${key}, Z1.VVD))              AS MAX_VVD$key," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.BSA  , 0), 0)) AS BSA$key    ," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.FULL , 0), 0)) AS FULL$key   ," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.EMPTY, 0), 0)) AS EMPTY$key  ," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.WGT  , 0), 0)) AS WGT$key    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ''" ).append("\n"); 
		query.append("      FROM BASE_DATA Z1" ).append("\n"); 
		query.append("  GROUP BY Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD    ," ).append("\n"); 
		query.append("           Z1.OPR_CD" ).append("\n"); 
		query.append("  ORDER BY Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD    ," ).append("\n"); 
		query.append("           Z1.OPR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT Z3.TRD_CD    ," ).append("\n"); 
		query.append("         Z3.SUB_TRD_CD," ).append("\n"); 
		query.append("         Z3.RLANE_CD  ," ).append("\n"); 
		query.append("         Z3.DIR_CD    ," ).append("\n"); 
		query.append("         Z3.OPR_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("         Z3.VVD$key    ," ).append("\n"); 
		query.append("         Z3.BSA$key    ," ).append("\n"); 
		query.append("         Z3.FULL$key   ," ).append("\n"); 
		query.append("         Z3.EMPTY$key  ," ).append("\n"); 
		query.append("         Z3.TTL_WGT$key," ).append("\n"); 
		query.append("         Z3.TTL_LOAD$key," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.BSA$key, 0, 0, DECODE(Z3.FULL$key    , 0, 0, Z3.FULL$key     * 100 / Z3.BSA$key)), 1) || '%' AS FULL_LF$key," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.BSA$key, 0, 0, DECODE(Z3.TTL_LOAD$key, 0, 0, Z3.TTL_LOAD$key * 100 / Z3.BSA$key)), 1) || '%' AS TTL_LF$key ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         '' AS T" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT NVL(Z2.TRD_CD    , 'TOTAL') AS TRD_CD    ," ).append("\n"); 
		query.append("                   NVL(Z2.SUB_TRD_CD, 'TOTAL') AS SUB_TRD_CD," ).append("\n"); 
		query.append("                   NVL(Z2.RLANE_CD  , 'TOTAL') AS RLANE_CD  ," ).append("\n"); 
		query.append("                   NVL(Z2.DIR_CD    , 'TOTAL') AS DIR_CD    ," ).append("\n"); 
		query.append("                   NVL(Z2.OPR_CD    , 'TOTAL') AS OPR_CD    ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   -- Add @2010.12.15" ).append("\n"); 
		query.append("                   NVL(( SELECT SUM(L.BSA) / COUNT(DISTINCT L.VVD) AS BSA" ).append("\n"); 
		query.append("                           FROM COA_MON_VVD_LV L" ).append("\n"); 
		query.append("                          WHERE L.SUB_TRD_CD = Z2.SUB_TRD_CD" ).append("\n"); 
		query.append("                            AND L.RLANE_CD   = Z2.RLANE_CD" ).append("\n"); 
		query.append("                            AND L.DIR_CD     = Z2.DIR_CD), 0) AS BSA_AVG," ).append("\n"); 
		query.append("                   -- Add End @2010.12.15" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                   MAX(DECODE((NVL(Z2.MIN_VVD$key, ' ')), (NVL(Z2.MAX_VVD$key, ' ')), Z2.MIN_VVD$key, Z2.MAX_VVD$key || '/' || Z2.MIN_VVD$key)) AS VVD${key}," ).append("\n"); 
		query.append("                   SUM(Z2.BSA$key)   AS BSA$key  ," ).append("\n"); 
		query.append("                   SUM(Z2.FULL$key)  AS FULL$key ," ).append("\n"); 
		query.append("                   SUM(Z2.EMPTY$key) AS EMPTY$key," ).append("\n"); 
		query.append("                   SUM(Z2.FULL$key + Z2.EMPTY$key) AS TTL_LOAD$key," ).append("\n"); 
		query.append("                   SUM(Z2.WGT$key)   AS TTL_WGT$key," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ''" ).append("\n"); 
		query.append("              FROM BASE_DATA2 Z2" ).append("\n"); 
		query.append("          GROUP BY Z2.TRD_CD," ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                Z2.SUB_TRD_CD, Z2.RLANE_CD, Z2.DIR_CD, CUBE(Z2.OPR_CD)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				CUBE(Z2.SUB_TRD_CD, Z2.RLANE_CD, Z2.DIR_CD, Z2.OPR_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            HAVING     (NOT (SUB_TRD_CD IS NULL     AND RLANE_CD IS NOT NULL))" ).append("\n"); 
		query.append("                   AND (NOT (SUB_TRD_CD IS NOT NULL AND RLANE_CD IS NOT NULL AND DIR_CD IS NULL))" ).append("\n"); 
		query.append("                   AND (NOT (SUB_TRD_CD IS NULL     AND RLANE_CD IS NULL     AND DIR_CD IS NOT NULL AND OPR_CD IS NOT NULL))" ).append("\n"); 
		query.append("                   AND (NOT (SUB_TRD_CD IS NOT NULL AND RLANE_CD IS NULL     AND DIR_CD IS NOT NULL AND OPR_CD IS NOT NULL))" ).append("\n"); 
		query.append("         ) Z3" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("-- @2010.12.15 Sub Trade 정렬 방식 변경" ).append("\n"); 
		query.append("ORDER BY DECODE(SUB_TRD_CD, 'TOTAL', '1', SUB_TRD_CD) DESC, BSA_AVG DESC," ).append("\n"); 
		query.append("         DECODE(RLANE_CD, 'TOTAL', 'ZZZZZ', RLANE_CD)," ).append("\n"); 
		query.append("--         DECODE(DIR_CD, 'TOTAL', '00000', DIR_CD), --2010.09.16 이윤정 [CHM-201005916-01] Weekly L/F by Carrier 화면의 조회 결과 값에 따른 정렬 변경" ).append("\n"); 
		query.append("		 DECODE(DIR_CD, 'TOTAL', decode(OPR_CD,'TOTAL','ZZZZZ','00000'), DIR_CD)," ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("-- @2010.12.15 Carrier 정렬 변경" ).append("\n"); 
		query.append("         DECODE(OPR_CD, 'VVD', '00000', 'ITEM', '00001', COM_ConstantMgr_PKG.COM_getCompanyCode_FNC, '00002', 'COS', '00003', 'KKL', '00004', 'YML', '00005', 'UAC', '00006', 'TOTAL', 'ZZZZZ', OPR_CD)" ).append("\n"); 

	}
}
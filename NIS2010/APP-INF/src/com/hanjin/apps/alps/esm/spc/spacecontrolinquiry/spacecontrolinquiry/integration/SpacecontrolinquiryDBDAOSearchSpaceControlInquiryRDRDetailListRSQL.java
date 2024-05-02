/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryRDRDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.05
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2011.10.05 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchSpaceControlInquiryRDRDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR 실적 중 POL/POD 세부 Data 조회
	  * 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발
	  * 2011.03.02 이석준 [CHM-201109016-01] 
	  *                 RDR에 BSA정보가 없을시 SPC_BSA_MGMT TABLE에서 BSA 정보를 보여주도록 쿼리 수정
	  * 2011.07.05 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
	  *  - Lane 조회조건 추가 및 Full TEU/Mty TEU 각각의 항목 옆에 Full WGT/Mty WGT 항목 추가
	  * 2011.10.05 김종준 [CHM-201113755-01] 
	  * 	-IOC가 ‘O’인 경우에만 조회가 가능토록 되어있으나, WAFIE와 마찬가지로 NBSIM 노선의 경우,
	  * 	  Intra 노선이지만, Ocean 처럼 인식되어 데이터가 조회될 수 있도록 보완 요청
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchSpaceControlInquiryRDRDetailListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryRDRDetailListRSQL").append("\n"); 
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
		query.append("SELECT OPR_CD,COST_WK,TRD_CD,SUB_TRD_CD,RLANE_CD,VVD,DIR_CD," ).append("\n"); 
		query.append("        DECODE(BSA,0,DECODE(B_BSA,0,C_BSA,B_BSA),-- RDR Alloc에 없으면 BSA MGMT 값 적용" ).append("\n"); 
		query.append("                     DECODE(B_LAST_FLG,1,BSA,-1,B_BSA,0,C_BSA)) BASIC_SLOT, -- RDR Alloc이 있으면 Update Date일자 비교하여 최근것을 적용" ).append("\n"); 
		query.append("       CNTR_TYPE, " ).append("\n"); 
		query.append("       CNTR_20,CNTR_20H,CNTR_40,CNTR_40H,CNTR_45," ).append("\n"); 
		query.append("       FULL_TEU,FULL_WGT,MTY_TEU,MTY_WGT," ).append("\n"); 
		query.append("       POL,POD" ).append("\n"); 
		query.append("  FROM (        " ).append("\n"); 
		query.append("        SELECT A.OPR_CD,A.COST_WK,A.TRD_CD,A.SUB_TRD_CD,A.RLANE_CD,A.VVD,A.DIR_CD," ).append("\n"); 
		query.append("               A.BSA," ).append("\n"); 
		query.append("               NVL(B.BSA_CAPA,0) B_BSA," ).append("\n"); 
		query.append("               NVL(C.BSA_CAPA,0) C_BSA," ).append("\n"); 
		query.append("               NVL(B.UPD_DT,TO_DATE('19900101','YYYYMMDD')) B_UPD_DT," ).append("\n"); 
		query.append("               NVL(C.UPD_DT,TO_DATE('19900101','YYYYMMDD')) C_UPD_DT," ).append("\n"); 
		query.append("               SIGN(NVL(A.UPD_DT,TO_DATE('19900101','YYYYMMDD')) - NVL(B.UPD_DT,TO_DATE('19900101','YYYYMMDD'))) B_LAST_FLG," ).append("\n"); 
		query.append("               SIGN(NVL(A.UPD_DT,TO_DATE('19900101','YYYYMMDD')) - NVL(C.UPD_DT,TO_DATE('19900101','YYYYMMDD'))) C_LAST_FLG,  " ).append("\n"); 
		query.append("               A.CNTR_TYPE," ).append("\n"); 
		query.append("               A.CNTR_20,A.CNTR_20H,A.CNTR_40,A.CNTR_40H,A.CNTR_45," ).append("\n"); 
		query.append("               A.FULL_TEU,A.FULL_WGT,A.MTY_TEU,A.MTY_WGT," ).append("\n"); 
		query.append("               A.POL,A.POD" ).append("\n"); 
		query.append("          FROM (       " ).append("\n"); 
		query.append("                SELECT  S.OPR_CD" ).append("\n"); 
		query.append("                       ,V.COST_WK" ).append("\n"); 
		query.append("                       ,V.TRD_CD" ).append("\n"); 
		query.append("                       ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("                       ,V.RLANE_CD" ).append("\n"); 
		query.append("                       ,S.VSL_CD||S.VOY_NO||S.DIR_CD AS VVD" ).append("\n"); 
		query.append("                       ,S.DIR_CD" ).append("\n"); 
		query.append("                       ,NVL(B.BASIC_SLOT,0) BSA" ).append("\n"); 
		query.append("                       ,S.CNTR_TYPE" ).append("\n"); 
		query.append("                       ,SUM(DECODE(S.CNTR_SIZE, '2', S.QTY, 0)) AS CNTR_20" ).append("\n"); 
		query.append("                       ,SUM(DECODE(S.CNTR_SIZE, '3', S.QTY, 0)) AS CNTR_20H" ).append("\n"); 
		query.append("                       ,SUM(DECODE(S.CNTR_SIZE, '4', S.QTY, 0)) AS CNTR_40" ).append("\n"); 
		query.append("                       ,SUM(DECODE(S.CNTR_SIZE, 'H', S.QTY, 0)) AS CNTR_40H" ).append("\n"); 
		query.append("                       ,SUM(DECODE(S.CNTR_SIZE, 'L', S.QTY, 0)) AS CNTR_45" ).append("\n"); 
		query.append("                       ,DECODE(S.CNTR_TYPE, 'F', SUM(DECODE(S.CNTR_SIZE, '2', S.QTY, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, '3', S.QTY, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, '4', S.QTY, 0)) * 2 +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, 'H', S.QTY, 0)) * 2 +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, 'L', S.QTY, 0)) * 2 , 0) AS FULL_TEU" ).append("\n"); 
		query.append("                       ,DECODE(S.CNTR_TYPE, 'F', SUM(DECODE(S.CNTR_SIZE, '2', S.WEIGHT, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, '3', S.WEIGHT, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, '4', S.WEIGHT, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, 'H', S.WEIGHT, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, 'L', S.WEIGHT, 0)) , 0) AS FULL_WGT" ).append("\n"); 
		query.append("                       ,DECODE(S.CNTR_TYPE, 'E', SUM(DECODE(S.CNTR_SIZE, '2', S.QTY, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, '3', S.QTY, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, '4', S.QTY, 0)) * 2 +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, 'H', S.QTY, 0)) * 2 +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, 'L', S.QTY, 0)) * 2 , 0) AS MTY_TEU" ).append("\n"); 
		query.append("                       ,DECODE(S.CNTR_TYPE, 'E', SUM(DECODE(S.CNTR_SIZE, '2', S.WEIGHT, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, '3', S.WEIGHT, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, '4', S.WEIGHT, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, 'H', S.WEIGHT, 0)) +" ).append("\n"); 
		query.append("                                                 SUM(DECODE(S.CNTR_SIZE, 'L', S.WEIGHT, 0)) , 0) AS MTY_WGT" ).append("\n"); 
		query.append("                       ,S.POL" ).append("\n"); 
		query.append("                       ,S.POD" ).append("\n"); 
		query.append("                       ,MAX(B.UPD_DT) UPD_DT" ).append("\n"); 
		query.append("                  FROM  RDR_HEADER     H" ).append("\n"); 
		query.append("                       ,RDR_SUMMARY    S" ).append("\n"); 
		query.append("                       ,(SELECT  M.VSL_CD," ).append("\n"); 
		query.append("                                 M.VOY_NO," ).append("\n"); 
		query.append("                                 M.DIR_CD," ).append("\n"); 
		query.append("                                 M.REGION," ).append("\n"); 
		query.append("                                 M.OPR_CD        AS OPR_CD," ).append("\n"); 
		query.append("                                 SUM(M.BSA_SLOT) AS BASIC_SLOT," ).append("\n"); 
		query.append("                                 MAX(M.UPDATE_TIME) UPD_DT" ).append("\n"); 
		query.append("                           FROM  RDR_ALLOCATION M" ).append("\n"); 
		query.append("                          WHERE  1 = 1" ).append("\n"); 
		query.append("                			#if (${rhq} == 'A')" ).append("\n"); 
		query.append("                			AND M.REGION IN ('A', 'D','E')" ).append("\n"); 
		query.append("                			#else" ).append("\n"); 
		query.append("                				#if (${rhq} == 'M')" ).append("\n"); 
		query.append("                				AND M.REGION IN ('M', 'S')" ).append("\n"); 
		query.append("                				#else" ).append("\n"); 
		query.append("                				AND M.REGION = @[rhq]" ).append("\n"); 
		query.append("                				#end" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                         GROUP BY M.VSL_CD, M.VOY_NO, M.DIR_CD, M.REGION, M.OPR_CD" ).append("\n"); 
		query.append("                        ) B" ).append("\n"); 
		query.append("                       ,MAS_MON_VVD    V" ).append("\n"); 
		query.append("                       ,(" ).append("\n"); 
		query.append("                        SELECT  /*+ INDEX (P, XPKMAS_WK_PRD)*/" ).append("\n"); 
		query.append("                                P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                                ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                          FROM  MAS_WK_PRD P" ).append("\n"); 
		query.append("                         WHERE  P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                           AND  ROWNUM               <= @[duration]" ).append("\n"); 
		query.append("                        ) P" ).append("\n"); 
		query.append("                 WHERE  1 = 1   " ).append("\n"); 
		query.append("                   AND  SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = P.COST_YRWK" ).append("\n"); 
		query.append("                   AND V.TRD_CD     = @[trade]" ).append("\n"); 
		query.append("                   AND V.DIR_CD     LIKE @[bound] || '%'" ).append("\n"); 
		query.append("                   AND V.SUB_TRD_CD LIKE @[subtrade] || '%'" ).append("\n"); 
		query.append("                   AND V.RLANE_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                #if (${operator} != '')" ).append("\n"); 
		query.append("                   AND B.OPR_CD     = @[operator]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("        #if (${rhq} == 'A')" ).append("\n"); 
		query.append("               AND B.REGION IN ('A', 'D',DECODE(V.RLANE_CD||V.DIR_CD,'AE1AEW','E','D'))" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rhq} =='E')" ).append("\n"); 
		query.append("			   AND B.REGION = DECODE(V.RLANE_CD,'AE1AE',DECODE(V.DIR_CD,'E','E','XXX'),'E')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                   AND  H.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("                   AND  H.VOY_NO = S.VOY_NO" ).append("\n"); 
		query.append("                   AND  H.DIR_CD = S.DIR_CD" ).append("\n"); 
		query.append("                   AND  H.REGION = S.REGION" ).append("\n"); 
		query.append("                   AND  H.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                   AND  H.VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND  H.DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("                   AND  H.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND  H.VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                   AND  H.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                   AND  H.REGION = B.REGION" ).append("\n"); 
		query.append("                   AND  S.OPR_CD = B.OPR_CD" ).append("\n"); 
		query.append("                   AND  S.CNTR_SIZE IN ('2',  '3',  '4',  'H',  'L' )" ).append("\n"); 
		query.append("                   AND  DECODE(V.RLANE_CD, 'WAFIE', 'O', 'NBSIM', 'O', V.IOC_CD)   = 'O'" ).append("\n"); 
		query.append("                   AND (V.DELT_FLG IS NULL OR V.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                        S.OPR_CD" ).append("\n"); 
		query.append("                       ,V.COST_WK" ).append("\n"); 
		query.append("                       ,V.TRD_CD" ).append("\n"); 
		query.append("                       ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("                       ,V.RLANE_CD" ).append("\n"); 
		query.append("                       ,S.VSL_CD||S.VOY_NO||S.DIR_CD" ).append("\n"); 
		query.append("                       ,S.DIR_CD" ).append("\n"); 
		query.append("                       ,B.BASIC_SLOT" ).append("\n"); 
		query.append("                       ,S.CNTR_TYPE" ).append("\n"); 
		query.append("                       ,S.POL" ).append("\n"); 
		query.append("                       ,S.POD" ).append("\n"); 
		query.append("                ) A," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                select TRD_CD,SUB_TRD_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,CRR_CD," ).append("\n"); 
		query.append("                       BSA_CAPA,UPD_DT" ).append("\n"); 
		query.append("                  from SPC_BSA_MGMT" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                  #if (${trade} != '')" ).append("\n"); 
		query.append("                   AND TRD_CD     = @[trade]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  #if (${subtrade} != '')" ).append("\n"); 
		query.append("                   AND SUB_TRD_CD     = @[subtrade]" ).append("\n"); 
		query.append("                  #end          " ).append("\n"); 
		query.append("                  #if (${bound} != '')" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD     = @[bound]" ).append("\n"); 
		query.append("                  #end         " ).append("\n"); 
		query.append("                  #if (${operator} != '')" ).append("\n"); 
		query.append("                   AND CRR_CD     = @[operator]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                ) B," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                select DISTINCT TRD_CD,SUB_TRD_CD,VSL_CD,SKD_DIR_CD,CRR_CD," ).append("\n"); 
		query.append("                       FIRST_VALUE(BSA_CAPA) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,VSL_CD,CRR_CD,SKD_DIR_CD ORDER BY BSA_SEQ DESC) BSA_CAPA," ).append("\n"); 
		query.append("                       FIRST_VALUE(UPD_DT) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,VSL_CD,CRR_CD,SKD_DIR_CD ORDER BY BSA_SEQ DESC) UPD_DT" ).append("\n"); 
		query.append("                  from SPC_BSA_MGMT" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                  #if (${trade} != '')" ).append("\n"); 
		query.append("                   AND TRD_CD     = @[trade]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  #if (${subtrade} != '')" ).append("\n"); 
		query.append("                   AND SUB_TRD_CD     = @[subtrade]" ).append("\n"); 
		query.append("                  #end          " ).append("\n"); 
		query.append("                  #if (${bound} != '')" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD     = @[bound]" ).append("\n"); 
		query.append("                  #end         " ).append("\n"); 
		query.append("                  #if (${operator} != '')" ).append("\n"); 
		query.append("                   AND CRR_CD     = @[operator]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                 ) C          " ).append("\n"); 
		query.append("             WHERE A.TRD_CD          = B.TRD_CD(+)" ).append("\n"); 
		query.append("               AND A.SUB_TRD_CD      = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("               AND SUBSTR(A.VVD,1,4) = B.VSL_CD(+)" ).append("\n"); 
		query.append("               AND SUBSTR(A.VVD,5,4) = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("               AND A.DIR_CD          = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("               AND A.OPR_CD      = B.CRR_CD(+)" ).append("\n"); 
		query.append("               AND A.TRD_CD          = C.TRD_CD(+)" ).append("\n"); 
		query.append("               AND A.SUB_TRD_CD      = C.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("               AND SUBSTR(A.VVD,1,4) = C.VSL_CD(+)" ).append("\n"); 
		query.append("               AND A.DIR_CD          = C.SKD_DIR_CD(+)   " ).append("\n"); 
		query.append("               AND A.OPR_CD      = C.CRR_CD(+)     " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        COST_WK" ).append("\n"); 
		query.append("       ,TRD_CD" ).append("\n"); 
		query.append("       ,SUB_TRD_CD" ).append("\n"); 
		query.append("       ,RLANE_CD" ).append("\n"); 
		query.append("       ,VVD    " ).append("\n"); 
		query.append("       ,POD" ).append("\n"); 
		query.append("       ,POL" ).append("\n"); 
		query.append("       ,OPR_CD" ).append("\n"); 
		query.append("       ,CNTR_TYPE" ).append("\n"); 

	}
}

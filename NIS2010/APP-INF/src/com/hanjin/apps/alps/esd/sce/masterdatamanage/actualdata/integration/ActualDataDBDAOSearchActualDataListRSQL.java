/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ActualDataDBDAOSearchActualDataListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.18 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualDataDBDAOSearchActualDataListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2013.05.14 김상수 [CHM-201324115] Actual Data Receiving Status 보완요청
	  *                    - CNTR no 입력후 retrieve 시 다른 조회 조건은 필요하지 않도록 로직 수정
	  *                    - CNTR No.가 없는 건 (SMCU0000000) 대상에서 제외
	  *                    - EDI MSG ID, EDI 컬럼을 Service Provider 앞 위치로 이동시키고 그 위치에 VVD 컬럼 추가
	  *                    - On Time 정렬기능 추가
	  *                    - Activity 컬럼 앞에 Activity Code 컬럼 추가
	  * 2013.06.21 김상수 [CHM-201324903] Actual Data Receiving Status 보완요청(추가)
	  *                    - 조회조건에 다건의 Yard Code 입력 가능하게 수정
	  * </pre>
	  */
	public ActualDataDBDAOSearchActualDataListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.integration").append("\n"); 
		query.append("FileName : ActualDataDBDAOSearchActualDataListRSQL").append("\n"); 
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
		query.append("  T2.CNTR_NO," ).append("\n"); 
		query.append("  T2.COP_NO," ).append("\n"); 
		query.append("  T2.BKG_NO," ).append("\n"); 
		query.append("  T2.NOD_CD," ).append("\n"); 
		query.append("  T2.ACT_CD," ).append("\n"); 
		query.append("  T2.ACT_NM," ).append("\n"); 
		query.append("  T2.VNDR_SEQ," ).append("\n"); 
		query.append("  T2.ACT_RCV_TP_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${actual_receiving} == 'Y')" ).append("\n"); 
		query.append("  @[act_rcv_tp_cd] AS ACT_RCV_TP_NM," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  '' AS ACT_RCV_TP_NM," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  T2.ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("  T2.EDI_MSG_TP_CD," ).append("\n"); 
		query.append("  T2.STND_EDI_STS_CD," ).append("\n"); 
		query.append("  TO_CHAR(T2.ACT_DT, 'YYYY-MM-DD') ACT_DATE," ).append("\n"); 
		query.append("  TO_CHAR(T2.ACT_DT, 'HH24:MI') ACT_TIME," ).append("\n"); 
		query.append("  TO_CHAR(T2.PLN_DT, 'YYYY-MM-DD') PLN_DATE," ).append("\n"); 
		query.append("  TO_CHAR(T2.PLN_DT, 'HH24:MI') PLN_TIME," ).append("\n"); 
		query.append("  TO_CHAR(T2.ACT_DAT_RCV_DT, 'YYYY-MM-DD') RCV_DATE," ).append("\n"); 
		query.append("  TO_CHAR(T2.ACT_DAT_RCV_DT, 'HH24:MI') RCV_TIME," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("    WHEN T2.ACT_DAT_RCV_DT - T2.ACT_DT <= 1 THEN TO_CHAR(0)" ).append("\n"); 
		query.append("    ELSE TO_CHAR(1)" ).append("\n"); 
		query.append("  END AS ON_TIME_CK," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("    WHEN T2.ACT_DAT_RCV_DT - T2.ACT_DT <= 1 THEN TO_CHAR(1)" ).append("\n"); 
		query.append("    ELSE TO_CHAR(0)" ).append("\n"); 
		query.append("  END AS ON_TIME," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("    WHEN T2.ACT_DAT_RCV_DT - T2.ACT_DT <= 1 THEN TO_CHAR(0)" ).append("\n"); 
		query.append("    ELSE TO_CHAR(1)" ).append("\n"); 
		query.append("  END AS NON_ON_TIME," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${actual_receiving} == 'Y')" ).append("\n"); 
		query.append("  NVL(USR_ID,'SceAutoMapped') AS USR_ID" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  USR_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,VVD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT T1.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT /*+ no_expand */" ).append("\n"); 
		query.append("          SCD.NOD_CD," ).append("\n"); 
		query.append("          SCD.ACT_CD," ).append("\n"); 
		query.append("          MA.ACT_NM," ).append("\n"); 
		query.append("          SCH.CNTR_NO," ).append("\n"); 
		query.append("          SCH.COP_NO," ).append("\n"); 
		query.append("          SCH.BKG_NO," ).append("\n"); 
		query.append("          SCD.VNDR_SEQ," ).append("\n"); 
		query.append("          SCD.ACT_RCV_TP_CD," ).append("\n"); 
		query.append("          SCD.ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("          SCD.EDI_MSG_TP_CD," ).append("\n"); 
		query.append("          SCD.STND_EDI_STS_CD," ).append("\n"); 
		query.append("          SCD.UPD_DT," ).append("\n"); 
		query.append("          SCD.ACT_DT," ).append("\n"); 
		query.append("          SCD.PLN_DT," ).append("\n"); 
		query.append("          SCD.ACT_DAT_RCV_DT," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("             WHEN SCD.ACT_RCV_TP_CD = '1' THEN" ).append("\n"); 
		query.append("			   (" ).append("\n"); 
		query.append("					SELECT  UPD_USR_ID" ).append("\n"); 
		query.append("					FROM    CTM_MOVEMENT" ).append("\n"); 
		query.append("					WHERE   ( CNTR_NO, CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO )" ).append("\n"); 
		query.append("							=" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SELECT AI.CNTR_NO, AI.CNMV_YR, AI.CNMV_SEQ, NVL(AI.CNMV_SPLIT_NO,' ')" ).append("\n"); 
		query.append("								FROM SCE_ACT_RCV_IF AI" ).append("\n"); 
		query.append("								WHERE AI.BKG_NO   = SCH.BKG_NO" ).append("\n"); 
		query.append("								AND  AI.CNTR_NO   = SCH.CNTR_NO" ).append("\n"); 
		query.append("								AND  AI.ACT_DAT_RCV_DT = SCD.ACT_DAT_RCV_DT" ).append("\n"); 
		query.append("								AND  AI.ACT_DT   = SCD.ACT_DT" ).append("\n"); 
		query.append("								AND  AI.ACT_STS_MAPG_CD = SCD.ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("								AND  AI.ACT_UMCH_TP_CD = '99'" ).append("\n"); 
		query.append("								AND  ROWNUM    = 1" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("             WHEN SCD.ACT_RCV_TP_CD = '2' THEN (" ).append("\n"); 
		query.append("                SELECT AI.CRE_USR_ID" ).append("\n"); 
		query.append("                FROM SCE_ACT_RCV_IF AI" ).append("\n"); 
		query.append("                WHERE AI.VSL_CD = SCD.VSL_CD" ).append("\n"); 
		query.append("                  AND AI.SKD_VOY_NO = SCD.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND AI.SKD_DIR_CD = SCD.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND AI.VPS_PORT_CD = SCD.VPS_PORT_CD" ).append("\n"); 
		query.append("                  --AND AI.ACT_DAT_RCV_DT =	SCD.ACT_DAT_RCV_DT" ).append("\n"); 
		query.append("                  AND AI.CLPT_IND_SEQ = SCD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND AI.ACT_DT = SCD.ACT_DT" ).append("\n"); 
		query.append("                  AND SUBSTR(AI.ACT_STS_MAPG_CD, 3, 1) = SUBSTR(SCD.ACT_CD, 5, 1)" ).append("\n"); 
		query.append("                  AND AI.ACT_UMCH_TP_CD = '99'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1 )" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("             END ) USR_ID" ).append("\n"); 
		query.append("			 ,SCD.VSL_CD||SCD.SKD_VOY_NO||SCD.SKD_DIR_CD	VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          /* New (3) */" ).append("\n"); 
		query.append("        FROM SCE_COP_HDR SCH," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT D.*" ).append("\n"); 
		query.append("            FROM SCE_COP_DTL D ," ).append("\n"); 
		query.append("              MDM_COUNTRY C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${nod_cd} != '')" ).append("\n"); 
		query.append("               AND NOD_CD IN (${nod_cd})" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cntr_no} != '')" ).append("\n"); 
		query.append("               AND	COP_NO	IN	(" ).append("\n"); 
		query.append("									SELECT	H.COP_NO" ).append("\n"); 
		query.append("									FROM	SCE_COP_HDR H" ).append("\n"); 
		query.append("									WHERE	CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("									AND		H.COP_STS_CD	<> 'X'" ).append("\n"); 
		query.append("									AND		H.CNTR_NO		<> 'SMCU0000000'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("              AND SUBSTR(D.NOD_CD, 1, 2) = C.CNT_CD" ).append("\n"); 
		query.append("              AND ( (" ).append("\n"); 
		query.append("						SUBSTR(C.SCONTI_CD, 1, 1) <> 'M'" ).append("\n"); 
		query.append("						AND D.ACT_CD NOT IN (	'FIRRLO'," ).append("\n"); 
		query.append("												'FIRRUD'," ).append("\n"); 
		query.append("												'FORRLO'," ).append("\n"); 
		query.append("												'FORRUD'" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("					OR" ).append("\n"); 
		query.append("					( SUBSTR(C.SCONTI_CD, 1, 1) = 'M' )" ).append("\n"); 
		query.append("				  )" ).append("\n"); 
		query.append("			  AND  D.ACT_CD NOT IN" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("							'MOTZAD'," ).append("\n"); 
		query.append("							'FITZAD'," ).append("\n"); 
		query.append("							'FIWMDO'," ).append("\n"); 
		query.append("							'FIWMLO'," ).append("\n"); 
		query.append("							'FIWMUD'," ).append("\n"); 
		query.append("							'FLWMUD'," ).append("\n"); 
		query.append("							'FOWMLO'," ).append("\n"); 
		query.append("							'FUWMLO'" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("            #if(${sc_cd} != '')" ).append("\n"); 
		query.append("              AND VNDR_SEQ = @[sc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${actual_receiving} == 'Y')" ).append("\n"); 
		query.append("              #if (${act_rcv_tp_cd} == 'MVMT')" ).append("\n"); 
		query.append("             -- AND ACT_RCV_TP_CD = '1'" ).append("\n"); 
		query.append("                AND ACT_RCV_TP_CD IN ( '1' ,'3', '9' )" ).append("\n"); 
		query.append("              #elseif (${act_rcv_tp_cd} == 'VSK')" ).append("\n"); 
		query.append("                AND ACT_RCV_TP_CD = '2'" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			  #if (${act_rcv_tp_cd} == 'MVMT')" ).append("\n"); 
		query.append("			  AND	(" ).append("\n"); 
		query.append("						ACT_CD IN ( 'FUWMDO', 'FIWMAD', 'FLWMAD', 'FOWMDO' )" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						NOT ( SUBSTR(ACT_CD,5,1)  IN ( 'A','B', 'D' ) AND SUBSTR(ACT_CD,3,1)  IN ( 'V','W' ) )" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			  #elseif (${act_rcv_tp_cd} == 'VSK')" ).append("\n"); 
		query.append("			   AND	(" ).append("\n"); 
		query.append("						ACT_CD NOT IN ( 'FUWMDO', 'FIWMAD', 'FLWMAD', 'FOWMDO' )" ).append("\n"); 
		query.append("						AND" ).append("\n"); 
		query.append("						( SUBSTR(ACT_CD,5,1)  IN ( 'A','B', 'D' ) AND SUBSTR(ACT_CD,3,1)  IN ( 'V','W' ) )" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${actual_receiving} == 'Y')" ).append("\n"); 
		query.append("              #if (${on_time} == 'Y')" ).append("\n"); 
		query.append("              AND ( ACT_DAT_RCV_DT - ACT_DT ) <= 1" ).append("\n"); 
		query.append("              #elseif (${on_time} == 'N')" ).append("\n"); 
		query.append("              AND ( ACT_DAT_RCV_DT - ACT_DT ) > 1" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${act_sts_mapg_cd} != '')" ).append("\n"); 
		query.append("              AND ACT_STS_MAPG_CD = @[act_sts_mapg_cd]" ).append("\n"); 
		query.append("            #end #if (${act_cd} != '')" ).append("\n"); 
		query.append("              #if (${act_cd} != 'ALL')" ).append("\n"); 
		query.append("                AND ACT_CD = @[act_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${act_dt1} != '' && ${act_dt2} != '')" ).append("\n"); 
		query.append("			 AND PLN_DT BETWEEN TO_DATE(@[act_dt1], 'yyyy-MM-dd') AND TO_DATE(@[act_dt2], 'yyyy-MM-dd') + .99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${actual_receiving} == 'Y')" ).append("\n"); 
		query.append("               AND	ACT_DT IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("               AND	ACT_DT IS NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("          #if (${cntr_no} != '')" ).append("\n"); 
		query.append("               ORDER BY PLN_DT" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("            ) SCD ," ).append("\n"); 
		query.append("          MDM_ACTIVITY MA ," ).append("\n"); 
		query.append("          BKG_BOOKING BK" ).append("\n"); 
		query.append("        WHERE SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("          AND SCH.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("          AND SCH.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("          AND BK.BKG_CGO_TP_CD <> 'R'" ).append("\n"); 
		query.append("          AND BK.BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("          AND SCD.ACT_CD = MA.ACT_CD" ).append("\n"); 
		query.append("        #if (${cntr_no} != '')" ).append("\n"); 
		query.append("          AND SCH.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("          AND SCH.CNTR_NO <> 'SMCU0000000'" ).append("\n"); 
		query.append("         ) T1" ).append("\n"); 
		query.append("    ) T2" ).append("\n"); 

	}
}
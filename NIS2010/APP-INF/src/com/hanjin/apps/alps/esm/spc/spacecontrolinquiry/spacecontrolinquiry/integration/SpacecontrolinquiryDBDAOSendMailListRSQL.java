/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSendMailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.12.17 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSendMailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.06.15 김종준 [CHM-201110708-01]  F"cast 입력 요청 메세지 송부 기능
	  * 2011.08.02 이행지 [CHM-201112670-01] F''cast Auto Message 대상 선정 로직 보완 - sls_ofc_cd NVL처리되어있던것 outer join으로 수정, having절 수정
	  * 2011.11.16 김종준 [CHM-201114558-01] F'cast Auto Message  SQL 튜닝
	  * 2014.03.25 김시몬 [선처리] SQM 분기구하는 로직 관련 보완
	  * 2015.03.03 CHM-201534458 SQM QTA주가 변경 관련 적용 요청
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSendMailListRSQL(){
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
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSendMailListRSQL").append("\n"); 
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
		query.append("WITH CW AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      SELECT /*+ INDEX(P XPKMAS_WK_PRD) */" ).append("\n"); 
		query.append("             P.COST_YR ," ).append("\n"); 
		query.append("             P.COST_WK ," ).append("\n"); 
		query.append("             ROWNUM AS NUM" ).append("\n"); 
		query.append("        FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("       WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("         AND ROWNUM               <= @[duration]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",CW2 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      SELECT /*+ INDEX_DESC(P XPKMAS_WK_PRD) */" ).append("\n"); 
		query.append("             P.COST_YR ," ).append("\n"); 
		query.append("             P.COST_WK ," ).append("\n"); 
		query.append("             ROWNUM AS NUM" ).append("\n"); 
		query.append("        FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("       WHERE P.COST_YR||P.COST_WK < @[year]||@[week]" ).append("\n"); 
		query.append("         AND ROWNUM               <= 6" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT SLS_OFC_CD, TRD_CD, SUB_TRD_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, DIR_CD, SLS_YRMON, COST_WK,BSE_QTR_CD, BSE_YR" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT T.TRD_CD, T.SUB_TRD_CD, T.RLANE_CD, T.VSL_CD, T.SKD_VOY_NO, T.DIR_CD, T.SLS_YRMON, T.COST_WK, T.SLS_OFC_CD,T.BSE_QTR_CD,T.BSE_YR" ).append("\n"); 
		query.append("      FROM SPC_DLY_FCAST_CUST C," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT /*+ ORDERED USE_NL(CW V M) */ " ).append("\n"); 
		query.append("               V.TRD_CD, V.SUB_TRD_CD,  V.RLANE_CD, V.IOC_CD, V.VSL_CD, V.SKD_VOY_NO, V.DIR_CD, V.SLS_YRMON, V.COST_WK, M.SLS_OFC_CD, M.POL_CD" ).append("\n"); 
		query.append("               , CASE WHEN V.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("                      THEN CEIL(TO_NUMBER(SUBSTR(V.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("                      ELSE CEIL(TO_NUMBER(DECODE(V.COST_WK,'00','01','53','52',V.COST_WK))/13)||'Q'" ).append("\n"); 
		query.append("                 END BSE_QTR_CD --2015.03.04 CHM-201534435 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("              , SUBSTR(V.COST_YRMON, 1,4) AS BSE_YR" ).append("\n"); 
		query.append("          FROM CW, " ).append("\n"); 
		query.append("			   MAS_MON_VVD V," ).append("\n"); 
		query.append("               SPC_FCAST_OFC_POL_MAPG M             " ).append("\n"); 
		query.append("         WHERE M.REP_TRD_CD         = SPC_GET_REP_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("           AND M.REP_SUB_TRD_CD     = SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("           AND M.RLANE_CD           = V.RLANE_CD" ).append("\n"); 
		query.append("           AND M.DIR_CD             = V.DIR_CD" ).append("\n"); 
		query.append("           AND M.IOC_TS_CD          = V.IOC_CD" ).append("\n"); 
		query.append("           AND M.TRD_CD             = V.TRD_CD" ).append("\n"); 
		query.append("           AND M.SUB_TRD_CD         = V.SUB_TRD_CD" ).append("\n"); 
		query.append("           AND NVL(V.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("           AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = CW.COST_YR||CW.COST_WK" ).append("\n"); 
		query.append("           AND EXISTS   ( SELECT /*+ INDEX_DESC(MI XPKSPC_FCAST_OFC_POL_MAPG) */" ).append("\n"); 
		query.append("                                 'X'" ).append("\n"); 
		query.append("                            FROM SPC_FCAST_OFC_POL_MAPG MI" ).append("\n"); 
		query.append("                           WHERE MI.REP_TRD_CD     = M.REP_TRD_CD" ).append("\n"); 
		query.append("                             AND MI.REP_SUB_TRD_CD = M.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("                             AND MI.RLANE_CD       = M.RLANE_CD" ).append("\n"); 
		query.append("                             AND MI.DIR_CD         = M.DIR_CD" ).append("\n"); 
		query.append("                             AND MI.IOC_TS_CD      = M.IOC_TS_CD" ).append("\n"); 
		query.append("                             AND MI.SLS_OFC_CD     = M.SLS_OFC_CD" ).append("\n"); 
		query.append("                             AND MI.BSE_YRWK       = M.BSE_YRWK" ).append("\n"); 
		query.append("                             AND MI.BSE_YRWK      <= SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("           AND M.SLS_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                 FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("                                WHERE N2ND_PRNT_OFC_CD IN (" ).append("\n"); 
		query.append("                                                            #foreach ($key in ${ilist})" ).append("\n"); 
		query.append("                                                                #if($velocityCount < $ilist.size())" ).append("\n"); 
		query.append("                                                                    '$key'," ).append("\n"); 
		query.append("                                                                #else" ).append("\n"); 
		query.append("                                                                    '$key'" ).append("\n"); 
		query.append("                                                                #end" ).append("\n"); 
		query.append("                                                            #end)" ).append("\n"); 
		query.append("                                  AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK)" ).append("\n"); 
		query.append("           AND V.TRD_CD IN (" ).append("\n"); 
		query.append("							#foreach ($key in ${trdCdlist})" ).append("\n"); 
		query.append("                 			  	#if($velocityCount < $trdCdlist.size())" ).append("\n"); 
		query.append("                  				  '$key'," ).append("\n"); 
		query.append("                  				  	#else" ).append("\n"); 
		query.append("                  				  '$key'" ).append("\n"); 
		query.append("                    			#end" ).append("\n"); 
		query.append("							#end)" ).append("\n"); 
		query.append("           #if($subTrdCdlist.size() > 0)" ).append("\n"); 
		query.append("           AND V.SUB_TRD_CD IN (" ).append("\n"); 
		query.append("								#foreach ($key in ${subTrdCdlist})" ).append("\n"); 
		query.append("                 			  		#if($velocityCount < $subTrdCdlist.size())" ).append("\n"); 
		query.append("                  				  		'$key'," ).append("\n"); 
		query.append("                  				  	#else" ).append("\n"); 
		query.append("                  				  		'$key'" ).append("\n"); 
		query.append("                    				#end" ).append("\n"); 
		query.append("								#end)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if($boundList.size() > 0)" ).append("\n"); 
		query.append("       	    AND V.DIR_CD IN (" ).append("\n"); 
		query.append("							#foreach ($key in ${boundList})" ).append("\n"); 
		query.append("                 			  	#if($velocityCount < $boundList.size())" ).append("\n"); 
		query.append("                  				  '$key'," ).append("\n"); 
		query.append("                  				  	#else" ).append("\n"); 
		query.append("                  				  '$key'" ).append("\n"); 
		query.append("                    			#end" ).append("\n"); 
		query.append("							#end)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if($rlaneList.size() > 0)" ).append("\n"); 
		query.append("            AND V.RLANE_CD IN (" ).append("\n"); 
		query.append("								#foreach ($key in ${rlaneList})" ).append("\n"); 
		query.append("                 			  		#if($velocityCount < $rlaneList.size())" ).append("\n"); 
		query.append("                  				  		'$key'," ).append("\n"); 
		query.append("                  				  	#else" ).append("\n"); 
		query.append("                  				  		'$key'" ).append("\n"); 
		query.append("                    				#end" ).append("\n"); 
		query.append("								#end)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT /*+ ORDERED USE_NL(CW M O) INDEX(V XFN1MAS_MON_VVD) */ " ).append("\n"); 
		query.append("				V.TRD_CD, V.SUB_TRD_CD, V.RLANE_CD, V.IOC_CD, V.VSL_CD, V.SKD_VOY_NO, V.DIR_CD, V.SLS_YRMON, V.COST_WK , M.SLS_OFC_CD, M.POL_CD" ).append("\n"); 
		query.append("               , CASE WHEN V.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("                      THEN CEIL(TO_NUMBER(SUBSTR(V.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("                      ELSE CEIL(TO_NUMBER(DECODE(V.COST_WK,'00','01','53','52',V.COST_WK))/13)||'Q'" ).append("\n"); 
		query.append("                 END BSE_QTR_CD --2015.03.04 CHM-201534435 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("              , SUBSTR(V.COST_YRMON, 1,4) AS BSE_YR" ).append("\n"); 
		query.append("          FROM  CW," ).append("\n"); 
		query.append("           		MAS_MON_VVD V," ).append("\n"); 
		query.append("           		SPC_IRR_FCAST_OFC_POL_MAPG M," ).append("\n"); 
		query.append("           		SPC_OFC_LVL O" ).append("\n"); 
		query.append("         WHERE M.REP_TRD_CD         = SPC_GET_REP_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("           AND M.REP_SUB_TRD_CD     = SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("           AND M.TRD_CD             = V.TRD_CD" ).append("\n"); 
		query.append("           AND M.SUB_TRD_CD         = V.SUB_TRD_CD" ).append("\n"); 
		query.append("           AND M.RLANE_CD           = V.RLANE_CD" ).append("\n"); 
		query.append("           AND M.DIR_CD             = V.DIR_CD" ).append("\n"); 
		query.append("           AND M.IOC_TS_CD          = V.IOC_CD" ).append("\n"); 
		query.append("           AND M.VSL_CD             = V.VSL_CD" ).append("\n"); 
		query.append("           AND M.SKD_VOY_NO         = V.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND M.SKD_DIR_CD         = V.DIR_CD" ).append("\n"); 
		query.append("           AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = CW.COST_YR||CW.COST_WK" ).append("\n"); 
		query.append("           AND NVL(V.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("           AND M.SLS_OFC_CD         = O.OFC_CD" ).append("\n"); 
		query.append("           AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("           AND N2ND_PRNT_OFC_CD IN (" ).append("\n"); 
		query.append("									#foreach ($key in ${ilist})" ).append("\n"); 
		query.append("                 					  	#if($velocityCount < $ilist.size())" ).append("\n"); 
		query.append("                  						  '$key'," ).append("\n"); 
		query.append("                  					  	#else" ).append("\n"); 
		query.append("                  						  '$key'" ).append("\n"); 
		query.append("                    					#end" ).append("\n"); 
		query.append("									#end)" ).append("\n"); 
		query.append("           AND V.TRD_CD IN (" ).append("\n"); 
		query.append("							#foreach ($key in ${trdCdlist})" ).append("\n"); 
		query.append("                 			  	#if($velocityCount < $trdCdlist.size())" ).append("\n"); 
		query.append("                  				  '$key'," ).append("\n"); 
		query.append("                  				  	#else" ).append("\n"); 
		query.append("                  				  '$key'" ).append("\n"); 
		query.append("                    			#end" ).append("\n"); 
		query.append("							#end)" ).append("\n"); 
		query.append("           #if($subTrdCdlist.size() > 0)" ).append("\n"); 
		query.append("           AND V.SUB_TRD_CD IN (" ).append("\n"); 
		query.append("								#foreach ($key in ${subTrdCdlist})" ).append("\n"); 
		query.append("                 			  		#if($velocityCount < $subTrdCdlist.size())" ).append("\n"); 
		query.append("                  				  		'$key'," ).append("\n"); 
		query.append("                  				  	#else" ).append("\n"); 
		query.append("                  				 		'$key'" ).append("\n"); 
		query.append("                    				#end" ).append("\n"); 
		query.append("								#end)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if($boundList.size() > 0)" ).append("\n"); 
		query.append("       	   AND V.DIR_CD IN (" ).append("\n"); 
		query.append("							#foreach ($key in ${boundList})" ).append("\n"); 
		query.append("                 			  	#if($velocityCount < $boundList.size())" ).append("\n"); 
		query.append("                  				  '$key'," ).append("\n"); 
		query.append("                  				  	#else" ).append("\n"); 
		query.append("                  				  '$key'" ).append("\n"); 
		query.append("                    			#end" ).append("\n"); 
		query.append("							#end)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if($rlaneList.size() > 0)" ).append("\n"); 
		query.append("           AND V.RLANE_CD IN (" ).append("\n"); 
		query.append("								#foreach ($key in ${rlaneList})" ).append("\n"); 
		query.append("                 			  		#if($velocityCount < $rlaneList.size())" ).append("\n"); 
		query.append("                  				  		'$key'," ).append("\n"); 
		query.append("                  				  	#else" ).append("\n"); 
		query.append("                  				  		'$key'" ).append("\n"); 
		query.append("                    				#end" ).append("\n"); 
		query.append("								#end)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) T" ).append("\n"); 
		query.append("    WHERE T.TRD_CD   = C.TRD_CD(+)" ).append("\n"); 
		query.append("    AND T.RLANE_CD   = C.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND T.VSL_CD     = C.VSL_CD(+)" ).append("\n"); 
		query.append("    AND T.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND T.DIR_CD     = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND T.SLS_OFC_CD = C.SLS_RGN_OFC_CD(+)" ).append("\n"); 
		query.append("    AND T.POL_CD     = NVL(SUBSTR(C.POL_YD_CD, 1, 5), T.POL_CD)" ).append("\n"); 
		query.append("   -- 실제 SKED에 해당 PORT 들이 있는지 확인." ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'A' " ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                 WHERE S.VSL_CD      = T.VSL_CD" ).append("\n"); 
		query.append("                   AND S.SKD_VOY_NO  = T.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND S.SKD_DIR_CD  = T.DIR_CD" ).append("\n"); 
		query.append("                   AND NVL(S.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                   AND S.VPS_PORT_CD = T.POL_CD)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    GROUP BY T.TRD_CD, T.SUB_TRD_CD, T.RLANE_CD, T.VSL_CD, T.SKD_VOY_NO, T.DIR_CD, T.SLS_YRMON, T.COST_WK, T.SLS_OFC_CD, T.BSE_QTR_CD,T.BSE_YR" ).append("\n"); 
		query.append("    HAVING SUM(NVL(C.CFM_TTL_QTY, 0) + NVL(C.CFM_40FT_HC_QTY, 0) + NVL(C.CFM_45FT_HC_QTY, 0) + NVL(C.CFM_53FT_QTY, 0)) = 0" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("            -- QTA 존재" ).append("\n"); 
		query.append("            SELECT  'A'" ).append("\n"); 
		query.append("              FROM SQM_CFM_QTA      MQ ," ).append("\n"); 
		query.append("                   SQM_QTA_RLSE_VER MQR" ).append("\n"); 
		query.append("             WHERE MQR.BSE_YR          = T.BSE_YR" ).append("\n"); 
		query.append("               --AND MQR.BSE_QTR_CD      = CEIL(TO_NUMBER(DECODE(T.COST_WK,'00','01','53','52',T.COST_WK))/13)||'Q' --CEIL(TO_NUMBER( SUBSTR(T.SLS_YRMON, 5, 2))/3)||'Q'" ).append("\n"); 
		query.append("			   -- CHM-201534458 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("			   AND MQR.BSE_QTR_CD      = T.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND MQR.SQM_VER_STS_CD  = 'R' -- 컬럼 변경" ).append("\n"); 
		query.append("               AND MQR.BSE_TP_CD       = 'Q' -- 분기 20131205추가" ).append("\n"); 
		query.append("               AND MQ.QTA_RLSE_VER_NO  = MQR.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("               AND MQ.BSE_TP_CD        = MQR.BSE_TP_CD -- 분기 20131205추가  " ).append("\n"); 
		query.append("               AND MQ.BSE_YR           = MQR.BSE_YR" ).append("\n"); 
		query.append("               AND MQ.BSE_QTR_CD       = MQR.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND MQ.QTA_TGT_CD       = 'D'" ).append("\n"); 
		query.append("               AND MQ.OFC_VW_CD        = 'L'  -- 20131205추가" ).append("\n"); 
		query.append("               AND MQ.VSL_CD 		   = T.VSL_CD" ).append("\n"); 
		query.append("               AND MQ.SKD_VOY_NO       = T.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND MQ.DIR_CD           = T.DIR_CD" ).append("\n"); 
		query.append("               AND MQ.SKD_DIR_CD       = T.DIR_CD" ).append("\n"); 
		query.append("               AND MQ.TRD_CD           = T.TRD_CD" ).append("\n"); 
		query.append("               AND MQ.RLANE_CD         = T.RLANE_CD" ).append("\n"); 
		query.append("               AND T.SLS_OFC_CD        = (SELECT NVL(MAX(ROC.CONV_RGN_OFC_CD), MQ.RGN_OFC_CD)" ).append("\n"); 
		query.append("                                            FROM SPC_RGN_OFC_CONV ROC" ).append("\n"); 
		query.append("                                           WHERE ROC.SLS_RGN_OFC_CD = MQ.RGN_OFC_CD)" ).append("\n"); 
		query.append("               AND MQ.LOD_QTY          > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             -- 1-6주차, 동일 Lane, Bound에 QTA 존재" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT /*+ ORDERED USE_NL(CW V MQ MQR) INDEX(V XFN1MAS_MON_VVD) */ " ).append("\n"); 
		query.append("				    'A'" ).append("\n"); 
		query.append("               FROM CW2, " ).append("\n"); 
		query.append("                    MAS_MON_VVD V," ).append("\n"); 
		query.append("                    SQM_CFM_QTA      MQ ," ).append("\n"); 
		query.append("                    SQM_QTA_RLSE_VER MQR" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("              WHERE MQR.BSE_YR          = SUBSTR(V.COST_YRMON, 1, 4)" ).append("\n"); 
		query.append("                --AND MQR.BSE_QTR_CD      = CEIL(TO_NUMBER(DECODE(V.COST_WK,'00','01','53','52',V.COST_WK))/13)||'Q' --CEIL(TO_NUMBER( SUBSTR(V.SLS_YRMON, 5, 2))/3)||'Q'" ).append("\n"); 
		query.append("				-- CHM-201534458 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("				AND MQR.BSE_QTR_CD      = T.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND MQR.SQM_VER_STS_CD  = 'R' -- 컬럼 변경" ).append("\n"); 
		query.append("                AND MQR.BSE_TP_CD       = 'Q' -- 분기 20131205추가" ).append("\n"); 
		query.append("                AND MQ.QTA_RLSE_VER_NO  = MQR.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                AND MQ.BSE_TP_CD        = MQR.BSE_TP_CD -- 분기 20131205추가       " ).append("\n"); 
		query.append("                AND MQ.BSE_YR           = MQR.BSE_YR" ).append("\n"); 
		query.append("                AND MQ.BSE_QTR_CD       = MQR.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND MQ.QTA_TGT_CD       = 'D'" ).append("\n"); 
		query.append("                AND MQ.OFC_VW_CD        = 'L'  -- 20131205추가" ).append("\n"); 
		query.append("                AND V.TRD_CD            = T.TRD_CD" ).append("\n"); 
		query.append("                AND V.RLANE_CD          = T.RLANE_CD" ).append("\n"); 
		query.append("                AND V.DIR_CD            = T.DIR_CD" ).append("\n"); 
		query.append("                AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = CW2.COST_YR||CW2.COST_WK" ).append("\n"); 
		query.append("                AND NVL(V.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                AND MQ.VSL_CD           = V.VSL_CD" ).append("\n"); 
		query.append("                AND MQ.SKD_VOY_NO       = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND MQ.DIR_CD           = V.DIR_CD" ).append("\n"); 
		query.append("                AND MQ.SKD_DIR_CD       = V.DIR_CD" ).append("\n"); 
		query.append("                AND MQ.TRD_CD           = V.TRD_CD" ).append("\n"); 
		query.append("                AND MQ.RLANE_CD         = V.RLANE_CD" ).append("\n"); 
		query.append("                AND T.SLS_OFC_CD        = (SELECT NVL(MAX(ROC.CONV_RGN_OFC_CD), MQ.RGN_OFC_CD)" ).append("\n"); 
		query.append("                                             FROM SPC_RGN_OFC_CONV ROC" ).append("\n"); 
		query.append("                                            WHERE ROC.SLS_RGN_OFC_CD = MQ.RGN_OFC_CD)" ).append("\n"); 
		query.append("                AND MQ.LOD_QTY          > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             -- 1-6주차, 동일 Lane, Bound에 fcast 존재" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT /*+ ORDERED USE_NL(CW2 V C)  INDEX(V XFN1MAS_MON_VVD) */ " ).append("\n"); 
		query.append("                    'A'" ).append("\n"); 
		query.append("               FROM CW2, " ).append("\n"); 
		query.append("                    MAS_MON_VVD V," ).append("\n"); 
		query.append("                    SPC_DLY_FCAST_CUST C                    " ).append("\n"); 
		query.append("              WHERE V.TRD_CD             = T.TRD_CD" ).append("\n"); 
		query.append("                AND V.RLANE_CD           = T.RLANE_CD" ).append("\n"); 
		query.append("                AND V.DIR_CD             = T.DIR_CD" ).append("\n"); 
		query.append("                AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = CW2.COST_YR||CW2.COST_WK" ).append("\n"); 
		query.append("                AND NVL(V.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                AND C.VSL_CD             = V.VSL_CD" ).append("\n"); 
		query.append("                AND C.SKD_VOY_NO         = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND C.DIR_CD             = V.DIR_CD" ).append("\n"); 
		query.append("                AND C.SKD_DIR_CD         = V.DIR_CD" ).append("\n"); 
		query.append("                AND C.TRD_CD             = V.TRD_CD" ).append("\n"); 
		query.append("                AND C.RLANE_CD           = V.RLANE_CD" ).append("\n"); 
		query.append("                AND C.REP_TRD_CD         = SPC_GET_REP_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("                AND C.REP_SUB_TRD_CD     = SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("                AND T.SLS_OFC_CD         = C.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("              GROUP BY C.TRD_CD, C.RLANE_CD, C.VSL_CD, C.SKD_VOY_NO, C.DIR_CD, V.SLS_YRMON, V.COST_WK, C.SLS_OFC_CD" ).append("\n"); 
		query.append("             HAVING SUM(NVL(C.CFM_TTL_QTY, 0)) > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("ORDER BY SLS_OFC_CD, TRD_CD, RLANE_CD, SLS_YRMON, COST_WK" ).append("\n"); 

	}
}
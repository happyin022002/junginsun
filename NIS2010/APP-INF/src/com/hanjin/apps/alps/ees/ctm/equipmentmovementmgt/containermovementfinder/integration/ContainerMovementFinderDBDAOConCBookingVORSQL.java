/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOConCBookingVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOConCBookingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ticket No : CHM-201108835-01
	  * 개발자 : 나상보
	  * Title : bkg/mvmt vl/vd unmatch inquiry 화면 logic 추가
	  * Description :    1.Cancel된 mt bkg 조회되지 않도록 수정
	  * 
	  * 2012.11.07 문동선 [CHM-201221016] [CTM] BKG/MVMT VL unmatched 에서 Local/TS 확인기능 보완
	  * 2013.08.23 최덕우 [CHM-201325812] [CTM] Bkg/MVMT VL/VD Unmatch Inquiry기능 보완 (Restuffing, TTL, RHQ)
	  * 2014.03.10 박다은 [CHM-201428741] [CTM] Stowage Plan POD (BKG/MVMT VL/VD unmatch Inquiry)
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOConCBookingVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vls_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOConCBookingVORSQL").append("\n"); 
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
		query.append("#if (${flgrslt} == 'RL')" ).append("\n"); 
		query.append("	#if (${viewtype} == '1')" ).append("\n"); 
		query.append("    SELECT CNTR_NO, CNTR_TPSZ_CD, MAX(ORG_YD_CD) ORG_YD_CD, FULL_FG, MAX(MVMT_STS_CD) MVMT_STS_CD, MAX(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, C.ORG_YD_CD, DECODE (B.BKG_CGO_TP_CD, 'P', 'M', 'F' ) FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("              FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("             WHERE C.BKG_NO IN (" ).append("\n"); 
		query.append("                                SELECT BV.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("                                 WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("                                   AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("                                   AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("                                   AND BV.POL_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("                                   AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("                                   AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) <" ).append("\n"); 
		query.append("                                       ASCII (BV.VSL_PRE_PST_CD) * 10 + TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("		#if (${locl_type} != '')" ).append("\n"); 
		query.append("                                   AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("               AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("               AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("		#if (${cgo_type} != '')" ).append("\n"); 
		query.append("               AND DECODE(B.BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${restuff} == 'Y')" ).append("\n"); 
		query.append("				AND (C.BKG_NO, C.CNTR_NO) NOT IN (SELECT  CM.BKG_NO, CM.CNTR_NO" ).append("\n"); 
		query.append("													FROM    CTM_MVMT_XCH    CX," ).append("\n"); 
		query.append("															CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("													WHERE   XCH_CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("															AND     XCH_CNTR_YR = C.CNMV_YR" ).append("\n"); 
		query.append("															AND     CM.CNTR_NO  = XCH_CNTR_NO" ).append("\n"); 
		query.append("                                                            AND     CM.CNMV_YR  = XCH_CNTR_YR" ).append("\n"); 
		query.append("                                                            AND     CM.CNMV_ID_NO = XCH_CNMV_ID_NO" ).append("\n"); 
		query.append("                                                            AND     ROWNUM = 1" ).append("\n"); 
		query.append("												)															" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${ttl} == 'Y')" ).append("\n"); 
		query.append("     			 AND ('TLL', SUBSTR(@[p_yard], 1, 5)) <> (SELECT CNTR_STS_CD, LOC_CD FROM MST_CONTAINER" ).append("\n"); 
		query.append("								WHERE CNTR_NO = C.CNTR_NO)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    GROUP BY CNTR_NO, CNTR_TPSZ_CD, FULL_FG" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${mv_type} == '')" ).append("\n"); 
		query.append("    SELECT DISTINCT A.CNTR_NO, A.CNTR_TPSZ_CD, A.FULL_FG, A.ORG_YD_CD, A.MVMT_STS_CD, A.MVMT_INP_TP_CD, A.BKG_NO" ).append("\n"); 
		query.append("      FROM (SELECT DISTINCT CNTR_NO, CNTR_TPSZ_CD, CTM.ORG_YD_CD, DECODE(BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, MVMT_STS_CD, MVMT_INP_TP_CD, BKG_NO" ).append("\n"); 
		query.append("              FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("             WHERE CRNT_VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("               AND CRNT_SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("               AND CRNT_SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("               AND ORG_YD_CD       LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			#if (${cgo_type} != '')" ).append("\n"); 
		query.append("               AND DECODE(BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("               AND MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("			#if (${restuff} == 'Y')" ).append("\n"); 
		query.append("				AND (CTM.BKG_NO, CTM.CNTR_NO) NOT IN (SELECT  CM.BKG_NO, CM.CNTR_NO" ).append("\n"); 
		query.append("														FROM    CTM_MVMT_XCH    CX," ).append("\n"); 
		query.append("																CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("														WHERE   XCH_CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("															AND     XCH_CNTR_YR = CTM.CNMV_YR" ).append("\n"); 
		query.append("															AND     CM.CNTR_NO  = XCH_CNTR_NO" ).append("\n"); 
		query.append("															AND     CM.CNMV_YR  = XCH_CNTR_YR" ).append("\n"); 
		query.append("															AND     CM.CNMV_ID_NO = XCH_CNMV_ID_NO" ).append("\n"); 
		query.append("															AND     ROWNUM = 1" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("           ) A," ).append("\n"); 
		query.append("           (SELECT BV.BKG_NO" ).append("\n"); 
		query.append("              FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("             WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("               AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("               AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("               AND BV.POL_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("               AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("               AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) <" ).append("\n"); 
		query.append("                   ASCII (BV.VSL_PRE_PST_CD) * 10 + TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("			#if (${locl_type} != '')" ).append("\n"); 
		query.append("               AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("           ) B" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("     ORDER BY CNTR_NO" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			SELECT DISTINCT CNTR_REF_NO CNTR_NO, CNTR_TPSZ_CD CNTR_TPSZ_CD, '' ORG_YD_CD, DECODE(FULL_MTY_CD, 'E', 'M', 'F') FULL_FG, 'VL' MVMT_STS_CD, '' BKG_NO" ).append("\n"); 
		query.append("			  FROM OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("			 WHERE VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			   AND SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			   AND SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			   AND POL_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			   AND LODG_DCHG_IND_CD = 'L'" ).append("\n"); 
		query.append("               AND CRR_CD = 'SML'" ).append("\n"); 
		query.append("			#if (${cgo_type} != '')" ).append("\n"); 
		query.append("               AND DECODE(FULL_MTY_CD, 'E', 'P', 'M', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          ORDER BY CNTR_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${flgrslt} == 'PD')" ).append("\n"); 
		query.append("	#if (${viewtype} == '1')" ).append("\n"); 
		query.append("    SELECT CNTR_NO, CNTR_TPSZ_CD, FULL_FG, MAX(ORG_YD_CD) ORG_YD_CD, MAX(MVMT_STS_CD) MVMT_STS_CD, MAX(BKG_NO) BKG_NO, substr(CNTR_NO||MAX(ORG_YD_CD),1,16) MAT_POD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, C.ORG_YD_CD, DECODE(B.BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("		FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("		WHERE C.BKG_NO IN (" ).append("\n"); 
		query.append("			SELECT BV.BKG_NO" ).append("\n"); 
		query.append("			    FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("			    WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			    AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			    AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			    AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			    AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("			    AND	ASCII(BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER(BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("					ASCII(BV.VSL_PRE_PST_CD) * 10 + TO_NUMBER(BV.VSL_SEQ)" ).append("\n"); 
		query.append("				#if (${locl_type} != '')" ).append("\n"); 
		query.append("			     AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("		AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		#if (${cgo_type} != '')" ).append("\n"); 
		query.append(" 	    AND DECODE(B.BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("		AND B.POD_CD <> 'XXXXX'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${restuff} == 'Y')" ).append("\n"); 
		query.append("				AND (C.BKG_NO, C.CNTR_NO) NOT IN (SELECT  CM.BKG_NO, CM.CNTR_NO" ).append("\n"); 
		query.append("													FROM    CTM_MVMT_XCH    CX," ).append("\n"); 
		query.append("															CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("													WHERE   XCH_CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("															AND     XCH_CNTR_YR = C.CNMV_YR" ).append("\n"); 
		query.append("															AND     CM.CNTR_NO  = XCH_CNTR_NO" ).append("\n"); 
		query.append("                                                            AND     CM.CNMV_YR  = XCH_CNTR_YR" ).append("\n"); 
		query.append("                                                            AND     CM.CNMV_ID_NO = XCH_CNMV_ID_NO" ).append("\n"); 
		query.append("                                                            AND     ROWNUM = 1" ).append("\n"); 
		query.append("												)															" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${ttl} == 'Y')" ).append("\n"); 
		query.append("				AND	(" ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							('TLL', SUBSTR(@[p_yard], 1, 5)) IN (SELECT CNTR_STS_CD, LOC_CD FROM MST_CONTAINER MC	" ).append("\n"); 
		query.append("																	WHERE MC.CNTR_NO = C.CNTR_NO )	" ).append("\n"); 
		query.append("							AND EXISTS(SELECT CM.CNTR_NO" ).append("\n"); 
		query.append("										FROM BKG_VVD BV, CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("										WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("											AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("											AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("											AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("											AND BV.VSL_CD = CM.CRNT_VSL_CD" ).append("\n"); 
		query.append("											AND BV.SKD_VOY_NO = CM.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("											AND BV.SKD_DIR_CD = CM.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("											AND BV.POD_CD = SUBSTR(CM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("											AND CM.MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("											AND CM.cntr_no = C.CNTR_NO" ).append("\n"); 
		query.append("											AND C.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						( C.CNTR_NO IN (SELECT MC.CNTR_NO FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("											WHERE MC.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("												AND CNTR_STS_CD <> 'TLL'" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY CNTR_NO, CNTR_TPSZ_CD, FULL_FG" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${mv_type} == '')" ).append("\n"); 
		query.append("		SELECT DISTINCT A.CNTR_NO, A.CNTR_TPSZ_CD, A.FULL_FG, A.ORG_YD_CD, A.MVMT_STS_CD, A.MVMT_INP_TP_CD BKG_NO" ).append("\n"); 
		query.append("		  FROM (SELECT CNTR_NO, CNTR_TPSZ_CD, ORG_YD_CD," ).append("\n"); 
		query.append("			           DECODE (BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, MVMT_STS_CD," ).append("\n"); 
		query.append("			           MVMT_INP_TP_CD, BKG_NO" ).append("\n"); 
		query.append(" 			      FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("			     WHERE CRNT_VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			       AND CRNT_SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			       AND CRNT_SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			#if (${cgo_type} != '')" ).append("\n"); 
		query.append(" 		   	       AND DECODE(BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			       AND MVMT_STS_CD NOT IN ('VD', 'IC', 'TS', 'MT')			" ).append("\n"); 
		query.append("			#if (${restuff} == 'Y')" ).append("\n"); 
		query.append("				AND (CTM.BKG_NO, CTM.CNTR_NO) NOT IN (SELECT  CM.BKG_NO, CM.CNTR_NO" ).append("\n"); 
		query.append("														FROM    CTM_MVMT_XCH    CX," ).append("\n"); 
		query.append("																CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("														WHERE   XCH_CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("															AND     XCH_CNTR_YR = CTM.CNMV_YR" ).append("\n"); 
		query.append("															AND     CM.CNTR_NO  = XCH_CNTR_NO" ).append("\n"); 
		query.append("															AND     CM.CNMV_YR  = XCH_CNTR_YR" ).append("\n"); 
		query.append("															AND     CM.CNMV_ID_NO = XCH_CNMV_ID_NO" ).append("\n"); 
		query.append("															AND     ROWNUM = 1" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("				) A," ).append("\n"); 
		query.append("		       (SELECT BV.BKG_NO" ).append("\n"); 
		query.append("			      FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("			     WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			       AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			       AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			       AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			       AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("			       AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("					   ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("					   + TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("				#if (${locl_type} != '')" ).append("\n"); 
		query.append("			       AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				) B" ).append("\n"); 
		query.append("		 WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("         ORDER BY CNTR_NO" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("SELECT DISTINCT SKD_VOY_NO,CNTR_REF_NO CNTR_NO, CNTR_TPSZ_CD CNTR_TPSZ_CD, '' ORG_YD_CD, POD_CD, DECODE(FULL_MTY_CD, 'E', 'M', 'F') FULL_FG, 'VD' MVMT_STS_CD, '' BKG_NO, CNTR_REF_NO||POD_CD MAT_POD" ).append("\n"); 
		query.append("       FROM OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("    WHERE VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("      AND POD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("      AND LODG_DCHG_IND_CD = 'L'" ).append("\n"); 
		query.append("         AND CRR_CD = 'SML'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT SKD_VOY_NO,CNTR_REF_NO CNTR_NO, CNTR_TPSZ_CD CNTR_TPSZ_CD, '' ORG_YD_CD, POD_CD, DECODE(FULL_MTY_CD, 'E', 'M', 'F') FULL_FG, 'VD' MVMT_STS_CD, '' BKG_NO, CNTR_REF_NO||POD_CD MAT_POD" ).append("\n"); 
		query.append("       FROM OPF_BAY_PLN_LDIS    OPFB," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("SELECT A.CNTR_NO" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT CNTR_NO, CNTR_TPSZ_CD, FULL_FG, MAX(ORG_YD_CD) ORG_YD_CD, MAX(MVMT_STS_CD) MVMT_STS_CD, MAX(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("  SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, C.ORG_YD_CD, DECODE(B.BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("  WHERE C.BKG_NO IN (" ).append("\n"); 
		query.append("   SELECT BV.BKG_NO" ).append("\n"); 
		query.append("       FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("       WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("       AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("       AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("#if(${spln_pod} == 'All')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("       AND ASCII(BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER(BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("     ASCII(BV.VSL_PRE_PST_CD) * 10 + TO_NUMBER(BV.VSL_SEQ)" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("  AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("  AND B.POD_CD <> 'XXXXX'" ).append("\n"); 
		query.append("      AND (C.BKG_NO, C.CNTR_NO) NOT IN (SELECT  CM.BKG_NO, CM.CNTR_NO" ).append("\n"); 
		query.append("             FROM    CTM_MVMT_XCH    CX," ).append("\n"); 
		query.append("               CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("             WHERE   XCH_CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("               AND     XCH_CNTR_YR = C.CNMV_YR" ).append("\n"); 
		query.append("               AND     CM.CNTR_NO  = XCH_CNTR_NO" ).append("\n"); 
		query.append("                                                            AND     CM.CNMV_YR  = XCH_CNTR_YR" ).append("\n"); 
		query.append("                                                            AND     CM.CNMV_ID_NO = XCH_CNMV_ID_NO" ).append("\n"); 
		query.append("                                                            AND     ROWNUM = 1" ).append("\n"); 
		query.append("            )               " ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       ('TLL', SUBSTR(@[p_yard], 1, 5)) IN (SELECT CNTR_STS_CD, LOC_CD FROM MST_CONTAINER MC " ).append("\n"); 
		query.append("                 WHERE MC.CNTR_NO = C.CNTR_NO ) " ).append("\n"); 
		query.append("       AND EXISTS(SELECT CM.CNTR_NO" ).append("\n"); 
		query.append("          FROM BKG_VVD BV, CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("          WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("           AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("           AND BV.VSL_CD = CM.CRNT_VSL_CD" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO = CM.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD = CM.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BV.POD_CD = SUBSTR(CM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("           AND CM.MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("           AND CM.cntr_no = C.CNTR_NO" ).append("\n"); 
		query.append("           AND C.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      OR" ).append("\n"); 
		query.append("      ( C.CNTR_NO IN (SELECT MC.CNTR_NO FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("           WHERE MC.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("            AND CNTR_STS_CD <> 'TLL'" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    GROUP BY CNTR_NO, CNTR_TPSZ_CD, FULL_FG" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO" ).append("\n"); 
		query.append(" ) A" ).append("\n"); 
		query.append(" MINUS" ).append("\n"); 
		query.append(" SELECT B.CNTR_NO" ).append("\n"); 
		query.append(" FROM   (SELECT DISTINCT SKD_VOY_NO,CNTR_REF_NO CNTR_NO, CNTR_TPSZ_CD CNTR_TPSZ_CD, '' ORG_YD_CD, POD_CD, DECODE(FULL_MTY_CD, 'E', 'M', 'F') FULL_FG, 'VD' MVMT_STS_CD, '' BKG_NO" ).append("\n"); 
		query.append("       FROM OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("    WHERE VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("      AND POD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("      AND LODG_DCHG_IND_CD = 'L'" ).append("\n"); 
		query.append("               AND CRR_CD = 'SML') B" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("    WHERE VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("      AND LODG_DCHG_IND_CD = 'L'" ).append("\n"); 
		query.append("         AND CRR_CD = 'SML'" ).append("\n"); 
		query.append("         AND OPFB.CNTR_REF_NO = C.CNTR_NO" ).append("\n"); 
		query.append("   			#if (${cgo_type} != '')" ).append("\n"); 
		query.append("               AND DECODE(FULL_MTY_CD,'E', 'P', 'M', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("             ORDER BY CNTR_NO" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${flgrslt} == 'RD')" ).append("\n"); 
		query.append("	#if (${viewtype} == '1')" ).append("\n"); 
		query.append("    SELECT CNTR_NO, CNTR_TPSZ_CD, FULL_FG, MAX(ORG_YD_CD) ORG_YD_CD, MAX(MVMT_STS_CD) MVMT_STS_CD, MAX(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, C.ORG_YD_CD, DECODE(B.BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("		FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("		WHERE C.BKG_NO IN (" ).append("\n"); 
		query.append("		SELECT BV.BKG_NO" ).append("\n"); 
		query.append("			    FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("			    WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			    AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			    AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			    AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			    AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("			    AND	ASCII(BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER(BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("					ASCII(BV.VSL_PRE_PST_CD) * 10 + TO_NUMBER(BV.VSL_SEQ)" ).append("\n"); 
		query.append("				#if (${locl_type} != '')" ).append("\n"); 
		query.append("			     AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		#if (${cgo_type} != '')" ).append("\n"); 
		query.append("   	    AND DECODE(B.BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("		AND B.POD_CD <> 'XXXXX'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${restuff} == 'Y')" ).append("\n"); 
		query.append("				AND (C.BKG_NO, C.CNTR_NO) NOT IN (SELECT  CM.BKG_NO, CM.CNTR_NO" ).append("\n"); 
		query.append("													FROM    CTM_MVMT_XCH    CX," ).append("\n"); 
		query.append("															CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("													WHERE   XCH_CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("															AND     XCH_CNTR_YR = C.CNMV_YR" ).append("\n"); 
		query.append("															AND     CM.CNTR_NO  = XCH_CNTR_NO" ).append("\n"); 
		query.append("                                                            AND     CM.CNMV_YR  = XCH_CNTR_YR" ).append("\n"); 
		query.append("                                                            AND     CM.CNMV_ID_NO = XCH_CNMV_ID_NO" ).append("\n"); 
		query.append("                                                            AND     ROWNUM = 1" ).append("\n"); 
		query.append("												)															" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${ttl} == 'Y')" ).append("\n"); 
		query.append("				AND	(" ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							('TLL', SUBSTR(@[p_yard], 1, 5)) IN (SELECT CNTR_STS_CD, LOC_CD FROM MST_CONTAINER MC	" ).append("\n"); 
		query.append("																	WHERE MC.CNTR_NO = C.CNTR_NO )	" ).append("\n"); 
		query.append("							AND EXISTS(SELECT CM.CNTR_NO" ).append("\n"); 
		query.append("										FROM BKG_VVD BV, CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("										WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("											AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("											AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("											AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("											AND BV.VSL_CD = CM.CRNT_VSL_CD" ).append("\n"); 
		query.append("											AND BV.SKD_VOY_NO = CM.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("											AND BV.SKD_DIR_CD = CM.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("											AND BV.POD_CD = SUBSTR(CM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("											AND CM.MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("											AND CM.cntr_no = C.CNTR_NO" ).append("\n"); 
		query.append("											AND C.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						( C.CNTR_NO IN (SELECT MC.CNTR_NO FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("											WHERE MC.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("												AND CNTR_STS_CD <> 'TLL'" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY CNTR_NO, CNTR_TPSZ_CD, FULL_FG" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		SELECT DISTINCT A.CNTR_NO, A.CNTR_TPSZ_CD, A.ORG_YD_CD, A.FULL_FG, A.MVMT_STS_CD, A.MVMT_INP_TP_CD BKG_NO" ).append("\n"); 
		query.append("		  FROM (SELECT CNTR_NO, CNTR_TPSZ_CD, ORG_YD_CD," ).append("\n"); 
		query.append("			       DECODE (BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, MVMT_STS_CD," ).append("\n"); 
		query.append("			       MVMT_INP_TP_CD, BKG_NO" ).append("\n"); 
		query.append("			  FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("			 WHERE CRNT_VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			   AND CRNT_SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			   AND CRNT_SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			   AND ORG_YD_CD       LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("		#if (${cgo_type} != '')" ).append("\n"); 
		query.append(" 		   	   AND DECODE(BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("			   AND MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("		#if (${restuff} == 'Y')" ).append("\n"); 
		query.append("				AND (CTM.BKG_NO, CTM.CNTR_NO) NOT IN (SELECT  CM.BKG_NO, CM.CNTR_NO" ).append("\n"); 
		query.append("														FROM    CTM_MVMT_XCH    CX," ).append("\n"); 
		query.append("																CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("														WHERE   XCH_CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("															AND     XCH_CNTR_YR = CTM.CNMV_YR" ).append("\n"); 
		query.append("															AND     CM.CNTR_NO  = XCH_CNTR_NO" ).append("\n"); 
		query.append("															AND     CM.CNMV_YR  = XCH_CNTR_YR" ).append("\n"); 
		query.append("															AND     CM.CNMV_ID_NO = XCH_CNMV_ID_NO" ).append("\n"); 
		query.append("															AND     ROWNUM = 1" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("			) A," ).append("\n"); 
		query.append("		       (SELECT BV.BKG_NO" ).append("\n"); 
		query.append("			  FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("			 WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			   AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			   AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			   AND BV.POD_CD = SUBSTR(@[p_yard], 0,5)" ).append("\n"); 
		query.append("			   AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("			   AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("				   ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("					+ TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("				#if (${locl_type} != '')" ).append("\n"); 
		query.append("			     AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				) B" ).append("\n"); 
		query.append("		 WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("         ORDER BY CNTR_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
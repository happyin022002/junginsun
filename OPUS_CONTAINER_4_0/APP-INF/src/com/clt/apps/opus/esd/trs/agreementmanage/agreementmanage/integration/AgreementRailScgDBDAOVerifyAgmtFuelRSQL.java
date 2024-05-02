/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AgreementRailScgDBDAOVerifyAgmtFuelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.09
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2017.01.09 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRailScgDBDAOVerifyAgmtFuelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fuel Type AgreementFileImport 의 Verify 수행
	  * </pre>
	  */
	public AgreementRailScgDBDAOVerifyAgmtFuelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmtRailTmpSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAOVerifyAgmtFuelRSQL").append("\n"); 
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
		query.append("	SUBSTR(" ).append("\n"); 
		query.append("		-- Agreement No 체크" ).append("\n"); 
		query.append("		CASE WHEN" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT 1" ).append("\n"); 
		query.append("			  FROM TRS_AGMT_HDR H," ).append("\n"); 
		query.append("				   TRS_AGMT_APLY_VNDR V" ).append("\n"); 
		query.append("			 WHERE H.TRSP_AGMT_OFC_CTY_CD = T.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("			   AND H.TRSP_AGMT_SEQ = T.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("			   AND V.TRSP_AGMT_OFC_CTY_CD = T.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("			   AND V.TRSP_AGMT_SEQ = T.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("			   AND V.VNDR_SEQ = T.VNDR_SEQ" ).append("\n"); 
		query.append("			   AND V.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("			   AND ROWNUM = 1" ).append("\n"); 
		query.append("		) IS NULL THEN ',AGMT NO ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		|| -- All Node Check" ).append("\n"); 
		query.append("		CASE WHEN T.AGMT_ROUT_ALL_FLG = 'N'" ).append("\n"); 
		query.append("			      AND T.FM_NOD_CD IS NULL" ).append("\n"); 
		query.append("			      AND T.TO_NOD_CD IS NULL" ).append("\n"); 
		query.append("		     THEN ',ROUTE ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		|| -- From Node Check" ).append("\n"); 
		query.append("		CASE WHEN T.FM_NOD_CD <> '00'" ).append("\n"); 
		query.append("              AND LENGTH(T.FM_NOD_CD) = 5 -- Location validation" ).append("\n"); 
		query.append("			  AND (" ).append("\n"); 
		query.append("				   SELECT 1" ).append("\n"); 
		query.append("				     FROM MDM_YARD M" ).append("\n"); 
		query.append("				    WHERE M.YD_CD LIKE (T.FM_NOD_CD||'%')" ).append("\n"); 
		query.append("					  AND T.FM_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("					  AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("					  AND ROWNUM = 1" ).append("\n"); 
		query.append("				   ) IS NULL THEN ',ROUTE ERR'" ).append("\n"); 
		query.append("             WHEN T.FM_NOD_CD <> '00'" ).append("\n"); 
		query.append("              AND LENGTH(T.FM_NOD_CD) <> 5 -- Node validation" ).append("\n"); 
		query.append("			  AND (" ).append("\n"); 
		query.append("				   SELECT 1" ).append("\n"); 
		query.append("				     FROM MDM_YARD M" ).append("\n"); 
		query.append("				    WHERE M.YD_CD = T.FM_NOD_CD" ).append("\n"); 
		query.append("					  AND T.FM_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("					  AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("					  AND ROWNUM = 1" ).append("\n"); 
		query.append("				   ) IS NULL THEN ',ROUTE ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		|| -- To Node Check" ).append("\n"); 
		query.append("		CASE WHEN T.TO_NOD_CD <> '00'" ).append("\n"); 
		query.append("              AND LENGTH(T.TO_NOD_CD) = 5 -- Location validation" ).append("\n"); 
		query.append("			  AND (" ).append("\n"); 
		query.append("				   SELECT 1" ).append("\n"); 
		query.append("				     FROM MDM_YARD M" ).append("\n"); 
		query.append("				    WHERE M.YD_CD LIKE (T.TO_NOD_CD||'%')" ).append("\n"); 
		query.append("					  AND T.TO_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("					  AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("					  AND ROWNUM = 1" ).append("\n"); 
		query.append("				   ) IS NULL THEN ',ROUTE ERR'" ).append("\n"); 
		query.append("             WHEN T.TO_NOD_CD <> '00'" ).append("\n"); 
		query.append("              AND LENGTH(T.TO_NOD_CD) <> 5 -- Node validation" ).append("\n"); 
		query.append("			  AND (" ).append("\n"); 
		query.append("				   SELECT 1" ).append("\n"); 
		query.append("				     FROM MDM_YARD M" ).append("\n"); 
		query.append("				    WHERE M.YD_CD = T.TO_NOD_CD" ).append("\n"); 
		query.append("					  AND T.TO_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("					  AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("					  AND ROWNUM = 1" ).append("\n"); 
		query.append("				   ) IS NULL THEN ',ROUTE ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		||-- Cargo Type 체크" ).append("\n"); 
		query.append("		CASE WHEN T.CGO_TP_CD IS NULL" ).append("\n"); 
		query.append("		THEN ',CARGO TYPE ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		||-- Ratio 체크" ).append("\n"); 
		query.append("		CASE WHEN T.TRSP_RAIL_RTO IS NULL" ).append("\n"); 
		query.append("		THEN ',RATIO ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		||-- Effective date 체크" ).append("\n"); 
		query.append("		CASE WHEN T.EFF_TO_DT IS NULL" ).append("\n"); 
		query.append("			OR T.EFF_FM_DT IS NULL" ).append("\n"); 
		query.append("			OR T.EFF_TO_DT - T.EFF_FM_DT < 0" ).append("\n"); 
		query.append("		THEN ',EFFECTIVE DATE ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		||-- All 항목 체크" ).append("\n"); 
		query.append("		CASE WHEN T.AGMT_ROUT_ALL_FLG = 'Y'" ).append("\n"); 
		query.append("			AND (T.FM_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("			AND T.FM_NOD_CD <>'00')" ).append("\n"); 
		query.append("			AND (T.TO_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("			AND T.TO_NOD_CD <> '00')" ).append("\n"); 
		query.append("		THEN ',ALL CHECK'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		||-- UI Dup 항목 체크" ).append("\n"); 
		query.append("		CASE WHEN " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append(" 	   		SELECT (" ).append("\n"); 
		query.append(" 	       			SELECT 1" ).append("\n"); 
		query.append("           			FROM  TRS_AGMT_RAIL_SCG_RT_TMP U" ).append("\n"); 
		query.append("        			WHERE U.AGMT_RAIL_TMP_SEQ = O.AGMT_RAIL_TMP_SEQ" ).append("\n"); 
		query.append("        			AND   NVL(U.VNDR_SEQ, 0) = NVL(O.VNDR_SEQ, 0)" ).append("\n"); 
		query.append("        			AND   U.TRSP_RAIL_SCG_CD = O.TRSP_RAIL_SCG_CD" ).append("\n"); 
		query.append("        			AND   U.TRSP_AGMT_OFC_CTY_CD = O.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        			AND   U.TRSP_AGMT_SEQ = O.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("--        			AND   U.AGMT_ROUT_ALL_FLG = O.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("                    AND   NVL(U.SPCL_CGO_CNTR_TP_CD, 'N') = NVL(O.SPCL_CGO_CNTR_TP_CD, 'N')" ).append("\n"); 
		query.append("        			AND   NVL(U.FM_NOD_CD, 'N/A') = NVL(O.FM_NOD_CD, 'N/A')" ).append("\n"); 
		query.append("        			AND   NVL(U.TO_NOD_CD, 'N/A') = NVL(O.TO_NOD_CD, 'N/A')" ).append("\n"); 
		query.append("        			AND   NVL(U.CGO_TP_CD, 'N/A') = NVL(O.CGO_TP_CD, 'N/A')" ).append("\n"); 
		query.append("        			AND   U.TRSP_RAIL_RTO = O.TRSP_RAIL_RTO" ).append("\n"); 
		query.append("        			AND   NVL(TO_CHAR(U.EFF_FM_DT, 'YYYYMMDD'), 'N/A') = NVL(TO_CHAR(O.EFF_FM_DT, 'YYYYMMDD'), 'N/A')" ).append("\n"); 
		query.append("					AND   NVL(TO_CHAR(U.EFF_TO_DT, 'YYYYMMDD'), 'N/A') = NVL(TO_CHAR(O.EFF_TO_DT, 'YYYYMMDD'), 'N/A')" ).append("\n"); 
		query.append("        			AND   NVL(U.RAIL_RTO_NO, 0) = NVL(O.RAIL_RTO_NO, 0)" ).append("\n"); 
		query.append("        			AND   NVL(U.LBS_OVR_WGT, 0) = NVL(O.LBS_OVR_WGT, 0)" ).append("\n"); 
		query.append("        			AND   NVL(U.CURR_CD, 'N/A') = NVL(O.CURR_CD, 'N/A')" ).append("\n"); 
		query.append("        			AND   NVL(U.FX_SCG_ALL_RT, 0.00001) = NVL(O.FX_SCG_ALL_RT, 0.00001)" ).append("\n"); 
		query.append("        			AND   NVL(U.FX_SCG_20FT_RT, 0.00001) = NVL(O.FX_SCG_20FT_RT, 0.00001)" ).append("\n"); 
		query.append("        			AND   NVL(U.FX_SCG_40FT_RT, 0.00001) = NVL(O.FX_SCG_40FT_RT, 0.00001)" ).append("\n"); 
		query.append("        			AND   NVL(U.FX_SCG_45FT_RT, 0.00001) = NVL(O.FX_SCG_45FT_RT, 0.00001)" ).append("\n"); 
		query.append("        			AND   NVL(U.FUEL_SCG_APLY_FLG, 'N/A') = NVL(O.FUEL_SCG_APLY_FLG, 'N/A')" ).append("\n"); 
		query.append("        			AND   NVL(U.DELT_FLG, 'N/A') = NVL(O.DELT_FLG, 'N/A')" ).append("\n"); 
		query.append("                    AND   NVL(U.USR_DEF_RMK, 'X') = NVL(O.USR_DEF_RMK, 'X')" ).append("\n"); 
		query.append("        			AND   U.ROW_NO <> O.ROW_NO" ).append("\n"); 
		query.append("        			AND   ROWNUM = 1" ).append("\n"); 
		query.append("    			) AS RESULT" ).append("\n"); 
		query.append("    		FROM TRS_AGMT_RAIL_SCG_RT_TMP O" ).append("\n"); 
		query.append("    		WHERE O.AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("    		AND O.ROW_NO       = T.ROW_NO" ).append("\n"); 
		query.append("		) IS NOT NULL" ).append("\n"); 
		query.append("		THEN" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append(" 	   		SELECT (" ).append("\n"); 
		query.append(" 	       		SELECT ',UI ERROR'||' Line '||U.ROW_NO" ).append("\n"); 
		query.append("          	 	FROM   TRS_AGMT_RAIL_SCG_RT_TMP U" ).append("\n"); 
		query.append("        		WHERE U.AGMT_RAIL_TMP_SEQ = O.AGMT_RAIL_TMP_SEQ" ).append("\n"); 
		query.append("        		AND   NVL(U.VNDR_SEQ, 0) = NVL(O.VNDR_SEQ, 0)" ).append("\n"); 
		query.append("        		AND   U.TRSP_RAIL_SCG_CD = O.TRSP_RAIL_SCG_CD" ).append("\n"); 
		query.append("        		AND   U.TRSP_AGMT_OFC_CTY_CD = O.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        		AND   U.TRSP_AGMT_SEQ = O.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("--        		AND   U.AGMT_ROUT_ALL_FLG = O.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("                AND   NVL(U.SPCL_CGO_CNTR_TP_CD, 'N') = NVL(O.SPCL_CGO_CNTR_TP_CD, 'N')" ).append("\n"); 
		query.append("        		AND   NVL(U.FM_NOD_CD, 'N/A') = NVL(O.FM_NOD_CD, 'N/A')" ).append("\n"); 
		query.append("        		AND   NVL(U.TO_NOD_CD, 'N/A') = NVL(O.TO_NOD_CD, 'N/A')" ).append("\n"); 
		query.append("        		AND   NVL(U.CGO_TP_CD, 'N/A') = NVL(O.CGO_TP_CD, 'N/A')" ).append("\n"); 
		query.append("        		AND   U.TRSP_RAIL_RTO = O.TRSP_RAIL_RTO" ).append("\n"); 
		query.append("        		AND   NVL(TO_CHAR(U.EFF_FM_DT, 'YYYYMMDD'), 'N/A') = NVL(TO_CHAR(O.EFF_FM_DT, 'YYYYMMDD'), 'N/A')" ).append("\n"); 
		query.append("				AND   NVL(TO_CHAR(U.EFF_TO_DT, 'YYYYMMDD'), 'N/A') = NVL(TO_CHAR(O.EFF_TO_DT, 'YYYYMMDD'), 'N/A')" ).append("\n"); 
		query.append("        		AND   NVL(U.RAIL_RTO_NO, 0) = NVL(O.RAIL_RTO_NO, 0)" ).append("\n"); 
		query.append("        		AND   NVL(U.LBS_OVR_WGT, 0) = NVL(O.LBS_OVR_WGT, 0)" ).append("\n"); 
		query.append("        		AND   NVL(U.CURR_CD, 'N/A') = NVL(O.CURR_CD, 'N/A')" ).append("\n"); 
		query.append("        		AND   NVL(U.FX_SCG_ALL_RT, 0.00001) = NVL(O.FX_SCG_ALL_RT, 0.00001)" ).append("\n"); 
		query.append("        		AND   NVL(U.FX_SCG_20FT_RT, 0.00001) = NVL(O.FX_SCG_20FT_RT, 0.00001)" ).append("\n"); 
		query.append("        		AND   NVL(U.FX_SCG_40FT_RT, 0.00001) = NVL(O.FX_SCG_40FT_RT, 0.00001)" ).append("\n"); 
		query.append("        		AND   NVL(U.FX_SCG_45FT_RT, 0.00001) = NVL(O.FX_SCG_45FT_RT, 0.00001)" ).append("\n"); 
		query.append("        		AND   NVL(U.FUEL_SCG_APLY_FLG, 'N/A') = NVL(O.FUEL_SCG_APLY_FLG, 'N/A')" ).append("\n"); 
		query.append("        		AND   NVL(U.DELT_FLG, 'N/A') = NVL(O.DELT_FLG, 'N/A')" ).append("\n"); 
		query.append("                AND   NVL(U.USR_DEF_RMK, 'X') = NVL(O.USR_DEF_RMK, 'X')" ).append("\n"); 
		query.append("        		AND   U.ROW_NO <> O.ROW_NO" ).append("\n"); 
		query.append("        		AND   ROWNUM = 1" ).append("\n"); 
		query.append("    		) AS RESULT" ).append("\n"); 
		query.append("    		FROM TRS_AGMT_RAIL_SCG_RT_TMP O" ).append("\n"); 
		query.append("    		WHERE O.AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("    		AND O.ROW_NO       = T.ROW_NO" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("	,2) AS RMK,	" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("   		SELECT 'DUP'" ).append("\n"); 
		query.append("   	 	FROM TRS_AGMT_RAIL_SCG_RT U" ).append("\n"); 
		query.append("   		WHERE 1 = 1" ).append("\n"); 
		query.append("   		AND   NVL(U.VNDR_SEQ, 0) = NVL(T.VNDR_SEQ, 0)" ).append("\n"); 
		query.append("   		AND   U.TRSP_RAIL_SCG_CD = T.TRSP_RAIL_SCG_CD" ).append("\n"); 
		query.append("   		AND   U.TRSP_AGMT_OFC_CTY_CD = T.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   		AND   U.TRSP_AGMT_SEQ = T.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("--   		AND   U.AGMT_ROUT_ALL_FLG = T.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("        AND   NVL(U.SPCL_CGO_CNTR_TP_CD, 'N') = NVL(T.SPCL_CGO_CNTR_TP_CD, 'N')" ).append("\n"); 
		query.append("   		AND   NVL(U.FM_NOD_CD, 'N/A') = NVL(T.FM_NOD_CD, 'N/A')" ).append("\n"); 
		query.append("   		AND   NVL(U.TO_NOD_CD, 'N/A') = NVL(T.TO_NOD_CD, 'N/A')" ).append("\n"); 
		query.append("   		AND   NVL(U.CGO_TP_CD, 'N/A') = NVL(T.CGO_TP_CD, 'N/A')" ).append("\n"); 
		query.append("   		AND   U.TRSP_RAIL_RTO = T.TRSP_RAIL_RTO" ).append("\n"); 
		query.append("-- 		AND   NVL(TO_CHAR(U.EFF_FM_DT, 'YYYYMMDD'), 'N/A') = NVL(TO_CHAR(T.EFF_FM_DT, 'YYYYMMDD'), 'N/A')" ).append("\n"); 
		query.append("-- 		AND   NVL(TO_CHAR(U.EFF_TO_DT, 'YYYYMMDD'), 'N/A') = NVL(TO_CHAR(T.EFF_TO_DT, 'YYYYMMDD'), 'N/A')" ).append("\n"); 
		query.append("        AND   ((U.EFF_TO_DT BETWEEN T.EFF_FM_DT AND T.EFF_TO_DT) OR (U.EFF_FM_DT BETWEEN T.EFF_FM_DT AND T.EFF_TO_DT) OR" ).append("\n"); 
		query.append("               (T.EFF_TO_DT BETWEEN U.EFF_FM_DT AND U.EFF_TO_DT) OR (T.EFF_FM_DT BETWEEN U.EFF_FM_DT AND U.EFF_TO_DT)) " ).append("\n"); 
		query.append("   		AND   NVL(U.RAIL_RTO_NO, 0) = NVL(T.RAIL_RTO_NO, 0)" ).append("\n"); 
		query.append("   		AND   NVL(U.LBS_OVR_WGT, 0) = NVL(T.LBS_OVR_WGT, 0)" ).append("\n"); 
		query.append("   		AND   NVL(U.CURR_CD, 'N/A') = NVL(T.CURR_CD, 'N/A')" ).append("\n"); 
		query.append("   		AND   NVL(U.FX_SCG_ALL_RT, 0.00001) = NVL(T.FX_SCG_ALL_RT, 0.00001)" ).append("\n"); 
		query.append("   		AND   NVL(U.FX_SCG_20FT_RT, 0.00001) = NVL(T.FX_SCG_20FT_RT, 0.00001)" ).append("\n"); 
		query.append("   		AND   NVL(U.FX_SCG_40FT_RT, 0.00001) = NVL(T.FX_SCG_40FT_RT, 0.00001)" ).append("\n"); 
		query.append("   		AND   NVL(U.FX_SCG_45FT_RT, 0.00001) = NVL(T.FX_SCG_45FT_RT, 0.00001)" ).append("\n"); 
		query.append("   		AND   NVL(U.FUEL_SCG_APLY_FLG, 'N/A') = NVL(T.FUEL_SCG_APLY_FLG, 'N/A')" ).append("\n"); 
		query.append("   		AND   NVL(U.DELT_FLG, 'N') = NVL(T.DELT_FLG, 'N')" ).append("\n"); 
		query.append("        AND   NVL(U.USR_DEF_RMK, 'X') = NVL(T.AFT_USR_DEF_RMK, 'X')" ).append("\n"); 
		query.append("        AND   U.TRSP_AGMT_SCG_SEQ <> NVL(T.TRSP_AGMT_SCG_SEQ, 0)" ).append("\n"); 
		query.append("   		AND   ROWNUM = 1" ).append("\n"); 
		query.append("	) AS RMK2," ).append("\n"); 
		query.append("	ROW_NO SR" ).append("\n"); 
		query.append("FROM TRS_AGMT_RAIL_SCG_RT_TMP T" ).append("\n"); 
		query.append("WHERE AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND ROW_NO IS NOT NULL" ).append("\n"); 

	}
}
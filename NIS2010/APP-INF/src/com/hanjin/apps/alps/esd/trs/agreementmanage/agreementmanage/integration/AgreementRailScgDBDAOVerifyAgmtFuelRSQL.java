/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AgreementRailScgDBDAOVerifyAgmtFuelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
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
		query.append("			SELECT" ).append("\n"); 
		query.append("			    1" ).append("\n"); 
		query.append("			FROM" ).append("\n"); 
		query.append("    			TRS_AGMT_HDR H," ).append("\n"); 
		query.append("				TRS_AGMT_APLY_VNDR V" ).append("\n"); 
		query.append("			WHERE H.TRSP_AGMT_OFC_CTY_CD = T.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("			AND H.TRSP_AGMT_SEQ = T.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("			AND V.TRSP_AGMT_OFC_CTY_CD = T.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("			AND V.TRSP_AGMT_SEQ = T.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("			AND V.VNDR_SEQ = T.VNDR_SEQ" ).append("\n"); 
		query.append("			AND V.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("			AND ROWNUM = 1" ).append("\n"); 
		query.append("		) IS NULL THEN ',AGMT NO ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		|| -- All Node Check" ).append("\n"); 
		query.append("		CASE WHEN T.AGMT_ROUT_ALL_FLG = 'N'" ).append("\n"); 
		query.append("			AND T.FM_NOD_CD IS NULL" ).append("\n"); 
		query.append("			AND T.TO_NOD_CD IS NULL" ).append("\n"); 
		query.append("		THEN ',ROUTE ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		|| -- From Node Check" ).append("\n"); 
		query.append("		CASE WHEN T.FM_NOD_CD <> '00'" ).append("\n"); 
		query.append("		AND" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("			    1" ).append("\n"); 
		query.append("			FROM" ).append("\n"); 
		query.append("				MDM_YARD M" ).append("\n"); 
		query.append("			WHERE M.YD_CD LIKE (T.FM_NOD_CD||'%')" ).append("\n"); 
		query.append("			AND T.FM_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("			AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			AND ROWNUM = 1" ).append("\n"); 
		query.append("		) IS NULL THEN ',ROUTE ERR'" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("		|| -- To Node Check" ).append("\n"); 
		query.append("		CASE WHEN T.TO_NOD_CD <> '00'" ).append("\n"); 
		query.append("		AND" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("    			1" ).append("\n"); 
		query.append("			FROM" ).append("\n"); 
		query.append("				MDM_YARD M" ).append("\n"); 
		query.append("			WHERE M.YD_CD LIKE (T.TO_NOD_CD||'%')" ).append("\n"); 
		query.append("			AND T.TO_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("			AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			AND ROWNUM = 1" ).append("\n"); 
		query.append("		) IS NULL THEN ',ROUTE ERR'" ).append("\n"); 
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
		query.append("		(CASE WHEN " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append(" 	   		SELECT" ).append("\n"); 
		query.append(" 	   			(" ).append("\n"); 
		query.append(" 	       			SELECT " ).append("\n"); 
		query.append("    	        		1" ).append("\n"); 
		query.append("           			FROM" ).append("\n"); 
		query.append("        				TRS_AGMT_RAIL_SCG_RT_TMP U" ).append("\n"); 
		query.append("        			WHERE U.AGMT_RAIL_TMP_SEQ = O.AGMT_RAIL_TMP_SEQ" ).append("\n"); 
		query.append("        			AND   NVL(U.VNDR_SEQ, 0) = NVL(O.VNDR_SEQ, 0)" ).append("\n"); 
		query.append("        			AND   U.TRSP_RAIL_SCG_CD = O.TRSP_RAIL_SCG_CD" ).append("\n"); 
		query.append("        			AND   U.TRSP_AGMT_OFC_CTY_CD = O.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        			AND   U.TRSP_AGMT_SEQ = O.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("        			AND   U.AGMT_ROUT_ALL_FLG = O.AGMT_ROUT_ALL_FLG" ).append("\n"); 
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
		query.append("        			AND   U.ROW_NO <> O.ROW_NO" ).append("\n"); 
		query.append("        			AND   ROWNUM = 1" ).append("\n"); 
		query.append("    			) AS RESULT" ).append("\n"); 
		query.append("    		FROM TRS_AGMT_RAIL_SCG_RT_TMP O" ).append("\n"); 
		query.append("    		WHERE O.AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("    		AND O.ROW_NO       = T.ROW_NO" ).append("\n"); 
		query.append("		) IS NOT NULL" ).append("\n"); 
		query.append("		THEN" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append(" 	   		SELECT" ).append("\n"); 
		query.append(" 	   		(" ).append("\n"); 
		query.append(" 	       		SELECT " ).append("\n"); 
		query.append("    	   	    	',UI ERROR'||' Line '||U.ROW_NO" ).append("\n"); 
		query.append("          	 	FROM" ).append("\n"); 
		query.append("        			TRS_AGMT_RAIL_SCG_RT_TMP U" ).append("\n"); 
		query.append("        		WHERE U.AGMT_RAIL_TMP_SEQ = O.AGMT_RAIL_TMP_SEQ" ).append("\n"); 
		query.append("        		AND   NVL(U.VNDR_SEQ, 0) = NVL(O.VNDR_SEQ, 0)" ).append("\n"); 
		query.append("        		AND   U.TRSP_RAIL_SCG_CD = O.TRSP_RAIL_SCG_CD" ).append("\n"); 
		query.append("        		AND   U.TRSP_AGMT_OFC_CTY_CD = O.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        		AND   U.TRSP_AGMT_SEQ = O.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("        		AND   U.AGMT_ROUT_ALL_FLG = O.AGMT_ROUT_ALL_FLG" ).append("\n"); 
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
		query.append("        		AND   U.ROW_NO <> O.ROW_NO" ).append("\n"); 
		query.append("        		AND   ROWNUM = 1" ).append("\n"); 
		query.append("    		) AS RESULT" ).append("\n"); 
		query.append("    		FROM TRS_AGMT_RAIL_SCG_RT_TMP O" ).append("\n"); 
		query.append("    		WHERE O.AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("    		AND O.ROW_NO       = T.ROW_NO" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		END)" ).append("\n"); 
		query.append("    || -- FSG, FUM 중복 체크" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT CASE WHEN MAX(SCG_RNK) > 1 THEN ',FSG/FUM DUP' END" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT AGMT_NO, RANK() OVER(PARTITION BY AGMT_NO ORDER BY TRSP_RAIL_SCG_CD) SCG_RNK" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                   SELECT  X.TRSP_AGMT_OFC_CTY_CD||X.TRSP_AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("                          ,X.TRSP_RAIL_SCG_CD" ).append("\n"); 
		query.append("                     FROM TRS_AGMT_RAIL_SCG_RT X" ).append("\n"); 
		query.append("                         ,TRS_AGMT_RAIL_SCG_RT_TMP Y" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                      AND X.TRSP_AGMT_OFC_CTY_CD = Y.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND X.TRSP_AGMT_SEQ        = Y.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                      AND Y.AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("                      AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                      AND X.TRSP_RAIL_SCG_CD    IN ('FUM', 'FSG')" ).append("\n"); 
		query.append("                    UNION" ).append("\n"); 
		query.append("                   SELECT X.TRSP_AGMT_OFC_CTY_CD||X.TRSP_AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("                         ,X.TRSP_RAIL_SCG_CD" ).append("\n"); 
		query.append("                     FROM TRS_AGMT_RAIL_SCG_RT_TMP X" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                      AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                      AND X.AGMT_RAIL_TMP_SEQ    = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("                      AND X.TRSP_RAIL_SCG_CD    IN ('FUM', 'FSG')" ).append("\n"); 
		query.append("                   )  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("	,2) AS RMK,	" ).append("\n"); 
		query.append("	CASE WHEN" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	  SELECT 1" ).append("\n"); 
		query.append("		FROM TRS_AGMT_RAIL_SCG_RT A" ).append("\n"); 
		query.append("            ,(SELECT VNDR_SEQ," ).append("\n"); 
		query.append("             		 TRSP_RAIL_SCG_CD," ).append("\n"); 
		query.append("              		 TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("            		 TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("            		 AGMT_ROUT_ALL_FLG," ).append("\n"); 
		query.append("            		 FM_NOD_CD," ).append("\n"); 
		query.append("            		 TO_NOD_CD," ).append("\n"); 
		query.append("            		 CGO_TP_CD," ).append("\n"); 
		query.append("					 AGMT_EQ_SZ_NO," ).append("\n"); 
		query.append("					 CURR_CD," ).append("\n"); 
		query.append("            		 ROW_NO" ).append("\n"); 
		query.append("        		FROM TRS_AGMT_RAIL_SCG_RT_TMP B" ).append("\n"); 
		query.append("        	   WHERE AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("        		 AND NVL(DELT_FLG,'N') = 'N'    " ).append("\n"); 
		query.append("    		) B" ).append("\n"); 
		query.append("		WHERE NVL(A.VNDR_SEQ, 0) = NVL(B.VNDR_SEQ, 0)" ).append("\n"); 
		query.append("  		  AND A.TRSP_RAIL_SCG_CD = B.TRSP_RAIL_SCG_CD" ).append("\n"); 
		query.append("		  AND A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		  AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("		  AND A.AGMT_ROUT_ALL_FLG = B.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("		  AND NVL(A.FM_NOD_CD, 'N/A') = NVL(B.FM_NOD_CD, 'N/A')" ).append("\n"); 
		query.append(" 		  AND NVL(A.TO_NOD_CD, 'N/A') = NVL(B.TO_NOD_CD, 'N/A')" ).append("\n"); 
		query.append("		  AND NVL(A.CGO_TP_CD, 'N/A') = NVL(B.CGO_TP_CD, 'N/A')" ).append("\n"); 
		query.append("		  AND A.AGMT_EQ_SZ_NO = B.AGMT_EQ_SZ_NO" ).append("\n"); 
		query.append("		  AND NVL(A.CURR_CD, 'N/A') = NVL(B.CURR_CD, 'N/A')" ).append("\n"); 
		query.append("          AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append(" 		  AND B.ROW_NO    = T.ROW_NO" ).append("\n"); 
		query.append("	) IS NOT NULL" ).append("\n"); 
		query.append("	THEN" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	  SELECT A.TRSP_AGMT_SCG_SEQ" ).append("\n"); 
		query.append("		FROM TRS_AGMT_RAIL_SCG_RT A" ).append("\n"); 
		query.append("            ,(SELECT VNDR_SEQ," ).append("\n"); 
		query.append("            	 	 TRSP_RAIL_SCG_CD," ).append("\n"); 
		query.append("            		 TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("            		 TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("            		 AGMT_ROUT_ALL_FLG," ).append("\n"); 
		query.append("            		 FM_NOD_CD," ).append("\n"); 
		query.append("            		 TO_NOD_CD," ).append("\n"); 
		query.append("            		 CGO_TP_CD," ).append("\n"); 
		query.append("					 AGMT_EQ_SZ_NO," ).append("\n"); 
		query.append("					 CURR_CD," ).append("\n"); 
		query.append("            		 ROW_NO" ).append("\n"); 
		query.append("        		FROM TRS_AGMT_RAIL_SCG_RT_TMP B" ).append("\n"); 
		query.append("        	   WHERE AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("        		 AND NVL(DELT_FLG,'N') = 'N'    " ).append("\n"); 
		query.append("    		) B" ).append("\n"); 
		query.append("		WHERE NVL(A.VNDR_SEQ, 0) = NVL(B.VNDR_SEQ, 0)" ).append("\n"); 
		query.append("		  AND A.TRSP_RAIL_SCG_CD = B.TRSP_RAIL_SCG_CD" ).append("\n"); 
		query.append("  		  AND A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(" 		  AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("		  AND A.AGMT_ROUT_ALL_FLG = B.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append(" 		  AND NVL(A.FM_NOD_CD, 'N/A') = NVL(B.FM_NOD_CD, 'N/A')" ).append("\n"); 
		query.append("		  AND NVL(A.TO_NOD_CD, 'N/A') = NVL(B.TO_NOD_CD, 'N/A')" ).append("\n"); 
		query.append(" 		  AND NVL(A.CGO_TP_CD, 'N/A') = NVL(B.CGO_TP_CD, 'N/A')" ).append("\n"); 
		query.append("		  AND A.AGMT_EQ_SZ_NO = B.AGMT_EQ_SZ_NO" ).append("\n"); 
		query.append("		  AND NVL(A.CURR_CD, 'N/A') = NVL(B.CURR_CD, 'N/A')" ).append("\n"); 
		query.append("          AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("		  AND B.ROW_NO    = T.ROW_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	END  AS RMK2," ).append("\n"); 
		query.append("	ROW_NO SR" ).append("\n"); 
		query.append("FROM TRS_AGMT_RAIL_SCG_RT_TMP T" ).append("\n"); 
		query.append("WHERE AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 

	}
}
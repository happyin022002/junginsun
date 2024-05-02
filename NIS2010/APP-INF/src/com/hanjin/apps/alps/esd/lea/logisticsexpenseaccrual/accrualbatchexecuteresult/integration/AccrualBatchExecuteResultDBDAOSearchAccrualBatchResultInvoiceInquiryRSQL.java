/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultInvoiceInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultInvoiceInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultInvoiceInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bind_sub_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bind_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultInvoiceInquiryRSQL").append("\n"); 
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
		query.append("SELECT	M.EXE_YRMON EXE_YRMON , NVL(M.REV_YRMON, ' ') REV_YRMON, B.RHQ_CD RHQ_CD ," ).append("\n"); 
		query.append("		--f_report = '1'(RHQ)&& vendor = '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--f_report = '1'(RHQ)&& vendor = '1'" ).append("\n"); 
		query.append("		#if (${f_report} == '1' && ${f_vndr} == '1' )" ).append("\n"); 
		query.append("		M.INV_VNDR_SEQ  VNDR_SEQ , V.VNDR_LGL_ENG_NM  VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--f_report = '2'(Control Office) && vendor = '0'" ).append("\n"); 
		query.append("		#if (${f_report} == '2' && ${f_vndr} != '1')" ).append("\n"); 
		query.append("		B.OFC_CD CTRL_OFC_CD," ).append("\n"); 
		query.append("		M.CTRL_OFC_CD SUB_OFC_CD ," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        --f_report = '2'(Control Office)&& vendor = '1'" ).append("\n"); 
		query.append("		#if (${f_report} == '2' && ${f_vndr} == '1' )" ).append("\n"); 
		query.append("		B.OFC_CD CTRL_OFC_CD," ).append("\n"); 
		query.append("		M.CTRL_OFC_CD SUB_OFC_CD ," ).append("\n"); 
		query.append("		M.INV_VNDR_SEQ  VNDR_SEQ , V.VNDR_LGL_ENG_NM  VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		C.COST_MN_TP  MN_COST_TP_NM , C.SUB_COST_TP_NM  SUB_COST_TP_NM ," ).append("\n"); 
		query.append("		M.COA_COST_SRC_CD COA_COST_SRC_CD , M.ACCT_CD ACCT_CD," ).append("\n"); 
		query.append("		M.N1ST_NOD_CD N1ST_NOD_CD , M.N2ND_NOD_CD N2ND_NOD_CD, NVL(M.N3RD_NOD_CD, '')  N3RD_NOD_CD , NVL(M.N4TH_NOD_CD ,'')  N4TH_NOD_CD ," ).append("\n"); 
		query.append("		M.LOCL_CURR_CD CURR_CD, SUM(M.LOCL_COST_AMT) LOCL_COST_AMT ," ).append("\n"); 
		query.append("		CASE	WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("					ROUND(SUM(M.LOCL_COST_AMT / U.USD_LOCL_XCH_RT), 20)" ).append("\n"); 
		query.append("				ELSE" ).append("\n"); 
		query.append("					SUM(M.USD_COST_AMT)" ).append("\n"); 
		query.append("		END USD_COST_AMT" ).append("\n"); 
		query.append("FROM	LEA_ACT_COST_IF M" ).append("\n"); 
		query.append("	," ).append("\n"); 
		query.append("		(SELECT 	VNDR_SEQ" ).append("\n"); 
		query.append("				, 	SUBSTR(VNDR_LGL_ENG_NM , 1, 50) VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("		 FROM		MDM_VENDOR" ).append("\n"); 
		query.append("		 WHERE 		DELT_FLG 			= 'N'" ).append("\n"); 
		query.append("		) v" ).append("\n"); 
		query.append("	," ).append("\n"); 
		query.append("		(SELECT		CURR_CD" ).append("\n"); 
		query.append("				, 	USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("		 FROM		GL_MON_XCH_RT" ).append("\n"); 
		query.append("		 WHERE		ACCT_XCH_RT_YRMON 	= REPLACE(@[frm_exe_yrmon_to],'-')" ).append("\n"); 
		query.append("		 AND		ACCT_XCH_RT_LVL 	= '3'" ).append("\n"); 
		query.append("		 AND 		DELT_FLG 			= 'N'" ).append("\n"); 
		query.append("		) U" ).append("\n"); 
		query.append("	," ).append("\n"); 
		query.append("		(SELECT		DECODE(Y.MN_COST_TP_CD, 'TM', 'Terminal', 'TR', 'Transport', 'MT', 'Mty Reposition ', 'CH', 'Chassis ', 'ETC' ) COST_MN_TP" ).append("\n"); 
		query.append("				,	Y.MN_COST_TP_CD" ).append("\n"); 
		query.append("				,	X.SUB_COST_TP_CD" ).append("\n"); 
		query.append("				, 	Y.SUB_COST_TP_NM" ).append("\n"); 
		query.append("				, 	X.COA_COST_SRC_CD" ).append("\n"); 
		query.append("				, 	X.ACCT_CD" ).append("\n"); 
		query.append("				,  	X.ACCL_AUTO_CD" ).append("\n"); 
		query.append("		FROM	(	SELECT		DISTINCT" ).append("\n"); 
		query.append("								SUB_COST_TP_CD SUB_COST_TP_CD" ).append("\n"); 
		query.append("							, 	COA_COST_SRC_CD" ).append("\n"); 
		query.append("							, 	ACCT_CD ACCT_CD" ).append("\n"); 
		query.append("							, 	ACCL_AUTO_CD" ).append("\n"); 
		query.append("					FROM		LEA_LGS_COST" ).append("\n"); 
		query.append("					WHERE		DELT_FLG 	= 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			        UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		            SELECT  DISTINCT" ).append("\n"); 
		query.append("            		        LL.SUB_COST_TP_CD" ).append("\n"); 
		query.append("		                ,   LL.COA_COST_SRC_CD" ).append("\n"); 
		query.append("		                ,   LL.OTR_CRR_ACCT_CD" ).append("\n"); 
		query.append("		                ,   LL.OTR_CRR_ACCL_AUTO_CD" ).append("\n"); 
		query.append("		            FROM    LEA_LGS_COST   LL" ).append("\n"); 
		query.append("		            WHERE   LL.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("		            AND     LL.OTR_CRR_ACCT_CD  IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				)	X" ).append("\n"); 
		query.append("			,		LEA_SUB_COST_TP Y" ).append("\n"); 
		query.append("		WHERE   X.SUB_COST_TP_CD 		= Y.SUB_COST_TP_CD" ).append("\n"); 
		query.append("		AND		Y.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		) C" ).append("\n"); 
		query.append("	," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("	     /* ::JSK::" ).append("\n"); 
		query.append("		 SELECT SUB_OFC_CD, OFC_CD, RHQ_CD" ).append("\n"); 
		query.append("		 FROM	(	SELECT		DISTINCT" ).append("\n"); 
		query.append("								OFC_CD SUB_OFC_CD" ).append("\n"); 
		query.append("							, 	OFC_N5TH_LVL_CD OFC_CD" ).append("\n"); 
		query.append("							, 	OFC_N3RD_LVL_CD RHQ_CD" ).append("\n"); 
		query.append("					FROM		COA_OFC_LVL" ).append("\n"); 
		query.append("                    WHERE  		1 = 1" ).append("\n"); 
		query.append("				    --::JSK::--AND			REPLACE([frm_exe_yrmon_to], '-')  BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON           --월별관리--" ).append("\n"); 
		query.append(" 				    AND OFC_CD NOT IN ('SELTBB','SELOPE') --('SELTOB', 'SELCOE')" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT   'SELTBB' , 'SELSC', 'SHARC' FROM DUAL --'SELTOB' , 'SELBB', 'SHAAS' " ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  'SELOPE' , 'SELSC', 'SHARC' FROM DUAL   --'SELCOE' , 'SELBB', 'SHAAS'" ).append("\n"); 
		query.append("		*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT 	YY.RHQ_CD" ).append("\n"); 
		query.append("				,	YY.OFC_CD" ).append("\n"); 
		query.append("				,	YY.SUB_OFC_CD" ).append("\n"); 
		query.append("				----::JSK::--,   OFC_APLY_FM_YRMON" ).append("\n"); 
		query.append("				----::JSK::--,   OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("		 	FROM	(" ).append("\n"); 
		query.append("					------------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("        			SELECT     	DISTINCT" ).append("\n"); 
		query.append("                   				CASE WHEN XX.OFC_CD IN ('SELTBB','SELOPE') THEN 'SHARC' --('SELTOB','SELCOE') THEN 'SHAAS'" ).append("\n"); 
		query.append("                        			 ELSE XX.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                   				END							AS RHQ_CD" ).append("\n"); 
		query.append("               				,   CASE WHEN XX.OFC_CD IN ('SELTBB','SELOPE') THEN 'SELSC' --('SELTOB','SELCOE') THEN 'SELBB'" ).append("\n"); 
		query.append("                        			 ELSE XX.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                   				END  						AS OFC_CD" ).append("\n"); 
		query.append("               				,   XX.OFC_CD            		AS SUB_OFC_CD" ).append("\n"); 
		query.append("        			FROM       	(" ).append("\n"); 
		query.append("                           SELECT     *" ).append("\n"); 
		query.append("                           FROM       (" ).append("\n"); 
		query.append("                                      SELECT          L.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                                                 ,    L.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                                                 ,    L.OFC_CD" ).append("\n"); 
		query.append("                                                 ,    L.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("                                                 ,    L.OFC_APLY_FM_YRMON" ).append("\n"); 
		query.append("                                                 ,    ROW_NUMBER() OVER (PARTITION BY L.OFC_CD ORDER BY L.OFC_APLY_TO_YRMON DESC)  OFC_ORDER" ).append("\n"); 
		query.append("                                       FROM           COA_OFC_LVL            L" ).append("\n"); 
		query.append("                                       WHERE          L.OFC_N3RD_LVL_CD      IS NOT NULL" ).append("\n"); 
		query.append("                                       AND            L.OFC_N5TH_LVL_CD      IS NOT NULL" ).append("\n"); 
		query.append("                                       ) X" ).append("\n"); 
		query.append("                            WHERE      X.OFC_ORDER    = 1" ).append("\n"); 
		query.append("                          ) XX" ).append("\n"); 
		query.append("					------------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("					) YY" ).append("\n"); 
		query.append("			WHERE	YY.RHQ_CD 			= @[f_rhq_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${f_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("				AND   YY.OFC_CD   = @[f_ctrl_ofc_cd]" ).append("\n"); 
		query.append("			#elseif(${f_report} == '2')" ).append("\n"); 
		query.append("				AND   YY.OFC_CD   IN (" ).append("\n"); 
		query.append("					  ------------------------------------------------------------------" ).append("\n"); 
		query.append("					  SELECT     DISTINCT" ).append("\n"); 
		query.append("								 LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("					  FROM       COA_OFC_LVL                LL" ).append("\n"); 
		query.append("					  WHERE      1 = 1" ).append("\n"); 
		query.append("					  AND        CASE (" ).append("\n"); 
		query.append("									  SELECT  OFC_LVL" ).append("\n"); 
		query.append("									  FROM    (" ).append("\n"); 
		query.append("											  SELECT  L.OFC_LVL" ).append("\n"); 
		query.append("											  FROM    COA_OFC_LVL       L" ).append("\n"); 
		query.append("											  WHERE   L.OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("											  AND     L.OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("											  AND     L.OFC_CD          = @[bind_ofc_cd]    /* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("											  ORDER BY L.OFC_APLY_TO_YRMON  DESC" ).append("\n"); 
		query.append("											  )" ).append("\n"); 
		query.append("									   WHERE   ROWNUM  = 1" ).append("\n"); 
		query.append("									  )" ).append("\n"); 
		query.append("									   WHEN '1' THEN 'XXXXX'" ).append("\n"); 
		query.append("									   WHEN '2' THEN LL.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("									   WHEN '3' THEN LL.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("									   WHEN '4' THEN LL.OFC_CD" ).append("\n"); 
		query.append("									   WHEN '5' THEN LL.OFC_CD" ).append("\n"); 
		query.append("									   WHEN '6' THEN LL.OFC_CD" ).append("\n"); 
		query.append("									   WHEN '7' THEN LL.OFC_CD" ).append("\n"); 
		query.append("									   WHEN '9' THEN 'XXXXX'" ).append("\n"); 
		query.append("									   ELSE          'XXXXX'" ).append("\n"); 
		query.append("								 END                        = @[bind_ofc_cd]    /* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("					  AND        LL.OFC_N5TH_LVL_CD         IS NOT NULL" ).append("\n"); 
		query.append("					  ------------------------------------------------------------------" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${f_sub_ofc_cd} != '')" ).append("\n"); 
		query.append("				AND	  YY.SUB_OFC_CD = @[f_sub_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#elseif(${f_report} == '2' && '1'=='0')" ).append("\n"); 
		query.append("				AND   YY.SUB_OFC_CD IN (" ).append("\n"); 
		query.append("					  ------------------------------------------------------------------" ).append("\n"); 
		query.append("					  SELECT     XX.SUB_OFC_CD" ).append("\n"); 
		query.append("					  FROM       (" ).append("\n"); 
		query.append("								 ----------------------------------------------------" ).append("\n"); 
		query.append("								  SELECT     DISTINCT" ).append("\n"); 
		query.append("											 LL.OFC_CD                  AS SUB_OFC_CD" ).append("\n"); 
		query.append("								  FROM       COA_OFC_LVL                LL" ).append("\n"); 
		query.append("								  WHERE      1 = 1" ).append("\n"); 
		query.append("								  AND        CASE (" ).append("\n"); 
		query.append("												  SELECT  OFC_LVL" ).append("\n"); 
		query.append("												  FROM    (" ).append("\n"); 
		query.append("														  SELECT  L.OFC_LVL" ).append("\n"); 
		query.append("														  FROM    COA_OFC_LVL       L" ).append("\n"); 
		query.append("														  WHERE   L.OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("														  AND     L.OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("														  AND     L.OFC_CD          = @[bind_sub_ofc_cd]     /* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("														  ORDER BY L.OFC_APLY_TO_YRMON  DESC" ).append("\n"); 
		query.append("														  )" ).append("\n"); 
		query.append("												   WHERE   ROWNUM  = 1" ).append("\n"); 
		query.append("												  )" ).append("\n"); 
		query.append("												   WHEN '1' THEN 'XXXXX'" ).append("\n"); 
		query.append("												   WHEN '2' THEN 'XXXXX'" ).append("\n"); 
		query.append("												   WHEN '3' THEN 'XXXXX'" ).append("\n"); 
		query.append("												   WHEN '4' THEN LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("												   WHEN '5' THEN LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("												   WHEN '6' THEN LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("												   WHEN '7' THEN LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("												   WHEN '9' THEN 'XXXXX'" ).append("\n"); 
		query.append("												   ELSE          'XXXXX'" ).append("\n"); 
		query.append("											 END                        = @[bind_sub_ofc_cd]	/* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										 OR  LL.OFC_CD                  = @[bind_sub_ofc_cd]	/* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("								 ----------------------------------------------------" ).append("\n"); 
		query.append("								 ) XX" ).append("\n"); 
		query.append("					  ------------------------------------------------------------------" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			) B" ).append("\n"); 
		query.append("WHERE		M.EXE_YRMON 			BETWEEN REPLACE(@[frm_exe_yrmon_from], '-') AND REPLACE(@[frm_exe_yrmon_to], '-')" ).append("\n"); 
		query.append("AND			M.COA_COST_SRC_CD 		= C.COA_COST_SRC_CD" ).append("\n"); 
		query.append("AND			M.ACCT_CD 				= C.ACCT_CD" ).append("\n"); 
		query.append("AND			M.LOCL_CURR_CD 			= U.CURR_CD" ).append("\n"); 
		query.append("AND			M.CTRL_OFC_CD 			= B.SUB_OFC_CD" ).append("\n"); 
		query.append("AND 		M.INV_VNDR_SEQ 			= V.VNDR_SEQ        (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (1=2" ).append("\n"); 
		query.append("#if (${f_cost_type_f} == '1')" ).append("\n"); 
		query.append("    OR C.MN_COST_TP_CD      IN ('TR', 'TM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cost_type_m} == '1')" ).append("\n"); 
		query.append("    OR C.MN_COST_TP_CD = 'MT'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("    OR C.MN_COST_TP_CD = 'CH'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cost_type_fv} == '1')" ).append("\n"); 
		query.append("    OR C.SUB_COST_TP_CD     IN ('TRDF','TMDF')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cost_type_ev} == '1')" ).append("\n"); 
		query.append("    OR C.SUB_COST_TP_CD     IN ('TRDM','TMDM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_other_carrier_expense} == '1')" ).append("\n"); 
		query.append("    OR M.OTR_CRR_FLG  = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY	M.EXE_YRMON , M.REV_YRMON, B.RHQ_CD ," ).append("\n"); 
		query.append("			--f_report = '1'(RHQ)&& vendor = '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--f_report = '1'(RHQ)&& vendor = '1'" ).append("\n"); 
		query.append("			#if (${f_report} == '1' && ${f_vndr} == '1' )" ).append("\n"); 
		query.append("			M.INV_VNDR_SEQ , V.VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--f_report = '2'(Control Office) && vendor = '0'" ).append("\n"); 
		query.append("			#if (${f_report} == '2' && ${f_vndr} != '1')" ).append("\n"); 
		query.append("			B.OFC_CD," ).append("\n"); 
		query.append("			M.CTRL_OFC_CD ," ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--f_report = '2'(Control Office)&& vendor = '1'" ).append("\n"); 
		query.append("			#if (${f_report} == '2' && ${f_vndr} == '1' )" ).append("\n"); 
		query.append("			B.OFC_CD," ).append("\n"); 
		query.append("			M.CTRL_OFC_CD ," ).append("\n"); 
		query.append("			M.INV_VNDR_SEQ , V.VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			C.COST_MN_TP , C.SUB_COST_TP_NM , M.COA_COST_SRC_CD, M.ACCT_CD," ).append("\n"); 
		query.append("			M.N1ST_NOD_CD, M.N2ND_NOD_CD, NVL(M.N3RD_NOD_CD, '') , NVL(M.N4TH_NOD_CD ,'') ," ).append("\n"); 
		query.append("			M.LOCL_CURR_CD" ).append("\n"); 
		query.append("ORDER BY	M.EXE_YRMON , M.REV_YRMON, B.RHQ_CD ," ).append("\n"); 
		query.append("			#if (${f_report} == '2')" ).append("\n"); 
		query.append("			B.OFC_CD , M.CTRL_OFC_CD ," ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			C.COST_MN_TP" ).append("\n"); 

	}
}
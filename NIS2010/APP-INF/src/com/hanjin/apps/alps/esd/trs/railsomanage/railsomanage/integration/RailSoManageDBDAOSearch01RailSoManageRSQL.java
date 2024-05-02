/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RailSoManageDBDAOSearch01RailSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch01RailSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail I/B SO 대상 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch01RailSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rail_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch01RailSoManageRSQL").append("\n"); 
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
		query.append("        X.TRSP_BND_CD AS TRSP_BND_CD," ).append("\n"); 
		query.append("        X.EQ_NO AS EQ_NO," ).append("\n"); 
		query.append("        X.EQ_TPSZ_CD AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("        SUBSTR(X.POD_NOD_CD, 1, 5) AS POD_CD," ).append("\n"); 
		query.append("        SUBSTR(X.POD_NOD_CD, 6) AS POD_CD_YARD," ).append("\n"); 
		query.append("        SUBSTR(X.FM_NOD_CD, 1, 5) AS FM_NOD_CD," ).append("\n"); 
		query.append("        SUBSTR(X.FM_NOD_CD, 6) AS FM_NOD_YARD," ).append("\n"); 
		query.append("        MIN(DECODE(SUBSTR(X.RAIL_CMB_THRU_TP_CD, 2, 1), '2', DECODE(X.ROUT_DTL_SEQ, 2, X.LNK_ORG_NOD_CD, ''), " ).append("\n"); 
		query.append("	    '3', DECODE(X.ROUT_DTL_SEQ, 2, X.LNK_ORG_NOD_CD, ''), '')) AS INTERCHANGE1_LOC," ).append("\n"); 
		query.append("    	'' AS INTERCHANGE1_NOD," ).append("\n"); 
		query.append("    	MIN(DECODE(SUBSTR(X.RAIL_CMB_THRU_TP_CD, 2, 1), '3', DECODE(X.ROUT_DTL_SEQ, 2, X.LNK_DEST_NOD_CD, ''), '')) AS INTERCHANGE2_LOC," ).append("\n"); 
		query.append("    	'' AS INTERCHANGE2_NOD," ).append("\n"); 
		query.append("        SUBSTR(X.TO_NOD_CD, 1, 5) AS TO_NOD_CD," ).append("\n"); 
		query.append("        SUBSTR(X.TO_NOD_CD, 6) AS TO_NOD_YARD," ).append("\n"); 
		query.append("        CASE WHEN X.IBD_CSTMS_CLR_LOC_CD != SUBSTR(X.FM_NOD_CD,1,5) AND X.IBD_CSTMS_CLR_LOC_CD != SUBSTR(X.TO_NOD_CD,1,5) THEN '0'" ).append("\n"); 
		query.append("    	     ELSE ''" ).append("\n"); 
		query.append("    	END AS EXPT," ).append("\n"); 
		query.append("    	NVL(X.HVC, X.CM) AS HIGH_VAL_CGO_TP_CD," ).append("\n"); 
		query.append("    	X.IBD_CSTMS_CLR_LOC_CD AS IBD_CSTMS_CLR_LOC_CD," ).append("\n"); 
		query.append("        X.DEL_SCC_CD AS DEL_SCC_CD," ).append("\n"); 
		query.append("        SUBSTR(X.DEL_NOD_CD, 1, 5) AS DEL_NOD_CD," ).append("\n"); 
		query.append("        SUBSTR(X.DEL_NOD_CD, 6) AS DEL_NOD_CD_YARD," ).append("\n"); 
		query.append("        X.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("        X.BL_NO AS BL_NO," ).append("\n"); 
		query.append("        X.BKG_RCVDE_TERM_CD AS BKG_RCVDE_TERM_CD,   " ).append("\n"); 
		query.append("        X.CGO_TP_CD AS CGO_TP_CD," ).append("\n"); 
		query.append("    	SUBSTR(X.BKG_SPCL, 0, LENGTH(X.BKG_SPCL)-1) AS BKG_SPE," ).append("\n"); 
		query.append("		CASE WHEN LENGTH(X.BKG_CNTR_SPCL) > 10 THEN" ).append("\n"); 
		query.append("				SUBSTR(X.BKG_CNTR_SPCL, 0, 10)" ).append("\n"); 
		query.append("			 ELSE" ).append("\n"); 
		query.append("				SUBSTR(X.BKG_CNTR_SPCL, 0, LENGTH(X.BKG_CNTR_SPCL)-1)" ).append("\n"); 
		query.append("		END AS SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("    	X.NVOCC_FILE_NO AS NVOCC_FILE_NO," ).append("\n"); 
		query.append("    	X.BLCK_STWG_CD AS BLCK_STWG_CD," ).append("\n"); 
		query.append("    	SUBSTR(X.CSTMS_IBD, INSTR(X.CSTMS_IBD, '$', 1, 1) + 1) AS IBD_NO," ).append("\n"); 
		query.append("    	(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO = X.BKG_NO AND CNTR_NO = X.EQ_NO AND CNTR_SEAL_SEQ = 1) AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("    	DECODE(SUBSTR(X.BKG_CNTR, 1, INSTR(X.BKG_CNTR, '$', 1, 1) - 1), 'LBS', " ).append("\n"); 
		query.append("    	       SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1), 'KGM'," ).append("\n"); 
		query.append("    	       SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1)*2.2, 'KG', " ).append("\n"); 
		query.append("    	       SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1)*2.2, 'KGS', " ).append("\n"); 
		query.append("    	       SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1)*2.2, " ).append("\n"); 
		query.append("			   DECODE(SUBSTR(X.FM_NOD_CD, 1, 2), 'CA', SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1)*2.2, " ).append("\n"); 
		query.append("												 'US', SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1))" ).append("\n"); 
		query.append("			   ) AS CNTR_WGT," ).append("\n"); 
		query.append("        SUBSTR(X.MDM_CO, INSTR(X.MDM_CO, '$', 1, 1) + 1) AS CMDT_NAME," ).append("\n"); 
		query.append("        MAX(DECODE( X.ROUT_DTL_SEQ, 1, NVL( AGMT.AGMT_REF_NO, 'N/A')||DECODE( X.LNK_DEST_NOD_CD,SUBSTR(X.TO_NOD_CD, 1, 5)||SUBSTR(X.TO_NOD_CD, 6),'',' / ')  ))  ||" ).append("\n"); 
		query.append("		MAX(DECODE( X.ROUT_DTL_SEQ, 2, NVL( AGMT.AGMT_REF_NO, 'N/A')||DECODE( X.LNK_DEST_NOD_CD,SUBSTR(X.TO_NOD_CD, 1, 5)||SUBSTR(X.TO_NOD_CD, 6),'',' / ')  ))  ||" ).append("\n"); 
		query.append("		MAX(DECODE( X.ROUT_DTL_SEQ, 3, NVL( AGMT.AGMT_REF_NO, 'N/A')||DECODE( X.LNK_DEST_NOD_CD,SUBSTR(X.TO_NOD_CD, 1, 5)||SUBSTR(X.TO_NOD_CD, 6),'',' / ')  ))  ||" ).append("\n"); 
		query.append("		MAX(DECODE( X.ROUT_DTL_SEQ, 4, NVL( AGMT.AGMT_REF_NO, 'N/A')||DECODE( X.LNK_DEST_NOD_CD,SUBSTR(X.TO_NOD_CD, 1, 5)||SUBSTR(X.TO_NOD_CD, 6),'',' / ')  ))  ||" ).append("\n"); 
		query.append("		MAX(DECODE( X.ROUT_DTL_SEQ, 5, NVL( AGMT.AGMT_REF_NO, 'N/A')||DECODE( X.LNK_DEST_NOD_CD,SUBSTR(X.TO_NOD_CD, 1, 5)||SUBSTR(X.TO_NOD_CD, 6),'',' / ')  ))  ||" ).append("\n"); 
		query.append("		MAX(DECODE( X.ROUT_DTL_SEQ, 6, NVL( AGMT.AGMT_REF_NO, 'N/A')||DECODE( X.LNK_DEST_NOD_CD,SUBSTR(X.TO_NOD_CD, 1, 5)||SUBSTR(X.TO_NOD_CD, 6),'',' / ')  ))  ||" ).append("\n"); 
		query.append("		MAX(DECODE( X.ROUT_DTL_SEQ, 7, NVL( AGMT.AGMT_REF_NO, 'N/A')||DECODE( X.LNK_DEST_NOD_CD,SUBSTR(X.TO_NOD_CD, 1, 5)||SUBSTR(X.TO_NOD_CD, 6),'',' / ')  ))  ||" ).append("\n"); 
		query.append("		MAX(DECODE( X.ROUT_DTL_SEQ, 8, NVL( AGMT.AGMT_REF_NO, 'N/A')||DECODE( X.LNK_DEST_NOD_CD,SUBSTR(X.TO_NOD_CD, 1, 5)||SUBSTR(X.TO_NOD_CD, 6),'',' / ')  ))    REF_NO," ).append("\n"); 
		query.append("        X.ROUT_PLN_CD AS ROUT_PLN_CD," ).append("\n"); 
		query.append("        X.VVD_CD AS TRUNKVVD," ).append("\n"); 
		query.append("        X.SLAN_CD AS SLAN_CD," ).append("\n"); 
		query.append("        X.SC_NO AS SC_NO," ).append("\n"); 
		query.append("        X.SHPR_CUST_NM AS SHPR_CUST_NM," ).append("\n"); 
		query.append("    	X.CNEE_CUST_NM AS CNEE_CUST_NM," ).append("\n"); 
		query.append("    	TO_CHAR(X.N1ST_NOD_PLN_DT, 'YYYYMMDD') AS N1ST_NOD_PLN_DT,       " ).append("\n"); 
		query.append("		TO_CHAR(X.N1ST_NOD_PLN_DT, 'HH24:MI:SS') AS N1ST_NOD_PLN_DT_HMS, " ).append("\n"); 
		query.append("		TO_CHAR(X.LST_NOD_PLN_DT, 'YYYYMMDD') AS LST_NOD_PLN_DT,         " ).append("\n"); 
		query.append("		TO_CHAR(X.LST_NOD_PLN_DT, 'HH24:MI:SS') AS LST_NOD_PLN_DT_HMS," ).append("\n"); 
		query.append("		SUBSTR(X.CSTMS_IBD, 1, INSTR(X.CSTMS_IBD, '$', 1, 1) - 1) AS IBD_IPI_LOCL_IND_CD," ).append("\n"); 
		query.append("		SUBSTR(X.MDM_CO, 1, INSTR(X.MDM_CO, '$', 1, 1) - 1) AS CMDT_CD," ).append("\n"); 
		query.append("		X.TRSP_SO_OFC_CTY_CD AS TRSP_SO_OFC_CTY_CD,   " ).append("\n"); 
		query.append("    	X.CRE_USR_ID AS CRE_USR_ID,           " ).append("\n"); 
		query.append("    	X.UPD_USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("    	X.RAIL_CMB_THRU_TP_CD AS RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("    	X.COP_NO AS COP_NO," ).append("\n"); 
		query.append("    	X.COST_ACT_GRP_SEQ AS COST_ACT_GRP_SEQ, " ).append("\n"); 
		query.append("    	X.ACT_GRP_CD AS ACT_GRP_CD," ).append("\n"); 
		query.append("    	X.ROUT_ORG_NOD_CD AS ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("    	X.ROUT_DEST_NOD_CD AS ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("    	X.ROUT_SEQ AS ROUT_SEQ," ).append("\n"); 
		query.append("    	X.BKG_CGO_TP_CD AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("    	X.INLND_ROUT_RMK AS INLND_ROUT_RMK," ).append("\n"); 
		query.append("    	SUBSTR(POL_NOD_CD, 1, 5) AS POL_CD," ).append("\n"); 
		query.append("		SUBSTR(POL_NOD_CD, 6) AS POL_CD_YARD," ).append("\n"); 
		query.append("    	SUBSTR(X.POR_NOD_CD, 1, 5) AS POR_NOD_CD," ).append("\n"); 
		query.append("        SUBSTR(X.POR_NOD_CD, 6) AS POR_NOD_CD_YARD," ).append("\n"); 
		query.append("        DECODE(MAX(X.ROUT_DTL_SEQ), SUBSTR(X.RAIL_CMB_THRU_TP_CD, 2, 1), MAX(X.ROUT_DTL_SEQ), '0') AS ROUT_DTL_SEQ," ).append("\n"); 
		query.append("        X.TRSP_COST_DTL_MOD_CD AS TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("    	X.CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("    	X.CUST_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("    	X.POR_CD AS POR_CD," ).append("\n"); 
		query.append("        X.DEL_CD AS DEL_CD," ).append("\n"); 
		query.append("        X.INV_BIL_PATT_DIV_FLG AS INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("    	MAX(X.ROUT_DTL_SEQ) AS RTR_DIV_CNT," ).append("\n"); 
		query.append("    	TO_CHAR(X.VD_DT, 'YYYYMMDDHH24:MI:SS') AS VD_DT," ).append("\n"); 
		query.append("    	X.TML_NOD_CD AS TML_NOD_CD," ).append("\n"); 
		query.append("		SUBSTR(X.FM_NOD_CD, 1, 5) AS ORG_FM_NOD_CD," ).append("\n"); 
		query.append("        SUBSTR(X.FM_NOD_CD, 6) AS ORG_FM_NOD_YARD,	" ).append("\n"); 
		query.append("		SUBSTR(X.TO_NOD_CD, 1, 5) AS ORG_TO_NOD_CD," ).append("\n"); 
		query.append("        SUBSTR(X.TO_NOD_CD, 6) AS ORG_TO_NOD_YARD," ).append("\n"); 
		query.append("        (SELECT NON_RT_STS_CD FROM BKG_BOOKING WHERE BKG_NO = X.BKG_NO) AS NON_RT_STS_CD" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("	SELECT TMP.*" ).append("\n"); 
		query.append("		 ,(NVL(BKG_CNTR.WGT_UT_CD, ' ') || '$' || NVL(TO_CHAR(BKG_CNTR.CNTR_WGT), '0')) BKG_CNTR" ).append("\n"); 
		query.append("		 ,(DECODE( BKG_CNTR.DCGO_FLG , 'Y' , 'DG,') || DECODE( BKG_CNTR.BB_CGO_FLG , 'Y' , 'BB,') || DECODE( BKG_CNTR.AWK_CGO_FLG , 'Y' , 'AK,') || DECODE( BKG_CNTR.RC_FLG , 'Y' , 'RF,') ) BKG_CNTR_SPCL" ).append("\n"); 
		query.append("		 ,(" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("			    DECODE( BKG_SPCL.DCGO_FLG         ,'Y', 'DG /') ||" ).append("\n"); 
		query.append("			    DECODE( BKG_SPCL.RC_FLG           ,'Y', 'RF /') ||" ).append("\n"); 
		query.append("			    DECODE( BKG_SPCL.AWK_CGO_FLG      ,'Y', 'AK /') ||" ).append("\n"); 
		query.append("			    DECODE( BKG_SPCL.BB_CGO_FLG       ,'Y', 'BB /') ||" ).append("\n"); 
		query.append("			    DECODE( BKG_SPCL.SPCL_HIDE_FLG    ,'Y', 'HD /') ||" ).append("\n"); 
		query.append("			    DECODE( BKG_SPCL.FD_GRD_FLG	      ,'Y', 'FG /') ||" ).append("\n"); 
		query.append("			    DECODE( BKG_SPCL.RAIL_BLK_CD      ,'', '', 'RB /') BKG_SPE" ).append("\n"); 
		query.append("			FROM" ).append("\n"); 
		query.append("			    BKG_BOOKING BKG_SPCL" ).append("\n"); 
		query.append("			WHERE BKG_SPCL.BKG_NO  = TMP.BKG_NO" ).append("\n"); 
		query.append("		 ) BKG_SPCL" ).append("\n"); 
		query.append("		 ,(" ).append("\n"); 
		query.append("		    SELECT " ).append("\n"); 
		query.append("				NVL(CSTMS_IBD.CSTMS_CLR_TP_CD, ' ') || '$' || NVL(CSTMS_IBD.IBD_TRSP_NO, ' ')" ).append("\n"); 
		query.append("		    FROM " ).append("\n"); 
		query.append("				BKG_CSTMS_ADV_IBD CSTMS_IBD" ).append("\n"); 
		query.append("		    WHERE CSTMS_IBD.BL_NO  = TMP.BL_NO" ).append("\n"); 
		query.append("		    AND   CSTMS_IBD.CNT_CD = 'US' " ).append("\n"); 
		query.append("		 ) CSTMS_IBD" ).append("\n"); 
		query.append("		 ,(" ).append("\n"); 
		query.append("		    SELECT " ).append("\n"); 
		query.append("				NVL(MDM_CO.CMDT_CD, ' ') || '$' || NVL(REPLACE(MDM_CO.CMDT_NM, CHR(13)||CHR(10), ' '), ' ')" ).append("\n"); 
		query.append("		    FROM " ).append("\n"); 
		query.append("				MDM_COMMODITY MDM_CO" ).append("\n"); 
		query.append("		    WHERE MDM_CO.CMDT_CD  = TMP.CMDT_CD" ).append("\n"); 
		query.append("		 ) MDM_CO" ).append("\n"); 
		query.append("		 ,(" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("				CASE WHEN SUBSTR(TMP.POD_NOD_CD, 1, 5) IN ('USLGB','USLAX') " ).append("\n"); 
		query.append("--							AND (SELECT SUBSTR(TRS_GET_BLCK_STWG_CD_FNC(TMP.BKG_NO),3,1) FROM DUAL) IN ('2','3','4') THEN HVC.HVC_CD " ).append("\n"); 
		query.append("                            AND (SELECT SUBSTR(BKG.BLCK_STWG_CD, 3,1) FROM BKG_BOOKING BKG WHERE BKG.BKG_NO = TMP.BKG_NO) IN ('2','3','4') THEN HVC.HVC_CD" ).append("\n"); 
		query.append("				 	 ELSE ''											 " ).append("\n"); 
		query.append("				END HIGH_VAL_CGO_TP_CD" ).append("\n"); 
		query.append("		    FROM" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			    SELECT" ).append("\n"); 
		query.append("					CMDT_CD," ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("						CASE WHEN ( REP_CMDT_CD = '6400' OR CMDT_CD IN ('847129', '853945', '847100') ) THEN 'H'" ).append("\n"); 
		query.append("						 	 WHEN CMDT_CD IN ( '760600', '840081', '730049', '840082', '847904', '731204', '840233'," ).append("\n"); 
		query.append("                      					   	   '740900', '740009', '730114', '850030', '950020', '720800', '390013'," ).append("\n"); 
		query.append("                      					   	   '720020', '721900', '720014', '720801', '840039') THEN 'C' " ).append("\n"); 
		query.append("						END " ).append("\n"); 
		query.append("					) HVC_CD" ).append("\n"); 
		query.append("				FROM MDM_COMMODITY" ).append("\n"); 
		query.append("            	WHERE ( REP_CMDT_CD = '6400' OR CMDT_CD IN ('847129', '853945', '847100', '760600', '840081', '730049'," ).append("\n"); 
		query.append("                      										'840082', '847904', '731204', '840233', '740900', '740009'," ).append("\n"); 
		query.append("                      										'730114', '850030', '950020', '720800', '390013', '720020'," ).append("\n"); 
		query.append("										                    '721900', '720014', '720801', '840039') " ).append("\n"); 
		query.append("					   ) " ).append("\n"); 
		query.append("			) HVC" ).append("\n"); 
		query.append("		 	WHERE HVC.CMDT_CD = TMP.CMDT_CD " ).append("\n"); 
		query.append("		 ) HVC" ).append("\n"); 
		query.append("		 ,(" ).append("\n"); 
		query.append("		    SELECT" ).append("\n"); 
		query.append("			CASE WHEN  SUBSTR(TMP.POD_NOD_CD, 1, 5) IN ('USLGB','USLAX') AND 	" ).append("\n"); 
		query.append("					   ( UPPER( CM.CNTR_MF_GDS_DESC) LIKE '%NOTE BOOK%'	" ).append("\n"); 
		query.append("						 OR UPPER( CM.CNTR_MF_GDS_DESC) LIKE '%LCD%TFT%' 	" ).append("\n"); 
		query.append("						 OR UPPER( CM.CNTR_MF_GDS_DESC) LIKE '%MONITOR%%' 	" ).append("\n"); 
		query.append("						 OR UPPER( CM.CNTR_MF_GDS_DESC) LIKE '%SHOE%' ) 	" ).append("\n"); 
		query.append("				       THEN 'H1' " ).append("\n"); 
		query.append("			END HVC_H1               		" ).append("\n"); 
		query.append("		    FROM " ).append("\n"); 
		query.append("			BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("		    WHERE CM.BKG_NO = TMP.BKG_NO          " ).append("\n"); 
		query.append("			AND   CM.CNTR_NO = TMP.EQ_NO" ).append("\n"); 
		query.append("			AND   CM.CNTR_MF_SEQ = 1" ).append("\n"); 
		query.append("		 ) CM" ).append("\n"); 
		query.append("	  FROM TRS_TRSP_RAIL_BIL_ORD_TMP TMP," ).append("\n"); 
		query.append("		   BKG_CONTAINER BKG_CNTR" ).append("\n"); 
		query.append("	  WHERE BKG_CNTR.BKG_NO(+) = TMP.BKG_NO" ).append("\n"); 
		query.append("	  AND   BKG_CNTR.CNTR_NO(+) = TMP.EQ_NO" ).append("\n"); 
		query.append("	  AND	TMP.TRSP_RAIL_TMP_SEQ = @[trsp_rail_tmp_seq]" ).append("\n"); 
		query.append("	  ) X," ).append("\n"); 
		query.append("	  TRS_AGMT_HDR AGMT" ).append("\n"); 
		query.append("WHERE X.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD (+)" ).append("\n"); 
		query.append("AND   X.TRSP_AGMT_SEQ = AGMT.TRSP_AGMT_SEQ (+)" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("    X.TRSP_BND_CD," ).append("\n"); 
		query.append("    X.EQ_NO," ).append("\n"); 
		query.append("    X.EQ_TPSZ_CD," ).append("\n"); 
		query.append("    SUBSTR(X.POD_NOD_CD, 1, 5)," ).append("\n"); 
		query.append("    SUBSTR(X.POD_NOD_CD, 6)," ).append("\n"); 
		query.append("    SUBSTR(X.FM_NOD_CD, 1, 5)," ).append("\n"); 
		query.append("    SUBSTR(X.FM_NOD_CD, 6)," ).append("\n"); 
		query.append("    SUBSTR(X.TO_NOD_CD, 1, 5)," ).append("\n"); 
		query.append("    SUBSTR(X.TO_NOD_CD, 6)," ).append("\n"); 
		query.append("    CASE WHEN X.IBD_CSTMS_CLR_LOC_CD != X.FM_NOD_CD AND X.IBD_CSTMS_CLR_LOC_CD != X.TO_NOD_CD THEN '0'" ).append("\n"); 
		query.append("    ELSE ''" ).append("\n"); 
		query.append("    END," ).append("\n"); 
		query.append("    NVL(X.HVC, X.CM)," ).append("\n"); 
		query.append("    X.IBD_CSTMS_CLR_LOC_CD," ).append("\n"); 
		query.append("    X.DEL_SCC_CD," ).append("\n"); 
		query.append("    SUBSTR(X.DEL_NOD_CD, 1, 5)," ).append("\n"); 
		query.append("    SUBSTR(X.DEL_NOD_CD, 6)," ).append("\n"); 
		query.append("    X.BKG_NO," ).append("\n"); 
		query.append("    X.BL_NO," ).append("\n"); 
		query.append("    X.BKG_RCVDE_TERM_CD," ).append("\n"); 
		query.append("    X.CGO_TP_CD," ).append("\n"); 
		query.append("    SUBSTR(X.BKG_SPCL, 0, LENGTH(X.BKG_SPCL)-1)," ).append("\n"); 
		query.append("    CASE WHEN LENGTH(X.BKG_CNTR_SPCL) > 10 THEN" ).append("\n"); 
		query.append("			SUBSTR(X.BKG_CNTR_SPCL, 0, 10)" ).append("\n"); 
		query.append("		 ELSE" ).append("\n"); 
		query.append("			SUBSTR(X.BKG_CNTR_SPCL, 0, LENGTH(X.BKG_CNTR_SPCL)-1)" ).append("\n"); 
		query.append("	END," ).append("\n"); 
		query.append("    X.NVOCC_FILE_NO," ).append("\n"); 
		query.append("    X.BLCK_STWG_CD," ).append("\n"); 
		query.append("    SUBSTR(X.CSTMS_IBD, INSTR(X.CSTMS_IBD, '$', 1, 1) + 1)," ).append("\n"); 
		query.append("    DECODE(SUBSTR(X.BKG_CNTR, 1, INSTR(X.BKG_CNTR, '$', 1, 1) - 1), 'LBS'," ).append("\n"); 
		query.append("    SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1), 'KGM'," ).append("\n"); 
		query.append("    SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1)*2.2, 'KG'," ).append("\n"); 
		query.append("    SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1)*2.2, 'KGS'," ).append("\n"); 
		query.append("    SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1)*2.2, " ).append("\n"); 
		query.append("	DECODE(SUBSTR(X.FM_NOD_CD, 1, 2), 'CA', SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1)*2.2, " ).append("\n"); 
		query.append("												 'US', SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1))" ).append("\n"); 
		query.append("	)," ).append("\n"); 
		query.append("    SUBSTR(X.MDM_CO, INSTR(X.MDM_CO, '$', 1, 1) + 1)," ).append("\n"); 
		query.append("    X.ROUT_PLN_CD," ).append("\n"); 
		query.append("    X.VVD_CD," ).append("\n"); 
		query.append("    X.SLAN_CD," ).append("\n"); 
		query.append("    X.SC_NO," ).append("\n"); 
		query.append("    X.SHPR_CUST_NM," ).append("\n"); 
		query.append("    X.CNEE_CUST_NM," ).append("\n"); 
		query.append("    TO_CHAR(X.N1ST_NOD_PLN_DT, 'YYYYMMDD')," ).append("\n"); 
		query.append("    TO_CHAR(X.N1ST_NOD_PLN_DT, 'HH24:MI:SS')," ).append("\n"); 
		query.append("    TO_CHAR(X.LST_NOD_PLN_DT, 'YYYYMMDD')," ).append("\n"); 
		query.append("    TO_CHAR(X.LST_NOD_PLN_DT, 'HH24:MI:SS')," ).append("\n"); 
		query.append("    SUBSTR(X.CSTMS_IBD, 1, INSTR(X.CSTMS_IBD, '$', 1, 1) - 1)," ).append("\n"); 
		query.append("    SUBSTR(X.MDM_CO, 1, INSTR(X.MDM_CO, '$', 1, 1) - 1)," ).append("\n"); 
		query.append("    X.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("    X.CRE_USR_ID," ).append("\n"); 
		query.append("    X.UPD_USR_ID," ).append("\n"); 
		query.append("    X.RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("    X.COP_NO," ).append("\n"); 
		query.append("    X.COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("    X.ACT_GRP_CD," ).append("\n"); 
		query.append("    X.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("    X.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("    X.ROUT_SEQ," ).append("\n"); 
		query.append("    X.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("    X.INLND_ROUT_RMK," ).append("\n"); 
		query.append("    SUBSTR(POL_NOD_CD, 1, 5)," ).append("\n"); 
		query.append("	SUBSTR(POL_NOD_CD, 6)," ).append("\n"); 
		query.append("    SUBSTR(X.POR_NOD_CD, 1, 5)," ).append("\n"); 
		query.append("    SUBSTR(X.POR_NOD_CD, 6)," ).append("\n"); 
		query.append("    X.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("    X.CUST_CNT_CD," ).append("\n"); 
		query.append("    X.CUST_SEQ," ).append("\n"); 
		query.append("    X.POR_CD," ).append("\n"); 
		query.append("    X.DEL_CD," ).append("\n"); 
		query.append("    X.INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("    TO_CHAR(X.VD_DT, 'YYYYMMDDHH24:MI:SS')," ).append("\n"); 
		query.append("    X.TML_NOD_CD," ).append("\n"); 
		query.append("    SUBSTR(X.FM_NOD_CD, 1, 5)," ).append("\n"); 
		query.append("    SUBSTR(X.FM_NOD_CD, 6)," ).append("\n"); 
		query.append("    SUBSTR(X.TO_NOD_CD, 1, 5)," ).append("\n"); 
		query.append("    SUBSTR(X.TO_NOD_CD, 6)" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChargeCalculationDBDAODmtChgBkgCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAODmtChgBkgCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAODmtChgBkgCntrRSQL.Query
	  * </pre>
	  */
	public ChargeCalculationDBDAODmtChgBkgCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODmtChgBkgCntrRSQL").append("\n"); 
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
		query.append("#if (${bypodeta} == '')" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT B.BKG_NO" ).append("\n"); 
		query.append("	,B.BL_NO" ).append("\n"); 
		query.append("	,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("	,TO_CHAR(V.VPS_ETA_DT,'yyyy-mm-dd') AS VPS_ETA_DT" ).append("\n"); 
		query.append("	,TO_CHAR(V.VPS_ETB_DT,'yyyy-mm-dd') AS VPS_ETB_DT" ).append("\n"); 
		query.append("	,TO_CHAR(V.VPS_ETD_DT,'yyyy-mm-dd') AS VPS_ETD_DT" ).append("\n"); 
		query.append("	,BK.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("	,BK.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("	,B.POR_CD" ).append("\n"); 
		query.append("	,B.POL_CD" ).append("\n"); 
		query.append("	,B.POD_CD" ).append("\n"); 
		query.append("	,B.DEL_CD" ).append("\n"); 
		query.append("	,B.BKG_RCV_TERM_CD || '/' || B.BKG_DE_TERM_CD AS RD_TERM_CD" ).append("\n"); 
		query.append("	,BS.CUST_CNT_CD || TRIM(TO_CHAR(BS.CUST_SEQ, '000000')) SHIPPER_CD" ).append("\n"); 
		query.append("	,REPLACE(BS.CUST_NM, CHR(13)||CHR(10), ' ') SHIPPER_NM" ).append("\n"); 
		query.append("	,DECODE(BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000')), '000000', NULL, BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000'))) CNEE_CD" ).append("\n"); 
		query.append("	,REPLACE(BC.CUST_NM, CHR(13)||CHR(10), ' ') CNEE_NM" ).append("\n"); 
		query.append("	,DECODE(BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000')), '000000', NULL, BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000'))) NTFY_CD" ).append("\n"); 
		query.append("	,NVL(RTRIM(REPLACE(REPLACE(BN.CUST_NM, CHR(34), ''), CHR(13)||CHR(10), ' ')), '-') NTFY_NM" ).append("\n"); 
		query.append("	,DECODE(TRIM(TO_CHAR(C.VNDR_SEQ, '000000')), '000000', NULL, TRIM(TO_CHAR(C.VNDR_SEQ, '000000'))) AS  SVC_PROVDR_CD" ).append("\n"); 
		query.append("	,MV.VNDR_LGL_ENG_NM AS SVC_PROVDR_NM" ).append("\n"); 
		query.append("	,B.SC_NO" ).append("\n"); 
		query.append("	,B.RFA_NO" ).append("\n"); 
		query.append("	,DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')),'000000', NULL" ).append("\n"); 
		query.append("        	,BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) ) AS ACUST" ).append("\n"); 
		query.append("	,B.CMDT_CD" ).append("\n"); 
		query.append("	,(	SELECT CMDT_NM" ).append("\n"); 
		query.append("		FROM  MDM_COMMODITY" ).append("\n"); 
		query.append("		WHERE  CMDT_CD = B.CMDT_CD" ).append("\n"); 
		query.append("	) AS CMDT_NM," ).append("\n"); 
		query.append("	B.REP_CMDT_CD," ).append("\n"); 
		query.append("	(	SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("		FROM  MDM_REP_CMDT" ).append("\n"); 
		query.append("		WHERE  REP_CMDT_CD = B.REP_CMDT_CD" ).append("\n"); 
		query.append("	) AS REP_CMDT_NM" ).append("\n"); 
		query.append("	,B.SLS_OFC_CD" ).append("\n"); 
		query.append("	,(	SELECT  BDD.EVNT_OFC_CD                    " ).append("\n"); 
		query.append("	    FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("		    	BKG_DO_DTL BDD" ).append("\n"); 
		query.append("	    WHERE BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("	    AND   BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("	    AND   BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("	    AND ROWNUM = 1" ).append("\n"); 
		query.append("	) AS RLSE_OFC" ).append("\n"); 
		query.append("	,TO_CHAR((" ).append("\n"); 
		query.append("	SELECT  BDD.EVNT_DT" ).append("\n"); 
		query.append("	FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("    	    BKG_DO_DTL BDD" ).append("\n"); 
		query.append("	WHERE BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("	AND   BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("	AND   BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("	AND ROWNUM = 1),'YYYY-MM-DD HH24:MI'" ).append("\n"); 
		query.append("	) AS RLSE_DT" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("	SELECT 'Release'" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 
		query.append("	WHERE EXISTS (" ).append("\n"); 
		query.append("		SELECT  BDD.RLSE_STS_CD" ).append("\n"); 
		query.append("		FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("			BKG_DO_DTL BDD" ).append("\n"); 
		query.append("		WHERE BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("		AND   BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("		AND   BDD.RLSE_STS_CD IN ('R', 'I') )" ).append("\n"); 
		query.append("	) AS D_O" ).append("\n"); 
		query.append("	,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		CASE" ).append("\n"); 
		query.append("		WHEN DECODE(MAX(DOTL.BKG_NO), NULL, 'N', 'Y') = 'Y' AND" ).append("\n"); 
		query.append("			DECODE(MAX(DCTR.BKG_NO), NULL, 'N', 'Y') = 'N'  THEN 'Y'	-- DO_DTL에 존재하고  DO_CNTR_에 존재하지 않는 경우 'Y'" ).append("\n"); 
		query.append("		WHEN COUNT(DISTINCT DCTR.CNTR_NO) > 0 AND" ).append("\n"); 
		query.append("            MAX(NVL(DCTR.CNTR_NO, '_')) = '_' THEN 'P'					-- BKG_CNTR에 매핑되는 DO_CNTR에 NULL이 존재하는 경우" ).append("\n"); 
		query.append("		WHEN COUNT(DISTINCT DCTR.CNTR_NO) = 0 THEN 'N'					-- DO_CNTR에 존재하는 CNTR가 하나도 없는 경우" ).append("\n"); 
		query.append("		END" ).append("\n"); 
		query.append("	FROM BKG_CONTAINER BCTR" ).append("\n"); 
		query.append("	LEFT OUTER JOIN   BKG_DO_DTL DOTL" ).append("\n"); 
		query.append("		ON (BCTR.BKG_NO = DOTL.BKG_NO" ).append("\n"); 
		query.append("		AND DOTL.RLSE_STS_CD  IN ('R', 'I'))" ).append("\n"); 
		query.append("	LEFT OUTER JOIN BKG_DO_CNTR DCTR" ).append("\n"); 
		query.append("		ON (DCTR.BKG_NO = DOTL.BKG_NO" ).append("\n"); 
		query.append("		AND DCTR.RLSE_SEQ = DOTL.RLSE_SEQ" ).append("\n"); 
		query.append("		AND DCTR.CNTR_NO = BCTR.CNTR_NO)" ).append("\n"); 
		query.append("	WHERE BCTR.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	GROUP BY BCTR.BKG_NO" ).append("\n"); 
		query.append("	) PARTIAL" ).append("\n"); 
		query.append("#*" ).append("\n"); 
		query.append("	,'' SVR_ID" ).append("\n"); 
		query.append("	,'' CNTR_NO" ).append("\n"); 
		query.append("	,'' CNTR_CYC_NO" ).append("\n"); 
		query.append("	,'' VSL_CD" ).append("\n"); 
		query.append("	,'' SKD_VOY_NO" ).append("\n"); 
		query.append("	,'' SKD_DIR_CD" ).append("\n"); 
		query.append("	,'' DCGO_FLG" ).append("\n"); 
		query.append("	,'' RC_FLG" ).append("\n"); 
		query.append("	,'' BB_CGO_FLG" ).append("\n"); 
		query.append("	,'' AWK_CGO_FLG" ).append("\n"); 
		query.append("	,'' RD_CGO_FLG" ).append("\n"); 
		query.append("	,'' SOC_FLG" ).append("\n"); 
		query.append("	,'' CNTR_PRT_FLG" ).append("\n"); 
		query.append("	,'' ADV_SHTG_CD" ).append("\n"); 
		query.append("	,'' DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("	,'' DMDT_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	,'' BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	,'' BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	,'' BKG_CNTR_QTY" ).append("\n"); 
		query.append("	,'' RHQ_CD" ).append("\n"); 
		query.append("	,'' CRE_USR_ID" ).append("\n"); 
		query.append("	,'' CRE_OFC_CD" ).append("\n"); 
		query.append("	,'' UPD_USR_ID" ).append("\n"); 
		query.append("	,'' UPD_OFC_CD" ).append("\n"); 
		query.append("	,'' ESTM_TM_OF_ARR_DT" ).append("\n"); 
		query.append("	,'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,'' CUST_CNT_CD" ).append("\n"); 
		query.append("	,'' CUST_SEQ" ).append("\n"); 
		query.append("	,'' AR_ACT_CD" ).append("\n"); 
		query.append("*#" ).append("\n"); 
		query.append("     FROM  DMT_CHG_BKG_CNTR		B" ).append("\n"); 
		query.append("          ,DMT_CHG_CALC			C" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD		V" ).append("\n"); 
		query.append("          ,BKG_BOOKING			BK" ).append("\n"); 
		query.append("          ,MDM_VENDOR			MV" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER			BS" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER			BC" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER			BN" ).append("\n"); 
		query.append("     WHERE  B.SYS_AREA_GRP_ID	 =   C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("     AND    B.CNTR_NO            =   C.CNTR_NO" ).append("\n"); 
		query.append("     AND    B.CNTR_CYC_NO        =   C.CNTR_CYC_NO" ).append("\n"); 
		query.append("     AND    B.BKG_NO             =   BK.BKG_NO	 " ).append("\n"); 
		query.append("	 AND NOT(C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 AND    B.VSL_CD			 =   V.VSL_CD(+)" ).append("\n"); 
		query.append("	 AND    B.SKD_VOY_NO         =   V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("	 AND    B.SKD_DIR_CD         =   V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("	 AND	DECODE(SUBSTR(@[dmdt_trf_cd], 3, 1), 'I', B.POD_CD, B.POL_CD) = V.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("--AND    DECODE(SUBSTR('DMIF', 3, 1),'I', B.POD_CD, B.POL_CD) IS NOT NULL" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#if (${rhq_ofc_cd} != 'All')" ).append("\n"); 
		query.append("	AND	C.OFC_RHQ_CD			 =	 @[rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 AND    B.BKG_NO			 =	 BS.BKG_NO(+)" ).append("\n"); 
		query.append("	 AND    BS.BKG_CUST_TP_CD(+) =   'S'" ).append("\n"); 
		query.append("	 AND    B.BKG_NO             =   BC.BKG_NO(+)" ).append("\n"); 
		query.append("	 AND    BC.BKG_CUST_TP_CD(+) =   'C'" ).append("\n"); 
		query.append("	 AND    B.BKG_NO             =   BN.BKG_NO(+)" ).append("\n"); 
		query.append("	 AND    BN.BKG_CUST_TP_CD(+) =   'N'	 " ).append("\n"); 
		query.append("	 AND    B.BKG_NO             =   @[bkg_no]	 " ).append("\n"); 
		query.append("     AND    C.DMDT_TRF_CD        =	 @[dmdt_trf_cd]" ).append("\n"); 
		query.append("	 AND	C.DMDT_CHG_STS_CD   IN (" ).append("\n"); 
		query.append("			#foreach( $chg_sts_cd in ${chg_sts_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $chg_sts_cd_list.size()) '$chg_sts_cd', #else '$chg_sts_cd' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("     AND    C.VNDR_SEQ           =   MV.VNDR_SEQ (+)" ).append("\n"); 
		query.append("	 AND	C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	ORDER BY B.BL_NO" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bypodeta} == 'booking')" ).append("\n"); 
		query.append("    SELECT   BK.BKG_NO" ).append("\n"); 
		query.append("            ,BK.BL_NO" ).append("\n"); 
		query.append("            ,BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("            ,TO_CHAR(V.VPS_ETA_DT,'yyyy-mm-dd') AS VPS_ETA_DT" ).append("\n"); 
		query.append("            ,TO_CHAR(V.VPS_ETB_DT,'yyyy-mm-dd') AS VPS_ETB_DT" ).append("\n"); 
		query.append("            ,TO_CHAR(V.VPS_ETD_DT,'yyyy-mm-dd') AS VPS_ETD_DT" ).append("\n"); 
		query.append("			,BK.POR_CD	AS POR_CD" ).append("\n"); 
		query.append("			,BK.POL_CD	AS POL_CD" ).append("\n"); 
		query.append("			,BK.POD_CD	AS POD_CD" ).append("\n"); 
		query.append("			,BK.DEL_CD	AS DEL_CD" ).append("\n"); 
		query.append("            ,BK.RCV_TERM_CD || '/' || BK.DE_TERM_CD AS RD_TERM_CD                        " ).append("\n"); 
		query.append("            ,BCS.CUST_CNT_CD || TRIM(TO_CHAR(BCS.CUST_SEQ, '000000')) SHIPPER_CD" ).append("\n"); 
		query.append("            ,REPLACE(BCS.CUST_NM, CHR(13)||CHR(10),' ') SHIPPER_NM" ).append("\n"); 
		query.append("            ,DECODE(BCC.CUST_CNT_CD || TRIM(TO_CHAR(BCC.CUST_SEQ, '000000')), '000000', NULL, BCC.CUST_CNT_CD || TRIM(TO_CHAR(BCC.CUST_SEQ, '000000'))) CNEE_CD" ).append("\n"); 
		query.append("            ,REPLACE(BCC.CUST_NM, CHR(13)||CHR(10),' ') CNEE_NM" ).append("\n"); 
		query.append("            ,DECODE(BCCN.CUST_CNT_CD || TRIM(TO_CHAR(BCCN.CUST_SEQ, '000000')), '000000', NULL, BCCN.CUST_CNT_CD || TRIM(TO_CHAR(BCCN.CUST_SEQ, '000000'))) NTFY_CD" ).append("\n"); 
		query.append("            ,NVL(RTRIM(REPLACE(REPLACE(BCCN.CUST_NM, CHR(34), ''), CHR(13)||CHR(10),' ')),'-') NTFY_NM" ).append("\n"); 
		query.append("            ,BK.SC_NO" ).append("\n"); 
		query.append("            ,BK.RFA_NO" ).append("\n"); 
		query.append("			,DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')),'000000', NULL" ).append("\n"); 
		query.append("        			,BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) ) AS ACUST" ).append("\n"); 
		query.append("			,BK.CMDT_CD" ).append("\n"); 
		query.append("			,(	SELECT CMDT_NM" ).append("\n"); 
		query.append("				FROM  MDM_COMMODITY" ).append("\n"); 
		query.append("				WHERE  CMDT_CD = BK.CMDT_CD" ).append("\n"); 
		query.append("			) AS CMDT_NM" ).append("\n"); 
		query.append("			,BK.REP_CMDT_CD" ).append("\n"); 
		query.append("			,(	SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("				FROM  MDM_REP_CMDT" ).append("\n"); 
		query.append("				WHERE  REP_CMDT_CD = BK.REP_CMDT_CD" ).append("\n"); 
		query.append("			) AS REP_CMDT_NM" ).append("\n"); 
		query.append("			,BK.OB_SLS_OFC_CD SLS_OFC_CD" ).append("\n"); 
		query.append("			,(	SELECT  I.ACT_CUST_CNT_CD || TRIM(TO_CHAR(ACT_CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("    			FROM    INV_AR_MN I" ).append("\n"); 
		query.append("    			WHERE   I.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("    			AND     I.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("				AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    	SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    	FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    	WHERE	BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                    	AND		IO_BND_CD = 'I'" ).append("\n"); 
		query.append("    	            	)" ).append("\n"); 
		query.append("				AND     ROWNUM  = 1" ).append("\n"); 
		query.append("			) AS AR_ACT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM     BKG_BOOKING        BK," ).append("\n"); 
		query.append("             BKG_CUSTOMER       BCS," ).append("\n"); 
		query.append("             BKG_CUSTOMER       BCC," ).append("\n"); 
		query.append("             BKG_CUSTOMER       BCCN," ).append("\n"); 
		query.append("             BKG_CONTAINER      BCN," ).append("\n"); 
		query.append("             BKG_VVD            BV," ).append("\n"); 
		query.append("             VSK_VSL_PORT_SKD   V" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("		BK.BKG_NO				= BCN.BKG_NO" ).append("\n"); 
		query.append("	AND	BV.VSL_CD				= V.VSL_CD(+)" ).append("\n"); 
		query.append("	AND	BV.SKD_VOY_NO			= V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("	AND	BV.SKD_DIR_CD			= V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("	AND	BV.POD_CD				= V.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("    AND	BK.BKG_NO				= BCS.BKG_NO(+)" ).append("\n"); 
		query.append("    AND	BCS.BKG_CUST_TP_CD(+)	= 'S'" ).append("\n"); 
		query.append("    AND	BK.BKG_NO				= BCC.BKG_NO(+)" ).append("\n"); 
		query.append("    AND	BCC.BKG_CUST_TP_CD(+)	= 'C'" ).append("\n"); 
		query.append("    AND	BK.BKG_NO				= BCCN.BKG_NO(+)" ).append("\n"); 
		query.append("    AND	BCCN.BKG_CUST_TP_CD(+)	= 'N'" ).append("\n"); 
		query.append("    AND	BK.BKG_NO				= BV.BKG_NO" ).append("\n"); 
		query.append("    AND	BK.POD_CD				= BV.POD_CD" ).append("\n"); 
		query.append("    AND	BK.DE_TERM_CD			<> 'T'" ).append("\n"); 
		query.append("    AND	BK.BKG_STS_CD			NOT IN ('S', 'X')" ).append("\n"); 
		query.append("	AND BK.BKG_CGO_TP_CD		= 'F'" ).append("\n"); 
		query.append("	AND BCN.DE_TERM_CD			IN ('D', 'H', 'O', 'M', 'Y')" ).append("\n"); 
		query.append("	AND	BK.BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("	AND	ROWNUM = 1" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("##" ).append("\n"); 

	}
}
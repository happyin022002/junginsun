/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeBySZPBBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchChargeBySZPBBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeBySZPBBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_provdr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeBySZPBBRSQL").append("\n"); 
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
		query.append("	C.SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append("    --,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("	,'' AS DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("    ,C.CNTR_NO    " ).append("\n"); 
		query.append("    ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("    ,C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("    ,C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("    --,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("	,'' AS DMDT_TRF_CD" ).append("\n"); 
		query.append("    ,C.FT_DYS" ).append("\n"); 
		query.append("    ,C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FT_CMNC_DT, 'YYYYMMDD') FT_CMNC_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FT_END_DT, 'YYYYMMDD') FT_END_DT" ).append("\n"); 
		query.append("    ,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("    --,C.ORG_CHG_AMT" ).append("\n"); 
		query.append("    --,C.SC_RFA_EXPT_AMT    " ).append("\n"); 
		query.append("    --,C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("    ,C.BIL_AMT" ).append("\n"); 
		query.append("    ,B.BKG_NO" ).append("\n"); 
		query.append("    ,B.BL_NO" ).append("\n"); 
		query.append("    ,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD_CD    " ).append("\n"); 
		query.append("    ,( SELECT	V.VSL_SLAN_CD LANE   " ).append("\n"); 
		query.append("       FROM		VSK_VSL_SKD V" ).append("\n"); 
		query.append("       WHERE	B.VSL_CD		=	V.VSL_CD" ).append("\n"); 
		query.append("       AND		B.SKD_VOY_NO	=	V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND		B.SKD_DIR_CD	=	V.SKD_DIR_CD" ).append("\n"); 
		query.append("    ) AS LANE" ).append("\n"); 
		query.append("    ,B.POR_CD" ).append("\n"); 
		query.append("    ,B.POL_CD" ).append("\n"); 
		query.append("    ,B.POD_CD" ).append("\n"); 
		query.append("    ,B.DEL_CD" ).append("\n"); 
		query.append("    ,B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("    ,B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    ,B.SC_NO" ).append("\n"); 
		query.append("    ,B.RFA_NO" ).append("\n"); 
		query.append("    ,DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')),'000000', NULL" ).append("\n"); 
		query.append("        	,BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) ) AS ACUST	" ).append("\n"); 
		query.append("    --,DECODE(C.CHG_SEQ, 1, 'G', 'B') AS CHG_TYPE" ).append("\n"); 
		query.append("	,C.CHG_SEQ" ).append("\n"); 
		query.append("	,NVL(B.SOC_FLG, 'N') AS SOC_FLG    " ).append("\n"); 
		query.append("	,(	SELECT 'Y'" ).append("\n"); 
		query.append("    	FROM DUAL      " ).append("\n"); 
		query.append("    	WHERE EXISTS (" ).append("\n"); 
		query.append("    		SELECT  BDD.RLSE_STS_CD" ).append("\n"); 
		query.append("    		FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("            		BKG_DO_DTL BDD" ).append("\n"); 
		query.append("    		WHERE BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("   			AND   BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("    			AND   BDD.RLSE_STS_CD IN ('R', 'I')) ) AS D_O" ).append("\n"); 
		query.append("	,(	SELECT  BDD.EVNT_OFC_CD" ).append("\n"); 
		query.append("    	FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("        	    BKG_DO_DTL BDD" ).append("\n"); 
		query.append("    	WHERE	BDO.BKG_NO	= BDD.BKG_NO   " ).append("\n"); 
		query.append("    		AND BDO.BKG_NO	= B.BKG_NO   " ).append("\n"); 
		query.append("    		AND BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("			AND	ROWNUM=1 ) AS RLSE_OFC" ).append("\n"); 
		query.append("	--,NVL(C.OFC_TRNS_FLG, 'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append("	,(	SELECT 'C'" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("    	WHERE EXISTS (" ).append("\n"); 
		query.append("    		SELECT 1" ).append("\n"); 
		query.append("    		FROM	BKG_ROLL_OVR R" ).append("\n"); 
		query.append("    		WHERE	R.BKG_NO = B.BKG_NO    			" ).append("\n"); 
		query.append("    			AND R.ROLL_OVR_RSN_CD IN ( 'C','H' )) ) AS ROLL_OVR	" ).append("\n"); 
		query.append("    ,C.WEB_IND_FLG" ).append("\n"); 
		query.append("    ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("    ,C.DMDT_CHG_LOC_DIV_CD	" ).append("\n"); 
		query.append("	,C.OFC_CD" ).append("\n"); 
		query.append("	,C.OFC_RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' AS DMDT_INV_NO" ).append("\n"); 
		query.append("	,'' AS ISS_DT" ).append("\n"); 
		query.append("	,'' AS INV_CURR_CD" ).append("\n"); 
		query.append("	,NULL AS INV_CHG_AMT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,DECODE( C.ACT_CNT_CD || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')" ).append("\n"); 
		query.append("			,'000000' , NULL, C.ACT_CNT_CD || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')) PAYER_CD" ).append("\n"); 
		query.append("	,CASE" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD='DTIC' AND B.BKG_DE_TERM_CD='Y' AND INSTR(NVL(B.POD_CD,'  '),'US')=1 THEN" ).append("\n"); 
		query.append("		(	SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	   		FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	   		WHERE MV.VNDR_SEQ = C.VNDR_SEQ	)" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD='DTOC' AND B.BKG_RCV_TERM_CD='Y' AND INSTR(NVL(B.POL_CD,'  '),'US')=1 THEN" ).append("\n"); 
		query.append("		(	SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("			FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	   		WHERE MV.VNDR_SEQ = C.VNDR_SEQ	)" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD IN ('DMIF','CTIC') OR (C.DMDT_TRF_CD='DTIC' AND INSTR(NVL(B.POD_CD,'  '),'US')<>1) THEN" ).append("\n"); 
		query.append("		(	SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("			FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("			WHERE MC.CUST_CNT_CD = C.ACT_CNT_CD" ).append("\n"); 
		query.append("			AND MC.CUST_SEQ = C.ACT_CUST_SEQ	)" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD IN ('DMOF','CTOC') OR (C.DMDT_TRF_CD='DTOC' AND INSTR(NVL(B.POL_CD,'  '),'US')<>1) THEN" ).append("\n"); 
		query.append("			REPLACE(BS.CUST_NM, CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("	END AS PAYER_NM" ).append("\n"); 
		query.append("    ,BS.CUST_CNT_CD || TRIM(TO_CHAR(BS.CUST_SEQ, '000000')) SHIPPER_CD " ).append("\n"); 
		query.append("    ,REPLACE(BS.CUST_NM, CHR(13) || CHR(10), ' ') SHIPPER_NM   " ).append("\n"); 
		query.append("    ,DECODE(BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000')), '000000', NULL, BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000'))) CNEE_CD" ).append("\n"); 
		query.append("    ,REPLACE(BC.CUST_NM, CHR(13) || CHR(10), ' ') CNEE_NM" ).append("\n"); 
		query.append("    ,DECODE(BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000')), '000000', NULL, BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000'))) NTFY_CD" ).append("\n"); 
		query.append("    ,NVL(RTRIM(REPLACE(REPLACE(BN.CUST_NM, '\"', ''), CHR(13)||CHR(10), ' ')), '-') NTFY_NM" ).append("\n"); 
		query.append("	,(	SELECT  I.ACT_CUST_CNT_CD || TRIM(TO_CHAR(ACT_CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("    	FROM    INV_AR_MN I" ).append("\n"); 
		query.append("    	WHERE   I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    	AND     I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("		AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("    	            )" ).append("\n"); 
		query.append("		AND     ROWNUM  = 1" ).append("\n"); 
		query.append("	) AS AR_ACT_CD" ).append("\n"); 
		query.append("	,(	SELECT	MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("		FROM 	MDM_CUSTOMER MC, INV_AR_MN I" ).append("\n"); 
		query.append("		WHERE	MC.CUST_CNT_CD = I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("		AND		MC.CUST_SEQ    = I.ACT_CUST_SEQ" ).append("\n"); 
		query.append("		AND		I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		AND		I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("		AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("    	            )" ).append("\n"); 
		query.append("		AND		ROWNUM  = 1" ).append("\n"); 
		query.append("	) AS AR_ACT_NM" ).append("\n"); 
		query.append("	,DECODE(TRIM(TO_CHAR(C.VNDR_SEQ, '000000')), '000000', NULL, TRIM(TO_CHAR(C.VNDR_SEQ, '000000'))) AS SVC_PROVDR_CD" ).append("\n"); 
		query.append("	,(SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	   FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	   WHERE MV.VNDR_SEQ = C.VNDR_SEQ)   AS SVC_PROVDR_NM" ).append("\n"); 
		query.append("	,B.CMDT_CD" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("		SELECT  CMDT_NM" ).append("\n"); 
		query.append("        FROM    MDM_COMMODITY" ).append("\n"); 
		query.append("        WHERE   CMDT_CD = B.CMDT_CD" ).append("\n"); 
		query.append("	) AS CMDT_NM" ).append("\n"); 
		query.append("	,C.CORR_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR    B" ).append("\n"); 
		query.append("        ,DMT_CHG_CALC       C" ).append("\n"); 
		query.append("        ,BKG_BOOKING        BK" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER       BS" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER       BC" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER       BN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  B.SYS_AREA_GRP_ID	=   C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND    B.CNTR_NO            =   C.CNTR_NO" ).append("\n"); 
		query.append("AND    B.CNTR_CYC_NO        =   C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND    B.BKG_NO             =   BK.BKG_NO" ).append("\n"); 
		query.append("AND    C.OFC_CD             =   'SZPSC'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DMOF') " ).append("\n"); 
		query.append("AND    C.DMDT_TRF_CD        =	'DMOF'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND    C.DMDT_TRF_CD        =	'CTIC'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("AND    C.SUTH_CHN_DEM_KEY_NO IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    B.BKG_NO				=	BS.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BS.BKG_CUST_TP_CD(+) =   'S'" ).append("\n"); 
		query.append("AND    B.BKG_NO             =   BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BC.BKG_CUST_TP_CD(+) =   'C'" ).append("\n"); 
		query.append("AND    B.BKG_NO            	=   BN.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BN.BKG_CUST_TP_CD(+) =   'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DMOF') " ).append("\n"); 
		query.append("AND    C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'N', 'D', 'E')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'date')" ).append("\n"); 
		query.append("	#if (${dmdt_trf_cd} == 'DMOF')" ).append("\n"); 
		query.append("		AND	   C.TO_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append("            					AND TO_DATE(@[to_mvmt_dt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	   C.FM_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append("        		    			AND TO_DATE(@[to_mvmt_dt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${fm_mvmt_yd_cd} != '')" ).append("\n"); 
		query.append("		##${fm_mvmt_yd_cd}" ).append("\n"); 
		query.append("		#if ($fm_mvmt_yd_cd.length() == 5)" ).append("\n"); 
		query.append("			AND SUBSTR(C.FM_MVMT_YD_CD, 1, 5) = @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND C.FM_MVMT_YD_CD = @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#elseif (${to_mvmt_yd_cd} != '')" ).append("\n"); 
		query.append("		##${to_mvmt_yd_cd}" ).append("\n"); 
		query.append("		#if ($to_mvmt_yd_cd.length() == 5)" ).append("\n"); 
		query.append("			AND SUBSTR(C.TO_MVMT_YD_CD,1, 5) = @[to_mvmt_yd_cd]" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND C.TO_MVMT_YD_CD = @[to_mvmt_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	--AND C.DMDT_CHG_STS_CD NOT IN ('D','N','U','I','C')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'vvd_cd')" ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("	AND (	B.VSL_CD = SUBSTR(@[vvd_cd],1,4) " ).append("\n"); 
		query.append("		AND B.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4) " ).append("\n"); 
		query.append("		AND B.SKD_DIR_CD = SUBSTR(@[vvd_cd],9) " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${pod_cd} != '' || ${pol_cd} != '')" ).append("\n"); 
		query.append("	AND (1=0" ).append("\n"); 
		query.append("		#if (${pod_cd} != '')" ).append("\n"); 
		query.append("		OR B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pol_cd} != '')" ).append("\n"); 
		query.append("		OR B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'cntr')" ).append("\n"); 
		query.append("	#if (${bkg_no} != '')	" ).append("\n"); 
		query.append("	AND B.BKG_NO IN (" ).append("\n"); 
		query.append("		#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bl_no} != '')" ).append("\n"); 
		query.append("	AND B.BL_NO IN (" ).append("\n"); 
		query.append("		#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $bl_no_list.size()) '$bl_cd', #else '$bl_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cntr_no} != '')" ).append("\n"); 
		query.append("	AND C.CNTR_NO IN (" ).append("\n"); 
		query.append("		#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cd} != '')" ).append("\n"); 
		query.append("	#if (${cust_type} == '')" ).append("\n"); 
		query.append("	AND (" ).append("\n"); 
		query.append("				C.ACT_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND C.ACT_CUST_SEQ	= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("		OR		BS.CUST_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND BS.CUST_SEQ		= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("		OR		BC.CUST_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND BC.CUST_SEQ		= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("		OR 		BN.CUST_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND BN.CUST_SEQ		= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("		OR(" ).append("\n"); 
		query.append("			EXISTS (" ).append("\n"); 
		query.append("    		SELECT  'X'" ).append("\n"); 
		query.append("    		FROM    INV_AR_MN I" ).append("\n"); 
		query.append("    		WHERE   I.BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("    		AND     I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("			AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    				SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    				FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    				WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    				AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("								  )" ).append("\n"); 
		query.append("			AND     ROWNUM  = 1" ).append("\n"); 
		query.append("			AND     I.ACT_CUST_CNT_CD   = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND     I.ACT_CUST_SEQ      = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'P')" ).append("\n"); 
		query.append("		AND C.ACT_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("		AND C.ACT_CUST_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'S') " ).append("\n"); 
		query.append("		AND BS.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("		AND BS.CUST_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'C') " ).append("\n"); 
		query.append("		AND BC.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("		AND BC.CUST_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'N') " ).append("\n"); 
		query.append("		AND BN.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("		AND BN.CUST_SEQ  = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'A')		" ).append("\n"); 
		query.append("		AND EXISTS (" ).append("\n"); 
		query.append("    		SELECT  'X'" ).append("\n"); 
		query.append("    		FROM    INV_AR_MN I" ).append("\n"); 
		query.append("    		WHERE   I.BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("    		AND     I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("			AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    				SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    				FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    				WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    				AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("								  )" ).append("\n"); 
		query.append("			AND     ROWNUM  = 1" ).append("\n"); 
		query.append("			AND     I.ACT_CUST_CNT_CD   = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND     I.ACT_CUST_SEQ      = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${svc_provdr} != '') " ).append("\n"); 
		query.append("AND C.VNDR_SEQ = LTRIM(@[svc_provdr],'0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sc_no} != '') " ).append("\n"); 
		query.append("AND B.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rfa_no} != '') " ).append("\n"); 
		query.append("AND B.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	C.SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append("    ,C.DMDT_CHG_STS_CD	" ).append("\n"); 
		query.append("    ,C.CNTR_NO    " ).append("\n"); 
		query.append("    ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("    ,C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("    ,C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("    ,C.FT_DYS" ).append("\n"); 
		query.append("    ,C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FT_CMNC_DT, 'YYYYMMDD') FT_CMNC_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FT_END_DT, 'YYYYMMDD') FT_END_DT" ).append("\n"); 
		query.append("    ,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("    --,C.ORG_CHG_AMT" ).append("\n"); 
		query.append("    --,C.SC_RFA_EXPT_AMT    " ).append("\n"); 
		query.append("    --,C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("    ,C.BIL_AMT" ).append("\n"); 
		query.append("    ,B.BKG_NO" ).append("\n"); 
		query.append("    ,B.BL_NO" ).append("\n"); 
		query.append("    ,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD_CD    " ).append("\n"); 
		query.append("    ,( SELECT	V.VSL_SLAN_CD LANE   " ).append("\n"); 
		query.append("       FROM		VSK_VSL_SKD V" ).append("\n"); 
		query.append("       WHERE	B.VSL_CD		=	V.VSL_CD" ).append("\n"); 
		query.append("       AND		B.SKD_VOY_NO	=	V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND		B.SKD_DIR_CD	=	V.SKD_DIR_CD" ).append("\n"); 
		query.append("    ) AS LANE" ).append("\n"); 
		query.append("    ,B.POR_CD" ).append("\n"); 
		query.append("    ,B.POL_CD" ).append("\n"); 
		query.append("    ,B.POD_CD" ).append("\n"); 
		query.append("    ,B.DEL_CD" ).append("\n"); 
		query.append("    ,B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("    ,B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    ,B.SC_NO" ).append("\n"); 
		query.append("    ,B.RFA_NO" ).append("\n"); 
		query.append("    ,DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')),'000000', NULL" ).append("\n"); 
		query.append("        	,BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) ) AS ACUST	" ).append("\n"); 
		query.append("    --,DECODE(C.CHG_SEQ, 1, 'G', 'B') AS CHG_TYPE" ).append("\n"); 
		query.append("	,C.CHG_SEQ" ).append("\n"); 
		query.append("	,NVL(B.SOC_FLG, 'N') AS SOC_FLG    " ).append("\n"); 
		query.append("	,(	SELECT 'Y'" ).append("\n"); 
		query.append("    	FROM DUAL      " ).append("\n"); 
		query.append("    	WHERE EXISTS (" ).append("\n"); 
		query.append("    		SELECT  BDD.RLSE_STS_CD" ).append("\n"); 
		query.append("    		FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("            		BKG_DO_DTL BDD" ).append("\n"); 
		query.append("    		WHERE BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("   			AND   BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("    			AND   BDD.RLSE_STS_CD IN ('R', 'I')) ) AS D_O" ).append("\n"); 
		query.append("	,(	SELECT  BDD.EVNT_OFC_CD" ).append("\n"); 
		query.append("    	FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("        	    BKG_DO_DTL BDD" ).append("\n"); 
		query.append("    	WHERE	BDO.BKG_NO	= BDD.BKG_NO   " ).append("\n"); 
		query.append("    		AND BDO.BKG_NO	= B.BKG_NO   " ).append("\n"); 
		query.append("    		AND BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("			AND	ROWNUM=1 ) AS RLSE_OFC" ).append("\n"); 
		query.append("	--,NVL(C.OFC_TRNS_FLG, 'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append("	,(	SELECT 'C'" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("    	WHERE EXISTS (" ).append("\n"); 
		query.append("    		SELECT 1" ).append("\n"); 
		query.append("    		FROM	BKG_ROLL_OVR R" ).append("\n"); 
		query.append("    		WHERE	R.BKG_NO = B.BKG_NO    			" ).append("\n"); 
		query.append("    			AND R.ROLL_OVR_RSN_CD IN ( 'C','H' )) ) AS ROLL_OVR	" ).append("\n"); 
		query.append("    ,C.WEB_IND_FLG" ).append("\n"); 
		query.append("    ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("    ,C.DMDT_CHG_LOC_DIV_CD	" ).append("\n"); 
		query.append("	,C.OFC_CD" ).append("\n"); 
		query.append("	,C.OFC_RHQ_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,C.DMDT_INV_NO" ).append("\n"); 
		query.append("	,(	" ).append("\n"); 
		query.append("		SELECT	TO_CHAR(IM.CRE_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("		FROM	DMT_INV_MN  IM," ).append("\n"); 
		query.append("				DMT_INV_DTL ID" ).append("\n"); 
		query.append("		WHERE   IM.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("		AND	IM.DMDT_INV_NO      = ID.DMDT_INV_NO" ).append("\n"); 
		query.append("		AND	IM.CRE_OFC_CD       = ID.CRE_OFC_CD" ).append("\n"); 
		query.append("		AND IM.DMDT_INV_STS_CD  = 'I'" ).append("\n"); 
		query.append("		AND C.SYS_AREA_GRP_ID = ID.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		AND C.CNTR_NO 		= ID.CNTR_NO" ).append("\n"); 
		query.append("		AND C.CNTR_CYC_NO 	= ID.CNTR_CYC_NO" ).append("\n"); 
		query.append("		AND C.DMDT_TRF_CD 	= ID.DMDT_TRF_CD" ).append("\n"); 
		query.append("		AND C.DMDT_CHG_LOC_DIV_CD = ID.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("		AND C.CHG_SEQ = ID.CHG_SEQ " ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("	) AS ISS_DT" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("		SELECT	IM.INV_CURR_CD" ).append("\n"); 
		query.append("		FROM    DMT_INV_MN  IM," ).append("\n"); 
		query.append("				DMT_INV_DTL ID" ).append("\n"); 
		query.append("		WHERE   IM.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("		AND IM.DMDT_INV_NO      = ID.DMDT_INV_NO" ).append("\n"); 
		query.append("		AND IM.CRE_OFC_CD       = ID.CRE_OFC_CD" ).append("\n"); 
		query.append("		AND IM.DMDT_INV_STS_CD  = 'I'" ).append("\n"); 
		query.append("		AND C.SYS_AREA_GRP_ID = ID.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		AND C.CNTR_NO 		= ID.CNTR_NO" ).append("\n"); 
		query.append("		AND C.CNTR_CYC_NO 	= ID.CNTR_CYC_NO" ).append("\n"); 
		query.append("		AND C.DMDT_TRF_CD 	= ID.DMDT_TRF_CD" ).append("\n"); 
		query.append("		AND C.DMDT_CHG_LOC_DIV_CD = ID.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("		AND C.CHG_SEQ = ID.CHG_SEQ" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("	) AS INV_CURR_CD" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("		SELECT	ID.CNTR_INV_AMT" ).append("\n"); 
		query.append("		FROM    DMT_INV_MN  IM," ).append("\n"); 
		query.append("				DMT_INV_DTL ID" ).append("\n"); 
		query.append("		WHERE   IM.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("		AND IM.DMDT_INV_NO      = ID.DMDT_INV_NO" ).append("\n"); 
		query.append("		AND IM.CRE_OFC_CD       = ID.CRE_OFC_CD" ).append("\n"); 
		query.append("		AND IM.DMDT_INV_STS_CD  = 'I'" ).append("\n"); 
		query.append("		AND C.SYS_AREA_GRP_ID = ID.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		AND C.CNTR_NO 		= ID.CNTR_NO" ).append("\n"); 
		query.append("		AND C.CNTR_CYC_NO 	= ID.CNTR_CYC_NO" ).append("\n"); 
		query.append("		AND C.DMDT_TRF_CD 	= ID.DMDT_TRF_CD" ).append("\n"); 
		query.append("		AND C.DMDT_CHG_LOC_DIV_CD = ID.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("		AND C.CHG_SEQ = ID.CHG_SEQ" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("    ) AS INV_CHG_AMT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,DECODE( C.ACT_CNT_CD || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')" ).append("\n"); 
		query.append("			,'000000' , NULL, C.ACT_CNT_CD || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')) PAYER_CD" ).append("\n"); 
		query.append("	,CASE	" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD='DTIC' AND B.BKG_DE_TERM_CD='Y' AND INSTR(NVL(B.POD_CD,'  '),'US')=1 THEN" ).append("\n"); 
		query.append("		(	SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	   		FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	   		WHERE MV.VNDR_SEQ = C.VNDR_SEQ	)" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD='DTOC' AND B.BKG_RCV_TERM_CD='Y' AND INSTR(NVL(B.POL_CD,'  '),'US')=1 THEN" ).append("\n"); 
		query.append("		(	SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("			FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	   		WHERE MV.VNDR_SEQ = C.VNDR_SEQ	)" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD IN ('DMIF','CTIC') OR (C.DMDT_TRF_CD='DTIC' AND INSTR(NVL(B.POD_CD,'  '),'US')<>1) THEN" ).append("\n"); 
		query.append("		(	SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("			FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("			WHERE MC.CUST_CNT_CD = C.ACT_CNT_CD" ).append("\n"); 
		query.append("			AND MC.CUST_SEQ = C.ACT_CUST_SEQ	)" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD IN ('DMOF','CTOC') OR (C.DMDT_TRF_CD='DTOC' AND INSTR(NVL(B.POL_CD,'  '),'US')<>1) THEN" ).append("\n"); 
		query.append("			REPLACE(BS.CUST_NM, CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("	END AS PAYER_NM" ).append("\n"); 
		query.append("    ,BS.CUST_CNT_CD || TRIM(TO_CHAR(BS.CUST_SEQ, '000000')) SHIPPER_CD " ).append("\n"); 
		query.append("    ,REPLACE(BS.CUST_NM, CHR(13) || CHR(10), ' ') SHIPPER_NM   " ).append("\n"); 
		query.append("    ,DECODE(BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000')), '000000', NULL, BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000'))) CNEE_CD" ).append("\n"); 
		query.append("    ,REPLACE(BC.CUST_NM, CHR(13) || CHR(10), ' ') CNEE_NM" ).append("\n"); 
		query.append("    ,DECODE(BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000')), '000000', NULL, BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000'))) NTFY_CD" ).append("\n"); 
		query.append("    ,NVL(RTRIM(REPLACE(REPLACE(BN.CUST_NM, '\"', ''), CHR(13)||CHR(10), ' ')), '-') NTFY_NM" ).append("\n"); 
		query.append("	,(	SELECT  I.ACT_CUST_CNT_CD || TRIM(TO_CHAR(ACT_CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("    	FROM    INV_AR_MN I" ).append("\n"); 
		query.append("    	WHERE   I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    	AND     I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("		AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("    	            )" ).append("\n"); 
		query.append("		AND     ROWNUM  = 1" ).append("\n"); 
		query.append("	) AS AR_ACT_CD" ).append("\n"); 
		query.append("	,(	SELECT	MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("		FROM 	MDM_CUSTOMER MC, INV_AR_MN I" ).append("\n"); 
		query.append("		WHERE	MC.CUST_CNT_CD = I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("		AND		MC.CUST_SEQ    = I.ACT_CUST_SEQ" ).append("\n"); 
		query.append("		AND		I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		AND		I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("		AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("    	            )" ).append("\n"); 
		query.append("		AND		ROWNUM  = 1" ).append("\n"); 
		query.append("	) AS AR_ACT_NM" ).append("\n"); 
		query.append("	,DECODE(TRIM(TO_CHAR(C.VNDR_SEQ, '000000')), '000000', NULL, TRIM(TO_CHAR(C.VNDR_SEQ, '000000'))) AS SVC_PROVDR_CD" ).append("\n"); 
		query.append("	,(SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	   FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	   WHERE MV.VNDR_SEQ = C.VNDR_SEQ)   AS SVC_PROVDR_NM" ).append("\n"); 
		query.append("	,B.CMDT_CD" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("		SELECT  CMDT_NM" ).append("\n"); 
		query.append("        FROM    MDM_COMMODITY" ).append("\n"); 
		query.append("        WHERE   CMDT_CD = B.CMDT_CD" ).append("\n"); 
		query.append("	) AS CMDT_NM" ).append("\n"); 
		query.append("	,C.CORR_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR    B" ).append("\n"); 
		query.append("        ,DMT_CHG_CALC       C" ).append("\n"); 
		query.append("        ,BKG_BOOKING        BK" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER       BS" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER       BC" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER       BN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  B.SYS_AREA_GRP_ID	=   C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND    B.CNTR_NO            =   C.CNTR_NO" ).append("\n"); 
		query.append("AND    B.CNTR_CYC_NO        =   C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND    B.BKG_NO             =   BK.BKG_NO" ).append("\n"); 
		query.append("AND    C.OFC_CD             =   'SZPSC'" ).append("\n"); 
		query.append("AND    C.DMDT_TRF_CD        =	@[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND    C.DMDT_CHG_LOC_DIV_CD =  'SZP'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    B.BKG_NO				=	BS.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BS.BKG_CUST_TP_CD(+) =   'S'" ).append("\n"); 
		query.append("AND    B.BKG_NO             =   BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BC.BKG_CUST_TP_CD(+) =   'C'" ).append("\n"); 
		query.append("AND    B.BKG_NO            	=   BN.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BN.BKG_CUST_TP_CD(+) =   'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DMOF') " ).append("\n"); 
		query.append("AND    C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'N', 'D', 'E')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'date')" ).append("\n"); 
		query.append("	#if (${dmdt_trf_cd} == 'DMOF')" ).append("\n"); 
		query.append("		AND	   C.TO_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append("            					AND TO_DATE(@[to_mvmt_dt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	   C.FM_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append("        		    			AND TO_DATE(@[to_mvmt_dt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${fm_mvmt_yd_cd} != '')" ).append("\n"); 
		query.append("		##${fm_mvmt_yd_cd}" ).append("\n"); 
		query.append("		#if ($fm_mvmt_yd_cd.length() == 5)" ).append("\n"); 
		query.append("			AND SUBSTR(C.FM_MVMT_YD_CD, 1, 5) = @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND C.FM_MVMT_YD_CD = @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#elseif (${to_mvmt_yd_cd} != '')" ).append("\n"); 
		query.append("		##${to_mvmt_yd_cd}" ).append("\n"); 
		query.append("		#if ($to_mvmt_yd_cd.length() == 5)" ).append("\n"); 
		query.append("			AND SUBSTR(C.TO_MVMT_YD_CD,1, 5) = @[to_mvmt_yd_cd]" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND C.TO_MVMT_YD_CD = @[to_mvmt_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	--AND C.DMDT_CHG_STS_CD NOT IN ('D','N','U','I','C')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${incl_inv} != 'Y') " ).append("\n"); 
		query.append("	AND C.DMDT_CHG_STS_CD <> 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'vvd_cd')" ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("	AND (	B.VSL_CD = SUBSTR(@[vvd_cd],1,4) " ).append("\n"); 
		query.append("		AND B.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4) " ).append("\n"); 
		query.append("		AND B.SKD_DIR_CD = SUBSTR(@[vvd_cd],9) " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${pod_cd} != '' || ${pol_cd} != '')" ).append("\n"); 
		query.append("	AND (1=0" ).append("\n"); 
		query.append("		#if (${pod_cd} != '')" ).append("\n"); 
		query.append("		OR B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pol_cd} != '')" ).append("\n"); 
		query.append("		OR B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'cntr')" ).append("\n"); 
		query.append("	#if (${bkg_no} != '')	" ).append("\n"); 
		query.append("	AND B.BKG_NO IN (" ).append("\n"); 
		query.append("		#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bl_no} != '')" ).append("\n"); 
		query.append("	AND B.BL_NO IN (" ).append("\n"); 
		query.append("		#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $bl_no_list.size()) '$bl_cd', #else '$bl_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cntr_no} != '')" ).append("\n"); 
		query.append("	AND C.CNTR_NO IN (" ).append("\n"); 
		query.append("		#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cd} != '')" ).append("\n"); 
		query.append("	#if (${cust_type} == '')" ).append("\n"); 
		query.append("	AND (" ).append("\n"); 
		query.append("				C.ACT_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND C.ACT_CUST_SEQ	= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("		OR		BS.CUST_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND BS.CUST_SEQ		= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("		OR		BC.CUST_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND BC.CUST_SEQ		= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("		OR 		BN.CUST_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND BN.CUST_SEQ		= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("		OR(" ).append("\n"); 
		query.append("			EXISTS (" ).append("\n"); 
		query.append("    		SELECT  'X'" ).append("\n"); 
		query.append("    		FROM    INV_AR_MN I" ).append("\n"); 
		query.append("    		WHERE   I.BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("    		AND     I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("			AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    				SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    				FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    				WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    				AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("								  )" ).append("\n"); 
		query.append("			AND     ROWNUM  = 1" ).append("\n"); 
		query.append("			AND     I.ACT_CUST_CNT_CD   = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND     I.ACT_CUST_SEQ      = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'P')" ).append("\n"); 
		query.append("		AND C.ACT_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("		AND C.ACT_CUST_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'S') " ).append("\n"); 
		query.append("		AND BS.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("		AND BS.CUST_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'C') " ).append("\n"); 
		query.append("		AND BC.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("		AND BC.CUST_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'N') " ).append("\n"); 
		query.append("		AND BN.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("		AND BN.CUST_SEQ  = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("	#elseif (${cust_type} == 'A')		" ).append("\n"); 
		query.append("		AND EXISTS (" ).append("\n"); 
		query.append("    		SELECT  'X'" ).append("\n"); 
		query.append("    		FROM    INV_AR_MN I" ).append("\n"); 
		query.append("    		WHERE   I.BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("    		AND     I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("			AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    				SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    				FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    				WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    				AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("								  )" ).append("\n"); 
		query.append("			AND     ROWNUM  = 1" ).append("\n"); 
		query.append("			AND     I.ACT_CUST_CNT_CD   = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND     I.ACT_CUST_SEQ      = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${svc_provdr} != '') " ).append("\n"); 
		query.append("AND C.VNDR_SEQ = LTRIM(@[svc_provdr],'0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sc_no} != '') " ).append("\n"); 
		query.append("AND B.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rfa_no} != '') " ).append("\n"); 
		query.append("AND B.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, FM_MVMT_DT" ).append("\n"); 

	}
}
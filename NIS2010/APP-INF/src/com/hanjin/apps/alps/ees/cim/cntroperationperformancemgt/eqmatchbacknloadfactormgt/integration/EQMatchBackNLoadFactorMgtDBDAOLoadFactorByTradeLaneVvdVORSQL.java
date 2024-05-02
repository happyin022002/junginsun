/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LoadFactorByTradeLaneVvdVO
	  * 2010.10.18 최윤성 [CHM-201006559-01] "EMS" Trade 추가에 따른 "EM"로직 추가
	  * 2011.08.17 신자영 [CHM-201112859-01] (CIM) ESE 노선 Trade 변경 관련 Data Management 요청
	  * 2011.10.26 신자영 [CHM-201113916-01] [CIM] Load factor by cy의 sub-trade 검색 기능 추가
	  * 2011.11.01 신자영 [CHM-201114141-01] [CIM] L/F by trade & M/B by vessel 기능에 EM1 & EM2 Lane 추가
	  * 2012.04.17 신자영 [CHM-201217339-01] iNVENTORY/ Load Factor & M/B by vessel 기능 보완
	  * 2012.08.08 신자영 [CHM-201219547-01] Load Factor 기능에 새로운 노선 추가
	  * 2012.12.10 신자영 [CHM-201221889-01] LOAD FACTOR 추가 보완 요청
	  * 2013.01.10 신자영 [CHM-201322311-01] LOAD FACTOR BY TRADE
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdVORSQL").append("\n"); 
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
		query.append("WITH MAIN AS " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT	TRD_CD ,				/* trade			*/" ).append("\n"); 
		query.append("					LANE_CD ,				/* lane				*/" ).append("\n"); 
		query.append("					RLANE_CD," ).append("\n"); 
		query.append("					VSL_CD," ).append("\n"); 
		query.append("					SKD_VOY_NO," ).append("\n"); 
		query.append("					SKD_DIR_CD ,			/* vvd				*/" ).append("\n"); 
		query.append("					VPS_PORT_CD ,			/* port				*/" ).append("\n"); 
		query.append("					CLPT_IND_SEQ ,			/* call_ind 		*/" ).append("\n"); 
		query.append("					CLPT_SEQ ,				/* call_seq 		*/" ).append("\n"); 
		query.append("					VPS_ETD_DT ,			/* atd				*/" ).append("\n"); 
		query.append("					PLN_YR," ).append("\n"); 
		query.append("					PLN_WK ,				/* atd week			*/	" ).append("\n"); 
		query.append("					FROM_RGN ,				/* from_region		*/" ).append("\n"); 
		query.append("					TO_RGN					/* to_region		*/" ).append("\n"); 
		query.append("			FROM	(" ).append("\n"); 
		query.append("						SELECT	" ).append("\n"); 
		query.append("								/*+ " ).append("\n"); 
		query.append("									ORDERED USE_NL( DST  OCNT OSCNT DCNT DSCNT ) " ).append("\n"); 
		query.append("									INDEX( DST      XPKVSK_VSL_PORT_SKD   )" ).append("\n"); 
		query.append("									INDEX( OCNT	    XPKMDM_COUNTRY )" ).append("\n"); 
		query.append("									INDEX( OCNT	    XPKMDM_COUNTRY )" ).append("\n"); 
		query.append("									INDEX( OSCNT	XPKMDM_SUBCONTINENT )" ).append("\n"); 
		query.append("									INDEX( OSCNT	XPKMDM_SUBCONTINENT )" ).append("\n"); 
		query.append("								*/" ).append("\n"); 
		query.append("					    		BSA.TRD_CD			,											/* trade			*/" ).append("\n"); 
		query.append("								ORG.LANE_CD			,											/* lane				*/" ).append("\n"); 
		query.append("								BSA.RLANE_CD        ,                                           /* R -lane Full     */" ).append("\n"); 
		query.append("								ORG.VSL_CD,	ORG.SKD_VOY_NO,	ORG.SKD_DIR_CD,						/* vvd				*/" ).append("\n"); 
		query.append("								ORG.VPS_PORT_CD		,											/* port				*/" ).append("\n"); 
		query.append("								ORG.CLPT_IND_SEQ	,											/* call_ind 		*/" ).append("\n"); 
		query.append("								ORG.CLPT_SEQ		,											/* call_seq 		*/" ).append("\n"); 
		query.append("								ORG.VPS_ETD_DT										VPS_ETD_DT,	/* atd				*/" ).append("\n"); 
		query.append("#if ( ${lane} == '' )" ).append("\n"); 
		query.append("								CASE " ).append("\n"); 
		query.append("								WHEN ORG.LANE_CD != 'WAF' AND ORG.LANE_CD != 'EM1' AND ORG.LANE_CD != 'EM2' AND ORG.LANE_CD != 'TLS' THEN                                 " ).append("\n"); 
		query.append("								DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD)  /* from_region   */								" ).append("\n"); 
		query.append("								ELSE " ).append("\n"); 
		query.append("					            OSCNT.CONTI_CD        /* from_region   */" ).append("\n"); 
		query.append("								END FROM_RGN," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("								CASE " ).append("\n"); 
		query.append("								WHEN ORG.LANE_CD != 'WAF' AND ORG.LANE_CD != 'EM1' AND ORG.LANE_CD != 'EM2' AND ORG.LANE_CD != 'TLS' THEN                                 " ).append("\n"); 
		query.append("                                --DECODE(DST.VPS_PORT_CD, 'RUNJK', 'A', DECODE(DSCNT.CONTI_CD, 'F', 'E', DSCNT.CONTI_CD))    /* to_region     */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    CASE WHEN DST.VPS_PORT_CD = 'RUNJK' OR DST.VPS_PORT_CD = 'RUSKA' THEN" ).append("\n"); 
		query.append("                                          CASE WHEN SUBSTR(TRD_CD,2,1) = 'P' THEN 'A'            " ).append("\n"); 
		query.append("                                               WHEN SUBSTR(TRD_CD,2,1) = 'M' THEN 'A'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'TAS' THEN 'E'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'AES' THEN 'A'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'EMS' AND ORG.LANE_CD = 'ESE' THEN 'E'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'EMS' AND ORG.LANE_CD = 'EXE' THEN 'E'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'EMS' AND ORG.LANE_CD <> 'ESE' AND ORG.LANE_CD <> 'EXE' THEN 'A'" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("                                    ELSE  DECODE(DSCNT.CONTI_CD, 'F', 'E', DSCNT.CONTI_CD)" ).append("\n"); 
		query.append("                                    END /* to_region     */" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("								ELSE " ).append("\n"); 
		query.append("                                	DSCNT.CONTI_CD           /* to_region     */" ).append("\n"); 
		query.append("								END TO_RGN" ).append("\n"); 
		query.append("#elseif ( ${lane} != 'WAF' && ${lane} != 'EM1' && ${lane} != 'EM2' && ${lane} != 'TLS')" ).append("\n"); 
		query.append("                               " ).append("\n"); 
		query.append("								DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) FROM_RGN, /* from_region   */" ).append("\n"); 
		query.append("                                --DECODE(DST.VPS_PORT_CD, 'RUNJK', 'A', DECODE(DSCNT.CONTI_CD, 'F', 'E', DSCNT.CONTI_CD)) TO_RGN    /* to_region     */" ).append("\n"); 
		query.append("                                    CASE WHEN DST.VPS_PORT_CD = 'RUNJK' OR DST.VPS_PORT_CD = 'RUSKA' THEN" ).append("\n"); 
		query.append("                                          CASE WHEN SUBSTR(TRD_CD,2,1) = 'P' THEN 'A'            " ).append("\n"); 
		query.append("                                               WHEN SUBSTR(TRD_CD,2,1) = 'M' THEN 'A'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'TAS' THEN 'E'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'AES' THEN 'A'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'EMS' AND ORG.LANE_CD = 'ESE' THEN 'E'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'EMS' AND ORG.LANE_CD = 'EXE' THEN 'E'" ).append("\n"); 
		query.append("                                               WHEN TRD_CD = 'EMS' AND ORG.LANE_CD <> 'ESE' AND ORG.LANE_CD <> 'EXE' THEN 'A'" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("                                    ELSE  DECODE(DSCNT.CONTI_CD, 'F', 'E', DSCNT.CONTI_CD)" ).append("\n"); 
		query.append("                                    END TO_RGN /* to_region     */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("					            OSCNT.CONTI_CD       FROM_RGN, /* from_region   */" ).append("\n"); 
		query.append("                                DSCNT.CONTI_CD       TO_RGN    /* to_region     */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						FROM	" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT /*+ INDEX_FFS(BSA_VVD_MST XPKBSA_VVD_MST) */" ).append("\n"); 
		query.append("                                    DISTINCT B.TRD_CD, SUBSTR(B.RLANE_CD,1, 3) LANE_CD, B.RLANE_CD RLANE_CD" ).append("\n"); 
		query.append("                        			FROM BSA_VVD_MST B, MDM_DTL_REV_LANE L" ).append("\n"); 
		query.append("                        			WHERE B.RLANE_CD = L.RLANE_CD" ).append("\n"); 
		query.append("									#if ( ${subtrade} != '' && ${subtrade} != 'ALL' )" ).append("\n"); 
		query.append("                        			AND  L.SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								)	BSA	," ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT	VPS1.VSL_CD							VSL_CD,		" ).append("\n"); 
		query.append("											VPS1.SKD_VOY_NO						SKD_VOY_NO,		" ).append("\n"); 
		query.append("											VPS1.SKD_DIR_CD						SKD_DIR_CD," ).append("\n"); 
		query.append("											VPS1.VPS_PORT_CD					VPS_PORT_CD,	" ).append("\n"); 
		query.append("											VPS1.CLPT_IND_SEQ					CLPT_IND_SEQ," ).append("\n"); 
		query.append("											VPS1.CLPT_SEQ						CLPT_SEQ,		" ).append("\n"); 
		query.append("											TO_CHAR(VPS1.VPS_ETD_DT,'YYYYMMDD')	VPS_ETD_DT," ).append("\n"); 
		query.append("											VPS1.SLAN_CD						LANE_CD," ).append("\n"); 
		query.append("											(" ).append("\n"); 
		query.append("												SELECT  /*+ INDEX( VPS2 XAK4VSK_VSL_PORT_SKD ) */" ).append("\n"); 
		query.append("														VPS_PORT_CD||CLPT_IND_SEQ" ).append("\n"); 
		query.append("												FROM    VSK_VSL_PORT_SKD    VPS2" ).append("\n"); 
		query.append("												WHERE   VPS2.VSL_CD				=	VPS1.VSL_CD" ).append("\n"); 
		query.append("												AND		VPS2.SKD_VOY_NO			=	VPS1.SKD_VOY_NO" ).append("\n"); 
		query.append("												AND		VPS2.SKD_DIR_CD			=	VPS1.SKD_DIR_CD" ).append("\n"); 
		query.append("												AND		VPS2.CLPT_SEQ			>	VPS1.CLPT_SEQ" ).append("\n"); 
		query.append("												AND		NVL(VPS2.VPS_PORT_CD,		' ') NOT IN ('PAPAC', 'EGSUZ')" ).append("\n"); 
		query.append("												AND		NVL(VPS2.SKD_CNG_STS_CD,	' ') <> 'S'" ).append("\n"); 
		query.append("												AND     ROWNUM = 1" ).append("\n"); 
		query.append("											)									TO_PKEY	" ).append("\n"); 
		query.append("									FROM	VSK_VSL_PORT_SKD	VPS1	" ).append("\n"); 
		query.append("									WHERE	VPS1.VPS_ETD_DT BETWEEN		TO_DATE(@[fromdate], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("															AND			TO_DATE(@[todate], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("									AND		NVL(VPS1.VPS_PORT_CD,		' ') NOT IN ('PAPAC', 'EGSUZ')" ).append("\n"); 
		query.append("									AND		NVL(VPS1.TURN_PORT_IND_CD,	' ') NOT IN ('D', 'F', 'V')" ).append("\n"); 
		query.append("									AND		NVL(VPS1.SKD_CNG_STS_CD,	' ') <> 'S'" ).append("\n"); 
		query.append("								)					ORG	,					" ).append("\n"); 
		query.append("								VSK_VSL_PORT_SKD	DST	," ).append("\n"); 
		query.append("								MDM_COUNTRY			OCNT, " ).append("\n"); 
		query.append("								MDM_SUBCONTINENT	OSCNT," ).append("\n"); 
		query.append("								MDM_COUNTRY			DCNT, " ).append("\n"); 
		query.append("								MDM_SUBCONTINENT	DSCNT," ).append("\n"); 
		query.append("								AR_MST_REV_VVD 		V" ).append("\n"); 
		query.append("						WHERE	DST.VSL_CD				=	ORG.VSL_CD" ).append("\n"); 
		query.append("						AND		DST.SKD_VOY_NO			=	ORG.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND		DST.SKD_DIR_CD			=	ORG.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND		DST.VPS_PORT_CD			=	SUBSTR(ORG.TO_PKEY,1,5)" ).append("\n"); 
		query.append("						AND		DST.CLPT_IND_SEQ		=	SUBSTR(ORG.TO_PKEY,6,2)" ).append("\n"); 
		query.append("						AND		OCNT.CNT_CD				=	SUBSTR(ORG.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("						AND		OCNT.SCONTI_CD			=	OSCNT.SCONTI_CD" ).append("\n"); 
		query.append("						AND		DCNT.CNT_CD				=	SUBSTR(DST.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("						AND		DCNT.SCONTI_CD			=	DSCNT.SCONTI_CD" ).append("\n"); 
		query.append("						AND		ORG.LANE_CD				=	BSA.LANE_CD" ).append("\n"); 
		query.append("						AND 	ORG.VSL_CD 				= 	V.VSL_CD" ).append("\n"); 
		query.append("						AND 	ORG.SKD_VOY_NO 			= 	V.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND 	ORG.SKD_DIR_CD 			= 	V.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND 	V.RLANE_CD 				= 	BSA.RLANE_CD" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${lane} != '')" ).append("\n"); 
		query.append("				AND		ORG.LANE_CD = @[lane]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${vvd} != '')" ).append("\n"); 
		query.append("				AND		ORG.VSL_CD				=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("				AND		ORG.SKD_VOY_NO			=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("				AND		ORG.SKD_DIR_CD			=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				-- 2013.01.08 load factor에 bound 추가" ).append("\n"); 
		query.append("   				#if (${bound} != '')" ).append("\n"); 
		query.append(" 			    AND  ORG.SKD_DIR_CD   = @[bound]" ).append("\n"); 
		query.append("    			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${trade} == 'AL')" ).append("\n"); 
		query.append("				--2012.12.21 추가" ).append("\n"); 
		query.append("				AND ((( TRD_CD = 'IAS' AND OSCNT.SCONTI_CD = 'AF' AND DSCNT.SCONTI_CD <> 'AF')" ).append("\n"); 
		query.append("    					OR (TRD_CD <> 'IAS' AND 1 = 1))" ).append("\n"); 
		query.append("    				OR " ).append("\n"); 
		query.append("     				(( TRD_CD = 'IAS' AND OSCNT.SCONTI_CD <> 'AF' AND DSCNT.SCONTI_CD = 'AF')" ).append("\n"); 
		query.append("        				OR (TRD_CD <> 'IAS' AND 1 = 1))" ).append("\n"); 
		query.append("    			)" ).append("\n"); 
		query.append("				--2012.12.21 end" ).append("\n"); 
		query.append("				AND	(" ).append("\n"); 
		query.append("						( SUBSTR(BSA.TRD_CD,2,1) = 'P' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'M','A' ) )" ).append("\n"); 
		query.append("--						OR" ).append("\n"); 
		query.append("--						( SUBSTR(BSA.TRD_CD,2,1) = 'A' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'M','E' ) )" ).append("\n"); 
		query.append("                        OR" ).append("\n"); 
		query.append("                        ( TRD_CD <> 'IAS' AND SUBSTR(BSA.TRD_CD,2,1) = 'A' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'M','E' ) )  -- 변경" ).append("\n"); 
		query.append("                        OR" ).append("\n"); 
		query.append("                        (TRD_CD = 'IAS' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'A' )) " ).append("\n"); 
		query.append("						--2012.12.20 추가" ).append("\n"); 
		query.append("						--OR " ).append("\n"); 
		query.append("						--( TRD_CD = 'IAS' AND OSCNT.SCONTI_CD = 'AF' AND DSCNT.SCONTI_CD <> 'AF')" ).append("\n"); 
		query.append("						--OR " ).append("\n"); 
		query.append("						--( TRD_CD = 'IAS' AND OSCNT.SCONTI_CD <> 'AF' AND DSCNT.SCONTI_CD = 'AF')" ).append("\n"); 
		query.append("						--2012.12.20 end" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("#if ( ${lane} == '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SUBSTR(BSA.TRD_CD,2,1) = 'E' AND DECODE(ORG.LANE_CD,'WAF',OSCNT.CONTI_CD, 'EM1',OSCNT.CONTI_CD, 'EM2',OSCNT.CONTI_CD, 'TLS',OSCNT.CONTI_CD, DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD)) IN ( 'E', DECODE(ORG.LANE_CD,'WAF','F', 'EM1','F', 'EM2','F', 'TLS','F', 'A' ) ) )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif ( ${lane} != 'WAF' && ${lane} != 'EM1' && ${lane} != 'EM2' && ${lane} != 'TLS')" ).append("\n"); 
		query.append("                      (SUBSTR(BSA.TRD_CD,2,1) = 'E' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'E','A' ) )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                      (SUBSTR(BSA.TRD_CD,2,1) = 'E' AND OSCNT.CONTI_CD IN ( 'E', 'F' ) )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("                      (SUBSTR(BSA.TRD_CD,2,1) = 'M' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'M','E' )) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("				#elseif (${trade} == 'TP')" ).append("\n"); 
		query.append("				AND	( SUBSTR(BSA.TRD_CD,2,1) = 'P' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'M','A' ) )" ).append("\n"); 
		query.append("				#elseif (${trade} == 'TA')" ).append("\n"); 
		query.append("				AND	( SUBSTR(BSA.TRD_CD,2,1) = 'A' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'M','E' ) )" ).append("\n"); 
		query.append("				#elseif (${trade} == 'TE')" ).append("\n"); 
		query.append("				AND	( SUBSTR(BSA.TRD_CD,2,1) = 'E' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'E','A' ) )" ).append("\n"); 
		query.append("				#elseif (${trade} == 'AA')" ).append("\n"); 
		query.append("				AND	( SUBSTR(BSA.TRD_CD,2,1) IN  ( 'P','E' ) AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) = 'A'  )" ).append("\n"); 
		query.append("				#elseif (${trade} == 'MM')" ).append("\n"); 
		query.append("				AND	( SUBSTR(BSA.TRD_CD,2,1) IN  ( 'P','A' ) AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) = 'M'  )" ).append("\n"); 
		query.append("				#elseif (${trade} == 'EE')" ).append("\n"); 
		query.append("				AND	( SUBSTR(BSA.TRD_CD,2,1) IN  ( 'A','E' ) AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) = 'E'  )" ).append("\n"); 
		query.append("                #elseif (${trade} == 'EM')" ).append("\n"); 
		query.append("				AND	( SUBSTR(BSA.TRD_CD,2,1) = 'M' AND DECODE(OSCNT.CONTI_CD, 'F', 'E', OSCNT.CONTI_CD) IN ( 'M','E' ) )" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)," ).append("\n"); 
		query.append("				EQR_WK_PRD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${trade} == 'AL')" ).append("\n"); 
		query.append("			WHERE	(" ).append("\n"); 
		query.append("				(SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'M' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("			OR	(SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'A' AND TO_RGN = 'M')" ).append("\n"); 
		query.append("--2012.08.07 add             " ).append("\n"); 
		query.append("            OR	(LANE_CD = 'AWJ' AND SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'A' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("            OR  (LANE_CD = 'AWJ' AND SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'M' AND TO_RGN = 'E')   " ).append("\n"); 
		query.append("--2012.08.07 add" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--			OR		(SUBSTR(TRD_CD,2,1) = 'A' AND FROM_RGN = 'M' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("--			OR		(SUBSTR(TRD_CD,2,1) = 'A' AND FROM_RGN = 'E' AND TO_RGN = 'M')" ).append("\n"); 
		query.append("--2012.12.10" ).append("\n"); 
		query.append("            OR  (TRD_CD <> 'IAS' AND SUBSTR(TRD_CD,2,1) = 'A' AND FROM_RGN = 'M' AND TO_RGN = 'E')  -- 변경" ).append("\n"); 
		query.append("            OR  (TRD_CD <> 'IAS' AND SUBSTR(TRD_CD,2,1) = 'A' AND FROM_RGN = 'E' AND TO_RGN = 'M')  -- 변경" ).append("\n"); 
		query.append("            OR  (TRD_CD = 'IAS' AND FROM_RGN = 'A' AND TO_RGN = 'A') -- 추가" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--OR		(SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'E' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("			--OR		(SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'A' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("#if ( ${lane} == '' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			OR (SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'E' AND TO_RGN = DECODE(LANE_CD, 'WAF','F','EM1','F','EM2','F','TLS','F','A') )" ).append("\n"); 
		query.append("			OR (SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = DECODE(LANE_CD, 'WAF','F','EM1','F','EM2','F','TLS','F','A') AND TO_RGN = 'E')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif ( ${lane} != 'WAF' && ${lane} != 'EM1' && ${lane} != 'EM2' && ${lane} != 'TLS')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'E' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'A' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             OR (SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'E' AND TO_RGN = 'F')" ).append("\n"); 
		query.append("             OR (SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'F' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${lane} == '' )" ).append("\n"); 
		query.append("			OR ( (SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = DECODE(LANE_CD, 'ESE','M', 'EXE','M','E') AND TO_RGN = DECODE(LANE_CD, 'ESE','E', 'EXE','E','A'))" ).append("\n"); 
		query.append("			OR 		(SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = DECODE(LANE_CD, 'ESE','E', 'EXE','E','M') AND TO_RGN = DECODE(LANE_CD, 'ESE','M', 'EXE','M','A'))" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#elseif ( ${lane} == 'ESE' ||  ${lane} == 'EXE')" ).append("\n"); 
		query.append("			OR ( (SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = 'M' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("			OR 		(SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = 'E' AND TO_RGN = 'M')" ).append("\n"); 
		query.append("			      )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("			OR	(" ).append("\n"); 
		query.append("					(SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = 'E' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = 'M' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#elseif (${trade} == 'TP')" ).append("\n"); 
		query.append("			WHERE	(" ).append("\n"); 
		query.append("					(SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'M' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'A' AND TO_RGN = 'M')" ).append("\n"); 
		query.append("--2012.08.07 add             " ).append("\n"); 
		query.append("            OR	(LANE_CD = 'AWJ' AND SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'A' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("            OR  (LANE_CD = 'AWJ' AND SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'M' AND TO_RGN = 'E')   " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#elseif (${trade} == 'TA')" ).append("\n"); 
		query.append("			WHERE	(" ).append("\n"); 
		query.append("					(SUBSTR(TRD_CD,2,1) = 'A' AND FROM_RGN = 'M' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'A' AND FROM_RGN = 'E' AND TO_RGN = 'M')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#elseif (${trade} == 'TE')" ).append("\n"); 
		query.append("			WHERE	(" ).append("\n"); 
		query.append("					(SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'E' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'A' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#elseif (${trade} == 'AA')" ).append("\n"); 
		query.append("			WHERE	(" ).append("\n"); 
		query.append("					(SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'A' AND TO_RGN = 'M')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'A' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#elseif (${trade} == 'MM')" ).append("\n"); 
		query.append("			WHERE	(" ).append("\n"); 
		query.append("					(SUBSTR(TRD_CD,2,1) = 'P' AND FROM_RGN = 'M' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'A' AND FROM_RGN = 'M' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#elseif (${trade} == 'EE')" ).append("\n"); 
		query.append("			WHERE	(" ).append("\n"); 
		query.append("					(SUBSTR(TRD_CD,2,1) = 'A' AND FROM_RGN = 'E' AND TO_RGN = 'M')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'E' AND FROM_RGN = 'E' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("            #elseif (${trade} == 'EM')" ).append("\n"); 
		query.append("		   		#if ( ${lane} == '' )" ).append("\n"); 
		query.append("			WHERE ( (SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = DECODE(LANE_CD, 'ESE', 'M', 'EXE', 'M', 'E') AND TO_RGN = DECODE(LANE_CD, 'ESE', 'E', 'EXE', 'E', 'A'))" ).append("\n"); 
		query.append("			OR 		(SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = DECODE(LANE_CD, 'ESE', 'E', 'EXE', 'E', 'M') AND TO_RGN = DECODE(LANE_CD, 'ESE', 'M', 'EXE', 'M', 'A'))" ).append("\n"); 
		query.append("			      )" ).append("\n"); 
		query.append("		   		#elseif ( ${lane} == 'ESE' || ${lane} == 'EXE'  )" ).append("\n"); 
		query.append("			WHERE ( (SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = 'M' AND TO_RGN = 'E')" ).append("\n"); 
		query.append("			OR 		(SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = 'E' AND TO_RGN = 'M')" ).append("\n"); 
		query.append("			      )" ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("			WHERE	(" ).append("\n"); 
		query.append("					(SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = 'E' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("			OR		(SUBSTR(TRD_CD,2,1) = 'M' AND FROM_RGN = 'M' AND TO_RGN = 'A')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND     VPS_ETD_DT	BETWEEN		WK_ST_DT" ).append("\n"); 
		query.append("								AND			WK_END_DT" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			SELECT	/*+ ORDERED USE_NL( M 01 02 RH2 B )*/ " ).append("\n"); 
		query.append("					M.TRD_CD trade,								/* trade			*/" ).append("\n"); 
		query.append("					M.LANE_CD lane,								/* lane				*/" ).append("\n"); 
		query.append("					M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD vvd,			/* vvd				*/" ).append("\n"); 
		query.append("					M.VPS_PORT_CD port,							/* port				*/" ).append("\n"); 
		query.append("					M.CLPT_IND_SEQ callind,						/* call_ind 		*/" ).append("\n"); 
		query.append("					M.CLPT_SEQ callseq,							/* call_seq 		*/" ).append("\n"); 
		query.append("					M.VPS_ETD_DT atd,								/* atd				*/" ).append("\n"); 
		query.append("					M.PLN_YR||M.PLN_WK atd_week,					/* atd week			*/	" ).append("\n"); 
		query.append("					M.FROM_RGN fromregion,						/* from_region		*/" ).append("\n"); 
		query.append("					M.TO_RGN	to_region,							/* to_region		*/" ).append("\n"); 
		query.append("        		--< BSA > ______________________________________________________________________________________" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                -- (1). RDR" ).append("\n"); 
		query.append("                DECODE((SELECT " ).append("\n"); 
		query.append("                		        SUM(RA.BSA_SLOT)||','||SUM(RA.BSA_WGT)                    	" ).append("\n"); 
		query.append("                        FROM	RDR_HEADER			RH1," ).append("\n"); 
		query.append("                        		RDR_ALLOCATION		RA" ).append("\n"); 
		query.append("                       WHERE	M.VSL_CD		=	RH1.VSL_CD	(+)" ).append("\n"); 
		query.append("                        AND     M.SKD_VOY_NO	=   RH1.VOY_NO	(+)" ).append("\n"); 
		query.append("                        AND     M.SKD_DIR_CD    =   RH1.DIR_CD	(+)" ).append("\n"); 
		query.append("                        AND     M.FROM_RGN		=   RH1.REGION	(+)" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        AND     RH1.VSL_CD		=   RA.VSL_CD	(+)" ).append("\n"); 
		query.append("                        AND     RH1.VOY_NO		=   RA.VOY_NO	(+)" ).append("\n"); 
		query.append("                        AND     RH1.DIR_CD		=   RA.DIR_CD	(+)" ).append("\n"); 
		query.append("                        AND     RH1.REGION		=   RA.REGION	(+)" ).append("\n"); 
		query.append("                        AND		@[company]		=	RA.OPR_CD	(+)                                     " ).append("\n"); 
		query.append("                    ),',',NVL(MAX(DECODE(O1.BSA_OP_JB_CD,'007',O1.CRR_BSA_CAPA,0)),0)||','||NVL(MAX(DECODE(O2.BSA_OP_JB_CD,'009',O2.CRR_BSA_CAPA,0)),0)," ).append("\n"); 
		query.append("                    ( SELECT " ).append("\n"); 
		query.append("                		    SUM(RA.BSA_SLOT)||','||SUM(RA.BSA_WGT)                   " ).append("\n"); 
		query.append("                    FROM	RDR_HEADER			RH1," ).append("\n"); 
		query.append("                    		RDR_ALLOCATION		RA" ).append("\n"); 
		query.append("                    WHERE	M.VSL_CD		=	RH1.VSL_CD	(+)" ).append("\n"); 
		query.append("                    AND     M.SKD_VOY_NO	=   RH1.VOY_NO	(+)" ).append("\n"); 
		query.append("                    AND     M.SKD_DIR_CD    =   RH1.DIR_CD	(+)" ).append("\n"); 
		query.append("                    AND     M.FROM_RGN		=   RH1.REGION	(+)" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    AND     RH1.VSL_CD		=   RA.VSL_CD	(+)" ).append("\n"); 
		query.append("                    AND     RH1.VOY_NO		=   RA.VOY_NO	(+)" ).append("\n"); 
		query.append("                    AND     RH1.DIR_CD		=   RA.DIR_CD	(+)" ).append("\n"); 
		query.append("                    AND     RH1.REGION		=   RA.REGION	(+)" ).append("\n"); 
		query.append("                    AND		@[company]		=	RA.OPR_CD	(+)                                     " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                 )  bsaspace	," ).append("\n"); 
		query.append("				-- deadSlot-------------------------------------------------------" ).append("\n"); 
		query.append("            	(SELECT " ).append("\n"); 
		query.append("            		   NVL(SUM(DECODE(RU.TYPE,'A',RU.SLOT_QTY,0))                                                    " ).append("\n"); 
		query.append("            		   +SUM(DECODE(RU.TYPE,'H',RU.SLOT_QTY,'L',RU.SLOT_QTY,0)),0)  /* deadSlot	*/    " ).append("\n"); 
		query.append("            	FROM    RDR_HEADER      H, " ).append("\n"); 
		query.append("            			RDR_UTILIZE     RU" ).append("\n"); 
		query.append("                WHERE	M.VSL_CD		=	H.VSL_CD	(+)" ).append("\n"); 
		query.append("                AND     M.SKD_VOY_NO	=   H.VOY_NO	(+)" ).append("\n"); 
		query.append("                AND     M.SKD_DIR_CD    =   H.DIR_CD	(+)" ).append("\n"); 
		query.append("                AND     M.FROM_RGN		=   H.REGION	(+)" ).append("\n"); 
		query.append("            	AND     H.VSL_CD    =   RU.VSL_CD" ).append("\n"); 
		query.append("            	AND     H.VOY_NO    =   RU.VOY_NO" ).append("\n"); 
		query.append("            	AND     H.DIR_CD    =   RU.DIR_CD" ).append("\n"); 
		query.append("            	AND     H.REGION    =   RU.REGION" ).append("\n"); 
		query.append("            	AND     @[company]  =   RU.OPR_CD" ).append("\n"); 
		query.append("            	) deadSlot,        		          " ).append("\n"); 
		query.append("        		" ).append("\n"); 
		query.append("				--< 실적 > ______________________________________________________________________________________" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        		-- (1). BAY PLAN" ).append("\n"); 
		query.append("        		" ).append("\n"); 
		query.append("        		DECODE(SUM(NVL(TO_NUMBER(TRIM(B.WEIGHT)), 0)),0,'','BAY')														dataSource,	/* dataSource */" ).append("\n"); 
		query.append("        		COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '2', SZTP)))	full20Qty,	/* full20Qty */" ).append("\n"); 
		query.append("        		COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '4', SZTP)))	full40Qty,	/* full40Qty */" ).append("\n"); 
		query.append("        		COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '5', SZTP)))	+ COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '9', SZTP))) fullHcQty,	/* fullHcQty */" ).append("\n"); 
		query.append("        		COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '7', SZTP)))	full45Qty,	/* full45Qty */" ).append("\n"); 
		query.append("        		COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '2', SZTP)))	mty20Qty,	/* mty20Qty  */" ).append("\n"); 
		query.append("        		COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '4', SZTP)))	mty40Qty,	/* mty40Qty  */" ).append("\n"); 
		query.append("        		COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '5', SZTP)))	+ COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '9', SZTP))) mtyHcQty,	/* mtyHcQty  */" ).append("\n"); 
		query.append("        		COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '7', SZTP)))	mty45Qty,	/* mty45Qty  */" ).append("\n"); 
		query.append("        		SUM(NVL(TO_NUMBER(TRIM(B.WEIGHT)), 0))						weightTotal," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        		--< Release > ______________________________________________________________________________________" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("--/*  20100405 Realese Logic 변경 By Y.H.Nam */" ).append("\n"); 
		query.append("--        		NVL(SUM(RR.SLOT),0)											releasedteu," ).append("\n"); 
		query.append("--        		NVL(SUM(RR.WEIGHT),0)										releasedweight  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        		--/* 20100405 Realese Logic 변경 By Y.H.Nam  */" ).append("\n"); 
		query.append("        		( SELECT " ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        NVL(NVL(SUM(RA.RELEASE_SLOT),0) + NVL(SUM(RA.SWAP_SLOT),0),0) ||','||  -- releasedteu                               " ).append("\n"); 
		query.append("                        NVL(NVL(SUM(RA.RELEASE_WGT), 0) + NVL(SUM(RA.SWAP_WGT), 0),0)          -- releasedweight             " ).append("\n"); 
		query.append("                FROM	RDR_HEADER			RH1," ).append("\n"); 
		query.append("                		RDR_ALLOCATION		RA" ).append("\n"); 
		query.append("                WHERE	M.VSL_CD		=	RH1.VSL_CD	(+)" ).append("\n"); 
		query.append("                AND     M.SKD_VOY_NO	=   RH1.VOY_NO	(+)" ).append("\n"); 
		query.append("                AND     M.SKD_DIR_CD    =   RH1.DIR_CD	(+)" ).append("\n"); 
		query.append("                AND     M.FROM_RGN		=   RH1.REGION	(+)" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                AND     RH1.VSL_CD		=   RA.VSL_CD	(+)" ).append("\n"); 
		query.append("                AND     RH1.VOY_NO		=   RA.VOY_NO	(+)" ).append("\n"); 
		query.append("                AND     RH1.DIR_CD		=   RA.DIR_CD	(+)" ).append("\n"); 
		query.append("                AND     RH1.REGION		=   RA.REGION	(+)" ).append("\n"); 
		query.append("                AND		@[company]		=	RA.OPR_CD	(+)                                     " ).append("\n"); 
		query.append("                ) releasedteu" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM	" ).append("\n"); 
		query.append("  		MAIN    M," ).append("\n"); 
		query.append("  		BSA_VVD_OTR_CRR  O1," ).append("\n"); 
		query.append("  		BSA_VVD_OTR_CRR  O2," ).append("\n"); 
		query.append("  		RDR_HEADER   RH2," ).append("\n"); 
		query.append("  		--RDR_SLOT_RELEASE RR,  /* 20100405 Realese Logic 변경 By Y.H.Nam */" ).append("\n"); 
		query.append("  		BAY_PLAN   B" ).append("\n"); 
		query.append("------------------------------------------------------- 실적  (1). BAY PLAN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	M.VSL_CD		=	B.VSL_CD	(+)" ).append("\n"); 
		query.append("AND     M.SKD_VOY_NO	=   B.VOY_NO	(+)" ).append("\n"); 
		query.append("AND     M.SKD_DIR_CD    =   B.DIR_CD	(+)" ).append("\n"); 
		query.append("AND     M.VPS_PORT_CD   =   B.PORT_CD	(+)" ).append("\n"); 
		query.append("AND     M.CLPT_IND_SEQ  =	B.CALL_IND	(+)" ).append("\n"); 
		query.append("AND		@[company]		=	B.OPR_CD	(+)" ).append("\n"); 
		query.append("AND		'F'				=	B.PLAN_TYPE	(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-------------------------------------------------------  BSA (2). COA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND	    M.TRD_CD		=	O1.TRD_CD		(+)		" ).append("\n"); 
		query.append("AND     M.RLANE_CD      =	O1.RLANE_CD		(+)" ).append("\n"); 
		query.append("AND		M.VSL_CD		=	O1.VSL_CD		(+)	" ).append("\n"); 
		query.append("AND		M.SKD_VOY_NO	=	O1.SKD_VOY_NO	(+)" ).append("\n"); 
		query.append("AND		M.SKD_DIR_CD	=	O1.SKD_DIR_CD	(+)" ).append("\n"); 
		query.append("AND     '007'           =	O1.BSA_OP_JB_CD	(+) " ).append("\n"); 
		query.append("AND     @[company]		=	O1.CRR_CD		(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     M.TRD_CD		=	O2.TRD_CD		(+)		" ).append("\n"); 
		query.append("AND     M.RLANE_CD      =	O2.RLANE_CD		(+)" ).append("\n"); 
		query.append("AND		M.VSL_CD		=	O2.VSL_CD		(+)	" ).append("\n"); 
		query.append("AND		M.SKD_VOY_NO	=	O2.SKD_VOY_NO	(+)" ).append("\n"); 
		query.append("AND		M.SKD_DIR_CD	=	O2.SKD_DIR_CD	(+)" ).append("\n"); 
		query.append("AND     '009'           =	O2.BSA_OP_JB_CD	(+) " ).append("\n"); 
		query.append("AND     @[company]		=	O2.CRR_CD		(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-------------------------------------------------------  RLSE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		M.VSL_CD		=	RH2.VSL_CD	(+)" ).append("\n"); 
		query.append("AND     M.SKD_VOY_NO	=	RH2.VOY_NO	(+)" ).append("\n"); 
		query.append("AND     M.SKD_DIR_CD	=	RH2.DIR_CD  (+)" ).append("\n"); 
		query.append("AND     M.VPS_PORT_CD	=	RH2.PORT_CD	(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--/*  20100405 Realese Logic 변경 By Y.H.Nam */" ).append("\n"); 
		query.append("--AND		RH2.VSL_CD		=	RR.VSL_CD	(+)" ).append("\n"); 
		query.append("--AND		RH2.VOY_NO		=	RR.VOY_NO	(+)" ).append("\n"); 
		query.append("--AND		RH2.DIR_CD		=	RR.DIR_CD	(+)" ).append("\n"); 
		query.append("--AND		RH2.REGION		=	RR.REGION	(+)" ).append("\n"); 
		query.append("--AND       'HJS'		=	RR.OPR_CD	(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        M.TRD_CD			,			/*	trade		*/" ).append("\n"); 
		query.append("		M.LANE_CD			,			/*	lane		*/" ).append("\n"); 
		query.append("		M.VSL_CD			,			/*	vsl			*/" ).append("\n"); 
		query.append("		M.SKD_VOY_NO		,			/*	voy			*/" ).append("\n"); 
		query.append("		M.SKD_DIR_CD		,			/*	vvd			*/" ).append("\n"); 
		query.append("		M.VPS_PORT_CD		,			/*	port		*/" ).append("\n"); 
		query.append("		M.CLPT_IND_SEQ		,			/*	call_ind	*/" ).append("\n"); 
		query.append("		M.CLPT_SEQ			,			/*	call_seq	*/" ).append("\n"); 
		query.append("		M.VPS_ETD_DT		,			/*	atd			*/" ).append("\n"); 
		query.append("		M.PLN_YR			,			/*	pln_yr		*/" ).append("\n"); 
		query.append("		M.PLN_WK			,			/*	pln_yr		*/" ).append("\n"); 
		query.append("		M.FROM_RGN			,			/*	from_region	*/" ).append("\n"); 
		query.append("		M.TO_RGN" ).append("\n"); 
		query.append("ORDER BY @[company],M.FROM_RGN,M.TRD_CD,M.VPS_ETD_DT,M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD" ).append("\n"); 

	}
}
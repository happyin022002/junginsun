/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChargeCollectionReportDBDAOMonthlyCollectionByOfficeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2014.11.11 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCollectionReportDBDAOMonthlyCollectionByOfficeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 월별 Billable/Invoiced/Collection 된 금액 정보를 조회한다.
	  * </pre>
	  */
	public ChargeCollectionReportDBDAOMonthlyCollectionByOfficeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration").append("\n"); 
		query.append("FileName : ChargeCollectionReportDBDAOMonthlyCollectionByOfficeVORSQL").append("\n"); 
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
		query.append("WITH " ).append("\n"); 
		query.append("TMP1 AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT /*+ MATERIALIZE */" ).append("\n"); 
		query.append("		DECODE(@[grp_flg], 'R', OFC_RHQ_CD, 'O', OFC_CD) OFC," ).append("\n"); 
		query.append("        TARIFF," ).append("\n"); 
		query.append("        IO_BND," ).append("\n"); 
		query.append("        O_CURR," ).append("\n"); 
		query.append("        SUM(NVL(O_COUNT, 0)) O_COUNT," ).append("\n"); 
		query.append("        SUM(NVL(O_AMT, 0)) O_AMT," ).append("\n"); 
		query.append("        -- '' I_CURR, " ).append("\n"); 
		query.append("        0 I_COUNT, 0 I_AMT, 0 M_COUNT, 0 M_AMT," ).append("\n"); 
		query.append("        0 AF_COUNT, 0 AF_AMT, 0 MF_COUNT, 0 MF_AMT, 0 BF_COUNT, 0 BF_AMT, 0 UF_COUNT, 0 UF_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		SELECT  OFC_CD, OFC_RHQ_CD," ).append("\n"); 
		query.append("	            DECODE(SUBSTR(C.DMDT_TRF_CD, 2, 1), 'M', 'DEM', 'DET') TARIFF," ).append("\n"); 
		query.append("	            DECODE(SUBSTR(C.DMDT_TRF_CD, 3, 1), 'I', 'I/B', 'O/B') IO_BND," ).append("\n"); 
		query.append("	            DECODE(@[curr_flg], 'U', 'USD', C.BZC_TRF_CURR_CD ) O_CURR," ).append("\n"); 
		query.append("	            COUNT(C.CNTR_NO) O_COUNT,  -- 20091222 수정" ).append("\n"); 
		query.append("	            ROUND(SUM(DECODE(@[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT)), 2 ) O_AMT," ).append("\n"); 
		query.append("	            -- '' I_CURR, " ).append("\n"); 
		query.append("	            0 I_COUNT, 0 I_AMT, 0 M_COUNT, 0 M_AMT," ).append("\n"); 
		query.append("	            0 AF_COUNT, 0 AF_AMT, 0 MF_COUNT, 0 MF_AMT, 0 BF_COUNT, 0 BF_AMT, 0 UF_COUNT, 0 UF_AMT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        FROM    DMT_CHG_CALC        C," ).append("\n"); 
		query.append("            	GL_MON_XCH_RT       F    " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    WHERE   C.TO_MVMT_DT BETWEEN TO_DATE(@[start_dt], 'YYYYMMDD') AND TO_DATE(@[end_dt], 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("	    AND		C.DMDT_CHG_STS_CD	IN ('F', 'C', 'I')	-- 2009/12/22 수정" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("		#if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("		AND		C.OFC_CD	IN (" ).append("\n"); 
		query.append("			#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All') " ).append("\n"); 
		query.append("		AND		C.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    /* DEM/DET */" ).append("\n"); 
		query.append("		#if (${chg_flg} == 'M')" ).append("\n"); 
		query.append("			#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("				AND	C.DMDT_TRF_CD = 'DMIF'" ).append("\n"); 
		query.append("			#elseif (${io_bnd_flg} == 'O')" ).append("\n"); 
		query.append("				AND	C.DMDT_TRF_CD = 'DMOF'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND C.DMDT_TRF_CD	IN	('DMIF', 'DMOF')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#elseif (${chg_flg} == 'T') " ).append("\n"); 
		query.append("			#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("				AND	C.DMDT_TRF_CD	IN	('DTIC', 'CTIC')" ).append("\n"); 
		query.append("			#elseif (${io_bnd_flg} == 'O')" ).append("\n"); 
		query.append("				AND	C.DMDT_TRF_CD	IN	('DTOC', 'CTOC')" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND C.DMDT_TRF_CD	IN	('DTIC', 'CTIC', 'DTOC', 'CTOC')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("				AND	C.DMDT_TRF_CD	IN	('DMIF', 'DTIC', 'CTIC')" ).append("\n"); 
		query.append("			#elseif (${io_bnd_flg} == 'O')" ).append("\n"); 
		query.append("				AND	C.DMDT_TRF_CD	IN	('DMOF', 'DTOC', 'CTOC')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND		C.DMDT_CHG_LOC_DIV_CD <> 'SZP'			-- 2010/03/18 추가" ).append("\n"); 
		query.append("		AND		-- 2010/03/25 추가" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		    (C.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'C')" ).append("\n"); 
		query.append("		    OR        " ).append("\n"); 
		query.append("		    (C.DUL_TP_EXPT_FLG = 'N')" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		-- 2010.11.01 HOLD Status 제외 조건 추가" ).append("\n"); 
		query.append("		AND" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				C.DMDT_CHG_STS_CD = 'I'" ).append("\n"); 
		query.append("				AND 'H' NOT IN (SELECT DMDT_AR_IF_CD FROM DMT_INV_MN WHERE DMDT_INV_NO = C.DMDT_INV_NO)" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("			(C.DMDT_CHG_STS_CD <> 'I')" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--	    AND		C.ORG_CHG_AMT		>	0		20091222 수정" ).append("\n"); 
		query.append("	    AND		F.ACCT_XCH_RT_YRMON	=	TO_CHAR(C.TO_MVMT_DT,'YYYYMM')" ).append("\n"); 
		query.append("	    AND		F.ACCT_XCH_RT_LVL	=	'1'" ).append("\n"); 
		query.append("	    AND		F.CURR_CD			=	C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    GROUP BY    OFC_CD, OFC_RHQ_CD," ).append("\n"); 
		query.append("	                DECODE(SUBSTR(C.DMDT_TRF_CD, 2, 1), 'M', 'DEM', 'DET')," ).append("\n"); 
		query.append("	                DECODE(SUBSTR(C.DMDT_TRF_CD, 3, 1), 'I', 'I/B', 'O/B')," ).append("\n"); 
		query.append("	                DECODE(@[curr_flg], 'U', 'USD', C.BZC_TRF_CURR_CD )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("	  GROUP BY DECODE(@[grp_flg], 'R', OFC_RHQ_CD, 'O', OFC_CD)," ).append("\n"); 
		query.append("			TARIFF," ).append("\n"); 
		query.append("			IO_BND," ).append("\n"); 
		query.append("			O_CURR " ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("TMP2 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT	/*+ MATERIALIZE */" ).append("\n"); 
		query.append("			BB.OFC, " ).append("\n"); 
		query.append("			BB.TARIFF, " ).append("\n"); 
		query.append("			BB.IO_BND, " ).append("\n"); 
		query.append("			BB.O_CURR, " ).append("\n"); 
		query.append("			BB.O_COUNT, " ).append("\n"); 
		query.append("			BB.O_AMT, " ).append("\n"); 
		query.append("			SUM(BB.I_COUNT) 	I_COUNT, " ).append("\n"); 
		query.append("			SUM(BB.I_AMT)		I_AMT, " ).append("\n"); 
		query.append("			-- SUM(BB.M_COUNT)	M_COUNT, " ).append("\n"); 
		query.append("			SUM(BB.M_AMT)		M_AMT," ).append("\n"); 
		query.append("			SUM(BB.AF_COUNT)	AF_COUNT, " ).append("\n"); 
		query.append("			SUM(BB.AF_AMT)		AF_AMT, " ).append("\n"); 
		query.append("			SUM(BB.MF_COUNT)	MF_COUNT, " ).append("\n"); 
		query.append("			SUM(BB.MF_AMT)		MF_AMT, " ).append("\n"); 
		query.append("			SUM(BB.BF_COUNT)	BF_COUNT, " ).append("\n"); 
		query.append("			SUM(BB.BF_AMT)		BF_AMT," ).append("\n"); 
		query.append("			SUM(BB.UF_COUNT)	UF_COUNT, " ).append("\n"); 
		query.append("			SUM(BB.UF_AMT)		UF_AMT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("		SELECT	  DECODE(@[grp_flg], 'R', OFC_RHQ_CD, 'O', OFC_CD) OFC," ).append("\n"); 
		query.append("                  BB.TARIFF," ).append("\n"); 
		query.append("                  BB.IO_BND," ).append("\n"); 
		query.append("                  BB.O_CURR," ).append("\n"); 
		query.append("                  SUM(BB.O_COUNT)   O_COUNT," ).append("\n"); 
		query.append("                  SUM(BB.O_AMT)     O_AMT," ).append("\n"); 
		query.append("                  -- SUM(BB.I_CURR)	I_CURR," ).append("\n"); 
		query.append("                  SUM(BB.I_COUNT)   I_COUNT," ).append("\n"); 
		query.append("                  SUM(BB.I_AMT)     I_AMT," ).append("\n"); 
		query.append("                  SUM(BB.M_AMT)		M_AMT," ).append("\n"); 
		query.append("                  SUM(BB.AF_COUNT)	AF_COUNT," ).append("\n"); 
		query.append("                  SUM(BB.AF_AMT)	AF_AMT," ).append("\n"); 
		query.append("                  SUM(BB.MF_COUNT)	MF_COUNT," ).append("\n"); 
		query.append("                  SUM(BB.MF_AMT)	MF_AMT," ).append("\n"); 
		query.append("                  SUM(BB.BF_COUNT)	BF_COUNT," ).append("\n"); 
		query.append("                  SUM(BB.BF_AMT)	BF_AMT," ).append("\n"); 
		query.append("                  SUM(BB.UF_COUNT)	UF_COUNT," ).append("\n"); 
		query.append("                  SUM(BB.UF_AMT)	UF_AMT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT  C.OFC_N8TH_LVL_CD    OFC_CD," ).append("\n"); 
		query.append("              C.OFC_N2ND_LVL_CD     OFC_RHQ_CD," ).append("\n"); 
		query.append("                    DECODE(SUBSTR(V.DMDT_TRF_CD, 2, 1), 'M', 'DEM', 'DET') TARIFF," ).append("\n"); 
		query.append("                    DECODE(SUBSTR(V.DMDT_TRF_CD, 3, 1), 'I', 'I/B', 'O/B') IO_BND," ).append("\n"); 
		query.append("                    DECODE(@[curr_flg], 'U', 'USD', V.INV_CURR_CD ) O_CURR," ).append("\n"); 
		query.append("                    0 O_COUNT," ).append("\n"); 
		query.append("                    0 O_AMT," ).append("\n"); 
		query.append("                    DECODE(SUBSTR(V.DMDT_INV_NO, 3, 1), 'M', 0, COUNT(ID.CNTR_NO)) I_COUNT," ).append("\n"); 
		query.append("                    DECODE(SUBSTR(V.DMDT_INV_NO, 3, 1), 'M', 0, ROUND(SUM( DECODE(@[curr_flg], 'U', NVL(ID.CNTR_INV_AMT, 0) /F.USD_LOCL_XCH_RT, NVL(ID.CNTR_INV_AMT, 0) )), 2)) I_AMT," ).append("\n"); 
		query.append("                    DECODE(SUBSTR(V.DMDT_INV_NO, 3, 1), 'M', ROUND(SUM(DISTINCT DECODE(@[curr_flg], 'U', V.INV_CHG_AMT/F.USD_LOCL_XCH_RT, V.INV_CHG_AMT)), 2), 0) M_AMT," ).append("\n"); 
		query.append("                    0 AF_COUNT, 0 AF_AMT, 0 MF_COUNT, 0 MF_AMT, 0 BF_COUNT, 0 BF_AMT, 0 UF_COUNT, 0 UF_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            FROM    DMT_OFC_LVL_V   C," ).append("\n"); 
		query.append("                    GL_MON_XCH_RT   F," ).append("\n"); 
		query.append("                    DMT_INV_MN      V," ).append("\n"); 
		query.append("                    DMT_INV_DTL		ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            WHERE   V.CRE_DT    BETWEEN TO_DATE(@[start_dt], 'YYYYMMDD') AND TO_DATE(@[end_dt], 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("            AND     V.DMDT_AR_IF_CD     <> 'H'                /*    HOLD EXCEPTION    */" ).append("\n"); 
		query.append("            AND     C.OFC_N8TH_LVL_CD   =  V.CRE_OFC_CD" ).append("\n"); 
		query.append("            AND	 V.DMDT_INV_STS_CD	= 'I'" ).append("\n"); 
		query.append("	 		#if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("				AND		V.CRE_OFC_CD	IN (" ).append("\n"); 
		query.append("					#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All') " ).append("\n"); 
		query.append("	            AND		V.CRE_OFC_CD	IN (" ).append("\n"); 
		query.append("				                            SELECT OFC_CD" ).append("\n"); 
		query.append("				                            FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("				                            START WITH OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("				                            CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("				                            )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("              AND   V.DMDT_INV_NO = ID.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("              AND V.CRE_OFC_CD = ID.CRE_OFC_CD(+)              " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* DEM/DET */" ).append("\n"); 
		query.append("			#if (${chg_flg} == 'M')" ).append("\n"); 
		query.append("				#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD = 'DMIF'" ).append("\n"); 
		query.append("				#elseif (${io_bnd_flg} == 'O')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD = 'DMOF'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND V.DMDT_TRF_CD	IN	('DMIF', 'DMOF')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#elseif (${chg_flg} == 'T') " ).append("\n"); 
		query.append("				#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD	IN	('DTIC', 'CTIC')" ).append("\n"); 
		query.append("				#elseif (${io_bnd_flg} == 'O')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD	IN	('DTOC', 'CTOC')" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND V.DMDT_TRF_CD	IN	('DTIC', 'CTIC', 'DTOC', 'CTOC')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD	IN	('DMIF', 'DTIC', 'CTIC')" ).append("\n"); 
		query.append("				#elseif (${io_bnd_flg} == 'O')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD	IN	('DMOF', 'DTOC', 'CTOC')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND        F.ACCT_XCH_RT_YRMON  =    TO_CHAR(V.CRE_DT,'YYYYMM')" ).append("\n"); 
		query.append("            AND        F.ACCT_XCH_RT_LVL    =    '1'" ).append("\n"); 
		query.append("            AND        F.CURR_CD            =    V.INV_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            GROUP BY    C.OFC_N8TH_LVL_CD, C.OFC_N2ND_LVL_CD," ).append("\n"); 
		query.append("                        V.DMDT_INV_NO," ).append("\n"); 
		query.append("                        DECODE(SUBSTR(V.DMDT_TRF_CD, 2, 1), 'M', 'DEM', 'DET')," ).append("\n"); 
		query.append("                        DECODE(SUBSTR(V.DMDT_TRF_CD, 3, 1), 'I', 'I/B', 'O/B')," ).append("\n"); 
		query.append("                        DECODE(@[curr_flg], 'U', 'USD', V.INV_CURR_CD )" ).append("\n"); 
		query.append("        ) BB" ).append("\n"); 
		query.append("GROUP BY	DECODE(@[grp_flg], 'R', OFC_RHQ_CD, 'O', OFC_CD)," ).append("\n"); 
		query.append("                    BB.TARIFF," ).append("\n"); 
		query.append("                    BB.IO_BND," ).append("\n"); 
		query.append("                    BB.O_CURR   " ).append("\n"); 
		query.append("    ) BB" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	GROUP BY	BB.OFC," ).append("\n"); 
		query.append("				BB.TARIFF," ).append("\n"); 
		query.append("				BB.IO_BND," ).append("\n"); 
		query.append("				BB.O_CURR," ).append("\n"); 
		query.append("				BB.O_COUNT," ).append("\n"); 
		query.append("				BB.O_AMT" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("TMP3 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT	/*+ MATERIALIZE */	" ).append("\n"); 
		query.append("			DECODE(@[grp_flg], 'R', OFC_RHQ_CD, 'O', OFC_CD) OFC," ).append("\n"); 
		query.append("			CC.TARIFF," ).append("\n"); 
		query.append("			CC.IO_BND," ).append("\n"); 
		query.append("			CC.O_CURR," ).append("\n"); 
		query.append("			SUM(CC.O_COUNT)   AS O_COUNT," ).append("\n"); 
		query.append("			SUM(CC.O_AMT)     AS O_AMT," ).append("\n"); 
		query.append("			-- SUM(CC.I_CURR)    AS I_CURR," ).append("\n"); 
		query.append("			SUM(CC.I_COUNT)   AS I_COUNT," ).append("\n"); 
		query.append("			SUM(CC.I_AMT)     AS I_AMT," ).append("\n"); 
		query.append("			SUM(CC.AF_COUNT) AF_COUNT," ).append("\n"); 
		query.append("			SUM(CC.AF_AMT) AF_AMT ," ).append("\n"); 
		query.append("			SUM(CC.MF_AMT) MF_AMT," ).append("\n"); 
		query.append("			SUM(CC.BF_COUNT) BF_COUNT," ).append("\n"); 
		query.append("			SUM(CC.I_AMT) BF_AMT," ).append("\n"); 
		query.append("			SUM(CC.UF_COUNT) UF_COUNT," ).append("\n"); 
		query.append("			SUM(CC.UF_AMT) UF_AMT           " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("			SELECT  C.OFC_N8TH_LVL_CD    OFC_CD," ).append("\n"); 
		query.append("					C.OFC_N2ND_LVL_CD     OFC_RHQ_CD," ).append("\n"); 
		query.append("					DECODE(SUBSTR(V.DMDT_TRF_CD, 2, 1), 'M', 'DEM', 'DET') TARIFF," ).append("\n"); 
		query.append("					DECODE(SUBSTR(V.DMDT_TRF_CD, 3, 1), 'I', 'I/B', 'O/B') IO_BND," ).append("\n"); 
		query.append("					DECODE(@[curr_flg], 'U', 'USD', V.INV_CURR_CD ) O_CURR," ).append("\n"); 
		query.append("					0 O_COUNT," ).append("\n"); 
		query.append("					0 O_AMT," ).append("\n"); 
		query.append("					-- '' I_CURR," ).append("\n"); 
		query.append("					0 I_COUNT," ).append("\n"); 
		query.append("					0 I_AMT," ).append("\n"); 
		query.append("					0 M_COUNT," ).append("\n"); 
		query.append("					0 M_AMT," ).append("\n"); 
		query.append("					DECODE(SUBSTR(V.DMDT_INV_NO, 3, 1), 'M', 0, SUM(DECODE(V.DMDT_INV_STS_CD, 'I', 1, 'X', 1, 'C', -1) )) AF_COUNT, -- 20091222 수정" ).append("\n"); 
		query.append("					DECODE(SUBSTR(V.DMDT_INV_NO, 3, 1), 'M', 0, ROUND(SUM( DECODE(V.DMDT_AR_IF_CD, 'Y', DECODE(@[curr_flg], 'U', NVL(ID.CNTR_INV_AMT, 0) /F.USD_LOCL_XCH_RT, NVL(ID.CNTR_INV_AMT, 0) ) ) ), 2) ) AF_AMT,	-- 20091222 수정" ).append("\n"); 
		query.append("					DECODE(SUBSTR(V.DMDT_INV_NO, 3, 1), 'M', ROUND(SUM(DISTINCT DECODE(@[curr_flg], 'U', V.INV_CHG_AMT/F.USD_LOCL_XCH_RT, V.INV_CHG_AMT)), 2), 0) MF_AMT," ).append("\n"); 
		query.append("					0 BF_COUNT," ).append("\n"); 
		query.append("					0 BF_AMT," ).append("\n"); 
		query.append("					0 UF_COUNT," ).append("\n"); 
		query.append("					0 UF_AMT" ).append("\n"); 
		query.append("			FROM	DMT_OFC_LVL_V   C," ).append("\n"); 
		query.append("					GL_MON_XCH_RT   F," ).append("\n"); 
		query.append("					DMT_INV_MN      V," ).append("\n"); 
		query.append("			    	DMT_INV_DTL		ID	-- 20091222 수정" ).append("\n"); 
		query.append("				                        " ).append("\n"); 
		query.append("			WHERE	V.AR_IF_DT BETWEEN TO_DATE(@[start_dt], 'YYYYMMDD') AND TO_DATE(@[end_dt], 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("			AND		V.DMDT_AR_IF_CD = 'Y' 			/*    HOLD EXCEPTION    */" ).append("\n"); 
		query.append("			AND		C.OFC_N8TH_LVL_CD = V.AR_IF_OFC_CD" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("			#if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("				AND		V.AR_IF_OFC_CD	IN (" ).append("\n"); 
		query.append("						#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All') " ).append("\n"); 
		query.append("				AND		V.AR_IF_OFC_CD	IN (" ).append("\n"); 
		query.append("				                            SELECT OFC_CD" ).append("\n"); 
		query.append("				                            FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("				                            START WITH OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("				                            CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("	                            			)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND		V.DMDT_INV_NO = ID.DMDT_INV_NO(+)	-- 20091222 수정" ).append("\n"); 
		query.append("			AND		V.CRE_OFC_CD = ID.CRE_OFC_CD(+)    	-- 20091222 수정          " ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			#if (${chg_flg} == 'M')" ).append("\n"); 
		query.append("				#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD = 'DMIF'" ).append("\n"); 
		query.append("				#elseif (${io_bnd_flg} == 'O')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD = 'DMOF'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND V.DMDT_TRF_CD	IN	('DMIF', 'DMOF')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#elseif (${chg_flg} == 'T') " ).append("\n"); 
		query.append("				#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD	IN	('DTIC', 'CTIC')" ).append("\n"); 
		query.append("				#elseif (${io_bnd_flg} == 'O')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD	IN	('DTOC', 'CTOC')" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND V.DMDT_TRF_CD	IN	('DTIC', 'CTIC', 'DTOC', 'CTOC')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD	IN	('DMIF', 'DTIC', 'CTIC')" ).append("\n"); 
		query.append("				#elseif (${io_bnd_flg} == 'O')" ).append("\n"); 
		query.append("					AND	V.DMDT_TRF_CD	IN	('DMOF', 'DTOC', 'CTOC')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND		F.ACCT_XCH_RT_YRMON = TO_CHAR(V.CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("			AND		F.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("			AND		F.CURR_CD = V.INV_CURR_CD" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			GROUP BY    C.OFC_N8TH_LVL_CD, C.OFC_N2ND_LVL_CD,	-- 20091222 수정" ).append("\n"); 
		query.append("						V.DMDT_INV_NO," ).append("\n"); 
		query.append("						DECODE(SUBSTR(V.DMDT_TRF_CD, 2, 1), 'M', 'DEM', 'DET'), " ).append("\n"); 
		query.append("						DECODE(SUBSTR(V.DMDT_TRF_CD, 3, 1), 'I', 'I/B', 'O/B'), " ).append("\n"); 
		query.append("						DECODE(@[curr_flg], 'U', 'USD', V.INV_CURR_CD )" ).append("\n"); 
		query.append("		) CC" ).append("\n"); 
		query.append("		GROUP BY    DECODE(@[grp_flg], 'R', OFC_RHQ_CD, 'O', OFC_CD),          " ).append("\n"); 
		query.append("                    CC.TARIFF," ).append("\n"); 
		query.append("                    CC.IO_BND," ).append("\n"); 
		query.append("                    CC.O_CURR" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("TMP4 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */" ).append("\n"); 
		query.append("			DECODE(@[grp_flg], 'R', OFC_RHQ_CD, 'O', OFC_CD) OFC," ).append("\n"); 
		query.append("            CC.TARIFF," ).append("\n"); 
		query.append("            CC.IO_BND," ).append("\n"); 
		query.append("            CC.O_CURR,            " ).append("\n"); 
		query.append("            SUM(CC.CHG_AMT) AS CHG_AMT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		SELECT	/*+NO_MERGE(L)  USE_NL(L M C F) ORDERED*/" ).append("\n"); 
		query.append("	      		L.OFC_N8TH_LVL_CD   OFC_CD," ).append("\n"); 
		query.append("                L.OFC_N2ND_LVL_CD   OFC_RHQ_CD," ).append("\n"); 
		query.append("	      		C.CHG_CD TARIFF," ).append("\n"); 
		query.append("	      		DECODE(M.IO_BND_CD, 'I', 'I/B', 'O/B') IO_BND," ).append("\n"); 
		query.append("	      		DECODE(@[curr_flg], 'U', 'USD', C.CURR_CD) 	O_CURR," ).append("\n"); 
		query.append("	      		ROUND(SUM(DECODE(@[curr_flg], 'U', C.CHG_AMT/F.USD_LOCL_XCH_RT, C.CHG_AMT)), 2) CHG_AMT" ).append("\n"); 
		query.append("	    FROM	INV_AR_MN		M," ).append("\n"); 
		query.append("				INV_AR_CHG		C, " ).append("\n"); 
		query.append("				GL_MON_XCH_RT	F," ).append("\n"); 
		query.append("				DMT_OFC_LVL_V	L" ).append("\n"); 
		query.append("	    WHERE	M.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("		AND		M.BL_INV_IF_DT BETWEEN @[start_dt] AND @[end_dt]" ).append("\n"); 
		query.append("		AND		L.OFC_N8TH_LVL_CD = M.AR_OFC_CD" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("			AND  M.AR_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All') " ).append("\n"); 
		query.append("			AND	M.AR_OFC_CD IN (" ).append("\n"); 
		query.append("								SELECT OFC_CD" ).append("\n"); 
		query.append("								FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("								START WITH OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("								CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		#if (${chg_flg} == '') --ALL 을 선택 했을 경우" ).append("\n"); 
		query.append("			AND C.CHG_CD IN ('DEM','DET')" ).append("\n"); 
		query.append("		#elseif (${chg_flg} == 'M')" ).append("\n"); 
		query.append("			AND C.CHG_CD = 'DEM'" ).append("\n"); 
		query.append("		#elseif (${chg_flg} == 'T')   " ).append("\n"); 
		query.append("			AND C.CHG_CD = 'DET' " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		#if (${io_bnd_flg} == 'I')" ).append("\n"); 
		query.append("			AND  M.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("		#elseif (${io_bnd_flg} == 'O') " ).append("\n"); 
		query.append("			AND  M.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		AND (M.REV_TP_CD IN ('B','C') OR (M.REV_TP_CD = 'M' AND M.REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("		AND F.ACCT_XCH_RT_YRMON = SUBSTR(M.BL_INV_IF_DT, 1, 6)" ).append("\n"); 
		query.append("		AND F.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("		AND F.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		GROUP BY    --M.AR_OFC_CD," ).append("\n"); 
		query.append("                    L.OFC_N8TH_LVL_CD, L.OFC_N2ND_LVL_CD," ).append("\n"); 
		query.append("                    C.CHG_CD," ).append("\n"); 
		query.append("                    DECODE(M.IO_BND_CD, 'I', 'I/B', 'O/B'), " ).append("\n"); 
		query.append("                    DECODE(@[curr_flg], 'U', 'USD', C.CURR_CD)   " ).append("\n"); 
		query.append("	) CC" ).append("\n"); 
		query.append("	GROUP BY    DECODE(@[grp_flg], 'R', OFC_RHQ_CD, 'O', OFC_CD)," ).append("\n"); 
		query.append("				TARIFF," ).append("\n"); 
		query.append("                CC.IO_BND," ).append("\n"); 
		query.append("                CC.O_CURR" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("TMP5 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT /*+ MATERIALIZE */" ).append("\n"); 
		query.append("          COALESCE(CC.OFC, I.OFC) OFC, " ).append("\n"); 
		query.append("          COALESCE(CC.TARIFF, I.TARIFF) TARIFF, " ).append("\n"); 
		query.append("          COALESCE(CC.IO_BND, I.IO_BND) IO_BND, " ).append("\n"); 
		query.append("          COALESCE(CC.O_CURR, I.O_CURR) O_CURR, " ).append("\n"); 
		query.append("          CC.O_COUNT, CC.O_AMT, " ).append("\n"); 
		query.append("       -- CC.I_CURR," ).append("\n"); 
		query.append("          CC.I_COUNT, " ).append("\n"); 
		query.append("          CC.I_AMT, " ).append("\n"); 
		query.append("          SUM(CC.AF_COUNT) AF_COUNT, " ).append("\n"); 
		query.append("          SUM(CC.AF_AMT) AF_AMT," ).append("\n"); 
		query.append("       -- SUM(CC.MF_COUNT) MF_COUNT," ).append("\n"); 
		query.append("          SUM(CC.MF_AMT) MF_AMT, " ).append("\n"); 
		query.append("          SUM(CC.BF_COUNT) BF_COUNT, " ).append("\n"); 
		query.append("          SUM(I.CHG_AMT) BF_AMT, " ).append("\n"); 
		query.append("          SUM(CC.UF_COUNT) UF_COUNT, " ).append("\n"); 
		query.append("          SUM(CC.UF_AMT) UF_AMT" ).append("\n"); 
		query.append("    FROM TMP3 CC" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("		 FULL OUTER JOIN " ).append("\n"); 
		query.append("    	 TMP4 I" ).append("\n"); 
		query.append("         ON ( CC.OFC = I.OFC" ).append("\n"); 
		query.append("              AND CC.TARIFF = I.TARIFF" ).append("\n"); 
		query.append("              AND CC.IO_BND = I.IO_BND" ).append("\n"); 
		query.append("              AND CC.O_CURR = I.O_CURR )" ).append("\n"); 
		query.append("	GROUP BY	COALESCE(CC.OFC, I.OFC) , COALESCE(CC.TARIFF, I.TARIFF) , COALESCE(CC.IO_BND, I.IO_BND), " ).append("\n"); 
		query.append("				COALESCE(CC.O_CURR, I.O_CURR) , CC.O_COUNT, CC.O_AMT, CC.I_COUNT, CC.I_AMT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("SELECT	COALESCE(A.OFC, B.OFC, C.OFC) OFC_CD," ).append("\n"); 
		query.append("        COALESCE(A.TARIFF, B.TARIFF, C.TARIFF) TARIFF," ).append("\n"); 
		query.append("        COALESCE(A.IO_BND, B.IO_BND, C.IO_BND) IO_BND," ).append("\n"); 
		query.append("        COALESCE(A.O_CURR, B.O_CURR, C.O_CURR) CURR_CD," ).append("\n"); 
		query.append("        SUM(NVL(A.O_COUNT, 0)) BILL_CNTR," ).append("\n"); 
		query.append("        SUM(NVL(A.O_AMT, 0)) BILL_AMT," ).append("\n"); 
		query.append("      -- MAX(B.I_CURR) I_CURR," ).append("\n"); 
		query.append("        SUM(NVL(B.I_COUNT, 0)) INV_CNTR," ).append("\n"); 
		query.append("        SUM(NVL(B.I_AMT, 0)) INV_AMT," ).append("\n"); 
		query.append("      -- SUM(NVL(B.M_COUNT, 0))    INV_M_CNTR," ).append("\n"); 
		query.append("        SUM(NVL(B.M_AMT, 0)) INV_M_AMT," ).append("\n"); 
		query.append("        SUM(NVL(C.AF_COUNT, 0)) COLL_CNTR," ).append("\n"); 
		query.append("        SUM(NVL(C.AF_AMT, 0)) COLL_AMT," ).append("\n"); 
		query.append("      -- SUM(NVL(C.MF_COUNT, 0))    COLL_M_CNTR," ).append("\n"); 
		query.append("        SUM(NVL(C.MF_AMT, 0)) COLL_M_AMT," ).append("\n"); 
		query.append("        SUM(NVL(C.BF_AMT, 0)) COLL_OTH_AMT" ).append("\n"); 
		query.append("FROM TMP1 A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 FULL OUTER JOIN " ).append("\n"); 
		query.append("     TMP2 B" ).append("\n"); 
		query.append("		ON (	B.OFC	 = A.OFC" ).append("\n"); 
		query.append("            AND B.TARIFF = A.TARIFF" ).append("\n"); 
		query.append("            AND B.IO_BND = A.IO_BND" ).append("\n"); 
		query.append("            AND B.O_CURR = A.O_CURR ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     FULL OUTER JOIN" ).append("\n"); 
		query.append("     TMP5 C" ).append("\n"); 
		query.append("		ON (  C.OFC	   = A.OFC" ).append("\n"); 
		query.append("	      AND C.TARIFF = A.TARIFF" ).append("\n"); 
		query.append("	      AND C.IO_BND = A.IO_BND" ).append("\n"); 
		query.append("	      AND C.O_CURR = A.O_CURR )" ).append("\n"); 
		query.append("GROUP BY COALESCE(A.OFC, B.OFC, C.OFC), COALESCE(A.TARIFF, B.TARIFF, C.TARIFF), COALESCE(A.IO_BND, B.IO_BND, C.IO_BND), COALESCE(A.O_CURR, B.O_CURR, C.O_CURR)" ).append("\n"); 
		query.append("ORDER BY COALESCE(A.OFC, B.OFC, C.OFC), COALESCE(A.TARIFF, B.TARIFF, C.TARIFF), COALESCE(A.IO_BND, B.IO_BND, C.IO_BND)" ).append("\n"); 

	}
}
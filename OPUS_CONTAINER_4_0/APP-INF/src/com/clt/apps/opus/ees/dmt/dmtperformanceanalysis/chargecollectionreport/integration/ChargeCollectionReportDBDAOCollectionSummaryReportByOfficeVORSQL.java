/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChargeCollectionReportDBDAOCollectionSummaryReportByOfficeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCollectionReportDBDAOCollectionSummaryReportByOfficeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Collection Status Report by Office의 상세 내역을 조회
	  * </pre>
	  */
	public ChargeCollectionReportDBDAOCollectionSummaryReportByOfficeVORSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration").append("\n"); 
		query.append("FileName : ChargeCollectionReportDBDAOCollectionSummaryReportByOfficeVORSQL").append("\n"); 
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
		query.append("	OFC_CD," ).append("\n"); 
		query.append("	DMDT_TRF_CD," ).append("\n"); 
		query.append("	TTL_CNTR," ).append("\n"); 
		query.append("	CURR_CD," ).append("\n"); 
		query.append("	INCR_CNTR," ).append("\n"); 
		query.append("	INCR_AMT," ).append("\n"); 
		query.append("	CMDT_CNTR," ).append("\n"); 
		query.append("	CMDT_AMT," ).append("\n"); 
		query.append("	EXPT_CNTR," ).append("\n"); 
		query.append("	EXPT_AMT," ).append("\n"); 
		query.append("	DC_CNTR," ).append("\n"); 
		query.append("	DC_AMT," ).append("\n"); 
		query.append("	BILL_CNTR," ).append("\n"); 
		query.append("	BILL_AMT," ).append("\n"); 
		query.append("	INV_CNTR," ).append("\n"); 
		query.append("	INV_AMT," ).append("\n"); 
		query.append("	COLL_CNTR," ).append("\n"); 
		query.append("	COLL_AMT," ).append("\n"); 
		query.append("	ROUND( COLL_AMT / DECODE(INCR_AMT, 0, 1, INCR_AMT), 4) * 100	COLL_RTO_A," ).append("\n"); 
		query.append("	ROUND( COLL_AMT / DECODE(BILL_AMT, 0, 1, BILL_AMT), 4) * 100	COLL_RTO_B," ).append("\n"); 
		query.append("	ROUND( COLL_AMT / DECODE(INV_AMT, 0, 1, INV_AMT), 4) * 100		COLL_RTO_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		X.OFC_CD                OFC_CD," ).append("\n"); 
		query.append("		X.DMDT_TRF_CD           DMDT_TRF_CD," ).append("\n"); 
		query.append("		SUM(TTL_CNTR)           TTL_CNTR," ).append("\n"); 
		query.append("		X.CURR_CD               CURR_CD," ).append("\n"); 
		query.append("		SUM(X.INCR_CNTR  )      INCR_CNTR," ).append("\n"); 
		query.append("		SUM(X.INCR_AMT   )      INCR_AMT," ).append("\n"); 
		query.append("		SUM(X.CMDT_CNTR  )      CMDT_CNTR," ).append("\n"); 
		query.append("		SUM(X.CMDT_AMT   )      CMDT_AMT," ).append("\n"); 
		query.append("		SUM(X.EXPT_CNTR  )      EXPT_CNTR," ).append("\n"); 
		query.append("		SUM(X.EXPT_AMT   )      EXPT_AMT," ).append("\n"); 
		query.append("		SUM(X.DC_CNTR    )      DC_CNTR," ).append("\n"); 
		query.append("		SUM(X.DC_AMT     )      DC_AMT," ).append("\n"); 
		query.append("		SUM(X.BILL_CNTR  )      BILL_CNTR," ).append("\n"); 
		query.append("		SUM(X.BILL_AMT   )      BILL_AMT," ).append("\n"); 
		query.append("		SUM(X.INV_CNTR   )      INV_CNTR," ).append("\n"); 
		query.append("		SUM(X.INV_AMT    )      INV_AMT," ).append("\n"); 
		query.append("		SUM(X.COLL_CNTR  )      COLL_CNTR," ).append("\n"); 
		query.append("		SUM(X.COLL_AMT   )      COLL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			#if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("				C.OFC_RHQ_CD" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				C.OFC_CD" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AS OFC_CD," ).append("\n"); 
		query.append("			C.DMDT_TRF_CD," ).append("\n"); 
		query.append("			COUNT (C.CNTR_NO) TTL_CNTR," ).append("\n"); 
		query.append("			C.BZC_TRF_CURR_CD CURR_CD," ).append("\n"); 
		query.append("			SUM( DECODE( NVL(C.ORG_CHG_AMT, 0), 0, 0, 1 ) ) INCR_CNTR," ).append("\n"); 
		query.append("			ROUND ( SUM ( DECODE( @[curr_flg], 'U', C.ORG_CHG_AMT  / F.USD_LOCL_XCH_RT, C.ORG_CHG_AMT  ) ), 2 ) INCR_AMT," ).append("\n"); 
		query.append("			SUM( DECODE( NVL(C.CMDT_EXPT_AMT, 0), 0, 0, 1 ) ) CMDT_CNTR," ).append("\n"); 
		query.append("			ROUND ( SUM ( DECODE( @[curr_flg], 'U', NVL(C.CMDT_EXPT_AMT, 0) / F.USD_LOCL_XCH_RT, NVL(C.CMDT_EXPT_AMT, 0) ) ), 2 ) CMDT_AMT," ).append("\n"); 
		query.append("			SUM( DECODE( NVL(C.SC_RFA_EXPT_AMT, 0), 0, 0, 1 ) ) EXPT_CNTR," ).append("\n"); 
		query.append("			ROUND ( SUM ( DECODE( @[curr_flg], 'U', C.SC_RFA_EXPT_AMT / F.USD_LOCL_XCH_RT, C.SC_RFA_EXPT_AMT) ), 2 ) EXPT_AMT," ).append("\n"); 
		query.append("			SUM( DECODE( NVL(C.AFT_EXPT_DC_AMT, 0), 0, 0, 1 ) ) DC_CNTR," ).append("\n"); 
		query.append("			ROUND ( SUM ( DECODE( @[curr_flg], 'U', C.AFT_EXPT_DC_AMT  / F.USD_LOCL_XCH_RT, C.AFT_EXPT_DC_AMT  ) ), 2 ) DC_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			/* BILLABLE */" ).append("\n"); 
		query.append("			SUM( DECODE( NVL(C.BIL_AMT, 0), 0, 0, 1 ) ) BILL_CNTR," ).append("\n"); 
		query.append("			ROUND( SUM( DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT ) )" ).append("\n"); 
		query.append("				, 2 ) BILL_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			/* INVOICE */" ).append("\n"); 
		query.append("			SUM( DECODE( V.DMDT_INV_STS_CD, 'I', 1, 0 ) ) INV_CNTR," ).append("\n"); 
		query.append("			ROUND( SUM( DECODE( V.DMDT_INV_STS_CD, 'I', DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT), 0) )" ).append("\n"); 
		query.append("				, 2 ) INV_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			/* COLLECTION */" ).append("\n"); 
		query.append("			SUM( DECODE( V.DMDT_AR_IF_CD, 'Y', 1, 0 ) ) COLL_CNTR," ).append("\n"); 
		query.append("			ROUND(	SUM( DECODE (V.DMDT_AR_IF_CD, 'Y', DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT )" ).append("\n"); 
		query.append("								 , 0 ) )" ).append("\n"); 
		query.append("				, 2 ) COLL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#*" ).append("\n"); 
		query.append("			/* COLLECTION RATIO (%) VS INCURRED */" ).append("\n"); 
		query.append("			ROUND(	SUM( DECODE (V.DMDT_AR_IF_CD, 'Y', DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT )" ).append("\n"); 
		query.append("								  , 0 ) )" ).append("\n"); 
		query.append("					/ SUM( DECODE( @[curr_flg], 'U', C.ORG_CHG_AMT  / F.USD_LOCL_XCH_RT, C.ORG_CHG_AMT ) )" ).append("\n"); 
		query.append("				 , 4) * 100 AS COLL_RTO_A," ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			/* COLLECTION RATIO (%) VS BILLABLE */" ).append("\n"); 
		query.append("			ROUND( SUM( DECODE (V.DMDT_AR_IF_CD , 'Y' , DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT )" ).append("\n"); 
		query.append("								  , 0 ) )" ).append("\n"); 
		query.append("					/ DECODE(  SUM( DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT) ), 0, 1," ).append("\n"); 
		query.append("							SUM( DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT) ) )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				 , 4 ) * 100 AS COLL_RTO_B," ).append("\n"); 
		query.append("			/* _________ DIVISOR IS EQUAL TO ZERO ORA-01476 방지 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			/* COLLECTION RATIO (%) VS INVOICED */" ).append("\n"); 
		query.append("			ROUND( SUM( DECODE ( V.DMDT_AR_IF_CD, 'Y', DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT )" ).append("\n"); 
		query.append("								 ,0 ) )" ).append("\n"); 
		query.append("					/ DECODE (   V.DMDT_INV_STS_CD, 'I'," ).append("\n"); 
		query.append("						   DECODE (" ).append("\n"); 
		query.append("							SUM ( DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT ) ), 0, 1," ).append("\n"); 
		query.append("								SUM ( DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT ) ) ), 1" ).append("\n"); 
		query.append("				), 4 ) * 100 AS COLL_RTO_C" ).append("\n"); 
		query.append("			/* _________ DIVISOR IS EQUAL TO ZERO ORA-01476 방지 */" ).append("\n"); 
		query.append("		*#" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM	DMT_CHG_CALC		C," ).append("\n"); 
		query.append("				DMT_INV_MN			V," ).append("\n"); 
		query.append("				DMT_CHG_BKG_CNTR	B," ).append("\n"); 
		query.append("				GL_MON_XCH_RT		F" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		WHERE   C.TO_MVMT_DT BETWEEN TO_DATE(@[start_dt],'YYYYMMDD') +.0  AND TO_DATE(@[end_dt],'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("		AND		C.DMDT_CHG_STS_CD	IN	( 'F' ,'C', 'I', 'N')		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("		AND		C.OFC_CD	IN (" ).append("\n"); 
		query.append("				#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All')" ).append("\n"); 
		query.append("		AND		C.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND		C.DMDT_TRF_CD		IN	(		/*_________ MULTI TARIFF TYPE	*/" ).append("\n"); 
		query.append("					#foreach( $trf_cd in ${trf_cd_list} ) " ).append("\n"); 
		query.append("						#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		AND		( C.ORG_CHG_AMT > 0 OR C.BIL_AMT > 0 )" ).append("\n"); 
		query.append("		AND		C.SYS_AREA_GRP_ID	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		AND		C.CNTR_NO			= B.CNTR_NO" ).append("\n"); 
		query.append("		AND		C.CNTR_CYC_NO		= B.CNTR_CYC_NO" ).append("\n"); 
		query.append("		AND		C.DMDT_INV_NO		=	V.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("		AND		C.DMDT_CHG_LOC_DIV_CD <> 'SZP'	-- 2010/03/18 추가" ).append("\n"); 
		query.append("		AND		-- 2010/03/25 추가" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		    (C.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'C')" ).append("\n"); 
		query.append("		    OR" ).append("\n"); 
		query.append("		    (C.DUL_TP_EXPT_FLG = 'N')" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("		AND" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			(C.DMDT_CHG_STS_CD <> 'I')" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("					C.DMDT_CHG_STS_CD   =	'I'" ).append("\n"); 
		query.append("				AND V.DMDT_INV_STS_CD   =	'I'" ).append("\n"); 
		query.append("				AND V.DMDT_AR_IF_CD		<>	'H'" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND		B.DMDT_CNTR_TP_CD	IN (" ).append("\n"); 
		query.append("					#foreach( $cntr_tp in ${cntr_tp_list} )" ).append("\n"); 
		query.append("						#if ($cntr_tp == 'S')" ).append("\n"); 
		query.append("							'F', 'O', 'T', 'P', 'S', 'A'" ).append("\n"); 
		query.append("						#elseif ($cntr_tp == 'D' || $cntr_tp == 'R')" ).append("\n"); 
		query.append("							'$cntr_tp'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						#if($velocityCount < $cntr_tp_list.size()) , #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND		F.ACCT_XCH_RT_YRMON	=	TO_CHAR(C.TO_MVMT_DT,'YYYYMM')" ).append("\n"); 
		query.append("		AND		F.ACCT_XCH_RT_LVL	=	'1'" ).append("\n"); 
		query.append("		AND		F.CURR_CD          	=	C.BZC_TRF_CURR_CD		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		GROUP	BY" ).append("\n"); 
		query.append("				#if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("					C.OFC_RHQ_CD" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					C.OFC_CD" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("				,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("				,V.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("	) X" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	GROUP BY	X.OFC_CD," ).append("\n"); 
		query.append("				X.DMDT_TRF_CD," ).append("\n"); 
		query.append("				X.CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}
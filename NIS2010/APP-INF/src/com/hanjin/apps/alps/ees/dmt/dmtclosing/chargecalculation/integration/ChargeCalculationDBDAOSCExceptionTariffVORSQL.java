/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChargeCalculationDBDAOSCExceptionTariffVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.03.04 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSCExceptionTariffVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception Tariff의 Free Time일수 및 주말, 공휴일 포함 여부를 조회한다
	  * </pre>
	  */
	public ChargeCalculationDBDAOSCExceptionTariffVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_expt_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSCExceptionTariffVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	(	SELECT PROG_OFC_CD" ).append("\n"); 
		query.append("		FROM	DMT_SC_EXPT_VER_PROG    VP" ).append("\n"); 
		query.append("		WHERE	D.PROP_NO			=	VP.PROP_NO" ).append("\n"); 
		query.append("		AND	D.SC_EXPT_VER_SEQ		=	VP.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("		AND	VP.DMDT_EXPT_VER_STS_CD	=  'R'" ).append("\n"); 
		query.append("		AND	ROWNUM = 1" ).append("\n"); 
		query.append("	)	AS  RQST_OFC_CD" ).append("\n"); 
		query.append("	,(	SELECT USR_NM" ).append("\n"); 
		query.append("		FROM COM_USER" ).append("\n"); 
		query.append("		WHERE USR_ID = (SELECT PROG_USR_ID" ).append("\n"); 
		query.append("						FROM	DMT_SC_EXPT_VER_PROG    VP" ).append("\n"); 
		query.append("						WHERE	D.PROP_NO			=	VP.PROP_NO" ).append("\n"); 
		query.append("						AND	D.SC_EXPT_VER_SEQ		=	VP.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("						AND	VP.DMDT_EXPT_VER_STS_CD	=  'R'" ).append("\n"); 
		query.append("						AND	ROWNUM = 1" ).append("\n"); 
		query.append("           				)" ).append("\n"); 
		query.append("	) RQST_USR_NM" ).append("\n"); 
		query.append("	,(	SELECT PROG_OFC_CD" ).append("\n"); 
		query.append("		FROM	DMT_SC_EXPT_VER_PROG    VP" ).append("\n"); 
		query.append("		WHERE	D.PROP_NO				=	VP.PROP_NO" ).append("\n"); 
		query.append("		AND	D.SC_EXPT_VER_SEQ			=	VP.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("		AND   VP.DMDT_EXPT_VER_STS_CD	=  'L'" ).append("\n"); 
		query.append("		AND   ROWNUM =  1" ).append("\n"); 
		query.append("	) APRO_OFC_CD" ).append("\n"); 
		query.append("	,(	SELECT USR_NM" ).append("\n"); 
		query.append("		FROM COM_USER" ).append("\n"); 
		query.append("		WHERE USR_ID = (SELECT	PROG_USR_ID" ).append("\n"); 
		query.append("						FROM	DMT_SC_EXPT_VER_PROG    VP" ).append("\n"); 
		query.append("						WHERE	D.PROP_NO			=	VP.PROP_NO" ).append("\n"); 
		query.append("						AND	D.SC_EXPT_VER_SEQ		=	VP.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("						AND	VP.DMDT_EXPT_VER_STS_CD	=  'L'" ).append("\n"); 
		query.append("						AND	ROWNUM =  1" ).append("\n"); 
		query.append("           				)" ).append("\n"); 
		query.append("	) APRO_USR_NM" ).append("\n"); 
		query.append("	,P.SC_NO		AS SC_APVL_NO" ).append("\n"); 
		query.append("	--,D.FT_ADD_DYS	AS ADD_DYS" ).append("\n"); 
		query.append("	--,F.FT_DYS		AS TTL_DYS	-- TOTAL DAY" ).append("\n"); 
		query.append("	,DECODE(D.FT_ADD_FLG, 'Y', D.FT_ADD_DYS) AS ADD_DYS " ).append("\n"); 
		query.append("	,CASE" ).append("\n"); 
		query.append("	WHEN NVL(D.FT_ADD_FLG, 'N') = 'N' AND NVL(D.FT_ADJ_FLG, 'N') = 'N' THEN" ).append("\n"); 
		query.append("		D.FT_ADD_DYS" ).append("\n"); 
		query.append("	WHEN D.FT_ADD_FLG = 'N' AND D.FT_ADJ_FLG = 'Y' THEN" ).append("\n"); 
		query.append("		F.FT_DYS " ).append("\n"); 
		query.append("	END AS TTL_DYS -- TOTAL DAY" ).append("\n"); 
		query.append("	,D.XCLD_SAT_FLG" ).append("\n"); 
		query.append("	,D.XCLD_SUN_FLG" ).append("\n"); 
		query.append("	,D.XCLD_HOL_FLG" ).append("\n"); 
		query.append("	,D.CURR_CD" ).append("\n"); 
		query.append("	,DECODE( SUBSTR(@[cntr_tpsz_cd], 2, 1)," ).append("\n"); 
		query.append("					'2', R.CNTR_20FT_RT_AMT," ).append("\n"); 
		query.append("					'4', R.CNTR_40FT_RT_AMT," ).append("\n"); 
		query.append("					'5', R.CNTR_HC_RT_AMT," ).append("\n"); 
		query.append("					'7', R.CNTR_45FT_RT_AMT," ).append("\n"); 
		query.append("                    '8', R.CNTR_R9_RT_AMT," ).append("\n"); 
		query.append("                    '9', R.CNTR_R9_RT_AMT   ) CNTR_FT_RT_AMT" ).append("\n"); 
		query.append("	,P.PROP_NO" ).append("\n"); 
		query.append("	,'' SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("	,'' SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append("	,'' SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("	,'' BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_SC_EXPT_VER		M," ).append("\n"); 
		query.append("		DMT_SC_EXPT_GRP     D," ).append("\n"); 
		query.append("		DMT_SC_EXPT_RT_ADJ  R," ).append("\n"); 
		query.append("		DMT_SC_EXPT_FREE_TM F," ).append("\n"); 
		query.append("		PRI_SP_HDR			P" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	D.PROP_NO			=	P.PROP_NO" ).append("\n"); 
		query.append("AND		D.SC_EXPT_VER_SEQ	=	@[sc_expt_ver_seq]" ).append("\n"); 
		query.append("AND		D.SC_EXPT_GRP_SEQ	=	@[sc_expt_grp_seq]" ).append("\n"); 
		query.append("AND		D.PROP_NO			=	M.PROP_NO" ).append("\n"); 
		query.append("AND		D.SC_EXPT_VER_SEQ	=	M.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND     M.DELT_FLG			=   'N'" ).append("\n"); 
		query.append("AND 	M.PROP_NO			=	P.PROP_NO" ).append("\n"); 
		query.append("AND     P.SC_NO				=	TRIM(@[sc_no])" ).append("\n"); 
		query.append("AND		D.PROP_NO			=	R.PROP_NO        (+)" ).append("\n"); 
		query.append("AND		D.SC_EXPT_VER_SEQ	=	R.SC_EXPT_VER_SEQ(+)" ).append("\n"); 
		query.append("AND     D.SC_EXPT_GRP_SEQ	=	R.SC_EXPT_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND     R.RT_SEQ (+)		=	1" ).append("\n"); 
		query.append("AND		D.PROP_NO			=	F.PROP_NO        (+)" ).append("\n"); 
		query.append("AND		D.SC_EXPT_VER_SEQ	=	F.SC_EXPT_VER_SEQ(+)" ).append("\n"); 
		query.append("AND     D.SC_EXPT_GRP_SEQ	=	F.SC_EXPT_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND     F.FT_SEQ (+)		=	1" ).append("\n"); 

	}
}
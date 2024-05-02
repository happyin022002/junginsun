/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchPfSkdEotpSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.01.20 임창빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchPfSkdEotpSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPfSkdEotpSummary
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchPfSkdEotpSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_prod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_ipcgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_ocn_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wrk_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_ipcgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bf_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hist_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_ocn_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_dist",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchPfSkdEotpSummaryRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) AS TTL_CNT" ).append("\n"); 
		query.append(", NVL(SUM(ON_TM),0) AS ON_TM_CNT" ).append("\n"); 
		query.append(", NVL(ROUND((SUM(ON_TM) / COUNT(*)) * 100, 1),0)||'%' AS ON_TM_RT" ).append("\n"); 
		query.append(", NVL(SUM(DECODE(CHK_EOTP01, 'Y', 1, 0)),0) AS EOTP_CNT" ).append("\n"); 
		query.append(", NVL(ROUND((SUM(DECODE(CHK_EOTP01, 'Y', 1, 0)) / COUNT(*) * 100), 1), 0)||'%' AS EOTP_RT01" ).append("\n"); 
		query.append(", NVL(ROUND((SUM(DECODE(CHK_EOTP02, 'Y', 1, 0)) / COUNT(*) * 100), 1), 0)||'%' AS EOTP_RT02" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ON_TM                                                        AS ON_TM" ).append("\n"); 
		query.append(", DECODE(ON_TM, 1, 'Y', 'N')                                 AS ON_TM_YN         /* ON TIME (Y/N)       */" ).append("\n"); 
		query.append(", CLASS                                                      AS VSL_CLASS        /* VESSEL CLASS        */" ).append("\n"); 
		query.append(", VVD                                                        AS VVD" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(ROUND(OLD_PORT_TM, 1)     , '99,990.0'))     AS OLD_PORT_TM" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(ROUND(NEW_PORT_TM, 1)     , '99,990.0'))     AS NEW_PORT_TM" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(TO_NUMBER(NEW_PORT_BF)    , '99,990.0'))     AS NEW_PORT_BUF_TM" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(DECODE(NEW_SPD, 0, LNK_DIST, ROUND((LNK_DIST / NEW_SPD), 1)), '99,990.0')) AS NEW_SEA_TM1" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(TO_NUMBER(NEW_SEA_BF)     , '99,990.0'))     AS NEW_SEA_BUF_TM" ).append("\n"); 
		query.append(", LNK_DIST                                                   AS LNK_DIST" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(MAX_SPD                   , '99,990.0'))     AS MAX_SPD" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(OLD_SPD                   , '99,990.0'))     AS ACT_SPD" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(DECODE(CHK_EOTP01, 'N', RECOVERY_TM), '99,990.0'))  AS RECOVERY_TM" ).append("\n"); 
		query.append(", CHK_EOTP01                                                 AS CHK_EOTP01" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(ROUND(EOTP01, 1), '99,990.0'))               AS EOTP01" ).append("\n"); 
		query.append(", DECODE(CHK_EOTP01, 'N', DECODE(SIGN(EOTP01 + EOTP02), -1, 'N', 'Y'), CHK_EOTP01) AS CHK_EOTP02" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(ROUND(EOTP02, 1), '99,990.0'))               AS EOTP02" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(OLD_SEA_TM                 , '99,990.0'))    AS ACT_SAIL_TM" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  CLASS" ).append("\n"); 
		query.append(", VVD" ).append("\n"); 
		query.append(", MAX_SPD" ).append("\n"); 
		query.append(", OLD_SPD" ).append("\n"); 
		query.append(", OLD_SEA_TM" ).append("\n"); 
		query.append(", NEW_SEA_TM" ).append("\n"); 
		query.append(", ((NEW_PORT_TM + NEW_PORT_BF) - OLD_PORT_TM ) + ((NEW_SEA_TM  + NEW_SEA_BF ) -  OLD_SEA_TM) + OLD_SEA_TM    AS EOTP01" ).append("\n"); 
		query.append("/** (Lane Simulation에서 입력된 Cargo Volume / A Port의 Terminal Productivity+ Port Buffer( Document Hour + Dead Hour)) - 과거 실적 Port의 Working Hour" ).append("\n"); 
		query.append("+ Standard Distance/ Service Speed + Sea Buffer - Actual 항해시간(Actual Distance /Actual Speed) **/" ).append("\n"); 
		query.append(", DECODE( SIGN(( (NEW_PORT_TM + NEW_PORT_BF) - OLD_PORT_TM ) + ((NEW_SEA_TM  + NEW_SEA_BF ) -  OLD_SEA_TM) + OLD_SEA_TM ), -1, 'N', 'Y') AS CHK_EOTP01" ).append("\n"); 
		query.append("/* Lane Simulation에서 입력된 Cargo Volume / A Port의 Terminal Productivity+ Port Buffer( Document Hour + Dead Hour)) - 과거 실적 Port의 Working Hour" ).append("\n"); 
		query.append("+ Standard Distance / Service Speed + Sea Buffer - Actual 항해시간(Actual Distance /Actual Speed)" ).append("\n"); 
		query.append("+ (Standard Distance /Actual Speed - Standard Distance/MAX Speed ) ***/" ).append("\n"); 
		query.append(", ((NEW_PORT_TM + NEW_PORT_BF) - OLD_PORT_TM ) + ((NEW_SEA_TM  + NEW_SEA_BF ) - (OLD_SEA_TM)) + OLD_SEA_TM  +" ).append("\n"); 
		query.append("((DECODE(NVL(OLD_SPD, 0),0,0, (LNK_DIST/OLD_SPD))) - (DECODE(NVL(MAX_SPD, 0),0,0, (LNK_DIST/MAX_SPD)))) AS EOTP02" ).append("\n"); 
		query.append(", ON_TM" ).append("\n"); 
		query.append(", OLD_PORT_TM" ).append("\n"); 
		query.append(", NEW_PORT_TM" ).append("\n"); 
		query.append(", CASE WHEN NVL(OLD_SPD, 0) = 0 THEN NULL" ).append("\n"); 
		query.append("WHEN NVL(MAX_SPD, 0) = 0 THEN NULL" ).append("\n"); 
		query.append("ELSE LNK_DIST * (( 1 / OLD_SPD) - (1 / MAX_SPD))" ).append("\n"); 
		query.append("END                                                   AS RECOVERY_TM /* Max. Recovery Time (회복 가능 시간) */" ).append("\n"); 
		query.append(", LNK_DIST" ).append("\n"); 
		query.append(", NEW_SPD" ).append("\n"); 
		query.append(", NEW_SEA_BF" ).append("\n"); 
		query.append(", NEW_PORT_BF" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT  T1.VSL_CD || T2.SKD_VOY_NO || T2.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(", T4.CNTR_VSL_CLSS_CAPA                     AS CLASS" ).append("\n"); 
		query.append(", DECODE( SIGN (T1.ARR_DLAY_HRS1 + T1.ARR_DLAY_HRS2 + T1.DEP_DLAY_HRS1 + T1.DEP_DLAY_HRS2), 1, 0, 1) AS ON_TM" ).append("\n"); 
		query.append(", NVL((" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_ASC(S2 XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("S1.AVG_SPD" ).append("\n"); 
		query.append("FROM    VSK_DEP_RPT S1, VSK_VSL_PORT_SKD S2" ).append("\n"); 
		query.append("WHERE   1               = 1" ).append("\n"); 
		query.append("AND     S1.VSL_CD       = S2.VSL_CD" ).append("\n"); 
		query.append("AND     S1.SKD_VOY_NO   = S2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     S1.SKD_DIR_CD   = S2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     S1.VPS_PORT_CD  = S2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND     S1.CLPT_IND_SEQ = S2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND     S2.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("AND     S2.SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     S2.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     S2.CLPT_SEQ     > T2.CLPT_SEQ" ).append("\n"); 
		query.append("AND     S2.VPS_PORT_CD  = @[to_port_cd]" ).append("\n"); 
		query.append("AND     ROWNUM          = 1" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  AVG(RMN_AVG_SPD)" ).append("\n"); 
		query.append("FROM    VSK_NOON_RPT" ).append("\n"); 
		query.append("WHERE   1            = 1" ).append("\n"); 
		query.append("AND     VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     NXT_PORT_CD  = @[to_port_cd]" ).append("\n"); 
		query.append("))                                                                     AS OLD_SPD    /* OLD SPEED */" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_ASC(S XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("ROUND((S.ACT_BRTH_DT - T1.ACT_DEP_DT) * 24 , 1)" ).append("\n"); 
		query.append("FROM    VSK_VSL_SKD_RSLT S" ).append("\n"); 
		query.append("WHERE   1               = 1" ).append("\n"); 
		query.append("AND     T1.VSL_CD       = S.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.CLPT_SEQ     < S.CLPT_SEQ" ).append("\n"); 
		query.append("AND     'S'            != NVL(S.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("AND     S.VPS_PORT_CD   = @[to_port_cd]" ).append("\n"); 
		query.append("AND     ROWNUM          = 1" ).append("\n"); 
		query.append(")                                                                        AS OLD_SEA_TM        /*OLD (SEA TIME + BUFFER TIME) */" ).append("\n"); 
		query.append(", ROUND((T1.ACT_DEP_DT - T1.ACT_BRTH_DT) * 24 , 1)                          AS OLD_PORT_TM        /*OLD (PORT TIME + BUFFER TIME) */" ).append("\n"); 
		query.append(", CASE WHEN TO_NUMBER(NVL(@[ib_ipcgo_qty], '0') + NVL(@[ob_ipcgo_qty], '0') + NVL(@[ib_ocn_cgo_qty], '0') + NVL(@[ob_ocn_cgo_qty], '0')) > 0 THEN" ).append("\n"); 
		query.append("TO_NUMBER(DECODE(@[tml_prod_qty],0,0,(DECODE(@[tml_prod_qty],0,(@[ib_ipcgo_qty] + @[ob_ipcgo_qty] + @[ib_ocn_cgo_qty] + @[ob_ocn_cgo_qty]),(@[ib_ipcgo_qty] + @[ob_ipcgo_qty] + @[ib_ocn_cgo_qty] + @[ob_ocn_cgo_qty]) / @[tml_prod_qty]))))" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL(TO_NUMBER(@[act_wrk_hrs]), 0)" ).append("\n"); 
		query.append("END                                                                       AS NEW_PORT_TM" ).append("\n"); 
		query.append(", @[port_buf_hrs]                                                           AS NEW_PORT_BF" ).append("\n"); 
		query.append(", DECODE(@[lnk_spd], 0, @[lnk_dist], ROUND(@[lnk_dist] / @[lnk_spd], 1))    AS NEW_SEA_TM" ).append("\n"); 
		query.append(", @[sea_buf_hrs]                                                            AS NEW_SEA_BF" ).append("\n"); 
		query.append(", @[lnk_dist]                                                               AS LNK_DIST" ).append("\n"); 
		query.append(", @[lnk_spd]                                                                AS NEW_SPD" ).append("\n"); 
		query.append(", T4.MAX_SPD                                                                AS MAX_SPD" ).append("\n"); 
		query.append(", T2.VPS_PORT_CD" ).append("\n"); 
		query.append(", T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM    VSK_VSL_SKD_RSLT T1, VSK_VSL_PORT_SKD T2, VSK_VSL_SKD T3, MDM_VSL_CNTR T4" ).append("\n"); 
		query.append("WHERE   1               = 1" ).append("\n"); 
		query.append("AND     T1.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.VPS_PORT_CD  = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND     T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND     T1.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T3.VSL_CD       = T4.VSL_CD" ).append("\n"); 
		query.append("AND     T4.CNTR_VSL_CLSS_CAPA   IN (@[n1st_vsl_clss_cd], @[n2nd_vsl_clss_cd], @[n3rd_vsl_clss_cd])" ).append("\n"); 
		query.append("AND     T1.VPS_PORT_CD  = @[bf_port_cd]" ).append("\n"); 
		query.append("AND        'S'         != NVL(T1.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("AND     T2.VPS_ETD_DT   BETWEEN SYSDATE - @[hist_yr] AND     SYSDATE" ).append("\n"); 
		query.append("AND     EXISTS  (" ).append("\n"); 
		query.append("SELECT  'X'" ).append("\n"); 
		query.append("FROM    VSK_VSL_SKD_RSLT S" ).append("\n"); 
		query.append("WHERE   1                = 1" ).append("\n"); 
		query.append("AND     T1.VSL_CD        = S.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO    = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD    = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.CLPT_SEQ      < S.CLPT_SEQ" ).append("\n"); 
		query.append("AND     S.VPS_PORT_CD    = @[to_port_cd]" ).append("\n"); 
		query.append("AND     'S'              != NVL(S.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("AND     ROWNUM           = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") T10" ).append("\n"); 
		query.append(") T20" ).append("\n"); 
		query.append(") T30" ).append("\n"); 

	}
}
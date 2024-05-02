/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchAutoratingReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchAutoratingReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Autorating Accuracy Ration
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchAutoratingReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_inc_sub",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchAutoratingReportRSQL").append("\n"); 
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
		query.append("SELECT T.SVC_SCP_CD" ).append("\n"); 
		query.append(",      T.BKG_OFC_CD" ).append("\n"); 
		query.append(",      T.REGION" ).append("\n"); 
		query.append(",      T.TTL" ).append("\n"); 
		query.append(",	   NVL(T.RATE_CNT,0) RATE_CNT" ).append("\n"); 
		query.append(",      NVL(T.RATE_CNT - T.NON_AUTO_CNT,0) AUTO_CNT" ).append("\n"); 
		query.append(",      NVL(T.NON_AUTO_CNT,0) AS NON_AUTO_CNT" ).append("\n"); 
		query.append(",      DECODE(NVL(T.RATE_CNT,0),0,'0.00', TRIM(TO_CHAR(NVL(T.RATE_CNT - T.NON_AUTO_CNT,0)/T.RATE_CNT * 100,'99990.99'))) AS RATIO" ).append("\n"); 
		query.append(",      SUM(T.TTL) OVER () T_TTL" ).append("\n"); 
		query.append(",	   SUM(T.RATE_CNT) OVER () T_RATE_CNT" ).append("\n"); 
		query.append(",      SUM(T.NON_AUTO_CNT) OVER () T_NON_AUTO_CNT" ).append("\n"); 
		query.append(",      SUM(T.RATE_CNT - T.NON_AUTO_CNT) OVER () T_AUTO_CNT" ).append("\n"); 
		query.append(",      DECODE(SUM(T.RATE_CNT) OVER (),0,'0.00',  NVL(TRIM(TO_CHAR(SUM(NVL(T.RATE_CNT - T.NON_AUTO_CNT,0)) OVER () /  SUM(T.RATE_CNT) OVER () * 100,'99990.99')),'0.00')) T_RATIO " ).append("\n"); 
		query.append(",	   '' BKG_NO" ).append("\n"); 
		query.append(",	   '' SC_NO" ).append("\n"); 
		query.append(",	   '' CMDT_CD" ).append("\n"); 
		query.append(",	   '' CMDT_NM" ).append("\n"); 
		query.append(",	   '' CHANGE_HISTORY" ).append("\n"); 
		query.append(",	   '' RATER" ).append("\n"); 
		query.append(",	   '' RATER_OFC" ).append("\n"); 
		query.append(",	   '' SEL_OFC_CD" ).append("\n"); 
		query.append(",	   '' SEL_SCP_CD" ).append("\n"); 
		query.append(",	   @[ofc_inc_sub] AS OFC_INC_SUB " ).append("\n"); 
		query.append(",	   '' CHG_CD" ).append("\n"); 
		query.append(",	   @[fr_dt] AS  FR_DT" ).append("\n"); 
		query.append(",	   @[to_dt] AS TO_DT" ).append("\n"); 
		query.append(",	   '' CTRT_CD" ).append("\n"); 
		query.append(",      '' RAT_UT_CD" ).append("\n"); 
		query.append(",      '' AUTO_RAT_FLG" ).append("\n"); 
		query.append(",      '' AUTO_DEL_FLG" ).append("\n"); 
		query.append(",	   '' RT_SEQ" ).append("\n"); 
		query.append(",	   '' ROW_NUM" ).append("\n"); 
		query.append(",	   '' AUTO_RAT_CD" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dt_option} == 'R') " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT BK.SVC_SCP_CD" ).append("\n"); 
		query.append("	      ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("	      ,PRNT_OFC_CD REGION" ).append("\n"); 
		query.append("	      ,COUNT(BK.BKG_NO) TTL" ).append("\n"); 
		query.append("	      ,SUM( CASE WHEN (SELECT COUNT(BH.BKG_NO) OVER()" ).append("\n"); 
		query.append("					  FROM   BKG_CHG_RT BH" ).append("\n"); 
		query.append("					  WHERE  BH.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("					  GROUP BY BH.BKG_NO) > 0 THEN 1 ELSE 0 END) RATE_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	      ,SUM(CASE WHEN NVL(BKG_GET_AUTO_RT_HIS_FNC(BK.BKG_NO,1),'') IS NULL THEN 0 ELSE 1 END) NON_AUTO_CNT" ).append("\n"); 
		query.append("	FROM   BKG_BOOKING     	BK" ).append("\n"); 
		query.append("	,      MDM_ORGANIZATION   	OL" ).append("\n"); 
		query.append("	,      BKG_CHG_RT 		RT" ).append("\n"); 
		query.append("	WHERE  BK.BKG_NO 		= RT.BKG_NO" ).append("\n"); 
		query.append("	AND    BK.BKG_OFC_CD   	= OL.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${fr_dt} != '') " ).append("\n"); 
		query.append("			AND    RT.CRE_DT >= TO_DATE(@[fr_dt], 'yyyy-mm-dd') " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${to_dt} != '') " ).append("\n"); 
		query.append("			AND    RT.CRE_DT <=  TO_DATE(@[to_dt], 'yyyy-mm-dd') + 0.99999 " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND    BK.BKG_STS_CD 	<> 'X' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("	AND	   BK.SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${sc_no} != '') " ).append("\n"); 
		query.append("	AND	   BK.SC_NO = @[sc_no] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${region} != '')" ).append("\n"); 
		query.append("		AND PRNT_OFC_CD = @[region]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${ofc_inc_sub} == 'Y') " ).append("\n"); 
		query.append("		AND BK.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("							SELECT 	OFC_CD  " ).append("\n"); 
		query.append("							FROM   	MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("							START 	WITH MO.OFC_CD = NVL(@[bkg_ofc_cd],BK.BKG_OFC_CD)" ).append("\n"); 
		query.append("									CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD)" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("			AND   BK.BKG_OFC_CD = @[bkg_ofc_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${ctrt_cd} == 'S/C') " ).append("\n"); 
		query.append("	AND    BK.SC_NO   IS NOT NULL" ).append("\n"); 
		query.append("	#elseif (${ctrt_cd} == 'RFA') " ).append("\n"); 
		query.append("	AND    BK.RFA_NO	 IS NOT NULL" ).append("\n"); 
		query.append("	#elseif (${ctrt_cd} == 'TAA') " ).append("\n"); 
		query.append("	AND    BK.TAA_NO IS NOT NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND    RT.RT_SEQ = 1 --(SELECT RT2.RT_SEQ FROM BKG_CHG_RT RT2 WHERE RT2.BKG_NO = RT.BKG_NO AND ROWNUM = 1 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT	BK.SVC_SCP_CD" ).append("\n"); 
		query.append("		,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("		,PRNT_OFC_CD REGION" ).append("\n"); 
		query.append("		,COUNT(BK.BKG_NO) TTL" ).append("\n"); 
		query.append("		,SUM( CASE WHEN (SELECT COUNT(BH.BKG_NO) OVER()" ).append("\n"); 
		query.append("					  FROM   BKG_CHG_RT BH" ).append("\n"); 
		query.append("					  WHERE  BH.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("					  GROUP BY BH.BKG_NO) > 0 THEN 1 ELSE 0 END) RATE_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,SUM(CASE WHEN NVL(BKG_GET_AUTO_RT_HIS_FNC(BK.BKG_NO,1),'') IS NULL THEN 0 ELSE 1 END) NON_AUTO_CNT" ).append("\n"); 
		query.append("	FROM	(	select	SUB1.* " ).append("\n"); 
		query.append("				from	vsk_vsl_port_skd skd," ).append("\n"); 
		query.append("					(	select  bkg.*, '' vsl_cd_chk, rank() over(partition by vvd.bkg_no order by vvd.vsl_pre_pst_cd||vvd.vsl_seq) ranking" ).append("\n"); 
		query.append("						from	bkg_vvd vvd, bkg_booking bkg" ).append("\n"); 
		query.append("						where	vvd.bkg_no	= bkg.bkg_no" ).append("\n"); 
		query.append("						and	vvd.bkg_no	in ( " ).append("\n"); 
		query.append("										select	bkg.bkg_no" ).append("\n"); 
		query.append("										from	bkg_booking			bkg" ).append("\n"); 
		query.append("										,		bkg_vvd				vvd" ).append("\n"); 
		query.append("										,		vsk_vsl_port_skd	skd" ).append("\n"); 
		query.append("										where	bkg.bkg_no		= vvd.bkg_no" ).append("\n"); 
		query.append("										and	vvd.vsl_cd			= skd.vsl_cd" ).append("\n"); 
		query.append("										and	vvd.skd_voy_no		= skd.skd_voy_no" ).append("\n"); 
		query.append("										and	vvd.skd_dir_cd		= skd.skd_dir_cd" ).append("\n"); 
		query.append("										and	vvd.pol_cd			= skd.vps_port_cd" ).append("\n"); 
		query.append("										AND	skd.vps_etd_dt		>= TO_DATE(@[fr_dt], 'yyyy-mm-dd') " ).append("\n"); 
		query.append("										AND	skd.vps_etd_dt		<= TO_DATE(@[to_dt], 'yyyy-mm-dd') + 0.99999 " ).append("\n"); 
		query.append("										and	skd.CLPT_IND_SEQ	= '1'" ).append("\n"); 
		query.append("										and	BKg.BKG_STS_CD 		<> 'X' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("											AND	BKG.SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										#if (${sc_no} != '') " ).append("\n"); 
		query.append("											AND	BKG.SC_NO = @[sc_no] " ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										#if (${ofc_inc_sub} == 'Y') " ).append("\n"); 
		query.append("											AND BKG.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("																	SELECT 	OFC_CD  " ).append("\n"); 
		query.append("																	FROM   	MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("																	START 	WITH MO.OFC_CD = NVL(@[bkg_ofc_cd],BKG.BKG_OFC_CD)" ).append("\n"); 
		query.append("																	CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD)" ).append("\n"); 
		query.append("										#else " ).append("\n"); 
		query.append("											#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("												AND   BKG.BKG_OFC_CD = @[bkg_ofc_cd] " ).append("\n"); 
		query.append("											#end" ).append("\n"); 
		query.append("										#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										#if (${ctrt_cd} == 'S/C') " ).append("\n"); 
		query.append("											AND    BKG.SC_NO   IS NOT NULL" ).append("\n"); 
		query.append("										#elseif (${ctrt_cd} == 'RFA') " ).append("\n"); 
		query.append("											AND    BKG.RFA_NO	 IS NOT NULL" ).append("\n"); 
		query.append("										#elseif (${ctrt_cd} == 'TAA') " ).append("\n"); 
		query.append("										AND    BKG.TAA_NO IS NOT NULL" ).append("\n"); 
		query.append("										#end	)" ).append("\n"); 
		query.append("							 ) SUB1" ).append("\n"); 
		query.append("				where	skd.vsl_cd	=	sub1.vsl_cd" ).append("\n"); 
		query.append("				and	skd.skd_voy_no	=	sub1.skd_voy_no" ).append("\n"); 
		query.append("				and	skd.skd_dir_cd	=	sub1.skd_dir_cd" ).append("\n"); 
		query.append("				and	skd.vps_port_cd	=	sub1.pol_cd" ).append("\n"); 
		query.append("				AND	skd.vps_etd_dt	>=	TO_DATE(@[fr_dt], 'yyyy-mm-dd') " ).append("\n"); 
		query.append("				AND	skd.vps_etd_dt	<=	TO_DATE(@[to_dt], 'yyyy-mm-dd') + 0.99999 " ).append("\n"); 
		query.append("				and	SUB1.ranking = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				select	sub1.*" ).append("\n"); 
		query.append("				from	(" ).append("\n"); 
		query.append("						select	bkg.*, vvd.vsl_cd vsl_cd_chk, rank() over(partition by vvd.bkg_no order by vvd.vsl_pre_pst_cd||vvd.vsl_seq) ranking" ).append("\n"); 
		query.append("						from	bkg_vvd vvd," ).append("\n"); 
		query.append("							bkg_booking bkg" ).append("\n"); 
		query.append("						where	vvd.bkg_no	=	bkg.bkg_no" ).append("\n"); 
		query.append("						and	vvd.bkg_no	in	(" ).append("\n"); 
		query.append("											select	distinct bkg.bkg_no" ).append("\n"); 
		query.append("											from	bkg_rate			rat" ).append("\n"); 
		query.append("											,	bkg_vvd				vvd" ).append("\n"); 
		query.append("											,	bkg_booking			bkg" ).append("\n"); 
		query.append("											where	rat.bkg_no			= vvd.bkg_no" ).append("\n"); 
		query.append("											and	rat.bkg_no			= bkg.bkg_no" ).append("\n"); 
		query.append("											AND 	rat.RT_APLY_DT		>= TO_DATE(@[fr_dt], 'yyyy-mm-dd') " ).append("\n"); 
		query.append("											AND	rat.RT_APLY_DT		<= TO_DATE(@[to_dt], 'yyyy-mm-dd') + 0.99999 " ).append("\n"); 
		query.append("											and	BKg.BKG_STS_CD 		<> 'X' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("											#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("												AND	BKG.SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("											#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("											#if (${sc_no} != '') " ).append("\n"); 
		query.append("												AND	BKG.SC_NO = @[sc_no] " ).append("\n"); 
		query.append("											#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("											#if (${ofc_inc_sub} == 'Y') " ).append("\n"); 
		query.append("												AND BKG.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("																		SELECT 	OFC_CD  " ).append("\n"); 
		query.append("																		FROM   	MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("																		START 	WITH MO.OFC_CD = NVL(@[bkg_ofc_cd],BKG.BKG_OFC_CD)" ).append("\n"); 
		query.append("																		CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD)" ).append("\n"); 
		query.append("											#else " ).append("\n"); 
		query.append("												#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("													AND   BKG.BKG_OFC_CD = @[bkg_ofc_cd] " ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("											#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("											#if (${ctrt_cd} == 'S/C') " ).append("\n"); 
		query.append("												AND    BKG.SC_NO   IS NOT NULL" ).append("\n"); 
		query.append("											#elseif (${ctrt_cd} == 'RFA') " ).append("\n"); 
		query.append("												AND    BKG.RFA_NO	 IS NOT NULL" ).append("\n"); 
		query.append("											#elseif (${ctrt_cd} == 'TAA') " ).append("\n"); 
		query.append("												AND    BKG.TAA_NO IS NOT NULL" ).append("\n"); 
		query.append("											#end " ).append("\n"); 
		query.append("											and		vvd.vsl_cd is null )) sub1" ).append("\n"); 
		query.append("				where	sub1.vsl_cd_chk is null" ).append("\n"); 
		query.append("				and	sub1.ranking = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				) BK" ).append("\n"); 
		query.append("	,	MDM_ORGANIZATION    	OL" ).append("\n"); 
		query.append("	,	BKG_CHG_RT 		RT" ).append("\n"); 
		query.append("	WHERE	BK.BKG_NO 		= RT.BKG_NO" ).append("\n"); 
		query.append("	AND	BK.BKG_OFC_CD   	= OL.OFC_CD" ).append("\n"); 
		query.append("	AND	RT.RT_SEQ = 1 --(SELECT RT2.RT_SEQ FROM BKG_CHG_RT RT2 WHERE RT2.BKG_NO = RT.BKG_NO AND ROWNUM = 1 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${region} != '')" ).append("\n"); 
		query.append("		AND PRNT_OFC_CD = @[region]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY BK.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("      ,PRNT_OFC_CD" ).append("\n"); 
		query.append("ORDER BY BK.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("      ) T" ).append("\n"); 

	}
}
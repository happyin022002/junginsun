/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchNonAutoratingReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchNonAutoratingReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2.Non Autorating B/L List
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchNonAutoratingReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchNonAutoratingReportRSQL").append("\n"); 
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
		query.append("WITH TEMP_T AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append(",      BK.SVC_SCP_CD" ).append("\n"); 
		query.append(",      BK.SC_NO" ).append("\n"); 
		query.append(",      BK.BKG_OFC_CD" ).append("\n"); 
		query.append(",      BK.CMDT_CD" ).append("\n"); 
		query.append(",      (SELECT BL.CSTMS_DESC FROM BKG_BL_DOC BL WHERE BL.BKG_NO = BK.BKG_NO) CMDT_NM" ).append("\n"); 
		query.append(",      BKG_GET_AUTO_RT_HIS_FNC(RT.BKG_NO,1) CHANGE_HISTORY" ).append("\n"); 
		query.append(",      RT.CRE_USR_ID AS RATER" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("#if (${dt_option} == 'R') " ).append("\n"); 
		query.append("		  BKG_CHG_RT RT" ).append("\n"); 
		query.append("	,	   BKG_BOOKING     BK" ).append("\n"); 
		query.append("	WHERE  1 = 1" ).append("\n"); 
		query.append("	AND    RT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("	AND    RT.RT_SEQ = 1 --(SELECT RT2.RT_SEQ FROM BKG_CHG_RT RT2 WHERE RT2.BKG_NO = RT.BKG_NO AND ROWNUM = 1 )" ).append("\n"); 
		query.append("	AND    BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${fr_dt} != '') " ).append("\n"); 
		query.append("	AND    RT.CRE_DT >= TO_DATE(@[fr_dt], 'yyyy-mm-dd') " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${to_dt} != '') " ).append("\n"); 
		query.append("	AND    RT.CRE_DT <  TO_DATE(@[to_dt], 'yyyy-mm-dd') + 0.99999 " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("	AND	   BK.SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${sc_no} != '') " ).append("\n"); 
		query.append("	AND	   BK.SC_NO = @[sc_no] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${ofc_inc_sub} == 'Y') " ).append("\n"); 
		query.append("			AND BK.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("      			SELECT OFC_CD  " ).append("\n"); 
		query.append("      			FROM   MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("      			START WITH MO.OFC_CD = NVL(@[bkg_ofc_cd],BK.BKG_OFC_CD)" ).append("\n"); 
		query.append("      			CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD)" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("			AND   BK.BKG_OFC_CD = @[bkg_ofc_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${ctrt_cd} == 'S/C') " ).append("\n"); 
		query.append("	AND    BK.SC_NO   IS NOT NULL" ).append("\n"); 
		query.append("	#elseif (${ctrt_cd} == 'RFA') " ).append("\n"); 
		query.append("	AND    BK.RFA_NO	 IS NOT NULL" ).append("\n"); 
		query.append("	#elseif (${ctrt_cd} == 'TAA') " ).append("\n"); 
		query.append("	AND    BK.TAA_NO IS NOT NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select	SUB1.* " ).append("\n"); 
		query.append("				from	vsk_vsl_port_skd skd," ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  bkg.*, '' vsl_cd_chk, rank() over(partition by vvd.bkg_no order by vvd.vsl_pre_pst_cd||vvd.vsl_seq) ranking" ).append("\n"); 
		query.append("						from	bkg_vvd vvd, bkg_booking bkg" ).append("\n"); 
		query.append("						where	vvd.bkg_no	= bkg.bkg_no" ).append("\n"); 
		query.append("						and	vvd.bkg_no	in (" ).append("\n"); 
		query.append("										select	distinct bkg.bkg_no" ).append("\n"); 
		query.append("										from	bkg_booking			bkg" ).append("\n"); 
		query.append("										,	bkg_vvd				vvd" ).append("\n"); 
		query.append("										,	vsk_vsl_port_skd	skd" ).append("\n"); 
		query.append("										where	bkg.bkg_no		= vvd.bkg_no" ).append("\n"); 
		query.append("										and	vvd.vsl_cd		= skd.vsl_cd" ).append("\n"); 
		query.append("										and	vvd.skd_voy_no		= skd.skd_voy_no" ).append("\n"); 
		query.append("										and	vvd.skd_dir_cd		= skd.skd_dir_cd" ).append("\n"); 
		query.append("										and	vvd.pol_cd		= skd.vps_port_cd" ).append("\n"); 
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
		query.append("											AND    BKG.TAA_NO IS NOT NULL" ).append("\n"); 
		query.append("										#end	)" ).append("\n"); 
		query.append("					) SUB1" ).append("\n"); 
		query.append("				where	skd.vsl_cd	=	sub1.vsl_cd" ).append("\n"); 
		query.append("				and	skd.skd_voy_no	=	sub1.skd_voy_no" ).append("\n"); 
		query.append("				and	skd.skd_dir_cd	=	sub1.skd_dir_cd" ).append("\n"); 
		query.append("				and	skd.vps_port_cd	=	sub1.pol_cd" ).append("\n"); 
		query.append("				AND	skd.vps_etd_dt	>=	TO_DATE(@[fr_dt], 'yyyy-mm-dd') " ).append("\n"); 
		query.append("				AND	skd.vps_etd_dt	<=	TO_DATE(@[to_dt], 'yyyy-mm-dd') + 0.99999 " ).append("\n"); 
		query.append("				and	SUB1.ranking	=	1" ).append("\n"); 
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
		query.append("											,		bkg_vvd				vvd" ).append("\n"); 
		query.append("											,		bkg_booking			bkg" ).append("\n"); 
		query.append("											where	rat.bkg_no			= vvd.bkg_no" ).append("\n"); 
		query.append("											and		rat.bkg_no			= bkg.bkg_no" ).append("\n"); 
		query.append("											AND 	rat.RT_APLY_DT		>= TO_DATE(@[fr_dt], 'yyyy-mm-dd') " ).append("\n"); 
		query.append("											AND		rat.RT_APLY_DT		<= TO_DATE(@[to_dt], 'yyyy-mm-dd') + 0.99999 " ).append("\n"); 
		query.append("											and		BKg.BKG_STS_CD 		<> 'X' " ).append("\n"); 
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
		query.append("				) BK, BKG_CHG_RT RT" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("	AND    BK.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("	AND    RT.RT_SEQ = 1 --(SELECT RT2.RT_SEQ FROM BKG_CHG_RT RT2 WHERE RT2.BKG_NO = RT.BKG_NO AND ROWNUM = 1 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY  BK.BKG_OFC_CD,BK.BKG_NO" ).append("\n"); 
		query.append(") SELECT T.* ,(SELECT CU.OFC_CD FROM COM_USER CU WHERE CU.USR_ID = T.RATER) RATER_OFC " ).append("\n"); 
		query.append("  FROM TEMP_T T" ).append("\n"); 
		query.append("#if ( ${auto_rat_cd} != '')" ).append("\n"); 
		query.append("  WHERE T.CHANGE_HISTORY IS NULL --ORDER BY REGION,BKG_OFC_CD,BKG_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  WHERE T.CHANGE_HISTORY IS NOT NULL --ORDER BY REGION,BKG_OFC_CD,BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
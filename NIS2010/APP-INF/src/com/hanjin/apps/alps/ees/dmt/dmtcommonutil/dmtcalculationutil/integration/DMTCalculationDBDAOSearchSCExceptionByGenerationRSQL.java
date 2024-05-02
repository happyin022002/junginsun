/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchSCExceptionByGenerationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchSCExceptionByGenerationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSCExceptionByGeneration
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchSCExceptionByGenerationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtt_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("efft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchSCExceptionByGenerationRSQL").append("\n"); 
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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("      ,VER_SEQ" ).append("\n"); 
		query.append("      ,GRP_SEQ" ).append("\n"); 
		query.append("      ,FTIME_MK" ).append("\n"); 
		query.append("      ,EXCL_SAT" ).append("\n"); 
		query.append("      ,EXCL_SUN" ).append("\n"); 
		query.append("      ,EXCL_HOLI" ).append("\n"); 
		query.append("      ,FT_ADD_MK" ).append("\n"); 
		query.append("      ,FT_ADD_DAY" ).append("\n"); 
		query.append("      ,FT_ADJ_MK" ).append("\n"); 
		query.append("      ,RT_ADJ_MK" ).append("\n"); 
		query.append("      ,CUR_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("							SELECT  /*+ " ).append("\n"); 
		query.append("							        USE_NL( P D M C ) NO_EXPAND" ).append("\n"); 
		query.append("							             INDEX( P XUK1PRI_SP_HDR  )" ).append("\n"); 
		query.append("							             INDEX( D XPKDMT_SC_EXPT_GRP )" ).append("\n"); 
		query.append("							             INDEX( M XPKDMT_SC_EXPT_VER )" ).append("\n"); 
		query.append("							             INDEX( C XPKDMT_SC_EXPT_CVRG  ) */   " ).append("\n"); 
		query.append("											D.PROP_NO			PROP_NO," ).append("\n"); 
		query.append("											D.SC_EXPT_VER_SEQ	VER_SEQ," ).append("\n"); 
		query.append("											D.SC_EXPT_GRP_SEQ  	GRP_SEQ," ).append("\n"); 
		query.append("											D.FT_FLG		FTIME_MK,	" ).append("\n"); 
		query.append("											D.XCLD_SAT_FLG	EXCL_SAT," ).append("\n"); 
		query.append("											D.XCLD_SUN_FLG	EXCL_SUN,	" ).append("\n"); 
		query.append("											D.XCLD_HOL_FLG	EXCL_HOLI," ).append("\n"); 
		query.append("											D.FT_ADD_FLG	FT_ADD_MK,	" ).append("\n"); 
		query.append("											D.FT_ADD_DYS	FT_ADD_DAY," ).append("\n"); 
		query.append("											D.FT_ADJ_FLG	FT_ADJ_MK,	" ).append("\n"); 
		query.append("											D.RT_ADJ_FLG	RT_ADJ_MK," ).append("\n"); 
		query.append("											D.CURR_CD 		CUR_CD" ).append("\n"); 
		query.append("							    FROM       	DMT_SC_EXPT_VER        M," ).append("\n"); 
		query.append("							               	DMT_SC_EXPT_GRP        D," ).append("\n"); 
		query.append("							               	DMT_SC_EXPT_CVRG       C," ).append("\n"); 
		query.append("										   	PRI_SP_HDR 			   P" ).append("\n"); 
		query.append("							   WHERE      	M.PROP_NO                =    D.PROP_NO" ).append("\n"); 
		query.append("							   AND        	M.SC_EXPT_VER_SEQ        =    D.SC_EXPT_VER_SEQ      " ).append("\n"); 
		query.append("							   AND (   (    D.CMDT_FLG = 'Y'" ).append("\n"); 
		query.append("							            AND (D.PROP_NO, D.SC_EXPT_VER_SEQ, D.SC_EXPT_GRP_SEQ) IN (" ).append("\n"); 
		query.append("							                   SELECT CMDT.PROP_NO" ).append("\n"); 
		query.append("							                         ,CMDT.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("							                         ,CMDT.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("							                     FROM DMT_SC_EXPT_CMDT CMDT" ).append("\n"); 
		query.append("							                    WHERE D.PROP_NO = CMDT.PROP_NO" ).append("\n"); 
		query.append("							                      AND D.SC_EXPT_VER_SEQ = CMDT.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("							                      AND D.SC_EXPT_GRP_SEQ = CMDT.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("							                      AND CMDT.CMDT_CD = @[cmdt_cd])" ).append("\n"); 
		query.append("							           )" ).append("\n"); 
		query.append("							        OR (D.CMDT_FLG = 'N')" ).append("\n"); 
		query.append("							       )" ).append("\n"); 
		query.append("							   AND (   (    D.ACT_CUST_FLG = 'Y'" ).append("\n"); 
		query.append("							            AND (D.PROP_NO, D.SC_EXPT_VER_SEQ, D.SC_EXPT_GRP_SEQ) IN " ).append("\n"); 
		query.append("											(" ).append("\n"); 
		query.append("							                   SELECT CUST.PROP_NO" ).append("\n"); 
		query.append("							                         ,CUST.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("							                         ,CUST.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("							                     FROM DMT_SC_EXPT_ACT_CUST CUST" ).append("\n"); 
		query.append("							                    WHERE D.PROP_NO = CUST.PROP_NO" ).append("\n"); 
		query.append("							                      AND D.SC_EXPT_VER_SEQ = CUST.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("							                      AND D.SC_EXPT_GRP_SEQ = CUST.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("							                      AND CUST.CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("							                      AND CUST.CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("												  AND ( SELECT	/*+ INDEX_DESC(A XPKPRI_SP_CTRT_CUST_TP) */ " ).append("\n"); 
		query.append("                                                                CASE prc_ctrt_cust_tp_cd WHEN 'N' THEN 'NVO'" ).append("\n"); 
		query.append("                                                                                         WHEN 'I' THEN 'BCO'" ).append("\n"); 
		query.append("                                                                                         WHEN 'A' THEN 'BCO'" ).append("\n"); 
		query.append("                                                                                         WHEN 'B' THEN 'BCO'" ).append("\n"); 
		query.append("                                                                                         ELSE ' ' END prc_ctrt_cust_tp_cd" ).append("\n"); 
		query.append("                                                        FROM	PRI_SP_CTRT_CUST_TP A" ).append("\n"); 
		query.append("                                                        WHERE	PROP_NO = ( SELECT PROP_NO FROM PRI_SP_HDR WHERE SC_NO = TRIM(@[sc_no]) AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                                                        AND ROWNUM = 1 ) = 'NVO'" ).append("\n"); 
		query.append("							                      AND ACT_CUST_FLG = 'Y' " ).append("\n"); 
		query.append("											   UNION ALL" ).append("\n"); 
		query.append("							                   SELECT CUST.PROP_NO" ).append("\n"); 
		query.append("							                         ,CUST.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("							                         ,CUST.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("							                     FROM DMT_SC_EXPT_ACT_CUST CUST" ).append("\n"); 
		query.append("							                    WHERE D.PROP_NO = CUST.PROP_NO" ).append("\n"); 
		query.append("							                      AND D.SC_EXPT_VER_SEQ = CUST.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("							                      AND D.SC_EXPT_GRP_SEQ = CUST.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("							                      AND ( CUST.CUST_CNT_CD, CUST.CUST_SEQ ) IN ( SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("																								 FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("																								WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("																								  AND BKG_CUST_TP_CD IN ( 'S','C','N' ) )" ).append("\n"); 
		query.append("												  AND ( SELECT	/*+ INDEX_DESC(A XPKPRI_SP_CTRT_CUST_TP) */ " ).append("\n"); 
		query.append("                                                                CASE prc_ctrt_cust_tp_cd WHEN 'N' THEN 'NVO'" ).append("\n"); 
		query.append("                                                                                         WHEN 'I' THEN 'BCO'" ).append("\n"); 
		query.append("                                                                                         WHEN 'A' THEN 'BCO'" ).append("\n"); 
		query.append("                                                                                         WHEN 'B' THEN 'BCO'" ).append("\n"); 
		query.append("                                                                                         ELSE ' ' END prc_ctrt_cust_tp_cd" ).append("\n"); 
		query.append("                                                        FROM	PRI_SP_CTRT_CUST_TP A" ).append("\n"); 
		query.append("                                                        WHERE	PROP_NO = ( SELECT PROP_NO FROM PRI_SP_HDR WHERE SC_NO = TRIM(@[sc_no]) AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                                                        AND ROWNUM = 1 ) = 'BCO'" ).append("\n"); 
		query.append("							                      AND ACT_CUST_FLG = 'Y' " ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("							           )" ).append("\n"); 
		query.append("							        OR (D.ACT_CUST_FLG = 'N')" ).append("\n"); 
		query.append("							       )" ).append("\n"); 
		query.append("							    AND        D.PROP_NO                =    C.PROP_NO" ).append("\n"); 
		query.append("							    AND        D.SC_EXPT_VER_SEQ        =    C.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("							    AND        D.SC_EXPT_GRP_SEQ        =    C.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("							    " ).append("\n"); 
		query.append("							#if (${io_bnd_cd} == 'I') " ).append("\n"); 
		query.append("									   AND	NVL(D.RCV_DE_TERM_CD, ' ')	=	DECODE(D.RCV_DE_TERM_CD, NULL, ' ', NVL(@[bb_de_term_cd], ' '))	" ).append("\n"); 
		query.append("								#if (${dtt_code} == 'DMIF') " ).append("\n"); 
		query.append("									   AND (   C.CNT_CD = NVL(@[yrd_cnt_cd], ' ')         		OR C.CNT_CD = ' ')" ).append("\n"); 
		query.append("									   AND (   C.RGN_CD = NVL(@[yrd_rgn_cd], ' ')         		OR C.RGN_CD = ' ')" ).append("\n"); 
		query.append("									   AND (   C.STE_CD = NVL(@[yrd_ste_cd], ' ')         		OR C.STE_CD = ' ')" ).append("\n"); 
		query.append("									   AND (   C.LOC_CD = NVL(@[yrd_loc_cd], ' ')         		OR C.LOC_CD = ' ')" ).append("\n"); 
		query.append("        	                           AND ( (   ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_CONTI_CD = NVL(@[por_conti_cd]  , ' ')  OR D.SC_EXPT_FM_CONTI_CD = ' ') )" ).append("\n"); 
		query.append("                                             AND ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_CNT_CD   = NVL(@[por_cnt_cd]    , ' ')  OR D.SC_EXPT_FM_CNT_CD = ' ' ) )" ).append("\n"); 
		query.append("                                             AND ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_RGN_CD   = NVL(@[por_rgn_cd]    , ' ')  OR D.SC_EXPT_FM_RGN_CD = ' ' ) )" ).append("\n"); 
		query.append("                                             AND ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_STE_CD   = NVL(@[por_ste_cd]    , ' ')  OR D.SC_EXPT_FM_STE_CD = ' ' ) )" ).append("\n"); 
		query.append("                                             AND ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_LOC_CD   = NVL(@[por_loc_cd]    , ' ')  OR D.SC_EXPT_FM_LOC_CD = ' ' ) )" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                                            OR   ( D.FM_TO_PAIR_FLG    =  'N' )" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("							    	  AND (   D.FNL_DEST_CNT_CD = NVL(@[del_cnt_cd], ' ')      OR D.FNL_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("							     	  AND (   D.FNL_DEST_RGN_CD = NVL(@[del_rgn_cd], ' ')      OR D.FNL_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("							     	  AND (   D.FNL_DEST_STE_CD = NVL(@[del_ste_cd], ' ')      OR D.FNL_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("							     	  AND (   D.FNL_DEST_LOC_CD = NVL(@[del_loc_cd], ' ')      OR D.FNL_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("								#elseif (${dtt_code} == 'DTIC' || ${dtt_code} == 'CTIC') " ).append("\n"); 
		query.append("							     	  AND (   C.CNT_CD = NVL(@[del_cnt_cd], ' ')           OR C.CNT_CD = ' ')" ).append("\n"); 
		query.append("							          AND (   C.RGN_CD = NVL(@[del_rgn_cd], ' ')           OR C.RGN_CD = ' ')" ).append("\n"); 
		query.append("							          AND (   C.STE_CD = NVL(@[del_ste_cd], ' ')           OR C.STE_CD = ' ')" ).append("\n"); 
		query.append("							          AND (   C.LOC_CD = NVL(@[del_loc_cd], ' ')           OR C.LOC_CD = ' ')" ).append("\n"); 
		query.append("							          AND (   D.SC_EXPT_FM_CONTI_CD = NVL(@[por_conti_cd], ' ')  OR D.SC_EXPT_FM_CONTI_CD = ' ')" ).append("\n"); 
		query.append("							          AND (   D.SC_EXPT_FM_CNT_CD   = NVL(@[por_cnt_cd]  , ' ')  OR D.SC_EXPT_FM_CNT_CD = ' ')" ).append("\n"); 
		query.append("							          AND (   D.SC_EXPT_FM_RGN_CD   = NVL(@[por_rgn_cd]  , ' ')  OR D.SC_EXPT_FM_RGN_CD = ' ')" ).append("\n"); 
		query.append("							          AND (   D.SC_EXPT_FM_STE_CD   = NVL(@[por_ste_cd]  , ' ')  OR D.SC_EXPT_FM_STE_CD = ' ')" ).append("\n"); 
		query.append("							          AND (   D.SC_EXPT_FM_LOC_CD   = NVL(@[por_loc_cd]  , ' ')  OR D.SC_EXPT_FM_LOC_CD = ' ')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							#elseif (${io_bnd_cd} == 'O')" ).append("\n"); 
		query.append("									   AND	NVL(D.RCV_DE_TERM_CD, ' ')	=	DECODE(D.RCV_DE_TERM_CD, NULL, ' ', NVL(@[bb_rcv_term_cd], ' '))	" ).append("\n"); 
		query.append("							 	#if (${dtt_code} == 'DMOF') " ).append("\n"); 
		query.append("							     	   AND (   C.CNT_CD = NVL(@[yrd_cnt_cd], ' ')           OR C.CNT_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   C.RGN_CD = NVL(@[yrd_rgn_cd], ' ')           OR C.RGN_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   C.STE_CD = NVL(@[yrd_ste_cd], ' ')           OR C.STE_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   C.LOC_CD = NVL(@[yrd_loc_cd], ' ')           OR C.LOC_CD = ' ')" ).append("\n"); 
		query.append("                                       AND ( (  ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_CONTI_CD = NVL(@[del_conti_cd], ' ')    OR D.SC_EXPT_FM_CONTI_CD = ' ') )" ).append("\n"); 
		query.append("                                            AND ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_CNT_CD   = NVL(@[del_cnt_cd]  , ' ')    OR D.SC_EXPT_FM_CNT_CD = ' ' ) )     " ).append("\n"); 
		query.append("                                            AND ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_RGN_CD   = NVL(@[del_rgn_cd]  , ' ')    OR D.SC_EXPT_FM_RGN_CD = ' ' ) )   " ).append("\n"); 
		query.append("                                            AND ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_STE_CD   = NVL(@[del_ste_cd]  , ' ')    OR D.SC_EXPT_FM_STE_CD = ' ' ) )   " ).append("\n"); 
		query.append("                                            AND ( D.FM_TO_PAIR_FLG    =  'Y' AND ( D.SC_EXPT_FM_LOC_CD   = NVL(@[del_loc_cd]  , ' ')    OR D.SC_EXPT_FM_LOC_CD = ' ' ) )   " ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                           OR ( D.FM_TO_PAIR_FLG    =  'N' )                                                                                             " ).append("\n"); 
		query.append("                                           )        " ).append("\n"); 
		query.append("							     	   AND (   D.FNL_DEST_CNT_CD = NVL(@[por_cnt_cd], ' ')      OR D.FNL_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   D.FNL_DEST_RGN_CD = NVL(@[por_rgn_cd], ' ')      OR D.FNL_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   D.FNL_DEST_STE_CD = NVL(@[por_ste_cd], ' ')      OR D.FNL_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   D.FNL_DEST_LOC_CD = NVL(@[por_loc_cd], ' ')      OR D.FNL_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("								#elseif (${dtt_code} == 'DTOC' || ${dtt_code} == 'CTOC') " ).append("\n"); 
		query.append("							     	   AND (   C.CNT_CD = NVL(@[por_cnt_cd], ' ')           OR C.CNT_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   C.RGN_CD = NVL(@[por_rgn_cd], ' ')           OR C.RGN_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   C.STE_CD = NVL(@[por_ste_cd], ' ')           OR C.STE_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   C.LOC_CD = NVL(@[por_loc_cd], ' ')           OR C.LOC_CD = ' ')     " ).append("\n"); 
		query.append("							     	   AND (   D.SC_EXPT_FM_CONTI_CD = NVL(@[del_conti_cd], ' ')    OR D.SC_EXPT_FM_CONTI_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   D.SC_EXPT_FM_CNT_CD   = NVL(@[del_cnt_cd]  , ' ')    OR D.SC_EXPT_FM_CNT_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   D.SC_EXPT_FM_RGN_CD   = NVL(@[del_rgn_cd]  , ' ')    OR D.SC_EXPT_FM_RGN_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   D.SC_EXPT_FM_STE_CD   = NVL(@[del_ste_cd]  , ' ')    OR D.SC_EXPT_FM_STE_CD = ' ')" ).append("\n"); 
		query.append("							     	   AND (   D.SC_EXPT_FM_LOC_CD   = NVL(@[del_loc_cd]  , ' ')    OR D.SC_EXPT_FM_LOC_CD = ' ')" ).append("\n"); 
		query.append("								#end	" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							    AND        D.EFF_DT                 <=    TO_DATE(@[efft_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("							    AND        D.EXP_DT                 >=    TO_DATE(@[efft_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("							    AND        D.DELT_FLG               =    'N'" ).append("\n"); 
		query.append("							    AND        D.DMDT_TRF_CD            =    @[dtt_code]" ).append("\n"); 
		query.append("							    AND        D.DMDT_CNTR_CGO_TP_CD    =    @[cntr_cgo_tp]" ).append("\n"); 
		query.append("							    AND 	   M.PROP_NO                =    P.PROP_NO" ).append("\n"); 
		query.append("							    AND        P.SC_NO                  =    TRIM(@[sc_no])" ).append("\n"); 
		query.append("								AND		   M.DMDT_EXPT_VER_STS_CD	=	'L'" ).append("\n"); 
		query.append("							  ORDER BY C.CNT_CD DESC" ).append("\n"); 
		query.append("							  				,C.RGN_CD DESC" ).append("\n"); 
		query.append("							  				,C.STE_CD DESC" ).append("\n"); 
		query.append("							  				,C.LOC_CD DESC" ).append("\n"); 
		query.append("							  				,DECODE (D.CMDT_FLG , 'Y', 1 , 2) ASC" ).append("\n"); 
		query.append("              				  				,DECODE (D.ACT_CUST_FLG , 'Y', 1 , 2) ASC" ).append("\n"); 
		query.append("              								,DECODE (D.RCV_DE_TERM_CD , 'Y', 1 , 2) ASC" ).append("\n"); 
		query.append("                							,D.SC_EXPT_FM_CONTI_CD DESC  " ).append("\n"); 
		query.append("                							,D.SC_EXPT_FM_CNT_CD DESC" ).append("\n"); 
		query.append("                							,D.SC_EXPT_FM_RGN_CD DESC " ).append("\n"); 
		query.append("                							,D.SC_EXPT_FM_STE_CD DESC  " ).append("\n"); 
		query.append("                							,D.SC_EXPT_FM_LOC_CD DESC  " ).append("\n"); 
		query.append("                							,D.FNL_DEST_CNT_CD DESC" ).append("\n"); 
		query.append("                							,D.FNL_DEST_RGN_CD DESC    " ).append("\n"); 
		query.append("                							,D.FNL_DEST_STE_CD DESC" ).append("\n"); 
		query.append("                							,D.FNL_DEST_LOC_CD DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" WHERE ROWNUM < 2" ).append("\n"); 

	}
}
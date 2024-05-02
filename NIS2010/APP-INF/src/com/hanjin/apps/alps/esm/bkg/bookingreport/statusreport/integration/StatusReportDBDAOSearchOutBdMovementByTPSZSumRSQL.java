/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : StatusReportDBDAOSearchOutBdMovementByTPSZSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchOutBdMovementByTPSZSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outbound Container Movement Status by Type/Size[ESM_BKG_0619]
	  * 2015.06.08 COA_MON_VVD ==>MAS_MON_VVD 변경
	  * </pre>
	  */
	public StatusReportDBDAOSearchOutBdMovementByTPSZSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_bkg_rqst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_1_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_1_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_dup_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchOutBdMovementByTPSZSumRSQL").append("\n"); 
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
		query.append("WITH AAA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT  SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR" ).append("\n"); 
		query.append("         , V.COST_WK" ).append("\n"); 
		query.append("         , V.SLS_YRMON" ).append("\n"); 
		query.append("         , V.TRD_CD" ).append("\n"); 
		query.append("         , V.SUB_TRD_CD" ).append("\n"); 
		query.append("         , V.RLANE_CD" ).append("\n"); 
		query.append("         , V.DIR_CD" ).append("\n"); 
		query.append("         , V.VSL_CD" ).append("\n"); 
		query.append("         , V.SKD_VOY_NO" ).append("\n"); 
		query.append("         , V.DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("         , V.IOC_CD" ).append("\n"); 
		query.append("   FROM    MDM_REV_LANE RL" ).append("\n"); 
		query.append("         , MAS_MON_VVD V" ).append("\n"); 
		query.append("   WHERE   RL.RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("   AND     V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND     V.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND     V.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND     V.DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BKG_VVD_DATE AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT  B.BKG_NO" ).append("\n"); 
		query.append("         , BV.SLAN_CD" ).append("\n"); 
		query.append("         , BV.VSL_CD" ).append("\n"); 
		query.append("         , BV.SKD_VOY_NO" ).append("\n"); 
		query.append("         , BV.SKD_DIR_CD" ).append("\n"); 
		query.append("         , DRL.TRD_CD" ).append("\n"); 
		query.append("         , DRL.SUB_TRD_CD" ).append("\n"); 
		query.append("         , DRL.RLANE_CD" ).append("\n"); 
		query.append("         , BV.POL_CD" ).append("\n"); 
		query.append("         , BV.POD_CD" ).append("\n"); 
		query.append("         , B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("              SELECT  SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, BV.SKD_DIR_CD)" ).append("\n"); 
		query.append("              FROM    MDM_LOCATION L" ).append("\n"); 
		query.append("              WHERE   L.LOC_CD = BV.POL_CD" ).append("\n"); 
		query.append("           ) FM_CONTI_CD," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("              SELECT  SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, BV.SKD_DIR_CD)" ).append("\n"); 
		query.append("              FROM    MDM_LOCATION L" ).append("\n"); 
		query.append("              WHERE   L.LOC_CD = BV.POD_CD" ).append("\n"); 
		query.append("           ) TO_CONTI_CD" ).append("\n"); 
		query.append("   FROM    BKG_VVD BV" ).append("\n"); 
		query.append("         , BKG_BOOKING B" ).append("\n"); 
		query.append("         , AAA M" ).append("\n"); 
		query.append("         , MDM_DTL_REV_LANE DRL" ).append("\n"); 
		query.append("         , MDM_REV_LANE RL" ).append("\n"); 
		query.append("   WHERE   B.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("   AND     M.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("   AND     M.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND     M.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND     RL.VSL_SLAN_CD = BV.SLAN_CD" ).append("\n"); 
		query.append("   AND     DRL.RLANE_CD = RL.RLANE_CD" ).append("\n"); 
		query.append("   AND     DRL.RLANE_CD = M.RLANE_CD" ).append("\n"); 
		query.append("   AND     DRL.VSL_SLAN_DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("   AND     DRL.IOC_CD = M.IOC_CD" ).append("\n"); 
		query.append("   AND     DRL.TRD_CD = M.TRD_CD" ).append("\n"); 
		query.append("   AND     DRL.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND     DRL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND     DRL.FM_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, M.DIR_CD) FROM MDM_LOCATION L WHERE L.LOC_CD = BV.POL_CD )" ).append("\n"); 
		query.append("   AND     DRL.TO_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, M.DIR_CD) FROM MDM_LOCATION L WHERE L.LOC_CD = BV.POD_CD )" ).append("\n"); 
		query.append("   AND     RL.RLANE_CD = M.RLANE_CD" ).append("\n"); 
		query.append("   AND     RL.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND     RL.DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  SUB1.VVD_CD" ).append("\n"); 
		query.append("      , SUB1.TRD_CD" ).append("\n"); 
		query.append("      , SUB1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , SUB1.RLANE_CD" ).append("\n"); 
		query.append("      , SUB1.VVD_CD||SUB1.TRD_CD||SUB1.SUB_TRD_CD||SUB1.RLANE_CD SUB_STR" ).append("\n"); 
		query.append("      , SUB1.CNTR_TPSZ_CD_MV" ).append("\n"); 
		query.append("      , SUM(NVL(SUB1.BKG_QTY,0)) BKG_QTY" ).append("\n"); 
		query.append("      , SUM(SUB1.OP) OP" ).append("\n"); 
		query.append("      , SUM(SUB1.OC) OC" ).append("\n"); 
		query.append("      , SUM(SUB1.ETN) ETN" ).append("\n"); 
		query.append("      , SUM(SUB1.CY) CY" ).append("\n"); 
		query.append("      , SUM(SUB1.VL) VL" ).append("\n"); 
		query.append("      , SUM(SUB1.MT) MT" ).append("\n"); 
		query.append("      , SUM(SUB1.OT) OT" ).append("\n"); 
		query.append("      , SUM(SUB1.TTL) TTL" ).append("\n"); 
		query.append("      , SUM(NVL(SUB1.BKG_QTY,0)) - SUM(NVL(SUB1.TTL,0)) DIFF_QTY" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("          SELECT  VVD_CD" ).append("\n"); 
		query.append("				, TRD_CD" ).append("\n"); 
		query.append("                , SUB_TRD_CD" ).append("\n"); 
		query.append("                , RLANE_CD" ).append("\n"); 
		query.append("                , CNTR_TPSZ_CD CNTR_TPSZ_CD_MV" ).append("\n"); 
		query.append("                , SUM(NVL(OP_CNTR_QTY,0)) BKG_QTY" ).append("\n"); 
		query.append("                , 0 OP" ).append("\n"); 
		query.append("                , 0 OC" ).append("\n"); 
		query.append("                , 0 ETN" ).append("\n"); 
		query.append("                , 0 CY" ).append("\n"); 
		query.append("                , 0 VL" ).append("\n"); 
		query.append("                , 0 MT" ).append("\n"); 
		query.append("                , 0 OT" ).append("\n"); 
		query.append("                , 0 TTL" ).append("\n"); 
		query.append("          FROM    (" ).append("\n"); 
		query.append("                    SELECT  DISTINCT VB.TRUNK_VVD" ).append("\n"); 
		query.append("						  , VB.KEY_VSL_CD||VB.KEY_SKD_VOY_NO||VB.KEY_SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                          , BVD.TRD_CD" ).append("\n"); 
		query.append("                          , BVD.SUB_TRD_CD" ).append("\n"); 
		query.append("                          , BVD.RLANE_CD" ).append("\n"); 
		query.append("                          , VB.BKG_NO" ).append("\n"); 
		query.append("                          , VB.BKG_STS_CD" ).append("\n"); 
		query.append("                          , VB.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                          , VB.POR_CD" ).append("\n"); 
		query.append("                          , VB.POD_CD" ).append("\n"); 
		query.append("                          , VB.POL_CD" ).append("\n"); 
		query.append("                          , A.OP_CNTR_QTY" ).append("\n"); 
		query.append("                          , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    FROM    BKG_WORK_V VB" ).append("\n"); 
		query.append("                          , BKG_QUANTITY A  --SELECT * FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                          , VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                          , BKG_BOOKING BK" ).append("\n"); 
		query.append("                          , BKG_VVD_DATE BVD" ).append("\n"); 
		query.append("                    WHERE   VB.BKG_NO        = A.BKG_NO" ).append("\n"); 
		query.append("                    AND     V.VSL_CD(+)      = VB.KEY_VSL_CD" ).append("\n"); 
		query.append("                    AND     V.SKD_VOY_NO(+)  = VB.KEY_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     V.SKD_DIR_CD(+)  = VB.KEY_SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     (DECODE(VB.PRE_1_POL_CD, NULL, VB.TRUNK_POL, VB.PRE_1_POL_CD) = V.VPS_PORT_CD(+))" ).append("\n"); 
		query.append("                    AND     VB.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                    AND     VB.BKG_STS_CD IN ('F', 'W', 'A')" ).append("\n"); 
		query.append("                    AND     VB.BKG_NO = BVD.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.KEY_VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                    AND     VB.KEY_SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                    AND     VB.KEY_SKD_DIR_CD =  SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("                    AND     BVD.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '') " ).append("\n"); 
		query.append("                    AND     BVD.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("                    AND     BVD.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("                   AND     BVD.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_inc_sub} == 'Y') " ).append("\n"); 
		query.append("                   AND      VB.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("                                                SELECT  OFC_CD  " ).append("\n"); 
		query.append("                                                FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                                START WITH MO.OFC_CD IN ( " ).append("\n"); 
		query.append("                                                                          #if(${bkg_ofc_cd}=='')" ).append("\n"); 
		query.append("                                                                            VB.BKG_OFC_CD" ).append("\n"); 
		query.append("                                                                          #else" ).append("\n"); 
		query.append("                                                                               #foreach( ${key} in ${r_bkgOfcCd}) " ).append("\n"); 
		query.append("                                                                                   #if($velocityCount < $r_bkgOfcCd.size()) " ).append("\n"); 
		query.append("                                                                                       '${key}', " ).append("\n"); 
		query.append("                                                                                   #else " ).append("\n"); 
		query.append("                                                                                       '${key}'" ).append("\n"); 
		query.append("                                                                                   #end " ).append("\n"); 
		query.append("                                                                               #end" ).append("\n"); 
		query.append("                                                                          #end" ).append("\n"); 
		query.append("                                                                         )" ).append("\n"); 
		query.append("                                                CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("       #if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("                   AND      VB.BKG_OFC_CD IN ( " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        #foreach( ${key} in ${r_bkgOfcCd}) " ).append("\n"); 
		query.append("                          #if($velocityCount < $r_bkgOfcCd.size()) " ).append("\n"); 
		query.append("                             '${key}', " ).append("\n"); 
		query.append("                          #else " ).append("\n"); 
		query.append("                             '${key}'" ).append("\n"); 
		query.append("                          #end " ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period_flg} == 'B') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bkg_dt_fr} != '' || ${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	                   AND      VB.BKG_CRE_DT BETWEEN TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD') AND TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	                   AND      VB.BKG_CRE_DT <= TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${bkg_dt_to} != '') " ).append("\n"); 
		query.append("	                   AND      VB.BKG_CRE_DT >= TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${period_flg} == 'E') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bkg_dt_fr} != '' || ${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	                   AND      V.VPS_ETA_DT BETWEEN TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD') AND TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	                   AND      V.VPS_ETA_DT <= TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${bkg_dt_to} != '') " ).append("\n"); 
		query.append("	                   AND      V.VPS_ETA_DT >= TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("                    AND     VB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.KEY_POL_CD  LIKE RTRIM(@[pol_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.POR_CD LIKE RTRIM(@[por_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rcv_term_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_term_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chk_lt_type} == 'L') " ).append("\n"); 
		query.append("                    AND     VB.KEY_POL_CD = VB.POL_CD	--L/T Local  " ).append("\n"); 
		query.append("#elseif (${chk_lt_type} == 'T') " ).append("\n"); 
		query.append("                    AND     VB.KEY_POL_CD <> VB.POL_CD	--T/S" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.BKG_STS_CD = @[bkg_sts_cd]  	--예약 현황 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_1_vvd} != '') " ).append("\n"); 
		query.append("                    AND     VB.PRE_1_VVD LIKE @[pre_1_vvd] || '%'	--pre_vvd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_1_pol_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.PRE_1_POL_CD = @[pre_1_pol_cd]		--pre_pol       " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_bkg_rqst_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.XTER_BKG_RQST_CD = @[xter_bkg_rqst_cd]	--BKG Kind " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '') " ).append("\n"); 
		query.append("                    AND     BK.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]	 --화물 종류All, Full, Empty로 구분 (Cargo Type 코드 참고)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dest_trns_svc_mod_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.DEST_TRNS_SVC_MOD_CD = @[dest_trns_svc_mod_cd]	--Service Mode" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("--1.'SHPR'" ).append("\n"); 
		query.append("#if (${cust_tp_cd} == 'S') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	    SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd] " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	    VB.SHIPPER LIKE @[cust_cnt_cd] || @[cust_seq] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	    VB.SHPR_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("--2.'CNEE'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'C') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	    SUBSTR(VB.CONSIGNEE,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	    VB.CONSIGNEE LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	    VB.CONSIGNEE_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--3.'NTFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'N') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	    SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	    VB.NTFY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	    VB.NTFY_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--4.'ANFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'A') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	    SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	    VB.ANTY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	    VB.ANTY_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--5.'FWDR'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	    SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	    VB.FFDR LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	    VB.FFDR_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--6.'선택하지 않았을때..'" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	  	(    SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                              OR SUBSTR(VB.CONSIGNEE,1,2)= @[cust_cnt_cd]" ).append("\n"); 
		query.append("                              OR SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                              OR SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                              OR SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND		(    VB.SHIPPER = @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("                              OR VB.CONSIGNEE = @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("                              OR VB.NTFY = @[cust_cnt_cd]|| @[cust_seq]" ).append("\n"); 
		query.append("                              OR VB.ANTY = @[cust_cnt_cd]|| @[cust_seq]" ).append("\n"); 
		query.append("                              OR VB.FFDR = @[cust_cnt_cd]|| @[cust_seq]" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND		(    VB.SHPR_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                              OR VB.CONSIGNEE_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                              OR VB.NTFY_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                              OR VB.ANTY_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                              OR VB.FFDR_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("                  ) T" ).append("\n"); 
		query.append("          GROUP BY VVD_CD, TRD_CD, SUB_TRD_CD, RLANE_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT  VVD_CD" ).append("\n"); 
		query.append("				, TRD_CD" ).append("\n"); 
		query.append("                , SUB_TRD_CD" ).append("\n"); 
		query.append("                , RLANE_CD" ).append("\n"); 
		query.append("                , CNTR_TPSZ_CD_MV CNTR_TPSZ_CD_MV" ).append("\n"); 
		query.append("                , 0 BKG_QTY" ).append("\n"); 
		query.append("                , SUM(DECODE(CNMV_STS_CD ,'OP',NVL(CNTR_VOL_QTY,0),0)) OP" ).append("\n"); 
		query.append("                , SUM(DECODE(CNMV_STS_CD ,'OC',NVL(CNTR_VOL_QTY,0) ,0)) OC" ).append("\n"); 
		query.append("                , SUM(DECODE(CNMV_STS_CD ,'EN',NVL(CNTR_VOL_QTY,0) ,DECODE(CNMV_STS_CD,'TN',NVL(CNTR_VOL_QTY,0),0))) ETN" ).append("\n"); 
		query.append("                , SUM(DECODE(CNMV_STS_CD ,'CY',NVL(CNTR_VOL_QTY,0) ,0)) CY" ).append("\n"); 
		query.append("                , SUM(DECODE(CNMV_STS_CD ,'VL',NVL(CNTR_VOL_QTY,0) ,0)) VL" ).append("\n"); 
		query.append("                , SUM(DECODE(CNMV_STS_CD ,'MT',NVL(CNTR_VOL_QTY,0) ,0)) MT" ).append("\n"); 
		query.append("                , SUM(DECODE(CNMV_STS_CD ,'OT',NVL(CNTR_VOL_QTY,0) ,0)) OT" ).append("\n"); 
		query.append("                , SUM(NVL(CNTR_VOL_QTY,0)) TTL" ).append("\n"); 
		query.append("          FROM    (" ).append("\n"); 
		query.append("                    SELECT  DISTINCT VB.TRUNK_VVD" ).append("\n"); 
		query.append("						  , VB.KEY_VSL_CD||VB.KEY_SKD_VOY_NO||VB.KEY_SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                          , BVD.TRD_CD" ).append("\n"); 
		query.append("                          , BVD.SUB_TRD_CD" ).append("\n"); 
		query.append("                          , BVD.RLANE_CD" ).append("\n"); 
		query.append("                          , VB.BKG_NO" ).append("\n"); 
		query.append("                          , VB.BKG_STS_CD" ).append("\n"); 
		query.append("                          , VB.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                          , VB.POR_CD" ).append("\n"); 
		query.append("                          , VB.POD_CD" ).append("\n"); 
		query.append("                          , VB.POL_CD" ).append("\n"); 
		query.append("                          , B.RCV_TERM_CD" ).append("\n"); 
		query.append("                          , B.DE_TERM_CD" ).append("\n"); 
		query.append("                          , B.CNTR_NO" ).append("\n"); 
		query.append("                          , B.CNTR_TPSZ_CD CNTR_TPSZ_CD_MV" ).append("\n"); 
		query.append("                          , B.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                          , CASE WHEN B.CNMV_STS_CD IN ('OP', 'OC', 'EN', 'TN', 'CY','VL','MT') THEN B.CNMV_STS_CD ELSE 'OT' END CNMV_STS_CD" ).append("\n"); 
		query.append("#if (${chk_dup_vvd} != '') " ).append("\n"); 
		query.append("                          , (" ).append("\n"); 
		query.append("                              SELECT  TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD||SUBSTR(DECODE(SUBSTR(ORG_YD_CD,1,5),'CNHKG','HKGCN',SUBSTR(ORG_YD_CD,1,5)),1,2)" ).append("\n"); 
		query.append("                              FROM    CTM_MOVEMENT  " ).append("\n"); 
		query.append("                              WHERE   CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                              AND     BKG_NO =BK.BKG_NO" ).append("\n"); 
		query.append("                              AND     NVL(TRNK_VSL_CD,'SMXX') NOT IN('SMXX','SMZZ')" ).append("\n"); 
		query.append("                              AND     CNMV_EVNT_DT = (" ).append("\n"); 
		query.append("                                                       SELECT  MAX(CNMV_EVNT_DT)" ).append("\n"); 
		query.append("                                                       FROM    CTM_MOVEMENT" ).append("\n"); 
		query.append("                                                       WHERE   CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                                       AND     BKG_NO =BK.BKG_NO" ).append("\n"); 
		query.append("                                                       AND     MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("                              AND     MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("                              AND     ROWNUM =1" ).append("\n"); 
		query.append("                            ) CRN_VVD_CNT                        " ).append("\n"); 
		query.append("                          , (" ).append("\n"); 
		query.append("                              SELECT  TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD||SUBSTR(DECODE(SUBSTR(CTM.ORG_YD_CD, 1, 5), 'CNHKG', 'HKGCN', SUBSTR(CTM.ORG_YD_CD, 1, 5)), 1, 2)" ).append("\n"); 
		query.append("                              FROM    CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("                                    , BKG_BOOKING BB" ).append("\n"); 
		query.append("                                    , BKG_CONTAINER BC" ).append("\n"); 
		query.append("                              WHERE   CTM.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                              AND     CTM.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                              AND     CTM.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("							  AND	  CTM.BKG_NO <> BK.BKG_NO" ).append("\n"); 
		query.append("                              AND     CTM.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                              AND     CTM.BKG_CGO_TP_CD ='F'" ).append("\n"); 
		query.append("                              AND     NVL(CTM.TRNK_VSL_CD, 'SMXX') NOT IN('SMXX','SMZZ')" ).append("\n"); 
		query.append("                              AND     CTM.CNMV_CYC_NO = (" ).append("\n"); 
		query.append("                                                          SELECT  MAX(CNMV_CYC_NO) - 1" ).append("\n"); 
		query.append("                                                          FROM    CTM_MOVEMENT" ).append("\n"); 
		query.append("                                                          WHERE   CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                                          AND     BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                          AND     MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("                                                          AND     NVL(TRNK_VSL_CD, 'SMXX') NOT IN('SMXX','SMZZ')" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                              AND    CTM.CNMV_EVNT_DT < (" ).append("\n"); 
		query.append("                                                          SELECT  MAX(CNMV_EVNT_DT)" ).append("\n"); 
		query.append("                                                          FROM    CTM_MOVEMENT" ).append("\n"); 
		query.append("                                                          WHERE   CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                                          AND     BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                          AND     MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("                                                          AND     NVL(TRNK_VSL_CD, 'SMXX') NOT IN('SMXX','SMZZ')" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("                              AND    CTM.CNMV_EVNT_DT >= (" ).append("\n"); 
		query.append("                                                          SELECT  MAX(CNMV_EVNT_DT) - 30" ).append("\n"); 
		query.append("                                                          FROM    CTM_MOVEMENT" ).append("\n"); 
		query.append("                                                          WHERE   CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                                          AND     BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                          AND     MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("                                                          AND     NVL(TRNK_VSL_CD, 'SMXX') NOT IN('SMXX','SMZZ')" ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("                              AND    CTM.MVMT_STS_CD IN ('OC','OP')" ).append("\n"); 
		query.append("                              AND    BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                              AND    ROWNUM = 1" ).append("\n"); 
		query.append("                            ) PRE_VVD_CNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    FROM    BKG_WORK_V VB" ).append("\n"); 
		query.append("                          , VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                          , BKG_CONTAINER B" ).append("\n"); 
		query.append("                          , BKG_BOOKING BK" ).append("\n"); 
		query.append("                          , CTM_MOVEMENT MOVE" ).append("\n"); 
		query.append("                          , BKG_VVD_DATE BVD" ).append("\n"); 
		query.append("                    WHERE   V.VSL_CD(+) = VB.KEY_VSL_CD" ).append("\n"); 
		query.append("                    AND     V.SKD_VOY_NO(+) = VB.KEY_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     V.SKD_DIR_CD(+) = VB.KEY_SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     (DECODE(VB.PRE_1_POL_CD, NULL, VB.TRUNK_POL, VB.PRE_1_POL_CD) = V.VPS_PORT_CD(+))" ).append("\n"); 
		query.append("                    AND     VB.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                    AND     VB.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("                    AND     B.CNTR_NO = MOVE.CNTR_NO(+)" ).append("\n"); 
		query.append("                    AND     B.CNMV_YR = MOVE.CNMV_YR(+)" ).append("\n"); 
		query.append("                    AND     B.CNMV_ID_NO = MOVE.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("                    AND     VB.BKG_STS_CD IN ('F','W','A')" ).append("\n"); 
		query.append("                    AND     VB.BKG_NO = BVD.BKG_NO(+)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                    AND     VB.KEY_VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                    AND     VB.KEY_SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                    AND     VB.KEY_SKD_DIR_CD =  SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("                    AND     BVD.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '') " ).append("\n"); 
		query.append("                    AND     BVD.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("                    AND     BVD.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_inc_sub} == 'Y') " ).append("\n"); 
		query.append("                   AND      VB.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("                                                SELECT  OFC_CD  " ).append("\n"); 
		query.append("                                                FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                                START WITH MO.OFC_CD IN ( " ).append("\n"); 
		query.append("                                                                          #if(${bkg_ofc_cd}=='')" ).append("\n"); 
		query.append("                                                                            VB.BKG_OFC_CD" ).append("\n"); 
		query.append("                                                                          #else" ).append("\n"); 
		query.append("                                                                               #foreach( ${key} in ${r_bkgOfcCd}) " ).append("\n"); 
		query.append("                                                                                   #if($velocityCount < $r_bkgOfcCd.size()) " ).append("\n"); 
		query.append("                                                                                       '${key}', " ).append("\n"); 
		query.append("                                                                                   #else " ).append("\n"); 
		query.append("                                                                                       '${key}'" ).append("\n"); 
		query.append("                                                                                   #end " ).append("\n"); 
		query.append("                                                                               #end" ).append("\n"); 
		query.append("                                                                          #end" ).append("\n"); 
		query.append("                                                                         )" ).append("\n"); 
		query.append("                                                CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("       #if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("                   AND      VB.BKG_OFC_CD IN ( " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        #foreach( ${key} in ${r_bkgOfcCd}) " ).append("\n"); 
		query.append("                          #if($velocityCount < $r_bkgOfcCd.size()) " ).append("\n"); 
		query.append("                             '${key}', " ).append("\n"); 
		query.append("                          #else " ).append("\n"); 
		query.append("                             '${key}'" ).append("\n"); 
		query.append("                          #end " ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period_flg} == 'B') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bkg_dt_fr} != '' || ${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	                   AND      VB.BKG_CRE_DT BETWEEN TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD') AND TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	                   AND      VB.BKG_CRE_DT <= TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${bkg_dt_to} != '') " ).append("\n"); 
		query.append("	                   AND      VB.BKG_CRE_DT >= TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${period_flg} == 'E') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bkg_dt_fr} != '' || ${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	                   AND      V.VPS_ETA_DT BETWEEN TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD') AND TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	                   AND      V.VPS_ETA_DT <= TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${bkg_dt_to} != '') " ).append("\n"); 
		query.append("	                   AND      V.VPS_ETA_DT >= TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("                    AND    VB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("                    AND    VB.KEY_POL_CD  LIKE RTRIM(@[pol_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("                    AND    VB.POR_CD LIKE RTRIM(@[por_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rcv_term_cd} != '') " ).append("\n"); 
		query.append("                    AND    B.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_term_cd} != '') " ).append("\n"); 
		query.append("                    AND    VB.DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_yd_cd} != '') " ).append("\n"); 
		query.append("                    AND    B.ORG_YD_CD LIKE  @[org_yd_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chk_lt_type} == 'L') " ).append("\n"); 
		query.append("                    AND    VB.KEY_POL_CD = VB.POL_CD	--L/T Local  " ).append("\n"); 
		query.append("#elseif (${chk_lt_type} == 'T') " ).append("\n"); 
		query.append("                    AND    VB.KEY_POL_CD <> VB.POL_CD	--T/S" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_cfm_flg} != '') " ).append("\n"); 
		query.append("                    AND    B.CNTR_CFM_FLG = @[cntr_cfm_flg]  --Booking Container의 Tab의 Confirm 정보 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append("                    AND    VB.BKG_STS_CD = @[bkg_sts_cd]  	--예약 현황 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_1_vvd} != '') " ).append("\n"); 
		query.append("                    AND    VB.PRE_1_VVD LIKE @[pre_1_vvd] || '%'	--pre_vvd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_1_pol_cd} != '') " ).append("\n"); 
		query.append("                    AND    VB.PRE_1_POL_CD = @[pre_1_pol_cd]		--pre_pol       " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_bkg_rqst_cd} != '') " ).append("\n"); 
		query.append("                    AND    VB.XTER_BKG_RQST_CD = @[xter_bkg_rqst_cd]	--BKG Kind " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} == 'Y') " ).append("\n"); 
		query.append("                    AND    B.CNMV_STS_CD = 'OC'	--O/C Status    Container Status가 OC인 항목 조회" ).append("\n"); 
		query.append("#elseif  (${cnmv_sts_cd} == 'N') " ).append("\n"); 
		query.append("                    AND    B.CNMV_STS_CD != 'OC'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '') " ).append("\n"); 
		query.append("                    AND    BK.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]	 --화물 종류All, Full, Empty로 구분 (Cargo Type 코드 참고)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dest_trns_svc_mod_cd} != '') " ).append("\n"); 
		query.append("                    AND    VB.DEST_TRNS_SVC_MOD_CD = @[dest_trns_svc_mod_cd]	--Service Mode" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("--1.'SHPR'" ).append("\n"); 
		query.append("#if (${cust_tp_cd} == 'S') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	   SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd] " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	   VB.SHIPPER LIKE @[cust_cnt_cd] || @[cust_seq] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	   VB.SHPR_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("--2.'CNEE'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'C') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	   SUBSTR(VB.CONSIGNEE,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	   VB.CONSIGNEE LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	   VB.CONSIGNEE_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--3.'NTFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'N') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	   SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	   VB.NTFY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	   VB.NTFY_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--4.'ANFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'A') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	   SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	   VB.ANTY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	   VB.ANTY_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--5.'FWDR'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	   SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	   VB.FFDR LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	   VB.FFDR_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--6.'선택하지 않았을때..'" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("                    AND	   (    SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                             OR SUBSTR(VB.CONSIGNEE,1,2)= @[cust_cnt_cd]" ).append("\n"); 
		query.append("                             OR SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                             OR SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                             OR SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("                    AND	   (    VB.SHIPPER = @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("                             OR VB.CONSIGNEE = @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("                             OR VB.NTFY = @[cust_cnt_cd]|| @[cust_seq]" ).append("\n"); 
		query.append("                             OR VB.ANTY = @[cust_cnt_cd]|| @[cust_seq]" ).append("\n"); 
		query.append("                             OR VB.FFDR = @[cust_cnt_cd]|| @[cust_seq]" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    AND	   (    VB.SHPR_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                             OR	VB.CONSIGNEE_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                             OR VB.NTFY_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                             OR VB.ANTY_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                             OR VB.FFDR_NAME = @[cust_nm]" ).append("\n"); 
		query.append("                           )		" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                  ) T" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${chk_dup_vvd} != '') " ).append("\n"); 
		query.append("          WHERE   DECODE(CRN_VVD_CNT,NULL,'',DECODE(PRE_VVD_CNT,NULL,'',DECODE(SUBSTR(CRN_VVD_CNT,-2),SUBSTR(PRE_VVD_CNT,-2),'D',''))) = @[chk_dup_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          GROUP BY VVD_CD, TRD_CD, SUB_TRD_CD, RLANE_CD, CNTR_TPSZ_CD_MV" ).append("\n"); 
		query.append("        ) SUB1" ).append("\n"); 
		query.append("WHERE   SUB1.CNTR_TPSZ_CD_MV IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY SUB1.VVD_CD, SUB1.TRD_CD, SUB1.SUB_TRD_CD, SUB1.RLANE_CD, SUB1.CNTR_TPSZ_CD_MV" ).append("\n"); 

	}
}
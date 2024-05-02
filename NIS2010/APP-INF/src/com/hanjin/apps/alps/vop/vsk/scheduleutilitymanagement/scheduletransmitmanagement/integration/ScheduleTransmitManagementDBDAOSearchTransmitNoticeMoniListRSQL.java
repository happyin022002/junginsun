/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScheduleTransmitManagementDBDAOSearchTransmitNoticeMoniListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleTransmitManagementDBDAOSearchTransmitNoticeMoniListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ETA 및 Pre Stowage Notice 발송내역 조회
	  * </pre>
	  */
	public ScheduleTransmitManagementDBDAOSearchTransmitNoticeMoniListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_purp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_port_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dif_over_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleTransmitManagementDBDAOSearchTransmitNoticeMoniListRSQL").append("\n"); 
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
		query.append("SELECT T.RHQ_OFC_CD" ).append("\n"); 
		query.append("     , T.CTRL_OFC_CD" ).append("\n"); 
		query.append("     , T.VPS_PORT_CD" ).append("\n"); 
		query.append("     , T.YD_CD" ).append("\n"); 
		query.append("     , T.SLAN_CD" ).append("\n"); 
		query.append("     , T.VVD" ).append("\n"); 
		query.append("     , T.VSL_ENG_NM" ).append("\n"); 
		query.append("     , T.ACT_CRR_CD" ).append("\n"); 
		query.append("     , T.VPS_ETA_DT" ).append("\n"); 
		query.append("     , T.VPS_ETB_DT" ).append("\n"); 
		query.append("     , T.ACT_ARR_DT" ).append("\n"); 
		query.append("     , T.ACT_BRTH_DT" ).append("\n"); 
		query.append("	 , T.ACT_DEP_DT" ).append("\n"); 
		query.append("     , T.NTC_ETA_DT" ).append("\n"); 
		query.append("     , T.NTC_ETB_DT" ).append("\n"); 
		query.append("     , T.TRSM_LOCL_DT" ).append("\n"); 
		query.append("     , T.UPD_USR_ID" ).append("\n"); 
		query.append("     , T.ESVC_VNDR_SEQ" ).append("\n"); 
		query.append("     , T.DIF_OVER_ARR_DT    " ).append("\n"); 
		query.append("     , T.DIF_OVER_BRTH_DT    " ).append("\n"); 
		query.append("     , T.RPM_ADJ_DT" ).append("\n"); 
		query.append("     , T.ORG_RPM_PWR" ).append("\n"); 
		query.append("     , T.CRNT_RPM_PWR     " ).append("\n"); 
		query.append("     , T.TRSM_HIS_SEQ" ).append("\n"); 
		query.append("     , T.TRSM_MZD_CD" ).append("\n"); 
		query.append("     , T.TRSM_MZD_NM" ).append("\n"); 
		query.append("     , T.TRSM_OWNR_CD" ).append("\n"); 
		query.append("     , T.clpt_ind_seq" ).append("\n"); 
		query.append("     , T.SEQ" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     , ABS(ROUND(T.STW_DIF_HRS,2))     AS STW_DIF_HRS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT       " ).append("\n"); 
		query.append("                 Y.RHQ_OFC_CD" ).append("\n"); 
		query.append("            ,    Y.CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,    H.VPS_PORT_CD" ).append("\n"); 
		query.append("            ,    H.YD_CD" ).append("\n"); 
		query.append("            ,    H.SLAN_CD" ).append("\n"); 
		query.append("            ,    H.VSL_CD||H.SKD_VOY_NO||H.SKD_DIR_CD            AS VVD  " ).append("\n"); 
		query.append("            ,    (SELECT VC.VSL_ENG_NM " ).append("\n"); 
		query.append("                  FROM   MDM_VSL_CNTR  VC " ).append("\n"); 
		query.append("                  WHERE  VC.VSL_CD     = H.VSL_CD)               AS VSL_ENG_NM" ).append("\n"); 
		query.append("            ,    H.ACT_CRR_CD" ).append("\n"); 
		query.append("            ,    TO_CHAR(H.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') VPS_ETA_DT" ).append("\n"); 
		query.append("            ,    TO_CHAR(H.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') VPS_ETB_DT" ).append("\n"); 
		query.append("            ,    TO_CHAR(AK.ACT_ARR_DT, 'YYYY-MM-DD HH24:MI') ACT_ARR_DT" ).append("\n"); 
		query.append("            ,    TO_CHAR(AK.ACT_BRTH_DT, 'YYYY-MM-DD HH24:MI') ACT_BRTH_DT" ).append("\n"); 
		query.append("			,    TO_CHAR(AK.ACT_DEP_DT, 'YYYY-MM-DD HH24:MI') ACT_DEP_DT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,    TO_CHAR(H.NTC_ETA_DT, 'YYYY-MM-DD HH24:MI') NTC_ETA_DT" ).append("\n"); 
		query.append("            ,    TO_CHAR(H.NTC_ETB_DT, 'YYYY-MM-DD HH24:MI') NTC_ETB_DT" ).append("\n"); 
		query.append("            ,    TO_CHAR(H.TRSM_LOCL_DT, 'YYYY-MM-DD HH24:MI') TRSM_LOCL_DT" ).append("\n"); 
		query.append("            ,    H.UPD_USR_ID" ).append("\n"); 
		query.append("            ,    H.ESVC_VNDR_SEQ" ).append("\n"); 
		query.append("            ,    ROUND(NVL(H.NTC_ETA_DT - AK.ACT_ARR_DT ,0)*24,1)     AS DIF_OVER_ARR_DT    " ).append("\n"); 
		query.append("            ,    ROUND(NVL(H.NTC_ETB_DT - AK.ACT_BRTH_DT,0)*24,1)     AS DIF_OVER_BRTH_DT    " ).append("\n"); 
		query.append("            ,    TO_CHAR(H.RPM_ADJ_DT, 'YYYY-MM-DD HH24:MI') RPM_ADJ_DT" ).append("\n"); 
		query.append("            ,    H.ORG_RPM_PWR" ).append("\n"); 
		query.append("            ,    H.CRNT_RPM_PWR     " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,    H.TRSM_HIS_SEQ" ).append("\n"); 
		query.append("            ,    H.TRSM_MZD_CD" ).append("\n"); 
		query.append("            ,    (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                   WHERE INTG_CD_ID = 'CD03129'" ).append("\n"); 
		query.append("                     AND INTG_CD_VAL_CTNT = H.TRSM_MZD_CD" ).append("\n"); 
		query.append("                 ) TRSM_MZD_NM" ).append("\n"); 
		query.append("            ,    H.TRSM_OWNR_CD" ).append("\n"); 
		query.append("            ,    H.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            ,    ROW_NUMBER () OVER (PARTITION BY H.VSL_CD, H.SKD_VOY_NO, H.SKD_DIR_CD, H.VPS_PORT_CD, H.CLPT_IND_SEQ ORDER BY TRSM_HIS_SEQ DESC) SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,    AK.ACT_BRTH_DT - H.TRSM_LOCL_DT                 AS STW_DIF_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM         VSK_VSL_PORT_SKD_TRSM_HIS                       H" ).append("\n"); 
		query.append("            ,    VSK_ACT_PORT_SKD                                AK" ).append("\n"); 
		query.append("            ,    (" ).append("\n"); 
		query.append("                 SELECT ML.LOC_CD                                AS VPS_PORT_CD" ).append("\n"); 
		query.append("                     ,  ML.EQ_CTRL_OFC_CD                        AS CTRL_OFC_CD" ).append("\n"); 
		query.append("                     ,  CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                              ELSE" ).append("\n"); 
		query.append("                              CASE WHEN ML.CONTI_CD  IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR')                 THEN 'HAMRU'" ).append("\n"); 
		query.append("                                   WHEN ML.CONTI_CD  = 'M'                                                              THEN 'PHXRA'" ).append("\n"); 
		query.append("                                   WHEN ML.CONTI_CD  = 'A' AND ML.SCONTI_CD = 'AF'                                      THEN 'SHARC'" ).append("\n"); 
		query.append("                                   WHEN (ML.CONTI_CD = 'A' AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR')  THEN 'SINRS'" ).append("\n"); 
		query.append("                                   ELSE ''" ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("                         END                                     AS RHQ_OFC_CD" ).append("\n"); 
		query.append("                  FROM   MDM_LOCATION ML" ).append("\n"); 
		query.append("                 ) Y" ).append("\n"); 
		query.append("    WHERE        1 = 1                                    " ).append("\n"); 
		query.append("    AND          H.VSL_CD                                        = AK.VSL_CD           (+)" ).append("\n"); 
		query.append("    AND          H.SKD_VOY_NO                                    = AK.SKD_VOY_NO       (+)" ).append("\n"); 
		query.append("    AND          H.SKD_DIR_CD                                    = AK.SKD_DIR_CD       (+)" ).append("\n"); 
		query.append("    AND          H.VPS_PORT_CD                                   = AK.VPS_PORT_CD      (+)" ).append("\n"); 
		query.append("    AND          H.CLPT_IND_SEQ                                  = AK.CLPT_IND_SEQ     (+)   " ).append("\n"); 
		query.append("    AND          H.VPS_PORT_CD                                   = Y.VPS_PORT_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${fm_eta_dt} != '' && ${to_eta_dt} != '') " ).append("\n"); 
		query.append("    AND          H.VPS_ETA_DT BETWEEN TO_DATE(@[fm_eta_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eta_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vskd_port_rhq_cd} != 'ALL' && ${vskd_port_rhq_cd} != '') " ).append("\n"); 
		query.append("    AND          Y.RHQ_OFC_CD = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vop_port_ctrl_ofc_cd} != '') " ).append("\n"); 
		query.append("    AND          Y.CTRL_OFC_CD IN  (" ).append("\n"); 
		query.append("                                    #foreach($key IN ${vop_port_ctrl_ofc_cd}) " ).append("\n"); 
		query.append("                                    	#if($velocityCount < $vop_port_ctrl_ofc_cd.size())" ).append("\n"); 
		query.append("                                    		'$key'," ).append("\n"); 
		query.append("                                    	#else" ).append("\n"); 
		query.append("                                    		'$key'" ).append("\n"); 
		query.append("                                    	#end" ).append("\n"); 
		query.append("                                    #end" ).append("\n"); 
		query.append("            						)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("    AND          H.VPS_PORT_CD  = @[vps_port_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${tml_cd} != '') " ).append("\n"); 
		query.append("    AND          H.YD_CD IN  (" ).append("\n"); 
		query.append("            	              #foreach($key IN ${tml_cd}) " ).append("\n"); 
		query.append("                              	#if($velocityCount < $tml_cd.size())" ).append("\n"); 
		query.append("                              		'$key'," ).append("\n"); 
		query.append("                              	#else" ).append("\n"); 
		query.append("                              		'$key'" ).append("\n"); 
		query.append("                              	#end" ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${slan_cd} != '') " ).append("\n"); 
		query.append("    AND          H.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("    AND          H.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("    AND          H.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("    AND          H.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${act_crr_cd} != '')" ).append("\n"); 
		query.append("    AND          H.ACT_CRR_CD = @[act_crr_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${trsm_mzd_cd} != '')" ).append("\n"); 
		query.append("    AND          H.TRSM_MZD_CD = @[trsm_mzd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${dif_over_arr_dt} != '')" ).append("\n"); 
		query.append("    AND          ROUND(NVL(H.NTC_ETA_DT - AK.ACT_ARR_DT ,0)*24,1) <= TO_NUMBER(@[dif_over_arr_dt])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND          H.TRSM_PURP_CD	= @[trsm_purp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("#if (${lst_flg} != '')" ).append("\n"); 
		query.append("WHERE T.SEQ = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY T.RHQ_OFC_CD, T.CTRL_OFC_CD, T.VPS_PORT_CD, T.YD_CD, T.SLAN_CD, T.VVD, T.TRSM_HIS_SEQ" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeDBDAOChkPriScgRtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2016.05.04 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOChkPriScgRtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check the validation of the surcharge xml info and return the result of it
	  * </pre>
	  */
	public SurchargeDBDAOChkPriScgRtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_call_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_ga_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("min_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usa_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_esvc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOChkPriScgRtInfoRSQL").append("\n"); 
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
		query.append("WITH VDATA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--넘겨준 1 ROW" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       @[por_def_cd]         AS POR_DEF_CD" ).append("\n"); 
		query.append("     , @[pol_def_cd]         AS POL_DEF_CD" ).append("\n"); 
		query.append("     , @[pod_def_cd]         AS POD_DEF_CD" ).append("\n"); 
		query.append("     , @[del_def_cd]         AS DEL_DEF_CD" ).append("\n"); 
		query.append("     , @[rat_ut_cd]          AS RAT_UT_CD" ).append("\n"); 
		query.append("     , @[prc_cgo_tp_cd]      AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , @[scg_imdg_clss_cd]   AS SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , @[curr_cd]            AS CURR_CD" ).append("\n"); 
		query.append("     , @[scg_amt]            AS SCG_AMT" ).append("\n"); 
		query.append("     , @[pay_term_cd]        AS PAY_TERM_CD" ).append("\n"); 
		query.append("     , @[cnl_tz_cd]          AS CNL_TZ_CD" ).append("\n"); 
		query.append("     , @[min_cgo_wgt]        AS MIN_CGO_WGT" ).append("\n"); 
		query.append("     , @[max_cgo_wgt]        AS MAX_CGO_WGT" ).append("\n"); 
		query.append("     , @[org_trsp_mod_cd]    AS ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , @[dest_trsp_mod_cd]   AS DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , @[prc_rcv_term_cd]    AS PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , @[prc_de_term_cd]     AS PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , @[prc_hngr_bar_tp_cd] AS PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , @[sub_trd_cd]         AS SUB_TRD_CD" ).append("\n"); 
		query.append("     , @[vsl_slan_cd]        AS VSL_SLAN_CD" ).append("\n"); 
		query.append("     , @[dir_call_flg]       AS DIR_CALL_FLG" ).append("\n"); 
		query.append("     , @[tml_cd]             AS TML_CD" ).append("\n"); 
		query.append("     , @[cmdt_cd]            AS CMDT_CD" ).append("\n"); 
		query.append("     , @[io_ga_cd]           AS IO_GA_CD" ).append("\n"); 
		query.append("     , @[ts_port_cd]         AS TS_PORT_CD" ).append("\n"); 
		query.append("     , @[soc_flg]            AS SOC_FLG" ).append("\n"); 
		query.append("     , @[scg_grp_cmdt_cd]    AS SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , @[usa_svc_mod_cd]     AS USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , @[eff_dt]             AS EFF_DT" ).append("\n"); 
		query.append("     , @[exp_dt]             AS EXP_DT" ).append("\n"); 
		query.append("     , @[svc_scp_cd]         AS SVC_SCP_CD" ).append("\n"); 
		query.append("     , @[chg_cd]             AS CHG_CD" ).append("\n"); 
		query.append("     , @[scg_seq]            AS SCG_SEQ" ).append("\n"); 
		query.append("     , @[por_tp_cd]          AS POR_TP_CD" ).append("\n"); 
		query.append("     , @[pol_tp_cd]          AS POL_TP_CD" ).append("\n"); 
		query.append("     , @[pod_tp_cd]          AS POD_TP_CD" ).append("\n"); 
		query.append("     , @[del_tp_cd]          AS DEL_TP_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("MDM_LOC AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append("     , A.LOC_NM" ).append("\n"); 
		query.append("  FROM MDM_LOCATION A" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG ='N'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("MDM_LOC_ETC AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      A.LOC_CD" ).append("\n"); 
		query.append("    , A.LOC_NM" ).append("\n"); 
		query.append("    , B.ORG_DEST_CD" ).append("\n"); 
		query.append(" FROM MDM_LOCATION A" ).append("\n"); 
		query.append("    , MDM_SVC_SCP_LMT B" ).append("\n"); 
		query.append("WHERE A.RGN_CD = B.RGN_CD" ).append("\n"); 
		query.append("  AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND B.SVC_SCP_CD = (SELECT SVC_SCP_CD FROM VDATA)" ).append("\n"); 
		query.append("  AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("SCG_LOC AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SCG_GRP_LOC_DESC" ).append("\n"); 
		query.append("     , SCG_GRP_LOC_CD" ).append("\n"); 
		query.append("  FROM PRI_SCG_GRP_LOC" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = (SELECT SVC_SCP_CD FROM VDATA)" ).append("\n"); 
		query.append("   AND CHG_CD = (SELECT CHG_CD FROM VDATA)" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("MDM_REG AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.RGN_CD" ).append("\n"); 
		query.append("     , A.RGN_NM" ).append("\n"); 
		query.append("  FROM MDM_REGION A" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG ='N'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("MDM_COM AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CNT_NM" ).append("\n"); 
		query.append("     , CNT_CD" ).append("\n"); 
		query.append("  FROM MDM_COUNTRY" ).append("\n"); 
		query.append(" WHERE DELT_FLG ='N'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("TML_LOC AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("		yd_cd,      		" ).append("\n"); 
		query.append("   		yd_nm,  						" ).append("\n"); 
		query.append("		ofc_cd  					" ).append("\n"); 
		query.append("  FROM (SELECT ROW_NUMBER() OVER (ORDER BY A.yd_cd ASC) no,  " ).append("\n"); 
		query.append("				A.yd_cd,              				" ).append("\n"); 
		query.append("		        A.yd_nm,          					" ).append("\n"); 
		query.append("		        A.ofc_cd         					" ).append("\n"); 
		query.append("		 FROM mdm_yard A, mdm_location B		    " ).append("\n"); 
		query.append("		WHERE 1 = 1 " ).append("\n"); 
		query.append("		  AND A.loc_cd = B.loc_cd " ).append("\n"); 
		query.append("		  AND A.yd_cd LIKE '%' ||(SELECT TML_CD FROM VDATA)|| '%'" ).append("\n"); 
		query.append("		  AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    	  AND NVL(A.DELT_FLG, 'N') <> 'Y') A        " ).append("\n"); 
		query.append(" WHERE no = (SELECT COUNT(A.yd_cd) AS YD_CNT" ).append("\n"); 
		query.append("               FROM mdm_yard A, mdm_location B						" ).append("\n"); 
		query.append("              WHERE 1 = 1 " ).append("\n"); 
		query.append("                AND A.loc_cd = B.loc_cd " ).append("\n"); 
		query.append("                AND A.yd_cd LIKE '%' ||(SELECT TML_CD FROM VDATA)|| '%' " ).append("\n"); 
		query.append("                AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                AND NVL(A.DELT_FLG, 'N') <> 'Y')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN A.POR_DEF_CD IS NULL THEN 'S'" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                   CASE WHEN LENGTH(A.POR_DEF_CD) = 5 AND (A.POR_DEF_CD  = 'RPSCP'  OR A.POR_DEF_CD  = 'RQSCP') THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POR_DEF_CD) = 5 AND (A.POR_DEF_CD <> 'RPSCP' AND A.POR_DEF_CD <> 'RQSCP') AND (SELECT COUNT(*) FROM MDM_LOC     T1 WHERE T1.LOC_CD = A.POR_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POR_DEF_CD) = 4 AND (SELECT COUNT(*) FROM SCG_LOC T2 WHERE T2.SCG_GRP_LOC_CD = A.POR_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POR_DEF_CD) = 3 AND (SELECT COUNT(*) FROM MDM_REG T3 WHERE T3.RGN_CD = A.POR_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POR_DEF_CD) = 2 AND A.POR_DEF_CD  = 'RG' THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POR_DEF_CD) = 2 AND A.POR_DEF_CD <> 'RG' AND (SELECT COUNT(*) FROM MDM_COM     T4 WHERE T4.CNT_CD = A.POR_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        ELSE 'F'" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("        END POR_DEF_CD_VLD" ).append("\n"); 
		query.append("     , CASE WHEN A.POL_DEF_CD IS NULL THEN 'S'" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                   CASE WHEN LENGTH(A.POL_DEF_CD) = 5 AND (A.POL_DEF_CD  = 'RPSCP'  OR A.POL_DEF_CD  = 'RQSCP') THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POL_DEF_CD) = 5 AND (A.POL_DEF_CD <> 'RPSCP' AND A.POL_DEF_CD <> 'RQSCP') AND (SELECT COUNT(*) FROM MDM_LOC     T1 WHERE T1.LOC_CD = A.POL_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POL_DEF_CD) = 4 AND (SELECT COUNT(*) FROM SCG_LOC T2 WHERE T2.SCG_GRP_LOC_CD = A.POL_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POL_DEF_CD) = 3 AND (SELECT COUNT(*) FROM MDM_REG T3 WHERE T3.RGN_CD = A.POL_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POL_DEF_CD) = 2 AND A.POL_DEF_CD  = 'RG' THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POL_DEF_CD) = 2 AND A.POL_DEF_CD <> 'RG' AND (SELECT COUNT(*) FROM MDM_COM     T4 WHERE T4.CNT_CD = A.POL_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        ELSE 'F'" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("        END POL_DEF_CD_VLD" ).append("\n"); 
		query.append("     , CASE WHEN A.POD_DEF_CD IS NULL THEN 'S'" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                   CASE WHEN LENGTH(A.POD_DEF_CD) = 5 AND (A.POD_DEF_CD  = 'RPSCP'  OR A.POD_DEF_CD  = 'RQSCP') THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POD_DEF_CD) = 5 AND (A.POD_DEF_CD <> 'RPSCP' AND A.POD_DEF_CD <> 'RQSCP') AND (SELECT COUNT(*) FROM MDM_LOC     T1 WHERE T1.LOC_CD = A.POD_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POD_DEF_CD) = 4 AND (SELECT COUNT(*) FROM SCG_LOC T2 WHERE T2.SCG_GRP_LOC_CD = A.POD_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POD_DEF_CD) = 3 AND (SELECT COUNT(*) FROM MDM_REG T3 WHERE T3.RGN_CD = A.POD_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POD_DEF_CD) = 2 AND A.POD_DEF_CD  = 'RG' THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.POD_DEF_CD) = 2 AND A.POD_DEF_CD <> 'RG' AND (SELECT COUNT(*) FROM MDM_COM     T4 WHERE T4.CNT_CD = A.POD_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        ELSE 'F' " ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("        END POD_DEF_CD_VLD" ).append("\n"); 
		query.append("     , CASE WHEN A.DEL_DEF_CD IS NULL THEN 'S'" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                   CASE WHEN LENGTH(A.DEL_DEF_CD) = 5 AND (A.DEL_DEF_CD  = 'RPSCP'  OR A.DEL_DEF_CD  = 'RQSCP') THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.DEL_DEF_CD) = 5 AND (A.DEL_DEF_CD <> 'RPSCP' AND A.DEL_DEF_CD <> 'RQSCP') AND (SELECT COUNT(*) FROM MDM_LOC     T1 WHERE T1.LOC_CD = A.DEL_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.DEL_DEF_CD) = 4 AND (SELECT COUNT(*) FROM SCG_LOC T2 WHERE T2.SCG_GRP_LOC_CD = A.DEL_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.DEL_DEF_CD) = 3 AND (SELECT COUNT(*) FROM MDM_REG T3 WHERE T3.RGN_CD = A.DEL_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.DEL_DEF_CD) = 2 AND A.DEL_DEF_CD  = 'RG' THEN 'S'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.DEL_DEF_CD) = 2 AND A.DEL_DEF_CD <> 'RG' AND (SELECT COUNT(*) FROM MDM_COM     T4 WHERE T4.CNT_CD = A.DEL_DEF_CD) > 0 THEN 'S'" ).append("\n"); 
		query.append("                        ELSE 'F'" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("        END DEL_DEF_CD_VLD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CASE WHEN A.TS_PORT_CD IS NULL THEN 'T'" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                   CASE WHEN LENGTH(A.TS_PORT_CD) = 5 AND (A.TS_PORT_CD  = 'RPSCP'  OR A.TS_PORT_CD  = 'RQSCP') THEN 'T'" ).append("\n"); 
		query.append("                        WHEN LENGTH(A.TS_PORT_CD) = 5 AND (A.TS_PORT_CD <> 'RPSCP' AND A.TS_PORT_CD <> 'RQSCP') AND (SELECT COUNT(*) FROM MDM_LOC     T1 WHERE T1.LOC_CD = A.TS_PORT_CD) > 0 THEN 'T'" ).append("\n"); 
		query.append("                        ELSE 'F'" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("        END TS_PORT_CD_VLD" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , CASE WHEN A.TS_PORT_CD IS NULL THEN 'T'" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                   CASE WHEN LENGTH(TML_CD) = 5 AND (SELECT YD_CD FROM TML_LOC) IS NOT NULL THEN 'T'" ).append("\n"); 
		query.append("                        ELSE 'F'" ).append("\n"); 
		query.append("                    END        " ).append("\n"); 
		query.append("        END TML_CD_VLD" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("     , CASE WHEN A.TS_PORT_CD IS NULL THEN 'T'" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 DECODE( (SELECT CMDT_CD FROM MDM_COMMODITY WHERE DELT_FLG = 'N' AND CMDT_CD LIKE (SELECT CMDT_CD FROM TML_LOC) ||'%' AND ROWNUM = 1),'F','T')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("        END CMDT_CD_VLD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CASE WHEN LENGTH(A.POR_DEF_CD) = 5 AND (A.POR_DEF_CD  = 'RPSCP'  OR A.POR_DEF_CD  = 'RQSCP') THEN 'L'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POR_DEF_CD) = 5 AND (A.POR_DEF_CD <> 'RPSCP' AND A.POR_DEF_CD <> 'RQSCP') AND (SELECT COUNT(*) FROM MDM_LOC     T1 WHERE T1.LOC_CD = A.POR_DEF_CD) > 0 THEN 'L'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POR_DEF_CD) = 4 AND (SELECT COUNT(*) FROM SCG_LOC T2 WHERE T2.SCG_GRP_LOC_CD = A.POR_DEF_CD) > 0 THEN 'G'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POR_DEF_CD) = 3 AND (SELECT COUNT(*) FROM MDM_REG T3 WHERE T3.RGN_CD = A.POR_DEF_CD) > 0 THEN 'R'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POR_DEF_CD) = 2 AND A.POR_DEF_CD  = 'RG' THEN 'C'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POR_DEF_CD) = 2 AND A.POR_DEF_CD <> 'RG' AND (SELECT COUNT(*) FROM MDM_COM     T4 WHERE T4.CNT_CD = A.POR_DEF_CD) > 0 THEN 'C'" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END POR_TP_CD_VLD" ).append("\n"); 
		query.append("     , CASE WHEN LENGTH(A.POL_DEF_CD) = 5 AND (A.POL_DEF_CD  = 'RPSCP'  OR A.POL_DEF_CD  = 'RQSCP') THEN 'L'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POL_DEF_CD) = 5 AND (A.POL_DEF_CD <> 'RPSCP' AND A.POL_DEF_CD <> 'RQSCP') AND (SELECT COUNT(*) FROM MDM_LOC     T1 WHERE T1.LOC_CD = A.POL_DEF_CD) > 0 THEN 'L'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POL_DEF_CD) = 4 AND (SELECT COUNT(*) FROM SCG_LOC T2 WHERE T2.SCG_GRP_LOC_CD = A.POL_DEF_CD) > 0 THEN 'G'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POL_DEF_CD) = 3 AND (SELECT COUNT(*) FROM MDM_REG T3 WHERE T3.RGN_CD = A.POL_DEF_CD) > 0 THEN 'R'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POL_DEF_CD) = 2 AND A.POL_DEF_CD  = 'RG' THEN 'C'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POL_DEF_CD) = 2 AND A.POL_DEF_CD <> 'RG' AND (SELECT COUNT(*) FROM MDM_COM     T4 WHERE T4.CNT_CD = A.POL_DEF_CD) > 0 THEN 'C'" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END POL_TP_CD_VLD" ).append("\n"); 
		query.append("     , CASE WHEN LENGTH(A.POD_DEF_CD) = 5 AND (A.POD_DEF_CD  = 'RPSCP'  OR A.POD_DEF_CD  = 'RQSCP') THEN 'L'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POD_DEF_CD) = 5 AND (A.POD_DEF_CD <> 'RPSCP' AND A.POD_DEF_CD <> 'RQSCP') AND (SELECT COUNT(*) FROM MDM_LOC     T1 WHERE T1.LOC_CD = A.POD_DEF_CD) > 0 THEN 'L'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POD_DEF_CD) = 4 AND (SELECT COUNT(*) FROM SCG_LOC T2 WHERE T2.SCG_GRP_LOC_CD = A.POD_DEF_CD) > 0 THEN 'G'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POD_DEF_CD) = 3 AND (SELECT COUNT(*) FROM MDM_REG T3 WHERE T3.RGN_CD = A.POD_DEF_CD) > 0 THEN 'R'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POD_DEF_CD) = 2 AND A.POD_DEF_CD  = 'RG' THEN 'C'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.POD_DEF_CD) = 2 AND A.POD_DEF_CD <> 'RG' AND (SELECT COUNT(*) FROM MDM_COM     T4 WHERE T4.CNT_CD = A.POD_DEF_CD) > 0 THEN 'C'" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END POD_TP_CD_VLD" ).append("\n"); 
		query.append("     , CASE WHEN LENGTH(A.DEL_DEF_CD) = 5 AND (A.DEL_DEF_CD  = 'RPSCP'  OR A.DEL_DEF_CD  = 'RQSCP') THEN 'L'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.DEL_DEF_CD) = 5 AND (A.DEL_DEF_CD <> 'RPSCP' AND A.DEL_DEF_CD <> 'RQSCP') AND (SELECT COUNT(*) FROM MDM_LOC     T1 WHERE T1.LOC_CD = A.DEL_DEF_CD) > 0 THEN 'L'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.DEL_DEF_CD) = 4 AND (SELECT COUNT(*) FROM SCG_LOC T2 WHERE T2.SCG_GRP_LOC_CD = A.DEL_DEF_CD) > 0 THEN 'G'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.DEL_DEF_CD) = 3 AND (SELECT COUNT(*) FROM MDM_REG T3 WHERE T3.RGN_CD = A.DEL_DEF_CD) > 0 THEN 'R'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.DEL_DEF_CD) = 2 AND A.DEL_DEF_CD  = 'RG' THEN 'C'" ).append("\n"); 
		query.append("            WHEN LENGTH(A.DEL_DEF_CD) = 2 AND A.DEL_DEF_CD <> 'RG' AND (SELECT COUNT(*) FROM MDM_COM     T4 WHERE T4.CNT_CD = A.DEL_DEF_CD) > 0 THEN 'C'" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END DEL_TP_CD_VLD" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM PRI_SCG_RT" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${por_def_cd} != '')" ).append("\n"); 
		query.append("   AND POR_DEF_CD = @[por_def_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND POR_DEF_CD IS NULL   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '')" ).append("\n"); 
		query.append("   AND POL_DEF_CD = @[pol_def_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND POL_DEF_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '')" ).append("\n"); 
		query.append("   AND POD_DEF_CD = @[pod_def_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND POD_DEF_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("   AND DEL_DEF_CD = @[del_def_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND DEL_DEF_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND RAT_UT_CD = @[rat_ut_cd]" ).append("\n"); 
		query.append("#if (${prc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("   AND PRC_CGO_TP_CD = @[prc_cgo_tp_cd] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PRC_CGO_TP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_imdg_clss_cd} != '')" ).append("\n"); 
		query.append("   AND SCG_IMDG_CLSS_CD = @[scg_imdg_clss_cd] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SCG_IMDG_CLSS_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("#if (${pay_term_cd} != '')" ).append("\n"); 
		query.append("   AND PAY_TERM_CD = @[pay_term_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PAY_TERM_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnl_tz_cd} != '')" ).append("\n"); 
		query.append("   AND CNL_TZ_CD = @[cnl_tz_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND CNL_TZ_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${min_cgo_wgt} != '')" ).append("\n"); 
		query.append("   AND MIN_CGO_WGT = @[min_cgo_wgt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND MIN_CGO_WGT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${max_cgo_wgt} != '')" ).append("\n"); 
		query.append("   AND MAX_CGO_WGT = @[max_cgo_wgt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND MAX_CGO_WGT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_trsp_mod_cd} != '')" ).append("\n"); 
		query.append("   AND ORG_TRSP_MOD_CD = @[org_trsp_mod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND ORG_TRSP_MOD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_trsp_mod_cd} != '')" ).append("\n"); 
		query.append("   AND DEST_TRSP_MOD_CD = @[dest_trsp_mod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND DEST_TRSP_MOD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_rcv_term_cd} != '')" ).append("\n"); 
		query.append("   AND PRC_RCV_TERM_CD = @[prc_rcv_term_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PRC_RCV_TERM_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_de_term_cd} != '')" ).append("\n"); 
		query.append("   AND PRC_DE_TERM_CD = @[prc_de_term_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PRC_DE_TERM_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_hngr_bar_tp_cd} != '')" ).append("\n"); 
		query.append("   AND PRC_HNGR_BAR_TP_CD = @[prc_hngr_bar_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PRC_HNGR_BAR_TP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '')" ).append("\n"); 
		query.append("   AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SUB_TRD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_call_flg} != '')" ).append("\n"); 
		query.append("   AND DIR_CALL_FLG = @[dir_call_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND DIR_CALL_FLG IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_cd} != '')" ).append("\n"); 
		query.append("   AND TML_CD = @[tml_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND TML_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND CMDT_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_ga_cd} != '')" ).append("\n"); 
		query.append("   AND IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND IO_GA_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ts_port_cd} != '')" ).append("\n"); 
		query.append("   AND TS_PORT_CD = @[ts_port_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND TS_PORT_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${soc_flg} != '')" ).append("\n"); 
		query.append("   AND SOC_FLG = @[soc_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SOC_FLG IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_grp_cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND SCG_GRP_CMDT_CD = @[scg_grp_cmdt_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SCG_GRP_CMDT_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usa_svc_mod_cd} != '')" ).append("\n"); 
		query.append("   AND USA_SVC_MOD_CD = @[usa_svc_mod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND USA_SVC_MOD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${exp_dt} != '')" ).append("\n"); 
		query.append("   AND ((TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT OR TO_DATE(@[exp_dt], 'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT) " ).append("\n"); 
		query.append("             OR (TO_DATE(@[eff_dt], 'YYYYMMDD') <= EFF_DT AND TO_DATE(@[exp_dt], 'YYYYMMDD') >= EXP_DT))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_esvc_tp_cd} != '')" ).append("\n"); 
		query.append("   AND BKG_ESVC_TP_CD = @[bkg_esvc_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND BKG_ESVC_TP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) AS DUP_IDX" ).append("\n"); 
		query.append("     , A.*" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("  FROM VDATA A" ).append("\n"); 

	}
}
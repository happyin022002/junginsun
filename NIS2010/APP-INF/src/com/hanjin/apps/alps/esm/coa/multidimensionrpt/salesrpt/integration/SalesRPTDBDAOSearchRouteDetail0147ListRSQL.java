/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SalesRPTDBDAOSearchRouteDetail0147ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchRouteDetail0147ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.06 이석준 [CHM-201215969-01] CM2 적용   
	  * </pre>
	  */
	public SalesRPTDBDAOSearchRouteDetail0147ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usa_bkg_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_key_acct_group_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_wk_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_shpr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_key_acct_indvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rev_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rev_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchRouteDetail0147ListRSQL").append("\n"); 
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
		query.append("      ORG" ).append("\n"); 
		query.append("      ,DEST" ).append("\n"); 
		query.append("      ,BKG_POR_CD" ).append("\n"); 
		query.append("      ,REV_POL_CD" ).append("\n"); 
		query.append("      ,REV_POD_CD" ).append("\n"); 
		query.append("      ,BKG_DEL_CD" ).append("\n"); 
		query.append("      ,SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,LOAD" ).append("\n"); 
		query.append("      ,BKG_REV                            AS REV" ).append("\n"); 
		query.append("      ,CM_COST                            AS CMC" ).append("\n"); 
		query.append("      ,(BKG_REV+MISC_REV-CM_COST)         AS CM" ).append("\n"); 
		query.append("      ,(BKG_REV+MISC_REV-CM_COST-CM2_COST) AS CM2" ).append("\n"); 
		query.append("      ,OP_COST + DEM_DET                  AS OPC" ).append("\n"); 
		query.append("      ,(BKG_REV+MISC_REV-CM_COST-OP_COST) AS OP" ).append("\n"); 
		query.append("      ,(BKG_REV/LOAD)                     AS G_RPB" ).append("\n"); 
		query.append("      ,CM_COST                            AS CM_COST" ).append("\n"); 
		query.append("      ,CM2_COST                           AS CM2_COST " ).append("\n"); 
		query.append("      ,CM_COST/LOAD                       AS CMCOST" ).append("\n"); 
		query.append("      ,(BKG_REV+MISC_REV-CM_COST)/LOAD    AS CMB" ).append("\n"); 
		query.append("      ,OP_COST+ DEM_DET                   AS OP_COST" ).append("\n"); 
		query.append("      ,(OP_COST+ DEM_DET)/LOAD            AS OPCOST" ).append("\n"); 
		query.append("      ,(BKG_REV+MISC_REV-CM_COST-OP_COST)/LOAD AS OPB" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("             I.CNT_CD ORG" ).append("\n"); 
		query.append("            ,J.CNT_CD DEST" ).append("\n"); 
		query.append("            ,B.BKG_POR_CD" ).append("\n"); 
		query.append("            ,B.REV_POL_CD" ).append("\n"); 
		query.append("            ,B.REV_POD_CD" ).append("\n"); 
		query.append("            ,B.BKG_DEL_CD" ).append("\n"); 
		query.append("#if (${f_view_tpsz} == 'box' )" ).append("\n"); 
		query.append("            ,B.SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,SUM(NVL(B.BKG_QTY,0)) LOAD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            ,'TEU' SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,SUM(DECODE(SUBSTR(B.SPCL_CNTR_TPSZ_CD,-1,1),'2', B.BKG_QTY, '3', B.BKG_QTY, B.BKG_QTY*2)) LOAD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            ,SUM(NVL(B.BKG_REV,0)+NVL(B.BKG_OFT_REV,0))      BKG_REV" ).append("\n"); 
		query.append("            ,SUM(NVL(B.BKG_MISC_REV,0)+NVL(B.SCR_CHG_REV,0)) MISC_REV" ).append("\n"); 
		query.append("            ,SUM(NVL(B.DMDT_COM_AMT,0))                      DEM_DET" ).append("\n"); 
		query.append("            ,SUM(DECODE(@[f_pro_vw], 'P', NVL(B.PA_CM_COST_TTL_AMT, 0), 'R', NVL(B.RA_CM_COST_TTL_AMT, 0))) CM_COST" ).append("\n"); 
		query.append("            ,SUM(DECODE(@[f_pro_vw], 'P', 0, 'R', NVL(B.RA_OP_COST_TTL_AMT, 0))) OP_COST" ).append("\n"); 
		query.append("            ,SUM(NVL(B.OWN_FDR_AMT,0)) CM2_COST" ).append("\n"); 
		query.append("       FROM" ).append("\n"); 
		query.append("#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("            COA_BKG_EXPN_DTL B" ).append("\n"); 
		query.append("#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("            COA_BKG_EXPN_DTL_WK B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           , COA_OFC_LVL E" ).append("\n"); 
		query.append("           , MDM_LOCATION I" ).append("\n"); 
		query.append("           , MDM_LOCATION J" ).append("\n"); 
		query.append("#if ( ${f_key_acct_group_cd} !='' )" ).append("\n"); 
		query.append(" #if ( ${f_key_acct_group_cd} !='All')" ).append("\n"); 
		query.append("  #if ( ${f_key_acct_indvl_cd} == '' )" ).append("\n"); 
		query.append("           , MDM_CUSTOMER K" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      WHERE   1=1" ).append("\n"); 
		query.append("#if ( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("           AND B.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("           AND B.COST_YRMON BETWEEN E.OFC_APLY_FM_YRMON AND E.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#elseif ( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("           AND SUBSTR(B.SLS_YRMON,1,4) || B.COST_WK BETWEEN  @[f_year]||@[f_fm_wk] AND  @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("           AND B.SLS_YRMON BETWEEN E.OFC_APLY_FM_YRMON AND E.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_ofc_vw} =='C')" ).append("\n"); 
		query.append("           AND B.AGMT_SGN_OFC_CD = E.OFC_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_vw} =='L')" ).append("\n"); 
		query.append("           AND B.SLS_OFC_CD = E.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND I.LOC_CD = B.BKG_POR_CD" ).append("\n"); 
		query.append("           AND J.LOC_CD = B.BKG_DEL_CD" ).append("\n"); 
		query.append("#if ( ${f_key_acct_group_cd} !='' )" ).append("\n"); 
		query.append(" #if ( ${f_key_acct_group_cd} !='All')" ).append("\n"); 
		query.append("  #if ( ${f_key_acct_indvl_cd} == '' )" ).append("\n"); 
		query.append("           AND B.AGMT_CNT_CD      = K.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND B.AGMT_CUST_SEQ    = K.CUST_SEQ" ).append("\n"); 
		query.append("           AND B.CUST_KEY_AGMT_MGR_FLG = K.CNTR_DIV_FLG" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_trd_cd} != '' )" ).append("\n"); 
		query.append("           AND B.TRD_CD = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_rlane_cd} != '' )" ).append("\n"); 
		query.append("           AND B.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_dir_sts} != 'Y' )" ).append("\n"); 
		query.append(" #if ( ${f_skd_dir_cd} != '' )" ).append("\n"); 
		query.append("           AND B.DIR_CD = @[f_skd_dir_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#elseif ( ${f_dir_sts} == 'Y' )" ).append("\n"); 
		query.append("           AND B.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_wk_sts} == 'Y' )" ).append("\n"); 
		query.append("           AND B.COST_WK = @[f_wk_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_vsl_cd} != '' )" ).append("\n"); 
		query.append("           AND B.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_skd_voy_no} != '' )" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_dir_cd} != '' )" ).append("\n"); 
		query.append("           AND B.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_bkg_por_cd} != '' )" ).append("\n"); 
		query.append("           AND B.BKG_POR_CD = @[f_bkg_por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_rev_pol_cd} != '' )" ).append("\n"); 
		query.append("           AND B.REV_POL_CD = @[f_rev_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_rev_pod_cd} != '' )" ).append("\n"); 
		query.append("           AND B.REV_POD_CD = @[f_rev_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_bkg_del_cd} != '' )" ).append("\n"); 
		query.append("           AND B.BKG_DEL_CD = @[f_bkg_del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_shpr} != '' )" ).append("\n"); 
		query.append("           AND B.SHPR_CNT_CD || B.SHPR_CUST_SEQ = @[f_shpr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_sc_no} != '' )" ).append("\n"); 
		query.append("           AND B.SC_NO = @[f_sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_rfa_no} != '' )" ).append("\n"); 
		query.append("           AND B.RFA_NO = @[f_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_key_acct_indvl_cd} !='' )" ).append("\n"); 
		query.append(" #if ( ${f_key_acct_indvl_cd} !='All')" ).append("\n"); 
		query.append("           AND B.AGMT_CNT_CD            = SUBSTR(@[f_key_acct_indvl_cd],1,2)" ).append("\n"); 
		query.append("           AND B.AGMT_CUST_SEQ          = TO_NUMBER ( SUBSTR(@[f_key_acct_indvl_cd],3) )" ).append("\n"); 
		query.append("           AND B.CUST_KEY_AGMT_MGR_FLG  = 'Y'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_key_acct_group_cd} !='' )" ).append("\n"); 
		query.append(" #if ( ${f_key_acct_group_cd} !='All')" ).append("\n"); 
		query.append("  #if ( ${f_key_acct_indvl_cd} == '' )" ).append("\n"); 
		query.append("           AND K.CUST_GRP_ID = @[f_key_acct_group_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_cmdt_cd} != '' )" ).append("\n"); 
		query.append("           AND B.REP_CMDT_CD = @[f_cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_usa_bkg_mod_cd} != '' )" ).append("\n"); 
		query.append("           AND B.USA_BKG_MOD_CD = @[f_usa_bkg_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append(" #if ( ${f_cntr_tpsz_cd} != 'TEU' )" ).append("\n"); 
		query.append("           AND B.SPCL_CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_bkg_no} != '' )" ).append("\n"); 
		query.append("           AND B.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND B.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("           AND B.BL_NO_TP       IN ('M','0')" ).append("\n"); 
		query.append("           AND B.BKG_CGO_TP_CD  <> 'P'" ).append("\n"); 
		query.append("#if ( ${f_bkg_sts} == 'Y' )" ).append("\n"); 
		query.append("           AND B.BKG_STS_CD     IN ('F','S','W')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND B.BKG_STS_CD     IN ('F','S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_sls_ofc_cd} != '' )" ).append("\n"); 
		query.append("           AND DECODE(@[f_rhq_cd]" ).append("\n"); 
		query.append("                      , '1', E.OFC_N1ST_LVL_CD, '2', E.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("                      , '3', E.OFC_N3RD_LVL_CD, '4', E.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("                      , '5', E.OFC_N5TH_LVL_CD, '6', E.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("                      , '7', E.OFC_N7TH_LVL_CD) = @[f_sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rhq_cd}=='6' || ${f_rhq_cd}=='7')" ).append("\n"); 
		query.append("           AND E.OFC_LVL = @[f_rhq_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND E.OFC_LVL < '9'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     GROUP BY B.TRD_CD, B.RLANE_CD, I.CNT_CD, J.CNT_CD" ).append("\n"); 
		query.append("            , B.BKG_POR_CD, B.REV_POL_CD, B.REV_POD_CD, B.BKG_DEL_CD" ).append("\n"); 
		query.append("#if (${f_view_tpsz} == 'box' )" ).append("\n"); 
		query.append("            , B.SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}
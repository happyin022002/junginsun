/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOsearchInqByLane0062ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.07.07 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOsearchInqByLane0062ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 관련 Table :  MON VVD, BKG INFO, BKG REV DTL,_BKG_COST_SMRY
	  * 로직 : 년월 VVD는  MON VVD
	  *            기타 정보는  BKG INFO에 검색 조건으로 하여 결정된 BKG _NO를 기준으로
	  *             BKG REV DTL에서 수입을, BKG Cost SMRY에서 비용을 구한다.
	  * 2015.03.25 [CHM-201534153] 김시몬 CM/OP계정 추가 및 변경에 따라 보완
	  * 2015.04.22 [CHM-201534153] 김시몬 Dem/Det CM계정관련 수정
	  * 2015.07.07 김시몬 Dem/Det, MISC CM계정 관련 수정
	  * </pre>
	  */
	public SalesRPTDBDAOsearchInqByLane0062ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_key_acct_group_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_taa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pro_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rev_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOsearchInqByLane0062ListRSQL").append("\n"); 
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
		query.append("SELECT  TRD_CD" ).append("\n"); 
		query.append("#if ( ${f_wk_sts} != '' )" ).append("\n"); 
		query.append("		,COST_YRMON" ).append("\n"); 
		query.append("		,SLS_YRMON" ).append("\n"); 
		query.append("		,COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		,RLANE_CD" ).append("\n"); 
		query.append("		,DIR_CD" ).append("\n"); 
		query.append("	    ,TRD_DIR_CD" ).append("\n"); 
		query.append("#if ( ${f_bkg_disp} != '' )" ).append("\n"); 
		query.append("		,BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		,SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,LOAD" ).append("\n"); 
		query.append("		,BKG_REV                                    AS REV      " ).append("\n"); 
		query.append("		,CM_COST                                    AS CMC      " ).append("\n"); 
		query.append("		,(BKG_REV+DEM_DET+MISC_REV-CM_COST)                 AS CM    " ).append("\n"); 
		query.append("		,DECODE(@[f_pro_lvl],'M', NVL(OWN_FDR_AMT,0), 0)   AS OWN_FDR_AMT      " ).append("\n"); 
		query.append("		,DECODE(@[f_pro_lvl],'M', (BKG_REV+DEM_DET+MISC_REV-CM_COST-NVL(OWN_FDR_AMT,0)), 0) AS CM2         " ).append("\n"); 
		query.append("		,OP_COST                                    AS OPC      " ).append("\n"); 
		query.append("		,(BKG_REV+DEM_DET+MISC_REV-CM_COST-OP_COST)         AS OP       " ).append("\n"); 
		query.append("		,(BKG_REV/LOAD)                             AS G_RPB    " ).append("\n"); 
		query.append("		,CM_COST                           AS CM_COST" ).append("\n"); 
		query.append("		,(CM_COST)/LOAD                    AS CMCOST  " ).append("\n"); 
		query.append("		,(BKG_REV+DEM_DET+MISC_REV-CM_COST)/LOAD            AS CMB      " ).append("\n"); 
		query.append("		,OP_COST                                    AS OP_COST" ).append("\n"); 
		query.append("		,OP_COST/LOAD                               AS OPCOST   " ).append("\n"); 
		query.append("		,(BKG_REV+DEM_DET+MISC_REV-CM_COST-OP_COST)/LOAD   AS OPB      " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT	" ).append("\n"); 
		query.append("			#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("                 /*+ FULL(D) PARALLEL(D) */" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				 D.TRD_CD" ).append("\n"); 
		query.append("				,D.RLANE_CD" ).append("\n"); 
		query.append("#if ( ${f_wk_sts} != '' )" ).append("\n"); 
		query.append("                ,D.COST_YRMON" ).append("\n"); 
		query.append("				,D.SLS_YRMON" ).append("\n"); 
		query.append("				,D.COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_dir_sts} == '' )" ).append("\n"); 
		query.append("				,'' DIR_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				,D.DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_trd_sts} == '' )" ).append("\n"); 
		query.append("				,'' TRD_DIR_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				,MAS_GET_CD_NM_FNC('CD03217', R.HUL_BND_CD) AS TRD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_bkg_disp} != '' )" ).append("\n"); 
		query.append("				,D.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_view_tpsz} == 'box' )" ).append("\n"); 
		query.append("				,D.SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,SUM(NVL(D.BKG_QTY,0)) LOAD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				,'TEU' SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,SUM(DECODE(SUBSTR(D.SPCL_CNTR_TPSZ_CD,-1,1),'2', D.BKG_QTY, '3', D.BKG_QTY, D.BKG_QTY*2)) LOAD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				,SUM(NVL(D.BKG_REV,0)+NVL(D.BKG_OFT_REV,0))      AS BKG_REV" ).append("\n"); 
		query.append("				,SUM(NVL(D.BKG_MISC_REV,0)+NVL(D.SCR_CHG_REV,0)) AS MISC_REV" ).append("\n"); 
		query.append("				,SUM(D.DMDT_COM_AMT) DEM_DET" ).append("\n"); 
		query.append("				,SUM(DECODE(@[f_pro_vw], 'P', NVL(D.PA_CM_COST_TTL_AMT, 0)   , 'R', NVL(D.RA_CM_COST_TTL_AMT, 0))   ) CM_COST" ).append("\n"); 
		query.append("				,SUM(DECODE(@[f_pro_vw], 'P', NVL(A6.PA_OP_COST_TTL_AMT, 0) , 'R', 0)) OP_COST" ).append("\n"); 
		query.append("				,SUM(D.OWN_FDR_AMT) OWN_FDR_AMT" ).append("\n"); 
		query.append("		FROM	" ).append("\n"); 
		query.append("			#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("        		MAS_BKG_EXPN_DTL D" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				MAS_BKG_EXPN_DTL_WK D " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				,MAS_BKG_OP_EXPN_DTL A6" ).append("\n"); 
		query.append("				,MAS_OFC_LVL E" ).append("\n"); 
		query.append("#if(( ${f_key_acct_group_cd} !='' && ${f_key_acct_group_cd} !='All' && ${f_key_acct_indvl_cd} == '' ) || ${f_otr_key_acct} !='')" ).append("\n"); 
		query.append("				, MDM_CUSTOMER F" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${f_soc_sts} != '')" ).append("\n"); 
		query.append("				,MAS_BKG_REV_DTL H" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (  ${f_trd_sts} != '' || ${f_trd_dir_cd} !=''  )" ).append("\n"); 
		query.append("				,MAS_LANE_RGST R" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		WHERE	1=1" ).append("\n"); 
		query.append("#if ( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("		AND		D.COST_YRMON     BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("		AND		D.COST_YRMON     BETWEEN E.OFC_APLY_FM_YRMON AND E.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#elseif ( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("		AND SUBSTR(D.SLS_YRMON, 1, 4)||D.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("		#if ( ${f_sls_mon} != '' )" ).append("\n"); 
		query.append("        	AND		D.SLS_YRMON      = @[f_year]||@[f_sls_mon]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		AND		D.SLS_YRMON      BETWEEN E.OFC_APLY_FM_YRMON AND E.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${f_ofc_vw} =='C')	" ).append("\n"); 
		query.append("		AND D.AGMT_SGN_OFC_CD = E.OFC_CD" ).append("\n"); 
		query.append("	#elseif (${f_ofc_vw} =='L')	" ).append("\n"); 
		query.append("		AND D.SLS_OFC_CD = E.OFC_CD" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND 1 = 0" ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("#if(( ${f_key_acct_group_cd} !='' && ${f_key_acct_group_cd} !='All' && ${f_key_acct_indvl_cd} == '' ) || ${f_otr_key_acct} !='')" ).append("\n"); 
		query.append("		AND		D.AGMT_CNT_CD		= F.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND		D.AGMT_CUST_SEQ		= F.CUST_SEQ" ).append("\n"); 
		query.append("		AND		F.NEW_KEY_ACCT_FLG	= 'Y'" ).append("\n"); 
		query.append("		AND		F.CNTR_DIV_FLG		= 'Y'" ).append("\n"); 
		query.append("		AND		F.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${f_soc_sts} == 'Y')" ).append("\n"); 
		query.append("		AND		D.BKG_NO			= H.BKG_NO" ).append("\n"); 
		query.append("		AND		D.CNTR_TPSZ_CD		= H.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		AND		D.COST_ROUT_NO		= H.COST_ROUT_NO" ).append("\n"); 
		query.append("		AND		NVL(H.SOC_FLG,'N')	= 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_trd_sts} != '' || ${f_trd_dir_cd} !='' )" ).append("\n"); 
		query.append("	    AND D.RLANE_CD            = R.RLANE_CD" ).append("\n"); 
		query.append("        AND D.DIR_CD              = R.DIR_CD" ).append("\n"); 
		query.append("        AND D.IOC_CD              = R.IOC_CD" ).append("\n"); 
		query.append("        AND D.TRD_CD              = R.TRD_CD" ).append("\n"); 
		query.append("        AND R.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_trd_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_rlane_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_skd_dir_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.DIR_CD     = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_vsl_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.VSL_CD     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_skd_voy_no} != '' )" ).append("\n"); 
		query.append("		AND		D.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_dir_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_bkg_por_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.BKG_POR_CD = @[f_bkg_por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_rev_pol_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.REV_POL_CD = @[f_rev_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_rev_pod_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.REV_POD_CD = @[f_rev_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_bkg_del_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.BKG_DEL_CD = @[f_bkg_del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_shpr} != '' )" ).append("\n"); 
		query.append("		AND		D.SHPR_CNT_CD || D.SHPR_CUST_SEQ    = @[f_shpr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_sc_no} != '' )" ).append("\n"); 
		query.append("		AND		D.SC_NO      = @[f_sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_rfa_no} != '' )" ).append("\n"); 
		query.append("		AND		D.RFA_NO     = @[f_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_taa_no} != '' )" ).append("\n"); 
		query.append("		AND		D.TAA_NO     = @[f_taa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_key_acct_indvl_cd} !='' )" ).append("\n"); 
		query.append("	#if ( ${f_key_acct_indvl_cd} !='All')" ).append("\n"); 
		query.append("		AND		D.AGMT_CNT_CD      = SUBSTR(@[f_key_acct_indvl_cd],1,2)" ).append("\n"); 
		query.append("		AND		D.AGMT_CUST_SEQ   	 = TO_NUMBER ( SUBSTR(@[f_key_acct_indvl_cd],3) )" ).append("\n"); 
		query.append("		AND		D.CUST_KEY_AGMT_MGR_FLG	 = 'Y'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_key_acct_group_cd} !='' )" ).append("\n"); 
		query.append("	#if ( ${f_key_acct_group_cd} !='All')" ).append("\n"); 
		query.append("		#if ( ${f_key_acct_indvl_cd} == '' )" ).append("\n"); 
		query.append("		AND		F.CUST_GRP_ID = @[f_key_acct_group_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_cmdt_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.REP_CMDT_CD    = @[f_cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_usa_bkg_mod_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.USA_BKG_MOD_CD = @[f_usa_bkg_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.SPCL_CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_bkg_no} != '' )" ).append("\n"); 
		query.append("		AND		D.BKG_NO         = @[f_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  		AND		NVL(D.DELT_FLG, 'N')       = 'N'" ).append("\n"); 
		query.append("		AND		D.BL_NO_TP       IN ('M','0')" ).append("\n"); 
		query.append("#if ( ${f_bkg_sts} == 'Y' )" ).append("\n"); 
		query.append("		AND		D.BKG_STS_CD    IN ('F','S','W')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		AND		D.BKG_STS_CD     IN ('F','S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND		D.BKG_CGO_TP_CD  <> 'P'" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${f_sls_ofc_cd} != '' )" ).append("\n"); 
		query.append("	#if ( ${f_excl_sub} == '' )" ).append("\n"); 
		query.append("		AND		DECODE(@[f_rhq_cd], '1', E.OFC_N1ST_LVL_CD, '2', E.OFC_N2ND_LVL_CD, '3', E.OFC_N3RD_LVL_CD, '4', E.OFC_N4TH_LVL_CD, '5', E.OFC_N5TH_LVL_CD, '6', E.OFC_N6TH_LVL_CD, '7', E.OFC_N7TH_LVL_CD) = @[f_sls_ofc_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND		E.OFC_CD = @[f_sls_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${f_rhq_cd}=='6' || ${f_rhq_cd}=='7')" ).append("\n"); 
		query.append("    	AND E.OFC_LVL = @[f_rhq_cd]" ).append("\n"); 
		query.append("  	#else" ).append("\n"); 
		query.append("    	AND E.OFC_LVL < '9'" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("#if ( ${f_trd_dir_cd} !='' )" ).append("\n"); 
		query.append("		AND R.HUL_BND_CD = @[f_trd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND D.BKG_NO         = A6.BKG_NO(+)" ).append("\n"); 
		query.append("        AND D.CNTR_TPSZ_CD   = A6.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("        AND D.COST_ROUT_NO   = A6.COST_ROUT_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		GROUP	BY	D.TRD_CD, D.RLANE_CD" ).append("\n"); 
		query.append("#if ( ${f_wk_sts} != '' )" ).append("\n"); 
		query.append("					,D.COST_YRMON, D.SLS_YRMON, D.COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_dir_sts} != '' )" ).append("\n"); 
		query.append("					,D.DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_bkg_disp} != '' )" ).append("\n"); 
		query.append("					,D.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_trd_sts} != '' )" ).append("\n"); 
		query.append("				,MAS_GET_CD_NM_FNC('CD03217', R.HUL_BND_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_view_tpsz} == 'box' )" ).append("\n"); 
		query.append("					,D.SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("ORDER	BY	TRD_CD, RLANE_CD, DIR_CD" ).append("\n"); 
		query.append("#if ( ${f_wk_sts} != '' )" ).append("\n"); 
		query.append("			,COST_YRMON, SLS_YRMON, COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
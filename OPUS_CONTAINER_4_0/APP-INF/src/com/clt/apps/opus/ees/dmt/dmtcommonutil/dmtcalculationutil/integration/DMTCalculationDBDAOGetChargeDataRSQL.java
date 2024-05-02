/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DMTCalculationDBDAOGetChargeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetChargeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getChargeData
	  * </pre>
	  */
	public DMTCalculationDBDAOGetChargeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetChargeDataRSQL").append("\n"); 
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
		query.append("SELECT C.DMDT_TRF_APLY_TP_CD	z_dc_appl_rate" ).append("\n"); 
		query.append("      ,C.BZC_TRF_CURR_CD		z_cur_cd" ).append("\n"); 
		query.append("      ,C.OFC_CD					z_ofc_cd" ).append("\n"); 
		query.append("      ,C.OFC_RHQ_CD				z_ofc_rhq" ).append("\n"); 
		query.append("      ,C.BZC_TRF_SEQ			z_dtn_seq" ).append("\n"); 
		query.append("      ,C.BZC_TRF_GRP_SEQ		z_dtg_grp_id" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,C.RFA_EXPT_APRO_NO		z_rfa_appr_no" ).append("\n"); 
		query.append("      ,C.RFA_EXPT_DAR_NO		z_rfa_dar_no" ).append("\n"); 
		query.append("      ,C.RFA_EXPT_MAPG_SEQ		z_rfa_mapg_seq" ).append("\n"); 
		query.append("      ,C.RFA_EXPT_VER_SEQ		z_rfa_ver_seq" ).append("\n"); 
		query.append("      ,C.RFA_RQST_DTL_SEQ		z_rfa_dtl_seq" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,C.SC_NO					z_sc_no" ).append("\n"); 
		query.append("      ,C.SC_EXPT_VER_SEQ		z_sc_ver_seq" ).append("\n"); 
		query.append("      ,C.SC_EXPT_GRP_SEQ		z_sc_grp_seq" ).append("\n"); 
		query.append("	  ,TO_CHAR(C.SC_RFA_EXPT_APLY_DT,'YYYYMMDD') z_sc_rfa_expt_aply_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,SUBSTR (C.DMDT_TRF_CD, 3, 1)	z_dbc_io_bnd" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,B.CNTR_TPSZ_CD		z_cntrts_cd" ).append("\n"); 
		query.append("      ,B.VSL_CD				z_vsl_cd" ).append("\n"); 
		query.append("      ,B.SKD_VOY_NO			z_skd_voyage_no" ).append("\n"); 
		query.append("      ,B.SKD_DIR_CD			z_skd_dir_cd" ).append("\n"); 
		query.append("      ,B.POL_CD				z_pol_loc" ).append("\n"); 
		query.append("      ,B.POD_CD				z_pod_loc" ).append("\n"); 
		query.append("      ,B.POR_CD				z_por_loc" ).append("\n"); 
		query.append("      ,B.DEL_CD				z_del_loc" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,K.PST_RLY_PORT_CD	z_post_rly" ).append("\n"); 
		query.append("      ,K.PRE_RLY_PORT_CD	z_pre_rly" ).append("\n"); 
		query.append("      ,F.CURR_CD			z_rfa_cur_cd" ).append("\n"); 
		query.append("      ,(SELECT  S.CURR_CD FROM PRI_SP_HDR         P, DMT_SC_EXPT_GRP      S" ).append("\n"); 
		query.append("        WHERE   P.PROP_NO   = S.PROP_NO" ).append("\n"); 
		query.append("        AND     C.SC_NO     = P.SC_NO" ).append("\n"); 
		query.append("        AND     C.SC_EXPT_VER_SEQ        =    S.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        AND     C.SC_EXPT_GRP_SEQ        =    S.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("        )   z_sc_cur_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  ,TO_CHAR(C.BZC_TRF_APLY_DT,'YYYYMMDD')	bzc_trf_aply_dt" ).append("\n"); 
		query.append("      ,B.BKG_NO             z_bkg_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  ,NVL (C.OFC_TRNS_RHQ_CNG_FLG, 'N') Z_DCC_TRS_IND" ).append("\n"); 
		query.append("FROM   DMT_CHG_CALC         C" ).append("\n"); 
		query.append("      ,DMT_CHG_BKG_CNTR     B" ).append("\n"); 
		query.append("      ,BKG_BOOKING          K" ).append("\n"); 
		query.append("      ,DMT_RFA_EXPT_TRF_DTL F" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("    WHERE      C.CNTR_NO                =    @[cntr_no]" ).append("\n"); 
		query.append("    AND        C.CNTR_CYC_NO            =    @[cntr_cyc_no]" ).append("\n"); 
		query.append("    AND        C.DMDT_TRF_CD            =    @[dmdt_trf_cd]" ).append("\n"); 
		query.append("    AND        C.DMDT_CHG_LOC_DIV_CD    =    @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("    AND        C.CHG_SEQ                =    1" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND        C.SYS_AREA_GRP_ID        =    B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    AND        C.CNTR_NO                =    B.CNTR_NO" ).append("\n"); 
		query.append("    AND        C.CNTR_CYC_NO            =    B.CNTR_CYC_NO " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND        B.BKG_NO                 =    K.BKG_NO" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    AND        C.RFA_EXPT_DAR_NO        =    F.RFA_EXPT_DAR_NO        (+)" ).append("\n"); 
		query.append("    AND        C.RFA_EXPT_MAPG_SEQ      =    F.RFA_EXPT_MAPG_SEQ      (+)" ).append("\n"); 
		query.append("    AND        C.RFA_EXPT_VER_SEQ       =    F.RFA_EXPT_VER_SEQ       (+)" ).append("\n"); 
		query.append("    AND        C.RFA_RQST_DTL_SEQ       =    F.RFA_RQST_DTL_SEQ       (+)" ).append("\n"); 

	}
}
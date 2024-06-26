/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeByOfficeTransferCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.23
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.23 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOChargeByOfficeTransferCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeByOfficeTransferCSQL(){
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
		params.put("to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_svr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOChargeByOfficeTransferCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_CHG_CALC" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_CYC_NO" ).append("\n"); 
		query.append(",DMDT_TRF_CD" ).append("\n"); 
		query.append(",DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",CHG_SEQ" ).append("\n"); 
		query.append(",FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",FM_MVMT_DT" ).append("\n"); 
		query.append(",FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",TO_MVMT_DT" ).append("\n"); 
		query.append(",TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",NOT_CRE_BAL_FLG" ).append("\n"); 
		query.append(",MVMT_UMCH_SEQ" ).append("\n"); 
		query.append(",FM_MVMT_YR" ).append("\n"); 
		query.append(",FM_MVMT_SEQ" ).append("\n"); 
		query.append(",FM_MVMT_SPLIT_NO" ).append("\n"); 
		query.append(",TO_MVMT_YR" ).append("\n"); 
		query.append(",TO_MVMT_SEQ" ).append("\n"); 
		query.append(",TO_MVMT_SPLIT_NO" ).append("\n"); 
		query.append(",FT_DYS" ).append("\n"); 
		query.append(",FT_CMNC_DT" ).append("\n"); 
		query.append(",FT_END_DT" ).append("\n"); 
		query.append(",FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",ORG_FT_OVR_DYS" ).append("\n"); 
		query.append(",SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append(",AFT_EXPT_OVR_DYS" ).append("\n"); 
		query.append(",BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",ORG_CHG_AMT" ).append("\n"); 
		query.append(",SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append(",AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",BIL_AMT" ).append("\n"); 
		query.append(",DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append(",DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",DMDT_PRE_CHG_STS_CD" ).append("\n"); 
		query.append(",DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append(",SC_RFA_AMT" ).append("\n"); 
		query.append(",AFT_EXPT_AMT" ).append("\n"); 
		query.append(",BZC_TRF_SEQ" ).append("\n"); 
		query.append(",BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",BZC_TRF_APLY_DT" ).append("\n"); 
		query.append(",RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append(",AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append(",AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append(",SC_NO" ).append("\n"); 
		query.append(",SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",OFC_RHQ_CD" ).append("\n"); 
		query.append(",OFC_TRNS_SEQ" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",ACT_CNT_CD" ).append("\n"); 
		query.append(",ACT_CUST_SEQ" ).append("\n"); 
		query.append(",CORR_RMK" ).append("\n"); 
		query.append(",DMDT_INV_NO" ).append("\n"); 
		query.append(",CALC_DT" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append(",CFM_USR_ID" ).append("\n"); 
		query.append(",CFM_OFC_CD" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",CMDT_TRF_SEQ" ).append("\n"); 
		query.append(",CMDT_EXPT_APLY_DT" ).append("\n"); 
		query.append(",CMDT_OVR_DYS" ).append("\n"); 
		query.append(",CMDT_EXPT_AMT" ).append("\n"); 
		query.append(",OFC_TRNS_FLG" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",WEB_IND_FLG" ).append("\n"); 
		query.append(",WEB_CRE_USR_ID" ).append("\n"); 
		query.append(",WEB_CRE_DT" ).append("\n"); 
		query.append(",WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append(",WEB_NTFY_PIC_TELCM_NO" ).append("\n"); 
		query.append(",WEB_MTY_DT" ).append("\n"); 
		query.append(",OFC_TRNS_RHQ_CNG_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("(	SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	WHERE CNT_CD = (SELECT TRIM(SUBSTR(LOC_CD, 1, 2))" ).append("\n"); 
		query.append("                	FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                	WHERE OFC_CD = @[to_ofc_cd]) " ).append("\n"); 
		query.append("	AND CO_IND_CD = 'H'	)" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_CYC_NO" ).append("\n"); 
		query.append(",DMDT_TRF_CD" ).append("\n"); 
		query.append(",DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",CHG_SEQ" ).append("\n"); 
		query.append(",FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",FM_MVMT_DT" ).append("\n"); 
		query.append(",FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",TO_MVMT_DT" ).append("\n"); 
		query.append(",TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",NOT_CRE_BAL_FLG" ).append("\n"); 
		query.append(",MVMT_UMCH_SEQ" ).append("\n"); 
		query.append(",FM_MVMT_YR" ).append("\n"); 
		query.append(",FM_MVMT_SEQ" ).append("\n"); 
		query.append(",FM_MVMT_SPLIT_NO" ).append("\n"); 
		query.append(",TO_MVMT_YR" ).append("\n"); 
		query.append(",TO_MVMT_SEQ" ).append("\n"); 
		query.append(",TO_MVMT_SPLIT_NO" ).append("\n"); 
		query.append(",FT_DYS" ).append("\n"); 
		query.append(",FT_CMNC_DT" ).append("\n"); 
		query.append(",FT_END_DT" ).append("\n"); 
		query.append(",FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",ORG_FT_OVR_DYS" ).append("\n"); 
		query.append(",SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append(",AFT_EXPT_OVR_DYS" ).append("\n"); 
		query.append(",BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",ORG_CHG_AMT" ).append("\n"); 
		query.append(",SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append(",AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",BIL_AMT" ).append("\n"); 
		query.append(",DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append(",DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",DMDT_PRE_CHG_STS_CD" ).append("\n"); 
		query.append(",DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append(",SC_RFA_AMT" ).append("\n"); 
		query.append(",AFT_EXPT_AMT" ).append("\n"); 
		query.append(",BZC_TRF_SEQ" ).append("\n"); 
		query.append(",BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",BZC_TRF_APLY_DT" ).append("\n"); 
		query.append(",RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append(",AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append(",AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append(",SC_NO" ).append("\n"); 
		query.append(",SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append(",@[to_ofc_cd]" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT	OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("	FROM	DMT_OFC_LVL_V" ).append("\n"); 
		query.append("	WHERE	OFC_N8TH_LVL_CD	= @[to_ofc_cd]" ).append("\n"); 
		query.append(") --OFC_RHQ_CD" ).append("\n"); 
		query.append(",OFC_TRNS_SEQ" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",ACT_CNT_CD" ).append("\n"); 
		query.append(",ACT_CUST_SEQ" ).append("\n"); 
		query.append(",CORR_RMK" ).append("\n"); 
		query.append(",DMDT_INV_NO" ).append("\n"); 
		query.append(",CALC_DT" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append(",CFM_USR_ID" ).append("\n"); 
		query.append(",CFM_OFC_CD" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",CMDT_TRF_SEQ" ).append("\n"); 
		query.append(",CMDT_EXPT_APLY_DT" ).append("\n"); 
		query.append(",CMDT_OVR_DYS" ).append("\n"); 
		query.append(",CMDT_EXPT_AMT" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",WEB_IND_FLG" ).append("\n"); 
		query.append(",WEB_CRE_USR_ID" ).append("\n"); 
		query.append(",WEB_CRE_DT" ).append("\n"); 
		query.append(",WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append(",WEB_NTFY_PIC_TELCM_NO" ).append("\n"); 
		query.append(",WEB_MTY_DT" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_CHG_CALC" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID	= @[fm_svr_id]" ).append("\n"); 
		query.append("AND		CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND		CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		CHG_SEQ			= @[chg_seq]" ).append("\n"); 

	}
}
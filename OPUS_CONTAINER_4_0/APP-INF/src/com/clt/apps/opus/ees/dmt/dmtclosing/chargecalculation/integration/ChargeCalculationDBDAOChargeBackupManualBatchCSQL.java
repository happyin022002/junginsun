/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeBackupManualBatchCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOChargeBackupManualBatchCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOChargeBackupManualBatchCSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeBackupManualBatchCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("batch_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOChargeBackupManualBatchCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_CHG_CALC_BKUP" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("	,CNTR_CYC_NO" ).append("\n"); 
		query.append("	,CHG_BKG_CNTR_BKUP_SEQ" ).append("\n"); 
		query.append("	,DMDT_TRF_CD" ).append("\n"); 
		query.append("	,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	,CHG_SEQ" ).append("\n"); 
		query.append("	,CHG_CALC_BKUP_SEQ" ).append("\n"); 
		query.append("	,FM_MVMT_STS_CD" ).append("\n"); 
		query.append("	,FM_MVMT_DT" ).append("\n"); 
		query.append("	,FM_MVMT_YD_CD" ).append("\n"); 
		query.append("	,TO_MVMT_STS_CD" ).append("\n"); 
		query.append("	,TO_MVMT_DT" ).append("\n"); 
		query.append("	,TO_MVMT_YD_CD" ).append("\n"); 
		query.append("	,NOT_CRE_BAL_FLG" ).append("\n"); 
		query.append("	,MVMT_UMCH_SEQ" ).append("\n"); 
		query.append("	,FM_MVMT_YR" ).append("\n"); 
		query.append("	,FM_MVMT_SEQ" ).append("\n"); 
		query.append("	,FM_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("	,TO_MVMT_YR" ).append("\n"); 
		query.append("	,TO_MVMT_SEQ" ).append("\n"); 
		query.append("	,TO_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("	,FT_DYS" ).append("\n"); 
		query.append("	,FT_CMNC_DT" ).append("\n"); 
		query.append("	,FT_END_DT" ).append("\n"); 
		query.append("	,FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	,ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("	,SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append("	,AFT_EXPT_OVR_DYS" ).append("\n"); 
		query.append("	,BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	,DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("	,ORG_CHG_AMT" ).append("\n"); 
		query.append("	,SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("	,AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	,BIL_AMT" ).append("\n"); 
		query.append("	,DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("	,DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("	,DMDT_PRE_CHG_STS_CD" ).append("\n"); 
		query.append("	,DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append("	,SC_RFA_AMT" ).append("\n"); 
		query.append("	,AFT_EXPT_AMT" ).append("\n"); 
		query.append("	,BZC_TRF_SEQ" ).append("\n"); 
		query.append("	,BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("	,BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("	,RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append("	,RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	,RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	,AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append("	,AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("	,SC_NO" ).append("\n"); 
		query.append("	,SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	,SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("	,OFC_CD" ).append("\n"); 
		query.append("	,OFC_RHQ_CD" ).append("\n"); 
		query.append("	,OFC_TRNS_SEQ" ).append("\n"); 
		query.append("	,CUST_CNT_CD" ).append("\n"); 
		query.append("	,CUST_SEQ" ).append("\n"); 
		query.append("	,ACT_CNT_CD" ).append("\n"); 
		query.append("	,ACT_CUST_SEQ" ).append("\n"); 
		query.append("	,CORR_RMK" ).append("\n"); 
		query.append("	,DMDT_INV_NO" ).append("\n"); 
		query.append("	,CALC_DT" ).append("\n"); 
		query.append("	,CFM_DT" ).append("\n"); 
		query.append("	,CFM_USR_ID" ).append("\n"); 
		query.append("	,CFM_OFC_CD" ).append("\n"); 
		query.append("	,CMDT_CD" ).append("\n"); 
		query.append("	,CMDT_TRF_SEQ" ).append("\n"); 
		query.append("	,CMDT_EXPT_APLY_DT" ).append("\n"); 
		query.append("	,CMDT_OVR_DYS" ).append("\n"); 
		query.append("	,CMDT_EXPT_AMT" ).append("\n"); 
		query.append("	,OFC_TRNS_FLG" ).append("\n"); 
		query.append("	,VNDR_SEQ" ).append("\n"); 
		query.append("	,WEB_IND_FLG" ).append("\n"); 
		query.append("	,WEB_CRE_USR_ID" ).append("\n"); 
		query.append("	,WEB_CRE_DT" ).append("\n"); 
		query.append("	,WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append("	,WEB_NTFY_PIC_TELCM_NO" ).append("\n"); 
		query.append("	,WEB_MTY_DT" ).append("\n"); 
		query.append("	,OFC_TRNS_RHQ_CNG_FLG" ).append("\n"); 
		query.append("	--,DMDT_OFC_TRNS_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	,DELT_USR_ID" ).append("\n"); 
		query.append("	,DELT_DT" ).append("\n"); 
		query.append("	,DELT_OFC_CD" ).append("\n"); 
		query.append("	,DELT_RMK" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,CRE_OFC_CD" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,UPD_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("	,CNTR_CYC_NO" ).append("\n"); 
		query.append("	,(	SELECT	NVL(MAX(CHG_BKG_CNTR_BKUP_SEQ), 1)" ).append("\n"); 
		query.append("		FROM	DMT_CHG_BKG_CNTR_BKUP" ).append("\n"); 
		query.append("		WHERE	SYS_AREA_GRP_ID	= A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		AND		CNTR_NO			= A.CNTR_NO" ).append("\n"); 
		query.append("		AND		CNTR_CYC_NO		= A.CNTR_CYC_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	,DMDT_TRF_CD" ).append("\n"); 
		query.append("	,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	,CHG_SEQ" ).append("\n"); 
		query.append("	,CHG_CALC_BKUP_SEQ.NEXTVAL" ).append("\n"); 
		query.append("	,FM_MVMT_STS_CD" ).append("\n"); 
		query.append("	,FM_MVMT_DT" ).append("\n"); 
		query.append("	,FM_MVMT_YD_CD" ).append("\n"); 
		query.append("	,TO_MVMT_STS_CD" ).append("\n"); 
		query.append("	,TO_MVMT_DT" ).append("\n"); 
		query.append("	,TO_MVMT_YD_CD" ).append("\n"); 
		query.append("	,NOT_CRE_BAL_FLG" ).append("\n"); 
		query.append("	,MVMT_UMCH_SEQ" ).append("\n"); 
		query.append("	,FM_MVMT_YR" ).append("\n"); 
		query.append("	,FM_MVMT_SEQ" ).append("\n"); 
		query.append("	,FM_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("	,TO_MVMT_YR" ).append("\n"); 
		query.append("	,TO_MVMT_SEQ" ).append("\n"); 
		query.append("	,TO_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("	,FT_DYS" ).append("\n"); 
		query.append("	,FT_CMNC_DT" ).append("\n"); 
		query.append("	,FT_END_DT" ).append("\n"); 
		query.append("	,FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	,ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("	,SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append("	,AFT_EXPT_OVR_DYS" ).append("\n"); 
		query.append("	,BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	,DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("	,ORG_CHG_AMT" ).append("\n"); 
		query.append("	,SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("	,AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	,BIL_AMT" ).append("\n"); 
		query.append("	,DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("	,DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("	,DMDT_PRE_CHG_STS_CD" ).append("\n"); 
		query.append("	,DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append("	,SC_RFA_AMT" ).append("\n"); 
		query.append("	,AFT_EXPT_AMT" ).append("\n"); 
		query.append("	,BZC_TRF_SEQ" ).append("\n"); 
		query.append("	,BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("	,BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("	,RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append("	,RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	,RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	,AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append("	,AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("	,SC_NO" ).append("\n"); 
		query.append("	,SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	,SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("	,OFC_CD" ).append("\n"); 
		query.append("	,OFC_RHQ_CD" ).append("\n"); 
		query.append("	,OFC_TRNS_SEQ" ).append("\n"); 
		query.append("	,CUST_CNT_CD" ).append("\n"); 
		query.append("	,CUST_SEQ" ).append("\n"); 
		query.append("	,ACT_CNT_CD" ).append("\n"); 
		query.append("	,ACT_CUST_SEQ" ).append("\n"); 
		query.append("	,CORR_RMK" ).append("\n"); 
		query.append("	,DMDT_INV_NO" ).append("\n"); 
		query.append("	,CALC_DT" ).append("\n"); 
		query.append("	,CFM_DT" ).append("\n"); 
		query.append("	,CFM_USR_ID" ).append("\n"); 
		query.append("	,CFM_OFC_CD" ).append("\n"); 
		query.append("	,CMDT_CD" ).append("\n"); 
		query.append("	,CMDT_TRF_SEQ" ).append("\n"); 
		query.append("	,CMDT_EXPT_APLY_DT" ).append("\n"); 
		query.append("	,CMDT_OVR_DYS" ).append("\n"); 
		query.append("	,CMDT_EXPT_AMT" ).append("\n"); 
		query.append("	,OFC_TRNS_FLG" ).append("\n"); 
		query.append("	,VNDR_SEQ" ).append("\n"); 
		query.append("	,WEB_IND_FLG" ).append("\n"); 
		query.append("	,WEB_CRE_USR_ID" ).append("\n"); 
		query.append("	,WEB_CRE_DT" ).append("\n"); 
		query.append("	,WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append("	,WEB_NTFY_PIC_TELCM_NO" ).append("\n"); 
		query.append("	,WEB_MTY_DT" ).append("\n"); 
		query.append("	,OFC_TRNS_RHQ_CNG_FLG" ).append("\n"); 
		query.append("	--,DMDT_OFC_TRNS_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	,@[delt_usr_id]" ).append("\n"); 
		query.append("	,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[delt_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("	,@[delt_ofc_cd]" ).append("\n"); 
		query.append("	,NULL" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,CRE_OFC_CD" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,UPD_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC A" ).append("\n"); 
		query.append("WHERE ROWID" ).append("\n"); 
		query.append("	IN" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT B.ROWID" ).append("\n"); 
		query.append("	FROM DMT_CHG_BKG_CNTR A, DMT_CHG_CALC B" ).append("\n"); 
		query.append("	WHERE A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	  AND A.CNTR_NO         = B.CNTR_NO" ).append("\n"); 
		query.append("	  AND A.CNTR_CYC_NO     = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("	  AND A.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("      AND B.DMDT_TRF_CD     = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("      AND B.DMDT_CHG_STS_CD IN ( 'C','F','N','L','U','E' )" ).append("\n"); 
		query.append("#if (${batch_cntr} != '')" ).append("\n"); 
		query.append("	  AND A.CNTR_NO = @[batch_cntr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 )" ).append("\n"); 

	}
}
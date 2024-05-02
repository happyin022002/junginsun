/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : USDemurrageAuditDBDAOChargeForAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDemurrageAuditDBDAOChargeForAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeForAudit
	  * </pre>
	  */
	public USDemurrageAuditDBDAOChargeForAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.integration").append("\n"); 
		query.append("FileName : USDemurrageAuditDBDAOChargeForAuditRSQL").append("\n"); 
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
		query.append("SELECT   X.CNTR_NO" ).append("\n"); 
		query.append(",X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",X.CAL_FROM_DT" ).append("\n"); 
		query.append(",X.CAL_TO_DT" ).append("\n"); 
		query.append(",X.CAL_FT_END" ).append("\n"); 
		query.append(",X.CAL_OVER" ).append("\n"); 
		query.append(",X.CURR_CD" ).append("\n"); 
		query.append(",X.CAL_COLLECTION" ).append("\n"); 
		query.append(",X.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",X.FT_CMNC_DT" ).append("\n"); 
		query.append(",X.FT_DYS" ).append("\n"); 
		query.append(",X.SC_NO" ).append("\n"); 
		query.append(",X.RFA_NO" ).append("\n"); 
		query.append(",X.EXCEPTION_AMT" ).append("\n"); 
		query.append(",X.AFT_EXPT_AMT" ).append("\n"); 
		query.append(",X.VVD" ).append("\n"); 
		query.append(",X.BKG_NO" ).append("\n"); 
		query.append(",X.BL_NO" ).append("\n"); 
		query.append(",X.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",X.SVR_ID" ).append("\n"); 
		query.append(",X.CNTR_CYC_NO" ).append("\n"); 
		query.append(",X.DMDT_TRF_CD" ).append("\n"); 
		query.append(",X.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",X.CHG_SEQ" ).append("\n"); 
		query.append(",X.OFC_CD" ).append("\n"); 
		query.append(",NVL(( SELECT MAX(NVL(R.DMDT_DELT_RQST_STS_CD,'N')) FROM DMT_CHG_DELT_RQST_APRO R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.CNTR_NO 		= R.CNTR_NO" ).append("\n"); 
		query.append("AND X.CNTR_CYC_NO 	= R.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND X.SVR_ID = R.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND X.DMDT_TRF_CD = R.DMDT_TRF_CD" ).append("\n"); 
		query.append("),'N')  AS DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("FROM (SELECT C.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",TO_CHAR(C.FM_MVMT_DT,'YYYY-MM-DD') AS CAL_FROM_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.TO_MVMT_DT,'YYYY-MM-DD') AS CAL_TO_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.FT_END_DT,'YYYY-MM-DD') AS CAL_FT_END" ).append("\n"); 
		query.append(",C.FX_FT_OVR_DYS AS CAL_OVER" ).append("\n"); 
		query.append(",C.BZC_TRF_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append(",C.BIL_AMT AS CAL_COLLECTION" ).append("\n"); 
		query.append(",C.FM_MVMT_YD_CD AS FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(C.FT_CMNC_DT,'YYYY-MM-DD') AS FT_CMNC_DT" ).append("\n"); 
		query.append(",C.FT_DYS AS FT_DYS" ).append("\n"); 
		query.append(",B.SC_NO AS SC_NO" ).append("\n"); 
		query.append(",B.RFA_NO AS RFA_NO" ).append("\n"); 
		query.append(",NVL(C.SC_RFA_EXPT_AMT + C.CMDT_EXPT_AMT, 0) AS EXCEPTION_AMT" ).append("\n"); 
		query.append(",NVL(C.AFT_EXPT_DC_AMT, 0) AS AFT_EXPT_AMT" ).append("\n"); 
		query.append(",B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",B.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append(",B.BL_NO AS BL_NO" ).append("\n"); 
		query.append(",C.DMDT_CHG_STS_CD AS DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",C.CNTR_CYC_NO AS CNTR_CYC_NO" ).append("\n"); 
		query.append(",C.DMDT_TRF_CD AS DMDT_TRF_CD" ).append("\n"); 
		query.append(",C.DMDT_CHG_LOC_DIV_CD AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",C.CHG_SEQ AS CHG_SEQ" ).append("\n"); 
		query.append(",C.OFC_CD" ).append("\n"); 
		query.append(",ROW_NUMBER () OVER (PARTITION BY C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD, C.DMDT_CHG_LOC_DIV_CD ORDER BY C.CHG_SEQ ASC)" ).append("\n"); 
		query.append("AS RNK" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC C" ).append("\n"); 
		query.append(",DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("WHERE C.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND C.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND C.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("( (C.DMDT_TRF_CD = 'DMIF' AND C.DMDT_CHG_LOC_DIV_CD = 'POD')" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(C.DMDT_TRF_CD = 'DMIF' AND C.DMDT_CHG_LOC_DIV_CD <> 'DEL')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR ( (C.DMDT_TRF_CD = 'DMOF' AND C.DMDT_CHG_LOC_DIV_CD = 'POL')" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(C.DMDT_TRF_CD = 'DMOF' AND C.DMDT_CHG_LOC_DIV_CD <> 'POR')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR ( (C.DMDT_TRF_CD = 'DTOC' OR  C.DMDT_TRF_CD = 'CTOC')" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = 'POR'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR ( (C.DMDT_TRF_CD = 'DTIC' OR  C.DMDT_TRF_CD = 'CTIC')" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = 'DEL'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND C.OFC_CD = @[p_ofc_cd]" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = @[p_dmdt_trf_cd]" ).append("\n"); 
		query.append("AND B.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#if (${p_fm_mvmt_yd_cd} != '')" ).append("\n"); 
		query.append("AND C.FM_MVMT_YD_CD LIKE @[p_fm_mvmt_yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_load_opt_input} == '1')" ).append("\n"); 
		query.append("AND B.VSL_CD" ).append("\n"); 
		query.append("|| B.SKD_VOY_NO" ).append("\n"); 
		query.append("|| B.SKD_DIR_CD = @[vvd]             -- VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${p_load_opt_input} == '2')" ).append("\n"); 
		query.append("AND B.BL_NO = @[bl_no]              		-- BL NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${p_load_opt_input} == '3')" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]           		-- BKG NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE RNK < 2" ).append("\n"); 

	}
}
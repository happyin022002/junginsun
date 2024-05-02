/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOAddBeforeExceptionTariffByCVRGCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOAddBeforeExceptionTariffByCVRGCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Coverage 정보가 추가될 경우 Coverage Sequence 필드추가 인해서 중복된 Before Booking Request 정보를 입력해준다.
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOAddBeforeExceptionTariffByCVRGCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_rqst_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOAddBeforeExceptionTariffByCVRGCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_RFA_EXPT_TRF_DTL(" ).append("\n"); 
		query.append("		RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	,	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	,	CVRG_CMB_SEQ" ).append("\n"); 
		query.append("	,	DMDT_TRF_CD" ).append("\n"); 
		query.append("	,	N1ST_CMNC_VER_SEQ" ).append("\n"); 
		query.append("	,	EFF_DT" ).append("\n"); 
		query.append("	,	EXP_DT" ).append("\n"); 
		query.append("	,	DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("	,	DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("	,	REP_CMDT_CD" ).append("\n"); 
		query.append("	,	FT_USE_FLG" ).append("\n"); 
		query.append("	,	ADD_DYS" ).append("\n"); 
		query.append("	,	TTL_DYS" ).append("\n"); 
		query.append("	,	XCLD_SAT_FLG" ).append("\n"); 
		query.append("	,	XCLD_SUN_FLG" ).append("\n"); 
		query.append("	,	XCLD_HOL_FLG" ).append("\n"); 
		query.append("	,	RT_USE_FLG" ).append("\n"); 
		query.append("	,	RT_CHK_FLG" ).append("\n"); 
		query.append("	,	CURR_CD" ).append("\n"); 
		query.append("	,	EXPT_TRF_RMK" ).append("\n"); 
		query.append("	,	ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("	,	ACT_CUST_SEQ" ).append("\n"); 
		query.append("	,	FNL_DEST_FLG" ).append("\n"); 
		query.append("	,	FNL_DEST_CONTI_CD" ).append("\n"); 
		query.append("	,	FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("	,	FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("	,	FNL_DEST_STE_CD" ).append("\n"); 
		query.append("	,	FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("	,	CRE_USR_ID" ).append("\n"); 
		query.append("	,	CRE_DT" ).append("\n"); 
		query.append("	,	CRE_OFC_CD" ).append("\n"); 
		query.append("	,	UPD_USR_ID" ).append("\n"); 
		query.append("	,	UPD_DT" ).append("\n"); 
		query.append("	,	UPD_OFC_CD" ).append("\n"); 
		query.append("    ,   CMDT_FLG" ).append("\n"); 
		query.append("    ,   FT_ADJ_FLG" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("SELECT	RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	,	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	,	@[cvrg_cmb_seq]" ).append("\n"); 
		query.append("	,	DMDT_TRF_CD" ).append("\n"); 
		query.append("	,	N1ST_CMNC_VER_SEQ" ).append("\n"); 
		query.append("	,	EFF_DT" ).append("\n"); 
		query.append("	,	EXP_DT" ).append("\n"); 
		query.append("	,	DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("	,	DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("	,	REP_CMDT_CD" ).append("\n"); 
		query.append("	,	FT_USE_FLG" ).append("\n"); 
		query.append("	,	ADD_DYS" ).append("\n"); 
		query.append("	,	TTL_DYS" ).append("\n"); 
		query.append("	,	XCLD_SAT_FLG" ).append("\n"); 
		query.append("	,	XCLD_SUN_FLG" ).append("\n"); 
		query.append("	,	XCLD_HOL_FLG" ).append("\n"); 
		query.append("	,	RT_USE_FLG" ).append("\n"); 
		query.append("	,	RT_CHK_FLG" ).append("\n"); 
		query.append("	,	CURR_CD" ).append("\n"); 
		query.append("	,	EXPT_TRF_RMK" ).append("\n"); 
		query.append("	,	ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("	,	ACT_CUST_SEQ" ).append("\n"); 
		query.append("	,	FNL_DEST_FLG" ).append("\n"); 
		query.append("	,	FNL_DEST_CONTI_CD" ).append("\n"); 
		query.append("	,	FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("	,	FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("	,	FNL_DEST_STE_CD" ).append("\n"); 
		query.append("	,	FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	SYSDATE" ).append("\n"); 
		query.append("	,	@[cre_ofc_cd]" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	SYSDATE" ).append("\n"); 
		query.append("	,	@[cre_ofc_cd]" ).append("\n"); 
		query.append("    ,   CMDT_FLG" ).append("\n"); 
		query.append("    ,   FT_ADJ_FLG" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF_DTL" ).append("\n"); 
		query.append("WHERE	RFA_EXPT_DAR_NO		= @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("    AND RFA_EXPT_MAPG_SEQ   = @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("    AND RFA_EXPT_VER_SEQ    = @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("    AND RFA_RQST_DTL_SEQ    = @[rfa_rqst_dtl_seq]" ).append("\n"); 
		query.append("    AND CVRG_CMB_SEQ       <> @[cvrg_cmb_seq]" ).append("\n"); 
		query.append("	AND ROWNUM				= 1" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOAddBeforeExceptionRateAdjustmentOfHistVersionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.28
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.06.28 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOAddBeforeExceptionRateAdjustmentOfHistVersionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAR History 에서 선택한 버전의 모든 Before Booking Request 의 Detail 에 해당하는 Rate Adjustment 정보를 현재 버전으로 생성하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOAddBeforeExceptionRateAdjustmentOfHistVersionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_hist_dar_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_expt_hist_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_hist_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOAddBeforeExceptionRateAdjustmentOfHistVersionCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_RFA_EXPT_RT" ).append("\n"); 
		query.append("( 	RFA_EXPT_DAR_NO," ).append("\n"); 
		query.append("	RFA_EXPT_MAPG_SEQ," ).append("\n"); 
		query.append("	RFA_EXPT_VER_SEQ," ).append("\n"); 
		query.append("	RFA_RQST_DTL_SEQ," ).append("\n"); 
		query.append("	CVRG_CMB_SEQ," ).append("\n"); 
		query.append("	RFA_EXPT_RT_SEQ," ).append("\n"); 
		query.append("	FT_OVR_DYS," ).append("\n"); 
		query.append("	FT_UND_DYS," ).append("\n"); 
		query.append("	CNTR_20FT_RT_AMT," ).append("\n"); 
		query.append("	CNTR_40FT_RT_AMT," ).append("\n"); 
		query.append("	CNTR_HC_RT_AMT," ).append("\n"); 
		query.append("	CNTR_45FT_RT_AMT," ).append("\n"); 
		query.append("	N1ST_CMNC_VER_SEQ," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	CRE_OFC_CD," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	UPD_OFC_CD," ).append("\n"); 
		query.append("	CNTR_R9_RT_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT	@[rfa_expt_dar_no]" ).append("\n"); 
		query.append("	,	@[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("	,	@[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("	,	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	,	CVRG_CMB_SEQ" ).append("\n"); 
		query.append("	,   RFA_EXPT_RT_SEQ" ).append("\n"); 
		query.append("	,	FT_OVR_DYS" ).append("\n"); 
		query.append("	,	FT_UND_DYS" ).append("\n"); 
		query.append("	,	CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append("	,	CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append("	,	CNTR_HC_RT_AMT" ).append("\n"); 
		query.append("	,	CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append("	,	N1ST_CMNC_VER_SEQ" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("	,	@[cre_ofc_cd]" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("	,	@[cre_ofc_cd]" ).append("\n"); 
		query.append("	,	CNTR_R9_RT_AMT" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_RT" ).append("\n"); 
		query.append("WHERE	RFA_EXPT_DAR_NO		= @[rfa_expt_hist_dar_no]" ).append("\n"); 
		query.append("	AND	RFA_EXPT_MAPG_SEQ	= @[rfa_expt_hist_mapg_seq]" ).append("\n"); 
		query.append("	AND RFA_EXPT_VER_SEQ	= @[rfa_expt_hist_ver_seq]" ).append("\n"); 

	}
}
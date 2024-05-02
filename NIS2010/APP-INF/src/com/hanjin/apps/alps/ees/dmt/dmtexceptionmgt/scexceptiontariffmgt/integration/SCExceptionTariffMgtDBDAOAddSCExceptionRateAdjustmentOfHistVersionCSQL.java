/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOAddSCExceptionRateAdjustmentOfHistVersionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.28
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.06.28 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOAddSCExceptionRateAdjustmentOfHistVersionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception Tariff History 에서 선택한 버전의 모든 S/C Exception Tariff Rate Adjustment정보를 현재 버전으로 생성하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOAddSCExceptionRateAdjustmentOfHistVersionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hist_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_hist_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOAddSCExceptionRateAdjustmentOfHistVersionCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_SC_EXPT_RT_ADJ" ).append("\n"); 
		query.append("(      PROP_NO" ).append("\n"); 
		query.append("     , SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("     , SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("     , RT_SEQ" ).append("\n"); 
		query.append("     , FT_FM_DYS" ).append("\n"); 
		query.append("     , FT_TO_DYS" ).append("\n"); 
		query.append("     , CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append("     , CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append("     , CNTR_HC_RT_AMT" ).append("\n"); 
		query.append("     , CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("	 , CNTR_R9_RT_AMT     " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT	@[prop_no]" ).append("\n"); 
		query.append("	,	@[sc_expt_ver_seq]" ).append("\n"); 
		query.append("	,	SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	,	RT_SEQ" ).append("\n"); 
		query.append("	,	FT_FM_DYS" ).append("\n"); 
		query.append("	,	FT_TO_DYS" ).append("\n"); 
		query.append("	,	CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append("	,	CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append("	,	CNTR_HC_RT_AMT" ).append("\n"); 
		query.append("	,	CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("    ,   CNTR_R9_RT_AMT " ).append("\n"); 
		query.append("FROM	DMT_SC_EXPT_RT_ADJ" ).append("\n"); 
		query.append("WHERE	PROP_NO 		= @[hist_prop_no]" ).append("\n"); 
		query.append("	AND	SC_EXPT_VER_SEQ = @[sc_expt_hist_ver_seq]" ).append("\n"); 

	}
}
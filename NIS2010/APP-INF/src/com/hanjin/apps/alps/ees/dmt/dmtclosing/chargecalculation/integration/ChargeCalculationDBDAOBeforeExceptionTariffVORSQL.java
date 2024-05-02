/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChargeCalculationDBDAOBeforeExceptionTariffVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.03.04 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOBeforeExceptionTariffVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Before Exception Tariff의 Free Time일수 및 주말, 공휴일 포함 여부를 조회한다
	  * </pre>
	  */
	public ChargeCalculationDBDAOBeforeExceptionTariffVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rfa_rqst_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOBeforeExceptionTariffVORSQL").append("\n"); 
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
		query.append("	M.RQST_OFC_CD" ).append("\n"); 
		query.append("	,(	SELECT USR_NM" ).append("\n"); 
		query.append("		FROM COM_USER" ).append("\n"); 
		query.append("		WHERE USR_ID = M.RQST_USR_ID" ).append("\n"); 
		query.append("	) RQST_USR_NM" ).append("\n"); 
		query.append("	,M.APRO_OFC_CD" ).append("\n"); 
		query.append("	,(	SELECT USR_NM" ).append("\n"); 
		query.append("		FROM COM_USER" ).append("\n"); 
		query.append("		WHERE USR_ID = M.APRO_USR_ID" ).append("\n"); 
		query.append("	) APRO_USR_NM" ).append("\n"); 
		query.append("	,M.RFA_EXPT_APRO_NO AS SC_APVL_NO" ).append("\n"); 
		query.append("	,M.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,D.ADD_DYS" ).append("\n"); 
		query.append("	,D.TTL_DYS" ).append("\n"); 
		query.append("	,D.XCLD_SAT_FLG" ).append("\n"); 
		query.append("	,D.XCLD_SUN_FLG" ).append("\n"); 
		query.append("	,D.XCLD_HOL_FLG" ).append("\n"); 
		query.append("	,D.CURR_CD" ).append("\n"); 
		query.append("	,DECODE( SUBSTR(@[cntr_tpsz_cd], 2, 1)," ).append("\n"); 
		query.append("					'2', R.CNTR_20FT_RT_AMT," ).append("\n"); 
		query.append("					'4', R.CNTR_40FT_RT_AMT," ).append("\n"); 
		query.append("					'5', R.CNTR_HC_RT_AMT," ).append("\n"); 
		query.append("					'7', R.CNTR_45FT_RT_AMT," ).append("\n"); 
		query.append("                    '8', R.CNTR_R9_RT_AMT," ).append("\n"); 
		query.append("                    '9', R.CNTR_R9_RT_AMT   ) CNTR_FT_RT_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("	,'' SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append("	,'' SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("	,'' BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF_DTL	D," ).append("\n"); 
		query.append("		DMT_RFA_EXPT_TRF		M," ).append("\n"); 
		query.append("		DMT_RFA_EXPT_RT			R" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	D.RFA_EXPT_DAR_NO		= @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("AND		D.RFA_EXPT_MAPG_SEQ		= @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("AND		D.RFA_EXPT_VER_SEQ		= @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("AND     D.RFA_RQST_DTL_SEQ		= @[rfa_rqst_dtl_seq]" ).append("\n"); 
		query.append("AND     D.RFA_EXPT_DAR_NO		= M.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND		D.RFA_EXPT_MAPG_SEQ		= M.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND     D.RFA_EXPT_VER_SEQ		= M.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND     D.RFA_EXPT_DAR_NO		= R.RFA_EXPT_DAR_NO(+)" ).append("\n"); 
		query.append("AND		D.RFA_EXPT_MAPG_SEQ		= R.RFA_EXPT_MAPG_SEQ(+)" ).append("\n"); 
		query.append("AND     D.RFA_EXPT_VER_SEQ   	= R.RFA_EXPT_VER_SEQ(+)" ).append("\n"); 
		query.append("AND     D.RFA_RQST_DTL_SEQ    	= R.RFA_RQST_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND     D.CVRG_CMB_SEQ        	= R.CVRG_CMB_SEQ(+)" ).append("\n"); 
		query.append("AND     R.RFA_EXPT_RT_SEQ(+)	= 1" ).append("\n"); 
		query.append("AND     ROWNUM                	= 1" ).append("\n"); 

	}
}
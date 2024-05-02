/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOCheckRequestChargeDeletionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOCheckRequestChargeDeletionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Deletaion Request 된 데이터 존재여부 확인.(Reject, Apporval된 데이터제외)
	  * </pre>
	  */
	public ChargeCalculationDBDAOCheckRequestChargeDeletionRSQL(){
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
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inact_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOCheckRequestChargeDeletionRSQL").append("\n"); 
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
		query.append("#if (${bydr} == 'OP')" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM  DMT_CHG_CALC A" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND	  A.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND	  A.CNTR_CYC_NO     = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND	  A.DMDT_TRF_CD     = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND	  A.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND	  A.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND   A.FM_MVMT_STS_CD = 'OP'" ).append("\n"); 
		query.append("AND   A.TO_MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("#elseif (${bydr} == 'INV')" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM  DMT_INV_MN A" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("AND A.DMDT_INV_STS_CD = 'I'" ).append("\n"); 
		query.append("#elseif (${bydr} == 'C')" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT, CHG_OFC_CD, DELT_SEQ" ).append("\n"); 
		query.append("FROM  DMT_CHG_DELT_RQST_APRO A" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND	  A.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND	  A.CNTR_CYC_NO     = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND	  A.DMDT_TRF_CD     = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND	  A.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND	  A.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND   A.DMDT_DELT_RQST_STS_CD = @[sts_cd]" ).append("\n"); 
		query.append("AND   NVL(A.INACT_RQST_NO,' ')  != NVL(@[inact_rqst_no],NVL(A.INACT_RQST_NO,' '))" ).append("\n"); 
		query.append("GROUP BY CHG_OFC_CD, DELT_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT, CHG_OFC_CD, DELT_SEQ" ).append("\n"); 
		query.append("FROM  DMT_CHG_DELT_RQST_APRO A" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND	  A.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND	  A.CNTR_CYC_NO     = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND	  A.DMDT_TRF_CD     = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND	  A.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND	  A.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND   A.DMDT_DELT_RQST_STS_CD = @[sts_cd]" ).append("\n"); 
		query.append("AND   NVL(A.INACT_RQST_NO,' ')  = NVL(@[inact_rqst_no],NVL(A.INACT_RQST_NO,' '))" ).append("\n"); 
		query.append("GROUP BY CHG_OFC_CD, DELT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChargeCalculationDBDAOCheckRequestChargeDeletionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.27 
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
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM  DMT_CHG_DELT_RQST_APRO A" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND	  A.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND	  A.CNTR_CYC_NO     = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND	  A.DMDT_TRF_CD     = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND	  A.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND	  A.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND   A.DMDT_DELT_RQST_STS_CD ='R'" ).append("\n"); 
		query.append("AND   A.DELT_SEQ = (SELECT MAX(B.DELT_SEQ) " ).append("\n"); 
		query.append("                    FROM  DMT_CHG_DELT_RQST_APRO B " ).append("\n"); 
		query.append("                    WHERE B.SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("                    AND	  B.CNTR_NO	        = @[cntr_no]" ).append("\n"); 
		query.append("                    AND	  B.CNTR_CYC_NO 	= @[cntr_cyc_no]" ).append("\n"); 
		query.append("                    AND	  B.DMDT_TRF_CD 	= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("                    AND	  B.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("                    AND	  B.CHG_SEQ		  = @[chg_seq] )" ).append("\n"); 

	}
}
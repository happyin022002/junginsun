/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAOModifyOrgChgAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.01.15 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOModifyOrgChgAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOModifyOrgChgAmtUSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOModifyOrgChgAmtUSQL(){
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
		query.append("FileName : ChargeCalculationDBDAOModifyOrgChgAmtUSQL").append("\n"); 
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
		query.append("#if (${call_flag} == 'PRECAL')" ).append("\n"); 
		query.append("UPDATE DMT_CHG_PRE_CALC C" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE DMT_CHG_CALC C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("(C.ORG_CHG_AMT ,C.SC_RFA_EXPT_AMT )" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SUM (NVL (B.ORG_CHG_AMT, 0)), SUM (NVL (B.ORG_CHG_AMT, 0)) - C.SC_RFA_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${call_flag} == 'PRECAL')" ).append("\n"); 
		query.append("FROM DMT_CHG_PRE_CALC B" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE B.SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND B.CNTR_NO 		= @[cntr_no]" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO 	= @[cntr_cyc_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'CTIC')" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD IN ('DMIF', 'DTIC')" ).append("\n"); 
		query.append("#elseif (${dmdt_trf_cd} == 'CTOC')" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD IN ('DTOC', 'DMOF')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.CHG_SEQ 		= @[chg_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE C.SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND C.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND C.CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND C.CHG_SEQ			= @[chg_seq]" ).append("\n"); 

	}
}
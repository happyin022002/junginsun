/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOCheckChargeInvoiceByDRCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.14 황효근
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

public class ChargeCalculationDBDAOCheckChargeInvoiceByDRCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Balance Charge중 Invoice Issued된 Charge가 존재하는지 체크
	  * </pre>
	  */
	public ChargeCalculationDBDAOCheckChargeInvoiceByDRCancelRSQL(){
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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOCheckChargeInvoiceByDRCancelRSQL").append("\n"); 
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
		query.append("SELECT	'Y'" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append("WHERE	EXISTS (" ).append("\n"); 
		query.append("SELECT	1" ).append("\n"); 
		query.append("FROM	DMT_CHG_CALC" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID		=	@[svr_id]" ).append("\n"); 
		query.append("AND		CNTR_NO				=	@[cntr_no]" ).append("\n"); 
		query.append("AND		CNTR_CYC_NO			=	@[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		DMDT_TRF_CD			=	@[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		DMDT_CHG_LOC_DIV_CD	=	@[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		CHG_SEQ				<>	1						/* first charge container */" ).append("\n"); 
		query.append("AND		FM_MVMT_STS_CD		=	'DR'" ).append("\n"); 
		query.append("AND		DMDT_CHG_STS_CD		=	'I'						/* Invoiced */" ).append("\n"); 
		query.append("AND		DMDT_INV_NO			IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}
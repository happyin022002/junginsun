/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOCheckChargeInvoiceByBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.30 
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

public class ChargeCalculationDBDAOCheckChargeInvoiceByBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOCheckChargeInvoiceByBookingRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOCheckChargeInvoiceByBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : ChargeCalculationDBDAOCheckChargeInvoiceByBookingRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT C.DMDT_INV_NO" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR A, DMT_CHG_CALC B, DMT_INV_MN C, DMT_INV_DTL D" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("  AND A.CNTR_NO         = B.CNTR_NO" ).append("\n"); 
		query.append("  AND A.CNTR_CYC_NO     = B.CNTR_CYC_NO " ).append("\n"); 
		query.append("  AND B.SYS_AREA_GRP_ID = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("  AND B.CNTR_NO         = D.CNTR_NO" ).append("\n"); 
		query.append("  AND B.CNTR_CYC_NO     = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("  AND B.DMDT_TRF_CD     = D.DMDT_TRF_CD" ).append("\n"); 
		query.append("  AND B.DMDT_CHG_LOC_DIV_CD = D.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("  AND B.CHG_SEQ         = D.CHG_SEQ" ).append("\n"); 
		query.append("  AND C.DMDT_INV_NO     = D.DMDT_INV_NO" ).append("\n"); 
		query.append("  AND C.CRE_OFC_CD      = D.CRE_OFC_CD" ).append("\n"); 
		query.append("  AND B.DMDT_CHG_STS_CD = 'I' " ).append("\n"); 
		query.append("  AND C.DMDT_INV_STS_CD = 'I'" ).append("\n"); 
		query.append("  AND A.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("  AND B.DMDT_TRF_CD     = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("#if (${batch_cntr} != '')" ).append("\n"); 
		query.append("  AND A.CNTR_NO LIKE @[batch_cntr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchExistsInvoiceChargeAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchExistsInvoiceChargeAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchExistsInvoiceChargeAmountRSQL
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchExistsInvoiceChargeAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchExistsInvoiceChargeAmountRSQL").append("\n"); 
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
		query.append("select  case when count(1) = 0 then 'N' else 'Y' end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  DMT_INV_MN    T1" ).append("\n"); 
		query.append("       ,DMT_INV_DTL   T2" ).append("\n"); 
		query.append("	   ,DMT_CHG_CALC  T3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" where  T1.DMDT_INV_NO         = @[dmdt_inv_no]" ).append("\n"); 
		query.append("   and  T1.CRE_OFC_CD          = @[cre_ofc_cd]" ).append("\n"); 
		query.append("   and  T1.DMDT_INV_NO         = T2.DMDT_INV_NO" ).append("\n"); 
		query.append("   and  T1.CRE_OFC_CD          = T2.CRE_OFC_CD" ).append("\n"); 
		query.append("   and  T2.SYS_AREA_GRP_ID     = T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  T2.CNTR_NO             = T3.CNTR_NO" ).append("\n"); 
		query.append("   and  T2.CNTR_CYC_NO		   = T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  T2.DMDT_TRF_CD		   = T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("   and  T2.DMDT_CHG_LOC_DIV_CD = T3.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   and  T2.CHG_SEQ 			   = T3.CHG_SEQ" ).append("\n"); 
		query.append("   and  T3.DMDT_CHG_STS_CD     in ('C', 'F')" ).append("\n"); 

	}
}
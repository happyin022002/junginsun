/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchExistsVirtualInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.10 
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

public class ChargeAmountDiscountMgtDBDAOSearchExistsVirtualInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchExistsVirtualInvoiceRSQL
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchExistsVirtualInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchExistsVirtualInvoiceRSQL").append("\n"); 
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
		query.append("select  case when count(1) > 0 then 'Y' else 'N' end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  DMT_AFT_BKG_ADJ_RQST      T1" ).append("\n"); 
		query.append("       ,DMT_AFT_BKG_ADJ_RQST_DTL  T2" ).append("\n"); 
		query.append("       ,DMT_AFT_BKG_CNTR		  T3" ).append("\n"); 
		query.append("       ,DMT_INV_MN                T4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" where  T1.AFT_EXPT_DAR_NO    = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("   and  T1.AFT_EXPT_DAR_NO    = T2.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   and  T2.AFT_EXPT_DAR_NO    = T3.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("   and  T2.AFT_EXPT_ADJ_SEQ   = T3.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("   and  T3.SYS_AREA_GRP_ID    IN ( 'KOR', 'USA', 'CHN' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   and  T2.DMDT_TRF_CD        = T4.DMDT_TRF_CD" ).append("\n"); 
		query.append("   and  T2.BKG_NO             = T4.BKG_NO" ).append("\n"); 
		query.append("   and  T4.DMDT_INV_STS_CD    = 'X'" ).append("\n"); 
		query.append("   and  T4.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 

	}
}
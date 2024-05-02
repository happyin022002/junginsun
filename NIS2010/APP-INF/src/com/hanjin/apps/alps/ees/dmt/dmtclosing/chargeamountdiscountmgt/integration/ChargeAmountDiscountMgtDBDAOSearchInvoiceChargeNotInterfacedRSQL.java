/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchInvoiceChargeNotInterfacedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.03 
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

public class ChargeAmountDiscountMgtDBDAOSearchInvoiceChargeNotInterfacedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchInvoiceChargeNotInterfacedRSQL
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchInvoiceChargeNotInterfacedRSQL(){
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
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchInvoiceChargeNotInterfacedRSQL").append("\n"); 
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
		query.append("select  T5.DMDT_INV_NO" ).append("\n"); 
		query.append("       ,T5.CRE_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  DMT_AFT_BKG_ADJ_RQST        T1" ).append("\n"); 
		query.append("       ,DMT_AFT_BKG_ADJ_RQST_DTL    T2" ).append("\n"); 
		query.append("       ,DMT_AFT_BKG_CNTR            T3" ).append("\n"); 
		query.append("       ,DMT_CHG_CALC                T4" ).append("\n"); 
		query.append("       ,DMT_INV_MN                  T5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" where  T1.AFT_EXPT_DAR_NO      =  @[aft_expt_dar_no]" ).append("\n"); 
		query.append("   and  T1.AFT_EXPT_DAR_NO      =  T2.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("   and  T2.AFT_EXPT_DAR_NO      =  T3.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("   and  T2.AFT_EXPT_ADJ_SEQ     =  T3.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("   and  T3.SYS_AREA_GRP_ID		IN ( 'KOR', 'USA', 'CHN' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  ( T2.EACH_CNTR_FLG        = 'N' OR NVL(T3.CNTR_CHG_DC_AMT,0) != 0 OR NVL(T3.CNTR_CHG_DC_RTO,0) != 0 )" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("   and  T3.SYS_AREA_GRP_ID      =  T4.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  T3.CNTR_NO              =  T4.CNTR_NO" ).append("\n"); 
		query.append("   and  T3.CNTR_CYC_NO          =  T4.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  T3.DMDT_TRF_CD          =  T4.DMDT_TRF_CD" ).append("\n"); 
		query.append("   and  T3.DMDT_CHG_LOC_DIV_CD  =  T4.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   and  T3.CHG_SEQ              =  T4.CHG_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   and  T4.DMDT_INV_NO          =  T5.DMDT_INV_NO" ).append("\n"); 
		query.append("   and  T5.DMDT_INV_STS_CD      =  'I'" ).append("\n"); 
		query.append("   and  T5.DMDT_AR_IF_CD        <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("group by T5.DMDT_INV_NO" ).append("\n"); 
		query.append("        ,T5.CRE_OFC_CD" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOARInvoiceChargeCorrectionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.29 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOARInvoiceChargeCorrectionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOARInvoiceChargeCorrectionVORSQL(){
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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOARInvoiceChargeCorrectionVORSQL").append("\n"); 
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
		query.append("SELECT B.CHG_CD," ).append("\n"); 
		query.append("B.MNL_FLG," ).append("\n"); 
		query.append("B.RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("DECODE (C.DP_PRCS_KNT, '0', TRIM(TO_CHAR(ROUND(B.TRF_RT_AMT, C.DP_PRCS_KNT), '999,999,999,999,999,990')), '1', TRIM(TO_CHAR(ROUND(B.TRF_RT_AMT, C.DP_PRCS_KNT), '999,999,999,999,999,990.9')), '2', TRIM(TO_CHAR(ROUND(B.TRF_RT_AMT, C.DP_PRCS_KNT), '999,999,999,999,999,990.99')), '3', TRIM(TO_CHAR(ROUND(B.TRF_RT_AMT, C.DP_PRCS_KNT), '999,999,999,999,999,990.999'))) TRF_RT_AMT," ).append("\n"); 
		query.append("B.PER_TP_CD," ).append("\n"); 
		query.append("B.CURR_CD," ).append("\n"); 
		query.append("DECODE (C.DP_PRCS_KNT, '0', TRIM(TO_CHAR(ROUND(B.CHG_AMT, C.DP_PRCS_KNT), '999,999,999,999,999,990')), '1', TRIM(TO_CHAR(ROUND(B.CHG_AMT, C.DP_PRCS_KNT), '999,999,999,999,999,990.9')), '2', TRIM(TO_CHAR(ROUND(B.CHG_AMT, C.DP_PRCS_KNT), '999,999,999,999,999,990.99')), '3', TRIM(TO_CHAR(ROUND(B.CHG_AMT, C.DP_PRCS_KNT), '999,999,999,999,999,990.999'))) CHG_AMT," ).append("\n"); 
		query.append("B.TVA_FLG," ).append("\n"); 
		query.append("B.CHG_RMK," ).append("\n"); 
		query.append("B.INV_XCH_RT," ).append("\n"); 
		query.append("DECODE (D.DP_PRCS_KNT, '0', TRIM(TO_CHAR(ROUND(B.CHG_AMT*B.INV_XCH_RT, D.DP_PRCS_KNT), '999,999,999,999,999,990')), '1', TRIM(TO_CHAR(ROUND(B.CHG_AMT*B.INV_XCH_RT, D.DP_PRCS_KNT), '999,999,999,999,999,990.9')), '2', TRIM(TO_CHAR(ROUND(B.CHG_AMT*B.INV_XCH_RT, D.DP_PRCS_KNT), '999,999,999,999,999,990.99')), '3', TRIM(TO_CHAR(ROUND(B.CHG_AMT*B.INV_XCH_RT, D.DP_PRCS_KNT), '999,999,999,999,999,990.999'))) TOTAL_AMT" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("INV_AR_CHG B," ).append("\n"); 
		query.append("MDM_CURRENCY C," ).append("\n"); 
		query.append("MDM_CURRENCY D" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND C.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND D.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("#if(${bl_src_no})" ).append("\n"); 
		query.append("AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bkg_no})" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ar_ofc_cd})" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.CHG_CD, B.MNL_FLG, B.RAT_AS_CNTR_QTY, B.PER_TP_CD, B.CURR_CD" ).append("\n"); 

	}
}
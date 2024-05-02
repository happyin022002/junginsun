/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT MN.INV_NO," ).append("\n"); 
		query.append("       MN.INV_REF_NO," ).append("\n"); 
		query.append("       MN.ISS_DT," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("       MN.VSL_CD||MN.SKD_VOY_NO||MN.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       MN.POL_CD," ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.IO_BND_CD," ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       CSUM.INV_TTL_LOCL_AMT," ).append("\n"); 
		query.append("	   MN.INV_CUST_CNT_CD||'-'||LPAD(MN.INV_CUST_SEQ, 6, '0') INV_CUST_CD" ).append("\n"); 
		query.append("  FROM INV_AR_MN      MN," ).append("\n"); 
		query.append("	   (SELECT INV_NO, NVL(SUM(CURR_LOCL_AMT),0) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("         FROM ( SELECT MN.INV_NO," ).append("\n"); 
		query.append("                       ROUND(SUM(CHG.CHG_AMT) * CHG.INV_XCH_RT, CUR.DP_PRCS_KNT ) CURR_LOCL_AMT" ).append("\n"); 
		query.append("                  FROM INV_AR_CHG     CHG," ).append("\n"); 
		query.append("                       INV_AR_MN      MN," ).append("\n"); 
		query.append("                       MDM_CURRENCY   CUR" ).append("\n"); 
		query.append("                 WHERE CHG.AR_IF_NO     = MN.AR_IF_NO" ).append("\n"); 
		query.append("                   AND MN.AR_OFC_CD       = @[ofc_cd]" ).append("\n"); 
		query.append("                   AND MN.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("                   AND MN.ACT_CUST_CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("                   AND MN.ACT_CUST_SEQ = @[cust_cd]" ).append("\n"); 
		query.append("                   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                   AND NVL(MN.INV_ISS_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("				   AND NVL(MN.INV_CLR_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                   AND CUR.CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("                 GROUP BY MN.INV_NO, CHG.CURR_CD, CHG.INV_XCH_RT, CUR.DP_PRCS_KNT)" ).append("\n"); 
		query.append("          GROUP BY INV_NO ) CSUM " ).append("\n"); 
		query.append(" WHERE MN.INV_NO = CSUM.INV_NO" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD     = @[ofc_cd]" ).append("\n"); 
		query.append("   AND MN.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("   AND MN.ACT_CUST_CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("   AND MN.ACT_CUST_SEQ = @[cust_cd]" ).append("\n"); 
		query.append("   AND MN.REV_TP_CD || MN.REV_SRC_CD <> 'MDF'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_ISS_FLG,'N') = 'Y' " ).append("\n"); 
		query.append("   AND NVL(MN.INV_CLR_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   --AND NVL(MN.INV_SPLIT_CD,'N') NOT IN ('M','X') 2010-01-18 이상희 과장" ).append("\n"); 
		query.append("   AND MN.INV_NO != 'SYS CLEAR'" ).append("\n"); 
		query.append(" ORDER BY MN.INV_NO" ).append("\n"); 

	}
}
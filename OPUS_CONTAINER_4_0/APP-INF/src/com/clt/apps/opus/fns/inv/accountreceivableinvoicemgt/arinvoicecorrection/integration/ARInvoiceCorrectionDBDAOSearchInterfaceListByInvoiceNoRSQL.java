/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchInterfaceListByInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchInterfaceListByInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchInterfaceListByInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchInterfaceListByInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT MN.AR_IF_NO IF_NO," ).append("\n"); 
		query.append("       (SELECT MAX(A.AR_IF_NO) " ).append("\n"); 
		query.append("          FROM INV_AR_MN A," ).append("\n"); 
		query.append("               INV_AR_CHG B," ).append("\n"); 
		query.append("               INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("         WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("           AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("           AND B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("           AND A.OTS_PAY_CD IS NULL AND A.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("           AND C.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("           AND A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND A.REV_TP_CD <> 'M' " ).append("\n"); 
		query.append("           AND NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("           --AND NVL(A.INV_SPLIT_CD,'N') NOT IN ('M','X') 2010-01-18 이상희 과장" ).append("\n"); 
		query.append("         GROUP BY A.BL_SRC_NO) MAX_IF_NO," ).append("\n"); 
		query.append("	   (SELECT MIN(A.AR_IF_NO) " ).append("\n"); 
		query.append("          FROM INV_AR_MN A," ).append("\n"); 
		query.append("               INV_AR_CHG B," ).append("\n"); 
		query.append("               INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("         WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("           AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("           AND B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("           AND A.OTS_PAY_CD IS NULL AND A.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("           AND C.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("           AND A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("         ) M_IF_NO" ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_CHG CHG," ).append("\n"); 
		query.append("       INV_AR_ISS_DTL DTL" ).append("\n"); 
		query.append(" WHERE MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("   AND CHG.AR_IF_NO = DTL.AR_IF_NO" ).append("\n"); 
		query.append("   AND CHG.CHG_SEQ = DTL.CHG_SEQ" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND DTL.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   --AND MN.REV_TP_CD <> 'M'  2009-12-02 김현화 수석 " ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   --AND NVL(MN.INV_SPLIT_CD,'N') NOT IN ('M','X') 2010-01-18 이상희 과장" ).append("\n"); 
		query.append(" ORDER BY MN.AR_IF_NO DESC" ).append("\n"); 

	}
}
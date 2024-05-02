/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchInvoiceEdiCntrMfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchInvoiceEdiCntrMfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchInvoiceEdiCntrMf
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchInvoiceEdiCntrMfRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchInvoiceEdiCntrMfRSQL").append("\n"); 
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
		query.append("SELECT '{CM_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CMD_CD:' || 'TEST' ||CHR(10) " ).append("\n"); 
		query.append("       || 'CMD_DESC:' || 'TEST123' ||CHR(10) " ).append("\n"); 
		query.append("       || '{PKG_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CM_PKG_LVL:' ||'1'|| CHR(10) " ).append("\n"); 
		query.append("       || 'CM_PKG_QTY:' || PCK_QTY || CHR(10) " ).append("\n"); 
		query.append("       || 'CM_PKG_UNIT:' || PCK_TP_CD || CHR(10)" ).append("\n"); 
		query.append("       || 'CM_PKG_UNIT_DESC:' || (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = BC.PCK_TP_CD)|| CHR(10) " ).append("\n"); 
		query.append("       || '}PKG_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{MEA_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CM_MEA_TP_CD:' || 'GVOL'|| CHR(10)" ).append("\n"); 
		query.append("       || 'CM_MEA_UNIT:' ||MEAS_UT_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CM_MEA_QTY:' || MEAS_QTY||CHR(10)    " ).append("\n"); 
		query.append("       || '}MEA_INFO' || CHR(10)" ).append("\n"); 
		query.append("       || '}CM_INFO' || CHR(10)" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC BC" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}
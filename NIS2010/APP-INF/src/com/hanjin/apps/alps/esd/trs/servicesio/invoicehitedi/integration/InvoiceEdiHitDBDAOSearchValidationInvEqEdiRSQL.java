/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSearchValidationInvEqEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.14 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceEdiHitDBDAOSearchValidationInvEqEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_INV_EDI_RCV_EQ Validation check
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSearchValidationInvEqEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSearchValidationInvEqEdiRSQL").append("\n"); 
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
		query.append("SELECT INV_EDI_RCV_SEQ" ).append("\n"); 
		query.append("      ,INV_EDI_RCV_SUB_SEQ" ).append("\n"); 
		query.append("      ,NVL(SUBSTR(INV_NO_CHK1||INV_NO_CHK2||SO_NO_CHK||WO_NO_CHK||CGO_TP_CHK||EQ_NO_CHK,2),'Y') VAL_CHK" ).append("\n"); 
		query.append("   FROM ( SELECT A.INV_EDI_RCV_SEQ" ).append("\n"); 
		query.append("                ,A.INV_EDI_RCV_SUB_SEQ" ).append("\n"); 
		query.append("                ,CASE WHEN A.INV_NO IS NULL THEN ',INVALID INVOICE NUMBER' ELSE '' END AS INV_NO_CHK1" ).append("\n"); 
		query.append("                ,CASE WHEN B.INV_NO IS NOT NULL THEN ',S/O('||A.TRSP_SO_OFC_CTY_CD || A.TRSP_SO_SEQ ||') INVOICE NUMBER DUPLICATION' ELSE '' END AS INV_NO_CHK2" ).append("\n"); 
		query.append("                ,CASE WHEN A.TRSP_SO_OFC_CTY_CD || A.TRSP_SO_SEQ <> B.TRSP_SO_OFC_CTY_CD || B.TRSP_SO_SEQ THEN ',S/O('||A.TRSP_SO_OFC_CTY_CD || A.TRSP_SO_SEQ ||') NUMBER MISMATCH' ELSE '' END AS SO_NO_CHK" ).append("\n"); 
		query.append("                ,CASE WHEN A.TRSP_WO_OFC_CTY_CD || A.TRSP_WO_SEQ <> B.TRSP_WO_OFC_CTY_CD || B.TRSP_WO_SEQ THEN ',W/O('||A.TRSP_WO_OFC_CTY_CD || A.TRSP_WO_SEQ ||') NUMBER MISMATCH' ELSE '' END AS WO_NO_CHK" ).append("\n"); 
		query.append("                ,CASE WHEN A.CGO_TP_CD <> B.CGO_TP_CD THEN ',CGO TYPE MISMATCH' ELSE '' END AS CGO_TP_CHK" ).append("\n"); 
		query.append("                ,CASE WHEN A.EQ_NO <> B.EQ_NO THEN ',EQ NUMBER MISMATCH' ELSE '' END AS EQ_NO_CHK" ).append("\n"); 
		query.append("            FROM TRS_INV_EDI_RCV_EQ A" ).append("\n"); 
		query.append("                ,TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("             AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("             AND A.INV_EDI_RCV_SEQ = @[inv_edi_rcv_seq]" ).append("\n"); 
		query.append("             AND 'N' = B.DELT_FLG(+)" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceEdiPdfFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.16
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.08.16 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAOSearchInvoiceEdiPdfFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HIT INVOICE EDI  수신 PDF 파일 정보 조회
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAOSearchInvoiceEdiPdfFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration ").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceEdiPdfFileRSQL").append("\n"); 
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
		query.append("SELECT A.INV_EDI_RCV_SEQ" ).append("\n"); 
		query.append("      ,B.INV_EDI_RCV_FILE_SEQ" ).append("\n"); 
		query.append("      ,B.INV_NO" ).append("\n"); 
		query.append("      ,B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("      ,B.FILE_NM " ).append("\n"); 
		query.append("      ,B.FILE_SAV_ID SAV_FILE_NM" ).append("\n"); 
		query.append("      ,C.FILE_PATH_URL SAV_PATH_NM" ).append("\n"); 
		query.append("      ,C.FILE_SZ_CAPA FILE_SIZE" ).append("\n"); 
		query.append("      ,B.CRE_DT" ).append("\n"); 
		query.append("  FROM TRS_INV_EDI_RCV A" ).append("\n"); 
		query.append("      ,TRS_INV_EDI_RCV_FILE B" ).append("\n"); 
		query.append("      ,COM_UPLD_FILE C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("   AND A.INV_VNDR_SEQ = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("   AND B.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("   AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("   AND A.INV_VNDR_SEQ = @[inv_vndr_seq]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append(" ORDER BY A.INV_EDI_RCV_SEQ DESC" ).append("\n"); 
		query.append("         ,B.INV_EDI_RCV_FILE_SEQ DESC" ).append("\n"); 

	}
}
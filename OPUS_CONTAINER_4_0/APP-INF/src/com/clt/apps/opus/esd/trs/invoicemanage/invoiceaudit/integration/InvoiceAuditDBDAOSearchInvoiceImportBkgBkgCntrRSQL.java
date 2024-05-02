/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking number로 컨테이너를 조회한다
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrRSQL(){
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
		params.put("org_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrRSQL").append("\n"); 
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
		query.append("-- NOT SPLIT" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.CNTR_NO      AS CNTR_NO" ).append("\n"); 
		query.append(",   B.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING      A" ).append("\n"); 
		query.append(",   BKG_CONTAINER    B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(A.BKG_NO = @[bkg_no] OR A.BKG_NO = @[org_bkg_no] )" ).append("\n"); 
		query.append("AND A.BKG_NO       = B.BKG_NO         (+)" ).append("\n"); 
		query.append("AND 'X'           <> A.BKG_STS_CD     (+)" ).append("\n"); 
		query.append("AND B.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("UNION -- IF SPLIT CASE, MAIN BKG" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.CNTR_NO      AS CNTR_NO" ).append("\n"); 
		query.append(",   B.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING      A" ).append("\n"); 
		query.append(",   BKG_CONTAINER    B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(A.FM_BKG_NO = @[bkg_no] OR A.FM_BKG_NO = @[org_bkg_no] )" ).append("\n"); 
		query.append("AND A.BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append("AND A.BKG_NO        = B.BKG_NO         (+)" ).append("\n"); 
		query.append("AND 'X'<> A.BKG_STS_CD     (+)" ).append("\n"); 
		query.append("AND B.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("UNION -- IF SPLIT CASE, SPLIT BKG" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.CNTR_NO      AS CNTR_NO" ).append("\n"); 
		query.append(",   B.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING      A" ).append("\n"); 
		query.append(",   BKG_BOOKING      C" ).append("\n"); 
		query.append(",   BKG_CONTAINER    B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(C.BKG_NO = @[bkg_no] OR C.BKG_NO = @[org_bkg_no] )" ).append("\n"); 
		query.append("AND C.BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append("AND C.FM_BKG_NO     = A.FM_BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO        = B.BKG_NO         (+)" ).append("\n"); 
		query.append("AND 'X'<> A.BKG_STS_CD     (+)" ).append("\n"); 
		query.append("AND B.CNTR_NO = @[eq_no]" ).append("\n"); 

	}
}
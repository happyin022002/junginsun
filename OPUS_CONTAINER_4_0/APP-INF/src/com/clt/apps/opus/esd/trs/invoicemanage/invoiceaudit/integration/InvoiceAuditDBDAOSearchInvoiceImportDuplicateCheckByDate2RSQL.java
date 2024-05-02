/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.23 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O Creation 날짜 기준으로 Invoice 중복여부를 조회
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL").append("\n"); 
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
		query.append("SELECT                                                       " ).append("\n"); 
		query.append("      A.TRSP_SO_OFC_CTY_CD                                    " ).append("\n"); 
		query.append(" ,    A.TRSP_SO_SEQ                                           " ).append("\n"); 
		query.append(" ,    TO_CHAR(A.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT         " ).append("\n"); 
		query.append(" ,    A.FM_NOD_CD                                             " ).append("\n"); 
		query.append(" ,    A.TO_NOD_CD                                             " ).append("\n"); 
		query.append(" ,    A.TRSP_COST_DTL_MOD_CD                                  " ).append("\n"); 
		query.append(" ,    A.TRSP_CRR_MOD_CD                                       " ).append("\n"); 
		query.append(" FROM TRS_TRSP_SVC_ORD     A                                  " ).append("\n"); 
		query.append(" WHERE A.EQ_NO   = @[eq_no]                " ).append("\n"); 
		query.append(" AND  A.FM_NOD_CD = @[fm_nod_cd]                              " ).append("\n"); 
		query.append(" AND  A.TO_NOD_CD = @[to_nod_cd]" ).append("\n"); 
		query.append(" AND  NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append(" AND  NVL(A.TRSP_FRST_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append(" AND  A.REF_ID = @[ref_id]" ).append("\n"); 
		query.append(" AND  A.TRSP_SO_TP_CD = 'M'" ).append("\n"); 

	}
}
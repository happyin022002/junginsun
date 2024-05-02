/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchKORIssuedBLListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.03.12 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchKORIssuedBLListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KOR Invoice Main, Invoice Main 테이블에서 select
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchKORIssuedBLListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchKORIssuedBLListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.BL_SRC_NO," ).append("\n"); 
		query.append("  B.BKG_NO," ).append("\n"); 
		query.append("  B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("  B.SAIL_ARR_DT," ).append("\n"); 
		query.append("  DECODE(B.IO_BND_CD, 'O', 'O/B', 'I', 'I/B') IO_BND_CD," ).append("\n"); 
		query.append("  DECODE(B.IO_BND_CD, 'O', B.POL_CD, 'I', B.POD_CD) PORT," ).append("\n"); 
		query.append("  B.POL_CD," ).append("\n"); 
		query.append("  B.POD_CD," ).append("\n"); 
		query.append("  C.USD_XCH_RT" ).append("\n"); 
		query.append("FROM INV_AR_KR_ISS A," ).append("\n"); 
		query.append("  INV_AR_KR_ISS_CHG B," ).append("\n"); 
		query.append("  INV_AR_MN C" ).append("\n"); 
		query.append("WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("  AND A.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("  AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("  AND A.INV_SEQ = (" ).append("\n"); 
		query.append("    SELECT MAX(INV_SEQ)" ).append("\n"); 
		query.append("    FROM INV_AR_KR_ISS" ).append("\n"); 
		query.append("    WHERE INV_NO = @[inv_no])" ).append("\n"); 
		query.append("  AND C.AR_IF_NO = (" ).append("\n"); 
		query.append("    SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE BL_SRC_NO = B.BL_SRC_NO" ).append("\n"); 
		query.append("      AND AR_OFC_CD IN (" ).append("\n"); 
		query.append("            SELECT DISTINCT AR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            --WHERE AR_HD_QTR_OFC_CD = 'SHAAS'" ).append("\n"); 
		query.append("              WHERE (LOC_CD LIKE 'KR%' OR LOC_CD LIKE 'HQ%')" ).append("\n"); 
		query.append("              AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("              AND AR_OFC_CD IS NOT NULL))" ).append("\n"); 

	}
}
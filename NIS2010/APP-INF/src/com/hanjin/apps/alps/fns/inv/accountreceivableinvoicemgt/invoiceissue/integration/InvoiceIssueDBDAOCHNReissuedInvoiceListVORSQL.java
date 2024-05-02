/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOCHNReissuedInvoiceListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.12.29 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Han Dong Hoon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOCHNReissuedInvoiceListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public InvoiceIssueDBDAOCHNReissuedInvoiceListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOCHNReissuedInvoiceListVORSQL").append("\n"); 
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
		query.append("SELECT	A.INV_NO" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(",A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",A.VVD" ).append("\n"); 
		query.append(",A.IO_BND_CD" ).append("\n"); 
		query.append(",A.POR_CD" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",A.DEL_CD" ).append("\n"); 
		query.append(",A.SAIL_ARR_DT" ).append("\n"); 
		query.append(",A.ISS_DT" ).append("\n"); 
		query.append(",A.AR_OFC_CD" ).append("\n"); 
		query.append(",A.INV_XCH_RT" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  C.INV_NO" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(",A.ACT_CUST_CNT_CD||LPAD(ACT_CUST_SEQ,6,'0') ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",A.VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",DECODE(A.IO_BND_CD,'I','I/B','O/B') IO_BND_CD" ).append("\n"); 
		query.append(",A.POR_CD" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",A.DEL_CD" ).append("\n"); 
		query.append(",A.SAIL_ARR_DT" ).append("\n"); 
		query.append(",D.ISS_DT" ).append("\n"); 
		query.append(",A.AR_OFC_CD" ).append("\n"); 
		query.append(",B.INV_XCH_RT" ).append("\n"); 
		query.append("#if (${cur_cd} == 'USD')" ).append("\n"); 
		query.append(",@[cur_cd] CURR_CD" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',B.CHG_AMT,'CNY',DECODE(A.USD_XCH_RT,0,0,B.CHG_AMT/A.USD_XCH_RT),DECODE(A.USD_XCH_RT,0,0,(B.CHG_AMT*INV_XCH_RT)/A.USD_XCH_RT))) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("#elseif (${cur_cd} == 'CNY')" ).append("\n"); 
		query.append(",@[cur_cd] CURR_CD" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',B.CHG_AMT*A.USD_XCH_RT,'CNY',B.CHG_AMT,B.CHG_AMT*INV_XCH_RT)) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE(B.CURR_CD,'USD','USD','CNY') CURR_CD" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',B.CHG_AMT,'CNY',DECODE(A.USD_XCH_RT,0,0,B.CHG_AMT/A.USD_XCH_RT),DECODE(A.USD_XCH_RT,0,0,(B.CHG_AMT*INV_XCH_RT)/A.USD_XCH_RT))) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM    INV_AR_MN A, INV_AR_CHG B" ).append("\n"); 
		query.append(",INV_AR_ISS_DTL C, INV_AR_ISS D" ).append("\n"); 
		query.append("WHERE   A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND     B.AR_IF_NO = C.AR_IF_NO(+)" ).append("\n"); 
		query.append("AND     B.CHG_SEQ = C.CHG_SEQ(+)" ).append("\n"); 
		query.append("AND     C.INV_NO = D.INV_NO" ).append("\n"); 
		query.append("AND     D.INV_SEQ = (SELECT MAX(K.INV_SEQ) FROM INV_AR_ISS K" ).append("\n"); 
		query.append("WHERE   K.INV_NO = D.INV_NO)" ).append("\n"); 
		query.append("AND     NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("AND     B.INV_ISS_FLG = 'Y'" ).append("\n"); 
		query.append("AND     A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("GROUP BY C.INV_NO" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(",A.ACT_CUST_CNT_CD||LPAD(ACT_CUST_SEQ,6,'0')" ).append("\n"); 
		query.append(",A.VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 
		query.append(",DECODE(A.IO_BND_CD,'I','I/B','O/B')" ).append("\n"); 
		query.append(",A.POR_CD" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",A.DEL_CD" ).append("\n"); 
		query.append(",A.SAIL_ARR_DT" ).append("\n"); 
		query.append(",D.ISS_DT" ).append("\n"); 
		query.append(",A.AR_OFC_CD" ).append("\n"); 
		query.append(",B.INV_XCH_RT" ).append("\n"); 
		query.append("#if (${cur_cd} != 'USD' and ${cur_cd} != 'CNY')" ).append("\n"); 
		query.append(",B.CURR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")A" ).append("\n"); 
		query.append("ORDER BY A.INV_NO" ).append("\n"); 

	}
}
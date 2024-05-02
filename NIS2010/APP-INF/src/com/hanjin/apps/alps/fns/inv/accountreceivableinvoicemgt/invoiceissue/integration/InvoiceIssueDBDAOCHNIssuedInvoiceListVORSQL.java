/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOCHNIssuedInvoiceListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.12.22 한동훈
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

public class InvoiceIssueDBDAOCHNIssuedInvoiceListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public InvoiceIssueDBDAOCHNIssuedInvoiceListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : InvoiceIssueDBDAOCHNIssuedInvoiceListVORSQL").append("\n"); 
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
		query.append("SELECT	'' INV_NO" ).append("\n"); 
		query.append(",TB.BKG_NO" ).append("\n"); 
		query.append(",TB.FRT_USD" ).append("\n"); 
		query.append(",TB.EX_RATE" ).append("\n"); 
		query.append(",TB.EQV_USD" ).append("\n"); 
		query.append(",TB.CHG_USD" ).append("\n"); 
		query.append(",TB.TOT_USD" ).append("\n"); 
		query.append(",TB.AR_IF_NO" ).append("\n"); 
		query.append(",TB.BL_SRC_NO" ).append("\n"); 
		query.append(",TB.IO_BND_CD" ).append("\n"); 
		query.append(",TB.CURR_CD" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("#if (${curr_cd} == 'USD')" ).append("\n"); 
		query.append("SELECT  A.BKG_NO" ).append("\n"); 
		query.append(",SUM(A.FRT_USD) FRT_USD" ).append("\n"); 
		query.append(",A.EX_RATE" ).append("\n"); 
		query.append(",SUM(A.EQV_USD) EQV_USD" ).append("\n"); 
		query.append(",SUM(A.CHG_USD) CHG_USD" ).append("\n"); 
		query.append(",SUM(A.EQV_USD+A.CHG_USD) TOT_USD" ).append("\n"); 
		query.append(",A.AR_IF_NO" ).append("\n"); 
		query.append(",A.BL_SRC_NO" ).append("\n"); 
		query.append(",A.IO_BND_CD" ).append("\n"); 
		query.append(",'USD' CURR_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  MAX(A.BKG_NO) BKG_NO" ).append("\n"); 
		query.append(",A.BL_SRC_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',B.CHG_AMT,0)) FRT_USD" ).append("\n"); 
		query.append(",1 EX_RATE" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',B.CHG_AMT,0)) EQV_USD" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',0,'CNY',DECODE(A.USD_XCH_RT,0,0,B.CHG_AMT/A.USD_XCH_RT),DECODE(A.USD_XCH_RT,0,0,(B.CHG_AMT*INV_XCH_RT)/A.USD_XCH_RT))) CHG_USD" ).append("\n"); 
		query.append(",MAX(B.AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("FROM    INV_AR_MN A, INV_AR_CHG B" ).append("\n"); 
		query.append("WHERE   A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND     NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("AND     A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND     B.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("AND     A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND     A.AR_IF_NO = (SELECT MAX(K.AR_IF_NO) FROM INV_AR_MN K WHERE K.BL_SRC_NO = A.BL_SRC_NO AND K.AR_OFC_CD = A.AR_OFC_CD)" ).append("\n"); 
		query.append("GROUP BY A.BL_SRC_NO,A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY    A.BL_SRC_NO,A.BKG_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD,A.EX_RATE,A.AR_IF_NO" ).append("\n"); 
		query.append("#elseif (${curr_cd} == 'CNY')" ).append("\n"); 
		query.append("SELECT  A.BKG_NO" ).append("\n"); 
		query.append(",SUM(A.FRT_USD) FRT_USD" ).append("\n"); 
		query.append("--,MAX(DECODE(A.EX_RATE, 1, 0,A.EX_RATE)) EX_RATE" ).append("\n"); 
		query.append(",MAX(A.EX_RATE) EX_RATE" ).append("\n"); 
		query.append(",SUM(A.EQV_USD) EQV_USD" ).append("\n"); 
		query.append(",SUM(A.CHG_USD) CHG_USD" ).append("\n"); 
		query.append(",SUM(A.EQV_USD+A.CHG_USD) TOT_USD" ).append("\n"); 
		query.append(",A.AR_IF_NO" ).append("\n"); 
		query.append(",A.BL_SRC_NO" ).append("\n"); 
		query.append(",A.IO_BND_CD" ).append("\n"); 
		query.append(",'CNY' CURR_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  MAX(A.BKG_NO) BKG_NO" ).append("\n"); 
		query.append(",A.BL_SRC_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',B.CHG_AMT,0)) FRT_USD" ).append("\n"); 
		query.append(",MAX(A.USD_XCH_RT) EX_RATE" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',B.CHG_AMT*A.USD_XCH_RT,0)) EQV_USD" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',0,'CNY',B.CHG_AMT,B.CHG_AMT*INV_XCH_RT)) CHG_USD" ).append("\n"); 
		query.append(",MAX(B.AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("FROM    INV_AR_MN A, INV_AR_CHG B" ).append("\n"); 
		query.append("WHERE   A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND     NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("AND     A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND     B.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("AND     A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND     A.AR_IF_NO = (SELECT MAX(K.AR_IF_NO) FROM INV_AR_MN K WHERE K.BL_SRC_NO = A.BL_SRC_NO AND K.AR_OFC_CD = A.AR_OFC_CD)" ).append("\n"); 
		query.append("GROUP BY A.BL_SRC_NO,A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY    A.BL_SRC_NO,A.BKG_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD,A.EX_RATE,A.AR_IF_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT  A.BKG_NO" ).append("\n"); 
		query.append(",DECODE(A.CURR_CD,'USD','1','2') CURR_GB" ).append("\n"); 
		query.append(",SUM(A.FRT_USD) FRT_USD" ).append("\n"); 
		query.append(",MIN(DECODE(A.CURR_CD,'USD',1,A.EX_RATE)) EX_RATE" ).append("\n"); 
		query.append(",SUM(A.EQV_USD) EQV_USD" ).append("\n"); 
		query.append(",SUM(A.CHG_USD) CHG_USD" ).append("\n"); 
		query.append(",SUM(A.EQV_USD+A.CHG_USD) TOT_USD" ).append("\n"); 
		query.append(",A.AR_IF_NO" ).append("\n"); 
		query.append(",A.BL_SRC_NO" ).append("\n"); 
		query.append(",A.IO_BND_CD" ).append("\n"); 
		query.append(",DECODE(A.CURR_CD,'USD','USD','CNY') CURR_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  MAX(A.BKG_NO) BKG_NO" ).append("\n"); 
		query.append(",A.BL_SRC_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD" ).append("\n"); 
		query.append(",B.CURR_CD" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',B.CHG_AMT,0)) FRT_USD" ).append("\n"); 
		query.append(",DECODE(B.CURR_CD,'USD',1,A.USD_XCH_RT) EX_RATE" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',B.CHG_AMT,0)) EQV_USD" ).append("\n"); 
		query.append(",SUM(DECODE(B.CURR_CD,'USD',0,'CNY',DECODE(A.USD_XCH_RT,0,0,B.CHG_AMT/A.USD_XCH_RT),DECODE(A.USD_XCH_RT,0,0,(B.CHG_AMT*INV_XCH_RT)/A.USD_XCH_RT))) CHG_USD" ).append("\n"); 
		query.append(",MAX(B.AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("FROM    INV_AR_MN A, INV_AR_CHG B" ).append("\n"); 
		query.append("WHERE   A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND     NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("AND     A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND     B.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("AND     A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND     A.AR_IF_NO = (SELECT MAX(K.AR_IF_NO) FROM INV_AR_MN K WHERE K.BL_SRC_NO = A.BL_SRC_NO AND K.AR_OFC_CD = A.AR_OFC_CD)" ).append("\n"); 
		query.append("GROUP BY A.BL_SRC_NO,A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD, B.CURR_CD,A.USD_XCH_RT" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.BL_SRC_NO,A.BKG_NO,A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD, DECODE(A.CURR_CD,'USD','1','2'),DECODE(A.CURR_CD,'USD','USD','CNY'),A.AR_IF_NO" ).append("\n"); 
		query.append("ORDER BY DECODE(A.CURR_CD,'USD','1','2')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") TB" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchApPayInvDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchApPayInvDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_PAY_INV_DTL csr insert
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchApPayInvDetailRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchApPayInvDetailRSQL").append("\n"); 
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
		query.append("SELECT NVL(B.LGS_COST_CD,'000000') AS LGS_COST_CD" ).append("\n"); 
		query.append("      ,NVL(B.ACCT_CD,'000000') AS ACCT_CD" ).append("\n"); 
		query.append("      ,NVL(C.VSL_CD,'0000') VSL_CD" ).append("\n"); 
		query.append("      ,NVL(C.SKD_VOY_NO,'0000') SKD_VOY_NO" ).append("\n"); 
		query.append("      ,NVL(C.SKD_DIR_CD,'0') SKD_DIR_CD" ).append("\n"); 
		query.append("      ,NVL(C.SKD_DIR_CD,'0') REV_DIR_CD" ).append("\n"); 
		query.append("      ,SLAN_CD" ).append("\n"); 
		query.append("      ,NVL(C.VSL_CD,'0000')||NVL(C.SKD_VOY_NO,'0000')||NVL(C.SKD_DIR_CD,'0') AS ACT_VVD_CD" ).append("\n"); 
		query.append("      ,B.EQ_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,NVL(B.INV_BZC_AMT,0)-NVL(B.FUEL_SCG_AMT,0) INV_AMT" ).append("\n"); 
		query.append("      ,C.TRSP_SO_OFC_CTY_CD AS SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,C.TRSP_SO_SEQ AS SO_SEQ" ).append("\n"); 
		query.append("      ,'I' IBFLAG" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       TRS_TRSP_RAIL_INV_DTL B," ).append("\n"); 
		query.append("       TRS_TRSP_RAIL_BIL_ORD C" ).append("\n"); 
		query.append(" WHERE B.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD (+)" ).append("\n"); 
		query.append(" AND   B.TRSP_SO_SEQ = C.TRSP_SO_SEQ (+)" ).append("\n"); 
		query.append(" AND   B.INV_NO = @[inv_no] " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NVL(B.LGS_COST_CD,'000000') AS LGS_COST_CD" ).append("\n"); 
		query.append("      ,NVL(B.ACCT_CD,'000000') AS ACCT_CD" ).append("\n"); 
		query.append("      ,NVL(C.VSL_CD,'0000') VSL_CD" ).append("\n"); 
		query.append("      ,NVL(C.SKD_VOY_NO,'0000') SKD_VOY_NO" ).append("\n"); 
		query.append("      ,NVL(C.SKD_DIR_CD,'0') SKD_DIR_CD" ).append("\n"); 
		query.append("      ,NVL(C.SKD_DIR_CD,'0') REV_DIR_CD" ).append("\n"); 
		query.append("      ,C.SLAN_CD" ).append("\n"); 
		query.append("      ,NVL(C.VSL_CD,'0000')||NVL(C.SKD_VOY_NO,'0000')||NVL(C.SKD_DIR_CD,'0') AS ACT_VVD_CD" ).append("\n"); 
		query.append("      ,C.EQ_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,NVL(B.FUEL_SCG_AMT,0) INV_AMT" ).append("\n"); 
		query.append("      ,C.TRSP_SO_OFC_CTY_CD AS SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,C.TRSP_SO_SEQ AS SO_SEQ" ).append("\n"); 
		query.append("      ,'I' IBFLAG" ).append("\n"); 
		query.append("FROM		TRS_TRSP_RAIL_INV_WRK A," ).append("\n"); 
		query.append("            TRS_TRSP_RAIL_INV_DTL B, 																																																																																															" ).append("\n"); 
		query.append("            TRS_TRSP_RAIL_BIL_ORD C, 																																																																																															" ).append("\n"); 
		query.append("			TES_LGS_COST D																								" ).append("\n"); 
		query.append("WHERE   A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("AND     A.INV_VNDR_SEQ = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND     B.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD (+)" ).append("\n"); 
		query.append("AND     B.TRSP_SO_SEQ = C.TRSP_SO_SEQ (+)             																" ).append("\n"); 
		query.append("AND	    D.LGS_COST_CD = DECODE(B.CGO_TP_CD,'F','SCFURD','M','SMFURD')" ).append("\n"); 
		query.append("AND     A.INV_NO = @[inv_no]" ).append("\n"); 

	}
}
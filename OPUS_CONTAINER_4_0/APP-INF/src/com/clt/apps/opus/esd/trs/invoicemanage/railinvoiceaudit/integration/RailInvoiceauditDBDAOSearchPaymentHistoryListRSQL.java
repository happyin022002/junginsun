/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchPaymentHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.09.14 최진오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JIN O CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchPaymentHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPaymentHistoryList SELECT
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchPaymentHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration ").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchPaymentHistoryListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("PAID," ).append("\n"); 
		query.append("SUBSTR(MAX(FM_NOD_CD), 0, 5) FM_NOD_CD1," ).append("\n"); 
		query.append("SUBSTR(MAX(FM_NOD_CD), 6, 7) FM_NOD_CD2," ).append("\n"); 
		query.append("SUBSTR(MAX(TO_NOD_CD), 0, 5) TO_NOD_CD1," ).append("\n"); 
		query.append("SUBSTR(MAX(TO_NOD_CD), 6, 7) TO_NOD_CD2," ).append("\n"); 
		query.append("BKG_CGO_TP_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("VNDR_ABBR_NM," ).append("\n"); 
		query.append("RAIL_BIL_DT," ).append("\n"); 
		query.append("PAY_DT," ).append("\n"); 
		query.append("INV_CURR_CD," ).append("\n"); 
		query.append("SUM(INV_BZC_AMT) INV_AMT," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("RGST_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN W.PAY_DT IS NULL THEN 'N' ELSE 'Y' END PAID," ).append("\n"); 
		query.append("B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("S.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_ABBR_NM," ).append("\n"); 
		query.append("TO_CHAR(D.RAIL_BIL_DT, 'YYYYMMDD') RAIL_BIL_DT," ).append("\n"); 
		query.append("TO_CHAR(W.PAY_DT,'YYYYMMDD')       PAY_DT," ).append("\n"); 
		query.append("D.INV_CURR_CD," ).append("\n"); 
		query.append("D.INV_BZC_AMT," ).append("\n"); 
		query.append("D.INV_NO," ).append("\n"); 
		query.append("W.RGST_NO," ).append("\n"); 
		query.append("CASE WHEN O.RAIL_CMB_THRU_TP_CD IN('C2T' , 'C3T') THEN" ).append("\n"); 
		query.append("CASE S.SUB_RAIL_SEQ WHEN 1 THEN" ).append("\n"); 
		query.append("(SELECT FM_NOD_CD FROM TRS_TRSP_RAIL_BIL_VNDR_SET" ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    TRSP_SO_SEQ = S.TRSP_SO_SEQ AND SUB_RAIL_SEQ =1 )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN O.RAIL_CMB_THRU_TP_CD IN('C2C') THEN" ).append("\n"); 
		query.append("CASE S.SUB_RAIL_SEQ WHEN 2 THEN" ).append("\n"); 
		query.append("(SELECT FM_NOD_CD FROM TRS_TRSP_RAIL_BIL_VNDR_SET" ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    TRSP_SO_SEQ = S.TRSP_SO_SEQ AND SUB_RAIL_SEQ =1 )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE  S.FM_NOD_CD" ).append("\n"); 
		query.append("END FM_NOD_CD," ).append("\n"); 
		query.append("CASE WHEN O.RAIL_CMB_THRU_TP_CD IN('C2T','C2T') THEN" ).append("\n"); 
		query.append("CASE S.SUB_RAIL_SEQ WHEN 1 THEN" ).append("\n"); 
		query.append("(SELECT TO_NOD_CD FROM TRS_TRSP_RAIL_BIL_VNDR_SET" ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    TRSP_SO_SEQ = S.TRSP_SO_SEQ AND SUB_RAIL_SEQ =2 )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN O.RAIL_CMB_THRU_TP_CD IN('C3T') THEN" ).append("\n"); 
		query.append("CASE S.SUB_RAIL_SEQ WHEN 2 THEN" ).append("\n"); 
		query.append("(SELECT TO_NOD_CD FROM TRS_TRSP_RAIL_BIL_VNDR_SET" ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    TRSP_SO_SEQ = S.TRSP_SO_SEQ AND SUB_RAIL_SEQ =3 )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN O.RAIL_CMB_THRU_TP_CD IN('C2C') THEN" ).append("\n"); 
		query.append("CASE S.SUB_RAIL_SEQ WHEN 2 THEN" ).append("\n"); 
		query.append("(SELECT TO_NOD_CD FROM TRS_TRSP_RAIL_BIL_VNDR_SET" ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    TRSP_SO_SEQ = S.TRSP_SO_SEQ AND SUB_RAIL_SEQ =1 )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE S.TO_NOD_CD" ).append("\n"); 
		query.append("END TO_NOD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_INV_WRK      W," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_INV_DTL      D," ).append("\n"); 
		query.append("BKG_BOOKING                B," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_VNDR_SET S," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD      O," ).append("\n"); 
		query.append("MDM_VENDOR                 V" ).append("\n"); 
		query.append("WHERE D.EQ_NO              = @[eq_no]" ).append("\n"); 
		query.append("AND   W.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("AND   O.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("AND   D.INV_NO             =  W.INV_NO" ).append("\n"); 
		query.append("AND   D.INV_VNDR_SEQ       = W.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND   D.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   D.TRSP_SO_SEQ        = S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   W.WO_VNDR_SEQ        = S.PAIR_VNDR_SEQ" ).append("\n"); 
		query.append("AND   S.TRSP_SO_OFC_CTY_CD = O.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   S.TRSP_SO_SEQ        = O.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   O.BKG_NO             = B.BKG_NO" ).append("\n"); 
		query.append("AND   V.VNDR_SEQ           = S.VNDR_SEQ" ).append("\n"); 
		query.append(") GROUP BY" ).append("\n"); 
		query.append("PAID," ).append("\n"); 
		query.append("BKG_CGO_TP_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("VNDR_ABBR_NM," ).append("\n"); 
		query.append("RAIL_BIL_DT," ).append("\n"); 
		query.append("PAY_DT," ).append("\n"); 
		query.append("INV_CURR_CD," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("RGST_NO" ).append("\n"); 

	}
}